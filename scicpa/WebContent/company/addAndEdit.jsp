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
		<c:if test="${userSession.userMap.officetype=='事务所'}">
			会&nbsp;&nbsp;计&nbsp;&nbsp;师&nbsp;&nbsp;事&nbsp;&nbsp;务&nbsp;&nbsp;所&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
		</c:if>
		<c:if test="${userSession.userMap.officetype=='评估所'}">
			资&nbsp;&nbsp;产&nbsp;&nbsp;评&nbsp;&nbsp;估&nbsp;&nbsp;机&nbsp;&nbsp;构&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
		</c:if>
	</center>

<DIV class=block id=search style="height: 100%;">

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">单位信息</A> 
<A class="tab " id=sjdwtab href="javascript:setTab('search','sjdw')">用户信息</A>
</H3>
<div class=tabcontent id="sjdw" style="text-align:center;display: none">
		<table height="5%" border="0" cellspacing="0" cellpadding="0">
			<tr align="center">
			  <td width="33%" align="left">
			  	<div id="xgc1">
			     		<input type="button" name="xgb" id="xgb" icon="icon-edit" value="修  改" class="flyBT" onclick="updateStyle();" >
		     	</div>
			  </td>
			  <td width="20%">
			  	<div style="display: none" id="bcc1">
			 			<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="updatePwds();" >
		 		</div>
			  </td>
			  <td width="33%" align="left">
			<input type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onclick="goBack();" >
				</td>
			  </tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center"> 
			<tr>
                <td class="data_tb_alignright" style="text-align: left;" colspan="3"><b>用户信息</b></td>
            </tr>
			
			<tr>
				<td class="data_tb_alignright" align="left">登录名</td>
				<td colspan="2" align="left"><input maxlength="30" class="data_tb_content" name="loginid" type="text" id="loginid"  size="20"  value="${userMap.loginid }" disabled="disabled"></td>
			</tr>
			<tr>
				<td class="data_tb_alignright" align="left">会员类型</td>
				<td colspan="2" align="left"><input maxlength="30" class="data_tb_content" name="ctype" type="text" id="ctype"  size="30" value = "${userMap.ctype }" disabled="disabled"></td>
			</tr>
			
			<!-- 
			<tr>
				<td class="data_tb_alignright" align="left" >最后修改时间</td>
				<td colspan="2" align="left"><input class="data_tb_content" name="lastmodified" type="text" id="lastmodified"  size="20" readonly="readonly" value = "${userMap.lastmodified }"></td>
			</tr>
			<tr>
				<td class="data_tb_alignright" align="left">最后修改人</td>
				<td colspan="2" align="left"><input class="data_tb_content" name="lastpeople" type="text" id="lastpeople"  size="20" readonly="readonly" value = "${userMap.lastpeople }"></td>
			</tr>
			 -->
			
		    <tr>
                <td class="data_tb_alignright" style="text-align: left;" colspan="3"><b>密码设置</b></td>
            </tr>
			
			 
			<tr>
				<td class="data_tb_alignright" align="left">旧密码</td>
				<td colspan="2" align="left"><input maxlength="30" class="data_tb_content" name="pwd_old" type="password" id="pwd_old"  size="20"  /></td>
			</tr>
			<tr>
				<td class="data_tb_alignright" align="left">新密码</td>
				<td colspan="2" align="left"><input maxlength="30" class="data_tb_content" name="pwd_one" type="password" id="pwd_one"  size="20"  /></td>
			</tr>
			<tr>
				<td class="data_tb_alignright" align="left">确认密码</td>
				<td colspan="2" align="left" width="80%">
					<input maxlength="30" style="margin-right: 10px;" class="data_tb_content" name="pwd_two" type="password" id="pwd_two"  size="20"  />
					<!-- <span id="update" style="display:none"><a href="#" onclick="return saveCompany();">【 修  改 】</a></span> -->
				</td>
			</tr>
			
		</table>	
		<input maxlength="30" class="data_tb_content" name="state" type="hidden" id="state"  size="25"  value = "${userMap.state }">
 	
</div>

<input maxlength="100" type="hidden" id = "association" name = "association" title="所在协会" value = "${userMap.association }"> 
<input maxlength="100" type="hidden" id = "officename" name = "officename" title="事务所全称" value = "${userMap.officename }">

