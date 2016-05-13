package com.believe.humanResource.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Position;
import com.believe.humanResource.po.PositionTitle;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.IHumanResourceService;
import com.believe.humanResource.service.IOrganazationService;
import com.believe.humanResource.service.IPositionService;
import com.believe.humanResource.service.IPositionTitleService;
import com.believe.humanResource.service.IPositionTypeService;
import com.believe.humanResource.service.ISalaryStandardService;
import com.believe.humanResource.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HumanResourceAction extends ActionSupport
{
	@Resource
	private IHumanResourceService humanResourceService ; 
	
	@Resource
	private IUserService userServiceImpl ; 
	
	@Resource
	private IOrganazationService organazationServiceImpl ; 
	
	@Resource
	private IPositionTypeService positionTypeServiceImpl ; 
	
	@Resource
	private IPositionService positionServiceImpl ; 
	
	@Resource
	private IPositionTitleService positionTitleServiceImpl ; 
	
	@Resource
	private ISalaryStandardService salaryStandardServiceImpl ; 
	
	private HumanResource humanResource ; 
	
	private int organazation1ID ; 
	private int organazation2ID ;
	private int organazation3ID ; 
	private int positionTypeID ; 
	private int positionID ; 
	private int positionTitleID ;
	
	private int salaryStandardID ; 
	
	private int requestPage ;
	
	private Organazation organazation ; //与ajax交互
	private PositionType positionType ; //与ajax交互
	private Position position ; //与ajax交互
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
		List<HumanResource> humanResourceList = this.humanResourceService.pageList(page);  

		ActionContext.getContext().put("page", page);
		
		
		ActionContext.getContext().put("humanResourceList", humanResourceList);
		
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		//拿到所有顶级机构
		List<Organazation> topOrganazationList = this.organazationServiceImpl.topOrganazationList() ; 
		ActionContext.getContext().put("topOrganazationList", topOrganazationList);
		
		//拿到所有职位类型
		List<PositionType> positionTypeList = this.positionTypeServiceImpl.list() ; 
		ActionContext.getContext().put("positionTypeList", positionTypeList);
		
		//拿到所有已经审核的薪酬标准
		List<SalaryStandard> salaryStandardList = this.salaryStandardServiceImpl.approvedList() ; 
		ActionContext.getContext().put("salaryStandardList", salaryStandardList);
		
		return "addUI" ; 
	}
	
	public String takeChildOrganazationList() throws Exception
	{
		this.organazation = this.organazationServiceImpl.getById(this.organazation.getId()) ; 
		
		return "takeChildOrganazationList" ;
	}
	
	public String takePositionList() throws Exception
	{
		this.positionType = this.positionTypeServiceImpl.getById(this.positionType.getId()) ; 
		
		return "takePositionList" ; 
	}
	
	public String takePositionTitleList() throws Exception
	{
		this.position = this.positionServiceImpl.getById(this.position.getId()) ; 
		
		return "takePositionTitleList" ; 
	}
	
	public String add() throws Exception 
	{
		//设置一级机构
		if(this.organazation1ID != 0)
		{
			Organazation organazation1 = this.organazationServiceImpl.getById(organazation1ID) ; 
			this.humanResource.setOrganazation1(organazation1);
		}
		
		//设置二级机构
		if(this.organazation2ID != 0)
		{
			Organazation organazation2 = this.organazationServiceImpl.getById(organazation2ID) ; 
			this.humanResource.setOrganazation2(organazation2);
		}
		
		//设置三级机构
		if(this.organazation3ID != 0)
		{
			Organazation organazation3 = this.organazationServiceImpl.getById(organazation3ID) ; 
			this.humanResource.setOrganazation3(organazation3);
		}
		
		//设置职位类型
		if(this.positionTypeID != 0)
		{
			PositionType positionType = this.positionTypeServiceImpl.getById(positionTypeID) ; 
			this.humanResource.setPositionType(positionType);
		}
		
		//设置职位
		if(this.positionID != 0)
		{
			Position position = this.positionServiceImpl.getById(positionID) ; 
			this.humanResource.setPosition(position);
		}
		
		//设置职称
		if(this.positionTitleID != 0)
		{
			PositionTitle positionTitle = this.positionTitleServiceImpl.getById(positionTitleID) ; 
			this.humanResource.setPositionTitle(positionTitle);
		}
		
		//设置薪酬标准
		if(this.salaryStandardID != 0)
		{
			SalaryStandard salaryStandard = this.salaryStandardServiceImpl.getById(salaryStandardID) ;
			this.humanResource.setSalaryStandard(salaryStandard);
		}
		
		
		//设置添加时间
		this.humanResource.setAddTime(new Date());
		
		//获取年份
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy") ; 
		String date = simpleDateFormat.format(new Date()) ; 
		System.out.println(date);
		
		//获取一级机构编号
		String organazation1Number = new Integer(this.organazation1ID).toString() ; 
		if(organazation1Number.length() == 1)
		{
			organazation1Number = "0" + organazation1Number ;
		}
		//获取二级机构编号
		String organazation2Number = new Integer(this.organazation2ID).toString() ; 
		if(organazation2Number.length() == 1)
		{
			organazation2Number = "0" + organazation2Number ;
		}
		//获取三级机构编号
		String organazation3Number = new Integer(this.organazation3ID).toString() ; 
		if(organazation3Number.length() == 1)
		{
			organazation3Number = "0" + organazation3Number ;
		}
		//生成随机后两位编号
		Random random = new Random() ; 
		String tail = random.nextInt(99) + ""; 
		if(tail.length() == 1)
		{
			tail = "0"+tail ; 
		}
		//生成编号
		String number = date + organazation1Number + organazation2Number + organazation3Number 
				+ tail ; 
		//设置编号
		this.humanResource.setNumber(number);
		
		
		//设置审核状态
		this.humanResource.setStatus("未审核");
		
		//添加到数据库
		this.humanResourceService.add(this.humanResource);
		
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.humanResourceService.delete(this.humanResource.getId());
		
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{		
		//拿到所有的薪酬标准
		List<SalaryStandard> salaryStandardList = this.salaryStandardServiceImpl.list() ; 
		ActionContext.getContext().put("salaryStandardList", salaryStandardList);
		
		//拿到需要修改的人力资源
		this.humanResource = this.humanResourceService.getById(this.humanResource.getId()) ;
		
		return "updateUI" ;
	}
	
	public String detailUI() throws Exception
	{
		this.humanResource = this.humanResourceService.getById(this.humanResource.getId()) ; 
		
		return "detailUI" ;
	}
	
	public String update() throws Exception
	{	
		//设置职称
		if(this.positionTitleID != 0)
		{
			PositionTitle positionTitle = this.positionTitleServiceImpl.getById(positionTitleID) ; 
			this.humanResource.setPositionTitle(positionTitle);
		}
		
		//设置薪酬标准
		SalaryStandard salaryStandard = this.salaryStandardServiceImpl.getById(salaryStandardID) ;
		this.humanResource.setSalaryStandard(salaryStandard);
		
		//更新到数据库
		this.humanResourceService.update(this.humanResource);
		
		return "toList" ; 
	}

	public IHumanResourceService getHumanResourceService()
	{
		return humanResourceService;
	}

	public void setHumanResourceService(IHumanResourceService humanResourceService)
	{
		this.humanResourceService = humanResourceService;
	}

	public IUserService getUserServiceImpl()
	{
		return userServiceImpl;
	}

	public void setUserServiceImpl(IUserService userServiceImpl)
	{
		this.userServiceImpl = userServiceImpl;
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

	public IPositionTypeService getPositionTypeServiceImpl()
	{
		return positionTypeServiceImpl;
	}

	public void setPositionTypeServiceImpl(
			IPositionTypeService positionTypeServiceImpl)
	{
		this.positionTypeServiceImpl = positionTypeServiceImpl;
	}

	public IPositionService getPositionServiceImpl()
	{
		return positionServiceImpl;
	}

	public void setPositionServiceImpl(IPositionService positionServiceImpl)
	{
		this.positionServiceImpl = positionServiceImpl;
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

	public HumanResource getHumanResource()
	{
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource)
	{
		this.humanResource = humanResource;
	}

	public int getOrganazation1ID()
	{
		return organazation1ID;
	}

	public void setOrganazation1ID(int organazation1id)
	{
		organazation1ID = organazation1id;
	}

	public int getOrganazation2ID()
	{
		return organazation2ID;
	}

	public void setOrganazation2ID(int organazation2id)
	{
		organazation2ID = organazation2id;
	}

	public int getOrganazation3ID()
	{
		return organazation3ID;
	}

	public void setOrganazation3ID(int organazation3id)
	{
		organazation3ID = organazation3id;
	}

	public int getPositionTypeID()
	{
		return positionTypeID;
	}

	public void setPositionTypeID(int positionTypeID)
	{
		this.positionTypeID = positionTypeID;
	}

	public int getPositionID()
	{
		return positionID;
	}

	public void setPositionID(int positionID)
	{
		this.positionID = positionID;
	}

	public int getPositionTitleID()
	{
		return positionTitleID;
	}

	public void setPositionTitleID(int positionTitleID)
	{
		this.positionTitleID = positionTitleID;
	}

	public int getSalaryStandardID()
	{
		return salaryStandardID;
	}

	public void setSalaryStandardID(int salaryStandardID)
	{
		this.salaryStandardID = salaryStandardID;
	}

	public Organazation getOrganazation()
	{
		return organazation;
	}

	public void setOrganazation(Organazation organazation)
	{
		this.organazation = organazation;
	}

	public Position getPosition()
	{
		return position;
	}

	public void setPosition(Position position)
	{
		this.position = position;
	}

	public PositionType getPositionType()
	{
		return positionType;
	}

	public void setPositionType(PositionType positionType)
	{
		this.positionType = positionType;
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

	public int getRequestPage()
	{
		return requestPage;
	}

	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	}
	
	
	
	
	
	
}
