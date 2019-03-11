<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jxl.Workbook"%>
<%@page import="jxl.Sheet"%>
<%@page import="java.io.File"%>
<%@page import="jxl.Cell"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="cn.org.gdicpa.web.pub.fileupload.MyFileUpload"%>
<%@page import="java.util.Map"%>
<%@page import="cn.org.gdicpa.web.pub.listener.UserSession"%>
<%@page import="cn.org.gdicpa.web.service.bbCommon.BbService"%>
<%@page import="java.util.UUID"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<%@page import="cn.org.gdicpa.web.service.applyHoldSelfHour.ApplyHoldSelfHourService"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ImportBBData.jsp</title>
<style>
a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

<form id="myform" name="myform" method="post" enctype="multipart/form-data" >
<input type="hidden" id="p" name="p" value="${p}">
<input type="hidden" id="classId" name="classId" value="${classId}">
<input type="hidden" id="fileName" name="fileName" value="">
<center>
<table style="margin-top: 15px;">
<td><font style="font-size: 20px;">请导入学时excel：</font></td>
<td><input type="file" id="upload" name="upload" size="50" ></td>
</table>

<br> 
<input type="button" value="确定" onclick="f_sure()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="window.history.back()">

</center>

 </form>
	 
</body>


<script type="text/javascript">
	function f_sure(){
		var path = document.getElementById("upload").value;
		if(path=="" || path==null){
			alert("请选择上传的文件！");
			return ;
		}
		
		document.getElementById("p").value = "sure";
		var classId = document.getElementById("classId").value;
		var fileName = path.substring(path.lastIndexOf("\\")+1);
		
		document.getElementById("fileName").value = fileName;
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=goImport&p=sure&classId="+classId;
		document.getElementById("myform").submit();
	}
	
	
	// 刷新列表
	function goList(){
		if(confirm("确定刷新列表吗？")){
			var classId = document.getElementById("classId").value;
			window.location = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=index&classId="+classId;
		}
	}
	
</script>

<%

String p = request.getParameter("p");
String classId = request.getParameter("classId");
System.out.println("p="+p+"classId="+classId);
if("sure".equalsIgnoreCase(p)){
UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
Map userMap = userSession.getUserMap();
// 事务所编号
String loginid = (String)userMap.get("loginid");


 
// 上传文件
MyFileUpload fileupload = new MyFileUpload(request);
ASFuntion as = new ASFuntion();
String date = as.getDateAndTime1();
String temp = date.replace("-","").replace(" ","").replace(":","")+"/";
String classPath = (String)new BbService().getMapInfo().get("classPath");
String filePath = new File(classPath).getParentFile().getParentFile().getPath() ;
filePath = filePath+"/common/ApplyHoldSelfHourData"+"/"+loginid+"/"+temp;
File file = new File(filePath);
if(!file.exists()) {
	file.mkdirs() ;
}
 
fileupload.UploadFile(null,filePath);

Map map = fileupload.getMap();

String fileName = (String)map.get("fileName");

// 读取 excel 数据 保存到数据库
Connection conn = null;
PreparedStatement ps = null;
try {
	conn = new DBConnect().getConnect();
	
	Workbook book = Workbook.getWorkbook(new File(filePath+"/"+fileName));
	Sheet sheet1 = book.getSheet(0);
	// 得到 excel 的行
	int rows = sheet1.getRows();

	// 得到 excel 的列
	int cols = sheet1.getColumns();
	
	
	// 读取配置，拼凑 sql
	ApplyHoldSelfHourService ahhs = new ApplyHoldSelfHourService(conn);
	
	if(fileName!=null && !"".equals(fileName)){
		fileName = fileName.substring(0,fileName.indexOf("."));
	}
	
	System.out.println("rows="+rows+"              cols="+cols+"          fileName="+fileName);
	
	String path = this.getClass().getResource("/").getPath();
	
	map = ahhs.getSqlByXml(path,"applyHoldSelfHour.xml");
	
	// 表名
	String tableName = (String)map.get("tableName");
	// 列名
	String column = (String)map.get("column");
	// 列名值 [文号]
	String columnValue = (String)map.get("columnValue");
	// 列的开始位置
	String columnStartIndex = (String)map.get("columnStartIndex");
	// 列的结束位置
	String columnEndIndex = (String)map.get("columnEndIndex");

	
	Cell cell = null;
	List list = new ArrayList();
	
	out.print("<font color='red'>开始自办培训班学时数据...<br></font>");
	int flag = 0;
	
	// 保存 
	for (int i = 3; i < rows; i++) {
		if(!"".equals(sheet1.getCell(1,i).getContents()) && null != sheet1.getCell(8,i).getContents()){
			// 主键
			String guid = UUID.randomUUID().toString();
			
			String sql = "insert into "+tableName+" ("+column+") values("+columnValue+")";
			out.print("excel.row[i]="+i+",sql=："+sql+"<br>");
			ps = conn.prepareStatement(sql);
			
			// 程序处理的字段：(guid,loginid,classId)
			list.add(guid);
			list.add(loginid);
			list.add(classId);
			
			for (int j = Integer.parseInt(columnStartIndex); j <= Integer.parseInt(columnEndIndex); j++) {
				cell = sheet1.getCell(j, i);
				list.add(cell.getContents());
				System.out.println("sheet1.getCell(j, i)="+sheet1.getCell(j, i)+"   i="+j+"  i="+i+" list.size()="+list.size()+"  cell="+cell.getContents());
			}
			
			int jj = 1;
			for (int ii = 0; ii < list.size(); ii++) {
				ps.setString(jj++, (String)list.get(ii));
			}
			
			ps.executeUpdate();
			ps.close();
			
			// 清空
			list.clear();
			
			flag = 1;
		}
	}
	
	book.close();
	
	if(flag == 0){
		out.print("<font color='red'>该excel无合法学时数据...</font>");
		return;
	}else{
		out.print("<font color='red'>导入学时数据完成...</font>");
	}
	
	
} catch (Exception e) {
	System.out.println("trainingSchoolTime.jsp.......Exception :"+e.getMessage());
	out.print("<font color='red'>bug信息："+e.getMessage()+"</font>");
	e.printStackTrace();
	return;
}finally{
	DbUtil.close(ps);
	DbUtil.close(conn);
}
    out.print("<script> goList();</script>");

}
%>


</html>