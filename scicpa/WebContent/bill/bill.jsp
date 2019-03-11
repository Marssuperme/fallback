<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发票申请</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
	<style>
		.data_tb_title{
			height: 45px;
			border: 1px solid #99bbe8;
			font-size: 16px; 
			text-align: center;
			font-weight: bolder;
		}
		.data_tb_alignright{
			height: 30px;
			border: 1px solid #99bbe8;
			text-align: right;
			padding-right: 10px;
		}
		.data_tb_content{
			height: 30px;
			border: 1px solid #99bbe8;
			text-align: left;
			padding-left: 10px;
			background-color: white;
		}
	</style> 
	<script type="text/javascript">

		function showLoading() {
			document.getElementById("divBlock").style.display = "";
			document.getElementById("loading").style.display = "";
		}
		
		function hiddenLoading() {
			document.getElementById("divBlock").style.display = "none";
			document.getElementById("loading").style.display = "none";
		}
		
		//保存后结果
		function saveResult(rs) {
			hiddenLoading();
			if (rs == '1') {
				alert("数据保存成功！");
				window.location.href = "${pageContext.request.contextPath}/common/bill.do?method=listBill";
			} else {
				alert("数据保存失败！");
			}
		}
		
		//暂存数据
		function saveApplyTable(state) {
			$("input").removeClass("required");
			if (!$("#thisForm").valid()) {
				$("input").error(function() {
					$(this).focus();
				});
			} else {
				$("#state").val(state);
				$("#thisForm").submit();
				showLoading();
			}
		}
		
		//提交审核
		function submitAudit(state) {
	
			var year = "${apply.year}";
			var loginid = "${apply.loginId}"
			
			$("#state").val(state);
			
			if (!$("#thisForm").valid()) {
				$("input").error(function() {
					$(this).focus();
				});
			} else {
				showLoading();
				if (confirm("注协受理后不将可更改信息，确定提交?")) {
					$("#thisForm").submit();
				}
			}
		}
		
		function clearValue(){
			
			$("#state").val(state);
			$("#state").val(state);
			$("#state").val(state);
			$("#state").val(state);
			$("#state").val(state);
			
		}
		
	</script>

