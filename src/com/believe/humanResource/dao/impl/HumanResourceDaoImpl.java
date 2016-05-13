package com.believe.humanResource.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IHumanResourceDao;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Page;

@Repository
@Transactional
public class HumanResourceDaoImpl extends BaseDaoImpl<HumanResource> implements IHumanResourceDao
{

	@Override
	public List<HumanResource> unApproveList() throws Exception
	{
		String hql = "from HumanResource h where h.status=? " ; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql) ; 
		query.setString(0, "未审核") ; 
		List<HumanResource> unApproveList = query.list() ;
		
		return unApproveList ; 
	}

	@Override
	public List<HumanResource> unApprovePageList(Page page) throws Exception
	{
		String hql = "from HumanResource h where h.status=? " ; 
		
		//设置分页
		int count = sessionFactory.getCurrentSession().createQuery(hql).setString(0, "未审核").list().size() ; 
		if(count%page.getPageSize() == 0)
		{
			page.setPageCount(count/page.getPageSize());
		}
		else
		{
			page.setPageCount(count/page.getPageSize()+1);
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setString(0, "未审核") ; 
		query.setMaxResults(page.getPageSize()).setFirstResult((page.getRequestPage()-1)*page.getPageSize()) ; 
 		
		return query.list() ;
	}

	@Override
	public List<HumanResource> approvedList() throws Exception
	{
		String hql = "from HumanResource h where h.status=?" ; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql).setString(0, "已审核") ; 
		
		return query.list() ; 
	}

}
