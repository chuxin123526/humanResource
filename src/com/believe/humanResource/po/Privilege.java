package com.believe.humanResource.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege implements Serializable
{
	private int id ; //id
	private String name ; //权限名称 
	private String url ; //用户请求的资源
	
	private Set<Role> roles = new HashSet<Role>() ; //这个权限对应的角色
	
	
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
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	} 
	
	
}
