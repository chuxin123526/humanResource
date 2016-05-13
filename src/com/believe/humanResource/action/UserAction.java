package com.believe.humanResource.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.po.User;
import com.believe.humanResource.service.IRoleService;
import com.believe.humanResource.service.IUserService;
import com.believe.humanResource.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.DigestMD5;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport
{
	private User user ; 
	
	@Resource
	private IUserService userServiceImpl ; 
	
	@Resource
	private IRoleService roleServiceImpl ; 
	
	private int[] roleIDS ; 
	
	private int requestPage ;
	
	public String loginUI() throws Exception
	{
		ActionContext.getContext().getSession().put("user", this.user) ; 
		return "loginUI" ; 
	}
	
	public String login() throws Exception
	{
		this.user = this.userServiceImpl.loginCheck(this.user) ; 

		if(user != null)
		{
			//登录成功,跳转到首页
			ActionContext.getContext().getSession().put("loginUser", this.user) ;
			
			//拿到用户所拥有的权限
			List<Privilege> userPrivilegeList = this.userServiceImpl.userPrivilegeList(this.user) ; 
			ActionContext.getContext().getSession().put("userPrivilegeList", userPrivilegeList) ;
			
			return "home" ; 
		}
		else
		{
			//登录失败，返回到登录页面
			return "loginUI" ;
		}
	}
	
	public String list() throws Exception
	{	
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
		List<User> userList = this.userServiceImpl.pageList(page) ;  

		ActionContext.getContext().put("page", page);
		
		ActionContext.getContext().put("userList", userList) ;
			
		return "list" ; 
	}
	
	
	public String addUI() throws Exception
	{	
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		String password = DigestUtils.md5Hex(user.getPassword()) ;
		this.user.setPassword(password);
		this.userServiceImpl.add(user);
		
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.userServiceImpl.delete(user.getId()) ;
		
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		this.user = this.userServiceImpl.getById(user.getId()) ;
		
		return "updateUI" ; 
	}
	
	public String update() throws Exception
	{
		this.userServiceImpl.update(user); 

		return "toList" ; 
	}
	
	public String initPassword() throws Exception
	{
		this.userServiceImpl.initPassword(user);
		return "toList" ;
	}
	
	public String distributeRoleUI() throws Exception
	{
		//拿到所有的角色
		List<Role> roleList = this.roleServiceImpl.list() ; 
		ActionContext.getContext().put("roleList", roleList);
		
		//拿到用户
		this.user = this.userServiceImpl.getById(this.user.getId()) ; 
		ActionContext.getContext().put("user", this.user);
		
		return "distributeRoleUI" ; 
	}
	
	public String distributeRole() throws Exception
	{
		Set<Role> roleSet = new HashSet<Role>() ; 
		if(this.roleIDS != null)
		{
			for(int id :this.roleIDS)
			{
				Role role = this.roleServiceImpl.getById(id) ; 
				roleSet.add(role) ; 
			}
		}

		this.user.setRoles(roleSet);
		
		//分配角色
		this.userServiceImpl.distributeRole(this.user);
		
		return "toList" ; 
	}
	
	public String updatePasswordUI() throws Exception
	{
		return "updatePasswordUI" ;
	}
	
	public String updatePassword() throws Exception
	{
		User loginUser =(User)ActionContext.getContext().getSession().get("loginUser") ; 
		loginUser.setPassword(DigestUtils.md5Hex(this.user.getPassword()));
		
		return "toList" ;
	}
	
	public String logout() throws Exception
	{
		ActionContext.getContext().getSession().put("user", null) ; 
		
		return "loginUI" ;
	}

	
	public IUserService getUserServiceImpl()
	{
		return userServiceImpl;
	}


	public void setUserServiceImpl(IUserService userServiceImpl)
	{
		this.userServiceImpl = userServiceImpl;
	}


	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public IRoleService getRoleServiceImpl()
	{
		return roleServiceImpl;
	}

	public void setRoleServiceImpl(IRoleService roleServiceImpl)
	{
		this.roleServiceImpl = roleServiceImpl;
	}

	public int[] getRoleIDS()
	{
		return roleIDS;
	}

	public void setRoleIDS(int[] roleIDS)
	{
		this.roleIDS = roleIDS;
	}

	public int getRequestPage()
	{
		return requestPage;
	}

	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	}



}
