<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>评估师注册信息</title>
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
		width:80%;
		border-collapse:collapse;
	}
	 
	#table td{ 
		border:solid 1px; 
		height:22px; 
	} 
	.input{
		width: 75%;  
	} 
	 
</style>
</head>
<body>

	<form id="myForm" name="myForm" method="post" >
	<input type="hidden" id="id" name="id" value="${mr.id }">
	<input type="hidden" id="p" name="p" value="${p}">
		<br> <br>
			<table align="center" id="table" cellpadding="3px;">
				<tr>
					<td colspan="4" class="color">
					<center> <font style="font-size: 20">&nbsp;评&nbsp;估&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息&nbsp;</font></center>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="color">
						<font style="margin-left: 2%;font-size: 15">个人信息</font>
					</td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right" ><font style="font-size: 14">姓名：</font></td>
					<td width="30%"><input class="input" id="loginName" name="loginName" value="${mr.loginName}" readonly="readonly"></td>
					<td rowspan="8" colspan="2">
						<center>
							<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_AssesserRegister/${mr.photo}"><br>
						</center>
					</td>
				</tr>
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">出生日期：</font></td>
					<td width="30%"><input style="width:75%" id="bornDate" name="bornDate" value="${mr.bornDate}" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">民族：</font></td>
					<td width="30%"><input style="width: 75%" id="nation" name="nation" value="${mr.nation}" readonly="readonly">
					</td>
				</tr>
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">联系电话：</font></td>
					<td width="30%"><input class="input phone" id="phone" name="phone" value="${mr.phone}" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">性别：</font></td>
					<td width="30%%"><input style="width: 75%" class="input" id="sex" name="sex" value="${mr.sex}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">国籍：</font></td>
					<td width="30%"><input class="input" id="country" name="country" value="${mr.country}" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">身份证号：</font></td>
					<td width="30%"><input style="width: 75%" id="idnumber" name="idnumber" value="${mr.idnumber}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">专业职称：</font></td>
					<td width="30%"><input class="input" id="rank" name="rank" value="${mr.rank}" readonly="readonly">
					</td>
				</tr>
					
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">职称等级：</font></td>
					<td width="30%" >
						<input class="input" id="professional" name="professional" value="${mr.professional}" readonly="readonly">
					</td>
					<td class="color" width="20%" align="right"><font style="font-size: 14">是否离退休：</font></td>
					<td width="30%"><input style="width: 75%" id="retirees" name="retirees" value="${mr.retirees}"  readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">专业：</font></td>
					<td width="30%"><input class="input" id="specialty" name="specialty" value="${mr.specialty}" readonly="readonly"></td>
					<td class="color" width="20%" align="right"><font style="font-size: 14">学历：</font></td>
					<td width="30%"><input style="width: 75%" id="diploma" name="diploma" value="${mr.diploma}" readonly="readonly">
					</td>
				</tr>
				
				
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所前所在单位：</font></td>
					<td width="30%"><input class="input" id="intobefore" name="intobefore" value="${mr.intobefore}" readonly="readonly"></td>
					<td class="color" width="20%" align="right"><font style="font-size: 14">档案存放单位：</font></td>
					<td width="30%"><input class="input" id="filestorage" name="filestorage" value="${mr.filestorage}" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所时间：</font></td>
					<td width="30%"><input style="width: 75%" id="intotime" name="intotime" value="${mr.intotime}" readonly="readonly"></td>
					<td class="color" width="20%" align="right"><font style="font-size: 14">从事审计业务时间(月)：</font></td>
					<td width="30%"><input class="input" id="auditTime" name="auditTime" value="${mr.auditTime}" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">是否在事务所专职执业：</font></td>
					<td width="30%"><input class="input" id="iscomanySpecialty" name="iscomanySpecialty" value="${mr.iscomanySpecialty}" readonly="readonly"></td>
					<td class="color" width="20%" align="right"><font style="font-size: 14">资格取得方式：</font></td>
					<td width="30%"><input class="input" id="seniorityType" name="seniorityType" value="${mr.seniorityType}" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">合格证号或考核（认定）批准文号：</font></td>
					<td width="80%" colspan="3"><input style="width: 94%" id="certificate" name="certificate" value="${mr.certificate}" readonly="readonly">
					</td>
				</tr>
				
				
				<tr>
					<td class="color" width="20%" align="right" rowspan="5"><font style="font-size: 14">本人从事审计业务工作简历：</font></td>
					<td width="30%" align="center">起止年月</td>
					<td width="20%" align="center">所在单位名称</td>
					<td width="30%" align="center">证明人</td>
				</tr>
				<tr>
					<td width="30%"><input id="startTime1" name="startTime1" value="${mr.startTime1}" style="width: 40%" readonly="readonly">&nbsp;至&nbsp;<input id="endTime1" name="endTime1" value="${mr.endTime1}" style="width: 40%" ></td>
					<td width="30%"><input id="stayCompany1" name="stayCompany1" value="${mr.stayCompany1}" style="width: 95%"></td>
					<td width="20%"><input id="certifier1" name="certifier1" value="${mr.certifier1}" style="width: 95%" readonly="readonly"></td>
				</tr>
				<tr>
					<td width="30%"><input id="startTime2" name="startTime2" value="${mr.startTime2}" style="width: 40%" >&nbsp;至&nbsp;<input id="endTime2" name="endTime2" value="${mr.endTime2}" style="width: 40%"></td>
					<td width="30%"><input id="stayCompany2" name="stayCompany2" value="${mr.stayCompany2}" style="width: 95%" readonly="readonly"></td>
					<td width="20%"><input id="certifier2" name="certifier2" value="${mr.certifier2}" style="width: 95%" readonly="readonly"></td>
				</tr>
				<tr>
					<td width="30%"><input id="startTime3" name="startTime3" value="${mr.startTime3}" style="width: 40%" readonly="readonly">&nbsp;至&nbsp;<input id="endTime3" name="endTime3" value="${mr.endTime3}" style="width: 40%" ></td>
					<td width="30%"><input id="stayCompany3" name="stayCompany3" value="${mr.stayCompany3}" style="width: 95%"></td>
					<td width="20%"><input id="certifier3" name="certifier3" value="${mr.certifier3}" style="width: 95%" readonly="readonly"></td>
				</tr>
				<tr>
					<td width="30%"><input id="startTime4" name="startTime4" value="${mr.startTime4}" style="width: 40%" readonly="readonly">&nbsp;至&nbsp;<input id="endTime4" name="endTime4" value="${mr.endTime4}" style="width: 40%" ></td>
					<td width="30%"><input id="stayCompany4" name="stayCompany4" value="${mr.stayCompany4}" style="width: 95%" readonly="readonly"></td>
					<td width="20%"><input id="certifier4" name="certifier4" value="${mr.certifier4}" style="width: 95%" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="color" width="20%" align="right"><font style="font-size: 14">何时因何原因受到何种处罚或者处分：</font></td>
					<td width="80%" colspan="3">
						<textarea rows="5" style="width: 99%" id="timeAndreason" name="timeAndreason" readonly="readonly">${mr.timeAndreason}</textarea> 
					</td>
				</tr>
			</table>
		<div style="margin-top:2%;" align="center" > 
		  <input type="button" icon="icon-back" value="返  回" onclick="window.history.back()">
		</div>
	</form>
</body>
<script type="text/javascript">
	 //加验证
	  $(document).ready(function(){
	    $("#myForm").validate();
	  });
	  
	// 确定  
	function f_save(){
		var id = document.getElementById("id").value;
		if(id=="" || id==null){
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=addAssesserRegister";
		}else{
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=updateAssesserRegister";
		}
	}
</script>
</html>