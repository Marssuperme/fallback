<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>业务分析统计</title>

<style>
.gridFrame {
		width: 100%; 
		height:500px;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
.tools {
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 	
</style>
</head>
<body>
		    
		    	<mt:DataGridPrintByBean name="content"/>
		    	
</body>


<script type="text/javascript">
	function f_search(){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/content.do?method=index&p=ywfxtj"; 
		document.getElementById("myform").submit();
	}
</script>


<script type="text/javascript">
 	function go_this(id){ 
 		var qmzscpa='${qmzscpa}';
 		window.location="${pageContext.request.contextPath}/common/bb.do?method=index&model=tongji&typeid="+id+"&qmzscpa="+qmzscpa;
 	}
</script>
</html>