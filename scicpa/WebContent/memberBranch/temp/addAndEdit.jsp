<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党建修改</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
</head>
<body>

<form id="myform" name="myform" action="" method="post">
<input type="hidden" id="id" name="id" value="${pt.id }">
<div style="text-align: center;"> 
<table cellSpacing="0" cellPadding="5" class="data_tb" width="100%" >
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">
    	<span>基础信息</span> 
    	<span style="margin-left: 70%">
    		<input type="button" id="save" icon="icon-save"  onclick="f_save()" value="保存">
			<input type="button" id="see" icon="icon-back"  onclick="window.history.back()" value="返回">
    	</span>
    </td>
  </tr>
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党组织名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="党组织名称" id="branchname" name="branchname" value="${pt.branchname}" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 86%">
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">党组织成立时间</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="党组织成立时间" id="builddate" name="builddate" value="${pt.builddate}" class="required"  readonly="readonly" style="background-color: #f7f7f7;width: 65%">
    </td>
    <td width="20%" height="23" class="data_tb_alignright">所属城市</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="所属城市" id="area" name="area" value="${pt.area}" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 63%"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">机构类型</td>
    <td width="30%" height="23" class="data_tb_content"><input title="机构类型" id="branchtype" name="branchtype" value="${pt.branchtype }" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">党组织类型</td>
    <td width="30%" height="23" class="data_tb_content"><input title="党组织类型" id="branchtype2" value="${pt.branchtype2 }" name="branchtype2" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 63%"></td>
  </tr>
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">隶属关系</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="党组织名称" id="affiliation" name="affiliation" value="${pt.affiliation}" class="required" style="width: 86%">
    </td>
  </tr>
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">所属党组织</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="所属党组织" id="" name="" value="${pt.pname }" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 86%">
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">事务所代码</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" title="事务所代码" id="officecode" name="officecode" value="${pt.officecode}" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">事务所全称</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="事务所全称" id="loginname" name="loginname" value="${loginname}" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 63%"></td>
  </tr>
  
   <tr>
    <td width="20%" height="23" class="data_tb_alignright">成&nbsp;&nbsp;员&nbsp;&nbsp;数</td>
    <td width="30%" height="23" class="data_tb_content"><input title="成员数" id="micfoCount" name="micfoCount" value="${micfoCount}" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</td>
    <td width="30%" height="23" class="data_tb_content"><input title="网址" id="web" name="web" value="${pt.web}" class="required" style="width: 63%"></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">固定电话</td>
    <td width="30%" height="23" class="data_tb_content"><input title="固定电话" id="phone" name="phone" value="${pt.phone}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真</td>
    <td width="30%" height="23" class="data_tb_content"><input title="传真" id="fax" name="fax" value="${pt.fax}" class="required" style="width: 63%"></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</td>
    <td width="30%" height="23" class="data_tb_content"><input title="手机" id="mobile" name="mobile" value="${pt.mobile}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">电子邮箱</td>
    <td width="30%" height="23" class="data_tb_content"><input title="电子邮箱" id="email" name="email" value="${pt.email}" class="required" style="width: 63%"></td>
  </tr>
    
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">通信地址</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input maxlength="300" title="通信地址" id="address" name="address" value="${pt.address}" class="required" style="width: 86%">
    </td>
  </tr>
  
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">民主生活</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<textarea title="民主生活" id="mzsh" name="mzsh" rows="4" class="required" style=";width: 86%">${pt.mzsh}</textarea>
    </td>
  </tr>
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党内表彰</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<textarea title="党内表彰" id="dnbz" name="dnbz" rows="4" class="required" style="width: 86%">${pt.dnbz}</textarea>
    </td>
  </tr>
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党员发展情况</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<textarea title="党员发展情况" id="fzqk" name="fzqk" rows="4" class="required" style="width: 86%">${pt.fzqk}</textarea>
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">修&nbsp;&nbsp;改&nbsp;&nbsp;人</td>
    <td width="30%" height="23" class="data_tb_content"><input title="修改人" id="lastby" name="lastby" value="${pt.lastby}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">修改时间</td>
    <td width="30%" height="23" class="data_tb_content"><input  title="修改时间" id="lastmodify" name="lastmodify" value="${pt.lastmodify}" class="required" showcalendar="true" style="width: 55%"></td>
  </tr>
  
</table>

</div>
</form>
</body>

<script type="text/javascript">
	// 保存
	function f_save(){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/partyBranch.do?method=save";
		document.getElementById("myform").submit();
	}
</script>

</html>