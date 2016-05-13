package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.dao.IOrganazationDao;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.service.IOrganazationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class OrganazationAction extends ActionSupport
{
	@Resource
	private IOrganazationService organazationServiceImpl ;
	
	private Organazation organazation ; 
	
	private int parentID ;
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
		List<Organazation> organazationList = this.organazationServiceImpl.pageList(page) ;

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("organazationList", organazationList);
		
		return "list" ;
	}
	
	public String addUI() throws Exception
	{		
		List<Organazation> organazationList = this.organazationServiceImpl.list() ;
		ActionContext.getContext().put("organazationList", organazationList);
		
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		if(this.parentID != 0)
		{	
			Organazation parentOrganazation = this.organazationServiceImpl.getById(parentID) ;
			this.organazation.setOrganazation(parentOrganazation);
		}
		
		this.organazationServiceImpl.add(this.organazation);
		
		return "toList" ;
	}
	
	public String delete() throws Exception
	{
		this.organazationServiceImpl.delete(this.organazation.getId());
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{
		//拿到原机构
		this.organazation = this.organazationServiceImpl.getById(this.organazation.getId()) ;
		ActionContext.getContext().put("organazation", this.organazation);
		
		//拿到所有机构 
		List<Organazation> organazationList = this.organazationServiceImpl.list() ; 
		ActionContext.getContext().put("organazationList", organazationList);
		
		return "updateUI" ;
	}
	
	public String update() throws Exception
	{	
		if(this.parentID != 0)
		{
			Organazation parentOrganazation = this.organazationServiceImpl.getById(this.parentID) ;
			this.organazation.setOrganazation(parentOrganazation);
		}
		
		this.organazationServiceImpl.update(this.organazation);
		
		return "toList" ;
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

	public int getParentID()
	{
		return parentID;
	}

	public void setParentID(int parentID)
	{
		this.parentID = parentID;
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
