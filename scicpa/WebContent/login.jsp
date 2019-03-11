<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<Meta name="Robots" Content="None">

<title>四川省注协服务管理平台_登录</title>


<SCRIPT LANGUAGE=JAVASCRIPT>
<!--
if (top.location != self.location)top.location=self.location;
// -->
</SCRIPT>
</head>
<body  leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="overflow:hidden;FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=#339933,endColorStr=#ffffff) revealTrans(duration=3,transition=0) ;">

<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<div id="search" style="position:absolute;width:22%;height:28%; z-index:1;left:40%;top:30%; border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
    <br>
    <fieldset  style="border: 1px solid lightblue;width:95%;height: 90%;margin-left: 2px;" id="fieldset">
		<legend>
			<font style="color: red;font-size: 15px">请完善主任会计师手机号码</font>
		</legend>
		<table align="center" style="margin-top: 15px;background: #ffffff;width: 100%;height: 30%">
    		<tr>
    			<td style="text-align: right;">
    				<font style="font-size: 15px;">手机号码：</font>
    			</td>
    			<td >
    				<input id="corporationphone" name="corporationphone" maxlength="11">
    			</td>
    		</tr>
    	</table>
    	<br>
   		<table width="90%" style="margin-left: 25%;">
			<tr>
				<td>
					<input id="pass" icon="icon-save" type="button" onclick="f_sure()" value="确定">
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
			    	<input id="pass" icon="icon-delete" type="button" onclick="f_quxiao();" value="取消">
			    </td>
			</tr>
    	</table>
    	<br>
   	</fieldset>
</div>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>
		<table width="465" height="380" border="0" align="center" >
			<tr>
				<td style="background-image: url('${pageContext.request.contextPath}/images/jx_login3.png');background-repeat: no-repeat;">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="50%" height="90">&nbsp;</td>
						<td width="34%" height="90" align="center" valign="middle">

							<div id=state2 name=state2 >
							<form id="thisForm" name="thisForm" action="${pageContext.request.contextPath}/common/login.do?method=login" method="post" >
							
							<table width="98%" border="0" cellpadding="0" cellspacing="0">

								<tr>
									<td width="30%" height="33" align="right" nowrap="nowrap" style="font-size: 12px;">
										用户类型：
									</td>
									<td width="70%" align="left">
										 <select id="userType" onchange="changeUserType(this)" name="userType" style="width: 123px;">
										 	<option value="1">事务所用户</option>
										 	<option value="0">个人用户</option>
										 </select>
										 
									</td>
								</tr>
								
								<tr>
									<td width="35%" height="33" align="right" nowrap="nowrap" style="font-size: 12px;">
										用户名：
									</td>
									<td width="65%" align="center">
										 <input  name="AS_usr"
												type="text" id="AS_usr"
												value="${cookiesValue}"
												size="20"
												style="height:20px;width:125px"
												hideresult=true
												tabindex="1">
										 
									</td>
								</tr>

								<tr>
									<td align="right" nowrap="nowrap" style="font-size: 12px;" height="33">
										密&nbsp;&nbsp;&nbsp;&nbsp;码：
									</td>

									<td align="center">
										<input  name="AS_psw"
												type="password"
												id="AS_psw"
												value="matech3"
												size="13"
												style="height:20px;width:125px"
												tabindex="2"
												>

										<input  name="AS_dog"
												type="hidden"
												id="AS_dog"
												value=""
												style="height:20px;width:125px"
												tabindex="3">

										<input name="userScreen"
												type="hidden"
												id="userScreen"
												value="" />
									</td>
								</tr>
								<tbody id="pwd_tbody">
									<tr id="dynamicPwd">
										<td align="right" nowrap="nowrap" style="font-size: 12px;"  height="33">
											动态口令号：
										</td>
	
										<td align="center">
											<input  name="AS_dynamicPwd"
													type="text"
													id="AS_dynamicPwd"
													value=""
													size="13"
													style="height:20px;width:125px"
													tabindex="2">
										</td>
									</tr>
								</tbody>
								<tr>
									<td colspan="2" height="30" align="center" valign="top">
										<div style="text-align: center;margin-top: 0px;"><font size=2 color=red>&nbsp;${serverinfo}</font></div>
										<input type="submit"
											   value="登 录"
											   tabindex="3"
											   class="common"
											   onclick="return loginChk();"
											   style="FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=#438CCF,endColorStr=#006699) revealTrans(duration=3,transition=0);
													background-color:#006699;border: 0px; color: #ffffff; font-size: 12px; width: 66px; height: 22px;margin-top: 5px;" />
									<span  id='hint' style='display:none'></span>
									
									</td>
								</tr>
								
							</table>
							</form>
							</div>
						</td>

						<td width="32%">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<p>&nbsp;</p>
							<font color="blue">※本系统支持IE9及以下版本的浏览器※</font>
						</td>
					</tr>
				</table>						
							<div id="notice" align="center" style="display: none">
								铭太服务热线：020-83063585或38378976，QQ1657810124。
							</div>
							<div id="notice2" align="center" style="display: none">事务所会员用户名是执业证上的事务所编号;<br>
								动态口令号为动态密钥6位密码。铭太服务热线：020-83063585或38378976，QQ1657810124。
							</div>	
				<p>&nbsp;</p>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>




