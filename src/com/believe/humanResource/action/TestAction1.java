package com.believe.humanResource.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.service.IOrganazationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction1 extends ActionSupport
{
	private int organazation1ID ; 
	private Organazation organazation ; 
	
	@Resource
	private IOrganazationService organazationServiceImpl ; 

	@Override
	public String execute() throws Exception
	{
		
		System.out.println("enter-----------------");
		System.out.println(this.organazation1ID);
		System.out.println(this.organazation.getId());
		
		if(this.organazation.getId() !=0)
		{
			this.organazation = this.organazationServiceImpl.getById(this.organazation.getId()) ; 
		}
		System.out.println(organazation.getOrganazations().size());
		
		
		return "success"; 
	}

	public int getOrganazation1ID()
	{
		return organazation1ID;
	}

	public void setOrganazation1ID(int organazation1id)
	{
		organazation1ID = organazation1id;
	}

	public IOrganazationService getOrganazationServiceImpl()
	{
		return organazationServiceImpl;
	}

	public void setOrganazationServiceImpl(
			IOrganazationService organazationServiceImpl)
	{
		this.organazationServiceImpl = organazationServiceImpl;
	}

	public Organazation getOrganazation()
	{
		return organazation;
	}

	public void setOrganazation(Organazation organazation)
	{
		this.organazation = organazation;
	}
	
	
	
	
}
