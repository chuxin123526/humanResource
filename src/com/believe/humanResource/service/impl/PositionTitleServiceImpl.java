package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IPositionTitleDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.PositionTitle;
import com.believe.humanResource.service.IPositionTitleService;

@Service
@Transactional
public class PositionTitleServiceImpl implements IPositionTitleService
{
	@Resource
	private IPositionTitleDao positionTitleDaoImpl ; 

	@Override
	public List<PositionTitle> list() throws Exception
	{
		return this.positionTitleDaoImpl.findAll() ; 
	}

	@Override
	public void add(PositionTitle entity) throws Exception
	{
		this.positionTitleDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.positionTitleDaoImpl.deleteById(id);
	}

	@Override
	public void update(PositionTitle entity) throws Exception
	{
		this.positionTitleDaoImpl.update(entity);
	}

	@Override
	public PositionTitle getById(int id) throws Exception
	{
		return this.positionTitleDaoImpl.getById(id) ;
	}

	public IPositionTitleDao getPositionTitleDaoImpl()
	{
		return positionTitleDaoImpl;
	}

	public void setPositionTitleDaoImpl(IPositionTitleDao positionTitleDaoImpl)
	{
		this.positionTitleDaoImpl = positionTitleDaoImpl;
	}

	@Override
	public List<PositionTitle> pageList(Page page) throws Exception
	{
		return this.positionTitleDaoImpl.pageList(page) ; 
	}
	
	
	
}
