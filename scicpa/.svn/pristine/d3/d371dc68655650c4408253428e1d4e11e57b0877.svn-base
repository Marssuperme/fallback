<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>执业会员信息</title>
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

#preview_wrapper{
display:inline-block;
width:200px;
height:200px;
text-align: center;
}
#preview_fake{
/* 该对象用于在IE下显示预览图片*/
filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
}
#preview_size_fake{
/* 该对象只用来在IE下获得图片的原始尺寸，无其它用途*/
filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
visibility:hidden;
}
#preview{
/* 该对象用于在FF下显示预览图片*/
width:200px;
height:200px;
}

</style>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />
</head>
<body>


<form name="thisForm" method="post" action="" id="thisForm">
<input id="isaudit" name="isaudit" type="hidden" value="${userMap.isaudit }"  >
<div class="formTitle">
<span style="margin-left: 30%">
执&nbsp;&nbsp;业&nbsp;&nbsp;会&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息
<a href="${pageContext.request.contextPath}/common/attachFile/options/photoTPYS.zip" style="margin-left: 20%;font-size: 12;font-weight: lighter;color: red" >[照片处理工具下载]</a>
</span>
<br />
<br />
</div>

<DIV class=block id=search style="width: 98%;">

<H3 class=tabs id=searchtabs><A class="tab curtab" id=dgxxtab
	href="javascript:setTab('search','dgxx')">执业信息</A> <A class="tab"
	id=sjdwtab href="javascript:setTab('search','sjdw')">用户信息</A></H3>
<div class=tabcontent id="sjdw"
	style="text-align: center; display: none;"> 
	
<table height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="33%" align="left">
			<div id="xgc1">
				<input type="button" name="xgb" id="xgb" value="修  改" class="flyBT" icon="icon-edit" onclick="updateStyle();">
			</div>
		</td>
		<td width="20%">
			<div style="display: none" id="bcc1">
				<input type="button" style="display: none;" name="bcb" id="bcb" value="保  存" icon="icon-save" onclick="updatePwds();">
			</div>
		</td>
		<td width="33%" align="left">
			<div id="fhc1"><input type="button" name="next"
				value="返  回" class="flyBT" icon="icon-back" onclick="goBack();">
			</div>
		</td>
	</tr>
</table>

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
			name="ctype" type="text" id="ctype" size="20" value="${userMap.ctype }" disabled="disabled" >
		</td>
	</tr>

	<!-- 
			<tr>
				<td class="data_tb_alignright" align="left" >最后修改时间</td>
				<td colspan="2" align="left"><input class="data_tb_content" name="lastmodified" type="text" id="lastmodified"  size="20" readonly="readonly" value = "${userMap.lastmodified }"></td>
			</tr>
			<tr>
				<td class="data_tb_alignright" align="left">最后修改人</td>
				<td colspan="2" align="left"><input class="data_tb_content" name="lastpeople" type="text" id="lastpeople"  size="20" readonly="readonly" value = "${userMap.lastpeople }"></td>
			</tr>
			 -->

	<tr>
		<td class="data_tb_alignright" style="text-align: left;" colspan="3"><b>密码设置</b></td>
	</tr>

	<tr>
		<td class="data_tb_alignright" align="left">旧密码</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="pwd_old" type="password" id="pwd_old" size="20" /></td>
	</tr>
	<tr>
		<td class="data_tb_alignright" align="left">新密码</td>
		<td colspan="2" align="left"><input class="data_tb_content"
			name="pwd_one" type="password" id="pwd_one" size="20" /></td>
	</tr>
	<tr>
		<td class="data_tb_alignright" align="left">确认密码</td>
		<td colspan="2" align="left" width="80%"><input
			style="margin-right: 10px;" class="data_tb_content" name="pwd_two"
			type="password" id="pwd_two" size="20" /> 
			<!-- 
			<span id="update" style="display:none"><a href="#"
			onclick="return saveMicfo();">【 修 改 】</a></span></td>
			 -->
	</tr>

	<!-- 
			<tr>
				<td align="right" width="40%">IC卡号</td>
				<td><input name="cardid" type="text" id="cardid"  size="25"  value = "${userMap.cardid }"></td>
			</tr>
			 -->


	<!-- 
				<tr>
					<td align="right" width="40%">最后修改时间</td>
					<td><input name="lastmodified" type="text" id="lastmodified"  size="25"  value = "${userMap.lastmodified }" showcalendar="true"></td>
				</tr>
				
				<tr>
					<td align="right" width="40%">最后修改人</td>
					<td><input name="lastpeople" type="text" id="lastpeople"  size="25"  value = "${userMap.lastpeople}"></td>
				</tr>
			   -->

