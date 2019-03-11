<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>执业会员信息</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}
</style>
<style>
	H3.tabs {
	PADDING-LEFT: 0px! important; HEIGHT: 26px; BACKGROUND-COLOR: #e8f7fc! important
	}
	.tab {
		BORDER-RIGHT: #c1d8e0 1px solid; PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FONT-WEIGHT: normal; FLOAT: left; PADDING-BOTTOM: 0px; CURSOR: pointer; PADDING-TOP: 0px
	}
	.curtab {
		FONT-WEIGHT: bold; BACKGROUND: #fff; BORDER-RIGHT-COLOR: #b2c9d3
	}
	.block {
	BORDER-RIGHT: #b2c9d3 1px solid; BORDER-TOP: #b2c9d3 1px solid; BACKGROUND: #fff; MARGIN: 0px 0px 6px; BORDER-LEFT: #b2c9d3 1px solid; BORDER-BOTTOM: #b2c9d3 1px solid
	}
	.block H3 {
		PADDING-LEFT: 0.5em; FONT-SIZE: 1em; BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom; MARGIN: 1px 0px 0px; COLOR: #5086a5; LINE-HEIGHT: 26px
	}
	.block H3 A {
		COLOR: #5086a5
	}
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	理&nbsp;&nbsp;事&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>

<DIV class=block id=search>

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=sjdwtab href="javascript:setTab('search','sjdw')">基本信息</A> 
</H3>
<div class=tabcontent id="sjdw" style="text-align:center;">
<br/>

<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
<tr>
	<td width="60%">
		<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
		       <td align="right" width="40%">登录名：</td>
		       <td><input id="loginid" name="loginid" value="${directorTable.loginid }"></td>
		    </tr>
		    <tr>
		        <td align="right" width="40%">姓名：</td>
		        <td><input id="loginName" name="loginName" value="${directorTable.loginName }"></td>
		    </tr>
		  
		    <tr>
				<td align="right" width="40%">旧密码：</td>
				<td><input name="pwd_old" type="password" id="pwd_old"  size="26" onblur="f_validate1()"/></td>
			</tr>
			<tr>
				<td align="right" width="40%">登录密码：</td>
				<td><input name="pwd_one" type="password" id="pwd_one"  size="26"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">确认密码：</td>
				<td><input name="pwd_two" type="password" id="pwd_two"  size="26" onblur="f_updatePwd()" />
				<a href="#" onClick="javascript:window.open('${pageContext.request.contextPath}/director/director.do?method=Help','','width=600, height=650, location=no, menubar=no, status=no, toolbar=no, scrollbars=yes, resizable=yes');">密码建议<label id="chkResult"></label></a>
				</td>
			</tr>
		  
		    <tr>
			   	<td align="right" width="40%">会员类型：</td>
			    <td><input id="ctype" name="ctype" value="${directorTable.ctype }"></td>
			</tr>
			<tr>
			    <td align="right" width="40%">状态：</td>
			    <td><input id="state" name="state" value="${directorTable.state }"></td>
		    </tr>
		  
		    <tr>
			    <td align="right" width="40%">手机：</td>
			    	<td><input id="mobile" name="mobile" value="${directorTable.mobile }"></td>
			</tr>
			<tr>
			    <td align="right" width="40%">联系电话：</td>
			    <td><input id="phone" name="phone" value="${directorTable.phone }"></td>
		    </tr>
		  
		  
		    <tr>
			    <td align="right" width="40%">E-mail：</td>
			    <td><input id="email" name="email" value="${directorTable.email }"></td>
			</tr>
			<tr>
			    <td align="right" width="40%">所属单位：</td>
			    <td><input id="workunits" name="workunits" value="${directorTable.workunits }"></td>
		   </tr>
     
		</table>	
	</td>
	 
</tr>
</table>

</div>
 
</DIV>
<input name="pwd" type="hidden" id="pwd"  value="${directorTable.pwd }"  >
<input name="ctypetabName" type="hidden" id="ctypetabName"  value="${directorTable.ctypetabName }"  >

	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
      <input type="submit" name="next" value="保 存" class="flyBT" onclick="return saveDirector();" >
    </td>
    <td width="8%">&nbsp;</td>
    <td width="55%"></td>
  </tr>
