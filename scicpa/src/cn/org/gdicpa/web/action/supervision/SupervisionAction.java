package cn.org.gdicpa.web.action.supervision;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.content.ContentService;
import cn.org.gdicpa.web.service.inspection.InspectionService;
import cn.org.gdicpa.web.service.supervision.SupervisionService;
import cn.org.gdicpa.web.service.supervision.model.SupervisionTable;
import cn.org.gdicpa.web.service.testerNotice.TesterNoticeService;
import cn.org.gdicpa.web.service.testerNotice.model.TesterNoticeTable;
import cn.org.gdicpa.web.service.user.UserService;

public class SupervisionAction extends MultiActionController{
	private static String LIST = "/supervision/list.jsp";
	private static String ADDANDEDIT = "/supervision/add.jsp";
	private static String SEARCH = "/supervision/search.jsp";
	private static String SLIST = "/supervision/testerNoticeList.jsp";
	private static String TESTERVIEW = "/supervision/testerView.jsp";
	private static String DOWNREPORT = "/supervision/downReport.jsp";
	
	// 跳转
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LIST);
		String p = request.getParameter("p");
		String source = request.getParameter("source");
		if(p.equalsIgnoreCase("add")){
			model = new ModelAndView(ADDANDEDIT);
			model.addObject("source", source);
		}
		return model;
	}
	
	
	/**
	 * 默认方法
	 * @param request  
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		
		try {
			String sql = " select id,project,caption,body,companyname,IP,iuser,idate,"
				       + " auser,adate,status,result,projectId "
					   + " from supervision where iuser='"+loginid+"' ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("监管问题汇报信息");
			 
			pp.setInputType("radio");
			pp.setTableID("supervision");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("项目", "project"); 
			pp.addColumn("事务所名称", "companyname");
			pp.addColumn("发现的问题", "body");
			pp.addColumn("问题状态", "status");
			pp.addColumn("解答", "result");
			pp.addColumn("上报人", "iuser");
			pp.addColumn("上报时间", "idate");
			pp.addColumn("解答人", "auser");
			pp.addColumn("解答时间", "adate");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("idate");
			pp.setDirection("desc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addSupervisionTable(HttpServletRequest request,HttpServletResponse response,SupervisionTable st) throws IOException{
		Connection conn = null; 
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ip = request.getParameter("ip");
		String source = request.getParameter("source");
		System.out.println(this.getClass()+"     |             ip = "+ip);
		String loginid = (String)map.get("loginid"); 
		try {
			conn = new DBConnect().getConnect();
			ASFuntion af = new ASFuntion();
		    SupervisionService ss = new SupervisionService(conn);
		    st.setIdate(af.getCurrentDate());
		    st.setCaption(st.getBody());
		    st.setIp(ip);
		    st.setIuser(loginid);
		    st.setStatus("未解决");
		    ss.addSupervisionTable(st);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		// 监管作业链接过来的
		if("jgzy".equalsIgnoreCase(source)){
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jzzc");
		}else{
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jzzc&id="+nid+"&userid="+userid);
		}
		return null;
	}
	

	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateSupervisionStatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		Connection conn = null; 
	
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		
		try {
			conn = new DBConnect().getConnect();
 
		    SupervisionService ss = new SupervisionService(conn);
		    ss.updateSupervisionStuatus(id);
		    
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		// 监管作业链接过来的
		if("jgzy".equalsIgnoreCase(source)){
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jzzc");
		}else{
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jzzc&id="+nid+"&userid="+userid);
		}
		return null;
	}
	
	
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewSupervisionTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null; 
		
		ModelAndView model = new ModelAndView(SEARCH);
		
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		
		try {
			conn = new DBConnect().getConnect();
 
		    SupervisionService ss = new SupervisionService(conn);
		    SupervisionTable st = ss.getSupervisionTable(id);
		    st.setAuser(ss.getNameById(st.getAuser())); // 转成对应的名称 
		    st.setIuser(ss.getNameById(st.getIuser())); 
		    model.addObject("st",st);
		    model.addObject("source",source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		 
		return model;
	}
	
	/**
	 * 得到状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewStatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String id = StringUtil.showNull(request.getParameter("id"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			SupervisionService ss = new SupervisionService(conn);
			String status = StringUtil.showNull(ss.viewStuatus(id));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> status = "+status);
			if(status.equals("办结")){
				out.print("yes");
			}else{
				out.print("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	/**
	 * 监管作业   list 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView testerNoticeList(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      list(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(SLIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		
		try {
			String sql = " select n.id as nid,c.id as cid,n.userid as nuserid,c.userid as cuserid,atime,subString(testyear,1,4) as testyear," 
					   + " subString(testyear,1,4)+'年会计师事务所执业质量检查' as titleTemp, "
					   + " customername,title,acontent,astate,c.companyid,k.endPublishDate from "
					   + " dbo.k_TesterNotice as n left join k_testerComposition as c on n.id = c.noticeid " 
					   + " left join k_SuperviseMain k on n.id = k.testernoticeid " 
					   + " where c.astate = '批准' and n.status = '1' and c.userId='"+loginid + "'";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("监管项目信息");
			 
			//pp.setInputType("radio");
			pp.setTableID("testerNoticeList");
			//pp.setWhichFieldIsValue(1);
			
			//pp.addColumn("标题", "title","showCenter").setTdProperty("onclick=f_viewTD('${nid}','${cuserid}','${companyid}','${testyear}','${endPublishDate}')");
			pp.addColumn("标题", "titleTemp","showCenter").setTdProperty("onclick=f_viewTD('${nid}','${cuserid}','${companyid}','${testyear}','${endPublishDate}')");
			pp.addColumn("发起机构", "customername","showCenter");
			pp.addColumn("检查年份", "testyear","showCenter");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("atime");
			pp.setDirection("desc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	/**
	 * 到多页签
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goSupervision(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(TESTERVIEW);
		ASFuntion af = new ASFuntion();
		String id = af.showNull(request.getParameter("id"));               // 通知编号
		String userid = af.showNull(request.getParameter("userid"));       // 对应通知的报名人编号    这里只会列出单个人出来
		String companyid = af.showNull(request.getParameter("companyid"));       // 事务所编号
		String testyear = af.showNull(request.getParameter("testyear"));       // 年份
		String endPublishDate = af.showNull(request.getParameter("endPublishDate"));       // 结束时间
		String type = af.showNull(request.getParameter("type"));       
		
		if("".equals(type)){
			type = "dgxx";
		}
		
		if("".equals(id)){
			id = af.showNull((String)request.getSession().getAttribute("testnoticeid"));
		}
		if("".equals(userid)){
			userid = af.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		}
		if("".equals(companyid)){
			companyid = af.showNull((String)request.getSession().getAttribute("tcompanyid"));
		}
		if("".equals(testyear)){
			testyear = af.showNull((String)request.getSession().getAttribute("testyear"));
		}
		if("".equals(endPublishDate)){
			endPublishDate = af.showNull((String)request.getSession().getAttribute("endPublishDate"));
		}
		
		String valid = "Y";
		int param = 0;
		
		// “截止发布日期” 与 现在的时间 差额  ： 后面 减 前面 这个   
		if(endPublishDate!=null && !"".equals(endPublishDate)){
			param = new DateUtil().equalDate(af.getCurrentDate(),endPublishDate);
		}
		
		if(param<0){
			valid = "N";
			model.addObject("info","<font style=\"margin-left: 100px;color:red \" >请注意：截止日期已过</font>");
		}
		model.addObject("valid", valid);
		model.addObject("type", type);
		
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			//////////////
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			Map tmap = new HashMap();
			String loginname = (String)map.get("loginname"); 
			String officecode = (String)map.get("officecode"); 
			
			request.getSession().setAttribute("testnoticeid", id);
			request.getSession().setAttribute("testnoticeuserid", userid);
			request.getSession().setAttribute("tcompanyid", companyid);
			request.getSession().setAttribute("testyear", testyear);
			request.getSession().setAttribute("endPublishDate", endPublishDate);
			request.getSession().setAttribute("valid", valid);
			
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			InspectionService is = new InspectionService(conn);
			
			String idate = CHF.getDateAndTime();
			String iyear = idate.substring(0, 4);
			
			String tabname = (String)map.get("ctypetabname");
			String loginid = (String)map.get("loginid");

			//用户信息
			Map userMap = user.getUser( tabname, loginid);
			model.addObject("userMap",userMap); 
			
			String approve = (String)userMap.get("approve");	//用户资格的批准时间 
			String cpaid = (String)userMap.get("cpano"); //cpaid
			
			
			// 当前登录如 是否组长
			String sql0 = " select checkPost from dbo.k_SuperviseUser where cpano = ? and noticeId = ? ";
			String checkPost = af.showNull(new DbUtil(conn).queryForString(sql0, new Object[]{loginid,id}));
			request.getSession().setAttribute("checkPost", checkPost);
			
			// 当前登录人的组名
			String sql2 = " select groupname from dbo.k_SuperviseUser where cpano = ? and noticeId = ? ";
			String groupname = af.showNull(new DbUtil(conn).queryForString(sql2, new Object[]{loginid,id}));
			request.getSession().setAttribute("groupname", groupname);
			
			SupervisionService ss = new SupervisionService(conn);
			// 登陆人组的所有人
			List list = ss.getCheckMan(id, groupname);
			String loginIds = "";
			String loginNames = "";
			for (Object object : list) {
				Map mapTemp = (Map)object;
				loginIds = "'" + mapTemp.get("loginid") + "'" + ",";
				loginNames = "'" + mapTemp.get("loginname") + "'" + ",";
			}
			if(loginIds.indexOf(",")>-1){
				loginIds = loginIds.substring(0, loginIds.length()-1);
			}else{
				loginIds = "''";
			}

			if(loginNames.indexOf(",")>-1){
				loginNames = loginNames.substring(0, loginNames.length()-1);
			}else{
				loginNames = "''";
			}
			
			String sql = "",sql1 = "";
			
			// [基础信息]   -->   [首页  --  检查通知 ]
			TesterNoticeService tns = new TesterNoticeService(conn);
			TesterNoticeTable tnt = tns.getTesterNoticeTable(id);
			
			// 根据 userId找到  k_user　中对应的loginName
			String fbPerson = tns.getLoginName(tnt.getUserId());
			model.addObject("fbPerson",fbPerson);  // 通知的发起人
		    model.addObject("tnt",tnt);
		    
		    
		    //取下载清单的开始、结束的日期
		    String startime = "";
		    String endtime = "";
			String timeSql = "select startime,endtime from k_SuperviseMain where TesterNoticeID=?";
		    PreparedStatement pstmt = conn.prepareStatement(timeSql);
		    pstmt.setString(1, id);
		    ResultSet timeRs = pstmt.executeQuery();
		    while(timeRs.next()){
		    	startime = timeRs.getString("startime");
		    	endtime = timeRs.getString("endtime");
		    }
		    
		    System.out.println(startime+"<----------------->"+endtime);
		    model.addObject("startime",startime); 
		    model.addObject("endtime",endtime); 
		    DbUtil.close(timeRs);
		    DbUtil.close(pstmt);
		    
		    // [检查组成员]
		    // 姓名 事务所 CPA编号 职位 年龄 联系方式 执业年数  三年业务数
		    //  InitFlag,title,aname,loginname,CPANo,  applytime,pracyear,post, age,  mobile,     hj,     astate';
		    //  选择,     标题,报名人,事务所,   CPA编号,报名时间,  执业年数, 职位, 年龄, 联系方式,三年业务数, 状态';

		    /*
		    String date = (Integer.parseInt(CHF.getCurrentDate().substring(0, 4))-3)+"-01-01";  // 三年业务数,
		    
		    sql = " select a.id, a.noticeId,a.Companyid,max(a.rtx) as rtx,e.loginid,a.userid, e.IsTester, b.title, "
			    + " a.CPANo,c.loginname,a.tcname, a.applytime, a.astate,DateDiff(year, e.Approve, getDate())as pracyear,"
			    + " e.loginname as aname,e.post,DateDiff(year, e.BornDate, getDate()) as age,e.mobile,max(e.email) as email,k.hj "
			    + " from k_TesterComposition a left join k_TesterNotice b on a.noticeId=b.id  "
			    + " left join K_Company c on a.companyId=c.loginid "
			    + " left join K_Micfo e on a.userid=e.loginid "
			    + " left join( "
			    + " SELECT b.CPANO, COUNT(*) AS hj "
			    + " FROM BB_View AS a CROSS JOIN K_Micfo AS b "
			    + " WHERE b.loginid = '"+loginid+"' and ((a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA1 = b.CPANO) OR "
			    + " (a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA2 = b.CPANO) OR "
			    + " (a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA3 = b.CPANO) OR "
			    + " (a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA4 = b.CPANO) OR "
			    + " (a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA5 = b.CPANO) OR "
			    + " (a.QYRQ >= '"+date+"' AND a.QYRQ <= '"+CHF.getCurrentDate()+"' AND a.CPA6 = b.CPANO) )"
			    + " GROUP BY b.CPANO "
			    + " )as K on a.CPANo=k.cpano where b.status = '1' "
			    + " GROUP BY a.id, b.title, a.CPANo, a.tcname, a.applytime, a.astate,e.post,"
			    + " e.mobile, e.Approve,e.BornDate,c.loginname,e.loginname,k.hj, a.userid, e.loginid, "
			    + " e.IsTester, a.noticeId,a.Companyid";
		    */
		    sql = " select * from (" 
		    	+ " Select a.CPANO,b.LoginName as CPAName,c.LoginName as CompanyName ,GroupName,a.CheckPost, " 
		    	+ " d.Post,d.Mobile,d.EMail,d.RTX,orderId = case  when a.CheckPost='组长' then 0 else 1 end "
		    	+ " From k_SuperviseUser a "
		    	+ " left join (K_Micfo b inner join K_Company c on b.OfficeCode=c.LoginID) on a.CPANO=b.LoginID "
		    	+ " Left join k_TesterComposition d on a.CPANO=d.CPANO and a.NoticeID=d.NoticeID and d.aState='批准' "
		    	+ " Where a.NoticeID='"+id+"' and GroupName=(Select GroupName From k_SuperviseUser "
		    	+ " Where NoticeID='"+id+"' and CPANO='"+loginid+"') "
		    	+ " ) a ";
		    
		    DataGridProperty pp0 = new DataGridProperty();
			
		  //  pp0.setTitle("检查组成员信息");
			 
		    //pp0.setInputType("radio");
		    
		    pp0.setTableID("checkGroupPersonInfo");
		    
		    //pp0.setWhichFieldIsValue(2);
		    //  InitFlag,title,aname,loginname,CPANo,  applytime,pracyear,post, age,  mobile,     hj,     astate';
		    //  选择,     标题,报名人,事务所,   CPA编号,报名时间,  执业年数, 职位, 年龄, 联系方式,三年业务数, 状态';

		    // 姓名    事务所     CPA编号     职位     年龄     联系方式      执业年数     三年业务数
		    pp0.addColumn("检查人员", "CPAName"); 
		    pp0.addColumn("所属事务所", "CompanyName","showCenter");
