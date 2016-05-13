package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Position;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.service.IPositionService;
import com.believe.humanResource.service.IPositionTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class PositionAction extends ActionSupport
{
	@Resource
	private IPositionService positionServiceImpl ;
	
	@Resource
	private IPositionTypeService positionTypeServiceImpl ; 
	
	private Position position ; 
	
	private int positionTypeID ; 
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
		//拿到所有的职位
		List<Position> positionList = this.positionServiceImpl.pageList(page) ; 

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("positionList", positionList);
		
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		List<PositionType> positionTypeList = this.positionTypeServiceImpl.list() ; 
		ActionContext.getContext().put("positionTypeList", positionTypeList);
		
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		if(this.positionTypeID != 0)
		{
			PositionType positionType = this.positionTypeServiceImpl.getById(positionTypeID) ;
			this.position.setPositionType(positionType);
		}
	
		this.positionServiceImpl.add(this.position);
		
		
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.positionServiceImpl.delete(this.position.getId());
		
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		//拿到职位
		this.position = this.positionServiceImpl.getById(this.position.getId()) ;
		ActionContext.getContext().put("position", this.position);
		
		//拿到所有职位类型
		List<PositionType> positionTypeList = this.positionTypeServiceImpl.list() ;
		ActionContext.getContext().put("positionTypeList", positionTypeList);
		 
		
		return "updateUI" ; 
	}
	
	public String update() throws Exception
	{
		//通过positionTypeID拿到positionType对象
		PositionType positionType = this.positionTypeServiceImpl.getById(positionTypeID) ;
		//给职位设置职位类型
		this.position.setPositionType(positionType);
		//更新职位
		this.positionServiceImpl.update(this.position) ; 
		
		return "toList" ; 
	}
	

	public Position getPosition()
	{
		return position;
	}

	public void setPosition(Position position)
	{
		this.position = position;
	}

	public int getPositionTypeID()
	{
		return positionTypeID;
	}

	public void setPositionTypeID(int positionTypeID)
	{
		this.positionTypeID = positionTypeID;
	}

	public IPositionService getPositionServiceImpl()
	{
		return positionServiceImpl;
	}

	public void setPositionServiceImpl(IPositionService positionServiceImpl)
	{
		this.positionServiceImpl = positionServiceImpl;
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

	public int getRequestPage()
	{
		return requestPage;
	}

	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	}

	
	
	
	
	
}
