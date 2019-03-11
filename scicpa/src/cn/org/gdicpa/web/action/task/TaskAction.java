package cn.org.gdicpa.web.action.task;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.matech.plugin.rtx.RtxService;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.task.TaskService;

public class TaskAction extends MultiActionController{
	private static String list = "/task/list.jsp";
	private static String view = "/task/view.jsp";
	
	//在线填报
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(this.getClass()+" >>>>>>>>>>>>> index()..........");
		ModelAndView model = new ModelAndView(list);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
 		
		// 加多 status 字段的查询判断
//		String sql = " select * from(select distinct(t.id),t.enddate,u.loginname,t.title,t.publisher,t.publishtime,t.describe," 
//			   + " case isnull(r.replytime,'') when '' then '未回复'"  
//			   + " when null then '未回复' else "
//			   + " case r.status "
//			   + " when '合格' then '已回复 已通过' "
//			   + " when '不合格' then '已回复 不通过' "
//			   + " else '已回复 等待确认' end "
//			   + " end as replytime "			
//			   + " from k_task t left join k_reply r on t.id = r.tid left join k_user as u on t.publisher=u.loginid "
//			   + " where replace(','+t.fillarea+',',' ','') like '%,"+loginid+",%') a";
		
		// 加多 status 字段的查询判断
		String sql = " select * from(select distinct(t.id),t.fillarea,t.enddate,t.title,t.publisher,t.publishtime,t.describe," 
			   + " case isnull(r.replytime,'') when '' then '未回复'"  
			   + " else "
			   + "  case r.replyer "
			   + "   when '"+loginid+"' then"
			   + "  	case r.status" 
			   + "  		when '合格' then '已回复 已通过' "
			   + "  		when '不合格' then '已回复 不通过' "
			   + "  		else '已回复 等待确认' " 
			   + " 		end  "
			   + "   else '未回复' " 
			   + "  end  "
			   + " end as replytime "			
			   + " from k_task t left join k_reply r on t.id = r.tid  "
			   + " where mode='已审核' and r.replyer='"+loginid+"' ) a";
//			   + " where mode='已审核' and replace(','+t.fillarea+',',' ','') like '%,"+loginid+",%') a";
		
		DataGridProperty pp = new DataGridProperty();
		pp.setTableID("taskList");
		pp.setWhichFieldIsValue(1);
		pp.addColumn("标题", "title").setTdProperty(" style=\"text-align:center\" onclick=\"goView('${id}','${replytime}');\" ");
//		pp.addColumn("发布人", "loginname","showCenter");
		pp.addColumn("发布机构", "fillarea","showCenter");
		pp.addColumn("发布时间", "publishtime","showCenter");
		pp.addColumn("截止日期", "enddate","showCenter");
		pp.addColumn("状态", "replytime","showCenter"); 
			
		pp.setSQL(sql);
		pp.setOrderBy_CH("publishtime");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		 
		return model;
		  
	}
	
	/**
	 * 查看单个
	 */
	public ModelAndView viewTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(view);
		Connection conn=null;
		String id = request.getParameter("id");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+"       >>>>>>> viewTask()............  id= "+id);
		String ttable = "k_task";
		String rtable = "k_reply"; 
		try {
			conn  = new DBConnect().getConnect();
			TaskService ts = new TaskService(conn);
			Map map = ts.getTask(id,loginid);
			String random = "";
			if("".equals(map.get("replyerattachment")) || map.get("replyerattachment")==null){
				random = DELUnid.getNumUnid();
				map.put("replyerattachment",random);
			}
			
			map.put("random", random);
			map.put("ttable", ttable);
			map.put("rtable", rtable);
			map.put("nowtime", new ASFuntion().getCurrentDate());
			model.addObject("taskMap", map);
			
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
		String replyId = request.getParameter("replyId");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String nowtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String attachment = request.getParameter("random");
		String replyerattachment = request.getParameter("replyerattachment");
		String contents = request.getParameter("contents");
		String loginname = request.getParameter("loginname");	// 在线填报任务的发起人
		String title = request.getParameter("title");		// 在线填报任务标题
		System.out.println(this.getClass()+"  contents = "+contents+"   loginname="+loginname+"   titlel = "+title);
		
		RtxService rtxService = null;
		
		try {
			conn  = new DBConnect().getConnect();
			TaskService ts = new TaskService(conn);
			
			// 发 RTX 消息
			//String receivers = "张三,李四";	//接收人，多人用逗号分隔
			//String title = "我是标题";	//消息标题
			//String msg = "我是内容,[广州铭太信息科技有限公司|http://www.matech.cn]";	//消息内容
			
			//小丘说先去掉
//			rtxService = new RtxService();	//实例化
//			int a = rtxService.sendMessage(loginname, title, contents);	//发送消息
//			System.out.println(this.getClass()+"  |||||||||||| 发送消息方法返回值为： a = "+a);
			//小丘说先去掉
			// 发 RTX 消息
			
			
			// 回复
			ts.reply(replyId, nowtime, replyerattachment, contents);
			response.sendRedirect("task.do");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//释放资源
//			rtxService.close();    // 这句话包异常   空指针  java.lang.NullPointerException
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 得到状态
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getStateById(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
 		
		String id = request.getParameter("id");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			String sql = " select "  
					   + " case isnull(r.replytime,'') when '' then '未回复' "  
				   	   + " else "
				   	   + " 	case r.replyer "
				   	   + " 	  when '"+loginid+"' then"
				   	   + " 		case r.status" 
				   	   + " 			when '合格' then '已回复 已通过' "
				   	   + " 			when '不合格' then '已回复 不通过' "
				   	   + " 			else '已回复 等待确认' " 
				   	   + "      end  "
				   	   + " 	  else '未回复' "   
				   	   + "  end  "
				   	   + " end as replytime "			
				   	   + " from k_task t left join k_reply r on r.replyer='"+loginid+"' and t.id = r.tid left join k_user as u on t.publisher=u.loginid "
				   	   + " where mode='已审核' and t.id = '"+id+"'";
			
			String value = new DbUtil(conn).queryForString(sql);
			System.out.println(this.getClass()+"      ###:   value="+value+"         id="+id+"      sql="+sql);
			out.print(value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
}