//		    pp0.addColumn("CPA编号", "CPANo","showCenter");
		    pp0.addColumn("职位", "CheckPost","showCenter");
//		    pp0.addColumn("年龄", "age","showCenter");
		    pp0.addColumn("手机号码", "Mobile","showCenter");
		    pp0.addColumn("邮箱", "EMail","showCenter");
		    pp0.addColumn("即时通讯", "RTX","showCenter");
//		    pp0.addColumn("执业年数", "pracyear","showCenter");
//		    pp0.addColumn("三年业务数", "hj","showCenter");
//		    pp0.addColumn("状态", "astate","showCenter");
			
			
		    pp0.setSQL(sql);
		    pp0.setOrderBy_CH("orderId");
		    pp0.setDirection("asc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp0.getTableID(), pp0);
			
			
			// 检查资料下载
			// sql = " select l.*,u.loginname from s_lineup l left join k_user u on l.lineupPerson = u.loginid where lineupperson = '"+loginid+"'";
			
			sql = " Select subString(tn.testyear,1,4) as testyear,c.loginname,sc.companyid,sc.scheck,sm.state "
				+ " From k_SuperviseCompany sc"
				+ " left join k_SuperviseUser su on su.groupname = sc.checkgroup and su.MainID=sc.MainID" 
				+ " left join k_company c on sc.companyid = c.loginid "
				+ " left join k_TesterNotice tn on su.noticeid = tn.id "
				+ " left join k_SuperviseMain sm on sm.testernoticeid = tn.id "
				+ " where su.cpano = '"+loginid+"' and subString(tn.testyear,1,4) = '"+testyear+"' ";
			
			DataGridProperty pp1 = new DataGridProperty();
			
			System.out.println("-----------》testyear ： "+testyear);
			
			// pp1.setTitle("监管底稿上报");
			 
			pp1.setTableID("zlxzList");
			pp1.setWhichFieldIsValue(1);
			
//			if(param>=0){
//				pp1.addColumn("被检查事务所", "loginname").setTdProperty(" onclick=\"downReport('${testyear}','${companyid}','${loginname}','${state}');\"  style='text-align:center'");
//			}else{
				pp1.addColumn("被检查事务所", "loginname");
//			}
			pp1.addColumn("检查类型", "scheck","showCenter");
			pp1.addColumn("年份", "testyear","showCenter");
			if(param>=0){//'${startime}','${endtime}',
				pp1.addColumn("操作", "loginname").setColContent("<div style='text-align: center;'><a href=\"###\" onclick=\"downReport('${testyear}','${companyid}','${loginname}','${state}');\">【自查报告下载】</a>&nbsp;|&nbsp;<a href=\"###\" onclick=\"downProject('${companyid}','${loginname}','${state}');\">【项目清单下载】</a> </div>");
//				pp1.addColumn("操作", "loginname").setColContent("<div style='text-align: center;'><a href=\"###\" onclick=\"downReport('${testyear}','${companyid}','${loginname}','${state}');\">【自查报告下载】</a>&nbsp;|&nbsp;<a href=\"###\" onclick=\"downProject('${testyear}','${companyid}','${loginname}','${state}');\">【项目清单下载】</a> </div>");
			}else{
				pp1.addColumn("操作", "loginname").setColContent("<div style='text-align: center;'><a >【自查报告下载】</a>&nbsp;|&nbsp;<a >【项目清单下载】</a> </div>");
				
			}
			pp1.setColumnWidth("30%,20%,10%,40%");
//			pp1.addColumn("上传时间按", "lineuptime","showCenter");
			
			pp1.setSQL(sql);
			pp1.setOrderBy_CH("testyear");
			pp1.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
			
			
			// 进度管理
//			sql = " select s.id,supid,begindate,enddate,s.userid,u1.loginname as loginname1,u2.loginname as loginname2,p.projectName," 
//				+ " comevaluation,proevaluation,progresscnt " 
//				+ " from K_SupProgress s left join k_user u1 on s.userid = u1.loginid "
//				+ " left join k_user u2 on s.companyid = u2.loginid "  
//				+ " left join k_SuperviseSub p on s.projectid = p.projectid "
//				+ " where userid = '"+loginid+"' ";
			
			sql = " select s.id,supid,begindate,enddate,s.userid,companyId,projectId," 
				+ " comevaluation,proevaluation,progresscnt " 
				+ " from K_SupProgress s "  
				+ " where userid = '"+loginid+"' ";
		
			DataGridProperty pp2 = new DataGridProperty();
			
			// pp2.setTitle("监管底稿上报");
			 
			pp2.setInputType("radio");
			pp2.setTableID("jdglList");
			pp2.setWhichFieldIsValue(1);
			
			pp2.addColumn("开始时间", "begindate","showCenter");
			pp2.addColumn("结束时间", "enddate","showCenter");
			pp2.addColumn("被检查事务所", "companyId","showCenter");
			pp2.addColumn("被检查项目", "projectId","showCenter");
			pp2.addColumn("被检查事务所评价", "comevaluation","showCenter");
			pp2.addColumn("被检查项目评价", "proevaluation","showCenter");
			
			pp2.setSQL(sql);
			pp2.setOrderBy_CH("begindate");
			pp2.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp2.getTableID(), pp2);
			
		    
		    //  在线填报
			sql = " select s.id,s.title as stitle,t.title as ttitle,s.taskMan,s.PublishType,s.enddate,s.createDate,s.department,s.CustomerName "
			       + " from K_SupTask s "
				   + " left join k_testernotice t "
				   + " on s.NotcieID = t.id " 
				   + " left join k_reply r "
				   + " on s.id = r.tid " 
				   + " where s.state='已审核' " 
				   + " and r.replyer = '"+loginid+"' ";
			
			DataGridProperty pp3 = new DataGridProperty();
			pp3.setTableID("supTaskList");
			pp3.setWhichFieldIsValue(1);
			pp3.addColumn("标题", "stitle").setTdProperty(" style=\"text-align:center\" onclick=\"goViewSupTask('${id}');\" ");
			pp3.addColumn("检查通知标题", "ttitle","showCenter");
