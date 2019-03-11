<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
<style type="text/css">
body{text-align:center;}
*{
	margin:0px;
	padding:0px;
}
#content{
	margin:0px;
	padding:0px;
	width:980px;
	margin:auto;
}
.td1{
	line-height:38px;
	background-color:#E4F4FE;
	border-left:#B0C6D8 solid 1px;
	border-bottom:#B0C6D8 solid 1px;
	border-right:#B0C6D8 solid 1px;
	border-top:#B0C6D8 solid 1px;
	font-size:16px;
	font-weight:bold;
}
#td2{
	clear:both;
	border-bottom:0px;
	border-top:0px;
}
.td2{
	overflow: hidden;
	margin-bottom:3px;
	margin-top:3px;
	border-bottom:1px #CCC solid;
	border-top:1px #CCC solid;
	border-left:1px #CCC solid;
	border-right:1px #CCC solid;
}
.te3{
	overflow: hidden;
	margin-bottom:3px;
	margin-top:3px;
	border-bottom:0px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
}
#save_span{
	text-align:right;
}
</style>
<!-- 上传附件时要写下面这个才能上传附件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
</head>
<body>
<div id="content">
<form id="myform" name="myform" method="post" action="">
	<input id="id" name="id" type="hidden" value="${papers.id}">
	<input id="p" name="p" type="hidden" value="${p}">
	<input type="hidden" id="uploadFilesPaper" name = "uploadFilesPaper" value="${uploadFilesPaper}">
	<br>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2" align="center" class="td1">投  稿</td>
	    </tr>
	  <tr>
	    <td width="21%" align="right" class="data_tb_alignright" id="td2">编号</td>
	    <td width="79%" class="data_tb_content" id="td2">
	      <input class="te3" type="text" name="officeCode" id="officeCode" disabled="disabled" value="${papers.officeCode}"></td>
	  </tr>
	  <tr>
	    <td align="right" class="data_tb_alignright">姓名</td>
	    <td class="data_tb_content">
	      <input class="te3" type="text" name="officeName" id="officeName" disabled="disabled" value="${papers.officeName}"></td>
	  </tr>
	  <tr>
	    <td align="right" class="data_tb_alignright" id="td2">标题</td>
	    <td class="data_tb_content">
        	 <input class="td2" type="text" name="title" id="title" value="${papers.title}" maxlength="10"></td>
      </tr>
	  <tr>
	    <td align="right" class="data_tb_alignright">工作单位</td>
	    <td class="data_tb_content">
        	 <input class="td2" type="text" name="workUnit" id="workUnit" value="${papers.workUnit}" maxlength="20"></td>
      </tr>
	  <tr>
	    <td align="right" class="data_tb_alignright" id="td2">稿件</td>
	    <td align="left" bgColor="#FFFFFF" style="border-right:#CCC 1px solid;"><div id = "uploadPaper"></div></td>
	  </tr>
	  <tr>
	    <td align="right" class="data_tb_alignright">备注</td>
	    <td align="left" class="data_tb_content">
			<textarea class="td2" cols="100%" rows="8%" id="remark" name="remark">${papers.remark}</textarea>
		</td>
	  </tr>
	  <tr>
		<td colspan="2">
	       <!-- 这里的c:if是判断'是否使用'的值是否为空，如果为空就隐藏'是否使用'和'使用说明'这两个字段，如果不为空就显示这两个字段-->
	 	   <c:if test="${papers.isUse!='' && papers.isUse!=null}">
			<table width="100%" border="0px;" cellpadding="0" cellspacing="0">
			  <tr>
			    <td width="21%" align="right" class="data_tb_alignright" id="td2">是否使用</td>
		        <td width="79%" id="td2" class="data_tb_content">
		           <input class="te3" type="text" id="isUse" name="isUse" disabled="disabled" value="${papers.isUse}">
		        </td>
			  </tr>
			  <tr>
				<td width="21%" align="right" class="data_tb_alignright">使用说明</td>
				<td class="data_tb_content">
				   <textarea class="te3" cols="100%" rows="8%" id="useRemark" name="useRemark" disabled="disabled">${papers.useRemark}</textarea>
				</td>
			  </tr>
			</table>
	       </c:if>
	    </td>
	  </tr>
    </table>
  	<br>
  	<div id="ds">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45%">
        <span id="save_span">
			<input type="button" id="save_btn" size="25" value="保存" icon="icon-save" onclick="f_save()">&nbsp;&nbsp;
		</span></td>
        <td width="55%">&nbsp;&nbsp;
        	<input type="button" id="back_btn" size="25" value="返回" icon="icon-back" onclick="f_goBack();"> 
        </td>
      </tr>
	</table>
    </div>
</form>
</div>

</body>
<script type="text/javascript">

// 操作判断,判断如果为查看的话就不能修改，为修改时才能修改
var p = "${p}";
var isUse ="${papers.isUse}"
var forbitUpload_temp = false;
var forbitDeltemp = false;
if(p=="search" || isUse=="是"){//判断是否使用时，如果是'是'的话，就不能上传附件和修改
	forbitUpload_temp = true;
	forbitDeltemp = true;
	document.getElementById("title").disabled = true;
	document.getElementById("workUnit").disabled = true;
	document.getElementById("remark").disabled = true;
	document.getElementById("save_span").style.display = "none";
}else{
	forbitUpload_temp = false;
	forbitDeltemp = false;
	document.getElementById("title").disabled = false;
	document.getElementById("workUnit").disabled = false;
	document.getElementById("remark").disabled = false;
	document.getElementById("save_span").style.display = "block";
}
// 上传附件，forbitUpload:forbitUpload_temp和forbitDel:forbitDeltemp是说为false时就上传文件
$('#uploadPaper').uploadFile({
	indexId:'${uploadFilesPaper}',
	module:'${paperTable}',
	mainId:'${papers.id}',
	forbitUpload:forbitUpload_temp,
	forbitDel:forbitDeltemp
});
	
//加验证
$(document).ready(function(){
   $("#myform").validate();
});

//保存
function f_save(){
	if(p=="update" || p=="search"){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=updatePaperNo";
		document.getElementById("myform").submit(); 
	}else{
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=addPaperNo";
		document.getElementById("myform").submit(); 
	}
}
// 返回 
function f_goBack(){
	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=paperIndex"; 
	document.getElementById("myform").submit(); 
}
</script>
</html>