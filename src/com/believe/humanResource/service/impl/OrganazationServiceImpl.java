package com.believe.humanResource.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IOrganazationDao;
import com.believe.humanResource.dao.impl.OrganazationDaoImpl;
import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.service.IOrganazationService;
@Service
@Transactional
public class OrganazationServiceImpl implements IOrganazationService
{
	@Resource 
	private IOrganazationDao organazationDaoImpl ; 
	
	@Override
	public List<Organazation> list() throws Exception
	{
		return this.organazationDaoImpl.findAll() ;
	}

	@Override
	public void add(Organazation entity) throws Exception
	{	
		this.organazationDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.organazationDaoImpl.deleteById(id);
	}

	@Override
	public void update(Organazation entity) throws Exception
	{
		this.organazationDaoImpl.update(entity);
	}

	@Override
	public Organazation getById(int id) throws Exception
	{
		return this.organazationDaoImpl.getById(id) ;
	}

	public IOrganazationDao getOrganazationDaoImpl()
	{
		return organazationDaoImpl;
	}

	public void setOrganazationDaoImpl(IOrganazationDao organazationDaoImpl)
	{
		this.organazationDaoImpl = organazationDaoImpl;
	}

	@Override
	public List<Organazation> topOrganazationList() throws Exception
	{
		//拿到所有顶级机构
		return this.organazationDaoImpl.topOrganazationList() ; 
	}

	@Override
	public List<Organazation> threeOrganazationList() throws Exception
	{
		List<Organazation> threeOrganazationList = new ArrayList<Organazation>() ; 
		
		//拿到所有的顶级
		List<Organazation> topOrganazationList = this.topOrganazationList() ; 
		//遍历顶级机构
		for(Organazation topOrganazation : topOrganazationList)
		{
			//遍历二级机构
			for(Organazation twoOrganazation : topOrganazation.getOrganazations())
			{
				//遍历三级机构
				for(Organazation threeOrganazation : twoOrganazation.getOrganazations())
				//拿到三级机构
				threeOrganazationList.add(threeOrganazation) ;
			}
		}
		
		return threeOrganazationList ; 
	}

	@Override
	public List<Organazation> pageList(Page page) throws Exception
	{
		return this.organazationDaoImpl.pageList(page) ; 
	}
	
	
	
	

}
