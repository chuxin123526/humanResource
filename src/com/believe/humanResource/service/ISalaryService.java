package com.believe.humanResource.service;


import java.util.List;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.Organazation;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Salary;
import com.believe.humanResource.po.SalaryPersonal;

public interface ISalaryService extends IBaseService<Salary>
{
	public void createSalaryList() throws Exception ; 
	public float calculateMoney(Organazation organazation) throws Exception ; 
	public void updatePersonalSalary(SalaryPersonal entity) throws Exception ;
	public void updateSalaryMoney(Salary salary) throws Exception ; 
	public void register(Salary salary) throws Exception ; 
	public List<Salary> unApproveList() throws Exception ; 
	public List<Salary> unApprovePageList(Page page) throws Exception ; 
	public void approve(Salary salary) throws Exception ;  
}
