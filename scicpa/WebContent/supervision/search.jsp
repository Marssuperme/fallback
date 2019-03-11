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
<input type="hidden" id="id" name="id" value="${st.id }">
<input type="hidden" id="source" name="source" value="${source}">
<br><br>
<table width="90%" height="30%" border="0" cellpadding="0" align="center" cellspacing="1" bgcolor="#6595d6">

<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF"> 
	<h4>监 管 问 题</h4> 
	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
		<tbody id="SWlist">
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>被检查事务所</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="被检查事务所" class="required" size="35" id="companyname" readonly="readonly" name="companyname" value="${st.companyname }"></td>
		</tr>
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>被检查项目</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="被检查项目" class="required" readonly="readonly" size="35" id="project" name="project" value="${st.project}"></td>
		</tr>
	 	
	 	<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>问题状态</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="问题状态" class="status" readonly="readonly" size="35" id="status" name="status" value="${st.status}"></td>
		</tr>
		 
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>上报人</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="上报人" class="status" readonly="readonly" size="35" id="iuser" name="iuser" value="${st.iuser}"></td>
		</tr>
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>上报时间</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="上报时间" class="required" size="35" id="idate" readonly="readonly" name="idate" value="${st.idate}"></td>
		</tr>
		 
		 <tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>解答人</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="解答人" class="required" readonly="readonly" size="35" id="auser" name="auser" value="${st.auser}"></td>
		</tr>
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>解答时间</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><input title="解答时间" class="required" size="35" id="adate" readonly="readonly" name="adate" value="${st.adate}"></td>
		</tr>
		
		<tr>
			<td align="right" bgColor="#EEEEEE"><strong>发现的问题</strong><font color="#FF0000">&nbsp;[*]</font></td>
			<td align="left" bgColor="#FFFFFF"> <textarea title="发现的问题" class="required" rows="7%" readonly="readonly" cols="100%" id="body" name="body">${st.body }</textarea> </td>
		</tr>
		
		<tr>
		  	<td align="right" bgColor="#EEEEEE"><strong>解答结果</strong><font color="#FF0000">&nbsp;[*]</font></td>
		  	<td align="left" bgColor="#ffffff" ><textarea title="解答结果" class="required" id="result" rows="7%" readonly="readonly" cols="100%"  name="result">${st.result}</textarea></td>
		</tr>
		
		<tbody>
	</table>  
	<table width="20%" align="center">
	<tr> 
		<td>
			
			<c:if test="${valid=='Y' }">
				<c:choose>
					<c:when test="${userSession.userMap.ctype=='团体会员' }">
						<input icon="icon-save" type="button" name="next" value="办结" onclick="f_update()" >
					</c:when>
					<c:otherwise>
						<c:if test="${checkPost=='组长'}">
							<input icon="icon-save" type="button" name="next" value="办结" onclick="f_update()" >
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:if>
		</td>
		<td>
			<input icon="icon-btncom" type="button" name="next" value="返回" onclick="f_back();" >
		</td>
	</tr>
	</table>

	</td>
</tr>
</table>
</form>
</body>

<script type="text/javascript">
 
   // 保存
   function f_update(){
   		var id = document.getElementById("id").value;
   		if(confirm("确定要办结吗?")){
   			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/supervision.do?method=viewStatus&id="+id;
			oBao.open("POST",url,false);
			oBao.send();
			
			var resText = oBao.responseText;  
			if(resText=="yes"){
				alert("已办结");
				return false;
			}else{
				document.thisForm.action="${pageContext.request.contextPath}/common/supervision.do?method=updateSupervisionStatus";
				document.thisForm.submit();
			}
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