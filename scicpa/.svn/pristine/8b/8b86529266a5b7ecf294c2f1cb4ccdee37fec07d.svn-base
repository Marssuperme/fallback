<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法律法规审核</title>
<script src="/Web/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="/Web/CSS/jquery.tree.css"/>

<style type="text/css">
	
	body {
		padding:0px;
		margin:0px;
		font-size: 12px ;
	}

	.gridFrame {
		width: 100%; 
		height:600px;
		border: #eff7e2 1px solid;
		float: left;
		margin: 10px ;
		padding: 5px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 
	#desc {
		height : 27px ;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
</style>

</head>
<body>
	<input type="hidden" value="" id="typeId" name="typeId">
	    <div class="gridFrame">
		    <div id="desc">待审核法律法规列表：</div>
			<div style="height:1px;border-top:1px solid #007500;width: 100%;"></div> 
		    <div> 
		    	<mt:DataGridPrintByBean name="auditPolicyList"/>
		    </div>
		</div>
  <script type="text/javascript">
        
         function audit(chooseValue) {
        	if(chooseValue == "") {
        		return ;
        	}
        	window.location = "${pageContext.request.contextPath}/common/policy.do?method=checkView&id="+chooseValue;
        }
    </script>
</body>
</html>
