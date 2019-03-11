<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>消息</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.js?v=${modifyDate}"  ></script>
	<style>
		* {
			font-family: "宋体";
			font-size: 14px;	
			text-decoration: none;
		}
		.title{
			font-size: 16px;	
			font-weight: bold;
			padding-bottom: 10px;
			text-decoration: none;
		}
		.tbRight{
			color: #5d5b5e;
			width: 15%;
			height: 30px;
			text-align: right;
			font-weight: bold;
			padding-right: 10px;
			background-color: #EEEEEE;
		}
		.tbLeft{
			widt: 85%;
			text-align: left;
			padding-left: 10px;
			background-color: #FFFFFF;
		}
		.alist{
			padding-top: 5px;
			list-style: none;
		}
	</style>
</head>
<body>
	<form name="thisForm" method="post" action="">
		<table width="95%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
			<tr>
				<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF" style="padding-top: 20px">
					<div class="title">${msg.caption }</div>
					<table width="98%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#6595d6">
						<tbody id="SWlist">
							<tr>
								<td class="tbRight">发布人</td>
								<td class="tbLeft">${msg.loginname }</td>
							</tr>
							<tr>
								<td class="tbRight">发布日期</td>
								<td class="tbLeft">${msg.ntime }</td>
							</tr>
							<tr>
								<td class="tbRight">文件正文</td>
								<td class="tbLeft">${msg.body }</td>
							</tr>
							<tr>
								<td class="tbRight">附件</td>
								<td class="tbLeft">
									<c:forEach items="${files}" var="f" >
										<li class="alist" >
											<a href="javascript:void(0)" onclick="downloadFiles(this)" id="${f.fileTempName}">
												${f.filename}（${f.download}<c:if test="${f.isDownload != '0'}">${f.isDownload}次</c:if>）
											</a>
											<input type="hidden" id="${f.fileTempName}_autoid" value="${f.autoid}"/>
											<input type="hidden" id="${f.fileTempName}_fileTempName" value="${f.fileTempName}"/>
											<input type="hidden" id="${f.fileTempName}_filename" value="${f.filename}"/>
											<input type="hidden" id="${f.fileTempName}_isDownload" value="${f.isDownload}"/>
										</li>
									</c:forEach>
								</td>
							</tr>
						<tbody>
					</table> <br> <br>
					<table width="90%" align="center">
						<tr>
							<td width="" align="center">
								<input type="button" name="next" value="返  回" onclick="f_goBack();">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	
		window.downloadFiles = function(obj){
			
			var id = obj.id;
			
			var autoid = $("#" + id + "_autoid").val();
			var code   = $("#" + id + "_fileTempName").val();
			var name   = $("#" + id + "_filename").val();
			var down   = $("#" + id + "_isDownload").val();
			
			var encodeName = encodeURI(encodeURI(name));
			
			var url = "${pageContext.request.contextPath}/common/message.do?method=downloadFile";
			
			window.location.href = url + "&autoid=" + autoid + "&code=" + code + "&name=" + encodeName + "&down=" + down;
			
			var count = parseInt(down) + 1;
			
			$(obj).text(name + "（已下载" + count + "次）");
			$("#" + id + "_isDownload").val(count);			
		}
		
		function f_goBack(){
			window.location.href = "${pageContext.request.contextPath}/common/message.do?method=messageList";
		}
	</script>
</body>
</html>
