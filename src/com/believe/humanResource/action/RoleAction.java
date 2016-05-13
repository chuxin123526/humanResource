package com.believe.humanResource.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.humanResource.dao.IPrivilegeDao;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.po.PositionType;
import com.believe.humanResource.po.Privilege;
import com.believe.humanResource.po.Role;
import com.believe.humanResource.service.IPrivilegeService;
import com.believe.humanResource.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport
{
	@Resource
	private IRoleService roleServiceImpl ;
	
	@Resource
	private IPrivilegeService privilegeServiceImpl ; 
	
	private Role role ; 
	
	private int [] privilegeIDS ; 
	
	private int requestPage ; 
	
	public String distributePrivilegeUI() throws Exception
	{
		this.role = this.roleServiceImpl.getById(role.getId()) ; 
		
		//拿到所有权限
		List<Privilege> privilegeList = this.privilegeServiceImpl.list() ; 
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "distributePrivilegeUI" ; 
	}
	
	public String distributePrivilege() throws Exception
	{
		//构造一个set集合
		Set<Privilege> privilegeSet = new HashSet<Privilege>() ; 
		
		for(int id : this.privilegeIDS)
		{
			Privilege privilege1 = this.privilegeServiceImpl.getById(id) ; 
			privilegeSet.add(privilege1) ;
		}
		
		this.role.setPrivileges(privilegeSet);
		
		this.roleServiceImpl.distributePrivilege(this.role) ;
		
		return "toList" ;
	}
	
	public String list() throws Exception
	{
		Page page = new Page() ; 
		if(this.requestPage !=0)
		{
			page.setRequestPage(this.requestPage);
		}
	
		List<Role> roleList = this.roleServiceImpl.pageList(page) ;

		ActionContext.getContext().put("page", page);
		
		ActionContext.getContext().put("roleList", roleList);
		
		return "list" ;
	}
	
	public String addUI() throws Exception
	{
		return "addUI" ;
	}
	
	public String add() throws Exception
	{
		this.roleServiceImpl.add(role);
		return "toList" ;
	}
	
	public String delete() throws Exception
	{
		this.roleServiceImpl.delete(role.getId());
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{
		role = this.roleServiceImpl.getById(role.getId()) ;
		
		return "updateUI" ;
	}
	
	public String update() throws Exception
	{
		this.roleServiceImpl.update(role);
		
		return "toList" ;
	}
	
	
	

	public IRoleService getRoleServiceImpl()
	{
		return roleServiceImpl;
	}

	public void setRoleServiceImpl(IRoleService roleServiceImpl)
	{
		this.roleServiceImpl = roleServiceImpl;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public int[] getPrivilegeIDS()
	{
		return privilegeIDS;
	}

	public void setPrivilegeIDS(int[] privilegeIDS)
	{
		this.privilegeIDS = privilegeIDS;
	}

	public IPrivilegeService getPrivilegeServiceImpl()
	{
		return privilegeServiceImpl;
	}

	public void setPrivilegeServiceImpl(IPrivilegeService privilegeServiceImpl)
	{
		this.privilegeServiceImpl = privilegeServiceImpl;
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
