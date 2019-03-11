<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告通知</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

</style>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="thisForm" method="post" action="">
	<div style="width:100%;">
	<div>
	 <div style="margin-bottom: 0.5%">
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		    </div>
		    
			<div id="search" style="position:absolute;width:40%;height:50%; z-index:0;left:expression((document.body.clientWidth-575)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:86%;height: 95%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table width="100%" style="margin-left: 15px;">
						<tr >
							<td align="right">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
							<td align="left"><input id="caption" name="caption" style="width: 260;height: 0px;"></td>
						</tr>
						<!-- 
						<tr >
							<td align="right">文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
							<td align="left"><input id="reference" name="reference" style="width: 260"></td>
						</tr>
						 -->
						<tr >
							<td align="right">发文时间：</td>
							<td align="left">
								<input id="ntime1" name="ntime1"  style="width: 85px;" showcalendar="true">至
								<input id="ntime2" name="ntime2"  style="width: 85px;" showcalendar="true">
							</td>
						</tr>
						<tr >
							<td align="right">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
							<td align="left"><input id="isview" name="isview"  style="width: 260px;"/></td>
						</tr>	
						 
				</table>
			<br>
			<table width="90%" style="margin-left: 25%;">
				<tr>
					<td>
						<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
				    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    	<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
				    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    	<input id="pass" icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
				    </td>
				</tr>
	    	</table>
		</fieldset>
	</div>	


	<!-- 是团体还是个人的判断参数 -->
	<input type="hidden" value="${p}" name="p" id="p">
	<mt:DataGridPrintByBean name="noticeList"/>
	
	</div>
	</div>
</form>
</body>
</html>
<script>
/*查看*/
function goView(chooseValue,t){
	var p = document.getElementById("p").value;
	if(t=="notice"){   //  普通通知 
		window.location="${pageContext.request.contextPath}/common/document.do?method=notice&nid="+chooseValue;
	}else if(t=="k_suptask"){             //  k_suptask  检查人员通知 在线填报
			window.location="${pageContext.request.contextPath}/common/supTask.do?method=viewSupTask&id=" + chooseValue + "&random="+Math.random();
	}else if(t=="k_task"){             //  k_task  在线填报
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/task.do?method=getStateById&id="+chooseValue;
			oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
			oBao.send();
	 
	    	var rs = oBao.responseText;  
			if(rs=="未回复" || rs=="已回复 等待确认" || rs=="已回复 不通过"){
				window.location="${pageContext.request.contextPath}/common/task.do?method=viewTask&id="+chooseValue;
			}else{
				alert(rs);
				return false;
			}
	}else{				// 检查组人员通知 
		window.location="${pageContext.request.contextPath}/common/testerNotice.do?method=getTesterNoticeTable&p="+p+"&id=" + chooseValue + "&random="+Math.random();
	}
	
	
}

// 搜索 
function f_search(){
	document.getElementById("search").style.display = "";
	document.getElementById("divBlock").style.display = "";
}

// 取消
function f_quxiao(){
	document.getElementById("search").style.display = "none";
	document.getElementById("divBlock").style.display = "none";
}


// 确定 
function f_sure(){
	var j=0;
	$("#search input[type='text']").each(function(){ 
		if(!Testing($(this).val())){
			j=1;
			return false;
		}
		
		});
	if(j==1){
		return false;
	};
	//document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/document.do?method=nlist"; 
	//document.getElementById("thisForm").submit();
	var url = "${pageContext.request.contextPath}/common/document.do?method=nlist";
	url = url+"&caption=" + document.getElementById("caption").value +
		"&ntime1=" + document.getElementById("ntime1").value +
		"&ntime2=" + document.getElementById("ntime2").value +		
		"&isview=" + document.getElementById("isview");
	window.location=url;
}
	
	
// 取消  清空
function f_clear(){
	// 标题
	document.getElementById("caption").value = "";
	// 文号
	document.getElementById("reference").value = "";
	// 发文时间
	document.getElementById("ntime1").value = "";
	document.getElementById("ntime2").value = "";
	// 状态
	document.getElementById("isview").value = "";
	
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/document.do?method=nlist"; 
	document.getElementById("thisForm").submit();
}
</script>