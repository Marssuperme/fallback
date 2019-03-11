<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘信息</title>
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/posts.css?v=${modifyDate}">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
<style>

.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<form name="thisForm" id="thisForm" method="post" enctype="multipart/form-data" >
	<center class="formTitle" >
	招&nbsp;&nbsp;聘&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>
	


<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
	<div id="divProduce" style="position:absolute;width:750px;height:400px; z-index:2;left:expression((document.body.clientWidth-800)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
	<fieldset>
		<legend><font size="2">回复内容</font></legend>
		
		<table width="100%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="50px" bgColor="#EEEEEE"><font color="#0000FF"><strong>附件</strong></font></td>
			<td bgColor="#ffffff" >
			<!-- <input name="attachment" type="file" id="attachment"  style="width:100%" > -->
			<div id = "attachment"></div>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top" width="50px" height="400px" bgColor="#EEEEEE" ><font color="#0000FF"><strong>内容</strong></font></td>
			<td bgColor="#ffffff" ><textarea id='postbody' name="postbody" ></textarea></td>
		</tr>
		</table>
		
		<input type='button' icon='icon-save' value='确定' onclick="return savePort();">
		<input type="button" icon='icon-delete' value="关闭" onclick="hiddenProDiv();">
	</fieldset>
</div>

<div id="divBlock1" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<div id="divProduce1" style="position:absolute;width:200px;height:50px; z-index:2;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
	<fieldset>
		<legend><font size="2">评分</font></legend>
		
		<table width="100%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="50px" bgColor="#EEEEEE"><font color="#0000FF"><strong>得分</strong></font></td>
			<td bgColor="#ffffff" ><input name="scoring" type="text" id="scoring"  value="0" onfocus="this.select();"></td>
		</tr>
		</table>
		<input name="key" type="hidden" id="key"  value=""  >
		<input name="postid1" type="hidden" id="postid1"  value=""  >
		<input name="topicid1" type="hidden" id="topicid1"  value=""  >	
			
		<input type='button' icon='icon-save' value='确定' onclick="return saveScoring();">
		<input type="button" icon='icon-delete' value="关闭" onclick="hiddenProDiv();">
	</fieldset>
</div>

<input name="loginid" type="hidden" id="loginid"  value="${userSession.userMap.loginid }"  >
<input name="topicid" type="hidden" id="topicid"  value="${topicMap.topicid }"  >
<input name="attachmentname" type="hidden" id="attachmentname"  value="${attachmentname }"  >
<input name="attachmentid" type="hidden" id="attachmentid"  value="${attachmentid }"  >

<div class="tit">
<dfn>
<c:if test="${userSession != null }">
<input icon="icon-add" type="button" value = "回复" onclick="getPort();">
</c:if>
<input icon="icon-back" type="button" value = "返回" onclick="go();">
</dfn>
<h1>${topicMap.topicname }</h1>
</div>	
<table cellspacing="0" cellpadding="0" class="mframe">
  <tr>
	<td rowspan="2" class="lf">
		<div class="df">
		<ul>
			<li class="center"><img height="120" width="100" src="${pageContext.request.contextPath}${topicMap.userphotosrc }" /></li>
			<li ><dfn>${topicMap.loginname }</dfn></li>
			<li></li>
		</ul>
		</div>
	</td>
	<td class="rw">
		<div class="fbart">
			<em>楼主</em>
			<img id="online" src="${pageContext.request.contextPath}/icons/online_member.gif">&nbsp;&nbsp;发表于：&nbsp;&nbsp;${topicMap.dateandtime }
		</div>

		${topicMap.body }
		<br><br><br><br>
		
			<div id = "attachmentFile"></div>
<script type="text/javascript">
	$('#attachmentFile').uploadFile({
		indexId: '${topicMap.attachmentid }',
		module:'b_topic',
		forbitUpload:true,
		forbitDel:true
	}); 
</script>	
	
	</td>
  </tr>
  <tr>
	<td class="rb">
		<div class="fbarb">		
			<dfn>问题点数：${topicMap.fraction }分</dfn>回复次数：<span >${topicMap.child }</span>
			
		</div>
	</td>
	</tr>
</table>	

<c:set var="number" value="1"></c:set>	
<c:forEach items="${postsList}" var="post" >
	