</table>
	<input name="lastpeople" type="hidden" id="lastpeople" size="25" value="${userSession.userMap.loginname}"> 
	<input name="lastmodified" type="hidden" id="lastmodified" size="25" value="${userMap.lastmodified}"> 
	<input name="state" type="hidden" id="state" size="25" value="${userMap.state }">
	<input name="loginname" type="hidden" id="loginname"  value="${userMap.loginname }"  >
	
</div>


<div class=tabcontent id="dgxx" style="text-align: center;"> 

<table height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="33%" align="left">
			<div id="xgc">
				<input type="button" name="xgb" id="xgb" value="修  改" class="flyBT" icon="icon-edit" onclick="updateStyle();">
			</div>
		</td>
		<td width="20%">
			<div style="display: none" id="bcc">
				<input type="button" style="display: none;" name="bcb" id="bcb" value="保  存" icon="icon-save" onclick="return saveMicfo();">
			</div>
		</td>
		<td width="33%" align="left">
			<div id="fhc"><input type="button" name="next"
				value="返  回" class="flyBT" icon="icon-back" onclick="goBack();">
			</div>
		</td>
	</tr>
</table>

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
						<td class="data_tb_alignright" width="20%" height="18">姓名<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" width="30%" height="18"><span
							id="name3">${userMap.loginname }</span></td>
						<td class="data_tb_alignright" width="50%" style="text-align: center" colspan="2" rowspan="5"
							height="111"><img id="bill" height="120" width="100" src="${pageContext.request.contextPath}${userPhotoSrc }"><br>
								<input type="text" id="myText" size="1" style="display:none"> <br>
								<span id="logospan" style="display: none;">
									<a href="#" onclick="upLoadFile();">点击上传个人照片</a><br>
									<a style="color: red">*注意：请上传蓝底免冠正面头像,格式jpg,<br>&nbsp;&nbsp;像素：宽度*高度(295*413),大小20k以下!</a>
									<!-- 
										<a href="#" onclick="deletePhoto();"><img border="0" src="${pageContext.request.contextPath}/images/del.gif"></a>
									 -->
								</span>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">性别<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" width="30%" height="21">
							<input
							name="sex" type="text" id="sex" size="25"
							value="${userMap.sex }"
							
							myClass="required"
							title="请输入性别"
							
							onfocus="onPopDivClick(this);"
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							autoid=2
							
							noinput=true
							hideresult=true
							cannotedit
							>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="21">民族</td>
						<td class="data_tb_content" width="30%" height="21">
							<input
							name="nation" type="text" id="nation" size="25" maxlength="10"
							value="${userMap.nation }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">出生日期<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" width="30%" height="39"><input
							name="borndate" type="text" id="borndate" size="25"
							value="${userMap.borndate }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" width="20%" height="39">身份证号码<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" width="30%" height="39">
							<input name="idnumber" type="text" id="idnumber" myClass="personcard" size="25"
							value="${userMap.idnumber }" cannotedit></td>
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
							<input name="degree" type="text" id="degree"  size="25" maxlength="50" value = "${userMap.degree }">	
						</td>
						<td class="data_tb_alignright" height="18">学历</td>
						<td class="data_tb_content" height="18">
							<input name="diploma" type="text" id="diploma"  size="25" maxlength="50" value = "${userMap.diploma }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">外语程度</td>
						<td class="data_tb_content" height="18">
							<input name="languagelevel" type="text" id="languagelevel"  size="25" maxlength="20" value = "${userMap.languagelevel }">
						</td>
						<td class="data_tb_alignright" height="18">政治面貌及其它</td>
						<td class="data_tb_content" height="18">
							<input name="politics" type="text" id="politics"  size="25" maxlength="20" value = "${userMap.politics }">
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>执业信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">事务所全称<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18" colspan="3">
							<input name="officename" type="text" id="officename"  size="25"  value = "${userMap.officename }" cannotedit>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">事务所代码<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18"><input cannotedit name="officecode" type="text" id="officecode"  size="25"  value = "${userMap.officecode }"></td>
						<td class="data_tb_alignright" height="18">职务</td>
						<td class="data_tb_content" height="18"><input name="post" type="text" id="post"  size="25" maxlength="50" value = "${userMap.post }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">进 所 时 间</td>
						<td class="data_tb_content" height="18"><input name="intotime" type="text" id="intotime"  size="25"  value = "${userMap.intotime }" showcalendar="true"></td>
						<td class="data_tb_alignright" height="18">是否股东或合伙人<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18">
								<select id="isshareholder" name="isshareholder" style="width: 55px;" cannotedit>
									<option value="是" <c:if test="${userMap.isshareholder == '是'}">selected</c:if> >是</option>
									<option value="否" <c:if test="${userMap.isshareholder == '否'}">selected</c:if> >否</option>
									<option value="" <c:if test="${userMap.isshareholder != '是' && userMap.isshareholder != '否'}">selected</c:if> ></option>
								</select>							
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">进所前所在单位</td>
						<td class="data_tb_content" height="18"><input name="intobefore" type="text" id="intobefore"  size="25" maxlength="100" value = "${userMap.intobefore }"></td>
						<td class="data_tb_alignright" height="18">离退休标志</td>
						<td class="data_tb_content" height="18"><input name="retirees" type="text" id="retirees" maxlength="100" size="25"  value = "${userMap.retirees }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							height="18" colspan="4"><b>资格取得信息</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">CPA证号<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18"><input name="cpano" type="text" id="cpano"  size="25"  value = "${userMap.cpano }" cannotedit></td>
						<td class="data_tb_alignright" height="18">注师批准文号<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18"><input name="cpapermitno" type="text" id="cpapermitno"  size="25"  value = "${userMap.cpapermitno }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">职称等级</td>
						<td class="data_tb_content" height="18"><input name="professional" type="text" id="professional" maxlength="20" size="25"  value = "${userMap.professional }"></td>
						<td class="data_tb_alignright" height="18">专业职称</td>
						<td class="data_tb_content" height="18"><input name="rank" type="text" id="rank"  size="25" maxlength="100" value = "${userMap.rank }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">申请时间</td>
						<td class="data_tb_content" height="18"><input name="application" type="text" id="application"  size="25"  value = "${userMap.application }" showcalendar="true"></td>
						<td class="data_tb_alignright" height="18">批准时间<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18"><input name="approve" type="text" id="approve"  size="25"  value = "${userMap.approve }" cannotedit></td>
					</tr>
					<tr style="display:none">
						<td class="data_tb_alignright" height="18">全科合格证书</td>
						<td class="data_tb_content" height="18"><input name="certificate" type="text" id="certificate"  size="25"  value = "${userMap.certificate }" cannotedit></td>
						<td class="data_tb_alignright" height="18">考核批准文号</td>
						<td class="data_tb_content" height="18"><input name="general2" type="text" id="general2"  size="25"  value = "${userMap.general }" cannotedit></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">档案存放单位<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18"><input name="filestorage" type="text" id="filestorage"  size="25"  value = "${userMap.filestorage }" cannotedit></td>
						<td class="data_tb_alignright" height="18">档案存放单位类型</td>
						<td class="data_tb_content" height="18"><input name="filetype" type="text" id="filetype" maxlength="100" size="25"  value = "${userMap.filetype }"></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">全科合格证书/考核批准文号<font color="#FF0000">&nbsp;[*]</font></td>
						<td class="data_tb_content" height="18" colspan="3">
							<input name="general" type="text" id="general"  size="25"  value = "${userMap.general }" cannotedit>
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" style="text-align: left;"
							colspan="4" height="18"><b>联系方式</b></td>
					</tr>
					<tr>
						<td class="data_tb_alignright" height="18">邮编</td>
						<td class="data_tb_content" height="18"><input name="postcode" type="text" id="postcode" maxlength="10" size="25"  value = "${userMap.postcode }" myClass="number"></td>
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
						<td class="data_tb_alignright" height="18">通信地址</td>
						<td class="data_tb_content" colSpan="3" height="18"><input name="address" type="text" id="address" maxlength="200" size="100"  value = "${userMap.address }"></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>
