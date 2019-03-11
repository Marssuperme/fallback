<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="stguid" name="stguid" value="${st.guid}">
<input type="hidden" id="bguid" name="bguid" value="${st.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addSdshsqjTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateSdshsqjTableById">

<table border="1" cellpadding="0" style="padding-left: 1px" cellspacing="0" width="100%">
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="100%" colspan="4" height="16">纳税信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">收入总额</td>
    <td width="30%" height="23"><input maxlength="20" id="srze" value="${st.srze}" name="srze" size="20" class="number">万元 </td>
    <td width="20%" height="23" class="data_tb_alignright">销售（营业）收入</td>
    <td width="30%" height="23"><input maxlength="20" id="xssr" value="${st.xssr}" name="xssr" size="15" class="number">万元 </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">销售（营业）成本</td>
    <td width="30%" height="23"><input maxlength="20" id="xscb" value="${st.xscb}" name="xscb" size="20" class="number">万元</td>
    <td width="20%" height="23" class="data_tb_alignright">利润总额</td>
    <td width="30%" height="23"><input maxlength="20" id="lrze" value="${st.lrze}" name="lrze" size="15" class="number">万元</td>
  </tr>
  <tr>
    <td width="20%" height="46" class="data_tb_alignright">纳税调整前所得额</td>
    <td width="30%" height="46"><input maxlength="20" id="lstzqsde" value="${st.lstzqsde}" name="lstzqsde" size="20" class="number">元</td>
    <td width="20%" height="46" class="data_tb_alignright">纳税调整增加额</td>
    <td width="30%" height="46"> 
    	<input maxlength="20" id="lstzzje" value="${st.lstzzje }" size="15" name="lstzzje" class="number">元
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">纳税调整减少额</td>
    <td width="30%" height="23"><input maxlength="20" id="lstzjse" value="${st.lstzjse }" name="lstzjse" size="20" class="number">元</td>
    <td width="20%" height="23" class="data_tb_alignright">应纳税所得额</td>
    <td width="30%" height="23">
		<input maxlength="20" id="ylssde" value="${st.ylssde }" size="15" name="ylssde" class="number">元 
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">适用税率(%)<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="20" title="只能输入数字" id="sysl" value="${st.sysl }" name="sysl" size="20" class="required number"></td>
    <td width="20%" height="23" class="data_tb_alignright">期间费用（管理费用、销售费用、财务费用）</td>
    <td width="30%" height="23">
		<input maxlength="20" id="qjfy" value="${st.qjfy }" size="15" name="qjfy"  class="number">元 
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">实际应纳税所得额</td>
    <td width="30%" height="23"><input maxlength="20" id="sjylssd" value="${st.sjylssd }" name="sjylssd" size="20" class="number">元</td>
    <td width="20%" height="23" class="data_tb_alignright">已预缴所得税额</td>
    <td width="30%" height="23"><input maxlength="20" id="yjlssde" value="${st.yjlssde }" name="yjlssde" size="15" class="number">元</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">本期应补（退、抵）所得税额</td>
    <td width="80%" colspan="3" height="23"><input maxlength="20" id="bqybsde" value="${st.bqybsde }" name="bqybsde" size="20" class="number">元</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="100%" colspan="4" height="16">税务信息</td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
    <td height="16" colspan="3">
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="22" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">受理税务机关<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="10"><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=19
						noinput=true
						hideresult=true title="受理税务机关" id="slswjg" value="${st.slswjg }" style="width: 60%" name="slswjg" class="required"></td>
    <td class="data_tb_alignright" width="20%" class="data_tb_alignright">国税税务登记证号</td>
    <td class="data_tb_content" width="30%"><input maxlength="50" id="gsswdjh" value="${st.gsswdjh }" style="width: 60%" name="gsswdjh"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">地税税务登记证号&nbsp;</td>
    <td width="30%" height="16"><input maxlength="50" id="dsswdjh" value="${st.dsswdjh }" style="width: 60%" name="dsswdjh"></td>
    <td width="20%" height="16" class="data_tb_alignright">受理税务机关名称</td>
    <td width="30%" height="16"><input maxlength="50" id="sjswjgmc" value="${st.sjswjgmc }" name="sjswjgmc" style="width: 60%" ></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报告意见类型</td>
    <td width="80%" height="16" colspan="3"><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						noinput=true
						hideresult=true id="bgyjlx" value="${st.bgyjlx }" name="bgyjlx" style="width: 85%"></td>
  </tr>
  
 
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">保留意见内容</td>
    <td width="80%" height="16" colspan="3"><textarea id="blyj" style="width: 85%;height: 50px;" name="blyj">${st.blyj }</textarea></td>
  </tr>
  
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">无保留意见强调事项</td>
    <td width="80%" height="16" colspan="3"><textarea id="notblyj" style="width: 85%;height: 50px;" name="notblyj">${st.notblyj }</textarea></td>
  </tr>
   
</table>

