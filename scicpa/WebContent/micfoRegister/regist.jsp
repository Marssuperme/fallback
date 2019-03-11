<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>注师注册</title>
</head>
<body>
	<form id="myForm" name="myForm" method="post">
		<br><br>
		<table align="center" >
			<tr>
				<td width="15%" align="right"><font style="font-size: 14">姓名：</font></td>
				<td width="15%"><input id="name" name="name"></td>
				<td width="10%" align="right"><font style="font-size: 14">身份证号：</font></td>
				<td width="15%"><input id="idCardNum" name="idCardNum"></td>
				<td width="45%" style="margin-left: 10%" colspan="4"><input icon='icon-save' type="button" value="确定" onclick="f_sure()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	// 确定
	function f_sure(){
		var name = document.getElementById("name").value;
		var idCardNum = document.getElementById("idCardNum").value;
		if(name=="" || name==null){
			alert("请填写姓名!");
			return;
		}
		if(idCardNum=="" || idCardNum==null){
			alert("请填写身份证号!");
			return;
		}
		document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/micfoRegister.do?method=goRegist";
		document.getElementById("myForm").submit();
	}
</script>
</html>