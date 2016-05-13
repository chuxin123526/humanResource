package com.believe.humanResource.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.service.IPrivilegeService;
import com.believe.humanResource.service.impl.PrivilegeServiceImpl;

public class InitPrivilegeListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent context)
	{
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(context.getServletContext()) ; 
		IPrivilegeService privilegeServiceImpl =(IPrivilegeService) applicationContext
				.getBean("privilegeServiceImpl") ; 
		try
		{
			List<Privilege> privilegeList = privilegeServiceImpl.list() ; 
			context.getServletContext().setAttribute("privilegeList", privilegeList);
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("初始化权限失败");
		}
		
	}

}
