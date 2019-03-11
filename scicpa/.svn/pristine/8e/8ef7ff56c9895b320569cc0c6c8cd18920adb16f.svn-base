<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>非执业入会</title>
<style>
	.left{
		width: 30%;
		text-align: left;	
	}
	.right{
		width: 15%;
		text-align: right;
	}
	.right1{
		width: 25%;
		text-align: right;
	}
	.alongHR{
		font-size: 15;
	}
	
	#color{
		background-color: #e4f4fe;
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
	.color{
		background-color: #e4f4fe;
	}
</style>
</head>
<body>

	<form id="myForm" name="myForm" method="post" >
	<input type="hidden" id="id" name="id" value="${ct.id }">
	<input type="hidden" id="p" name="p" value="${p}">
	<input type="hidden" id="save" name="save" value="${save}">
		<br><br>
		<c:choose>
			<c:when test="${p=='m'}">
				<table align="center" id="table" cellpadding="3px;">
					<tr>
						<td colspan="4" class="color">
							<span style="margin-left: 35%"><font style="font-size: 20">非&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;入&nbsp;会&nbsp;信&nbsp;息&nbsp;</font></span>
							<span id="print" style="margin-left: 15%;"><input icon="icon-print" type="button" value="打  印" style="border: 0px" onclick="f_print()"></span>
						</td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">个人信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right" ><font style="font-size: 14">姓名<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="loginName" name="loginName" value="${ct.loginName}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">性别<font color="red">[*]</font>：</td>
						<td width="30%"><input style="width: 75%" class="required input" id="sex" name="sex" value="${ct.sex}" 
													autoWidth="210"
													noinput="true"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=2  >
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用名：</font></td>
						<td width="30%"><input class="input" id="oldName" name="oldName" value="${ct.oldName}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用身份证号码：</font></td>
						<td width="30%"><input class="input" id="oldCredenttialsNum" name="oldCredenttialsNum" value="${ct.oldCredenttialsNum}"></td>
					</tr>
					
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">出生日期<font color="red">[*]</font>：</font></td>
						<td width="30%"><input style="width:63%" id="bornDate" name="bornDate" value="${ct.bornDate}" showcalendar="true" class="required date"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">户口所在地<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="bornAddress" name="bornAddress" value="${ct.bornAddress}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">民族<font color="red">[*]</font>：</font></td>
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
						<td id="color" width="20%" align="right"><font style="font-size: 14">政治面貌<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="politics" name="politics" style="width: 75%;"  >
								<option value="01|中国共产党"  <c:if test="${ct.politics=='01|中国共产党' }">selected</c:if> >01|中国共产党</option>
								<option value="03|群众" <c:if test="${ct.politics=='03|群众' }">selected</c:if> >03|群众</option>
								<option value="04|共青团员" <c:if test="${ct.politics=='04|共青团员' }">selected</c:if> >04|共青团员</option>
								<option value="05|民革会员" <c:if test="${ct.politics=='05|民革会员' }">selected</c:if> >05|民革会员</option>
								<option value="06|民盟盟员" <c:if test="${ct.politics=='06|民盟盟员' }">selected</c:if> >06|民盟盟员</option>
								<option value="07|民建会员" <c:if test="${ct.politics=='07|民建会员' }">selected</c:if> >07|民建会员</option>
								<option value="08|民进会员" <c:if test="${ct.politics=='08|民进会员' }">selected</c:if> >08|民进会员</option>
								<option value="09|农工党党员" <c:if test="${ct.politics=='09|农工党党员' }">selected</c:if> >09|农工党党员</option>
								<option value="10|中国致公党党员" <c:if test="${ct.politics=='10|中国致公党党员' }">selected</c:if>>10|中国致公党党员</option>
								<option value="11|九三学社社员" <c:if test="${ct.politics=='11|九三学社社员' }">selected</c:if>>11|九三学社社员</option>
								<option value="12|台盟盟员" <c:if test="${ct.politics=='12|台盟盟员' }">selected</c:if> >12|台盟盟员</option>
								<option value="13|无党派人士" <c:if test="${ct.politics=='3|无党派人士' }">selected</c:if> >13|无党派人士</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">身份证件类别<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="credentials" name="credentials" value="${ct.credentials}"
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="idCardType">
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">证件号<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="credentialsNum" name="credentialsNum" value="${ct.credentialsNum}" ></td>
					</tr>
					
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">联系方式</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">联系电话<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input phone" id="phone" name="phone" value="${ct.phone}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">手机<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input phone" id="mobile" name="mobile" value="${ct.mobile}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">电子邮件<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input email" id="email" name="email" value="${ct.email}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">邮编<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="postcode" name="postcode" value="${ct.postcode}"></td>
					</tr>
					
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">所在地区<font color="red">[*]</font>：</font></td>
						<td width="30%">
							<input class="required input" id="area" name="area" value="${ct.area}" 
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=40><br>
							<font color="red">(当前所在市注协)</font>
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">全科合格年份<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="passYear" name="passYear" value="${ct.passYear}"></td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">受教育信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">毕业院校<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="educational" name="educational" value="${ct.educational}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">外语程度<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="languagelevel" name="languagelevel" value="${ct.languagelevel}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">学历<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="diploma" name="diploma" style="width: 75%;"  >
								<option value="01|博士" <c:if test="${ct.diploma=='01|博士' }">selected</c:if> >01|博士</option>
								<option value="02|在读博士" <c:if test="${ct.diploma=='02|在读博士' }">selected</c:if> >02|在读博士</option>
								<option value="03|硕士" <c:if test="${ct.diploma=='03|硕士' }">selected</c:if> >003|硕士</option>
								<option value="04|在读硕士" <c:if test="${ct.diploma=='04|在读硕士' }">selected</c:if> >04|在读硕士</option>
								<option value="05|本科" <c:if test="${ct.diploma=='05|本科' }">selected</c:if> >05|本科</option>
								<option value="06|大专" <c:if test="${ct.diploma=='06|大专' }">selected</c:if> >06|大专</option>
								<option value="07|中专" <c:if test="${ct.diploma=='07|中专' }">selected</c:if> >07|中专</option>
								<option value="90|其他" <c:if test="${ct.diploma=='90|其他' }">selected</c:if> >90|其他</option>
							</select>
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">学位<font color="red">[*]</font>：</font></td>
						<td width="30%">  
							<select id="degree" name="degree" style="width: 75%;"  >
								<option value="01|博士" <c:if test="${ct.degree=='01|博士' }">selected</c:if> >01|博士</option>
								<option value="02|硕士" <c:if test="${ct.degree=='02|硕士' }">selected</c:if> >02|硕士</option>
								<option value="03|双学士" <c:if test="${ct.degree=='03|双学士' }">selected</c:if> >03|双学士</option>
								<option value="04|学士" <c:if test="${ct.degree=='04|学士' }">selected</c:if> >04|学士</option>
								<option value="09|其他" <c:if test="${ct.degree=='09|其他' }">selected</c:if> >09|其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">专业<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="specialty" name="specialty" value="${ct.specialty}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">专业技术职称：</font></td>
						<td width="30%"><input class="input" id="rank" name="rank" value="${ct.rank}"
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=45>
						</td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">执业信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">工作单位<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="workunits" name="workunits" value="${ct.workunits}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">单位性质：</font></td>
						<td width="30%"> 
							<select id="ownership" name="ownership" style="width: 75%;"  >
								<option value="01|会计师事务所" <c:if test="${ct.ownership=='01|会计师事务所' }">selected</c:if> >01|会计师事务所</option>
								<option value="02|机关事业" <c:if test="${ct.ownership=='02|机关事业' }">selected</c:if> >02|机关事业</option>
								<option value="03|企业公司" <c:if test="${ct.ownership=='03|企业公司' }">selected</c:if> >03|企业公司</option>
								<option value="04|院校" <c:if test="${ct.ownership=='04|院校' }">selected</c:if> >04|院校</option>
								<option value="05|其他" <c:if test="${ct.ownership=='05|其他' }">selected</c:if> >05|其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">通讯地址<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="address" name="address" value="${ct.address}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">是否离退休<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="istired" name="istired" style="width: 75%;"  >
								<option value="01|在职" <c:if test="${ct.istired=='01|在职' }">selected</c:if> >01|在职</option>
								<option value="02|退休" <c:if test="${ct.istired=='02|退休' }">selected</c:if> >02|退休</option>
								<option value="03|离休" <c:if test="${ct.istired=='03|离休' }">selected</c:if> >03|离休</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">资格取得方式<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="seniorityType" name="seniorityType" value="${ct.seniorityType}"
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="zgType">
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14" >全科合格证号<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="certificate2" name="certificate2" value="${ct.certificate2}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">职称等级<font color="red">[*]</font>：</font></td>
						<td >
							<input style="width: 75%" id="professional" name="professional" value="${ct.professional}"
									autoWidth="210"
									noinput="true"
									class="required"
									onfocus="onPopDivClick(this);" 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="dutyLevel"> 
						</td>
						<td colspan="2"></td>
					</tr>
				</table>
			</c:when>
			
			<c:otherwise>
				<table align="center" id="table" cellpadding="3px;">
					<tr>
						<td colspan="4" class="color">
						<center> <font style="font-size: 20">非&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;入&nbsp;会&nbsp;信&nbsp;息&nbsp;</font></center>
						</td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">个人信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right" ><font style="font-size: 14">姓名<font color="red">[*]</font>：</font></td>
						<td width="30%"><input  class="required input" id="loginName" name="loginName" value="${ct.loginName}" ></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">性别<font color="red">[*]</font>：</font></td>
						<td width="30%"><input style="width: 75%" class="required input" id="sex" name="sex" value="${ct.sex}" 
													autoWidth="210"
													noinput="true"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=2  >
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用名：</font></td>
						<td width="30%"><input class="input" id="oldName" name="oldName" value=""></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用身份证号码：</font></td>
						<td width="30%"><input class="input" id="oldCredenttialsNum" name="oldCredenttialsNum" value=""></td>
					</tr>
				
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">出生日期<font color="red">[*]</font>：</font></td>
						<td width="30%"><input style="width: 63%" id="bornDate" name="bornDate" value="" showcalendar="true" class="required date"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">户口所在地<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="bornAddress" name="bornAddress" value=""></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">民族<font color="red">[*]</font>：</font></td>
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
						<td id="color" width="20%" align="right"><font style="font-size: 14">政治面貌<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="politics" name="politics" style="width: 75%;"  >
								<option value="01|中国共产党"  <c:if test="${ct.political=='01|中国共产党' }">selected</c:if> >01|中国共产党</option>
								<option value="03|群众" <c:if test="${ct.political=='03|群众' }">selected</c:if> >03|群众</option>
								<option value="04|共青团员" <c:if test="${ct.political=='04|共青团员' }">selected</c:if> >04|共青团员</option>
								<option value="05|民革会员" <c:if test="${ct.political=='05|民革会员' }">selected</c:if> >05|民革会员</option>
								<option value="06|民盟盟员" <c:if test="${ct.political=='06|民盟盟员' }">selected</c:if> >06|民盟盟员</option>
								<option value="07|民建会员" <c:if test="${ct.political=='07|民建会员' }">selected</c:if> >07|民建会员</option>
								<option value="08|民进会员" <c:if test="${ct.political=='08|民进会员' }">selected</c:if> >08|民进会员</option>
								<option value="09|农工党党员" <c:if test="${ct.political=='09|农工党党员' }">selected</c:if> >09|农工党党员</option>
								<option value="10|中国致公党党员" <c:if test="${ct.political=='10|中国致公党党员' }">selected</c:if>>10|中国致公党党员</option>
								<option value="11|九三学社社员" <c:if test="${ct.political=='11|九三学社社员' }">selected</c:if>>11|九三学社社员</option>
								<option value="12|台盟盟员" <c:if test="${ct.political=='12|台盟盟员' }">selected</c:if> >12|台盟盟员</option>
								<option value="13|无党派人士" <c:if test="${ct.political=='3|无党派人士' }">selected</c:if> >13|无党派人士</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">身份证件类别<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="credentials" name="credentials" value="${ct.idtype}"
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="idCardType">
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">证件号<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="credentialsNum" name="credentialsNum" value=""></td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">联系方式</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">资格取得方式<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="seniorityType" name="seniorityType" value=""  
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="zgType"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14" >全科合格证号<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="certificate2" name="certificate2" value=""></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">联系电话<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input phone" id="phone" name="phone" value="${ct.phone}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">手机<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input phone" id="mobile" name="mobile" value="${ct.mobile}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">电子邮件<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input email" id="email" name="email" value="${ct.email}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">邮编<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="postcode" name="postcode" value="${ct.post}"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">所在地区：</font></td>
						<td width="30%">
							<input class="required input" id="area" name="area" value="${ct.area}" 
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=40><br>
							<font color="red">(当前所在市注协)</font>
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">全科合格年份<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="passYear" name="passYear" value=""></td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">受教育信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">毕业院校<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="educational" name="educational" value=""></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">外语程度<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="languagelevel" name="languagelevel" value=""></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">学历<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="diploma" name="diploma" style="width: 75%;"  >
								<option value="01|博士" <c:if test="${ct.education=='01|博士' }">selected</c:if> >01|博士</option>
								<option value="02|在读博士" <c:if test="${ct.education=='02|在读博士' }">selected</c:if> >02|在读博士</option>
								<option value="03|硕士" <c:if test="${ct.education=='03|硕士' }">selected</c:if> >003|硕士</option>
								<option value="04|在读硕士" <c:if test="${ct.education=='04|在读硕士' }">selected</c:if> >04|在读硕士</option>
								<option value="05|本科" <c:if test="${ct.education=='05|本科' }">selected</c:if> >05|本科</option>
								<option value="06|大专" <c:if test="${ct.education=='06|大专' }">selected</c:if> >06|大专</option>
								<option value="07|中专" <c:if test="${ct.education=='07|中专' }">selected</c:if> >07|中专</option>
								<option value="90|其他" <c:if test="${ct.education=='90|其他' }">selected</c:if> >90|其他</option>
							</select>
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">学位<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="degree" name="degree" style="width: 75%;"  >
								<option value="01|博士" >01|博士</option>
								<option value="02|硕士" >02|硕士</option>
								<option value="03|双学士" >03|双学士</option>
								<option value="04|学士" >04|学士</option>
								<option value="09|其他" >09|其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">专业<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="specialty" name="specialty" value="${ct.specialty}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">专业技术职称：</font></td>
						<td width="30%"><input class="input" id="rank" name="rank" value=""
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=45>
						</td>
					</tr>
					<tr style="display: none">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 15">执业信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">工作单位<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="workunits" name="workunits" value=""></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">单位性质：</font></td>
						<td width="30%"> 
							<select id="ownership" name="ownership" style="width: 75%;"  >
								<option value="01|会计师事务所" >01|会计师事务所</option>
								<option value="02|机关事业" >02|机关事业</option>
								<option value="03|企业公司" >03|企业公司</option>
								<option value="04|院校" >04|院校</option>
								<option value="05|其他" >05|其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">通讯地址<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="address" name="address" value="${ct.address}"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">是否离退休<font color="red">[*]</font>：</font></td>
						<td width="30%"> 
							<select id="istired" name="istired" style="width: 75%;"  >
								<option value="01|在职" >01|在职</option>
								<option value="02|退休" >02|退休</option>
								<option value="03|离休" >03|离休</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">职称等级<font color="red">[*]</font>：</font></td>
						<td >
							<input style="width: 75%" id="professional" name="professional" value="${ct.professional}"
									autoWidth="210"
									noinput="true"
									class="required" 
									onfocus="onPopDivClick(this);" 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="dutyLevel"> 
						</td>
						<td colspan="2"></td>
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

	// 加载 对应的 名族
	var nvalue = "${ct.nation}";
	var nation = document.getElementById("nation");
	for(var i=0;i<nation.length;i++){
		if(nation[i].value==nvalue){
			nation[i].selected = true;
			break;
		}
	}

	//加验证
	$(document).ready(function(){
	   $("#myForm").validate();
	});
	  
	var id = "${ct.id }";
	if(id!=null && id!=""){
		document.getElementById("print").display = "";
	}else{
		// 民族
		document.getElementById("nation").value = "";
		// 政治面貌
		document.getElementById("politics").value = "";
		// 学历
		document.getElementById("diploma").value = "";
		// 学位
		document.getElementById("degree").value = "";
		// 单位性质
		document.getElementById("ownership").value = "";
		// 是否离退休
		document.getElementById("istired").value = "";
		
		// 全科合格年份 默认当前年份
		// document.getElementById("passYear").value = new Date().getYear();
	}
	
	
	// 确定  
	function f_save(){
		var id = document.getElementById("id").value;
		if(id=="" || id==null){
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/micfonoJoinParty.do?method=addMicfonoJoinParty";
		}else{
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/micfonoJoinParty.do?method=updateMicfonoJoinParty";
		}
	}
	
	// 打印
	function f_print(){
		var id = document.getElementById("id").value;
		var save = document.getElementById("save").value;
		if(save!="save"){
			alert("请保存好信息在进行打印!");
		}else{
			window.open("${pageContext.request.contextPath}/common/micfonoJoinParty.do?method=goPrint&id="+id);
		}
	}
</script>
</html>