<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>团体会员信息</title> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>
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
	
	.before{
		border: 0px;
	}
	.after{
		border: 1px solid;
	}
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" > 
	会&nbsp;&nbsp;计&nbsp;&nbsp;师&nbsp;&nbsp;事&nbsp;&nbsp;务&nbsp;&nbsp;所&nbsp;&nbsp;信&nbsp;&nbsp;息
	<span style="margin-left: 100px;vertical-align: middle;">
		<input type="button" name="next" value="关  闭" icon="icon-delete" class="flyBT" onclick="window.close();" >
	 </span>
	<br/><br/> 
	</center>

<DIV class=block id=search style="height: 100%;">

<input maxlength="100" type="hidden" id = "association" name = "association" title="所在协会" value = "${userMap.association }"> 
<input maxlength="100" type="hidden" id = "officename" name = "officename" title="事务所全称" value = "${userMap.officename }">

<div class=tabcontent id="dgxx" style="text-align:center;">
 
 <table style="WIDTH: 100%" class="data_tb" align="center">
   <tbody>
   	<!-- 
     <tr>
       <td class="toptitle_bg2" colSpan="4">
         <p align="center">会计师事务所有限公司广东分所</p>
       </td>
     </tr>
     -->
     <tr>
       <td class="data_tb_alignright" width="50%" style="text-align: left;" colspan="4"><b>基础资料</b></td>
     </tr>
     <tr>
       <td class="data_tb_alignright" width="20%">事务所名称</td>
       <td class="data_tb_content" width="30%">${userMap.loginname }
      
       <td class="data_tb_content" width="50%" style="text-align: center" colspan="2" rowspan="2">
			<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}${userPhotoSrc }"><br>
			<input type="text" id="myText" size="1" style="display:none"> <br>
			<span id="logospan" style="display: none">
			<a id="no1" href="#" onclick="upLoadFile();">点击上传企业LOGO</a><br>
			<a style="color: red">*注意：照片上传后将不能更改,请确认上传真实照片！</a>
			<!-- 
				<a id="no2" href="#" onclick="deletePhoto();"><img border="0" src="${pageContext.request.contextPath}/images/del.gif"></a>
			 -->
			</span>
       </td>
     </tr>
         
     <tr>
       <td class="data_tb_alignright">备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     注</td> 
       <td class="data_tb_content">${userMap.remark}</td>
     </tr>
     
     <tr>
       <td class="data_tb_alignright" width="20%">事务所代码</td>
       <td class="data_tb_content" width="30%"><input maxlength="100" id="officecode" name="officecode" value="${userMap.officecode}" cannotedit></td>
       <td class="data_tb_alignright">注册资金</td>
       <td class="data_tb_content"><input maxlength="100" class="borderstyle" id="capital" name="capital" value="${userMap.capital}" cannotedit></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">组织形式</td>
       <td class="data_tb_content"><input maxlength="100" id="organization" name="organization" value="${userMap.organization}" cannotedit></td>
       <td class="data_tb_alignright">所在城市</td>
       <td class="data_tb_content"><input maxlength="30" onfocus="onPopDivClick(this);"
			noinput=true
			onkeydown="onKeyDownEvent();"
			onkeyup="onKeyUpEvent();"
			onclick="onPopDivClick(this);"
			norestorehint=true
			autoid=10
			hideresult=true id="area" name="area" value="${userMap.area}"></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">成立批准时间</td>
       <td class="data_tb_content"><input maxlength="100" id="approval" name="approval" value="${userMap.approval}" cannotedit></td>
       <td class="data_tb_alignright">成立批准文号</td>
       <td class="data_tb_content"><input maxlength="100" id="approvalnumber" name="approvalnumber" value="${userMap.approvalnumber}" cannotedit></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">税务登记号</td>
       <td class="data_tb_content"><input maxlength="100" id="tax" name="tax" value="${userMap.tax }"></td>
       <td class="data_tb_alignright">成立批准机关</td>
       <td class="data_tb_content"> <input maxlength="100" id="approvalauthority" name="approvalauthority" value="${userMap.approvalauthority}" cannotedit></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">工商登记日期</td>
       <td class="data_tb_content"><input maxlength="100" id="businesstime" name="businesstime" value="${userMap.businesstime}"  showcalendar="true" readonly="readonly"></td>
       <td class="data_tb_alignright">工商登记号</td>
       <td class="data_tb_content"><input maxlength="100" id="business" name="business" value="${userMap.business}"></td>
     </tr>
      <tr>
       <td class="data_tb_alignright">主任会计师</td>
       <td class="data_tb_content"><input maxlength="100" id="corporate" name="corporate" value="${userMap.corporate}" cannotedit></td>
       <td class="data_tb_alignright">主任会计师手机号</td>
       <td class="data_tb_content"><input maxlength="100" id="corporatephone" name="corporatephone" value="${userMap.corporatephone}" myClass="phone"  ></td>
     </tr>
     <tr>
       <td class="data_tb_alignright" style="text-align: left;" colspan="4"><b>联系方式</b></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">地址</td>
       <td class="data_tb_content" colspan="3">${userMap.address} </td>
     </tr>
     <tr>
       <td class="data_tb_alignright">联系人</td>
       <td class="data_tb_content"><input maxlength="50" name="linkman" type="text" id="linkman" title="联系人" value = "${userMap.linkman}"></td>
       <td class="data_tb_alignright">联系电话</td>
       <td class="data_tb_content"><input maxlength="100" name="phone" type="text" id="phone" myClass="phone"  value = "${userMap.phone }"></td>
     </tr>
      
     <tr>
       <td class="data_tb_alignright">邮政编码</td>
       <td class="data_tb_content"><input maxlength="100" name="postcode" type="text" id="postcode" myClass="number" value = "${userMap.postcode}" ></td>
       <td class="data_tb_alignright">传真</td>
       <td class="data_tb_content"><input maxlength="100" name="postalcode" type="text" id="postalcode" title="传真号码非法" value = "${userMap.postalcode}"></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">E-Mail</td>
       <td class="data_tb_content"><input maxlength="100" name="email" type="text" id="email" myClass="email" value = "${userMap.email}"></td>
       <td class="data_tb_alignright">网址</td>	
       <td class="data_tb_content"><input maxlength="50" name="url" type="text" id="url"  value = "${userMap.url }"></td>
     </tr> 
     <tr>
       <td class="data_tb_alignright" style="text-align: left;" colspan="4">
       		<b>执业信息</b> 　
       	</td>
     </tr>
     <tr>
       <td class="data_tb_alignright">业务规模：&nbsp;</td>
       <td class="data_tb_content"><input maxlength="100" id="scale" name="scale" value="${userMap.scale}"></td>
       <td class="data_tb_alignright">其他资质：&nbsp;</td>
       <td class="data_tb_content"><input maxlength="100" id="other" name="other" value="${userMap.other }"></td>
     </tr>
     <tr>
       <td class="data_tb_alignright">注册会计师总数</td>
       <td class="data_tb_content"><input maxlength="100" id="cpa" name="cpa" myClass="number" value="${cpaCount}"></td>
       <td class="data_tb_alignright">从业人员总数</td>
       <td class="data_tb_content"><input maxlength="100" id="employees" name="employees" myClass="number" value="${userMap.employees }"></td>
     </tr>
    
   </tbody>
 </table>
             

