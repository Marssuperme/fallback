<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上支付</title>
<style>
label {
	cursor: hand;
}
</style>
</head>

<body>
<form action="">
选择付款方式：
<table width="100%">
	<tr>
		<td>
			<label onclick="selectBank(this);" for="gongshang">
				<input type="radio" id="gongshang" value="ICBC-NET" name="frpId" />
				<img alt="中国工商银行" src="${pageContext.request.contextPath}/images/bankLogo/gongshang.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="zhongguo" >
				<input type="radio" id="zhongguo" value="BOC-NET" name="frpId" />
				<img alt="中国银行" src="${pageContext.request.contextPath}/images/bankLogo/zhongguo.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="nongye">
				<input type="radio" id="nongye" value="ABC-NET" name="frpId" />
				<img alt="农业银行" src="${pageContext.request.contextPath}/images/bankLogo/nongye.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="jianshe">
				<input type="radio" id="jianshe" value="CCB-NET" name="frpId" />
				<img alt="建设银行" src="${pageContext.request.contextPath}/images/bankLogo/jianshe.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="minsheng" >
				<input type="radio" id="minsheng" value="CMBC-NET" name="frpId" />
				<img alt="中国民生银行" src="${pageContext.request.contextPath}/images/bankLogo/minsheng.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="zhaohang">
				<input type="radio" id="zhaohang" value="CMBCHINA-NET" name="frpId" />
				<img alt="招商银行" src="${pageContext.request.contextPath}/images/bankLogo/zhaohang.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="guangfa">
				<input type="radio" id="guangfa" value="GDB-NET" name="frpId" />
				<img alt="广东发展银行" src="${pageContext.request.contextPath}/images/bankLogo/guangfa.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="jiaotong" >
				<input type="radio" id="jiaotong" value="BOCO-NET" name="frpId" />
				<img alt="交通银行" src="${pageContext.request.contextPath}/images/bankLogo/jiaotong.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="guangda">
				<input type="radio" id="guangda" value="CEB-NET" name="frpId" />
				<img alt="光大银行" src="${pageContext.request.contextPath}/images/bankLogo/guangda.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="youzheng">
				<input type="radio" id="youzheng" value="POST-NET" name="frpId" />
				<img alt="中国邮政" src="${pageContext.request.contextPath}/images/bankLogo/youzheng.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="xingye" >
				<input type="radio" id="xingye" value="CIB-NET" name="frpId" />
				<img alt="兴业银行" src="${pageContext.request.contextPath}/images/bankLogo/xingye.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="pingan">
				<input type="radio" id="pingan" value="PAB-NET" name="frpId" />
				<img alt="平安银行" src="${pageContext.request.contextPath}/images/bankLogo/pingan.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="nanjing">
				<input type="radio" id="nanjing" value="NJCB-NET" name="frpId" />
				<img alt="南京银行" src="${pageContext.request.contextPath}/images/bankLogo/nanjing.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="shenfa" >
				<input type="radio" id="shenfa" value="SDB-NET" name="frpId" />
				<img alt="深圳发展银行" src="${pageContext.request.contextPath}/images/bankLogo/shenfa.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="shangpufa">
				<input type="radio" id="shangpufa" value="SPDB-NET" name="frpId" />
				<img alt="上海浦东发展银行" src="${pageContext.request.contextPath}/images/bankLogo/shangpufa.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="zhongxin">
				<input type="radio" id="zhongxin" value="ECITIC-NET" name="frpId" />
				<img alt="中信银行" src="${pageContext.request.contextPath}/images/bankLogo/zhongxin.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="beijing" >
				<input type="radio" id="beijing" value="BCCB-NET" name="frpId" />
				<img alt="北京银行" src="${pageContext.request.contextPath}/images/bankLogo/beijing.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="dongya">
				<input type="radio" id="dongya" value="HKBEA-NET" name="frpId" />
				<img alt="东亚银行" src="${pageContext.request.contextPath}/images/bankLogo/dongya.gif" />
			</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<label onclick="selectBank(this);" for="nongcunshangye">
				<input type="radio" id="nongcunshangye" value="BJRCB-NET" name="frpId" />
				<img alt="北京农村商业银行" src="${pageContext.request.contextPath}/images/bankLogo/nongcunshangye.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="ningbo" >
				<input type="radio" id="ningbo" value="NBCB-NET" name="frpId" />
				<img alt="宁波银行" src="${pageContext.request.contextPath}/images/bankLogo/ningbo.gif" />
			</label>
		</td>
		<td>
			<label onclick="selectBank(this);" for="buohai">
				<input type="radio" id="buohai" value="CBHB-NET" name="frpId" />
				<img alt="渤海银行" src="${pageContext.request.contextPath}/images/bankLogo/buohai.gif" />
			</label>
		</td>
	</tr>
</table>
</form>
</body>

<script type="text/javascript">
function selectBank(obj) {

	obj.getElementsByTagName('input')[0].checked=true;
	alert(obj.getElementsByTagName('input')[0].value);
	alert(obj.getElementsByTagName('input')[0].id);
}
</script>
</html>