<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会费缴纳登记表</title>

<style>
	a:hover{color:#F00;text-decoration:underline;cursor:hand;}
</style>
</head>
<body style="height:100%;" >
	<div style="height:100%;">
		<input type="submit" icon='icon-add' name="next" value="登记会费"  onclick="goAdd();" >
   		<mt:DataGridPrintByBean name="costPayList"/>
	</div>	
</body>

<script type="text/javascript"> 

        function goView(id) {
        	if(id == "") {
        		return;
        	}
        	window.location = "${pageContext.request.contextPath}/company/costpay.do?method=goAdd&p=view&UUID="+id;
        }
        
        function goUpdate(id,property) {
        	if(id == "") {
        		return;
        	}
        	window.location = "${pageContext.request.contextPath}/company/costpay.do?method=goAdd&p=update&UUID="+id;
        }
        
        function goDel(id,property) {
			if(property == "已缴费") {
        		alert("缴费信息已经由省注协确认，不能删除!");
        		return ;
        	}else {
	        	if(confirm("您确定要删除吗?")){
		        	if(id == "") {
		        		return;
		        	}
		        	window.location = "${pageContext.request.contextPath}/company/costpay.do?method=del&UUID="+id;
	       		}
        	}
        }
        
         function goAdd() {
        	window.location = "${pageContext.request.contextPath}/company/costpay.do?method=goAdd";
        }
        
   </script>
</html>
