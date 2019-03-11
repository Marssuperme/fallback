package cn.org.gdicpa.web.action.workerBranch;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.memberBranch.MemberBranchService;
import cn.org.gdicpa.web.service.workerBranch.WorkerBranchService;
import cn.org.gdicpa.web.service.workerBranch.model.WorkerBranchTable;

public class WorkerBranchAction extends MultiActionController{
	private static final String WORKERBRANCHLIST = "/workerBranch/list.jsp";
	private static final String WORKERBRANCHADDANDEDIT = "/workerBranch/addAndEdit.jsp";
	private static final String WORKERBRANCHVIEW = "/workerBranch/view.jsp";
	private static final String WORKERBRANCHADDFRAME = "/workerBranch/addframe.jsp";
	
	//工会
	public ModelAndView goAddFrame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(WORKERBRANCHADDFRAME);
		return model;
	}
	
	//工会
	private static final String BRANCH = "/workerBranch/branch.jsp";
	public ModelAndView branch(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		ModelAndView model = new ModelAndView(BRANCH);
		
		Connection conn = null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			
			conn = new DBConnect().getConnect();
			WorkerBranchService wbs = new WorkerBranchService(conn);
			Map branch = wbs.getBranch(loginid);
			
			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
			System.out.println("测试oldLoginId是否为空："+oldLoginId);
			if(oldLoginId!=null){
				String isCreateNew = new DbUtil(conn).queryForString("select isCreate from K_WorkerBranch where officecode=?",new Object[]{loginid});
				System.out.println("测试是否创建isCreateNew（NULL,是,否）: " + isCreateNew);
				String isCreateOld = new DbUtil(conn).queryForString("select isCreate from K_WorkerBranch where officecode=?",new Object[]{oldLoginId});
				System.out.println("测试是否创建isCreateOld（NULL,是,否）: " + isCreateOld);
				if(isCreateNew==null && isCreateOld!=null){
					branch = wbs.getBranch(oldLoginId);
				}
			}
			
			model.addObject("branch", branch);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	//修改工会资料
	public ModelAndView updateSave(HttpServletRequest request,HttpServletResponse response)throws Exception { 
		Connection conn=null;
		PrintWriter out = null ;
		try {
			conn  = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			String loginid = (String)userMap.get("loginid");
			String loginname = (String)userMap.get("loginname");
			
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			
			ASFuntion CHF = new ASFuntion();
			
			System.out.println("------------->>>"+parameters);
			
			WorkerBranchTable workerBranch = new WorkerBranchTable();
			workerBranch.setId((String)parameters.get("id"));
			workerBranch.setArea((String)parameters.get("area"));
			workerBranch.setOfficecode(loginid);
			//兼容改制前旧数据
//			String oldLoginId = new DbUtil(conn).queryForString("select oldLoginId from K_Company where loginid=?",new Object[]{loginid});
//			if(oldLoginId!=null){
//				String isCreateNew = new DbUtil(conn).queryForString("select isCreate from K_WorkerBranch where officecode=?",new Object[]{loginid});
//				String isCreateOld = new DbUtil(conn).queryForString("select isCreate from K_WorkerBranch where officecode=?",new Object[]{oldLoginId});
//				if(isCreateNew==null && isCreateOld!=null){
//					workerBranch.setOfficecode(oldLoginId);
//				}
//			}
			
			workerBranch.setBranchtype((String)parameters.get("branchtype"));
			workerBranch.setIsCreate((String)parameters.get("isCreate"));
			workerBranch.setBranchname((String)parameters.get("branchname"));
			workerBranch.setBuilddate((String)parameters.get("builddate"));
			workerBranch.setChairMan((String)parameters.get("chairman"));
			workerBranch.setMobile((String)parameters.get("mobile"));
			workerBranch.setLinkMan((String)parameters.get("linkman"));
			workerBranch.setPhone((String)parameters.get("phone"));
			
			String num1 = (String)parameters.get("workernum");
			workerBranch.setWorkerNum(Integer.parseInt(num1==null || "".equals(num1) ? "0" : num1));
			
			String num2 = (String)parameters.get("membernum");
			workerBranch.setMembernum(Integer.parseInt(num2==null || "".equals(num2) ? "0" : num2));
			
			String num3 = (String)parameters.get("cpanum");
			workerBranch.setCpanum(Integer.parseInt(num3==null || "".equals(num3) ? "0" : num3));
			
			workerBranch.setLastby(loginid);
			workerBranch.setLastmodify(CHF.getDateAndTime1());
			
			//获取事务所归属“市级行业（协会）团组织”的ID,NAME
			String pId = new DbUtil(conn).queryForString("select id from K_WorkerBranch where area=? and branchType=?", new Object[]{workerBranch.getArea(),"市级行业(协会)工会"});
			String pName = new DbUtil(conn).queryForString("select branchName from K_WorkerBranch where area=? and branchType=?", new Object[]{workerBranch.getArea(),"市级行业(协会)工会"});
			
			workerBranch.setPid(pId);
			workerBranch.setPname(pName);
			
			
			WorkerBranchService wbs = new WorkerBranchService(conn);
			wbs.saveOrUpdate(workerBranch);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\"提交工会信息成功!\");window.location=\""+request.getContextPath()+"/common/workerBranch.do?method=branch\"</script>");
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			//out.println("<script>alert(\"提交团组织信息失败，请联系管理员!\");window.location=\""+request.getContextPath()+"/common/workerBranch.do?method=branch\"</script>");
			throw e;
		} finally{
			DbUtil.close(conn);
		}
		
	}
}