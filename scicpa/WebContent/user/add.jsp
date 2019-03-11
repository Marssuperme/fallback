<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
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

</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	注&nbsp;&nbsp;册&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>


	<fieldset>
		<legend>注册信息</legend>
	
		<input name="ctypetabname" type="hidden" id="ctypetabname"  value = "k_micfono" >
		<!-- <input name="state" type="hidden" id="state" value="新增会员"> -->
		<input name="state" type="hidden" id="state" value="0">
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">登录名<span class="mustSpan">[*]</span>：</td>
				<td>
				<input name="loginid" type="text" id="loginid"  size="25" onblur="setLogin(this);" >
				<input name="isloginid" type="hidden" id="isloginid"   >
				<font color="red"><span id = "islogin"></span></font>
				</td>
			</tr>
			<tr>
				<td align="right" width="40%">姓名<span class="mustSpan">[*]</span>：</td>
				<td><input name="loginname" type="text" id="loginname"  size="25"  ></td>
			</tr>
			<tr>
				<td align="right" width="40%">登录密码<span class="mustSpan">[*]</span>：</td>
				<td><input name="pwd_one" type="password" id="pwd_one"  size="26"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">确认密码<span class="mustSpan">[*]</span>：</td>
				<td><input name="pwd_two" type="password" id="pwd_two"  size="26"  />
				<a href="#" onClick="javascript:window.open('${pageContext.request.contextPath}/common/user.do?method=Help','','width=600, height=650, location=no, menubar=no, status=no, toolbar=no, scrollbars=yes, resizable=yes');">密码建议<label id="chkResult"></label></a>
				</td>
			</tr>
			<tr>
				<td align="right" width="40%">会员类型<span class="mustSpan">[*]</span>：</td>
				<td>
				<input name="ctype" type="radio" id="ctype"  value="执业会员" onclick="setTabName(this);" >执业会员
				<input name="ctype" type="radio" id="ctype"  value="非执业会员" onclick="setTabName(this);" checked>非执业会员
				</td>
			</tr>
			
			</table>
		
		</td>
		<td align="left" valign="top">
		&nbsp;
		</td>
		</tr></table>
		
	</fieldset>
	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
      <input type="submit" name="next" value="保 存" class="flyBT" onclick="return saveInfo();" >
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
//设置对应的tableName
function setTabName(obj){
	var ctypetabname = document.getElementById("ctypetabname");
	if(obj.value == "执业会员"){
		ctypetabname.value = "k_micfo";
	}else if(obj.value == "非执业会员"){
		ctypetabname.value = "k_micfono";
	}
}

//检查登录名是否可用
function setLogin(obj){
	var loginid = obj.value;
	if(loginid != ""){
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/user.do?method=isLogin&loginid="+loginid ;
		oBao.open("POST",url,false);
		oBao.send();
		var islogin = document.getElementById("islogin");
		var isloginid = document.getElementById("isloginid");
		
		resText = oBao.responseText ;
		if(resText.indexOf("0")>-1){
			obj.select();
			islogin.innerText = "该登录名不可用";
			isloginid.value = "0";
		}else if(resText.indexOf("1")>-1){
			islogin.innerText = "该登录名可用";
			isloginid.value = "1";
		}
	}
}

//检查密码
function updatePwd(){
	var pwd_one = document.getElementById("pwd_one").value;
	var pwd_two = document.getElementById("pwd_two").value;
	
	if(pwd_one == ""||pwd_one==null) {
		alert("登录密码不能为空，请重新输入!");
		document.getElementById("pwd_one").focus();
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
	
	return true;
}

//保存
function saveInfo(){
	var loginid = document.getElementById("loginid").value; //登录名
	var loginname = document.getElementById("loginname").value; //姓名
	//会员类型
	//var ctype1 = document.getElementById("ctype1"); //会员类型:执业会员
	//var ctype2 = document.getElementById("ctype2"); //会员类型:非执业会员
	
	var isloginid = document.getElementById("isloginid");
	if(isloginid.value == "0"){
		alert("登录名不可用，请重新输入!");
		document.getElementById("loginid").select();
		return false;
	}

	if(loginid == ""||loginid==null) {
		alert("登录名不能为空，请重新输入!");
		document.getElementById("loginid").select();
		return false;
	}

	if(loginname == ""||loginname==null) {
		alert("姓名不能为空，请重新输入!");
		document.getElementById("loginname").select();
		return false;
	}

	if(!updatePwd()){
		return false;
	}
	
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/user.do?method=save";
	document.thisForm.target = "";
	return true;
}

//-->
</script>
