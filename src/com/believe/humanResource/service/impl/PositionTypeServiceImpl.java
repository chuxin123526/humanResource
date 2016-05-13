package com.believe.humanResource.service.impl;

import java.util.List;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IPositionTypeDao;
import com.believe.humanResource.dao.impl.PositionTypeDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.service.IPositionTypeService;

@Service
@Transactional
public class PositionTypeServiceImpl implements IPositionTypeService
{
	@Resource
	private IPositionTypeDao positionTypeDaoImpl ;

	@Override
	public List<PositionType> list() throws Exception
	{
		return this.positionTypeDaoImpl.findAll() ;
	}

	@Override
	public void add(PositionType entity) throws Exception
	{
		this.positionTypeDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.positionTypeDaoImpl.deleteById(id);
	}

	@Override
	public void update(PositionType entity) throws Exception
	{
		this.positionTypeDaoImpl.update(entity);
	}

	@Override
	public PositionType getById(int id) throws Exception
	{
		return this.positionTypeDaoImpl.getById(id) ;
	}

	public IPositionTypeDao getPositionTypeDaoImpl()
	{
		return positionTypeDaoImpl;
	}

	public void setPositionTypeDaoImpl(IPositionTypeDao positionTypeDaoImpl)
	{
		this.positionTypeDaoImpl = positionTypeDaoImpl;
	}

	@Override
	public List<PositionType> pageList(Page page) throws Exception
	{
		return this.positionTypeDaoImpl.pageList(page) ;
	} 
	
	
	
}
