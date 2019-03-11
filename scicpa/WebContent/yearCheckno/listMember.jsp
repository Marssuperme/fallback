<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="zh-CN" />
	<meta name="Keywords" content="" />
	<meta name="Description" content="" />
	<title>非执业年检信息</title>
	
	<style type="text/css">
		#absolutediv {background-color: #f5f5f5; width: 100%; left: 0px;}
	</style>
	
	<c:choose>
		<c:when test="${usertype=='office' }">
			<style type="text/css">
				.waitdone_1 {color: red; background-color: #FFEFD5;}	
			</style>
		</c:when>
	</c:choose>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />

</head>
<body>

	<div id="divBlock" style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;"></div>
	<div id="divBlock2" style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 3; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;"></div>

	<iframe name="myiframe" id="myiframe" style="display: none;"></iframe>

	<div id="loading" style="position: absolute; width: 300px; height: 80px; z-index: 10; left: expression(( document.body.clientWidth-300)/2); top: expression(( document.body.clientHeight-1100)/2); border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
		<div style="border: 1px solid #6595d6; padding: 10px;">
			<table>
				<tr>
					<td><img alt="" src="/scicpa/images/loading.gif"></td>
					<td>正在提交数据，请稍候...</td>
				</tr>
			</table>
		</div>
	</div>

	<form action="" method="post" name="myform" id="myform" style="dispaly: none;">
		<div style="margin-bottom: 0.5%" id="absolutediv">
		 	&nbsp;<input id="pass1" icon='icon-add-row' type='button' onclick="go_add();" value='新增'>
			&nbsp;<input id="pass2" icon='icon-edit' type='button' onclick="goDetail('');" value='查看'>
			&nbsp;<input id="pass" icon='icon-print' type='button' onclick="printResult();" value='打印年检结果'>
			&nbsp;<input id="pass" icon="icon-excel" type="button" onclick="f_expExcel();" value="导出Excel">
		</div>
		<div style="width: 100%; overflow: scroll; height: 100% px;">
			<mt:DataGridPrintByBean name="listMemberno" />
		</div>
	</form>
	<script type="text/javascript">
	
		function goDetail(uuid) {
			var chooseValue = document.getElementById('chooseValue_listMemberno').value;
			if ((chooseValue == null || chooseValue == "") && uuid == '') {
				alert("请选择要一条的记录!");
			} else {
				chooseValue = chooseValue == '' ? uuid : chooseValue;
				window.location = "${pageContext.request.contextPath}/common/annualInspection.do?method=addAndView&uuid="
						+ chooseValue + "&operation=view&type=yckcpano";
			}
		}
		
		// 修改
		function look() {
			var chooseValue = document.getElementById('chooseValue_listMemberno').value;
			if (chooseValue == null || chooseValue == "") {
				alert("请选择要查看的记录!");
			} else {
				window.location = "${pageContext.request.contextPath}/common/yearCheck.do?method=member&uuid="
						+ chooseValue
						+ "&theyear=${theyear}&usertype=${usertype}";
			}
		}

		//新增
		function go_add() {
			var t = Math.random();
			$.ajax({
				url : "annualInspection.do?method=beforeAddApplyTable&ccc=" + t,
				async : false,
				cache : false,
				type : "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(data) {
					if (data != null && data != "" && data != 'undefined') {
						alert(data);
					} else {
						window.location.href = "${pageContext.request.contextPath}/common/annualInspection.do?method=addAndView&operation=add";
					}
				}
			});
		}

		// 导出excel
		function f_expExcel() {

			var expSql = $("#dgExpSql_listMemberno").val();
			var expDisplayColName = $("#dgExpDisplayColName_listMemberno").val();
			var expColName = $("#dgExpColName_listMemberno").val();

			if(!expSql){
				expSql = "${excelSql }";
			}
			
			$("#expSql").val(expSql);
			$("#expDisplayColName").val(expDisplayColName);
			$("#expColName").val(expColName);
			$("#fileName").val("非执业注师年检汇总");
			document.getElementById("exform1").submit();

		}
		
		//打印年检结果
		function printResult() {
			var chooseValue = document.getElementById('chooseValue_listMemberno').value;
			if (chooseValue == null || chooseValue == "") {
				alert("请选择要打印年检结果的记录!");
			} else {
				window.open("${pageContext.request.contextPath}/common/annualInspection.do?method=printResult&uuid=" + chooseValue, "_blank");
			}
		}
	</script>

	<form action="${pageContext.request.contextPath}/common/common.do?method=expExcel_1" method="post" name="exform1" id="exform1">
		<input type="hidden" id="expSql" name="expSql" value="" /> 
		<input type="hidden" id="expDisplayColName" name="expDisplayColName" value="" /> 
		<input type="hidden" id="expColName" name="expColName" value="" /> 
		<input type="hidden" id="fileName" name="fileName" value="" />
	</form>
	
</body>
</html>