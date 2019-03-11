<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>查看法律法规</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/legislation.css" />

<style type="text/css">

	body {
		margin: 0px ;
		padding: 0px ;
	}
	
	/*
	.tools {
		width:100% ;
		height:27px ;
		padding-top: 5px;
		
		text-align: right; 		
	    position:fixed;
	    _position:absolute;  
	    left:0px;
	    top: 0 px ;
	    background-color: #fff;
	} 
	*/
	
	.content {
		width:100% ;
		/*padding-bottom:150px;*/  
		padding-bottom:0px;		 /*我改的*/
		/*padding-top: 30px;*/
		padding-top: opx;		/*我改的*/
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
	  _width:100%;
	  background-color: #fff;
	}
	
	.hd{
	  width: 100%;
	  background-color: #e6f4d0;
	  height: 24px;
	  line-height:25px;
	  color: #0066cc;
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

	/*	
	p { 
		text-indent: 2em;
	}
	p:first-child {
		font-weight: bold;
		//border: solid 1px red;
		text-align: center;
	}
	*/	
	
	<!--
	table {
		margin:0 auto;
	}
	-->

	.dan {
		background: #dfe6ee;
	}
	
.t {
	border: lightgray; 
	border-style: solid; 
	border-width: 1px;
} 
	
</style>

</head>
<body> 

<table width=768>
<tr><td align=right>

<div class="tools">
	<c:if test="${check != '' && check !=null}">
		&nbsp;<input id="pass" icon='icon-config' type='button' onclick="goAudit(1);" value='审核通过'>
		&nbsp;<input icon='icon-config' id="notPass" onclick="goAudit(0);" type='button' value='审核不通过'>
	</c:if>
	
	<c:if test="${view != '' && view !=null}">
		&nbsp;<input icon='icon-config' id="notPass" onclick="update();" type='button' value='我要纠错'>
		&nbsp;<input icon='icon-question' onclick="goAdd();" type='button' value='我要提问'>
	</c:if>
	<!-- 
	&nbsp;<input icon='icon-back' onclick="window.close();" type='button' value='返回'>
	 -->
	&nbsp;<input icon='icon-cancel' onclick="window.close();" type='button' value='关闭'>
</div>

</td></tr>
</table>
<!-- 
<div class="content">
	<table border=0 cellspacing=0 width=100% cellpadding=3 align=center bordercolor=#ffffff>
		<tr><Td align=center style="font-size:14px"><b><font color=maroon>${policy.title}</font></b></td></tr>
		<tr><Td align=center style="font-size:14px"><font color=#614E4E>${policy.wordNum}</font></td></tr>
		<tr>
			<td align=center style="font-size:14px">
					
			<font color=#614E4E>颁布日期：${policy.sendDate}</font><font color=#614E4E>　颁布单位：${policy.sendDepartment}</font></td>
		</tr>
		<tr><Td height=5></td></tr>
	</table>
	${content}
 -->

<div>

	<table border=0 cellspacing=0 width=768 cellpadding=3 align=center class=t>
		<tr class=dan>
			<td colspan=2><table align=left><tr><td width=75 valign=top>【法规标题】</td><td><b><font color=maroon>${policy.title}</font></b></td></tr></table></td>
		</tr>
		<tr>
			<td width=50%>【发布日期】${policy.sendDate}&nbsp;</td><td width=50%>【发文机关】${policy.sendDepartment}&nbsp;</td>
		</tr>	
		<tr class=dan>
			<td>【文号】${documentNumber }&nbsp;</td><td>【行业分类】${hangye }&nbsp;</td>
		</tr>	
		<tr>
			<td>【效力状态】<font color="red">${validityStatus }</font>&nbsp;</td><td>【效力级别】${xiaoli } &nbsp;</td>
		</tr>	
		<tr class=dan>
			<td>【主题分类】${zhuti }&nbsp;</td><td>【地域分类】${diyu }&nbsp;</td>
		</tr>	
			
		<tr>
			<td colspan=2 bgcolor=#e37c37></td>
		</tr>

		<tr>
			<td colspan=2><font color=red>【全文】</font></td>
		</tr>
	
		<tr>
			<td colspan=2>${content}</td>
		</tr>
		
		
		<c:if test="${isAttach=='Y'}">
			<tr>
				<td colspan=2 bgcolor=#e37c37></td>
			</tr>
			<tr>
				<td colspan=2><font color=red>【附件】</font></td>
			</tr>
			<c:forEach var="attach" items="${listAttach}">
				<tr class=dan>
					<td colspan=2>
					<!-- 
					<a href="${pageContext.request.contextPath}/Download_File${attach.filename }" target="_balnk">${attach.displayname }.${attach.type }</a><br>
					 -->
					<a href="javascript:;" onclick="f_download('${attach.attachmentid}')">${attach.displayname }.${attach.type }</a><br/>
					</td>
				</tr>	
				
			</c:forEach>
		</c:if>
		
	</table><br/><br/>















	
	
</div>
<!-- 
<div class="foot_bar" id="foot">
	<div class="hd">
		<img src="${pageContext.request.contextPath}/icons/question_blue.png"/>  &nbsp;相关问题
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
 -->


<div id="askQuestion" style="display:none">
	<form action="" id="thisForm" name="thisForm" method="post"> 
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
		<input type="hidden" value="${policy.id}" id="policyId" name="policyId">
 	</form>
 	
 	<iframe src="" id="go"  name="go" style="display: none"></iframe>
 	
</div>	





<script language="javascript">
	
	$(function (){
		if("${check}" != "" && "${check}" != "null") {
			$("#foot").css("display","none");
		}
	}) ;

	//flag 1代表通过，0代表不通过
	function goAudit(flag) {
		 var result = $.ajax({
		  	url: "${pageContext.request.contextPath}/common/policy.do?method=audit",
		  	data: "id=${checkId}&state="+flag+"&random="+Math.random(),
		  	async: false
		 }).responseText;
	   alert(result);
	  $("#pass").btn().disable();
	  $("#notPass").btn().disable();
	}
	   
	function update() {
      	window.location = "${pageContext.request.contextPath}/common/policy.do?method=update&id=${policy.id}" ;
    } 
    
    //显示浮动窗口的方法    
	function showWin() {
	   $.weeboxs.open('#askQuestion',{width:600,height:300,title: '请输入您的问题',okBtnName:'提交',onok:function(){saveQuestion()}});
	}  
	
	
	function saveQuestion() {
	   document.thisForm.action = "${pageContext.request.contextPath}/common/policy.do?method=saveQuestion" ;
	   document.thisForm.submit();
	}
	
	function goAdd() {
       	window.open("${pageContext.request.contextPath}/common/question.do?method=addView&ctype=policy&typeId=${policy.id}");
    }
	
	
	function f_download(attachmentId){
		//alert(attachmentId);
		document.getElementById("go").src = "${pageContext.request.contextPath}/common/policy.do?method=downPolicy&attachmentId="+attachmentId;
	}
	
</script>

</body>
</html>
 