package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.service.ISalaryStandardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalaryStandardApproveAction extends ActionSupport
{
	@Resource
	private ISalaryStandardService salaryStandardServiceImpl ;
	
	private SalaryStandard salaryStandard ; 
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<SalaryStandard> unApproveList = this.salaryStandardServiceImpl.unApprovePageList(page) ; 

		ActionContext.getContext().put("page", page);
		
		ActionContext.getContext().put("unApproveList", unApproveList);
		
		return "unApproveList" ; 
	}
	
	public String approveUI() throws Exception
	{
		this.salaryStandard = this.salaryStandardServiceImpl.getById(this.salaryStandard.getId()) ;
		
		return "approveUI" ; 
	}
	
	public String approve() throws Exception
	{
		this.salaryStandardServiceImpl.approve(this.salaryStandard);
		
		return "toUnApproveList" ;
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

	public SalaryStandard getSalaryStandard()
	{
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard)
	{
		this.salaryStandard = salaryStandard;
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