<table cellspacing="0" cellpadding="0" class="mframe">
  <tr>
	<td rowspan="2" class="lf">
		<div class="df">
		<ul>
			<li class="center"><img height="120" width="100" src="${pageContext.request.contextPath}${post.userphotosrc }" /></li>
			<li ><dfn>${post.loginname }</dfn></li>
			<li></li>
		</ul>
		</div>
	</td>
	<td class="rw">
		<div class="fbart">
			<dfn>#${number }楼&nbsp;&nbsp;得分：<span id=p_${number}>${post.scoring }</span></dfn>
			<img id="online" src="${pageContext.request.contextPath}/icons/online_member.gif">&nbsp;&nbsp;回复于：&nbsp;&nbsp;${post.posttime }
		</div>

		${post.postbody }
		<br><br><br><br>
		
		<div id = "${post.attachmentid }"></div>
<script type="text/javascript">
	$('#${post.attachmentid }').uploadFile({
		indexId: '${post.attachmentid }',
		module:'b_post',
		forbitUpload:true,
		forbitDel:true
	}); 
</script>

	</td>
  </tr>
  <tr>
	<td class="rb">
		<div class="fbarb">
	   	<ul>		
			<li>
<c:if test="${userSession.userMap.loginid == topicMap.loginid}">			
			<a href="###" onclick="getScoring('p_${number}','${post.postid }','${post.topicid }');">评分</a>&nbsp;&nbsp;
</c:if>			
			<a href="#top" >TOP</a>
			</li>
		</ul>		
		</div>
	</td>
	</tr>
</table>	
		

<c:set var="number" value="${number+1 }"></c:set>
</c:forEach>
	
</form>

</body>
</html>
<script type="text/javascript">
<!--

	$('#attachment').uploadFile({
		indexId: '${attachmentid }',
		module:'b_post'
		//forbitUpload:true,
		//forbitDel:true
	}); 
	
initHtmlbox("postbody","100%","100%");

function getPort(){
	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	var postbody =  document.getElementById("postbody");
	divObj.style.display = "";
	blockObj.style.display = "";
	postbody.value = "";
	
}

function hiddenProDiv() {
	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
	
	divObj = document.getElementById("divProduce1");
	blockObj =  document.getElementById("divBlock1");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}

//保存回复
function savePort(){
	var postbody = document.getElementById("postbody").value;	
	if(postbody == ""){
		alert("内容不能为空，请重新输入！");
		document.getElementById("postbody").focus();
		return false;
	}
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/recruitment.do?method=saveport";
	document.thisForm.target = "";
	document.thisForm.submit();
	return true;
}

//贴子评分
function getScoring(key,pid,tid){
	
	var divObj = document.getElementById("divProduce1");
	var blockObj =  document.getElementById("divBlock1");
	var scoring =  document.getElementById("scoring");
	divObj.style.display = "";
	blockObj.style.display = "";
	scoring.value = "0";

	document.getElementById("key").value = key;	
	document.getElementById("postid1").value = pid;
	document.getElementById("topicid1").value = tid;
	
}

//保存贴子评分
function saveScoring(){
	var key = document.getElementById("key").value;

	var postid1 = document.getElementById("postid1").value;
	var topicid1 =  document.getElementById("topicid1").value;
	var scoring = document.getElementById("scoring").value;
	
	if(isNaN(scoring)){
		alert("得分填写有错误，请重写！");
		document.getElementById("scoring").select();
		return ;
	}
	if(scoring == 0){
		alert("零分不需要评审，请重写！");
		document.getElementById("scoring").select();
		return ;
	}
	
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	var url="${pageContext.request.contextPath}/common/recruitment.do?method=savescoring&postid="+postid1+"&topicid="+topicid1+"&scoring="+scoring+"&random="+Math.random() ;
	oBao.open("POST",url,false);
	oBao.send();

	resText = oBao.responseText ;
	if(resText.indexOf("ok")>-1){
		document.getElementById(key).innerText = scoring;
		document.getElementById("scoring").value = "0";
		hiddenProDiv()
	}else{
		alert(resText);
		document.getElementById("scoring").select();
	}
}

function go(){
	window.location="${pageContext.request.contextPath}/common/recruitment.do";
}
//-->
</script>


