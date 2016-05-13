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
            <form name="myform" id="myform" method="post">
            <table >
            <tr>
       <td>　薪酬标准标号:　</td><td><input type = "text" value = "${salaryStandard.id}" disabled /></td>
       <td>　薪酬标准名称:　</td><td><input type = "text" name = "" value = "${salaryStandard.name}" disabled /></td>
       <td>　薪酬总额:　</td><td><input type = "text" name = "" value = "${salaryStandard.money}" disabled /></td>
       </tr>
       <tr>
        <td align="center">　制定人:　</td><td><input type = "text" name = "" value = "${salaryStandard.maker}" disabled /></td>
   		 <td align="center">　登记人:　</td><td><input type = "text" name = "" value = "${salaryStandard.user.name}" disabled /></td>
      	 <td>　登记时间:　</td><td><input type = "text" name = "" value = "${salaryStandard.addTime}" disabled /></td>
       </tr>
       <tr>
       <td align = "center">审核意见:　</td><td colspan="5"><textarea rows="5" disabled cols="101" name = "salaryStandard.approveIdea">${salaryStandard.approveIdea }</textarea></td>
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
                            <th>薪酬项目名称</th>
                            <th>金额</th>
                            
                        </tr>
          
                        <s:iterator value="salaryStandard.salaryProjects">
                        <tr>
                           <td>${id}</td>
                           <td>${name}</td>
                           <td>${money}</td>
                        </tr>
                        </s:iterator>        
                        
                    </table>
                    <div class="list-page"><input class="btn btn-primary btn6 mr10" onclick="history.go(-1)" value="返回" type="button"></div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>