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
<%@page import="cn.org.gdicpa.web.pub.autocode.DELAutocode"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
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
<input type="hidden" id="p" name="p" value="">
<input type="hidden" id="fileName" name="fileName" value="">
<center>
<table style="margin-top: 15px;">
<tr>
<td><font style="font-size: 20px;">请导入学时excel：</font></td>
<td><input type="file" id="upload" name="upload" size="50" ></td>
</tr>
</table>

<br> 
<input type="button" value="确定" onclick="f_sure()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="取消" onclick="window.close()">

</center>

 </form>
	 
</body>


<script type="text/javascript">
	function f_sure(){
		var bbtype = document.getElementById("bbtype").value+".xls";
		var path = document.getElementById("upload").value;
		if(path=="" || path==null){
			alert("请选择上传的文件！");
			return ;
		}
		document.getElementById("p").value = "sure";
		var fileName = path.substring(path.lastIndexOf("\\")+1);
	
		if(bbtype != fileName){
			alert("上传的excel与所选择的报备类型不匹配!");
		}else{
		document.getElementById("fileName").value = fileName;
		document.getElementById("myform").action = "importBBData.jsp?p=sure";
		document.getElementById("myform").submit();
		}
	}
	
	
	// 刷新列表
	function goList(typeid){
		if(confirm("确定刷新列表吗？")){
			window.opener.location.href="${pageContext.request.contextPath}/common/bb.do?method=index&typeid="+typeid;
			window.close();
		}
	}
	
</script>

<%

