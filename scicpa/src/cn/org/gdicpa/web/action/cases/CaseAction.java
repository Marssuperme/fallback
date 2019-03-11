package cn.org.gdicpa.web.action.cases;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.pub.util.diff_match_patch;
import cn.org.gdicpa.web.pub.util.diff_match_patch.Diff;
import cn.org.gdicpa.web.service.cases.CaseService;
import cn.org.gdicpa.web.service.cases.model.Case;
import cn.org.gdicpa.web.service.cases.model.CaseCheck;
import cn.org.gdicpa.web.service.question.QuestionService;
import cn.org.gdicpa.web.service.question.model.Question;
import cn.org.gdicpa.web.service.toHTML.ToHTML;



public class CaseAction extends MultiActionController {
	private final static String MAIN_VIEW = "/Case/main.jsp";
	private final static String VIEW = "/Case/view.jsp";
	private final static String OAVIEW = "/Case/oaView.jsp";
	private final static String UPDATE_VIEW = "/Case/add.jsp";
	private final static String AUDITLIST_VIEW = "/Case/auditList.jsp";
	
	public ModelAndView getTree(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		response.setContentType("text/html;charset=UTF-8") ;
		try { 
			conn = new DBConnect().getConnect();
			String id = request.getParameter("id") ;
			if(id == null || "".equals(id)) {
				id = "1" ;
			}
			List list = new CaseService(conn).getTypeTree(id) ;
			String treeStr = JSONArray.fromObject(list).toString() ;
			response.getWriter().write(treeStr); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		ModelAndView modelAndView = new ModelAndView(MAIN_VIEW) ;
		try { 
			String sql = "select id,typeId,title,content,author,viewcount,createtime,c.loginName " 
					   +" from  p_cases a left join (" 
					   +" 	select a.updateUserId,a.caseId from p_cases_check a,(" 
					   +" 		select max(updateDate) as updateDate,caseId from p_cases_check where state='1' group by caseId" 
					   +" 	) b where a.updateDate = b.updateDate and a.caseId = b.caseId" 
					   +" ) b on a.id = b.caseId " 
					   +" left join k_user c  on c.loginId = b.updateUserId where 1=1 ${fullPath}" ;
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					Connection conn = null; 
					try {
						conn = new DBConnect().getConnect();
						String fullPath = getRequestValue("fullPath") ;
						if(fullPath == null || "".equals(fullPath)) {
							fullPath = "" ;
						}else {
							CaseService cs = new CaseService(conn) ;
							String typeIds = cs.getCaseTypeIds(fullPath) ;
							if(!"".equals(typeIds)) {
								fullPath = " and typeId in ("+typeIds +")";
							}else {
								fullPath = "" ;
							}
						}
						this.setOrAddRequestValue("fullPath", fullPath);
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						DbUtil.close(conn) ;
					}
				}
			};
			pp.addSqlWhere("fullPath","${fullPath}") ;
			pp.setTableID("caseList");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("标题", "title").setTdProperty(" onclick='view(\"${id}\",\"${typeId}\");'");
			pp.addColumn("发布日期", "createtime");
			//pp.addColumn("作者", "author");
			pp.addColumn("最后维护人", "loginName");
			
			pp.setColumnWidth("50%,15%,15%,15%");
			pp.setSQL(sql);
			pp.setOrderBy_CH("createtime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			
			boolean isCicpa = "k_cicpa".equals(((String)userSession.getUserMap().get("ctypetabname")).toLowerCase())?true:false ;
			modelAndView.addObject("isCicpa", isCicpa) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	public ModelAndView auditList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(AUDITLIST_VIEW) ;
		try { 
			conn = new DBConnect().getConnect();
			String sql = "select * from (select a.id,a.typeId,a.title,a.content,a.author,a.createtime,updateDate,c.loginName from p_cases_check a left join p_cases b on a.caseId = b.id" 
					   + " left join k_user c on a.updateUserId = c.loginId where (a.state = '' or a.state is null)) a" ;
			
			DataGridProperty pp = new DataGridProperty();
			pp.setTableID("auditCaseList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "title").setTdProperty(" onclick='audit(\"${id}\");'");
			pp.addColumn("修改日期", "updateDate");
			pp.addColumn("修改人", "loginName");
			pp.setColumnWidth("350,70,70");
			pp.setSQL(sql);
			pp.setOrderBy_CH("createtime,id");
			pp.setDirection("desc,desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView checkView(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		String view = "" ;
		String oaView = StringUtil.showNull(request.getParameter("oaView"));
		if(!"".equals(oaView)) {
			view = OAVIEW ;
		}else {
			view = VIEW ;
		}
		ModelAndView modelAndView = new ModelAndView(view) ;
		try { 
			conn = new DBConnect().getConnect() ;
			String cId = request.getParameter("id") ;
			CaseService cs = new CaseService(conn) ;
			CaseCheck cc = cs.getCheck(cId) ;
		
			String updateContent = cc.getContent() ; //修改过的案例内容
			String caseId = StringUtil.showNull(cc.getCaseId()) ;
			String content = "";
			if(!"".equals(caseId)) {
				//说明是修改待审核的案例
				Case cases = cs.getCase(caseId) ;
				//对比两段字符串，找出差异
				diff_match_patch dmp = new diff_match_patch();  
				content = dmp.diff_prettyHtml(dmp.diff_main(cases.getContent(), updateContent));
				cc.setContent(content.replaceAll("&lt;p&gt;","").replaceAll("&amp;","&").replaceAll("&lt;","<")
						.replaceAll("&gt;",">").replaceAll("&para;","")) ;
			}
			
			modelAndView.addObject("cases", cc) ;
			modelAndView.addObject("check", "check") ;
			modelAndView.addObject("checkId", cId) ;
			
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
			String id = request.getParameter("id") ;
			String typeid = request.getParameter("typeid") ;
			CaseService cs = new CaseService(conn) ;
			Case cases = cs.getCase(id) ;
			
			//取出相关问题
			QuestionService qs = new QuestionService(conn) ;
			List<Question> list =  qs.getQuestions("cases", typeid) ;
			
			modelAndView.addObject("cases", cases) ;
			modelAndView.addObject("questions", list) ;
			modelAndView.addObject("view", "view") ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public void createCaseHtml(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter out = response.getWriter() ;
		try { 
			ToHTML tohtml = new ToHTML() ;
			String caseId = StringUtil.showNull(request.getParameter("id")) ;
			//重新生成法律法规静态文件
			String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/common/case.do?method=view&id="+caseId;
			String path = request.getSession().getServletContext().getRealPath("/")+"common/caseHtml/" ;
			tohtml.convertToHtml(url,caseId+".html",path) ;
			out.write("suc");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("fail");
		}finally {
		}
	}
	
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(UPDATE_VIEW) ;
		try { 
			conn = new DBConnect().getConnect() ;
			String cId = request.getParameter("id") ;
			CaseService cs = new CaseService(conn) ;
			Case cases = cs.getCase(cId) ;
			modelAndView.addObject("cases", cases) ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	
	public void audit(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		response.setContentType("text/html;charset=UTF-8") ;
		try { 
			conn = new DBConnect().getConnect() ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String id = request.getParameter("id") ;
			String state = request.getParameter("state") ;
			CaseService cs = new CaseService(conn) ;
			String userId = (String)userSession.getUserMap().get("loginid") ; //从session中取
			cs.updateCheck(id,state,userId) ;
			CaseCheck cc = cs.getCheck(id) ;
			if("1".equals(state)) {
				//审核通过，更新原来的案例文件！！
				String  cId =  cs.addOrUpdatePolicy(cc) ;
				
				//重新生成案例静态文件
				ToHTML tohtml = new ToHTML() ;
				String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/common/case.do?method=view&id="+cId;
				String path = request.getSession().getServletContext().getRealPath("/")+"common/caseHtml/" ;
				tohtml.convertToHtml(url,cId+".html",path) ;
			}
			
			PrintWriter out = response.getWriter() ;
			out.write("审核成功!") ;
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
	}
	
	public ModelAndView submitAudit(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try {
			request.setCharacterEncoding("UTF-8");
			conn = new DBConnect().getConnect() ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String id = StringUtil.showNull(request.getParameter("id")) ;
			String content = StringUtil.showNull(request.getParameter("content")).toLowerCase();
			String title = StringUtil.showNull(request.getParameter("title")); 
			String author = StringUtil.showNull(request.getParameter("author")); 
			String typeId = StringUtil.showNull(request.getParameter("typeId")); 
			
			CaseService cs = new CaseService(conn) ;
			String userId = (String)userSession.getUserMap().get("loginid") ; //从session中取
			//保存审核信息
			CaseCheck cc = new CaseCheck();
			cc.setCaseId(id) ;
			cc.setContent(content) ;
			cc.setTypeId(typeId) ;
			cc.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date())) ;
			cc.setUpdateUserId(userId) ;
			cc.setAuthor(author) ;
			cc.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date())) ;
			cc.setTitle(title);
		
			cs.addCheck(cc) ;
			
			response.sendRedirect(request.getContextPath()+"/common/case.do?method=list");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	public ModelAndView addView(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		ModelAndView modelAndView = new ModelAndView("/Case/add.jsp") ;
		String typeId = StringUtil.showNull(request.getParameter("typeId")) ;
		modelAndView.addObject("typeId",typeId) ;
		return modelAndView;
	}
	
	
	public ModelAndView saveQuestion(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try {
			request.setCharacterEncoding("UTF-8");
			conn = new DBConnect().getConnect() ;
			String caseId = request.getParameter("caseId") ;
			String content = request.getParameter("content") ;
			String title = request.getParameter("title") ;
			
			Question question = new Question();
			question.setCtype("case") ;
			question.setTypeId(caseId) ;
			question.setTitle(title) ;
			question.setQuestion(content) ;
			question.setState("0") ;
			question.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) ;
			//全路径
			QuestionService qs = new QuestionService(conn) ;
			String questionId = qs.add(question) ;
			
			//重新生成案例静态文件
			ToHTML tohtml = new ToHTML() ;
			String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/case.do?method=view&id="+caseId;
			String path = request.getSession().getServletContext().getRealPath("/")+"Case/caseHtml/" ;
			tohtml.convertToHtml(url,caseId+".html",path) ;
			
			//重新生成问题静态文件
			String url2 = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/question.do?method=view&id="+questionId;
			String path2 = request.getSession().getServletContext().getRealPath("/")+"question/questionHtml/" ;
			tohtml.convertToHtml(url2,questionId+".html",path2) ;
			
			response.sendRedirect(request.getContextPath()+"/Case/caseHtml/"+caseId+".html");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	  private static LinkedList<Diff> diffList(Diff... diffs) {
	    LinkedList<Diff> myDiffList = new LinkedList<Diff>();
	    for (Diff myDiff : diffs) {
	      myDiffList.add(myDiff);
	    }
	    return myDiffList;
	  }
	
}
