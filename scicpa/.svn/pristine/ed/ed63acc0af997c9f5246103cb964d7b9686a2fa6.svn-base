package cn.org.gdicpa.web.action.question;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.grade.GradeService;
import cn.org.gdicpa.web.service.grade.model.Grade;
import cn.org.gdicpa.web.service.policy.PolicyService;
import cn.org.gdicpa.web.service.policy.model.Policy;
import cn.org.gdicpa.web.service.question.QuestionService;
import cn.org.gdicpa.web.service.question.model.Answer;
import cn.org.gdicpa.web.service.question.model.Question;
import cn.org.gdicpa.web.service.toHTML.ToHTML;

public class QuestionAction extends MultiActionController {
	private final static String MAIN_VIEW = "/Question/main.jsp";
	private final static String VIEW = "/Question/view.jsp";
	private final static String UPDATE_VIEW = "/Policy/update.jsp";
	
	public ModelAndView getTree(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		response.setContentType("text/html;charset=UTF-8") ;
		try { 
			conn = new DBConnect().getConnect();
			
			String id = request.getParameter("id") ;
			String type = request.getParameter("value") ;
			String mine = StringUtil.showNull(request.getParameter("mine")) ;
			
			if(id == null || "".equals(id)) {
				id = "0" ;
			}
			if(type == null ) {
				type = "" ;
			}
			if(!"".equals(mine)) {
				UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
				mine = ""+userSession.getUserMap().get("loginid") ;
			}
			
			List list = new QuestionService(conn).getTree(id,type,mine) ;
			String treeStr = JSONArray.fromObject(list).toString() ;
			response.getWriter().write(treeStr); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	//,lastAnswerUser=(select top 1 b.userId from p_answer b where b.questionId=a.id order by answerDate desc )
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(MAIN_VIEW) ;
		try { 
			conn = new DBConnect().getConnect();
//			String sql = "select id,title,question,b.loginname,createDate,a.state,fullPath,rewardMark from p_question a left join k_user b " 
//				+"on a.userId = b.loginId where 1=1 ${typeIds} ${mine} ${ctype} ${searchQuestion}";
			String sql = "select * from (select a.id,a.title,a.question,b.loginname,a.createDate,a.state,a.fullPath," +
					"a.rewardMark,c.loginName lastAnswerUser from p_question a left join k_user b " +
					"on a.userId = b.loginId left join (select a.questionId,a.answerDate,b.loginName " +
					"from (select * from p_answer where answerDate in (select max(answerDate) " +
					"answerDate from p_answer group by questionId)) a left join k_user b on " +
					"a.userId=b.loginId) c on a.id=c.questionId " +
					"where  1=1 ${typeIds} ${mine} ${ctype} ${searchQuestion} ) b";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
						Connection conn = null ;
					try { 
						conn = new DBConnect().getConnect();
						UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
						String ctype = getRequestValue("ctype") ;
						String fullPath = getRequestValue("fullPath") ;
						QuestionService qs = new QuestionService(conn) ;
						String typeIds = "";
						if("policy".equals(ctype)) {
							typeIds = qs.getPolicyTypeIds(fullPath) ;
						}else if("case".equals(ctype)) {
							typeIds = qs.getCaseTypeIds(fullPath) ;
						}else if("course".equals(ctype)) {
							typeIds = "" ;
						}else {
							typeIds = "" ;
						}
						
						if(typeIds == null || "".equals(typeIds)) {
							typeIds = "" ;
						}else {
							typeIds = " and typeId in ("+typeIds+")";
						}
						
						if(ctype == null || "".equals(ctype)) {
							ctype = "" ;
						}else {
							ctype = " and a.ctype = '"+ctype+"'";
						}
						this.setOrAddRequestValue("typeIds", typeIds);
						this.setOrAddRequestValue("ctype", ctype);
						
						String mine = getRequestValue("mine") ; //是否只显示我的问题
						if(mine == null || "".equals(mine)) {
							mine = "" ;
						}else {
							mine = " and userId = '"+userSession.getUserMap().get("loginid")+"'";
						} 
						this.setOrAddRequestValue("mine", mine);
						
						String searchQuestion = getRequestValue("searchQuestion") ;
						if(searchQuestion == null || "".equals(searchQuestion)) {
							searchQuestion = "" ;
						}else {
							searchQuestion = " and title like '%"+searchQuestion+"%'";
						} 
						this.setOrAddRequestValue("searchQuestion", searchQuestion);
					
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						DbUtil.close(conn) ;
					}
				}
			};
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String mine = StringUtil.showNull(request.getParameter("mine")) ;
			
			if(!"".equals(mine)) {
				sql += " and userId = '"+userSession.getUserMap().get("loginid")+"'" ;
			}
			
			pp.addSqlWhere("typeIds","${typeIds}") ;
			pp.addSqlWhere("mine","${mine}") ;
			pp.addSqlWhere("ctype","${ctype}") ;
			pp.addSqlWhere("fullPath","${fullPath}") ;
			pp.addSqlWhere("searchQuestion","${searchQuestion}") ;
			pp.setTableID("questionList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "title").setTdProperty(" onclick='view(\"${id}\");'");
			pp.addColumn("状态", "state");
			pp.addColumn("最后更新日期", "createDate");
			pp.addColumn("提问人", "loginname");
			pp.addColumn("悬赏分", "rewardMark");
			pp.addColumn("最后回答人", "lastAnswerUser");
			
			pp.setColumnWidth("40%,10%,20%,10%,10%,10%");
		
			pp.setSQL(sql);
			pp.setOrderBy_CH("createDate");
			pp.setPageSize_CH(10);
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
			modelAndView.addObject("mine", mine) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(VIEW) ;
		try { 
			conn = new DBConnect().getConnect() ;
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String loginId = (String)userSession.getUserMap().get("loginid");
			
			String id = request.getParameter("id") ;
			QuestionService qs = new QuestionService(conn) ;
			Question question = qs.getQuestion(id) ;
			List<Answer> list = qs.getAnswers(id) ;
			Answer bestAnswer = qs.getBestAnswer(id) ;
			boolean isAnswer = qs.isAnswer(id, loginId);
			
			modelAndView.addObject("question", question) ;
			modelAndView.addObject("answers", list) ;
			modelAndView.addObject("bestAnswer", bestAnswer) ;
			modelAndView.addObject("isAnswer", isAnswer) ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView addView(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		ModelAndView modelAndView = new ModelAndView("/Question/add.jsp") ;
		String ctype = 	StringUtil.showNull(request.getParameter("ctype")) ;
		String typeId = StringUtil.showNull(request.getParameter("typeId")) ;
		
		Connection conn = null; 
		
		try {	
			conn = new DBConnect().getConnect() ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String loginId = userSession.getUserMap().get("loginid")+"";
			GradeService gradeService = new GradeService(conn);
			Grade grade = gradeService.getGradeByLoginId(loginId);
			
			modelAndView.addObject("grade", grade) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn) ;
		}
		
		modelAndView.addObject("ctype", ctype) ;
		modelAndView.addObject("typeId", typeId) ;
		return modelAndView;
	}
	
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try {
			request.setCharacterEncoding("UTF-8");
			conn = new DBConnect().getConnect() ;
			String questionContent = StringUtil.showNull(request.getParameter("question")).replaceAll("<p>","<br>") ;
			String title = StringUtil.showNull(request.getParameter("title"));
			String rewardMark = StringUtil.showNull(request.getParameter("rewardMark")) ;
			String ctype = StringUtil.showNull(request.getParameter("ctype")) ;
			String typeId = StringUtil.showNull(request.getParameter("typeId")) ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			
			String loginId = userSession.getUserMap().get("loginid")+"";
			
			Question question = new Question();
			question.setCtype(ctype) ;
			question.setUserId(loginId);
			question.setTypeId(typeId) ;
			question.setTitle(title) ;
			question.setQuestion(questionContent) ;
			question.setState("未解决") ;
			question.setRewardMark(rewardMark) ;
			question.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())) ;
			
			//扣掉资源分
			QuestionService qs = new QuestionService(conn) ;
			String questionId = qs.add(question) ;
			
			int intRewardMark = Integer.parseInt(rewardMark);
			GradeService gradeService = new GradeService(conn);
			Grade grade = gradeService.getGradeByLoginId(loginId);
			int resource = grade.getResource() - intRewardMark;
			grade.setResource(resource);
			gradeService.update(grade);
			
			ToHTML tohtml = new ToHTML() ;
			if("cases".equals(ctype)) {
				//重新生成案例静态文件
				String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/common/case.do?method=view&id="+typeId;
				String path = request.getSession().getServletContext().getRealPath("/")+"common/caseHtml/" ;
				tohtml.convertToHtml(url,typeId+".html",path) ;
			}else if("policy".equals(ctype)) {
				//重新生成法规静态文件
				String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/common/policy.do?method=view&id="+typeId;
				String path = request.getSession().getServletContext().getRealPath("/")+"common/policyHtml/" ;
				tohtml.convertToHtml(url,typeId+".html",path) ;
			}
			
			response.sendRedirect(request.getContextPath()+"/common/question.do?method=view&id="+questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(UPDATE_VIEW) ;
		try { 
			conn = new DBConnect().getConnect() ;
			String pId = request.getParameter("id") ;
			PolicyService ps = new PolicyService(conn) ;
			Policy policy = ps.getPolicy(pId) ;
			modelAndView.addObject("policy", policy) ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	
	public ModelAndView addAnswer(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect() ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String answerContent = StringUtil.showNull(request.getParameter("answer"));
			String questionId = request.getParameter("questionId") ;
			Answer answer = new Answer() ;
			answer.setAnswer(answerContent.replaceAll("\r\n", "</br>")) ;
			answer.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())) ;
			answer.setQuestionId(questionId) ;
			
			String loginId = (String)userSession.getUserMap().get("loginid");
			answer.setUserId(loginId) ;
			
			QuestionService qs = new QuestionService(conn) ;
			qs.add(answer) ;
			
			GradeService gradeService = new GradeService(conn);
			
			//要进行回答用户的资源分加分
			Grade grade = gradeService.getGradeByLoginId(loginId);
			int resource = grade.getResource() + 2;
			grade.setResource(resource);
			gradeService.update(grade);
			
			response.sendRedirect(request.getContextPath()+"/common/question.do?method=view&id="+questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	/**
	 * 修改回答
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateAnswer(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect() ;
			String updateAnswerId = request.getParameter("updateAnswerId") ;
			String updateAnswer = request.getParameter("updateAnswer") ;
			
			
			QuestionService qs = new QuestionService(conn) ;
			Answer answer = qs.getAnswer(updateAnswerId);
			answer.setAnswer(updateAnswer);
			answer.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			qs.updateAnswer(answer);
		
			String questionId = answer.getQuestionId();
			
			response.sendRedirect(request.getContextPath()+"/common/question.do?method=view&id="+questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	/**
	 * 修改回答
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveExplan(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect() ;
			String questionId = request.getParameter("questionId") ;
			String explan = request.getParameter("explan");		
			
			QuestionService qs = new QuestionService(conn) ;
			
			Question question = qs.getQuestion(questionId);
			question.setExplan(explan);
			question.setExplanDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			qs.updateQuestion(question);
			
			response.sendRedirect(request.getContextPath()+"/common/question.do?method=view&id="+questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	/**
	 * 没有答案
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView noAnswer(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 

		String questionId = request.getParameter("questionId") ;
		
		try { 
			conn = new DBConnect().getConnect() ;
			
			QuestionService questionService = new QuestionService(conn) ;
			
			//将问题状态修改成已解决
			Question question = questionService.getQuestion(questionId);
			question.setState("没有答案");
			questionService.updateQuestion(question);
			
			response.sendRedirect(request.getContextPath() + "/common/question.do?method=view&id=" + questionId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn) ;
		}
		
		return null;
	}
	
	/**
	 * 最佳答案
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView bestAnswer(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		
		try { 
			conn = new DBConnect().getConnect() ;
			
			String answerId = request.getParameter("answerId") ;
			String questionId = request.getParameter("questionId") ;
			
			QuestionService questionService = new QuestionService(conn) ;
			
			//更新为最佳答案
			Answer answer = questionService.getAnswer(answerId);
			answer.setIsBest("1");
			questionService.updateAnswer(answer);
			
			//将问题状态修改成已解决
			Question question = questionService.getQuestion(questionId);
			question.setState("已解决");
			questionService.updateQuestion(question);
	
			String answerUserId = answer.getUserId();
			
			GradeService gradeService = new GradeService(conn);
			
			//取得回答用户的积分，要进行加分
			Grade grade = gradeService.getGradeByLoginId(answerUserId);
			
			//本次问题的悬赏分
			int rewardMark = Integer.parseInt(question.getRewardMark());
			
			//专家分+2,资源分+ 悬赏分
			int expert = grade.getExpert() + 2;
			int resource = grade.getResource() + rewardMark;
			grade.setExpert(expert);
			grade.setResource(resource);
			gradeService.update(grade);
		
			response.sendRedirect(request.getContextPath() + "/common/question.do?method=view&id=" + questionId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn) ;
		}
		
		return null;
	}
	
	
	/**
	 * 得到问题类型
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getQuestionType(HttpServletRequest request,HttpServletResponse response){
		ASFuntion af = new ASFuntion();
		String ctype = af.showNull(request.getParameter("ctype"));
		response.setContentType("text/html;charset=UTF-8") ;
		Connection conn = null;
		PrintWriter out = null;
		try{
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			String sql = " select ctype from p_questionType where parentid = '0' ";
			if("CH".equalsIgnoreCase(ctype)){
				sql = " select typename as ctype from p_questionType where parentid = '0' ";
			}
			QuestionService qs = new QuestionService(conn);
			List list = qs.getListBySql(sql);
			String ctypeValue = JSONArray.fromObject(list).toString();
			out.print(ctypeValue);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
}
