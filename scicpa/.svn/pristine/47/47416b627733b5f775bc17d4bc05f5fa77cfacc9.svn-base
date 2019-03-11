package cn.org.gdicpa.web.action.director;

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
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.director.DirectorService;
import cn.org.gdicpa.web.service.director.model.DirectorTable;
import cn.org.gdicpa.web.service.government.model.GovernmentTable;

public class DirectorAction extends MultiActionController{
	private static final String _DIRECTORADDANDEDIT = "/director/addAndEdit.jsp";
	 
	
	/**
	 * 根据编号得到实体对象的方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getDirectorTableById(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(_DIRECTORADDANDEDIT);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		
		Map userMap = userSession.getUserMap();
		
 		
 		String loginid = (String)userMap.get("loginid");
 		DirectorTable directorTable = null;
 		Connection conn = null;
 		try {
 			conn = new DBConnect().getConnect();
 			DirectorService ds = new DirectorService(conn);
 			directorTable = ds.getDirectorTableById(loginid);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally{
 			DbUtil.close(conn);
 		}
 		model.addObject("directorTable", directorTable);
		
 		request.getSession().setAttribute("directorTable", directorTable);
		
		return model;
	}
	
	
	
	/**
	 * 根据编号修改实体对象的方法
	 * @param request
	 * @param 
	 * @param directorTable
	 * @return
	 */
	public ModelAndView updateDirectorTableById(HttpServletRequest request,HttpServletResponse response,DirectorTable directorTable){
		System.out.println(this.getClass()+"      updateDirectorTableByID >>>>>>"+directorTable.getLoginName()+"   "+directorTable.getCtypetabName());
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String ctypetabname = (String)userMap.get("ctypetabname"); // 会员类型对应的表名
		String tableName = ctypetabname.split("\\_")[1].toLowerCase();
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			DirectorService ds = new DirectorService(conn);
			ds.updateDirectorTableById(directorTable);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"修改成功\");window.location=\""+request.getContextPath()+"/"+tableName+"/"+tableName+".do?method=getDirectorTableById\"</script>");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return this.getDirectorTableById(request,response );
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
	 * 验证密码的方法
	 * @param request
	 * @param 
	 * @param directorTable
	 * @return
	 */
	public ModelAndView validate(HttpServletRequest request,HttpServletResponse response){
		String pwdold = request.getParameter("pwdold");
		System.out.println(this.getClass()+"      validate >>>>>>  pwdold = "+pwdold);
		Connection conn = null;
		try {
			String sql = "select loginid from k_director where pwd = '"+ MD5.getMD5String(pwdold)+"'";
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
		
		return this.getDirectorTableById(request,response );
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
			String sql = "update k_director set pwd = ? where loginid = ?";
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
		
		return this.getDirectorTableById(request,response );
	}
}
