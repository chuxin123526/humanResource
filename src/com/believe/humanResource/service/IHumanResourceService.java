package com.believe.humanResource.service;

import java.util.List;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Page;

public interface IHumanResourceService extends IBaseService<HumanResource>
{
	public List<HumanResource> unApproveList() throws Exception ; 
	public List<HumanResource> unApproveList(Page page) throws Exception ; 
	public List<HumanResource> approveList() throws Exception ; 
	public void approve(HumanResource entity) throws Exception ;  
}
