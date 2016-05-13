package com.believe.humanResource.po;


public class SalaryPersonal
{
	private int id ;  
	private float deduct ; //应扣除工资 
	private float reward ; //应奖励工资
	
	private HumanResource humanResource ; //该个人薪酬记录对应的人力资源
	
	private Salary salary ; //该个人薪酬记录对应的机构薪酬记录

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public float getDeduct()
	{
		return deduct;
	}

	public void setDeduct(float deduct)
	{
		this.deduct = deduct;
	}

	public float getReward()
	{
		return reward;
	}

	public void setReward(float reward)
	{
		this.reward = reward;
	}

	public HumanResource getHumanResource()
	{
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource)
	{
		this.humanResource = humanResource;
	}

	public Salary getSalary()
	{
		return salary;
	}

	public void setSalary(Salary salary)
	{
		this.salary = salary;
	}
	
	
	
	
	
	
}
