package massim.javaagents.percept;

/**
 * @author Poney
 *
 */
public class Location
{
	private double	minLat;
	private double	minLon;
	private double	maxLat;
	private double	maxLon;
	private double	currentLat;
	private double	currentLon;

	public Location(double currentLat, double currentLon)
	{
		this.currentLat = currentLat;
		this.currentLon = currentLon;
	}

	public Location(double currentLat, double currentLon,
		double minLat, double minLon, double maxLat, double maxLon)
	{
		this.currentLat = currentLat;
		this.currentLon = currentLon;
		this.minLat = minLat;
		this.minLon = minLon;
		this.maxLat = maxLat;
		this.maxLon = maxLon;
	}

	public double getMinLat()
	{
		return minLat;
	}

	public void setMinLat(double minLat)
	{
		this.minLat = minLat;
	}

	public double getMinLon()
	{
		return minLon;
	}

	public void setMinLon(double minLon)
	{
		this.minLon = minLon;
	}

	public double getMaxLat()
	{
		return maxLat;
	}

	public void setMaxLat(double maxLat)
	{
		this.maxLat = maxLat;
	}

	public double getMaxLon()
	{
		return maxLon;
	}

	public void setMaxLon(double maxLon)
	{
		maxLon = maxLon;
	}

	public double getCurrentLat()
	{
		return currentLat;
	}

	public void setCurrentLat(double currentLat)
	{
		this.currentLat = currentLat;
	}

	public double getCurrentLon()
	{
		return currentLon;
	}

	public void setCurrentLon(double currentLon)
	{
		this.currentLon = currentLon;
	}
}
