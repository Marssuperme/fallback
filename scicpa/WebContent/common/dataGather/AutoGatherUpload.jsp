<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
   
<html>
<head>
<title>装载采集数据</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
<body>
<bgsound  id="bgs" src="" loop="">
<font color="#FF0000" size="2"><strong>您现在所在位置： </strong></font>
<font color="#0000CC">数据采集-&gt;导入数据</font>
<br>
<table width="500" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="1" bgcolor="#0000FF"></td>
	</tr>
</table>
<%

	int opt = 0;

	// 该变量用于接收带文件上传情况下前台提交的参数
	Map parameters = null;
	// 该变量用于记录用户是否确认要覆盖原有数据

	// 该变量记录了文件解压的临时目录
	String uploadtemppath = "";

	int error = 0;
	int exist = 0; // 用于标记帐套数据是否已经存在;
//	int userconfirm = 0;  //用户是否同意了重新装载
	//获取用户对象
	UserSession userSession = (UserSession)session.getAttribute("userSession");
	
	ASFuntion CHF=new ASFuntion();
	
	String loginid = "";
	String loginname = "";
	if(userSession != null){
		loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
		loginname = CHF.showNull((String)userSession.getUserMap().get("loginname"));
	}
	String bbtime = CHF.getDateAndTime(); 
	
	String filename = "";
	String sql = ""; 

	Connection conn = new DBConnect().getConnect();

	//处理上传文件
	try {
		MyFileUpload myfileUpload = new MyFileUpload(request); 
		uploadtemppath = myfileUpload.UploadData(); 
		parameters = myfileUpload.getMap();
//		customerid = (String) parameters.get("customerid");
		filename = (String) parameters.get("filename");
		
//		EndDate = (String) parameters.get("EndDate");
	} catch (Exception e) {
		out.println("解析采集文件错误,错误原因：" + e.getMessage() + "<br>");
		out.println("<a href=\""+ request.getContextPath()+ "/common/dataGather/dataupload1.jsp\">点击返回装载页面</a></font>");
		out.flush();
		return;
	}