</head>
<body style="font-size: 15px;">

	<div id="divBlock" style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;"></div>

	<iframe name="thisIframe" name="thisIframe" style="display: none;"></iframe>

	<div style="text-align: center;">
		<c:choose>
			<c:when test="${type!='view' }">
				&nbsp;<input icon="icon-save" type="button" onclick="saveApplyTable('0');" value="暂 存" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input icon="icon-edit" type="button" onclick="submitAudit('1');" value="提交" /> 
	 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input icon="icon-back" type="button" onclick="window.history.back();window.reload();" value="返 回" />
			</c:when>
			<c:otherwise>
				<input icon="icon-back" type="button" onclick="window.history.back();window.reload();" value="返回" />
			</c:otherwise>
		</c:choose>
	</div>
	<center>
		<form action="${pageContext.request.contextPath}/common/bill.do?method=saveInfo" method="post" name="thisForm" id="thisForm" target='thisIframe'>
			<div class="block" id="search" style="height: 100%;">
				<br />
				<table style="width: 90%;border: 1px solid #99bbe8;" cellpadding="0" cellspacing="0" border="0" bgcolor="#99cfe8">
					<tr>
						<td colspan="2" class="data_tb_title">会费发票申请信息</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							申请年份：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>${apply.year}</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
							发票抬头：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="title_edit" >
								<input class="required"  maxlength='100' style='width:78%' 
									name="title" id="title" value="${apply.title}" type="text"/>
								<span class="remarkspan" >(限开本人或本人+单位)</span>
							</div>
							<div id="title_show">${apply.title}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							发票金额：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>100.0元</td>
					</tr>
					<tr>
						<td class="data_tb_alignright " nowrap="nowrap"  width='38%'>
							收件人地址：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="address_edit">
								<input class="required" maxlength='16' style='width:78%' 
									name="address" id="address" value="${apply.address}" type="text"/>
							</div>
							<div id="address_show">${apply.address}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							收件人单位：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="workUnit_edit">
								<input class="required" maxlength='16' style='width:78%' 
									name="workUnit" id="workUnit" value="${apply.workUnit}" type="text"/>
							</div>
							<div id="workUnit_show">${apply.workUnit}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							收件人：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="receiver_edit">
								<input class="required" maxlength='16' style='width:78%' 
									name="receiver" id="receiver" value="${apply.receiver}" type="text"/>
							</div>
							<div id="receiver_show">${apply.receiver}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							收件人手机：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="mobile_edit">
								<input class="required" maxlength='16' style='width:78%' 
									name="mobile" id="mobile" value="${apply.mobile}" type="text"/>
							</div>
							<div id="mobile_show">${apply.mobile}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>
							邮编：<font color="red">&nbsp;[*]</font>
						</td>
						<td class="data_tb_content" width='62%'>
							<div id="postcode_edit">
								<input class="required" maxlength='16' style='width:78%' 
									name="postcode" id="postcode" value="${apply.postcode}" type="text"/>
							</div>
							<div id="postcode_show">${apply.postcode}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>备注：</td>
						<td class="data_tb_content" width='62%'>
							<div id="remark_edit">
								<textarea rows="5" cols="67" id='remark' name='remark' maxlength='200' ></textarea>
							</div>
							<div id="remark_show" >${apply.remark}</div>
						</td>
					</tr>
				</table>
				<table id="tbBill" style="width: 90%;border: 1px solid #99bbe8;" cellpadding="0" cellspacing="0" border="0" bgcolor="#99cfe8">
					<tr>
						<td colspan="2" class="data_tb_title">发票处理信息</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>发票单号：</td>
						<td class="data_tb_content" width='62%'>${apply.billNo}</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>快递公司：</td>
						<td class="data_tb_content" width='62%'>${apply.expressCompany}</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>快递订单号：</td>
						<td class="data_tb_content" width='62%'>${apply.expressNo}</td>
					</tr>
					<tr>
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>状态：</td>
						<td class="data_tb_content" width='62%' id="stateShow" ></td>
					</tr>
				</table>
				<table id="auditTb" style="width: 90%;border: 1px solid #99bbe8;" cellpadding="0" cellspacing="0" border="0" bgcolor="#99cfe8">
					<tr>
						<td colspan="2" class="data_tb_title">审核信息</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>注协意见：</td>
						<td class="data_tb_content" width='62%'>
							<div id="auditIdea_show">${apply.auditIdea}</div>
						</td>
					</tr>
					<tr >
						<td class="data_tb_alignright " nowrap="nowrap" width='38%'>备注：</td>
						<td class="data_tb_content" width='62%'>
							<div id="auditRemark_show">${apply.auditRemark }</div>
						</td>
					</tr>
				</table>
			</div>
			<input type="hidden" value="${apply.guid}" name="guid"  id='guid'/>
			<input type="hidden" value="${apply.year}" name="year"  id='year'/>
			<input type="hidden" value="100.0" name="money"  id='money'/>
			<input type="hidden" value="${apply.loginId }" name="loginId" id="loginId" />
			<input type="hidden" value="${apply.loginName }" name="loginName" id="loginName" />
			<input type="hidden" value="${apply.state }" name="state" id="state" />
			<input type="hidden" value="${apply.area }" name="area" id="area" />
			<input type="hidden" value="${edit }" name="edit" id="edit" />
		</form>
	</center>
	<br />
	<br />
	<div id="loading" style="position: absolute; width: 300px; height: 80px; z-index: 10; left: 40%; top: 18%; border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
		<div style="border: 1px solid #6595d6; padding: 5px;">
			<table>
				<tr>
					<td><img alt="" src="/scicpa/images/loading.gif"/></td>
					<td>正在提交数据，请稍候...</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
	
		if("${type }" != "view"){
			
			$("#title_show").hide();
			$("#address_show").hide();
			$("#workUnit_show").hide();
			$("#receiver_show").hide();
			$("#mobile_show").hide();
			$("#postcode_show").hide();
			$("#remark_show").hide();
			$("#tbBill").hide();
			$("#auditTb").hide();
			
		}else{
			
			$("#title_edit").hide();
			$("#address_edit").hide();
			$("#workUnit_edit").hide();
			$("#receiver_edit").hide();
			$("#mobile_edit").hide();
			$("#postcode_edit").hide();
			$("#remark_edit").hide();
			$("#tbBill").show();
			$("#auditTb").show();
		}	
	
		
		var state = "${apply.state }";
		
		if(state == "0"){
			
			state = "暂存";
			
		}else if(state == "1"){
			
			state = "会员已提交";
			
		}else if(state == "2"){
			
			state = "注协已受理";
			
		}else if(state == "3"){
			
			state = "发票已寄出";
			
		}else{
			
			state = "退回";
			$("#tbBill").show();
			$("#auditTb").show();
		}
		
		$("#stateShow").text(state);
	</script>
</body>
</html>