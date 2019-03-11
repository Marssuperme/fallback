package cn.org.gdicpa.web.action.grade;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.grade.GradeService;
import cn.org.gdicpa.web.service.grade.model.Grade;
import cn.org.gdicpa.web.service.question.QuestionService;

public class GradeAction extends MultiActionController {
	private final static String LIST_VIEW = "/grade/list.jsp";
	private final static String USER_GRADE_VIEW = "/grade/userGrade.jsp";

	/**
	 * 用户排名
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW);
		
		Connection conn = null;

		try {		
			
			conn = new DBConnect().getConnect();
			
			QuestionService questionService = new QuestionService(conn);
			List<Map<String, String>> policyTypeList = questionService.getTypeList(QuestionService.TYPE_POLICY);
			List<Map<String, String>> casesTypeList = questionService.getTypeList(QuestionService.TYPE_CASES);
			
			modelAndView.addObject("policyTypeList", policyTypeList);
			modelAndView.addObject("casesTypeList", casesTypeList);
			
			//总排名/月度总排名/分类月度排名/分类排名/
			String ctype = StringUtil.showNull(request.getParameter("ctype"));
			String typeId = StringUtil.showNull(request.getParameter("typeId"));
			
			if(!"".equals(ctype)) {
				ctype = " and b.ctype='" + ctype + "' ";
			}
			
			if(!"".equals(typeId)) {
				typeId = " and b.typeId='" + typeId + "' ";
			}
			
			String sql = " select top 50 a.expert,b.loginname from "
						+ " ( "
						+ " 	select a.userid,count(1)*2 as expert "
						+ " 	from p_answer a,p_question b "
						+ " 	where a.isbest=1 "
						+ " 	and a.questionid=b.id "
						+ ctype
						+ typeId
						+ " 	group by a.userid "
						+ " ) a,k_user b "
						+ " where a.userid = b.loginid  ";
			DataGridProperty pp = new DataGridProperty();

			pp.setTitle("总排名");
			pp.setTableID("gradeList");

			pp.addColumn("用户名", "loginName");
			pp.addColumn("专家分", "expert", "showCenter");
			pp.setCancelOrderby(true);
			pp.setCancelPage(true);
			pp.setSerialCol(true);
			pp.setSerialColName("排名");
			pp.setCancelFoot(true);

			pp.setSQL(sql);
			pp.setOrderBy_CH("expert");
			pp.setDirection("desc");
			request.getSession().setAttribute(
					DataGrid.sessionPre + pp.getTableID(), pp);
			
			String month = new SimpleDateFormat("yyyy-MM").format(new Date());
			
			String sql1 = " select top 50 a.expert,b.loginname from "
						+ " ( "
						+ " 	select a.userid,count(1)*2 as expert "
						+ " 	from p_answer a,p_question b "
						+ " 	where a.isbest=1 "
						+ " 	and a.questionid=b.id "
						+ "		and b.createdate like '" + month + "%' "
						+ ctype
						+ typeId
						+ " 	group by a.userid "
						+ " ) a,k_user b "
						+ " where a.userid = b.loginid  ";
			DataGridProperty pp1 = new DataGridProperty();
		
			pp1.setTitle("月度排名");
			pp1.setTableID("gradeMonthList");
	
			pp1.addColumn("用户名", "loginName");
			pp1.addColumn("专家分", "expert", "showCenter");
			pp1.setCancelOrderby(true);
			pp1.setCancelPage(true);
			pp1.setSerialCol(true);
			pp1.setSerialColName("排名");
			pp1.setCancelFoot(true);
		
			pp1.setSQL(sql1);
			pp1.setOrderBy_CH("expert");
			pp1.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp1.getTableID(), pp1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}

		return modelAndView;
	}
	
	public ModelAndView getGrade(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String type = request.getParameter("type");
		String loginId = request.getParameter("loginId");
		
		if(loginId == null) {
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			
			Map map = userSession.getUserMap();
			loginId = (String) map.get("loginid");
		}
		
		Connection conn = null;
		
		try {
			
			conn = new DBConnect().getConnect();
			
			GradeService gradeService = new GradeService(conn);
			Grade grade = gradeService.getGradeByLoginId(loginId);
		
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
		
			if("expert".equals(type)) {
				out.write(String.valueOf(grade.getExpert()));
			} else if("resource".equals(type)) {
				out.write(String.valueOf(grade.getResource()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
		
	}

	/**
	 * 用户分数信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView userGradeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(USER_GRADE_VIEW);
		UserSession userSession = (UserSession) request.getSession()
				.getAttribute("userSession");
		
		Map map = userSession.getUserMap();
		
		String loginId = (String) map.get("loginid");
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			
			GradeService gradeService = new GradeService(conn);
			
			int total = gradeService.getTop(loginId, GradeService.TOP_TOTAL);
			int expert = gradeService.getTop(loginId, GradeService.TOP_EXPERT);
			int resource = gradeService.getTop(loginId, GradeService.TOP_RESOURCE);
			
			modelAndView.addObject("total", String.valueOf(total));
			modelAndView.addObject("expert", String.valueOf(expert));
			modelAndView.addObject("resource", String.valueOf(resource));
			
			Grade grade = gradeService.getGradeByLoginId(loginId);
			
			modelAndView.addObject("grade", grade);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}

		return modelAndView;
	}
}
