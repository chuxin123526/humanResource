package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;
import com.believe.humanResource.po.SalaryPersonal;
import com.believe.humanResource.service.ISalaryPersonalService;
import com.believe.humanResource.service.ISalaryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalaryApproveAction extends ActionSupport
{
	@Resource
	private ISalaryService salaryServiceImpl ; 
	
	@Resource
	private ISalaryPersonalService salaryPersonalServiceImpl ; 
	
	private Salary salary ;

	private SalaryPersonal salaryPersonal ; 
	
	private int requestPage; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<Salary> salaryList = this.salaryServiceImpl.unApprovePageList(page) ; 

		ActionContext.getContext().put("page", page);
				
		ActionContext.getContext().put("salaryList" , salaryList) ; 
		
		return "list" ;
	}
	
	public String approveUI() throws Exception
	{
		//拿到需要审核的薪酬对象
		this.salary = this.salaryServiceImpl.getById(this.salary.getId()) ;
		
		return "approveUI" ; 
	}
	
	public String approve() throws Exception
	{
		this.salaryServiceImpl.approve(this.salary);
		
		return "toList" ; 
	}
	
	public String updatePersonalSalaryUI() throws Exception
	{
		this.salaryPersonal = this.salaryPersonalServiceImpl.getById(this.salaryPersonal.getId()) ; 
		
		return "updatePersonalSalaryUI" ; 
	}
	
	public String updatePersonalSalary() throws Exception
	{
		//修改修改个人薪酬记录
		this.salaryServiceImpl.updatePersonalSalary(this.salaryPersonal);
		
		return "toApproveUI" ; 
	}
	
	
	public ISalaryService getSalaryServiceImpl()
	{
		return salaryServiceImpl;
	}

	public void setSalaryServiceImpl(ISalaryService salaryServiceImpl)
	{
		this.salaryServiceImpl = salaryServiceImpl;
	}

	public Salary getSalary()
	{
		return salary;
	}

	public void setSalary(Salary salary)
	{
		this.salary = salary;
	}

	public SalaryPersonal getSalaryPersonal()
	{
		return salaryPersonal;
	}

	public void setSalaryPersonal(SalaryPersonal salaryPersonal)
	{
		this.salaryPersonal = salaryPersonal;
	}

	public ISalaryPersonalService getSalaryPersonalServiceImpl()
	{
		return salaryPersonalServiceImpl;
	}

	public void setSalaryPersonalServiceImpl(
			ISalaryPersonalService salaryPersonalServiceImpl)
	{
		this.salaryPersonalServiceImpl = salaryPersonalServiceImpl;
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
