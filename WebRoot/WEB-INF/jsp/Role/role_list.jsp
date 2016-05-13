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
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<jsp:include page="../Home/home_top.jsp"></jsp:include>
 <jsp:include page="../Home/home_left.jsp"></jsp:include>
<div class="container clearfix">
    
    <!--/sidebar-->
    <div class="main-wrap">

       
        
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="roleAction_addUI.action"><i class="icon-font"></i>新增</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                         
                            <th>ID</th>
                            <th>角色名</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="#roleList">
                        <tr>
                           <td>${id}</td>
                           <td>${name}</td>
                            
                            <td>
                                <a href="roleAction_delete.action?role.id=${id}" onclick = "return confirm('确定要删除吗')">删除　</a>
                                <a  href="roleAction_updateUI.action?role.id=${id}">修改　</a>
                                <a  href="roleAction_distributePrivilegeUI.action?role.id=${id}">分配权限</a>
                            </td>
                        </tr>
                        </s:iterator>           
                    </table>
                    <div class="list-page"> 
					<s:iterator begin="1" end="#page.pageCount" var="p">
					<s:if test="#p == #page.requestPage">
					${p}
					</s:if>
					<s:else>
					<a href = "roleAction_list.action?requestPage=${p}">${p}</a>
					</s:else>
					</s:iterator>

					</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>