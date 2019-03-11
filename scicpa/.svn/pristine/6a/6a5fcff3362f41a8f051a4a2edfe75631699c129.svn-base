<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>非执业会员</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/common.js" charset="gbk"></script>
</head>
<body>
	<jsp:include page="/top.jsp" flush="true"></jsp:include>

	<table id="mainTable" cellpadding="0" cellspacing="0"  style="height: 900px">
		<tr>
			<td id="td1" width="190px" align="center" style="padding: 10px;padding-left:5px;" bgcolor="#eff7e2" valign="top">
				<div id="welcome">
				<img src="${pageContext.request.contextPath}${userPhotoSrc }" style="padding-bottom: 10px;" height="150" width="150"/>
						<br/>
						<font color="red">${userSession.userMap.loginname}</font> ，您好！<br/>
						今天是${today}
				</div>
				
				<div id="leftMenu">
					<ul>
						<div class="dash"></div>
						<li><a href="${pageContext.request.contextPath}/micfono/micfono.do?method=goAddFrame&param=mainFrame" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/Network.png" border=0/>&nbsp;&nbsp;个人首页</a></li>
						<li><a href="${pageContext.request.contextPath}/micfono/micfono.do?method=goAddFrame" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/zianli.png" border=0/>&nbsp;&nbsp;我的简历</a></li>
						<li><a href="${pageContext.request.contextPath}/common/training.do?method=networkSchool" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/check2.png" border=0/>&nbsp;&nbsp;继续教育学习</a></li>
						<li><a href="${pageContext.request.contextPath}/common/annualInspection.do?method=listXS" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/searchs.png" border=0/>&nbsp;&nbsp;继续教育学时查询</a></li>
						<li><a href="${pageContext.request.contextPath}/common/annualInspection.do?method=listYeepay" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/money2.png" border=0/>&nbsp;&nbsp;会费缴纳</a></li>
						<li><a href="${pageContext.request.contextPath}/common/annualInspection.do?method=listMember" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/check2.png" border=0/>&nbsp;&nbsp;申请年检</a></li>
						<li><a href="${pageContext.request.contextPath}/common/bill.do?method=listBill" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/money.png" border=0/>&nbsp;&nbsp;会费发票申请</a></li>
						<li><a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=micfono" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/Info.png" border=0/>&nbsp;&nbsp;公告通知</a></li>
						<li><a href="${pageContext.request.contextPath}/common/message.do?method=messageList" target="mainFrame"><img src="${pageContext.request.contextPath}/icons/Info.png" border=0/>&nbsp;&nbsp;消息</a></li>
						<!-- 
						<li><a href="${pageContext.request.contextPath}/common/inspection.do?method=micfono" target=mainFrame><img src="${pageContext.request.contextPath}/icons/check2.png" border=0/>&nbsp;&nbsp;非执业年检信息</a></li>
						<li><a href="${pageContext.request.contextPath}/common/nianjian.do?method=list" target=mainFrame><img src="${pageContext.request.contextPath}/icons/zianli.png" border=0/>&nbsp;&nbsp;填报年检表</a></li>
						 -->
						<div class="dash"></div>
					</ul>
				</div>
				</td>
				<td width="1" id="td2" style="padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-left.gif" alt="伸宿主菜单" onclick="extend(1);"/></td>
		    	<td width="1" id="td3" style="display: none;padding-top:250px;" valign="top"><img style="cursor: hand;" src="${pageContext.request.contextPath}/images/mini-right.gif" alt="伸宿主菜单" onclick="extend(2);"/></td>
				<td align="left" style="padding: 0px;" valign="top">
					<div id="rightDiv" style="height: 1500px;">  
						<iframe src="${pageContext.request.contextPath}/micfono/micfono.do?method=goAddFrame&param=mainFrame" id="mainFrame" name="mainFrame"
							 onload="reinitIframe('mainFrame');" frameborder="0" width="99%" scrolling="no" style="height: 1480px;">
						</iframe>
					</div>
			    </td>
		</tr>
	</table>

	<jsp:include page="/bottom.jsp" flush="true"></jsp:include>
	
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