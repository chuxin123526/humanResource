package com.believe.humanResource.base;

import java.util.List;

import com.believe.humanResource.po.Page;

public interface IBaseService<T> 
{
	public List<T> list() throws Exception ; 
	public void add(T entity) throws Exception ;
	public void delete(int id) throws Exception ; 
	public void update(T entity) throws Exception ;
	public T getById(int id) throws Exception ; 
	public List<T> pageList(Page page) throws Exception ; 
}
