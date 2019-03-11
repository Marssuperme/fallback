<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自查报告下载</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />

<style>
	a:hover {color: blue}
</style>
</head>
<body>
 
<iframe src="" id="go"  name="go" style="display: none">
</iframe>
<form id="thisForm" name="thisForm" method="post" action="">
<input name="ip" type="hidden" id="ip"  value="${pageContext.request.remoteAddr}"  >
<input name="testnoticeid" type="hidden" id="nid"  value="${testnoticeid}"  >
<br><br>
<table width="90%" height="30%" border="0" cellpadding="0" align="center" cellspacing="1" bgcolor="#6595d6">

<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF"> 
	<div style="margin-top: 10px;margin-bottom: 10px;"><font style="font-size: 16px;">业  务  监  管  信  息</font></div> 
	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
		<tbody id="SWlist">
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>被检查事务所名称</strong>：</td>
		  	<td align="left" bgColor="#ffffff" >${companyName}</td>
		</tr>
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>年份</strong>：</td>
		  	<td align="left" bgColor="#ffffff" >${testyear}</td>
		</tr>
		 
		<tr>
			<td align="right" bgColor="#EEEEEE"><strong>自查报告：</td>
			<td align="left" bgColor="#FFFFFF"> 
				<c:forEach var="files" items="${list}">
					<a href="###" onclick="f_downLoad('${files.filetempname}','${files.indextable}','${files.indexid}')">${files.filename }</a><br>
				</c:forEach>
			</td>
		</tr>
	 	
		<tbody>
	</table>  
	<table width="20%" align="center" style="margin-top: 10px;">
	<tr> 
		<td>
			<input icon="icon-btncom" type="button" name="next" value="返回"  onclick="f_back();" >
		</td>
	</tr>
	</table>

	</td>
</tr>
</table>
</form>
</body> 

<script type="text/javascript">
  $(document).ready(function(){
    $("#thisForm").validate();
    
    $("input.zipcode").mask("99999");
    
  });
  
  
   // 保存
   function f_save(){
		document.thisForm.action="${pageContext.request.contextPath}/common/supervision.do?method=addSupervisionTable";
		if (thisForm.fireEvent('onsubmit')){
			document.thisForm.submit();
		}
	}
	
	
	// 下载	
	function f_downLoad(fileTempName,indexTable,indexId){
		document.getElementById("go").src = "${pageContext.request.contextPath}/common/uploadProcess.do?method=download" +
								"&fileTempName="+fileTempName+"&indexTable="+indexTable+"&indexId="+indexId;
	}
	
	function f_back(){
		window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=zlxz";
	}
</script>

</html>