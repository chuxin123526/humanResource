package com.believe.humanResource.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.ISalaryDao;
import com.believe.humanResource.dao.impl.SalaryDaoImpl;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;
import com.believe.humanResource.po.SalaryPersonal;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.service.IOrganazationService;
import com.believe.humanResource.service.ISalaryPersonalService;
import com.believe.humanResource.service.ISalaryService;
@Service
@Transactional
public class SalaryServiceImpl implements ISalaryService
{
	@Resource 
	private ISalaryDao salaryDaoImpl ;
	
	@Resource
	private IOrganazationService organazationServiceImpl ; 
	
	@Resource
	private ISalaryPersonalService salaryPersonalServiceImpl ; 
	
	@Override
	public List<Salary> list() throws Exception
	{
		return this.salaryDaoImpl.findAll() ;
	}

	@Override
	public void add(Salary entity) throws Exception
	{
		this.salaryDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.salaryDaoImpl.deleteById(id);
	}

	@Override
	public void update(Salary entity) throws Exception
	{
		this.salaryDaoImpl.update(entity);
	}

	@Override
	public Salary getById(int id) throws Exception
	{
		return this.salaryDaoImpl.getById(id) ;
	}

	public ISalaryDao getSalaryDaoImpl()
	{
		return salaryDaoImpl;
	}

	public void setSalaryDaoImpl(ISalaryDao salaryDaoImpl)
	{
		this.salaryDaoImpl = salaryDaoImpl;
	}

	@Override
	public void createSalaryList() throws Exception
	{
		List<Organazation> threeOrganazationList = this.organazationServiceImpl.threeOrganazationList() ; 
		//遍历三级机构
		for(Organazation threeOrganazation : threeOrganazationList)
		{
			//根据每一个机构生成机构薪酬列表
			Salary salary = new Salary() ; 
			salary.setAccount(this.calculateMoney(threeOrganazation));
			salary.setOrganazation(threeOrganazation);
			
			salary.setStatus("待登记");
			salary.setRegisterTime(new Date());
			this.salaryDaoImpl.add(salary);
			
			//遍历已经审核的人力资源生成人力资源薪酬记录
			for(HumanResource humanResource : threeOrganazation.getHumanResources())
			{
				if(!humanResource.getStatus().equals("已审核"))
				{
					continue ; 
				}
				//设置机构薪酬记录的
				salary.setCount(salary.getCount()+1);
				//生成薪酬记录
				SalaryPersonal salaryPersonal = new SalaryPersonal() ; 
				salaryPersonal.setDeduct(0);
				salaryPersonal.setReward(0);
				salaryPersonal.setHumanResource(humanResource);
				salaryPersonal.setSalary(salary);
				this.salaryPersonalServiceImpl.add(salaryPersonal);
			}
		}
	}

	@Override
	public float calculateMoney(Organazation organazation) throws Exception
	{
		float account = 0 ; 
		//拿到该机构的所有人力资源
		List<HumanResource> list = new ArrayList<HumanResource>(organazation.getHumanResources()) ; 
		//遍历所有的人力资源计算总额
		for(HumanResource humanResource : list)
		{
			SalaryStandard salaryStandard = humanResource.getSalaryStandard() ; 
			account += salaryStandard.getMoney() ; 
		}
			
		return account ; 
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

	public ISalaryPersonalService getSalaryPersonalServiceImpl()
	{
		return salaryPersonalServiceImpl;
	}

	public void setSalaryPersonalServiceImpl(
			ISalaryPersonalService salaryPersonalServiceImpl)
	{
		this.salaryPersonalServiceImpl = salaryPersonalServiceImpl;
	}

	@Override
	public void updatePersonalSalary(SalaryPersonal entity) throws Exception
	{
		SalaryPersonal salaryPersonal = this.salaryPersonalServiceImpl.getById(entity.getId()) ; 
		salaryPersonal.setDeduct(entity.getDeduct());
		salaryPersonal.setReward(entity.getReward());
		
		//跟新薪酬记录的金额
		this.updateSalaryMoney(salaryPersonal.getSalary());
		
	}

	@Override
	public void updateSalaryMoney(Salary salary) throws Exception
	{
		float money = 0 ;
		for(SalaryPersonal salaryPersonal : salary.getSalaryPersonals())
		{
			money += salaryPersonal.getHumanResource().getSalaryStandard().getMoney() ; 
			money -= salaryPersonal.getDeduct() ; 
			money += salaryPersonal.getReward() ; 
		}
		
		salary.setAccount(money);
		
	}

	@Override
	public void register(Salary salary) throws Exception
	{
		Salary entity = this.salaryDaoImpl.getById(salary.getId()) ; 
		entity.setStatus("待审核");
	}

	@Override
	public List<Salary> unApproveList() throws Exception
	{
		return this.salaryDaoImpl.unApproveList() ; 
	}

	@Override
	public void approve(Salary salary) throws Exception
	{
		Salary entity = this.salaryDaoImpl.getById(salary.getId()) ; 
		entity.setStatus("已审核");
		
	}

	@Override
	public List<Salary> pageList(Page page) throws Exception
	{
		return this.salaryDaoImpl.pageList(page) ; 
	}

	@Override
	public List<Salary> unApprovePageList(Page page) throws Exception
	{
		return this.salaryDaoImpl.unApprovePageList(page) ; 
	}


	
	

}
