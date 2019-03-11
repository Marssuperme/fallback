<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监管问题</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
	
</head>
<body>
 

<form id="thisForm" name="thisForm" method="post" action="">
<input name="ip" type="hidden" id="ip"  value="${pageContext.request.remoteAddr}"  >
<input name="testnoticeid" type="hidden" id="nid"  value="${testnoticeid}"  >
<input name="source" type="hidden" id="source"  value="${source}"  >
<input maxlength="50" name="userID" id="userID" style="width: 65%" type="hidden" value="${userSession.userMap.loginid}" >
<br><br>
<table width="90%" height="30%" border="0" cellpadding="0" align="center" cellspacing="1" bgcolor="#6595d6">

<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF"> 
	<h4>监 管 问 题</h4> 
	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
		<tbody id="SWlist">
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>被检查事务所</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" >
		  		<!-- 
		  		<input title="被检查事务所" class="required" size="35" id="companyname" name="companyname" refer="testnoticeid" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						valuemustexist="true"
						autoid=25  class="required" >
				 -->
				 	
				<input maxlength="50" id="companyname" name="companyname" title="被检查事务所" style="width: 65%" type="text" 
						class="required" 
						onfocus="onPopDivClick(this);"
						autoWidth=230
						autoHeight=460
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=65
						refer="userID"
						hideresult=true>		
										
			</td>
		</tr>
		 
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>被检查项目</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" >
		  		<input maxlength="50" id="project" name="project" style="width: 65%" type="text" class="required" 
						onfocus="onPopDivClick(this);"
						autoWidth=230
						autoHeight=460
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=66
						refer="companyname"
						hideresult=true>
		  	</td>
		</tr>
		
		<tr>
			<td align="right" bgColor="#EEEEEE"><strong>发现的问题</strong><font color="#FF0000">&nbsp;[*]</font></td>
			<td align="left" bgColor="#FFFFFF"> <textarea title="发现的问题" class="required" rows="7%" cols="90%" id="body" name="body"></textarea> </td>
		</tr>
	 	
		<tbody>
	</table>  
	<table width="20%" align="center">
	<tr> 
		<td>
			<input icon="icon-save" type="button" name="next" value="保存"  onclick="f_save()" >
		</td>
		<td>
			<input icon="icon-btncom" type="button" name="next" value="返回"  onclick="f_back();" >
		</td>
	</tr>
	</table>

	</td>
</tr>
</table>
</form>
</body>

<script type="text/javascript">
  $(document).ready(function(){
    $("#thisForm").validate();
    
    $("input.zipcode").mask("99999");
    
  });
  
   // 保存
   function f_save(){
		document.thisForm.action="${pageContext.request.contextPath}/common/supervision.do?method=addSupervisionTable";
		if (thisForm.fireEvent('onsubmit')){
			document.thisForm.submit();
		}
	}
	
	
	function f_back(){
		var source = "${source}";
		// 监管作业链接过来的
		if(source=="jzzc"){
			window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=jzzc";
		}else{
			window.history.back();
		}
	}
</script>

</html>