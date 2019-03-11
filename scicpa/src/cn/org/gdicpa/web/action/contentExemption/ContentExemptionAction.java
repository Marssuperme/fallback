package cn.org.gdicpa.web.action.contentExemption;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

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
import cn.org.gdicpa.web.service.contentExemption.ContentExemptionService;
import cn.org.gdicpa.web.service.contentExemption.model.ContentExemption;

/**
 * 豁免学时申报 Action
 * 
 * @author YDZ
 * 
 */
public class ContentExemptionAction extends MultiActionController {

	private static final String LIST_VIEW = "/contentExemption/list.jsp"; // list页面
	private static final String _SAVE = "/contentExemption/save.jsp";
	private static final String VIEW = "/contentExemption/view.jsp";
	
	
	/**
	 * List 方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws IOException { 
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname"); 
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);			
		try {

			String sql = " select a.ID,a.LoginId,a.LoginName,a.sex,a.sDate,a.sYear,"
					   + " a.EContent,a.EHelp,a.Status,b.Ctype,a.sType,a.InitFlag,a.imeFlag "
					   + " from XS_ContentExemption a" 
					   + " left join k_user b on a.LoginId=b.loginid"
					   + " where 1=1 and a.sType='执业会员' and a.loginid = '"+loginid+"' and a.loginname = '"+loginname+"' "
			           + " ${loginName} ${sYear}";
			// 实现查询		
		 DataGridProperty pp = new DataGridProperty();
			pp.addSqlWhere("loginName", " and a.LoginName like'%${loginName}%'");	
			pp.addSqlWhere("sYear", " and a.sYear like'%${sYear}%'");	
			System.out.println("sql       是"+sql);			
			pp.setWhichFieldIsValue(1);
			pp.setSQL(sql);
			pp.setOrderBy_CH("sDate");
			pp.setDirection("desc");
			pp.setTableID("conExmptinList");
			pp.setPageSize_CH("10");
			pp.setInputType("radio");

			pp.setWhichFieldIsValue(1);
			pp.setTitle("豁免学时");
			pp.addColumn("申报者", "LoginName","showCenter").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("性别", "sex","showCenter");
			pp.addColumn("申报年份", "sYear","showCenter");
			pp.addColumn("豁免学时内容", "EContent","showCenter");
			

			request.getSession().setAttribute(
					DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		modelandview.addObject("ctypetabname", ctypetabname.toLowerCase());
		return modelandview;

		}
	
	
	/** 
	  * 实现删除功能
	  * @param id
	  * @return  
	  */
	public ModelAndView deleteCotetExtion(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");
		Connection connection=null;  
		try {
			String id=request.getParameter("id"); 
			connection = new DBConnect().getConnect();
			ContentExemptionService contentExemptionService= new ContentExemptionService(connection);
			contentExemptionService.deleteCotetExtion(id);
	       
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(connection);   
		}	
		modelAndView.addObject("ctypetabname", ctypetabname.toLowerCase());
		
		return modelAndView;
	
	}
	
	
	/** 
	 *  点击新增实现页面跳转
	 * @param id
	 * @return approval 
	 */
	public ModelAndView addGo(HttpServletRequest request,HttpServletResponse response) throws Exception{	     
		ModelAndView modelandview = new ModelAndView(_SAVE);		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		ASFuntion as= new ASFuntion();
		String hour= as.getCurrentDate();                // 年-月-日		
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			modelandview.addObject("hour", hour);            //传值对象
			modelandview.addObject("add", "add");            //用来判断是否新增
			modelandview.addObject("ctypetabname", ctypetabname.toLowerCase());
			String sex = new DbUtil(conn).queryForString(" select sex from k_micfo where loginid = '"+loginid+"' and loginname = '"+loginname+"'  ");
			modelandview.addObject("sex", sex);            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
    	return modelandview;
	}
		
	 
	/** 
	 *  保存
	 * @param id
	 * @return Collection 
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,ContentExemption contentExemption) throws Exception{			
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);
		ASFuntion asf= new ASFuntion();
		Connection connection=null;			
		String add=request.getParameter("add");                             //用来判断是否执行增加
		String id=request.getParameter("id");   			
	
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctype = (String)map.get("ctype");  
		String loginid = (String)map.get("loginid"); 
		String loginName = (String)map.get("loginname");
		try {
					
			contentExemption.setsDate( asf.showNull(request.getParameter("sDate")));             //申报日期
			contentExemption.setSex(  asf.showNull(request.getParameter("sex")));                //性别
			contentExemption.setEContent( asf.showNull(request.getParameter("EConten")));       //豁免学时内容
			contentExemption.setsYear( asf.showNull(request.getParameter("sYear")));              //申报年份
			
			contentExemption.setEHelp( asf.showNull(request.getParameter("EHelp")));              //豁免学时详细说明		                             
			contentExemption.setsType(ctype);                                              //区分执业和非执业会员
			
			contentExemption.setLoginId(loginid);   
			contentExemption.setLoginName(loginName); 
			
			connection=new DBConnect().getConnect(); 
			ContentExemptionService contentExemptionService = new ContentExemptionService(connection);  
		
			if("add".equals(add)){     		
				contentExemption.setId(UUID.randomUUID().toString());                   
				contentExemptionService.addCnteExption(contentExemption);                				
	        }else{ 
	    	    contentExemption.setId(id);
				contentExemptionService.updateCnteExption(contentExemption);        											
			}	
			
		} catch (Exception e) {
			e.printStackTrace();		
		} finally{
			DbUtil.close(connection); 
		}
		return modelandview;
	}
	
	/** 
	 *点击修改按钮跳到修改页面
	 *  根据id查询一条记录
	 * @param id
	 * @return approval 
	 */
	public ModelAndView selectCteExtionId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 ModelAndView modelandview = new ModelAndView(_SAVE);
		 ContentExemption contentExemption =new ContentExemption();
		 Connection connection=null;
		 String id=request.getParameter("id"); 
		 try {
			connection= new DBConnect().getConnect(); 
			ContentExemptionService contentExemptionService = new ContentExemptionService(connection); 
			contentExemption=contentExemptionService.selectCteExtionId(id);
		 } catch (Exception e){
			e.printStackTrace();
		 } finally{
			DbUtil.close(connection); 
		 }	 		
		modelandview.addObject("contentExemption", contentExemption);  //传值对象
		return modelandview;
	}
	
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 ModelAndView modelandview = new ModelAndView(VIEW);
		 ContentExemption contentExemption =new ContentExemption();
		 Connection connection=null;
		 String id=request.getParameter("id"); 
		 try {
			connection= new DBConnect().getConnect(); 
			ContentExemptionService contentExemptionService = new ContentExemptionService(connection); 
			contentExemption=contentExemptionService.selectCteExtionId(id);
		 } catch (Exception e){
			e.printStackTrace();
		 } finally{
			DbUtil.close(connection); 
		 }	 		
		modelandview.addObject("contentExemption", contentExemption);  //传值对象
		return modelandview;
	}
}
