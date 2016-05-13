<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<sx:head debug="true" cache="false" compressed="false" />
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
    <script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript">
    function takeChildOrganazationList1()
	{
		var organazationID = $("#organazation1").find("option:selected").val()	; 
		$("#organazation2").load("humanResourceAction_takeChildOrganazationList.action" , {'organazation.id':organazationID}) ;
	}
	
	function takeChildOrganazationList2()
	{
		var organazationID = $("#organazation2").find("option:selected").val()	; 
		$("#organazation3").load("humanResourceAction_takeChildOrganazationList.action" , {'organazation.id':organazationID}) ;
	}
	
	function takePositionList()
	{
		var positionTypeID = $("#positionType").find("option:selected").val()	; 
		$("#position").load("humanResourceAction_takePositionList.action" , {'positionType.id':positionTypeID}) ;
	}
	
	function takePositionTitleList()
	{
		var positionID = $("#position").find("option:selected").val()	; 
		$("#positionTitle").load("humanResourceAction_takePositionTitleList.action" , {'position.id':positionID}) ;
	}
	
	function check()
	{
		var organazation1 = $("#organazation1").val() ; 
	
		if(organazation1 == "0" )
		{
				alert("请选择一级机构") ; 
				return false ; 
		}
		if($("#organazation2").val() == "0")
			{
				alert("请选择二级机构") ; 
				return false ; 
			}
		if($("#organazation3").val() == "0")
		{
			alert("请选择三级机构") ; 
			return false ; 
		}
		if($("#positionType").val() == "0")
		{
			alert("请选择职位类型") ; 
			return false ; 
		}
		if($("#position").val() == "0")
		{
			alert("请选择职位") ; 
			return false ; 
		}
		if($("#positionTitle").val() == "0")
		{
			alert("请选择职称") ; 
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span>
            <span class="crumb-name"><a href = "#">人力资源管理</a>&gt;人力资源登记</span></div>
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
            <form name="myform" action = "humanResourceAction_add.action" id="myform" method="post">
            <table >
            <tr>
       <td>　一级机构:　</td><td>
       <select name = "organazation1ID" id = "organazation1" style = "width:188px" onchange="takeChildOrganazationList1()">
		<option value = "0">请选择</option>
       <s:iterator value = "topOrganazationList">
       <option value = "${id}">${name}</option>
       </s:iterator>
       </select>
       </td>
   
       <td>　二级机构:　</td><td>     
		<select name = "organazation2ID" id = "organazation2" style = "width:188px" onchange="takeChildOrganazationList2()">
        
       </select>
       </td>
       
        <td>　三级机构:　</td><td>
		<select name = "organazation3ID" id = "organazation3" style = "width:188px">
           
       </select>
       </td>
    
       </tr>
       
       
       <tr>
        <td align="center">　职位分类:　</td><td>
		<select name = "positionTypeID" id = "positionType" style = "width:188px" onchange="takePositionList()">
		<option value = "0">请选择</option>
       <s:iterator value = "positionTypeList">
       <option value  = "${id}">${name}</option>
       </s:iterator>
       </select>
        </td>
        
        <td align="center">　职位:　</td><td>
		<select name = "positionID" id = "position" style = "width:188px" onchange="takePositionTitleList()">
           
       </select>
        </td>
        
         <td align="center">　职称:　</td><td>
		<select name = "positionTitleID" id = "positionTitle" style = "width:188px">
            
       </select>
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　姓名:　</td><td>
		<input type = 'text' name = "humanResource.name" />
        </td>
        
        <td align="center">　性别:　</td><td>
		<select name = "humanResource.sex" style = "width:188px">
       <option value = "男">男</option>
       <option value = "女">女</option>
       </select>
        </td>
        
         <td align="center">　邮箱:　</td><td>
		<input type = "email" name = "humanResource.email" />
        </td>
        
       </tr>
       
       
       
        <tr>
        <td align="center">　电话:　</td><td>
		<input type ="text" name = "humanResource.phoneNumber" />
        </td>
        
        <td align="center">　QQ:　</td><td>
       <input type  = "text" name = "humanResource.qq" />
        </td>
        
         <td align="center">　手机:　</td><td>
		    <input type = "text" name = "humanResource.mobilePhoneNumber" />
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　住址:　</td><td colspan="3" >
		<input  type = "text" name = "humanResource.address" style = "width:100%" /> 
        </td>
        
        <td align="center">　邮编:　</td><td >
		<input type = "text" name = "humanResource.postCode" />
        </td>
  
       </tr>
       
       
       
        <tr>
        <td align="center">　国籍:　</td><td>
		<select name = "humanResource.country" style = "width:188px">
       <option value = "中国">中国</option>
       <option value = "荷兰">荷兰</option>
       <option value = "英国">英国</option>       
       </select>
        </td>
        
        <td align="center">　出生地:　</td><td>
		<input type = "text" name = "humanResource.birthAddress" />
        </td>
        
         <td align="center">　生日:　</td><td>
         <sx:datetimepicker name="humanResource.birthDate" displayFormat="yyyy-MM-dd" cssStyle = "width:90%"  />
        </td>
        
       </tr>
       
       
       
       
         <tr>
        <td align="center">　民族:　</td><td>
		<select name = "humanResource.nation" style = "width:188px">
       <option value = "汉族">汉族</option>
       <option value = "苗族">苗族</option>
       <option value = "维吾尔族">维吾尔族</option>       
       </select>
        </td>
        
        <td align="center">　宗教信仰:　</td><td>
		<select name = "humanResource.religion" style = "width:188px">
       <option value="">无</option>
       <option value="基督教">基督教</option>
       <option value="佛教">佛教</option>
       <option value="伊斯兰教">伊斯兰教</option>       
       </select>
        </td>
        
         <td align="center">　政治面貌:　</td><td>
		<select name = "humanResource.political" style = "width:188px">
       <option value = "无">无</option>
       <option value = "党员">党员</option>
       <option value = "团员">团员</option>    
       </select>
        </td>
        
       </tr>
       
       
       
       
       
         <tr>
        <td align="center">　身份证号码:　</td><td>
		<input type = "text" name = "humanResource.identityCard" />
        </td>
        
        <td align="center">　年龄:　</td><td>
		<input name = "humanResource.age" type = "text" />      
        </td>
        
         <td align="center">　学历:　</td><td>
		<select name = "humanResource.education" style = "width:188px">
       <option value = "幼儿园">幼儿园</option>
       <option value = "小学">小学</option>
       <option value = "初中">初中</option>
       <option value = "高中">高中</option>       
       <option value = "专科">专科</option>       
       <option value = "本科" selected = "selected">本科</option>       
       <option value = "研究生">研究生</option>       
       <option value = "博士">博士</option>       
       <option value = "博士后">博士后</option>       
       </select>
        </td>
        
       </tr>
       
       
       
       
       
       <tr>
        <td align="center">　专业:　</td><td>
		<select name = "humanResource.major" style = "width:188px">
       <option value = "社会学">社会学</option>
       <option value = "制药工程">制药工程</option>
       <option value = "神经科学">神经科学</option>       
       </select>
        </td>
        
        <td align="center">　薪酬标准:　</td><td>
		<select name = "salaryStandardID" style = "width:188px">
        
        <s:iterator value = "salaryStandardList">
        <option value = "${id}">${name}</option>
        </s:iterator>
        
       </select>
        </td>
        
         <td align="center">　开户行:　</td><td>
		<select name = "humanResource.bank" style = "width:188px">
       <option value = "中国建设银行">中国建设银行</option>
       <option value = "中国工商银行">中国工商银行</option>
       <option value = "中国农业银行">中国农业银行</option>       
       <option value = "中国银行">中国银行</option>       
       </select>
        </td>
        
       </tr>
       
       
       
       <tr>
        <td align="center">　账号:　</td><td>
		<input type = "text" name = "humanResource.account" />
        </td>
        
        <td align="center">　特长:　</td><td>
		<input type = "text" name = "humanResource.speciality"  />
        </td>
        	
         <td align="center">　爱好:　</td><td>
		<input type = "text" name = "humanResource.interest" />
        </td>
        
       </tr>
       
       <tr>
       <td align = "center">个人履历:　</td><td colspan="5"><textarea  rows="3"  cols="107" name = "humanResource.resume"></textarea></td>
       </tr>
       
       <tr>
       <td align = "center">家庭关系信息:　</td><td colspan="5"><textarea rows="3"  cols="107" name = "humanResource.familyRelationship"></textarea></td>
       </tr>
       
       <tr>
       <td align = "center">备注:　</td><td colspan="5"><textarea rows="3" cols="107" name = "humanResource.remark"></textarea></td>
       </tr>
       
       
				<tr>
                    <th></th>
                    <td>
                        <input class="btn btn-primary btn6 mr10" value="提交" type="submit" onclick = "return check()">
                        <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                    </td>
                </tr>
       
       
       </table>
                <div class="result-title">
                    <div class="result-list">
                    </div>
                </div>
                
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>