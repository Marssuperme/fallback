<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>消息</title>
	<style>
		.formTitle {
			color: #4A74BC;
			font-weight: bold;
			font-size: 14px;
			text-align: center;
			width: 100%;
			margin-top: 10px;
		}
	</style>
</head>
<body>
	<div id="divBlock" style="position: absolute; width: 100%; height: 100%; z-index: 0; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;"></div>
	<form name="thisForm" method="post" >
		<div style="width: 100%;">
			<div>
				<div style="margin-bottom: 0.5%">
					&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
				</div>
				<div id="search" style="position: absolute; width: 400px; height: 200px; left:50%; top:10%; margin-left:-200px; z-index: 0;  border: 1px solid #6595d6; padding: 1px; background: #ffffff; display: none;">
					<br>
					<fieldset style="border: 1px solid lightblue; width: 86%; height: 95%; margin-left: 2px;" id="fieldset">
						<legend> 搜索条件 </legend>
						<table width="100%" style="margin-left: 15px;">
							<tr>
								<td align="right">标　　题：</td>
								<td align="left"><input id="caption" name="caption" style="width: 260; height: 0px;"></td>
							</tr>
							<tr>
								<td align="right">发文时间：</td>
								<td align="left">
									<input id="ntime1" name="ntime1" style="width: 85px;" showcalendar="true"> 至 
									<input id="ntime2" name="ntime2" style="width: 85px;" showcalendar="true">
								</td>
							</tr>
							<tr>
								<td align="right">状　　态：</td>
								<td align="left">
									<select id="isview" name="isview" style="width: 260px;" >
										<option value="">全部</option>
										<option value="1">已阅</option>
										<option value="0">未阅</option>
									</select>
								</td>
							</tr>
						</table>
						<br>
						<table width="90%" style="margin-left: 25%;">
							<tr>
								<td>
									<input icon='icon-success' type='button' onclick="f_sure();"   value='确定'>　　 
									<input icon='icon-retry'   type='button' onclick="f_clear();"  value='清空'>　　
									<input icon='icon-delete'  type='button' onclick="f_quxiao();" value='取消'>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<!-- 列表显示 -->
				<mt:DataGridPrintByBean name="messageList" />
			</div>
		</div>
	</form>
	
	<script>
	
		// 查看
		function goDetail(id){
			window.location.href="${pageContext.request.contextPath}/common/message.do?method=messageView&id="+id;
		}
	
		// 搜索 
		function f_search() {
			$("#search").show();
			$("#divBlock").show();
		}
	
		// 取消
		function f_quxiao() {
			$("#search").hide();
			$("#divBlock").hide();
		}
	
		// 确定 
		function f_sure() {
			var caption = $("#caption").val();
			var ntime1  = $("#ntime1").val();
			var ntime2  = $("#ntime2").val();
			var isview  = $("#isview").val();
			
			var url = "${pageContext.request.contextPath}/common/message.do?method=messageList";
			
			window.location = url + "&caption=" + caption + "&ntime1=" + ntime1 + "&ntime2=" + ntime2 + "&isview=" + isview;
		}
	
		// 清空
		function f_clear() {
			$("#caption").val();	// 标题
			$("#ntime1").val();		// 开始时间
			$("#ntime2").val();		// 结束时间
			$("#isview").val();		// 状态
		}
	</script>
	
</body>
</html>
