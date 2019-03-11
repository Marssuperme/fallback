<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>培训经历操作</title>

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
		
		<input name="id" type="hidden" id="id" value="${trt.id}">
		<input name="loginid" type="hidden" id="loginid" value="${trt.loginid}">
		
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">培训师<span class="mustSpan">[*]</span>：</td>
				<td><input name="trainTeacher" type="text" id="trainTeacher" value="${trt.trainTeacher}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">培训开始时间：</td>
				<td><input name="startTime" type="text" id="startTime" showcalendar="true" value="${trt.startTime}" size="25""></td>
			</tr>
			<tr>
				<td align="right" width="40%">结束时间<span class="mustSpan">[*]</span>：</td>
				<td><input name="endTime" type="text" id="endTime" showcalendar="true" value="${trt.endTime}" size="25"></td>
			</tr>
			<tr>
				<td align="right" width="40%">培训地点：</td>
				<td><input name="trainPlace" id="trainPlace" value="${trt.trainPlace}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">培训内容：</td>
				<td><input name="trainContent" id="trainContent" value="${trt.trainContent}" size="25"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">学时：</td>
				<td><input name="classHour" type="text" id="classHour" showcalendar="true" value="${trt.classHour}" size="25" ></td>
			</tr>
			<tr>
				<td align="right" width="40%">培训方式：</td>
				<td><input name="trainWay" type="text" id="trainWay" value="${trt.trainWay}" size="25" ></td>
			</tr>
			
			<tr>
				<td align="right" width="40%">备注：</td>
				<td>
					<textarea name="remark" id="remark" size="30">${trt.remark}</textarea>
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
			thisForm.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=addTrainRecordTable";
			thisForm.submit();
		}else{
			thisForm.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=updateTrainRecordTableById";
			thisForm.submit();
		}
	}
</script>
</html>