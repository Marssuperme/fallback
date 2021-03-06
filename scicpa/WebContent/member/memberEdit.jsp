<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>团员信息</title> 
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
	.required{
		border:0 px;
	}
	.isnull{
		border:1px solid red;
	}
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" > 
	团&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息<br/>
	</center>

<DIV class=block id=search style="height: 100%;">

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">基础资料</A> 
<!-- 
<c:if test="${paramopt == 'update'}">
<A class="tab " id=sjdwtab href="javascript:setTab('search','sjdw');setIframe('sjdwIframe');">团内培训</A>
<A class="tab " id=commtab href="javascript:setTab('search','comm');setIframe('commIframe');">团内奖惩</A>
<A class="tab " id=infotab href="javascript:setTab('search','info');setIframe('infoIframe');">团员信息变动经历</A>
</c:if>
 -->
</H3>

<div class=tabcontent id="dgxx" style="text-align:center;">
<table height="5%" border="0" cellspacing="0" cellpadding="0"  <c:if test="${edit.isupdate =='1' }">style="display: none;"</c:if>   >
  <tr align="center">
    <td align="left">
    	<div id="xgc">
       		<input type="button" name="xgb" id="xgb" icon="icon-edit" value="修  改" class="flyBT" onclick="updateStyle();" >
       		<span style="display:${goBackHidden}">
       			<input type="button" icon="icon-back" name="fhBtn" id="fhBtn" value="返  回"  class="flyBT" onclick="goBack();">
       		</span>
       	</div>
       	<div style="display: none" id="bcc">
   			<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="return saveCompany();" >
   			<span style="display:${goBackHidden}">
		   		<input type="button" icon="icon-back" name="fhBtn" id="fhBtn" value="返  回"  class="flyBT" onclick="goBack();">
   			</span>
   		</div>
    </td>
  </tr>
</table>

<table border="0" cellSpacing="0" cellPadding="0" width="100%" bgColor="#ffffff" align="center">
  <tbody>
    <tr>
      <td height="100%" vAlign="top" align="middle"><!--顶部图片结束-->
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
                      <td class="data_tb_alignright" width="20%">团员姓名<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%">
                   	  <input type="hidden" id="memberid" name="memberid" value="${edit.memberid }"/>
                      <input class="required" maxlength="50" title="党员姓名"  name="membername" id="membername" value="${edit.membername}" 
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
					  <td class="data_tb_alignright" width="20%">是否注师</td>
                         <td class="data_tb_content" width="30%">
                      	  <select id="isCicpa" name="isCicpa" style="width: 134px" >
                      	  	<option value="是" <c:if test="${edit.iscicpa=='是' }">selected</c:if> >是</option>
                      	  	<option value="否" <c:if test="${edit.iscicpa=='否' }">selected</c:if> >否</option>
                     	  </select>
                      </td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">事务所代码</td>
                      <td class="data_tb_content" width="30%"><input maxlength="100" id="officecode" name="officecode" value="${edit.officecode}" tablename='K_memberPost' cannotedit></td>
                      <td class="data_tb_alignright">事务所全称</td>
                      <td class="data_tb_content"><input maxlength="100" id="officename" name="officename" value="${edit.loginname}" tablename='K_memberPost' cannotedit></td>
                    </tr>                    
                    <tr>
                      <td class="data_tb_alignright" width="20%">民族</td>
                      <td class="data_tb_content" width="30%">
                      	<select id="nation" name="nation" style="width: 134px;"   >
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
					  <td class="data_tb_alignright" width="20%">性别</td>
                         <td class="data_tb_content" width="30%">
                      	  <select id="sex" name="sex" style="width: 134px" >
	                      	<option value="男" <c:if test="${edit.sex=='男' }">selected</c:if> >男</option>
	                      	<option value="女" <c:if test="${edit.sex=='女' }">selected</c:if> >女</option>
                     	  </select>
                      </td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">出生日期<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input showcalendar="true" maxlength="100" id="borndate" name="borndate" value="${edit.borndate}" onkeypress="return false;" onpaste="return false;"></td>
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
						<option value="" <c:if test="${empty edit.education}">selected</c:if> ></option>
                      	</select>
                      </td>
                    </tr> 
                    <tr>
                     <td class="data_tb_alignright" width="20%">是否团干部</td>
                      <td class="data_tb_content" width="30%">
                     	 <select id="isMemberCadre" name="isMemberCadre" style="width: 134px" onchange="changeDisabled();">
                     	 	<option value="否" <c:if test="${edit.ismembercadre=='否' }">selected</c:if> >否</option>
                     	 	<option value="是" <c:if test="${edit.ismembercadre=='是' }">selected</c:if> >是</option>
                     	 </select>
                      </td>
                      <td class="data_tb_alignright">职位<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content">
                      	<select id="rank" name="rank" style="width: 134px" >
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
						<option value="" <c:if test="${empty edit.rank}">selected</c:if> ></option>
                      	</select>
                      </td>
                    </tr> 
                    <tr>
                       <td class="data_tb_alignright" width="20%">团内职务</td>
                       <td class="data_tb_content" width="30%">
                      	<select id="memberpost" name="memberpost" style="width: 134px">
	                      	<option value="书记" <c:if test="${edit.memberpost=='书记' }">selected</c:if> >书记</option>
	                      	<option value="副书记" <c:if test="${edit.memberpost=='副书记' }">selected</c:if> >副书记</option>
	                      	<option value="委员" <c:if test="${edit.memberpost=='委员' }">selected</c:if> >委员</option>
	                      	<option value="副委员" <c:if test="${edit.memberpost=='副委员' }">selected</c:if> >副委员</option>                      	
	                      	<option value="理事" <c:if test="${edit.memberpost=='理事' }">selected</c:if> >理事</option>
	                      	<option value="团务工作者" <c:if test="${edit.memberpost=='团务工作者' }">selected</c:if> >团务工作者</option>
	                      	<option value="无" <c:if test="${edit.memberpost=='无' || empty edit.memberpost}">selected</c:if> >无</option>
                      	</select>
                       </td>
                       <td class="data_tb_alignright" width="20%">手机<font color="#FF0000">&nbsp;[*]</font></td>
                       <td class="data_tb_content" width="30%"><input maxlength="100" id="mobile" name="mobile" value="${edit.mobile}" onkeyup="f_moneys(this);" readonly="readonly"></td>                      
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

