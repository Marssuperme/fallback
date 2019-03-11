package cn.org.gdicpa.web.action.memberBranch;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.memberBranch.MemberBranchService;
import cn.org.gdicpa.web.service.memberBranch.model.MemberBranchTable;

public class MemberBranchAction extends MultiActionController{
	private static final String MEMBERBRANCHLIST = "/memberBranch/list.jsp";
	private static final String MEMBERBRANCHADDANDEDIT = "/memberBranch/addAndEdit.jsp";
	private static final String MEMBERBRANCHVIEW = "/memberBranch/view.jsp";
	private static final String MEMBERBRANCHADDFRAME = "/memberBranch/addframe.jsp";
	
	//团组织
	public ModelAndView goAddFrame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(MEMBERBRANCHADDFRAME);
		return model;
	}
	
	//团组织
	private static final String BRANCH = "/memberBranch/branch.jsp";
	public ModelAndView branch(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		Connection conn = null;
		ModelAndView model = new ModelAndView(BRANCH);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			ASFuntion CHF = new ASFuntion();
			
			conn = new DBConnect().getConnect();
			MemberBranchService mbs = new MemberBranchService(conn);
			Map branch = mbs.getBranch(loginid);
			
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			System.out.println("测试oldLoginId是否为空："+oldLoginId);
			if(oldLoginId!=null){
				String isCreateNew = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{loginid});
				System.out.println("测试是否创建isCreateNew（NULL,是,否）: " + isCreateNew);
				String isCreateOld = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{oldLoginId});
				System.out.println("测试是否创建isCreateOld（NULL,是,否）: " + isCreateOld);
				if(isCreateNew==null && isCreateOld!=null){
					branch = mbs.getBranch(oldLoginId);
				}
			}
			
			System.out.println(branch);
			model.addObject("branch", branch);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	//修改团组织
	public ModelAndView updateSave(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		Connection conn=null;
		PrintWriter out = null ;
		try {
			conn  = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			String loginid = (String)userMap.get("loginid");
			String loginname = (String)userMap.get("loginname");
			
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			
			ASFuntion CHF = new ASFuntion();
			
			System.out.println("------------->>>"+parameters);
			
			MemberBranchTable memberBranch = new MemberBranchTable();
			memberBranch.setId((String)parameters.get("id"));
			memberBranch.setArea((String)parameters.get("area"));
			memberBranch.setOfficecode(loginid);
			//兼容改制前旧数据
//			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
//			if(oldLoginId!=null){
//				String isCreateNew = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{loginid});
//				String isCreateOld = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{oldLoginId});
//				if(isCreateNew==null && isCreateOld!=null){
//					memberBranch.setOfficecode(oldLoginId);
//				}
//			}
			
			memberBranch.setBranchtype((String)parameters.get("branchtype"));
			memberBranch.setIsCreate((String)parameters.get("isCreate"));
			memberBranch.setBranchname((String)parameters.get("branchname"));
			memberBranch.setBuilddate((String)parameters.get("builddate"));
			memberBranch.setSecretaryName((String)parameters.get("secretaryname"));
			memberBranch.setMobile((String)parameters.get("mobile"));
			
			String memberNum = CHF.showNull((String)parameters.get("membernum")); 
			String cpaNum = CHF.showNull((String)parameters.get("cpanum"));
			
			memberBranch.setMemberNum("".equals(memberNum) ? 0 : Integer.parseInt(memberNum));
			memberBranch.setCpaNum("".equals(cpaNum) ? 0 : Integer.parseInt(cpaNum));
			memberBranch.setLinkMan((String)parameters.get("linkman"));
			memberBranch.setPhone((String)parameters.get("phone"));
			memberBranch.setLastby(loginid);
			memberBranch.setLastmodify(CHF.getDateAndTime1());
			
			//获取事务所归属“市级行业（协会）团组织”的ID,NAME
			String pId = new DbUtil(conn).queryForString("select id from K_MemberBranch where area=? and branchType=?", new Object[]{memberBranch.getArea(),"市级行业(协会)团组织"});
			String pName = new DbUtil(conn).queryForString("select branchName from K_MemberBranch where area=? and branchType=?", new Object[]{memberBranch.getArea(),"市级行业(协会)团组织"});
			
			memberBranch.setPid(pId);
			memberBranch.setPname(pName);
			
			MemberBranchService mbs = new MemberBranchService(conn);
			mbs.saveOrUpdate(memberBranch);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"提交团组织信息成功!\");window.location=\""+request.getContextPath()+"/common/memberBranch.do?method=branch\"</script>");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			//out.println("<script>alert(\"提交团组织信息失败，请联系管理员!\");window.location=\""+request.getContextPath()+"/common/memberBranch.do?method=branch\"</script>");
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		
	}
	//在增加团员时，先检查是否已经建立团组织
	public ModelAndView checkIsCreateBranch(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		ASFuntion CHF = new ASFuntion();
		String officeCode = CHF.showNull(request.getParameter("officecode"));
		
		Connection conn = null;
		PrintWriter out = response.getWriter();
		try {
			conn  = new DBConnect().getConnect();
			String isNull = new DbUtil(conn).queryForString("select 1 from K_MemberBranch where officecode=?", new Object[]{officeCode});
			if(isNull == null || "".equals(isNull)){
				out.write("NO");
			}else{
				out.write("YES");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * 列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
////	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception{
////		ModelAndView model = new ModelAndView(MEMBERBRANCHLIST);
////		
////		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
////		Map map = userSession.getUserMap();
////		String loginid = (String)map.get("loginid");
////		
////		String sql = " select p.id,p.branchname,p.builddate,p.branchtype,p.branchtype2,p.affiliation,p.pid,p.pname,p.email,p.mobile,p.phone, "
////				   + " p.address,p.fax,p.web,p.area,p.lastby,p.lastmodify,p.officecode,p.state,p.ctype,fzqk,mzsh,dnbz,c.loginname "  
////				   + " from K_PartyBranch p left join k_company c on p.officecode = c.loginid where p.officecode = '"+loginid+"'";
////		
////		
////		DataGridProperty pp = new DataGridProperty();
////		
////		System.out.println(this.getClass()+"          index............sql="+sql);
////		
////		pp.setTitle("党组织");
////		 
////		pp.setInputType("radio");
////		pp.setTableID("memberBranch");
////		pp.setWhichFieldIsValue(1);
////		pp.setPageSize_CH(10);
////		
////		
////		pp.addColumn("党组织名称", "branchname").setTdProperty("align='center' onclick=f_view('${id}')");
////		pp.addColumn("机构类型", "branchtype","showCenter");
////
////		pp.addColumn("党组织类型", "branchtype2","showCenter");
////		pp.addColumn("事务所代码", "officecode","showCenter");
////		pp.addColumn("事务所全称", "loginname","showCenter");
////		pp.addColumn("所属城市", "area","showCenter");
////		
////		pp.setSQL(sql);
////		pp.setOrderBy_CH("builddate");
////		pp.setDirection("desc");
////		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
////		
////		return model;
////	
////	}
//	
//	/**
//	 * 查看 || 修改
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
//		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
//		Map map = userSession.getUserMap();
//		String loginid = (String)map.get("loginid");
//		String loginname = (String)map.get("loginname");
//		
//		ModelAndView model = null;
//		String micfoCount = "";
//		String p = request.getParameter("param");
//		String id = request.getParameter("id");
//		PartyBranchTable pt = null;
//		Connection conn = null;
//		try {
//			conn = new DBConnect().getConnect();
//			PartyBranchService ps = new PartyBranchService(conn);
//			if("view".equalsIgnoreCase(p)){
//				pt = ps.getPartyBranchTableById(id);
//				model = new ModelAndView(MEMBERBRANCHVIEW);
//			}else if("update".equalsIgnoreCase(p)){
//				pt = ps.getPartyBranchTableById(id);
//				model = new ModelAndView(MEMBERBRANCHADDANDEDIT);
//			}else{
//				model = new ModelAndView(MEMBERBRANCHADDANDEDIT);
//			}
//			System.out.println(this.getClass()+"        p="+p+"          id="+id+"    getBranchname=  "+pt.getBranchname());
//			
//			// 找出成员数
//			// micfoCount = new DbUtil(conn).queryForString("");
//
//		} catch (Exception e) {
//			System.out.println(" Connection   ERROR:"+e.getMessage());
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(conn);
//		}
//		
//		model.addObject("micfoCount", micfoCount);
//		model.addObject("loginname", loginname);
//		model.addObject("pt", pt);
//		return model;
//	
//	}
//	

	/**
	 * 保存
	 * @param request
	 * @param response
	 * @param pt
	 * @return
	 */
//	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,PartyBranchTable pt){
//		Connection conn = null;
//		PartyBranchService ps = null;
//		try {
//			conn = new DBConnect().getConnect();
//			ps = new PartyBranchService(conn);
//			ps.updatePartyBranchTablePart(pt);
//			response.sendRedirect("memberBranch.do?method=index");
//		} catch (Exception e) {
//			System.out.println("Exception  ERROR:"+e.getMessage());
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(conn);
//		}
//		return null;
//	}
//	
//	//===========================================================================================================
//	//重写党建
//	//===========================================================================================================
//	/**
//	 * 1、党组织:找事务所的党组织
//	 * 2、党员
//	 * 3、党建制度
//	 */	
//	
	
	
	
	//发展党员
//	private static final String expansion = "/partyBranch/expansion.jsp";
//	private static final String expansionEdit = "/partyBranch/expansionEdit.jsp";
//	//组织活动
//	private static final String activities = "/partyBranch/activities.jsp";
//	private static final String activitiesEdit = "/partyBranch/activitiesEdit.jsp";
//	//党内奖惩
//	private static final String commend = "/partyBranch/commend.jsp";
//	private static final String commendEdit = "/partyBranch/commendEdit.jsp";
//	//党内培训
//	private static final String training = "/partyBranch/training.jsp";
//	private static final String trainingEdit = "/partyBranch/trainingEdit.jsp";
//	public ModelAndView expansion(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		ModelAndView model = new ModelAndView(expansion);
//		ASFuntion CHF = new ASFuntion();
//		String id = CHF.showNull(request.getParameter("id")); 
//		
//		String sql = " Select * From K_PartyExpansion Where PID='"+id+"' ";
//
//		DataGridProperty pp = new DataGridProperty();
//		
//		pp.setTitle("发展党员");
//		 
//		pp.setInputType("radio");
//		pp.setTableID("partyExpansion");
//		pp.setWhichFieldIsValue(1);
//		pp.setPageSize_CH(10);
//		
//		pp.addColumn("年度", "sYear","showCenter");
//		pp.addColumn("发展新党员人数", "NewNum","showCenter");
//		pp.addColumn("申请入党人数", "ApplyNum","showCenter");
//		pp.addColumn("确定培养对象(入党积极分子)人数", "GrowNum","showCenter");
//		pp.addColumn("审核人", "auditor","showCenter");//添加审核人
//		
//		pp.setSQL(sql);
//		pp.setOrderBy_CH("sYear");
//		pp.setDirection("desc");
//		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
//		
//		model.addObject("pid", id);
//		return model;
//	}
//
//	public ModelAndView activities(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		ModelAndView model = new ModelAndView(activities);
//		ASFuntion CHF = new ASFuntion();
//		String id = CHF.showNull(request.getParameter("id")); 
//		
//		String sql = " Select * From K_PartyActivities Where PID='"+id+"' ";
//
//		DataGridProperty pp = new DataGridProperty();
//		
//		pp.setTitle("组织活动");
//		 
//		pp.setInputType("radio");
//		pp.setTableID("partyActivities");
//		pp.setWhichFieldIsValue(1);
//		pp.setPageSize_CH(10);
//		
//		pp.addColumn("年度", "sYear","showCenter");
//		pp.addColumn("三会次数", "ThreeNum","showCenter");
//		pp.addColumn("组织(民主)生活会次数", "ActivitiesNum","showCenter");
//		pp.addColumn("党课次数", "ClassNum","showCenter");
//		pp.addColumn("开展主题活动情况", "ActContent");
//		pp.addColumn("审核人", "auditor","showCenter");
//		
//		pp.setSQL(sql);
//		pp.setOrderBy_CH("sYear");
//		pp.setDirection("desc");
//		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
//		
//		model.addObject("pid", id);
//		return model;
//	}
//	
//	
//	public ModelAndView commend(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		ModelAndView model = new ModelAndView(commend);
//		ASFuntion CHF = new ASFuntion();
//		String id = CHF.showNull(request.getParameter("id")); 
//		
//		String sql = " Select * From K_PartyCommend Where PID='"+id+"' ";
//
//		DataGridProperty pp = new DataGridProperty();
//		
//		pp.setTitle("党内奖惩");
//		 
//		pp.setInputType("radio");
//		pp.setTableID("partyCommend");
//		pp.setWhichFieldIsValue(1);
//		pp.setPageSize_CH(10);
//		
//		pp.addColumn("年度", "sYear","showCenter");
//		pp.addColumn("类型", "sType","showCenter");
//		pp.addColumn("名称", "CommendName");
//		pp.addColumn("级别", "CommendType");
//		pp.addColumn("批准时间", "ApprovalTime");
//		pp.addColumn("批准机构名称", "ApprovalDepart");
//		pp.addColumn("审核人", "auditor","showCenter");
//		
//		pp.setSQL(sql);
//		pp.setOrderBy_CH("sYear");
//		pp.setDirection("desc");
//		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
//		
//		model.addObject("pid", id);
//		return model;
//	}
//	
//	public ModelAndView training(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		ModelAndView model = new ModelAndView(training);
//		ASFuntion CHF = new ASFuntion();
//		String id = CHF.showNull(request.getParameter("id")); 
//		
//		String sql = " Select * From K_PartyTraining Where PartyID = '"+id+"' ";
//
//		DataGridProperty pp = new DataGridProperty();
//		
//		pp.setTitle("党内培训");
//		 
//		pp.setInputType("radio");
//		pp.setTableID("partyTraining");
//		pp.setWhichFieldIsValue(1);
//		pp.setPageSize_CH(10);
//		pp.addColumn("培训班名称", "TrainName");
//		pp.addColumn("开始日期", "BeginDate","showCenter");
//		pp.addColumn("截止日期", "EndDate","showCenter");
//		pp.addColumn("培训单位", "DepartMent");
//		pp.addColumn("完成情况", "TrainResult");
//		pp.addColumn("培训学时数", "TrainTime","showCenter");
//		pp.addColumn("审核人", "auditor","showCenter");
//		
//		pp.setSQL(sql);
//		pp.setOrderBy_CH("BeginDate");
//		pp.setDirection("desc");
//		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
//		
//		model.addObject("pid", id);
//		return model;
//	}
//	
//	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		Connection conn = null;
//		ModelAndView model = new ModelAndView();
//		try {
//			ASFuntion CHF = new ASFuntion();
//			String param = CHF.showNull(request.getParameter("param")); 
//			String id = CHF.showNull(request.getParameter("id")); 
//			String pid = CHF.showNull(request.getParameter("pid")); 
//			
//			String tablename = CHF.showNull(request.getParameter("tablename"));
//			String url = CHF.showNull(request.getParameter("url"));
//			
//			conn = new DBConnect().getConnect();
//			PartyBranchService ps = new PartyBranchService(conn);
//			Map edit = new HashMap();
//			
//			edit.put("syear", CHF.getCurrentDate().substring(0, 4));
//			if("K_PartyExpansion".toLowerCase().equals(tablename.toLowerCase())){
//				//发展党员
//				model.setViewName(expansionEdit);
//			}else if("K_PartyActivities".toLowerCase().equals(tablename.toLowerCase())){
//				//组织活动
//				model.setViewName(activitiesEdit);
//			}else if("K_PartyCommend".toLowerCase().equals(tablename.toLowerCase())){
//				//党内奖惩
//				model.setViewName(commendEdit);
//				String ctype = CHF.showNull(request.getParameter("ctype")); 
//				if("1".equals(ctype)){
//					edit.put("ctype", "党组织");
//				}else{
//					edit.put("ctype", "党员");
//				}
//			}else if("K_PartyTraining".toLowerCase().equals(tablename.toLowerCase())){
//				//党内培训
//				model.setViewName(trainingEdit);
//			}
//			
//			if("add".equals(param)){//新增
//				edit.put("pid", pid);
//			}else if("update".equals(param)){//修改
//				edit = ps.get(tablename, "id", id);
//			}else{//删除
//				ps.del(tablename, "id", id);
//				
//				PrintWriter out = null ;
//				response.setContentType("text/html;charset=UTF-8") ;
//				out = response.getWriter() ;
//				out.println("<script>alert(\"删除信息成功!\");window.location=\""+request.getContextPath()+ url + "&id="+pid+"\"</script>");
//				out.close();
//				return null;
//			}
//			
//			model.addObject("edit", edit);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally{
//			DbUtil.close(conn);
//		}
//		return model;
//	}
//	
//	//保存
//	public ModelAndView saveTable(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		Connection conn = null;
//		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
//		String loginname = (String)userSession.getUserMap().get("loginname");
//		try {
//			ASFuntion CHF = new ASFuntion();
//			Map parameters = new HashMap();
//			Enumeration enum1 = request.getParameterNames();
//			while (enum1.hasMoreElements()) {
//				String paramName = (String) enum1.nextElement();
//				String paramValue = request.getParameter(paramName);
//				parameters.put(paramName, paramValue);
//			
//			}
//			String id =CHF.showNull((String)parameters.get("id"));
//			String tablename =CHF.showNull((String)parameters.get("tablename"));
//			
//			String url =CHF.showNull((String)parameters.get("url"));
//			conn  = new DBConnect().getConnect();
//			PartyBranchService ps = new PartyBranchService(conn);
//			
//			parameters.put("creator", loginname);
//			parameters.put("createdate", CHF.getCurrentDate());
//			
//			if("".equals(id)){
//				//新增
//				parameters.put("id", UUID.randomUUID().toString());
//				ps.add(tablename, "", parameters);
//			}else{
//				//修改
//				ps.update(tablename, "id", parameters);
//			}
//			
//			System.out.println(request.getContextPath()+url);
//			response.sendRedirect(request.getContextPath()+url);
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally{
//			DbUtil.close(conn);
//		}	
//	}
//	
//	public static void main(String[] args) {
//		String str = "ID,PartyID,TrainName,BeginDate,EndDate,Department,TrainResult,TrainTime,InitFlag,TimeFlag,TrainCnt";
//		System.out.println(str.toLowerCase());
//	}
}
