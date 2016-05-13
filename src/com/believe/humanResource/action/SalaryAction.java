package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.po.Salary;
import com.believe.humanResource.po.SalaryPersonal;
import com.believe.humanResource.po.SalaryProject;
import com.believe.humanResource.service.IOrganazationService;
import com.believe.humanResource.service.ISalaryPersonalService;
import com.believe.humanResource.service.ISalaryProjectService;
import com.believe.humanResource.service.ISalaryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalaryAction extends ActionSupport
{
	@Resource 
	private ISalaryService salaryServiceImpl ; 
	
	@Resource
	private IOrganazationService organazationServiceImpl ; 
	
	@Resource
	private ISalaryProjectService salaryProjectServiceImpl ; 
	
	@Resource
	private ISalaryPersonalService salaryPersonalServiceImpl ;
	
	private Salary salary ; 
	
	private SalaryPersonal salaryPersonal ; 
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<Salary> salaryList = this.salaryServiceImpl.pageList(page) ; 

		ActionContext.getContext().put("page", page);
			
		ActionContext.getContext().put("salaryList", salaryList);
		
		return "list" ;
	}
	
	public String add() throws Exception
	{
		//生成所有三级机构的薪酬记录
		this.salaryServiceImpl.createSalaryList() ; 
		
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.salaryServiceImpl.delete(this.salary.getId());
		
		return "toList" ; 
	}
	
	public String registerUI() throws Exception
	{
		//根据薪酬id拿到机构的薪酬对象
		this.salary = this.salaryServiceImpl.getById(this.salary.getId()) ; 
		
		return "registerUI" ;
	}
	
	public String register() throws Exception
	{
		this.salaryServiceImpl.register(this.salary);
		
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
		
		return "toRegisterUI" ; 
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

	public ISalaryProjectService getSalaryProjectServiceImpl()
	{
		return salaryProjectServiceImpl;
	}

	public void setSalaryProjectServiceImpl(
			ISalaryProjectService salaryProjectServiceImpl)
	{
		this.salaryProjectServiceImpl = salaryProjectServiceImpl;
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
