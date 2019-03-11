package cn.org.gdicpa.web.action.document;

import java.sql.Connection;
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

public class DocumentAction extends MultiActionController {

	private final String _NOTICE_VIEW = "/document/noticeView.jsp";
	private final String _NLIST_VIEW = "/document/noticeList.jsp";
	
	private final String _DOCUMENT_VIEW = "/document/documentView.jsp";
	private final String _DLIST_VIEW = "/document/documentList.jsp";
	
	/**
	 * 公告通知
	 */
	public ModelAndView notice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_NOTICE_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String table = "b_notice";
			
			String nid = CHF.showNull(request.getParameter("nid"));
			String reader = "";
			if(userSession != null){
				reader = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			conn  = new DBConnect().getConnect();
			
			DocumentService ds = new DocumentService(conn);
			
			System.out.println("table:nid:reader:"+table+" : "+nid+" : "+reader);
			
			Map map = ds.get(table, nid, reader);
			map.put("table", table);
			modelAndView.addObject("noticeMap", map);


			String p = request.getParameter("p");
			modelAndView.addObject("p",p);

			
			ds.save(nid, reader);	//打开view，修改已阅时间
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	/**
	 * 显示所有公告通知
	 */
	public ModelAndView nlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_NLIST_VIEW);
		Connection conn = null; 
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			
			String p = request.getParameter("p");			
			
			String loginid = (String)map.get("loginid");
			String officecode = (String)map.get("officecode");
			
			//改制修改20130313
			conn = new DBConnect().getConnect();
			String getOldLoginIdSql = "select oldLoginId from k_company where loginid=?";
			String oldLoginId = new DbUtil(conn).queryForString(getOldLoginIdSql, new Object[]{loginid});
			
			String sql = null;
			
			// 将一般通知和检查组人员通知组合在一起
			// 非执业会员只能看到 已审核最新通知           看不到检查组人员通知
			if("micfono".equalsIgnoreCase(p)){
				 sql = " select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
				 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status," 
				 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid," 
			         + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p " 
					 + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "  
					 + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' and r.ctype='k_micfono' ";
			}
//			else{  // 执业和团体能看到 已审核的最新培训信息和检查组人员通知
//				 sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
//			 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
//			 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
//			     + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
//			     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
//			     + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' " 
//			     + " union "
//			     + " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
//			     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
//			     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
//			     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
//			     + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
//			     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
//			     + " left join k_TesterComposition b on a.id = b.noticeid where a.Status = '1') g ";
			
//			sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
//			 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
//			 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
//			     + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
//			     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
//			     + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' and r.ctype!='k_micfono' " 
//			     + " union "
//			     + " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
//			     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
//			     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
//			     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
//			     + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
//			     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
//			     + " left join k_TesterComposition b on a.id = b.noticeid left join b_reader r on a.id = r.nid "
//			     + " where a.Status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"') g ";
//		}
			else if("micfo".equalsIgnoreCase(p)){  // 执业人员通知
//				 sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
//				 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
//				 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
//				     + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
//				     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
//				     + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' " 
//				     + " union "
//				     + " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
//				     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
//				     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
//				     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
//				     + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
//				     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
//				     + " left join k_TesterComposition b on a.id = b.noticeid where a.Status = '1') g ";
				sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
				 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
				 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
				     + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
				     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
				     + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' and r.ctype!='k_micfono' " 
				     + " union "
				     + " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
				     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
				     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
				     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
				     + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
				     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
				     + " left join k_TesterComposition b on a.id = b.noticeid left join b_reader r on a.id = r.nid "
				     + " where a.Status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"') g ";
			}else{  // 团体能看到 已审核的最新培训信息和检查组人员通知
				//改所修改----------------------------------------------------------20130313
				if(oldLoginId==null){
					sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
					 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
					 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
					     + " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
					     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
					     + " where r.source='b_notice' and n.mode='已审核' and r.reader = '"+loginid+"' and r.ctype!='k_micfono' " 
					     + " union "
					     + " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
					     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
					     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
					     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
					     + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
					     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
					     + " left join k_TesterComposition b on a.id = b.noticeid left join b_reader r on a.id = r.nid "
					     + " where a.Status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"') g where 1=1 ";
				}else{
					sql = " select * from (select n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
						+ " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
						+ " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
						+ " r.nid,r.source,r.reader,isview = case when r.isview ='1' then '已阅' else '未阅' end,r.viewtime,'notice' as p "   
						+ " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "   
						+ " where r.source='b_notice' and n.mode='已审核' and r.reader in ('" + loginid +"','"+oldLoginId+"') and r.ctype!='k_micfono' " 
						+ " union "
						+ " select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
						+ " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
						+ " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
						+ " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
						+ " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
						+ " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
						+ " left join k_TesterComposition b on a.id = b.noticeid left join b_reader r on a.id = r.nid "
						+ " where a.Status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"') g where 1=1 ";
				}
		}
			
