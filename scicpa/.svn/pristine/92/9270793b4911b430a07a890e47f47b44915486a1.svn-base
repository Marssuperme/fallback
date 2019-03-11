<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息经历操作</title>

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
		
		<input name="id" type="hidden" id="id" value="${pict.id}">
		<input name="loginid" type="hidden" id="loginid" value="${pict.loginid}">
		
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">变动人<span class="mustSpan">[*]</span>：</td>
				<td><input disabled="disabled" name="person" type="text" id="person" value="${pict.person}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动时间：</td>
				<td><input disabled="disabled" name="changeTime" type="text" id="changeTime" showcalendar="true" value="${pict.changeTime}" size="25""></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动原因<span class="mustSpan">[*]</span>：</td>
				<td><input disabled="disabled" name="changeReason" type="text" id="changeReason" value="${pict.changeReason}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动字段：</td>
				<td><input disabled="disabled" name="changeField" type="text" id="changeField" value="${pict.changeField}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">原来值：</td>
				<td><input disabled="disabled" name="beforeValue" id="beforeValue" value="${pict.beforeValue}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">现在值：</td>
				<td><input disabled="disabled" name="nowValue" id="nowValue" value="${pict.nowValue}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动审批人：</td>
				<td><input disabled="disabled" name="approvePerson" id="approvePerson" value="${pict.approvePerson}" size="25"  /> </td>
			</tr>
			<tr>
				<td align="right" width="40%">变动审批时间：</td>
				<td><input disabled="disabled" name="approveTime" type="text" id="approveTime" showcalendar="true" value="${pict.approveTime}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">备注：</td>
				<td>
					<textarea disabled="disabled" name="remark" type="text" id="remark" size="25" >${pict.remark}</textarea>
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