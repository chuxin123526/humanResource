package com.believe.humanResource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IOrganazationDao;
import com.believe.humanResource.po.Organazation;

@Repository
@Transactional
public class OrganazationDaoImpl extends BaseDaoImpl<Organazation> implements IOrganazationDao
{

	@Override
	public List<Organazation> topOrganazationList() throws Exception
	{
		String sql = "from Organazation o where o.organazation is null" ; 
		List<Organazation> topOrganazationList = this.sessionFactory.getCurrentSession().createQuery(sql).list() ; 
		
		return topOrganazationList ; 
	}

}
