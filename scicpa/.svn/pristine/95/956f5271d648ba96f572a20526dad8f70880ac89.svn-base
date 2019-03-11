<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>执业会员信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align: center;
	width: 100%;
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
	PADDING-LEFT: 0px ! important;
	HEIGHT: 26px;
	BACKGROUND-COLOR: #e8f7fc ! important
}

.tab {
	BORDER-RIGHT: #c1d8e0 1px solid;
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	FONT-WEIGHT: normal;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	CURSOR: pointer;
	PADDING-TOP: 0px
}

.curtab {
	FONT-WEIGHT: bold;
	BACKGROUND: #fff;
	BORDER-RIGHT-COLOR: #b2c9d3
}

.block {
	BORDER-RIGHT: #b2c9d3 1px solid;
	BORDER-TOP: #b2c9d3 1px solid;
	BACKGROUND: #fff;
	MARGIN: 0px 0px 6px;
	BORDER-LEFT: #b2c9d3 1px solid;
	BORDER-BOTTOM: #b2c9d3 1px solid
}

.block H3 {
	PADDING-LEFT: 0.5em;
	FONT-SIZE: 1em;
	BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
	MARGIN: 1px 0px 0px;
	COLOR: #5086a5;
	LINE-HEIGHT: 26px
}

.block H3 A {
	COLOR: #5086a5
}

.before {
	border: 0px;
	background-color: white;
}

