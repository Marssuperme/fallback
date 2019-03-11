<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<script type="text/javascript">

  
	var dataArray = [ '在境外停留', '因生育休产假的', '因疾病不能参加年检的', '丧失完全民事行为能力',
			'省注协认可的其他情形', '未报备变动的会员信息', '存在严重违反中注协职业道德守则的行为', '未按时足额缴纳会费',
			'受到刑事处罚', '未完成规定的继续教育',
			'因在财务、会计、审计、企业管理或者其他经济管理工作中犯有严重错误受行政处罚、撤职以上处分' ];

	$(function() {

		var userType = '${usertype}';
		var audit = '${audit}';

		if ("${member.ischeck}" == '1' && "${member.stateno}" == '0') {//注协 退回
			$(".ccheck").attr("disabled", "disabled");

		}
		//拼接 原因

		if ("${member.cityidea}" != '') {
			switchCheckbox('city');
		} else {
			auditideas('city');
		}

		if ("${member.provinceidea}" != '') {
			switchCheckbox('province');
		} else {
			auditideas('province');
		}

		if ("${member.age}" == '') {
			caculateAge("${member.borndate}");
		}

		$("#ig_provinceother").change(function() {

			if ($("#ig_provinceother").val() == 1) {
				$("#provinceother_con").removeAttr("readOnly");
				$("#provinceother_con").attr("required", "required");
			} else if ($("#ig_provinceother").val() == 0) {
				$("#provinceother_con").val("");
				$("#provinceother_con").attr("readOnly", "readOnly");
				$("#provinceother_con").removeAttr("required");
			}
		});

	});

	function auditideas(usertype) {
		var s = $("#ftd select");
		for (var i = 0; i < s.length; i++) {
			var tt = dataArray[i];
			if ((s[i].id.indexOf("ig_") >= 0 && s[i].value == '1' && s[i].id != "ig_membershipfee")
					|| (s[i].value == '0' && s[i].id == "ig_membershipfee")) {
				if ("city" == usertype) {
					$("#cityaudit").val("申请暂缓");
					var ci = $("#cityidea").val();
					if (s[i].id.substring(3) == "provinceother") {
						var tt1 = $("#provinceother_con").val();
						$("#cityidea").val(ci + tt + ":" + tt1 + ",");
					} else {
						$("#cityidea").val(ci + tt + ",");
					}

				} else if ("province" == usertype) {
					$("#provinceaudit").val("暂缓");
					var pi = $("#provinceidea").val();
					if (s[i].id.substring(3) == "provinceother") {
						var tt1 = $("#provinceother_con").val();
						$("#provinceidea").val(pi + tt + ":" + tt1 + ",");
					} else {
						$("#provinceidea").val(pi + tt + ",");
					}
				}
			}
		}

	}
	function caculateAge(borndate) {
		if (borndate != 'undefined' && borndate != null && borndate != "") {
			var d = new Date();
			var nowYear = d.getFullYear();
			var born = borndate.substring(0, 4);

			$("#age").val(nowYear - born);
		}
	}
	function switchCheckbox(usertype) {
		if ('city' == usertype) {
			var cityidea = "${member.cityidea}";
			var ctd = $("#ctd .ccheck");
			for (var i = 0; i < dataArray.length; i++) {
				if (cityidea.indexOf('(市注协)' + dataArray[i]) >= 0)
					ctd[i].checked = true;
			}
		}
		if ('province' == usertype) {
			var provinceidea = "${member.provinceidea}";
			var ptd = $("#ptd .ccheck");
			for (var i = 0; i < dataArray.length; i++) {
				if (provinceidea.indexOf('(省注协)' + dataArray[i]) >= 0)
					ptd[i].checked = true;
			}
		}

	}
	function changeName(obj) {
		var loginname = obj.value;
		var t = Math.random();
		$.ajax({
			url : "yearCheck.do?method=loadInfo&ccc=" + t,
			async : false,
			type : "post",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : {
				"loginname" : loginname
			},
			success : function(data) {
				info = eval("(" + data + ")");
				for ( var attr in info) {
					$("#" + attr).val(info[attr]);
				}
				alert(date);

			}
		});

	}

	function impSB() {
		var divObj = document.getElementById("divProduce");
		var blockObj = document.getElementById("divBlock");
		var attachments = document.getElementById("attachments");
		divObj.style.display = "";
		blockObj.style.display = "";

	}

	function hiddenProDiv() {
		var divObj = document.getElementById("divProduce");
		var blockObj = document.getElementById("divBlock");
		divObj.style.display = "none";
		blockObj.style.display = "none";
	}

	function changeGD(obj) {
		var v = obj.value;
		if (v == "否") {
			$("#contributiveratio").removeClass("required error");
			$("#contributiveratio").removeClass("error");
			$("#lvxing").val("");
			$("#contributiveratio").val("");
			$("#lvxing").attr("disabled", "disabled");
			$("#contributiveratio").attr("disabled", "disabled");
			$("#contributiveratio").addAttr("disabled");
			$("#contributiveratio").removeClass("required");

		} else {
			$("#lvxing").removeAttr("disabled");
			$("#contributiveratio").removeAttr("disabled");
			$("#contributiveratio").addClass("required");
		}

	}
	function checkunit(obj) {
		var unit = obj.value;
		var officename = document.getElementById("officename").value;
		var retireesunit = '${member.retireesunit}';
		var retirees = '${member.retirees}';
		if ('${member.edit}' == 'edit') {
			if ('${usertype}' == 'office' || '${usertype}' == 'cpa') {
				if (retirees == '在职') {
					if (unit.substr(0, 4).search(officename.substr(0, 4)) != -1) {
						alert("此处不应填写所在事务所名称或离退休所在单位名称");
						obj.value = "";
						obj.focus();
					}
				} else {
					if (retireesunit == '') {
						alert('若已离退休,请在个人信息中完善离退休单位');
					} else {
						if ((unit.substr(0, 4).search(officename.substr(0, 4)) != -1)
								|| (unit.substr(0, 4).search(
										retireesunit.substr(0, 4)) != -1)) {
							alert("此处不应填写所在事务所名称或离退休所在单位名称");
							obj.value = "";
							obj.focus();
						}
					}

				}
			}
		}
	}
