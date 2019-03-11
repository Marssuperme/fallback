<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>非执业年检信息</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css" />
	<style type="text/css">
		.formTitle {
			color: #4A74BC;
			font-weight: bold;
			font-size: 14px;
			text-align: center;
			width: 100%;
			margin-top: 10px;
		}
		
		.mustSpan {
			color: #FF6600;
			font-family: "宋体";
			font: normal;
			font-size: 9pt;
			padding: 0px;
			margin: 0px;
		}
		
		H3.tabs {
			PADDING-LEFT: 0px ! important;
			HEIGHT: 26px;
			BACKGROUND-COLOR: #e8f7fc ! important
		}
		
		.tab {
			BORDER-RIGHT: #c1d8e0 1px solid;
			PADDING-RIGHT: 10px;
			PADDING-LEFT: 10px;
			FONT-WEIGHT: normal;
			FLOAT: left;
			PADDING-BOTTOM: 0px;
			CURSOR: pointer;
			PADDING-TOP: 0px
		}
		
		.curtab {
			FONT-WEIGHT: bold;
			BACKGROUND: #fff;
			BORDER-RIGHT-COLOR: #b2c9d3
		}
		
		.block {
			BORDER-RIGHT: #b2c9d3 1px solid;
			BORDER-TOP: #b2c9d3 1px solid;
			BACKGROUND: #fff;
			MARGIN: 0px 0px 6px;
			BORDER-LEFT: #b2c9d3 1px solid;
			BORDER-BOTTOM: #b2c9d3 1px solid
		}
		
		.block H3 {
			PADDING-LEFT: 0.5em;
			FONT-SIZE: 1em;
			BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
			MARGIN: 1px 0px 0px;
			COLOR: #5086a5;
			LINE-HEIGHT: 26px
		}
		
		.block H3 A {
			COLOR: #5086a5
		}
		
		.before {
			border: 0px;
			background-color: white;
		}
		
		.after {
			border: 1px solid;
		}
	</style>