<!--中部表格结束--></div>

</DIV>
<input name="pwd" type="hidden" id="pwd" value="${userMap.pwd }">
<input name="ctypetabname" type="hidden" id="ctypetabname"
	value="${userMap.ctypetabname }"> <input name="userphotoname"
	type="hidden" id="userphotoname" value="${userMap.userphotoname }">



<input type="hidden" id="uploadFileName" name="uploadFileName" value="">

</form>
<form name="myForm" id="myForm" action="" method="post"	enctype="multipart/form-data" target="hidden_frame">

<input id="imageSize" name="imageSize" type="hidden" value="${imageSize}"  >
<input id="imageWidth" name="imageWidth" type="hidden" value="${imageWidth}"  >
<input id="imageHeight" name="imageHeight" type="hidden" value="${imageHeight}"  >

<div id="divBlock" style="position: absolute; width: 100%; height: 100%; top: expression(this . offsetParent . scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;">
</div>
<div id="divProduce"
	style="position: absolute; width: 400px; height: 80px; z-index: 2; left: expression(( document.body.clientWidth-550)/ 2 ); top: expression(( document.body.clientHeight-1100)/ 2 ); border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
	<!-- <div align="left" style="color: red;">*注意:照片上传后将不能更改,请上传您的真实照片</div><br> 
	<fieldset><legend><font size="2">照片上传</font></legend> <input
	type="file" id="attachments" size="50" name="attachments" /> <input
	type='submit' class="flyBT" value='确定' onclick="return upLoadSumbit();">
	<input type="button" class="flyBT" value="关闭" onclick="hiddenProDiv();">
	</fieldset>-->

