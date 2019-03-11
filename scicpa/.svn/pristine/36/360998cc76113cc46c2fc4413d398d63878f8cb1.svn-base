<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>转会经历操作</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}

</style>

</head>
<body>
 
<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	个&nbsp;&nbsp;人&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>


	<fieldset>
		<legend>个人信息</legend>
		
		<input name="id" type="hidden" id="id" value="${crt.id}">
		<input name="loginid" type="hidden" id="loginid" value="${crt.loginid}">
		
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">登记人<span class="mustSpan">[*]</span>：</td>
				<td><input disabled="disabled" name="register" type="text" id="register" value="${crt.register}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">登记日期：</td>
				<td><input disabled="disabled" name="registDate" type="text" id="registDate" showcalendar="true" value="${crt.registDate}" size="25""></td>
			</tr>
			<tr>
				<td align="right" width="40%">之前会的名称<span class="mustSpan">[*]</span>：</td>
				<td><input disabled="disabled" name="beforeName" type="text" id="beforeName" value="${crt.beforeName}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">之前会的离会时间：</td>
				<td><input disabled="disabled" name="outTime" id="outTime" showcalendar="true" value="${crt.outTime}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">之前会类型：</td>
				<td><input disabled="disabled" name="beforeType" id="beforeType" value="${crt.beforeType}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">现在会名称：</td>
				<td><input disabled="disabled" name="nowName" id="nowName" value="${crt.nowName}" size="25"  /> </td>
			</tr>
			<tr>
				<td align="right" width="40%">当前会的进会时间：</td>
				<td><input disabled="disabled" name="inTime" type="text" id="inTime" showcalendar="true" value="${crt.inTime}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">现在会类型：</td>
				<td><input disabled="disabled" name="nowType" type="text" id="nowType" value="${crt.nowType}" size="25" ></td>
			</tr>
			
			<tr>
				<td align="right" width="40%">原因：</td>
				<td>
					<textarea disabled="disabled" name="reason" id="reason" size="30">${crt.reason}</textarea>
				</td>
			</tr>
			</table>
		</td>
		</tr>
		</table>
		
	</fieldset>
	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="10%">&nbsp;</td>
    <td width="45%" align="right">
    	<input type="button" name="next" value="返 回" class="flyBT" onclick="history.back();" >
    </td>
    <td width="45%" ></td>
  </tr>
</table>


</form>
 

</body>
 
</html>