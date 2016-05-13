package com.believe.humanResource.base.impl ;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.Page;

public class BaseDaoImpl<T>  implements IBaseDao<T>
{
	@Resource
	protected SessionFactory sessionFactory ; 
	private Class clazz ;
	
	public BaseDaoImpl()
	{
		Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        clazz = (Class) params[0];
	}
	
	@Override
	public void add(T entity)
	{
		sessionFactory.getCurrentSession().save(entity) ; 
	}

	@Override
	public void deleteById(int id)
	{
		System.out.println("enter");
		Object object = this.getById(id);
		
		sessionFactory.getCurrentSession().delete(object) ;
	}

	@Override
	public void update(T entity)
	{
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public T getById(int id)
	{
		T entity = (T)sessionFactory.getCurrentSession().load(clazz, id) ;
		return entity ;
	}

	@Override
	public List<T> findAll()
	{
		String hql = "from "+clazz.getSimpleName() ;
			
		Query query = sessionFactory.getCurrentSession().createQuery(hql) ; 
 		
		return query.list() ;
	}

	@Override
	public List<T> pageList(Page page)
	{

		String hql = "from "+clazz.getSimpleName() ;
		
		//设置分页
		int count = sessionFactory.getCurrentSession().createQuery(hql).list().size() ; 
		if(count%page.getPageSize() == 0)
		{
			page.setPageCount(count/page.getPageSize());
		}
		else
		{
			page.setPageCount(count/page.getPageSize()+1);
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql) ; 
		query.setMaxResults(page.getPageSize()).setFirstResult((page.getRequestPage()-1)*page.getPageSize()) ; 
 		
		return query.list() ;
	}



}
