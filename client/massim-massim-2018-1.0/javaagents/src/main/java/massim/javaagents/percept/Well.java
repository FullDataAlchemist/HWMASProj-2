package massim.javaagents.percept;

/**
 * @author Poney
 *
 */
public class Well
{
	private Location	location;
	private int			cost;
	private int			efficiency;	// score points per step
	private int			integrity;	// life time

	public Well(int cost, int efficiency, int integrity, Location location)
	{
		this.cost = cost;
		this.efficiency = efficiency;
		this.integrity = integrity;
		this.location = location;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public int getEfficiency()
	{
		return efficiency;
	}

	public void setEfficiency(int efficiency)
	{
		this.efficiency = efficiency;
	}

	public int getIntegrity()
	{
		return integrity;
	}

	public void setIntegrity(int integrity)
	{
		this.integrity = integrity;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}
}