<div class=tabcontent id="dgxx" style="text-align:center;">
<table height="5%" border="0" cellspacing="0" cellpadding="0">
  <tr align="center">
    <td width="33%" align="left">
    	<div id="xgc">
       		<input type="button" name="xgb" id="xgb" icon="icon-edit" value="修  改" class="flyBT" onclick="updateStyle();" >
       	</div>
    </td>
    <td width="20%">
    	<div style="display: none" id="bcc">
   			<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="return saveCompany();" >
   		</div>
    </td>
    <td width="33%" align="left">
		<input type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onclick="goBack();" >
	</td>
  </tr>
</table>
<table border="0" cellSpacing="0" cellPadding="0" width="100%" bgColor="#ffffff" align="center">
  <tbody>
    <tr>
      <td height="250" vAlign="top" align="middle"><!--顶部图片结束-->
        <!--中部表格开始-->
        <table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
          <tbody>
            <tr>
              <td vAlign="top">
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
                      <td class="data_tb_alignright" width="20%">事务所名称<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="loginname" size="50" name="loginname" value="${userMap.loginname }" cannotedit> </td>
                     
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
                      <td class="data_tb_content"><textarea style="width: 90%;height: 70px;" id="remark" name="remark">${userMap.remark}</textarea></td>
                    </tr>
                    
                    <tr>
                      <td class="data_tb_alignright" width="20%">事务所代码<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="officecode" name="officecode" value="${userMap.officecode}" cannotedit></td>
                      <td class="data_tb_alignright">注册资金<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" class="borderstyle" id="capital" name="capital" value="${userMap.capital}" cannotedit>万元</td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">组织形式<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" id="organization" name="organization" value="${userMap.organization}" cannotedit></td>
                      <td class="data_tb_alignright">所在城市<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="30" onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=10
						hideresult=true id="area" name="area" value="${userMap.area}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">成立批准时间<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" id="approval" name="approval" value="${userMap.approval}" cannotedit></td>
                      <td class="data_tb_alignright">成立批准文号<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" id="approvalnumber" name="approvalnumber" value="${userMap.approvalnumber}" cannotedit></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">税务登记号</td>
                      <td class="data_tb_content"><input maxlength="100" id="tax" name="tax" value="${userMap.tax }"></td>
                      <td class="data_tb_alignright">成立批准机关</td>
                      <td class="data_tb_content"> <input maxlength="100" id="approvalauthority" name="approvalauthority" value="${userMap.approvalauthority}"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">工商登记日期</td>
                      <td class="data_tb_content"><input maxlength="100" id="businesstime" name="businesstime" value="${userMap.businesstime}"  showcalendar="true" readonly="readonly"></td>
                      <td class="data_tb_alignright">工商登记号</td>
                      <td class="data_tb_content"><input maxlength="100" id="business" name="business" value="${userMap.business}"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">主任会计师<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" id="corporate" name="corporate" value="${userMap.corporate}" cannotedit></td>
                      <td class="data_tb_alignright">主任会计师手机号<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content">
                      	<input maxlength="100" id="corporatephone" name="corporatephone" value="${userMap.corporatephone}" myClass="phone" >
                      </td>
                    </tr>
                     <tr>
                      <td class="data_tb_alignright">股东或合伙人总数<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="" type="text" id="" title="股东或合伙人总数" value="${shareholderCount }" cannotedit></td>
                      <td class="data_tb_alignright">股东或合伙人姓名<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="" type="text" id="" title="股东或合伙人姓名" value="${shareholderNames }" cannotedit></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" style="text-align: left;" colspan="4"><b>联系方式</b></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">地址<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" colspan="3"><input maxlength="100" style="width: 83%;" type="text" id="address" name="address" value="${userMap.address}" class="required"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">联系人<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="50" name="linkman" type="text" id="linkman" value = "${userMap.linkman}" class="required"></td>
                      <td class="data_tb_alignright">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="phone" type="text" id="phone" value = "${userMap.phone }" class="required"></td>
                    </tr>
                     
                    <tr>
                      <td class="data_tb_alignright">联系人手机号<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content">
                      	<input maxlength="100" name="linkphone" type="text" id="linkphone" class="phone" value = "${userMap.linkphone}">
