package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IPositionDao;
import com.believe.humanResource.dao.impl.PositionDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Position;
import com.believe.humanResource.service.IPositionService;
@Service
@Transactional
public class PositionServiceImpl implements IPositionService
{
	@Resource
	private IPositionDao positionDaoImpl ;

	public List<Position> list() throws Exception
	{
		return this.positionDaoImpl.findAll() ;
	}
	
	public void add(Position position) throws Exception
	{
		this.positionDaoImpl.add(position);
	}
	
	public void delete(int id) throws Exception
	{
		this.positionDaoImpl.deleteById(id);
	}

	@Override
	public void update(Position entity) throws Exception
	{
		this.positionDaoImpl.update(entity);
	}

	@Override
	public Position getById(int id) throws Exception
	{
		return this.positionDaoImpl.getById(id) ;
	}

	public IPositionDao getPositionDaoImpl()
	{
		return positionDaoImpl;
	}

	public void setPositionDaoImpl(IPositionDao positionDaoImpl)
	{
		this.positionDaoImpl = positionDaoImpl;
	}

	@Override
	public List<Position> pageList(Page page) throws Exception
	{
		return this.positionDaoImpl.pageList(page) ; 
	} 
	
	
	
	
}
