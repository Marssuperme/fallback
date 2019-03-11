<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>进度管理</title>

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

</head>
<body>

<div class=tabcontent id="dbswszl" style="text-align: center;"> 
<br><br>
<form id="myform" name="myform" method="post" action="" > 
<input id="id" name="id" type="hidden" value="${pm.id }">
<input id="opt" name="opt" type="hidden" value="${opt}">
<input id="soure" name="soure" type="hidden" value="${soure}">

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">进&nbsp;&nbsp;度&nbsp;&nbsp;管&nbsp;&nbsp;理</font></td>
	</tr>
	 
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">进场时间：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" id="beginDate" name="beginDate" style="width: 55%" type="text" value="${pm.beginDate}" showcalendar="true" class="required">
		</td>
		 
		<td class="data_tb_alignright" width="20%" height="18">交换意见时间：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" width="30%"> 
			<input maxlength="50" id="changeDate" name="changeDate" style="width: 60%" type="text" value="${pm.changeDate}" showcalendar="true" class="required">
		</td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">填报人：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="userName" id="userName" style="width: 65%" type="text" value="${userSession.userMap.loginname}" readonly="readonly">
			<input maxlength="50" name="userID" id="userID" style="width: 65%" type="hidden" value="${userSession.userMap.loginid}" >
		</td>
		<td class="data_tb_alignright" width="20%" height="18">结束时间：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="endDate" id="endDate" style="width: 60%" type="text" value = "${pm.endDate}" showcalendar="true" class="required">
		</td>
	</tr>
	 
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">被检查事务所：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" id="companyID" name="companyID" title="被检查事务所" style="width: 65%" type="text" value="${pm.companyID }" 
				class="required" 
				onfocus="onPopDivClick(this);"
				autoWidth=230
				autoHeight=460
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				norestorehint=true
				autoid=65
				refer="userID"
				hideresult=true>
		</td>
		 
		<td class="data_tb_alignright" width="20%" height="18">被检查项目：</td>
		<td class="data_tb_content" height="18" width="30%"> 
			<input maxlength="50" id="projectID" name="projectID" style="width: 72%" type="text" value="${pm.projectID}" class="required" 
				onfocus="onPopDivClick(this);"
				autoWidth=230
				autoHeight=460
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				norestorehint=true
				autoid=66
				refer="companyID"
				hideresult=true>
		</td>
	</tr>
	
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">被检查事务所评价：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" id="comEvaluation" name="comEvaluation" style="width: 65%" type="text" value="${pm.comEvaluation }" 
				onfocus="onPopDivClick(this);"
				noinput=true 
				autoWidth=190
				autoHeight=150
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				norestorehint=true
				autoid=55
				refer="valudations"
				hideresult=true>
		</td>
		 
		<td class="data_tb_alignright" width="20%" height="18">被检查项目评价：</td>
		<td class="data_tb_content" height="18" width="30%"> 
			<input maxlength="50" id="proEvaluation" name="proEvaluation" style="width: 72%" type="text" value="${pm.proEvaluation}" 
				onfocus="onPopDivClick(this);"
				noinput=true 
				autoWidth=190
				autoHeight=150
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				norestorehint=true
				autoid=55
				refer="valudations"
				hideresult=true>
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">评价意见：</td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<textarea id="progressCnt" name="progressCnt" rows="5" style="width: 90%">${pm.progressCnt }</textarea>
		</td>
	</tr>
	
</table>
<br>
			<input type="submit" size="25" value="保存" icon="icon-save" onclick="return f_save()">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" size="25" value="返回" icon="icon-back" onclick="f_back()"> 
</form>
</div>

<script type="text/javascript">
//加验证
$(document).ready(function(){
   $("#myform").validate();
});


// 保存
function f_save(){
	// 验证时间：进场时间要前于交换意见时间，交换意见时间要前于结束时间，进场时间要前于结束时间
	// 进场时间 
	var beginDate = document.getElementById("beginDate").value;
	// 交换意见时间
	var changeDate = document.getElementById("changeDate").value;
	// 结束时间
	var endDate = document.getElementById("endDate").value;
	
	var param = "0";
	if(beginDate>changeDate){
		param = "1";
		alert("进场时间不能晚于交换意见时间！");
		return false;
	}
	
	if(changeDate>endDate){
		param = "1";
		alert("交换意见时间不能晚于结束时间！");
		return false;
	}
	
	if(beginDate>endDate){
		param = "1";
		alert("进场时间不能晚于结束时间！");
		return false;
	}
	
	
	if(param=="0"){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/planManage.do?method=save";
	} 
}


function f_back(){
	var source = "${source}";
	// 监管作业链接过来的
	if(source=="jdgl"){
		window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=jdgl";
	}else{
		window.history.back();
	}
}
</script>
</body>
</html>