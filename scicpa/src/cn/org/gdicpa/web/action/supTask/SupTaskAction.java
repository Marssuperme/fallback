package cn.org.gdicpa.web.action.supTask;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.supTask.SupTaskService;

import com.matech.plugin.rtx.RtxService;

public class SupTaskAction extends MultiActionController {

	private static String list = "/supTask/list.jsp";
	private static String view = "/supTask/view.jsp";
	
	//在线填报
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(list);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
 		
		
		String sql = " select s.id,s.title as stitle,t.title as ttitle,s.taskMan,s.PublishType,s.enddate,s.createDate,s.department,s.CustomerName "
			       + " from K_SupTask s "
 				   + " left join k_testernotice t "
				   + " on s.NotcieID = t.id " 
				   + " left join k_reply r "
				   + " on s.id = r.tid " 
				   + " where s.state='已审核' " 
				   + " and r.replyer = '"+loginid+"' ";
		
		DataGridProperty pp = new DataGridProperty();
		pp.setTableID("supTaskList");
		pp.setWhichFieldIsValue(1);
		pp.addColumn("标题", "stitle").setTdProperty(" style=\"text-align:center\" onclick=\"goView('${id}');\" ");
		pp.addColumn("检查通知标题", "ttitle").setTdProperty(" style=\"text-align:center\" onclick=\"goView('${id}');\" ");
//		pp.addColumn("填报人", "taskMan","showCenter");
//		pp.addColumn("发布部门", "department","showCenter");
		pp.addColumn("发布机构", "CustomerName","showCenter");
		pp.addColumn("发布类型", "PublishType","showCenter");
		pp.addColumn("开立时间", "createDate","showCenter");
		pp.addColumn("截止日期", "enddate","showCenter");
			
		pp.setSQL(sql);
		pp.setOrderBy_CH("createDate");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		 
		return model;
		  
	}
	
	/**
	 * 查看单个
	 */
	public ModelAndView viewSupTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(view);
		Connection conn=null;
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+"       >>>>>>> viewTask()............  id= "+id);
		String ttable = "k_supTask";
		String rtable = "k_reply"; 
		try {
			conn  = new DBConnect().getConnect();
			SupTaskService sts = new SupTaskService(conn);
			Map map = sts.getSupTask(id,loginid);
			String random = "";
			if("".equals(map.get("replyerattachment")) || map.get("replyerattachment")==null){
				random = DELUnid.getNumUnid();
				map.put("replyerattachment",random);
			}
			
			map.put("random", random);
			map.put("ttable", ttable);
			map.put("rtable", rtable);
			map.put("nowtime", new ASFuntion().getCurrentDate());
			model.addObject("supTaskMap", map);
			model.addObject("source", source);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	
	/**
	 * 回复
	 */
	public ModelAndView reply(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView model = new ModelAndView(list);
		Connection conn=null;
		String tid = request.getParameter("tid");
		String source = request.getParameter("source");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String nowtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String replyerattachment = request.getParameter("replyerattachment");
		String contents = request.getParameter("contents");
		String loginname = request.getParameter("loginname");	 
		String title = request.getParameter("title");		 
		System.out.println(this.getClass()+"  contents = "+contents+"   loginname="+loginname+"   titlel = "+title);
		
		RtxService rtxService = null;
		
		try {
			conn  = new DBConnect().getConnect();
			SupTaskService sts = new SupTaskService(conn);
			
			// 回复
			sts.reply(tid, nowtime, replyerattachment, contents);
			// 监管作业链接过来的
			if("zxtb".equalsIgnoreCase(source)){
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=zxtb");
			}else{
				response.sendRedirect("supTask.do?method=list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
}
