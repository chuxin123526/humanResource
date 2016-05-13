package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IPrivilegeDao;
import com.believe.humanResource.dao.impl.PrivilegeDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.service.IPrivilegeService;
@Service
@Transactional
public class PrivilegeServiceImpl implements IPrivilegeService
{
	@Resource
	private IPrivilegeDao privilegeDaoImpl ;

	@Override
	public List<Privilege> list() throws Exception
	{
		return this.privilegeDaoImpl.findAll() ;
	}

	@Override
	public void add(Privilege entity) throws Exception
	{
		this.privilegeDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.privilegeDaoImpl.deleteById(id);
	}

	@Override
	public void update(Privilege entity) throws Exception
	{
		this.privilegeDaoImpl.update(entity);
	}

	@Override
	public Privilege getById(int id) throws Exception
	{
		return this.privilegeDaoImpl.getById(id) ;
	}

	public IPrivilegeDao getPrivilegeDaoImpl()
	{
		return privilegeDaoImpl;
	}

	public void setPrivilegeDaoImpl(IPrivilegeDao privilegeDaoImpl)
	{
		this.privilegeDaoImpl = privilegeDaoImpl;
	}

	@Override
	public List<Privilege> pageList(Page page) throws Exception
	{
		return null ;
	}

	
	
}
