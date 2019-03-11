<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工会</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
<style type="text/css">
.dash{
	border-top: 1px dashed #d1dfbb;
	height: 1px;	
}
body {
	margin: 0px;
	padding: 0px;
}

#leftTb{
	border: 1px solid;width:100%;margin: 0px;padding: 0px;
}
#leftTb tr {
	height:30px;
}
#leftTb td{
	text-align: left;
}

#leftTb td a{
	font-size: 13px; 
	font-family:"宋体" ;
	text-decoration: none;
	height: 100%;
	width: 100%;
	line-height: 30px;
	padding-left:10px;
}

#leftTb td a:HOVER{
	background-color: #e6f4d0;
	color: #fff;
	font-weight: bold;
}

#leftTb td a:VISITED{
	font-size: 13px; 
	font-family:"宋体" ;
	color: #000;
}

.title {
	background-color: #e6f4d0;
	text-align:left;
	padding-left:10px;
	font-size:16px;
	line-height:25px;
	color: #125908;
	font-weight: bold;
	height: 25px;
}
</style>

</head>
   <BODY style="height:100%;width:100%;">
	<table height="100%" width="100%">
		<tr height="100%">
			<td width="20%" style="vertical-align: top">
				<div class="title">工会资料维护</div>
				<table id="leftTb">
					<tr>
						<td>
							<A title="工会基础资料" 
								href="${pageContext.request.contextPath}/common/workerBranch.do?method=branch" 
								target=bodyFrame>&nbsp;&nbsp;基础资料</A>
						</td>
					</tr>
					<!-- 
					<tr>
						<td>
							<A title="本事务所中的团员列表" 
								href="${pageContext.request.contextPath}/common/worker.do?method=member&goBackHidden=none" 
								target=bodyFrame>&nbsp;&nbsp;成员列表</A>
		
						</td>
					</tr>
					 -->
					<tr><td height="400px;"></td></tr>
				</table>
			</td>
			<td width="80%">
				<iframe src="${pageContext.request.contextPath}/common/workerBranch.do?method=branch"
					width="100%" height="100%" name="bodyFrame" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
	</table>
	
</BODY>

</html>
  
