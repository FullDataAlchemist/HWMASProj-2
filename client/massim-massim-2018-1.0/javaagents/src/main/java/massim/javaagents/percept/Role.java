/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massim.javaagents.percept;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Poney
 */
public class Role
{
	private String			name;
	private int				baseBattery;
	private int				maxBattery;
	private int				baseLoad;
	private int				maxLoad;
	private int				baseSpeed;
	private int				maxSpeed;
	private int				baseVision;
	private int				maxVision;
	private int				baseSkill;
	private int				maxSkill;
	private List<String>	tools;
	private List<String>	roads;

	public Role()
	{
	}

	public Role(int battery, int load, String name, int speed, List<String> roads)
	{
		this.baseBattery = battery;
		this.baseLoad = load;
		this.name = name;
		this.baseSpeed = speed;
		this.roads = roads;
	}

	public int getBaseBattery()
	{
		return baseBattery;
	}

	public void setBaseBattery(int baseBattery)
	{
		this.baseBattery = baseBattery;
	}

	public int getMaxBattery()
	{
		return maxBattery;
	}

	public void setMaxBattery(int maxBattery)
	{
		this.maxBattery = maxBattery;
	}

	public int getBaseLoad()
	{
		return baseLoad;
	}

	public void setBaseLoad(int baseLoad)
	{
		this.baseLoad = baseLoad;
	}

	public int getMaxLoad()
	{
		return maxLoad;
	}

	public void setMaxLoad(int maxLoad)
	{
		this.maxLoad = maxLoad;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getBaseSpeed()
	{
		return baseSpeed;
	}

	public void setBaseSpeed(int baseSpeed)
	{
		this.baseSpeed = baseSpeed;
	}

	public int getMaxSpeed()
	{
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed = maxSpeed;
	}

	public int getBaseVision()
	{
		return baseVision;
	}

	public void setBaseVision(int baseVision)
	{
		this.baseVision = baseVision;
	}

	public int getMaxVision()
	{
		return maxVision;
	}

	public void setMaxVision(int maxVision)
	{
		this.maxVision = maxVision;
	}

	public int getBaseSkill()
	{
		return baseSkill;
	}

	public void setBaseSkill(int baseSkill)
	{
		this.baseSkill = baseSkill;
	}

	public int getMaxSkill()
	{
		return maxSkill;
	}

	public void setMaxSkill(int maxSkill)
	{
		this.maxSkill = maxSkill;
	}

	public List<String> getTools()
	{
		return tools;
	}

	public void setTools(List<String> tools)
	{
		this.tools = tools;
	}

	public List<String> getRoads()
	{
		return roads;
	}

	public void setRoads(List<String> roads)
	{
		this.roads = roads;
	}

	public boolean haveTool(String toolName)
	{
		// System.out.println("Have Tool Function");
		for (int i = 0; i < tools.size(); i++)
		{
			// System.out.println("-> haveTool() -> ToolItem : "+tools.get(i));
			if (tools.get(i).compareTo(toolName) == 0)
			{
				return true;
			}
		}
		return false;
	}
}
