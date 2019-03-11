package cn.org.gdicpa.web.action.ticket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import cn.org.gdicpa.web.service.ticket.TicketService;
import cn.org.gdicpa.web.service.ticket.model.TicketCountTable;
import cn.org.gdicpa.web.service.ticket.model.TicketTable;

public class TicketAction extends MultiActionController{
	private static final String LIST = "/ticket/list.jsp";
	private static final String VIEW = "/ticket/view.jsp";
	private static final String ADDANDEDIT = "/ticket/addAndEdit.jsp";
	
	
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  index ............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String loginid = (String)userMap.get("loginid");
		Connection conn = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql  = " select tctitle,subString(tccontent,1,10)+'...' as content,tcenddate from k_ticket";
			
			//投票信息
//			sql = "select top 1 * from k_ticket " +
//			"	WHERE (tcenddate >= convert(varchar(10),getdate(),120))  " +
//			"	and ', '+fillarea+',' like '%, " + loginid + ",%' " +
//			"	order by tcenddate,id desc";
			
//				sql = "select top 4 * from k_ticket " +
//				"	WHERE (tcenddate >= convert(varchar(10),getdate(),120))  " +
//				"	and ', '+fillarea+',' like '%, " + loginid + ",%' " +
//				"	order by tcenddate,id desc";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String tctitle = getRequestValue("tctitle") ;
					if(tctitle == null || "".equals(tctitle)) {
						tctitle = "" ;
					}else {
						tctitle = " and tctitle= "+tctitle;
					}
					this.setOrAddRequestValue("tctitle", tctitle);
				}
			};
			pp.setTitle("投票信息");
			
			pp.addSqlWhere("tctitle","${tctitle}") ;
			pp.setTableID("ticketList");
			pp.setWhichFieldIsValue(1);
			
			pp.setOrderBy_CH("tcenddate");
			pp.setDirection_CH("desc");
			pp.addColumn("标题", "tctitle","showCenter");
			pp.addColumn("内容", "content","showCenter");
			pp.addColumn("截止日期", "tcenddate","showCenter");
		
			pp.setSQL(sql);
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	/**
	 * list2
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView list2(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  index ............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String loginid = (String)userMap.get("loginid");
		Connection conn = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql  = " select tctitle,count(tctitle) as ct "
				 + " from k_ticket "
				 + " group by tctitle";
			//投票信息
//			sql = "select top 1 * from k_ticket " +
//			"	WHERE (tcenddate >= convert(varchar(10),getdate(),120))  " +
//			"	and ', '+fillarea+',' like '%, " + loginid + ",%' " +
//			"	order by tcenddate,id desc";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String tctitle = getRequestValue("tctitle") ;
					if(tctitle == null || "".equals(tctitle)) {
						tctitle = "" ;
					}else {
						tctitle = " and tctitle= "+tctitle;
					}
					this.setOrAddRequestValue("tctitle", tctitle);
				}
			};
			pp.addSqlWhere("tctitle","${tctitle}") ;
			pp.setTableID("ticketList");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("标题", "tctitle");
			pp.addColumn("投票数", "ct");
		
			pp.setSQL(sql);
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	


	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  index ............");
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql  = " select tctitle,count(tctitle) as ct "
				 + " from k_ticket "
				 + " group by tctitle";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String tctitle = getRequestValue("tctitle") ;
					if(tctitle == null || "".equals(tctitle)) {
						tctitle = "" ;
					}else {
						tctitle = " and tctitle= "+tctitle;
					}
					this.setOrAddRequestValue("tctitle", tctitle);
				}
			};
			pp.addSqlWhere("tctitle","${tctitle}") ;
			//pp.setInputType("radio");
			pp.setTableID("ticketList");
			pp.setWhichFieldIsValue(1);
			//pp.setPrintColumnWidth("20,20,20");
			
			pp.addColumn("标题", "tctitle");
			pp.addColumn("投票数", "ct");
			//pp.addColumn("访问次数", "viewCount");
		
			pp.setSQL(sql);
			//pp.setOrderBy_CH("id");
			//pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	

	/**
	 * 得到单个投票标题所有信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getAll(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  getAll ............");
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql  = " select tctitle,count(tctitle) as ct "
				 + " from k_ticket "
				 + " group by tctitle";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("tctitle = "+rs.getString(1));
				model.addObject("tctitle", rs.getString(1));
				System.out.println("ct = "+rs.getString(2));
				model.addObject("ct", rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	
	
	/**
	 * 投票的方法
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView tpTicket(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String choose = request.getParameter("choose");
		String tid = request.getParameter("tid");
		String p = request.getParameter("p");
		Connection conn = null;
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			
			
			
			conn = new DBConnect().getConnect();
			TicketService ts = new TicketService(conn);
			
			request.setAttribute("result", ts.tpTicket(tid, choose,loginid));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("ticket.do?method=viewTicketResult&tid="+tid+"&p="+p);
		return null;
	}
	
	
	
	
	/**
	 * 投票完成之后到投票结果界面
	 */
	
	public ModelAndView viewTicketResult(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(VIEW);
		String tid = request.getParameter("tid");
		String p = request.getParameter("p");
		TicketTable tt = null;
		TicketCountTable tct = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TicketService ts = new TicketService(conn);
			
			//取得投票设置内容
			tt = ts.viewTicketResult(tid);
			
			//计算比例
			tct=ts.viewTicketCountResult(tid);
				
			System.out.println(">>>>>>>>>>>>>>> "+tct.getTcchooseonecount()+"   "+tct.getTotal()+"   "+tct.getPercente1());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		model.addObject("p", p);
		model.addObject("tt",tt);
		model.addObject("tct",tct);
		model.addObject("result",request.getAttribute("result"));
		return model;
	}
	
	
	/** 
	 * 获取投票信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getMoreTicket(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		String sql = "";
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map userMap = userSession.getUserMap();
			String loginid = (String)userMap.get("loginid");
			
			conn = new DBConnect().getConnect();
//			sql  = " select max(id) as id,tctitle,count(tctitle) as ct ,max(tcenddate) as tcenddate,max(reduplicate) reduplicate,max(idate) as idate "
//				 + " from k_ticket group by tctitle as ticket order by ticket.idate desc";
			
//			sql = " select * from (select top 10 * from (select max(id) as id,tctitle,count(tctitle) as ct ,max(tcenddate) as tcenddate,"
//				+ "	max(reduplicate) reduplicate,max(idate) as idate "
//				+ " from k_ticket group by tctitle) as ticket order by ticket.idate desc) as a";
			
			sql = "select top 10 id,tctitle,tccontent,tcenddate,anonymous,reduplicate,idate " +
			"	from k_ticket " +
			"	where 1=1 " +
			"	and ', '+fillarea+',' like '%, " + loginid + ",%' " ;
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
//					String tctitle = getRequestValue("tctitle") ;
//					if(tctitle == null || "".equals(tctitle)) {
//						tctitle = "" ;
//					}else {
//						tctitle = " and tctitle= "+tctitle;
//					}
//					this.setOrAddRequestValue("tctitle", tctitle);
				}
			};
//			pp.addSqlWhere("tctitle","${tctitle}") ;
			
			pp.setTableID("ticketList");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("标题", "tctitle").setTdProperty("onclick=goTicket('${id}','${tcenddate}','${anonymous}','${reduplicate}')");
			pp.addColumn("投票截止日期", "tcenddate","showCenter");
			pp.addColumn("是否允许匿名投票", "anonymous","showCenter");
			pp.addColumn("是否允许重复投票", "reduplicate","showCenter");
			
			pp.setOrderBy_CH("tcenddate");
			pp.setDirection("desc");
			pp.setTitle("投票信息") ;
		
			pp.setSQL(sql);
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	
	/**
	 * 得到单个投票标题所有信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goTicket(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  goTicket ............");
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		
		String id = request.getParameter("id");
		
		Connection conn = null;
		TicketTable tt = null;
		try {
			conn = new DBConnect().getConnect();
			TicketService ts = new TicketService(conn);
			tt = ts.getTicket(id);
			model.addObject("tt", tt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	/**
	 * 得到单个投票截止日期
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getTicketEndDate(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  getTicketEndDate ............");
		
		String id = request.getParameter("id");
		String endDate = null;
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			TicketService ts = new TicketService(conn);
			endDate = ts.getTicketEndDate(id);
			
			
			// 比较日期
			DateUtil du = new DateUtil();
			int value = du.equalDate(endDate, new ASFuntion().getCurrentDate());
			System.out.println(this.getClass()+"      endDate = "+endDate+"         new ASFuntion().getCurrentDate()="+new ASFuntion().getCurrentDate()+"      value="+value+"     id="+id);
			if(value>0){
				out.print("N");   
			}else{
				out.print("Y");   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	/**
	 * 得到对应投票是否允许匿名
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getTicketAnonymous(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  getTicketAnonymous ............");
		
		String id = StringUtil.showNull(request.getParameter("id"));
		String anonymous = null;
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			TicketService ts = new TicketService(conn);
			anonymous = StringUtil.showNull(ts.getTicketAnonymous(id));
			
			System.out.println(this.getClass()+"    id="+id+"        anonymous="+anonymous);
			
			if(anonymous.equals("是")){
				out.print("Y");
			}else{
				out.print("N");  // 返回否允许匿名
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 得到对应投票是否允许重复投票
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getTicketReduplicate(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  getTicketReduplicate ............");
		
		String id = StringUtil.showNull(request.getParameter("id"));
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
		String userId = StringUtil.showNull((String)userSession.getUserMap().get("loginid"));
		
		String reduplicate = null;
		int count = 0;
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			TicketService ts = new TicketService(conn);
			reduplicate = StringUtil.showNull(ts.getTicketReduplicate(id));
			count = ts.getTicketCount(id,userId);
			
			System.out.println(this.getClass()+"   reduplicate="+reduplicate+"       count="+count);
			
			if(reduplicate.equals("是")){
				out.print("Y");
			}else{
				if(count>=1){
					out.print("N");  // 返回否允许重复投票
				}else{
					out.print("Y");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
}
