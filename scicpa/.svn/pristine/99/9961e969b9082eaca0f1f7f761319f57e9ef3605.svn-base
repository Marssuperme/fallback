<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>非执业会员信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
<style>
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
</style>
<style>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	非&nbsp;&nbsp;执&nbsp;&nbsp;业&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息
	<span style="margin-left: 100px;vertical-align: middle;">
		<input type="button" name="next"
					value="关  闭" class="flyBT" icon="icon-delete" onclick="window.close();">
	</span> 
	</center>
<br/> 
<DIV class=block id=search style="width: 99%">
<div class=tabcontent id="sjdw" style="text-align:center;display: none;">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="data_tb" align="center">
	<tr>
		<td class="data_tb_alignright" style="text-align: left;" colspan="3"><b>用户信息</b></td>
	</tr>

	<tr>
		<td class="data_tb_alignright" align="left">登录名</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="loginid" type="text" id="loginid" size="20"
			value="${userMap.loginid }" disabled="disabled"></td>
	</tr>
	<tr>
		<td class="data_tb_alignright" align="left">会员类型</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="ctype" type="text" id="ctype" size="20" value="${userMap.ctype }" disabled="disabled">
		</td>
	</tr>

	<tr>
		<td class="data_tb_alignright" style="text-align: left;" colspan="3"><b>密码设置</b></td>
	</tr>

	<tr>
		<td class="data_tb_alignright" align="left">旧密码</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="pwd_old" type="password" id="pwd_old" size="20" /></td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" align="left">登录密码</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="pwd_one" type="password" id="pwd_one" size="20" />
		</td>
	</tr>
	<tr>
		<td class="data_tb_alignright" align="left">确认密码</td>
		<td colspan="2" align="left" width="80%"><input
			style="margin-right: 10px;" class="data_tb_content" name="pwd_two"
			type="password" id="pwd_two" size="20" /> 
		</td>
	</tr>
</table> 
</div>

<input type="hidden" name="lastmodified" id="lastmodified" vlaue="${userMap.lastmodified }">
<input type="hidden" name="lastpeople" id="lastpeople" vlaue="${userMap.lastpeople}">
<input type="hidden" name="state" id="state" vlaue="${userMap.state}">

<div class=tabcontent id="dgxx" style="text-align:center;">

