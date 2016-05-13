package com.believe.humanResource.po;

import java.util.HashSet;
import java.util.Set;

public class PositionType
{
	private int id ; 
	private String name ; 
	private String description ;
	
	private Set<Position> positions = new HashSet<Position>() ; //该职位类型所拥有的职位
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Set<Position> getPositions()
	{
		return positions;
	}
	public void setPositions(Set<Position> positions)
	{
		this.positions = positions;
	} 
	
	
	
}
