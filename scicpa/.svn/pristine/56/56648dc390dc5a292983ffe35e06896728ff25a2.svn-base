<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报备查询</title>
</head>
<body>
	<form id="myForm" name="myForm" method="post" 
			target=_blank style="margin:0px;display: inline">
			<table>
				<tr>
					<td>
						<font style="color: #FF7F00;font-weight: bold;">报告防伪报备查询：</font>
					</td>
					<td>
						&nbsp;&nbsp;<input type=text size=30 id=bbhm name=bbhm>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<input type="button" icon="icon-search" value="查询" onclick="f_search()">
					</td>
				</tr>
			</table>
	</form>

</body>
<script type="text/javascript">
	function f_search(){
		document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/content.do?method=search";
		document.getElementById("myForm").submit();
	}
</script>
</html>