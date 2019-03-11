<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会费缴纳登记</title>
<style>
	#tb {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;text-align:center;width:90%;margin:20 0px;}
	#tb td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	#tb input{border:0px;border-bottom:1px solid #aaa;width:100%;margin:0 10px; }
	#desc {height : 27px ;line-height: 27px ;color: #125908 ;font-size: 14px;font-weight: bold;padding-left: 5px;}
	.titleTd{background-color: #eff7e2;font-size: 13px;font-family:"宋体";}
	.otherinput{border:0px;border-bottom:1px solid #aaa;margin-right: 100px;}
	a:visited{color:blue} 
	.error{color: red;}
	
	#tb2 {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;text-align:center;width:90%;margin:20 0px;}
	#tb2 td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	#tb2 input{border:0px;border-bottom:1px solid #aaa;width:100%;margin:0 10px; }
	
	
</style>
</head>
<body style="height:100%;">
	<form id="thisForm" name="thisForm" method="post">
		<div id="desc">请录入会费缴纳信息：</div>
		<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
		事务所名称：<input type="text" readonly="readonly" id="departname" name="departname" title="请输入事务所名称"
				 class="required" size="70" value="${departname}" style="border:0px;border-bottom:1px solid #aaa;">
		    <span style="margin-left:150px;">
				会费年度：<input type="text" id="iyear" name="iyear" class="required" value="${iyear}" style="border:0px;border-bottom:1px solid #aaa;" title="请输入会费缴纳年度">
			</span>
		<input type="hidden" id="departCode" name="departCode" value="${officeCode}">
		
		
		
		<table id="tb2" cellpadding="5" cellspacing="0" >
			<tr>
				<td width="17%" class="titleTd">总收入(元)</td>
				<td width="17%" class="titleTd">应缴团体会费(元)</td>
				<td width="17%" class="titleTd">CPA人数</td>
				<td width="17%" class="titleTd">应缴个人会费(元)</td>
				<td class="titleTd" colspan="2">总计(元)</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><input type="text" id="totalIncome" name="totalIncome" value="${pay.totalIncome}" class="required number"  title="请输入有效的金额"></td>
				<td><input type="text" id="groupCost" name="groupCost" value="${pay.groupCost}" onkeyup="getSum();" class="required number"  title="请输入有效的金额"></td>
				<td><input type="text" id="cpaCount" name="cpaCount" style="text-align: center;" readonly="readonly" value="${cpaCount}"></td>
				<td><input type="text" id="memberCost" name="memberCost" value="${pay.memberCost}" readonly="readonly" ></td>
				<td colspan="2"><input type="text" id="total" name="total" value="${pay.total}" class="required number" ></td>
			</tr>
			<tr>
				<td class="titleTd">备注</td>
				<td colspan="5"><input type="text" id="pmemo" name="pmemo" value="${pay.memo}"></td>
			</tr>
			<tr>
				<td colspan="6" align="center" class="titleTd">CPA详细信息&nbsp;&nbsp;
					<!-- <a href="###" onclick="addLine();">【点击追加CPA信息】</a>  -->
				</td>
			</tr>
			<tr>
				<td class="titleTd" width="17%">CPA证书号</td>
				<td class="titleTd" width="17%">姓名</td>
				<td class="titleTd" width="17%">性别</td>
				<td class="titleTd" width="17%">职务</td>
				<td class="titleTd" width="17%">备注</td>
				<td class="titleTd" width="5%">操作</td>
			</tr>
		</table>
		
		<div style="overflow: auto;height:200px;width:90%;margin-top: -20px">
		<table id="tb" cellpadding="5" cellspacing="0" style="margin: 0px;width: 100%">
			<c:forEach items="${payDetailList}" var="payDetail">
			<tr>
				<td width="17%"><input type="text" name="cpaId" value="${payDetail.cpaid}" readonly="readonly" class="required" ></td>
				<td width="17%" ><input type="text" name="userName" value="${payDetail.username}" readonly="readonly" class="required"></td>
				<td width="17%" ><input type="text" name="sex" style="text-align: center;" readonly="readonly" value="${payDetail.sex}"></td>
				<td width="17%" ><input type="text" name="dutylevel" value="${payDetail.dutylevel}"></td>
				<td width="17%"><input type="text" name="memo" value="${payDetail.memo}"></td>
				<td width="5%"><a href="###" onclick="removeLine(this);">【删除】</a></td>
			</tr>
			</c:forEach>
		</table> 
		</div>
		<center>
			<input type="button" icon='icon-save' name="next" value="保存"  onclick="return goSave();" >&nbsp;&nbsp;
			<input type="button" icon='icon-back' name="next" value="返回"  onclick="window.history.back();" >
		</center>
		
	</form>
</body>

<script type="text/javascript"> 

	$(function (){$("#thisForm").validate({
		errorClass: "error",
		errorElement: "div"
	});})
	
	function goSave() {
		var iyear = $("#iyear").val();
		var property = "${pay.property}" ;
		
		var url = "${pageContext.request.contextPath}/company/costpay.do?method=isCostPayExist&iyear="+iyear;
		if(confirm("请确认填报无误!")){
			if("${pay.UUID}" == "") {
				//新增,判断一下是否存在
				document.thisForm.action = "${pageContext.request.contextPath}/company/costpay.do?method=save" ;
				$.post(url,null,function(resText){
					if(resText != "") {
						if(resText == "已缴费") {
							alert("您本年缴费已经填报，并经省注协确认，不能重复录入!");
							return false ;
						}
						if(confirm("已有"+iyear+"年记录，保存会覆盖原先记录，是否保存？")) {
							if (document.thisForm.fireEvent('onsubmit'))
								document.thisForm.submit();
						}
					}else {
						if (document.thisForm.fireEvent('onsubmit'))
							document.thisForm.submit();
					}
				});
			}else {
				if(property == "已缴费") {
					alert("您本年缴费已经省注协确认，不允许保存!");
					return false ;
				}
				document.thisForm.action = "${pageContext.request.contextPath}/company/costpay.do?method=save&UUID=${pay.UUID}";
				if (document.thisForm.fireEvent('onsubmit'))
					document.thisForm.submit();
			}
		}
	}
	
	function addLine(){
	  //$('#get').append("<tr><td class='serial'><input type='text' name='cpaId' class='required'></td><td><input type='text' name='userName' class='required'></td>"
	  //					+"<td><input type='text' name='sex' onfocus='onPopDivClick(this);' onkeyup='onKeyUpEvent();' onclick='onPopDivClick(this);' autoid=2 hideresult=true norestorehint=true></td>"
	  //					+"<td><input type='text' name='dutylevel' ></td><td><input type='text' name='memo' ></td>"
	  //					+"<td><a href='###' onclick='removeLine(this);'>【删除】</a></td></tr>");
	  
	  var cpacount = parseInt($("#cpaCount").val())+1;
	  $("#cpaCount").val(cpacount) ;
	}
	
	function removeLine(obj){
	  var $delLine = $(obj).parent("td").parent("tr") ; 
	  $delLine.remove();
	  var cpacount = parseInt($("#cpaCount").val())-1;
	  $("#cpaCount").val(cpacount) ;
	  // 应缴个人费用
	  $("#memberCost").val(cpacount*1000);
	  // 总计
	  $("#total").val($("#memberCost").val()*1+$("#groupCost").val()*1).toFixed(2);
	  
   }
   
   function getSum(){
	 var groupCost =  $("#groupCost").val() ;
	 var memberCost =  $("#memberCost").val() ;
	 
	 if(groupCost == "") {
	 	groupCost = "0";
	 }
	 if(memberCost == "") {
	 	memberCost = "0";
	 }
	 var tl = (groupCost*1+memberCost*1).toFixed(2);
	 $("#total").val(tl);
   }

   if("${pay.UUID}"=="" || "${pay.UUID}"==null){
	   // 应缴个人费用
	   var cpaCount = "${cpaCount}";
	   if(isNaN(cpaCount)){
	   		document.getElementById("memberCost").value = "0";
	   		document.getElementById("cpaCount").value = "0";
	   }else{
	   		document.getElementById("memberCost").value = 1000*cpaCount;
	   		document.getElementById("total").value = 1000*cpaCount;
	   }
   }
       
</script>
</html>
