<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>统战信息</title>

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

a:visited {text-decoration: none;}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}

.data_tb TD {
	BORDER-RIGHT: #b0c6d8 1px solid; BORDER-TOP: #b0c6d8 1px solid; PADDING-LEFT: 2px; BORDER-LEFT: #b0c6d8 1px solid; WORD-BREAK: break-all; BORDER-BOTTOM: #b0c6d8 1px solid; WORD-WRAP: break-word 
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
	BORDER-RIGHT-COLOR: #b2c9d3;
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
.dispaly {
	display: none;
}

label { width: 10em; float: left; }
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }

</style>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

</head>
<body>

<div class=tabcontent id="dbswszl" style="text-align: center;"> 
<br><br>
<form id="myform" name="myform" method="post" action="" > 
<input id="id" name="id" type="hidden" value="${pt.id}">
<input id="area" name="area" type="hidden" value="${pt.area}">

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
	 <tr>
		<td class="data_tb_alignright" style="text-align: center;" colspan="4" height="38">
			<font style="font-size: 20">人大、政协及党外代表统计信息</font>
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" colspan="4" style="text-align: left;font-size: 15px;">基础信息</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">事务所编号：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="officeCode" name="officeCode" value="${pt.officeCode}" maxlength="50" style="width: 65%;border-color: gainsboro" class="required" readonly="readonly">
		</td>
		<td class="data_tb_alignright" width="20%" height="18">所在机构：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="customerName" name="customerName" value="${pt.customerName }" maxlength="50" style="width: 75%;border-color: gainsboro" class="required" readonly="readonly">
		</td>
	</tr>
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">姓名：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="loginName" name="loginName" value="${pt.loginName}" maxlength="50" style="width: 65%" class="required">
		</td>
		<td class="data_tb_alignright" height="18">性别：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="sex" name="sex" maxlength="50" value="${pt.sex }" 
					onfocus="onPopDivClick(this);"
   					autoWidth=230
					autoHeight=180
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					autoid=55
					noinput="true"
					refer="性别" style="width: 75%" class="required">
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">联系电话：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="phone" name="phone" value="${pt.phone}" maxlength="50" style="width: 65%" onkeyup="f_moneys(this);">
		</td>
		<td class="data_tb_alignright" height="18">手机：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="mobile" name="mobile" maxlength="50" value="${pt.mobile }" style="width: 75%" class="required" onkeyup="f_moneys(this);">
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">出身日期：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="bornDate" name="bornDate" value="${pt.bornDate}" maxlength="50" style="width: 65%" class="required" showcalendar="true" onkeypress="return false;" onpaste="return false;">
		</td>
		<td class="data_tb_alignright" height="18">是否CPA：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="iscpa" name="iscpa" maxlength="50" value="${pt.iscpa }" 
					onfocus="onPopDivClick(this);"
   					autoWidth=230
					autoHeight=180
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					autoid=55
					noinput="true"
					refer="是否连续审计" style="width: 75%" class="required">
		</td>
	</tr>
		
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">学历：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18" colspan="1"> 
			<input type="text" id="diploma" name="diploma" value="${pt.diploma}" maxlength="50" 
					onfocus="onPopDivClick(this);"
   					autoWidth=200
					autoHeight=180
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					autoid=55
					noinput="true"
					refer="xueli" style="width: 24%" class="required">
		</td>
		<td class="data_tb_alignright" width="20%">民族：<font color="#FF0000">[*]</font></td>
        <td class="data_tb_content" width="30%">
        	<select id="nation" name="nation" style="width: 251px;" class="required" >
			<option value="汉族" <c:if test="${pt.nation=='汉族' }">selected</c:if> >汉族</option>
			<option value="蒙古族" <c:if test="${pt.nation=='蒙古族' }">selected</c:if> >蒙古族</option>
			<option value="回族" <c:if test="${pt.nation=='回族' }">selected</c:if> >回族</option>
			<option value="藏族" <c:if test="${pt.nation=='藏族' }">selected</c:if> >藏族</option>
			<option value="维吾尔族" <c:if test="${pt.nation=='维吾尔族' }">selected</c:if> >维吾尔族</option>
			<option value="苗族" <c:if test="${pt.nation=='苗族' }">selected</c:if> >苗族</option>
			<option value="彝族" <c:if test="${pt.nation=='彝族' }">selected</c:if> >彝族</option>
			<option value="壮族" <c:if test="${pt.nation=='壮族' }">selected</c:if> >壮族</option>
			<option value="布依族" <c:if test="${pt.nation=='布依族' }">selected</c:if> >布依族</option>
			<option value="朝鲜族" <c:if test="${pt.nation=='朝鲜族' }">selected</c:if> >朝鲜族</option>
			<option value="满族" <c:if test="${pt.nation=='满族' }">selected</c:if> >满族</option>
			<option value="侗族" <c:if test="${pt.nation=='侗族' }">selected</c:if> >侗族</option>
			<option value="瑶族" <c:if test="${pt.nation=='瑶族' }">selected</c:if> >瑶族</option>
			<option value="白族" <c:if test="${pt.nation=='白族' }">selected</c:if> >白族</option>
			<option value="土家族" <c:if test="${pt.nation=='土家族' }">selected</c:if> >土家族</option>　
			<option value="哈尼族" <c:if test="${pt.nation=='哈尼族' }">selected</c:if> >哈尼族</option>
			<option value="哈萨克族" <c:if test="${pt.nation=='哈萨克族' }">selected</c:if> >哈萨克族</option>
			<option value="傣族" <c:if test="${pt.nation=='傣族' }">selected</c:if> >傣族</option>
			<option value="黎族" <c:if test="${pt.nation=='黎族' }">selected</c:if> >黎族</option>
			<option value="傈僳族" <c:if test="${pt.nation=='傈僳族' }">selected</c:if> >傈僳族</option>
			<option value="佤族" <c:if test="${pt.nation=='佤族' }">selected</c:if> >佤族</option>
			<option value="畲族" <c:if test="${pt.nation=='畲族' }">selected</c:if> >畲族</option>
			<option value="高山族" <c:if test="${pt.nation=='高山族' }">selected</c:if> >高山族</option>
			<option value="拉祜族" <c:if test="${pt.nation=='拉祜族' }">selected</c:if> >拉祜族</option>
			<option value="水族" <c:if test="${pt.nation=='水族' }">selected</c:if> >水族</option>
			<option value="东乡族" <c:if test="${pt.nation=='东乡族' }">selected</c:if> >东乡族</option>
			<option value="纳西族" <c:if test="${pt.nation=='纳西族' }">selected</c:if> >纳西族</option>
			<option value="景颇族" <c:if test="${pt.nation=='景颇族' }">selected</c:if> >景颇族</option>
			<option value="柯尔克孜族" <c:if test="${pt.nation=='柯尔克孜族' }">selected</c:if> >柯尔克孜族</option>
			<option value="土族" <c:if test="${pt.nation=='土族' }">selected</c:if> >土族</option>
			<option value="达斡尔族" <c:if test="${pt.nation=='达斡尔族' }">selected</c:if> >达斡尔族</option>
			<option value="仫佬族" <c:if test="${pt.nation=='仫佬族' }">selected</c:if> >仫佬族</option>
			<option value="羌族" <c:if test="${pt.nation=='羌族' }">selected</c:if> >羌族</option>
			<option value="布朗族" <c:if test="${pt.nation=='布朗族' }">selected</c:if> >布朗族</option>
			<option value="撒拉族" <c:if test="${pt.nation=='撒拉族' }">selected</c:if> >撒拉族</option>
			<option value="毛难族" <c:if test="${pt.nation=='毛难族' }">selected</c:if> >毛难族</option>
			<option value="仡佬族" <c:if test="${pt.nation=='仡佬族' }">selected</c:if> >仡佬族</option>
			<option value="锡伯族" <c:if test="${pt.nation=='锡伯族' }">selected</c:if> >锡伯族</option>
			<option value="阿昌族" <c:if test="${pt.nation=='阿昌族' }">selected</c:if> >阿昌族</option>
			<option value="普米族" <c:if test="${pt.nation=='普米族' }">selected</c:if> >普米族</option>
			<option value="塔吉克族" <c:if test="${pt.nation=='塔吉克族' }">selected</c:if> >塔吉克族</option>
			<option value="怒族" <c:if test="${pt.nation=='怒族' }">selected</c:if> >怒族</option>
			<option value="乌孜别克族" <c:if test="${pt.nation=='乌孜别克族' }">selected</c:if> >乌孜别克族</option>
			<option value="俄罗斯族" <c:if test="${pt.nation=='俄罗斯族' }">selected</c:if> >俄罗斯族</option>
			<option value="鄂温克族" <c:if test="${pt.nation=='鄂温克族' }">selected</c:if> >鄂温克族</option>
			<option value="崩龙族" <c:if test="${pt.nation=='崩龙族' }">selected</c:if> >崩龙族</option>
			<option value="保安族" <c:if test="${pt.nation=='保安族' }">selected</c:if> >保安族</option>
			<option value="裕固族" <c:if test="${pt.nation=='裕固族' }">selected</c:if> >裕固族</option>
			<option value="京族" <c:if test="${pt.nation=='京族' }">selected</c:if> >京族</option>
			<option value="塔塔尔族" <c:if test="${pt.nation=='塔塔尔族' }">selected</c:if> >塔塔尔族</option>
			<option value="独龙族" <c:if test="${pt.nation=='独龙族' }">selected</c:if> >独龙族</option>
			<option value="鄂伦春族" <c:if test="${pt.nation=='鄂伦春族' }">selected</c:if> >鄂伦春族</option>
			<option value="赫哲族" <c:if test="${pt.nation=='赫哲族' }">selected</c:if> >赫哲族</option>
			<option value="门巴族" <c:if test="${pt.nation=='门巴族' }">selected</c:if> >门巴族</option>
			<option value="珞巴族" <c:if test="${pt.nation=='珞巴族' }">selected</c:if> >珞巴族</option>
			<option value="基诺族" <c:if test="${pt.nation=='基诺族' }">selected</c:if> >基诺族</option>
			<option value="其他" <c:if test="${pt.nation=='其他' }">selected</c:if> >其他</option>
			<option value="外国血统中国籍人士" <c:if test="${pt.nation=='外国血统中国籍人士' }">selected</c:if> >外国血统中国籍人士</option>
			</select>
	  </td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" height="18">工作单位：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="department" name="department" value="${pt.department}" maxlength="50" style="width: 65%" class="required">
		</td>
		<td class="data_tb_alignright" height="18">单位担任职务：</td>
		<td class="data_tb_content" height="18" >  
			<input type="text" id="departRank" name="departRank" maxlength="50" value="${pt.departRank }" style="width: 75%">
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" colspan="4" style="text-align: left;font-size: 15px;">人大政协任职情况</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">所在人大、政协名称：</td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="relation" name="relation" value="${pt.relation}" maxlength="50" style="width: 65%" >
		</td>
		<td class="data_tb_alignright" height="18">人大、政协担任职务：</td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="rank" name="rank" maxlength="50" value="${pt.rank }" style="width: 75%" >
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">已任几届：</td>
		<td class="data_tb_content" width="30%" height="18" colspan="3"> 
			<input type="text" id="rankNum" name="rankNum" value="${pt.rankNum}" maxlength="50" style="width: 24%" class="number" onkeyup="f_moneys(this);">
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" colspan="4" style="text-align: left;font-size: 15px;">加入党派情况</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">党派情况：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input type="text" id="joinParty" name="joinParty" value="${pt.joinParty }" maxlength="50" 
					onfocus="onPopDivClick(this);"
   					autoWidth=200
					autoHeight=180
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					autoid=55
					noinput="true"
					refer="politic2" style="width: 65%" class="required">
		</td>
		<td class="data_tb_alignright" height="18">党派担任职务：</td>
		<td class="data_tb_content" height="18"> 
			<input type="text" id="partyRank" name="partyRank" maxlength="50" value="${pt.partyRank }" style="width: 75%">
		</td>
		
		<tr>
			<td class="data_tb_alignright" height="18">备注：</td>
			<td class="data_tb_content" height="18" colspan="3"> 
				<textarea id="remark" name="remark" cols="105%" rows="4%" >${pt.remark }</textarea>
			</td>
		</tr>
