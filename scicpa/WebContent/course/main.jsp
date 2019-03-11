<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线视频教学</title>
<style type="text/css"> 
	body {margin: 10px;padding: 0px;overflow: hidden;background-color:#fffee2;}
	#title{width:100%;height:30px;background-color: #e6f4d0;color: #007500;border-bottom: 1px solid #e6f4d0;font-size:14px;line-height:25px;text-align: center;}
	#outlineContent{height:expression(document.body.clientHeight-40);overflow:auto;}
	#catalog{background-color: #ffce7b;padding:10px;height: 70%}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/course/JS/video.js"  ></script>
</head>
<body>
	 	<table width="100%" height="100%">
	 		<tr>
	 			<td width="30%">
					<div id="videoDiv" style="height:50%;">
		 				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						id="videoplayer" width="100%" height="100%"
						codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
							<param name="movie" value="${pageContext.request.contextPath}/common/video/MTVideo.swf?srcVideo=${course.video}" />
							<param name="quality" value="high" />
							<param name="bgcolor" value="#444444" />
							<param name="allowScriptAccess" value="sameDomain" />
							<embed src="" quality="high" bgcolor="#444444"
								width="100%" height="100%" name="MTVideo" align="middle"
								play="true"
								loop="false"
								quality="high"
								allowScriptAccess="sameDomain"
								type="application/x-shockwave-flash"
								pluginspage="http://www.adobe.com/go/getflashplayer">
							</embed>
						</object>
				 	</div>
				 	<div id="catalog">
				 		${course.outline} 
				 	</div>
	 			</td>
	 			<td height="100%">
	 				<div id="title">
			 			${course.title}
			 		</div>
			 		<div id="outlineContent">
			 			${course.content}
			 		</div>
	 			</td>
	 		</tr>
	 	</table>
</body>
<script>
</script>
</html>
