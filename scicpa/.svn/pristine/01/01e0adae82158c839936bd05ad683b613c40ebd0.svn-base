<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/Sys_INCLUDE/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">

<title>团体会员主页</title>
</head>
 
<body> 
	<!-- 最新通知 -->
	<table class="indexList" cellspacing="0" cellpadding="5"  border="0" >
		<tr>
			<th align="left">
				<img src="${pageContext.request.contextPath }/icons/Info.png"/>&nbsp;
				最新通知
			</th>
			<th colspan="2" align="right">
				<span class="more">
					<a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=company">更多</a>
				</span>
			</th>
		</tr>
		
		<tr>
	 		<td width="50%" style="color: #007500">标题</td>
	 		<td width="30%" style="color: #007500">发放机构</td>
	 		<td width="20%" style="color: #007500">状态</td>
 		</tr>
	
		<c:forEach items="${noticeList}" var="notice" >
			<tr>
			<td>
	 			<a href="#" onclick="getNotice('${notice.id }','${notice.p }')" >
	 				${notice.caption }
  				</a><span class="datetime">${notice.ntime }</span>
			</td>
			<td>${notice.agency }</td>
			<td>
					<c:if test="${notice.isview=='1'}">已阅</c:if>
					<c:if test="${notice.isview=='' || notice.isview==null}">未阅</c:if>
					<c:if test="${notice.isview=='y'}">已报名</c:if>
					<c:if test="${notice.isview=='n'}">未报名</c:if>
			</td>
		</tr>
		</c:forEach>
		
	</table> 	

<br/>

	<!-- 公文收文 -->
	<table class="indexList" cellspacing="0" cellpadding="5" border="0" >
		<tr>
			<th align="left">
				<img src="${pageContext.request.contextPath }/icons/document.png"/>&nbsp;
				公文收文
			</th>
			<th colspan="3" align="right">
				<span class="more">
					<a href="${pageContext.request.contextPath}/common/document.do?method=dlist">更多</a>
				</span>
			</th>
		</tr>
		
		<tr>
	 		<td width="50%" style="color: #007500">标题</td>
	 		<td width="20%" style="color: #007500">发文机构</td> 
	 		<td width="20%" style="color: #007500">文号</td> 
	 		<td width="10%" style="color: #007500">状态</td> 
 		</tr>
	
	 	<c:forEach items="${bdList}" var="bdlist">				
			<tr>
		 		<td><a href="${pageContext.request.contextPath }/common/document.do?method=document&nid=${bdlist.id}" >${bdlist.caption}</a><span class="datetime">${bdlist.ntime}</span></td>
		 		<td>${bdlist.agencyname} </td>
		 		<td>${bdlist.reference}</td>
		 		<td>
		 			<c:if test="${bdlist.isview=='1'}">已阅</c:if>
					<c:if test="${bdlist.isview=='' || bdlist.isview==null}">未阅</c:if>
		 		</td>
	 		</tr>
		</c:forEach>
	</table> 	
	
	 <div style="margin-top: 95%;"> </div>
 
</body>
</html>
<script>

	// b_notice 通知
	function getNotice(id,p){
		if(p=="notice"){
			window.location="${pageContext.request.contextPath}/common/document.do?method=notice&nid=" + id + "&random="+Math.random()+"&p=main";
		}else if(p=="k_task"){             //  k_task  在线填报
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/task.do?method=getStateById&id="+id;
			oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
			oBao.send();
	 
	    	var rs = oBao.responseText;  
			if(rs=="未回复" || rs=="已回复 等待确认" || rs=="已回复 不通过"){
				window.location="${pageContext.request.contextPath}/common/task.do?method=viewTask&id="+id;
			}else{
				alert(rs);
				return false;
			}
		}else{
			window.location="${pageContext.request.contextPath}/common/testerNotice.do?method=getTesterNoticeTable&p=company&id=" + id + "&random="+Math.random();
		}
	}
	
	// k_TesterNotice  检查人员通知
	function getTNotice(id){
		window.location="${pageContext.request.contextPath}/common/testerNotice.do?method=getTesterNoticeTable&id=" + id + "&random="+Math.random();
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