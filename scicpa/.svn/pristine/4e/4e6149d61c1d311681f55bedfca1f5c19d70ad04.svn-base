package cn.org.gdicpa.web.action.party;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.approval.ApprovalService;
import cn.org.gdicpa.web.service.party.PartyService;
import cn.org.gdicpa.web.service.party.model.PartyTable;
import cn.org.gdicpa.web.service.partyBranch.PartyBranchService;


public class PartyAction extends MultiActionController {
	private static final String PARTYLIST = "/party/list.jsp";
	private static final String PARTYVIEW = "/party/view.jsp";
	private static final String PARTYADDANDEDIT = "/party/addAndEdit.jsp";
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView model = new ModelAndView(PARTYLIST);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		
		String sql = " select id,partyname,sex,post,department,idnumber,general,partystate,joindate,relationparty,"
				   + " borndate,marital,rank,relationdepart,email,mobile,phone,address,fax,partytype, "
				   + " lastby,lastmodify,state,ctype,dnpxxx,dyjzxx from k_party where 1=1 ";
		
		DataGridProperty pp = new DataGridProperty();
		
		System.out.println(this.getClass()+"          index............sql="+sql);
		
		pp.setTitle("党员信息");
		 
		pp.setInputType("radio");
		pp.setTableID("party");
		pp.setWhichFieldIsValue(1);
		pp.setPageSize_CH(10);
		
		pp.addColumn("党员姓名", "PartyName").setTdProperty("align='center' onclick=f_view('${id}')");
		pp.addColumn("性别", "sex","showCenter");