</div>
</DIV>

<c:if test="${ispunish=='Y'}">
	<div class="gridFrame"> 
	    <div style="width:100%;overflow:auto;height:100%;"> 
	    	<mt:DataGridPrintByBean name="punishList"/>
	    </div>
	</div>
</c:if>

<input name="pwd" type="hidden" id="pwd"  value="${userMap.pwd }"  >
<input name="ctypetabname" type="hidden" id="ctypetabname"  value="${userMap.ctypetabname }"  >
<input name="userphotoname" type="hidden" id="userphotoname"  value="${userMap.userphotoname }"  >

	

<input type="hidden" id="uploadFileName" name="uploadFileName" value="">

</form>
<form name="myForm" id="myForm" action="" method="post" enctype="multipart/form-data" target="hidden_frame">

	<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
	</div>
	<div id="divProduce" style="position:absolute;width:400px;height:100px; z-index:2;left:expression((document.body.clientWidth-580)/2);top:expression((document.body.clientHeight-580)/2); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
		<!-- <div align="left" style="color: red;">*注意：照片上传后将不能更改,请上传您的真实照片</div><br> -->
		<fieldset>
			<legend><font size="2">图片上传</font></legend>
			<input type="file" id="attachments" size="50" name="attachments"/>
			<input type='submit' class="flyBT" value='确定' onclick="return upLoadSumbit();">
			<input type="button" class="flyBT" value="关闭" onclick="hiddenProDiv();">
		</fieldset>
	</div>

