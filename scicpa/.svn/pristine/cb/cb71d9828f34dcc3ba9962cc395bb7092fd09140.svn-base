<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员查询</title>
</head>
<style>
	
	#loginDiv {
		height:100%; 
		background-image:url('${pageContext.request.contextPath}/images/searchBG2.jpg'); 
		max-width:1258px;
		width:expression(this.Width>1258?"1258px":"auto");
	}
</style>
<body>

<form id="myForm" name="myForm" method="post" target=_blank style="margin:0px;display: inline">
	<div id="loginDiv" align="center">
		<table style="width: 320px;margin-top: 265px;margin-left: 130px;" cellspacing="10" cellpadding="5">
			<tr>
				<td style="text-align: right;">
					<font style="color: #FF7F00;font-weight: bold;font-size: 16;">用户类型：</font>
				</td>
				<td>
					<select id="userType" name="userType" style="width: 170px;">
						<option value="机构会员">机构会员</option>
						<option value="执业会员">执业会员</option>
						<option value="非执业会员">非执业会员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<font style="color: #FF7F00;font-weight: bold;font-size: 16;">用户名：</font>
				</td>
				<td>
					<input id="user" name="user" style="width: 170px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="height: 50px;">
					<span style="margin-left: 130px;">
						<span>
							<img src="${pageContext.request.contextPath}/images/searchBtn.jpg" onclick="f_search()" >
						</span>
					</span>
				</td>
			</tr>
		</table>
	</div>
</form>

</body>


<script type="text/javascript">
	function f_search(){
		var userTypeObj = document.getElementById("userType");
		var userObj = document.getElementById("user");
		if(userTypeObj.value==""){
			userTypeObj.select();
			alert("请选择用户类型！");
			return;
		}
		if(userObj.value==""){
			userObj.select();
			alert("请填写用户！");
			return;
		}
		var userTypeArray = ["机构会员","执业会员","非执业会员"];
		var userTypeTableArray = ["K_Company","K_Micfo","K_MicfoNo"];
		var methodTypeTableArray = ["goCompanyInfo","micfoBaoBei","gomicfono"];
		var id = userObj.value;
		var name = "k_company";
		var methodTemp = "goCompanyInfo";
		for(var i=0;i<userTypeArray.length;i++){
			if(userTypeObj.value == userTypeArray[i]){
				name = userTypeTableArray[i];
				methodTemp = methodTypeTableArray[i];
				break;
			}
		}
		
		var param = "&id="+id+"&name="+name+"&opt=micfoSelect";
		
		var url="${pageContext.request.contextPath}/common/content.do?method=checkUser";
		var resText = ajaxLoadPageSynch(url,param);
		if(resText=="Y"){
			document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/content.do?method="+methodTemp+param;
			document.getElementById("myForm").submit();
		}else{
			alert("不存在该用户！");
		}
	}
</script>
</html>