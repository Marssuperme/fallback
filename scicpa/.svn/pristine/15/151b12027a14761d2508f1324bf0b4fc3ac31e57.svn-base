package cn.org.gdicpa.web.action.government;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.company.model.CompanyTable;
import cn.org.gdicpa.web.service.director.model.DirectorTable;
import cn.org.gdicpa.web.service.government.GovernmentService;
import cn.org.gdicpa.web.service.government.model.GovernmentTable;

public class GovernmentAction extends MultiActionController {
	private static final String _GOVERNMENTADDANDEDIT = "/government/addAndEdit.jsp";
	
	
	/**
	 * 根据编号得到实体对象的方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getGovernmentTableById(HttpServletRequest request,HttpServletResponse response){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
 		String loginid = (String)userMap.get("loginid");
		ModelAndView model = new ModelAndView(_GOVERNMENTADDANDEDIT);
		Connection conn = null;
		GovernmentTable governmentTable = null;
		try {
			conn = new DBConnect().getConnect();
			GovernmentService gs = new GovernmentService(conn);
			governmentTable = gs.getGovernmentTableById(loginid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("governmentTable", governmentTable);
		//request.getSession().setAttribute("governmentTable", governmentTable);
		return model;
	}
	
	/**
	 * 用于［密码建议］
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView Help(HttpServletRequest request, HttpServletResponse response) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String ctypetabname = (String)userMap.get("ctypetabname"); // 会员类型对应的表名
		String tableName = ctypetabname.split("\\_")[1].toLowerCase();
		
		return new ModelAndView("/"+tableName+"/PasswordHelp.jsp");
	}
	
	
	
	/**
	 * 根据编号修改实体对象的方法
	 * @param request
	 * @param response
	 * @param governmentTable
	 * @return
	 */
	public ModelAndView updateGovernmentTableById(HttpServletRequest request,HttpServletResponse  response,GovernmentTable governmentTable){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String ctypetabname = (String)userMap.get("ctypetabname"); // 会员类型对应的表名
		String tableName = ctypetabname.split("\\_")[1].toLowerCase();
	
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			GovernmentService gs = new GovernmentService(conn);
			gs.updateGovernmentTableById(governmentTable);
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"修改成功\");window.location=\""+request.getContextPath()+"/"+tableName+"/"+tableName+".do?method=getGovernmentTableById\"</script>");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return this.getGovernmentTableById(request, response);
	}
	

	/**
	 * 验证密码的方法
	 * @param request
	 * @param 
	 * @param directorTable
	 * @return
	 */
	public ModelAndView validate(HttpServletRequest request,HttpServletResponse response){
		String pwdold = request.getParameter("pwdold");
		Connection conn = null;
		try {
			String sql = "select loginid from k_government where pwd = '"+ MD5.getMD5String(pwdold)+"'";
			conn = new DBConnect().getConnect();
			String loginid = new DbUtil(conn).queryForString(sql);
			
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.print(loginid);
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return this.getGovernmentTableById(request,response );
	}
	
	

	/**
	 * 修改密码的方法
	 * @param request
	 * @param 
	 * @param directorTable
	 * @return
	 */
	public ModelAndView updatePwd(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"      updatePwd >>>>>>");
		String loginid = request.getParameter("loginid");
		String pwdnow = request.getParameter("pwdnow");
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = new DBConnect().getConnect();
			String sql = "update k_government set pwd = ? where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, MD5.getMD5String(pwdnow));
			ps.setString(2, loginid);
			ps.execute();
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.print("0");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		
		return this.getGovernmentTableById(request,response );
	}
}
