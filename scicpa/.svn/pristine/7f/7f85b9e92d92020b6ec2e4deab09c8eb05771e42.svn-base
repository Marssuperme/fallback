<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
	</div>
	<div id="divProduce" style="position:absolute;width:750px;height:240px; z-index:2;left:expression((document.body.clientWidth-680)/2);top:expression(this.offsetParent.scrollTop + 20); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
		<fieldset>
			<legend><font size="2">该所已有的会员</font></legend>
		<div style="height: 200px;overflow: auto">	
		
		<input type="hidden" id="tname1" name = "tname1" value="">
		
		
		<table id="targetTable" cellSpacing="1" cellPadding="2" width="100%" bgColor="#6595d6" border="0" style="margin-top: 5px; " >
	    <tr >
	      <td width="2px;" align="center" bgColor="#b9c4d5"><input type="checkbox" onclick="checkall(this);"></td>
	      <td align="center" bgColor="#b9c4d5">姓名</td>
	      <td noWrap align="center" bgColor="#b9c4d5">会员类型</td>
	      <td noWrap align="center" bgColor="#b9c4d5">电话号码</td>
	      <td noWrap align="center" bgColor="#b9c4d5">职务</td>
	    </tr>
	    
<c:forEach items="${userList}" var="user" >
 
		<tr >
	      <td width="2px;" align="center" bgcolor="#f6f6f6">
	      	<input type=hidden id="loginid2" name="loginid2"  value="${user.loginid}">
	      	<input
	      		<c:if test="${user.ttype == '个人已报名'}">checked</c:if>
	      		<c:if test="${user.ttype == '团体代报名'}">checked</c:if>
	      		<c:if test="${user.ttype == '已缴费'}">checked disabled</c:if>
	      		<c:if test="${user.ttype == '已通过'}">checked disabled</c:if>
	      		name="t_name1" 
	      		type="checkbox" 
	      		value='${user.loginname }' 
	      		ttype='${user.ttype }' 
	      	>
	      </td>
	      <td align="center" bgcolor="#f6f6f6">${user.loginname }</td>
	      <td noWrap align="center" bgColor="#f6f6f6">${user.ctype }</td>
	      <td noWrap align="center" bgColor="#f6f6f6">
	     	 <input type="text" class='wb' id="sysPhoneId" size="16" name="sysPhoneName" value="${user.phone}" onkeyup="value=value.replace(/[^\d\.\\-]/g,'');" >
	      </td>
	      <td noWrap align="center" bgColor="#f6f6f6"><input type="text" class='wb' id="sysLeval" size="16" name="sysLeval" value="${user.leval }" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=33 
												hideresult=true ></td>
	    </tr>
	    
</c:forEach>
	    
		</table>	
		
		
			
		</div>	
	</fieldset>
	<br> 
	<input type="button" onclick="" class="flyBT" value="发送" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="hiddenProDiv1();" class="flyBT" value="取消" >
	</div>
	

<br>
<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
<tr height=18>
	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>短信内容：</strong><font color="#FF0000">&nbsp;[*]</font></td>
 	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
		<textarea style="width: 95%;height: 100px;" name="noteContent" id= "noteContent" ></textarea>
	</td>
</tr>

<tr height=18>
	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>短信通知范围：</strong><font color="#FF0000">&nbsp;[*]</font></td>
 	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
		<textarea style="width: 95%;height: 100px;"  name="noteArea" id= "noteArea" onclick="setName()"></textarea>
	</td>
</tr>
</table>
<table align="center" style="display: none">
<tr>
	<td><input type="button" value="发送"></td>
	<td style="width: 40%"></td>
	<td><input type="button" value="取消"></td>
</tr>
</table>	

</body>

<script type="text/javascript">


function setName(){

	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "";
	blockObj.style.display = "";
}

// 隐藏执业会员的是否中转和是否住宿 的 div
function hiddenProDiv1() {
	divObj = document.getElementById("divProduce");
	blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}


	
// 手动添加  表格的第一列
function checkall(oCbx){
	var cbxValue = oCbx.checked; 
	var oInput = document.getElementsByName("t_name1");
	for(var i = 0; i < oInput.length; i++){
		oInput[i].checked = cbxValue;  
	}
	//checkone();
}

</script>
</html>