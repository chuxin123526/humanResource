package com.believe.humanResource.po;

import java.util.HashSet;
import java.util.Set;



public class SalaryProject
{
	private int id ; 
	private String name ; //薪酬项目名称
	private float money ; //薪酬金额
	
	//该薪酬项目对应的薪酬标准
	private Set<SalaryStandard> salaryStandards = new HashSet<SalaryStandard>() ;
	
	public Set<SalaryStandard> getSalaryStandards()
	{
		return salaryStandards;
	}
	public void setSalaryStandards(Set<SalaryStandard> salaryStandards)
	{
		this.salaryStandards = salaryStandards;
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
	public float getMoney()
	{
		return money;
	}
	public void setMoney(float money)
	{
		this.money = money;
	}
	
	
}
