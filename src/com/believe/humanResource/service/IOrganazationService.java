package com.believe.humanResource.service;

import java.util.List;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.Organazation;

public interface IOrganazationService extends IBaseService<Organazation>
{
	public List<Organazation> topOrganazationList() throws Exception ; //拿到所有的顶级机构
	public List<Organazation> threeOrganazationList() throws Exception ; //拿到所有的三级机构
}