.after {
	border: 1px solid;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />
</head>
<body>


<form name="thisForm" method="post" action="" id="thisForm">
<center class="formTitle">
执&nbsp;&nbsp;业&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息
<span style="margin-left: 100px;vertical-align: middle;">
	<input type="button" name="next"
					value="关  闭" class="flyBT" icon="icon-delete" onclick="window.close();">
</span>
<br />
<br />
</center>

<DIV class=block id=search style="width: 98%;">

<div class=tabcontent id="sjdw"
	style="text-align: center; display: none;"> 
　
	<input name="lastpeople" type="hidden" id="lastpeople" size="25" value="${userSession.userMap.loginname}"> 
	<input name="lastmodified" type="hidden" id="lastmodified" size="25" value="${userMap.lastmodified}"> 
	<input name="state" type="hidden" id="state" size="25" value="${userMap.state }">
	<input name="loginname" type="hidden" id="loginname"  value="${userMap.loginname }"  >
	
</div>


<div class=tabcontent id="dgxx" style="text-align: center;"> 
 

<!--中部表格开始-->
<table border="0" cellSpacing="0" cellPadding="0" width="100%">
	<tbody>
		<tr>
			<td vAlign="top">
			<table style="WIDTH: 100%" class="data_tb" align="center">
				<tbody>
				
					<!-- 
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							width="50%" colspan="4" height="18"><b>个人信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="18">姓名</td>
						<td class="data_tb_content" width="30%" height="18"><span
							id="name3">${userMap.loginname }</span></td>
						<td class="data_tb_alignright" width="50%" style="text-align: center" colspan="2" rowspan="5"
							height="111"><img id="bill" height="120" width="100" src="${pageContext.request.contextPath}${userPhotoSrc }"><br>
								<input type="text" id="myText" size="1" style="display:none"> <br>
								<span id="logospan" style="display: none;">
									<a href="#" onclick="upLoadFile();">点击上传个人照片</a><br>
									<a style="color: red">*注意：照片上传后将不能更改,请上传您的真实照片！</a>
									 
								</span>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">性别</td>
						<td class="data_tb_content" width="30%" height="21">
							<input
							name="sex" type="text" id="sex" size="25"
							value="${userMap.sex }"
							
							myClass="required"
							title="请输入性别"
							
							onfocus="onPopDivClick(this);"
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							autoid=2
							
							noinput=true
							hideresult=true
							cannotedit
							>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">民族</td>
						<td class="data_tb_content" width="30%" height="21">
							<input
							name="nation" type="text" id="nation" size="25" maxlength="10"
							value="${userMap.nation }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">出生日期</td>
						<td class="data_tb_content" width="30%" height="39"><input
							name="borndate" type="text" id="borndate" size="25"
							value="${userMap.borndate }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">身份证号码</td>
						<td class="data_tb_content" width="30%" height="39">
							<input name="idnumber" type="text" id="idnumber" myClass="personcard" size="25"
							value="${userMap.idnumber }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;
							widt ="50%" colspan="4" height="18"><b>受教育信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="18">毕业学校</td>
						<td class="data_tb_content" width="30%" height="18"><input
							name="educational" type="text" id="educational" size="25" maxlength="50"
							value="${userMap.educational }"></td>
						<td class="data_tb_alignright" height="18">专业</td>
						<td class="data_tb_content" height="18">
							<input name="specialty" type="text" id="specialty"  size="25" maxlength="50" value = "${userMap.specialty }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">学位</td>
						<td class="data_tb_content" height="18">
							<input name="degree" type="text" id="degree"  size="25" maxlength="50" value = "${userMap.degree }">	
						</td>
						<td class="data_tb_alignright" height="18">学历</td>
						<td class="data_tb_content" height="18">
							<input name="diploma" type="text" id="diploma"  size="25" maxlength="50" value = "${userMap.diploma }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">外语程度</td>
						<td class="data_tb_content" height="18">
							<input name="languagelevel" type="text" id="languagelevel"  size="25" maxlength="20" value = "${userMap.languagelevel }">
						</td>
						<td class="data_tb_alignright" height="18">政治面貌及其它</td>
						<td class="data_tb_content" height="18">
							<input name="politics" type="text" id="politics"  size="25" maxlength="20" value = "${userMap.politics }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>执业信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">事务所全称</td>
						<td class="data_tb_content" height="18" colspan="3">
							<input name="officename" type="text" id="officename"  size="25"  value = "${userMap.officename }" cannotedit>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">事务所代码</td>
						<td class="data_tb_content" height="18"><input cannotedit name="officecode" type="text" id="officecode"  size="25"  value = "${userMap.officecode }"></td>
						<td class="data_tb_alignright" height="18">职务</td>
						<td class="data_tb_content" height="18"><input name="post" type="text" id="post"  size="25" maxlength="50" value = "${userMap.post }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">进 所 时 间</td>
						<td class="data_tb_content" height="18"><input name="intotime" type="text" id="intotime"  size="25"  value = "${userMap.intotime }" showcalendar="true"></td>
						<td class="data_tb_alignright" height="18">是否股东或合伙人</td>
						<td class="data_tb_content" height="18">
								<select id="isshareholder" name="isshareholder" style="width: 55px;" cannotedit>
									<option value="是" <c:if test="${userMap.isshareholder == '是'}">selected</c:if> >是</option>
									<option value="否" <c:if test="${userMap.isshareholder == '否'}">selected</c:if> >否</option>
								</select>							
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">进所前所在单位</td>
						<td class="data_tb_content" height="18"><input name="intobefore" type="text" id="intobefore"  size="25" maxlength="100" value = "${userMap.intobefore }"></td>
						<td class="data_tb_alignright" height="18">离退休标志</td>
						<td class="data_tb_content" height="18"><input name="retirees" type="text" id="retirees" maxlength="100" size="25"  value = "${userMap.retirees }"></td>
					</tr>
					
					 -->
					
					
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>资格取得信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">CPA证号</td>
						<td class="data_tb_content" height="18"><input name="cpano" type="text" id="cpano"  size="25"  value = "${userMap.cpano }" cannotedit></td>
						<td class="data_tb_alignright" height="18">注师批准文号</td>
						<td class="data_tb_content" height="18"><input name="cpapermitno" type="text" id="cpapermitno"  size="25"  value = "${userMap.cpapermitno }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">职称等级</td>
						<td class="data_tb_content" height="18"><input name="professional" type="text" id="professional" maxlength="20" size="25"  value = "${userMap.professional }"></td>
						<td class="data_tb_alignright" height="18">专业职称</td>
						<td class="data_tb_content" height="18"><input name="rank" type="text" id="rank"  size="25" maxlength="100" value = "${userMap.rank }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">申请时间</td>
						<td class="data_tb_content" height="18"><input name="application" type="text" id="application"  size="25"  value = "${userMap.application }" showcalendar="true"></td>
						<td class="data_tb_alignright" height="18">批准时间</td>
						<td class="data_tb_content" height="18"><input name="approve" type="text" id="approve"  size="25"  value = "${userMap.approve }" showcalendar="true"></td>
					</tr>
					<tr style="display:none">
						<td class="data_tb_alignright" height="18">全科合格证书</td>
						<td class="data_tb_content" height="18"><input name="certificate" type="text" id="certificate"  size="25"  value = "${userMap.certificate }" cannotedit></td>
						<td class="data_tb_alignright" height="18">考核批准文号</td>
						<td class="data_tb_content" height="18"><input name="general2" type="text" id="general2"  size="25"  value = "${userMap.general }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">档案存放单位</td>
						<td class="data_tb_content" height="18"><input name="filestorage" type="text" id="filestorage"  size="25"  value = "${userMap.filestorage }" cannotedit></td>
						<td class="data_tb_alignright" height="18">档案存放单位类型</td>
						<td class="data_tb_content" height="18"><input name="filetype" type="text" id="filetype" maxlength="100" size="25"  value = "${userMap.filetype }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">全科合格证书/考核批准文号</td>
						<td class="data_tb_content" height="18" colspan="3">
							<input name="general" type="text" id="general"  size="25"  value = "${userMap.general }" cannotedit>
						</td>
					</tr>
					
					<!-- 
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							colspan="4" height="18"><b>联系方式</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">邮编</td>
						<td class="data_tb_content" height="18"><input name="postcode" type="text" id="postcode" maxlength="10" size="25"  value = "${userMap.postcode }" myClass="number"></td>
						<td class="data_tb_alignright" height="18">电子邮箱</td>
						<td class="data_tb_content" height="18"><input name="email" type="text" id="email"  size="25" maxlength="50" value = "${userMap.email }" myClass="email"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="14">电话</td>
						<td class="data_tb_content" height="14"><input name="phone" type="text" id="phone"  size="25" maxlength="20" value = "${userMap.phone }" myClass="phone"></td>
						<td class="data_tb_alignright" height="14">手机</td>
						<td class="data_tb_content" height="14"><input name="mobile" type="text" id="mobile"  size="25" maxlength="20" value = "${userMap.mobile }" myClass="number"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">通信地址</td>
						<td class="data_tb_content" colSpan="3" height="18"><input name="address" type="text" id="address" maxlength="200" size="25"  value = "${userMap.address }"></td>
					</tr>
					 -->
					 
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>
<!--中部表格结束--></div>

</DIV>
<input name="pwd" type="hidden" id="pwd" value="${userMap.pwd }">
<input name="ctypetabname" type="hidden" id="ctypetabname"
	value="${userMap.ctypetabname }"> <input name="userphotoname"
	type="hidden" id="userphotoname" value="${userMap.userphotoname }">



<input type="hidden" id="uploadFileName" name="uploadFileName" value="">

</form>
<form name="myForm" id="myForm" action="" method="post"
	enctype="multipart/form-data" target="hidden_frame">

<div id="divBlock"
	style="position: absolute; width: 100%; height: 100%; top: expression(this . offsetParent . scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;">
</div>
<div id="divProduce"
	style="position: absolute; width: 400px; height: 50px; z-index: 2; left: expression(( document.body.clientWidth-550)/ 2 ); top: expression(( document.body.clientHeight-1100)/ 2 ); border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
	<!-- <div align="left" style="color: red;">*注意:照片上传后将不能更改,请上传您的真实照片</div><br> -->
	<fieldset><legend><font size="2">图片上传</font></legend> <input
	type="file" id="attachments" size="50" name="attachments" /> <input
	type='submit' class="flyBT" value='确定' onclick="return upLoadSumbit();">
<input type="button" class="flyBT" value="关闭" onclick="hiddenProDiv();">
</fieldset>
</div>

</form>
<iframe name='hidden_frame' id="hidden_frame" style='display: none'></iframe>

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
	
	$("select").each(function(index,obj){
		obj.disabled = true ;
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
	if(pwd_one != null || pwd_one != ""){
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
function saveMicfo(){
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	
	document.thisForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=updateSave";
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
		alert("您已经上传了个人照片,不能重复上传!");
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
	myForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=uploadPhoto" ;
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
		var url="${pageContext.request.contextPath}/micfo/micfo.do?method=deletePhoto&userphotoname="+userphotoname.value+"&loginid=${userMap.loginid}&ctypetabname=${userMap.ctypetabname }" ;
		oBao.open("POST",url,false);
		oBao.send();

		resText = oBao.responseText ;
		
		alert(resText);
		document.getElementById("bill").src = "${pageContext.request.contextPath}/images/administrator.png";
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
			if(obj.id == "ctype"){
				obj.readOnly = true;
			}else{
				obj.readOnly = false;
			}
			if (obj.myClass){
				obj.className = obj.myClass;
			}else{
				obj.className = "";
			}
		}	
	});
	
	$("textarea").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.readOnly = false;
			obj.className = "";
		}
	});
	
	$("select").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.disabled = false ;
			obj.className = "";
		}
	});
	 
	document.getElementById("logospan").style.display="";
	document.getElementById("update").style.display="";


	
	document.getElementById("intotime").readOnly=true;
	document.getElementById("application").readOnly=true;
	document.getElementById("approve").readOnly=true;
	
}


  //加验证
  $(document).ready(function(){
    $("#thisForm").validate();
  });


 // 返回处理 
function goBack(){
	document.thisForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame&param=mainFrame";
	document.thisForm.target = "mainFrame";
	document.thisForm.submit();
}

// 修改密码处理 
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
		var url="${pageContext.request.contextPath}/micfo/micfo.do?method=updatePwds&ctypetabname="+ctypetabname+"&pwd_old="+pwd_old+"&pwd_one="+pwd_one ;
		oBao.open("POST",url,false);
		oBao.send();
	
		resText = oBao.responseText ;
		alert(resText);
	}
	
}
</script>
