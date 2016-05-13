<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src = "<%=basePath %>js/jquery-1.11.2.js"></script>

  </head>
  
  <script type="text/javascript">
  
  function takeOrganazation()
  {
	  var a = $("#organazation1").find("option:selected").val() ;
	  $("#organazation2").load("testAction1.action",{'organazation.id':a}) ; 
  }
  
  
  </script>
  
  
  <body>
  
	<form action = "testAction.action">
	<table>
	 <tr>
       <td>　一级机构:　</td><td>
       <select id = "organazation1" name = "organazationID" style = "width:188px" onchange="takeOrganazation()">
      	 <option value = "${id}">无</option>
       <s:iterator value = "topOrganazationList">
       <option value = "${id}">${name}</option>
       </s:iterator>     
       </select>
       </td>
   
       <td>　二级机构:　</td><td>
		<select name = "organazation2ID" id = "organazation2" style = "width:188px">
            
       </select>
       </td>
       
        <td>　三级机构:　</td><td>
		<select name = "organazation3ID" style = "width:188px">
       <option>1</option>
       <option>1</option>
       <option>1</option>       
       </select>
       </td>
    
       </tr>
	</table>
	</form>   
  </body>
</html>
