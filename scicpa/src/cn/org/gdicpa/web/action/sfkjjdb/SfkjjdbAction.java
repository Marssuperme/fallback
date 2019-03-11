package cn.org.gdicpa.web.action.sfkjjdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.UUID;

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
import cn.org.gdicpa.web.service.companyList.CompanyListService;
import cn.org.gdicpa.web.service.companyList.model.CompanyListTable;
import cn.org.gdicpa.web.service.content.ContentService;
import cn.org.gdicpa.web.service.content.model.ContentTable;
import cn.org.gdicpa.web.service.sfkjjdb.SfkjjdbService;
import cn.org.gdicpa.web.service.sfkjjdb.model.SfkjjdbTable;
import cn.org.gdicpa.web.service.user.UserService;

public class SfkjjdbAction extends MultiActionController{
	private static String LIST = "/bbsfkjjdb/list.jsp";
	private static String ADDANDEDIT = "/bbsfkjjdb/addAndEdit.jsp";
	private static String SEARCH = "/bbsfkjjdb/search.jsp";
	
	
	/**
	 * 页面跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		model = new ModelAndView("/bbsfkjjdb/addTree.jsp");
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
		String typeid = request.getParameter("typeid");
		System.out.println(this.getClass()+"        typeid = "+typeid);
		String bbnum = request.getParameter("bbnum");
		
		try {
			String sql = "select guid,companyGUID,typeid,wtdwmc,khjjxj,bsdwmc,kmhylx,wtxmlx,ywyds,qyrq,bgwh,qmzs1,qmzs2,qmzs3,bbbh,isnull(isreviewed,'否') as isreviewed,bbstate from [BB_CONTENT1] where typeid = '"+typeid+"' and  BBPERSON = '"+loginid+"'";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("司法会计鉴定");
			 
			pp.setInputType("radio");
			pp.setTableID("sfkjjdb");
			pp.setWhichFieldIsValue(1);
			
			//pp.setPrintColumnWidth("20,20,20");
			
			// 委托单位名称     被审（验）单位           业务约定书号码         报备编号     报备状态      是否审核
			
			pp.addColumn("委托单位", "wtdwmc").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}')");
			pp.addColumn("被审（验）单位", "bsdwmc").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}')");

			pp.addColumn("业务约定书号码", "ywyds").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}')");
			pp.addColumn("报备编号", "bbbh").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}')");
			pp.addColumn("报备状态 ", "bbstate").setTdProperty("style='text-align: center' onclick=f_viewTD('${guid}','${companyGUID}')");
			pp.addColumn("是否审核", "isreviewed").setTdProperty("style='text-align: center' onclick=f_viewTD('${guid}','${companyGUID}')");
			
//			pp.addColumn("签字注师1", "qmzs1").setTdProperty("onclick=f_viewTD('${guid}','${companyGUID}')");
//			pp.addColumn("签字注师2", "qmzs2").setTdProperty("onclick=f_viewTD('${guid}','${companyGUID}')");
//			pp.addColumn("签字注师3", "qmzs3").setTdProperty("onclick=f_viewTD('${guid}','${companyGUID}')");
			
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("guid");
			pp.setDirection("asc");
			model.addObject("typeid",typeid);
			model.addObject("bbnum",bbnum);
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
	public ModelAndView addSfkjjdbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		System.out.println(this.getClass()+"   area= "+area);
		String bbbh = "";// 报备编号

		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			String cltguid = request.getParameter("cltguid");
			if(cltguid != null && !"".equals(cltguid)){
				companyGUID = cltguid;
			}
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(request.getParameter("person"));
			clt.setPhone(request.getParameter("phone"));
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 司法会计鉴定
			SfkjjdbService ss = new SfkjjdbService(conn);
			

			SfkjjdbTable st = new SfkjjdbTable();
			st.setGuid(GUID);  // 设置与相应报备内容的id
			st.setJdjg(request.getParameter("jdjg"));

			// 设置主键
			ct.setGuid(GUID); 
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate("报备中");
			
			// 司法会计鉴定
			ss.addSfkjjdbTable(st);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			// 代报事务所
			if(cltguid != null && !"".equals(cltguid)){
				cls.updateCompanyListTable(clt);
			}else{
				cls.addCompanyListTable(clt);
			}
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
//			userMap.put("officename", clt.getCompanyName());//事务所名称
			userMap.put("linkman", clt.getPerson());//联系人
			userMap.put("phone", clt.getPhone());//联系电话
			userMap.put("postalcode", clt.getFaxes());//传    真 
			userMap.put("postcode", clt.getPost());//邮     编
			userMap.put("address", clt.getAddress());//地  址
			userMap.put("email", clt.getEmail());//E-Mial 
			userMap.put("url", clt.getUrl());//网     址
//			userMap.put("area", clt.getArea());//事务所归属地
			user.saveInfo(userMap);
			
			System.out.println(this.getClass()+"   person"+ct.getBbperson()+"   time = "+ct.getBbtime()+"  state="+ct.getBbstate());
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
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
	public ModelAndView updateSfkjjdbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		System.out.println(this.getClass()+"        updateSfkjjdbTableById   >>>>>>>>>>>>>>>> cjt.getWtdwmc() ="+ct.getWtdwmc()+"     typeid ="+typeid );
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(request.getParameter("person"));
			clt.setPhone(request.getParameter("phone"));
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 内容二
			SfkjjdbTable st = new SfkjjdbTable();
			st.setGuid(request.getParameter("stguid"));
			st.setJdjg(request.getParameter("jdjg"));

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate("报备中");
			
			
			ct.setGuid(request.getParameter("ctguid"));
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			SfkjjdbService ss = new SfkjjdbService(conn);
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(st.getGuid() == null || "".equals(st.getGuid())){
				st.setGuid(ct.getGuid());
				ss.addSfkjjdbTable(st);
			}else{
				ss.updateSfkjjdbTable(st);	
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
//			userMap.put("officename", clt.getCompanyName());//事务所名称
			userMap.put("linkman", clt.getPerson());//联系人
			userMap.put("phone", clt.getPhone());//联系电话
			userMap.put("postalcode", clt.getFaxes());//传    真 
			userMap.put("postcode", clt.getPost());//邮     编
			userMap.put("address", clt.getAddress());//地  址
			userMap.put("email", clt.getEmail());//E-Mial 
			userMap.put("url", clt.getUrl());//网     址
//			userMap.put("area", clt.getArea());//事务所归属地
			user.saveInfo(userMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		System.out.println(this.getClass()+"   person"+ct.getBbperson()+"   time = "+ct.getBbtime()+"  state="+ct.getBbstate());
		response.sendRedirect("bb.do?method=index&typeid="+typeid);
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deleteSfkjjdbTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		String typeid = request.getParameter("typeid");
		try {
			conn = new DBConnect().getConnect();
			CompanyListService cls = new CompanyListService(conn);
			ContentService cs = new ContentService(conn);
			SfkjjdbService ss = new SfkjjdbService(conn);
			String GUID = request.getParameter("GUID");
			ContentTable ct = cs.getContentTableById(GUID);
			cls.deleteCompanyListTable(ct.getCompanyGUID());
			cs.deleteContentTable(GUID);
			ss.deleteSfkjjdbTable(GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("sfkjjdb.do?method=index&typeid="+typeid);
		return null;
	}
	
	/**
	 * 编辑跳转
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+  ">>>>>>>>>>>  addAndEdit() ......");
		ModelAndView model = new ModelAndView(ADDANDEDIT);

		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = StringUtil.showNull((String)map.get("loginid"));
		
		String param = StringUtil.showNull(request.getParameter("param"));
		String typeid = StringUtil.showNull(request.getParameter("typeid"));
		String view = StringUtil.showNull(request.getParameter("view"));
		model.addObject("view", view);
		model.addObject("typeid", typeid);
		
		System.out.println(this.getClass()+" |  typeid= "+typeid+"   view = "+view+"param="+param+"  guid="+request.getParameter("GUID"));
		
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ContentTable ct= null;
		CompanyListTable clt= null;
		SfkjjdbTable st = null;
		try {
			if(param.equals("search")){
				conn = new DBConnect().getConnect();
				CompanyListService cls = new CompanyListService(conn);
				ContentService cs = new ContentService(conn);
				SfkjjdbService ss = new SfkjjdbService(conn);
				String p = request.getParameter("p");   //  查看操作还是作废操作判断的依据
				String GUID = request.getParameter("GUID");
				ct = cs.getContentTableById(GUID);
				clt = cls.getCompanyListTable(ct.getCompanyGUID());
				st = ss.getSfkjjdbTable(GUID);
				model = new ModelAndView(SEARCH);
				model.addObject("p", p);
				model.addObject("ct", ct);
				model.addObject("clt", clt);
				model.addObject("st", st);
			}else if(param.equals("update")){
				conn = new DBConnect().getConnect();
				CompanyListService cls = new CompanyListService(conn);
				ContentService cs = new ContentService(conn);
				SfkjjdbService ss = new SfkjjdbService(conn);
				String GUID = request.getParameter("GUID");
				ct = cs.getContentTableById(GUID);
				clt = cls.getCompanyListTable(ct.getCompanyGUID());
				st = ss.getSfkjjdbTable(GUID);
				model.addObject("ct", ct);
				model.addObject("clt", clt);
				model.addObject("st", st);
			}else{
				ct = new ContentTable();
				ct.setWtxmlx("司法会计鉴定");
				//1.首先看companylist里面有没有记录；有记录，就取修改日期最后的记录；
				//2.没有，就取机构信息k_company的信息；
				String sql = " select " +
				"	isnull(b.guid,'') as guid, " +
				"	isnull(b.loginid,a.loginid) as loginid, " +
				"	isnull(b.companyname,officename) as companyname, " +
				"	isnull(b.languageselectname,'') as languageselectname, " +
				"	isnull(b.person,a.linkman) as person, " +
				"	isnull(b.phone,a.phone) as phone, " +
				"	isnull(b.faxes,a.postalcode) as faxes, " +
				"	isnull(b.post,a.postcode) as post, " +
				"	isnull(b.address,a.address) as address, " +
				"	isnull(b.email,a.email) as email, " +
				"	isnull(b.url,a.url) as url, " +
				"	isnull(a.area,b.area) as area " +
				"	from K_Company a left join ( " +
				"		select distinct a.* from bb_companylist as a " + 
				"		left join bb_content1 as b on a.guid = b.companyguid " + 
				"		where loginid=?  " +
				"	) b  " +
				"	on a.loginid = b.loginid " +
				"	where a.loginid=?   " ;

//				String sql = " select a.* from bb_companylist as a left join bb_content1 as b" 
//						   + " on a.guid = b.companyguid where loginid=? order by b.bgrq desc";
				conn = new DBConnect().getConnect();
				ps = conn.prepareStatement(sql);
				ps.setString(1, loginid);
				ps.setString(2, loginid);
				rs = ps.executeQuery();
				clt = new CompanyListTable();
				if(rs.next()){
						clt.setGuid(rs.getString("guid"));
						clt.setLoginid(rs.getString("loginid"));
						clt.setCompanyName(rs.getString("companyname"));
						clt.setLanguageSelectName(rs.getString("languageselectname"));
						clt.setPerson(rs.getString("person"));
						clt.setPhone(rs.getString("phone"));
						clt.setFaxes(rs.getString("faxes"));
						clt.setPost(rs.getString("post"));
						clt.setAddress(rs.getString("address"));
						clt.setEmail(rs.getString("email"));
						clt.setUrl(rs.getString("url"));
						clt.setArea(rs.getString("area"));
				}
//				else{
//					sql = " select loginid,loginname,officename,email,"
//						+ " postcode,address,phone,postalcode from k_company where loginid = ?";
//					ps = conn.prepareStatement(sql);
//					ps.setString(1, loginid);
//					rs = ps.executeQuery();
//					if(rs.next()){
//						clt.setCompanyName(rs.getString("officename"));
//						clt.setLanguageSelectName("");
//						clt.setPerson("");
//						clt.setPhone(rs.getString("phone"));
//						clt.setFaxes("");
//						clt.setPost(rs.getString("postcode"));
//						clt.setAddress(rs.getString("address"));
//						clt.setEmail(rs.getString("email"));
//						clt.setUrl("");
//					}
//				}
				model.addObject("clt", clt);
				model.addObject("ct", ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		return model;
	}
}
