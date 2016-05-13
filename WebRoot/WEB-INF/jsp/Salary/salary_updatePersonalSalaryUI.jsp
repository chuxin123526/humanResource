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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="salaryAction_updatePersonalSalary.action" method="post" id="myform" name="myform" >
                <s:hidden name = "salary.id"></s:hidden>
                <s:hidden name = "salaryPersonal.id"></s:hidden>
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>姓名</th>
                                <td>
                                    <input class="common-text required" disabled="disabled" id="title" name="salaryPersonal.humanResource.name" size="50" value="${salaryPersonal.humanResource.name}" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>工资</th>
                                <td>
                                    <input class="common-text required" disabled="disabled" id="title" name="salaryPersonal.humanResource.salaryStandard.money" size="50" value="${salaryPersonal.humanResource.salaryStandard.money }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>应扣奖金</th>
                                <td>
                                    <input class="common-text required" id="title" name="salaryPersonal.deduct" size="50" value="${salaryPersonal.deduct}" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>奖励奖金</th>
                                <td>
                                    <input class="common-text required" id="title" name="salaryPersonal.reward" size="50" value="${salaryPersonal.reward}" type="text">
                                </td>
                            </tr>
                            
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