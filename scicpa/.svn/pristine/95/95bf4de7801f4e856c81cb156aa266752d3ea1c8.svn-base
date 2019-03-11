package cn.org.gdicpa.web.action.inspection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.org.gdicpa.web.service.inspection.InspectionService;
import cn.org.gdicpa.web.service.user.UserService;

public class InspectionAction extends MultiActionController {
	
	private final String INSPECTION_MICFO = "/inspection/micfo.jsp";	//执业会员的【自我任职资格预查】
	private final String INSPECTION_COMPANY = "/inspection/company.jsp";
	private final String INSPECTION_COMPANY1 = "/inspection/company1.jsp";
	private final String INSPECTION_MICFONO = "/inspection/micfono.jsp"; 
	
	public ModelAndView micfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(INSPECTION_MICFO);
	
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			Map map = userSession.getUserMap();
			Map tmap = new HashMap();
			
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			InspectionService is = new InspectionService(conn);
			
			String idate = CHF.getDateAndTime();
			String iyear = idate.substring(0, 4);
			
			String tabname = (String)map.get("ctypetabname");
			String loginid = (String)map.get("loginid");

			//用户信息
			Map userMap = user.getUser( tabname, loginid);
			modelAndView.addObject("userMap",userMap); 
			
			String approve = (String)userMap.get("approve");	//用户资格的批准时间 
			String cpaid = (String)userMap.get("cpano"); //cpaid
			
			String sql = "",sql1 = "";
			//学时检查</A>
			sql1 = "select sum(PeriodResult) from XS_Content where appid = '"+loginid+"' and curryear='"+(Integer.parseInt(iyear) - 2)+"' ";
			String PR = is.get(sql1); //三年前的学时总数
			if(PR == null || "".equals(PR)){
				PR = "0";
			}
			
			if("k_company".equalsIgnoreCase(tabname) || "k_micfo".equalsIgnoreCase(tabname)){
				sql = "select a.*,b.trainingname,b.lessonid,b.lessonname,b.term " +
					"	from XS_Content a,b_training b  " +
					"	where 1=1 " +
					"	and a.appid = '"+loginid+"' " +
					"	and a.curryear <= '"+(Integer.parseInt(iyear) - 1)+"' " +
					"	and a.curryear >= '"+(Integer.parseInt(iyear) - 2)+"' " +
					"	and a.psb_guid = b.id and isnull(b.ctype,'')<>'k_micfono' ";
			}else{
				sql = "select a.*,b.trainingname,b.lessonid,b.lessonname,b.term " +
					"	from XS_Content a,b_training b  " +
					"	where 1=1 " +
					"	and a.appid = '"+loginid+"' " +
					"	and a.curryear <= '"+(Integer.parseInt(iyear) - 1)+"' " +
					"	and a.curryear >= '"+(Integer.parseInt(iyear) - 2)+"' " +
					"	and a.psb_guid = b.id and b.ctype='k_micfono' ";
			}
			DataGridProperty pp1 = new DataGridProperty();
			
			pp1.setTitle("学时检查");
			pp1.setTableID("xs_content");
			pp1.setWhichFieldIsValue(1);
			pp1.addColumn("培训班名称", "trainingname");//lessonname
			pp1.addColumn("期次", "term","showCenter");
			pp1.addColumn("所属年度", "CurrYear","showCenter");
			pp1.addColumn("出勤率", "CQL","showCenter");			
			pp1.addColumn("学时数", "PeriodResult","showCenter");
			pp1.addColumn("考核结果", "ending","showCenter");
			pp1.addColumn("是否结业", "SFJY","showCenter");
			pp1.addColumn("维护类型", "whType","showCenter");
			
