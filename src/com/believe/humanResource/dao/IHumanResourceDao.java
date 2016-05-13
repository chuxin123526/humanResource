package com.believe.humanResource.dao;

import java.util.List;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Page;

public interface IHumanResourceDao extends IBaseDao<HumanResource>
{
	public List<HumanResource> unApproveList() throws Exception ; 
	public List<HumanResource> approvedList() throws Exception ; 
	public List<HumanResource> unApprovePageList(Page page) throws Exception ; 
}