</table>
 

</form> 
</body>
</html>
<script type="text/javascript">
<!--

// 检验原密码
function f_validate1(){
		var pwdold = document.getElementById("pwd_old").value;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/director/director.do?method=validate&pwdold="+pwdold;
		oBao.open("POST",url,false);
		oBao.send();

		resText = oBao.responseText ;
		
		if(resText == "" || resText == "null"){
			alert("原密码错误!");
			document.getElementById("pwd_old").value = "";
			//document.getElementById("pwd_old").focus();
			return false;
		}
		return true;
}


//检查密码
function f_validate2(){
	
	var pwd_old = document.getElementById("pwd_old").value;	//旧密码
	var pwd_one = document.getElementById("pwd_one").value; //新密码
	var pwd_two = document.getElementById("pwd_two").value; //确认密码
	
	//当[新密码]不用空时，就表示要修改密码
	if(pwd_one != null && pwd_one != ""){
		if(pwd_old=="" || pwd_old==null){
			alert("旧密码不能为空，请重新输入!");
			document.getElementById("pwd_old").focus();
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_two").value = "";
			return false;
		}
		if(pwd_two == ""||pwd_two==null) {
			alert("确认密码不能为空，请重新输入!");
			document.getElementById("pwd_two").focus();
			return false;
		}
		
		if(pwd_one != pwd_two ) {
			alert("【新密码】和【确认密码】不一样，请重新输入!");
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_one").focus();
			document.getElementById("pwd_two").value = "";
			return false;
		}
		
		if(pwd_one.indexOf("\\") > -1
			|| pwd_one.indexOf("/") > -1
			|| pwd_one.indexOf(":") > -1
			|| pwd_one.indexOf("*") > -1
			|| pwd_one.indexOf("?") > -1
			|| pwd_one.indexOf("\"") > -1
			|| pwd_one.indexOf("<") > -1
			|| pwd_one.indexOf(">") > -1
			|| pwd_one.indexOf("|") > -1
			|| pwd_one.indexOf("+") > -1
			|| pwd_one.indexOf("&") > -1
			|| pwd_one.indexOf("=") > -1) {

			alert("密码不能含有\/:*?\"<>|+&=等符号");
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_one").focus();
			document.getElementById("pwd_two").value = "";
			return false;
		}
	}
	document.getElementById("pwd").value = pwd_two;
	return true;
}

// 修改密码
function f_updatePwd(){
	var loginid = document.getElementById("loginid").value;	
	var pwd_old = document.getElementById("pwd_old").value;	//旧密码
	var pwd_one = document.getElementById("pwd_one").value; //新密码
	var pwd_two = document.getElementById("pwd_two").value; //确认密码
	
	if(pwd_one =="" || pwd_one == null){	
		alert("密码建议不设为空!");
	}else{
		if(f_validate2()){
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/director/director.do?method=updatePwd&loginid="+loginid+"&pwdnow="+pwd_one ;
			oBao.open("POST",url,false);
			oBao.send();
	
			resText = oBao.responseText ;
			
			if(resText == "0"){
				alert("修改密码成功!");
			}else{
				alert("修改密码失败!");
			}
		}
	}
}



//保存
function saveDirector(){ 
	document.thisForm.action = "${pageContext.request.contextPath}/director/director.do?method=updateDirectorTableById";
	document.thisForm.target = "";
	return true;
}

 

 

//显示
function setTab(area,id) {
	var tabArea=document.getElementById(area);
	var contents=tabArea.childNodes;
	for(i=0; i<contents.length; i++) {
		if(contents[i].className=='tabcontent'){contents[i].style.display='none';}
	}
	document.getElementById(id).style.display='';
	var tabs=document.getElementById(area+'tabs').getElementsByTagName('a');
	
	for(i=0; i<tabs.length; i++) { 
		tabs[i].className='tab'; 
	}
	document.getElementById(id+'tab').className='tab curtab';
	document.getElementById(id+'tab').blur();
	
}
 

//-->
</script>
