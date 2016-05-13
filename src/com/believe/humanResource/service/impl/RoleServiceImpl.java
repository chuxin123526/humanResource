package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IRoleDao;
import com.believe.humanResource.dao.impl.RoleDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.service.IRoleService;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService
{
	@Resource
	private IRoleDao roleDaoImpl ;
	
	@Override
	public List<Role> list() throws Exception
	{
		return this.roleDaoImpl.findAll() ;
	}

	@Override
	public void add(Role entity) throws Exception
	{
		this.roleDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.roleDaoImpl.deleteById(id);
	}

	@Override
	public void update(Role entity) throws Exception
	{
		Role role = this.getById(entity.getId()) ; 
		role.setName(entity.getName());
	}

	@Override
	public Role getById(int id) throws Exception
	{
		return this.roleDaoImpl.getById(id) ;
	}

	public IRoleDao getRoleDaoImpl()
	{
		return roleDaoImpl;
	}

	public void setRoleDaoImpl(IRoleDao roleDaoImpl)
	{
		this.roleDaoImpl = roleDaoImpl;
	}

	@Override
	public void distributePrivilege(Role role) throws Exception
	{
		//分配权限
		Role role1 = this.roleDaoImpl.getById(role.getId()) ; 
		role1.setPrivileges(role.getPrivileges());
		
	}

	@Override
	public List<Role> pageList(Page page) throws Exception
	{
		return this.roleDaoImpl.pageList(page) ; 
	}

	
	
	

}
