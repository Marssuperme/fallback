<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/Sys_INCLUDE/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">

<title>个人首页</title>
</head>

<body>
<!-- 最新通知 -->
<table class="indexList" cellspacing="0" border="0" >
	<tr>
		<th align="left">
			<img src="${pageContext.request.contextPath }/icons/Info.png"/>&nbsp;
			最新通知
		</th>
		<th colspan="2" align="right">
			<span class="more">
				<a href="${pageContext.request.contextPath}/common/document.do?method=nlist&p=micfo">更多</a>
			</span>
		</th>
	</tr>
	
	<tr>
 		<td width="60%" style="color: #007500">标题</td>
 		<td width="25%" style="color: #007500">发放机构</td>
 		<td width="15%" style="color: #007500">状态</td>
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
</body>
</html>
<script type="text/javascript">

	function getNotice(id,p){
		if(p=="notice"){    //  notice  普通通知
			window.location="${pageContext.request.contextPath}/common/document.do?method=notice&nid=" + id + "&random="+Math.random()+"&p=micfomain";
		}else if(p=="k_suptask"){             //  k_suptask  检查人员通知 在线填报
			window.location="${pageContext.request.contextPath}/common/supTask.do?method=viewSupTask&id=" + id + "&random="+Math.random();
		}else{             //  k_TesterNotice  检查人员通知
			window.location="${pageContext.request.contextPath}/common/testerNotice.do?method=getTesterNoticeTable&p=micfo&id=" + id + "&random="+Math.random();
		}
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