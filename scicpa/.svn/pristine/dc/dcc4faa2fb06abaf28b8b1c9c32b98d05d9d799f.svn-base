package cn.org.gdicpa.web.action.partyNo;

import java.io.IOException;
import java.sql.Connection;
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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.partyNo.PartyNoService;
import cn.org.gdicpa.web.service.partyNo.model.PartyNoTable;

public class PartyNoAction extends MultiActionController{
	private static final String LIST = "/partyNo/list.jsp";
	private static final String ADDANDEDIT = "/partyNo/addAndEdit.jsp";
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LIST);
		String optRs = request.getParameter("optRs");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			Connection conn = new DBConnect().getConnect();
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			DbUtil.close(conn);
			String sql = " select id,customerName,officeCode,area,loginName, "
				+ " sex,bornDate,iscpa,diploma,politics, "
				+ " relation,rank,rankNum,department,departRank, "
				+ " phone,mobile,joinParty,partyRank,remark "
				+ " from k_partyno where officecode = '"+loginid+"' ${loginName} ${joinParty} ${iscpa} ";
			
			//为兼容改制所而修改的（时间：2013年5月20日16:53:29）
			if(oldLoginId!=null){
				sql = " select id,customerName,officeCode,area,loginName, "
					+ " sex,bornDate,iscpa,diploma,politics, "
					+ " relation,rank,rankNum,department,departRank, "
					+ " phone,mobile,joinParty,partyRank,remark "
//					+ " from k_partyno where officecode = '"+loginid+"' ${loginName} ${joinParty} ${iscpa} ";
					+ " from k_partyno where officecode in ('"+loginid+"','"+oldLoginId+"') ${loginName} ${joinParty} ${iscpa} ";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.addSqlWhere("loginName"," and loginName like '%${loginName}%' ") ;
			pp.addSqlWhere("joinParty"," and joinParty like '%${joinParty}%' ") ;
			pp.addSqlWhere("iscpa"," and iscpa like '%${iscpa}%' ") ;
			
			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			
			pp.setTitle("统战信息");
			
			pp.setTableID("partyNo");

			pp.addColumn("姓名", "loginName","showCenter").setTdProperty(" style=\" text-align:center; \" onclick=\"goView('${id}');\" ");
			pp.addColumn("性别", "sex","showCenter");
			pp.addColumn("党派情况", "joinparty","showCenter");
			pp.addColumn("是否CPA", "iscpa","showCenter");
			pp.addColumn("手机", "mobile","showCenter");
			
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("bornDate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		model.addObject("optRs",optRs);
		return model;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param pt
	 * @return
	 * @throws IOException 
	 * @throws IOException
	 */
	public ModelAndView addPartyNoTable(HttpServletRequest request,HttpServletResponse response,PartyNoTable pt) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String loginname = (String)userSession.getUserMap().get("loginname");
		String area = (String)userSession.getUserMap().get("area");
		
		pt.setOfficeCode(loginid);
		pt.setCustomerName(loginname);
		// 保存返回结果
		String optRs = "succ";
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PartyNoService ps = new PartyNoService(conn);
			pt.setId(UUID.randomUUID().toString());
			pt.setArea(area);
			
			// 添加
			boolean bl = ps.addPartyNo(pt);
			if(!bl){
				optRs = "fail";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("partyNo.do?method=index&optRs="+optRs);
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param pt
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updatePartyNoTable(HttpServletRequest request,HttpServletResponse response,PartyNoTable pt) throws IOException{
		// 保存返回结果
		String optRs = "succ";
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			PartyNoService ps = new PartyNoService(conn);
			
			// 修改
			boolean bl = ps.updatePartyNo(pt);
			
			if(!bl){
				optRs = "fail";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("partyNo.do?method=index&optRs="+optRs);
		return null;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deletePartyNoTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PartyNoService ps = new PartyNoService(conn);
			String id = request.getParameter("id");
			
			// 删除
			ps.delPartyNo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("partyNo.do?method=index");
		
		return null;
	}
	
	
	
	/**
	 * 编辑/查看
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String loginname = (String)userSession.getUserMap().get("loginname");
	
		Connection conn = null; 
		String p = StringUtil.showNull(request.getParameter("p"));
		PartyNoTable pt = null;
		try {
			if("update".equalsIgnoreCase(p) || "search".equalsIgnoreCase(p)){
				conn = new DBConnect().getConnect();
				PartyNoService ps = new PartyNoService(conn);
				String id = request.getParameter("id");
				pt = ps.getPartyNo(id);
			}else{
				pt = new PartyNoTable();
				pt.setOfficeCode(loginid);
				pt.setCustomerName(loginname);
			}
			model.addObject("pt", pt);
			model.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
}
