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
                        <a href="humanResourceAction_addUI.action"><i class="icon-font"></i>新增</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                         
                            <th>档案编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>一级机构</th>
                            <th>二级机构</th>
                            <th>三级机构</th>
                            <th>职位名称</th>
                            <th>状态</th>
                            <th>操作</th>
                            
                        </tr>
          
                        <s:iterator value="#humanResourceUnApproveList">
                        <tr>
                           <td>${number}</td>
                           <td>${name}</td>
                           <td>${sex}</td>
                           <td>${organazation1.name}</td>
                           <td>${organazation2.name}</td>
                           <td>${organazation3.name}</td>
                           <td>${position.name}</td>
                           <td>${status}</td>
                            <td>
                                
                                <a href="humanResourceApproveAction_approveUI.action?humanResource.id=${id}" >审核　</a>
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
					<a href = "humanResourceApproveAction_list.action?requestPage=${p}">${p}</a>
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