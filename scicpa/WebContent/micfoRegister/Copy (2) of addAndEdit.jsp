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
		width: 30%;
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
		width:90%;
		border-collapse:collapse;
	}
	 
	#table td{ 
		border:solid 1px #B4CDCD; 
		height:22px; 
	} 
	.input{
		width: 75%;  
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
					<span style="margin-left: 35%"><font style="font-size: 20">&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息&nbsp;</font></span>
		<table align="center" id="table" cellpadding="3px;" class="data_tb">
			<tr>
				<td colspan="4" class="color"><font>个人信息</font></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right" >姓名<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input style="width: 75%" id="loginName" name="loginName" value="${mr.loginName}" class="required"></td>
				<td rowspan="5" colspan="2">
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
				<td class="color" width="20%" align="right">性别<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input style="width: 75%"  id="sex" name="sex" value="${mr.sex}"
						noinput=true
						autoWidth="20%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=2  >
				</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right" >民族</td>
				<td width="30%">
					<input name="nation" style="width: 75%" 
						noinput=true
						type="text" 
						id="nation" 
						size="33" 
						maxlength="10"
						value="${mr.nation }" 
						autoWidth=220
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="mingzu" >	
				</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">出生日期<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input style="width:63%" id="bornDate" name="bornDate" value="${mr.bornDate}" showcalendar="true" class="date"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">身份证号<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input style="width: 75%" id="idnumber" name="idnumber" value="${mr.idnumber}" class="required">
				</td>
			</tr>
			<tr>
				<td colspan="4" class="color"><font>受教育信息</font></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">毕业学校</td>
				<td width="30%"><input  name="" type="text" id="" value="" style="width: 75%"></td>
				<td class="color" width="20%" align="right">专业</td>
				<td width="30%"><input  id="specialty" name="specialty" value="${mr.specialty}" style="width: 75%"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">学位</td>
				<td width="30%"><input  id="" name="" value="" style="width: 75%"></td>
				<td class="color" width="20%" align="right">学历</td>
				<td width="30%"> 
					<input name="diploma" type="text" id="diploma"  size="19" maxlength="50" value="${mr.diploma }" 
						style="width: 75%"
						noinput=true
						autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="xueli" >
				</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">外语程度</td>
				<td width="30%"><input name="languagelevel" type="text" id="languagelevel"  size="25" maxlength="20" value="" style="width: 75%"></td>
				<td class="color" width="20%" align="right">政治面貌及其它</td>
				<td width="30%"><input name="politics" type="text" id="politics"  size="25" maxlength="20" value="" style="width: 75%"></td>
			</tr>
			<tr>
				<td colspan="4" class="color"><font>执业信息</font></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right" >事务所全称</td>
				<td width="30%" colspan="3">${userSession.userMap.loginname}</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right" >事务所代码</td>
				<td width="30%">${userSession.userMap.loginid}</td>
				<td class="color" width="20%" align="right">职务</td>
				<td width="30%"><input name="" type="text" id="" size="25" maxlength="20" value="" style="width: 75%"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">进所时间</td>
				<td width="30%"><input style="width: 63%" id="intotime" name="intotime" value="${mr.intotime}" showcalendar="true"></td>
				<td class="color" width="20%" align="right">是否股东或合伙人<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%">
					<input onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=20
						hideresult=true 
						title="是否股东或合伙人" 
						style="width: 75%" id="isshareholder" name="isshareholder" value="" class="required">
				</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">进所前所在单位</td>
				<td width="30%"><input  id="intobefore" name="intobefore" value="${mr.intobefore}" style="width: 75%"></td>
				<td class="color" width="20%" align="right">离退休标志</td>
				<td width="30%"> 
					<input name="retirees" type="text" id="retirees" size="19" maxlength="10" style="width: 75%"
						noinput=true
						value="${mr.retirees }" autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="workState" >	
				</td>
			</tr>
			<tr>
				<td colspan="4" class="color"><font>资格取得信息</font></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right" >CPA号<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input  id="loginid" name="loginid" value="${mr.loginid}" style="width: 75%"></td>
				<td class="color" width="20%" align="right">注师批准文号</td>
				<td width="30%"><input name="" type="text" id="" size="19" maxlength="10" style="width: 75%"></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td class="color" width="20%" align="right">职称等级</td>
				<td width="30%" >
					<input  id="professional" name="professional" value="${mr.professional}" style="width: 75%"
						noinput=true
						autoWidth="20%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=41>
				</td>
				<td class="color" width="20%" align="right">专业职称</td>
				<td width="30%">
					<input  id="rank" name="rank" value="${mr.rank}" style="width: 75%"
						noinput=true
						autoWidth="20%"
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=45>
				</td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">申请时间<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input  id="" name="" value="" style="width: 75%"></td>
				<td class="color" width="20%" align="right">批准时间<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input  id="" name="" value="" style="width: 75%"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">档案存放单位<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input  id="filestorage" name="filestorage" value="${mr.filestorage}" style="width: 75%"></td>
				<td class="color" width="20%" align="right">档案存放单位<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input  id="filestorage" name="filestorage" value="${mr.filestorage}" style="width: 75%"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">合格证号或考核（认定）批准文号<font color="#FF0000">&nbsp;[*]</font></td>
				<td width="30%"><input id="certificate" name="certificate" value="${mr.certificate}" style="width: 75%">
				<td class="color" width="20%" align="right">资格取得方式</td>
				<td width="30%">
					<input  id="seniorityType" name="seniorityType" value="${mr.seniorityType}"autoWidth="20%" style="width: 75%"
						noinput=true
						onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="zgType">
				</td>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="color"><font>联系方式</font></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">邮编</td>
				<td class="data_tb_content" height="18"><input style="width: 75%" name="postcode" type="text" id="postcode" maxlength="10" size="25"  value="" myClass="number"></td>
				<td class="color" width="20%" align="right">电子邮箱</td>
				<td class="data_tb_content" height="18"><input style="width: 75%" name="email" type="text" id="email"  size="25" maxlength="50" value="" myClass="email"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">电话</td>
				<td class="data_tb_content" height="14"><input style="width: 75%" name="phone" type="text" id="phone"  size="25" maxlength="20" value="" myClass="phone"></td>
				<td class="color" width="20%" align="right">手机</td>
				<td class="data_tb_content" height="14"><input style="width: 75%" name="mobile" type="text" id="mobile"  size="25" maxlength="20" value="" myClass="number"></td>
			</tr>
			<tr>
				<td class="color" width="20%" align="right">通信地址</td>
				<td class="data_tb_content" colSpan="3" height="18"><input name="address" type="text" id="address" maxlength="220" size="100"  value=""></td>
			</tr>
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
	var nvalue="${mr.nation}";
	var nation=document.getElementById("nation");
	for(var i=0;i<nation.length;i++){
		if(nation[i].value==nvalue){
			nation[i].selected=true;
			break;
		}
	}
	
	// 确定  
	function f_save(){
		var id=document.getElementById("id").value;
		var url="${pageContext.request.contextPath}/common/micfoRegister.do?method=check";
		var loginid=document.getElementById("loginid").value;
		var idnumber=document.getElementById("idnumber").value;
		if(id=="" || id==null){//添加时检证CPA号跟身份证号
			var request="&type=add&loginid="+loginid+"&idnumber="+idnumber;
			var resText=ajaxLoadPageSynch(url,request);
			if(resText!="PASS"){
				alert(resText);
				return;
			}
		}else{//更新时检证CPA号跟身份证号
			var request="&type=update&id="+id+"&loginid="+loginid+"&idnumber="+idnumber;
			var resText=ajaxLoadPageSynch(url,request);
			if(resText!="PASS"){
				alert(resText);
				return;
			}
		}
		if(id=="" || id==null){//新增
			document.getElementById("myForm").action="${pageContext.request.contextPath}/common/micfoRegister.do?method=addMicfoRegister";
			document.getElementById("myForm").submit();
		}else{//更新
			document.getElementById("myForm").action="${pageContext.request.contextPath}/common/micfoRegister.do?method=updateMicfoRegister";
			document.getElementById("myForm").submit();
		}
	}
	
	//上传相片
	function upLoadFile() {
		var divObj=document.getElementById("divProduce");
		var blockObj= document.getElementById("divBlock");
		var attachments= document.getElementById("attachments");
		divObj.style.display="";
		blockObj.style.display="";
		attachments.value="";
	}
	
	// 取消
	function hiddenProDiv() {
		var divObj=document.getElementById("divProduce");
		var blockObj= document.getElementById("divBlock");
		divObj.style.display="none";
		blockObj.style.display="none";
	}
	
	//保存相片
	function upLoadSumbit() {
		var attachments=document.getElementById("attachments");
		document.getElementById("uploadFileName").value=attachments.value ;
		var myForm=document.getElementById("uploadForm");
		myForm.action="${pageContext.request.contextPath}/common/micfoRegister.do?method=uploadPhoto" ;
		hiddenProDiv();
		
		return true;
	}
	
	// 更新照片
	function changePhoto(photoName) {
		var userphotoname=document.getElementById("userphotoname");
		if(photoName != "") {
			document.getElementById("bill").src="${pageContext.request.contextPath}/common/attachFile/K_MicfoRegister/"+photoName;
			userphotoname.value=photoName;
		}
	}
	
	// 打印
	function f_print(){
		var id=document.getElementById("id").value;
		if(id=="" || id==null){
			alert("请保存好信息在进行打印!");
		}else{
			window.open("${pageContext.request.contextPath}/common/micfoRegister.do?method=goPrint&id="+id);
		}
	}
</script>
</html>