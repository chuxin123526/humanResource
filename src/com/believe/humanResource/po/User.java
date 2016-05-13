package com.believe.humanResource.po;

import java.util.HashSet;
import java.util.Set;


public class User 
{
	private int id ; //id
	private String name ; //用户名
	private String password ; //密码
	
	private Set<Role> roles = new HashSet<Role>() ; //用户所拥有的权限

	private Set<SalaryStandard> salaryStandards = new HashSet<SalaryStandard>() ; //用户所登记的薪酬标准
	
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Set<SalaryStandard> getSalaryStandards()
	{
		return salaryStandards;
	}
	public void setSalaryStandards(Set<SalaryStandard> salaryStandards)
	{
		this.salaryStandards = salaryStandards;
	} 
	
	
	
	
}
