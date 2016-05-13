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
    <script src = "<%=basePath %>js/jquery-1.11.2.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>js/libs/modernizr.min.js"></script>
    <script type="text/javascript">
    function check()
    {
    	var name = $("#name").val() ; 

    	if(name == "")
    		{
    		alert("名称不能为空") ; 
    		return false ; 
    		}
    }
    
    </script>
</head>
<body>

<jsp:include page="../Home/home_top.jsp"></jsp:include>
 <jsp:include page="../Home/home_left.jsp"></jsp:include>

<div class="container clearfix">
    
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="organazationAction_update.action" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                       		 <s:hidden name = "organazation.id"></s:hidden>
                            <tr>
                                <th><i class="require-red">*</i>机构名称</th>
                                <td>
                                    <input id = "name" class="common-text required" id="title" name="organazation.name" size="50" value="${organazation.name}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>上级机构</th>
                                <td>
                                	<select class="common-text required" name = "parentID" style="width:440px;height:30px">
                                	<option value = "0">无</option>
                                	<s:iterator value="#organazationList">	
                                	<s:if test="%{#organazation.organazation.id==id}">
                                	<option value="${id}" selected="selected">${name}</option>
                                	</s:if>
                                	<s:else>
                                	<option value="${id}">${name}</option>
                                	</s:else>
                                	</s:iterator>
                                	
                                	</select>
                                   <!-- <input class="common-text required" id="title" name="organazation.password" size="50" value="" type="password">
                               		 --> 
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red"></i>描述</th>
                                <td>
                                <input type="text" name = "organazation.description" value = "${organazation.description}" size = "50"/>
                           
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" onclick = "return check()" value="提交" type="submit">
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