<script type="text/javascript">

	/* var xhr = new XMLHttpRequest();   

	xhr.setRequestHeader('C', 'application'); */
	var ut = getCookie("userType");
	
	if(ut) {
		document.getElementById("userType").value = ut ;		
	}

	var userType = document.getElementById("userType").value;
	if(userType == "1") {
		document.getElementById("dynamicPwd").style.visibility = "visible" ;
	}else {
		document.getElementById("dynamicPwd").style.visibility = "hidden" ;
	}
	
	if(userType==1){
		//document.getElementById("notice").style.display = "none" ;
		document.getElementById("notice2").style.display = "" ;
	}else if(userType==0){
		document.getElementById("notice").style.display = "" ;
		//document.getElementById("notice2").style.display = "none" ;
	}


// 检测是否设置过电话号码
var isSetPhone = "${isSetPhone}";
if(isSetPhone=="N"){
	document.getElementById("search").style.display = "";
	document.getElementById("divBlock").style.display = "";
	document.getElementById("AS_usr").value = "${AS_usr}";
	document.getElementById("AS_psw").value = "${AS_psw}";
	document.getElementById("AS_dynamicPwd").value = "${AS_dynamicPwd}";
}

// 取消
function f_quxiao(){
	document.getElementById("search").style.display = "none";
	document.getElementById("divBlock").style.display = "none";
}

