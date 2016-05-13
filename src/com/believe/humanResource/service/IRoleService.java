package com.believe.humanResource.service;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.Role;

public interface IRoleService extends IBaseService<Role>
{
	public void distributePrivilege(Role role) throws Exception ;  
}
