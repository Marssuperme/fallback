<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>事务所经历操作</title>

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
		
		<input name="id" type="hidden" id="id" value="${oict.id}">
		<input name="loginid" type="hidden" id="loginid" value="${oict.loginid}">
		
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">变动事务所<span class="mustSpan">[*]</span>：</td>
				<td><input name="officeName" type="text" id="officeName" value="${oict.officeName}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动时间：</td>
				<td><input name="changeTime" type="text" id="changeTime" showcalendar="true" value="${oict.changeTime}" size="25""></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动原因<span class="mustSpan">[*]</span>：</td>
				<td><input name="changeReason" type="text" id="changeReason" value="${oict.changeReason}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动字段：</td>
				<td><input name="changeField" type="text" id="changeField" value="${oict.changeField}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">原来值：</td>
				<td><input name="beforeValue" id="beforeValue" value="${oict.beforeValue}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">现在值：</td>
				<td><input name="nowValue" id="nowValue" value="${oict.nowValue}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">变动审批人：</td>
				<td><input name="approvePerson" id="approvePerson" value="${oict.approvePerson}" size="25"  /> </td>
			</tr>
			<tr>
				<td align="right" width="40%">变动审批时间：</td>
				<td><input name="approveTime" type="text" id="approveTime" showcalendar="true" value="${oict.approveTime}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">备注：</td>
				<td><input name="remark" type="text" id="remark" value="${oict.remark}" size="25" ></td>
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
    	<input type="button" name="next" value="保 存" class="flyBT" onclick="return f_save();" >&nbsp;&nbsp;&nbsp;
    	<input type="button" name="next" value="返 回" class="flyBT" onclick="history.back();" >
    </td>
    <td width="45%" ></td>
  </tr>
</table>


</form>
 
</body>

<script type="text/javascript">
	// 保存
	function f_save(){
		var id = document.getElementById("id").value;
		if(id==null || id==""){
			thisForm.action = "${pageContext.request.contextPath}/common/officeInfoChange.do?method=addOfficeInfoChangeTable";
			thisForm.submit();
		}else{
			thisForm.action = "${pageContext.request.contextPath}/common/officeInfoChange.do?method=updateOfficeInfoChangeTableById";
			thisForm.submit();
		}
	}
</script>
</html>