// 确定
function f_sure(){
	// 检查电话号码
	var corporationphone = document.getElementById("corporationphone").value;
	if(checkMobile(corporationphone)){
		var AS_usr = document.getElementById("AS_usr").value;
		
		// 修改电话号码
		var url = "${pageContext.request.contextPath}/common/login.do?method=updatePhone";
		var request = "&loginid="+AS_usr+"&corporationphone="+corporationphone;
		var rs = ajaxLoadPageSynch(url,request);
		if(rs=="Y"){
			// 影藏层
			f_quxiao();
			// 提交
			document.getElementById("thisForm").submit(); 
		}else{
			alert("设置电话号码失败，请重新设置！");
			return false;
		}
	}else{
		alert("请填写正确的手机号码！");
		return false;
	}
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


function changeUserType(obj) {
	var dynamicPwd = document.getElementById("dynamicPwd");
	//var notice = document.getElementById("notice");
	if(obj.value == "1") {
		dynamicPwd.style.visibility = "visible" ;
		document.getElementById("notice").style.display = "none" ;
		document.getElementById("notice2").style.display = "block" ;
	}else {
		dynamicPwd.style.visibility = "hidden" ;
		document.getElementById("notice").style.display = "block" ;
		document.getElementById("notice2").style.display = "none" ;
	}
}


function getCookie(objName){//获取指定名称的cookie的值
    var arrStr = document.cookie.split("; ");
    for(var i = 0;i < arrStr.length;i ++){
     var temp = arrStr[i].split("=");
     if(temp[0] == objName) return unescape(temp[1]);
    }
   }


//获取主机地址
function getlocationhost(){
	return "http:\/\/"+window.location.host;
}

function checkUserOnline() {
	var userLoginId = document.getElementById("AS_usr").value;
	var password = document.getElementById("AS_psw").value;

	var query_String = "&userLoginId=" + userLoginId
					 + "&password=" + password;

	var url = "${pageContext.request.contextPath}/onlineUser.do?method=checkUserOnline";

	return ajaxLoadPageSynch(url,query_String);
}

var mtoffice;

function loginChk(){
	
	/*
	if(!window.navigator.onLine) {
  		alert("您的IE已被设成\"脱机工作\",请去掉IE菜单栏中\"文件(F)\"->\"脱机工作(W)\"前的钩后再点击登录! ");
  		return false;
  	}
  	*/
  	var userType = document.getElementById("userType").value;
  	document.cookie = "userType="+userType+";" ;
  	
	if(thisForm.AS_usr.value==""){
		alert("用户名不能为空！");
		thisForm.AS_usr.focus();
		return false;
	}
	if(thisForm.AS_psw.value==""){
		alert("密码不能为空！");
		thisForm.AS_psw.focus();
		return false;
	}

	document.getElementById("userScreen").value = window.screen.width;
	/*
	try {
		var result = checkUserOnline();

		//alert(result);
		
		if(result != 'offLine' && result != 'noUser') {
			//如果用户在线
			if(confirm("该用户已经登录,如果您继续登录的话,将会导致已登录的该用户强行退出!")) {
				try {
					var query_String = "&sessionId=" + result;
					var url = "${pageContext.request.contextPath}/onlineUser.do?method=kickUser";
					ajaxLoadPageSynch(url,query_String);
				} catch(e) {
					//alert(e);
				}

				return true;
			} else {
				//用户离线或者用户名密码错误
				return false;
			}
		}
	} catch(e) {
		//alert(e);
	}
	*/
}


	function fadein(){
	    var cur=23;
	    var bodytext=document.body.innerHTML;
		document.body.innerHTML='';
		document.body.filters.revealTrans.Transition=cur;
		document.body.filters.revealTrans.apply();
		document.body.innerHTML=bodytext;
		document.body.filters.revealTrans.play();
	}


	function next() {
		var src = event.srcElement;
		if (event.keyCode != 13)
			return;

		if (src.type == "text") {
			document.getElementById("AS_psw").focus();
			return false;
		}

		if (src.type == "password") {
			//thisForm.submit();
			return true;
		}
	}




	${cookiesValue1}

</script>

<div id="searchError" style="position:absolute;width:20%;height:80px; z-index:1;left:expression((document.body.clientWidth-250)/2);top:expression(this.offsetParent.scrollTop + 230); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">

	<br/>
   <center>
   <font style="font-size: 15">用户类型选择错误！</font>
   <br/><br/>
    <input id="pass" icon="icon-save" type="button" onclick="typeNo();" value="确定">
   <br/>
   </center>
</div>

<script type="text/javascript">
var typeError = "${typeError}";
if(typeError=="error"){
	document.getElementById("searchError").style.display = "";
	document.getElementById("divBlock").style.display = "";
	document.getElementById("AS_usr").value = "${AS_usr}";
	document.getElementById("AS_psw").value = "${AS_psw}";
	document.getElementById("AS_dynamicPwd").value = "${AS_dynamicPwd}";
	
}


 function typeNo(){
		 document.getElementById("searchError").style.display = "none";
		 document.getElementById("divBlock").style.display = "none";
 }
</script>
</body>
</html>
