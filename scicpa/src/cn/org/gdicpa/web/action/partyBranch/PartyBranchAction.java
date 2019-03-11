package cn.org.gdicpa.web.action.partyBranch;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.approval.ApprovalService;
import cn.org.gdicpa.web.service.partyBranch.PartyBranchService;
import cn.org.gdicpa.web.service.partyBranch.model.PartyBranchTable;
import cn.org.gdicpa.web.service.user.UserService;

public class PartyBranchAction extends MultiActionController{
	private static final String PARTYBRANCHLIST = "/partyBranch/list.jsp";
	private static final String PARTYBRANCHLIST2 = "/partyBranch/branchList.jsp";
	private static final String PARTYBRANCHADDANDEDIT = "/partyBranch/addAndEdit.jsp";
	private static final String PARTYBRANCHVIEW = "/partyBranch/view.jsp";	
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView model = new ModelAndView(PARTYBRANCHLIST);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		
		String sql = " select p.id,p.branchname,p.builddate,p.branchtype,p.branchtype2,p.affiliation,p.pid,p.pname,p.email,p.mobile,p.phone, "
				   + " p.address,p.fax,p.web,p.area,p.lastby,p.lastmodify,p.officecode,p.state,p.ctype,fzqk,mzsh,dnbz,c.loginname "  
				   + " from K_PartyBranch p left join k_company c on p.officecode = c.loginid where p.officecode = '"+loginid+"'";
		
		DataGridProperty pp = new DataGridProperty();
		
		System.out.println(this.getClass()+"          index............sql="+sql);
		
		pp.setTitle("党组织");
		 
		pp.setInputType("radio");
		pp.setTableID("partyBranch");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		
		
		pp.addColumn("党组织名称", "branchname").setTdProperty("align='center' onclick=f_view('${id}')");
		pp.addColumn("机构类型", "branchtype","showCenter");

