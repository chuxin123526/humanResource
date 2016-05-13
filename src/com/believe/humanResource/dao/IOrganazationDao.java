package com.believe.humanResource.dao;

import java.util.List;

import com.believe.humanResource.base.IBaseDao;
import com.believe.humanResource.po.Organazation;

public interface IOrganazationDao extends IBaseDao<Organazation>
{
	public List<Organazation> topOrganazationList() throws Exception ; 
}
