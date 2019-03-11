<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评估师</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/common.js" charset="gbk"></script>
</head>
<body>
	<jsp:include page="/top.jsp" flush="true"></jsp:include>

	<table id="mainTable" cellpadding="0" cellspacing="0" style="height: 900px">
		<tr>
			<td width="190px;" align="center" style="padding:10px;padding-left:5px;" bgcolor="#eff7e2" valign="top">
				<div id="welcome">
					<img src="${pageContext.request.contextPath}${userPhotoSrc }" style="padding-bottom: 10px;" height="150" width="150"/>
						<br/>
						<font color="red">${userSession.userMap.loginname}</font> ，您好！<br/>
						今天是${today}
				</div>
				
				<div id="leftMenu">
					<ul>
						<div class="dash"></div>
						<li><a href="${pageContext.request.contextPath}/assesser/assesser.do?method=goAddFrame&param=mainFrame" target=mainFrame><img src="${pageContext.request.contextPath}/icons/Network.png" border=0/>&nbsp;&nbsp;个人首页</a></li>
						<li><a href="${pageContext.request.contextPath}/assesser/assesser.do?method=goAddFrame" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/zianli.png" border=0/>&nbsp;&nbsp;我的简历</a></li>
						<li><a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=assesser" target=mainFrame><img src="${pageContext.request.contextPath}/icons/Info.png" border=0/>&nbsp;&nbsp;最新通知</a></li>
						<div class="dash"></div>
					</ul>
				</div>
			
			</td>
	    
			<td align="left" style="padding: 0px;" valign="top">
				<div id="rightDiv" style="height: 1500px;"> 
					<iframe src="${pageContext.request.contextPath}/assesser/assesser.do?method=goAddFrame&param=mainFrame" id="mainFrame" name="mainFrame"
						 onload="reinitIframe('mainFrame');" frameborder="0" width="99%" scrolling="no" style="height: 1480px;">
					</iframe>
				</div>
			</td>
		</tr> 
	</table>
	<jsp:include page="/bottom.jsp" flush="true"/>
</body> 
<html>