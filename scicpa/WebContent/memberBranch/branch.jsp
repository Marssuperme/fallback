<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>团组织信息</title> 
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
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" > 
	团&nbsp;&nbsp;组&nbsp;&nbsp;织&nbsp;&nbsp;基&nbsp;&nbsp;础&nbsp;&nbsp;资&nbsp;&nbsp;料<br/><br/> 
	</center>

<DIV class=block id=search style="height: 100%;">

<div class=tabcontent id="dgxx" style="text-align:center;">
<table height="5%" border="0" cellspacing="0" cellpadding="0"  <c:if test="${branch.isupdate !='1' }">style="display: block;"</c:if>   >
  <tr align="center">
    <td align="left" style="display: ">
    	<div style="display: none;" id="xgc">
       		<input type="button" name="xgb" id="xgb" icon="icon-edit" value="修  改" class="flyBT" onclick="updateStyle();" >
       	</div>
       	<div id="bcc">
   			<input type="button"  icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="return saveCompany();" >
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
                      <td class="data_tb_alignright" width="20%">事务所代码</td>
                      <td class="data_tb_content" width="30%">${branch.officecode }</td>
                      <td class="data_tb_alignright">事务所名称</td>
                      <td class="data_tb_content">${branch.officename }</td>
                    </tr>         
                    <tr>
                      <td class="data_tb_alignright">所属城市</td>
                      <td class="data_tb_content">${branch.area }<input type="hidden" id="area" name="area" value="${branch.area }"/></td>                     
                      <td class="data_tb_alignright" width="20%">机构类型</td>
                      <td class="data_tb_content" width="30%">
                      	<c:if test='${empty branch.branchtype }'>事务所团组织</c:if>
                      	<c:if test='${!empty branch.branchtype }'>${branch.branchtype }</c:if>
                      	<input type="hidden" id="branchtype" name="branchtype" value="事务所团组织"/>                      
                      </td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">是否成立团组织</td>
                      <td class="data_tb_content" colspan="3">
                      	<select id="isCreate" name="isCreate" style="width: 185px" onchange="changeDisabled();">
	                      	<option value="是" <c:if test="${branch.iscreate=='是' }">selected</c:if> >是</option>
	                      	<option value="否" <c:if test="${empty branch.iscreate || branch.iscreate=='否' }">selected</c:if> >否</option>
                      	</select>
                      </td>
                    </tr>
                    <tr>
                    <td colspan="4">
                    <span id="yesOrNo" style="display:none;">
                    <table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
                    <tr>
                      <td class="data_tb_alignright">团组织名称<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input value="${branch.branchname }" id="branchname" name="branchname" maxlength="50" type="text" size="30"></td>
                      <td class="data_tb_alignright" width="20%">团组织成立时间<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input showcalendar="true" maxlength="100" value="${branch.builddate }" id="builddate" name="builddate" maxlength="50" type="text" size="30"  onkeypress="return false;" onpaste="return false;"></td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">团组织书记<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content" width="30%"><input value="${branch.secretaryname }" id="secretaryname" name="secretaryname" maxlength="50" type="text" size="30"></td>
                      <td class="data_tb_alignright">书记手机<font color="#FF0000">&nbsp;[*]</font></td>
                      <td class="data_tb_content"><input value="${branch.mobile }" id="mobile" name="mobile" maxlength="50" type="text" size="30" onkeyup="f_moneys(this);"></td>
                    </tr> 
                    <tr>
                      <td class="data_tb_alignright" width="20%">团员数<font color="#FF0000">&nbsp;[*]</td>
                      <td class="data_tb_content" width="30%"><input maxlength="50" type="text" size="30"  id="membernum" name="membernum" value="${branch.membernum }" onkeyup="f_moneys(this);" ></td>
                      <td class="data_tb_alignright">团员中CPA人数<font color="#FF0000">&nbsp;[*]</td>
                      <td class="data_tb_content"><input maxlength="50" type="text" size="30" id="cpanum" name="cpanum" value="${branch.cpanum }" onkeyup="f_moneys(this);" ></td>
                    </tr>  
                    </table>
                    </span>
                    </td>                      
                    <tr>
                      <td class="data_tb_alignright" width="20%">联系人<font id="linkman1" color="#FF0000"><c:if test="${branch.iscreate=='否' }">&nbsp;[*]</c:if><c:if test="${branch.iscreate=='是' }"></c:if></font></td>
                      <td class="data_tb_content" width="30%"><input value="${branch.linkman }" name="linkman" maxlength="50" type="text"  id="linkman"  size="30"  title="请正确填写您的联系人" ></td>
                      <td class="data_tb_alignright">联系人手机<font id="phone1" color="#FF0000"><c:if test="${branch.iscreate=='否' }">&nbsp;[*]</c:if><c:if test="${branch.iscreate=='是' }"></c:if></font></td>
                      <td class="data_tb_content"><input value="${branch.phone }" name="phone" maxlength="50" type="text"  id="phone"  size="30"  title="请正确填写您的电话" onkeyup="f_moneys(this);" ></td>
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
</DIV>
<input name="id" type="hidden" id="id"  value="${branch.id }"  >

