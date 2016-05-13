package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.ISalaryPersonalDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryPersonal;
import com.believe.humanResource.service.ISalaryPersonalService;

@Service
@Transactional
public class SalaryPersonalServiceImpl implements ISalaryPersonalService
{

	@Resource
	private ISalaryPersonalDao salaryPersonDaoImpl ; 
	
	@Override
	public List<SalaryPersonal> list() throws Exception
	{
		return this.salaryPersonDaoImpl.findAll() ; 
	}

	@Override
	public void add(SalaryPersonal entity) throws Exception
	{
		this.salaryPersonDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.salaryPersonDaoImpl.deleteById(id);
	}

	@Override
	public void update(SalaryPersonal entity) throws Exception
	{
		this.salaryPersonDaoImpl.update(entity);
	}

	@Override
	public SalaryPersonal getById(int id) throws Exception
	{
		return this.salaryPersonDaoImpl.getById(id) ; 
	}

	public ISalaryPersonalDao getSalaryPersonDaoImpl()
	{
		return salaryPersonDaoImpl;
	}

	public void setSalaryPersonDaoImpl(ISalaryPersonalDao salaryPersonDaoImpl)
	{
		this.salaryPersonDaoImpl = salaryPersonDaoImpl;
	}

	@Override
	public List<SalaryPersonal> pageList(Page page) throws Exception
	{
		return this.salaryPersonDaoImpl.pageList(page) ; 
	}

	
	
}
