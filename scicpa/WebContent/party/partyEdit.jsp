<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党员信息</title> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
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
 
 
.fieldTable td {
	border: 0px;
}
 
 
</style>
<style>
	H3.tabs {
	PADDING-LEFT: 0px! important; HEIGHT: 26px; BACKGROUND-COLOR: #e8f7fc! important
	}
	.tab {
		BORDER-RIGHT: #c1d8e0 1px solid; PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FONT-WEIGHT: normal; FLOAT: left; PADDING-BOTTOM: 0px; CURSOR: pointer; PADDING-TOP: 0px
	}
	.curtab {
		FONT-WEIGHT: bold; BACKGROUND: #fff; BORDER-RIGHT-COLOR: #b2c9d3
	}
	.block {
	BORDER-RIGHT: #b2c9d3 1px solid; BORDER-TOP: #b2c9d3 1px solid; BACKGROUND: #fff; MARGIN: 0px 0px 6px; BORDER-LEFT: #b2c9d3 1px solid; BORDER-BOTTOM: #b2c9d3 1px solid
	}
	.block H3 {
		PADDING-LEFT: 0.5em; FONT-SIZE: 1em; BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom; MARGIN: 1px 0px 0px; COLOR: #5086a5; LINE-HEIGHT: 26px
	}
	.block H3 A {
		COLOR: #5086a5
	}
	
	.before{
		border: 0px;
	}
	.after{
		border: 1px solid;
	}
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" > 
	党&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息<br/>
	</center>

<DIV class=block id=search style="height: 100%;">

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">基础资料</A> 
<c:if test="${paramopt == 'update'}">
<A class="tab " id=sjdwtab href="javascript:setTab('search','sjdw');setIframe('sjdwIframe');">党内培训</A>
<A class="tab " id=commtab href="javascript:setTab('search','comm');setIframe('commIframe');">党内奖惩</A>
<A class="tab " id=infotab href="javascript:setTab('search','info');setIframe('infoIframe');">党员信息变动经历</A>
</c:if>
</H3>

<div class=tabcontent id="dgxx" style="text-align:center;">
<table height="5%" border="0" cellspacing="0" cellpadding="0"  <c:if test="${edit.isupdate =='1' }">style="display: none;"</c:if>   >
  <tr align="center">
    <td align="left">
    	<div id="xgc">
       		<input type="button" name="xgb" id="xgb" icon="icon-edit" value="修  改" class="flyBT" onclick="updateStyle();" >
       	</div>
       	<div style="display: none" id="bcc">
   			<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="return saveCompany();" >
   		</div>
    </td>
  </tr>
</table>

