<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="zh-CN" />
	<meta name="Keywords" content="" />
	<meta name="Description" content="" />
	<title>继续教育信息</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>
</head>
<body>

	<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
	
	<form action="" method="post" name="myform" id="myform" style="dispaly:none;"> 
 	
    	<div style="width:100%;overflow:scroll;height:100%px;"> 
	    	<mt:DataGridPrintByBean name="listMemberno"/>
		</div> 
	</form>

</body>
</html>