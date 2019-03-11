package cn.org.gdicpa.web.action.contentExemptionNot;

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
import cn.org.gdicpa.web.service.contentExemptionNot.ContentExemptionNotService;
import cn.org.gdicpa.web.service.contentExemptionNot.model.ContentExemptionNot;

/**
 * 非职业豁免学时申报 Action
 * 
 * @author YDZ
 * 
 */
public class ContentExemptionNotAction extends MultiActionController {
	private static final String fLIST_VIEW = "/contentExemptionNot/flist.jsp"; // list页面
	private static final String _SAVE = "/contentExemptionNot/save.jsp";        //保存页面
	private static final String VIEW = "/contentExemptionNot/view.jsp";        

	
	/**
	 * List 方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView fList(HttpServletRequest request,
			HttpServletResponse response) throws IOException { 
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname"); 
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		ModelAndView modelandview = new ModelAndView(fLIST_VIEW);			
		try {

			String sql = " select a.ID,a.LoginId,a.LoginName,a.sex,a.sDate,a.sYear,"
					   + " a.EContent,a.EHelp,a.Status,b.Ctype ,a.sType,a.InitFlag,a.imeFlag "
					   + " from XS_ContentExemption a" 
					   + " left join k_user b on a.LoginId=b.loginid"
					   + " where 1=1 and sType='非执业会员' and a.loginid = '"+loginid+"' and a.loginname = '"+loginname+"' "
			           + " ${loginName}";
			// 实现查询		
		 DataGridProperty pp = new DataGridProperty();
			pp.addSqlWhere("loginName", " and a.LoginName like'%${loginName}%'");		
			System.out.println("Fsql       是："+sql);			
			pp.setWhichFieldIsValue(1);
			pp.setSQL(sql);
			pp.setOrderBy_CH("sDate");
			pp.setDirection("desc");
			pp.setTableID("FconExemList");
			pp.setInputType("radio");
			pp.setPageSize_CH("10");


			pp.setWhichFieldIsValue(1); 
			pp.setTitle("非执业豁免学时");
			pp.addColumn("申报者","LoginName").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("性别","sex","showCenter");
			pp.addColumn("申报年份","sYear","showCenter");
			pp.addColumn("豁免学时内容","EContent","showCenter");

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
	public ModelAndView deleteFcotetExtion(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView(fLIST_VIEW);
		
		Connection connection=null;  
		try {
			String id=request.getParameter("id"); 
			connection = new DBConnect().getConnect();
			ContentExemptionNotService cExemptionNotService= new ContentExemptionNotService(connection);
			cExemptionNotService.deleteFcotetNot(id);
	       
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(connection);   
		}	
		return modelAndView;
	}
	
	
	/** 
	 *  点击新增实现页面跳转
	 * @param id
	 * @return FcontentExemption 
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
		    modelandview.addObject("ctypetabname",ctypetabname.toLowerCase() );
			String sex = new DbUtil(conn).queryForString(" select sex from k_micfono where loginid = '"+loginid+"' and loginname = '"+loginname+"'  ");
			modelandview.addObject("sex", sex);
		} catch (Exception e){
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
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,ContentExemptionNot cExemptionNot) throws Exception{			
		ModelAndView modelandview = new ModelAndView(fLIST_VIEW);
		ASFuntion asf= new ASFuntion();
		Connection connection=null;			
		String add=request.getParameter("add");                             //用来判断是否执行增加
		String id=request.getParameter("id");   			
	
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctype");
		String loginid = (String)map.get("loginid"); 
		String loginName = (String)map.get("loginname");
		try {
					
			cExemptionNot.setsDate( asf.showNull(request.getParameter("sDate")));              //申报日期
			cExemptionNot.setSex(  asf.showNull(request.getParameter("sex")));                 //性别
			cExemptionNot.setEContent( asf.showNull(request.getParameter("EConten")));         //豁免学时内容
			cExemptionNot.setsYear( asf.showNull(request.getParameter("sYear")));              //申报年份
			
			cExemptionNot.setEHelp( asf.showNull(request.getParameter("EHelp")));              //豁免学时详细说明		                             
			cExemptionNot.setsType(ctypetabname);                                              //区分执业和非执业会员
			cExemptionNot.setLoginId(loginid);   
			cExemptionNot.setLoginName(loginName); 
			
			cExemptionNot.setStatus(asf.showNull(request.getParameter("status")));              //写死
			connection=new DBConnect().getConnect(); 
			ContentExemptionNotService cExemptionNotService= new ContentExemptionNotService(connection);
		
		   if("add".equals(add)){    //相等执行    INSERT		
			   cExemptionNot.setId(UUID.randomUUID().toString());                            
		
			   cExemptionNotService.addFcnteExption(cExemptionNot);                          				
	       }else{ 
	    	   cExemptionNot.setId(id);
	    	   cExemptionNotService.updateFcnteExption(cExemptionNot);                       												
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
		 ContentExemptionNot cExemptionNot =new ContentExemptionNot();
		 Connection connection=null;
         String id=request.getParameter("id");
         try {
			connection= new DBConnect().getConnect(); 
			ContentExemptionNotService cExemptionNotService= new ContentExemptionNotService(connection); 
			cExemptionNot=cExemptionNotService.selectCteNotId(id) ;
         } catch (Exception e){
			
			e.printStackTrace();
         } finally{
			DbUtil.close(connection); 
         }	 		
		modelandview.addObject("cExemptionNot", cExemptionNot);  //传值对象
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
		 ContentExemptionNot cExemptionNot =new ContentExemptionNot();
		 Connection connection=null;
         String id=request.getParameter("id");
         try {
			connection= new DBConnect().getConnect(); 
			ContentExemptionNotService cExemptionNotService= new ContentExemptionNotService(connection); 
			cExemptionNot=cExemptionNotService.selectCteNotId(id) ;
         } catch (Exception e){
			e.printStackTrace();
         } finally{
			DbUtil.close(connection); 
         }	 		
		modelandview.addObject("cExemptionNot", cExemptionNot);  //传值对象
		return modelandview;
	}
	
}
