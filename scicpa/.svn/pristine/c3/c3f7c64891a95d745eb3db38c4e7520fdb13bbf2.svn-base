<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>团体会员</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/common.js" charset="gbk"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
<script>

</script>  
</head>
<body>
	<jsp:include page="/top.jsp" flush="true"></jsp:include>

	<table id="mainTable" cellpadding="0" cellspacing="0" style="height: 1000px;">
		<tr>
			<td width="190px;" align="center" style="padding:10px;padding-left:5px;" bgcolor="#eff7e2" valign="top">
				<div id="welcome">
					<img src="${pageContext.request.contextPath}${userPhotoSrc }" style="padding-bottom: 10px;" height="150" width="150"/>
						<br>
						<font color="red">${userSession.userMap.loginname}</font> ，您好！<br/>
					今天是${today}
				</div>
				
				<div id="leftMenu">
					<ul> 
						<li><a href="${pageContext.request.contextPath}/common/document.do?method=dlist" target=mainFrame><img src="${pageContext.request.contextPath}/icons/document.png"/>&nbsp;&nbsp;公文收文</a></li>
						<li><a href="${pageContext.request.contextPath}/common/bb.do?method=go&p=addFrame" target=mainFrame><img src="${pageContext.request.contextPath}/icons/selfcheck.png" border=0/>&nbsp;&nbsp;报告防伪报备</a></li>
						<div class="dash"></div>
						<li><a href="${pageContext.request.contextPath}/common/training.do?method=index&param=company" target=mainFrame><img src="${pageContext.request.contextPath}/icons/net.png" border=0/>&nbsp;&nbsp;培训通知</a></li>
						<li><a href="${pageContext.request.contextPath}/common/training.do?method=list" target=mainFrame><img src="${pageContext.request.contextPath}/icons/attach.png" border=0/>&nbsp;&nbsp;报名管理</a></li>
						<li><a href="${pageContext.request.contextPath}/common/pay.do?method=orderList" target=mainFrame><img src="${pageContext.request.contextPath}/icons/money.png" border=0/>&nbsp;&nbsp;支付管理</a></li>
						 
						<c:if test="${micfocount == 'Y' }">
							<li><a href="${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=index" target=mainFrame><img src="${pageContext.request.contextPath}/icons/retry.png" border=0/>&nbsp;&nbsp;自办培训班资格申请</a></li>
						</c:if>
						<div class="dash"></div>
						<li><a href="${pageContext.request.contextPath}/common/addApplyTrainHour.do?method=index" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/clients.png" border=0/>&nbsp;&nbsp;学时申报</a></li>
						<li><a href="${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=index" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/port.png" border=0/>&nbsp;&nbsp;自办培训班学时上报</a></li>
						<li><a href="${pageContext.request.contextPath}/common/recruitment.do" target=mainFrame><img src="${pageContext.request.contextPath}/icons/zaopin.png"/>&nbsp;&nbsp;招聘信息发布</a></li>
						<li><a href="${pageContext.request.contextPath}/common/internship.do" target=mainFrame><img src="${pageContext.request.contextPath}/icons/sixi.png"/>&nbsp;&nbsp;实习信息发布</a></li>
						<div class="dash"></div>
						<!-- 
							<li><a href="#"><img src="${pageContext.request.contextPath}/icons/zoom.png"/>&nbsp;&nbsp;网上年检</a></li> 
						-->
						<li><a href="${pageContext.request.contextPath}/company/company.do?method=goAddFrame" target=mainFrame><img src="${pageContext.request.contextPath}/icons/zianli.png" bo/>&nbsp;&nbsp;机构信息维护</a></li>
						<li><a href="${pageContext.request.contextPath}/common/new.do" target=mainFrame><img src="${pageContext.request.contextPath}/icons/Network.png"/>&nbsp;&nbsp;党群新闻</a></li>
						<li><a href="${pageContext.request.contextPath}/common/task.do" target=mainFrame><img src="${pageContext.request.contextPath}/icons/pen.png"/>&nbsp;&nbsp;在线填报</a></li>
						<li><a href="${pageContext.request.contextPath}/company/costpay.do" target=mainFrame><img src="${pageContext.request.contextPath}/icons/money2.png"/>&nbsp;&nbsp;会费填报</a></li>
						<li><a href="${pageContext.request.contextPath}/common/inspection.do?method=company" target=mainFrame><img src="${pageContext.request.contextPath}/icons/check2.png" border=0/>&nbsp;&nbsp;任职资格预查</a></li>
						<div class="dash"></div>
					</ul>
				</div>
			</td>
	    
			<td align="left" style="padding:0px;" valign="top"> 
				<div id="rightDiv" style="height: 960px; ">
					<iframe src="${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame" id="mainFrame" name="mainFrame" 
							onload="reinitIframe('mainFrame');" frameborder="0" style="height: 1020px;" width="99%" scrolling="no">
					</iframe>
				</div>
			</td>
		</tr>
	</table>


	<jsp:include page="/bottom.jsp" flush="true"></jsp:include>
</body> 
<html>