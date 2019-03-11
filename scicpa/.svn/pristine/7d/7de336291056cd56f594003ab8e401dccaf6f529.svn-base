<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>豁免学时申报</title>

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
<input id="add" name="add" type="hidden" value="${add}"><!-- 用来判断是否执行增加方法 -->
<input id="id" name="id" type="hidden" value="${contentExemption.id}">
<input id="status" name="status" type="hidden" value="省注协审核"><!-- 写死 -->
<input id="hour" name="hour" type="hidden" value="${hour}">
<input type="hidden" name="sex" id="sex" value="${contentExemption.sex}" />&nbsp;&nbsp;
			
<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">豁&nbsp;&nbsp;免&nbsp;&nbsp;学&nbsp;&nbsp;时&nbsp;&nbsp;申&nbsp;&nbsp;报</font></td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">申报年份：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
				<input maxlength="30" value="${contentExemption.sYear }" name="sYear" class="required" title="请输入申报年份, 不能为空！" style="width: 30%" type="text" id="sYear">
		</td>
	 	<td class="data_tb_alignright" width="20%" height="18">申报日期：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" width="30%"> 
			<input maxlength="30" name="sDate" class="required" title="请输入申报日期, 不能为空！" style="width: 30%" type="text" id="sDate" value=" ${contentExemption.sDate}" showcalendar="true">&nbsp;&nbsp; 
		</td>
	</tr>
	 	<tr>
		<td class="data_tb_alignright" width="20%" height="18">豁免学时内容：<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18" colspan="3"> 
			<input type="text" name="EConten"
			id="EConten" size="46"
			onkeydown="onKeyDownEvent();" onkeyup="onKeyUpEvent();"
			onclick="onPopDivClick(this);" value="${contentExemption.EContent}"
			valuemustexist=true autoid=55 class="required" refer="contentExemption" title="请输入豁免学时内容, 不能为空！"/>&nbsp;&nbsp; 
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">豁免学时详细说明：</td>
		<td class="data_tb_content" width="80%" height="18" colspan="3"> 
			<textarea name="EHelp" id="EHelp" style="width: 90%" rows="8">${contentExemption.EHelp}</textarea> 
		</td>
	</tr>
</table>
<br>
			<input type="submit" " size="25" value="保存" icon="icon-save" onclick="save()">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" size="25" value="返回" icon="icon-back" onclick="window.history.back()"> 
</form>
</div>

<script type="text/javascript">
  //add 为“” 就是修改页面
  var add = document.getElementById("add").value;
  var hour = document.getElementById("hour").value;
  if(add!=""){ 
	   document.getElementById("sDate").value=hour;  //初始时日期取当前系统时间
	   document.getElementById("sex").value="${sex}"; 
	   document.getElementById("sYear").value=hour.substring(0,4);
  }


//加验证
$(document).ready(function(){
   $("#myform").validate();
});



//保存
function save(){	
	document.myform.action = "${pageContext.request.contextPath}/common/contentExemption.do?method=save";
}

</script>
</body>
</html>