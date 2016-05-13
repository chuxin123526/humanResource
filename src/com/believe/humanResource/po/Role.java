package com.believe.humanResource.po;

import java.util.HashSet;
import java.util.Set;

public class Role
{
	private int id ; 
	private String name ; //角色名 
	private String description ; //角色的描述
	
	private Set<User> users = new HashSet<User>() ; //这个角色对应的用户
	private Set<Privilege> privileges = new HashSet<Privilege>() ; //这个角色对应的权限	
	
	
	public Set<User> getUsers()
	{
		return users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
	public Set<Privilege> getPrivileges()
	{
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges)
	{
		this.privileges = privileges;
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
