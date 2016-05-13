package com.believe.humanResource.dao;

import java.util.List;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;

public interface ISalaryDao extends IBaseDao<Salary>
{
	public List<Salary> unApproveList() throws Exception ; 
	public List<Salary> unApprovePageList(Page page) throws Exception ; 
}
