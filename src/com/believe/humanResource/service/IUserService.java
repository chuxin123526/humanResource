package com.believe.humanResource.service;

import java.util.List;

import com.believe.humanResource.base.IBaseService;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.User;

public interface IUserService extends IBaseService<User>
{
	public void initPassword(User user) throws Exception ;
	public User loginCheck(User user) throws Exception ; 
	public void distributeRole(User user) throws Exception ; 
	public List<Privilege> userPrivilegeList(User user) throws Exception ;  
}