<input name="area" type="hidden" id="area"  value="${edit.area }"  tilte='K_memberPost'>
<input name="branchid" type="hidden" id="branchid"  value="${edit.branchid }"  tilte='K_memberPost branchid'>
<input name="postid" type="hidden" id="postid"  value="${edit.postid }">

<div class=tabcontent  id="sjdw" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/memberBranch.do?method=training&id=${edit.id }" id="sjdwIframe" name="sjdwIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>
<div class=tabcontent  id="comm" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/memberBranch.do?method=commend&id=${edit.id }&ctype=0" id="commIframe" name="commIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>
<div class=tabcontent  id="info" style="text-align:center;display: none;width:100%;height:100%;overflow: hidden;" >
<iframe src="${pageContext.request.contextPath}/common/officeInfoChange.do?tablename=K_member&id=${edit.postid }" id="infoIframe" name="infoIframe" frameborder="0" width="100%" style="height:800;" scrolling="no"></iframe>
</div>


</DIV>

</form>

</body>
</html>
<script type="text/javascript">
	function changeDisabled(){
		if(document.getElementById("isMemberCadre").value!="是"){
			document.getElementById("memberpost").value="";
			document.getElementById("memberpost").disabled="disabled";
		}else{
			document.getElementById("memberpost").disabled=false;
		}
	}
	//选择注师时调用,并自动填充注师信息
	function changeName(){
		//alert(100000000);
		/*
		var memberid = document.getElementById("memberid").value;
		var url="${pageContext.request.contextPath}/common/member.do?method=getMicfoInfo";
		var request = "&officecode=${edit.officecode}&id="+memberid;
		var resText = ajaxLoadPageSynch(url,request);
		var json = eval(resText)[0]; 
		document.getElementById("borndate").value=json.borndate==null ? "" : json.borndate;
		document.getElementById("sex").value=json.sex==undefined ? "男" : json.sex;
		document.getElementById("mobile").value=json.mobile==undefined ? "" : json.mobile;
		
		document.getElementById("nation").value=json.nation==undefined ? "" : json.nation;
		document.getElementById("education").value=json.educational==undefined ? "" : json.educational;
		document.getElementById("rank").value=json.rank==undefined ? "" : json.rank;
		
		*/
	}
 
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
       $("#thisForm").validate();
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

