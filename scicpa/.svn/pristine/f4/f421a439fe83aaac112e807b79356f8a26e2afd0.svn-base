<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>执业会员</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/common.js" charset="gbk"></script>

</head>
<body>	
	<jsp:include page="/top.jsp" flush="true"></jsp:include>

	<table id="mainTable" cellpadding="0" cellspacing="0" style="height: 900px">
		<tr>
			<td id="td1" width="190px;" align="center" style="padding:10px;padding-left:5px;" bgcolor="#eff7e2" valign="top">
				<div id="welcome">
					<img src="${pageContext.request.contextPath}${userPhotoSrc }" style="padding-bottom: 10px;" height="150" width="150"/>
						<br/>
						<font color="red">${userSession.userMap.loginname}</font> ，您好！<br/>
						今天是${today}
				</div>
			
				<div id="leftMenu">
					<ul>
						<div class="dash"></div>
						<li><a href="${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame&param=mainFrame" target=mainFrame><img src="${pageContext.request.contextPath}/icons/Network.png" border=0/>&nbsp;&nbsp;个人首页</a></li>
						<li><a href="${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/zianli.png" border=0/>&nbsp;&nbsp;我的简历</a></li>
						<li><a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=micfo" target=mainFrame><img src="${pageContext.request.contextPath}/icons/Info.png" border=0/>&nbsp;&nbsp;最新通知</a></li>
						<!-- 
						<li><a href="${pageContext.request.contextPath}/common/supervision.do?method=testerNoticeList" target=mainFrame><img width="18" height="18" src="${pageContext.request.contextPath}/icons/jg.png" border=0/>&nbsp;&nbsp;监管作业</a></li>
						<li><a href="${pageContext.request.contextPath}/common/inspection.do?method=micfo" target=mainFrame><img src="${pageContext.request.contextPath}/icons/check2.png" border=0/>&nbsp;&nbsp;自我任职资格预查</a></li>
						 -->
						<div class="dash"></div>
						<!--
						<li><a href="${pageContext.request.contextPath}/micfo/transferClub.jsp" target=mainFrame><img width="18" height="18" src="${pageContext.request.contextPath}/icons/jg.png" border=0/>&nbsp;&nbsp;申请转所</a></li>
						<div class="dash"></div>
						-->
					</ul>
				</div>
			
			</td>
	    	<td width="1" id="td2" style="padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-left.gif" alt="伸宿主菜单" onclick="extend(1);"/></td>
	    	<td width="1" id="td3" style="display: none;padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-right.gif" alt="伸宿主菜单" onclick="extend(2);"/></td>
			<td align="left" style="padding: 0px;" valign="top">
				<div id="rightDiv" style="height: 1500px;"> 
					<iframe src="${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame&param=mainFrame" id="mainFrame" name="mainFrame"
						 onload="reinitIframe('mainFrame');" frameborder="0" width="99%" scrolling="no" style="height: 1480px;">
					</iframe>
					<div id="myDiv">
						
					</div>
				</div>
			</td>
		</tr> 
	</table>
	<jsp:include page="/bottom.jsp" flush="true"/>
	
<script type="text/javascript">
	window.onbeforeunload = onbeforeunload_handler;  
	window.onunload = onunload_handler;  
	function onbeforeunload_handler(){  
	    return warning;  
	}  
	  
	function onunload_handler(){  
	    closeHtml();
	} 
	
	function loginYJ(){  		
        var tempForm = window.document.createElement("form");          
        tempForm.id="tempForm1";  
        tempForm.method="post";  
        tempForm.action="http://ce.esnai.net/c/cpaguangdong/login.jsp";  
        tempForm.target="loginForm";  
        
        var loginname = window.document.createElement("input");  
        loginname.type="hidden";  
        loginname.name= "name";
        tempForm.appendChild(loginname); 
        
        var certno = window.document.createElement("input");  
        certno.type="hidden";  
        certno.name= "certno";
        tempForm.appendChild(certno); 
        
        var sign = window.document.createElement("input");  
        sign.type="hidden";  
        sign.name= "sign";
        tempForm.appendChild(sign); 
        
        loginname.value="${userSession.userMap.loginname}";
		certno.value="${userSession.userMap.loginid}";
		sign.value="${userSession.userMap.sign}";
        
        //tempForm.attachEvent("onsubmit",function(){ openWindow("loginForm"); });
		tempForm.onsubmit=function(){ openWindow("loginForm"); }

        window.document.body.appendChild(tempForm);  
        
        //tempForm.fireEvent("onsubmit");
        tempForm.submit();
        window.document.body.removeChild(tempForm);
    }
   
	var myHtml = null;
    function openWindow(name){  
        myHtml = window.open('about:blank',name,'height=400, width=400, top=0, left=0, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=yes, status=yes');   
    }  	
	//关闭远教窗口
	function closeHtml(){
		if(myHtml!=null){
			myHtml.location="http://ce.esnai.net/c/cpaguangdong/logout.jsp";
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
</body> 
</html>