//			pp3.addColumn("填报人", "taskMan","showCenter");
//			pp3.addColumn("发布部门", "department","showCenter");
			pp3.addColumn("发布机构", "CustomerName","showCenter");
			pp3.addColumn("发布类型", "PublishType","showCenter");
			pp3.addColumn("开立时间", "createDate","showCenter");
			pp3.addColumn("截止日期", "enddate","showCenter");
				
			pp3.setSQL(sql);
			pp3.setOrderBy_CH("createDate");
			pp3.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp3.getTableID(), pp3);
			
			
			// 项目填报
			// sql = " select * from  k_projectFill where 1=1 and fillUserId='"+loginid+"' ${companyName} ${projectName} ${fillUserName} ${fillTime} ";
			
			sql = " select s.id,c.loginname as companyName,s.projectname,m.loginname,subString(filltime,1,10) as filltime "
				+ " from k_SuperviseSub s left join k_company c on s.loginid = c.loginid "
				+ " left join k_micfo m on s.fillBy = m.loginid "
				+ " where fillBy in ("+loginIds+") ";
			
			DataGridProperty pp5 = new DataGridProperty();

			pp5.setInputType("radio");
			
			pp5.setTableID("projectFillList");
			pp5.setWhichFieldIsValue(1);
			
			pp5.addColumn("被检查事务所", "companyName","showCenter");
			pp5.addColumn("项目名称", "projectName","showCenter");
			pp5.addColumn("填报人", "loginname","showCenter");
			pp5.addColumn("填报时间", "fillTime","showCenter");
			
			//pp5.setTitle("项目填报信息");
			pp5.setPageSize_CH("10");
			
			pp5.setSQL(sql);
			pp5.setOrderBy_CH("fillTime");
			pp5.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp5.getTableID(), pp5);
				
			
		    
		    // [问题汇报]
		    // http://127.0.0.1:8080/GZZX/common/supervision.do
		    sql = " select id,project,caption,body,companyname,IP,iuser,idate,"
			       + " auser,adate,status,result,projectId "
				   + " from supervision where iuser = '"+loginid+"'";
		
			DataGridProperty pp6 = new DataGridProperty();
			
			//pp6.setTitle("监管问题汇报信息");
			 
			//pp6.setInputType("radio");
			pp6.setTableID("supervision");
			//pp6.setWhichFieldIsValue(1);
			  
			pp6.addColumn("被检查项目", "project").setTdProperty(" style=\"text-align:center\" onclick=\"f_view('${id}');\" "); 
			pp6.addColumn("被检查事务所", "companyname");
			pp6.addColumn("发现的问题", "body");
			pp6.addColumn("问题状态", "status");
			pp6.addColumn("解答", "result");
			pp6.addColumn("上报人", "iuser");
			pp6.addColumn("上报时间", "idate");
			pp6.addColumn("解答人", "auser");
			pp6.addColumn("解答时间", "adate");
			
			
			pp6.setSQL(sql);
			pp6.setOrderBy_CH("idate");
			pp6.setDirection("desc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp6.getTableID(), pp6);
		    
			
			// [监管底稿上报（新做）]
			sql = " select l.id,l.lineupname,l.lineupperson,l.lineuptime,l.attachment,l.memo,l.noticeid,u.loginname " 
				+ " from s_lineup l left join k_user u on l.lineupPerson = u.loginid where lineupperson = '"+loginid+"'";
		
			DataGridProperty pp7 = new DataGridProperty(); 
			
			// pp7.setTitle("监管底稿上报");
			pp7.setTableID("lineup");
			if(param>=0){
				pp7.setInputType("radio");
				pp7.setWhichFieldIsValue(1);
				pp7.addColumn("底稿名称", "lineupname","showCenter").setTdProperty(" onclick=\"goViewLineup('${id}');\" ");
			}else{
				pp7.addColumn("底稿名称", "lineupname","showCenter");
			}
			
			pp7.addColumn("上传人", "loginname","showCenter");
			pp7.addColumn("上传时间", "lineuptime","showCenter");
			pp7.setSQL(sql);
			pp7.setOrderBy_CH("lineuptime");
			pp7.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp7.getTableID(), pp7);
			
		    
		    // [监管费用（新做）]
		    // ( OA---业务监管模块--监管工时费用报备管理 ) 仅作参考
			sql = " select id,fillMan,checkProject,checkoffice,fillTime,totalDays,totalCheckPay,"  
				   + " totalfoodPay,totalbusinessTrips,totalCountMoney,propertys "
				   + " from k_hourcostmain where fillMan='"+loginname+"' and checkoffice='"+officecode+"' ";
		
			DataGridProperty pp8 = new DataGridProperty();
			
			//pp8.setTitle("监管工时费用信息");
			 
			pp8.setTableID("hourCostMain");
			
			if(param>=0){
				pp8.setInputType("radio");
				pp8.setWhichFieldIsValue(1);
			}
			pp8.addColumn("被检查事务所名称", "checkoffice").setTdProperty(" style='text-align:center' onclick=\"goView('${id}');\" ");
	
			pp8.addColumn("填报人", "fillMan","showCenter");
			pp8.addColumn("填报项目", "checkProject","showCenter");
			pp8.addColumn("填报日期", "fillTime","showCenter");
			pp8.addColumn("检查津贴总额", "totalCheckPay","showCenter");
			pp8.addColumn("小计总额", "totalCountMoney","showCenter");
			
			pp8.setSQL(sql);
			pp8.setOrderBy_CH("fillTime");
			pp8.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp8.getTableID(), pp8);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	/**
	 * 下载自查报告
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView downReport(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(DOWNREPORT);
		String companyName = request.getParameter("companyName");
		String companyid = request.getParameter("companyid");
		String testyear = request.getParameter("testyear");
		String testnoticeid = (String)request.getSession().getAttribute("testnoticeid");
		Connection conn = null;
		List list = null;
		
		try{
			conn = new DBConnect().getConnect();
			SupervisionService ss = new SupervisionService(conn);
			list = ss.getFiles(testyear,companyid,testnoticeid);
			System.out.println("list.size="+list.size());
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DbUtil.close(conn);
		}
		
		model.addObject("companyName", companyName);
		model.addObject("testyear", testyear);
		model.addObject("list", list);
		
		return model;
	}
	
	/**
	 * 导出成EXCEL
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView expExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/* response.setHeader("Pragma", "public");
		   response.setHeader("Cache-Control", "public");   这两句是解决 下面 下载出现的问题 */
		
		/*
		---------------------------
		Windows Internet Explorer
		---------------------------
		Internet Explorer 无法下载 supervision.do (来自 127.0.0.1)。
		Internet Explorer 无法打开该 Internet 站点。请求的站点不可用，或找不到。请以后再试。
		---------------------------
		确定   
		---------------------------
		*/
		
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "public");
		
