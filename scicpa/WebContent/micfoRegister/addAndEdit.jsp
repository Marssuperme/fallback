<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ include file="/Sys_INCLUDE/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>注师注册信息</title>
<style>
	.left{
		width: 20%;
		text-align: left;	
	}
	.color{
		background-color: #e4f4fe;
	}
	.right1{
		width: 25%;
		text-align: right;
		background-color: #e4f4fe;
	}
	.alongHR{
		font-size: 15;
	}
	
	#table{
		width:95%;
		border-collapse:collapse;
	}
	 
	#table td{ 
		border:solid 1px #B4CDCD; 
		height:22px; 
	} 
</style>
</head>
<body>
	<form name="uploadForm" id="uploadForm" action="" method="post" enctype="multipart/form-data" target="hidden_frame">
		<input type="hidden" id="uploadFileName" name="uploadFileName" value="">
		<input type="hidden" id="ids" name="ids" value="${mr.id}">
		
		<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
		</div>
		<div id="divProduce" style="position:absolute;width:400px;height:100px; z-index:2;left:expression((document.body.clientWidth-540)/2);top:expression((document.body.clientHeight-1080)/2); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
			<fieldset>
				<legend><font size="2">图片上传</font></legend>
				<input type="file" id="attachments" size="50" name="attachments"/>
				<input type='submit' class="flyBT" value='确定' onclick="return upLoadSumbit();">
				<input type="button" class="flyBT" value="关闭" onclick="hiddenProDiv();">
			</fieldset>
		</div>
	</form>
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	
	<form id="myForm" name="myForm" method="post">
		<input type="hidden" id="id" name="id" value="${mr.id}">
		<input type="hidden" id="p" name="p" value="${p}">
		<input type="hidden" id="pd" name="pd" value="${pd}">
		<input type="hidden" id="userphotoname" name="userphotoname" value="">
		<br><br>
		<span style="margin-left: 40%"><font style="font-size: 20">&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息&nbsp;</font></span>
		<table align="center" id="table" cellpadding="3px;" class="data_tb">
			<tr>
				<td colspan="3" class="color">
					<font style="margin-left: 2%;font-size: 15"><b>个人信息</b></font>
				</td>
			</tr>
			<tr>
				<td class="color" width="30%" align="right" >CPA号<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input style="width:70%;" maxlength="12" id="loginid" name="loginid" value="${mr.loginid}" class="required" onkeyup="f_money(this)" ></td>
				<td rowspan="11" style="width:40%">
					<center>
						<c:choose>
							<c:when test="${mr.photo=='' || mr.photo==null}">
								<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/images/administrator.png"><br>
							</c:when>
							<c:otherwise>
								<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_MicfoRegister/${mr.photo}"><br>
							</c:otherwise>
						</c:choose>
						
						<input type="text" id="myText" size="1" style="display:none"> <br>
						<span id="logospan">
							<a id="no1" href="#" onclick="upLoadFile();">点击上传个人LOGO</a><br>
						</span>
					</center>
				</td>
			</tr>
			<tr>
				<td class="color" align="right" >姓名<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input style="width:70%;" id="loginName" name="loginName" value="${mr.loginName}" class="required"></td>
			</tr>
			
			<tr>
				<td class="color" align="right">出生日期<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input style="width:60%" id="bornDate" name="bornDate" value="${mr.bornDate}" showcalendar="true"  class="required" onkeypress="return false;" onpaste="return false;" ></td>
			</tr>
			<tr>
				<td class="color" align="right">民族<font color="#FF0000">&nbsp;[*]</font></td>
				<td>
					<input name="nation" 
						noinput=true
						type="text" 
						id="nation" 
						size="33" 
						maxlength="10"
						value="${mr.nation }" 
						autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="mingzu" class="required"  style="width:70%;">	
				</td>
			</tr>
			
			<tr>
				<td class="color" align="right">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input  class="required" id="phone" name="phone" value="${mr.phone}" style="width:70%;"></td>
			</tr>
			
			<tr>
				<td class="color" align="right">性别<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input  id="sex" name="sex" value="${mr.sex}"
						noinput=true
						autowidth="10%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=2 class="required" style="width:70%;">
				</td>
			</tr>
			<tr>
				<td class="color" align="right">学历<font color="#FF0000">&nbsp;[*]</font></td>
				<td> 
					<input name="diploma" type="text" id="diploma"  size="19" maxlength="50" value = "${mr.diploma }" 
						noinput=true
						autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="xueli" class="required"  style="width:80%;">
				</td>
			</tr>
			<tr>
				<td class="color" align="right">身份证号<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input maxlength="18" id="idnumber" name="idnumber" value="${mr.idnumber}" class="required" style="width:70%;">
				</td>
			</tr>
				<tr>
				<td class="color" align="right">合格证号或考核（认定）批准文号<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input style="width: 94.5%" id="certificate" name="certificate" value="${mr.certificate}" class="required">
				</td>
			</tr>
			<tr>
				<td class="color" align="right">批准注册文号<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input id="CPApermitno" name="CPApermitno" value="${mr.CPApermitno}" class="required" style="width:70%;">
				</td>
			</tr>
			<tr>
				<td class="color" align="right">批准注册时间<font color="#FF0000">&nbsp;[*]</font></td>
				<td><input id="approve" name="approve" value="${mr.approve}"  showcalendar="true" style="width:70%" class="required" onkeypress="return false;" onpaste="return false;" >
				</td>
			</tr>
			<%-- <tr>
				<td class="color" width="10%" align="right">国籍<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%"><input id="country" name="country" value="${mr.country}"
						noinput=true
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="city" class="required"  style="width:70%;"></td>
			</tr> --%>
			

			<%-- <tr>
				<td class="color" width="10%" align="right">专业职称<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%">
					<input class="required" id="rank" name="rank" value="${mr.rank}"
						noinput=true
						autowidth="10%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=45
						style="width:70%;"
						>
				</td>
			</tr> --%>
			
			<%-- <tr>
				<td class="color" width="10%" align="right">职称等级<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%" >
					<input class="required" id="professional" name="professional" value="${mr.professional}"
						noinput=true
						autowidth="10%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=41
						style="width:70%;">
				</td>
				<td class="color" width="10%" align="right">是否离退休</td>
				<td width="20%"> 
					<input name="retirees" type="text" id="retirees" size="19" maxlength="10"
						noinput=true
						value="${mr.retirees }" autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="workState"  style="width:80%;">	
				</td>
			</tr> --%>
