package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Position;
import com.believe.humanResource.po.PositionTitle;
import com.believe.humanResource.service.IPositionService;
import com.believe.humanResource.service.IPositionTitleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class PositionTitleAction extends ActionSupport
{
	@Resource
	private IPositionTitleService positionTitleServiceImpl ; 
	
	@Resource
	private IPositionService positionServiceImpl ; 
	
	private PositionTitle positionTitle ;
	
	private int positionID ; 
	
	private int requestPage ; 

	
	public String list() throws Exception
	{
		
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<PositionTitle> positionTitleList = this.positionTitleServiceImpl.pageList(page) ; 

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("positionTitleList", positionTitleList);
		
		return "list" ;
	}
	
	public String addUI() throws Exception
	{
		//拿到所有职位
		List<Position> positionList = this.positionServiceImpl.list() ;
		ActionContext.getContext().put("positionList", positionList);
		
		return "addUI" ;
	}
	
	public String add() throws Exception
	{
		//根据positionID拿到职位
		Position position = this.positionServiceImpl.getById(positionID) ; 
		this.positionTitle.setPosition(position);
		this.positionTitleServiceImpl.add(this.positionTitle);
		
		return "toList" ;
	}
	
	public String delete() throws Exception
	{
		this.positionTitleServiceImpl.delete(this.positionTitle.getId());
		
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{
		//拿到所有职位
		List<Position> positionList = this.positionServiceImpl.list() ; 
		ActionContext.getContext().put("positionList", positionList);
		
		//拿到该职称
		this.positionTitle = this.positionTitleServiceImpl.getById(this.positionTitle.getId()) ; 
		ActionContext.getContext().put("positionTitle", this.positionTitle);
		
		return "updateUI" ;
	}
	
	public String update() throws Exception
	{
		//根据职位id拿到职位
		Position position = this.positionServiceImpl.getById(positionID) ; 
		this.positionTitle.setPosition(position);
		
		//修改职称
		this.positionTitleServiceImpl.update(this.positionTitle);
		
		return "toList" ;
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

	

	public IPositionService getPositionServiceImpl()
	{
		return positionServiceImpl;
	}

	public void setPositionServiceImpl(IPositionService positionServiceImpl)
	{
		this.positionServiceImpl = positionServiceImpl;
	}

	public int getPositionID()
	{
		return positionID;
	}

	public void setPositionID(int positionID)
	{
		this.positionID = positionID;
	}

	public PositionTitle getPositionTitle()
	{
		return positionTitle;
	}

	public void setPositionTitle(PositionTitle positionTitle)
	{
		this.positionTitle = positionTitle;
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
