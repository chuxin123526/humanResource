package com.believe.humanResource.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryProject;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.ISalaryProjectService;
import com.believe.humanResource.service.ISalaryStandardService;
import com.believe.humanResource.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalaryStandardAction extends ActionSupport
{
	@Resource
	private ISalaryStandardService salaryStandardServiceImpl ; 
	
	@Resource
	private IUserService userServiceImpl ; 
	
	@Resource
	private ISalaryProjectService salaryProjectServiceImpl ; 
	
	private SalaryStandard salaryStandard ; 
	
	private int[] salaryProjectIDS ; 
	
	private int requestPage ; 
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<SalaryStandard> salaryStandardList = this.salaryStandardServiceImpl.pageList(page) ;  

		ActionContext.getContext().put("page", page);
		
		ActionContext.getContext().put("salaryStandardList", salaryStandardList);
		
		return "list" ;
	}
	
	public String addUI() throws Exception
	{
		//拿到所有薪酬项目
		List<SalaryProject> salaryProjectList = this.salaryProjectServiceImpl.list() ; 
		ActionContext.getContext().put("salaryProjectList", salaryProjectList);

		return "addUI" ;
	}
	
	public String add() throws Exception
	{
		//根据页面传过来的薪酬项目ids构造一个set
		Set<SalaryProject> salaryProjects = new HashSet<SalaryProject>() ;
		
		if(this.salaryProjectIDS!=null)
		{
			for(int id : this.salaryProjectIDS)
			{
				SalaryProject salaryProject = this.salaryProjectServiceImpl.getById(id) ; 
				salaryProjects.add(salaryProject) ; 
				//计算总额
				this.salaryStandard.setMoney(salaryProject.getMoney()+this.salaryStandard.getMoney());
			}
		}
		
		//设置登记人
		this.salaryStandard.setUser((User)ActionContext.getContext().getSession().get("loginUser"));
		
		//设置登记时间
		Date date = new Date() ;
		this.salaryStandard.setAddTime(date);

		this.salaryStandard.setSalaryProjects(salaryProjects);
		
		this.salaryStandardServiceImpl.add(this.salaryStandard);
		
		return "toList" ;
	}
	
	public String delete() throws Exception
	{
		this.salaryStandardServiceImpl.delete(this.salaryStandard.getId());
		
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{
		//拿到所有薪酬项目
		List<SalaryProject> salaryProjectList = this.salaryProjectServiceImpl.list() ; 
		ActionContext.getContext().put("salaryProjectList", salaryProjectList);
		
		//拿到需要修改的薪酬标准
		this.salaryStandard = this.salaryStandardServiceImpl.getById(this.salaryStandard.getId()) ;
		
		return "updateUI" ;
	}
	
	public String update() throws Exception
	{
		//根据页面传过来的薪酬项目id数据构造一个set集合
		Set<SalaryProject> salaryProjects = new HashSet<SalaryProject>() ;
		
		if(this.salaryProjectIDS!=null)
		{
			for(int id : this.salaryProjectIDS)
			{
				SalaryProject salaryProject = this.salaryProjectServiceImpl.getById(id) ; 
				salaryProjects.add(salaryProject) ; 
				//计算总额
				this.salaryStandard.setMoney(salaryProject.getMoney()+this.salaryStandard.getMoney());
			}
		}
		
		this.salaryStandard.setSalaryProjects(salaryProjects) ;
		
		//设置登记人
		this.salaryStandard.setUser((User)ActionContext.getContext().getSession().get("loginUser"));
				
		
		//设置登记时间
		Date date = new Date() ;
		this.salaryStandard.setAddTime(date);
		
		//修改数据
		this.salaryStandardServiceImpl.update(this.salaryStandard);
		
		return "toList" ;
	}

	public String detailUI() throws Exception
	{
		this.salaryStandard = this.salaryStandardServiceImpl.getById(this.salaryStandard.getId()) ;
		
		return "detailUI" ; 
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

	public ISalaryProjectService getSalaryProjectServiceImpl()
	{
		return salaryProjectServiceImpl;
	}

	public void setSalaryProjectServiceImpl(
			ISalaryProjectService salaryProjectServiceImpl)
	{
		this.salaryProjectServiceImpl = salaryProjectServiceImpl;
	}

	public SalaryStandard getSalaryStandard()
	{
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard)
	{
		this.salaryStandard = salaryStandard;
	}

	public int[] getSalaryProjectIDS()
	{
		return salaryProjectIDS;
	}

	public void setSalaryProjectIDS(int[] salaryProjectIDS)
	{
		this.salaryProjectIDS = salaryProjectIDS;
	}

	public IUserService getUserServiceImpl()
	{
		return userServiceImpl;
	}

	public void setUserServiceImpl(IUserService userServiceImpl)
	{
		this.userServiceImpl = userServiceImpl;
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
