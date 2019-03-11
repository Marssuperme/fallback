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
                      <td class="data_tb_alignright" width="20%">事务所代码</td>
                      <td class="data_tb_content" width="30%">${branch.officecode }</td>
                      <td class="data_tb_alignright">事务所名称</td>
                      <td class="data_tb_content">${branch.officename }</td>
                    </tr>         
                    <tr>
                      <td class="data_tb_alignright">所属城市</td>
                      <td class="data_tb_content">${branch.area }</td>                     
                      <td class="data_tb_alignright" width="20%">机构类型</td>
                      <td class="data_tb_content" width="30%">${branch.branchtype }</td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">是否成立团组织</td>
                      <td class="data_tb_content" colspan="3">
                      	<select id="dues" name="dues" style="width: 185px"  >
	                      	<option value="是" <c:if test="${branch.dues=='是' }">selected</c:if> >是</option>
	                      	<option value="否" <c:if test="${branch.dues=='否' }">selected</c:if> >否</option>
                      	</select>
                      </td>
                    </tr>
                    <tr>
                      <td class="data_tb_alignright">团组织名称</td>
                      <td class="data_tb_content"><input value="${branch.branchname }" id="branchname" name="branchname" maxlength="50" type="text" size="30"></td>
                      <td class="data_tb_alignright" width="20%">团组织成立时间</td>
                      <td class="data_tb_content" width="30%"><input value="${branch.builddate }" id="builddate" name="builddate" maxlength="50" type="text" size="30"></td>
                    
                    </tr>
                    <tr>
                      <td class="data_tb_alignright" width="20%">团组织书记</td>
                      <td class="data_tb_content" width="30%"><input value="${branch.apartyname }" id="apartyname" name="apartyname" maxlength="50" type="text" size="30"></td>
                      <td class="data_tb_alignright">书记手机</td>
                      <td class="data_tb_content"><input value="${branch.aphone }" id="aphone" name="aphone" maxlength="50" type="text" size="30"></td>
                    </tr>                        
                    <tr>
                      <td class="data_tb_alignright" width="20%">联系人</td>
                      <td class="data_tb_content" width="30%"><input value="${branch.linkman }" name="linkman" maxlength="50" type="text"  id="linkman"  size="30"  title="请正确填写您的联系人" ></td>
                      <td class="data_tb_alignright">联系人手机</td>
                      <td class="data_tb_content"><input value="${branch.phone }" name="phone" maxlength="50" type="text"  id="phone"  size="30"  title="请正确填写您的固定电话" ></td>
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
 	$("input").each(function(index,obj){
		obj.readOnly = true ;
		if (obj.type=="checkbox"){
			obj.disabled = true ;
		}
		obj.className = "before";
	});
	
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


	


//保存
function saveCompany(){ 
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/memberBranch.do?method=updateSave";
	document.thisForm.target = "";
	
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	
	if(document.thisForm.fireEvent('onsubmit')){
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
	//
}

</script>