		pp.addColumn("党组织名称", "Department","showCenter");
		pp.addColumn("事务所全称", "partyname","showCenter");
		pp.addColumn("党内职务", "rank","showCenter");
		pp.addColumn("身份证号", "idnumber","showCenter");
		pp.addColumn("证书编号", "general","showCenter");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("joindate");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		
		return model;
	
	}
	
	/**
	 * 添加、修改、查看
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		String p = request.getParameter("param");
		String id = request.getParameter("id");
		Connection conn = null;
		PartyTable pt = null;
		try {
			conn = new DBConnect().getConnect();
			PartyService ps = new PartyService(conn);
			if("view".equalsIgnoreCase(p)){
				pt = ps.getPartyTableById(id);
				model = new ModelAndView(PARTYVIEW);
			}else if("update".equalsIgnoreCase(p)){
				pt = ps.getPartyTableById(id);
				model = new ModelAndView(PARTYADDANDEDIT);
			}else{
				// 加载 部分匹配默认数据
				
				model = new ModelAndView(PARTYADDANDEDIT);
			}
		} catch (Exception e) {
			System.out.println(this.getClass()+"         Exception   :"+e.getLocalizedMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		model.addObject("pt", pt);
		return model;
	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,PartyTable pt){
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			PartyService ps = new PartyService(conn);
			if(!"".equals(pt.getId()) && pt.getId()!=null ){// 修改
				ps.updatePartyById(pt);
			}else{	// 添加
				// 生成 id 主键
				String guid = UUID.randomUUID().toString();
				pt.setId(guid);
				ps.addParty(pt);
			}
			response.sendRedirect("party.do?method=index");
		} catch (Exception e) {
			System.out.println(this.getClass()+"     exception   ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PartyService ps = new PartyService(conn);
			ps.deletePartyTableById(id);
			response.sendRedirect("party.do?method=party");
		} catch (Exception e) {
			System.out.println(" exception  ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	//===========================================================================================================
	//重写党建
	//===========================================================================================================
	/**
	 * 1、党组织:找事务所的党组织
	 * 2、党员
	 * 3、党建制度
	 */
	//党员
	private static final String party = "/party/party.jsp";
	private static final String partyEdit = "/party/partyEdit.jsp";
	public ModelAndView party(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		try {
			ASFuntion CHF = new ASFuntion();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			conn = new DBConnect().getConnect();
			//改制后的事务所引用旧数据
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			String flag = new DbUtil(conn).queryForString("select 1 from K_PartyBranch where officecode=?",new Object[]{oldLoginId});
			String loginid_temp = loginid;
			
			if(flag!=null && oldLoginId!=null){
				loginid_temp = oldLoginId;
			}
			PartyBranchService ps = new PartyBranchService(conn);
			Map branch = ps.getBranch(loginid_temp);
			
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
				ModelAndView model = new ModelAndView(party);
				String sql = " select a.*,b.ID as PostGUID, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
						"From K_Party a left join (K_PartyPost b left join K_Company c on b.OfficeCode=c.LoginID)on a.ID=b.PID Where b.OfficeCode='"+loginid+"' ";
		
				if(oldLoginId!=null){
					sql = " select a.*,b.ID as PostGUID, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
					"From K_Party a left join (K_PartyPost b left join K_Company c on b.OfficeCode=c.LoginID)on a.ID=b.PID Where b.OfficeCode in ('"+loginid+"','"+oldLoginId+"')";
				}
				DataGridProperty pp = new DataGridProperty();
				
				pp.setTitle("党员列表");
				 
				pp.setInputType("radio");
				pp.setTableID("party");
				pp.setWhichFieldIsValue(1);
				pp.setPageSize_CH(10);
				
				pp.addColumn("姓名", "PartyName").setTdProperty("align='center' onclick=f_view('${id}')");
		//		pp.addColumn("所在事务所名称", "loginname");
		//		pp.addColumn("所属党组织类型", "BranchType");
		//		pp.addColumn("党组织名称", "BranchName");
				pp.addColumn("党内职务", "PartyPost","showCenter");
		//		pp.addColumn("党籍状态", "PartyState");
		//		pp.addColumn("入党时间", "JoinDate","showCenter");
				pp.addColumn("固定电话", "Phone","showCenter");
				pp.addColumn("传真", "Fax","showCenter");
				pp.addColumn("手机", "Mobile","showCenter");
				pp.addColumn("电子邮箱", "EMail");
				
				pp.setSQL(sql);
				pp.setOrderBy_CH(" case When PartyPost Like '书记%' then 1 when PartyPost like '副书记%' then 2 when PartyPost like '%委员%' then 3 when PartyPost like '%党务工作者%' then 4 else 5 end , PartyName");
				
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
	
	public ModelAndView partyById(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		try {
			
			ASFuntion CHF = new ASFuntion();
			String id = CHF.showNull(request.getParameter("id"));
			
//			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
//			Map map = userSession.getUserMap();
//			String loginid = (String)map.get("loginid");
//			conn = new DBConnect().getConnect();
//			//改制后的事务所引用旧数据
//			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
//			String flag = new DbUtil(conn).queryForString("select 1 from K_PartyBranch where officecode=?",new Object[]{oldLoginId});
//			String loginid_temp = loginid;
//			
//			if(flag!=null && oldLoginId!=null){
//				loginid_temp = oldLoginId;
//			}
//			PartyBranchService ps = new PartyBranchService(conn);
//			Map branch = ps.getBranch(loginid_temp);
//			
//			String isbranch = "1";
			
//			if(CHF.showNull(branch.get("id")+"") == null || "".equals(CHF.showNull(branch.get("id")+""))){
//				isbranch = "0";//还没有加入党组织
//				//返回主页面
//				PrintWriter out = null ;
//				response.setContentType("text/html;charset=UTF-8") ;
//				out = response.getWriter() ;
//				out.println("<script>alert('本事务所还没有加入党组织，请先到注协申请加入！');window.location=\""+request.getContextPath()+"/company/company.do?method=goAddFrame&param=mainFrame\"</script>");
//				out.close();
//				
//				return null;
//			}else{
//				//TODO---
//				ModelAndView model = new ModelAndView(party);
//				String sql = " select a.*,b.ID as PostGUID, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
//				"From K_Party a left join (K_PartyPost b left join K_Company c on b.OfficeCode=c.LoginID)on a.ID=b.PID Where b.OfficeCode='"+loginid+"' ";
//				
//				if(oldLoginId!=null){
//					sql = " select a.*,b.ID as PostGUID, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
//					"From K_Party a left join (K_PartyPost b left join K_Company c on b.OfficeCode=c.LoginID)on a.ID=b.PID Where b.OfficeCode in ('"+loginid+"','"+oldLoginId+"')";
//				}
//			}
			
			
			ModelAndView model = new ModelAndView(party);
			String sql = "select p.*,b.ID as PostGUID, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
			" from k_partyPost b inner join K_Party p on b.pid = p.id inner join k_company c on b.officecode=c.officecode where b.branchid='"+id+"'";
			
			System.out.println("sql :   ==  >>   " + sql);
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("党员列表");
			
			pp.setInputType("radio");
			pp.setTableID("party");
			pp.setWhichFieldIsValue(1);
			pp.setPageSize_CH(10);
			
			pp.addColumn("姓名", "PartyName").setTdProperty("align='center' onclick=f_view('${id}')");
			//		pp.addColumn("所在事务所名称", "loginname");
			//		pp.addColumn("所属党组织类型", "BranchType");
			//		pp.addColumn("党组织名称", "BranchName");
			pp.addColumn("党内职务", "PartyPost","showCenter");
			//		pp.addColumn("党籍状态", "PartyState");
			//		pp.addColumn("入党时间", "JoinDate","showCenter");
			pp.addColumn("固定电话", "Phone","showCenter");
			pp.addColumn("传真", "Fax","showCenter");
			pp.addColumn("手机", "Mobile","showCenter");
			pp.addColumn("电子邮箱", "EMail");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH(" case When PartyPost Like '书记%' then 1 when PartyPost like '副书记%' then 2 when PartyPost like '%委员%' then 3 when PartyPost like '%党务工作者%' then 4 else 5 end , PartyName");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
	}
	
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		ModelAndView model = new ModelAndView();
		try {
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			String loginname = (String)map.get("loginname");
			
			
//			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
//			System.out.println("测试oldLoginId是否为空："+oldLoginId);
//			if(oldLoginId!=null){
//				loginid = oldLoginId;
//				loginname = new DbUtil(conn).queryForString("select loginname from K_Company where loginid=?", new Object[]{loginid});
//			}
			
			String area = (String)map.get("area");
			
			ASFuntion CHF = new ASFuntion();
			String param = CHF.showNull(request.getParameter("param")); 
			String id = CHF.showNull(request.getParameter("id")); 
			
			PartyService ps = new PartyService(conn);
			Map edit = new HashMap(); 

			model.setViewName(partyEdit);
			
			if("add".equals(param)){//新增
				PartyBranchService pbs = new PartyBranchService(conn);
				Map branch = pbs.getBranch(loginid);
				
				edit.put("branchid",CHF.showNull((String)branch.get("id")));//党组织ID
				edit.put("branchtype",CHF.showNull((String)branch.get("branchtype")));//所属党组织类型
				edit.put("branchname",CHF.showNull((String)branch.get("branchname")));//党组织名称
				
				edit.put("officecode", loginid);//事务所代码
				edit.put("loginname", loginname);//事务所全称
				edit.put("area",area);//事务所地区
				
				edit.put("nonland","否");//是否港澳台籍
				edit.put("education","");//学历
				edit.put("degree","");//学位
				edit.put("marital","");//婚姻状态
				edit.put("rank","");//职位
				edit.put("partypost","");//党内职务
				edit.put("isworker","否");//是否党务工作者
				edit.put("lastpost","");//曾任党内职务
				
			}else if("update".equals(param)){//修改
				
				String sql = "select a.*,b.ID as postid, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
					"	from K_Party a left join (K_PartyPost b inner join K_Company c on b.OfficeCode=c.LoginID) on a.ID=b.PID " +
					"	where a.ID = '"+id+"'";
				edit = ps.get(sql);
			}
			
			System.out.println(param+"|"+edit);
			model.addObject("edit", edit);
			model.addObject("paramopt", param);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	public ModelAndView getParty(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PartyService ps = new PartyService(conn);
			
			ASFuntion CHF = new ASFuntion();
			String loginname = CHF.showNull(request.getParameter("loginname")); 
			String officecode = CHF.showNull(request.getParameter("officecode")); 
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			//String sql = "select * from K_Party where PartyName = '"+loginname+"' ";
			String sql = " select * from K_Party p "
					   + " left join K_Partypost pt "
					   + " on p.id = pt.pid "
					   + " where PartyName = '"+loginname+"' and officecode = '"+officecode+"' ";
			Map map1  = ps.get(sql); //判断是否已经是党员了
			if(map1 != null){
				//已经是党员
				out.write("YES");
				out.close();
				return null;
			}
			
			sql = "select * from K_Micfo where loginname = '"+loginname+"' and officecode = '"+officecode+"' ";
			Map map  = ps.get(sql);
			
			Map edit = new HashMap(); 
			if(map!=null){
				edit.put("sex",CHF.showNull((String)map.get("sex"))); //性别 sex
				edit.put("nation",CHF.showNull((String)map.get("nation")));  //民族 nation
				edit.put("borndate",CHF.showNull((String)map.get("borndate"))); // borndate //出生日期 borndate
				edit.put("idnumber",CHF.showNull((String)map.get("idnumber")));  //idnumber //身份证号码 idnumber
				edit.put("graduateschool",CHF.showNull((String)map.get("educational")));  //graduateschool //毕业学校 educational
				edit.put("specialty",CHF.showNull((String)map.get("specialty")));  //specialty //专业 specialty
				edit.put("degree",CHF.showNull((String)map.get("degree"))); // degree //学位 degree
				edit.put("education",CHF.showNull((String)map.get("diploma")));  //education //学历 diploma
				edit.put("rank",CHF.showNull((String)map.get("post"))); // rank //职务 post
				edit.put("general",CHF.showNull((String)map.get("cpano")));  //general //CPA证号 cpano
				edit.put("title","".equals(CHF.showNull((String)map.get("professional"))) ? "01|无" : CHF.showNull((String)map.get("professional")));  //title //职称等级 professional
				edit.put("titlename",CHF.showNull((String)map.get("rank"))); // titlename //职称名称 rank
				edit.put("phone",CHF.showNull((String)map.get("phone")));  //phone //电话 phone
				edit.put("email",CHF.showNull((String)map.get("email"))); // email //电子邮箱 email
				edit.put("mobile",CHF.showNull((String)map.get("mobile"))); // mobile //手机 mobile
				edit.put("address",CHF.showNull((String)map.get("address"))); // address //通信地址 address
			}
			String result = "";
//			Set coll = edit.keySet();
//			for (Iterator iter = coll.iterator(); iter.hasNext();) { 
//				String key = (String) iter.next();
//				String value = (String) edit.get(key);
//				result += "`|`" + key + "=" + value;
//			}
//			out.write(result);
			
			JSONArray json = JSONArray.fromObject(map);
			out.write(json.toString());
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	public ModelAndView updateSave(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			String loginid = (String)userMap.get("loginid");
			String loginname = (String)userMap.get("loginname");
			
			ASFuntion CHF = new ASFuntion();
			
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			
			parameters.put("lastby", loginid); //最后修改人
			parameters.put("lastmodify", CHF.getDateAndTime1()); //最后修改时间
			if("".equals(CHF.showNull((String)parameters.get("industry1"))))parameters.put("industry1", "0");
			if("".equals(CHF.showNull((String)parameters.get("industry2"))))parameters.put("industry2", "0");
			if("".equals(CHF.showNull((String)parameters.get("industry3"))))parameters.put("industry3", "0");
			if("".equals(CHF.showNull((String)parameters.get("industry4"))))parameters.put("industry4", "0");
			
			if("".equals(CHF.showNull((String)parameters.get("politics1"))))parameters.put("politics1", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics2"))))parameters.put("politics2", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics3"))))parameters.put("politics3", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics4"))))parameters.put("politics4", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics5"))))parameters.put("politics5", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics6"))))parameters.put("politics6", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics7"))))parameters.put("politics7", "0");
			if("".equals(CHF.showNull((String)parameters.get("politics8"))))parameters.put("politics8", "0");
			
			String param = (String)parameters.get("param");
			if("add".equals(param)){
				//新增
				String id = UUID.randomUUID().toString();
				parameters.put("id", id);
				PartyBranchService ps = new PartyBranchService(conn);
				// 是否有该党员了，有的话就 update
				String idnumber = parameters.get("idnumber")+"";
				String partyname = parameters.get("partyname")+"";
				
				String idDB = CHF.showNull(new DbUtil(conn).queryForString("select id from K_Party p where partyname=? and idnumber=?",new Object[]{partyname,idnumber}));
				if(!"".equals(idDB)){
					parameters.put("id", idDB);
					id = idDB;
					ps.update("K_Party", "id", parameters); //党员表
				}else{
					ps.add("K_Party", "", parameters); //党员表
				}
				
				
				parameters.put("id", UUID.randomUUID().toString());
				parameters.put("pid", id);
				ps.add("K_PartyPost", "", parameters); //党内职务表
				
				response.sendRedirect(request.getContextPath()+"/common/party.do?method=party");
				return null;
				
			}else if("update".equals(param)){
				
				
				ApprovalService ss = new ApprovalService(conn);
				ss.setPerson(loginname); //设置变动人
				
				String id = parameters.get("id")+"";
				
				String sql = "update K_Party set iscpa=?,rank=? where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, (String)parameters.get("iscpa"));
				pstmt.setString(2, (String)parameters.get("rank"));
				pstmt.setString(3, id);
				pstmt.executeUpdate();
				
				// 保存
				ss.save("K_Party", id, parameters);
				
				// 修改
				PartyBranchService ps = new PartyBranchService(conn);
				System.out.println("id="+id+"||||||postid="+parameters.get("postid"));
				parameters.put("id", parameters.get("postid"));
				parameters.put("pid", id);
				
				ps.update("K_PartyPost", "id", parameters); //党内职务表
				
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\"修改党员信息成功!\");window.location=\""+request.getContextPath()+"/common/party.do?method=edit&param=update&id="+id+"\"</script>");
				out.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return null;	
	}
	
	
}
