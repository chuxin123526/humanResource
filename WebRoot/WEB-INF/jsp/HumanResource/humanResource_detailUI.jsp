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
    
    </script>
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
            <form name="myform" action = "humanResourceAction_add.action" id="myform" method="post">
            <table >
            <tr>
       <td>　一级机构:　</td><td>
       <input type = "text" value = "${humanResource.organazation1.name}" disabled />
       </td>
   
       <td>　二级机构:　</td><td>
		<input type = "text" value = "${humanResource.organazation2.name}" disabled />
       </td>
       
        <td>　三级机构:　</td><td>
		<input type = "text" value = "${humanResource.organazation3.name}" disabled />
       </td>
    
       </tr>
       
       
       <tr>
        <td align="center">　职位分类:　</td><td>
		<input type = "text" value = "${humanResource.positionType.name}" disabled />
        </td>
        
        <td align="center">　职位:　</td><td>
		<input type = "text" value = "${humanResource.position.name}" disabled />
        </td>
        
         <td align="center">　职称:　</td><td>
		<input type = "text" value = "${humanResource.positionTitle.name}" disabled />
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　姓名:　</td><td>
		<input type = "text" value = "${humanResource.name}" disabled />
        </td>
        
        <td align="center">　性别:　</td><td>
		<input type = "text" value = "${humanResource.sex}" disabled />
        </td>
        
         <td align="center">　邮箱:　</td><td>
		<input type = "text" value = "${humanResource.email}" disabled />
        </td>
        
       </tr>
       
       
       
        <tr>
        <td align="center">　电话:　</td><td>
		<input type = "text" value = "${humanResource.phoneNumber}" disabled />
        </td>
        
        <td align="center">　QQ:　</td><td>
       <input type = "text" value = "${humanResource.qq}" disabled />
        </td>
        
         <td align="center">　手机:　</td><td>
		    <input type = "text" value = "${humanResource.mobilePhoneNumber}" disabled />
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　住址:　</td><td colspan="3" >
		<input  type = "text" value = "${humanResource.address}" style = "width : 97%" disabled /> 
        </td>
        
        <td align="center">　邮编:　</td><td >
		<input type = "text" value = "${humanResource.postCode}" disabled />
        </td>
  
       </tr>
       
       
       
        <tr>
        <td align="center">　国籍:　</td><td>
		<input type = "text" value = "${humanResource.country}" disabled />
        </td>
        
        <td align="center">　出生地:　</td><td>
		<input type = "text" value = "${humanResource.birthAddress}" disabled />
        </td>
        
         <td align="center">　生日:　</td><td>
         <input type = "text" value = "${humanResource.birthDate}" disabled />
        </td>
        
       </tr>
       
       
       
       
         <tr>
        <td align="center">　民族:　</td><td>
		<input type = "text" value = "${humanResource.nation}" disabled />
        </td>
        
        <td align="center">　宗教信仰:　</td><td>
        <input type = "text" value = "${humanResource.religion}" disabled  />
        </td>
        
         <td align="center">　政治面貌:　</td><td>
		<input type = "text" value = "${humanResource.political}" disabled  />
        </td>
        
       </tr>
       
       
       
       
       
         <tr>
        <td align="center">　身份证号码:　</td><td>
		<input type = "text" value = "${humanResource.identityCard}" disabled  />
        </td>
        
        <td align="center">　年龄:　</td><td>
		<input type = "text" value = "${humanResource.age}" disabled  />   
        </td>
        
         <td align="center">　学历:　</td><td>
		<input type = "text" value = "${humanResource.education}" disabled  />   
        </td>
        
       </tr>
       
       
       
       
       
       <tr>
        <td align="center">　专业:　</td><td>
		<input type = "text" value = "${humanResource.major}" disabled  />
        </td>
        
        <td align="center">　薪酬标准:　</td><td>
		<input type = "text" value = "${humanResource.salaryStandard.name}" disabled  />
        </td>
        
         <td align="center">　开户行:　</td><td>
		<input type = "text" value = "${humanResource.bank}" disabled  />
        </td>
        
       </tr>
       
       
       
       <tr>
        <td align="center">　账号:　</td><td>
		<input type = "text" value = "${humanResource.account}" disabled  />
        </td>
        
        <td align="center">　特长:　</td><td>
		<input type = "text" value = "${humanResource.speciality}" disabled  />
        </td>
        	
         <td align="center">　爱好:　</td><td>
		<input type = "text" value = "${humanResource.interest}" disabled  />
        </td>
        
       </tr>
       
       <tr>
       <td align = "center">个人履历:　</td><td colspan="5"><textarea disabled rows="3"  cols="107" >${humanResource.resume}</textarea></td>
       </tr>
       
       <tr>
       <td align = "center">家庭关系信息:　</td><td colspan="5"><textarea disabled rows="3"  cols="107" >${humanResource.familyRelationship}</textarea></td>
       </tr>
       
       <tr>
       <td align = "center">备注:　</td><td colspan="5"><textarea rows="3" disabled cols="107" >${humanResource.remark}</textarea></td>
       </tr>
       
        <tr>
       <td align = "center">审核意见:　</td><td colspan="5"><textarea disabled="disabled" rows="3" cols="107" name = "humanResource.approveIdea">${humanResource.approveIdea}</textarea></td>
       </tr>
				<tr>
                    <th></th>
                    <td>
                        <input class="btn btn-primary btn6 mr10" onclick="history.go(-1)" value="返回" type="button">
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