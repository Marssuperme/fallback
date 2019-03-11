package cn.org.gdicpa.web.action.exam;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.exam.ExamService;
import cn.org.gdicpa.web.service.exam.model.Paper;

public class ExamAction extends MultiActionController {

	private final String _exam = "/exam/paperSheet.jsp";

	/**
	 * 显示考试试题
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView(_exam) ;
		Connection conn = null ;
		try {
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			ExamService es = new ExamService(conn) ;
			String courseId = StringUtil.showNull(request.getParameter("courseId")) ;
			String view = StringUtil.showNull(request.getParameter("view"));
			Paper paper = es.getRandomPaperByCourseId(courseId) ;  //取得试卷信息
			if(paper == null) {
				throw new Exception("找不到相应的试卷信息");
			}
			String userId = (String)userSession.getUserMap().get("loginid"); 
			String examId = es.addFromPaper(userId, paper.getId()) ;    //增加一张试卷信息
			List examList = es.getExamDetails(examId);
			
			modelAndView.addObject("singleList", examList.get(0));
			modelAndView.addObject("multiList", examList.get(1));
			modelAndView.addObject("judgeList", examList.get(2));
			modelAndView.addObject("fillList", examList.get(3));
			modelAndView.addObject("qaList", examList.get(4));
			modelAndView.addObject("paper", paper) ;
			modelAndView.addObject("examId", examId) ;
			modelAndView.addObject("courseId", courseId) ;
			modelAndView.addObject("view", view) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);

		}
		return modelAndView;

	}

	/**
	 * 将考生答案保存起来
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ASFuntion CHF = new ASFuntion();
		try {
			conn = new DBConnect().getConnect();

			Enumeration enum1 = req.getParameterNames();
			String examid = req.getParameter("examId");
			String courseId = req.getParameter("courseId");
			String view = req.getParameter("view");
			String paramName = "";
			String paramValue[] = null;
			ExamService es = new ExamService(conn) ;
			while (enum1.hasMoreElements()) {// 遍历整页试卷，更新对应序号的考生答案
				paramName = (String) enum1.nextElement();
				System.out.println("-----paramName:"+paramName);
				paramValue = req.getParameterValues(paramName);
				String paramValue1 = "";
				for (int i = 0; i < paramValue.length; i++) {
					paramValue1 += paramValue[i] + "~`~`";
					
					
				}
				if (!"".equals(paramValue1)) {
					paramValue1 = paramValue1.substring(0,
							paramValue1.length() - 4);
				}
				System.out.println("-----paramValue1:"+paramValue1);
				es.updateUserAnswer(paramName, paramValue1) ;
			
			}
			es.updateExamState(examid) ;
			res.sendRedirect(req.getContextPath()+"/common/exam.do?method=list&courseId="+courseId+"&view="+view);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);

		}
		return null;
	}
	
	
	/**
	 * 将考生答案保存起来
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ModelAndView isExistPaper(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ExamService es = new ExamService(conn) ;
			String courseId = StringUtil.showNull(request.getParameter("courseId")) ;
			boolean isPaperExist = es.isPaperExist(courseId) ;
			boolean isExamFinish = es.isExamFinish(courseId,(String)userSession.getUserMap().get("loginid")) ;
			boolean paperState = es.getPaperState(courseId);
			
			if(paperState){
				out.write("jy");
			}else if(!isPaperExist) {
				out.write("noPaper") ;
			}else if(isPaperExist && isExamFinish){
				out.write("finish") ;
			}else {
				out.write("suc") ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);

		}
		return null;
	}
	
}

