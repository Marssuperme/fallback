<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党群新闻</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css?v=${modifyDate}"/>
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
</head>
<body>
<form name="thisForm" id="thisForm" method="post"  >

	<center class="formTitle" >
	党&nbsp;&nbsp;群&nbsp;&nbsp;新&nbsp;&nbsp;闻<br/><br/> 
	</center>

	<hr>
	
	<input name="id" type="hidden" id="id"  value="${newMap.id }"  >
	
	<input name="loginid" type="hidden" id="loginid"  value="${userSession.userMap.loginid }"  >
	<input name="ntime" type="hidden" id="ntime"  value="${newMap.ntime }"  >
	
	<input name="auditid" type="hidden" id="auditid"  value="${newMap.auditid }"  >
	<input name="audittime" type="hidden" id="audittime"  value="${newMap.audittime }"  >
	<input name="status" type="hidden" id="status"  value="${newMap.status }"  >
	
	<input name="agency" type="hidden" id="agency"  value="${userSession.userMap.loginname }"  >
	
	<input name="attachmentid" type="hidden" id="attachmentid"  value="${attachmentid }"  >
	
		<table width="100%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>标题</strong><font color="#FF0000">&nbsp;[*]</font></font></td>
			<td bgColor="#EEEEEE" ><input name="caption" type="text" id="caption"  style="height:20px;width:500px" value = "${newMap.caption }"></td>
		</tr>
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>发布机构</strong><font color="#FF0000">&nbsp;[*]</font></font></td>
			<td bgColor="#EEEEEE" >
			${userSession.userMap.loginname }
			<!-- <input name="agency" type="text" id="agency"  style="height:20px;width:500px" value = ""> -->
			</td>
		</tr>
		
<!-- 		
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>附件</strong></font></td>
			<td bgColor="#ffffff" ><div id = "attachment"></div></td>
		</tr>
 -->		
		<tr>
			<td align="right" valign="top" width="15%" height="300" bgColor="#EEEEEE" ><font color="#0000FF"><strong>内容</strong><font color="#FF0000">&nbsp;[*]</font></font></td>
			<td bgColor="#ffffff" ><textarea id='body' name="body" >${newMap.body }</textarea></td>
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
		var agency = document.getElementById("agency").value;
		if(caption == ""){
			alert("标题不能为空，请重新输入！");
			document.getElementById("caption").focus();
			return false;
		}
		if(agency == ""){
			alert("发布机构不能为空，请重新输入！");
			document.getElementById("agency").focus();
			return false;
		}
		if(body == ""){
			alert("内容不能为空，请重新输入！");
			document.getElementById("body").focus();
			return false;
		}
		
		document.thisForm.action = "${pageContext.request.contextPath}/common/new.do?method=save";
		document.thisForm.target = "";
		document.thisForm.submit();
		return true;
	}

	/*返回*/
	function go(){
		window.location="${pageContext.request.contextPath}/common/new.do?method=indexdel";
	}
</script>

