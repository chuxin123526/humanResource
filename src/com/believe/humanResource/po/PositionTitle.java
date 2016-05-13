package com.believe.humanResource.po;

public class PositionTitle
{
	private int id ; 
	private String name ; //职称名称
	private String description ; //描述
	
	private Position position ; //职称所属职位
	
	public Position getPosition()
	{
		return position;
	}
	public void setPosition(Position position)
	{
		this.position = position;
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
	
	
	
	
}
