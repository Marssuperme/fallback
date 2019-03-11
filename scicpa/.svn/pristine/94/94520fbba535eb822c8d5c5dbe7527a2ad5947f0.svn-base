<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>会员自助服务平台</title>

<style >
a { text-decoration: none; font-weight: bolder;}
a:hover {
	text-decoration: underline;
	font-size: 20px;
}
</style>

</head>
<body >
<form id="myform" name="myform" method="post" >
	<input type="hidden" id="typeId" name="typeId" >
	<input type="hidden" id="idNumber" name="idNumber" >
	<input type="hidden" id="departName" name="departName" >
	<input type="hidden" id="ctypeTabName" name="ctypeTabName" >
	<input type="hidden" id="loginId" name="loginId" >
	<input type="hidden" id="officeCode" name="officeCode" >
</form>
<div style="width: 1234px;height: 995px;">
	<img src="entry.jpg" style="width: 102%;height: 102%;">
</div> 

<table style="position: absolute;z-index: 1;width: 370px;height: 50px;left: 530px;top: 415px;" cellspacing="15">
	<tr>
		<td align="right"><font color="blue" style="font-size: 15">身份证姓名：</font></td>
		<td>
			<input type="text" id="identityName" name="identityName" readonly="" size="22">
			<!-- &nbsp;<input type="button" value="读卡" onClick="f_startRead()"> -->
	  </td>
	</tr>
	<tr>
		<td align="right"><font color="blue" style="font-size: 15">身份证：</font></td>
		<td>
			<input type="text" id="identityCard" name="identityCard" readonly="" size="22">
	  	</td>
	</tr>
	<tr>
		<td align="right"><font color="blue" style="font-size: 15">照片：</font></td>
		<td>
			<OBJECT Name="GT2ICROCX" width="102" height="126" 
					CLASSID="CLSID:220C3AD1-5E9D-4B06-870F-E34662E2DFEA"
					CODEBASE="IdrOcx.cab#version=1,0,1,2">			
			</OBJECT>
	  	</td>
	</tr>
	
	<tr>
		<td colspan="2" >
		</td>
	</tr>
	
	<tr>
		<td align="center" colspan="2" >
			<span id="info" style="color: red;font-size: 18;margin-left: 40px;">未检测到身份证，请刷身份证。</span>
		</td>
	</tr>
</table>

</body>

<script type="text/javascript">


// 登陆
function f_login(idnumber){
	var url="${pageContext.request.contextPath}/common/login.do?method=loginByIdentity";
	var request = "&idnumber="+idnumber;
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}

var interval_id = "";

// 设置数据信息
function f_myGetData(){//OCX读卡成功后的回调函数
	GT2ICROCX.PhotoPath = "c:"
	//GT2ICROCX.Start() //循环读卡
	var state0 = GT2ICROCX.GetState()
	if(state0==0){
		var _state = GT2ICROCX.ReadCard();
		if(_state>=0){
			document.getElementById("info").innerHTML = "正在登陆中，请稍等...";
			var _name = GT2ICROCX.NameL;
			var _cardNo = GT2ICROCX.CardNo;
			document.getElementById("identityName").value = _name;
			document.getElementById("identityCard").value = _cardNo;
			// 登陆
			var rs = f_login(_cardNo);
			var obj_array = eval('('+rs+')');
			var ctypetabname = obj_array[0].ctypetabname;
			var idnumber = obj_array[0].idnumber;
			var name = obj_array[0].name;
			var loginId = obj_array[0].loginid;
			var officeCode = obj_array[0].officecode;
			
		 	document.getElementById("ctypeTabName").value = ctypetabname;
		 	document.getElementById("idNumber").value = idnumber;
		 	document.getElementById("departName").value = name;
		 	document.getElementById("loginId").value = loginId;
		 	document.getElementById("officeCode").value = officeCode;
			var param = "?ctypeTabName="+ctypetabname+"&idNumber="+idnumber+"&departName="+name+"&loginId="+loginId+"&officeCode="+officeCode;
			if(ctypetabname=="k_cicpa"){ // 注协用户
				param = param + "&typeId=kq&paremTemp="+Math.random();
			 	var url = "${pageContext.request.contextPath}/common/member/step2.jsp" + param;
			 	document.getElementById("typeId").value = "kq";
			 	//window.showModalDialog(url,"","dialogWidth=1500px;dialogHeight=1000px;toolbar=no;scrollbars=no;location=no");
			 	
			 	//清除定时器：只有真实会员登录成功了才清除
				window.clearInterval(interval_id);
				 
			 	window.location = url;
			} 
			
			if(ctypetabname=="k_micfo" || ctypetabname=="k_micfono"){ // 个人用户
				param = param + "&typeId=bs&paremTemp="+Math.random();
			 	var url = "${pageContext.request.contextPath}/common/member/step2.jsp" + param;
				document.getElementById("typeId").value = "bs";
			 	//window.showModalDialog(url,"","dialogWidth=1500px;dialogHeight=1000px;toolbar=no;scrollbars=no;location=no");
			 	
				//清除定时器：只有真实会员登录成功了才清除
				window.clearInterval(interval_id);
				 
			 	window.location = url;
			}
			
			//清空信息
			f_clearInfo();
			
		}else{
			//清空信息
			f_clearInfo();
		} 
	}else{
		//清空信息
		f_clearInfo();
	}
}

//清空信息
function f_clearInfo(){
	document.getElementById("identityName").value = "";
	document.getElementById("identityCard").value = "";
	document.getElementById("info").innerHTML = "未检测到身份证，请刷身份证。";
} 

// 定时读身份证	
interval_id = window.setInterval("f_myGetData()",1000);
	
</script>

</html>