</form>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
</html>
<script type="text/javascript">
 
 	// 让 border = 0
 	// 让 textarea被替换
 	$("input").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});
	
	$("textarea").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});
	
	//加验证
    $(document).ready(function(){
       $("#thisForm").validate();
    });


	
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
function saveCompany(){ 
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	
	//if(!updatePwd()){
		//return false;
	//}
	document.thisForm.action = "${pageContext.request.contextPath}/company/company.do?method=updateSave";
	document.thisForm.target = "";
	
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	
	if(document.thisForm.fireEvent('onsubmit')){
		xgc.style.display="";
		bcc.style.display="none";
		document.thisForm.submit();
		return true;
	}else{
		return false;
	}
}

//上传相片
function upLoadFile() {
	
	var userphotoname = document.getElementById("userphotoname");
	if(userphotoname.value != ""){
		alert("您已经上传了企业logo,不能重复上传!");
		return ;
	}

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
	myForm.action = "${pageContext.request.contextPath}/company/company.do?method=uploadPhoto" ;
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
		var url="${pageContext.request.contextPath}/company/company.do?method=deletePhoto&userphotoname="+userphotoname.value+"&loginid=${userMap.loginid}&ctypetabname=${userMap.ctypetabname }" ;
		oBao.open("POST",url,false);
		oBao.send();

		resText = oBao.responseText ;
		
		alert(resText);
		document.getElementById("bill").src = "${pageContext.request.contextPath}/images/comp.png";
		userphotoname.value = "";
	}
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

function changeName(odjThis){
	document.getElementById('name1').innerText=odjThis.value;
	document.getElementById('name2').innerText=odjThis.value;
	document.getElementById('name3').innerText=odjThis.value;
}

// 修改 input 样式
function updateStyle(){ 
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	xgc.style.display="none";
	bcc.style.display="";
	var xgc1 = document.getElementById("xgc1");
	var bcc1 = document.getElementById("bcc1");
	xgc1.style.display="none";
	bcc1.style.display="";
	
	// 加边框     重新加日期出来
	$("input").each(function(index,obj){
		if (obj.cannotedit==null){
			if (obj.type=="button" && obj.id.indexOf("date_")>=0){
				obj.style.display="";
			}
			if(obj.id == "lastpeople" || obj.id == "lastmodified" || obj.id == "ctype"){
				obj.readOnly = true;
			}else{
				obj.readOnly = false;
			}
			obj.className = "";
		}
	});
	
	$("textarea").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.readOnly = false;
			obj.className = "";
		}
	});
	
	document.getElementById("logospan").style.display="";
	//document.getElementById("update").style.display="";
    document.getElementById("businesstime").readOnly=true;
	
}

// 返回到主页 
function goBack(){
	document.thisForm.action = "${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame";
	document.thisForm.target="mainFrame";
	document.thisForm.submit();
}

// 修改密码
function updatePwds(){

	var ctypetabname = document.getElementById("ctypetabname").value;
	var pwd_old = document.getElementById("pwd_old").value;
	var pwd_one = document.getElementById("pwd_one").value;
	var pwd_two = document.getElementById("pwd_two").value;
	if(pwd_old==""){
		alert("旧密码不能为空!");
		document.getElementById("pwd_old").focus();
		return;
	}

	if(pwd_one==""){
		alert("新密码不能为空!");
		document.getElementById("pwd_one").focus();
		return;
	}

	if(pwd_two==""){
		alert("确认密码不能为空!");
		document.getElementById("pwd_two").focus();
		return;
	}
	
	if(updatePwd()){
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/company/company.do?method=updatePwds&ctypetabname="+ctypetabname+"&pwd_old="+pwd_old+"&pwd_one="+pwd_one ;
		oBao.open("POST",url,false);
		oBao.send();
	
		resText = oBao.responseText ;
		if(resText!="" && resText!=null){
			alert("修改密码成功!");
		}else{
			alert(resText);
		}
	}
}
 
</script>
