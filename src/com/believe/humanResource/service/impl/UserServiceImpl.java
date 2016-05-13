package com.believe.humanResource.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IUserDao;
import com.believe.humanResource.dao.impl.UserDaoImpl;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
	@Resource
	private IUserDao userDaoImpl ;
	
	public List<User> list() throws Exception
	{
		return this.userDaoImpl.findAll() ;
	}
	
	public void add(User user) throws Exception
	{
		this.userDaoImpl.add(user) ; 
	}
	
	public void delete(int id) throws Exception
	{
		this.userDaoImpl.deleteById(id);
	}
	
	public User getById(int id) throws Exception
	{
		User user = this.userDaoImpl.getById(id) ;
		
		return user ; 
	}
	
	@Override
	public void update(User entity) throws Exception
	{
		User user = this.getById(entity.getId()) ; 
		user.setName(entity.getName());
	}

	public IUserDao getUserDaoImpl()
	{
		return userDaoImpl;
	}

	public void setUserDaoImpl(IUserDao userDaoImpl)
	{
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public void initPassword(User user) throws Exception
	{
		user = this.userDaoImpl.getById(user.getId()) ;
		user.setPassword(DigestUtils.md5Hex("000000"));
		
	}

	@Override
	public User loginCheck(User user) throws Exception
	{
		return this.userDaoImpl.getByNameAndPassword(user) ;
	}

	@Override
	public void distributeRole(User user) throws Exception
	{
		//分配角色
		User user1 = this.userDaoImpl.getById(user.getId()) ; 
		user1.setRoles(user.getRoles());
		
	}

	@Override
	public List<Privilege> userPrivilegeList(User user) throws Exception
	{
		user = this.getById(user.getId()) ; 
		
		Set<Privilege> userPrivileges = new HashSet<Privilege>() ;
		
		//遍历用户所拥有的角色
		for(Role role : user.getRoles())
		{
			//遍历角色所拥有的权限
			for(Privilege privilege : role.getPrivileges())
			{
				userPrivileges.add(privilege) ;
			}
		}
		
		List<Privilege> userPrivilegeList = new ArrayList<Privilege>(userPrivileges) ; 
		return userPrivilegeList; 
	}

	@Override
	public List<User> pageList(Page page) throws Exception
	{
		return this.userDaoImpl.pageList(page) ; 
	}

	
	
}