//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "no-cache");
		
		response.setDateHeader("Expires", 0);
		
		//改成时间范围（startime-endtime）
//		String testyear = request.getParameter("testyear");//TODO---
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");
		
		String companyid = request.getParameter("companyid");		
		
		String expSql = " select c.*,t.typename,ba.standerprice from bb_content1 c left join bb_type t on c.typeid=t.guid left join bb_apply ba on ba.guid = c.guid ";
		
		String bbType = " select guid,(yzbzje+yzswje+yztdsyje+yzqtwszcje+yzqtje) as yzze,'' as zc,'' as sr,'' as yy from bb_yzb "
			
			  + " union all "
			  
			  + " select a.guid,'' as yzze,isnull(zc,'') as zc,isnull(sr,'') as sr,isnull(yy,'') as yy from " 
			  + " ( "
			  + " 	select a.guid, "
			  + " 	'' as yzze, " 
			  + " 	zc = case when a.bbguid is null then a.zcze when bbguid='' then a.zcze else zc end, " 
			  + " 	sr = case when a.bbguid is null then a.xssr when bbguid='' then a.xssr else sr end, "
			  + " 	yy = case when a.bbguid is null then a.yysr when bbguid='' then a.yysr else yy end "
			  + " 	from "
			  + " 		( "
			  + " 			select * from bb_sjb as sj left join " 
			  + " 			( "
			  + " 				select a.bbguid,a.years,a.propertys,a.zcze as zc,a.xssr as sr,yysr as yy from bb_sjmoney a inner join " 
			  + " 				(select bbguid,max(cast(propertys as int)) as propertys from bb_sjmoney group by bbguid) b "
			  + " 				on a.bbguid = b.bbguid and a.propertys = b.propertys "
			  + " 			) as sjm on sj.guid = sjm.bbguid "
			  + " 		) a  "
			  + " ) a "
			  
			  + " union all "
			  
			  + " select guid,'' as yzze,jchj as zc,'' as sr,'' as yy from bb_whnjb "
			  
			  + " union all "
			  
			  + " select a.guid,yzze,isnull(zc,'') as zc,isnull(sr,'') as sr,yy from "  
			  + " ( " 
			  + " 	select a.guid, " 
			  + " 	'' as yzze, " 
			  + " 	zc = case when a.bbguid is null then a.zcze when bbguid='' then a.zcze else zc end, "  
			  + " 	sr = case when a.bbguid is null then a.xssr when bbguid='' then a.xssr else sr end, "
			  + " 	'' as yy "
			  + " 	from " 
			  + " 		( " 
			  + " 			select * from bb_qsshb as sj left join "  
			  + " 			( " 
			  + " 				select a.bbguid,a.years,a.propertys,a.zcze as zc,a.xssr as sr,yysr as yy from bb_sjmoney a inner join "  
			  + " 				(select bbguid,max(cast(propertys as int)) as propertys from bb_sjmoney group by bbguid) b " 
			  + " 				on a.bbguid = b.bbguid and a.propertys = b.propertys " 
			  + " 			) as sjm on sj.guid = sjm.bbguid " 
			  + " 		) a " 
			  + " ) a " 
			  
			  + " union all "
			  
			  + " select guid,'' as yzze,zcze as zc,xssr as sr,'' as yy from bb_flsjb "
			  
			  + " union all "
			  
			  + " select guid,'' as yzze,zcze as zc,xssr as sr,'' as yy from bb_hbsjb "
			   
			  + " union all "
			  
			  + " select guid,'' as yzze,zcze as zc,xssr as sr,'' as yy from bb_qchzb "
			  
			  + " union all "
			  
			  + " select guid,'' as yzze,zcze as zc,xssr as sr,'' as yy from bb_sfkjjdb ";
		
		expSql = " select a.*,b.yzze,b.zc,b.sr,b.yy from ("+expSql+") a inner join ("+bbType+") as b on a.guid = b.guid where bbstate='报备完成' and bgrq>'"+startime+"' and bgrq<'"+endtime+"' and bbperson='"+companyid+"'";
