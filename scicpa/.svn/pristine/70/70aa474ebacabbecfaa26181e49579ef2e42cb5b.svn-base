<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html>
<head>
<title>下载模板</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js"></script>
<style>
	body {
		height: 100%;
	}
	.outContent {
		border: 1px solid #88c369 ;
		width: 70%;
		margin: 20 0px;
	}
	
	.inContent {
		border: 2px solid #e6f4d0 ;
		margin: 1px;
	}
	.title {
		height: 30px;
		background-color: #e6f4d0;
		color: #007500;
		font-size: 14px;
		font-weight: bold;
	}
	
	.dash{
		border-top: 1px dashed #d1dfbb;
		height: 1px;
		margin:0 10px;
	}
	
	a:visited{
		nothing;
	}
</style>

</head>
<body>
	首页  >  <a href="${pageContext.request.contextPath}/common/template.do?method=list">模板库</a>
	<div class="outContent">
		<div class="inContent">
			<div class="title"></div>
			<div style="padding:10px;">
					${template.desc}
				<br>
				<div id="file" style="margin:10px;"></div> <span style="font-size:11px;margin: 20px;">${desc}</span>
				<div style="margin:10px;">下载需要分数:<img src="${pageContext.request.contextPath}/icons/money.png" width="16" height="16" />${template.mark}</div>
				<div style="text-align: right;margin:0 10px;">提问者:${template.userId}&nbsp;&nbsp;${template.publishDate}</div>
			</div>
		</div>
	</div>
	
	<div class="outContent">
		<div class="inContent">
			<div style="padding:10px;">
				<form id="thisForm" name="thisForm" method="post">
					<input type="hidden" id="templateId" name="templateId" value="${template.id}">
					<table>
						<tr>
							<td>我来说说：</td>
							<td><textarea cols="80" rows="10" id="askContent" name="askContent"></textarea> </td>
						</tr>
						<tr>
							<td>&nbsp; </td>
							<td><input id="pass" icon='icon-config' type='submit' onclick="return goAdd();" value='提 交'></td>
							
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<br/>
	
	<div class="outContent" id="askDiv">
		<div class="inContent">
			<div class="title">回复</div>
			<c:forEach items="${askList}" var="ask">
			<div style="padding:10px;">
				${ask.askContent}
			<div style="text-align: right;margin:0 10px;">回复者：${ask.userId} &nbsp;&nbsp;${ask.askDate}</div>
			</div>
			<div class="dash"></div>
			</c:forEach>
		</div>
	</div>
	
</body>
	<script type="text/javascript">
		
		$(function () {
		
			if("${fn:length(askList)}" == 0){
				$("#askDiv").css("display","none") ;
			}
			
			$('#file').uploadFile({
				indexId: '${template.id}',
				module:'template',
				forbitUpload:true,
				forbitDel:true,
				onDownload:donwloadSuc
			});  
		})	;
		
		function donwloadSuc() {
			var resText = true ;
			
			if(!resText) return false;
			var url = "${pageContext.request.contextPath}/common/template.do?method=addDownloadInfo" ;
			var data = "&mark=${template.mark}&module=template&indexid=${template.id}" ;
			var resText = "";
			
		   $.ajax({
	            url: url,   //接收页面
	            type: 'post',      //POST方式发送数据
	            async: false,      //ajax同步
	            data: data,
	            success: function(msg) {
	            	if(msg == "ok") {
	            		resText = true;
	            	}else if(msg == "notenough"){
	            		alert("您的资源分不足，不能下载此模板！");
	            		resText = false ;
	            	}else {
	            		alert("扣除资源分出错，请稍候再试！");
	            		resText = false ;
	            	}
	               
	            }
       	 });
       	 return resText ;
		}
		
		function goAdd() {
			var askContent = document.getElementById("askContent").value ;
			if(askContent == "") {
				alert("请输入您要发表的内容！");
				return false ;
			}
			document.thisForm.action = "${pageContext.request.contextPath}/common/template.do?method=saveAsk";
		}
		
		
	</script>
</html>
 