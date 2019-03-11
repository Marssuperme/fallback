package cn.org.gdicpa.web.action.testerComposition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.testerComposition.TesterCompositionService;
import cn.org.gdicpa.web.service.testerComposition.model.TesterCompositionTable;

public class TesterCompositionAction extends MultiActionController{
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException
	 */
	public ModelAndView addTesterCompositionTable (HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("addTesterCompositionTable ..........................");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ;
		ASFuntion af = new ASFuntion();
		Connection conn = null; 
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		System.out.println(this.getClass()+"     loginid="+loginid);
		String tcname = request.getParameter("userId");
		String uploadAttachId = request.getParameter("uploadAttachId");
		String tcnames[] = tcname.split(",");           //  注意没有 , 号的时候
		String tid2 = request.getParameter("tid2");
		String tid2s[] = tid2.split(",");           
		String tname2 = request.getParameter("tname2");
		String tname2s[] = tname2.split(",");       
		
		String post1 = request.getParameter("post1");
		String post1s[] = post1.split(",");        
		
		String mobile1 = request.getParameter("mobile1");
		String mobile1s[] = mobile1.split(",");        
		
		String email1 = request.getParameter("email1");
		String email1s[] = email1.split(",");       
		
		String rtx1 = request.getParameter("rtx1").replace("无", " ");
		String rtx1s[] = rtx1.split(",");       
		System.out.println("tname2="+tname2+"    tid2 = "+tid2+"   tid2s.length="+tid2s.length+"   rtx1s="+rtx1s.length+" post1="+post1+ "email1="+email1);
		
		//		检查人员组成表：
		//		（id，检查通知ID，CPA号，姓名，报名事务所，报名人ID，
		//		 报名时间，状态【批准/不批准/空】）
		
		String noticeId = request.getParameter("noticeId");
		
		String applytime = af.getCurrentDate(); 
		
		try {
			conn = new DBConnect().getConnect();
		    TesterCompositionService tcs = new TesterCompositionService(conn);
		    TesterCompositionTable tct = null;
		    TesterCompositionTable tct2 = tcs.search(noticeId, loginid);
		    if(tct2!=null && !"".equals(tct2.getId())){
		    	// 先删除原来的
		    	tcs.deleteTesterCompositionTable(noticeId, loginid);
		    }
		    
		    boolean bl = false;
		    
		    for(int i = 0;i < tid2s.length; i++){
	    		tct = new TesterCompositionTable();
	    		tct.setNoticeId(noticeId);
	    		tct.setCPANo(tcs.getCPANO(tid2s[i]));
	    		tct.setTcname(tname2s[i]);
	    		tct.setCompanyId(loginid);
	    		tct.setUserId(tid2s[i]);
	    		tct.setApplytime(applytime);
	    		tct.setAstate("未批准");
	    		tct.setPost(post1s[i]);
	    		tct.setMobile(mobile1s[i]);
	    		tct.setEmail(email1s[i]);
	    		tct.setRtx(rtx1s[i]);
	    		tct.setUploadAttachId(uploadAttachId);
	    		
	    		bl = tcs.addTesterCompositionTable(tct);
		    }
//			String url = request.getContextPath()+"/company/company.do?method=goAddFrame&param=mainFrame";
			String url = request.getContextPath()+"/common/document.do?method=companyTesterNoticeList";
			System.out.println(this.getClass()+"        bl="+bl+"   url  = "+url);
			if(bl){
				out.write("<script>");
				out.write("	alert(\" 报名成功\");");
				out.write("	window.location=\"" + url + "\";");
				out.write("</script>");
			}else{
				out.write("<script>");
				out.write("	alert(\"报名失败\");");
				out.write("	window.location=\"" + url + "\";");
				out.write("</script>");
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
		//return new ModelAndView("/company/company.do?method=goAddFrame&param=mainFrame");
	}
	
	/**
	 * 已报名人数
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView viewCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			String noticeid = CHF.showNull((String)request.getParameter("noticeId"));
			conn  = new DBConnect().getConnect();
			String sql = "select count(*) as personcount from k_TesterComposition where noticeid = '"+noticeid+"' group by noticeid ";
			String count = CHF.showNull(new DbUtil(conn).queryForString(sql));
			System.out.println(this.getClass()+"     sqll="+sql+" noticeid="+noticeid+"   count="+count);
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(count==null || count.equals("")){
				count = "0";
			}
			out.println(count);
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
	 * 取消报名
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String noticeid = request.getParameter("noticeId");
		System.out.println("oginid="+loginid+" noticeid="+noticeid);
		try {
			String sql = "delete from k_TesterComposition where noticeid = ? and companyid = ?";
			conn = new DBConnect().getConnect();
			int temp = new DbUtil(conn).executeUpdate(sql,new String[]{noticeid,loginid});
			System.out.println(this.getClass()+"       temp="+temp+"   loginid="+loginid+" noticeid="+noticeid);
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.print(temp);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
		
	}
	
	/**
	 * 参加/不参加
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkFile(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String indexId = af.showNull(request.getParameter("indexId"));
		String module = af.showNull(request.getParameter("module"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select autoId from k_attachfile where indextable = ? and indexId = ? ";
			Object[] obj = new Object[]{module,indexId};
			String rs = af.showNull(new DbUtil(conn).queryForString(sql,obj));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("Y");
			}else{
				out.print("N");
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