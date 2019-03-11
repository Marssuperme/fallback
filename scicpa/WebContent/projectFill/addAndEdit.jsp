<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目填报</title>

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
<input id="id" name="id" type="hidden" value="${map.id }">
<input id="projectId" name="projectId" type="hidden" value="${map.projectid }">
<input id="opt" name="opt" type="hidden" value="${opt}">
<input id="source" name="source" type="hidden" value="${source}">
<input id="bgwh" name="bgwh" type="hidden" value="">

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">项&nbsp;&nbsp;目&nbsp;&nbsp;填&nbsp;&nbsp;报</font></td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">被检查事务所：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" id="companyName" name="companyName" title="被检查事务所" style="width: 65%" type="text" value="${map.companyname }" 
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
			<input maxlength="50" id="projectName" name="projectName" style="width: 75%" type="text" value="${map.projectname}" 
				class="required"
				onpropertychange="f_checkSame()" 
				onfocus="onPopDivClick(this);"
				autoWidth=230
				autoHeight=460
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				autoid=66
				refer="companyName" >
		</td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">填报人：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="userID" id="userID" style="width: 65%" type="hidden" value="${userSession.userMap.loginid}" >
			<input maxlength="50" name="fillUserName" id="fillUserName" style="width: 65%" type="text" value="${userSession.userMap.loginname}" readonly="readonly">
		</td>
		<td class="data_tb_alignright" width="20%" height="18">填报时间：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="fillTime" id="fillTime" style="width: 75%" type="text" value = "${map.filltime}" readonly="readonly">
		</td>
	</tr>
	 
</table>
<br>
			<input type="submit" size="25" value="保存" icon="icon-save" onclick="f_save()">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" size="25" value="返回" icon="icon-back" onclick="f_back()"> 
</form>
</div>

<script type="text/javascript">
//加验证
$(document).ready(function(){
   $("#myform").validate(); 
});

function f_checkSame(){
	if(document.getElementById("projectName").value!=""){
		var id = document.getElementById("id").value;
		var companyName = document.getElementById("companyName").value;
		var bgwh = document.getElementById("advice-projectName").innerHTML;
		if(id=="" || id==null){
			var url="${pageContext.request.contextPath}/common/projectFill.do?method=check1";
			var request = "&companyName="+companyName+"&bgwh="+bgwh;
			var resText = ajaxLoadPageSynch(url,request);
			if(resText == "Y"){
				alert("该项目已填报，请选择其他项目！");
				document.getElementById("projectName").value = "";
				document.getElementById("advice-projectName").innerHTML = "";
				document.getElementById("projectName").focus();
				return;
			}
		}else{
			var url="${pageContext.request.contextPath}/common/projectFill.do?method=check2";
			var request = "&companyName="+companyName+"&id="+id+"&bgwh="+bgwh;
			var resText = ajaxLoadPageSynch(url,request);
			if(resText == "Y"){
				alert("该项目已填报，请选择其他项目！");
				document.getElementById("projectName").value = "";
				document.getElementById("advice-projectName").innerHTML = "";
				document.getElementById("projectName").focus();
				return;
			}
		}
	}
}

// 保存
function f_save(){
	document.getElementById("bgwh").value = document.getElementById("advice-projectName").innerHTML;
	document.myform.action = "${pageContext.request.contextPath}/common/projectFill.do?method=save";
}


function f_back(){
	var source = "${source}";
	// 监管作业链接过来的
	if(source=="xmtb"){
		window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=xmtb";
	}else{
		window.history.back();
	}
}
</script>
</body>
</html>