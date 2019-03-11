<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>评估师信息</title>
</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
<input type="hidden" id="loginid" name="loginid">
<br>
	<div style="margin-bottom: 0.5%">
		    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
    </div>
    <div class="gridFrame"> 
	    <div style="width:100%;overflow:auto;height:90%x;"> 
	    	<mt:DataGridPrintByBean name="assesser"/>
	    </div>
	</div>
</form>

</body>

<script type="text/javascript">
// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_assesser').value;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			document.getElementById('loginid').value=chooseValue;
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/assesserInfo.do?method=edit";
			document.getElementById("myform").submit();
		}
	}
</script>

</html>