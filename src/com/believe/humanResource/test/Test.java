package com.believe.humanResource.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import antlr.CppCodeGenerator;

import com.believe.humanResource.dao.IPrivilegeDao;
import com.believe.humanResource.dao.impl.PrivilegeDaoImpl;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.IUserService;
import com.believe.humanResource.service.impl.UserServiceImpl;

public class Test
{
	public static void main(String[] args)
	{
		
	}
	
	@org.junit.Test
	public void test() throws Exception
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		SessionFactory sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory") ; 
		Session session = sessionFactory.openSession() ;
		User user = new User() ; 
		user.setName("believe");
		user.setPassword(DigestUtils.md5Hex("000000"));
		session.save(user) ;
		
	}
	
	
	
	
	
	
	
	
	
	@org.junit.Test
	public void addPrivilege() throws Exception
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		SessionFactory sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory") ; 
		Session session = sessionFactory.openSession() ; 
		
		IPrivilegeDao privilegeDaoImpl =(PrivilegeDaoImpl) applicationContext.getBean("privilegeDaoImpl") ; 
		Privilege privilege = new Privilege() ; 
		privilege.setName("用户管理");
		privilege.setUrl("userAction");
		
		Privilege privilege2 = new Privilege() ; 
		privilege2.setName("角色管理");
		privilege2.setUrl("roleAction");
		
		Privilege privilege3 = new Privilege() ; 
		privilege3.setName("机构管理");
		privilege3.setUrl("organazationAction");
		
		Privilege privilege4 = new Privilege() ; 
		privilege4.setName("职位类型管理");
		privilege4.setUrl("positionTypeAction");
		
		Privilege privilege5 = new Privilege() ;
		privilege5.setName("职位管理");
		privilege5.setUrl("positionAction");
		
		Privilege privilege6 = new Privilege() ; 
		privilege6.setName("职称管理");
		privilege6.setUrl("positionTitleAction");
		
		Privilege privilege7 = new Privilege() ; 
		privilege7.setName("人力资源管理");
		privilege7.setUrl("humanResourceAction");
		
		Privilege privilege8 = new Privilege();
		privilege8.setName("人力资源审核 ");
		privilege8.setUrl("humanResourceApproveAction");
		
		Privilege privilege9 = new Privilege() ; 
		privilege9.setName("薪酬项目管理");
		privilege9.setUrl("salaryProjectAction");
		
		Privilege privilege10 = new Privilege() ; 
		privilege10.setName("薪酬标准管理");
		privilege10.setUrl("salaryStandardAction");
		
		Privilege privilege11 = new Privilege() ; 
		privilege11.setName("薪酬标准审核");
		privilege11.setUrl("salaryStandardApproveAction");
		
		Privilege privilege12 = new Privilege() ; 
		privilege12.setName("薪酬发放管理");
		privilege12.setUrl("salaryAction");
		
		Privilege privilege13 = new Privilege() ; 
		privilege13.setName("薪酬发放审核");
		privilege13.setUrl("salaryApproveAction");
		
		session.save(privilege13);
		session.save(privilege12);
		session.save(privilege11);
		session.save(privilege10);
		session.save(privilege9);
		session.save(privilege8);
		session.save(privilege7);
		session.save(privilege6);
		session.save(privilege5);
		session.save(privilege4);
		session.save(privilege3);
		session.save(privilege2);
		session.save(privilege);
		
		
	}
}
