<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${title}</title>

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

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38"><font style="font-size: 20">${title}</font></td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">负责人：&nbsp;&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="trainingChargeID" type="text" id="trainingChargeID" disabled="disabled" style="width: 65%" value="${tt.trainingChargeID }" />
		</td>
		 
		<td class="data_tb_alignright" height="18">培训日期：&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="trainingDateBeg" type="text" id="trainingDateBeg" style="width: 35%" disabled="disabled" value="${tt.trainingDateBeg}"/>
			至
			<input maxlength="50" name="trainingDateEnd" type="text" id="trainingDateEnd" disabled="disabled" style="width: 35%" value="${tt.trainingDateEnd}" />
		</td>
	</tr>
	 
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">培训班名称：&nbsp;&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="className"  type="text"  id="className" style="width: 65%" disabled="disabled" value="${tt.className }" >
		</td>
		<td class="data_tb_alignright" height="18">培训学时：&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="trainingHour" type="text" id="trainingHour" style="width: 75%" disabled="disabled" value = "${tt.trainingHour }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：&nbsp;&nbsp;</td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<a id="file" style="margin-left: 30px;"></a>
		</td>
	</tr>
	<c:choose>
		<c:when test="${act=='apply'}">
			 <tr>
				<td class="data_tb_alignright" width="20%" height="18">培训地址：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea  name="trainingAddress" id="trainingAddress" style="width: 90%" disabled="disabled" rows="3">${tt.trainingAddress}</textarea>
				</td>
			</tr>
			
			<tr>
				<td class="data_tb_alignright" width="20%" height="18">课程安排：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea  name="trainingContent" id="trainingContent" style="width: 90%" disabled="disabled" rows="3">${tt.trainingContent}</textarea>
				</td>
			</tr>
			
			 <tr>
				<td class="data_tb_alignright" width="20%" height="18">授课师资：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea name="teachers" id="teachers" style="width: 90%" disabled="disabled" rows="3">${tt.teachers}</textarea>
				</td>
			</tr>
			
			 <tr>
				<td class="data_tb_alignright" width="20%" height="18">师资简介：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea name="teacherIntroduce" id="teacherIntroduce" disabled="disabled" style="width: 90%" rows="3">${tt.teacherIntroduce}</textarea>
				</td>
			</tr>
			
			 <tr>
				<td class="data_tb_alignright" width="20%" height="18">培训对象：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea name="trainingObject" id="trainingObject" disabled="disabled" style="width: 90%" rows="3">${tt.trainingObject}</textarea>
				</td>
			</tr>
			
			 <tr>
				<td class="data_tb_alignright" width="20%" height="18">其他说明：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea name="memo" id="memo" style="width: 90%" disabled="disabled" rows="3">${tt.memo}</textarea> 
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td class="data_tb_alignright" width="20%" height="18">培训总结：&nbsp;&nbsp;</td>
				<td class="data_tb_content" height="18" colspan="3"> 
					<textarea name="trainingSummary" id="trainingSummary" style="width: 90%" disabled="disabled" rows="3">${tt.trainingSummary}</textarea> 
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
</table>
<br>
		<input type="button" size="25" value="返回" icon="icon-back" onclick="f_goBack()"> 
</form>
</div>

<script type="text/javascript">
var id = "${tt.classID }";
if(id!=null && id!=""){
	try{
		$('#file').uploadFile({
			indexId: '${tt.attachmentid }', 
			module:'b_TrainingHoldSelf',
			forbitUpload:true,
			forbitDel:true
		});
	}catch(e){}	 
}else{
	try{
		$('#file').uploadFile({
			indexId: '${attachmentid }',
			module:'b_TrainingHoldSelf',
			forbitUpload:true,
			forbitDel:true
		});
	}catch(e){}	 
}

// 返回 
function f_goBack(){
	var act = "${act}";
	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=index&act="+act; 
	document.getElementById("myform").submit(); 
 
}
 
 
</script>
</body>
</html>