<!--中部表格开始-->
<table border="0" cellSpacing="0" cellPadding="0" width="100%">
	<tbody>
		<tr>
			<td vAlign="top">
			<table style="WIDTH: 100%" class="data_tb" align="center">
				<tbody>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							width="50%" colspan="4" height="18"><b>个人信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="18">姓名</td>
						<td class="data_tb_content" width="30%" height="18"><span
							id="name3">${userMap.loginname }</span></td>
						<td class="data_tb_alignright" width="50%" style="text-align: center" colspan="2" rowspan="6"
							height="111"><img id="bill" height="120" width="100" src="${pageContext.request.contextPath}${userPhotoSrc }"><br>
								<input type="text" id="myText" size="1" style="display:none"> <br>
								<span id="logospan" style="display: none;">
									<a href="#" onclick="upLoadFile();">点击上传个人照片</a><br>
									<a style="color: red">*注意：照片上传后将不能更改,请上传您的真实照片！</a>
									<!-- 
									<a href="#" onclick="deletePhoto();"><img src="${pageContext.request.contextPath}/images/del.gif"></a>
									-->
								</span>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">性别</td>
						<td class="data_tb_content" width="30%" height="39">
							<input name="borndate" type="text" id="borndate" size="25"
							value="${userMap.sex }" cannotedit> 
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">民族</td>
						<td class="data_tb_content" width="30%" height="21"><input
							name="nation" type="text" id="nation" size="25" maxlength="10"
							value="${userMap.nation }" autoWidth=190
	    					autoHeight=180
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							autoid=55 refer="mingzu" >	
					</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">出生日期</td>
						<td class="data_tb_content" width="30%" height="39"><input
							name="borndate" type="text" id="borndate" size="25"
							value="${userMap.borndate }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">身份证号码</td>
						<td class="data_tb_content" width="30%" height="39"><input
							name="idnumber" type="text" id="idnumber" myClass="personcard" size="25"
							value="${userMap.idnumber }" cannotedit></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">户口所在地</td>
						<td class="data_tb_content" width="30%" height="39"><input
							name="accountin" type="text" id="accountin"  size="25"
							value="${userMap.accountin}" cannotedit></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">曾用身份证号&nbsp;</td>
						<td class="data_tb_content" height="18"><input name="idnumberex" type="text" id="idnumberex"  size="25"  value = "${userMap.idnumberex }" ></td>
						<td class="data_tb_alignright" height="18">曾用名</td>
						<td class="data_tb_content" height="18"><input name="loginnameex" type="text" id="loginnameex"  size="25"  value = "${userMap.loginnameex }" ></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" style="text-align: left;
							widt ="50%" colspan="4" height="18"><b>受教育信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="18">毕业学校</td>
						<td class="data_tb_content" width="30%" height="18"><input
							name="educational" type="text" id="educational" size="25" maxlength="50"
							value="${userMap.educational }"></td>
						<td class="data_tb_alignright" height="18">专业</td>
						<td class="data_tb_content" height="18">
							<input name="specialty" type="text" id="specialty"  size="25" maxlength="50" value = "${userMap.specialty }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">学位</td>
						<td class="data_tb_content" height="18">
							<input name="degree" type="text" id="degree"  size="25" maxlength="50" value = "${userMap.degree }"		
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="xuewei" >	
						</td>
						<td class="data_tb_alignright" height="18">学历</td>
						<td class="data_tb_content" height="18">
							<input name="diploma" type="text" id="diploma"  size="25" maxlength="50" value = "${userMap.diploma }" 
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="xueli" >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">外语程度</td>
						<td class="data_tb_content" height="18">
							<input name="languagelevel" type="text" id="languagelevel"  size="25" maxlength="20" value = "${userMap.languagelevel }">
						</td>
						<td class="data_tb_alignright" height="18">政治面貌及其它</td>
						<td class="data_tb_content" height="18">
							<input name="politics" type="text" id="politics"  size="25" maxlength="20" value = "${userMap.politics }" 
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="politic2" >
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>执业信息</b></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">会员证号&nbsp;</td>
						<td class="data_tb_content" height="18"><input name="crsa" type="text" id="crsa"  size="25"  value = "${userMap.crsa }" cannotedit></td>
						<td class="data_tb_alignright" height="18">会员批准文号</td>
						<td class="data_tb_content" height="18"><input name="approvalnumber" type="text" id="approvalnumber"  size="25"  value = "${userMap.approvalnumber }" cannotedit></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">合格证发放时间&nbsp;</td>
						<td class="data_tb_content" height="18"><input name="issuance" type="text" id="issuance"  size="25"  value = "${userMap.issuance }" cannotedit></td>
						<td class="data_tb_alignright" height="18">会员批准时间</td>
						<td class="data_tb_content" height="18"><input name="approval" type="text" id="approval" maxlength="200" size="25"  value = "${userMap.approval }" cannotedit></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">事务所全称</td>
						<td class="data_tb_content" height="18">
							<input name="officename" type="text" id="officename"  size="25"  value = "${userMap.officename }" cannotedit>
						</td>
						<td class="data_tb_alignright" height="18">事务所代码</td>
						<td class="data_tb_content" height="18"><input name="officecode" type="text" id="officecode"  size="25"  value = "${userMap.officecode }" cannotedit></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">职务</td>
						<td class="data_tb_content" height="18"><input name="post" type="text" id="post" maxlength="50" size="25"  value = "${userMap.post }"
									autoWidth=260
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=33 >
						</td>
						<td class="data_tb_alignright" height="18">进所时间</td>
						<td class="data_tb_content" height="18"><input name="intotime" type="text" id="intotime"  size="25"  value = "${userMap.intotime }" showcalendar="true"></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">来源&nbsp;</td>
						<td class="data_tb_content" height="18"><input name="source" type="text" id="source"  size="25"  value = "${userMap.source }" cannotedit></td>
						<td class="data_tb_alignright" height="18">所在地区</td>
						<td class="data_tb_content" height="18">
							<input name="area" type="text" id="area" maxlength="200" size="25"  value = "${userMap.area}"
						 			autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=40  >
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">进所前所在单位</td>
						<td class="data_tb_content" height="18"><input name="intobefore" type="text" id="intobefore" maxlength="100" size="25"  value = "${userMap.intobefore }"></td>
						<td class="data_tb_alignright" height="18">离退休标志</td>
						<td class="data_tb_content" height="18">
							<input name="retirees" type="text" id="retirees" maxlength="100" size="25"  value = "${userMap.retirees }"
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="workState">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>资格取得信息</b></td>
					</tr>
					<tr style="display: none">
						<td class="data_tb_alignright" height="18">  【 CPA证号 】</td>
						<td class="data_tb_content" height="18"><input name="cpano" type="text" id="cpano"  size="25"  value = "${userMap.cpano }"></td>
						<td class="data_tb_alignright" height="18">注师批准文号</td>
						<td class="data_tb_content" height="18"><input name="cpapermitno" type="text" id="cpapermitno"  size="25"  value = "${userMap.cpapermitno }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">申请时间</td>
						<td class="data_tb_content" height="18" >
							<input name="application" type="text" id="application"  size="25"  value = "${userMap.application }" showcalendar="true">
						</td>
						<td class="data_tb_alignright" height="18">考核批准文号</td>
						<td class="data_tb_content" height="18"><input name="general" type="text" id="general" maxlength="50" size="25"  value = "${userMap.general }" ></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">职称等级</td>
						<td class="data_tb_content" height="18"><input name="professional" type="text" id="professional" maxlength="20" size="25"  value = "${userMap.professional }"
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="zcdj">
					</td>
					<td class="data_tb_alignright" height="18">专业职称</td>
					<td class="data_tb_content" height="18">
						<input name="rank" type="text" id="rank"  size="25" maxlength="100" value = "${userMap.rank }" 
								autoWidth=190
		    					autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								autoid=55 refer="zyzc">
					</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">档案存放单位</td>
						<td class="data_tb_content" height="18"><input name="filestorage" type="text" id="filestorage" maxlength="100" size="25"  value = "${userMap.filestorage }"></td>
						<td class="data_tb_alignright" height="18">档案存放单位类型</td>
						<td class="data_tb_content" height="18"><input name="filetype" type="text" id="filetype" maxlength="100" size="25"  value = "${userMap.filetype }"></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">全科合格证书</td>
						<td class="data_tb_content" height="18"><input name="certificate" type="text" id="certificate" maxlength="100" size="25"  value = "${userMap.certificate }" cannotedit></td>
						<td class="data_tb_alignright" height="18">资格取得方式</td>
						<td class="data_tb_content" height="18">
							<input name="getmode" type="text" id="getmode" maxlength="100" size="25"  value = "${userMap.getmode }" 
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="zgqdfs">
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							colspan="4" height="18"><b>联系方式</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">邮编</td>
						<td class="data_tb_content" height="18"><input name="postcode" type="text" id="postcode"  size="25" maxlength="10" value = "${userMap.postcode }" myClass="number"></td>
						<td class="data_tb_alignright" height="18">电子邮箱</td>
						<td class="data_tb_content" height="18"><input name="email" type="text" id="email"  size="25" maxlength="50" value = "${userMap.email }" myClass="email"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="14">电话</td>
						<td class="data_tb_content" height="14"><input name="phone" type="text" id="phone"  size="25" maxlength="20" value = "${userMap.phone }" myClass="phone"></td>
						<td class="data_tb_alignright" height="14">手机</td>
						<td class="data_tb_content" height="14"><input name="mobile" type="text" id="mobile"  size="25" maxlength="20" value = "${userMap.mobile }" myClass="number"></td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="14">工作单位&nbsp;</td>
						<td class="data_tb_content" height="14"><input name="workunits" type="text" id="workunits" maxlength="100" size="25"  value = "${userMap.workunits }"></td>
						<td class="data_tb_alignright" height="14">单位性质</td>
						<td class="data_tb_content" height="14">
							<input name="ownership" type="text" id="ownership"  size="25" maxlength="100" value = "${userMap.ownership}"
									autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55 refer="comanyquale">
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" height="18">通信地址</td>
						<td class="data_tb_content"  height="18"><input name="address" type="text" id="address"  size="25" maxlength="200" value = "${userMap.address }"></td>
						<td class="data_tb_alignright" height="18">单位地址</td>
						<td class="data_tb_content"  height="18"><input name="unit" type="text" id="unit"  size="25" maxlength="200" value = "${userMap.unit }">
						</td>
						
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>
<!--中部表格结束-->
</div>
	
</DIV>

<c:if test="${ispunish=='Y'}">
	<div class="gridFrame"> 
	    <div style="width:100%;overflow:auto;height:100%;"> 
	    	<mt:DataGridPrintByBean name="punishList"/>
	    </div>
	</div>
</c:if>

<input name="pwd" type="hidden" id="pwd"  value="${userMap.pwd }"  >
<input name="ctypetabname" type="hidden" id="ctypetabname"  value="${userMap.ctypetabname }"  >
<input name="userphotoname" type="hidden" id="userphotoname"  value="${userMap.userphotoname }"  >
<input name="loginname" type="hidden" id="loginname"  value="${userMap.loginname }"  >

<input type="hidden" id="uploadFileName" name="uploadFileName" value="">

</form>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
</html>
<script type="text/javascript">
	// 让 border = 0
 	// 让 textarea被替换
 	$("input").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});
	
	$("textarea").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});

</script>