</script>

<input type="hidden" value="${member.uuid }" name="uuid" />
<input type="hidden" value="${member.year }" name="year"  />
<input type="hidden" value="${member.officecode }" name="officecode" />
<input type="hidden" value="${member.officename }" name="officename" id="officename" />
<input type="hidden" value="${member.state }" name="state" id="state" />
<input type="hidden" value="${member.stateno }" name="stateno" id="stateno" />
<input type="hidden" value="${member.fillformperson }" name="fillformperson" id="fillformperson" />
<input type="hidden" value="${member.fillformdate }" name="fillformdate" id="fillformdate" />
<input type="hidden" value="${member.auditresult }" name="auditresult" id="auditresult" />
<input type="hidden" value="${member.auditreason }" name="auditreason" id="auditreason" />

<table border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
	<tbody>
		<tr>
			<td height="280" vAlign="top" align="middle">
				<!--顶部图片结束--> <!--中部表格开始-->
				<table border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
					<tbody >
						<tr>
							<td vAlign="top">
								<table style="WIDTH: 100%" class="data_tb" align="center" id='ftd'>
									<tr>
										<td class="data_tb_aligncenter" colspan="9" style="height: 50px;">
											<font style="font-size: 22px; font-weight: bolder;" align="center">非执业年检信息</font> 
										</td>
									</tr>
									<tr>
										<td class="data_tb_aligncenter" colspan="9" style="height: 50px;">
											<font style="font-size: 22px; font-weight: bolder;" align="center">一、基础信息</font> 
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='10%'>
											姓名：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required data_tb_contentinput" readOnly='readOnly' name="loginname" 
											id="loginname" value="${member.loginname}" type="text"/>
										</td>
										<td class="data_tb_alignright" nowrap="nowrap">
											性别：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='150px'>
											<input class="required data_tb_contentinput" type="text"  readOnly='readOnly' 
											name="sex" id="sex" value="${member.sex }" style="width:80%"/></td>
										<td class="data_tb_alignright" nowrap="nowrap" >
											年龄：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required" type="text" name="age" id="age" style="width:70px;" value="${member.age}" />
										</td>
										<td class="data_tb_alignright" nowrap="nowrap" width='100px'>
											政治面貌：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='150px' colspan="2">
									   		<input class="required" name="politics" id="politics" value="${member.politics }" style="width:75%"/>
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright" nowrap="nowrap">
											身份证号码：<font color="red">&nbsp;[*]</font>
										</td>
										<td colspan="1" class="data_tb_content ">
											<input class="required data_tb_contentinput" readOnly='readOnly' type="text" 
											name="idnumber" id="idnumber" value="${member.idnumber }" style="width:93.7%"/>
										</td>
										<td class="data_tb_alignright" nowrap="nowrap">
											所在地区：<font color="red">&nbsp;[*]</font>
										</td>
										<td colspan="1" class="data_tb_content ">
											<input class="required data_tb_contentinput" readOnly='readOnly' type="text"
											value="${member.area }" style="width:93.7%"name="area" id="area_area" />
										</td>
										<td class="data_tb_alignright" nowrap="nowrap" >非执业会员证号：<font
											color="red">&nbsp;[*]</font>
										</td>
										<td colspan="4" class="data_tb_content">
											<input class="required data_tb_contentinput" readOnly='readOnly' type="text"
											name="loginid" id="loginid" value="${member.loginid }" style="width:79.5%"/>
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright" nowrap="nowrap">
											户口所在地：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required" type="text" name="accountin" id="accountin" value="${member.accountin}" />
										</td>
										<td class="data_tb_alignright" nowrap="nowrap">
											邮编：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required number" type="text" name="postcode" id="postcode"
											value="${member.postcode}"  style="width:80%"/>
										</td>
										<td class="data_tb_alignright" nowrap="nowrap" >
											通讯地址：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" colspan='4'>
											<input class="required" style="width:79.5%" type="text"
											name="address" id="address" value="${member.address }" /></td>
									</tr>
									<tr>
										<td class="data_tb_alignright" nowrap="nowrap">
											固定电话：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required" type="text" name="phone" id="phone" value="${member.phone}" />
										</td>
										<td class="data_tb_alignright" nowrap="nowrap">
											手机：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required number" type="text" name="mobile" id="mobile"
											value="${member.mobile}" style="width:80%"/>
										</td>
										<td class="data_tb_alignright" nowrap="nowrap" >
											工作单位：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" colspan='4'>
											<input class="required" style="width:79.5%" type="text"
											name="workunits" id="workunits" value="${member.workunits }" />
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright" nowrap="nowrap">
											Email：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" >
											<input class="required"  type="text" name="email" id="email" value="${member.email }" />
										</td>
                                        <td class="data_tb_alignright" nowrap="nowrap">
                                        	QQ：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input class="required number" type="text" name="qq" id="qq"
											value="${member.qq}"  style="width:80%"/>
										</td>
											<td class="data_tb_alignright" nowrap="nowrap" >
												继续教育情况：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input readonly="readonly" class="required data_tb_contentinput" style="width:79.5%" type="text" 
											name="continuedu" id="continuedu" value="${member.continuedu=='0'||member.continuedu=='通过'||member.continuedu=='是'?'通过':'不通过' }" />
										</td>
										<td class="data_tb_content" rowspan="2" colspan="3">
											<font color="red">（隔天自动更新，直接提交审核）</font>
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright" nowrap="nowrap" >
											全科合格证号/考核批准文号：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" colspan='3'>
											<input class="required data_tb_contentinput" style="width:93.7%" type="text" readonly="readonly" 
											name="general" id="general" value="${member.general }" />
										</td>
										<td class="data_tb_alignright" nowrap="nowrap">
											已完成学时<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content">
											<input readonly="readonly"  class="required data_tb_contentinput" style="width:79.5%" type="text" 
											name="periodresult" id="periodresult" value="${member.periodresult==''?'0':member.periodresult}" />
										</td>
									</tr>
									<tr>
										<td class="data_tb_aligncenter" colspan="9" style="height:50px;">
											<font style="font-size: 22px; font-weight: bolder;" align="center"> 二、年检内容 </font>
										</td>
									</tr>
									<tr>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id='outboundstay_con'>1.是否在境外停留的：</td>
										<td  class="data_tb_content" colspan='2' >
											<select name='ig_outboundstay' id="ig_outboundstay" style="width: 100px;">
												<option ${member.outboundstay=='1'?'selected':'' } value='1'>是</option>
												<option ${member.outboundstay!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="bearholiday_con">2.是否因生育休产假的：</td>
										<td  class="data_tb_content" colspan='3' >
											<select name='ig_bearholiday' id="ig_bearholiday" style="width: 100px;">
												<option ${member.bearholiday=='1'?'selected':'' } value='1'>是</option>
												<option ${member.bearholiday!='1'?'selected':'' } value='0' >否</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="sickdays_con">3.是否因疾病不能参加年检的：</td>
										<td  class="data_tb_content" colspan='2' >
											<select name='ig_sickdays' id="ig_sickdays" style="width: 100px;">
												<option ${member.sickdays=='1'?'selected':'' } value='1'>是</option>
												<option ${member.sickdays!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="losecivilact_con">4.是否丧失完全民事行为能力：</td>
										<td  class="data_tb_content" colspan='3' >
											<select name='ig_losecivilact' id="ig_losecivilact" style="width: 100px;">
												<option ${member.losecivilact=='1'?'selected':'' } value='1'>是</option>
												<option ${member.losecivilact!='1'?'selected':'' } value='0' >否</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" >5.是否省注协认可的其他情形：</td>
										<td  class="data_tb_content" colspan='2' >
											<select name='ig_provinceother' id="ig_provinceother" style="width: 100px;">
												<option ${member.provinceother=='1'?'selected':'' } value='1'>是</option>
												<option ${member.provinceother!='1'?'selected':'' } value='0'>否</option>
											</select>
											<input type='text' id="provinceother_con" name='provinceotheridea' readOnly="readOnly" value="${member.provinceotheridea }">
										</td>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="memberinfochange_con">6.是否未报备变动的会员信息：</td>
										<td  class="data_tb_content" colspan='3' >
											<select name='ig_memberinfochange' id="ig_memberinfochange" style="width: 100px;">
												<option ${member.memberinfochange=='1'?'selected':'' } value='1'>是</option>
												<option ${member.memberinfochange!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id='illegal_con'>7.是否存在严重违反中注协职业道德守则的行为：</td>
										<td  class="data_tb_content" colspan='2' >
											<select name='ig_illegal' id="ig_illegal" style="width: 100px;">
												<option ${member.illegal=='1'?'selected':'' } value='1'>是</option>
												<option ${member.illegal!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="membershipfee_con">8.是否按时足额缴纳会费：</td>
										<td  class="data_tb_content" colspan='3' >
											<select name='ig_membershipfee' id="ig_membershipfee" style="width: 100px;" disabled='disabled'>
												<option ${member.membershipfee=='1'?'selected':'' } value='1'>是</option>
												<option ${member.membershipfee!='1'?'selected':'' } value='0' >否</option>
											</select>
										<%-- <c:if test="${member.stateno=='0'||member.edit=='edit'}">
										&nbsp;&nbsp;&nbsp;<a target='_blank' style='color:red;' href='http://www.jicpa.org.cn/pub/jszx/zcgl/hyglxx/201506/t20150608_76112.html' title='非执业会员会费缴纳系统' >会费缴纳</a>
										</c:if> --%>
										</td>
									</tr>
									<tr>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id="criminal_con">9.是否受到刑事处罚：</td>
										<td  class="data_tb_content" colspan='2' >
											<select name='ig_criminal' id="ig_criminal" style="width: 100px;">
												<option ${member.criminal=='1'?'selected':'' } value='1'>是</option>
												<option ${member.criminal!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
										<td colspan='2' class="data_tb_alignright" nowrap="nowrap" id='continuedu_con'>10.是否完成规定的继续教育：</td>
										<td  class="data_tb_content" colspan='3' >
											<select name='ig_continuedu' id="ig_continuedu" style="width: 100px;" disabled='disabled'>
												<option ${(member.continuedu!='1')?'selected':'' } value='0'>是</option>
												<option ${member.continuedu=='1'?'selected':'' } value='1'>否</option>
											</select>
										<c:if test="${member.stateno=='0'||member.edit=='edit'}">
														<!-- <span style='font-size:12px;color:red;margin-left:20px;'>注协后期统一导入</span> -->
													</c:if>
										</td>
									</tr>
									<tr>
										<td colspan='4' class="data_tb_alignright" nowrap="nowrap" id="otherpunish_con">11是否因在财务、会计、审计、企业管理或者其他经济管理工作中犯有严重错误受行政处罚、撤职以上处分：</td>
										<td colspan='5' class="data_tb_content">
											<select name='ig_otherpunish' id="ig_otherpunish" style="width: 100px;">
												<option ${member.otherpunish=='1'?'selected':'' } value='1'>是</option>
												<option ${member.otherpunish!='1'?'selected':'' } value='0'>否</option>
											</select>
										</td>
									</tr>
								</table>
							</td>
						</tr>
				</table> <!--中部表格结束-->
			</td>
		</tr>
	</tbody>
</table>
<!-- </form> -->

