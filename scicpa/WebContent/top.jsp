<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top</title>
</head>
<body>
	<!-- <div id="logoDiv"></div> -->
	
    <div id="topRightDiv">
    	<table width="100%" cellpadding="0" cellspacing="0" border="0">
    		<tr>
    			<td align="left" width="50%" valign="top">
    				<div id="fontDiv">四川省注协服务管理平台</div>
    				<!-- 
    				 <div id="fontDiv">注册会计师监管及其安全防伪技术软件</div>
    				 -->
    			</td>
    			<td align="right" valign="bottom" width="50%">
    				 <ul>
			            <li><a href="${pageContext.request.contextPath}/${tableName}/${tableName}.do?method=goAddFrame&param=mainFrame" target=mainFrame>返回首页</a></li>
			            <c:if test="${userSession.userMap.ctypetabname=='K_Company' }">
				            <li>|</li> 
				            <li><a target="_blank" href=http://shang.qq.com/wpa/qunwpa?idkey=a23ab99165d1c2c72ac9fa5d1550ee0ec0f3bf711727c7912260445093e49d85">客服Q群</a></li>
			            </c:if>
			            <li>|</li> 
			            <li><a target="_blank" href="tencent://message/?uin=1657810124&Site=public.gdicpa.org.cn&Menu=yes">客服QQ</a></li>
			            <li>|</li>
			            <li><a href="###" onclick="window.open('${pageContext.request.contextPath}/common/help.jsp');" >使用帮助</a></li>
			            <li>|</li>
			            <li><a href="###" onclick="if(confirm('是否退出登录?')){window.location='${pageContext.request.contextPath}/common/login.do?method=exit'};closeHtml();">退出登录</a></li> 
			        </ul>
    			</td>
    		</tr>
    	</table>
   	 	
        
    </div>    

    <div id="" style="background-color:#5ebd3b;height:15px;">
    </div>   
</body>
<script language="JavaScript">   
	// 屏蔽浏览器后退
    javascript:window.history.forward(1);   
</script>
</html>