			pp1.setSQL(sql);
			pp1.setOrderBy_CH("CurrYear,APPID");
			pp1.setDirection("desc,asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
			
			is.get(sql, approve, String.valueOf(Integer.parseInt(iyear) - 1), PR, tmap);
			
			//鉴证检查</A>
			
			sql = "select * from BB_View " +
			"	where 1=1 " +
			"	and substring(bbtime,1,4) like '"+(Integer.parseInt(iyear) - 1)+"%'" +           
			"	and (" +
			"		CPA1 = '"+cpaid+"' " +
			"		or CPA2 = '"+cpaid+"' " +
			"		or CPA3 = '"+cpaid+"' " +
			"		or CPA4 = '"+cpaid+"' " +
			"		or CPA5 = '"+cpaid+"' " +
			"		or CPA6 = '"+cpaid+"' " +
			"	)" ;
			DataGridProperty pp2 = new DataGridProperty();
			
			pp2.setTitle("鉴证检查");
			pp2.setTableID("verification");
			pp2.setWhichFieldIsValue(1);
			pp2.addColumn("事务所名称", "CompanyName");
			pp2.addColumn("委托单位名称", "WTDWMC");			
			pp2.addColumn("委托项目类型", "WTXMLX");
			pp2.addColumn("项目名称", "XMMC");
			pp2.addColumn("业务约定书号码", "YWYDS");
			pp2.addColumn("报告文号", "BGWH");
			
			pp2.setSQL(sql);
			pp2.setOrderBy_CH("WTDWMC");
			pp2.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp2.getTableID(), pp2);

			sql1 = "select count(*) from ("+sql+") a ";
			String verification = is.get(sql1);
			
			
			//会费缴纳</A>
			sql = "select b.*,a.idate,a.iyear,a.totalincome,a.total " +
			"	from k_costpay a ,k_costpay_detail b " +
			"	where 1=1" +
			"	and a.iyear = '"+iyear+"'" +
			"	and b.cpaid = '"+cpaid+"' " +
			"	and a.uuid =b.uid  " ;
			DataGridProperty pp3 = new DataGridProperty();
			
			pp3.setTitle("会费缴纳");
			pp3.setTableID("costpaydetail");
			pp3.setWhichFieldIsValue(1);
			pp3.addColumn("CPA证号", "cpaid","showCenter");
			pp3.addColumn("姓名", "username","showCenter");
			pp3.addColumn("职级", "dutylevel","showCenter");
			pp3.addColumn("日期", "iyear","showCenter");
			pp3.addColumn("总计", "total","showCenter");
			pp3.addColumn("备注", "memo");
			
