/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massim.javaagents.percept;

import java.util.List;

/**
 *
 * @author Poney
 */
public class self
{
	private int							battery;
	private double						lat;
	private int							load;
	private int							skill;
	private int							speed;
	private int							vision;
	private double						lon;
	private String						name;
	private Role						role;
	private String						team;
	private String						LastAction;
	private String						LastActionResult;
	private List<Pair<item, Integer>>	carriedItems;
	private int							teamMoney;

	public self(int charge, int skill, int speed, int vision, double lat, int load, double lon, String name, Role role,
		String team, String LastAction, String LastActionResult,
		List<Pair<item, Integer>> carriedItems)
	{
		this.skill = skill;
		this.speed = speed;
		this.vision = vision;
		this.battery = charge;
		this.lat = lat;
		this.load = load;
		this.lon = lon;
		this.name = name;
		this.role = role;
		this.team = team;
		this.LastAction = LastAction;
		this.LastActionResult = LastActionResult;
		this.carriedItems = carriedItems;
	}

	public self()
	{
	}

	public void setCharge(int charge)
	{
		this.battery = charge;
	}

	public void setLat(double lat)
	{
		this.lat = lat;
	}

	public void setLoad(int load)
	{
		this.load = load;
	}

	public void setLon(double lon)
	{
		this.lon = lon;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public void setTeam(String team)
	{
		this.team = team;
	}

	public void setLastAction(String LastAction)
	{
		this.LastAction = LastAction;
	}

	public void setLastActionResult(String LastActionResult)
	{
		this.LastActionResult = LastActionResult;
	}

	public int getCharge()
	{
		return battery;
	}

	public double getLat()
	{
		return lat;
	}

	public int getLoad()
	{
		return load;
	}

	public double getLon()
	{
		return lon;
	}

	public String getName()
	{
		return name;
	}

	public Role getRole()
	{
		return role;
	}

	public String getTeam()
	{
		return team;
	}

	public String getLastAction()
	{
		return LastAction;
	}

	public String getLastActionResult()
	{
		return LastActionResult;
	}

	public List<Pair<item, Integer>> getCarriedItems()
	{
		return carriedItems;
	}

	public void setCarriedItems(List<Pair<item, Integer>> carriedItems)
	{
		this.carriedItems = carriedItems;
	}

	public int getTeamMoney()
	{
		return teamMoney;
	}

	public void setTeamMoney(int teamMoney)
	{
		this.teamMoney = teamMoney;
	}

	public int getBattery()
	{
		return battery;
	}

	public void setBattery(int battery)
	{
		this.battery = battery;
	}

	public int getSkill()
	{
		return skill;
	}

	public void setSkill(int skill)
	{
		this.skill = skill;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getVision()
	{
		return vision;
	}

	public void setVision(int vision)
	{
		this.vision = vision;
	}

	public boolean haveItem(String itemName, int itemAmount)
	{
		// System.out.println("Have Item Function");
		for (int i = 0; i < carriedItems.size(); i++)
		{
			// System.out.println("-> haveItem() -> carriedItem : "+carriedItems.get(i).getLeft().getName()+carriedItems.get(i).getRight().intValue());
			if (carriedItems.get(i).getLeft().getName().compareTo(itemName) == 0)
			{
				if (carriedItems.get(i).getRight().intValue() == itemAmount)
				{
					return true;
				}
			}
		}
		return false;
	}
}
