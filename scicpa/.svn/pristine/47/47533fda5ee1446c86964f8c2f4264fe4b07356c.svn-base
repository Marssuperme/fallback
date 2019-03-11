<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>检查人员报名审批</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}
</style>


</head>
<body>


<form name="thisForm" method="post" action="" >

<!-- 选中人的编号  -->
<input type="hidden" id="tid2" name = "tid2" value="">

<!-- 选中人的名称  -->
<input type="hidden" id="tname2" name = "tname2" value="">


<input type="hidden" id="noticeId" name = "noticeId" value="${tnt.id }">
<input type="hidden" id="timelimit" name = "timelimit" value="${tnt.timelimit }">


<table width="100%" height="121" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
      <br>
	<h4>${tnt.title }</h4>


	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>标题</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.title }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>通知正文</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.acontent }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>发起机构</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.customerID }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>发起时间</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.atime }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>检查年份</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.testyear }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>检查报名人数上限</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.testerlimit }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>报名截止日期</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.timelimit }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>附件</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" ><div id="file"></div></td>
	</tr>
	 
</table>
<br> 
		<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1">
			<tr height=18>
				<td height="20" align="center" bgColor="#ffffff"><font color="red">个人用户无权报名，请用您所在事务所用户登录网站代报名</font></td>
			</tr>
		</table>	
	<br>
		<table width="90%" align="center">
			<tr>
				<td width="" align="center" > 
					<input icon="icon-back" type="button" name="next" value="返  回"  onclick="window.history.back();" >
				</td>
			</tr>
		</table>
	 
</body>
<script>
var num = "${tnt.attachment}";
// 附件
if(num!=null && num!=""){
	$('#file').uploadFile({
		indexId: '${tnt.attachment}',
		module:'k_testernotice',
		forbitUpload:true,
		forbitDel:true
	})
}; 
</script>
</html>