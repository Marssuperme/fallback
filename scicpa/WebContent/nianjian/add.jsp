<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>非执业会员年检</title>
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
		width:850px;
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
		
				<table align="center" id="table" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="4" class="color">
						<center> <font style="font-size: 20">非&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;年&nbsp;检&nbsp;信&nbsp;息&nbsp;</font></center>
						</td>
					</tr>
					<tr style="display: ">
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 16;font-weight:bold ">个人信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right" ><font style="font-size: 14">姓名<font color="red">[*]</font>：</font></td>
						<td width="30%">
							<input name="loginname" type="text" id="loginname"   class="required input" 
							readonly size="25"  value = "${userMap.loginname }" cannotedit>
						</td>
						
						<td id="color" width="20%" align="right"><font style="font-size: 14">性别<font color="red"></font>：</font></td>
						<td width="30%"><input style="width: 75%" id="sex" name="sex" 
										value="${userMap.sex }"  readonly
													autoWidth="210"
													noinput="true"
													onfocus="onPopDivClick(this);" 
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													${readonly} 
													autoid=2  >
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用名：</font></td>
						<td width="30%">
								<input class="input" id="loginnameex" name="loginnameex" 
								${readonly}
								value = "${userMap.loginnameex }"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">曾用身份证号码：</font></td>
						<td width="30%">
						<input class="input" id="idnumberex" name="idnumberex"  ${readonly} value = "${userMap.idnumberex }" ></td>
					</tr>
				
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">出生日期<font color="red"></font>：</font></td>
						<td width="30%"><input style="width: 63%" id="borndate" name="borndate" value="${userMap.borndate }" 
									showcalendar="true" ${readonly} ></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">户口所在地<font color="red"></font>：</font></td>
						<td width="30%"><input class="input" id="accountin" name="accountin" value="${userMap.accountin}" ${readonly} ></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">民族<font color="red"></font>：</font></td>
						<td width="30%"> 
								<input class="input" ${readonly} 
							name="nation" type="text" id="nation" size="25" maxlength="10"
							value="${userMap.nation }" autoWidth=190
	    					autoHeight=180 noinput=true
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							autoid=55 refer="mingzu" >	
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">政治面貌<font color="red"></font>：</font></td>
						<td width="30%"> 
							<input name="politics" type="text" id="politics"  size="25" maxlength="20" value = "${userMap.politics }" 
									autoWidth=190 class="input"  noinput=true
			    					autoHeight=180 ${readonly} 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="politic2" >
						</td>
					</tr>
					<tr>
						<!--
						<td id="color" width="20%" align="right"><font style="font-size: 14">身份证件类别<font color="red">[*]</font>：</font></td>
						<td width="30%"><input class="required input" id="credentials" name="credentials" value="${userMap.idtype}"
												autoWidth="210"
												noinput="true"
												onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoid=55 refer="idCardType">
						</td>-->
						<td id="color" width="20%" align="right"><font style="font-size: 14">身份证号<font color="red">[*]</font>：</font></td>
						<td width="30%">
							<input name="idnumber" type="text" id="idnumber"  class="input" size="25"
							value="${userMap.idnumber }" cannotedit readonly>
						</td>
						<td id="color" ></td><td id="color" ></td>
					</tr>
					
					<tr >
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 16;font-weight:bold ">联系方式</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">邮编<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18"><input name="postcode" ${readonly} type="text" id="postcode"  class="input"  size="25" maxlength="10" value = "${userMap.postcode }" myClass="number"></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">电子邮箱<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="email" type="text" id="email"  size="25" maxlength="50" ${readonly} 
							value = "${userMap.email }" myClass="email"  class="required input" ></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">电话<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="14">
							<input name="phone" type="text" id="phone"  size="25" maxlength="20" value = "${userMap.phone }" ${readonly} 
							myClass="phone"  class="input" ></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">手机<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="14"><input name="mobile" type="text" 
							id="mobile"  size="25" maxlength="20" value = "${userMap.mobile }" class="required input" 
							${readonly} myClass="number"></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">所在地区<font color="red">[*]</font>：</font></td>
						<td width="30%" colspan=3>
							<input name="area" type="text" id="area" maxlength="200" size="25"  value = "${userMap.area}"
						 			autoWidth=190 class="required input" ${readonly} 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=40  >		
							<font color="red">(当前所在市注协)</font>
						</td>
						<!--
						<td id="color" width="20%" align="right"><font style="font-size: 14">全科合格年份<font color="red"></font>：</font></td>
						<td width="30%"><input class="required input" id="passYear" name="passYear" value=""></td>
						-->
					</tr>					
					
					<tr >
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 16;font-weight:bold ">受教育信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">毕业学校<font color="red"></font>：</font></td>
						<td class="data_tb_content" width="30%" height="18"><input
							name="educational" type="text" id="educational" size="25" maxlength="50" class="input" ${readonly} 
							value="${userMap.educational }"></td>

						<td id="color" width="20%" align="right"><font style="font-size: 14">专业<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="specialty" type="text" id="specialty"  size="25" maxlength="50"  class="input" ${readonly} 
							value = "${userMap.specialty }">
						</td>
					</tr>
					<tr>

						<td id="color" width="20%" align="right"><font style="font-size: 14">学位<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="degree" type="text" id="degree"  size="25" maxlength="50" value = "${userMap.degree }"		${readonly} 
									autoWidth=190 noinput=true
			    					autoHeight=180  class="input" 
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="xuewei" >	
						</td>

						<td id="color" width="20%" align="right"><font style="font-size: 14">学历<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="diploma" type="text" id="diploma"  size="25" maxlength="50" value = "${userMap.diploma }" ${readonly} 
									autoWidth=190 class="input" 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="xueli" >
						</td>
					</tr>
					<tr>

						<td id="color" width="20%" align="right"><font style="font-size: 14">外语程度<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="languagelevel" type="text" id="languagelevel"   class="input" size="25" ${readonly} maxlength="20" value = "${userMap.languagelevel }">
						</td>
						
						<td id="color" width="20%" align="right"><font style="font-size: 14">专业技术职称<font color="red"></font>：</font></td>
						<td class="data_tb_content" >
								<input name="rank" type="text" id="rank"  size="25" maxlength="100" ${readonly} value = "${userMap.rank }" 
								autoWidth=190 class="input" 
		    					autoHeight=180 noinput=true
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 refer="zyzc">
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">职称等级<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="professional" type="text" id="professional" maxlength="20" size="25"  value = "${userMap.professional }" 
									autoWidth=190  noinput=true
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="zcdj">
						</td>
						<td id="color" width="20%" align="right"></td>
						<td id="color" width="20%" align="right"></td>
					</tr>
					
					<tr >
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 16;font-weight:bold ">执业信息</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">工作单位<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="14"><input name="workunits"  class="input" type="text" id="workunits" ${readonly} maxlength="100" size="25"  value = "${userMap.workunits }"></td>
						
						<td id="color" width="20%" align="right"><font style="font-size: 14">单位性质<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="14">
							<input name="ownership" type="text" id="ownership"  size="25" maxlength="100" ${readonly} value = "${userMap.ownership}"
									autoWidth=190 class="input" 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="comanyquale">
						</td>
					</tr>
					
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">通信地址<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content"  height="18"><input name="address" type="text" class="required input" ${readonly} id="address"  size="25" maxlength="200" value = "${userMap.address }"></td>
						
						<td id="color" width="20%" align="right"><font style="font-size: 14">离退休标志<font color="red"></font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="retirees" type="text" id="retirees" maxlength="100" size="25" ${readonly}  class="input"  
									value = "${userMap.retirees }"
									autoWidth=190 noinput=true
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="workState">
						</td>
					</tr>

					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">会员证号<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="crsa" type="text" id="crsa"  ${readonly}  class="required input" 
							readonly size="25"  value = "${userMap.crsa }" cannotedit></td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">会员批准文号<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="18"><input name="approvalnumber"  readonly class="input" type="text" id="approvalnumber"  size="25"  value = "${userMap.approvalnumber }" cannotedit></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">资格取得方式<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="18">
							<input name="getmode" type="text" id="getmode" maxlength="100" size="25"  value = "${userMap.getmode }" 
									autoWidth=190 class="input"  readonly
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="zgqdfs">
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">全科合格证号<font color="red">[*]</font>：</font></td>
						<td class="data_tb_content" height="18"><input name="certificate" type="text" 
								id="certificate" maxlength="100" size="25"   class="input" 
							value = "${userMap.certificate }" cannotedit readonly></td>
					</tr>
					
					<tr >
						<td colspan="4" class="color">
							<font style="margin-left: 2%;font-size: 16;font-weight:bold ">${year}年检情况</font>
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">完全民事行为能力<font color="red">[*]</font>：</font></td>
						<td>
							<input name="msnl" type="text" id="msnl"  size="25" maxlength="50" value = "${isMap.msnl }" 
									autoWidth=190  class="required input" ${readonly} 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="是否连续审计" >
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">后续教育学时<font color="red">[*]</font>：</font></td>
						<td><input class="required input" id="schooldate" name="schooldate" value="${isMap.schooldate}" ${readonly} 
								class="required input" ></td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">受过何种刑事处罚<font color="red">[*]</font>：</font></td>
						<td>
							<input name="xscf" type="text" id="xscf"  size="25" maxlength="50" value = "${isMap.xscf }" 
									autoWidth=190 class="required input" ${readonly} 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="是否连续审计" >
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">受过何种行政或行业惩戒<font color="red">[*]</font>：</font></td>
						<td><input name="hycf" type="text" id="hycf"  size="25" maxlength="50" value = "${isMap.hycf }" 
									autoWidth=190 class="required input" ${readonly} 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="是否连续审计" >
						</td>
					</tr>
					<tr>
						<td id="color" width="20%" align="right"><font style="font-size: 14">是否缴纳会费<font color="red">[*]</font>：</font></td>
						<td>
							<input name="dues" type="text" id="dues"  size="25" maxlength="50" value = "${isMap.dues }" 
									autoWidth=190 class="required input" ${readonly} 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="是否连续审计" >
						</td>
						<td id="color" width="20%" align="right"><font style="font-size: 14">是否参加年检<font color="red">[*]</font>：</font></td>
						<td>
						<input name="yearcheck" type="yearcheck" id="dues"  size="25" maxlength="50" 
									value = "${isMap.yearcheck }" ${readonly} 
									autoWidth=190 class="required input" 
			    					autoHeight=180 noinput=true
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="是否连续审计" >
						</td>
					</tr>
				</table>
			
		<div style="margin-top:2%;" align="center" > 
			  <input type="button" class="flyBT" value="暂  存" ${save} onclick="return f_save(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="button" class="flyBT" value="提  交" ${save} onclick="return f_save(1)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="button" class="flyBT" value="打  印" ${print} onclick="return f_print()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="button" class="flyBT" value="返  回" onclick="window.history.back()">
			  
			  <input type="hidden" value="${year}" name="year" />
			  
			  <input type="hidden" value = "${isMap.approval }"  name="approval" />
		</div>
		<br><br><br>
	</form>
</body>
<script type="text/javascript">

	//加验证
	$(document).ready(function(){
	   $("#myForm").validate();
	});
	  
	var id = "${ct.id }";
	if(id!=null && id!=""){
		document.getElementById("print").display = "";
	}
	
	// 确定  
	function f_save(op){
	
		if(document.myForm.fireEvent('onsubmit')){
		
			if (op==0){
				alert('您选择了暂存，以后可以随时编辑，但不能打印（只有选择提交才可打印）');
			}else{
				if (!confirm('您选择了提交，确认后将不能修改，是否继续？（只有选择提交才可打印）')){
					alert('系统按暂存处理');
					op=0;
				}
			}
			document.getElementById("approval").value=op;
			
		
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/nianjian.do?method=save";
			document.getElementById("myForm").submit();
			return true;
		}else{
			return false;
		}		
	}
	
	// 打印
	function f_print(){
			window.open("${pageContext.request.contextPath}/common/nianjian.do?method=goPrint&year=${year}");
	}
</script>
</html>