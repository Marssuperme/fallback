<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="cn.org.gdicpa.web.pub.fileupload.MyFileUpload"%>
<%@page import="cn.org.gdicpa.web.service.dataupload.DisposeTableService"%>
<%@page import="cn.org.gdicpa.web.service.dataupload.UploadDataService"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.util.FileUtil"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="cn.org.gdicpa.web.pub.autocode.DELUnid"%>
<%@page import="cn.org.gdicpa.web.pub.listener.UserSession"%>
<%@page import="cn.org.gdicpa.web.pub.net.Web"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//date.jsp是用来转换日期格式所使用的工具类（主要用来转换BB_CONTENT1中的广州历史数据中"报告日期"不规范的日期）
		Connection conn = null;
		
		try{
			conn = new DBConnect().getConnect();
			String sum = new DbUtil(conn).queryForString("select count(1) from bb_content1 where bgrq like '%AM%'");
			
			String zcze = new DbUtil(conn).queryForString("select zcze from bb_sjb where guid='b1046f29-356b-471c-9631-a2175a0918f7'");
			
			String zczetzh = new DbUtil(conn).queryForString("select zczetzh from bb_sjb where guid='b1046f29-356b-471c-9631-a2175a0918f7'");
			
			out.println(zcze + "<-------->" + zczetzh);
			
			
			String sql = "select guid,bgrq from bb_content1 where bgrq like '%AM%'";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			PreparedStatement pstmt = conn.prepareStatement("update bb_content1 set bgrq=? where bgrq like '%AM%' and guid=?");
			
			out.print("<h1>总数 ： "+sum+" 条记录。</h1><hr>");
			int i = 1;
			while(rs.next()){
				String bgrqString = rs.getString("bgrq");
				String guid = rs.getString("guid");
				String [] arr = bgrqString.split("\\s");
				String str = "";
				if(arr.length==4){
					str+=arr[2]+"-"+arr[0]+"-"+arr[1];
				}else{
					str+=arr[3]+"-"+arr[0]+"-0"+arr[2];
				}
				
				pstmt.setString(1,str);
				pstmt.setString(2,guid);
				pstmt.addBatch();
				if(i++%100==0){
					pstmt.executeBatch();
					//out.println("第"+(i-1)+"次执行一次<br/>");
				}
				
				out.println(bgrqString+"<--------"+i+"-------->" +str+"<br/>");
			}
			pstmt.executeBatch();
			
			DbUtil.close(rs);
			DbUtil.close(stmt);
			DbUtil.close(pstmt);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.checkConn(conn);
		}
	 %>
</body>
</html>