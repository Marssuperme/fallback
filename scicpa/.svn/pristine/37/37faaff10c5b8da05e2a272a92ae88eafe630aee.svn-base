package cn.org.gdicpa.web.action.checkGroupResult;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.checkGroupResult.CheckGroupResultService;
import cn.org.gdicpa.web.service.checkGroupResult.model.CheckGroupResultTable;

public class CheckGroupResultAction extends MultiActionController{
	private static String LIST = "/checkGroupResult/list.jsp";
	private static final String ADDANDEDIT = "/checkGroupResult/addAndEdit.jsp";
	
	
	/**
	 * 默认方法
	 * @param request  
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		
		try {
			String sql = " select checkid,checkofficeid,checkoffice,years,evaluation,prize,punish,result from" 
					   + " b_checkGroupResult";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("事务所执业质量结果评价信息");
			 
			pp.setInputType("radio");
			pp.setTableID("checkGroupResult");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("被检查事务所名称", "checkoffice","showCenter");

			pp.addColumn("检查年度", "years","showCenter");
			pp.addColumn("评价", "evaluation","showCenter");
			pp.addColumn("奖励内容", "prize","showCenter");
			pp.addColumn("惩戒内容", "punish","showCenter");
			pp.addColumn("审批意见", "result","showCenter");
			
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("years");
			pp.setDirection("desc");
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
	public ModelAndView addCheckGroupResultTable(HttpServletRequest request,HttpServletResponse response,CheckGroupResultTable cgrt) throws IOException{
		Connection conn = null;
		String checkoffice = request.getParameter("checkoffice");
		cgrt.setCheckoffice(checkoffice);
		try {
			conn = new DBConnect().getConnect();
			CheckGroupResultService cgrs = new CheckGroupResultService(conn);
			cgrs.addCheckGroupResultTable(cgrt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("checkGroupResult.do");
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
	public ModelAndView updateCheckGroupResultTable(HttpServletRequest request,HttpServletResponse response,CheckGroupResultTable cgrt) throws IOException{
		Connection conn = null;
		String checkoffice = request.getParameter("checkoffice");
		try {
			conn = new DBConnect().getConnect();
			if(checkoffice==null || "".equals(checkoffice)){
				checkoffice = new DbUtil(conn).queryForString("select loginName from k_company where loginid = "+cgrt.getCheckofficeid());
			}
			cgrt.setCheckoffice(checkoffice);
			CheckGroupResultService cgrs = new CheckGroupResultService(conn);
			cgrs.updateCheckGroupResultTable(cgrt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("checkGroupResult.do");
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deleteCheckGroupResultTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteCheckGroupResultTable()...");
		String checkid = request.getParameter("checkid");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			CheckGroupResultService cgrs = new CheckGroupResultService(conn);
			cgrs.deleteCheckGroupResultTable(checkid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("checkGroupResult.do");
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
		Connection conn = null; 
		String param = StringUtil.showNull(request.getParameter("param"));
		CheckGroupResultTable cgrt = null;
		try {
			conn = new DBConnect().getConnect();
			CheckGroupResultService cgrs = new CheckGroupResultService (conn);
			if(param.equals("update")){
				String checkid = request.getParameter("checkid");
				cgrt = cgrs.getCheckGroupResultTable(checkid);
				model.addObject("cgrt", cgrt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
}
