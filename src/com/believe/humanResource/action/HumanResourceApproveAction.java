package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.PositionTitle;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.service.IHumanResourceService;
import com.believe.humanResource.service.IPositionTitleService;
import com.believe.humanResource.service.ISalaryStandardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HumanResourceApproveAction extends ActionSupport
{
	@Resource
	private IHumanResourceService humanResourceServiceImpl ; 
	
	@Resource
	private IPositionTitleService positionTitleServiceImpl ; 

	@Resource
	private ISalaryStandardService salaryStandardServiceImpl ; 
	
	private HumanResource humanResource ;
	
	private int positionTitleID ;
	
	private int salaryStandardID ;
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
		List<HumanResource> humanResourceUnApproveList = this.humanResourceServiceImpl.unApproveList(page);  

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("humanResourceUnApproveList", humanResourceUnApproveList);
		
		return "list" ;
	}
	
	public String approveUI() throws Exception
	{
		//拿到所有的薪酬标准
		List<SalaryStandard> salaryStandardList = this.salaryStandardServiceImpl.list() ; 
		ActionContext.getContext().put("salaryStandardList", salaryStandardList);
		
		this.humanResource = this.humanResourceServiceImpl.getById(this.humanResource.getId()) ;
		
		return "approveUI" ;
	}
	
	public String approve() throws Exception
	{
		//设置职称
		if(this.positionTitleID != 0)
		{
			PositionTitle positionTitle = this.positionTitleServiceImpl.getById(positionTitleID) ; 
			this.humanResource.setPositionTitle(positionTitle);
		}
		
		//设置薪酬标准
		SalaryStandard salaryStandard = this.salaryStandardServiceImpl.getById(salaryStandardID) ;
		this.humanResource.setSalaryStandard(salaryStandard);
		
		this.humanResourceServiceImpl.approve(this.humanResource);
		
		return "toList" ;
	}

	public IHumanResourceService getHumanResourceServiceImpl()
	{
		return humanResourceServiceImpl;
	}

	public void setHumanResourceServiceImpl(
			IHumanResourceService humanResourceServiceImpl)
	{
		this.humanResourceServiceImpl = humanResourceServiceImpl;
	}

	public HumanResource getHumanResource()
	{
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource)
	{
		this.humanResource = humanResource;
	}

	public int getPositionTitleID()
	{
		return positionTitleID;
	}

	public void setPositionTitleID(int positionTitleID)
	{
		this.positionTitleID = positionTitleID;
	}

	public int getSalaryStandardID()
	{
		return salaryStandardID;
	}

	public void setSalaryStandardID(int salaryStandardID)
	{
		this.salaryStandardID = salaryStandardID;
	}

	public IPositionTitleService getPositionTitleServiceImpl()
	{
		return positionTitleServiceImpl;
	}

	public void setPositionTitleServiceImpl(
			IPositionTitleService positionTitleServiceImpl)
	{
		this.positionTitleServiceImpl = positionTitleServiceImpl;
	}

	public ISalaryStandardService getSalaryStandardServiceImpl()
	{
		return salaryStandardServiceImpl;
	}

	public void setSalaryStandardServiceImpl(
			ISalaryStandardService salaryStandardServiceImpl)
	{
		this.salaryStandardServiceImpl = salaryStandardServiceImpl;
	}

	public int getRequestPage()
	{
		return requestPage;
	}

	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	} 
	
	
	
	
	
	
}
