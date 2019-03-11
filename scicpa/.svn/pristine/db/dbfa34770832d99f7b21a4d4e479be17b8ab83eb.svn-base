<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实名举报</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}


	body {
		margin: 0px ;
		padding: 0px ;
		font-size:12px;
		overflow: auto;
		padding: 0 100;
	}
	
	.tools {
		width:100%;
		height:27px ;
		background-image: url("${pageContext.request.contextPath}/images/toolBarBg.gif");
		padding-top: 5px;
		padding-left:10px; 
	} 
	
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css?v=${modifyDate}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
</head>
<body>
<form name="thisForm" id="thisForm" method="post" enctype="multipart/form-data" >

	<center class="formTitle" >
	实&nbsp;&nbsp;名&nbsp;&nbsp;举&nbsp;&nbsp;报<br/><br/> 
	</center>
	<hr>
	提示： 本网站提供实名举报功能，在您通过本网站投诉时，请务必做到实事求是，我们将为您保密并及时处理。 
	<br>
	
	<input name="iuser" type="hidden" id="iuser"  value="${userSession.userMap.loginid }"  >
	<input name="idate" type="hidden" id="idate"  value="${dateandtime }"  >
	<input name="ip" type="hidden" id="ip"  value="${pageContext.request.remoteAddr }"  >
	<input name="result" type="hidden" id="result"  value="未处理"  >
	
		<table width="98%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>标题</strong></font></td>
			<td bgColor="#EEEEEE" >
			<input name="caption" type="text" id="caption"  style="height:20px;width:500px" value = "">
			</td>
		</tr>
		
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>事务所</strong></font></td>
			<td bgColor="#EEEEEE" >
			<input name="companyid" type="text" id="companyid" style="height:20px;width:200px" value = "" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						valuemustexist="true"
						autoid=24  class="required">
			</td>
		</tr>
		
		<tr>
			<td align="right" valign="top" width="15%" height="450" bgColor="#EEEEEE" ><font color="#0000FF"><strong>举报事项</strong></font></td>
			<td bgColor="#ffffff" ><textarea id='body' name="body" ></textarea></td>
		</tr>
		</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
      <input type="button" icon='icon-save' name="next" value="保 存"  onclick="return saveInfo();" >
    </td>
    <td width="8%">&nbsp;</td>
	<td width="55%">
    	<input type="button" icon='icon-back' value="返 回" onclick="go()">
    </td>
  </tr>
</table>

</form>
</body>
</html>
<script type="text/javascript">
 
	initHtmlbox("body","100%","100%");

	   
	function saveInfo(){
		
		var caption = document.getElementById("caption").value;
		var body = document.getElementById("body").value;
		var companyid = document.getElementById("companyid").value;
		if(caption == ""){
			alert("标题不能为空，请重新输入！");
			document.getElementById("caption").focus();
			return false;
		}
		
		if(companyid == ""){
			alert("事务所不能为空，请重新输入！");
			document.getElementById("companyid").focus();
			return false;
		}
		
		if(body == ""){
			alert("内容不能为空，请重新输入！");
			document.getElementById("body").focus();
			return false;
		}

		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/inform.do?method=isCompany&companyid="+companyid;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();
		var resText = oBao.responseText;  
		if(resText=="no"){
			alert("请输入合法事务所!");
			document.getElementById("companyid").focus();
			return false;
		}else{
			document.thisForm.action = "${pageContext.request.contextPath}/common/inform.do?method=saveinform";
			document.thisForm.target = "";
			document.thisForm.submit();
			return true;
		}
		
	}
	

	/*返回*/
	function go(){
		var table = "${userSession.userMap.ctypetabname}";
		table = table.toLowerCase().substring(2);
		var url = "${pageContext.request.contextPath}/"+table+"/"+table+".do?method=goAddFrame&param=mainFrame";
		window.location = url;
	}
</script>

