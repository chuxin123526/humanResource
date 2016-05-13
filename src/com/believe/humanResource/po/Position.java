package com.believe.humanResource.po;

import java.util.Set;

public class Position
{
	private int id ;
	private String name ; 
	private String description ;
	
	private PositionType positionType ; // 该职位的职位类型
	
	private Set<PositionTitle> positionTitles ; //该职位所拥有的职称
	
	public PositionType getPositionType()
	{
		return positionType;
	}
	public void setPositionType(PositionType positionType)
	{
		this.positionType = positionType;
	}
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
	public Set<PositionTitle> getPositionTitles()
	{
		return positionTitles;
	}
	public void setPositionTitles(Set<PositionTitle> positionTitles)
	{
		this.positionTitles = positionTitles;
	}
	
	
	
	

}
