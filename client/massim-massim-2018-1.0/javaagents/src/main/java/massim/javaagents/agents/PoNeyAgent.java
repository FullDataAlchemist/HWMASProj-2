package massim.javaagents.agents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

import eis.iilang.Action;
import eis.iilang.Identifier;
import eis.iilang.Numeral;
import eis.iilang.Percept;
import massim.javaagents.MailService;
import massim.javaagents.percept.AgentPercepts;
import massim.javaagents.percept.Pair;
import massim.javaagents.percept.item;
import massim.javaagents.percept.job;
import massim.javaagents.percept.shop;
import massim.javaagents.percept.storage;
import massim.javaagents.percept.task;

/**
 * @author newda & pouria
 *
 */
public class PoNeyAgent extends Agent
{
	// +++++++++++++++++++++ Parameters Section +++++++++++++++++++++
	private AgentPercepts	AP;
	private Queue<Action>	actionQueue;
	private List<task>		jobs;
	private task			myTask;

	public PoNeyAgent(String name, MailService mailbox)
	{
		super(name, mailbox);
		this.AP = new AgentPercepts();
		this.actionQueue = new LinkedList<>();
		this.jobs = new LinkedList<>();
	}

	// +++++++++++++++++++++ Service Section +++++++++++++++++++++
	@Override
	public void handlePercept(Percept percept)
	{
	}

	@Override
	public Action step()
	{
		System.out.println("Hello ! it's PoNey Turn now :D ");
		makePerceptObjects();

		if (!actionQueue.isEmpty())
			return actionQueue.poll();

		if (getStepNumber() > 0)
		{
			// if (AP.getSelfRole().getName().equals("car"))
			// {
			// System.out.println("yaaaaay i'm a car");
			// return new Action("goto", new Identifier(AP.getShops().get(0).getShopName()));
			// }
			// else if (AP.getSelfRole().getName().equals("drone"))
			// {
			// System.out.println("yaaaaay i'm a drone");
			// return new Action("goto", new Identifier(AP.getDumps().get(0).getName()));
			// }
			// else if (AP.getSelfRole().getName().equals("motorcycle"))
			// {
			// System.out.println("yaaaaay i'm a motorcycle");
			// return new Action("goto", new Identifier(AP.getResourceNodes().get(0).getName()));
			// }
			// else
			// System.out.println("yaaaaay i'm a truck");

			getProperJob();

			if (getMyTask() != null)
			{
				switch (getMyTask().getAction())
				{
					case "buy":
						buy();
						break;
					case "carryToStorage":
						goToStorage();
						break;
				}
			}

		}
		return actionQueue.poll();
	}

	@Override
	public void handleMessage(Percept message, String sender)
	{
		// TODO have to had some messages here
		// these mesages tells me what job todo and what not to do (which ones are taken and wich ones are still open)
		// i can have a message "SOS : means some agent runs out of a fuel or energy that some one else should come and help carry items"

	}

	// +++++++++++++++++++++ Private methods +++++++++++++++++++++

	private void makePerceptObjects()
	{
		List<Percept> percepts = new Vector<>();
		percepts = this.getPercepts();

		AP.setPercepts(percepts);
		if (getStepNumber() != 0)
			AP.stepPercept();
		else
			AP.initialize();
	}

	private void getProperJob() // TODO have to iterate over given jobs from server and choose what i can do, then add those jobs to jobs
	{
		String itemName;
		int itemAmount;
		storage tempStorage;
		item item;
		List<job> serverJobs = AP.getJobs();

		for (job serverJob : serverJobs)
		{
			for (Pair<String, Integer> pair : serverJob.getJobRequireds())
			{
				itemName = pair.getLeft();
				itemAmount = pair.getRight();
				tempStorage = AP.Storages.get(serverJob.getJobStorage());
				item = AP.ItemsInEnv.get(itemName);
				if (item != null)
				{
					if (item.getSubItems().isEmpty())
					{
						jobs.add(new task(serverJob.getJobID(), "buy", itemName, itemName, itemAmount, findNearestshop(tempStorage.getName(), itemName, itemAmount, false)));
						jobs.add(new task(serverJob.getJobID(), "carryToStorage", itemName, itemName, itemAmount, tempStorage.getName()));
					}
				}
				// This part was only for single item jobs, there should be more for multiItem jobs
			}
		}
	}