<fieldset style="width: 400px; height: 50;">  
		<legend><font color="#FF0000">照片来源</font></legend>   
		<input type="file" name="attachments" id="attachments" onchange="onUploadImgChange(this)" style="width:220px;vertical-align: text-bottom;">    
		&nbsp;&nbsp;&nbsp; 
		<input type="submit" id="UploadButton" value="开始上传" class="flyBT" onclick="return upLoadSumbit();">  
		<input type="button" class="flyBT" value="取消" onclick="hiddenProDiv();">
		<br><br>
		<div style="background:#E0E0E0;width:100%;height:350px;color:#606060;overflow: hidden" >   
			<table border="0"> 
				<tr style="height: 40px">
					<td width="100px" id="PreviewImg" align="center">
						&nbsp;预&nbsp;&nbsp;览&nbsp;&nbsp;区&nbsp;
					</td>  
					<td id="MsgList" >
					</td>
				</tr>
			</table>  
			<span id="preview_wrapper"> 
			  <span id="preview_fake"> 
				  <img id="preview" onload="onPreviewLoad(this)"/>
			  </span>
			</span>  
			<img id="preview_size_fake"/> 
			 
		</div>
		
									 
		
</fieldset>

</div>

</form>
<iframe name='hidden_frame' id="hidden_frame" style='display: none'></iframe>

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
	
	$("select").each(function(index,obj){
		obj.disabled = true ;
		obj.className = "before";
	});
	 
	 //加验证
    $(document).ready(function(){
       $("#thisForm").validate();
    });

//检查密码
function updatePwd(){
	
	var pwd_old = document.getElementById("pwd_old").value;	//旧密码
	var pwd_one = document.getElementById("pwd_one").value; //新密码
	var pwd_two = document.getElementById("pwd_two").value; //确认密码
	
	//当[新密码]不用空时，就表示要修改密码
	if(pwd_one != null || pwd_one != ""){
		if(pwd_old=="" || pwd_old==null){
			alert("旧密码不能为空，请重新输入!");
			document.getElementById("pwd_old").focus();
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_two").value = "";
			return false;
		}
		if(pwd_two == ""||pwd_two==null) {
			alert("确认密码不能为空，请重新输入!");
			document.getElementById("pwd_two").focus();
			return false;
		}
		
		if(pwd_one != pwd_two ) {
			alert("【新密码】和【确认密码】不一样，请重新输入!");
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_one").focus();
			document.getElementById("pwd_two").value = "";
			return false;
		}
		
		if(pwd_one.indexOf("\\") > -1
			|| pwd_one.indexOf("/") > -1
			|| pwd_one.indexOf(":") > -1
			|| pwd_one.indexOf("*") > -1
			|| pwd_one.indexOf("?") > -1
			|| pwd_one.indexOf("\"") > -1
			|| pwd_one.indexOf("<") > -1
			|| pwd_one.indexOf(">") > -1
			|| pwd_one.indexOf("|") > -1
			|| pwd_one.indexOf("+") > -1
			|| pwd_one.indexOf("&") > -1
			|| pwd_one.indexOf("=") > -1) {

			alert("密码不能含有\/:*?\"<>|+&=等符号");
			document.getElementById("pwd_one").value = "";
			document.getElementById("pwd_one").focus();
			document.getElementById("pwd_two").value = "";
			return false;
		}
	}
	
	return true;
}