<table border="0" cellSpacing="0" cellPadding="0" width="100%" bgColor="#ffffff" align="center">
  <tbody>
    <tr>
      <td height="250" vAlign="top" align="middle"><!--顶部图片结束-->
        <!--中部表格开始-->
        <table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
          <tbody>
            <tr>
              <td vAlign="top">
                <table style="WIDTH: 100%" class="data_tb" align="center">
                  <tbody>
                    <tr>
                      <td class="data_tb_alignright" width="50%" style="text-align: left;" colspan="4"><b>基础资料</b></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">党员姓名<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%">
                      <input class="required" maxlength="50" title="党员姓名"  name="partyname" id="partyname" value="${edit.partyname}" 
                      	onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this);"
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${edit.officecode}"
						hideresult=true 
						<c:if test="${paramopt == 'update'}">cannotedit</c:if>
						>
                      </td>
                      <td class="data_tb_alignright">曾用名</td>
                      <td class="data_tb_content"><input maxlength="100"  id="partynameex" name="partynameex" value="${edit.partynameex}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">所属党组织类型</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="branchtype" name="branchtype" value="${edit.branchtype}" tablename='K_PartyPost' cannotedit></td>
                      <td class="data_tb_alignright" width="20%">性别<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%">
                      	<select id="sex" name="sex" style="width: 134px" >
                      	<option value="男" <c:if test="${edit.sex=='男' }">selected</c:if> >男</option>
                      	<option value="女" <c:if test="${edit.sex=='女' }">selected</c:if> >女</option>
                      	</select>
                      </td>
                    </tr>                    
                    <tr>
                      <td class="data_tb_alignright" width="20%">党组织名称</td>
                      <td class="data_tb_content" colspan="1" ><input maxlength="100" id="branchname" name="branchname" value="${edit.branchname}" tablename='K_PartyPost' cannotedit></td>
                   	  <td class="data_tb_alignright" width="20%">是否注师</td>
                   	  <td class="data_tb_content" width="30%">
                   	  <select id="iscpa" name="iscpa" style="width: 134px" >
                      	<option value="是" <c:if test="${edit.iscpa=='是' }">selected</c:if> >是</option>
                      	<option value="否" <c:if test="${edit.iscpa=='否' }">selected</c:if> >否</option>
                      </select>
                      </td>
                    </tr>  
                    <tr>
                      <td class="data_tb_alignright" width="20%">事务所代码</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="officecode" name="officecode" value="${edit.officecode}" tablename='K_PartyPost' cannotedit></td>
                      <td class="data_tb_alignright">事务所全称</td>
                      <td class="data_tb_content">${edit.loginname}</td>
                    </tr>                    
                    <tr>
                      <td class="data_tb_alignright" width="20%">行政职务</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="post" name="post" value="${edit.post}" ></td>
                      <td class="data_tb_alignright">工作单位</td>
                      <td class="data_tb_content"><input maxlength="100"  id="department" name="department" value="${edit.department}" ></td>
                    </tr>                    
                    <tr>
                      <td class="data_tb_alignright" width="20%">身份证号<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input class="required" maxlength="100" id="idnumber" name="idnumber" value="${edit.idnumber}" ></td>
                      <td class="data_tb_alignright">证书编号</td>
                      <td class="data_tb_content"><input maxlength="100"  id="general" name="general" value="${edit.general}" ></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">民族<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%">
                      	<select id="nation" name="nation" style="width: 134px;" class="required">
						<option value="汉族" <c:if test="${edit.nation=='汉族' }">selected</c:if> >汉族</option>
						<option value="蒙古族" <c:if test="${edit.nation=='蒙古族' }">selected</c:if> >蒙古族</option>
						<option value="回族" <c:if test="${edit.nation=='回族' }">selected</c:if> >回族</option>
						<option value="藏族" <c:if test="${edit.nation=='藏族' }">selected</c:if> >藏族</option>
						<option value="维吾尔族" <c:if test="${edit.nation=='维吾尔族' }">selected</c:if> >维吾尔族</option>
						<option value="苗族" <c:if test="${edit.nation=='苗族' }">selected</c:if> >苗族</option>
						<option value="彝族" <c:if test="${edit.nation=='彝族' }">selected</c:if> >彝族</option>
						<option value="壮族" <c:if test="${edit.nation=='壮族' }">selected</c:if> >壮族</option>
						<option value="布依族" <c:if test="${edit.nation=='布依族' }">selected</c:if> >布依族</option>
						<option value="朝鲜族" <c:if test="${edit.nation=='朝鲜族' }">selected</c:if> >朝鲜族</option>
						<option value="满族" <c:if test="${edit.nation=='满族' }">selected</c:if> >满族</option>
						<option value="侗族" <c:if test="${edit.nation=='侗族' }">selected</c:if> >侗族</option>
						<option value="瑶族" <c:if test="${edit.nation=='瑶族' }">selected</c:if> >瑶族</option>
						<option value="白族" <c:if test="${edit.nation=='白族' }">selected</c:if> >白族</option>
						<option value="土家族" <c:if test="${edit.nation=='土家族' }">selected</c:if> >土家族</option>　
						<option value="哈尼族" <c:if test="${edit.nation=='哈尼族' }">selected</c:if> >哈尼族</option>
						<option value="哈萨克族" <c:if test="${edit.nation=='哈萨克族' }">selected</c:if> >哈萨克族</option>
						<option value="傣族" <c:if test="${edit.nation=='傣族' }">selected</c:if> >傣族</option>
						<option value="黎族" <c:if test="${edit.nation=='黎族' }">selected</c:if> >黎族</option>
						<option value="傈僳族" <c:if test="${edit.nation=='傈僳族' }">selected</c:if> >傈僳族</option>
						<option value="佤族" <c:if test="${edit.nation=='佤族' }">selected</c:if> >佤族</option>
						<option value="畲族" <c:if test="${edit.nation=='畲族' }">selected</c:if> >畲族</option>
						<option value="高山族" <c:if test="${edit.nation=='高山族' }">selected</c:if> >高山族</option>
						<option value="拉祜族" <c:if test="${edit.nation=='拉祜族' }">selected</c:if> >拉祜族</option>
						<option value="水族" <c:if test="${edit.nation=='水族' }">selected</c:if> >水族</option>
						<option value="东乡族" <c:if test="${edit.nation=='东乡族' }">selected</c:if> >东乡族</option>
						<option value="纳西族" <c:if test="${edit.nation=='纳西族' }">selected</c:if> >纳西族</option>
						<option value="景颇族" <c:if test="${edit.nation=='景颇族' }">selected</c:if> >景颇族</option>
						<option value="柯尔克孜族" <c:if test="${edit.nation=='柯尔克孜族' }">selected</c:if> >柯尔克孜族</option>
						<option value="土族" <c:if test="${edit.nation=='土族' }">selected</c:if> >土族</option>
						<option value="达斡尔族" <c:if test="${edit.nation=='达斡尔族' }">selected</c:if> >达斡尔族</option>
						<option value="仫佬族" <c:if test="${edit.nation=='仫佬族' }">selected</c:if> >仫佬族</option>
						<option value="羌族" <c:if test="${edit.nation=='羌族' }">selected</c:if> >羌族</option>
						<option value="布朗族" <c:if test="${edit.nation=='布朗族' }">selected</c:if> >布朗族</option>
						<option value="撒拉族" <c:if test="${edit.nation=='撒拉族' }">selected</c:if> >撒拉族</option>
						<option value="毛难族" <c:if test="${edit.nation=='毛难族' }">selected</c:if> >毛难族</option>
						<option value="仡佬族" <c:if test="${edit.nation=='仡佬族' }">selected</c:if> >仡佬族</option>
						<option value="锡伯族" <c:if test="${edit.nation=='锡伯族' }">selected</c:if> >锡伯族</option>
						<option value="阿昌族" <c:if test="${edit.nation=='阿昌族' }">selected</c:if> >阿昌族</option>
						<option value="普米族" <c:if test="${edit.nation=='普米族' }">selected</c:if> >普米族</option>
						<option value="塔吉克族" <c:if test="${edit.nation=='塔吉克族' }">selected</c:if> >塔吉克族</option>
						<option value="怒族" <c:if test="${edit.nation=='怒族' }">selected</c:if> >怒族</option>
						<option value="乌孜别克族" <c:if test="${edit.nation=='乌孜别克族' }">selected</c:if> >乌孜别克族</option>
						<option value="俄罗斯族" <c:if test="${edit.nation=='俄罗斯族' }">selected</c:if> >俄罗斯族</option>
						<option value="鄂温克族" <c:if test="${edit.nation=='鄂温克族' }">selected</c:if> >鄂温克族</option>
						<option value="崩龙族" <c:if test="${edit.nation=='崩龙族' }">selected</c:if> >崩龙族</option>
						<option value="保安族" <c:if test="${edit.nation=='保安族' }">selected</c:if> >保安族</option>
						<option value="裕固族" <c:if test="${edit.nation=='裕固族' }">selected</c:if> >裕固族</option>
						<option value="京族" <c:if test="${edit.nation=='京族' }">selected</c:if> >京族</option>
						<option value="塔塔尔族" <c:if test="${edit.nation=='塔塔尔族' }">selected</c:if> >塔塔尔族</option>
						<option value="独龙族" <c:if test="${edit.nation=='独龙族' }">selected</c:if> >独龙族</option>
						<option value="鄂伦春族" <c:if test="${edit.nation=='鄂伦春族' }">selected</c:if> >鄂伦春族</option>
						<option value="赫哲族" <c:if test="${edit.nation=='赫哲族' }">selected</c:if> >赫哲族</option>
						<option value="门巴族" <c:if test="${edit.nation=='门巴族' }">selected</c:if> >门巴族</option>
						<option value="珞巴族" <c:if test="${edit.nation=='珞巴族' }">selected</c:if> >珞巴族</option>
						<option value="基诺族" <c:if test="${edit.nation=='基诺族' }">selected</c:if> >基诺族</option>
						<option value="其他" <c:if test="${edit.nation=='其他' }">selected</c:if> >其他</option>
						<option value="外国血统中国籍人士" <c:if test="${edit.nation=='外国血统中国籍人士' }">selected</c:if> >外国血统中国籍人士</option>
						</select>
                      	<!--<input maxlength="100" onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						refer="minzu"
						hideresult=true id="nation" name="nation" value="${edit.nation}" >-->
					  </td>
                      <td class="data_tb_alignright">籍贯</td>
                      <td class="data_tb_content"><input maxlength="100"  id="birthplace" name="birthplace" value="${edit.birthplace}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">出生日期<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input showcalendar="true" maxlength="100" id="borndate" name="borndate" value="${edit.borndate}" onkeypress="return false;" onpaste="return false;"></td>
                      <td class="data_tb_alignright">是否港澳台籍</td>
                      <td class="data_tb_content">
                      	<select id="nonland" name="nonland" style="width: 134px" >
                      	<option value="香港" <c:if test="${edit.nonland=='香港' }">selected</c:if> >香港</option>
                      	<option value="澳门" <c:if test="${edit.nonland=='澳门' }">selected</c:if> >澳门</option>
                      	<option value="台湾" <c:if test="${edit.nonland=='台湾' }">selected</c:if> >台湾</option>
                      	<option value="否" <c:if test="${edit.nonland=='否' }">selected</c:if> >否</option>
                      	</select>
                      </td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">毕业学校</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="graduateschool" name="graduateschool" value="${edit.graduateschool}" ></td>
                      <td class="data_tb_alignright">专业</td>
                      <td class="data_tb_content"><input maxlength="100"  id="specialty" name="specialty" value="${edit.specialty}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">特长</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="goodat" name="goodat" value="${edit.goodat}" ></td>
                      <td class="data_tb_alignright">学历<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content">
                      	<select id="education" name="education" style="width: 134px" >
						<option value="博士" <c:if test="${edit.education=='博士' }">selected</c:if> >博士</option>
						<option value="在读博士" <c:if test="${edit.education=='在读博士' }">selected</c:if> >在读博士</option>
						<option value="硕士" <c:if test="${edit.education=='硕士' }">selected</c:if> >硕士</option>
						<option value="在读硕士" <c:if test="${edit.education=='在读硕士' }">selected</c:if> >在读硕士</option>
						<option value="本科" <c:if test="${edit.education=='本科' }">selected</c:if> >本科</option>
						<option value="大专" <c:if test="${edit.education=='大专' }">selected</c:if> >大专</option>
						<option value="中专" <c:if test="${edit.education=='中专' }">selected</c:if> >中专</option>
						<option value="其他" <c:if test="${edit.education=='其他' }">selected</c:if> >其他</option>
						<option value="" <c:if test="${edit.education=='' }">selected</c:if> ></option>
                      	</select>
                      </td>
                    </tr>   
                    <tr>
                      <td class="data_tb_alignright" width="20%">学位</td>
                      <td class="data_tb_content" width="30%">
                      	<select id="degree" name="degree" style="width: 134px" >
						<option value="博士" <c:if test="${edit.degree=='博士' }">selected</c:if> >博士</option>
						<option value="硕士" <c:if test="${edit.degree=='硕士' }">selected</c:if> >硕士</option>
						<option value="双学士" <c:if test="${edit.degree=='双学士' }">selected</c:if> >双学士</option>
						<option value="学士" <c:if test="${edit.degree=='学士' }">selected</c:if> >学士</option>
						<option value="其他" <c:if test="${edit.degree=='其他' }">selected</c:if> >其他</option>
						<option value="" <c:if test="${edit.degree=='' }">selected</c:if> ></option>
                      	</select>
                      </td>
                      <td class="data_tb_alignright">参加工作时间</td>
                      <td class="data_tb_content"><input showcalendar="true" maxlength="100"  id="workdate" name="workdate" value="${edit.workdate}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">职称</td>
                      <td class="data_tb_content" width="30%">
                      	<select id="title" name="title" style="width: 134px" >
						<option value="无" <c:if test="${edit.title=='无' }">selected</c:if> >无</option>
						<option value="高级" <c:if test="${edit.title=='高级' }">selected</c:if> >高级</option>
						<option value="中级" <c:if test="${edit.title=='中级' }">selected</c:if> >中级</option>
						<option value="初级" <c:if test="${edit.title=='初级' }">selected</c:if> >初级</option>
                      	</select>
                      </td>
                      <td class="data_tb_alignright">职称名称</td>
                      <td class="data_tb_content"><input maxlength="100"  id="titlename" name="titlename" value="${edit.titlename}" ></td>
                    </tr>  
                    <tr>
                      <td class="data_tb_content" colspan="4" align="center" >
                      <div style="width: 100%;" align="center">
                      <fieldset style="width: 80%;" >
						<legend>担任行业职务</legend>
						<table class="fieldTable"  border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
						<tr>
						<td><input type="checkbox" id="industry1" name="industry1" value="1" <c:if test="${edit.industry1==1 }">checked</c:if>>中国注册会计师协会理事</td>
						<td><input type="checkbox" id="industry2" name="industry2" value="1" <c:if test="${edit.industry2==1 }">checked</c:if>>中国注册会计师协会专业（专门）委员会委员</td>
						</tr><tr>
						<td><input type="checkbox" id="industry3" name="industry3" value="1" <c:if test="${edit.industry3==1 }">checked</c:if>>省注册会计师协会理事</td>
						<td><input type="checkbox" id="industry4" name="industry4" value="1" <c:if test="${edit.industry4==1 }">checked</c:if>>省注册会计师协会专业（专门）委员会委员</td>
						</tr>
						</table>
                      </fieldset>
                      </div>
                      </td>
                    </tr> 
                    <tr>
                      <td class="data_tb_content" colspan="4" align="center" >
                      <div style="width: 100%;" align="center">
                      <fieldset style="width: 80%;" >
						<legend>参政议政情况</legend>
						<table class="fieldTable" border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
						<tr>
						<td><input type="checkbox" id="politics1" name="politics1" value="1" <c:if test="${edit.politics1==1 }">checked</c:if>>全国人大代表</td>
						<td><input type="checkbox" id="politics2" name="politics2" value="1" <c:if test="${edit.politics2==1 }">checked</c:if>>全国政协委员</td>
						<td><input type="checkbox" id="politics3" name="politics3" value="1" <c:if test="${edit.politics3==1 }">checked</c:if>>省人大代表</td>
						<td><input type="checkbox" id="politics4" name="politics4" value="1" <c:if test="${edit.politics4==1 }">checked</c:if>>省政协委员</td>
						</tr><tr>
						<td><input type="checkbox" id="politics5" name="politics5" value="1" <c:if test="${edit.politics5==1 }">checked</c:if>>市人大代表</td>
						<td><input type="checkbox" id="politics6" name="politics6" value="1" <c:if test="${edit.politics6==1 }">checked</c:if>>市政协委员</td>
						<td><input type="checkbox" id="politics7" name="politics7" value="1" <c:if test="${edit.politics7==1 }">checked</c:if>>县/区人大代表</td>
						<td><input type="checkbox" id="politics8" name="politics8" value="1" <c:if test="${edit.politics8==1 }">checked</c:if>>县/区政协委员</td>
						</tr>
						</table>
                      </fieldset>
                      </div>
                      </td>
                    </tr>  
                    <tr>
                      <td class="data_tb_alignright" width="20%">婚姻状态</td>
                      <td class="data_tb_content" width="30%">
                      	<select id="marital" name="marital" style="width: 134px" >
                      	<option value="已婚" <c:if test="${edit.marital=='已婚' }">selected</c:if> >已婚</option>
                      	<option value="未婚" <c:if test="${edit.marital=='未婚' }">selected</c:if> >未婚</option>
                      	<option value="" <c:if test="${edit.marital=='' }">selected</c:if> ></option>
                      	</select>
                      </td>
                      
                      <td class="data_tb_alignright">职位<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content">
                      	<select id="rank" name="rank" style="width: 200px" >
                      	<option value="部门经理" <c:if test="${edit.rank=='部门经理' }">selected</c:if> >部门经理</option>
                      	<option value="从业人员" <c:if test="${edit.rank=='从业人员' }">selected</c:if> >从业人员</option>
                      	<option value="副主任会计师（含：副董事长、副总经理）" <c:if test="${edit.rank=='副主任会计师（含：副董事长、副总经理）' }">selected</c:if> >副主任会计师（含：副董事长、副总经理）</option>
                      	<option value="工勤人员" <c:if test="${edit.rank=='工勤人员' }">selected</c:if> >工勤人员</option>
                      	<option value="管理合伙人" <c:if test="${edit.rank=='管理合伙人' }">selected</c:if> >管理合伙人</option>
                      	<option value="项目经理" <c:if test="${edit.rank=='项目经理' }">selected</c:if> >项目经理</option>
                      	<option value="一般合伙人" <c:if test="${edit.rank=='一般合伙人' }">selected</c:if> >一般合伙人</option>
                      	<option value="一般注册会计师" <c:if test="${edit.rank=='一般注册会计师' }">selected</c:if> >一般注册会计师</option>
                      	<option value="主任会计师（含：董事长、总经理、法定代表人）" <c:if test="${edit.rank=='主任会计师（含：董事长、总经理、法定代表人）' }">selected</c:if> >主任会计师（含：董事长、总经理、法定代表人）</option>
						<option value="高层管理人员" <c:if test="${edit.rank=='高层管理人员' }">selected</c:if> >高层管理人员</option>
						<option value="行政管理人员" <c:if test="${edit.rank=='行政管理人员' }">selected</c:if> >行政管理人员</option>
						<option value="" <c:if test="${edit.rank=='' }">selected</c:if> ></option>                      	
                      	</select>
                      </td>
                    </tr>   
                    <tr>
                      <td class="data_tb_alignright" width="20%">人事关系所在单位名称</td>
                      <td class="data_tb_content" colspan="3" ><input maxlength="100" id="relationdepart" name="relationdepart" value="${edit.relationdepart}" size="100"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">固定电话</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="phone" name="phone" value="${edit.phone}" ></td>
                      <td class="data_tb_alignright">传真</td>
                      <td class="data_tb_content"><input maxlength="100"  id="fax" name="fax" value="${edit.fax}" ></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">手机<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="mobile" name="mobile" value="${edit.mobile}" ></td>
                      <td class="data_tb_alignright">电子邮箱</td>
                      <td class="data_tb_content"><input maxlength="100"  id="email" name="email" value="${edit.email}" ></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">通讯地址</td>
                      <td class="data_tb_content" colspan="3" ><input maxlength="100" id="address" name="address" value="${edit.address}" size="100"></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="50%" style="text-align: left;" colspan="4"><b>党籍信息</b></td>
                    </tr>  
                    <tr>
                      <td class="data_tb_alignright" width="20%">党籍状态</td>
                      <td class="data_tb_content" width="30%">
                      	<select id="partystate" name="partystate" style="width: 134px" >
                      	<option value="正式党员" <c:if test="${edit.partystate=='正式党员' }">selected</c:if> >正式党员</option>
                      	<option value="预备党员" <c:if test="${edit.partystate=='预备党员' }">selected</c:if> >预备党员</option>
                      	</select>
                      </td>
                      <td class="data_tb_alignright">入党日期</td>
                      <td class="data_tb_content"><input showcalendar="true" maxlength="100"  id="joindate" name="joindate" value="${edit.joindate}" ></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">入党介绍人1</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="introduce1" name="introduce1" value="${edit.introduce1}" ></td>
                      <td class="data_tb_alignright">入党介绍人2</td>
                      <td class="data_tb_content"><input maxlength="100"  id="introduce2" name="introduce2" value="${edit.introduce2}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">缴纳党费工资基数</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="base" name="base" value="${edit.base}" ></td>
                      <td class="data_tb_alignright">每月缴纳党费数额</td>
                      <td class="data_tb_content"><input maxlength="100"  id="amount" name="amount" value="${edit.amount}" ></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">转正年月</td>
                      <td class="data_tb_content" colspan="3" ><input showcalendar="true"  maxlength="100" id="returndate" name="returndate" value="${edit.returndate}" ></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">延迟转正原因</td>
                      <td class="data_tb_content" colspan="3" ><textarea style="width: 90%;height: 70px;" id="delayreurn" name="delayreurn" onkeyup="if(this.value.length>200)this.value=this.value.substring(0,200);">${edit.delayreurn}</textarea></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">正式组织关系所在党组织</td>
                      <td class="data_tb_content" colspan="3" >
                      	<select id="relationparty" name="relationparty" style="width: 134px" >
                      	<option value="所在会计师事务所" <c:if test="${edit.relationparty=='所在会计师事务所' }">selected</c:if> >所在会计师事务所</option>
                      	<option value="行业人才中心" <c:if test="${edit.relationparty=='行业人才中心' }">selected</c:if> >行业人才中心</option>
                      	<option value="社会人才中心" <c:if test="${edit.relationparty=='社会人才中心' }">selected</c:if> >社会人才中心</option>
                      	<option value="原工作单位" <c:if test="${edit.relationparty=='原工作单位' }">selected</c:if> >原工作单位</option>
                      	<option value="街道办事处" <c:if test="${edit.relationparty=='街道办事处' }">selected</c:if> >街道办事处</option>
                      	<option value="各级党工委" <c:if test="${edit.relationparty=='各级党工委' }">selected</c:if> >各级党工委</option>
                      	<option value="其他" <c:if test="${edit.relationparty=='其他' }">selected</c:if> >其他</option>
                      	</select>
                      </td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">所在党小组</td>
                      <td class="data_tb_content" colspan="3" ><input maxlength="100" id="inparty" name="inparty" value="${edit.inparty}" size="100"></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">党内职务<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%">
                      	<select id="partypost" name="partypost" style="width: 134px" tablename='K_PartyPost' >
                      	<option value="党委书记" <c:if test="${edit.partypost=='党委书记' }">selected</c:if> >党委书记</option>
                      	<option value="党委副书记" <c:if test="${edit.partypost=='党委副书记' }">selected</c:if> >党委副书记</option>
                      	<option value="党委委员" <c:if test="${edit.partypost=='党委委员' }">selected</c:if> >党委委员</option>
                      	<option value="总支书记" <c:if test="${edit.partypost=='总支书记' }">selected</c:if> >总支书记</option>
                      	<option value="总支副书记" <c:if test="${edit.partypost=='总支副书记' }">selected</c:if> >总支副书记</option>
                      	<option value="总支委员" <c:if test="${edit.partypost=='总支委员' }">selected</c:if> >总支委员</option>
                      	<option value="支部书记" <c:if test="${edit.partypost=='支部书记' }">selected</c:if> >支部书记</option>
                      	<option value="支部副书记" <c:if test="${edit.partypost=='支部副书记' }">selected</c:if> >支部副书记</option>
                      	<option value="支部委员" <c:if test="${edit.partypost=='支部委员' }">selected</c:if> >支部委员</option>
                      	<option value="党组成员" <c:if test="${edit.partypost=='党组成员' }">selected</c:if> >党组成员</option>
                      	<option value="" <c:if test="${edit.partypost=='' }">selected</c:if> >无</option>
                      	</select>
                      </td>
                      <td class="data_tb_alignright">是否党务工作者</td>
                      <td class="data_tb_content">
                      	<select id="isworker" name="isworker" style="width: 134px" >
                      	<option value="是" <c:if test="${edit.isworker=='是' }">selected</c:if> >是</option>
                      	<option value="否" <c:if test="${edit.isworker=='否' }">selected</c:if> >否</option>
                      	</select>
                      </td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">党内任职情况</td>
                      <td class="data_tb_content" colspan="3" ><textarea style="width: 90%;height: 70px;" id="postcontent" name="postcontent" onkeyup="if(this.value.length>200)this.value=this.value.substring(0,200);">${edit.postcontent}</textarea></td>
                    </tr>
                     <tr>
                      <td class="data_tb_alignright" width="20%">任职开始年月</td>
                      <td class="data_tb_content" width="30%"><input showcalendar="true" maxlength="100" id="posttime" name="posttime" value="${edit.posttime}" ></td>
                      <td class="data_tb_alignright">曾任党内职务</td>
                      <td class="data_tb_content">
                      	<select id="lastpost" name="lastpost" style="width: 134px" >
                      	<option value="党委书记" <c:if test="${edit.lastpost=='党委书记' }">selected</c:if> >党委书记</option>
                      	<option value="党委副书记" <c:if test="${edit.lastpost=='党委副书记' }">selected</c:if> >党委副书记</option>
                      	<option value="党委委员" <c:if test="${edit.lastpost=='党委委员' }">selected</c:if> >党委委员</option>
                      	<option value="总支书记" <c:if test="${edit.lastpost=='总支书记' }">selected</c:if> >总支书记</option>
                      	<option value="总支副书记" <c:if test="${edit.lastpost=='总支副书记' }">selected</c:if> >总支副书记</option>
                      	<option value="总支委员" <c:if test="${edit.lastpost=='总支委员' }">selected</c:if> >总支委员</option>
                      	<option value="支部书记" <c:if test="${edit.lastpost=='支部书记' }">selected</c:if> >支部书记</option>
                      	<option value="支部副书记" <c:if test="${edit.lastpost=='支部副书记' }">selected</c:if> >支部副书记</option>
                      	<option value="支部委员" <c:if test="${edit.lastpost=='支部委员' }">selected</c:if> >支部委员</option>
                      	<option value="党组成员" <c:if test="${edit.lastpost=='党组成员' }">selected</c:if> >党组成员</option>
                      	<option value="" <c:if test="${edit.lastpost=='' }">selected</c:if> >无</option>
                      	</select>
                      </td>
                    </tr> 
                  </tbody>
                </table>
              </td>
            </tr>
          </tbody>
        </table>
        <!--中部表格结束-->
      </td>
    </tr>
  </tbody>
