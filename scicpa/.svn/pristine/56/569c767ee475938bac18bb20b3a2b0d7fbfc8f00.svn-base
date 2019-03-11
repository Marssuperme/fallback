package cn.org.gdicpa.web.action.template;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.attachFileUploadService.AttachFileUploadService;
import cn.org.gdicpa.web.service.grade.GradeService;
import cn.org.gdicpa.web.service.grade.model.Grade;
import cn.org.gdicpa.web.service.template.TemplateService;
import cn.org.gdicpa.web.service.template.model.Template;
import cn.org.gdicpa.web.service.template.model.TemplateAsk;
import cn.org.gdicpa.web.service.toHTML.ToHTML;

public class TemplateAction extends MultiActionController {
	
	private static final String LIST_VIEW = "/template/main.jsp" ;
	private static final String ADD_VIEW = "/template/add.jsp" ;
	private static final String VIEW = "/template/view.jsp" ;
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW) ;
		try { 
			conn = new DBConnect().getConnect();
			String sql = "select id,title,description,b.loginName,publishDate,mark,property from p_template a left join k_user b on a.userId = b.loginId where a.property = 1" ;
			
			DataGridProperty pp = new DataGridProperty();
			pp.setTableID("templateList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "title","showCenter").setTdProperty(" onclick='goView(${id});'");
			pp.addColumn("发布日期", "publishDate");
			pp.addColumn("发布人", "loginName");
			pp.setColumnWidth("350,70,70");
			pp.setSQL(sql);
			pp.setOrderBy_CH("publishDate");
			pp.setDirection("desc");
			pp.setTitle("模板列表") ;
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView addView(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW) ;
		try { 
			//生成模板表主键
			String id = DELUnid.getNumUnid() ;
			modelAndView.addObject("id", id) ;
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
			//生成模板表主键
			conn = new DBConnect().getConnect();
			String id = StringUtil.showNull(request.getParameter("id")) ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String userId = StringUtil.showNull((String)userSession.getUserMap().get("loginid")) ;
			TemplateService ts = new TemplateService(conn) ;
			AttachFileUploadService afs = new AttachFileUploadService(conn) ;
			boolean isExist = afs.isDownInfoExist(userId,"template", id) ;
			String desc = "";
			if(isExist) {
				desc = "(温馨提示：您已经下载过这个模板，重复下载不会扣除您的资源分）";
			}
			Template template =  ts.getTemplate(id) ;
			
			String[] acontents = template.getDesc().split("\n");
			String temp = "";
			for (int i = 0; i < acontents.length; i++) {
				temp=temp+acontents[i]+"<br>";
			}
			template.setDesc(temp);
			List askList = ts.getAsk(id) ;
			modelAndView.addObject("template", template) ;
			modelAndView.addObject("askList", askList) ;
			modelAndView.addObject("desc", desc) ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView addDownloadInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		PrintWriter out = null; 
		try { 
			//生成模板表主键
			conn = new DBConnect().getConnect();
			out = response.getWriter();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String userId = StringUtil.showNull((String)userSession.getUserMap().get("loginid")) ;
			String module = StringUtil.showNull(request.getParameter("module")) ;
			String indexId = StringUtil.showNull(request.getParameter("indexid")) ;
			String mark = StringUtil.showNull(request.getParameter("mark")) ;
			
			GradeService gs = new GradeService(conn) ;
			AttachFileUploadService afs = new AttachFileUploadService(conn) ;
			boolean isDownload =  afs.isDownInfoExist(userId, module, indexId) ;
			if(!isDownload) {
				//没下载过，扣分，记录下载
				int intMark = Integer.parseInt(mark);
				Grade grade = gs.getGradeByLoginId(userId);
				if(grade.getResource() < intMark){
					//不够分
					out.write("notenough") ;
					return null;
				}else {
					int resource = grade.getResource() - intMark;
					grade.setResource(resource);
					gs.update(grade);
					afs.addDownInfo(userId, module, indexId) ;
				}
			}
			out.write("ok");
		} catch (Exception e) {
			out.write("fail");
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect() ;
			
			//生成模板表主键
			String id = StringUtil.showNull(request.getParameter("id")) ;
			String title = StringUtil.showNull(request.getParameter("title")) ;
			String mark = StringUtil.showNull(request.getParameter("minMark")) ;
			String desc = StringUtil.showNull(request.getParameter("desc")) ;
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Template template = new Template() ;
			template.setId(id) ;
			template.setTitle(title);
			template.setDesc(desc) ;
			template.setMark(mark) ;
			template.setUserId((String)userSession.getUserMap().get("loginid")) ;
			template.setPublishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			
			TemplateService ts = new TemplateService(conn) ;
			ts.add(template) ;
			response.sendRedirect(request.getContextPath()+"/common/template.do?method=list") ;
 		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	public ModelAndView saveAsk(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect() ;
			
			//生成模板表主键
			String templateId = StringUtil.showNull(request.getParameter("templateId")) ;
			String askContent = StringUtil.showNull(request.getParameter("askContent")) ;
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			TemplateAsk ta = new TemplateAsk() ;
			ta.setTemplateId(templateId) ;
			ta.setAskContent(askContent) ;
			ta.setAskDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) ;
			ta.setUserId((String)userSession.getUserMap().get("loginid")) ;
			
			TemplateService ts = new TemplateService(conn) ;
			ts.addAsk(ta) ;
			
			/*//重新生成静态文件
			ToHTML tohtml = new ToHTML() ;
			String url = "http://"+request.getServerName() + ":"+request.getServerPort()+request.getContextPath()+"/common/template.do?method=view&id="+templateId;
			String path = request.getSession().getServletContext().getRealPath("/")+"common/templateHtml/" ;
			tohtml.convertToHtml(url,templateId+".html",path) ;*/
			
			response.sendRedirect(request.getContextPath()+"/common/template.do?method=view&id="+templateId);
 		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}

}
