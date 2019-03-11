<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="zh-CN" />
	<meta name="Keywords" content="" />
	<meta name="Description" content="" />
	<title>会员缴费信息</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>
	
</head>
<body>

	<div id="divBlock" onclick="closeDiv()" style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;"></div>
	<div id='tipDiv' style="width: 200; height: 100; border: 1px blue solid; padding: 5px; display: none; position: absolute; left: 400px; top: 50px; z-index: 2;">
		<div style="background: #33CCFF; border: 1px blue solid; width: 100%; text-align: center;">
			<br /> <font style="color: red; font-size: 22px;">我已经完成操作！</font> <br />
			<br /> <input icon='icon-reflush' type='button' onclick="go_reload();" value='刷新数据'>
		</div>
	</div>
	<form method="post" name="myform" id="myform" style="dispaly: none;">
		<div style="margin-bottom: 0.5%" id="absolutediv">
			<input id="pass1" icon='icon-add-row' type='button' onclick="openDiv();" value='会费缴纳'>
		</div>
		<div style="width: 100%; overflow: scroll; height: 100% px;">
			<mt:DataGridPrintByBean name="listMemberno" />
		</div>
	</form>
	<div id="yearDiv" style="display:none; position:absolute; z-index:1; width:300px; height:120px; top:15%; left:35%; border:1px solid black; background-color: #b0c6d8">
		<center style="margin:10%">请选择年度：<select id="years" style="width:60px"></select></center>
		<center>
			<input type="button" onclick="go_add();" value="确认"/>
			<input type="button" onclick="closeDiv();" value="取消"/>
		</center>
	</div>
	<input type="hidden" id="selectedYear" />
	<script type="text/javascript">
	
		// 下拉年度：当前年度~前10年
		var currYear = "${currYear}";
		var years = "";
		var year;
		for(var i = 0; i < 10; i++ ){
			year = currYear - i;
			years += "<option value='" + year + "'>" + year + "</option>"
		}
		$("#years").append(years);
	
		function openDiv(){
			$("#yearDiv").show();
			$("#divBlock").show();
		}
	
		function closeDiv(){
			$("#yearDiv").hide();
			$("#divBlock").hide();
		}
		
		function go_add(){
			
			closeDiv();
			
			var year = $("#years").val();
			var t = Math.random();
			
			$.ajax({
				url:"${pageContext.request.contextPath}/common/annualInspection.do?method=checkIsPayDate&ccc="+t,
				async:false,
				type: "post", 
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{"year":year},
				success:function(data){
					
					if(data == "unFinished"){
						
						alert("请先完成"+(year-1)+"年度继续教育");
						
					}else if(data == "timeOut"){
						
						alert("不在会费缴纳时间内，如有疑问，请咨询省注协！");
						
					}else if(data == "paid"){
						
						alert("本年度您已经缴费了");
								
					}else{
						
						$("#selectedYear").val(year);
						$("#divBlock").css("display","");
						$("#tipDiv").css("display","");
						window.open("${pageContext.request.contextPath}/common/yeepay/sendPay_01.jsp");
					}
				}
			}); 
		}
		
		function go_reload(){
			
			window.location.href="${pageContext.request.contextPath}/common/annualInspection.do?method=listYeepay";
			
			/* var year = $("#selectedYear").val();
			var t = Math.random();
			$.ajax({
				url:"${pageContext.request.contextPath}/common/annualInspection.do?method=checkIsPaid&ttt="+t,
				async:false,
				type: "post", 
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{"year":year}, 
				success:function(data){
					if(data=="1"){
						var flag = confirm("缴费成功，本年度年检已通过，是否查看年检信息？\n年检内容如有修改，请及时联系省注协");
						if(flag){
							window.location.href="${pageContext.request.contextPath}/common/annualInspection.do?method=listMember";
						}else{
							window.location.href="${pageContext.request.contextPath}/common/annualInspection.do?method=listYeepay";
						}
					}else{
						window.location.href="${pageContext.request.contextPath}/common/annualInspection.do?method=listYeepay";
					}
				}
			});  */
		}
	</script>
	
</body>
</html>