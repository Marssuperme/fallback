<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>执业会员信息</title>
<style>
.gridFrame {
	width: 99%; 
	height:55%;
	border: #c3daf9 1px solid;
	float: left;
	margin-left: 5px ;
	padding: 5px ;
}
</style>
</head>
<body>
<form action="" method="post" name="myform" id="myform"> 
<input type="hidden" id="loginid" name="loginid">
<br>
<div class="gridFrame"> 
	<div style="margin-bottom: 0.5%">
		&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='查看'>
	</div>
	<div style="width:100%;overflow:auto;height:400px;"> 
		<mt:DataGridPrintByBean name="micfo"/>
	</div>
</div>
</form>

</body>

<script type="text/javascript">
// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_micfo').value;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			//document.getElementById('loginid').value=chooseValue;
			//document.getElementById("myform").action = "${pageContext.request.contextPath}/common/micfoInfo.do?method=edit";
			//document.getElementById("myform").submit();
			//因为拓管的环境问题，DataGridPrintByBean存在时不能POST提交
			var url = "${pageContext.request.contextPath}/common/micfoInfo.do?method=edit&loginid=" +chooseValue;
			window.location = url;
		}
	}
</script>

</html>