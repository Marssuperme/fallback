<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="qtssjjbguid" name="qtssjjbguid" value="${qt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${qt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addQtssjjbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateQtssjjbTableById">

<table border="1" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="597" colspan="4" height="16">其他涉税鉴证表信息</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">收入总额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="srze" value="${qt.srze}" name="srze" size="20" class="number">万元</td>
    <td width="20%" class="data_tb_alignright">销售（营业）收入</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="xssr" value="${qt.xssr}" name="xssr" size="20" class="number">万元</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">销售（营业）成本</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="xscb" value="${qt.xscb}" name="xscb" size="20" class="number">万元</td>
   	<td width="20%" class="data_tb_alignright">期间费用</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="qjfy" value="${qt.qjfy}" name="qjfy" size="20" class="number">万元</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">利润总额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="lrze" value="${qt.lrze}" name="lrze" size="20" class="number">万元</td>
    <td width="20%" class="data_tb_alignright">纳税调整前所得额</td>
    <td width="30%" class="data_tb_content"> 
    	<input maxlength="20" id="lstzqsde" value="${qt.lstzqsde }" size="20" name="lstzqsde" class="number">元
    </td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">纳税调整增加额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="lstzzje" value="${qt.lstzzje }" name="lstzzje" size="20" class="number">元</td>
    <td width="20%" class="data_tb_alignright">纳税调整减少额</td>
    <td width="30%" class="data_tb_content">
		<input maxlength="20" id="lstzjse" value="${qt.lstzjse }" size="20" name="lstzjse" class="number">元 
	</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">应纳税所得额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="ylssde" value="${qt.ylssde }" name="ylssde" size="20" class="number">元</td>
    <td width="20%" class="data_tb_alignright">适用税率(%)<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content">
		<input maxlength="20" title="适用税率" id="sysl" value="${qt.sysl }" size="20" name="sysl" class="required number"> 
	</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">实际应纳税所得额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="sjylssd" value="${qt.sjylssd }" name="sjylssd" size="20" class="number">元</td>
    <td width="20%" class="data_tb_alignright">已预缴所得税额</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="yyjsdse" value="${qt.yyjsdse }" name="yyjsdse" size="20" class="number">元</td>
  </tr>
  
  <tr>
    <td width="20%" class="data_tb_alignright">本期应补</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="bqybsdlse" value="${qt.bqybsdlse }" name="bqybsdlse" size="20" class="number">元</td>
    <td width="20%" class="data_tb_alignright">受理税务机关<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content">
		<input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=19
						noinput=true
						hideresult=true title="受理税务机关" id="slsjg" value="${qt.slsjg }" size="20" name="slsjg" class="required"> 
	</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright">国税税务登记证号</td>
    <td width="30%" class="data_tb_content"><input maxlength="50" id="gsswdjh" value="${qt.gsswdjh }" name="gsswdjh" size="20"></td>
    <td width="20%" class="data_tb_alignright">地税税务登记证号</td>
    <td width="30%" class="data_tb_content"><input maxlength="50" id="dsswdjh" value="${qt.dsswdjh }" name="dsswdjh" size="20"></td>
  </tr>
  
  <tr>
    <td width="20%" class="data_tb_alignright">受理税务机关名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content"><input maxlength="50" title="受理税务机关名称" id="slswjgmc" value="${qt.slswjgmc }" name="slswjgmc" size="20" class="required"></td>
    <td width="20%" class="data_tb_alignright">报告意见类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content">
		<input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						refer=0
						noinput=true
						hideresult=true id="bgyjlx" title="报告意见类型" value="${qt.bgyjlx }" size="20" name="bgyjlx" class="required"> 
	</td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
    <td height="16" colspan="3">
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="20" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
  
  <tr>
    <td class="data_tb_alignright" width="20%">保留意见内容</td>
    <td width="30%" class="data_tb_content" colspan="3"><textarea id="blyjly" style="width: 90%;height: 50px;" name="blyjly">${qt.blyjly }</textarea></td>
  </tr>
  
   <tr>
    <td class="data_tb_alignright" width="20%">无保留意见强调事项</td>
    <td width="30%" class="data_tb_content" colspan="3"><textarea id="notblyjly" ${qt.blyjly } name="notblyjly" style="width: 90%;height: 50px;" >${qt.notblyjly }</textarea></td>
  </tr>
  
</table>

