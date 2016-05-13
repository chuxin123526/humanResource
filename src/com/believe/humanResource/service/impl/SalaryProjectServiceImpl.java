package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.ISalaryProjectDao;
import com.believe.humanResource.dao.impl.SalaryProjectDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryProject;
import com.believe.humanResource.service.ISalaryProjectService;
@Service
@Transactional
public class SalaryProjectServiceImpl implements ISalaryProjectService
{
	@Resource
	private ISalaryProjectDao salaryProjectDaoImpl ;
	
	@Override
	public List<SalaryProject> list() throws Exception
	{
		return this.salaryProjectDaoImpl.findAll() ;
	}

	@Override
	public void add(SalaryProject entity) throws Exception
	{
		this.salaryProjectDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.salaryProjectDaoImpl.deleteById(id);
	}

	@Override
	public void update(SalaryProject entity) throws Exception
	{
		this.salaryProjectDaoImpl.update(entity);
	}

	@Override
	public SalaryProject getById(int id) throws Exception
	{
		return this.salaryProjectDaoImpl.getById(id) ;
	}

	public ISalaryProjectDao getSalaryProjectDaoImpl()
	{
		return salaryProjectDaoImpl;
	}

	public void setSalaryProjectDaoImpl(ISalaryProjectDao salaryProjectDaoImpl)
	{
		this.salaryProjectDaoImpl = salaryProjectDaoImpl;
	}

	@Override
	public List<SalaryProject> pageList(Page page) throws Exception
	{
		return this.salaryProjectDaoImpl.pageList(page) ; 
	}

	
	
	

}
