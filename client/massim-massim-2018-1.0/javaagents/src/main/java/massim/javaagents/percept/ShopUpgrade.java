package massim.javaagents.percept;

/**
 * @author Poney
 *
 */
public class ShopUpgrade
{
	private String	name;
	private int		cost;
	private int		step;

	public ShopUpgrade(String name, int cost, int step)
	{
		this.cost = cost;
		this.name = name;
		this.step = step;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public int getStep()
	{
		return step;
	}

	public void setStep(int step)
	{
		this.step = step;
	}
}
