<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注协会员</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
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
<jsp:include page="/top.jsp" flush="true"></jsp:include>
<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	个&nbsp;&nbsp;人&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>


	<fieldset>
		<legend>个人信息</legend>
	
		<input name="pwd" type="hidden" id="pwd"  value="${userMap.pwd }"  >
		<input name="ctypetabname" type="hidden" id="ctypetabname"  value="${userMap.ctypetabname }"  >
		<input name="userphotoname" type="hidden" id="userphotoname"  value="${userMap.userphotoname }"  >
		
		<!-- 
		<input name="departid" type="hidden" id="departid"  value = "${userMap.departid }">
		 -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" > 
		<tr><td width="60%">
		
			<table width="98%" border="0" cellpadding="0" cellspacing="0" > 
			<tr>
				<td align="right" width="40%">登录名<span class="mustSpan">[*]</span>：</td>
				<td><input name="loginid" type="text" id="loginid"  size="25"  value="${userMap.loginid }" disabled="disabled"></td>
			</tr>
			<tr>
				<td align="right" width="40%">姓名<span class="mustSpan">[*]</span>：</td>
				<td><input name="loginname" type="text" id="loginname"  size="25"  value="${userMap.loginname }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">旧密码：</td>
				<td><input name="pwd_old" type="password" id="pwd_old"  size="26"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">登录密码：</td>
				<td><input name="pwd_one" type="password" id="pwd_one"  size="26"  /></td>
			</tr>
			<tr>
				<td align="right" width="40%">确认密码：</td>
				<td><input name="pwd_two" type="password" id="pwd_two"  size="26"  />
				<a href="#" onClick="javascript:window.open('${pageContext.request.contextPath}/cicpa/cicpa.do?method=Help','','width=600, height=650, location=no, menubar=no, status=no, toolbar=no, scrollbars=yes, resizable=yes');">密码建议<label id="chkResult"></label></a>
				</td>
			</tr>
			<tr>
				<td align="right" width="40%">IC卡号：</td>
				<td><input name="cardid" type="text" id="cardid"  size="25"  value = "${userMap.cardid }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">所属注协：</td>
				<td><input name="departid" type="text" id="departid"  size="25"  value = "${userMap.departid }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">状态：</td>
				<td><input name="state" type="text" id="state"  size="25"  value = "${userMap.state }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">会员类型：</td>
				<td><input name="ctype" type="text" id="ctype"  size="25"  value = "${userMap.ctype }"></td>
			</tr>
			
			<tr>
				<td align="right" width="40%">职务：</td>
				<td><input name="post" type="text" id="post"  size="25"  value = "${userMap.post }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">E-Mail：</td>
				<td><input name="email" type="text" id="email"  size="25"  value = "${userMap.email }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">电话：</td>
				<td><input name="phone" type="text" id="phone"  size="25"  value = "${userMap.phone }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">手机：</td>
				<td><input name="mobile" type="text" id="mobile"  size="25"  value = "${userMap.mobile }"></td>
			</tr>
			<tr>
				<td align="right" width="40%">离退休标志：</td>
				<td><input name="retirees" type="text" id="retirees"  size="25"  value = "${userMap.retirees }"></td>
			</tr>
			
			</table>
		
		</td>
		<td align="left" valign="top">
			<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}${userPhotoSrc }"><br>
			<input type="text" id="myText" size="1" style="display:none"> <br>
			<a href="#" onclick="upLoadFile();">点击上传相片</a>
			<a href="#" onclick="deletePhoto();"><img src="${pageContext.request.contextPath}/images/del.gif"></a>
		</td>
		</tr></table>
		
	</fieldset>
	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
      <input icon="icon-save" type="submit" name="next" value="保 存" class="flyBT" onclick="return saveCicpa();" >
    </td>
    <td width="8%">&nbsp;</td>
    <td width="55%"><input icon="icon-delete" type="button" name="next" value="关 闭" class="flyBT" onclick="window.close();" ></td>
  </tr>
</table>

<input type="hidden" id="uploadFileName" name="uploadFileName" value="">

</form>
<form name="myForm" id="myForm" action="" method="post" enctype="multipart/form-data" target="hidden_frame">

	<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
	</div>
	<div id="divProduce" style="position:absolute;width:400px;height:50px; z-index:2;left:expression((document.body.clientWidth-400)/2);top:expression((document.body.clientHeight-300)/2); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
		<fieldset>
			<legend><font size="2">图片上传</font></legend>
			<input type="file" id="attachments" size="50" name="attachments"/>
			<input type='submit' class="flyBT" value='确定' onclick="return upLoadSumbit();">
			<input type="button" class="flyBT" value="关闭" onclick="hiddenProDiv();">
		</fieldset>
	</div>

</form>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
<jsp:include page="/bottom.jsp" flush="true"></jsp:include>
</body>
</html>
<script type="text/javascript">
<!--

//检查密码
function updatePwd(){
	
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
	
	return true;
}

//保存
function saveCicpa(){
	if(!updatePwd()){
		return false;
	}
	document.thisForm.action = "${pageContext.request.contextPath}/cicpa/cicpa.do?method=updateSave";
	document.thisForm.target = "";
	return true;
}

//上传相片
function upLoadFile() {

	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	var attachments =  document.getElementById("attachments");
	divObj.style.display = "";
	blockObj.style.display = "";
	attachments.value = "";
}

function hiddenProDiv() {
	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}

//保存相片
function upLoadSumbit() {
	
	var attachments = document.getElementById("attachments");

	document.getElementById("uploadFileName").value = attachments.value ;
	var myForm = document.getElementById("myForm");
	myForm.action = "${pageContext.request.contextPath}/cicpa/cicpa.do?method=uploadPhoto" ;
	hiddenProDiv();
	
	return true;
}


function changePhoto(srcName) {
	var attachments = document.getElementById("attachments");
	var userphotoname = document.getElementById("userphotoname");
	if(attachments.value != "") {
		document.getElementById("bill").src = "${pageContext.request.contextPath}/photo/"+srcName;
		userphotoname.value = srcName;
	}

}

//删除图片
function deletePhoto() {
	var userphotoname = document.getElementById("userphotoname");
	if(userphotoname.value == ""){
		alert("您没有上传任何照片!");
		return ;
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/cicpa/cicpa.do?method=deletePhoto&userphotoname="+userphotoname.value+"&loginid=${userMap.loginid}&ctypetabname=${userMap.ctypetabname }" ;
		oBao.open("POST",url,false);
		oBao.send();

		resText = oBao.responseText ;
		
		alert(resText);
		document.getElementById("bill").src = "${pageContext.request.contextPath}/images/noPhoto.gif";
		userphotoname.value = "";
	}
}

//-->
</script>
