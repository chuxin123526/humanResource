package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.PositionTitle;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.service.IPositionTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class PositionTypeAction extends ActionSupport
{
	@Resource
	private IPositionTypeService positionTypeServiceImpl ;
	
	private PositionType positionType ;
	
	private int requestPage ; 
	
	public String list() throws Exception 
	{

		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<PositionType> positionTypeList = this.positionTypeServiceImpl.pageList(page) ; 

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("positionTypeList", positionTypeList);
		
		return "list" ;
	}
	
	public String addUI() throws Exception 
	{
		return "addUI" ;
	}
	
	public String add() throws Exception 
	{
		this.positionTypeServiceImpl.add(positionType);
		
		return "toList" ;
	}
	
	public String delete() throws Exception 
	{
		this.positionTypeServiceImpl.delete(this.positionType.getId());
		
		return "toList" ;
	}
	
	public String updateUI() throws Exception 
	{
		this.positionType = this.positionTypeServiceImpl.getById(this.positionType.getId()) ;
		ActionContext.getContext().put("positionType", this.positionType);
		return "updateUI" ;
	}
	
	public String update() throws Exception 
	{
		this.positionTypeServiceImpl.update(this.positionType);
		
		return "toList" ;
	}

	public IPositionTypeService getPositionTypeServiceImpl()
	{
		return positionTypeServiceImpl;
	}

	public void setPositionTypeServiceImpl(
			IPositionTypeService positionTypeServiceImpl)
	{
		this.positionTypeServiceImpl = positionTypeServiceImpl;
	}

	public PositionType getPositionType()
	{
		return positionType;
	}

	public void setPositionType(PositionType positionType)
	{
		this.positionType = positionType;
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
