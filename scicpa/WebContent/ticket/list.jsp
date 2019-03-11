<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp" %>    
<script language="javascript" src="${pageContext.request.contextPath}/JS/weebox.js"></script> 
<link rel="STYLESHEET" type="text/css" href="/Web/CSS/weebox.css">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>投票list页面</title>
</head>
<body>
<form name="thisForm" method="post" action="">
 
	<mt:DataGridPrintByBean name="ticketList"/>
</form>
</body>

<script>
	// 投票方法
	function f_ticket(){
		var r = document.getElementsByName("title");
		var bl = true;
		for(var i =0;i<r.length;i++){
			if(r[i].checked){
				bl = false;
				document.getElementById("param").value=r[i].value;
				thisForm.action="${pageContext.request.contextPath}/common/ticket.do?method=tiaozhuan&p=addAndEdit";
				thisForm.submit();
			}
		}
		if(bl){
			alert("请选择要投票的标题!");
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
    	alert(resText);
		if(resText=="Y"){
		    url="${pageContext.request.contextPath}/common/ticket.do?method=getTicketReduplicate&id="+tid;
			oBao.open("POST",url,false);     
			oBao.send();

	    	var resText2 = oBao.responseText;  
	    	alert(resText2);
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
	
	// 进入子投票页面 
	function goTicket(id,tcenddate,anonymous,reduplicate){
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/ticket.do?method=getTicketEndDate&id="+id;
		oBao.open("POST",url,false);    // 注意第三个参数   
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="Y"){
		    url="${pageContext.request.contextPath}/common/ticket.do?method=getTicketReduplicate&id="+id;
			oBao.open("POST",url,false);     
			oBao.send();

	    	var resText2 = oBao.responseText;  
	    	if(resText2=="Y"){
				thisForm.action="${pageContext.request.contextPath}/common/ticket.do?method=goTicket&id="+id;
				thisForm.submit();
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