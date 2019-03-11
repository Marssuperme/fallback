<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>行业奖惩经历操作</title>

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
		
		<input name="id" type="hidden" id="id" value="${tprt.id}">
		<input name="loginid" type="hidden" id="loginid" value="${tprt.loginid}">
		
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">奖惩人<span class="mustSpan">[*]</span>：</td>
				<td><input name="person" type="text" id="person" value="${tprt.person}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">事务所名称：</td>
				<td><input name="officeName" type="text" id="officeName" value="${tprt.officeName}" size="25""></td>
			</tr>
			<tr>
				<td align="right" width="40%">注师名称<span class="mustSpan">[*]</span>：</td>
				<td><input name="noteMasterName" type="text" id="noteMasterName" value="${tprt.noteMasterName}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">处理部门：</td>
				<td><input name="department" type="text" id="department" value="${tprt.department}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">文号：</td>
				<td><input name="fieldNumber" id="fieldNumber" value="${tprt.fieldNumber}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">日期：</td>
				<td><input name="recordDate" id="recordDate" showcalendar="true" value="${tprt.recordDate}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">事由：</td>
				<td><input name="reason" id="reason" value="${tprt.reason}" size="25"  /> </td>
			</tr>
			<tr>
				<td align="right" width="40%">奖励内容：</td>
				<td><input name="prizeContent" type="text" id="prizeContent" value="${tprt.prizeContent}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">惩戒内容：</td>
				<td><input name="punishContent" type="text" id="punishContent" value="${tprt.punishContent}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">发布范围：</td>
				<td><input name="publishZone" type="text" id="publishZone" value="${tprt.publishZone}" size="25" ></td>
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
			thisForm.action = "${pageContext.request.contextPath}/common/tradePrizeRecord.do?method=addTradePrizeRecordTable";
			thisForm.submit();
		}else{
			thisForm.action = "${pageContext.request.contextPath}/common/tradePrizeRecord.do?method=updateTradePrizeRecordTableById";
			thisForm.submit();
		}
	}
</script>
</html>