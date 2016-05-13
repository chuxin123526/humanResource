package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.IOrganazationService;
import com.believe.humanResource.service.impl.TestService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport
{
	@Resource
	private TestService testService ;
	
	@Resource IOrganazationService organazationServieceImpl ; 

	private int organazationID ; 
	
	@Override
	public String execute() throws Exception
	{
		//拿到所有顶级机构
		List<Organazation> topOrganazationList = this.organazationServieceImpl.topOrganazationList() ; 
		ActionContext.getContext().put("topOrganazationList", topOrganazationList);
		
		return "success" ; 
	}

	public TestService getTestService()
	{
		return testService;
	}

	public void setTestService(TestService testService)
	{
		this.testService = testService;
	}

	public IOrganazationService getOrganazationServieceImpl()
	{
		return organazationServieceImpl;
	}

	public void setOrganazationServieceImpl(
			IOrganazationService organazationServieceImpl)
	{
		this.organazationServieceImpl = organazationServieceImpl;
	}

	public int getOrganazationID()
	{
		return organazationID;
	}

	public void setOrganazationID(int organazationID)
	{
		this.organazationID = organazationID;
	}
	
	
	

}
