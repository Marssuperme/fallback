<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../CSS/position.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工</title>
<script type="text/javascript">
	function f_open(depaId,staffId){
		var url = "${pageContext.request.contextPath}/common/staff.do?method=staffOdd&depaId="+depaId+"&staffId="+staffId;
		window.open(url);
	} 
</script>
</head>
<body>

<div id="content">

	<div id="header">
    	<div id="left1"><img src="../images/staffTop/topleft.jpg" height="40"/></div>
        <div id="main1"><a href="#">${depaId.name}</a></div>
        <div id="right1"><img src="../images/staffTop/topRight.jpg" height="40"/></div>
    </div>
    
    <div class="clear-both"></div>
    
	<div id="main">
    	<div id="shopping">
	    	<table width="100%" border="0" id="tabst" cellpadding="0" cellspacing="0">
	          <tr>
	            <td width="20%" style="border-right:solid 1px #CCC;">照片</td>
	            <td width="80%">岗位职责</td>
	          </tr>
	         </table>
		</div>
	
		<div id="shopping">
	        <c:forEach var="sf" items="${staff}" varStatus="status">
	          <table width="100%" border="0" cellpadding="0" cellspacing="0">
	              <tr>
	                <td width="19%" align="center" id="tds">
	                	<a href="#" onClick="f_open('${sf.position.departmentId}','${sf.id}')">
	                		<img src="../common/attachFile/k_staff/${sf.photoPath}" width="160" height="150" class="dimg"/>
	                	</a>
	                	<br/><span id="trd">${sf.loginName}</span>
	                </td>
	                <td width="81%" class="td5">
	                	<span class="td1">
	                		<span class="tdText3">岗位：</span>${sf.positionNames}
	               		</span><br/><br/>
	               	 	<span class="tdors"><hr class="bor"/></span><br/>
	               	 	<span class="td4">
                        	<span class="tdText3">岗位描述：</span>${sf.positionRemarks}</span>
	               	</td>
	              </tr>
	          		</table>
	         </c:forEach>
		</div>
	
	    <div id="pas" align="center">
	    	<a href="${pageContext.request.contextPath}/common/staff.do?method=staffIndex&departmentId=${depaId.id}&countPage=${currentPage-1}" class="at">上一页</a>&nbsp;&nbsp;
	    	<a href="${pageContext.request.contextPath}/common/staff.do?method=staffIndex&departmentId=${depaId.id}&countPage=${currentPage+1}" class="at">下一页</a>
	    </div>
    </div>
    
    <div class="clear-both"></div>
    
    <div id="footer">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center"><a href="#" class="fos" style="color:#666">360网站安全检测平台</a></td>
          </tr>
          <tr>
            <td align="center"><a href="#" class="fos" style="color:#666">关于铭太</a>|<a href="#" style="color:#666">新闻中心</a>|<a href="#" style="color:#666">人才招聘</a></td>
          </tr>
          <tr>
            <td align="center"><a href="#" style="color:#666">版权所有 © 2011 广州铭太信息科技有限公司 粤ICP备07007344号</a></td>
          </tr>
        </table>
    </div>
    
</div>

</body>


</html>