<%--                       	<input maxlength="100" name="linkphone" type="text" id="linkphone" class="phone" value = "${userMap.linkphone}" <c:if test="${userMap.linkphoneupdate=='N' }">cannotedit</c:if> > --%>
                      </td>
                      <td class="data_tb_alignright">邮政编码<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="postcode" type="text" id="postcode" value = "${userMap.postcode}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">E-Mail<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="email" type="text" id="email" value = "${userMap.email}"></td>
                       <td class="data_tb_alignright">传真<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" name="postalcode" type="text" id="postalcode" value = "${userMap.postalcode}"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">网址</td>
                      <td class="data_tb_content" colspan="3">
                      	<input maxlength="100" style="width: 83%;" type="text" id="url" name="url" value="${userMap.url}">
                      </td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" style="text-align: left;" colspan="4">
                      		<b>执业信息</b>
                      		&nbsp;&nbsp;<font color="#FF0000">( 部分要素是无法自行修改的，如果要修改请通过所属注协 )</font>
                      	</td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">业务规模：&nbsp;</td>
                      <td class="data_tb_content"><input maxlength="100" id="scale" name="scale" value="${userMap.scale}"></td>
                      <td class="data_tb_alignright">其他资质：&nbsp;</td>
                      <td class="data_tb_content"><input maxlength="100" id="other" name="other" value="${userMap.other }"></td>
                    </tr>
                    <tr>
                   	  <td class="data_tb_alignright">注册会计师总数<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input maxlength="100" id="cpa" name="cpa" myClass="number" value="${cpaCount}" cannotedit></td>
                      <td class="data_tb_alignright">从业人员总数</td>
                      <td class="data_tb_content"><input maxlength="100" id="employees" name="employees" myClass="number" value="${userMap.employees }"></td>
                    </tr>
                   
                  </tbody>
                </table>
              </td>
            </tr>
          </tbody>
        </table>
        <!--中部表格结束-->
      </td>
    </tr>
  </tbody>
</table>

</div>
</DIV>
<input name="pwd" type="hidden" id="pwd"  value="${userMap.pwd }"  >
<input name="ctypetabname" type="hidden" id="ctypetabname"  value="${userMap.ctypetabname }"  >
<input name="userphotoname" type="hidden" id="userphotoname"  value="${userMap.userphotoname }"  >

	

<input type="hidden" id="uploadFileName" name="uploadFileName" value="">
<input type="hidden" id="corporatephoneupdate" name="corporatephoneupdate"  value="${userMap.corporatephoneupdate }" >
<input type="hidden" id="corporatephone_bofore" name="corporatephone_bofore"  value="${userMap.corporatephone }" >
<input type="hidden" id="linkphoneupdate" name="linkphoneupdate"  value="${userMap.linkphoneupdate }" >
<input type="hidden" id="linkphone_before" name="linkphone_before"  value="${userMap.linkphone }" >

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

function checkMobile(s){ 
	var regu =/^[1][3,5,8,9][0-9]{9}$/; 
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
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
	
	var corporatephone = document.getElementById("corporatephone").value;
	var linkphone = document.getElementById("linkphone").value;
	if(!checkMobile(corporatephone)){
		alert("请填写合法的主任会计师手机号！");
		document.getElementById("corporatephone").select();
		return;
	}
	if(!checkMobile(linkphone)){
		alert("请填写合法的联系人手机号！");
		document.getElementById("linkphone").select();
		return;
	}
	
	
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
		document.getElementById("bill").src = "${pageContext.request.contextPath}/common/attachFile/K_Company/"+srcName;
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
			if(obj.id == "lastpeople" || obj.id == "lastmodified" || obj.id == "ctype" || obj.id=="area"){
				obj.readOnly = true;
			}else if(obj.id=="address" || obj.id=="linkman" || obj.id=="phone" || obj.id=="linkphone" || obj.id=="postcode" || obj.id=="email" || obj.id=="postalcode" || obj.id=="corporatephone"){
				obj.readOnly = false;
				obj.className = "required";
			}else{
				obj.readOnly = false;
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
		alert(resText);
		document.thisForm.action = "${pageContext.request.contextPath}/company/company.do?method=goAddFrame";
		document.thisForm.target="mainFrame";
		document.thisForm.submit();
	}
}
//1 
</script>
