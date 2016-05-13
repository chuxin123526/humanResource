package com.believe.humanResource.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.impl.TestDao;
import com.believe.humanResource.po.User;

@Transactional 
@Service
public class TestService
{
	@Resource
	private TestDao testDao ; 
	
	public User getUser()
	{
		return testDao.getUser() ;
	}

	public TestDao getTestDao()
	{
		return testDao;
	}

	public void setTestDao(TestDao testDao)
	{
		this.testDao = testDao;
	}
	
	
	
}