<%-- 		<tr>
				<td class="color" width="10%" align="right">专业<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%"><input class="required" id="specialty" name="specialty" value="${mr.specialty}"  style="width:70%;"></td>
				<td class="color" width="10%" align="right">学历<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%"> 
					<input name="diploma" type="text" id="diploma"  size="19" maxlength="50" value = "${mr.diploma }" 
						noinput=true
						autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="xueli" class="required"  style="width:80%;">
				</td>
			</tr> --%>
			
			<%-- <tr>
				<td class="color" width="10%" align="right">进事务所前所在单位</td>
				<td width="20%"><input id="intobefore" name="intobefore" value="${mr.intobefore}" style="width:70%;"></td>
				<td class="color" width="10%" align="right">档案存放单位<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%"><input  class="required" id="filestorage" name="filestorage" value="${mr.filestorage}" style="width:80%;"></td>
			</tr> --%>
			
			<%-- <tr>
				<td class="color" width="10%" align="right">进事务所时间</td>
				<td width="20%"><input style="width: 60%" id="intotime" name="intotime" value="${mr.intotime}" showcalendar="true"></td>
				<td class="color" width="10%" align="right">从事审计业务时间(月)</td>
				<td width="20%"><input  id="auditTime" name="auditTime" value="${mr.auditTime}" style="width:80%;"></td>
			</tr> --%>
			<%-- <tr>
				<td class="color" width="10%" align="right">是否在事务所专职执业</td>
				<td width="20%"><input  id="iscomanySpecialty" name="iscomanySpecialty" value="${mr.iscomanySpecialty}" style="width:70%;"></td>
				<td class="color" width="10%" align="right">资格取得方式<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="20%">
					<input  class="required" id="seniorityType" name="seniorityType" value="${mr.seniorityType}"
						noinput=true
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="zgType"
						style="width:80%;">
				</td>
			</tr> --%>
		
			
			<%-- <tr>
				<td class="color" width="10%" align="right" rowspan="5">本人从事审计业务工作简历</td>
				<td width="20%" align="center">起止年月</td>
				<td width="10%" align="center">所在单位名称</td>
				<td width="20%" align="center">证明人</td>
			</tr>
			<tr>
				<td width="20%"><input id="startTime1" name="startTime1" value="${mr.startTime1}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime1" name="endTime1" value="${mr.endTime1}" style="width: 30%" showcalendar="true"></td>
				<td width="20%"><input id="stayCompany1" name="stayCompany1" value="${mr.stayCompany1}" style="width: 95%"></td>
				<td width="10%"><input id="certifier1" name="certifier1" value="${mr.certifier1}" style="width: 95%"></td>
			</tr>
			<tr>
				<td width="20%"><input id="startTime2" name="startTime2" value="${mr.startTime2}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime2" name="endTime2" value="${mr.endTime2}" style="width: 30%" showcalendar="true"></td>
				<td width="20%"><input id="stayCompany2" name="stayCompany2" value="${mr.stayCompany2}" style="width: 95%"></td>
				<td width="10%"><input id="certifier2" name="certifier2" value="${mr.certifier2}" style="width: 95%"></td>
			</tr>
			<tr>
				<td width="20%"><input id="startTime3" name="startTime3" value="${mr.startTime3}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime3" name="endTime3" value="${mr.endTime3}" style="width: 30%" showcalendar="true"></td>
				<td width="20%"><input id="stayCompany3" name="stayCompany3" value="${mr.stayCompany3}" style="width: 95%"></td>
				<td width="10%"><input id="certifier3" name="certifier3" value="${mr.certifier3}" style="width: 95%"></td>
			</tr>
			<tr>
				<td width="20%"><input id="startTime4" name="startTime4" value="${mr.startTime4}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime4" name="endTime4" value="${mr.endTime4}" style="width: 30%" showcalendar="true"></td>
				<td width="20%"><input id="stayCompany4" name="stayCompany4" value="${mr.stayCompany4}" style="width: 95%"></td>
				<td width="10%"><input id="certifier4" name="certifier4" value="${mr.certifier4}" style="width: 95%"></td>
			</tr> --%>
			<%-- <tr>
				<td class="color" width="10%" align="right">何时因何原因受到何种处罚或者处分</td>
				<td width="80%" colspan="3">
					<textarea rows="5" style="width: 99%" id="timeAndreason" name="timeAndreason" >${mr.timeAndreason}</textarea> 
				</td>
			</tr> --%>
		</table>
			
		<div style="margin-top:2%;" align="center" > 
			  <input type="button" icon="icon-save" value="保  存" onclick="f_save();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="button" icon="icon-back" value="返  回" onclick="window.history.back()">
		</div>
	</form>
