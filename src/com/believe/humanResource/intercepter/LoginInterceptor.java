package com.believe.humanResource.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor
{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		String actionName = invocation.getProxy().getActionName() ; 
		if(actionName.equals("userAction_login") )
		{
			return invocation.invoke() ;
		}
		else
		{
			if(invocation.getInvocationContext().getSession().get("loginUser")!=null)
			{
				return invocation.invoke() ; 
			}
			else
			{
				return "loginUI" ;
			}
		}
	}

}
