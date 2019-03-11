package cn.org.gdicpa.web.action.noteInfo;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.service.noteInfo.NoteInfoService;

public class NoteInfoAction extends MultiActionController{
	private static final String LIST = "/noteInfo/noteInfo.jsp";
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		
		Connection conn=null;
		try {
			conn  = new DBConnect().getConnect();
			// 系统报名人员
			String sql = "select * from k_micfo where officecode = '"+loginid+"' " ;
			
			List userList = new NoteInfoService(conn).getLists(sql);
			System.out.println("py:" + sql+"      userList.size()="+userList.size());
			model.addObject("userList",userList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
}