//		 如果不存在,说明是第一次提交,这个时候开始解压
	uploadtemppath = (String) parameters.get("tempdir");

	

	PreparedStatement ps = null;
	ResultSet rs = null;

	String lockmsg = "";
	String newpackageid = DELUnid.getNumUnid();

	// 注意这里不采用连接池，而是采用直接启动一个数据库连接的方式进行；
	// 初始化业务对象
	UploadDataService upload = null;
	try {
		try {
			upload = new UploadDataService(uploadtemppath, conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("临时路径或者客户编号设置有误,请与系统管理员联系<br>");
		}            

		//暂不校验审计机构信息

		// 分析帐套文件,取出帐套年份;
		String re[] = null;
		int iNf = 0;
		String nf="";
		try {
			re = upload.getPackageId();
			nf = re[1];
			iNf=Integer.parseInt(nf.trim());	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("预处理分析帐套文件,取出帐套年份出错,请联系系统管理员<br>");
		}

		out.println("预处理分析帐套文件,本次报备年份为" + nf + "<br/>");

		//报备的装载的表
		Map tableMap = new HashMap();
		
		//tableMap.put("BB_Area","报备地区表");
		tableMap.put("BB_BBQTB","报备其他表");
		tableMap.put("BB_CCSSSQKCJJB","财产损失税前扣除鉴证表");
		tableMap.put("BB_CompanyList","报备事务所表");
		tableMap.put("BB_CONTENT1","报备主表");
		
		tableMap.put("BB_KJDSHB","会计电算化表");
		tableMap.put("BB_KJZSB","会计咨询表");
		tableMap.put("BB_QCHZB","清产核资表");
		tableMap.put("BB_QSSHB","清算审计表");
		tableMap.put("BB_QTSSJJB","其他涉税鉴证表");
		
		tableMap.put("BB_SDSHSQJB","所得税汇算清缴表");
		tableMap.put("BB_SFKJJDB","司法会计鉴定表");
		tableMap.put("BB_SJB","审计表");
		tableMap.put("BB_SWDLB","税务代理表");
		//tableMap.put("BB_Type","报备类型表");
		
		tableMap.put("BB_YZB","验资表");
		tableMap.put("BB_ZCPGB","资产评估表");
		
		tableMap.put("BB_WHNJB","外汇年检表");
		
		tableMap.put("BB_SUM","报备汇总表");
		
		upload.setTable( tableMap,newpackageid);//建表
		
		int t1 = 0, t2 = 0,t3=0;


		out.println("开始装载报备数据<br>");
		out.flush();

		// 切换到客户数据分库
		DisposeTableService optable = new DisposeTableService(conn);

		//装载MT包的数据
		Set coll = tableMap.keySet();
		for (Iterator iter = coll.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			String value = (String) tableMap.get(key);
			
			out.println("开始装载"+value+"信息...");
			out.flush();
			//optable.DeleteData("tt_" + key, newpackageid);
			upload.setTableName(key);
			upload.insertToDB(newpackageid);
			out.println("装载"+value+"信息成功<br>");
			out.flush();
			
		}

		//修改【报备人】= 事务所编号
		sql = "update a set a.bbperson = b.loginid " + 
		" from tt_BB_CONTENT1"+newpackageid+" a ,tt_BB_CompanyList"+newpackageid+" b " +
		" where a.companyguid = b.guid and isnull(a.bbperson,'') = '' ";
		
		ps = conn.prepareStatement(sql);
		ps.execute();
		DbUtil.close(ps);
		
		
		//out.println("去除各个临时表中 主键的前后空格...<br>");
		//out.flush();
		//去除各个临时表的主键前后存在的空格
		//upload.exeTempTabTrimGuid(tableMap,newpackageid);//TODO---------------
		//out.println("去除各个临时表中主键的前后空格完成<br>");
		//out.flush();
		
		//检查分析提交的数据信息
		out.println("检查分析提交的数据信息...<br>");
		out.flush();
		//保存文件名
		upload.setUpFileName(filename);
		
		StringBuffer errInfo = new StringBuffer();
		//TODO----------------------------------------------------
		//更新正式表前先要查临时数据是否符合要求，如果不符合要求则不更新正式表，并记录日志。否则就更新到正式表中去。
		//1、（临时表）检查上报的记录数与实际记录数是否一致
		try{upload.testBbCount();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
		//2、（临时表）业务表的总记录跟报备表的总记录要一致
		try{upload.testYwtabAndBbtabCountSame();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
		//3、（临时表）报备记录中是否存在相同GUID的记录。
		try{upload.testBbGUID();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
		//4、（临时表）业务记录中是否存在相同GUID的记录。
		try{upload.testYwGUID();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
		//5、（临时表）报备记录中是否存在相同报备编号的记录。
	 	try{upload.testBbBBBH();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
	 	//6、（临时表）各个临时表的GUID是否存在空格现象
	 	try{upload.testBlankIsInGUID(tableMap,newpackageid);}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
		//7、（临时表）业务表的总记录跟报备表的记录没有一一对应（GUID关联）
	 	try{upload.testYwtabJoinBbtab();}catch(Exception e){errInfo.append(e.getMessage()).append("<br/>");}
	 	//8、（临时表）报备事务所信息是否存在与报备表不关联的记录
	 	try{upload.testCompanyList();}catch(Exception e){errInfo.append(e.getMessage());}
	 	
	 	if(errInfo.length()!=0){
	 		throw new Exception(errInfo.toString());
	 	}
		out.println("检查分析提交的数据信息通过<br>");
		out.flush();
		//删除数据库同地区的数据，并复制数据到系统表
		out.println("复制信息到系统中...<br>");
		out.flush();
		String area = upload.createTable(tableMap,newpackageid); 
		out.println("复制信息成功<br>");
		out.flush();
		
		//删除临时表
		out.println("删除报备临时表...<br>");
		out.flush();
		
		upload.delTable(tableMap,newpackageid);//TODO---------------
		out.println("删除报备临时表成功<br>");
		out.flush();
		
		//写日志
		String url = Web.getIp(request);
		System.out.println("URL:"+url);

		if(loginid == null || "".equals(loginid)){
			loginid = "";
			loginname = "系统自动装载";
		}
		String memo = "装载报备信息成功";
		//out.println("写入日志信息<br>");
		//out.flush();
		//upload.table(newpackageid); 
		//upload.setTableName("c_AccPackage"); //装载采集信息
		//upload.insertToDB(newpackageid);
		//upload.log( area, url, memo, newpackageid, loginid, loginname);
		//upload.delTable("tt_c_AccPackage" + newpackageid);
		out.println(memo + "<br>");
		out.flush();
		out.print("系统自动装载成功");
	} catch (Exception e) {
		e.printStackTrace();
		out.println("<font style=\"color:red\">装载处理出现错误：<br/>"
				+ e.getMessage());
		
		opt = 1;
		upload.saveLog(conn,e);

	} finally {
		DbUtil.close(rs);
		DbUtil.close(ps);
		DbUtil.close(conn);

		//删除装载文件目录
		try {
			if(opt == 0){
				//FileUtil.delDir(uploadtemppath);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		/* if(opt == 0){
			out.write(" <script> ");
			out.write(" try { ");
			out.write("		window.opener=null; ");
			out.write("		window.open('','_self'); ");
			out.write("		window.close(); ");
			out.write("	}catch(e) { ");
			out.write("	} ");
			out.write(" </script> ");
		} */
	}
%>
</body>
</html>
