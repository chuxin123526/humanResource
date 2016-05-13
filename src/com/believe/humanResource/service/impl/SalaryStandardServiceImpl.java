package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.ISalaryStandardDao;
import com.believe.humanResource.dao.impl.SalaryStandardDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryStandard;
import com.believe.humanResource.service.ISalaryStandardService;
@Service
@Transactional
public class SalaryStandardServiceImpl implements ISalaryStandardService
{
	@Resource
	private ISalaryStandardDao salaryStandardDaoImpl ; 

	
	@Override
	public List<SalaryStandard> list() throws Exception
	{
		return this.salaryStandardDaoImpl.findAll() ;
	}

	@Override
	public void add(SalaryStandard entity) throws Exception
	{
		entity.setStatus("未审核");
		this.salaryStandardDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.salaryStandardDaoImpl.deleteById(id);
	}

	@Override
	public void update(SalaryStandard entity) throws Exception
	{
		this.salaryStandardDaoImpl.update(entity);
	}

	@Override
	public SalaryStandard getById(int id) throws Exception
	{
		return this.salaryStandardDaoImpl.getById(id) ;
	}

	public ISalaryStandardDao getSalaryStandardDaoImpl()
	{
		return salaryStandardDaoImpl;
	}

	public void setSalaryStandardDaoImpl(ISalaryStandardDao salaryStandardDaoImpl)
	{
		this.salaryStandardDaoImpl = salaryStandardDaoImpl;
	}

	@Override
	public List<SalaryStandard> unApproveList() throws Exception
	{
		return this.salaryStandardDaoImpl.unApproveList() ; 
	}

	@Override
	public void approve(SalaryStandard salaryStandard) throws Exception
	{
		SalaryStandard salaryStandard1 = this.salaryStandardDaoImpl.getById(salaryStandard.getId()) ;
		salaryStandard1.setApproveIdea(salaryStandard.getApproveIdea());
		salaryStandard1.setStatus("已审核");
	}

	@Override
	public List<SalaryStandard> pageList(Page page) throws Exception
	{
		return this.salaryStandardDaoImpl.pageList(page) ; 
	}

	@Override
	public List<SalaryStandard> unApprovePageList(Page page) throws Exception
	{
		return this.salaryStandardDaoImpl.unApprovePageList(page) ; 
	}

	@Override
	public List<SalaryStandard> approvedList() throws Exception
	{
		return this.salaryStandardDaoImpl.ApprovedList() ; 
	}



	

	
}
