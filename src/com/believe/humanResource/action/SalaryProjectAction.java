package com.believe.humanResource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;
import com.believe.humanResource.po.SalaryProject;
import com.believe.humanResource.service.ISalaryProjectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalaryProjectAction extends ActionSupport
{
	@Resource
	private ISalaryProjectService salaryProjectServiceImpl ; 
	
	private SalaryProject salaryProject ;
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		//拿到所有薪酬项目
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<SalaryProject> salaryProjectList = this.salaryProjectServiceImpl.pageList(page);

		ActionContext.getContext().put("page", page);
 
		ActionContext.getContext().put("salaryProjectList", salaryProjectList);
		
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		this.salaryProjectServiceImpl.add(this.salaryProject);
		
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.salaryProjectServiceImpl.delete(this.salaryProject.getId());
		
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		this.salaryProject = this.salaryProjectServiceImpl.getById(this.salaryProject.getId()) ; 
		ActionContext.getContext().put("salaryProject", this.salaryProject);
		
		return "updateUI" ; 
	}
	
	public String update() throws Exception
	{
		//更新 
		this.salaryProjectServiceImpl.update(this.salaryProject);
		
		return "toList" ; 
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

	public SalaryProject getSalaryProject()
	{
		return salaryProject;
	}

	public void setSalaryProject(SalaryProject salaryProject)
	{
		this.salaryProject = salaryProject;
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
