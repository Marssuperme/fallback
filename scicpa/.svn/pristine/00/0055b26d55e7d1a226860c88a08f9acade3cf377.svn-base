package cn.org.gdicpa.web.pub.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.org.gdicpa.web.pub.listener.UserSession;

public class RequestFilter implements Filter {

	private String LOG_IN_URL;
	private static ArrayList AccessAnyWayUrl; // 任何时候都可以访问的URL

	public void init(FilterConfig config) throws ServletException {
		// 初始化
		LOG_IN_URL = config.getServletContext().getContextPath()+"/common/login.do" ;
		//LOG_IN_URL = "/GZZX/common/login.do" ;
		AccessAnyWayUrl = new ArrayList();

		AccessAnyWayUrl.add("/common/"); // 公共 URL
		AccessAnyWayUrl.add("/company/"); // 事务所用户
		AccessAnyWayUrl.add("/micfo/"); // 执业会员会员
		AccessAnyWayUrl.add("/micfono/"); // 非执业会员

		System.out.println("过滤器启动了...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		removeResponseHeaders(hresponse);
		String uri = hrequest.getServletPath();
		System.out.println("过滤器uri:" + uri); 
		request.setCharacterEncoding("UTF-8");

		UserSession userSession = (UserSession) hrequest.getSession()
				.getAttribute("userSession");

		/**
		 * 任何用户（不登陆也可以），都可以访问下列开头的url URL通过INIT函数定义
		 */
		if (!AccessAnyWayUrl.isEmpty()) {
			for (int i = 0; i < AccessAnyWayUrl.size(); i++) {
				if (uri.startsWith(AccessAnyWayUrl.get(i).toString())) {
					chain.doFilter(request, response);
					return;
				}
			}
		}

		/**
		 * 检查已经登陆用户的权限
		 */
		if (userSession != null) {
			Map map = userSession.getUserMap();
			System.out.println("doFilter=" + map);
			String tableName = (String) map.get("ctypetabname"); 
 
			if (uri.startsWith("/" + tableName.split("\\_")[1].toLowerCase()
					+ "/")) {
				chain.doFilter(request, response);
				return;
			} else if (uri.startsWith("/"
					+ tableName.split("\\_")[1].toLowerCase() + ".do")) {
				chain.doFilter(request, response);
				return;
			} else if (uri.startsWith("/common/")) {
				chain.doFilter(request, response);
				return;
			} else {
				hresponse.sendRedirect(LOG_IN_URL);
				return;
			}
		} else {
			hresponse.sendRedirect(LOG_IN_URL);
			return;
		}
	}
	
	/**
	 * 用于删除敏感的相应头部信息
	 */
	private void removeResponseHeaders(HttpServletResponse response) {
		response.setHeader("Server", "");
	}

	public void destroy() {
		System.out.println("过滤器注销了");
	}
}