	private String findNearestshop(String storage, String itemName, int itemAmount, boolean isMultiItem)
	{
		double lat1;
		double lon1;
		double lat2;
		double lon2;
		double distance;
		double minDistance = new Double(1000000);
		String shop = "";

		if (AP.shopsByItem.get(itemName) != null)
		{
			for (shop next : AP.shopsByItem.get(itemName))
			{
				lat1 = next.getShopLat();
				lon1 = next.getShopLon();
				lat2 = AP.Storages.get(storage).getLat();
				lon2 = AP.Storages.get(storage).getLon();
				distance = Math.sqrt((lat1 - lat2) * (lat1 - lat2) + (lon1 - lon2) * (lon1 - lon2));
				if (distance < minDistance && next.ShopItemsMap.get(itemName).getAmount() >= itemAmount)
				{
					minDistance = distance;
					shop = next.getShopName();
				}
			}
		}
		return shop;
	}

	private task getMyTask()
	{
		Map<String, List<task>> currentTasks = new HashMap<>();
		List<task> candidate = new LinkedList<>();
		List<task> storageTasks = new LinkedList<>();
		List<task> buyTasks = new LinkedList<>();
		task tempTask = null;
		double dist;
		double minDistance = new Double(1000000);

		for (task selectedJobs : jobs)
		{
			switch (selectedJobs.getAction())
			{
				case "carryToStorage":
					if (AP.getSelfInfo().haveItem(selectedJobs.getItem(), selectedJobs.getAmount()))
						candidate.add(selectedJobs);
					break;

				case "buy":
					if (AP.getSelfRole().getLoad() - AP.getSelfInfo().getLoad() > AP.ItemsInEnv.get(selectedJobs.getTopItem()).getVolume())
						candidate.add(selectedJobs);
					break;
			}

		}

		for (task doingTask : candidate)
		{
			if (!(currentTasks.containsKey(doingTask.getAction())))
				currentTasks.putIfAbsent(doingTask.getAction(), new ArrayList<task>());

			currentTasks.get(doingTask.getAction()).add(doingTask);
			if (doingTask.getAction().equals("carryToStorage"))
				storageTasks.add(doingTask);
			else if (doingTask.getAction().equals("buy"))
				buyTasks.add(doingTask);
		}

		boolean check = false;
		if (!storageTasks.isEmpty())
		{
			for (task item : storageTasks)
			{
				if (AP.Jobs.get(item.getJob()).isIsSimple())
				{
					tempTask = item;
					check = true;
					break;
				}
			}
		}
		if (!check)
		{
			if (!storageTasks.isEmpty())
			{
				tempTask = storageTasks.get(0);
				check = true;
			}
			else
			{
				for (task buyTask : buyTasks)
				{
					dist = Math.sqrt(Math.pow(AP.getSelfInfo().getLat() - AP.Shops.get(buyTask.getDestination()).getShopLat(), 2) + Math.pow(AP.getSelfInfo().getLon() - AP.Shops.get(buyTask.getDestination()).getShopLon(), 2));
					if (dist < minDistance)
					{
						tempTask = buyTask;
						minDistance = dist;
					}

					if ((AP.Jobs.get(buyTask.getJob()) != null) && (AP.Jobs.get(buyTask.getJob()).isIsSimple()))
					{
						tempTask = buyTask;
						check = true;
						break;
					}
				}
			}

		}
		if (tempTask != null && tempTask.getAction() != null)
			this.myTask = tempTask;

		return tempTask;
	}

	private void buy()
	{
		if ((AP.getSelfInfo().getLastAction().compareTo("buy") == 0) && AP.getSelfInfo().getLastActionResult().compareTo("successful") != 0)
			actionQueue.add(new Action("buy", new Identifier(myTask.getItem()), new Numeral(myTask.getAmount())));
	}

	private void goToStorage()
	{
		if ((AP.getSelfInfo().getLastAction().compareTo("deliver_job") == 0) && (AP.getSelfInfo().getLastActionResult().compareTo("successful") != 0))
		{
			actionQueue.add(new Action("goto", new Identifier(myTask.getDestination())));
			actionQueue.add(new Action("deliver_job", new Identifier(myTask.getJob())));
		}
	}
}