</table>

</div>

<input name="id" type="hidden" id="id"  value="${edit.id }"  >

<input name="area" type="hidden" id="area"  value="${edit.area }"  tilte='K_PartyPost'>
<input name="branchid" type="hidden" id="branchid"  value="${edit.branchid }"  tilte='K_PartyPost branchid'>
<input name="postid" type="hidden" id="postid"  value="${edit.postid }"  tilte='K_PartyPost id'>

<div class=tabcontent  id="sjdw" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/partyBranch.do?method=training&id=${edit.id }" id="sjdwIframe" name="sjdwIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>
<div class=tabcontent  id="comm" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/partyBranch.do?method=commend&id=${edit.id }&ctype=0" id="commIframe" name="commIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>
<div class=tabcontent  id="info" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/officeInfoChange.do?tablename=K_Party&id=${edit.postid }" id="infoIframe" name="infoIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>


</DIV>

</form>

</body>
</html>
<script type="text/javascript">
 
 	// 让 border = 0
 	// 让 textarea被替换
 	$("input").each(function(index,obj){
		obj.readOnly = true ;
		if (obj.type=="checkbox"){
			obj.disabled = true ;
		}
		obj.className = "before";
	});
	
	$("select").each(function(index,obj){
		obj.disabled = true ;
		obj.className = "before";
	});
	
	$("textarea").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});
	
	//加验证
    $(document).ready(function(){
       $("#thisForm").validate({
    	   rules:{
   			   partyname:"required",
   			   sex:"required",
   			   idnumber:"required",
   			   nation:"required",
   			   borndate:"required",
   			   education:"required",
   			   rank:"required",
   			   mobile:"required"
   			  // partypost:"required"
    	   }
       });
    });

