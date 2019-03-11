package cn.org.gdicpa.web.action.lineup;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.lineup.LineupService;
import cn.org.gdicpa.web.service.lineup.model.LineupTable;

public class LineupAction extends MultiActionController{
	private final String add = "/lineup/add.jsp";	//执业会员的【自我任职资格预查】
	private final String view = "/lineup/view.jsp";
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView repeat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = null;
		String p = request.getParameter("p"); 
		String source = request.getParameter("source"); 
		if(p.equalsIgnoreCase("add")){
			model = new ModelAndView(add);
			model.addObject("attachment", DELUnid.getNumUnid());    //产生一个唯一编号         JS 上传的时候要用到这个编号
		}else if(p.equalsIgnoreCase("view")){
			model = new ModelAndView(view);
			String id = request.getParameter("id");
			Connection conn = new DBConnect().getConnect();
			LineupService ls = new LineupService(conn);
			LineupTable lte = ls.getLineupTable(id);
			model.addObject("lte", lte);
		}
		model.addObject("source", source);
		return model;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ASFuntion asf = new ASFuntion();
		String attachment = asf.showNull(request.getParameter("attachment"));
		String source = asf.showNull(request.getParameter("source"));
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = asf.showNull((String)map.get("loginid"));
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		
		String testnoticeid = (String)request.getSession().getAttribute("testnoticeid");
	
		String time = asf.getDateAndTime();
		
		//  得到文件名称
		String strSql = "select filename from k_attachfile where indexid = '"+attachment+"' and indexTable = 's_lineup'";
		try {
			conn = new DBConnect().getConnect();
			String lineupname = new DbUtil(conn).queryForString(strSql);   // 得到文件名称
			LineupService ls = new LineupService(conn);
			LineupTable lt = new LineupTable();
			lt.setLineupname(lineupname);
			lt.setLineupperson(loginid);
			lt.setLineuptime(time);
			lt.setAttachment(attachment);
			lt.setMemo("");
			lt.setNoticeid(testnoticeid);
			ls.addLineupTable(lt);	// 添加对应信息到表中
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.close(conn);
		}
		
		// 监管作业链接过来的
		if("jgzy".equalsIgnoreCase(source)){
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=zxtb");
		}else{
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jgdgsb&id="+nid+"&userid="+userid);
		}
		return null;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ASFuntion asf = new ASFuntion();
		String id = asf.showNull(request.getParameter("id"));
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 先删除 k_attachment 表中对应的记录
			LineupService ls = new LineupService(conn);
			LineupTable lt = ls.getLineupTable(id);
			ls.deleteLineupAttachfile(lt.getAttachment());    // 删除 k_attachment 表中对应的记录
			ls.deleteLineupTable(id);						  // 底稿中对应的记录
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jgdgsb&id="+nid+"&userid="+userid);
		return null;
	}
}
