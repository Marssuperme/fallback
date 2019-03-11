<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>查看法律法规</title>
    <script language="Javascript" src="${pageContext.request.contextPath}/JS/htmlbox_zh.js" charset="gbk" type="text/javascript"></script>

<style>

	body {
		margin: 0px ;
		padding: 0px ;
		font-size:12px;
		overflow: hidden;
		padding: 0 100;
	}
	
	.tools {
		width:100%;
		height:27px ;
		background-image: url("${pageContext.request.contextPath}/images/toolBarBg.gif");
		padding-top: 5px;
		padding-left:10px; 
	} 
	
</style>

</head>
<body>
<form action="" id="thisForm" name="thisForm" method="POST">
<div align="center">
	<div class="tools" align="left"> 
		&nbsp;<input id="audit" icon='icon-config' type='button' onclick="goAudit();" value='提交审核' title="11111">
		&nbsp;<input id="back" icon='icon-back' type='button' onclick="goback();" value='返回'>
	</div>
	<textarea id='content' name="content">${policy.content}</textarea>
</div>
<input type="hidden" value="${policy.id}" id="id" name="id">
</form>
<script type="text/javascript">
 
   initHtmlbox("content","100%","100%");
   
   function goAudit() {
   		document.thisForm.action = "${pageContext.request.contextPath}/common/policy.do?method=submitAudit" ;
   		document.thisForm.submit() ;
   }
   
   function goback() {
   		window.history.back();
   }

</script>


</body>
</html>
 