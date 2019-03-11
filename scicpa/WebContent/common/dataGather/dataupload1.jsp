<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/hasNoRight.jsp"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/AuditSystem/AS_CSS/style.css" />
<script language="javascript" >
//响应提交前的检查
function checkit(){
    var f1=thisForm.image.value;
    if (f1==""){
    	//上传文件不得为空
    	alert("上传文件不得为空");
    	return false;
    }
    if(f1.toLowerCase().indexOf(".mt_")>-1 
    || f1.toLowerCase().indexOf(".mtd_")>-1 
    || f1.toLowerCase().indexOf(".mt3_")>-1
    || f1.toLowerCase().indexOf(".zip")>-1
    ){
    }else{
    	alert("导入的文件必须是mt_（旧版）或mtd_(新版)、mt3_(最新版)、zip后缀的文档!");
    	return false;
    }
    
}

	
</script>
<title>导入数据</title>
</head>

<body leftmargin="0" topmargin="0">
<form name="thisForm" method="post" onsubmit="return checkit()" action="${pageContext.request.contextPath}/common/dataGather/AutoGatherUpload.jsp" id="thisForm" enctype="multipart/form-data">

<table>
  <tr><td colspan="2">采集到数据文件路径：</td></tr>
  <tr>

    <td colspan="2">

    	<input type="file" name="image" id="image" value=""  size="90" title="请输入，不得为空">

      &nbsp;
	</td>
  </tr>
</table>

  <table width="75%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="22" colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td width="37%" align="right">
        <input type="submit" name="next" value="确  定" class="flyBT" >
      </td>
      <td width="8%">&nbsp;</td>
      <td width="55%"><input type="button" name="back" value="返  回" class="flyBT"  onClick="goClose();"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  
<input name="Property" type="hidden" id="Property" value='待定'>
<input name="AuditPara" type="hidden" id="AuditPara" value=0>
  <input name="submitStr" type="hidden" id="submitStr">

  <input name="id" type="hidden" id="id">
  <input name="adored" type="hidden" id="adored" value="ad">
</form>

</body>
</html>