//		expSql = " select a.*,b.yzze,b.zc,b.sr,b.yy from ("+expSql+") a inner join ("+bbType+") as b on a.guid = b.guid where bbstate='报备完成' and bgrq like'%"+testyear+"%' and bbperson='"+companyid+"'";
		
		System.out.println("expSql="+expSql);
		
		String expDisplayColName = "防伪编号,报备时间,报备类型,报告文号,报告日期,被审（验）单位,签名注师1,签名注师2,应收业务费,实收业务费,基准价,发票号1,发票号2,验资总金额,资产总额,销售收入,营业收入";
		String expColName = "bbbh,bbtime,typename,bgwh,bgrq,bsdwmc,qmzs1,qmzs2,ysywf,ysywfed,standerprice,kjskdfphd,kjskdfphd2,yzze,zc,sr,yy";
//		String fileName = testyear+"年项目清单";
		String fileName = startime+"至"+endtime+"项目清单";//TODO---
		
		Connection conn = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		OutputStream os = null;

		try {
			conn = new DBConnect().getConnect();
			
			String loginname = new DbUtil(conn).queryForString(" select loginname from k_company where loginid = ?",new Object[]{companyid});
			
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			
			String sheetName = fileName;
			//fileName += simpleDateFormat.format(new Date()) + ".xls";
			
			fileName = loginname + fileName + ".xls";
			fileName = URLEncoder.encode(fileName, "UTF-8");

			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);

			os = response.getOutputStream();
			//创建EXCEL
			WritableWorkbook wwb = Workbook.createWorkbook(os);

			//创建表页
			WritableSheet ws = wwb.createSheet(sheetName, 0);

			
			ps = conn.prepareStatement(expSql);
			rs = ps.executeQuery();

			String displayColName[] = expDisplayColName.split(",");
			String colName[] = expColName.split(",");
			Label label = null;

			//写入表头
			for (int i = 0; i < displayColName.length; i++) {
				label = new Label(i, 0, displayColName[i]);
				ws.addCell(label);
			}

			//写入数据行
			int row = 1;
			while (rs.next()) {
				for (int i = 0; i < colName.length; i++) {
					label = new Label(i, row, rs.getString(colName[i]));
					ws.addCell(label);
				}
				row ++;
			}

			//写入EXCEL
			wwb.write();
			
			//关闭EXCEL
			wwb.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);

			os.close();
		}

		return null;
	}

	
}
