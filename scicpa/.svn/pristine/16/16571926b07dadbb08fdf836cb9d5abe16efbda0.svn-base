<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监管作业</title>


<style type="text/css">
	
	body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
	}

	.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
	}
	
	
	.gridFrame {
		width: 100%; 
		height:500px;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 
</style>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
		
<input type="hidden" value="${typeid }" id="typeid" name="typeid">
  <div class="gridFrame" >	 
    	<!--  
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_view();" value='查看'> 
		    </div>
	   <center class="formTitle">
			请&nbsp;&nbsp;选&nbsp;&nbsp;择&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;监&nbsp;&nbsp;管&nbsp;&nbsp;项&nbsp;&nbsp;目<br />
	   </center>
	   <br>
		 -->
	        
	    <div style="width:100%;height: 90%;overflow:auto;"> 
	    	<mt:DataGridPrintByBean name="testerNoticeList"/>
	    </div>
	</div>
</form>

</body>
<script type="text/javascript">
	 

	// 进入监管作业界面 
	function f_viewTD(nid,userid,companyid,testyear,endPublishDate){
		document.myform.action = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&id="+nid+"&userid="+userid+"&companyid="+companyid+"&testyear="+testyear+"&endPublishDate="+endPublishDate;
		document.myform.submit();
	}
	
	
</script>

</html>