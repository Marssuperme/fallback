package cn.org.gdicpa.web.action.inform;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
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
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.inform.InformService;
import cn.org.gdicpa.web.service.user.UserService;

public class InformAction extends MultiActionController {

	private final String _VIEW = "/inform/list.jsp";
	private final String _LOOK_VIEW = "/inform/view.jsp";
	private final String _ADD_VIEW = "/inform/add.jsp";
	private final String _DEL_VIEW = "/inform/del.jsp";
	
	//检举列表
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_VIEW);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			String sql = "select a.*,b.loginname,c.loginname as auditname from b_inform a,k_user b,k_user c " +
				" 	where 1=1 " +
				"	and a.iuser = b.loginid and a.auser = c.loginid ";
			DataGridProperty pp = new DataGridProperty();
//			pp.setInputType("radio");
			pp.setTableID("informList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "caption").setTdProperty(" onclick=\"goView('${topicid}');\" ");
			pp.addColumn("检举人", "loginname","showCenter");
			pp.addColumn("检举时间", "idate","showCenter");
			pp.addColumn("状态", "status","showCenter");
			pp.addColumn("审核人", "lastname","showCenter");
			pp.addColumn("审核时间", "adate","showCenter");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("idate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);

			String ctypetabname = "";
			if(userSession != null){
				ctypetabname = ((String)userSession.getUserMap().get("ctypetabname")).toLowerCase();
			}
			modelAndView.addObject("ctypetabname", ctypetabname);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
		
	}
	
	//打开删除列表
	public ModelAndView indexdel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DEL_VIEW);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String loginid = CHF.showNull(request.getParameter("loginid"));
			String sql = "select a.*,b.loginname,c.loginname as auditname from b_inform a,k_user b,k_user c " +
			" 	where 1=1 " +
			"	and a.iuser = b.loginid and a.auser = c.loginid ";
			
			DataGridProperty pp = new DataGridProperty();
			pp.setInputType("checkbox");
			pp.setTableID("InformDelList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "caption","showLeft");
			pp.addColumn("检举人", "loginname","showCenter");
			pp.addColumn("检举时间", "idate","showCenter");
			pp.addColumn("状态", "status","showCenter");
			pp.addColumn("审核人", "lastname","showCenter");
			pp.addColumn("审核时间", "adate","showCenter");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("idate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);

			String ctypetabname = ((String)userSession.getUserMap().get("ctypetabname")).toLowerCase();
			modelAndView.addObject("ctypetabname", ctypetabname);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
		
	}
	
	//查看
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_LOOK_VIEW);
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String topicid = CHF.showNull(request.getParameter("topicid"));
			
			conn  = new DBConnect().getConnect();
			
			InformService rService = new InformService(conn);
			UserService user = new UserService(conn);
			
			//rService.updateHits(topicid);//修改查看次数
			/**
			 * 主题表
			 */
			Map topicMap = rService.getTopic("b_inform", topicid);
			modelAndView.addObject("topicMap", topicMap);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		
		return modelAndView;
	}
	
	
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String chooseValue = CHF.showNull(request.getParameter("chooseValue"));
			String loginid = CHF.showNull(request.getParameter("loginid"));
			
			conn  = new DBConnect().getConnect();
			
			InformService rService = new InformService(conn);
			rService.delete(chooseValue);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"删除数据成功\");window.location=\""+request.getContextPath()+ "/common/inform.do?method=indexdel&loginid="+loginid+"\"</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		
		return null;
	}
	
	//新增举报
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_ADD_VIEW);
		ASFuntion CHF=new ASFuntion();
		String dateandtime = CHF.getDateAndTime();//yyyy-MM-dd HH:mm
		modelAndView.addObject("dateandtime", dateandtime);
		modelAndView.addObject("attachmentid", DELUnid.getNumUnid());
		return modelAndView;
	}
	
	/**
	 * 保存举报内容
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveinform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			
			ASFuntion CHF=new ASFuntion();
			String dateandtime = CHF.getDateAndTime();//yyyy-MM-dd HH:mm
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			
			conn  = new DBConnect().getConnect();
			
			InformService rService = new InformService(conn);
			String topicid = cn.org.gdicpa.web.pub.autocode.DELUnid.getNumUnid();
			String loginid = (String)parameters.get("loginid");
			
			parameters.put("posttime", dateandtime);//回贴日期 (自动)
			parameters.put("id", topicid);//回贴日期 (自动)
			
			String result = rService.saveInfo("b_inform", parameters);
			
			if("".equals(result)){
				response.sendRedirect(request.getContextPath()+ "/common/inform.do?method=view&topicid="+topicid+"&random="+DELUnid.getNumUnid() );
			}else{
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/inform.do?method=view&topicid="+topicid+"&random="+DELUnid.getNumUnid()+"\"</script>");
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	/**
	 * 合法事务所
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView isCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			conn  = new DBConnect().getConnect();
			String companyid = (String)request.getParameter("companyid");
//			companyid = new String(companyid.getBytes("ISO8859_1"),"GB2312");  
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			String sql = "select loginid from k_company where loginid = '"+companyid+"' or loginname = '"+companyid+"'";
			String result = new DbUtil(conn).queryForString(sql);
			System.out.println(this.getClass()+"     companyid="+companyid+"      resultl="+result+"    sqll="+sql);
			
			if(result!= null && !"".equals(result)){
				out.print("yes");
			}else{
				out.print("no");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
}