</head>
<body>
	<center class="formTitle">
		非&nbsp;&nbsp;执&nbsp;&nbsp;业&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;年&nbsp;&nbsp;检&nbsp;&nbsp;信&nbsp;&nbsp;息<br />
	</center>
	<center style="margin: 5px; font-size: 15px; font-weight: bold;">
		年度：${member.year }年</center>
	<DIV class=block id=search style="width: 99%">
		<center>
			<table height="30px" border="0" cellspacing="0" cellpadding="0">
				<tr align="center">
					<c:if test="${edit == 'edit'}">
						<td width="120px">
							<div>
								<input type="button" name="bct" id="bct" value="提交审核" onclick="return saveApply();">
							</div>
						</td>
					</c:if>
					<td width="">
						<div>
							<input type="button" name="next" value="返  回" class="flyBT" onclick="goBack();">
						</div>
					</td>
				</tr>
			</table>
		</center>
		<form action="${pageContext.request.contextPath}/common/annualInspection.do?method=saveApplyTable" method="post" name="thisForm" id="thisForm">
			
			<input type="hidden" name="uuid" id="uuid" value="${member.uuid }" />
			<input type="hidden" name="stateno" id="stateno" value="${member.stateno }" /> 
			<input type="hidden" name="state" id="state" value="${member.state }" /> 
			<input type="hidden" name="audittime" id="audittime" value="${member.audittime }" /> 
			<input type="hidden" name="auditperson" id="auditperson" value="${member.auditperson }" /> 
			<input type="hidden" name="filltime" id="filltime" value="${member.filltime }" /> 
			<input type="hidden" name="year" id="year" value="${member.year }" />

			<table border="0" cellSpacing="0" cellPadding="0" width="100%">
				<tbody>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;" colspan="8" height="18"><b>个人信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">姓名</td>
						<td class="data_tb_content" height="30">
							<input name="loginname" type="text" id="loginname" size="25"
								value="${member.loginname }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">会员证号&nbsp;</td>
						<td class="data_tb_content" height="30">
							<input name="loginid" type="text" id="loginid" size="25" 
								value="${member.loginid }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">性别</td>
						<td class="data_tb_content" height="30">
							<input name="sex" type="text" id="sex" size="25" 
								value="${member.sex }" cannotedit='cannotedit' myClass='required'></td>
						<td class="data_tb_alignright" height="30">身份证号码</td>
						<td class="data_tb_content" height="30">
							<input name="idnumber" type="text" id="idnumber" size="25" 
								value="${member.idnumber }" cannotedit='cannotedit' myClass="personcard required">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">会员批准文号</td>
						<td class="data_tb_content" height="30">
							<input name="approvalnumber" type="text" id="approvalnumber" size="25"
								value="${member.approvalnumber }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">全科合格证书/考核批准文号</td>
						<td class="data_tb_content" height="30">
							<input name="certificate" type="text" id="certificate" maxlength="100" size="25" 
								value="${member.certificate }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">资格取得方式</td>
						<td class="data_tb_content" height="30">
							<input name="getmode" type="text" id="getmode" maxlength="100" size="25"
								value="${member.getmode }" myClass='required' cannotedit='cannotedit'>
						</td>
						<td class="data_tb_alignright" height="30">所在地区</td>
						<td class="data_tb_content" height="30">
							<input name="area" type="text" id="area" maxlength="200" size="25"
								value="${member.area}" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=74   
								myClass='required'>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">会员批准日期</td>
						<td class="data_tb_content" height="30">
							<input name="approval" type="text" id="approval" maxlength="200" size="25" 
								value="${member.approval }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">全科合格年份&nbsp;</td>
						<td class="data_tb_content" height="30">
							<input name="certificdate" type="text" id="certificdate" size="25"
								value="${member.certificdate }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">人员状态</td>
						<td class="data_tb_content" height="30">正式</td>
						<td class="data_tb_alignright" height="30">离退休标志</td>
						<td class="data_tb_content" height="30">
							<input name="retirees" type="text" id="retirees" maxlength="100" size="25" 
								value="${member.retirees }" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="workState"
								myClass='required'   >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">曾用名</td>
						<td class="data_tb_content" height="30">
							<input name="loginnameex" type="text" id="loginnameex" size="25"
								value="${member.loginnameex }" >
						</td>
						<td class="data_tb_alignright" height="30">旧证书编号</td>
						<td class="data_tb_content" height="30">
							<input name="oldcrsa" type="text" id="oldcrsa" size="25" 
								value="${member.oldcrsa }" cannotedit='cannotedit'>
						</td>
						<td class="data_tb_alignright" height="30">出生日期</td>
						<td class="data_tb_content" height="30">
							<input name="borndate" type="text" id="borndate" size="25"
								value="${member.borndate }" cannotedit='cannotedit' myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">民族</td>
						<td class="data_tb_content" height="30">
							<input name="nation" type="text" id="nation" size="25" maxlength="10"
								value="${member.nation }"  
								autoWidth=190
	    						autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="mingzu" 
								myClass='required'  >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">政治面貌</td>
						<td class="data_tb_content" height="30">
							<input name="politics" type="text" id="politics" size="25"
								value = "${member.politics }" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="politic2" 
								myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">邮政编码</td>
						<td class="data_tb_content" height="30">
							<input name="postcode" type="text" id="postcode" size="25" maxlength="10" 
								value="${member.postcode }" myClass="number required" >
						</td>
						<td class="data_tb_alignright" height="30">通讯地址</td>
						<td class="data_tb_content" height="30">
							<input name="address" type="text" id="address" size="25" maxlength="200"
								value="${member.address }" myClass="required" >
						</td>
						<td class="data_tb_alignright" height="14">联系电话</td>
						<td class="data_tb_content" height="14">
							<input name="phone" type="text" id="phone" size="25" maxlength="20"
								value="${member.phone }" myClass="phone required" >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">电子邮箱</td>
						<td class="data_tb_content" height="30">
							<input name="email" type="text" id="email" size="25" maxlength="50"
								value="${member.email }" myClass="email required" >
						</td>
						<td class="data_tb_alignright" height="30">职称等级</td>
						<td class="data_tb_content" height="30">
							<input name="professional" type="text" id="professional" maxlength="20" size="25" 
								value="${member.professional }"  
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="zcdj"
								myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">学历</td>
						<td class="data_tb_content" height="30">
							<input name="diploma" type="text" id="diploma" size="25" maxlength="50"
								value="${member.diploma }" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 refer="xueli" 
								myClass='required' >
						</td>
						<td class="data_tb_alignright" height="30">学位</td>
						<td class="data_tb_content" height="30">
							<input name="degree" type="text" id="degree" size="25" maxlength="50"
								value="${member.degree }"  
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="xuewei" 
								myClass='required'>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">所学专业</td>
						<td class="data_tb_content" height="30">
							<input name="specialty" type="text" id="specialty" size="25" maxlength="50" 
								value="${member.specialty }" >
						</td>
						<td class="data_tb_alignright" height="30">毕业院校</td>
						<td class="data_tb_content" height="30">
							<input name="educational" type="text" id="educational" size="25" maxlength="50" 
								value="${member.educational }" myClass='required' >
						</td>
						<td class="data_tb_alignright" height="30">外语程度</td>
						<td class="data_tb_content" height="30">
							<input name="languagelevel" type="text" id="languagelevel" size="25" maxlength="20" 
								value="${member.languagelevel }" myClass='required' >
						</td>
						<td class="data_tb_alignright" height="30">户口所在地</td>
						<td class="data_tb_content" height="30">
							<input name="accountin" type="text" id="accountin" size="25"
								value="${member.accountin}" myClass='required' >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">工作单位&nbsp;</td>
						<td class="data_tb_content" height="30">
							<input name="workunits" type="text" id="workunits" maxlength="100" size="25" 
								value="${member.workunits }" myClass='required' >
						</td>
						<td class="data_tb_alignright" height="30">单位性质</td>
						<td class="data_tb_content" height="30">
							<input name="ownership" type="text" id="ownership" size="25" maxlength="100" 
								value="${member.ownership}"  
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="comanyquale" 
								myClass='required'>
						</td>
						<td class="data_tb_alignright" height="30">手机号</td>
						<td class="data_tb_content" height="30">
							<input name="mobile" type="text" id="mobile" size="25" maxlength="20"
								value="${member.mobile }" myClass="number required" >
						</td>
						<td class="data_tb_alignright" height="30">所属协会</td>
						<td class="data_tb_content" height="30">
							<input name="association" type="text" id="association" size="25" maxlength="20" 
								value="${member.association }" myClass='required' cannotedit='cannotedit'>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;" colspan="8" height="18"><b>年检信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="30">会员申请意见</td>
						<td class="data_tb_content" height="30" colspan="1">
							<input name="selfidea" type="text" id="selfidea" maxlength="100" size="25" 
								value="${member.selfidea }" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 
								refer="hysqyj"
								myClass='required'  
								onchange="showZHBODY();">
						</td>
						<td class="data_tb_alignright" height="30">学时数</td>
						<td class="data_tb_content" height="30">
							<input name="sxcontent" type="text" id="sxcontent" size="25"
								value="${member.sxcontent }" cannotedit='cannotedit'>
						</td>
						<td class="data_tb_alignright" height="30">是否完成继续教育</td>
						<td class="data_tb_content" height="30">
							<input name="educate" type="text" id="educate" size="25" 
								value="${member.educate }" cannotedit='cannotedit'>
						</td>
						<td class="data_tb_alignright" height="30">是否缴纳会费</td>
						<td class="data_tb_content" height="30" colspan="1">
							<input name="payfee" type="text" id="payfee" size="25"
								value="${member.payfee }" cannotedit='cannotedit'>
						</td>
					</tr>
				<tbody id="zhbody" style="display: none">
					<tr>
						<td class="data_tb_alignright" height="30">暂缓原因</td>
						<td class="data_tb_content" height="30" colspan="3">
							<input name="zhyy" type="text" id="zhyy" maxlength="100" size="25"
								value="${member.zhyy }" 
								autoWidth=190 
								autoHeight=180
								onkeydown="onKeyDownEvent();" 
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);" 
								autoid=55 
								refer="zhyy1"
								onchange="showOT()">
							<input name="otheryy" type="text" id="otheryy" size="25" value="${member.otheryy }" style="display: none; width: 300px">
						</td>
						<td class="data_tb_alignright" height="30" colspan="4"></td>
					</tr>
				</tbody>
				<tr>
					<td class="data_tb_alignright" style="text-align: left;" colspan="8" height="18"><b>年检结果</b></td>
				</tr>
				<tr>
					<td class="data_tb_alignright" height="30">注协意见</td>
					<td class="data_tb_content" height="30">
						<input name="auditidea" type="text" id="auditidea" size="25"
							value="${member.auditidea }" cannotedit='cannotedit'>
					</td>
					<td class="data_tb_alignright" height="30">注协原因</td>
					<td class="data_tb_content" height="30">
						<input name="auditreasonzx" type="text" id="auditreasonzx" size="25"
							value="${member.auditreasonzx }" cannotedit='cannotedit'>
					</td>
					<td class="data_tb_alignright" height="30">核定原因</td>
					<td class="data_tb_content" height="30">
						<input name="auditreason" type="text" id="auditreason" size="25"
							value="${member.auditreason }" cannotedit='cannotedit'>
					</td>
					<td class="data_tb_alignright" height="30">年检结论</td>
					<td class="data_tb_content" height="30" colspan="1">
						<input name="result" type="text" id="result" size="25"
							value="${member.result }" cannotedit='cannotedit'>
					</td>
				</tr>
				</tbody>
			</table>
			<br>
		</form>
	</DIV>
	<br />
	<div id="loading" style="position: absolute; width: 300px; height: 80px; z-index: 10; left: 40%; top: 18%; border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
		<div style="border: 1px solid #6595d6; padding: 5px;">
			<table>
				<tr>
					<td><img src="/scicpa/images/loading.gif"/></td>
					<td>正在提交数据，请稍候...</td>
				</tr>
			</table>
		</div>
	</div>
	
	<script type="text/javascript">
	
		showOT();
		showZHBODY();
		// 让 border = 0
		// 让 textarea被替换
		$("input").each(function(index, obj) {
			obj.readOnly = true;
			obj.className = "before";
		});
		$("textarea").each(function(index, obj) {
			obj.readOnly = true;
			obj.className = "before";
		});
	
		if ("${edit}" == "edit") {
			updateStyle();
		}
	
		//修改 input 样式
		function updateStyle() {
			// 加边框     重新加日期出来
			$("input").each(function(index, obj) {
				var cannotedit = $(obj).attr('cannotedit');
				var myClass = $(obj).attr('myClass');
				if (cannotedit != 'cannotedit') {
					if (obj.type == "button" && obj.id.indexOf("date_") >= 0) {
						obj.style.display = "";
					}
					if (obj.id == "ctype") {
						$(obj).attr('readOnly', 'readOnly');
					} else {
						$(obj).removeAttr('readOnly');
					}
					if (myClass) {
						obj.className = myClass;
					} else {
						obj.className = "";
					}
				}
			});
	
			$("textarea").each(function(index, obj) {
				if (obj.cannotedit == null) {
					obj.readOnly = false;
					obj.className = "";
				}
			});
	
			$("textarea").each(function(index, obj) {
				if (obj.cannotedit == null) {
					obj.readOnly = false;
					obj.className = "";
				}
			});
	
			$("select").each(function(index, obj) {
				if (obj.cannotedit == null) {
					obj.disabled = false;
					obj.className = "";
				}
			});
		}
	
		function saveApply() {
			
			if (!$("#thisForm").valid()) {
				alert("填写必填项！");
				return false;
			}
			
			$("#loading").show();
			
			$.ajax({
				url : "${pageContext.request.contextPath}/common/annualInspection.do?method=checkBeforApply",
				async : false,
				type : "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				data : { year : '${member.year}' },
				success : function(data) {
					if (data == "Y") {
						$("#thisForm").submit();
					}
				}
			});
		}
	
		//选择暂缓时要求填写
		function showZHBODY() {
	
			var value = $("#selfidea").val();
			if (value == '申请暂缓') {
				$("#zhbody").show();
				$("#zhyy").attr("class", "required");
			} else {
				$("#zhbody").hide();
				$("#zhyy").removeAttr("class");
				$("#zhyy").val("");
				$("#otheryy").val("");
			}
		}
		
		function showOT() {
			var value = $("#zhyy").val();
			if (value == '其他原因') {
				$("#otheryy").show();
				$("#otheryy").attr("class", "required");
			} else {
				$("#otheryy").hide();
				$("#otheryy").removeAttr("class");
				$("#otheryy").val("");
			}
		}
		//加验证
		$(document).ready(function() {
			$("#thisForm").validate();
		});
		
		function goBack() {
			window.location = "${pageContext.request.contextPath}/common/annualInspection.do?method=listMember";
		}
	</script>
	
</body>
</html>
