<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案例案新增</title>

<style>
#desc {
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
</style>
</head>
<body>
	<form name="thisForm" id="thisForm" method="post">
	<div id="desc">请录入案例资料：</div>
	<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
	<div id="main">
		<table cellpadding="0" cellspacing="5" border="0" align="left">
			<tr>
				<td align="right">标题：</td>
				<td><input type="text" name="title" id="title" size="100" title="案例标题不能为空" value="${cases.title}"></td>
			</tr>
			<!-- 
			<tr>
				<td align="right">作者：</td>
				<td><input type="text" name="author" id="author" size="80" value="${cases.author}"></td>
			</tr>
			 -->
			<tr>
				<td align="right" nowrap="nowrap"> 文件内容：</td>
				<td align="left" height="500"><textarea id="content" name="content" title="案例文件内容不能为空">${cases.content}</textarea></td>
			</tr>
			
		</table>
	</div>
	<input type="hidden" value="${typeId}" id="typeId" name="typeId">
	<input type="hidden" value="${cases.id}" id="id" name="id">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="22" colspan="3">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="37%" align="right">
	      <input type="button" icon='icon-save' name="next" value="提交审核"  onclick="goSave();" >
	    </td>
	    <td width="2%">&nbsp;</td>
	    <td width="55%">
	    	<input type="button" icon='icon-back' value="返 回" onclick="window.history.back();">
	    </td>
	  </tr>
	</table>
	<form>
  <script type="text/javascript">
  		
  		document.getElementById("title").focus();
  	
        $(function (){
  			$("#thisForm").validate();
  			initHtmlbox("content","100%","100%");
  		})
        
         function goSave() {
         	var title = document.getElementById("title").value;
         	var content = document.getElementById("content").value;
       		if(title == "") {
				alert("案例标题不能为空!");
				return;
			}
			
			if(content == "") {
				alert("案例文件内容不能为空!");
				return;
			}
			alert("新增成功，但需审批通过才能进入案例库!");
         	document.thisForm.action = "${pageContext.request.contextPath}/common/case.do?method=submitAudit" ;
         	document.thisForm.submit();
        }
    </script>
</body>
</html>
