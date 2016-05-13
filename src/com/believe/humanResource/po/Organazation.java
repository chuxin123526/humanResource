package com.believe.humanResource.po;

import java.util.HashSet;
import java.util.Set;

public class Organazation
{
	private int id ; 
	private String name ; 
	private String description ;
	
	//该机构的薪酬发放记录
	private Set<Salary> salarys = new HashSet<Salary>() ;
	
	private Organazation organazation ; //该机构的上级机构
	
	private Set<Organazation> organazations = new HashSet<Organazation>() ; //该机够的下属机构
	
	private Set<HumanResource> humanResources = new HashSet<HumanResource>() ; //该机构下的所有人力资源
	
	public Set<Salary> getSalarys()
	{
		return salarys;
	}
	public void setSalarys(Set<Salary> salarys)
	{
		this.salarys = salarys;
	}
	public Set<Organazation> getOrganazations()
	{
		return organazations;
	}
	public void setOrganazations(Set<Organazation> organazations)
	{
		this.organazations = organazations;
	}
	public Organazation getOrganazation()
	{
		return organazation;
	}
	public void setOrganazation(Organazation organazation)
	{
		this.organazation = organazation;
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
	public Set<HumanResource> getHumanResources()
	{
		return humanResources;
	}
	public void setHumanResources(Set<HumanResource> humanResources)
	{
		this.humanResources = humanResources;
	} 
	
	
}
