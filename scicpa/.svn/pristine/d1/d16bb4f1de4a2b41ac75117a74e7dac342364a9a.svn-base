<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>operateDB.jsp</title>
<style>
a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

<form id="myform" name="myform" method="post" >

<br>
<span>
<input type="password" id="pwd" name="pwd" style="vertical-align: top;">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="pwdBtn" name="pwdBtn" value="解开潘多拉" onclick="f_show()" >
</span>

<br><br>

<div style="margin-left: 10px;display: none" id="sqlDivObj" >

<br>
<font style="font-size: 17;color: red">请录入sql：</font><br><br>
<textarea rows="10%" cols="90%" id="optSql" name="optSql">${optSql}</textarea>
<br><br>
<textarea rows="4%" cols="90%" id="optSqlResult" name="optSqlResult" style="display: none" onkeypress="return false;">${optSqlResult}</textarea>
<br><br>
<input type="button" value="执行" onclick="f_execute()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="关闭" onclick="window.close()">

</div>

</form>
	 
</body>


<script type="text/javascript">
		
	// 显示
	function f_show(){
		var pwd = document.getElementById("pwd").value;
		if(pwd != ""){
			if(pwd=="password"){
				document.getElementById("sqlDivObj").style.display = "";
			}else{
				alert("密码错误!如果不知道请查看源代码!");
				document.getElementById("pwd").select();
				document.getElementById("sqlDivObj").style.display = "none";
			}
		}else{
			alert("请输入密码！");
			document.getElementById("sqlDivObj").style.display = "none";
		}
	}
	
	// 执行 sql
	function f_execute(){
		var optSql = document.getElementById("optSql").value;
		//正则，\s匹配空格和回车等
		var parten = /^\s*$/ ;
		
		//执行验证
		if(parten.test(optSql)){
			alert("没sql，不执行！");
			return ;
		}else{
			var optSql = document.getElementById("optSql").value;
			optSql = optSql.toLowerCase();
			
			if(optSql.indexOf("insert")>-1 || optSql.indexOf("update")>-1 || optSql.indexOf("delete")>-1){
				if(confirm("您确定要进行持久化到数据库操作吗？可能导致不可恢复的数据操作！")){
					document.getElementById("myform").action = "operateDB.jsp?isExecute=Y";
					document.getElementById("myform").submit();
				}
			}else{
				document.getElementById("myform").action = "operateDB.jsp?isExecute=Y";
				document.getElementById("myform").submit();
			}
		}
		
	}
	
	
</script>

<%
String isExecute = request.getParameter("isExecute");
if("Y".equalsIgnoreCase(isExecute)){
ASFuntion af = new ASFuntion();
String optSql = af.showNull(request.getParameter("optSql"));
optSql = optSql.toLowerCase();

optSql = optSql.replaceAll("\r"," ");
optSql = optSql.replaceAll("\n"," ");

Connection conn = null;
String optSqlResult = "";
try {
	conn = new DBConnect().getConnect();
	int executeValue = 0;
	if(optSql.indexOf("select")>-1 && optSql.indexOf("from")>-1 
			&& optSql.indexOf("delete")<0 && optSql.indexOf("update")<0 && optSql.indexOf("insert")<0){
		optSqlResult = af.showNull(new DbUtil(conn).queryForString(optSql));
	}else{
		executeValue = new DbUtil(conn).executeUpdate(optSql);
		if(executeValue>0){
			optSqlResult = "恭喜成功持久化到数据库了！";
		}else{
			optSqlResult = "对不起,持久化到数据库失败了！或许没有符合您要求的数据!";
		}
	} 
	if("".equals(optSqlResult)){
		optSqlResult = "没有符合要求的记录！";
	}
	out.print("<script>");
	out.print("document.getElementById(\"optSql\").value=\""+optSql+"\" ;");
	out.print("document.getElementById(\"sqlDivObj\").style.display=\"\"; ");
	out.print("document.getElementById(\"optSqlResult\").style.display=\"\"; ");
	out.print("document.getElementById(\"optSqlResult\").value=\"sql执行返回的结果："+optSqlResult+"\" ;");
	out.print("</script> ");
} catch (Exception e) {
	System.out.println("operateDB.jsp.......Exception :"+e.getMessage());
	out.print("<font color='red'>BUG信息："+e.getMessage()+"。<br><br>BUG原因："+e.getCause().getMessage()+"</font>");
	out.print("<script>");
	out.print("document.getElementById(\"optSql\").value=\""+optSql+"\" ;");
	out.print("document.getElementById(\"optSqlResult\").style.display=\"none\"; ");
	out.print("document.getElementById(\"sqlDivObj\").style.display=\"\"; ");
	out.print("</script> ");
	e.printStackTrace();
}finally{
	DbUtil.close(conn);
}

}
%>


</html>