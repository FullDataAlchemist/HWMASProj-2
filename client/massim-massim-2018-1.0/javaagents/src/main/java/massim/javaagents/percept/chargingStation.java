/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massim.javaagents.percept;

/**
 *
 * @author poney
 */
public class chargingStation
{
	private String		name;
	private Location	location;
	private int			rate;

	public chargingStation(String name, Location location, int rate)
	{
		this.name = name;
		this.location = location;
		this.rate = rate;
	}

	public chargingStation()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getRate()
	{
		return rate;
	}

	public void setRate(int rate)
	{
		this.rate = rate;
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
