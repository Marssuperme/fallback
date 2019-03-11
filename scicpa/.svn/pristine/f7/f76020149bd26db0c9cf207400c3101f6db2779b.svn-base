<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<title>用户排名</title>

<style>
.clicked {
	background-color: #5ebd3b;
	color: #ffffff;
	font-size: 14px;
}
</style>
</head>
<body>

<table class="indexBox" cellpadding="0" cellspacing="0">
	<tr>
		<th><a href="###" onclick="getList('','');">所有分类</a></th>
		<th></th>
	</tr>
	<tr>
		<th width="100">
			<a href="###" onclick="getList('policy','');">法律法规</a>
		</th>
		<td>
			<c:forEach items="${policyTypeList}" var="policyType">
				<c:if test="${param.ctype=='policy' && param.typeId==policyType.id }">
					<span class="clicked">${policyType.typeName}</span>&nbsp;&nbsp;&nbsp;
				</c:if>
				
				<c:if test="${param.typeId!=policyType.id }">
					<a href="###" onclick="getList('policy','${policyType.id}');">${policyType.typeName}</a>&nbsp;&nbsp;&nbsp;
				</c:if>
			</c:forEach>
		</td>
	</tr>
	
	<tr>
		<th width="100">
			<a href="###" onclick="getList('cases','');">案例</a>
		</th>
		<td>
			<c:forEach items="${casesTypeList}" var="cases">
				<c:if test="${param.ctype=='cases' && param.typeId==cases.id }">
					<span class="clicked">${cases.typeName}</span>&nbsp;&nbsp;&nbsp;
				</c:if>
				
				<c:if test="${param.typeId!=cases.id }">
					<a href="###" onclick="getList('cases','${cases.id}');">${cases.typeName}</a>&nbsp;&nbsp;&nbsp;
				</c:if>
			</c:forEach>
		</td>
	</tr>
	
	<tr>
		<th width="100">
			<a href="###" onclick="getList('course','');">课程</a>
		</th>
		<td>
			&nbsp;
		</td>
	</tr>
	
	<tr>
		<th width="100">
			<a href="###" onclick="getList('other','');">其他</a>
		</th>
		<td>
			&nbsp;
		</td>
	</tr>
</table>
<br/>

<table width="100%">
	<tr>
		<td width="50%"><mt:DataGridPrintByBean name="gradeList"/></td>
		<td width="50%"><mt:DataGridPrintByBean name="gradeMonthList"/></td>
	</tr>
</table>



</body>

<script type="text/javascript">
function getList(ctype,typeId) {
	window.location = "${pageContext.request.contextPath}/common/grade.do?method=list&ctype=" + ctype + "&typeId=" + typeId;
}

</script>
</html>