//保存
function saveMicfo(){
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	
	document.thisForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=updateSave";
	document.thisForm.target = "";
	
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	
	if(document.thisForm.fireEvent('onsubmit')){
		xgc.style.display="";
		bcc.style.display="none";
		document.thisForm.submit();
		return true;
	}else{
		return false;
	}
	 
}

//上传相片
function upLoadFile() {
	
	var isaudit = isAudit();
	if(isaudit == "1"){
		alert("照片已审核通过,不能重复上传!");
		return ;
	}

	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	var attachments =  document.getElementById("attachments");
	divObj.style.display = "";
	blockObj.style.display = "";
	attachments.value = "";
}

function hiddenProDiv() {
	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}

//保存相片
function upLoadSumbit() {
	var isaudit = isAudit();
	if(isaudit == "1"){
		alert("照片已审核通过,不能重复上传!");
		return ;
	}
	
	var fileName = document.getElementById("attachments").value;
	var ImgFileSize = document.getElementById("imageSize").value; // 取得照片的大小   
 	var ImgWidth = document.getElementById("imageWidth").value;   // 取得照片的宽度   
    var ImgHeight = document.getElementById("imageHeight").value; // 取得照片的高度
	if(fileName.indexOf(".") > -1) { 
		var photo = fileName.substr(fileName.lastIndexOf(".")+1);
		if(photo == "jpg" || photo == "JPG"){
			if(ImgFileSize>20){
				alert("允许上传照片的大小不能超过20kb!该照片的大小为:"+ImgFileSize+"kb");
				return false;
			}
			if(ImgWidth!=295){
				alert("允许上传照片的规格 像素：宽度*高度(295*413)!该照片的像素宽*高为:"+ImgWidth+"*"+ImgHeight);
				return false;
			}
			if(ImgHeight!=413){
				alert("允许上传照片的规格 像素：宽度*高度(295*413)!该照片的像素宽*高为:"+ImgWidth+"*"+ImgHeight);
				return false;
			}
			document.getElementById("uploadFileName").value = fileName ;
			var myForm = document.getElementById("myForm");
			myForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=uploadPhoto" ;
			hiddenProDiv();
			return true;
		}else{
			alert("只允许上传jpg格式照片!");
			return false;
		}
	}else {
		alert("请上传蓝底小一寸免冠正面头像，格式jpg，像素宽*高为295*413px，大小20kb以下!");
		return false;
	}

	
}


function changePhoto(srcName) {
	var attachments = document.getElementById("attachments");
	var userphotoname = document.getElementById("userphotoname");
	if(attachments.value != "") {
		document.getElementById("bill").src = "${pageContext.request.contextPath}/common/attachFile/K_Micfo/"+srcName;
		userphotoname.value = srcName;
	}
	window.location.reload(); 

}

//删除照片
function deletePhoto() {
	var userphotoname = document.getElementById("userphotoname");
	if(userphotoname.value == ""){
		alert("您没有上传任何照片!");
		return ;
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/micfo/micfo.do?method=deletePhoto&userphotoname="+userphotoname.value+"&loginid=${userMap.loginid}&ctypetabname=${userMap.ctypetabname }" ;
		oBao.open("POST",url,false);
		oBao.send();

		resText = oBao.responseText ;
		
		alert(resText);
		document.getElementById("bill").src = "${pageContext.request.contextPath}/images/administrator.png";
		userphotoname.value = "";
	}
}

