<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党群新闻</title>
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
	<input type="button" icon='icon-add' value="增加" onclick="goAdd();">
	
	<input type="button" icon='icon-edit' value="修改" onclick="goUpdate();">
	
	<input type="button" icon='icon-delete' value="删除" onclick="goDel();">
	
	<input type="button" icon='icon-back' value="返回" onclick="go()">
	
	<mt:DataGridPrintByBean name="delNewList"/>
</form>
</body>

</html>
<script>

/*返回*/
function go(){
	window.location="${pageContext.request.contextPath}/common/new.do";
}

/*增加*/
function goAdd(){
	window.location="${pageContext.request.contextPath}/common/new.do?method=add";
}

/*修改*/
function goUpdate(){
	var chooseValue = document.getElementById("chooseValue_delNewList").value;
	var status = "";
	if(chooseValue =="") {
		alert("请选择要修改的党群新闻！");
	}else if(chooseValue.indexOf(",")>-1){
		alert("一次只能修改一条党群新闻！");
	}else{
		var choose = document.getElementsByName("choose_delNewList");
		for(var i = 0;i< choose.length; i++){
			if(choose[i].checked){
				status = choose[i].parentElement.parentElement.status;
			}
		}
		
		if(status == "1"){
			alert("该新闻已经审核过，不允许删除！");
			return ;
		}
		
		window.location="${pageContext.request.contextPath}/common/new.do?method=edit&nid="+chooseValue;
	}
}

/*删除*/
function goDel(){
	var chooseValue = document.getElementById("chooseValue_delNewList").value;
	
	if(chooseValue =="") {
		alert("请选择要删除的党群新闻！");
	}else {
		if(confirm("您的操作可能会造成数据丢失，您确定要删除该记录吗？","提示")){
			document.thisForm.action = "${pageContext.request.contextPath}/common/new.do?method=del&loginid=${userSession.userMap.loginid}&chooseValue="+chooseValue;
			document.thisForm.submit();
		}
	}
}
</script>

