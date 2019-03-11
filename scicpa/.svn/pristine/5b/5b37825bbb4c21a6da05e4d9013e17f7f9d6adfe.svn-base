<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
 <%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

 

<title>投票 addAndEdit页面</title>
</head>
<body> 

<form action="" name="thisForm" id="thisForm" method="post">
<input type="hidden" id="tid" name="tid" value="${tt.id}"/>&nbsp;&nbsp;&nbsp;
<input type="hidden" id="tcenddate" name="tcenddate" value="${tt.tcenddate}"/>&nbsp;&nbsp;&nbsp;

<!-- 投票信息 -->
<div style="border: 2px solid #7fb80e;height: 100%">
<table width="100%" style="background-color: #cde6c7">
	<tr>
		<td>
			<img src="${pageContext.request.contextPath }/icons/tp.png"/>&nbsp;<font style="font-size: 17">投票中</font>
		</td>
	</tr>
</table>
<br>
<table class="indexBox" width="100%" cellspacing="0" border="0" >
		<tr align="center">
			<td align="center"><font style="font-size: 17">${tt.tctitle}</font></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 15">${tt.tccontent}</font></td>
		</tr> 
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>
				<c:if test="${tt.tcchooseone != ''}">
					<input type="radio" id="tp" name="tp" value="tcchooseonecount" onclick="gotpTicket('1')"/><font style="font-size: 15">${tt.tcchooseone}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${tt.tcchoosetwo != ''}">
					<input type="radio" id="tp" name="tp" value="tcchooseonecount" onclick="gotpTicket('2')"/><font style="font-size: 15">${tt.tcchoosetwo}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${tt.tcchoosethree != ''}">
					<input type="radio" id="tp" name="tp" value="tcchooseonecount" onclick="gotpTicket('3')"/><font style="font-size: 15">${tt.tcchoosethree}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${tt.tcchoosefour != ''}">
					<input type="radio" id="tp" name="tp" value="tcchooseonecount" onclick="gotpTicket('4')"/><font style="font-size: 15">${tt.tcchoosefour}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
			</td>
		</tr>
		<tr align="right">
			<td>
				 <font size="2" color="#dec674">投票截止日期：${tt.tcenddate }</font>&nbsp;&nbsp;&nbsp; 
			</td>
		</tr>
		
		 
		<tr align="center">
			<td>
				<input icon="icon-back" type="button" name="next" value="返  回"  onclick="window.history.back();" >
			</td>
		</tr>
		  
</table>	
<br><br>
</div>
</form>
</body>

<script>
	
	// 默认为当前日期
	var date = new Date();
	var year = date.getYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month*1<10){
		month = "0"+month;
	}	
	if(day*1<10){
		day = "0"+day;
	}
	document.getElementById("tcenddate").value = year+"-"+month+"-"+day;
	
	
	
	// 确定
	function f_sure(){
		thisForm.action="${pageContext.request.contextPath}/common/ticket.do?method=addTicket";
		thisForm.submit();
	}
	
	// 取消
	function f_cancle(){
		window.close();
	}


	// 投票的方法
	function gotpTicket(choose){
		var tid = document.getElementById("tid").value;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/ticket.do?method=getTicketEndDate&id="+tid;
		oBao.open("POST",url,false);    // 注意第三个参数   
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="Y"){
		    url="${pageContext.request.contextPath}/common/ticket.do?method=getTicketReduplicate&id="+tid;
			oBao.open("POST",url,false);     
			oBao.send();

	    	var resText2 = oBao.responseText;  
	    	if(resText2=="Y"){
				window.location="${pageContext.request.contextPath}/common/ticket.do?method=tpTicket&choose="+choose+"&tid="+tid;
			}else{ 
				alert("您已投过票了，此投票信息不允许重复投！ ");
				return ;
			}
		}else{
			alert("投票截止日已过，不能再投票 ！");
			return ;
		}
		
	}
	
</script>
</html>