//显示
function setTab(area,id) {
	var tabArea=document.getElementById(area);
	var contents=tabArea.childNodes;
	for(i=0; i<contents.length; i++) {
		if(contents[i].className=='tabcontent'){contents[i].style.display='none';}
	}
	document.getElementById(id).style.display='';
	var tabs=document.getElementById(area+'tabs').getElementsByTagName('a');
	
	for(i=0; i<tabs.length; i++) { 
		tabs[i].className='tab'; 
	}
	document.getElementById(id+'tab').className='tab curtab';
	document.getElementById(id+'tab').blur();
	
}

function changeName(odjThis){
	document.getElementById('name1').innerText=odjThis.value;
	document.getElementById('name2').innerText=odjThis.value;
	document.getElementById('name3').innerText=odjThis.value;
}


// 修改 input 样式
function updateStyle(){ 
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	xgc.style.display="none";
	bcc.style.display="";
	var xgc1 = document.getElementById("xgc1");
	var bcc1 = document.getElementById("bcc1");
	xgc1.style.display="none";
	bcc1.style.display="";
	
	// 加边框     重新加日期出来
	$("input").each(function(index,obj){ 
		if (obj.cannotedit==null){
			if (obj.type=="button" && obj.id.indexOf("date_")>=0){
				obj.style.display="";
			}
			if(obj.id == "ctype"){
				obj.readOnly = true;
			}else{
				obj.readOnly = false;
			}
			if (obj.myClass){
				obj.className = obj.myClass;
			}else{
				obj.className = "";
			}
		}	
	});
	
	$("textarea").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.readOnly = false;
			obj.className = "";
		}
	});
	
	$("select").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.disabled = false ;
			obj.className = "";
		}
	});
	
	document.getElementById("logospan").style.display="";
	//document.getElementById("update").style.display="";


	
	document.getElementById("intotime").readOnly=true;
	document.getElementById("application").readOnly=true;
	document.getElementById("approve").readOnly=true;
	
}


  //加验证
  $(document).ready(function(){
    $("#thisForm").validate();
  });


 // 返回处理 
function goBack(){
	document.thisForm.action = "${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame&param=mainFrame";
	document.thisForm.target = "mainFrame";
	document.thisForm.submit();
}

// 修改密码处理 
function updatePwds(){
	var ctypetabname = document.getElementById("ctypetabname").value;
	var pwd_old = document.getElementById("pwd_old").value;
	var pwd_one = document.getElementById("pwd_one").value;
	var pwd_two = document.getElementById("pwd_two").value;
	if(pwd_old==""){
		alert("旧密码不能为空!");
		document.getElementById("pwd_old").focus();
		return;
	}

	if(pwd_one==""){
		alert("新密码不能为空!");
		document.getElementById("pwd_one").focus();
		return;
	}

	if(pwd_two==""){
		alert("确认密码不能为空!");
		document.getElementById("pwd_two").focus();
		return;
	}
	
	if(updatePwd()){
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/micfo/micfo.do?method=updatePwds&ctypetabname="+ctypetabname+"&pwd_old="+pwd_old+"&pwd_one="+pwd_one ;
		oBao.open("POST",url,false);
		oBao.send();
	
		resText = oBao.responseText ;
		alert(resText);
	}
	
}




/*----------------------------------------   
文件上传前台控制检测程序        不兼容 IE7 IE8
  
远程照片检测功能   
检测上传文件类型   
  
　检测照片文件格式是否正确   
　检测照片文件大小   
　检测照片文件宽度   
　检测照片文件高度   
照片预览   
-----------------------------------------*/   
  
var ImgObj=new Image();                           //建立一个图像对象   
  
var AllImgExt=".jpg|.gif|.png|";      //全部照片格式类型   
var FileObj,ImgFileSize,ImgWidth,ImgHeight,FileExt,ErrMsg,FileMsg,HasCheked,IsImg;   
                                                                              //全局变量 照片相关属性   
  
/*以下为限制变量*/   
var AllowExt=".jpg|.gif|.png|";      //允许上传的文件类型,0为无限制   
                                      //每个扩展名后边要加一个"|",小写字母表示   
var AllowImgFileSize=20;    //允许上传照片文件的大小,0为无限制,单位:KB    
var AllowImgWidth=423;    //允许上传的照片的宽度,0为无限制,单位:px(像素)   
var AllowImgHeight=295;  //允许上传的照片的高度,0为无限制,单位:px(像素)   
  
