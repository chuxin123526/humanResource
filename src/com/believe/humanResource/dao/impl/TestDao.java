package com.believe.humanResource.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.po.User;


@Transactional
@Repository
public class TestDao
{
	@Resource
	private SessionFactory sessionFactory ;

	public User getUser()
	{
		User user = new User() ; 
		
		Session session = this.sessionFactory.getCurrentSession() ; 
		user = (User)session.load(User.class, 3) ;
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return user ; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
