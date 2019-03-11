<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>使用帮助</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

<style>
	.left{
		text-align: left;
		border: 0px,0px,0px,0px;
	}
	.right{
		text-align: right;
		border: 0px,0px,0px,0px;
	}
	a:HOVER {
		text-decoration: underline;
	}
	.center{
		text-align: center;
		font-size: 15;
	}
</style>
 
</head>
<body>
<form action="" method="post" name="myform" id="myform">
	<input type="hidden" id="indexTable" name="indexTable" value="options"> 
	<input type="hidden" id="fileTempName" name="fileTempName" value="matech.pdf"> 
	<input type="hidden" id="indexId" name="indexId" value="indexid123"> 
		<center>
		  <div id="dis1" style="margin-top: 20px; ">
			<table cellSpacing="0" cellPadding="5" width="100%" border="1px">
				<tr>
					<td colspan="6" align="center" style="background-color: #e8f7fc ! important">&nbsp;&nbsp;&nbsp;
						<font style="font-size: 20; ">省注协公共服务平台客服支持方式</font>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="left" style="background-color: #e8f7fc ! important">&nbsp;&nbsp;&nbsp;
						<font style="font-size: 20; ">工作人员：铭太公司省注协项目组</font>
						<a id="option" href="${pageContext.request.contextPath}/common/attachFile/options/matech.zip" style="margin-left: 50px;font-size: 18">(操作手册下载)</a>
					</td>
				</tr>
				
				<tr>
					<td class="center">服务地点</td>
					<td class="center">服务时间</td>
					<td class="center">QQ群</td>
					<td class="center">客服QQ</td>
					<td class="center">客服电话</td>
					<td class="center">传真</td>
				</tr>
				 
				<tr>
					<td class="center" >铭太公司</td>
					<td class="center" >星期一~日9:00~18:00</td>
					<td class="center" >四川注协公共服务平台(171328905)</td>
					<td class="center" >铭太维护(1657810124)</td>
					<td class="center" >020-38378976、020-38378830</td>
					<td class="center" >020-38378820</td>
				</tr>
				<!-- 
				<tr>
					<td class="center" >广东省注协</td>
					<td class="center" >星期一~五8:30~17:30</td>
					<td class="center" >广东注协公共服务平台(128507371)</td>
					<td class="center" >铭太维护2（1678670650）备用 不常挂</td>
					<td class="center" >020-83063585</td>
					<td class="center" >020-83063579</td>
				</tr>
				 -->
				 
			</table>
		</div>
    </center>				
</form>
</body>
<script type="text/javascript">
function f_submit(){
	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/uploadProcess.do?method=download";
	document.getElementById("myform").submit();
}

</script>
</html>