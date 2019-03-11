package cn.org.gdicpa.web.action.tradePrizeRecord;

import java.io.IOException;
import java.sql.Connection;

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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.tradePrizeRecord.TradePrizeRecordService;
import cn.org.gdicpa.web.service.tradePrizeRecord.model.TradePrizeRecordTable;

public class TradePrizeRecordAction extends MultiActionController{
	private static final String LIST = "/tradePrizeRecord/list.jsp";
	private static final String ADDANDEDIT = "/tradePrizeRecord/addAndEdit.jsp";
	private static final String VIEW = "/tradePrizeRecord/view.jsp";
	
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = " select a.*,persons = case when a.person='' then a.notemastername when a.person=null then a.notemastername else a.person end " 
					   + " from k_tradePrizeRecord a inner join k_supPunish b " 
					   + " on a.loginid = b.loginid " 
					   + " where a.loginid = '"+loginid+"' and (b.opentype='事务所' or b.opentype='公众') " 
					   + " ${notemastername} ${fieldNumber} ${recordDate}";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String notemastername = getRequestValue("notemastername") ;
					String fieldNumber = getRequestValue("fieldNumber") ;
					String recordDate1 = getRequestValue("recordDate1") ;
					String recordDate2 = getRequestValue("recordDate2") ;
					String recordDate = "";
					if(notemastername == null || "".equals(notemastername)) {
						notemastername = "" ;
					}else {
						notemastername = " and ( notemastername like '%"+notemastername+"%' )";
					}
					if(fieldNumber == null || "".equals(fieldNumber)) {
						fieldNumber = "" ;
					}else {
						fieldNumber = " and fieldNumber like '%"+fieldNumber+"%'";
					}
					
					if(recordDate1!=null && !"".equals(recordDate1) && recordDate2!=null && !"".equals(recordDate2)){
						recordDate = "  and ( recordDate between '"+recordDate1+"' and '"+recordDate2+" 24:00:00' ) ";
					}else{
						if(recordDate1!=null && !"".equals(recordDate1)){
							recordDate = "  and substring(recordDate,1,10) = '"+recordDate1+"'";
						}
						if(recordDate2!=null && !"".equals(recordDate2)){
							recordDate = "  and substring(recordDate,1,10) = '"+recordDate2+"'";
						}
					}
					
					System.out.println("recordDate2="+recordDate2+"   recordDate1="+recordDate1+"  recordDate="+recordDate);
					this.setOrAddRequestValue("notemastername", notemastername);
					this.setOrAddRequestValue("fieldNumber", fieldNumber);
					this.setOrAddRequestValue("recordDate", recordDate);
				}
			};
			
			pp.setTitle("行业奖罚经历信息");
			
			pp.addInputValue("recordDate1");
			pp.addInputValue("recordDate2");
			
			pp.addSqlWhere("notemastername","${notemastername}") ;
			pp.addSqlWhere("fieldNumber","${fieldNumber}") ;
			pp.addSqlWhere("recordDate","${recordDate}") ;
			
			// 会员名称   事务所名称  奖惩内容   奖惩事由    处理部门      文号         日期    发布范围
			
			pp.setTableID("tradePrizeRecord");
			pp.addColumn("会员名称", "noteMasterName","showCenter");
			pp.addColumn("事务所名称", "officeName","showCenter");
			pp.addColumn("奖惩内容", "punishContent","showCenter");
			pp.addColumn("奖惩事由", "reason","showCenter");
			pp.addColumn("处理部门", "department","showCenter");
			pp.addColumn("文号", "fieldNumber","showCenter");
			pp.addColumn("日期", "recordDate","showCenter");
			pp.addColumn("发布范围", "publishZone","showCenter");
			pp.addColumn("操作人", "person","showCenter");
			
		
			pp.setPageSize_CH("10");
			pp.setSQL(sql);
			pp.setColumnWidth("80,80,180,180,100,100,100,150,80");
			pp.setOrderBy_CH("recordDate");
			pp.setDirection("asc");
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
	public ModelAndView addTradePrizeRecordTable(HttpServletRequest request,HttpServletResponse response,TradePrizeRecordTable tprt) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+" ..........111>>>>>>>>> addTradePrizeRecordTableById()   loginid = "+loginid);
		tprt.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TradePrizeRecordService tprs = new TradePrizeRecordService(conn);
			tprs.addTradePrizeRecordTable(tprt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		///return this.index(request, response);
		response.sendRedirect("tradePrizeRecord.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updateTradePrizeRecordTableById(HttpServletRequest request,HttpServletResponse response,TradePrizeRecordTable tprt){
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			TradePrizeRecordService tprs = new TradePrizeRecordService(conn);
			tprs.updateTradePrizeRecordTable(tprt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return this.index(request, response);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteTradePrizeRecordTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteTradePrizeRecordTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TradePrizeRecordService tprs = new TradePrizeRecordService(conn);
			String id = request.getParameter("id");
			tprs.deleteTradePrizeRecordTable(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return this.index(request, response);
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
		Connection conn = null; 
		String param = StringUtil.showNull(request.getParameter("param"));
		TradePrizeRecordTable tprt = null;
		try {
			conn = new DBConnect().getConnect();
			TradePrizeRecordService tprs = new TradePrizeRecordService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				tprt = tprs.getTradePrizeRecordTableById(id);
				model.addObject("tprt", tprt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	
	/**
	 * 查看详细
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+  ">>>>>>>>>>>  view() ......");
		ModelAndView model = new ModelAndView(VIEW);
		Connection conn = null; 
		String id = request.getParameter("id");
		TradePrizeRecordTable tprt = null;
		try {
			conn = new DBConnect().getConnect();
			TradePrizeRecordService tprs = new TradePrizeRecordService(conn);
			tprt = tprs.getTradePrizeRecordTableById(id);
			model.addObject("tprt", tprt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
