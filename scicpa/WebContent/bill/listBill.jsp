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
	<title>发票申请信息</title>

	<style type="text/css">
		#absolutediv {
			background-color: #f5f5f5;
			width: 100%;
			left: 0px;
		}
	</style>
	
	<c:choose>
		<c:when test="${usertype=='office' }">
			<style type="text/css">
				.waitdone_1 {
					color: red;
					background-color: #FFEFD5;
				}	
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
			&nbsp;
			<span style="display: ${add=='noadd'?'none':''};">
				<input id="pass1" icon='icon-add-row' type='button' onclick="go_add();" value='新增'>
			</span> 
			&nbsp;<input id="pass2" icon='icon-edit' type='button' onclick="goDetail('');" value='修改'> 
			&nbsp;<input id="pass3" icon='icon-delete' type='button' onclick="go_delete();" value='删除'> 
			&nbsp;<span style="color: red">会费发票，请与所属注协联系领取。</span>
		</div>
		<div style="width: 100%; overflow: scroll; height: 100% px;">
			<mt:DataGridPrintByBean name="applyBill" />
		</div>
	</form>

	<script type="text/javascript">
	
		var year = new Date().getFullYear();
		
		//新增
		function go_add() {
			
			$.ajax({
				url : "${pageContext.request.contextPath}/common/bill.do?method=checkIfCanApply",
				async : false,
				type : "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				data : {"year" : year},
				success : function(data) {
					
					if (data == "TimeOut") {
						
						alert("不在发票申请时间内，如有疑问，请咨询省注协！");
						
					} else if(data == "UnPay"){
						
						alert(year + "年的会费未缴纳，不能申请发票！");
						
					} else if(data == "Exists"){
						
						alert(year + "年已经申请发票了, 不允许继续申请");
						
					} else if(data == "Ok"){
							
						window.location.href = "${pageContext.request.contextPath}/common/bill.do?method=addAndView&operation=add";
					
					} else{
						alert("操作错误");
					}
				}
			});
		}
		
		// 修改
		function goDetail(guid) {
			
			var chooseValue = document.getElementById('chooseValue_applyBill').value;
			
			if ((chooseValue == null || chooseValue == "") && guid == '') {
				
				alert("请选择要一条的记录!");
				
			} else {
				
				chooseValue = chooseValue == '' ? guid : chooseValue;
				
				var rs = ckeckApply("edit", chooseValue);
				
				if(rs == ""){
					return;
				}
				
				var operation = rs == "No" ? "view" : "update";
				
				window.location = "${pageContext.request.contextPath}/common/bill.do?method=addAndView"
						+ "&operation=" + operation + "&guid=" + chooseValue;
			}
		}
		
		//删除记录
		function go_delete() {
			
			var chooseValue = document.getElementById('chooseValue_applyBill').value;
			
			if (chooseValue == null || chooseValue == "") {
				
				alert("请选择要删除的记录!");
				
			} else {
				
				var rs = ckeckApply("delete", chooseValue);
				
				if(rs == "" || rs == "No"){
					return;
				}
				
				if (confirm("确定要删除该条记录?")) {
					
					$.ajax({
						url : "bill.do?method=delete",
						async : false,
						type  : "post",
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						data  : {"type" : "yckcpano", "guid" : chooseValue },
						success : function(data) {
							if (data == 1) {
								document.execCommand('Refresh');
							} else if (data == 0) {
								alert("当前操作失败，或可能该条记录不存在");
								document.execCommand('Refresh');
							} else {
								alert(data);
							}
						}
					});
				}
			}
		}
		
		// 修改，删除前检查
		function ckeckApply(type, chooseValue){
			
			var rs = "";
			
			$.ajax({
				url : "${pageContext.request.contextPath}/common/bill.do?method=checkIfCanEdit",
				async : false,
				type : "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				data : {"guid" : chooseValue, "year" : year },
				success : function(data) {
					
					if (data == "TimeOut") {
						
						alert("不在发票修改时间内，如有疑问，请咨询省注协！");
						
						rs = "No";
						
					} else if(data == "No"){
						
						var msg = type == "edit" ? "修改" : "删除";
						
						alert("该申请已提交审核, 不可" + msg);
						
						rs = data;
						
					} else if(data == "Yes"){
						
						rs = type;
						
					} else {
						alert("操作错误");
					}
				}
			});
			return rs;
		}
		
	</script>

</body>
</html>