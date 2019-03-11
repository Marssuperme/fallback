package cn.org.gdicpa.web.action.user;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.user.UserService;

public class UserAction extends MultiActionController {

	private final String USER_ADD_VIEW = "/user/add.jsp";
	
	/**
	 * 新增注册用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(USER_ADD_VIEW);
		
		return modelAndView;
	}
	
	public ModelAndView isLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			String loginid = CHF.showNull(request.getParameter("loginid"));
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			String string = user.isLogin(loginid);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println(string);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
	/**
	 * 用于［密码建议］
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView Help(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("/user/PasswordHelp.jsp");
	}
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			String loginid = CHF.showNull(request.getParameter("loginid"));
			String loginname = CHF.showNull(request.getParameter("loginname"));
			String pwd = CHF.showNull(request.getParameter("pwd_one"));
			String state = CHF.showNull(request.getParameter("state"));
			String ctype = CHF.showNull(request.getParameter("ctype"));
			String ctypetabname = CHF.showNull(request.getParameter("ctypetabname"));
			
//			Enumeration enum1 = request.getParameterNames();
//			while (enum1.hasMoreElements()) {
//				String paramName = (String) enum1.nextElement();
//				String paramValue = request.getParameter(paramName);
//				args.put(paramName, paramValue);
//			
//			}
			
			Map map = new HashMap();
			map.put("loginid", loginid);
			map.put("loginname", loginname);
			map.put("pwd", pwd);
			map.put("state", state);
			map.put("ctype", ctype);
			map.put("ctypetabname", ctypetabname);
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			String result = user.insert(ctypetabname, "k_user", map);
			
			if("".equals(result)){
				response.sendRedirect("login.do?method=login&AS_usr=" + loginid + "&AS_psw=" + pwd);
			}else{
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/user.do\"</script>");
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
}
