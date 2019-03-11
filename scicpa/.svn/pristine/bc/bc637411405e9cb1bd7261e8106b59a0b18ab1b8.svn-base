<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线填报</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}
</style>
</head>
<body>
<form name="thisForm" method="post" action="">

<input type="hidden" id="indexId" name="indexId" value="${taskMap.indexId }">
<input type="hidden" id="tid" name="tid" value="${taskMap.id }">
<input type="hidden" id="random" name="random" value="${taskMap.random }">
<input type="hidden" id="attachment" name="attachment" value="${taskMap.attachment}">
<input type="hidden" id="replyerattachment" name="replyerattachment" value="${taskMap.replyerattachment }">

<input type="hidden" id="enddate" name="enddate" value="${taskMap.enddate}">

<input type="hidden" id="loginname" name="loginname" value="${taskMap.loginname}">
<input type="hidden" id="title" name="title" value="${taskMap.title}">
<input type="hidden" id="replyId" name="replyId" value="${taskMap.replyId}">
 
<table width="100%" height="121" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
    <br>
	<h4>${taskMap.title }</h4>

	<table width="98%">
		<tr>
		  	<td align="left" >发布机构:&nbsp;&nbsp;${taskMap.fillarea} 
		  	&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		  	 发布时间:&nbsp;&nbsp;${taskMap.publishtime}</td>
		</tr>
	</table>
	
	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
	<tbody id="SWlist">
	
	<tr height=18>
	  	<td height="20" align="center" bgColor="#EEEEEE" width="13%"><strong>截止日期</strong></td>
	  	<td align="left" bgColor="#ffffff" width="87%">${taskMap.enddate}</td>
	</tr>
	
	<tr height=18>
	  	<td height="20" align="center" bgColor="#EEEEEE"><strong>填报说明</strong></td>
	  	<td align="left" bgColor="#ffffff" >
	  		<textarea cols="100%" rows="8%" readonly="readonly">${taskMap.describe}</textarea>
	  	</td>
	</tr>
	 
	<tr>
		<td height="22" align="center" bgColor="#EEEEEE"><strong>下载模板</strong></td>
		<td align="left" bgColor="#FFFFFF"><div id = "task"></div></td>
	</tr>
 	
 	<tr>
 		<td colspan="2" align="center" bgColor="#FFFFFF">进&nbsp;&nbsp;行&nbsp;&nbsp;填&nbsp;&nbsp;报</td>
 	</tr>
 	
 	<tr>
		<td height="22" align="center" bgColor="#EEEEEE"><strong>上传附件</strong></td>
		<td align="left" bgColor="#FFFFFF"><div id = "reply"></div></td>
	</tr>
	
	<tr>
		<td height="22" align="center" bgColor="#EEEEEE"><strong>补充说明</strong></td>
		<td align="left" bgColor="#FFFFFF">
			
			<c:if test="${taskMap.enddate<taskMap.nowtime}">
				<textarea cols="100%" rows="8%" id="contents" name="contents" readonly="readonly">${taskMap.contents} </textarea>
			</c:if>
			<c:if test="${taskMap.enddate>=taskMap.nowtime}">
				<textarea cols="100%" rows="8%" id="contents" name="contents">${taskMap.contents} </textarea>
			</c:if>
		</td>
	</tr>
	
	<c:if test="${taskMap.stext!='' && taskMap.stext != null}">
		<tr>
			<td height="22" align="center" bgColor="#EEEEEE"><strong>不通过原因</strong></td>
			<td align="left" bgColor="#FFFFFF">
				<textarea cols="100%" rows="8%" id="stext" name="stext" readonly="readonly">${taskMap.stext} </textarea>
			</td>
		</tr>
	</c:if>
	
	
	</tbody>
	</table>
	<br>

<c:if test="${taskMap.enddate>=taskMap.nowtime}">
	<table width="30%" align="center">
	<tr> 
		<td>
			<input icon="icon-save" type="button" name="next" value="确定填报"  onclick="goReply()" >
		</td>
		
		<td>
			<input icon="icon-back" type="button" name="next" value="返    回"  onclick="window.history.back();" >
		</td>
	</tr>
	</table>
</c:if>	
<c:if test="${taskMap.enddate<taskMap.nowtime}">
	<table width="30%" align="center" >
	<tr> 
		<td style="color: red;" align="center">
			填报日期已过期，不能在进行填报！
		</td>
	</tr>
	
	<tr> 
		<td align="center">
			<input icon="icon-back" type="button" name="next" value="返    回"  onclick="window.history.back();" >
		</td>
	</tr>
	</table>
</c:if>	

	</td>
</tr>
</table>
</form>
</body>
</html>
 
<script type="text/javascript">

	//模板  有附件就不再上传也不能删除模板
	if("${taskMap.indexId}"!=null && "${taskMap.indexId}"!=""){
		$('#task').uploadFile({
			indexId: '${taskMap.attachment}',
			module:'${taskMap.ttable }',
			mainId:'${taskMap.id}',
			forbitUpload:true,
			forbitDel:true
		});
	}else{                               // 没有模板附件就也能上传但不能删除
		$('#task').uploadFile({
			indexId: '${taskMap.attachment}',
			module:'${taskMap.ttable }',
			mainId:'${taskMap.id}',
			forbitUpload:true,
			forbitDel:true
		});
	 }
 

	if("${taskMap.enddate}">="${taskMap.nowtime}"){
		// 附件
		$('#reply').uploadFile({
			indexId: '${taskMap.replyerattachment}',
			module:'${taskMap.rtable}',
			mainId:'${taskMap.id}',
			forbitUpload:false,
			forbitDel:false
		});
	} 
	
	
	// 回复
	function goReply(){
		var now = new Date();
		var fullyear = now.getFullYear();
		var month = now.getMonth()*1+1;
		if(month<10){
			month="0"+month;
		}
		var date = now.getDate();
		
		if(date<10){
			date = "0"+date;
		}

		
		
		var nowtime = fullyear+"-"+month+"-"+date;
		var enddate = document.getElementById("enddate").value;

		
		if(enddate>=nowtime){
			document.thisForm.action="${pageContext.request.contextPath}/common/task.do?method=reply";
			document.thisForm.submit();
			return true;
		}else{
			alert("填报日期已过期，不能在进行填报！");
			return false;
		}
	}
	 
</script>