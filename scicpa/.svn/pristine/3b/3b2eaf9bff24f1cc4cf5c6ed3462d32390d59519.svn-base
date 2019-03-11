package cn.org.gdicpa.web.action.testerNotice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.testerComposition.TesterCompositionService;
import cn.org.gdicpa.web.service.testerComposition.model.TesterCompositionTable;
import cn.org.gdicpa.web.service.testerNotice.TesterNoticeService;
import cn.org.gdicpa.web.service.testerNotice.model.TesterNoticeTable;

public class TesterNoticeAction extends MultiActionController{
	private static String SEARCH = "/testerNotice/search.jsp";
	private static String SEARCHPERSON = "/testerNotice/searchPerson.jsp";
	
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getTesterNoticeTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null; 
		ModelAndView model = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = StringUtil.showNull((String)userSession.getUserMap().get("loginid"));
		String p = StringUtil.showNull(request.getParameter("p"));
		if(p.equals("company")){				// 事务所就可以进行报名
			model = new ModelAndView(SEARCH);
		}else{									// 其他必须通过事务所才能报名
			model = new ModelAndView(SEARCHPERSON);
		}
		String id = request.getParameter("id");
		try {
			conn = new DBConnect().getConnect();
			TesterNoticeService tns = new TesterNoticeService(conn);
			TesterNoticeTable tnt = tns.getTesterNoticeTable(id);
			
			if(tnt.getAcontent()!=null && !"".equals(tnt.getAcontent())){
				if(tnt.getAcontent().indexOf("\n")>-1){
					String[] acontents = tnt.getAcontent().split("\n");
					String temp = "";
					for (int i = 0; i < acontents.length; i++) {
						temp=temp+acontents[i]+"<br>";
					}
					tnt.setAcontent(temp);
				}
			}
			// 根据 userId找到  k_user　中对应的loginName
			String fbPerson = tns.getLoginName(tnt.getUserId());
			model.addObject("fbPerson",fbPerson);
		    model.addObject("tnt",tnt);
		    
		    TesterCompositionService tcs = new TesterCompositionService(conn);
		    //TesterCompositionTable tct = tcs.search(tnt.getId(),loginid);
		    
		    List<TesterCompositionTable> list = tcs.getTcnameList(tnt.getId(),loginid);
		    
		    String uploadAttachId = DELUnid.getNumUnid();
		    String tcname = "";
		    if(list.size()!=0){
			    for (TesterCompositionTable testerCompositionTable : list) {
					tcname += testerCompositionTable.getTcname()+",";
				}
			    tcname = tcname.substring(0,tcname.length()-1);
			    uploadAttachId = list.get(0).getUploadAttachId();
 		    }
		    model.addObject("uploadAttachId", uploadAttachId);
		    // 对应通知  本所 参加的人的名单
		    model.addObject("tcname", tcname);

		    // 对应通知的已参加人数
		    String count = tcs.getCountByNoticeid(tnt.getId());
		    model.addObject("count",count);
		    
		    model.addObject("today", new ASFuntion().getCurrentDate());
			
//			String sql = " select l.loginid,l.loginname,l.ctype,l.ctypetabname,l.officecode,l.cpano,t.astate"
//					   + " from ( select b.loginid,b.loginname,b.ctype,b.ctypetabname,b.officecode,b.cpano"
//					   + " from k_user a , (" 
//					   + " select loginid,loginname,ctype,ctypetabname,officecode,cpano from K_Micfo"  
//					   + " union  "
//					   + " select loginid,loginname,ctype,ctypetabname,officecode,'' as cpano from k_micfono" 
//					   + " union "
//					   + " select loginid,loginname,ctype,'' as ctypetabname,officecode,'' as cpano  from k_company"
//					   + " ) b "
//					   + " where a.loginid='"+loginid+"' and  a.officecode = b.officecode"
//					   + " ) l left join k_TesterComposition t on l.loginid = t.userid " ;
		    
//			String sql = " select l.loginid,l.loginname,l.ctype,l.ctypetabname,l.officecode,l.cpano,t.astate"
//				   + " from ( select b.loginid,b.loginname,b.ctype,b.ctypetabname,b.officecode,b.cpano"
//				   + " from k_user a , ("  
//				   + " select loginid,loginname,'' as ctype,'' as ctypetabname,officecode,'' as cpano  from k_company"
//				   + " ) b "
//				   + " where a.loginid='"+loginid+"' and  a.officecode = b.officecode"
//				   + " ) l left join k_TesterComposition t on l.loginid = t.userid " ;
			 
		    String sql = " select distinct a.loginid,a.loginname,a.ctype,a.ctypetabname,a.officecode,a.cpano,a.rank,b.companyid,b.userid,b.applytime,b.astate,b.id,b.rtx," 
		    		   + " post = case isnull(b.post,'') when '' then case isnull(a.rank,'') when '' then '' else a.rank end else b.post end,"
		    		   + " mobile = case isnull(b.mobile,'') when '' then case isnull(a.mobile,'') when '' then '' else a.mobile end else b.mobile end,"
		    		   + " email = case isnull(b.email,'') when '' then case isnull(a.email,'') when '' then '' else a.email end else b.email end"
		    		   + " from ("
					   + " select b.loginid,b.loginname,b.ctype,b.ctypetabname,b.officecode,b.cpano,b.rank,b.mobile,b.email from k_user a ,"  
					   + " (select loginid,loginname,ctype,ctypetabname,officecode,cpano,rank,mobile,email from K_Micfo where state='0' and association='广东省注册会计师协会' "  
					   + " union" 
					   + " select loginid,loginname,ctype,ctypetabname,officecode,'' as cpano,rank,mobile,email from k_micfono where state='0' and association='广东省注册会计师协会' " 
					   + " ) b"  
					   + " where a.loginid='"+loginid+"' and  a.officecode = b.officecode" 
					   + " ) as a left join (select * from k_TesterComposition where noticeId = '"+id+"'  ) as b on a.loginid = b.userid";
		    
			System.out.println("py:" + sql);
			
			List userList = tns.getList(sql);
			model.addObject("userList", userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 检查人员通知	5年里受惩戒的注师不能报名
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView isPunish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8") ;
		String cpano = request.getParameter("cpano");
		ASFuntion af = new ASFuntion();
		PrintWriter out = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			out = response.getWriter();
			String sql = " select PunishDate from k_SupPunish where loginid = ? ";

			String result = af.showNull(new DbUtil(conn).queryForString(sql,new Object[]{cpano}));
			if(result==null || "".equals(request)){
				out.print("Y");
			}else{
				String nowyear = af.getCurrentDate().substring(0, 4);
				String punishYear = "0";
				if(result.length()>4){
					punishYear = result.substring(0, 4);
				}
				
				if(Integer.parseInt(nowyear) - Integer.parseInt(punishYear)>5){
					out.print("Y");
				}else{
					out.print("N");
				}
			}
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
	

	/**
	 * 检查报名状态
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkState(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String id = af.showNull(request.getParameter("id"));
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = "";
		if(userSession==null){
			loginid = af.showNull(request.getParameter("loginid"));
		}else{
			loginid = af.showNull((String)userSession.getUserMap().get("loginid"));
		}
		
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select tn.id from k_testernotice tn left join k_TesterComposition tc "
					   + " on tn.id = tc.noticeid "
					   + " where tc.companyid = ? and tc.noticeid = ? and tc.astate = ? ";
			String rs = af.showNull(new DbUtil(conn).queryForString(sql,new Object[]{loginid,id,"批准"}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("N");
			}else{
				out.print("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
}
