<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线填报</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<form name="thisForm" method="post" action="">

	<center class="formTitle" >
		在&nbsp;&nbsp;线&nbsp;&nbsp;填&nbsp;&nbsp;报<br/><br/> 
	</center>
 
 
	<mt:DataGridPrintByBean name="taskList"/>
</form>
</body>
</html>

 
<script>
 
  
	/*查看*/
	function goView(chooseValue,p){
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/task.do?method=getStateById&id="+chooseValue;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();
 
    	p = oBao.responseText;  
		if(p=="未回复" || p=="已回复 等待确认" || p == "已回复 不通过"){
			window.location="${pageContext.request.contextPath}/common/task.do?method=viewTask&id="+chooseValue;
		}else{
			alert(p);
			return false;
		}
	}

 
</script>