			pp3.setSQL(sql);
			pp3.setOrderBy_CH("id");
			pp3.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp3.getTableID(), pp3);
			
			sql1 = "select count(*) from ("+sql+") a ";
			String dues = is.get(sql1);
			if("0".equals(dues)){
				dues = "否";
			}else{
				dues = "是";
			}
			//保存自检结果
			String result = "";
			if(!"0".equals(verification)
				&& !"否".equals(dues) 
				&& "通过".equals(map.get("school2")) 
			){
				result = "通过";
			}else{
				result = "不通过"; 
			}
			
			tmap.put("officecode", (String)map.get("officecode")); //事务所代码
			tmap.put("iuser", loginid); 	//自检人
			tmap.put("idate", idate); 	//自检日期
			tmap.put("iyear", iyear); 	//自检年份
			tmap.put("cpaid", cpaid); 	//CPA号	
			
			tmap.put("verification", verification); 	//鉴证数
			tmap.put("dues", dues); 	//缴纳会费	是/否	
			tmap.put("result", result); 	//自检结果
			
			is.save(tmap);
			
			modelAndView.addObject("tmap", tmap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	public ModelAndView company(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(INSPECTION_COMPANY);
		Connection conn=null;
		try {		
			ASFuntion CHF=new ASFuntion();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = new HashMap();
			String tabname = "";
			String loginid = "";
			String type = CHF.showNull(request.getParameter("type"));
			if(userSession!=null){
				map = userSession.getUserMap();
				tabname = (String)map.get("ctypetabname");
				loginid = (String)map.get("loginid");
			}else{
				tabname = CHF.showNull(request.getParameter("ctypetabname"));
				loginid = CHF.showNull(request.getParameter("loginid"));
				if("".equals(tabname)){
					tabname = "k_cicpa";
				}
			}
			
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			InspectionService is = new InspectionService(conn); 
			
			String nianfen = CHF.showNull(request.getParameter("nianfen"));
			String date = CHF.getCurrentDate();
			String idate = CHF.getDateAndTime();
			String iyear = idate.substring(0, 4);
			
			if(!"".equals(nianfen) && null != nianfen){
				iyear = nianfen;
			} 

			//用户信息
			Map userMap = user.getUser( tabname, loginid);
			modelAndView.addObject("userMap",userMap); 
			String officecode = (String)userMap.get("officecode"); //事务所代码
			is.saveMicfo(officecode, idate, iyear);	
			
			String sql = "";
			
			/*
			//CPA信息</A>
//			sql = " select a.*,cast(schooledate as float)-cast(schoolbdate as float) as school3date,"
//				+ " case when cast(schooledate as float)-cast(schoolbdate as float)>=30 then '通过' else '不通过' end as school3," 
//				+ " b.loginname from t_inspection a,k_micfo b  " 
//				+ "	where 1=1 " 
//				+ "	and a.officecode = '"+officecode+"' " 
//				+ "	and a.iyear = '"+iyear+"' "           
//				+ "	and a.iuser = b.loginid " ;
			
			
			sql = " select a.*,b.loginname,punishType = case "
				+ " when c.opentype='不公开' then '' " 
				+ " when c.opentype='注协' then '' " 
				+ " when c.opentype='事务所' or c.opentype='公众' " 
				+ " then case when c.state='领导审核' and '"+iyear+"'<=substring(c.validDate,1,4) then c.punishType else '' end "
				+ " else '' "
				+ " end " 
				+ " from t_inspection a inner join k_micfo b on a.iuser = b.loginid " 
				+ " left join K_SupPunish c on a.iuser = c.loginid " 
				+ "	where a.officecode = '"+officecode+"' and b.state = '0'" 
				+ " and b.association='广东省注册会计师协会' and a.iyear = '"+iyear+"' " ;       
			*/
			
			sql = " select a.*,b.loginname,c.punishType "
				+ " from t_inspection a inner join k_micfo b on a.iuser = b.loginid " 
				+ " left join (Select a.*,b.PunishType From ( "
				+ " select VipType,LoginID,Max(PunishDate) as PunishDate from K_SupPunish "
				+ " Where VipType='执业会员' and State='领导审核' and (IsNull(ValidDate, '') = '' "
				+ " or ValidDate<= convert(Varchar(10), getDate(), 120)) and OpenType in ('注协', '公众','事务所') " 
				+ " Group By VipType,LoginID) a "
				+ " Left Join K_SupPunish b on a.VipType=b.VipType and a.LoginID=b.LoginID and a.PunishDate=b.PunishDate) c on a.iuser = c.loginid " 
				+ " where a.officecode = '"+officecode+"' and b.state = '0'" 
				+ " and b.association='广东省注册会计师协会' and a.iyear = '"+iyear+"' ";
			
			if("hyj".equalsIgnoreCase(type)){
				sql = sql + " and a.iuser='"+loginid+"' ";
			}
			
			DataGridProperty pp1 = new DataGridProperty();
			
			pp1.setTitle("CPA信息");
			pp1.setTableID("inspection");
//			CPA号，姓名，自检年份，学时数，鉴证数，会费缴纳，通过情况
			pp1.setWhichFieldIsValue(1);
			
			
			pp1.addColumn("CPA证号", "cpaid");
			pp1.addColumn("姓名", "loginname");		
			pp1.addColumn("资格批准时间", "approve","showCenter");	
			pp1.addColumn("自检年份", "iyear","showCenter");			
			pp1.addColumn("是否参加年检", "yearcheck","showCenter","cn.org.gdicpa.web.action.inspection.InspectionFieldProcess","");			
			pp1.addColumn("前年学时数", "schoolodate","showCenter");
			pp1.addColumn("前年学时通过", "school0","showCenter");
			pp1.addColumn("上年学时数", "schoolbdate","showCenter");
			pp1.addColumn("上年学时通过", "school1","showCenter");
			pp1.addColumn("两年学时数", "schooledate","showCenter");
			pp1.addColumn("两年学时通过", "school2","showCenter");
			
			//pp1.addColumn("鉴证数", "verification","showCenter");
			pp1.addColumn("报告份数", "verification","showCenter");
			pp1.addColumn("缴纳会费", "dues","showCenter");
			pp1.addColumn("自检结果", "result","showCenter");
			pp1.addColumn("惩戒类型", "punishType","showCenter");
						
			pp1.setCancelPage(true);
			pp1.setSQL(sql);
			pp1.setOrderBy_CH("cpaid");
			pp1.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
		
			
			List list = is.getInspectionList(sql);
			modelAndView.addObject("list",list);
			modelAndView.addObject("iyear",iyear);
			modelAndView.addObject("type",type);
			modelAndView.addObject("loginid",loginid);
			modelAndView.addObject("ctypetabname",tabname);
			modelAndView.addObject("now",idate.substring(0, 4));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
		
	}
	
	
	public ModelAndView company1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(INSPECTION_COMPANY1);
		Connection conn=null;
		try {		
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = new HashMap();
			ASFuntion CHF=new ASFuntion();
			String tabname = "";
			String loginid = "";

			if(userSession==null){
				tabname = request.getParameter("ctypetabname");
				loginid = request.getParameter("loginid");
			}else{
				map = userSession.getUserMap();	
				tabname = (String)map.get("ctypetabname");
				loginid = (String)map.get("loginid");
			}
			
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			InspectionService is = new InspectionService(conn);
			
			String nianfen = CHF.showNull(request.getParameter("nianfen"));
			String idate = CHF.getDateAndTime();
			String iyear = idate.substring(0, 4);
			
			if(!"".equals(nianfen) && null != nianfen){
				iyear = nianfen;
			} 
			
			//用户信息
			Map userMap = user.getUser( tabname, loginid);
			modelAndView.addObject("userMap",userMap); 
			String officecode = (String)userMap.get("officecode"); //事务所代码
			is.saveMicfo(officecode, idate, iyear);	
			
			String sql = "";
			
			sql = " select a.*,b.loginname from t_inspection a,k_micfo b  " 
				+ "	where 1=1 " 
				+ "	and a.officecode = '"+officecode+"' " 
				+ "	and a.iyear = '"+iyear+"' "          // 去掉年份 限制，默认显示所有年度的信息
				+ "	and a.iuser = b.loginid " ;
			
			
			DataGridProperty pp1 = new DataGridProperty();
			
			pp1.setTitle("CPA学时信息");
			pp1.setTableID("inspection");
//			CPA号，姓名，自检年份，学时数，鉴证数，会费缴纳，通过情况
			pp1.setWhichFieldIsValue(1);
			
			
			pp1.addColumn("CPA证号", "cpaid");
			pp1.addColumn("姓名", "loginname");			
			pp1.addColumn("前年学时数", "schoolodate","showCenter");
			pp1.addColumn("前年学时通过", "school0","showCenter");			
			pp1.addColumn("上年学时数", "schoolbdate","showCenter");
			pp1.addColumn("上年学时通过", "school1","showCenter");
			
			pp1.addColumn("两年学时数", "schooledate","showCenter");			
			pp1.addColumn("两年学时通过", "school2","showCenter");			
						
			//pp1.addColumn("鉴证数", "verification","showCenter");
			pp1.addColumn("报告份数", "verification","showCenter");
			pp1.addColumn("缴纳会费", "dues","showCenter");
			pp1.addColumn("自检结果", "result","showCenter");
			pp1.setCancelPage(true);
			
			pp1.setCancelPage(true);
			pp1.setSQL(sql);
			pp1.setOrderBy_CH("cpaid");
			pp1.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
			modelAndView.addObject("iyear",iyear);
			modelAndView.addObject("now",idate.substring(0, 4));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
		
	}
	
	
	
	/**
	 * 修改是否参加年检
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateYearCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String isyearcheck = request.getParameter("isyearcheck");
		String iyear = request.getParameter("iyear");
		String ID = request.getParameter("ID");
		String type = request.getParameter("type");
		String tabname = request.getParameter("ctypetabname");
		String loginid = request.getParameter("loginid");
		
		String noyearcheckreason = request.getParameter("noyearcheckreason");
		
		
		String userids[] = userid.split(",");    // 注意下  没有  , 好的情况   这里一定会有 , 号
		String isyearchecks[] = isyearcheck.split(",");
		String iyears[] = iyear.split(",");
		String IDS[] = ID.split(",");
		String noyearcheckreasons[] = noyearcheckreason.split(",");
		Connection conn=null;
		try {
			
			conn  = new DBConnect().getConnect();
			
			InspectionService is = new InspectionService(conn);
			for (int i = 0; i < isyearchecks.length; i++) {
				is.updateYearCheck(userids[i], isyearchecks[i],iyears[i]);	// 调用修改状态的方法
			}
			
			for (int i = 0; i < IDS.length; i++) {
				is.updateNoYearCheckReason(IDS[i], noyearcheckreasons[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		response.sendRedirect(request.getContextPath()+"/common/inspection.do?method=company&type="+type+"&ctypetabname="+tabname+"&loginid="+loginid);
		return null;
		
	}
	
	
	
	/**
	 * 非执业年检
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView micfono(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView(INSPECTION_MICFONO);
		Connection conn=null;
		String iyear = request.getParameter("nianfen");
		try {		
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion af=new ASFuntion();
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			conn  = new DBConnect().getConnect();
			String now = af.getCurrentDate().substring(0,4);
			
			if(iyear==null || "".equals(iyear)){
				iyear = now;
			}
			
			InspectionService is = new InspectionService(conn);
			map.put("iyear", iyear);

			is.saveInspectionNo(map);
			
			String sql = " select a.*,b.loginname from t_inspectionno a inner join k_micfono b on a.iuser = b.loginid  " 
				+ "	where 1=1 " 
				+ "	and a.iyear = '"+iyear+"' "          
				+ "	and a.iuser = '"+loginid+"' " ;
			
			
			DataGridProperty pp1 = new DataGridProperty();
			
			pp1.setTitle("非执业年检信息");
			pp1.setTableID("inspectionno");
			pp1.setWhichFieldIsValue(1);
			
			
			// YearCheckResult varchar(10),--年检结果   oa 处理            资格批准时间 是什么时间 要怎样算
			// pp1.addColumn("资格批准时间", "approval","showCenter");	
			
			pp1.addColumn("姓名", "loginname");		
			pp1.addColumn("资格批准时间", "approval","showCenter");	
			pp1.addColumn("自检年份", "iyear","showCenter");			
			pp1.addColumn("是否参加年检", "yearcheck","showCenter","cn.org.gdicpa.web.action.inspection.InspectionFieldProcess","");			
			pp1.addColumn("上年学时数", "schooldate","showCenter");
			pp1.addColumn("上年投入式学时", "schooldate2","showCenter");
			pp1.addColumn("上年投入式学时通过", "school2","showCenter");
			pp1.addColumn("上年产出式学时", "schooldate3","showCenter");
			
			pp1.addColumn("缴纳会费", "dues","showCenter");
			pp1.addColumn("自检结果", "result","showCenter");
						
			pp1.setCancelPage(true);
			pp1.setSQL(sql);
			pp1.setOrderBy_CH("loginid");
			pp1.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
		
			modelAndView.addObject("iyear",iyear);
			modelAndView.addObject("iuser",loginid);
			modelAndView.addObject("now",now);
			
			sql = " select nocheckreason from t_inspectionno a " 
				+ "	where 1=1 " 
				+ "	and a.iyear = '"+iyear+"' "          
				+ "	and a.iuser = '"+loginid+"' " ;
			
			String noyearcheckreason = new DbUtil(conn).queryForString(sql);
			modelAndView.addObject("noyearcheckreason",noyearcheckreason);
			
		
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return modelAndView;
	}
	
	
	

	/**
	 * 修改是否参加年检
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateYearCheckMicfono(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String p = request.getParameter("p");
		String iuser = request.getParameter("iuser");
		String iyear = request.getParameter("iyear");
		String isyearcheck = request.getParameter("isyearcheck");
		String noyearcheckreason = "";
		if("否".equals(isyearcheck)){
			noyearcheckreason = request.getParameter("noyearcheckreason");
		}
		
		Connection conn=null;
		try {
			
			conn  = new DBConnect().getConnect();
			
			InspectionService is = new InspectionService(conn);
		
			is.updateYearCheckMicfono(iuser, isyearcheck, iyear, noyearcheckreason);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		response.sendRedirect(request.getContextPath()+"/common/inspection.do?method=micfono");
		return null;
		
	}
}
