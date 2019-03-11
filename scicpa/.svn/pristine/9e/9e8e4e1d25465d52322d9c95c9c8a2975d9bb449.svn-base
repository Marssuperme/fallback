package cn.org.gdicpa.web.action.course;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.course.CourseService;
import cn.org.gdicpa.web.service.course.model.Course;



public class CourseAction extends MultiActionController {
	private final static String LIST_VIEW = "/course/list.jsp";
	private final static String VIEW = "/course/main.jsp";

	
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response)  throws Exception {
			Connection conn = null; 
			ModelAndView modelAndView = new ModelAndView(VIEW) ;
			try { 
				conn = new DBConnect().getConnect() ;
				String id = StringUtil.showNull(request.getParameter("id")) ;
				CourseService cs = new CourseService(conn) ;
				Course course = cs.getCourse(id) ;
				modelAndView.addObject("course", course) ; 
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DbUtil.close(conn) ;
			}
			return modelAndView;
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)  throws Exception {
//		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW) ;
		try { 
//			conn = new DBConnect().getConnect(); 
			String sql = "select id,title,pubdate,b.loginname,teacher,video,content,outline,description,property from k_course a left join k_user b on a.userId = b.loginId" ;
			
			DataGridProperty pp = new DataGridProperty();
			pp.setTableID("courseList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "title").setTdProperty(" onclick=\"goView('${id}');\"");
			pp.addColumn("发布日期", "pubdate","showCenter");
			pp.addColumn("发布人", "loginName","showCenter");  
			pp.addColumn("主讲人", "teacher","showCenter");
			pp.addColumn("操作", "teacher","showCenter").setColContent("<a href=\"###\" onclick=\"goExam('${id}');\">考试</a>");
			pp.setColumnWidth("50%,20%,10%,10%");
			pp.setSQL(sql);
			pp.setOrderBy_CH("pubdate");
			pp.setDirection("desc");
			pp.setTitle("在线课程列表") ;
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
}
