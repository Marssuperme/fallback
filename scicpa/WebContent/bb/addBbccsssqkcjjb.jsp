<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="ccsssqkjjguid" name="ccsssqkjjguid" value="${cct.guid}">
<input type="hidden" id="bguid" name="bguid" value="${cct.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addCcsssqkcjjbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateCcsssqkcjjbTableById">

<table border="1" cellSpacing="0" style="padding-left: 2px" cellPadding="0" width="100%" height="20%">
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">财产损失类别<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16"><input maxlength="50"  onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						noinput=true
						autoid=8 id="ccsslb" title="财产损失类别" value="${cct.ccsslb}" name="ccsslb" size="20" class="required"></td>
    <td width="20%" height="16" class="data_tb_alignright">客户申报损失金额</td>
    <td width="30%" height="16"><input maxlength="20"  id="khsbssje" value="${cct.khsbssje}" name="khsbssje" size="20" class="number">元</td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">鉴证损失金额</td>
    <td width="30%" height="16"><input maxlength="20"  id="jzssje" value="${cct.jzssje}" name="jzssje" size="20" class="number">元</td>
    <td width="20%" height="16" class="data_tb_alignright">报告意见类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16"><input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						refer=0
						noinput=true
						hideresult=true id="bgyjlx" title="报告意见类型" value="${cct.bgyjlx}" name="bgyjlx" size="20" class="required"></td>
  </tr>
 
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
    <td height="16" align="left" colspan="3">
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="20" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">保留意见内容</td>
    <td width="80%" height="16" colspan="3"><textarea id="blyjly" name="blyjly" style="width: 90%;height: 50px;">${cct.blyjly }</textarea></td>
  </tr>
   
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">无保留意见强调事项</td>
    <td width="80%" height="16" colspan="3"><textarea id="notblyjly" name="notblyjly" style="width: 90%;height: 50px;">${cct.notblyjly }</textarea></td>
  </tr>
</table>

