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
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="salaryStandardAction_add.action" method="post" id="myform" name="myform" >
             
                    <table class="insert-tab" width="100%">
                        <tbody>
                       		 <tr>
                                <th><i class="require-red"></i>薪酬标准名称</th>
                                <td>
                               	<input class="common-text required" id="title" name="salaryStandard.name" size="50" type="text">
                                </td>
                             </tr>
                             
                             <tr>
                                <th><i class="require-red"></i>制定人</th>
                                <td>
                               	<input class="common-text required" id="title" name="salaryStandard.maker" size="50" type="text">
                                </td>
                             </tr>
                             
                              <tr>
                                <th><i class="require-red"></i>请选择薪酬项目</th>
                                <td>
                               
                                </td>
                             </tr>
                             
                        <s:iterator value="salaryProjectList">
                       
                            <tr>
                                <th><i class="require-red"></i>${name}　${money}</th>
                                <td>
                                
                              
                                   <input class="common-text required" id="title" name="salaryProjectIDS" size="50" type="checkbox" value="${id}" >
                             
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