		pp.addColumn("党组织类型", "branchtype2","showCenter");
		pp.addColumn("事务所代码", "officecode","showCenter");
		pp.addColumn("事务所全称", "loginname","showCenter");
		pp.addColumn("所属城市", "area","showCenter");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("builddate");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		return model;
	
	}
	
	/**
	 * 查看 || 修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		ASFuntion CHF = new ASFuntion();
		
		ModelAndView model = null;
		String micfoCount = "";
		String p = CHF.showNull(request.getParameter("param"));
		String id = CHF.showNull(request.getParameter("id"));
		PartyBranchTable pt = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PartyBranchService ps = new PartyBranchService(conn);
			if("view".equalsIgnoreCase(p)){
				pt = ps.getPartyBranchTableById(id);
				model = new ModelAndView(PARTYBRANCHVIEW);
			}else if("update".equalsIgnoreCase(p)){
				pt = ps.getPartyBranchTableById(id);
				model = new ModelAndView(PARTYBRANCHADDANDEDIT);
			}else{
				model = new ModelAndView(PARTYBRANCHADDANDEDIT);
			}
			System.out.println(this.getClass()+"        p="+p+"          id="+id+"    getBranchname=  "+pt.getBranchname());
			
			// 找出成员数
			// micfoCount = new DbUtil(conn).queryForString("");

		} catch (Exception e) {
			System.out.println(" Connection   ERROR:"+e.getMessage());
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		model.addObject("micfoCount", micfoCount);
		model.addObject("loginname", loginname);
		model.addObject("pt", pt);
		return model;
	
	}
	

	/**
	 * 保存
	 * @param request
	 * @param response
	 * @param pt
	 * @return
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,PartyBranchTable pt){
		Connection conn = null;
		PartyBranchService ps = null;
		try {
			conn = new DBConnect().getConnect();
			ps = new PartyBranchService(conn);
			ps.updatePartyBranchTablePart(pt);
			response.sendRedirect("partyBranch.do?method=index");
		} catch (Exception e) {
			System.out.println("Exception  ERROR:"+e.getMessage());
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 党组织列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goBranchList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Connection conn = null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			String loginidTemp = loginid;
			ASFuntion CHF = new ASFuntion();
			
			conn = new DBConnect().getConnect();
			//改制后的事务所引用旧数据
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			if(oldLoginId!=null){
				loginid = oldLoginId;
			}
			
			PartyBranchService ps = new PartyBranchService(conn);
			Map branch = ps.getBranch(loginid);
			if(oldLoginId!=null && branch.size()==0){
				branch = ps.getBranch(loginidTemp);
			}
			System.out.println(branch+"=====");
			String isbranch = "1";
			if(CHF.showNull(branch.get("id")+"") == null || "".equals(CHF.showNull(branch.get("id")+""))){
				isbranch = "0";//还没有加入党组织
				//返回主页面
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert('本事务所还没有加入党组织，请先到注协申请加入！');window.location=\""+request.getContextPath()+"/company/company.do?method=goAddFrame&param=mainFrame\"</script>");
				out.close();				
				return null;
			}else{
				ModelAndView model = new ModelAndView(PARTYBRANCHLIST2);
				System.out.println("goBranchList...");
				
				String sql = "select id,BranchName,buildDate,BranchType,branchType2,area,affiliation,pname from K_PartyBranch where OfficeCode in ('"+loginid+"','"+loginidTemp+"')";
				DataGridProperty pp = new DataGridProperty();
				
				System.out.println(this.getClass()+"          index............sql="+sql);
				//党组织名称|党组织成立日期|机构类型|党组织类型|所属城市|隶属关系|所属党组织
				pp.setTitle("党组织列表");
				pp.setTableID("BranchList");
				pp.setWhichFieldIsValue(1);
				pp.setPageSize_CH(10);
				
				pp.addColumn("党组织名称", "branchname").setTdProperty("align='center' onclick=f_view('${id}')");
				pp.addColumn("党组织成立日期", "buildDate","showCenter");
				pp.addColumn("机构类型", "branchtype","showCenter");
				pp.addColumn("党组织类型", "branchtype2","showCenter");
				pp.addColumn("所属城市", "area","showCenter");
				pp.addColumn("隶属关系", "affiliation","showCenter");
				pp.addColumn("所属党组织", "pname","showCenter");
				
				pp.setSQL(sql);
				pp.setOrderBy_CH("builddate");
				request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
	}
	
	//===========================================================================================================
	//重写党建
	//===========================================================================================================
	/**
	 * 1、党组织:找事务所的党组织
	 * 2、党员
	 * 3、党建制度
	 */	
	//党组织
	public ModelAndView goAddFrame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("goAddFrame...");
		Connection conn = null;
		try {
			ASFuntion CHF = new ASFuntion();
			String id = CHF.showNull(request.getParameter("id"));			
			System.out.println("ID ==  >>>>>>    "+id);
			conn = new DBConnect().getConnect();
			ModelAndView model = new ModelAndView("/partyBranch/addframe.jsp");
			model.addObject("id", id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		
	}
	
	//党组织
	private static final String branch = "/partyBranch/branch.jsp";
	public ModelAndView branch(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		Connection conn = null;
		ModelAndView model = new ModelAndView(branch);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			ASFuntion CHF = new ASFuntion();
			String id = CHF.showNull(request.getParameter("id"));
			
			conn = new DBConnect().getConnect();
			
			PartyBranchService ps = new PartyBranchService(conn);
			Map branch = ps.getBranchById(id);
			
			String isbranch = "1";
			if(CHF.showNull((String)branch.get("id")) == null || "".equals(CHF.showNull((String)branch.get("id")))){
				isbranch = "0";//还没有加入党组织
			}else{
				ps.get((String)branch.get("id"),branch);
				
				UserService user = new UserService(conn);
				Map userMap = user.getUser( "K_Company", CHF.showNull((String)branch.get("officecode")));
				branch.put("officename", userMap.get("loginname"));
				
				String isworker = (String)new DbUtil(conn).queryForObject("select isworker from k_partyBranch where officecode=?", new Object[]{loginid});
				String acpa = (String)new DbUtil(conn).queryForObject("select acpa from k_partyBranch where officecode=?", new Object[]{loginid});
				branch.put("isworker",isworker==null || "".equals(isworker) ? "无" : isworker);
				branch.put("acpa",acpa==null || "".equals(acpa) ? "否" : acpa);
				//if("".equals(CHF.showNull((String)branch.get("isworker")))) branch.put("isworker", "无");
				
				// if(loginid.equals(CHF.showNull((String)branch.get("officecode"))))  
					branch.put("isupdate", "1"); //只有党组织所在的事务所才能修改党组织信息
				
			}
			
			model.addObject("isbranch", isbranch);
			
			System.out.println("branch | " + branch);
			model.addObject("branch", branch);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	//修改党组织
	public ModelAndView updateSave(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		Connection conn=null;
		PreparedStatement ps = null;
		PreparedStatement pstmt = null;
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
			System.out.println("MMMMMMMMMMMMMMMMMMM--------------->parameters: "+parameters);
			ASFuntion CHF = new ASFuntion();
			parameters.put("lastby", loginid);
			parameters.put("lastmodify", CHF.getDateAndTime1());
			if("".equals(CHF.showNull((String)parameters.get("bunion"))))parameters.put("bunion", "0");
			if("".equals(CHF.showNull((String)parameters.get("bmember"))))parameters.put("bmember", "0");
			if("".equals(CHF.showNull((String)parameters.get("bwomens"))))parameters.put("bwomens", "0");
			if("".equals(CHF.showNull((String)parameters.get("bother"))))parameters.put("bother", "0");
			
			String id = CHF.showNull(request.getParameter("id"));
			
			String sql = "update K_PartyBranch set apartyname=?,partynum=?,cpanum=?,aphone=?,officecode=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, (String)parameters.get("apartyname"));	
			ps.setString(2, (String)parameters.get("partynum"));
			ps.setString(3, (String)parameters.get("cpanum"));
			ps.setString(4, (String)parameters.get("aphone"));
			ps.setString(5, loginid);
			ps.setString(6, id);
			ps.executeUpdate(); 
			
			pstmt = conn.prepareStatement("update K_PartyBranch set isworker=?,acpa=? where id=?");
			pstmt.setString(1, (String)parameters.get("isworker"));
			pstmt.setString(2, (String)parameters.get("acpa"));
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
			ApprovalService ss = new ApprovalService(conn);
			ss.setPerson(loginname); //设置变动人
			ss.save("K_PartyBranch", (String)parameters.get("id"), parameters);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"修改党组织信息成功!\");window.location=\""+request.getContextPath()+"/common/partyBranch.do?method=branch&id="+id+"\"</script>");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(ps);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
	}
	
	//发展党员
	private static final String expansion = "/partyBranch/expansion.jsp";
	private static final String expansionEdit = "/partyBranch/expansionEdit.jsp";
	//组织活动
	private static final String activities = "/partyBranch/activities.jsp";
	private static final String activitiesEdit = "/partyBranch/activitiesEdit.jsp";
	//党内奖惩
	private static final String commend = "/partyBranch/commend.jsp";
	private static final String commendEdit = "/partyBranch/commendEdit.jsp";
	//党内培训
	private static final String training = "/partyBranch/training.jsp";
	private static final String trainingEdit = "/partyBranch/trainingEdit.jsp";
	public ModelAndView expansion(HttpServletRequest request,HttpServletResponse response)throws Exception {
		ModelAndView model = new ModelAndView(expansion);
		ASFuntion CHF = new ASFuntion();
		String id = CHF.showNull(request.getParameter("id")); 
		
		String sql = " Select * From K_PartyExpansion Where PID='"+id+"' ";

		DataGridProperty pp = new DataGridProperty();
		
		pp.setTitle("发展党员");
		 
		pp.setInputType("radio");
		pp.setTableID("partyExpansion");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		
		pp.addColumn("年度", "sYear","showCenter");
		pp.addColumn("发展新党员人数", "NewNum","showCenter");
		pp.addColumn("申请入党人数", "ApplyNum","showCenter");
		pp.addColumn("确定培养对象(入党积极分子)人数", "GrowNum","showCenter");
		pp.addColumn("审核人", "auditor","showCenter");//添加审核人
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("sYear");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		model.addObject("pid", id);
		return model;
	}

	public ModelAndView activities(HttpServletRequest request,HttpServletResponse response)throws Exception {
		ModelAndView model = new ModelAndView(activities);
		ASFuntion CHF = new ASFuntion();
		String id = CHF.showNull(request.getParameter("id")); 
		
		String sql = " Select * From K_PartyActivities Where PID='"+id+"' ";

		DataGridProperty pp = new DataGridProperty();
		
		pp.setTitle("组织活动");
		 
		pp.setInputType("radio");
		pp.setTableID("partyActivities");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		
		pp.addColumn("年度", "sYear","showCenter");
		pp.addColumn("三会次数", "ThreeNum","showCenter");
		pp.addColumn("组织(民主)生活会次数", "ActivitiesNum","showCenter");
		pp.addColumn("党课次数", "ClassNum","showCenter");
		pp.addColumn("开展主题活动情况", "ActContent");
		pp.addColumn("审核人", "auditor","showCenter");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("sYear");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		model.addObject("pid", id);
		return model;
	}
	
	
	public ModelAndView commend(HttpServletRequest request,HttpServletResponse response)throws Exception {
		ModelAndView model = new ModelAndView(commend);
		ASFuntion CHF = new ASFuntion();
		String id = CHF.showNull(request.getParameter("id")); 
		
		String sql = " Select * From K_PartyCommend Where PID='"+id+"' ";

		DataGridProperty pp = new DataGridProperty();
		
		pp.setTitle("党内奖惩");
		 
		pp.setInputType("radio");
		pp.setTableID("partyCommend");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		
		pp.addColumn("年度", "sYear","showCenter");
		pp.addColumn("类型", "sType","showCenter");
		pp.addColumn("名称", "CommendName");
		pp.addColumn("级别", "CommendType");
		pp.addColumn("批准时间", "ApprovalTime");
		pp.addColumn("批准机构名称", "ApprovalDepart");
		pp.addColumn("审核人", "auditor","showCenter");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("sYear");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		model.addObject("pid", id);
		return model;
	}
	
	public ModelAndView training(HttpServletRequest request,HttpServletResponse response)throws Exception {
		ModelAndView model = new ModelAndView(training);
		ASFuntion CHF = new ASFuntion();
		String id = CHF.showNull(request.getParameter("id")); 
		
		String sql = " Select * From K_PartyTraining Where PartyID = '"+id+"' ";

		DataGridProperty pp = new DataGridProperty();
		
		pp.setTitle("党内培训");
		 
		pp.setInputType("radio");
		pp.setTableID("partyTraining");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		pp.addColumn("培训班名称", "TrainName");
		pp.addColumn("开始日期", "BeginDate","showCenter");
		pp.addColumn("截止日期", "EndDate","showCenter");
		pp.addColumn("培训单位", "DepartMent");
		pp.addColumn("完成情况", "TrainResult");
		pp.addColumn("培训学时数", "TrainTime","showCenter");
		pp.addColumn("审核人", "auditor","showCenter");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("BeginDate");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		model.addObject("pid", id);
		return model;
	}
	
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		ModelAndView model = new ModelAndView();
		try {
			ASFuntion CHF = new ASFuntion();
			String param = CHF.showNull(request.getParameter("param")); 
			String id = CHF.showNull(request.getParameter("id")); 
			String pid = CHF.showNull(request.getParameter("pid")); 
			
			String tablename = CHF.showNull(request.getParameter("tablename"));
			String url = CHF.showNull(request.getParameter("url"));
			
			conn = new DBConnect().getConnect();
			PartyBranchService ps = new PartyBranchService(conn);
			Map edit = new HashMap();
			
			edit.put("syear", CHF.getCurrentDate().substring(0, 4));
			if("K_PartyExpansion".toLowerCase().equals(tablename.toLowerCase())){
				//发展党员
				model.setViewName(expansionEdit);
			}else if("K_PartyActivities".toLowerCase().equals(tablename.toLowerCase())){
				//组织活动
				model.setViewName(activitiesEdit);
			}else if("K_PartyCommend".toLowerCase().equals(tablename.toLowerCase())){
				//党内奖惩
				model.setViewName(commendEdit);
				String ctype = CHF.showNull(request.getParameter("ctype")); 
				if("1".equals(ctype)){
					edit.put("ctype", "党组织");
				}else{
					edit.put("ctype", "党员");
				}
			}else if("K_PartyTraining".toLowerCase().equals(tablename.toLowerCase())){
				//党内培训
				model.setViewName(trainingEdit);
			}
			
			if("add".equals(param)){//新增
				edit.put("pid", pid);
			}else if("update".equals(param)){//修改
				edit = ps.get(tablename, "id", id);
			}else{//删除
				ps.del(tablename, "id", id);
				
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\"删除信息成功!\");window.location=\""+request.getContextPath()+ url + "&id="+pid+"\"</script>");
				out.close();
				return null;
			}
			
			model.addObject("edit", edit);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	//保存
	public ModelAndView saveTable(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginname = (String)userSession.getUserMap().get("loginname");
		try {
			ASFuntion CHF = new ASFuntion();
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			String id =CHF.showNull((String)parameters.get("id"));
			String tablename =CHF.showNull((String)parameters.get("tablename"));
			
			String url =CHF.showNull((String)parameters.get("url"));
			conn  = new DBConnect().getConnect();
			PartyBranchService ps = new PartyBranchService(conn);
			
			parameters.put("creator", loginname);
			parameters.put("createdate", CHF.getCurrentDate());
			
			if("".equals(id)){
				//新增
				parameters.put("id", UUID.randomUUID().toString());
				ps.add(tablename, "", parameters);
			}else{
				//修改
				ps.update(tablename, "id", parameters);
			}
			
			System.out.println(request.getContextPath()+url);
			response.sendRedirect(request.getContextPath()+url);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}	
	}
	
	public static void main(String[] args) {
		String str = "ID,PartyID,TrainName,BeginDate,EndDate,Department,TrainResult,TrainTime,InitFlag,TimeFlag,TrainCnt";
		System.out.println(str.toLowerCase());
	}
}
