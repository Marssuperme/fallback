package cn.org.gdicpa.web.action.micfonoJoinParty;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.candidates.CandidateService;
import cn.org.gdicpa.web.service.candidates.model.Candidates;
import cn.org.gdicpa.web.service.micfonoJoinParty.MicfonoJoinPartyService;
import cn.org.gdicpa.web.service.micfonoJoinParty.model.MicfonoJoinParty;

public class MicfonoJoinPartyAction extends MultiActionController{
	private final String JOINPARTY = "/micfonoJoinParty/joinParty.jsp";
	private final String JOINPARTYINFO = "/micfonoJoinParty/joinPartyInfo.jsp";
	private final String PRINT = "/micfonoJoinParty/print.jsp";
	
	
	// 非执业入会 入口
	public ModelAndView goJoinParty(HttpServletRequest request,HttpServletResponse response){
		System.out.println("goJoinParty............................");
		ModelAndView model = new ModelAndView(JOINPARTY);
		return model;
	}
	
	// 加载非执业入会信息  考生信息
	public ModelAndView goJoinPartyInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(JOINPARTYINFO);
		String name = request.getParameter("name");
		String idCardNum = request.getParameter("IDCardNum");
		ASFuntion af = new ASFuntion();
		String syear = af.getCurrentDate().substring(0,4);
		Connection conn = null;
		String sql = "";
		String p = "m";
		try {
			conn = new DBConnect().getConnect();
			MicfonoJoinPartyService mps = new MicfonoJoinPartyService(conn);
			MicfonoJoinParty mjp = mps.getMicfonoJoinPartyByMore(name, idCardNum, syear);
			//  查看 非执业入会表里面是否 存在   当年 符合 录入姓名+身份证号的 非执业信息   
			if("".equals(mjp.getId()) || null==mjp.getId()){		// 没有  就 查看    K_Certificate   合格证号
				sql = " select general from K_Certificate where loginname = ? and idnumber = ? ";
				String general = new DbUtil(conn).queryForString(sql,new Object[]{name,idCardNum});
				if(general!=null && !"".equals(general)){	// 存在 K_Certificate   合格证号 就 找出 考生信息表里面 最后一条记录
					CandidateService cs = new CandidateService(conn);
					Candidates cd = cs.getCandidatesByMore(name, idCardNum);
					cd.setId("");
					model.addObject("ct", cd);
					p = "c";
				}
			} else{
				model.addObject("ct", mjp);
			}
			
			model.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 新增
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addMicfonoJoinParty(HttpServletRequest request,HttpServletResponse response,MicfonoJoinParty mjp){
		Connection conn = null;
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		
		ASFuntion af = new ASFuntion();
		
		String id = UUID.randomUUID().toString();
		String loginid = "";
		mjp.setId(id);
		mjp.setLoginid(loginid);
		mjp.setState("0");
		mjp.setCreateDate(af.getCurrentDate());
		
		try {
			conn = new DBConnect().getConnect();
			MicfonoJoinPartyService mjps = new MicfonoJoinPartyService(conn);
			boolean bl = mjps.addMicfonoJoinParty(mjp);
			out = response.getWriter();
			if(bl){
				out.print("<script>");
				out.print("alert('保存成功!');");
				out.print("window.location='"+request.getContextPath()+"/common/micfonoJoinParty.do?method=loadJoinPartyInfo&id="+id+"';"); 
				out.print("</script>");
			}else{
				out.print("<script>");
				out.println("alert('保存失败!');");
				out.println("window.location='"+request.getContextPath()+"/common/micfonoJoinParty.do?method=loadJoinPartyInfo&id="+id+"';"); 
				out.println("</script>");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateMicfonoJoinParty(HttpServletRequest request,HttpServletResponse response,MicfonoJoinParty mjp){
		Connection conn = null;
		PrintWriter out = null;
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=UTF-8") ;
		try {
			conn = new DBConnect().getConnect();
			MicfonoJoinPartyService mjps = new MicfonoJoinPartyService(conn);
			boolean bl = mjps.updateMicfonoJoinPartyById(mjp);
			out = response.getWriter();
			if(bl){
				out.print("<script>");
				out.println("alert('保存成功!');");
				out.println("window.location='"+request.getContextPath()+"/common/micfonoJoinParty.do?method=loadJoinPartyInfo&id="+id+"';"); 
				out.println("</script>");
			}else{
				out.print("<script>");
				out.println("alert('保存失败!');");
				out.println("window.location='"+request.getContextPath()+"/common/micfonoJoinParty.do?method=loadJoinPartyInfo&id="+id+"';"); 
				out.println("</script>");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	// 保存后加载 非执业入会信息 
	public ModelAndView loadJoinPartyInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(JOINPARTYINFO);
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			MicfonoJoinParty mjp = new MicfonoJoinPartyService(conn).getMicfonoJoinPartyById(id);
			model.addObject("ct", mjp);
			model.addObject("p", "m");
			model.addObject("save", "save");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 打印 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goPrint(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(PRINT);
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			MicfonoJoinParty mjp = new MicfonoJoinPartyService(conn).getMicfonoJoinPartyById(id);
			model.addObject("mjp", mjp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
}
