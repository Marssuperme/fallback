package cn.org.gdicpa.web.action.member;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import cn.org.gdicpa.web.service.member.MemberService;
import cn.org.gdicpa.web.service.member.model.MemberTable;
import cn.org.gdicpa.web.service.memberBranch.MemberBranchService;
import cn.org.gdicpa.web.service.memberBranch.model.MemberBranchTable;

public class MemberAction extends MultiActionController {

	private static final String MEMBER = "/member/member.jsp";
	private static final String MEMBEREdit = "/member/memberEdit.jsp";
	
//  团员	
	public ModelAndView member(HttpServletRequest request,HttpServletResponse response)throws Exception {
		Connection conn = null;
		try {
			ASFuntion CHF = new ASFuntion();
		
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
		
			conn = new DBConnect().getConnect();
			MemberService ms = new MemberService(conn);
			
			ModelAndView model = new ModelAndView(MEMBER);
			model.addObject("goBackHidden", request.getParameter("goBackHidden"));
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			String sql = "select id,partyname,post,sex,nation,rank,mobile from K_Member where officecode='"+loginid+"'";
			
			//兼容改制后的事务所查看旧的数据
			if(oldLoginId!=null){
				sql = "select id,partyname,post,sex,nation,rank,mobile from K_Member where officecode in ('"+loginid+"','"+oldLoginId+"')";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("团员列表");
		 
			pp.setInputType("radio");
			pp.setTableID("member");
			pp.setWhichFieldIsValue(1);
			pp.setPageSize_CH(10);
			
			pp.addColumn("姓名", "partyname").setTdProperty("align='center' onclick=f_view('${id}')");
			pp.addColumn("团内职务", "post","showCenter");
			pp.addColumn("性别", "sex","showCenter");
			pp.addColumn("民族", "nation","showCenter");
			pp.addColumn("职位", "rank","showCenter");
			pp.addColumn("手机", "mobile","showCenter");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH(" id");
			
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
		model.addObject("goBackHidden", request.getParameter("goBackHidden"));
		try {
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			String loginname = (String)map.get("loginname");
			
//			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
//			System.out.println("测试oldLoginId是否为空："+oldLoginId);
//			if(oldLoginId!=null){
//				String isCreateNew = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{loginid});
//				System.out.println("测试是否创建isCreateNew（NULL,是,否）: " + isCreateNew);
//				String isCreateOld = new DbUtil(conn).queryForString("select isCreate from K_MemberBranch where officecode=?",new Object[]{oldLoginId});
//				System.out.println("测试是否创建isCreateOld（NULL,是,否）: " + isCreateOld);
//				if(isCreateNew==null && isCreateOld!=null){
//					loginid = oldLoginId;
//					loginname = new DbUtil(conn).queryForString("select loginname from K_Company where loginid=?", new Object[]{loginid});
//				}
//			}
			
			String area = (String)map.get("area");
			
			ASFuntion CHF = new ASFuntion();
			String param = CHF.showNull(request.getParameter("param")); 
			String id = CHF.showNull(request.getParameter("id")); 
			
			MemberService ms = new MemberService(conn);
			Map edit = new HashMap(); 

			model.setViewName(MEMBEREdit);
			
			if("add".equals(param)){//新增
				edit.put("officecode", loginid);//事务所代码
				edit.put("loginname", loginname);//事务所全称
				String sql = "select loginid,loginname from K_Micfo where officecode=? order by loginid";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, loginid);
				ResultSet rs = pstmt.executeQuery();
				List<Map<String,String>> micfos = new ArrayList<Map<String,String>>();
				while(rs.next()){
					Map<String,String> micfo = new HashMap<String,String>();
					micfo.put("loginid", rs.getString("loginid"));
					micfo.put("loginname", rs.getString("loginname"));
					micfos.add(micfo);
				}
				model.addObject("micfos", micfos);
				
			}else if("update".equals(param)){//修改
//				String sql = "select a.*,b.ID as postid, b.BranchType,b.BranchID,b.BranchName,b.OfficeCode,b.PartyPost,b.Area,c.LoginName,b.ID as LoginID " +
//					"	from K_Party a left join (K_PartyPost b inner join K_Company c on b.OfficeCode=c.LoginID) on a.ID=b.PID " +
//					"	where a.ID = '"+id+"'";
				
				String sql = "select c.officename,m.*from K_Member m left join K_Company c on m.officecode=c.officecode " +
						"where m.id=?";				
				edit = ms.get(sql,id);
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
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
//	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		ModelAndView model = new ModelAndView(MEMBERLIST);
//		
//		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
//		Map map = userSession.getUserMap();
//		String loginid = (String)map.get("loginid");
//		String loginname = (String)map.get("loginname");
//		
//		String sql = " select id,partyname,sex,post,department,idnumber,general,partystate,joindate,relationparty,"
//				   + " borndate,marital,rank,relationdepart,email,mobile,phone,address,fax,partytype, "
//				   + " lastby,lastmodify,state,ctype,dnpxxx,dyjzxx from k_party where 1=1 ";
//		
//		DataGridProperty pp = new DataGridProperty();
//		
//		System.out.println(this.getClass()+"          index............sql="+sql);
//		
//		pp.setTitle("党员信息");
//		 
//		pp.setInputType("radio");
//		pp.setTableID("party");
//		pp.setWhichFieldIsValue(1);
//		pp.setPageSize_CH(10);
//		
//		pp.addColumn("党员姓名", "PartyName").setTdProperty("align='center' onclick=f_view('${id}')");
//		pp.addColumn("性别", "sex","showCenter");
//
//		pp.addColumn("党组织名称", "Department","showCenter");
//		pp.addColumn("事务所全称", "partyname","showCenter");
//		pp.addColumn("党内职务", "rank","showCenter");
//		pp.addColumn("身份证号", "idnumber","showCenter");
//		pp.addColumn("证书编号", "general","showCenter");
//		
//		pp.setSQL(sql);
//		pp.setOrderBy_CH("joindate");
//		pp.setDirection("desc");
//		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
//		
//		return model;
//	
//	}
	
	/**
	 * 添加、修改、查看
	 * @param request
	 * @param response
	 * @return
	 */
//	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
//		ModelAndView model = null;
//		String p = request.getParameter("param");
//		String id = request.getParameter("id");
//		Connection conn = null;
//		PartyTable pt = null;
//		try {
//			conn = new DBConnect().getConnect();
//			PartyService ps = new PartyService(conn);
//			if("view".equalsIgnoreCase(p)){
//				pt = ps.getPartyTableById(id);
//				model = new ModelAndView(MEMBERVIEW);
//			}else if("update".equalsIgnoreCase(p)){
//				pt = ps.getPartyTableById(id);
//				model = new ModelAndView(MEMBERADDANDEDIT);
//			}else{
//				// 加载 部分匹配默认数据
//				
//				model = new ModelAndView(MEMBERADDANDEDIT);
//			}
//		} catch (Exception e) {
//			System.out.println(this.getClass()+"         Exception   :"+e.getLocalizedMessage());
//			e.printStackTrace();
//		} finally{
//			DbUtil.close(conn);
//		}
//		model.addObject("pt", pt);
//		return model;
//	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @return
	 */
//	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,PartyTable pt){
//		Connection conn = null;
//		
//		try {
//			conn = new DBConnect().getConnect();
//			PartyService ps = new PartyService(conn);
//			if(!"".equals(pt.getId()) && pt.getId()!=null ){// 修改
//				ps.updatePartyById(pt);
//			}else{	// 添加
//				// 生成 id 主键
//				String guid = UUID.randomUUID().toString();
//				pt.setId(guid);
//				ps.addParty(pt);
//			}
//			response.sendRedirect("party.do?method=index");
//		} catch (Exception e) {
//			System.out.println(this.getClass()+"     exception   ERROR:"+e.getMessage());
//			e.printStackTrace();
//		} finally{
//			DbUtil.close(conn);
//		}
//		
//		return null;
//	}
	
	
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
			MemberService ms = new MemberService(conn);
			ms.deleteMemberTableById(id);
			response.sendRedirect("member.do?method=member");
		} catch (Exception e) {
			System.out.println(" exception  ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	
	
//	public ModelAndView getParty(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		Connection conn = null;
//		try {
//			conn = new DBConnect().getConnect();
//			PartyService ps = new PartyService(conn);
//			
//			ASFuntion CHF = new ASFuntion();
//			String loginname = CHF.showNull(request.getParameter("loginname")); 
//			String officecode = CHF.showNull(request.getParameter("officecode")); 
//			
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			
//			//String sql = "select * from K_Party where PartyName = '"+loginname+"' ";
//			String sql = " select * from K_Party p "
//					   + " left join K_Partypost pt "
//					   + " on p.id = pt.pid "
//					   + " where PartyName = '"+loginname+"' and officecode = '"+officecode+"' ";
//			System.out.println(sql);
//			Map map1  = ps.get(sql); //判断是否已经是党员了
//			if(map1 != null){
//				//已经是党员
//				out.write("YES");
//				out.close();
//				return null;
//			}
//			
//			sql = "select * from K_Micfo where loginname = '"+loginname+"' and officecode = '"+officecode+"' ";
//			Map map  = ps.get(sql);
//			
//			Map edit = new HashMap(); 
//			edit.put("sex",CHF.showNull((String)map.get("sex"))); //性别 sex
//			edit.put("nation",CHF.showNull((String)map.get("nation")));  //民族 nation
//			edit.put("borndate",CHF.showNull((String)map.get("borndate"))); // borndate //出生日期 borndate
//			edit.put("idnumber",CHF.showNull((String)map.get("idnumber")));  //idnumber //身份证号码 idnumber
//			edit.put("graduateschool",CHF.showNull((String)map.get("educational")));  //graduateschool //毕业学校 educational
//			edit.put("specialty",CHF.showNull((String)map.get("specialty")));  //specialty //专业 specialty
//			edit.put("degree",CHF.showNull((String)map.get("degree"))); // degree //学位 degree
//			edit.put("education",CHF.showNull((String)map.get("diploma")));  //education //学历 diploma
//			edit.put("rank",CHF.showNull((String)map.get("post"))); // rank //职务 post
//			edit.put("general",CHF.showNull((String)map.get("cpano")));  //general //CPA证号 cpano
//			edit.put("title","".equals(CHF.showNull((String)map.get("professional"))) ? "01|无" : CHF.showNull((String)map.get("professional")));  //title //职称等级 professional
//			edit.put("titlename",CHF.showNull((String)map.get("rank"))); // titlename //职称名称 rank
//			edit.put("phone",CHF.showNull((String)map.get("phone")));  //phone //电话 phone
//			edit.put("email",CHF.showNull((String)map.get("email"))); // email //电子邮箱 email
//			edit.put("mobile",CHF.showNull((String)map.get("mobile"))); // mobile //手机 mobile
//			edit.put("address",CHF.showNull((String)map.get("address"))); // address //通信地址 address
//			
//			String result = "";
//			Set coll = edit.keySet();
//			for (Iterator iter = coll.iterator(); iter.hasNext();) { 
//				String key = (String) iter.next();
//				String value = (String) edit.get(key);
//				result += "`|`" + key + "=" + value;
//			}
//			
//			out.write(result);
//			out.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally{
//			DbUtil.close(conn);
//		}
//		return null;
//	}
//	
	public ModelAndView updateSave(HttpServletRequest request,HttpServletResponse response)throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		Connection conn = null;
		PrintWriter out = null;
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
//			parameters.put("lastby", loginid); //最后修改人
//			parameters.put("lastmodify", CHF.getDateAndTime1()); //最后修改时间
			
			
			System.out.println("查看Map内容:"+parameters);
			
			
			String param = (String)parameters.get("param");
			if("add".equals(param)){
				//新增
				String id = parameters.get("memberid")==null || parameters.get("memberid")=="" ? UUID.randomUUID().toString() : (String)parameters.get("memberid");
				MemberTable mt = new MemberTable();
				mt.setId(id);
				mt.setMemberName((String)parameters.get("membername"));
				mt.setOfficeCode((String)parameters.get("officecode"));
				mt.setNation((String)parameters.get("nation"));
				mt.setBorndate((String)parameters.get("borndate"));
				mt.setIsMemberCadre((String)parameters.get("isMemberCadre"));
				mt.setPost((String)parameters.get("memberpost"));
				mt.setIsCicpa((String)parameters.get("isCicpa"));
				mt.setSex((String)parameters.get("sex"));
				mt.setEducation((String)parameters.get("education"));
				mt.setRank((String)parameters.get("rank"));
				mt.setMobile((String)parameters.get("mobile"));
				mt.setLastby(loginid);
				mt.setLastmodify(CHF.getDateAndTime1());
				
				MemberService ms = new MemberService(conn);
				ms.save(mt);
				
//				String memberBranchId = new DbUtil(conn).queryForString("select id from MemberBranch where officecode=?", new Object[]{(String)parameters.get("officecode")});
				MemberBranchService mbs = new MemberBranchService(conn);
				MemberBranchTable mbt = mbs.getByCofficeCode(mt.getOfficeCode());
				if(mbt!=null){
					String sql = "insert into K_MemberPost (ID,PID,BranchType,BranchID,BranchName,OfficeCode,Area) values (?,?,?,?,?,?,?)"; 
					PreparedStatement pstmt = conn.prepareStatement(sql);
					int i = 1;
					pstmt.setString(i++, UUID.randomUUID().toString());
					pstmt.setString(i++, mt.getId());
					pstmt.setString(i++, mbt.getBranchtype());
					pstmt.setString(i++, mbt.getId());
					pstmt.setString(i++, mbt.getBranchname());
					pstmt.setString(i++, mbt.getOfficecode());
					pstmt.setString(i++, mbt.getArea());
					pstmt.executeUpdate();
				}
				
				response.sendRedirect(request.getContextPath()+"/common/member.do?method=member");
				return null;
				
			}else if("update".equals(param)){
				
				String id = request.getParameter("memberid");
				
				MemberTable mt = new MemberTable();
				mt.setId(id);
				mt.setMemberName((String)parameters.get("membername"));
				mt.setOfficeCode((String)parameters.get("officecode"));
				mt.setNation((String)parameters.get("nation"));
				mt.setBorndate((String)parameters.get("borndate"));
				mt.setIsMemberCadre((String)parameters.get("isMemberCadre"));
				mt.setPost((String)parameters.get("memberpost"));
				mt.setIsCicpa((String)parameters.get("isCicpa"));
				mt.setSex((String)parameters.get("sex"));
				mt.setEducation((String)parameters.get("education"));
				mt.setRank((String)parameters.get("rank"));
				mt.setMobile((String)parameters.get("mobile"));
				mt.setLastby(loginid);
				mt.setLastmodify(CHF.getDateAndTime1());
				
				MemberService ms = new MemberService(conn);
				
				ms.update(mt);
				
				out = response.getWriter() ;
				out.println("<script>alert(\"修改团员信息成功!\");window.location=\""+request.getContextPath()+"/common/member.do?method=edit&param=update&id="+id+"\"</script>");
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return null;	
	}
	//点击团员姓名下拉获取注师信息ajax JSON格式
	public ModelAndView getMicfoInfo(HttpServletRequest request,HttpServletResponse response)throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		ASFuntion CHF = new ASFuntion();
		String officeCode = CHF.showNull(request.getParameter("officecode"));
		String id = CHF.showNull(request.getParameter("id"));
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		try {
			conn = new DBConnect().getConnect();
			String sql = "select loginid,loginname,sex,nation,mobile,educational,rank,post,borndate from K_Micfo where officecode=? and loginid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, officeCode);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			Map<String,String> map = new HashMap<String,String>();
			while(rs.next()){
				map.put("loginid", rs.getString("loginid"));
				map.put("loginname", rs.getString("loginname"));
				map.put("sex", rs.getString("sex"));
				map.put("nation", rs.getString("nation"));
				map.put("mobile", rs.getString("mobile"));
				map.put("educational", rs.getString("educational"));
				map.put("rank", rs.getString("rank"));
				map.put("post", rs.getString("post"));
				map.put("borndate", rs.getString("borndate"));
			}
			JSONArray json = JSONArray.fromObject(map);
			out.write(json.toString());
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			if(out!=null)out.close();
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return null;
	}
	//
	public ModelAndView checkIsMember(HttpServletRequest request,HttpServletResponse response)throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		ASFuntion CHF = new ASFuntion();
		String officeCode = CHF.showNull(request.getParameter("officecode"));
		String loginname = CHF.showNull(request.getParameter("loginname"));
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		try {
			conn = new DBConnect().getConnect();
			String sql = "select 1 from K_Member where officecode=? and partyname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, officeCode);
			pstmt.setString(2, loginname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				out.write("Y");
			}else{
				sql = "select loginid,loginname,sex,nation,mobile,educational,rank,post,borndate,degree from K_Micfo where officecode=? and loginname=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, officeCode);
				pstmt.setString(2, loginname);
				rs = pstmt.executeQuery();
				Map<String,String> map = new HashMap<String,String>();
				while(rs.next()){
					map.put("loginid", rs.getString("loginid"));
					map.put("loginname", rs.getString("loginname"));
					map.put("sex", rs.getString("sex"));
					map.put("nation", rs.getString("nation"));
					map.put("mobile", rs.getString("mobile"));
					map.put("educational", rs.getString("educational"));
					map.put("degree", rs.getString("degree"));
					map.put("post", rs.getString("post"));
					map.put("borndate", rs.getString("borndate"));
				}
				JSONArray json = JSONArray.fromObject(map);
				out.write(json.toString());
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			if(out!=null)out.close();
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return null;
	}
}
