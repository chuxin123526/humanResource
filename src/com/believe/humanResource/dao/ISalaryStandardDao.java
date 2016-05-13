package com.believe.humanResource.dao;

import java.util.List;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.SalaryStandard;

public interface ISalaryStandardDao extends IBaseDao<SalaryStandard>
{
	public List<SalaryStandard> unApproveList() throws Exception ;
	public List<SalaryStandard> ApprovedList() throws Exception ;
	public List<SalaryStandard> unApprovePageList(Page page) throws Exception ;
}
