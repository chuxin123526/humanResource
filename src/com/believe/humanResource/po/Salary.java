package com.believe.humanResource.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Salary
{
	private int id ; //id
	private int count ; //人数 
	private float account ; //总额 
	private String status ; //审核状态  ， 0 为未审核，1为已经审核
	private Date registerTime ; //登记日期
	
	private Organazation organazation ; //该薪酬发放对应的机构
	
	private Set<SalaryPersonal> salaryPersonals = new HashSet<SalaryPersonal>() ; 
	
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
	public float getAccount()
	{
		return account;
	}
	public void setAccount(float account)
	{
		this.account = account;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public Date getRegisterTime()
	{
		return registerTime;
	}
	public void setRegisterTime(Date registerTime)
	{
		this.registerTime = registerTime;
	}
	public Set<SalaryPersonal> getSalaryPersonals()
	{
		return salaryPersonals;
	}
	public void setSalaryPersonals(Set<SalaryPersonal> salaryPersonals)
	{
		this.salaryPersonals = salaryPersonals;
	}

	
	
	
}
