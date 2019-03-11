<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="zcpgbguid" name="zcpgbguid" value="${zt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${zt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addZcpgbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateZcpgbTableById">

<table border="1" width="100%" cellpadding="0" style="padding-left: 2px" cellspacing="0">
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">评估目的</td>
    <td width="30%" height="16"><input maxlength="50" id="pgmd" value="${zt.pgmd}" name="pgmd" size="15"></td>
    <td width="20%" height="16" class="data_tb_alignright">评估对象</td>
    <td width="30%" height="16"><input maxlength="50" id="pgdx" value="${zt.pgdx}" name="pgdx" size="15"></td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">价值类型</td>
    <td width="30%" height="16"><input maxlength="50" id="pglx" value="${zt.pglx}" name="pglx" size="15"></td>
    <td width="20%" height="16" class="data_tb_alignright">评估方法</td>
    <td width="30%" height="16"><input maxlength="50" id="pgff" value="${zt.pgff}" name="pgff" size="15"></td>
  </tr>
  
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">评估基准日</td>
    <td width="30%" height="16"><input maxlength="50" id="pgjzr" value="${zt.pgjzr}" name="pgjzr" showcalendar="true" size="15"></td>
    <td width="20%" height="16" class="data_tb_alignright">资产总额</td>
    <td width="30%" height="16"><input maxlength="20" id="zcze" value="${zt.zcze}" name="zcze" size="15" class="number">万元</td>
  </tr>
 
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">负债总额</td>
    <td width="30%" height="16"><input maxlength="20" id="fzze" value="${zt.fzze}" name="fzze" size="15" class="number">万元</td>
    <td width="20%" height="16" class="data_tb_alignright">净增值额</td>
    <td width="30%" height="16"><input maxlength="20" id="jzze" value="${zt.jzze}" name="jzze" size="15" class="number">万元</td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
    <td height="16" colspan="3">
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="15" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
  
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">审计单位名称</td>
    <td width="80%" height="16" colspan="3"><input maxlength="50" id="sjdwmc" value="${zt.sjdwmc }" name="sjdwmc" style="width: 80%"></td>
  </tr>
  
</table>