<c:if test="${paramopt == 'add'}">updateStyle();</c:if>

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

//保存
function saveCompany(){ 
	
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/party.do?method=updateSave&param=${paramopt}";	
	document.thisForm.target = "";
	
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	if(document.thisForm.fireEvent('onsubmit')){
		
		var partyname = document.getElementById("partyname").value;
		if(partyname == ""){
			alert("党员姓名不能为空");
			document.getElementById("partyname").focus();
			return false;
		}
		
		var idnumber = document.getElementById("idnumber").value;
		if(idnumber == ""){
			alert("身份证号不能为空");
			document.getElementById("idnumber").focus();
			return false;
		}
		
		xgc.style.display="";
		bcc.style.display="none";
		document.thisForm.submit();
		return true;
	}else{
		return false;
	}
}

// 修改 input 样式
function updateStyle(){ 
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	xgc.style.display="none";
	bcc.style.display="";
	
	// 加边框     重新加日期出来
	$("input").each(function(index,obj){
		if (obj.cannotedit==null){
			if (obj.type=="button" && obj.id.indexOf("date_")>=0){
				obj.style.display="";
			}
			obj.readOnly = false;
			obj.className = "";
		}
		obj.disabled = false;
	});
	
	$("textarea").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.readOnly = false;
			obj.className = "";
		}
	});
	
	$("select").each(function(index,obj){
		if (obj.cannotedit==null){
			obj.disabled = false;
			obj.className = "";
		}
	});
}

