package com.believe.humanResource.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.ISalaryDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;

@Repository
@Transactional
public class SalaryDaoImpl extends BaseDaoImpl<Salary> implements ISalaryDao 
{

	@Override
	public List<Salary> unApproveList() throws Exception
	{
		//拿到未审核的薪酬列表
		String hql = "from Salary s where s.status=?" ; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql) ; 
		query.setString(0,"待审核") ;
		return query.list() ; 
	}

	@Override
	public List<Salary> unApprovePageList(Page page) throws Exception
	{
		String hql = "from Salary s where s.status=?" ; 
		//设置分页
		int count = sessionFactory.getCurrentSession().createQuery(hql).setString(0, "待审核").list().size() ; 
		if(count%page.getPageSize() == 0)
		{
			page.setPageCount(count/page.getPageSize());
		}
		else
		{
			page.setPageCount(count/page.getPageSize()+1);
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setString(0, "待审核") ; 
		query.setMaxResults(page.getPageSize()).setFirstResult((page.getRequestPage()-1)*page.getPageSize()) ; 
 		
		return query.list() ;
	}

}
