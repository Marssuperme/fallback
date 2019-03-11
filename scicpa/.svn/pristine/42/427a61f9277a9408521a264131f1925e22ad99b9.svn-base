<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党员修改</title>
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
    <td width="20%" height="23" class="data_tb_alignright">党员姓名</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="党员姓名" id="partyname" name="partyname" value="${pt.partyname}" class="required" style="width: 65%">
    </td>
    <td width="20%" height="23" class="data_tb_alignright">性别</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="性别" id="sex" name="sex" value="${pt.sex}" class="required" style="width: 63%"></td>
  </tr>
  
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">所属党组织类型</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="所属党组织类型" id="" name="" value="22222222222" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 86%">
    </td>
  </tr>
  
   <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党组织名称</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="党组织名称" id="" name="" value="333333333" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 86%">
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">事务所代码</td>
    <td width="30%" height="23" class="data_tb_content"><input title="事务所代码"  id="officecode" name="officecode" value="" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 65%" ></td>
    <td width="20%" height="23" class="data_tb_alignright">事务所全称</td>
    <td width="30%" height="23" class="data_tb_content"><input title="事务所全称" id="loginname" name="loginname" value="" class="required" readonly="readonly" style="background-color: #f7f7f7;width: 63%" ></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">党内职务</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="党内职务" id="" name="" value="" class="required"  style="width: 65%">
    	
    </td>
    <td width="20%" height="23" class="data_tb_alignright">所属城市</td>
    <td width="30%" height="23" class="data_tb_content">
    	<input title="所属城市" id="area" name="area" value="" class="required" style="width: 63%"></td>
  </tr>
  
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">
    	详细信息 
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">行政职务</td>
    <td width="30%" height="23" class="data_tb_content"><input title="行政职务" id="post" name="post" value="${pt.post}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">工作单位</td>
    <td width="30%" height="23" class="data_tb_content"><input title="工作单位" id="department" value="${pt.department }" name="department" class="required" style="width: 63%"></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">身份证号</td>
    <td width="30%" height="23" class="data_tb_content"><input title="身份证号" id="idnumber" name="idnumber" value="${pt.idnumber}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">证书编号</td>
    <td width="30%" height="23" class="data_tb_content"><input title="工作单位" id="general" value="${pt.general }" name="department" class="required" style="width: 63%"></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">党籍状态</td>
    <td width="30%" height="23" class="data_tb_content"><input title="党籍状态" id="state" name="state" value="${pt.state}" class="required" style="width: 65%"></td>
    <td width="20%" height="23" class="data_tb_alignright">入党日期</td>
    <td width="30%" height="23" class="data_tb_content"><input title="入党日期" id="joindate" value="${pt.joindate }" name="joindate" class="required" style="width: 55%" showcalendar="true"></td>
  </tr>
  
  
  
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">正式组织关系所在党组织</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="身份证号" id="relationparty" name="relationparty" value="${pt.relationparty}" class="required" style="width: 86%" >
    </td>
  </tr>
  
   <tr>
    <td width="20%" height="23" class="data_tb_alignright">出生日期</td>
    <td width="30%" height="23" class="data_tb_content"><input title="出生日期" id="borndate" name="borndate" value="${pt.borndate}" class="required" style="width: 55%" showcalendar="true"></td>
    <td width="20%" height="23" class="data_tb_alignright">婚姻状况</td>
    <td width="30%" height="23" class="data_tb_content"><input title="婚姻状况" id="marital" name="marital" value="${pt.marital}" class="required" style="width: 63%" ></td>
  </tr>
  
   <tr>
  	<td width="20%" height="23" class="data_tb_alignright">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="身份证号" id="relationparty" name="relationparty" value="${pt.relationparty}" class="required" style="width: 86%" >
    </td>
  </tr>
  <tr>
 	<td width="20%" height="23" class="data_tb_alignright">人事关系所在单位名称</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input title="身份证号" id="relationparty" name="relationdepart" value="${pt.relationdepart}" class="required" style="width: 86%" >
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">固定电话</td>
    <td width="30%" height="23" class="data_tb_content"><input title="固定电话" id="phone" name="phone" value="${pt.phone}" class="required" style="width: 65%" ></td>
    <td width="20%" height="23" class="data_tb_alignright">传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真</td>
    <td width="30%" height="23" class="data_tb_content"><input title="传真" id="fax" name="fax" value="${pt.fax}" class="required" style="width: 63%" ></td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</td>
    <td width="30%" height="23" class="data_tb_content"><input title="手机" id="mobile" name="mobile" value="${pt.mobile}" class="required" style="width: 65%" ></td>
    <td width="20%" height="23" class="data_tb_alignright">电子邮箱</td>
    <td width="30%" height="23" class="data_tb_content"><input title="电子邮箱" id="email" name="email" value="${pt.email}" class="required" style="width: 63%" ></td>
  </tr>
    
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">通信地址</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<input maxlength="300" title="通信地址" id="address" name="address" value="${pt.address}" class="required" style="width: 86%" >
    </td>
  </tr>
  
  
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党内培训信息</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<textarea title="党内培训信息" id="" name="" rows="4" class="required" style=";width: 86%" ></textarea>
    </td>
  </tr>
   
  <tr>
  	<td width="20%" height="23" class="data_tb_alignright">党内奖惩信息</td>
    <td width="30%" height="23" colspan="3" class="data_tb_content">
    	<textarea title="党内奖惩信息" id="" name="" rows="4" class="required" style=";width: 86%" ></textarea>
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">修&nbsp;&nbsp;改&nbsp;&nbsp;人</td>
    <td width="30%" height="23" class="data_tb_content"><input title="修改人" id="lastby" name="lastby" value="${pt.lastby}" class="required" style="width: 65%" ></td>
    <td width="20%" height="23" class="data_tb_alignright">修改时间</td>
    <td width="30%" height="23" class="data_tb_content"><input  title="修改时间" id="lastmodify" name="lastmodify" value="${pt.lastmodify}" class="required" style="width: 55%" showcalendar="true"></td>
  </tr>
  
</table>

</div>
</form>
</body>
 <script type="text/javascript">
 	// 保存
 	function f_save(){
 		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/party.do?method=save";
 		document.getElementById("myform").submit();
 	}
 </script>

</html>