// 返回到主页 
function goBack(){
/*
	document.thisForm.action = "${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame";
	document.thisForm.target="mainFrame";
	document.thisForm.submit();
*/	
}

function isQmzs(obj){
	var officecode = document.getElementById("officecode").value;
	var url="${pageContext.request.contextPath}/common/party.do?method=getParty";
	var request = "&loginname="+obj.value+"&officecode="+officecode;
	var resText = ajaxLoadPageSynch(url,request);
	if("YES" == resText){
		alert("["+obj.value+"]已经是党员，不能新增！");
		document.getElementById("partyname").value = "";
		return ;
	}
	
	//alert(resText);
	
	var json = eval(resText)[0]; 
	document.getElementById("sex").value=json.sex==undefined ? "男" : json.sex;
	document.getElementById("nation").value=json.nation==undefined ? "" : json.nation;
	document.getElementById("borndate").value=json.borndate==null ? "" : json.borndate;
	document.getElementById("mobile").value=json.mobile==undefined ? "" : json.mobile;
	document.getElementById("idnumber").value=json.idnumber==undefined ? "" : json.idnumber;
	
	
	
	
	document.getElementById("rank").value=json.post==undefined ? "" : json.post;//职位
	document.getElementById("education").value=json.degree==undefined ? "" : json.degree;//学历
	document.getElementById("graduateschool").value=json.educational==undefined ? "" : json.educational;//学校
	document.getElementById("title").value=json.professional==undefined ? "" : json.professional;//职称
	document.getElementById("titlename").value=json.rank==undefined ? "" : json.rank;//职称名称
	
	document.getElementById("specialty").value=json.specialty==undefined ? "" : json.specialty;
	document.getElementById("degree").value=json.diploma==undefined ? "" : json.diploma;//学位
	document.getElementById("general").value=json.general==undefined ? "" : json.general;
	document.getElementById("phone").value=json.phone==undefined ? "" : json.phone;
	document.getElementById("email").value=json.email==undefined ? "" : json.email;
	document.getElementById("address").value=json.address==undefined ? "" : json.address;
	
	
	/*
	edit.put("sex",CHF.showNull((String)map.get("sex"))); //性别 sex
	edit.put("nation",CHF.showNull((String)map.get("nation")));  //民族 nation
	edit.put("borndate",CHF.showNull((String)map.get("borndate"))); // borndate //出生日期 borndate
	edit.put("rank",CHF.showNull((String)map.get("post"))); // rank //职务 post
	edit.put("mobile",CHF.showNull((String)map.get("mobile"))); // mobile //手机 mobile
	edit.put("education",CHF.showNull((String)map.get("diploma")));  //education //学历 diploma
	
	edit.put("idnumber",CHF.showNull((String)map.get("idnumber")));  //idnumber //身份证号码 idnumber
	
	edit.put("graduateschool",CHF.showNull((String)map.get("educational")));  //graduateschool //毕业学校 educational
	edit.put("specialty",CHF.showNull((String)map.get("specialty")));  //specialty //专业 specialty
	edit.put("degree",CHF.showNull((String)map.get("degree"))); // degree //学位 degree
	edit.put("general",CHF.showNull((String)map.get("cpano")));  //general //CPA证号 cpano
	edit.put("title","".equals(CHF.showNull((String)map.get("professional"))) ? "01|无" : CHF.showNull((String)map.get("professional")));  //title //职称等级 professional
	edit.put("titlename",CHF.showNull((String)map.get("rank"))); // titlename //职称名称 rank
	edit.put("phone",CHF.showNull((String)map.get("phone")));  //phone //电话 phone
	edit.put("email",CHF.showNull((String)map.get("email"))); // email //电子邮箱 email
	edit.put("address",CHF.showNull((String)map.get("address"))); // address //通信地址 address
	*/
	/*
	var project = resText.split("`|`");
	for(var i = 0;i<project.length;i++){
		if(project[i] != null && project[i] != ''){
			var vp = project[i].split("=");
			try{
				document.getElementById(vp[0]).value = vp[1];
			}catch(e){}
		}
	}
	*/
}

function setIframe(ifId) {
	var obj = document.getElementById(ifId);
	//alert(obj);
	obj.contentWindow.location.reload();
}
 
</script>
