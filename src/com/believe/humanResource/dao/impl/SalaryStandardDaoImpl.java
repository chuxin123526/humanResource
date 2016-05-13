package com.believe.humanResource.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.ISalaryStandardDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryStandard;

@Repository
@Transactional
public class SalaryStandardDaoImpl extends BaseDaoImpl<SalaryStandard> implements ISalaryStandardDao
{

	@Override
	public List<SalaryStandard> unApproveList() throws Exception
	{
		String hql = "from SalaryStandard s where s.status = ?" ; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		List<SalaryStandard> unApproveList = query.setString(0, "未审核").list() ; 
		
		return unApproveList ; 
	}

	@Override
	public List<SalaryStandard> unApprovePageList(Page page) throws Exception
	{
		String hql = "from SalaryStandard s where s.status = ?" ; 
		
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
	public List<SalaryStandard> ApprovedList() throws Exception
	{
		String hql = "from SalaryStandard s where s.status=?" ; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql).setString(0, "已审核") ; 
		
		return query.list() ; 
	}

}
