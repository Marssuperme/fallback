package cn.org.gdicpa.web.action.trainingHoldSelf;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.trainingHoldSelf.TrainingHoldSelfService;
import cn.org.gdicpa.web.service.trainingHoldSelf.model.TrainingHoldSelfTable;

public class TrainingHoldSelfAction extends MultiActionController {
	private static final String LIST = "/trainingHoldSelf/list.jsp";
	private static final String VIEW = "/trainingHoldSelf/view.jsp";
	private static final String ADDANDEDIT = "/trainingHoldSelf/addAndEdit.jsp";
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		String classid = StringUtil.showNull(request.getParameter("id"));
		String act = StringUtil.showNull(request.getParameter("act"));
		
		/**
		 * act
		 *   apply：自办培训班申请
		 *   summary：自办培训班学时上报
		 */
		
		String title = "";
		if("apply".equalsIgnoreCase(act)){
			title = "自办培训班申请";
		}else{
			title = "自办培训班学时上报";	
		}
		
		Connection conn = null;
		try {
			
			if(classid != null && !classid.equals("")){
				conn = new DBConnect().getConnect();
				TrainingHoldSelfService ts = new TrainingHoldSelfService(conn);
				TrainingHoldSelfTable tt = ts.getTrainingHoldSelfTableByClassId(classid);
				model.addObject("tt",tt);
			}else{
				model.addObject("attachmentid",DELUnid.getNumUnid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("act", act);
		model.addObject("title", title);
		
		return model;
	}
	
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = af.showNull((String)map.get("loginid")); 
		String ctypetabname = af.showNull((String)map.get("ctypetabname")); 
		String act = request.getParameter("act");
		/**
		 * act
		 *   apply：自办培训班申请
		 *   summary：自办培训班学时上报
		 */
		
		String title = "";
		if("apply".equalsIgnoreCase(act)){
			title = "自办培训班申请";
		}else{
			title = "自办培训班学时上报";	
		}
		
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql = " select classid,OfficeId,OfficeName,TrainingChargeID,TrainingDate,TrainingDateBeg,TrainingDateEnd,TrainingAddress,TrainingHour, "
				+ " ClassName,TrainingContent,Teachers,TeacherIntroduce,TrainingObject,Annox,Memo, "
				+ " CheckState,attachmentid "
				+ " from b_TrainingHoldSelf where OfficeId = '"+loginid+"'  ${className} ${trainingDateBeg} ${trainingDateEnd} ";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String className = getRequestValue("className") ;
					String trainingDateBeg1 = getRequestValue("trainingDateBeg1") ;
					String trainingDateBeg2 = getRequestValue("trainingDateBeg2") ;
					String trainingDateEnd1 = getRequestValue("trainingDateEnd1") ;
					String trainingDateEnd2 = getRequestValue("trainingDateEnd2") ;
					String trainingDateBeg = "";
					String trainingDateEnd = "";
					if(className == null || "".equals(className)) {
						className = "" ;
					}else {
						className = " and className like '%"+className+"%'";
					}
					
					if(trainingDateBeg1!=null && !"".equals(trainingDateBeg1) && trainingDateBeg2!=null && !"".equals(trainingDateBeg2)){
						trainingDateBeg = "  and ( trainingDateBeg between '"+trainingDateBeg1+"' and '"+trainingDateBeg2+" 24:00:00' ) ";
					}else{
						if(trainingDateBeg1!=null && !"".equals(trainingDateBeg1)){
							trainingDateBeg = "  and substring(trainingDateBeg,1,10) = '"+trainingDateBeg1+"'";
						}
						if(trainingDateBeg2!=null && !"".equals(trainingDateBeg2)){
							trainingDateBeg = "  and substring(trainingDateBeg,1,10) = '"+trainingDateBeg2+"'";
						}
					}
					
					if(trainingDateEnd1!=null && !"".equals(trainingDateEnd1) && trainingDateEnd2!=null && !"".equals(trainingDateEnd2)){
						trainingDateEnd = "  and ( trainingDateEnd between '"+trainingDateEnd1+"' and '"+trainingDateEnd2+" 24:00:00' ) ";
					}else{
						if(trainingDateEnd1!=null && !"".equals(trainingDateEnd1)){
							trainingDateEnd = "  and substring(trainingDateEnd,1,10) = '"+trainingDateEnd1+"'";
						}
						if(trainingDateEnd2!=null && !"".equals(trainingDateEnd2)){
							trainingDateEnd = "  and substring(trainingDateEnd,1,10) = '"+trainingDateEnd2+"'";
						}
					}
					this.setOrAddRequestValue("className", className);
					this.setOrAddRequestValue("trainingDateBeg", trainingDateBeg);
					this.setOrAddRequestValue("trainingDateEnd", trainingDateEnd);
				}
			};
			pp.addSqlWhere("tctitle","${tctitle}") ;
			pp.setInputType("radio");
			
