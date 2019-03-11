<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板列表</title>


</head>
<body style="height:100%;">
	<div>
		&nbsp;<input id="pass" icon='icon-add' type='button' onclick="goAdd();" value='我要发布模板'>
	</div>
   		<mt:DataGridPrintByBean name="templateList"/>
</body>

<script type="text/javascript">
  	
        function goView(id) {
        	if(id == "") {
        		return;
        	}
        	window.location = "${pageContext.request.contextPath}/common/template.do?method=view&id="+id ;
        }
        
         function goAdd() {
        	window.location = "${pageContext.request.contextPath}/common/template.do?method=addView";
        }
        
   </script>
</html>
