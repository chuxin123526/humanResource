package com.believe.humanResource.base;

import java.util.List;

import com.believe.humanResource.po.Page;

public interface IBaseDao<T>
{
	public void add(T entiey) throws Exception ; 
	public void deleteById(int id) throws Exception ; 
	public void update(T entity) throws Exception ;
	public T getById(int id) throws Exception ;
	public List<T> findAll() ; 
	public List<T> pageList(Page page) ; 
}
