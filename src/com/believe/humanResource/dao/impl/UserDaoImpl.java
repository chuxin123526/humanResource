package com.believe.humanResource.dao.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IUserDao;
import com.believe.humanResource.po.User;
import com.sun.mail.smtp.DigestMD5;

@Transactional
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao
{

	@Override
	public User getByNameAndPassword(User user) throws Exception
	{
		String sql = "from User u where u.name=? and u.password=? " ; 
		
		String name = user.getName() ; 
		String password = DigestUtils.md5Hex(user.getPassword()) ; 
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(sql) ; 
		query.setString(0, name) ; 
		query.setString(1, password) ; 
		
		return (User)query.uniqueResult() ; 
		
	}

}