			System.out.println("----------------------------------------------------start");
			
			// 标题
			String caption = request.getParameter("caption");
			// 时间
			String ntime1 = request.getParameter("ntime1");
			String ntime2 = request.getParameter("ntime2");
			// 状态
			String isview = request.getParameter("isview");
			
			
			if(caption!=null && !"".equals(caption)){
				sql += " and caption like '%"+caption+"%'";
			}
			
			if(ntime1!=null && !"".equals(ntime1) && ntime2!=null && !"".equals(ntime2)){
				sql += " and ( ntime between '"+ntime1+"' and '"+ntime2+"' ) ";
			}else{
				if(ntime1!=null && !"".equals(ntime1)){
					sql += " and ntime like '%"+ntime1+"%'";
				}
				if(ntime2!=null && !"".equals(ntime2)){
					sql += " and ntime like '%"+ntime2+"%'";
				}
			}
			
			if(isview!=null && !"".equals(isview)){
				sql += " and isview like '%"+isview+"%'";
			}
			
			System.out.println("----------------------------------------------------end");
			
			System.out.println(this.getClass()+"　　　ｓｑｌ="+sql);
						
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("公告通知");
			pp.setTableID("noticeList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "caption","showCenter").setTdProperty(" onclick=\"goView('${id}','${p}');\" ");
//			pp.addColumn("文号", "reference","showCenter");
			pp.addColumn("发放机构", "agency","showCenter");
			pp.addColumn("发放时间", "ntime","showCenter");
			pp.addColumn("状态", "isview","showCenter");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			modelAndView.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	/**
	 * 公文收文
	 */
	public ModelAndView document(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DOCUMENT_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String table = "b_document";
			
			String nid = CHF.showNull(request.getParameter("nid"));
			String reader = "";
			if(userSession != null){
				reader = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			conn  = new DBConnect().getConnect();
			
			DocumentService ds = new DocumentService(conn);
			
			Map map = ds.get(table, nid, reader);
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
	
	/**
	 * 更多链接       显示所有公文收文
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView dlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_DLIST_VIEW);
		Connection conn = null;
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
			
			
			//改制修改20130313
			conn = new DBConnect().getConnect();
			String getOldLoginIdSql = "select oldLoginId from k_company where loginid=?";
			String oldLoginId = new DbUtil(conn).queryForString(getOldLoginIdSql, new Object[]{loginid});
			
			String sql = null;
			if(oldLoginId==null){
				// 显示当前登录事务所能看到的公文收文
				sql = " select  a.*,c.name from ( " 
						   + " select (case isnull(a.urgency,'') when '' then '' else '<font color=red>【急】</font>' end) as urgency,a.id,caption = case when LEN(a.caption)>50 then substring(a.caption,1,50)+'...' else a.caption end," 
						   + " a.body,a.attachmentid,subString(a.ntime,1,10) as ntime,a.agency,a.loginname,a.reference,a.status,b.nid,b.source,b.reader," 
						   + " isview = case when b.isview ='1' then '已阅' else '未阅' end,b.viewtime " 
						   + " from b_document a  left join b_reader b on a.id = b.nid" 
						   + " where b.reader = '" + loginid + "' and b.source = 'b_document'  "  
						   + " ) a left join k_customer as c on a.agency=c.id  where 1=1  " ; 
			}else{//改制后SQL
				sql = " select  a.*,c.name from ( " 
					   + " select (case isnull(a.urgency,'') when '' then '' else '<font color=red>【急】</font>' end) as urgency,a.id,caption = case when LEN(a.caption)>50 then substring(a.caption,1,50)+'...' else a.caption end," 
					   + " a.body,a.attachmentid,subString(a.ntime,1,10) as ntime,a.agency,a.loginname,a.reference,a.status,b.nid,b.source,b.reader," 
					   + " isview = case when b.isview ='1' then '已阅' else '未阅' end,b.viewtime " 
					   + " from b_document a  left join b_reader b on a.id = b.nid" 
					   + " where b.reader in ('" + loginid +"','"+oldLoginId+"') and b.source = 'b_document'  "  
					   + " ) a left join k_customer as c on a.agency=c.id  where 1=1  " ; 
			}
			
			if(caption!=null && !"".equals(caption)){
				sql += "  and caption like '%"+caption+"%'";
			}
			if(reference!=null && !"".equals(reference)){
				if(reference.indexOf("[")>-1){
					reference=reference.replaceAll("\\[","%");
				}
				if(reference.indexOf("]")>-1){
					reference=reference.replaceAll("\\]","%");
				}
				if(reference.indexOf("【")>-1){
					reference=reference.replaceAll("【","%");
				}
				if(reference.indexOf("】")>-1){
					reference=reference.replaceAll("】","%");
				}
				sql += "  and reference like '%"+reference+"%'";
			}
			
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
			
			if(isview!=null && !"".equals(isview)){
				sql += "  and isview like '%"+isview+"%'";
			}
			
			System.out.println(this.getClass()+"        sql="+sql);
			
			DataGridProperty pp = new DataGridProperty();
			
			
			pp.setTitle("公文收文");
			pp.setPageSize_CH(15);
			pp.setTableID("documentList");
			pp.setWhichFieldIsValue(1);
			
			
			pp.addColumn("&nbsp;", "urgency","showCenter");
			pp.addColumn("标题", "caption").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("文号", "reference","showCenter");
			pp.addColumn("发文机构", "name","showCenter");
			pp.addColumn("发文时间", "ntime","showCenter");
			pp.addColumn("状态", "isview","showCenter");			
			
			
			System.out.println("HHHHHH:"+sql);
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	
	/**
	 * 团体会员的检查组人员通知
	 */
	public ModelAndView companyTesterNoticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(_NLIST_VIEW);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			
			String officecode = (String)map.get("officecode");
			
			String sql = null;
			
			sql = " select * from (select a.id,caption = case when LEN(a.title)>50 then substring(a.title,1,50)+'...' else a.title end," 
			    + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
			    + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
			    + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
			    + " a.userid as reader,isview = case when b.noticeid is null then '未报名' when b.noticeid='' then '未报名'  else '已报名' end,"
			    + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
			    + " left join (select distinct noticeid,companyid from k_TesterComposition where companyid = '"+officecode+"') b on a.id = b.noticeid left join b_reader r on a.id = r.nid "
			    + " where a.Status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"') g ";
			 
			System.out.println(this.getClass()+"　　　ｓｑｌ="+sql);
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("检查组人员通知");
			pp.setTableID("noticeList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题","caption","showCenter").setTdProperty(" onclick=\"goView('${id}','${p}');\" ");
			pp.addColumn("发放机构","agency","showCenter");
			pp.addColumn("发放时间","ntime","showCenter");
			pp.addColumn("状态","isview","showCenter");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");

			modelAndView.addObject("p", "company");

			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		
		return modelAndView;
	}
}
