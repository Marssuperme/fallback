package cn.org.gdicpa.web.action.certificateReceipt;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.certificateReceipt.CertificateReceiptService;
 
public class CertificateReceiptAction extends MultiActionController{
	private final String CERTIFICATE_LIST = "/training/certificateList.jsp";
	private final String CERTIFICATE_PINRT = "/training/certificatePrint.jsp";
	private final String RECEIPT_LIST = "/training/receiptList.jsp";
	private final String RECEIPT_PRINT = "/training/receiptPrint.jsp";
	
	private final String PERIOD_LIST = "/training/periodList.jsp";
	private final String PERIOD_PRINT = "/training/periodPrint.jsp";
		
	/**
	 * 打印结业证书list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ModelAndView certificateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(CERTIFICATE_LIST);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String sql = "";
			String officecode = "";
			String ctypetabname = "";
			String loginid = "";
			if(userSession != null){
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			// 学员
			String loginname = request.getParameter("loginname");
			// cpa 号
			String cpano = request.getParameter("cpano");
			// 培训班
			String trainingname = request.getParameter("trainingname");
			

			if(ctypetabname.equalsIgnoreCase("k_company")){
				/*
				sql = " select t.id,trainingName,t.tid,t.SFJY,t.PeriodResult,t.jyzsbh,t.trainingbdate,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
						   + " inner join ( "
						   + " select distinct t.id,trainingName,t.trainingbdate,e.loginid,e.tid,c.jyzsbh, "
						   + " SFJY = case SFJY when '1' then '是' else '否' end , "
						   + " convert(int,PeriodResult) as PeriodResult "
						   + " from b_training t "
						   + " left join "
						   + " b_enroll e "
						   + " on t.id = trainingid "
						   + " left join XS_Content c on t.id = c.PSB_Guid and e.tid = c.appid " 
						   + " where PSB_MC = '审核通过' and SFJY = '1' "
						   + " ) t on t.tid = m.loginid "
						   + " where officecode = '"+officecode+"' " ;
						  */
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,t.trainingbdate,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(decimal(18,2),PeriodResult) as PeriodResult "
					   + " from XS_Content c "
					   + " left join b_training t on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintcertificate='是' and c.PeriodResult>=35 "
					   + " ) t on t.appid = m.loginid "
					   + " where officecode = '"+officecode+"' " ;
			}else{
				/*
				sql = " select t.id,trainingName,t.tid,t.SFJY,t.PeriodResult,t.jyzsbh,m.loginid,t.trainingbdate,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,e.loginid,e.tid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(int,PeriodResult) as PeriodResult "
					   + " from b_training t "
					   + " left join "
					   + " b_enroll e "
					   + " on t.id = trainingid "
					   + " left join XS_Content c on t.id = c.PSB_Guid and e.tid = c.appid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' "
					   + " ) t on t.tid = m.loginid "
					   + " where tid = '"+loginid+"' " ;
			   */
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,m.loginid,t.trainingbdate,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(decimal(18,2),PeriodResult) as PeriodResult "
					   + " from b_training t "
					   + " left join XS_Content c on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintcertificate='是' and c.PeriodResult>=35 "
					   + " ) t on t.appid = m.loginid "
					   + " where appid = '"+loginid+"' " ;
			}
				
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			System.out.println("结业证书SQL == >>  "+sql);
			System.out.println("===============================");
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("certificateList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("是否结业", "SFJY","showCenter");
			pp.addColumn("学时数", "PeriodResult","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printCertificate('${id}','${loginid}');\">打印结业证书</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(10);
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
	
	/**
	 * 会员机链接到：打印结业证书list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView certificateListFromHYJ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(CERTIFICATE_LIST);
		try {
			
			ASFuntion af = new ASFuntion();
			
			// 会员机 用户类型
			String ctypeTabName = af.showNull(request.getParameter("ctypeTabName"));
			// 会员机 loginId
			String loginId = af.showNull(request.getParameter("loginId"));
			System.out.println("ctypeTabName="+ctypeTabName+"   loginId="+loginId);
			
			// 学员
			String loginname = af.showNull(request.getParameter("loginname"));
			// cpa 号
			String cpano = af.showNull(request.getParameter("cpano"));
			// 培训班
			String trainingname = af.showNull(request.getParameter("trainingname"));
			
			String sql = "";
			if("k_cicpa".equalsIgnoreCase(ctypeTabName)){	// 注协用户
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,t.trainingbdate,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(decimal(18,2),PeriodResult) as PeriodResult "
					   + " from XS_Content c "
					   + " left join b_training t on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintcertificate='是' and c.PeriodResult>=35 "
					   + " ) t on t.appid = m.loginid "
					   + " where 1=1 " ;
			}else{	//普通会员
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,m.loginid,t.trainingbdate,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(decimal(18,2),PeriodResult) as PeriodResult "
					   + " from b_training t "
					   + " left join XS_Content c on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintcertificate='是' and c.PeriodResult>=35 "
					   + " ) t on t.appid = m.loginid "
					   + " where appid = '"+loginId+"' " ;
			}
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("certificateList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("是否结业", "SFJY","showCenter");
			pp.addColumn("学时数", "PeriodResult","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printCertificate('${id}','${loginid}');\">打印结业证书</a> </div>");;
			
			pp.setPageSize_CH(10);
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
			
			modelAndView.addObject("ctypeTabName", ctypeTabName);
			modelAndView.addObject("loginId", loginId);
			modelAndView.addObject("source", "hyj");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		
		// 培训班名称
		setTrainingNameList(request,response,modelAndView);
		
		return modelAndView;
	}
		
	/**
	 * 打印回执list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView receiptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RECEIPT_LIST);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String sql = "";
			String officecode = "";
			String ctypetabname = "";
			String loginid = "";
			if(userSession != null){
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}else{
				officecode = CHF.showNull(request.getParameter("officecode"));
				ctypetabname = CHF.showNull(request.getParameter("ctypetabname"));
				loginid = CHF.showNull(request.getParameter("loginid"));
			}

			// 学员
			String loginname = request.getParameter("loginname");
			// cpa 号
			String cpano = request.getParameter("cpano");
			// 培训班
			String trainingname = request.getParameter("trainingname");

			if(ctypetabname.equalsIgnoreCase("k_company")){
				sql = " select distinct t.id,trainingid,e.tid,e.edate,e.seatno,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
					+ " inner join b_training t "
					+ " on e.trainingid = t.id "
					+ " left join k_micfo m "
					+ " on m.loginid = e.tid "
					+ " where officecode = '"+officecode+"' " ;
			}else{
				sql = " select distinct t.id,trainingid,e.tid,e.edate,e.seatno,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
					+ " inner join b_training t "
					+ " on e.trainingid = t.id "
					+ " left join k_micfo m "
					+ " on m.loginid = e.tid "
					+ " where tid = '"+loginid+"' " ;
			}
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("receiptList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("座位号", "seatno","showCenter");
			pp.addColumn("报名时间", "edate","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printReceipt('${id}','${tid}');\">打印报名回执</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("edate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
		
	/**
	 * 会员机链接到：打印回执list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView receiptListFromHYJ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RECEIPT_LIST);
		try {
			
			ASFuntion CHF=new ASFuntion();

			String loginId = CHF.showNull(request.getParameter("loginId"));
			// 学员
			String loginname = CHF.showNull(request.getParameter("loginname"));
			// cpa 号
			String cpano = CHF.showNull(request.getParameter("cpano"));
			// 培训班
			String trainingname = CHF.showNull(request.getParameter("trainingname"));

			String sql = " select distinct t.id,trainingid,e.tid,e.edate,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
				+ " inner join b_training t "
				+ " on e.trainingid = t.id "
				+ " left join k_micfo m "
				+ " on m.loginid = e.tid "
				+ " where tid = '"+loginId+"' " ;
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("receiptList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("报名时间", "edate","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printReceipt('${id}','${tid}');\">打印报名回执</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("edate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			modelAndView.addObject("loginId", loginId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		modelAndView.addObject("source", "hyj");
		// 培训班名称
		setTrainingNameList(request,response,modelAndView);
		return modelAndView;
	}
	
	/**
	 * 打印学时证明list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView periodList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(PERIOD_LIST);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String sql = "";
			String officecode = "";
			String ctypetabname = "";
			String loginid = "";
			if(userSession != null){
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			// 学员
			String loginname = request.getParameter("loginname");
			// cpa 号
			String cpano = request.getParameter("cpano");
			// 培训班
			String trainingname = request.getParameter("trainingname");
			

			if(ctypetabname.equalsIgnoreCase("k_company")){
				/*
				sql = " select t.id,trainingName,t.tid,t.SFJY,t.PeriodResult,t.jyzsbh,t.trainingbdate,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
						   + " inner join ( "
						   + " select distinct t.id,trainingName,t.trainingbdate,e.loginid,e.tid,c.jyzsbh, "
						   + " SFJY = case SFJY when '1' then '是' else '否' end , "
						   + " convert(int,PeriodResult) as PeriodResult "
						   + " from b_training t "
						   + " left join "
						   + " b_enroll e "
						   + " on t.id = trainingid "
						   + " left join XS_Content c on t.id = c.PSB_Guid and e.tid = c.appid " 
						   + " where PSB_MC = '审核通过' and SFJY = '1' "
						   + " ) t on t.tid = m.loginid "
						   + " where officecode = '"+officecode+"' " ;
						  */
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,t.trainingbdate,t.curryear,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh,c.curryear, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(int,PeriodResult) as PeriodResult "
					   + " from XS_Content c "
					   + " left join b_training t on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintperiod='是' and isnull(c.proxy,'')<>'上海会院' "
					   + " ) t on t.appid = m.loginid "
					   + " where officecode = '"+officecode+"' " ;
			}else{
				/*
				sql = " select t.id,trainingName,t.tid,t.SFJY,t.PeriodResult,t.jyzsbh,m.loginid,t.trainingbdate,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,e.loginid,e.tid,c.jyzsbh, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(int,PeriodResult) as PeriodResult "
					   + " from b_training t "
					   + " left join "
					   + " b_enroll e "
					   + " on t.id = trainingid "
					   + " left join XS_Content c on t.id = c.PSB_Guid and e.tid = c.appid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' "
					   + " ) t on t.tid = m.loginid "
					   + " where tid = '"+loginid+"' " ;
			   */
				sql = " select t.id,trainingName,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,t.curryear,m.loginid,t.trainingbdate,m.loginname,m.cpano,m.officecode from k_micfo m "
					   + " inner join ( "
					   + " select distinct t.id,trainingName,t.trainingbdate,c.appid,c.jyzsbh,c.curryear, "
					   + " SFJY = case SFJY when '1' then '是' else '否' end , "
					   + " convert(int,PeriodResult) as PeriodResult "
					   + " from b_training t "
					   + " left join XS_Content c on t.id = c.PSB_Guid " 
					   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintperiod='是' and isnull(c.proxy,'')<>'上海会院' "
					   + " ) t on t.appid = m.loginid "
					   + " where appid = '"+loginid+"' " ;
			}
				
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			System.out.println("学时证明SQL == >>  "+sql);
			System.out.println("===============================");
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("certificateList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("所属年份", "curryear","showCenter");
			pp.addColumn("是否结业", "SFJY","showCenter");
			pp.addColumn("学时数", "PeriodResult","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printPeriod('${PeriodResult}','${loginid}','${cpano}','${loginname}','${curryear}');\">打印学时证明</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(10);
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
	
	/**
	 * 会员机链接到：打印学时证明list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView periodListFromHYJ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RECEIPT_LIST);
		try {
			
			ASFuntion CHF=new ASFuntion();

			String loginId = CHF.showNull(request.getParameter("loginId"));
			// 学员
			String loginname = CHF.showNull(request.getParameter("loginname"));
			// cpa 号
			String cpano = CHF.showNull(request.getParameter("cpano"));
			// 培训班
			String trainingname = CHF.showNull(request.getParameter("trainingname"));

			String sql = " select distinct t.id,trainingid,e.tid,e.edate,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
				+ " inner join b_training t "
				+ " on e.trainingid = t.id "
				+ " left join k_micfo m "
				+ " on m.loginid = e.tid "
				+ " where tid = '"+loginId+"' " ;
			
			if(loginname!=null && !"".equals(loginname)){
				sql += "  and (loginname like '%"+loginname+"%' or cpano like '%"+loginname+"%') ";
			}
			
			if(cpano!=null && !"".equals(cpano)){
				sql += "  and cpano like '%"+cpano+"%'";
			}
			
			if(trainingname!=null && !"".equals(trainingname)){
				sql += "  and trainingname like '%"+trainingname+"%'";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("学时信息");
			pp.setTableID("receiptList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("学员", "loginname","showCenter");
			pp.addColumn("CPA证书号", "cpano","showCenter");
			pp.addColumn("培训班", "trainingName","showCenter");
			pp.addColumn("报名时间", "edate","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"printReceipt('${id}','${tid}');\">打印报名回执</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("edate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			modelAndView.addObject("loginId", loginId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		modelAndView.addObject("source", "hyj");
		// 培训班名称
		setTrainingNameList(request,response,modelAndView);
		return modelAndView;
	}
	
	/**
	 * 打印结业证书
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView printCertificate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(CERTIFICATE_PINRT);
		
		ASFuntion af = new ASFuntion();
		
		String id = request.getParameter("id");
		String micfoLoginid = request.getParameter("micfoLoginid");
		String officecode = request.getParameter("officeCode");
		
		Map mapInfo = new HashMap();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession!=null){
			Map map = userSession.getUserMap();
			officecode = (String)map.get("officecode");
		}

		Connection conn = null;
		
		try{
			conn = new DBConnect().getConnect();
			if(officecode==null || "".equals(officecode)){
				officecode = new DbUtil(conn).queryForString("select officecode from k_user where loginid = '"+micfoLoginid+"'");
			}
			String sql = " select t.id,trainingName,trainingedate,t.appid,t.SFJY,t.PeriodResult,t.jyzsbh,m.loginid,m.loginname,m.cpano,m.officecode from k_micfo m "
				   + " inner join ( "
				   + " select distinct t.id,trainingName,trainingedate,c.appid,c.jyzsbh, "
				   + " SFJY = case SFJY when '1' then '是' else '否' end , "
				   + " convert(int,PeriodResult) as PeriodResult "
				   + " from b_training t "
				   + " left join XS_Content c on t.id = c.PSB_Guid " 
				   + " where PSB_MC = '审核通过' and SFJY = '1' and c.isprintcertificate='是' "
				   + " ) t on t.appid = m.loginid "
				   + " where officecode = '"+officecode+"' and id= '"+id+"' and appid = '"+micfoLoginid+"' " ;
			
			CertificateReceiptService crs = new CertificateReceiptService(conn);
			mapInfo = crs.getInfoBySql(sql);
			
			String trainingedate = mapInfo.get("trainingedate")+"";
			
			String currentDate = af.getCurrentDate();
			if(trainingedate==null || "".equals(trainingedate) || "null".equalsIgnoreCase(trainingedate)){
				trainingedate = currentDate;
			}
			
			String year = trainingedate.substring(0,4);
			String month = trainingedate.substring(5, 7);
			String day = trainingedate.substring(8, 10);
			
			trainingedate = year+"年"+month+"月"+day+"日";
			
			trainingedate = crs.dateToChineseStyle(trainingedate);
			
			model.addObject("mapInfo",mapInfo);
			model.addObject("trainingedate",trainingedate);

			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
		
	/**
	 * 打印回执
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView printReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(RECEIPT_PRINT);
		
		ASFuntion af = new ASFuntion();
		
		String id = request.getParameter("id");
		String micfoLoginid = request.getParameter("micfoLoginid");
		String officecode = request.getParameter("officeCode");
		
		Map mapInfo = new HashMap();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession!=null){
			Map map = userSession.getUserMap();
			officecode = (String)map.get("officecode"); 
		}
		
		Connection conn = null;
		
		try{
			String sql = " select distinct t.id,trainingid,t.trainingbdate,e.tid,e.seatno,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
					+ " inner join b_training t "
					+ " on e.trainingid = t.id "
					+ " left join k_micfo m "
					+ " on m.loginid = e.tid where t.id= '"+id+"' and tid = '"+micfoLoginid+"' " ;
			
			if(null!=officecode && !"".equals(officecode)){
				sql = sql + " and officecode = '"+officecode+"'";
			}
			
			conn = new DBConnect().getConnect();
			CertificateReceiptService crs = new CertificateReceiptService(conn);
			mapInfo = crs.getInfoBySql(sql);
			model.addObject("mapInfo",mapInfo);
			String currentDate = af.getCurrentDate();
			String year = currentDate.substring(0,4);
			String month = currentDate.substring(5, 7);
			String day = currentDate.substring(8, 10);
			
			String trainingbdate = mapInfo.get("trainingbdate")+"";
			
			if(trainingbdate==null || "".equals(trainingbdate) || "null".equalsIgnoreCase(trainingbdate)){
				trainingbdate = currentDate;
			}
			
			String trainingyear = trainingbdate.substring(0,4);
			String trainingmonth = trainingbdate.substring(5, 7);
			String trainingday = trainingbdate.substring(8, 10);
			
			trainingbdate = trainingyear+"年"+Integer.parseInt(trainingmonth)+"月"+Integer.parseInt(trainingday)+"日";
			
			String time = year+"年"+month+"月"+day+"日";
			time = crs.dateToChineseStyle(time);
			model.addObject("nowTime",time);
			model.addObject("trainingbdate",trainingbdate);
			
			
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	/**
	 * 打印学时证明
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView printPeriod(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("GBK");
		ModelAndView model = new ModelAndView(PERIOD_PRINT);
		
		ASFuntion af = new ASFuntion(); 
		
//		String id = request.getParameter("id");
		String PeriodResult = request.getParameter("PeriodResult");
		String cpano = request.getParameter("cpano");
		String loginname = request.getParameter("loginname");
		
		System.out.println("888888888888888>>>>>>>>>>>>>>>>>>>>"+loginname);
		String curryear = request.getParameter("curryear");
//		String micfoLoginid = request.getParameter("micfoLoginid");
		String officecode = request.getParameter("officeCode");
		
		Map mapInfo = new HashMap();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession!=null){
			Map map = userSession.getUserMap();
			officecode = (String)map.get("officecode"); 
		}
		
		Connection conn = null;
//		
		try{
//			String sql = " select distinct t.id,trainingid,t.trainingbdate,e.tid,m.loginname,m.cpano,m.officecode,t.trainingname from b_enroll e "
//				+ " inner join b_training t "
//				+ " on e.trainingid = t.id "
//				+ " left join k_micfo m "
//				+ " on m.loginid = e.tid where t.id= '"+id+"' and tid = '"+micfoLoginid+"' " ;
//			
//			if(null!=officecode && !"".equals(officecode)){
//				sql = sql + " and officecode = '"+officecode+"'";
//			}
//			
			conn = new DBConnect().getConnect();
			CertificateReceiptService crs = new CertificateReceiptService(conn);
//			mapInfo = crs.getInfoBySql(sql);
//			model.addObject("mapInfo",mapInfo);
			String currentDate = af.getCurrentDate();
			String year = currentDate.substring(0,4);
			String month = currentDate.substring(5, 7);
			String day = currentDate.substring(8, 10);
			
			String trainingbdate = mapInfo.get("trainingbdate")+"";
			
			if(trainingbdate==null || "".equals(trainingbdate) || "null".equalsIgnoreCase(trainingbdate)){
				trainingbdate = currentDate;
			}
			
			String trainingyear = trainingbdate.substring(0,4);
			String trainingmonth = trainingbdate.substring(5, 7);
			String trainingday = trainingbdate.substring(8, 10);
			
			trainingbdate = trainingyear+"年"+Integer.parseInt(trainingmonth)+"月"+Integer.parseInt(trainingday)+"日";
			
			String time = year+"年"+month+"月"+day+"日";
			time = crs.dateToChineseStyle(time);
			model.addObject("nowTime",time);
			model.addObject("trainingbdate",trainingbdate);
			
			model.addObject("PeriodResult",PeriodResult);
			model.addObject("cpano",cpano);
			model.addObject("loginname",loginname);
			model.addObject("officecode",officecode);
			model.addObject("curryear",curryear);
			
			
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	/**
	 * 得到培训班
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView setTrainingNameList(HttpServletRequest request,
			HttpServletResponse response,ModelAndView model) {
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		String ctypeTabName = CHF.showNull(request.getParameter("ctypeTabName"));
		try {
			conn = new DBConnect().getConnect();
			
			if(!"k_cicpa".equalsIgnoreCase(ctypeTabName)){
				sql = " select trainingname from b_training where enrollbdate<=convert(Varchar(10),getdate(),120) " 
					+ " and convert(Varchar(10),getdate(),120)<trainingedate "
					+ " order by trainingbdate desc ";
			}else{
				sql = " select trainingname from b_training order by trainingbdate desc ";
			}
			
			System.out.println("ctypeTabName="+ctypeTabName);
			System.out.println("sql="+sql);
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();

			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getString("trainingname"));
			}
			
			// 去除重复元素
			Set set = new HashSet();
			List newList = new ArrayList();
			for(Iterator iter = list.iterator();iter.hasNext();){
				Object element = iter.next();
		        if(set.add(element)){
		           newList.add(element);
		        };
		    } 
		    list.clear();
		    list.addAll(newList);
		    
			model.addObject("trainNameList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		return null;
	}
	
	//检查是否上海会院的培训
	public ModelAndView checkJHKY(HttpServletRequest request,
			HttpServletResponse response,ModelAndView model) {
		response.setContentType("text/xml;charset=UTF-8");
		String id = request.getParameter("id");
		String micfoLoginid = request.getParameter("micfoLoginid");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer buf = new StringBuffer();
		try{
			PrintWriter out = response.getWriter();
			conn = new DBConnect().getConnect();
			String sql = "select x.APPNAME,x.APPID,x.curryear,b.trainingName,x.periodresult,x.proxy from b_training b join xs_content x on b.id=x.PSB_GUID where x.PSB_GUID=? and x.APPID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, micfoLoginid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				buf.append(StringUtil.showNull(rs.getString("APPNAME"))).append(":")
				.append(StringUtil.showNull(rs.getString("APPID"))).append(":")
				.append(StringUtil.showNull(rs.getString("curryear"))).append(":")
				.append(StringUtil.showNull(rs.getString("trainingName"))).append(":")
				.append(StringUtil.showNull(rs.getString("periodresult"))).append(":")
				.append(StringUtil.showNull(rs.getString("proxy")));
			}
			System.out.println(buf.toString());
			out.write(buf.toString());
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
}
