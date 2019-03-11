package cn.org.gdicpa.web.action.posts;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.posts.PostsService;
import cn.org.gdicpa.web.service.user.UserService;

public class RecruitmentAction extends MultiActionController {

	private final String _VIEW = "/recruitment/list.jsp";
	private final String _LOOK_VIEW = "/recruitment/view.jsp";
	private final String _ADD_VIEW = "/recruitment/add.jsp";
	private final String _DEL_VIEW = "/recruitment/del.jsp";
	
	//招聘信息
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_VIEW);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String btype = "招聘";
			
			String sql = " select a.*,b.loginname,c.loginname as lastname from b_topic a,k_user b,k_user c " 
					   + " where 1=1 " 
					   + " and a.btype = '"+btype+"' " 
					   + " and a.loginid = b.loginid and a.lastpost = c.loginid "
					   + " and b.ctypetabname not in ('k_micfono','k_micfo')  "  // 团体会员和非职业会员的 loginid 一样
					   + " and c.ctypetabname not in ('k_micfono','k_micfo')  "; // 团体会员和职业会员的 loginid 一样
			DataGridProperty pp = new DataGridProperty();
//			pp.setInputType("radio");
			pp.setTitle("招聘信息");
			pp.setTableID("topicList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "topicName").setTdProperty(" onclick=\"goView('${topicid}');\" ");
			pp.addColumn("作者", "loginname","showCenter");
			pp.addColumn("发表时间", "dateandtime","showCenter");
			pp.addColumn("回复数", "child","showCenter");
			pp.addColumn("查看数", "hits","showCenter");
			pp.addColumn("最后发表人", "lastname","showCenter");
			pp.addColumn("最后发表时间", "lastposttime","showCenter");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("dateandtime");
			pp.setPageSize_CH(10);
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);

			String ctypetabname = "";
			if(userSession != null){
				ctypetabname = ((String)userSession.getUserMap().get("ctypetabname")).toLowerCase();
			}
			modelAndView.addObject("ctypetabname", ctypetabname);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
		
	}
	
	//打开删除列表
	public ModelAndView indexdel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DEL_VIEW);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			String loginid = CHF.showNull(request.getParameter("loginid"));
			String btype = "招聘";
			String sql = " select a.*,b.loginname,c.loginname as lastname from b_topic a,k_user b,k_user c "  
					   + " where a.loginid = '"+loginid+"' " 
					   + " and a.btype = '"+btype+"' " 
					   + " and a.loginid = b.loginid and a.lastpost = c.loginid "
					   + " and b.ctypetabname not in ('k_micfono','k_micfo')  "  // 团体会员和非职业会员的 loginid 一样
					   + " and c.ctypetabname not in ('k_micfono','k_micfo')  "; // 团体会员和职业会员的 loginid 一样
			DataGridProperty pp = new DataGridProperty();
			pp.setTitle("招聘信息");
			pp.setInputType("checkbox");
			pp.setTableID("delList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "topicName");
			pp.addColumn("作者", "loginname");
			pp.addColumn("发表时间", "dateandtime");
			pp.addColumn("回复数", "child");
			pp.addColumn("查看数", "hits");
			pp.addColumn("最后发表人", "lastname");
			pp.addColumn("最后发表时间", "lastposttime");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("dateandtime");
			pp.setPageSize_CH(10);
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);

			String ctypetabname = ((String)userSession.getUserMap().get("ctypetabname")).toLowerCase();
			modelAndView.addObject("ctypetabname", ctypetabname);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
		
	}
	//新增
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_ADD_VIEW);
		ASFuntion CHF=new ASFuntion();
		String dateandtime = CHF.getDateAndTime();//yyyy-MM-dd HH:mm
		modelAndView.addObject("dateandtime", dateandtime);
		modelAndView.addObject("attachmentid", DELUnid.getNumUnid());
		return modelAndView;
	}
	
	//保存
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			
			conn  = new DBConnect().getConnect();
			
			PostsService rService = new PostsService(conn);
			
			String result = rService.saveInfo("b_topic", parameters);
			
			if("".equals(result)){
				response.sendRedirect(request.getContextPath()+ "/common/recruitment.do");
			}else{
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/recruitment.do?method=add\"</script>");
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
	
	public ModelAndView saveport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			
			ASFuntion CHF=new ASFuntion();
			String dateandtime = CHF.getDateAndTime();//yyyy-MM-dd HH:mm
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			
			conn  = new DBConnect().getConnect();
			
			PostsService rService = new PostsService(conn);
			String topicid = (String)parameters.get("topicid");
			String loginid = (String)parameters.get("loginid");
			parameters.put("posttime", dateandtime);//回贴日期 (自动)
			String result = rService.savePost("b_post", parameters);
			rService.updateChild(topicid, loginid, dateandtime);
			
			if("".equals(result)){
				response.sendRedirect(request.getContextPath()+ "/common/recruitment.do?method=view&topicid="+topicid+"&random="+DELUnid.getNumUnid() );
			}else{
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/recruitment.do?method=view&topicid="+topicid+"&random="+DELUnid.getNumUnid()+"\"</script>");
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
	
	//评分
	public ModelAndView savescoring(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			
			ASFuntion CHF=new ASFuntion();
			
			String postid = CHF.showNull(request.getParameter("postid"));
			String topicid = CHF.showNull(request.getParameter("topicid"));
			String scoring = CHF.showNull(request.getParameter("scoring"));
			
			conn  = new DBConnect().getConnect();
			
			PostsService rService = new PostsService(conn);
			
			String result = rService.updateScoring(postid, topicid, scoring);
			if("".equals(result)){
				result = "ok";
			}
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println(result);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	//查看
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_LOOK_VIEW);
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String topicid = CHF.showNull(request.getParameter("topicid"));
			
			conn  = new DBConnect().getConnect();
			
			PostsService rService = new PostsService(conn);
			UserService user = new UserService(conn);
			
			rService.updateHits(topicid);//修改查看次数
			/**
			 * 主题表
			 */
			Map topicMap = rService.getTopic("b_topic", topicid);
			
			/**
			 * 个人图片
			 */
			String tabname = (String)topicMap.get("ctypetabname");
			String loginid = (String)topicMap.get("loginid");
			
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("photo") ;
			String fileTempName = DELUnid.getNumUnid()  ; 
			String userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			topicMap.put("userphotosrc",userPhotoSrc);
			
			modelAndView.addObject("topicMap", topicMap);
			
			modelAndView.addObject("attachmentid", DELUnid.getNumUnid());
			
			/**
			 * 贴子表
			 */
			ArrayList postsList = rService.getPosts("b_post", topicid);
			int postCount = (Integer)postsList.get(postsList.size()-1);
			postsList.remove(postsList.size()-1);
			
			modelAndView.addObject("postCount", postCount);	//贴子数
			if(postCount != 0){	//有贴子
				for(int i = 0; i < postCount; i++){
					Map post = (Map)postsList.get(i);
					
					/**
					 * 个人图片
					 */
					tabname = (String)post.get("ctypetabname");
					loginid = (String)post.get("loginid");
					
					userPhotoSrc = "";
					foder  = new Foder("",request);
					newPath = foder.createFoder("photo") ;
					fileTempName = DELUnid.getNumUnid()  ; 
					userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
					post.put("userphotosrc",userPhotoSrc);
					
				}
			}
			modelAndView.addObject("postsList", postsList);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		
		return modelAndView;
	}
	
	
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String chooseValue = CHF.showNull(request.getParameter("chooseValue"));
			String loginid = CHF.showNull(request.getParameter("loginid"));
			
			conn  = new DBConnect().getConnect();
			
			PostsService rService = new PostsService(conn);
			rService.delete(chooseValue);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"删除数据成功\");window.location=\""+request.getContextPath()+ "/common/recruitment.do?method=indexdel&loginid="+loginid+"\"</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		
		return null;
	}
}
