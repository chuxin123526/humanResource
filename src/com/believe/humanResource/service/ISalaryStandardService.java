package com.believe.humanResource.service;

import java.util.List;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryStandard;

public interface ISalaryStandardService extends IBaseService<SalaryStandard>
{
	public List<SalaryStandard> unApproveList() throws Exception ; 
	public List<SalaryStandard> unApprovePageList(Page page) throws Exception ; 
	public void approve(SalaryStandard salaryStandard) throws Exception ;  
	public List<SalaryStandard> approvedList() throws Exception ; 
}
