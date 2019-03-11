package cn.org.gdicpa.web.action.Staff;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.Staff.StaffService;
import cn.org.gdicpa.web.service.Staff.model.StaffTable;
import cn.org.gdicpa.web.service.department.model.departmentTable;
/**
 * 业务处理类
 * @author kq
 *
 */
public class StaffAction extends MultiActionController {
	private static final String STAFFLIST="/staff/staffList.jsp";
	private static final String STAFFODD="/staff/staffOdd.jsp";
	/**
	 * 显示所有员工信息
	 * @param request
	 * @param response  
	 * @return
	 * @throws Exception
	 */
	public ModelAndView staffIndex(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model = new ModelAndView(STAFFLIST);
		departmentTable depaNo = new departmentTable();
		Connection con = null;
		String departmentId = request.getParameter("departmentId");
		try {
			con = new DBConnect().getConnect();
			StaffService  service = new StaffService(con);
			int currentPage = 1;
			int count = service.getCount(departmentId);
			System.out.println(count);
			if (request.getParameter("countPage") != null && request.getParameter("countPage").matches("\\d+")){
				currentPage = Integer.parseInt(request.getParameter("countPage"));
				if (currentPage < 1) {
					currentPage = 1;
				}else if (currentPage > count) {
					currentPage = count;
				}
			}
			List<StaffTable> list = service.getAll(currentPage, departmentId);
			System.out.println(list.size());
			model.addObject("staff", list);
			model.addObject("currentPage", currentPage);
			depaNo = service.getdepartmentNo(departmentId);
			model.addObject("depaId", depaNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con);
		}
		return model;
	}
	/**
	 * 显示详细个人信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView staffOdd(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model = new ModelAndView(STAFFODD);
		departmentTable depaNo = new departmentTable();
		String departmentId = request.getParameter("depaId");
		String staffId = request.getParameter("staffId");
		Connection con = null;
		try {
			con = new DBConnect().getConnect();
			StaffService  service = new StaffService(con);
			StaffTable staffTable = service.getStaffTableOdd(departmentId, staffId);
			model.addObject("staffOdd", staffTable);
			depaNo = service.getdepartmentNo(departmentId);
			model.addObject("depa", depaNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(con);
		}
		return model;
	}

}
