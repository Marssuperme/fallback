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
<style>
.subMenu {
	display: "";
}

.subMenuNone {
	display: none;
}

.subMenu li {
	padding-left: 5px !important;
}

.subMenu li a  {
	font-size:12px !important;
	font-weight:normal !important;
}
</style>
</head>
<body>
	
	<jsp:include page="/top.jsp" flush="true"></jsp:include>

	<table id="mainTable" cellpadding="0" cellspacing="0" style="height: 1950px;">
		<tr>
			<td id="td1" width="190px;" align="center" style="padding:10px;padding-left:5px;" bgcolor="#eff7e2" valign="top">
				<div id="welcome">
					<img src="${pageContext.request.contextPath}${userPhotoSrc }" style="padding-bottom: 10px;" height="150" width="150"/>
						<br>
						<font color="red">${userSession.userMap.loginname}</font> ，您好！<br/>
					今天是${today}
				</div>
				
				<div id="leftMenu">
					<ul> 
						<li>
							<img src="${pageContext.request.contextPath}/icons/Network.png"/>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame" target=mainFrame>&nbsp;机构首页 </a>
						</li>
						<li><img src="${pageContext.request.contextPath}/icons/document.png"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="getSub('menu_1','menu_1')">&nbsp;办公OA</a>
							<ul id="menu_1" class="subMenuNone">
								<li><a href="${pageContext.request.contextPath}/common/document.do?method=dlist" target="mainFrame">公文收文</a></li>
								<li><a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=company" target="mainFrame">公告通知</a></li>
								<li><a href="${pageContext.request.contextPath}/common/task.do" target="mainFrame">在线填报</a></li>
							</ul>
						</li>
						<li><img src="${pageContext.request.contextPath}/icons/sixi.png"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="getSub('menu_2','menu_2')">&nbsp;会籍管理</a>
							<ul id="menu_2" class="subMenuNone">
								<c:if test="${userSession.userMap.officetype=='事务所'}">
									<li><a href="${pageContext.request.contextPath}/company/company.do?method=goAddFrame" target="mainFrame">事务所情况维护</a></li>
									<li><a href="${pageContext.request.contextPath}/common/micfoInfo.do?method=list" target="mainFrame">所内注师简历维护</a></li>
									<li><a href="${pageContext.request.contextPath}/common/micfoRegister.do?method=index" target=mainFrame>执业会员注册管理</a></li>
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所'}">
									<li><a href="${pageContext.request.contextPath}/company/company.do?method=goAddFrame" target="mainFrame">评估机构情况维护</a></li>
									<li><a href="${pageContext.request.contextPath}/common/assesserInfo.do?method=list" target="mainFrame">所内评估师简历维护</a></li>
								</c:if>
							</ul>
						</li>
						<li><img src="${pageContext.request.contextPath}/icons/selfcheck.png" border=0/><a href="javascript:void(0);" onclick="getSub('menu_3','menu_3')">&nbsp;&nbsp;报告防伪报备</a>
							<ul id="menu_3" class="subMenuNone">
								<li><a href="${pageContext.request.contextPath}/common/bb.do?method=go&p=addFrame&model=baobei" target="mainFrame">报告防伪报备</a></li>
								<li><a href="${pageContext.request.contextPath}/common/content.do?method=index&p=ywfxtj&model=tongji" target="mainFrame">业务情况统计分析</a></li>
								<li><a href="${pageContext.request.contextPath}/common/bb.do?method=bbHistoryList" target="mainFrame">报备数据变更记录</a></li>
							</ul>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/icons/money.png" border=0/><a href="${pageContext.request.contextPath}/common/bb.do?method=goFsList" target="mainFrame"">&nbsp;&nbsp;&nbsp;审核分所报备</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/icons/pen.png" border=0/><a href="${pageContext.request.contextPath}/common/shzrtb.do?method=index"   target="mainFrame"">&nbsp;&nbsp;社会责任填报</a>
						</li>
					</ul>
				</div>
			
			</td>
	    	<td width="1" id="td2" style="padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-left.gif" alt="伸宿主菜单" onclick="extend(1);"/></td>
	    	<td width="1" id="td3" style="display: none;padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-right.gif" alt="伸宿主菜单" onclick="extend(2);"/></td>
			<td align="left" style="padding:0px; height:100%; overflow:auto" valign="top"> 
				<div id="rightDiv">
					<iframe src="${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame" id="mainFrame" name="mainFrame" 
							onload="reinitIframe('mainFrame');" frameborder="0" style="height: 100%;" width="99%" scrolling="no">
					</iframe>
				</div>
			</td>
		</tr>
	</table>


	<jsp:include page="/bottom.jsp" flush="true"></jsp:include>
	
</body> 
<script>
function getSub(menuId,p) {
	var ul = document.getElementById(menuId);
	
	for(var i = 1;i<4;i++){
		var temp = document.getElementById("menu_"+i);
		if(p!=temp.id){
			temp.className = "subMenuNone";
		}else{
			if(ul.className == "subMenuNone") {
				ul.className = "subMenu";
			} else {
				ul.className = "subMenuNone";
			}
		}
		
	}
}

//伸宿主菜单
function extend(index){
	if(index==1){
		document.getElementById("td1").style.display="none";
		document.getElementById("td2").style.display="none";
		document.getElementById("td3").style.display="";
	}else{
		document.getElementById("td1").style.display="";
		document.getElementById("td2").style.display="";
		document.getElementById("td3").style.display="none";
	}
}
</script>
<html>