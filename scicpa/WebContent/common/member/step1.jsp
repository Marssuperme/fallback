<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员自助服务平台</title>

<style >
a { color: transparent; text-decoration: none; }
</style>

</head>
<body >
<form id="myform" name="myform" method="post" >
	<input type="hidden" id="typeId" name="typeId" >
	<input type="hidden" id="idNumber" name="idNumber" >
	<input type="hidden" id="departName" name="departName" >
	<input type="hidden" id="ctypeTabName" name="ctypeTabName" >
	<input type="hidden" id="loginId" name="loginId" >
	<input type="hidden" id="officeCode" name="officeCode" >
</form>

<%
String typeId = request.getParameter("typeId"); 
String idNumber = request.getParameter("idNumber"); 
String ctypeTabName = request.getParameter("ctypeTabName"); 
String detailTypeId = request.getParameter("detailTypeId"); 
String departName = request.getParameter("departName"); 
String loginId = request.getParameter("loginId"); 
String officeCode = request.getParameter("officeCode"); 
%>


<div style="width: 1245px;height: 840px;">
	<img src="step1_bg.jpg" style="width: 102%;height: 100%;background-repeat: no-repeat;" >
</div> 
<div style="position: absolute;z-index: 1;width: 115px;height: 115px;left: 160px;top: 340px;">
	<img src="step1_01.jpg" style="width: 100%;height: 100%;border: 0px">
</div>

<div style="position: absolute;z-index: 1;width: 260px;height: 260px;left: 300px;top: 220px;">
	<img src="step1_02.jpg" style="width: 100%;height: 100%;border: 0px">
</div>

<div style="position: absolute;z-index: 1;width: 115px;height: 115px;left: 240px;top: 470px;">
	<img src="step1_03.jpg" style="width: 100%;height: 100%;border: 0px">
</div>

<div style="position: absolute;z-index: 1;width: 115px;height: 115px;left: 380px;top: 510px;">
	<img src="step1_04.jpg" style="width: 100%;height: 100%;border: 0px">
</div>

<div style="position: absolute;z-index: 1;width: 240px;height: 50px;left: 860px;top: 280px;">
	<a href="###" onFocus="this.blur()" onclick="f_go('bs')">
		<img src="step1_05.jpg" style="width: 100%;height: 100%;border: 0px">
	</a>
</div>

<div style="position: absolute;z-index: 1;width: 240px;height: 50px;left: 860px;top: 390px;">
	<a href="###" onFocus="this.blur()" onclick="f_go('kq');">
		<img src="step1_06.jpg" style="width: 100%;height: 100%;border: 0px">
	</a>
</div>

<div style="position: absolute;z-index: 1;width: 130px;height: 50px;left: 970px;top: 550px;">
	<a href="${pageContext.request.contextPath}/common/member/entry.jsp" onFocus="this.blur()">
		<img src="step1_exit.jpg" style="width: 100%;height: 100%;border: 0px">
	</a>
</div>

</body>

<script type="text/javascript">
	
	function f_go(typeId){
		var ctypeTabName = "<%=ctypeTabName%>";
	 	var idNumber = "<%=idNumber%>";
	 	var departName = "<%=departName%>";
	 	var loginId = "<%=loginId%>";
	 	var officeCode = "<%=officeCode%>";
	 	
		document.getElementById("ctypeTabName").value = ctypeTabName;
	 	document.getElementById("idNumber").value = idNumber;
	 	document.getElementById("departName").value = departName;
	 	document.getElementById("loginId").value = loginId;
	 	document.getElementById("officeCode").value = officeCode;
	 	var param = "?ctypeTabName="+ctypeTabName+"&idNumber="+idNumber+"&departName="+departName+"&loginId="+loginId+"&officeCode="+officeCode+"&typeId="+typeId;
	 	var url = "${pageContext.request.contextPath}/common/member/step2.jsp" + param;
			
	 	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/member/step2.jsp?typeId="+typeId;
	 	document.getElementById("myform").submit();
	 	//window.showModalDialog(url,"","dialogWidth=1300px;dialogHeight=1000px;location=no");
	 	//window.close();
	}

</script>

</html>