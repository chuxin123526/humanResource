package com.believe.humanResource.intercepter;

import java.util.Set;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.po.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivilegeInterceptor extends AbstractInterceptor
{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
//		test
//		String name = invocation.getProxy().getActionName() ; 
//		System.out.println(invocation.getProxy().getActionName());
//		int index = name.indexOf("_") ; 
//		String actionName = name.substring(0, index) ; 
//		System.out.println(actionName);
		
		
		String actionName = invocation.getProxy().getActionName() ; 
		int index = actionName.indexOf("_") ; 
		String privilegeActionName = actionName.substring(0 , index) ; 
		
		User user1 = (User) invocation.getInvocationContext().getSession().get("loginUser") ; 
		if(user1 != null && user1.getName().equals("believe")) 
		{
			return invocation.invoke() ; 
		}
		
		//判断该用户是否有权限
		
		//如果不是需要控制的权限
		if(actionName.equals("userAction_login") || actionName.equals("homeAction_home")
				||actionName.equals("userAction_updatePasswordUI") || actionName.equals("userAction_updatePassword")
				||actionName.equals("userAction_logout")
				)
		{
			return invocation.invoke() ; 
		}
		else
		{
			boolean exit_2 = false ; 
			boolean hasPrivilege = false ; 
			
			User user = (User)invocation.getInvocationContext().getSession().get("loginUser") ; 
			if(user == null)
			{
				return "loginUI" ;
			}
			else
			{
				Set<Role> roles = user.getRoles() ; 
				//遍历每一个用户所拥有的角色
				for(Role role : roles)
				{
					//遍历角色所拥有的权限
					Set<Privilege> privileges = role.getPrivileges() ; 
					for(Privilege privilege : privileges)
					{
						if(privilegeActionName.equals(privilege.getUrl()))
						{
							hasPrivilege = true ; 
							exit_2 = true ; 
							break ; 
						}
					}
					if(exit_2)
					{
						break ;
					}
				}
			}
			
			if(user.getName().equals("believe"))
			{
				return invocation.invoke() ;
			}
			if(hasPrivilege)
			{
				//有权限
				return invocation.invoke() ;
			}
			else
			{
				//没权限
				return "loginUI" ;
			}
		}
	}

}