function checkNull(){
	var arr1 = ["团员姓名","是否注师","民族","性别","出生日期","学历","是否团干部","职位","手机"];
	var arr2 = ["membername","isCicpa","nation","sex","borndate","education","isMemberCadre","rank","mobile"];
	for(i=0;i<arr2.length;i++){
		var obj = document.getElementById(arr2[i]);
		if(obj.value==""){
			alert(arr1[i]+"不能为空!");
			if(obj.tagName=='INPUT'){
				obj.select();
			}
			return;
		}
	}
	/*
	if(document.getElementById("isMemberCadre").value=="是"){
		if(document.getElementById("memberpost").value==""){
			alert("如果是团干部,团内职务不能为空!");
			return;
		}
	}
	*/
	return true;
}

//保存
function saveCompany(){ 
	if(!checkNull()){
		return;
	}
	
	//是否已经建立团组织(应先建立了团组织后才可以增加团员)
	var url="${pageContext.request.contextPath}/common/memberBranch.do?method=checkIsCreateBranch";
	var request = "&officecode=${edit.officecode}";
	var resText = ajaxLoadPageSynch(url,request);

	if(resText=="NO"){
		alert("请先建立团组织再增加团员");
		return;
	}else if(resText=="YES"){
	}else{
		alert("操作超时，请重新登陆!");
		return;
	}
	
	/*
	if('${paramopt}'=='add'){
		var memberid = document.getElementById("memberid").value;
		var url="${pageContext.request.contextPath}/common/member.do?method=checkIsMember";
		var request = "&officecode=${edit.officecode}&id="+memberid;
		var resText = ajaxLoadPageSynch(url,request);
		if(resText=="Y"){
			alert("该注师已经添加为团员了!");
			return;
		}
	}
	*/
		
	var xgc = document.getElementById("xgc");
	var bcc = document.getElementById("bcc");
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/member.do?method=updateSave&param=${paramopt}";	
	document.thisForm.target = "";
	
	
	/*
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	if(document.thisForm.fireEvent('onsubmit')){
		
		var membername = document.getElementById("membername").value;
		if(membername == ""){
			alert("团员姓名不能为空");
			document.getElementById("membername").focus();
			return false;
		}
		
		var idnumber = document.getElementById("idnumber").value;
		if(idnumber == ""){
			alert("身份证号不能为空");
			document.getElementById("idnumber").focus();
			return false;
		}
		*/
		//xgc.style.display="";
		//bcc.style.display="none";
		document.thisForm.submit();
		return true;
	//}else{
	//	return false;
	//}
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
	
	//changeDisabled();
}

// 返回到主页 
function goBack(){
	document.thisForm.action = "${pageContext.request.contextPath}/common/member.do?method=member";
	document.thisForm.target="mainFrame";
	document.thisForm.submit();
}

function isQmzs(obj){
	var officecode = document.getElementById("officecode").value;
	var url="${pageContext.request.contextPath}/common/member.do?method=checkIsMember";
	var request = "&loginname="+obj.value+"&officecode="+officecode;
	var resText = ajaxLoadPageSynch(url,request);
	//alert(resText);
	if("Y" == resText){
		alert("[ "+obj.value+" ]已经是团员，不能新增！");
		document.getElementById("membername").value = "";
		return ;
	}
	
	//alert(resText);
	
	var json = eval(resText)[0]; 
	document.getElementById("borndate").value=json.borndate==null ? "" : json.borndate;
	document.getElementById("sex").value=json.sex==undefined ? "男" : json.sex;
	document.getElementById("mobile").value=json.mobile==undefined ? "" : json.mobile;
	
	document.getElementById("nation").value=json.nation==undefined ? "" : json.nation;
	document.getElementById("education").value=json.degree==undefined ? "" : json.degree;//学历
	document.getElementById("rank").value=json.post==undefined ? "" : json.post;//职位
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
//document.getElementById("memberpost").disabled="disabled";

//加验证
$(document).ready(function(){
   $("#myform").validate();
});

//验证数字
function f_moneys(t){
	t.value = t.value.replace(/[^\d\.\\-]/g,'');
} 

</script>