HasChecked=false;   
  
function CheckProperty(obj){         //检测图像属性   
  
     FileObj=obj;   
     if(ErrMsg!=""){          //检测是否为正确的图像文件,返回出错信息并重置   
         ShowMsg(ErrMsg,false);   
         return false;                                  //返回   
     }   
  
     if(ImgObj.readyState!="complete"){//如果图像是未加载完成进行循环检测   
         setTimeout("CheckProperty(FileObj)",500);   
         return false;   
     }   
  
     ImgFileSize=Math.round(ImgObj.fileSize/1024*100)/100;   
	//取得照片文件的大小   
     ImgWidth=ImgObj.width ;                                                 //取得照片的宽度   
     ImgHeight=ImgObj.height;                                                        //取得照片的高度   
     FileMsg="\n照片大小:"+ImgWidth+"*"+ImgHeight+"px";   
     FileMsgFileMsg=FileMsg+"\n照片文件大小:"+ImgFileSize+"Kb";   
     FileMsgFileMsg=FileMsg+"\n照片文件扩展名:"+FileExt;   
  
     if(AllowImgWidth!=0&&AllowImgWidth<ImgWidth){   
         ErrMsgErrMsg=ErrMsg+"\n照片宽度超过限制.请上传宽度小于"+AllowImgWidth+"px的文件,"+   
                      "当前照片宽度为"+ImgWidth+"px";   
     }   
     if(AllowImgHeight!=0&&AllowImgHeight<ImgHeight){   
         ErrMsgErrMsg=ErrMsg+"\n照片高度超过限制.请上传高度小于"+AllowImgHeight+"px的文件,"+   
                      "当前照片高度为"+ImgHeight+"px";   
     }   
     if(AllowImgFileSize!=0&&AllowImgFileSize<ImgFileSize){   
         ErrMsgErrMsg=ErrMsg+"\n照片文件大小超过限制.请上传小于"+AllowImgFileSize+"KB的文件,"+   
                      "当前文件大小为"+ImgFileSize+"KB";   
     }   
     alert(ErrMsg);
     if(ErrMsg!=""){   
         ShowMsg(ErrMsg,false);   
     }   
     else{   
         ShowMsg(FileMsg,true);   
     }   
}   
  
ImgObj.onerror=function(){ErrMsg='\n照片格式不正确或者照片已损坏!';}
  
/*以下为显示提示信息,tf=true显示文件信息,tf=false显示错误信息,msg-信息内容*/   
function ShowMsg(msg,tf){   
     msgmsg=msg.replace("\n","<li>");   
     msgmsg=msg.replace(/\n/gi,"<li>");   
     if(!tf){   
         document.all.UploadButton.disabled=true;   
         FileObjFileObj.outerHTML=FileObj.outerHTML;   
         MsgList.innerHTML=msg;   
         HasChecked=false;   
     }   
     else{   
         document.all.UploadButton.disabled=false;   
         if(IsImg){   
             PreviewImg.innerHTML="<img src='"+ImgObj.src+"' width='60' height='60'>";
         }   
         else{   
             PreviewImg.innerHTML="非照片文件";   
         }   
         MsgList.innerHTML=msg;   
         HasChecked=true;   
     }   
}   
  
function CheckExt(obj){   
     ErrMsg="";   
     FileMsg="";   
     FileObj=obj;   
     IsImg=false;   
     HasChecked=false;   
     PreviewImg.innerHTML="预览区";   
     if(obj.value==""){return false;}   
     MsgList.innerHTML="文件信息处理中...";   
     document.all.UploadButton.disabled=true;   
     FileExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();   
     if(AllowExt!=0&&AllowExt.indexOf(FileExt+"|")==-1){                 //判断文件类型是否允许上传   
         ErrMsg="\n该文件类型不允许上传!请上传.jpg类型的文件,当前文件类型为"+FileExt;
         alert(ErrMsg);   
         //ShowMsg(ErrMsg,false);   
         MsgList.innerHTML = ErrMsg;
         return false;   
     }   
  
     if(AllImgExt.indexOf(FileExt+"|")!=-1){                   //如果是照片文件,则进行照片信息处理   
         IsImg=true;   
         ImgObj.src=obj.value;   
         CheckProperty(obj);   
         return false;   
     }   
     else{   
         FileMsg="\n文件扩展名:"+FileExt;   
         ShowMsg(FileMsg,true);   
     }   
}   
  
  
function SwitchUpType(tf){   
     if(tf){   
         str='<input type="file" name="file1" onchange="CheckExt(this)" style="width:180px;">';
     }   
     else{   
         str='<input type="text" name="file1" onblur="CheckExt(this)" style="width:180px;">';
     }   
     document.all.file1.outerHTML=str;   
     document.all.UploadButton.disabled=true;   
     MsgList.innerHTML="";   
}   