</table>
<br>
	<span id="save_span">
		<input type="submit" id="save_btn" size="25" value="保存" icon="icon-save" onclick="f_save()">&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	<input type="button" id="back_btn" size="25" value="返回" icon="icon-back" onclick="f_goBack()"> 
	
</form>
</div>

<script type="text/javascript">

function f_view(){
	var form_obj = document.all; 
	//form的值
	for (i=0;i<form_obj.length ;i++ ) {
		e=form_obj[i];
		if (e.tagName=='INPUT' || e.tagName=='TEXTAREA') {
			e.readOnly = true ;
			e.className = "before";
			if(e.type == 'checkbox'){
				e.disabled = true ;
			}
		}
		if(e.tagName=='SELECT'){
			e.disabled= true;
			e.className = "before";
		}
		//alert(e.tagName);
		if(e.tagName == 'A'){
			e.style.display = "none";
		}
		if(e.tagName == "IMG"){
			e.style.display = "none";
		}
		
	}
		
	document.getElementById("save_span").style.display = "none";
}
var p = "${p}";
if("search"==p){
	f_view();
}

//加验证
$(document).ready(function(){
   $("#myform").validate();
});


function f_save(){
	var id = document.getElementById("id").value;
	
	if(id != null && id != ""){
		document.myform.action = "${pageContext.request.contextPath}/common/partyNo.do?method=updatePartyNoTable";
	}else{
		document.myform.action = "${pageContext.request.contextPath}/common/partyNo.do?method=addPartyNoTable";
	}
}


// 返回 
function f_goBack(){
	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/partyNo.do?method=index"; 
	document.getElementById("myform").submit(); 
}


// 验证数字
function f_moneys(t){
	t.value = t.value.replace(/[^\d\.\\-]/g,'');
} 

</script>
</body>
</html>