package com.believe.humanResource.dao;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.User;

public interface IUserDao extends IBaseDao<User>
{
	public User getByNameAndPassword(User user) throws Exception ;
}