			pp.addInputValue("trainingDateBeg1");
			pp.addInputValue("trainingDateBeg2");
			pp.addInputValue("trainingDateEnd1");
			pp.addInputValue("trainingDateEnd2");
			
			pp.addSqlWhere("className","${className}") ;
			pp.addSqlWhere("trainingDateBeg","${trainingDateBeg}") ;
			pp.addSqlWhere("trainingDateEnd","${trainingDateEnd}") ;
			
			pp.setTableID("trainingHoldSelf");
			pp.setWhichFieldIsValue(1);
			
			pp.setTitle(title);
			
			
			//pp.addColumn("事务所", "OfficeName","showCenter").setTdProperty(" onclick=\"goView('${classid}');\" ");
			pp.addColumn("培训班", "ClassName").setTdProperty(" style=\"text-align:center \" onclick=\"goView('${classid}');\" ");
			pp.addColumn("培训地址", "TrainingAddress","showCenter");
			pp.addColumn("负责人", "TrainingChargeID","showCenter");
		
			pp.addColumn("培训开始日期", "TrainingDateBeg","showCenter");
			pp.addColumn("培训结束日期", "TrainingDateEnd","showCenter");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("TrainingDate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("act", act);
		model.addObject("title", title);
		model.addObject("ctypetabname", ctypetabname.toLowerCase());
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
	public ModelAndView addTrainingHoldSelfTable(HttpServletRequest request,HttpServletResponse response,TrainingHoldSelfTable tt) throws IOException{
		Connection conn = null;  
		ASFuntion af = new ASFuntion();
		String act = "";
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = af.showNull((String)map.get("loginid")); 
			String loginName = af.showNull((String)map.get("loginname"));
			
			act = af.showNull(request.getParameter("act"));
			
			conn = new DBConnect().getConnect();
			TrainingHoldSelfService ts= new TrainingHoldSelfService(conn);
			
			tt.setClassID(UUID.randomUUID().toString());
			tt.setOfficeId(loginid);
			tt.setOfficeName(loginName);
			tt.setCheckState("否");
		    
			ts.addTrainingHoldSelfTable(tt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/trainingHoldSelf.do?method=index&act="+act);
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
	public ModelAndView updateTrainingHoldSelfTable(HttpServletRequest request,HttpServletResponse response,TrainingHoldSelfTable tt) throws IOException{
		Connection conn = null;  
		ASFuntion af = new ASFuntion();
		String act = "";
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = af.showNull((String)map.get("loginid")); 
			String loginName = af.showNull((String)map.get("loginname"));
			
			act = af.showNull(request.getParameter("act"));
			
			conn = new DBConnect().getConnect();
			TrainingHoldSelfService ts= new TrainingHoldSelfService(conn);
			
			tt.setOfficeId(loginid);
			tt.setOfficeName(loginName);
//			tt.setCheckState("否");
		    
			ts.updateTrainingHoldSelfTable(tt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/trainingHoldSelf.do?method=index&act="+act);
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deleteTrainingHoldSelfTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;  
		ASFuntion af = new ASFuntion();
		String act = "";
		try {
			String classid = af.showNull(request.getParameter("id"));
			act = af.showNull(request.getParameter("act"));
			
			conn = new DBConnect().getConnect();
			TrainingHoldSelfService ts= new TrainingHoldSelfService(conn);
		    
			ts.deleteByClassId(classid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/trainingHoldSelf.do?method=index&act="+act);
		return null;
	}
	
	
	 
	/**
	 * 得到事务所审核状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewState(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String id = request.getParameter("id");
		PrintWriter out = null ;
		String state = "";
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql = " select CheckState from b_TrainingHoldSelf where classid = ?";
			state = af.showNull(new DbUtil(conn).queryForString(sql,new String[]{id}).trim());
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> state = "+state+" | id="+id+"    |"+af.showNull(state));
			if("通过".equals(state)){
				out.print("N");
			}else{
				out.print("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 查看 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(VIEW);
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = af.showNull((String)map.get("ctypetabname")); 
		String classid = af.showNull(request.getParameter("id"));
		String act = af.showNull(request.getParameter("act"));
		String title = "";
		if("apply".equalsIgnoreCase(act)){
			title = "自办培训班申请";
		}else{
			title = "自办培训班学时上报";	
		}
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TrainingHoldSelfService ts = new TrainingHoldSelfService(conn);
			TrainingHoldSelfTable tt = ts.getTrainingHoldSelfTableByClassId(classid);
			model.addObject("tt",tt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("title", title);
		model.addObject("act", act);
		return model;
	}
}
