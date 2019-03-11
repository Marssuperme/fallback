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
	
	<form id="myForm" name="myForm" method="post" >
		<input type="hidden" id="id" name="id" value="${mr.id}">
		<input type="hidden" id="p" name="p" value="${p}">
		<input type="hidden" id="pd" name="pd" value="${pd}">
		<input type="hidden" id="userphotoname" name="userphotoname" value="">
		<input type="hidden" id="photo" name="photo" value="${mr.photo}">
		<br><br>
			
		<c:choose>
			<c:when test="${p=='m'}">
				<table align="center" id="table" cellpadding="3px;">
					<tr>
						<td colspan="4" class="color">
						<span style="margin-left: 35%"><font style="font-size: 20">&nbsp;评&nbsp;估&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息&nbsp;</font></span>
						<span id="print" style="margin-left: 15%;"><input icon="icon-print" type="button" value="打  印" style="border: 0px" onclick="f_print()"></span>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">个人信息</font>
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right" ><font style="font-size: 14">姓名：</font></td>
						<td width="30%"><input class="input" id="loginName" name="loginName" value="${mr.loginName}"></td>
						<td rowspan="8" colspan="2">
							<center>
								<c:choose>
									<c:when test="${mr.id=='' || mr.id==null}">
										<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_Assesser/100000281703"><br>
									</c:when>
									<c:otherwise>
										<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_AssesserRegister/${mr.photo}"><br>
									</c:otherwise>
								</c:choose>
								
								<input type="text" id="myText" size="1" style="display:none"> <br>
								<span id="logospan">
									<a id="no1" href="#" onclick="upLoadFile();">点击上传企业LOGO</a><br>
								</span>
							</center>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">出生日期：</font></td>
						<td width="30%"><input style="width:63%" id="bornDate" name="bornDate" value="${mr.bornDate}" showcalendar="true" class="date"></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">民族：</font></td>
						<td width="30%">
								<select id="nation" name="nation" style="width: 75%;"  >
									<option value="01|汉族" >01|汉族</option>
									<option value="02|蒙古族" >02|蒙古族</option>
									<option value="03|回族"  >03|回族</option>
									<option value="04|藏族"  >04|藏族</option>
									<option value="05|维吾尔族"  >05|维吾尔族</option>
									<option value="06|苗族"  >06|苗族</option>
									<option value="07|彝族"  >07|彝族</option>
									<option value="08|壮族"  >08|壮族</option>
									<option value="09|布依族"  >09|布依族</option>
									<option value="10|朝鲜族"  >10|朝鲜族</option>
									<option value="11|满族"  >11|满族</option>
									<option value="12|侗族"  >12|侗族</option>
									<option value="13|瑶族"  >13|瑶族</option>
									<option value="14|白族"  >14|白族</option>
									<option value="15|土家族"  >15|土家族</option>　
									<option value="16|哈尼族"  >16|哈尼族</option>
									<option value="17|哈萨克族"  >17|哈萨克族</option>
									<option value="18|傣族"  >18|傣族</option>
									<option value="19|黎族"  >19|黎族</option>
									<option value="20|傈僳族"  >20|傈僳族</option>
									<option value="21|佤族"  >21|佤族</option>
									<option value="22|畲族"  >22|畲族</option>
									<option value="23|高山族"  >23|高山族</option>
									<option value="24|拉祜族"  >24|拉祜族</option>
									<option value="25|水族"  >25|水族</option>
									<option value="26|东乡族"  >26|东乡族</option>
									<option value="27|纳西族"  >27|纳西族</option>
									<option value="28|景颇族"  >28|景颇族</option>
									<option value="29|柯尔克孜族"  >29|柯尔克孜族</option>
									<option value="30|土族"  >30|土族</option>
									<option value="31|达斡尔族"  >31|达斡尔族</option>
									<option value="32|仫佬族"  >32|仫佬族</option>
									<option value="33|羌族"  >33|羌族</option>
									<option value="34|布朗族"  >34|布朗族</option>
									<option value="35|撒拉族"  >35|撒拉族</option>
									<option value="36|毛难族"  >36|毛难族</option>
									<option value="37|仡佬族"  >37|仡佬族</option>
									<option value="38|锡伯族"  >38|锡伯族</option>
									<option value="39|阿昌族"  >39|阿昌族</option>
									<option value="40|普米族"  >40|普米族</option>
									<option value="41|塔吉克族"  >41|塔吉克族</option>
									<option value="42|怒族"  >42|怒族</option>
									<option value="43|乌孜别克族"  >43|乌孜别克族</option>
									<option value="44|俄罗斯族"  >44|俄罗斯族</option>
									<option value="45|鄂温克族"  >45|鄂温克族</option>
									<option value="46|崩龙族"  >46|崩龙族</option>
									<option value="47|保安族"  >47|保安族</option>
									<option value="48|裕固族"  >48|裕固族</option>
									<option value="49|京族"  >49|京族</option>
									<option value="50|塔塔尔族"  >50|塔塔尔族</option>
									<option value="51|独龙族"  >51|独龙族</option>
									<option value="52|鄂伦春族"  >52|鄂伦春族</option>
									<option value="53|赫哲族"  >53|赫哲族</option>
									<option value="54|门巴族"  >54|门巴族</option>
									<option value="55|珞巴族"  >55|珞巴族</option>
									<option value="56|基诺族"  >56|基诺族</option>
									<option value="97|其他"  >97|其他</option>
									<option value="98|外国血统中国籍人士"  >98|外国血统中国籍人士</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">联系电话：</font></td>
						<td width="30%"><input class="input phone" id="phone" name="phone" value="${mr.phone}"></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">性别：</font></td>
						<td width="30%%"><input style="width: 75%" class="input" id="sex" name="sex" value="${mr.sex}"
													autoWidth="20%"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=2  >
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">国籍：</font></td>
						<td width="30%"><input class="input" id="country" name="country" value="${mr.country}" autoWidth="20%"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=55 refer="city"></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">身份证号：</font></td>
						<td width="30%"><input style="width: 75%" id="idnumber" name="idnumber" value="${mr.idnumber}" >
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">专业职称：</font></td>
						<td width="30%"><input class="input" id="rank" name="rank" value="${mr.rank}"
												autoWidth="20%"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=45>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">职称等级：</font></td>
						<td width="30%" >
							<input class="input" id="professional" name="professional" value="${mr.professional}"
									autoWidth="20%"
									onfocus="onPopDivClick(this);" 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=41>
						</td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">是否离退休：</font></td>
						<td width="30%"> 
							<select id="retirees" name="retirees" style="width: 75%;"  >
								<option value="01|在职" <c:if test="${mr.retirees=='01|在职' }">selected</c:if> >01|在职</option>
								<option value="02|退休" <c:if test="${mr.retirees=='02|退休' }">selected</c:if> >02|退休</option>
								<option value="03|离休" <c:if test="${mr.retirees=='03|离休' }">selected</c:if> >03|离休</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">专业：</font></td>
						<td width="30%"><input class="input" id="specialty" name="specialty" value="${mr.specialty}"></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">学历：</font></td>
						<td width="30%"> 
							<select id="diploma" name="diploma" style="width: 75%;"  >
								<option value="01|博士" <c:if test="${mr.diploma=='01|博士' }">selected</c:if> >01|博士</option>
								<option value="02|在读博士" <c:if test="${mr.diploma=='01|博士' }">selected</c:if> >02|在读博士</option>
								<option value="03|硕士" <c:if test="${mr.diploma=='03|硕士' }">selected</c:if> >003|硕士</option>
								<option value="04|在读硕士" <c:if test="${mr.diploma=='04|在读硕士' }">selected</c:if> >04|在读硕士</option>
								<option value="05|本科" <c:if test="${mr.diploma=='05|本科' }">selected</c:if> >05|本科</option>
								<option value="06|大专" <c:if test="${mr.diploma=='06|大专' }">selected</c:if> >06|大专</option>
								<option value="07|中专" <c:if test="${mr.diploma=='07|中专' }">selected</c:if> >07|中专</option>
								<option value="90|其他" <c:if test="${mr.diploma=='90|其他' }">selected</c:if> >90|其他</option>
							</select>
						</td>
					</tr>
					
					
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所前所在单位：</font></td>
						<td width="30%"><input class="input" id="intobefore" name="intobefore" value="${mr.intobefore}"></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">档案存放单位：</font></td>
						<td width="30%"><input class="input" id="filestorage" name="filestorage" value="${mr.filestorage}"></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所时间：</font></td>
						<td width="30%"><input style="width: 63%" id="intotime" name="intotime" value="${mr.intotime}" showcalendar="true"></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">从事审计业务时间(月)：</font></td>
						<td width="30%"><input class="input" id="auditTime" name="auditTime" value="${mr.auditTime}"></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">是否在事务所专职执业：</font></td>
						<td width="30%"><input class="input" id="iscomanySpecialty" name="iscomanySpecialty" value="${mr.iscomanySpecialty}"></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">资格取得方式：</font></td>
						<td width="30%"><input class="input" id="seniorityType" name="seniorityType" value="${mr.seniorityType}"autoWidth="20%"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="zgType">
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">合格证号或考核（认定）批准文号：</font></td>
						<td width="80%" colspan="3"><input style="width: 94%" id="certificate" name="certificate" value="${mr.certificate}">
						</td>
					</tr>
					
					
					<tr>
						<td class="color" width="20%" align="right" rowspan="5"><font style="font-size: 14">本人从事审计业务工作简历：</font></td>
						<td width="30%" align="center">起止年月</td>
						<td width="20%" align="center">所在单位名称</td>
						<td width="30%" align="center">证明人</td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime1" name="startTime1" value="${mr.startTime1}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime1" name="endTime1" value="${mr.endTime1}" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany1" name="stayCompany1" value="${mr.stayCompany1}" style="width: 95%"></td>
						<td width="20%"><input id="certifier1" name="certifier1" value="${mr.certifier1}" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime2" name="startTime2" value="${mr.startTime2}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime2" name="endTime2" value="${mr.endTime2}" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany2" name="stayCompany2" value="${mr.stayCompany2}" style="width: 95%"></td>
						<td width="20%"><input id="certifier2" name="certifier2" value="${mr.certifier2}" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime3" name="startTime3" value="${mr.startTime3}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime3" name="endTime3" value="${mr.endTime3}" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany3" name="stayCompany3" value="${mr.stayCompany3}" style="width: 95%"></td>
						<td width="20%"><input id="certifier3" name="certifier3" value="${mr.certifier3}" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime4" name="startTime4" value="${mr.startTime4}" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime4" name="endTime4" value="${mr.endTime4}" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany4" name="stayCompany4" value="${mr.stayCompany4}" style="width: 95%"></td>
						<td width="20%"><input id="certifier4" name="certifier4" value="${mr.certifier4}" style="width: 95%"></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">何时因何原因受到何种处罚或者处分：</font></td>
						<td width="80%" colspan="3">
							<textarea rows="5" style="width: 99%" id="timeAndreason" name="timeAndreason" >${mr.timeAndreason}</textarea> 
						</td>
					</tr>
				</table>
			</c:when>
			
			<c:otherwise>
				<table align="center" id="table" cellpadding="3px;">
					<tr>
						<td colspan="4" class="color">
						<center> <font style="font-size: 20">&nbsp;评&nbsp;估&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息1&nbsp;</font></center>
						</td>
					</tr>	
					<tr>
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">个人信息</font>
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right" ><font style="font-size: 14">姓名：</font></td>
						<td width="30%"><input class="input" id="loginName" name="loginName" value="${mr.loginName}"></td>
						<td rowspan="8" colspan="2">
							<center>
								<c:choose>
									<c:when test="${mr.id=='' || mr.id==null}">
										<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_Assesser/100000281703"><br>
									</c:when>
									<c:otherwise>
										<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_AssesserRegister/${mr.photo}"><br>
									</c:otherwise>
								</c:choose>
								
								<input type="text" id="myText" size="1" style="display:none"> <br>
								<span id="logospan">
									<a id="no1" href="#" onclick="upLoadFile();">点击上传企业LOGO</a><br>
								</span>
							</center>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">出生日期：</font></td>
						<td width="30%"><input style="width:63%" id="bornDate" name="bornDate" value="" showcalendar="true" class="date"></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">民族：</font></td>
						<td width="30%"> 
								<select id="nation" name="nation" style="width: 75%;"  >
									<option value="01|汉族" >01|汉族</option>
									<option value="02|蒙古族" >02|蒙古族</option>
									<option value="03|回族"  >03|回族</option>
									<option value="04|藏族"  >04|藏族</option>
									<option value="05|维吾尔族"  >05|维吾尔族</option>
									<option value="06|苗族"  >06|苗族</option>
									<option value="07|彝族"  >07|彝族</option>
									<option value="08|壮族"  >08|壮族</option>
									<option value="09|布依族"  >09|布依族</option>
									<option value="10|朝鲜族"  >10|朝鲜族</option>
									<option value="11|满族"  >11|满族</option>
									<option value="12|侗族"  >12|侗族</option>
									<option value="13|瑶族"  >13|瑶族</option>
									<option value="14|白族"  >14|白族</option>
									<option value="15|土家族"  >15|土家族</option>　
									<option value="16|哈尼族"  >16|哈尼族</option>
									<option value="17|哈萨克族"  >17|哈萨克族</option>
									<option value="18|傣族"  >18|傣族</option>
									<option value="19|黎族"  >19|黎族</option>
									<option value="20|傈僳族"  >20|傈僳族</option>
									<option value="21|佤族"  >21|佤族</option>
									<option value="22|畲族"  >22|畲族</option>
									<option value="23|高山族"  >23|高山族</option>
									<option value="24|拉祜族"  >24|拉祜族</option>
									<option value="25|水族"  >25|水族</option>
									<option value="26|东乡族"  >26|东乡族</option>
									<option value="27|纳西族"  >27|纳西族</option>
									<option value="28|景颇族"  >28|景颇族</option>
									<option value="29|柯尔克孜族"  >29|柯尔克孜族</option>
									<option value="30|土族"  >30|土族</option>
									<option value="31|达斡尔族"  >31|达斡尔族</option>
									<option value="32|仫佬族"  >32|仫佬族</option>
									<option value="33|羌族"  >33|羌族</option>
									<option value="34|布朗族"  >34|布朗族</option>
									<option value="35|撒拉族"  >35|撒拉族</option>
									<option value="36|毛难族"  >36|毛难族</option>
									<option value="37|仡佬族"  >37|仡佬族</option>
									<option value="38|锡伯族"  >38|锡伯族</option>
									<option value="39|阿昌族"  >39|阿昌族</option>
									<option value="40|普米族"  >40|普米族</option>
									<option value="41|塔吉克族"  >41|塔吉克族</option>
									<option value="42|怒族"  >42|怒族</option>
									<option value="43|乌孜别克族"  >43|乌孜别克族</option>
									<option value="44|俄罗斯族"  >44|俄罗斯族</option>
									<option value="45|鄂温克族"  >45|鄂温克族</option>
									<option value="46|崩龙族"  >46|崩龙族</option>
									<option value="47|保安族"  >47|保安族</option>
									<option value="48|裕固族"  >48|裕固族</option>
									<option value="49|京族"  >49|京族</option>
									<option value="50|塔塔尔族"  >50|塔塔尔族</option>
									<option value="51|独龙族"  >51|独龙族</option>
									<option value="52|鄂伦春族"  >52|鄂伦春族</option>
									<option value="53|赫哲族"  >53|赫哲族</option>
									<option value="54|门巴族"  >54|门巴族</option>
									<option value="55|珞巴族"  >55|珞巴族</option>
									<option value="56|基诺族"  >56|基诺族</option>
									<option value="97|其他"  >97|其他</option>
									<option value="98|外国血统中国籍人士"  >98|外国血统中国籍人士</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">联系电话：</font></td>
						<td width="30%"><input class="input phone" id="phone" name="phone" value="${mr.phone}"></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">性别：</font></td>
						<td width="30%%"><input style="width: 75%" class="input" id="sex" name="sex" value="${mr.sex}"
													autoWidth="20%"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=2  >
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">国籍：</font></td>
						<td width="30%"><input class="input" id="country" name="country" value="" autoWidth="20%"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=55 refer="city" ></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">身份证号：</font></td>
						<td width="30%"><input style="width: 75%" id="idnumber" name="idnumber" value="${mr.idnumber}" >
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">专业职称：</font></td>
						<td width="30%"><input class="input" id="rank" name="rank" value="${mr.title}"
												autoWidth="20%"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=45>
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">职称等级：</font></td>
						<td width="30%" >
							<input class="input" id="professional" name="professional" value=""
									autoWidth="20%"
									onfocus="onPopDivClick(this);" 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=41>
						</td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">是否离退休：</font></td>
						<td width="30%">
							<select id="retirees" name="retirees" style="width: 75%;"  >
								<option value="01|在职" >01|在职</option>
								<option value="02|退休" >02|退休</option>
								<option value="03|离休" >03|离休</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">专业：</font></td>
						<td width="30%"><input class="input" id="specialty" name="specialty" value=""></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">学历：</font></td>
						<td width="30%"> 
							<select id="diploma" name="diploma" style="width: 75%;"  >
								<option value="01|博士" <c:if test="${mr.specialty2=='01|博士' }">selected</c:if> >01|博士</option>
								<option value="02|在读博士" <c:if test="${mr.specialty2=='01|博士' }">selected</c:if> >02|在读博士</option>
								<option value="03|硕士" <c:if test="${mr.specialty2=='03|硕士' }">selected</c:if> >003|硕士</option>
								<option value="04|在读硕士" <c:if test="${mr.specialty2=='04|在读硕士' }">selected</c:if> >04|在读硕士</option>
								<option value="05|本科" <c:if test="${mr.specialty2=='05|本科' }">selected</c:if> >05|本科</option>
								<option value="06|大专" <c:if test="${mr.specialty2=='06|大专' }">selected</c:if> >06|大专</option>
								<option value="07|中专" <c:if test="${mr.specialty2=='07|中专' }">selected</c:if> >07|中专</option>
								<option value="90|其他" <c:if test="${mr.specialty2=='90|其他' }">selected</c:if> >90|其他</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所前所在单位：</font></td>
						<td width="30%"><input class="input" id="intobefore" name="intobefore" value=""></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">档案存放单位：</font></td>
						<td width="30%"><input class="input" id="fileStayCompany" name="fileStayCompany" value=""></td>
					</tr>
					
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">进事务所时间：</font></td>
						<td width="30%"><input style="width: 63%" id="intotime" name="intotime" value="" showcalendar="true"></td>
						<td class="color" width="20%" align="right"><font style="font-size: 14">从事审计业务时间(月)：</font></td>
						<td width="30%"><input class="input" id="auditTime" name="auditTime" value=""></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">是否在事务所专职执业：</font></td>
						<td width="30%"><input class="input" id="iscomanySpecialty" name="iscomanySpecialty" value=""></td>
						<td class="color" width="20%" align="right" ><font style="font-size: 14">资格取得方式：</font></td>
						<td width="30%"><input class="input" id="seniorityType" name="seniorityType" value="" autoWidth="20%"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="zgType">
						</td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">合格证号或考核（认定）批准文号：</font></td>
						<td width="80%" colspan="3">
							<input style="width: 94%" id="certificate" name="certificate" value="">
						</td>
					</tr>
					
					
					<tr>
						<td class="color" width="20%" align="right" rowspan="5"><font style="font-size: 14">本人从事审计业务工作简历：</font></td>
						<td class="color" width="30%" align="center">起止年月</td>
						<td class="color" width="20%" align="center">所在单位名称</td>
						<td class="color" width="30%" align="center">证明人</td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime1" name="startTime1" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime1" name="endTime1" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany1" name="stayCompany1" style="width: 95%"></td>
						<td width="20%"><input id="certifier1" name="certifier1" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime2" name="startTime2" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime2" name="endTime2" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany2" name="stayCompany2" style="width: 95%"></td>
						<td width="20%"><input id="certifier2" name="certifier2" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime3" name="startTime3" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime3" name="endTime3" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany3" name="stayCompany3" style="width: 95%"></td>
						<td width="20%"><input id="certifier3" name="certifier3" style="width: 95%"></td>
					</tr>
					<tr>
						<td width="30%"><input id="startTime4" name="startTime4" style="width: 30%" showcalendar="true">&nbsp;至&nbsp;<input id="endTime4" name="endTime4" style="width: 30%" showcalendar="true"></td>
						<td width="30%"><input id="stayCompany4" name="stayCompany4" style="width: 95%"></td>
						<td width="20%"><input id="certifier4" name="certifier4" style="width: 95%"></td>
					</tr>
					<tr>
						<td class="color" width="20%" align="right"><font style="font-size: 14">何时因何原因受到何种处罚或者处分：</font></td>
						<td width="80%" colspan="3">
							<textarea rows="5" style="width: 99%" id="timeAndreason" name="timeAndreason" ></textarea> 
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		<div style="margin-top:2%;" align="center" > 
			  <input type="submit" icon="icon-save" value="保  存" onclick="f_save()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
	var nvalue = "${mr.nation}";
	var nation = document.getElementById("nation");
	for(var i=0;i<nation.length;i++){
		if(nation[i].value==nvalue){
			nation[i].selected = true;
			break;
		}
	}
	
	// 确定  
	function f_save(){
		var id = document.getElementById("id").value;
		if(id=="" || id==null){
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=addAssesserRegister";
		}else{
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=updateAssesserRegister";
		}
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
		myForm.action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=uploadPhoto" ;
		hiddenProDiv();
		
		return true;
	}
	
	// 更新照片
	function changePhoto(photoName) {
		var userphotoname = document.getElementById("userphotoname");
		if(photoName != "") {
			document.getElementById("bill").src = "${pageContext.request.contextPath}/common/attachFile/K_AssesserRegister/"+photoName;
			userphotoname.value = photoName;
		}
	}
	
	// 打印
	function f_print(){
		var id = document.getElementById("id").value;
		if(id=="" || id==null){
			alert("请保存好信息在进行打印!");
		}else{
			window.open("${pageContext.request.contextPath}/common/assesserRegister.do?method=goPrint&id="+id);
		}
	}
</script>
</html>