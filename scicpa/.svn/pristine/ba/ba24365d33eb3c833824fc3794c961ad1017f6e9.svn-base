<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自办培训班学时申报</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
	
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align: center;
	width: 100%;
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

.data_tb TD {
	BORDER-RIGHT: #b0c6d8 1px solid; BORDER-TOP: #b0c6d8 1px solid; PADDING-LEFT: 2px; BORDER-LEFT: #b0c6d8 1px solid; WORD-BREAK: break-all; BORDER-BOTTOM: #b0c6d8 1px solid; WORD-WRAP: break-word 
}

H3.tabs {
	PADDING-LEFT: 0px ! important;
	HEIGHT: 26px;
	BACKGROUND-COLOR: #e8f7fc ! important
}

.tab {
	BORDER-RIGHT: #c1d8e0 1px solid;
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	FONT-WEIGHT: normal;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	CURSOR: pointer;
	PADDING-TOP: 0px
}

.curtab {
	FONT-WEIGHT: bold;
	BACKGROUND: #fff;
	BORDER-RIGHT-COLOR: #b2c9d3;
}

.block {
	BORDER-RIGHT: #b2c9d3 1px solid;
	BORDER-TOP: #b2c9d3 1px solid;
	BACKGROUND: #fff;
	MARGIN: 0px 0px 6px;
	BORDER-LEFT: #b2c9d3 1px solid;
	BORDER-BOTTOM: #b2c9d3 1px solid
}

.block H3 {
	PADDING-LEFT: 0.5em;
	FONT-SIZE: 1em;
	BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
	MARGIN: 1px 0px 0px;
	COLOR: #5086a5;
	LINE-HEIGHT: 26px
}

.block H3 A {
	COLOR: #5086a5
}

.before {
	border: 0px;
	background-color: white;
}

.after {
	border: 1px solid;
}

.disabled {
	disabled: disabled;
}

label { width: 10em; float: left; }
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }

</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />	
	
	
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

</head>
<body>

<div class=tabcontent id="dbswszl" style="text-align: center;"> 
<br><br>
<form id="myform" name="myform" method="post" action="" > 
<input id="id" name="id" type="hidden" value="${ah.id }">
<input id="companyId" name="companyId" type="hidden" value="${ah.companyId }">
<input id="provinceChecked" name="provinceChecked" type="hidden" value="${ah.provinceChecked}">
<input type="hidden" id="attachmentid" name="attachmentid" value="${ah.attachmentid }">

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	   <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">自&nbsp;&nbsp;办&nbsp;&nbsp;培&nbsp;&nbsp;训&nbsp;&nbsp;班&nbsp;&nbsp;学&nbsp;&nbsp;时&nbsp;&nbsp;申&nbsp;&nbsp;报</font></td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">培训课程&nbsp;&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="classID" type="text" id="classID" size="25" value="${ah.classID }">
		</td>
		 
		<td class="data_tb_alignright" height="18">培训时间&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="trainingTime" type="text" id="trainingTime" size="25" value="${ah.trainingTime}" class="required" showcalendar="true">
		</td>
	</tr>
	 
	  <tr>
		<td class="data_tb_alignright" width="20%" height="18">学&nbsp;&nbsp;时&nbsp;&nbsp;模&nbsp;&nbsp;块&nbsp;&nbsp;附&nbsp;&nbsp;件&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<a id="file" style="margin-left: 30px;"></a>
		</td>
	</tr>
	 
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">其&nbsp;&nbsp;&nbsp;他&nbsp;&nbsp;&nbsp;附&nbsp;&nbsp;&nbsp;件&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<a id="file2" style="margin-left: 30px;"></a>
		</td>
	</tr>
</table>
<br>
			<input type="button" size="25" value="返回" icon="icon-back" onclick="window.history.back()"> 
</form>
</div>

<script type="text/javascript">
try{
	$('#file').uploadFile({
		indexId: '${ah.attachmentid }',
		module:'XS_ApplyHoldSelfHour',
		forbitUpload:true,
		forbitDel:true
	});
}catch(e){}	 


try{
	$('#file2').uploadFile({
		indexId: '${ah.hourAttachmentid }',
		module:'XS_ApplyHoldSelfHour',
		forbitUpload:true,
		forbitDel:true
	});
}catch(e){}	 

 
</script>
</body>
</html>