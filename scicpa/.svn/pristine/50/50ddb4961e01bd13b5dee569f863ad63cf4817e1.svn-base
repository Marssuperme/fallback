<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="kjdshbguid" name="kjdshbguid" value="${kt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${kt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addKjdshbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateKjdshbTableById">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center">
	  <tr>
	    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
	    <td height="16" align="left" colspan="3">
		    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="40" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
		    <font color="red">(会显示在报备封面上)</font>
	    </td>
	  </tr>
 	  <tr>
	    <td width="20%" height="53" class="data_tb_alignright">评价结果<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="80%" height="53" colspan="3" align="left" >
	    	<textarea title="评价结果" id="pjjs" name="pjjs" style="width: 90%;height: 50px;" class="required">${kt.pjjs }</textarea>
	    </td>
	  </tr>
</table>