</body>
<script type="text/javascript">
	 //加验证
	$(document).ready(function(){
	  $("#myForm").validate();
	}); 
	  
  	// 加载 对应的 名族
	/* var nvalue = "${mr.nation}";
	var nation = document.getElementById("nation");
	for(var i=0;i<nation.length;i++){
		if(nation[i].value==nvalue){
			nation[i].selected = true;
			break;
		}
	} */
	
	// 确定  
	function f_save(){
		if(!f_idnumber()){
			return;
		}
		
		if(!$("#myForm").valid()){
			return;
		};
		var id = document.getElementById("id").value;
		var url="${pageContext.request.contextPath}/common/micfoRegister.do?method=check";
		var loginid = document.getElementById("loginid").value;
		var idnumber = document.getElementById("idnumber").value;
		if(id=="" || id==null){//添加时检证CPA号跟身份证号
			var request = "&type=add&loginid="+loginid+"&idnumber="+idnumber;
			var resText = ajaxLoadPageSynch(url,request);
			if(resText!="PASS"){
				alert(resText);
				return;
			}
		}else{//更新时检证CPA号跟身份证号
			var request = "&type=update&id="+id+"&loginid="+loginid+"&idnumber="+idnumber;
			var resText = ajaxLoadPageSynch(url,request);
			if(resText!="PASS"){
				alert(resText);
				return;
			}
		}
		if(id=="" || id==null){//新增
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/micfoRegister.do?method=addMicfoRegister";
		}else{//更新
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/micfoRegister.do?method=updateMicfoRegister";
		}
		myForm.submit();
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
	
	// 取消
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
		var myForm = document.getElementById("uploadForm");
		myForm.action = "${pageContext.request.contextPath}/common/micfoRegister.do?method=uploadPhoto" ;
		hiddenProDiv();
		
		return true;
	}
	
	// 更新照片
	function changePhoto(photoName) {
		var userphotoname = document.getElementById("userphotoname");
		if(photoName != "") {
			document.getElementById("bill").src = "${pageContext.request.contextPath}/common/attachFile/K_MicfoRegister/"+photoName;
			userphotoname.value = photoName;
		}
	}
	
	// 打印
	function f_print(){
		var id = document.getElementById("id").value;
		if(id=="" || id==null){
			alert("请保存好信息在进行打印!");
		}else{
			window.open("${pageContext.request.contextPath}/common/micfoRegister.do?method=goPrint&id="+id);
		}
	}
	
	//内容不允许输入空格
	$(function(){
		
		$("input[type=text]").keyup(function(){
			var v=$(this).val();
			var v2=v.replace(/[ ]/g,"");
			$(this).val(v2);
		});
	});
	//只能输入数字
	function f_money(t){
		t.value = t.value.replace(/[^\d]/g,'');
	}
	function f_idnumber(){
		var bool = true;
		var loginid = document.getElementById("loginid").value;
		if(loginid.length!=12){
			alert("请输入12位的cpa证书号。");
			bool = false;
		}
		var val = document.getElementById("idnumber").value;
		var bornDate = document.getElementById("bornDate").value;
		var bornDates = bornDate.substring(5,7)+bornDate.substring(8,10);
		if(val.length==18||val.length==15){
			if(val.length==18){
				if(val.substring(10,14)!=bornDates){
					alert("出生日期和身份证上的出生日期不相等。");
					bool = false;
				}
			}
			if(val.length==15){
				if(val.substring(8,12)!=bornDates){
					alert("出生日期和身份证上的出生日期不相等。");
					bool = false;
				}
			}
		}else{
			alert("请输入18或15位的身份证号码！！！");
			bool = false;
		}
		return bool;
	}
	
</script>
</html>