<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>js/libs/modernizr.min.js"></script>
</head>
<body>
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h3>菜单</h3>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                <li>
                    <ul class="sub-menu">
                    <s:if test="#session.loginUser.name == 'believe'">
                   		 <li><a href="userAction_list.action"><i class="icon-font">&#xe005;</i>用户管理</a></li>
                        <li><a href="roleAction_list.action"><i class="icon-font">&#xe005;</i>角色管理</a></li>
                        <li><a href="organazationAction_list.action"><i class="icon-font">&#xe005;</i>机构管理</a></li>
                        <li><a href="positionTypeAction_list.action"><i class="icon-font">&#xe005;</i>职位类型管理</a></li>
                        <li><a href="positionAction_list.action"><i class="icon-font">&#xe005;</i>职位管理</a></li>
                        <li><a href="positionTitleAction_list.action"><i class="icon-font">&#xe005;</i>职称管理</a></li>
                        <li><a href="humanResourceAction_list.action"><i class="icon-font">&#xe005;</i>人力资源管理</a></li>
                        <li><a href="humanResourceApproveAction_list.action"><i class="icon-font">&#xe005;</i>人力资源审核</a></li>
                        <li><a href="salaryProjectAction_list.action"><i class="icon-font">&#xe005;</i>薪酬项目管理</a></li>
                        <li><a href="salaryStandardAction_list.action"><i class="icon-font">&#xe005;</i>薪酬标准管理</a></li>
                        <li><a href="salaryStandardApproveAction_list.action"><i class="icon-font">&#xe005;</i>薪酬标准审核</a></li>
                        <li><a href="salaryAction_list.action"><i class="icon-font">&#xe005;</i>薪酬发放管理</a></li>
                        <li><a href="salaryApproveAction_list.action"><i class="icon-font">&#xe005;</i>薪酬发放审核</a></li>
                    </s:if>
                    <s:elseif test="#session.userPrivilegeList != null">
						<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='userAction'">
                  	    		<li><a href="userAction_list.action"><i class="icon-font">&#xe005;</i>用户管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='roleAction'">
                  	    		<li><a href="roleAction_list.action"><i class="icon-font">&#xe008;</i>角色管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      <s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='organazationAction'">
                  	    		<li><a href="organazationAction_list.action"><i class="icon-font">&#xe008;</i>机构管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='positionTypeAction'">
                  	    		<li><a href="positionTypeAction_list.action"><i class="icon-font">&#xe008;</i>职位类型管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='positionAction'">
                  	    		<li><a href="positionAction_list.action"><i class="icon-font">&#xe008;</i>职位管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='positionTitleAction'">
                  	    		<li><a href="positionTitleAction_list.action"><i class="icon-font">&#xe008;</i>职称管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='humanResourceAction'">
                  	    		<li><a href="humanResourceAction_list.action"><i class="icon-font">&#xe008;</i>人力资源管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='humanResourceApproveAction'">
                  	    		<li><a href="humanResourceApproveAction_list.action"><i class="icon-font">&#xe008;</i>人力资源审核</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      <s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='salaryProjectAction'">
                  	    		<li><a href="salaryProjectAction_list.action"><i class="icon-font">&#xe008;</i>薪酬项目管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='salaryStandardAction'">
                  	    		<li><a href="salaryStandardAction_list.action"><i class="icon-font">&#xe008;</i>薪酬标准管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='salaryStandardApproveAction'">
                  	    		<li><a href="salaryStandardApproveAction_list.action"><i class="icon-font">&#xe008;</i>薪酬标准审核</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      <s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='salaryAction'">
                  	    		<li><a href="salaryAction_list.action"><i class="icon-font">&#xe008;</i>薪酬发放管理</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                      	<s:iterator value="#session.userPrivilegeList">
							<s:if test="url=='salaryApproveAction'">
                  	    		<li><a href="salaryApproveAction_list.action"><i class="icon-font">&#xe008;</i>薪酬发放审核</a></li>
                  	    	</s:if>
                      	</s:iterator>
                      	
                    </s:elseif>
                    </ul>
                </li>  
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>

</body>
</html>