// IE7   IE8 照片预览兼容性问题
function onUploadImgChange(sender){
	if( !sender.value.match(/.jpg/i)){
	  alert("图片格式无效,只能上传 jpg 格式的照片!");
	  return false;
	}

	var objPreview = document.getElementById('preview');
	var objPreviewFake = document.getElementById('preview_fake');
	var objPreviewSizeFake = document.getElementById('preview_size_fake');
	if( sender.files &&sender.files[0] ){
		objPreview.style.display ='block';
		objPreview.style.width ='auto';
		objPreview.style.height ='auto';
	 
		// Firefox 因安全性问题已无法直接通过input[file].value
		objPreview.src =sender.files[0].getAsDataURL();
	}else if( objPreviewFake.filters){
		// IE7,IE8 在设置本地图片地址为 img.src 时出现莫名其妙的后果
		//（相同环境有时能显示，有时不显示），因此只能用滤镜来解决
		
		// IE7, IE8因安全性问题已无法直接通过 input[file].value 获取完整的文件路径
		sender.select();
		var imgSrc =document.selection.createRange().text;  
		objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= imgSrc;
		objPreviewSizeFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= imgSrc;  
		autoSizePreview( objPreviewFake,objPreviewSizeFake.offsetWidth,objPreviewSizeFake.offsetHeight );
		objPreview.style.display ='none';
	} 

    document.getElementById("imageWidth").value=objPreviewSizeFake.offsetWidth ;                                             //取得照片的宽度   
    document.getElementById("imageHeight").value=objPreviewSizeFake.offsetHeight;                                            //取得照片的高度
    
	document.getElementById("myForm").action = "${pageContext.request.contextPath}/micfo/micfo.do?method=scanPhoto";
	document.getElementById("myForm").submit();
   
}

function onPreviewLoad(sender){
	autoSizePreview(sender,sender.offsetWidth, sender.offsetHeight );
}

function autoSizePreview( objPre, originalWidth, originalHeight){
	var zoomParam = clacImgZoomParam( 300, 300, originalWidth,originalHeight);
	objPre.style.width = zoomParam.width +'px';
	objPre.style.height = zoomParam.height +'px';
	objPre.style.marginTop = zoomParam.top +'px';
	objPre.style.marginLeft = zoomParam.left + 'px';
}

function clacImgZoomParam( maxWidth, maxHeight, width, height ){
	var param = { width:width, height:height, top:0, left:0 };
	if(width>maxWidth || height>maxHeight ){
	  rateWidth = width /maxWidth;
	  rateHeight = height /maxHeight;  
	  if( rateWidth > rateHeight){
	  param.width =maxWidth;
	  param.height = height /rateWidth;
	  }else{
	  param.width = width /rateHeight;
	  param.height =maxHeight;
	  }
	}
	
	param.left = (maxWidth - param.width) / 2;
	param.top = (maxHeight - param.height) /2;
	return param;
}


// 设置照片信息
function setImageInfo(loginid,imageSize,imageWidth,imageHeight){
 	document.getElementById("imageSize").value = imageSize;     // 大小                            
 	document.getElementById("imageWidth").value = imageWidth;  //取得照片的宽度                                              
    document.getElementById("imageHeight").value = imageHeight; //取得照片的高度        
	document.getElementById("MsgList").innerHTML = "照片大小:"+imageWidth+"*"+imageHeight+"px.<br>照片文件大小:"+imageSize+"kb."; 
}

// 是否审核
function isAudit(){
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	var url="${pageContext.request.contextPath}/micfo/micfo.do?method=isAudit";
	oBao.open("POST",url,false);
	oBao.send();

	resText = oBao.responseText ;
	return resText; 
}
 
</script>
