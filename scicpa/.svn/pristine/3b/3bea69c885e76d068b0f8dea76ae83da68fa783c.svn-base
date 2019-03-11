package cn.org.gdicpa.web.action.partynew;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
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
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.document.DocumentService;
import cn.org.gdicpa.web.service.partynew.NewService;

public class NewAction extends MultiActionController {

	private final String NEW_LIST = "/partynew/index.jsp";
	private final String NEW_ADD = "/partynew/add.jsp";
	private final String NEW_VIEW = "/partynew/view.jsp";
	private final String NEW_EDIT = "/partynew/edit.jsp";
	
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(NEW_LIST);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String loginid = "", ctypetabname = "";;
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname")).toLowerCase(); 
			}
			
			String sql = "select * from (" + 
				"select id,caption ,body ,ntime ,agency ,loginid ,auditid ,audittime ,status from b_new where loginid = '"+loginid+"' " +
				"union " +
				"select id,caption ,body ,ntime ,agency ,loginid ,auditid ,audittime ,status from b_new where status = 1" +
				") a" ; 
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("党群新闻");
			pp.setTableID("newList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "caption").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("发布机构", "agency","showCenter");
			pp.addColumn("发布时间", "ntime","showCenter");
			
			pp.setColumnWidth("70%,15%,15%");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
			modelAndView.addObject("ctypetabname",ctypetabname);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
	
	//增加
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(NEW_ADD);
		return modelAndView;
	}
	
	//修改
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		ModelAndView modelAndView = new ModelAndView(NEW_ADD);
		try {
			ASFuntion CHF=new ASFuntion();
			
			String nid = CHF.showNull(request.getParameter("nid"));
			
			conn  = new DBConnect().getConnect();
			String table = "b_new";
			
			NewService ns = new NewService(conn);
			Map newMap = ns.get( table, nid);
			
			newMap.put("table", table);
			
			modelAndView.addObject("newMap", newMap);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
	}
	
	//保存
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			
			conn  = new DBConnect().getConnect();
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			
			ASFuntion CHF=new ASFuntion();
			String ntime = (String)parameters.get("ntime");
			if(ntime == null || "".equals(ntime) || "null".equals(ntime)){
				ntime = CHF.getDateAndTime();//yyyy-MM-dd HH:mm
			}
			parameters.put("ntime", ntime);
			
			String table = "b_new";
			
			NewService ns = new NewService(conn);
			ns.saveInfo(table, parameters);
			
			
			String result = "";
			if("".equals(result)){
				response.sendRedirect(request.getContextPath()+ "/common/new.do?method=indexdel");
			}else{
				PrintWriter out = null ;
				response.setContentType("text/html;charset=UTF-8") ;
				out = response.getWriter() ;
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/new.do?method=add\"</script>");
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
	
	//查看
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(NEW_VIEW);
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String nid = CHF.showNull(request.getParameter("nid"));
			
			conn  = new DBConnect().getConnect();
			String table = "b_new";
			
			NewService ns = new NewService(conn);
			Map newMap = ns.get( table, nid);
			
			newMap.put("table", table);
			
			modelAndView.addObject("newMap", newMap);
		
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
	}
	
	
	//删除列表
	public ModelAndView indexdel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(NEW_EDIT);
		try {
			ASFuntion CHF=new ASFuntion();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");

			String loginid = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}

			
			String sql = "select * from (" + 
			"	select id,caption ,body ,ntime ,agency ,loginid ,auditid ,audittime ,status,case status when 1 then '已审核' else '未审核' end as nstatus " +
			"	from b_new where loginid = '"+loginid+"' " +
			") a" ; 
			DataGridProperty pp = new DataGridProperty();
			pp.setTitle("党群新闻");
			pp.setInputType("checkbox");
			pp.setTableID("delNewList");
			pp.setWhichFieldIsValue(1);
			pp.setTrActionProperty(true);
			pp.setTrAction(" status = '${status}' ");
			pp.addColumn("标题", "caption");
			pp.addColumn("发布机构", "agency","showCenter");
			pp.addColumn("发布时间", "ntime","showCenter");
			pp.addColumn("状态", "nstatus","showCenter");
			
			pp.setColumnWidth("60%,15%,15%,10%");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
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
	
	//删除
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			
			String chooseValue = CHF.showNull(request.getParameter("chooseValue"));
			
			conn  = new DBConnect().getConnect();
			String table = "b_new";
			NewService ns = new NewService(conn);
			String result = ns.del(table,chooseValue);
			if("".equals(result)){
				result = "删除数据成功";
			}
			System.out.println(result);
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/common/new.do?method=indexdel\"</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		
		return null;
	}
	
	/**
	 * 党建制度
	 */
	private final String _DOCUMENT_VIEW = "/partynew/documentView.jsp";
	private final String _DLIST_VIEW = "/partynew/documentList.jsp";
	public ModelAndView dlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DLIST_VIEW);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String loginid = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			

			// 标题
			String caption = request.getParameter("caption");
			// 文号
			String reference = request.getParameter("reference");
			// 时间
			String ntime1 = request.getParameter("ntime1");
			String ntime2 = request.getParameter("ntime2");
			// 状态
			String isview = request.getParameter("isview");
			
			
			// 显示当前登录事务所能看到的公文收文
			String sql = 
			"	select " +
			"	a.id,caption = case when LEN(a.caption)>50 then substring(a.caption,1,50)+'...' else a.caption end," +
			"	a.body,a.attachmentid,subString(a.ntime,1,10) as ntime,a.customerid," +
			"	b.nid,b.source,b.reader," +
			"	isview = case when b.isview ='1' then '已阅' else '未阅' end,b.viewtime ," +
			"	c.name " +
			"	from K_PartyDoc a  " +
			"	left join b_reader b on a.id = b.nid " +
			"	left join k_customer as c on a.customerid = c.id " +
			"	where b.reader = '" + loginid + "' and b.source = 'K_PartyDoc'   " ;
			
			
			if(caption!=null && !"".equals(caption)){
				sql += "  and a.caption like '%"+caption+"%'";
			}
			