</form>

<iframe name='hidden_frame' id="hidden_frame" style='display:none;'></iframe>
</body>
</html>
<script type="text/javascript">
 
 	// 让 border = 0
 	// 让 textarea被替换
 	/*
 	$("input").each(function(index,obj){
		obj.readOnly = true ;
		if (obj.type=="checkbox"){
			obj.disabled = true ;
		}
		obj.className = "before";
	});
	*/
	//$("select").each(function(index,obj){
		//obj.disabled = true ;
	//	obj.className = "before";
	//});
	
	$("textarea").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
	});
	
	//加验证
    $(document).ready(function(){
       $("#thisForm").validate();
    });

var arr1 = ["团组织名称","团组织成立时间","团组织书记","书记手机","团员数","团员中CPA人数","联系人","联系人手机"];
var arr2 = ["branchname","builddate","secretaryname","mobile","membernum","cpanum","linkman","phone"];

//保存
function saveCompany(){ 
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/memberBranch.do?method=updateSave";
	document.thisForm.target = "";
	var isCreate = document.getElementById("isCreate").value;
	if(isCreate=='是'){
		for(i=0;i<arr2.length-2;i++){
			var obj = document.getElementById(arr2[i]);
			if(obj.value==""){
				alert(arr1[i]+"不能为空!");
				if(obj.tagName=='INPUT'){
					obj.select();
				}
				return;
			}
		}		
	}else{
		for(i=6;i<arr2.length;i++){
			var obj = document.getElementById(arr2[i]);
			if(obj.value==""){
				alert(arr1[i]+"不能为空!");
				if(obj.tagName=='INPUT'){
					obj.select();
				}
				return;
			}
		}		
	}
	document.thisForm.submit();
	return true;
	/*
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	*/
	/*
	if(document.thisForm.fireEvent('onsubmit')){
		document.thisForm.submit();
		return true;
	}else{
		return false;
	}
	*/
}

//控制是否显示工会信息
var isCreate = document.getElementById("isCreate").value;  
if(isCreate=='是'){
	yesOrNo.style.display='';
}else{
	yesOrNo.style.display='none';
}

//是否成立工会<font color="#FF0000">&nbsp;[*]</font>
function changeDisabled(){
    var isCreate = document.getElementById("isCreate").value;  
	var yesOrNo = document.getElementById('yesOrNo');
	if(isCreate=='是'){
		yesOrNo.style.display='';
		document.getElementById("linkman1").innerHTML="";
		document.getElementById("phone1").innerHTML="";
	}else{
		yesOrNo.style.display='none';
		document.getElementById("linkman1").innerHTML="&nbsp;[*]";
		document.getElementById("phone1").innerHTML="&nbsp;[*]";
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
	//
}

//验证数字
function f_moneys(t){
	//t.value = t.value.replace(/[^\d\.\\-]/g,'');
	t.value = t.value.replace(/[^\d]/g,'');
} 
</script>
