package com.believe.humanResource.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SalaryStandard
{
	private int id ; 
	private String name ; 
	private Date addTime ; 
	private String status ; 
	private String approveIdea ;
	private float money ; 
	private String maker ; 

	private User user ; //登记人
	
	//该薪酬标准对应的人力资源
	private Set<HumanResource> humanResources = new HashSet<HumanResource>() ; 
	//该薪酬标准所拥有的薪酬项目 
	private Set<SalaryProject> salaryProjects = new HashSet<SalaryProject>() ; 
	
	
	
	public Set<HumanResource> getHumanResources()
	{
		return humanResources;
	}
	public void setHumanResources(Set<HumanResource> humanResources)
	{
		this.humanResources = humanResources;
	}
	public Set<SalaryProject> getSalaryProjects()
	{
		return salaryProjects;
	}
	public void setSalaryProjects(Set<SalaryProject> salaryProjects)
	{
		this.salaryProjects = salaryProjects;
	}
	public Date getAddTime()
	{
		return addTime;
	}
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
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

	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getApproveIdea()
	{
		return approveIdea;
	}
	public void setApproveIdea(String approveIdea)
	{
		this.approveIdea = approveIdea;
	}
	public float getMoney()
	{
		return money;
	}
	public void setMoney(float money)
	{
		this.money = money;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public String getMaker()
	{
		return maker;
	}
	public void setMaker(String maker)
	{
		this.maker = maker;
	}
	
	
	
	
	
}