//			//文号
//			if(reference!=null && !"".equals(reference)){
//				if(reference.indexOf("[")>-1){
//					reference=reference.replaceAll("\\[","%");
//				}
//				if(reference.indexOf("]")>-1){
//					reference=reference.replaceAll("\\]","%");
//				}
//				if(reference.indexOf("【")>-1){
//					reference=reference.replaceAll("【","%");
//				}
//				if(reference.indexOf("】")>-1){
//					reference=reference.replaceAll("】","%");
//				}
//				sql += "  and reference like '%"+reference+"%'";
//			}
			
			if(ntime1!=null && !"".equals(ntime1) && ntime2!=null && !"".equals(ntime2)){
				sql += "  and ( ntime between '"+ntime1+"' and '"+ntime2+"' ) ";
			}else{
				if(ntime1!=null && !"".equals(ntime1)){
					sql += "  and ntime like '%"+ntime1+"%'";
				}
				if(ntime2!=null && !"".equals(ntime2)){
					sql += "  and ntime like '%"+ntime2+"%'";
				}
			}
			
			sql = "select * from ("+sql+") a where 1=1 ";
			if(isview!=null && !"".equals(isview)){
				sql += "  and isview like '%"+isview+"%'";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("党建通知");
			pp.setPageSize_CH(15);
			pp.setTableID("documentList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "caption").setTdProperty(" onclick=\"goView('${id}');\" ");
//			pp.addColumn("文号", "reference","showCenter");
			pp.addColumn("发文机构", "name","showCenter");
			pp.addColumn("发文时间", "ntime","showCenter");
			pp.addColumn("状态", "isview","showCenter");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		
		return modelAndView;
	}
	
	public ModelAndView document(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DOCUMENT_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String table = "K_PartyDoc";
			
			String nid = CHF.showNull(request.getParameter("nid"));
			String reader = "";
			if(userSession != null){
				reader = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			conn  = new DBConnect().getConnect();
			NewService ns = new NewService(conn);
			DocumentService ds = new DocumentService(conn);
			
			Map map = ns.get(table, nid, reader);
			map.put("table", table);
			modelAndView.addObject("documentMap", map);
			
			ds.save(nid, reader);	//打开view，修改已阅时间
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
}
