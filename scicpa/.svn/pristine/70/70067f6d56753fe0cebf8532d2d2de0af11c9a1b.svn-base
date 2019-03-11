<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实习信息</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}


	body {
		margin: 0px ;
		padding: 0px ;
		font-size:12px;
		overflow: auto;
		padding: 0 100;
	}
	
	.tools {
		width:100%;
		height:27px ;
		background-image: url("${pageContext.request.contextPath}/images/toolBarBg.gif");
		padding-top: 5px;
		padding-left:10px; 
	} 
	
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css?v=${modifyDate}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
</head>
<body>
<form name="thisForm" id="thisForm" method="post" enctype="multipart/form-data" >

	<center class="formTitle" >
	实&nbsp;&nbsp;习&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>

	<hr>
	
	<input name="loginid" type="hidden" id="loginid"  value="${userSession.userMap.loginid }"  >
	<input name="dateandtime" type="hidden" id="dateandtime"  value="${dateandtime }"  >
	<input name="lastpost" type="hidden" id="lastpost"  value="${userSession.userMap.loginid }"  >
	<input name="lastposttime" type="hidden" id="lastposttime"  value="${dateandtime }"  >
	<input name="attachmentname" type="hidden" id="attachmentname"  value="${attachmentname }"  >
	
	<input name="istop" type="hidden" id="istop"  value="0"  >
	<input name="child" type="hidden" id="child"  value="0"  >
	<input name="hits" type="hidden" id="hits"  value="0"  >
	<input name="btype" type="hidden" id="btype"  value="实习"  >
	
	<input name="attachmentid" type="hidden" id="attachmentid"  value="${attachmentid }"  >
	
		<table width="98%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>标题</strong></font></td>
			<td bgColor="#EEEEEE" ><input name="topicname" type="text" id="topicname"  style="height:20px;width:500px" value = ""></td>
		</tr>
<!--  		
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE">分类：</td>
			<td bgColor="#ffffff">
			<select id="btype">
				<option value="招聘">招聘</option>
				<option value="实习">实习</option>
			</select>
			</td>
		</tr>
 -->		
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>分数</strong></font></td>
			<td bgColor="#ffffff" ><input name="fraction" type="text" id="fraction"  size="10"  value = "0"></td>
		</tr>
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>附件</strong></font></td>
			<td bgColor="#ffffff" >
			<div id = "attachment"></div>
			<!-- <input name="attachment" type="file" id="attachment"  style="width:100%" > -->
			</td>
		</tr>
		<tr>
			<td align="right" valign="top" width="15%" height="450" bgColor="#EEEEEE" ><font color="#0000FF"><strong>内容</strong></font></td>
			<td bgColor="#ffffff" ><textarea id='body' name="body" ></textarea></td>
		</tr>
		</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
      <input type="button" icon='icon-save' name="next" value="保 存"  onclick="return saveInfo();" >
    </td>
    <td width="8%">&nbsp;</td>
	<td width="55%">
    	<input type="button" icon='icon-back' value="返 回" onclick="go()">
    </td>
  </tr>
</table>

</form>
</body>
</html>
<script type="text/javascript">
 
	initHtmlbox("body","100%","100%");

	$('#attachment').uploadFile({
		indexId: '${attachmentid }',
		module:'b_topic'
	});   
	   
	function saveInfo(){
		
		var topicname = document.getElementById("topicname").value;
		var body = document.getElementById("body").value;
		if(topicname == ""){
			alert("标题不能为空，请重新输入！");
			document.getElementById("topicname").focus();
			return false;
		}
		if(body == ""){
			alert("内容不能为空，请重新输入！");
			document.getElementById("body").focus();
			return false;
		}
		
		document.thisForm.action = "${pageContext.request.contextPath}/common/internship.do?method=save";
		document.thisForm.target = "";
		document.thisForm.submit();
		return true;
	}
	
	/*返回*/
	function go(){
		window.location="${pageContext.request.contextPath}/common/internship.do";
	}
</script>

