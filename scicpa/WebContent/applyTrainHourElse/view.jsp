<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>其它学时申报</title>

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

a:visited {text-decoration: none;}

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
.dispaly {
	display: none;
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

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">其&nbsp;&nbsp;它&nbsp;&nbsp;学&nbsp;&nbsp;时&nbsp;&nbsp;申&nbsp;&nbsp;报</font></td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">申请确认的学时数：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18" colspan="3"> 
			<input maxlength="50" name="applyHours" style="width: 25%" readonly="readonly" type="text" id="applyHours" value="${aTrainHourElse.applyHours }" class="required">
		</td>
	</tr>
	 
	 
	 
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：</td>
		<td class="data_tb_content" width="80%" height="18" colspan="3"> 
			<a id="file"></a>
		</td>
	</tr>
	
	<c:if test="${aTrainHourElse.companyChecked!='' && aTrainHourElse.companyChecked!=null}">
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">事务所审核：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="companyChecked" id="companyChecked" style="width: 65%" disabled="disabled" type="text" value="${aTrainHourElse.companyChecked }" >
		</td>
		<td class="data_tb_alignright" width="20%" height="18">省注协审核：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="provinceChecked" id="provinceChecked" disabled="disabled" style="width: 75%" type="text" value = "${aTrainHourElse.provinceChecked }" >
		</td>
	</tr>
	 
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">事务所意见：</td>
		<td class="data_tb_content" width="80%" height="18" colspan="3"> 
			<textarea  name="companyOpinion" id="companyOpinion" readonly="readonly" style="width: 90%" rows="3">${aTrainHourElse.companyOpinion}</textarea>
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">省注协意见：</td>
		<td class="data_tb_content" width="80%" height="18" colspan="3"> 
			<textarea name="societyOpinion" id="societyOpinion" readonly="readonly" style="width: 90%" rows="3">${aTrainHourElse.societyOpinion}</textarea>
		</td>
	</tr>
	</c:if>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">参加继续教育情况说明：</td>
		<td class="data_tb_content" width="80%" height="18" colspan="3"> 
			<textarea name="educationNote" id="educationNote" style="width: 90%" rows="8" readonly="readonly" >${aTrainHourElse.educationNote}</textarea> 
		</td>
	</tr>
</table>
<br>
	<input type="button" size="25" value="返回" icon="icon-back" onclick="window.history.back()"> 
</form>
</div>

<script type="text/javascript">
 

//加验证
$(document).ready(function(){
   $("#myform").validate();
});

$('#file').uploadFile({
	indexId: '${aTrainHourElse.attachmentid}',
	module:'XS_ApplyTrainHour',
	forbitUpload:true,
	forbitDel:true
});


</script>
</body>
</html>