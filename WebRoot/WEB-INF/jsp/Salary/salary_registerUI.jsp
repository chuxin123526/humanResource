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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" action = "salaryAction_register.action" method="post">
            <s:hidden name = "salary.id"></s:hidden>
            <table >
            <tr>
       <td>　薪酬发放编号:　</td><td><input type = "text" value = "${salary.id}" disabled /></td>
       <td>　机构:　</td><td><input type = "text" name = "" value = "${salary.organazation.organazation.organazation.name}/${salary.organazation.organazation.name}/${salary.organazation.name}" disabled /></td>
       <td>　总人数:　</td><td><input type = "text" name = "" value = "${salary.count}" disabled /></td>
       </tr>
       <tr>
        <td align="center">　总额:　</td><td><input type = "text" name = "" value = "${salary.account}" disabled /></td>
      	 <td>　登记时间:　</td><td><input type = "text" name = "" value = "${salary.registerTime}" disabled /></td>
       </tr>
       
       </table>
                <div class="result-title">
                    <div class="result-list">
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                         
                            <th>ID</th>
                            <th>姓名</th>
                            <th>工资</th>
                            <th>应扣奖金</th>
                            <th>奖励奖金</th>
                            <th>操作</th>
                            
                        </tr>
          
                        <s:iterator value="salary.salaryPersonals">
                        <tr>
                           <td>${humanResource.id}</td>
                           <td>${humanResource.name}</td>
                           <td>${humanResource.salaryStandard.money}</td>
                           <td>${deduct}</td>
                           <td>${reward}</td>
                           
                           <td>
                           <a href="salaryAction_updatePersonalSalaryUI.action?salary.id=${salary.id}&salaryPersonal.id=${id}">修改　</a>
                           
                           </td>
                        </tr>
                        </s:iterator>        
                        
                    </table>
                    <div class="list-page">
                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                   	<input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                   </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>