String p = request.getParameter("p");
if("sure".equalsIgnoreCase(p)){
UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
Map userMap = userSession.getUserMap();
String loginid = (String)userMap.get("loginid");
String loginName = (String)userMap.get("loginname");
String area = (String)userMap.get("area");//事务所所在地区

System.out.println("loginid="+loginid);
 
// 上传文件
MyFileUpload fileupload = new MyFileUpload(request);
ASFuntion as = new ASFuntion();
String date = as.getDateAndTime1();
String temp = date.replace("-","").replace(" ","").replace(":","")+"/";
String classPath = (String)new BbService().getMapInfo().get("classPath");
String filePath = new File(classPath).getParentFile().getParentFile().getPath() ;
filePath = filePath+"/common/BBExcelData"+"/"+loginid+"/"+temp;
File file = new File(filePath);
if(!file.exists()) {
	file.mkdirs() ;
}
 
fileupload.UploadFile(null,filePath);

Map map = fileupload.getMap();

String fileName = (String)map.get("fileName");

String bbtype = (String)map.get("bbtype");

String bbTypeId = "";

// 读取 excel 数据 保存到数据库
Connection conn = null;
PreparedStatement ps = null;
try {
	conn = new DBConnect().getConnect();
	bbTypeId = new DbUtil(conn).queryForString("select guid from bb_type where typename = ?",new Object[]{bbtype});
	
	Workbook book = Workbook.getWorkbook(new File(filePath+"/"+fileName));
	Sheet sheet1 = book.getSheet(0);
	// 得到 excel 的行
	int rows = sheet1.getRows();

	// 得到 excel 的列
	int cols = sheet1.getColumns();
	
	
	// 读取配置，拼凑 sql
	BbService bs = new BbService();
	
	if(fileName!=null && !"".equals(fileName)){
		fileName = fileName.substring(0,fileName.indexOf("."));
	}
	
	System.out.println("rows="+rows+"              cols="+cols+"          fileName="+fileName);
	
	map = bs.getSqlByType(fileName);
	// 事务所信息
	String companyListTable = (String)map.get("companyListTable");
	String companyListCol = (String)map.get("companyListCol");
	String companyListColValue = (String)map.get("companyListColValue");
	String companyListColStartIndex = (String)map.get("companyListColStartIndex");
	String companyListColEndIndex = (String)map.get("companyListColEndIndex");

	// 报备内容一信息
	String content1Table = (String)map.get("content1Table");
	String content1Col = (String)map.get("content1Col");
	String content1ColValue = (String)map.get("content1ColValue");
	String content1ColStartIndex = (String)map.get("content1ColStartIndex");
	String content1ColEndIndex = (String)map.get("content1ColEndIndex");
	
	// 报备内容二信息
	String detailTable = (String)map.get("detailTable");
	String detailCol = (String)map.get("detailCol");
	String detailColValue = (String)map.get("detailColValue");
	String detailColStartIndex = (String)map.get("detailColStartIndex");
	String detailColEndIndex = (String)map.get("detailColEndIndex");
	
	
	Cell cell = null;
	List list = new ArrayList();
	
	String companyGuid = "";
	String content1Guid = "";
	
	out.print("<font color='red'>开始导入报备数据...<br></font>");
	int flag = 0;
	
	// 保存 
	for (int i = 2; i < rows; i++) {
		if(!"".equals(sheet1.getCell(8,i).getContents()) && null != sheet1.getCell(8,i).getContents()){
			// 事务所表
			String sqlCompany = "insert into "+companyListTable+" ("+companyListCol+") values("+companyListColValue+")";
			out.print("excel.row[i]="+i+",事务所："+sqlCompany+"<br>");
			ps = conn.prepareStatement(sqlCompany);
			
			// <column>Guid,Loginid,CompanyName,area,LanguageSelectName,Person,Phone,Faxes,Post,Address,Email,Url</column>
			// 程序处理的字段：(guid,loginid,companyName,area,languageSelectName)
			companyGuid = UUID.randomUUID().toString();
			list.add(companyGuid);
			list.add(loginid);
			list.add(loginName);
			list.add(area);
			list.add(loginName);
			
			for (int j = Integer.parseInt(companyListColStartIndex); j <= Integer.parseInt(companyListColEndIndex); j++) {
				cell = sheet1.getCell(j, i);
				list.add(cell.getContents());
			}
			
			int jj = 1;
			for (int ii = 0; ii < list.size(); ii++) {
				ps.setString(jj++, (String)list.get(ii));
			}
			
			ps.executeUpdate();
			ps.close();
			
			// 清空
			list.clear();
			
			
			// 报备表
			String sqlContent = "insert into "+content1Table+" ("+content1Col+") values("+content1ColValue+")";
			out.print("excel.row[i]="+i+",报备表："+sqlContent+"<br>");
			ps = conn.prepareStatement(sqlContent);
			
			
			// 程序处理的字段：(companyguid,guid,bbbh,typeid,bbperson,bbstate,bbtime)
			content1Guid = UUID.randomUUID().toString();
			
			list.add(companyGuid);
			list.add(content1Guid);
			list.add(new DELAutocode().getAutoCode("报备编号", area));
			list.add(bbTypeId);
			list.add(loginid);
			list.add("暂存");
			list.add(new ASFuntion().getDateAndTime1());        
			// 联系人
			list.add(sheet1.getCell(0, i).getContents());
			// 联系电话
			list.add(sheet1.getCell(1, i).getContents());            
			
			for (int j = Integer.parseInt(content1ColStartIndex); j <= Integer.parseInt(content1ColEndIndex); j++) {
				cell = sheet1.getCell(j, i);
				System.out.println("报备表：="+cell.getContents());
				list.add(cell.getContents());
			}
			
			int jc = 1;
			for (int ii = 0; ii < list.size(); ii++) {
				ps.setString(jc++, (String)list.get(ii));
			}
			
			ps.executeUpdate();
			ps.close();
			
			// 清空
			list.clear();
			
			
			// 报备分类
			String sqlDetail = "insert into "+detailTable+" ("+detailCol+") values("+detailColValue+")";
			out.print("excel.row[i]="+i+","+map.get("typeName")+"报备分类："+sqlDetail+"<br>");
			ps = conn.prepareStatement(sqlDetail);
			
			// 报备分类表主键
			list.add(content1Guid);
			
			for (int j = Integer.parseInt(detailColStartIndex); j <= Integer.parseInt(detailColEndIndex); j++) {
				cell = sheet1.getCell(j, i);
				list.add(cell.getContents());
			}
			
			int jd = 1;
			for (int ii = 0; ii < list.size(); ii++) {
				ps.setString(jd++, (String)list.get(ii));
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
		out.print("<font color='red'>该excel无合法报备数据...</font>");
		return;
	}else{
		out.print("<font color='red'>导入报备数据完成...</font>");
	}
	
	
} catch (Exception e) {
	System.out.println("importBBData.jsp.......Exception :"+e.getMessage());
	out.print("<font color='red'>bug信息："+e.getMessage()+"</font>");
	e.printStackTrace();
	return;
}finally{
	DbUtil.close(ps);
	DbUtil.close(conn);
}
    out.print("<script> goList('"+bbTypeId+"');</script>");

}
%>


</html>