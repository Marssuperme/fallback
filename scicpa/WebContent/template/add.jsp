<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增模板下载</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js"></script>
<style>
#description {
		height : 27px ;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
#main{
	padding-left:30px; 
	padding-right:50px; 
	width: 80%;
}

#main table{
	width: 100%;
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
	<form name="thisForm" id="thisForm" method="post" style="height: 100%">
	<div id="description">请输入模板描述及上传模板：</div>
	<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
	<div id="main" >
		<table cellpadding="0" cellspacing="5" border="0" align="left">
			<tr>
				<td align="right" >模板标题<span class="mustSpan">[*]</span>：</td>
				<td><input type="text" name="title" id="title" size="80" maxlength="100"></td>
				<td><div id="titleTip" style="width:250px"></div></td>
			</tr>
			
			<tr>
				<td align="right" >模板描述：</td>
				<td align="left"><textarea id='desc' name="desc" cols="55" rows="15"></textarea></td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">下载扣除资源分<span class="mustSpan">[*]</span>：</td>
				<td><input type="text" name="minMark" id="minMark" size="20" value="0"> <span id="minMarkTip" style="width:250px"></span></td>
				<td></td>
			</tr>
			<tr>
				<td align="right">模板文件<span class="mustSpan">[*]</span>：</td>
				<td><div id="upload"></div></td>
			</tr>
		</table>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="22" colspan="3">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="20%" align="right">
	      <input type="button" icon='icon-save' name="next" value="提交"  onclick="return goSave();" >
	    </td>
	    <td width="2%">&nbsp;</td>
	    <td width="55%">
	    	<input type="button" icon='icon-back' value="返 回" onclick="window.history.back();">
	    </td>
	  </tr>
	</table>
	<input type="hidden" value="${id}" id="id" name="id">
	<form>
  <script type="text/javascript">
  		
  		document.getElementById("title").focus();
  
  		$('#upload').uploadFile({
			indexId: '${id}',
			module:'template'
		});  
        
         function goSave() {
         	var title = document.getElementById("title").value;
         	var minMark = document.getElementById("minMark").value;
         	
         	var files = document.getElementsByName("downtemplate");
         	
         	if(title == "") {
         		alert("标题不能为空！");
         		return false;
         	}
         	if(minMark == "") {
         		alert("扣除专家分不能为空！");
         		return false;
         	}
         	if(files.length <1) {
         		alert("请上传一个模板文件！");
         		return false;
         	}
          	alert("新增成功，但需审批通过才能进入模板库!");
         	document.thisForm.action = "${pageContext.request.contextPath}/common/template.do?method=save" ;
         	document.thisForm.submit();
        }
        
    </script>
</body>
</html>
