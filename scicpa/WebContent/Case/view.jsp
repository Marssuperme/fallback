<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>查看案例</title>
<script language="javascript" src="${pageContext.request.contextPath}/JS/weebox.js"></script> 
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/weebox.css">
<style>

	body {
		margin: 0px ;
		padding: 0px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		padding-top: 5px;
		padding-left:10px;
	    position:fixed;
	    _position:absolute;
	    left:0px;
	    top: 0 px ;
	    background-color: #fff;
	} 
	
	.content {
		width:100% ;
		padding-bottom:150px;
		padding-top: 100px;
		padding-left:20px;
		padding-right:30px;
	}
	
	.foot_bar{
	  position:fixed;
	  bottom:0;
	  left:0;
	  color:#fff;
	  border:1.5px solid #eff7e2;
	  font-weight:bold;
	  width:100%;
	  z-index:100;
	  height:150px;
	  line-height:58px;
	  display:block;
	  text-indent:16px;
	  _position:absolute; /* for IE6 */
	  _top: expression(documentElement.scrollTop + documentElement.clientHeight-this.offsetHeight); /* for IE6 */
	  overflow:visible;
	  _width:100%; ;
	  background-color: #fff;
	}
	
	.hd{
	  width: 100%;
	  background-color: #e6f4d0;
	  height: 24px;
	  line-height:25px;
	  color: #125908;
	  font-size: 14px ;
	}
	
	ul {
		color:#030303;
		text-align: top;
		line-height:20px;
	}
	
	li a{
		color:#030303;
		font-size:12px;
		text-decoration:none;
	}
	li a:hover {
		color:#0066cc ;
	}
	
	
	#askQuestion 
	{
		position: absolute;
		left:250px;
		top:80px;
		width:700px;
		height:350px;
		background-color:#f0f5FF;
		border: 1px solid #000;
		z-index: 50;
	}
	#askQuestion_handle 
	{
		background-color:#5588bb;
		padding:2px;
		text-align:center;
		font-weight:bold;
		color: #FFFFFF;
		vertical-align:middle;
	}
	#askQuestion_content 
	{
		padding:5px;
	}
	#close
	{
		float:right;
		text-decoration:none;
		color:#FFFFFF;
	}

	
</style>

</head>
<body>

<div class="tools">
	<c:if test="${check != '' && check !=null}">
		&nbsp;<input id="pass" icon='icon-config' type='button' onclick="goAudit(1);" value='审核通过'>
		&nbsp;<input icon='icon-config' id="notPass" onclick="goAudit(0);" type='button' value='审核不通过'>
	</c:if>
	
	<c:if test="${view != '' && view !=null}">
		&nbsp;<input icon='icon-config' id="notPass" onclick="update();" type='button' value='我要纠错'>
		&nbsp;<input icon='icon-question' onclick="goAdd();" type='button' value='我要提问'>
	</c:if>
	&nbsp;<input icon='icon-cancel' onclick="window.close();" type='button' value='关闭'>
	<table border=0 cellspacing=0 width=100% cellpadding=3 align=center style="background-color: #FFF;">
		<tr><Td align=center style="font-size:14px"><b><font color=maroon>${cases.title}</font></b></td></tr>
		<tr>
			<td align=center style="font-size:14px">
			<font color=#614E4E>　作者：${cases.author}</font> 	</td>
		</tr>
		<tr><Td height=5></td></tr>
	</table>
</div>

<div class="content">
	${cases.content}
</div>

<div class="foot_bar">
	<div class="hd">
		<img src="${pageContext.request.contextPath}/icons/question_blue.png"> </img> &nbsp;相关问题
		<span style="float: right"><a href="#" style="text-decoration:none;">更多</a></span>
	</div>
	<div style="height:76;overflow: auto;">
		<ul>
			
			<c:forEach items="${questions}" var="question">
				<li><span><a href="${pageContext.request.contextPath}/common/question.do?method=view&id=${question.id}" target="_blank">${question.title}</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>


<div id="askQuestion" style="display:none">
	<form action="" id="thisForm" name="thisForm" method="POST"> 
		<table>
			<tr>
				<td>标题:</td>
				<td><input type="text" size="80" id="title" name="title"></td>
			</tr>
			<tr>
				<td>内容:</td>
				<td><textarea cols="62" rows="15" id="content" name="content"></textarea></td>
			</tr>
		</table>
		<input type="hidden" value="${cases.id}" id="policyId" name="policyId">
 	</form>
</div>	

<script language="javascript">
	//flag 1代表通过，0代表不通过
	function goAudit(flag) {
		 var result = $.ajax({
		  	url: "${pageContext.request.contextPath}/common/case.do?method=audit",
		  	data: "id=${checkId}&state="+flag+"&random="+Math.random(),
		  	async: false
		 }).responseText;
	   alert(result);
	  $("#pass").btn().disable();
	  $("#notPass").btn().disable();
	}
	   
	function update() {
      	window.location = "${pageContext.request.contextPath}/common/case.do?method=update&id=${cases.id}" ;
    }
    
    //显示浮动窗口的方法   
	function showWin() {
	   $.weeboxs.open('#askQuestion',{width:600,height:300,title: '请输入您的问题',okBtnName:'提交',onok:function(){saveQuestion()}});
	}  
	
	
	function saveQuestion() {
	   document.thisForm.action = "${pageContext.request.contextPath}/common/case.do?method=saveQuestion" ;
	   document.thisForm.submit();
	}
	
	 function goAdd() {
       	window.open("${pageContext.request.contextPath}/common/question.do?method=addView&ctype=cases&typeId=${cases.id}");
     }  
	
</script>
</body>
</html>
 