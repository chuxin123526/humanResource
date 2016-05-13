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

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>正在为${role.name}分配权限</div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="roleAction_distributePrivilege.action" method="post" id="myform" name="myform" >
                <s:hidden name="role.id"></s:hidden>
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <s:iterator value="privilegeList">
                        <s:set name = "privilege_id" value = "id"></s:set>
                            <tr>
                                <th><i class="require-red"></i>${name}</th>
                                <td>
                                <s:iterator value = "role.privileges">
                                	<s:if test="id == #privilege_id">
                                	<s:set name = "flag" value = "1"></s:set>
                                	</s:if>
                                 </s:iterator>
                                 
                                 <s:if test="#flag == 1">
                                 <s:set name = "flag" value = "0"></s:set>
                                   <input class="common-text required" checked="checked" id="title" name="privilegeIDS" size="50" type="checkbox" value="${id}" >
                                 </s:if>
                                 <s:else>
                                   <input class="common-text required" id="title" name="privilegeIDS" size="50" type="checkbox" value="${id}" >
                                 </s:else>
                                </td>
                            </tr>
                            </s:iterator>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>