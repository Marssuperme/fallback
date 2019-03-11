<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>非执业年检信息</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css" />
	<style type="text/css">
		*{
			font-size: 16px;
			font-weight: bloder;
		}
		.formTitle {
			color: #4A74BC;
			font-weight: bold;
			text-align: center;
			width: 100%;
			margin-top: 10px;
		}
		.data_tb_alignRight {
			padding-right: 10px;
			text-align: right;
			width: 100px;
		}
		
		.data_tb_content {
			padding-left: 3px;
			text-align: left;
			word-break: break-all;
			word-wrap: break-word;
			width: 190px;
			
		}
	</style>

</head>
<body>
	<center class="formTitle">非&nbsp;&nbsp;执&nbsp;&nbsp;业&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;年&nbsp;&nbsp;检&nbsp;&nbsp;信&nbsp;&nbsp;息</center>
	<br />
	<center style="margin: 5px; font-size: 15px; font-weight: bold;">年度：${member.year }年</center>
	<br />
	<table border="0" cellSpacing="0" cellPadding="0" width="600px" align="center">
		<tbody>
			<tr>
				<td class="data_tb_alignRight" style="text-align: center" colspan="8" height="35"><b>年检结果</b></td>
			</tr>
			<tr>
				<td class="data_tb_alignRight" height="30">会员证号</td>
				<td class="data_tb_content" height="30">${member.loginid }</td>
				<td class="data_tb_alignRight" height="30">姓　　名</td>
				<td class="data_tb_content" height="30">${member.loginname }</td>
			</tr>
			<tr>
				<td class="data_tb_alignRight" height="30">状　　态</td>
				<td class="data_tb_content" height="30">${member.state }</td>
				<td class="data_tb_alignRight" height="30">学时状态</td>
				<td class="data_tb_content" height="30">${member.educate }</td>
			</tr>
			<tr>
				<td class="data_tb_alignRight" height="30">会费状态</td>
				<td class="data_tb_content" height="30">${member.payfee }</td>
				<td class="data_tb_alignRight" height="30">注协意见</td>
				<td class="data_tb_content" height="30">${member.auditidea }</td>
			</tr>
			<tr>
				<td class="data_tb_alignRight" height="30">年检结果</td>
				<td class="data_tb_content" height="30">${member.result }</td>
				<td class="data_tb_alignRight" height="30"></td>
				<td class="data_tb_content" height="30"></td>
			</tr>
		</tbody>
	</table>

</body>
</html>

