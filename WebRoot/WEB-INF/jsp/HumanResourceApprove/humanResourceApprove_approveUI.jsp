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
            <form name="myform" action = "humanResourceApproveAction_approve.action" id="myform" method="post">
            <s:hidden name = "humanResource.id"></s:hidden>
            <table >
            <tr>
       <td>　一级机构:　</td><td>
      	 <input type = "text" disabled="disabled"   value = "${humanResource.organazation1.name}" />
       </td>
   
       <td>　二级机构:　</td><td>
		 <input type = "text" disabled="disabled" value = "${humanResource.organazation2.name}" />
       </td>
       
        <td>　三级机构:　</td><td>
		 <input type = "text" disabled="disabled"  value = "${humanResource.organazation3.name}" />
       </td>
    
       </tr>
       
       
       <tr>
        <td align="center">　职位分类:　</td><td>
		 <input type = "text" disabled="disabled" value = "${humanResource.positionType.name}" />
        </td>
        
        <td align="center">　职位:　</td><td>
            <input type = "text" disabled="disabled"   value = "${humanResource.position.name}" />
        </td>
        
         <td align="center">　职称:　</td><td>
		<select name = "positionTitleID" id = "positionTitle" style = "width:188px">
           <s:iterator value="humanResource.position.positionTitles">
           <s:if test="id == humanResource.positionTitle.id">
           <option selected="selected" value = "${id}">${name}</option>
           </s:if>
           <s:else>
           <option  value = "${id}">${name}</option>
           </s:else>
           </s:iterator>
       </select>
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　姓名:　</td><td>
		<input type = 'text' name = "humanResource.name" value = "${humanResource.name}" />
        </td>
        
        <td align="center">　性别:　</td><td>
		<select name = "humanResource.sex" style = "width:188px">
		
		<s:if test='humanResource.sex == "男"'>
		<option value = "男" selected="selected">男</option>
		</s:if>
       <s:else>
       <option value = "男">男</option>
       </s:else>
       <s:if test='humanResource.sex=="女"'>
       <option value = "女" selected="selected">女</option>
       </s:if>
       <s:else>
        <option  value = "女">女</option>
       </s:else>
       </select>
        </td>
        
         <td align="center">　邮箱:　</td><td>
		<input type = "email" name = "humanResource.email" value = "${humanResource.email}" />
        </td>
        
       </tr>
       
       
       
        <tr>
        <td align="center">　电话:　</td><td>
		<input type ="text" name = "humanResource.phoneNumber" value = "${humanResource.phoneNumber}" />
        </td>
        
        <td align="center">　QQ:　</td><td>
       <input type  = "text" name = "humanResource.qq" value = "${humanResource.qq}" />
        </td>
        
         <td align="center">　手机:　</td><td>
		    <input type = "text" name = "humanResource.mobilePhoneNumber" value = "${humanResource.mobilePhoneNumber}" />
        </td>
        
       </tr>
       
       
        <tr>
        <td align="center">　住址:　</td><td colspan="3" >
		<input  type = "text" name = "humanResource.address" style = "width:100%" value = "${humanResource.address}"/> 
        </td>
        
        <td align="center">　邮编:　</td><td >
		<input type = "text" name = "humanResource.postCode" value = "${humanResource.postCode}" />
        </td>
  
       </tr>
       
       
       
        <tr>
        <td align="center">　国籍:　</td><td>
		<select name = "humanResource.country" style = "width:188px">
		<s:if test='humanResource.contry == "中国"'>
		<option value = "中国" selected="selected" >中国</option>
		</s:if>
		<s:else>
		<option value = "中国">中国</option>
		</s:else>
		<s:if test='humanResource.country == "荷兰"'>
		<option value = "荷兰" selected="selected"  >荷兰</option>
		</s:if>
		<s:else>
		<option value = "荷兰">荷兰</option>
		</s:else>
		<s:if test='humanResource.country == "英国"'>
		<option value = "英国" selected="selected"  >英国</option>
		</s:if>
		<s:else>
		<option value = "英国">英国</option>  
		</s:else>   
       </select>
        </td>
        
        <td align="center">　出生地:　</td><td>
		<input type = "text" name = "humanResource.birthAddress" />
        </td>
        
         <td align="center">　生日:　</td><td>
         <sx:datetimepicker name="humanResource.birthDate" displayFormat="yyyy-MM-dd" cssStyle = "width:90%" value = "humanResource.birthDate"  />
        </td>
        
       </tr>
       
       
       
       
         <tr>
        <td align="center">　民族:　</td><td>
		<select name = "humanResource.nation" style = "width:188px">
		<s:if test='humanResource.nation=="汉族"'>
		<option value = "汉族" selected="selected">汉族</option>
		</s:if>
		<s:else>
		<option value = "汉族">汉族</option>
		</s:else>
		
		<s:if test='humanResource.nation=="苗族"'>
		<option value = "苗族" selected="selected">苗族</option>
		</s:if>
		<s:else>
		<option value = "苗族">苗族</option>
		</s:else>
		
		<s:if test='humanResource.nation=="维吾尔族"'>
		<option value = "维吾尔族" selected="selected">维吾尔族</option>
		</s:if>
		<s:else>
		<option value = "维吾尔族">维吾尔族</option>
		</s:else>    
       </select>
        </td>
        
        <td align="center">　宗教信仰:　</td><td>
		<select name = "humanResource.religion" style = "width:188px">
		
		<s:if test='humanResource.religion=="基督教"'>
		<option value = "基督教" selected="selected">基督教</option>
		</s:if>
		<s:else>
		<option value = "基督教">基督教</option>
		</s:else>    
   
       
       <s:if test='humanResource.religion=="佛教"'>
		<option value = "佛教" selected="selected">佛教</option>
		</s:if>
		<s:else>
		<option value = "佛教">佛教</option>
		</s:else>    
   
       
       <s:if test='humanResource.religion=="伊斯兰教"'>
		<option value = "伊斯兰教" selected="selected">伊斯兰教</option>
		</s:if>
		<s:else>
		<option value = "伊斯兰教">伊斯兰教</option>
		</s:else>    
      
       </select>
        </td>
        
         <td align="center">　政治面貌:　</td><td>
		<select name = "humanResource.political" style = "width:188px">
		
		<s:if test='humanResource.political=="无"'>
		<option value = "无" selected="selected">无</option>
		</s:if>
		<s:else>
		<option value = "无">无</option>
		</s:else>
		
		<s:if test='humanResource.political=="党员"'>
		<option value = "党员" selected="selected">党员</option>
		</s:if>
		<s:else>
		<option value = "党员">党员</option>
		</s:else>
		
		<s:if test='humanResource.political=="团员"'>
		<option value = "团员" selected="selected">团员</option>
		</s:if>
		<s:else>
		<option value = "团员">团员</option>
		</s:else>
		
		</select>
        </td>
      
       </tr>
       
         <tr>
        <td align="center">　身份证号码:　</td><td>
		<input type = "text" name = "humanResource.identityCard" value = "${humanResource.identityCard}" />
        </td>
        
        <td align="center">　年龄:　</td><td>
		<input name = "humanResource.age" type = "text" value = "${humanResource.age}" />      
        </td>
        
         <td align="center">　学历:　</td><td>
		<select name = "humanResource.education" style = "width:188px">
		<s:if test='humanResource.education=="幼儿园"'>
		<option value = "幼儿园" selected="selected">幼儿园</option>
		</s:if>
		<s:else>
		<option value = "幼儿园">幼儿园</option>
		</s:else>
		
		<s:if test='humanResource.education=="小学"'>
		<option value = "小学" selected="selected">小学</option>
		</s:if>
		<s:else>
		<option value = "小学">小学</option>
		</s:else>
		
		<s:if test='humanResource.education=="初中"'>
		<option value = "初中" selected="selected">初中</option>
		</s:if>
		<s:else>
		<option value = "初中">初中</option>
		</s:else>
		
		<s:if test='humanResource.education=="高中"'>
		<option value = "高中" selected="selected">高中</option>
		</s:if>
		<s:else>
		<option value = "高中">高中</option>
		</s:else>
		
		<s:if test='humanResource.education=="专科'>
		<option value = "专科" selected="selected">专科</option>
		</s:if>
		<s:else>
		<option value = "专科">专科</option>
		</s:else>
		
		<s:if test='humanResource.education=="本科"'>
		<option value = "本科" selected="selected">本科</option>
		</s:if>
		<s:else>
		<option value = "本科">本科</option>
		</s:else>
		
		<s:if test='humanResource.education=="研究生"'>
		<option value = "研究生" selected="selected">研究生</option>
		</s:if>
		<s:else>
		<option value = "研究生">研究生</option>
		</s:else>
		
		<s:if test='humanResource.education=="博士"'>
		<option value = "博士" selected="selected">博士</option>
		</s:if>
		<s:else>
		<option value = "博士">博士</option>
		</s:else>
		
		<s:if test='humanResource.education=="博士后"'>
		<option value = "博士后" selected="selected">博士后</option>
		</s:if>
		<s:else>
		<option value = "博士后">博士后</option>
		</s:else>
	
       </select>
        </td>
        
       </tr>
       
       
       
       
       
       <tr>
        <td align="center">　专业:　</td><td>
		<select name = "humanResource.major" style = "width:188px">
		
		<s:if test='humanResource.major=="社会学"'>
		 <option value = "社会学" selected="selected">社会学</option>
		</s:if>
		<s:else>
		<option value = "社会学">社会学</option>
		</s:else>
		
		<s:if test='humanResource.major=="制药工程"'>
		 <option value = "制药工程" selected="selected">制药工程</option>
		</s:if>
		<s:else>
		<option value = "制药工程">制药工程</option>
		</s:else>
		
		<s:if test='humanResource.major=="神经科学"'>
		 <option value = "神经科学" selected="selected">神经科学</option>
		</s:if>
		<s:else>
		<option value = "神经科学">神经科学</option>
		</s:else>
 
       </select>
        </td>
        
        <td align="center">　薪酬标准:　</td><td>
		<select name = "salaryStandardID" style = "width:188px">
        
        <s:iterator value = "salaryStandardList">
        <s:if test="id==humanResource.salaryStandard.id">
        <option selected="selected" value = "${id}">${name}</option>
        </s:if>
        <s:else>
        <option value = "${id}">${name}</option>
        </s:else>
        </s:iterator>
        
       </select>
        </td>
        
         <td align="center">　开户行:　</td><td>
		<select name = "humanResource.bank" style = "width:188px">
		<s:if test='humanResource.bank=="中国建设银行"'>
		<option value = "中国建设银行" selected="selected">中国建设银行</option>
		</s:if>
		<s:else>
		<option value = "中国建设银行">中国建设银行</option>
		</s:else>
		
		<s:if test='humanResource.bank=="中国工商银行"'>
		<option value = "中国工商银行" selected="selected">中国工商银行</option>
		</s:if>
		<s:else>
		<option value = "中国工商银行">中国工商银行</option>
		</s:else>
		
		<s:if test='humanResource.bank=="中国农业银行"'>
		<option value = "中国农业银行" selected="selected">中国农业银行</option>
		</s:if>
		<s:else>
		<option value = "中国农业银行">中国农业银行</option>
		</s:else>
		
		<s:if test='humanResource.bank=="中国银行"'>
		<option value = "中国银行" selected="selected">中国银行</option>
		</s:if>
		<s:else>
		<option value = "中国银行">中国银行</option>
		</s:else>
           
       </select>
        </td>
        
       </tr>
       
       
       
       <tr>
        <td align="center">　账号:　</td><td>
		<input type = "text" name = "humanResource.account" value = "${humanResource.account }" />
        </td>
        
        <td align="center">　特长:　</td><td>
		<input type = "text" name = "humanResource.specaility" value = "${humanResource.speciality}"  />
        </td>
        	
         <td align="center">　爱好:　</td><td>
		<input type = "text" name = "humanResource.interest" value = "${humanResource.interest}" />
        </td>
        
       </tr>
       
       <tr>
       <td align = "center">个人履历:　</td><td colspan="5"><textarea rows="3"  cols="107" name = "humanResource.resume">${humanResource.resume}</textarea></td>
       </tr>
       
       <tr>
       <td align = "center">家庭关系信息:　</td><td colspan="5"><textarea rows="3"  cols="107" name = "humanResource.familyRelationship">${humanResource.familyRelationship}</textarea></td>
       </tr>
       
       <tr>
       <td align = "center">备注:　</td><td colspan="5"><textarea rows="3" cols="107" name = "humanResource.remark">${humanResource.remark}</textarea></td>
       </tr>
       
        <tr>
       <td align = "center">审核意见:　</td><td colspan="5"><textarea rows="3" cols="107" name = "humanResource.approveIdea"></textarea></td>
       </tr>
				<tr>
                    <th></th>
                    <td>
                        <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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
