package cn.org.gdicpa.web.action.applyTrainHourElse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

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
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.applyTrainHourElse.ApplyTrainHourElseService;
import cn.org.gdicpa.web.service.applyTrainHourElse.model.ApplyTrainHourElse;

/**
 * 其它学时申报 Action
 * 
 * @author YDZ
 * 
 */
public class ApplyTrainHourElseAction extends MultiActionController {
	private static final String LIST_VIEW = "/applyTrainHourElse/qList.jsp"; // list页面
	private static final String _SAVE = "/applyTrainHourElse/save.jsp";        //保存页面
	private static final String VIEW = "/applyTrainHourElse/view.jsp";        //保存页面

	
	/**
	 * List 方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView applyList(HttpServletRequest request,
			HttpServletResponse response) throws IOException { 
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname"); 
		String loginid = (String)map.get("loginid"); 
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);			
		try {

			String sql = " select" +
					     " a.id,a.loginid,a.loginName,a.applyHours," +
					     " b.Ctype,a.educationType,a.educationNote, a.applyDate,"+
						 " a.companyOpinion,a.societyOpinion,a.attachmentid,a.companyChecked,"+
						 " a.provinceChecked " +
						 " from XS_ApplyTrainHour a"+
						 " left join k_user b on a.loginid=b.loginid"+
					     " where 1=1 and a.Ctype='非执业会员' and a.loginid = '"+loginid+"' "+
			             " ${loginName}${applyHours}";
			
			         // 实现查询		
		   DataGridProperty pp = new DataGridProperty();
			pp.addSqlWhere("loginName", " and a.loginName like'%${loginName}%'");	
			pp.addSqlWhere("applyHours", " and a.applyHours like'%${applyHours}%'");	
					
			pp.setWhichFieldIsValue(1);
			pp.setSQL(sql);
			pp.setOrderBy_CH("applyDate");
			pp.setDirection("desc");
			pp.setTableID("aplyTinList");
			pp.setPageSize_CH("10");

			pp.setInputType("radio");

			pp.setWhichFieldIsValue(1);
			pp.setTitle("其它学时");
			pp.addColumn("申报者","loginName").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("会员证号","loginid","showCenter");
			pp.addColumn("申请时数","applyHours","showCenter");
			pp.addColumn("事务所意见","companyOpinion","showCenter");
			pp.addColumn("省注协意见","societyOpinion","showCenter");
			pp.addColumn("申请日期","applyDate","showCenter");

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
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");
		Connection connection=null;  
		try {
			String id=request.getParameter("id"); 
			connection = new DBConnect().getConnect();
			ApplyTrainHourElseService aElseService= new ApplyTrainHourElseService(connection);
			aElseService.deleteApplyElse(id);
	       
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
	 * @return FcontentExemption 
	 */
	public ModelAndView addGo(HttpServletRequest request,HttpServletResponse response) throws Exception{	     
		ModelAndView modelandview = new ModelAndView(_SAVE);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");
		ASFuntion as= new ASFuntion();
		String hour= as.getCurrentDate();                // 年-月-日		
		modelandview.addObject("hour", hour);            //传值对象
		modelandview.addObject("add", "add");            //用来判断是否新增
		modelandview.addObject("attachmentid",DELUnid.getNumUnid());            //用来判断是否新增
	    modelandview.addObject("ctypetabname",ctypetabname.toLowerCase() );
		return modelandview;
		
	 }
	


	/** 
	 *  保存
	 * @param id
	 * @return Collection 
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,ApplyTrainHourElse aTrainHourElse) throws Exception{			
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);
		ASFuntion asf= new ASFuntion();
		Connection connection=null;			
		String add=request.getParameter("add");                             //用来判断是否执行增加
		String id=request.getParameter("id");   			
		String hour= asf.getCurrentDate();                // 年-月-日		
		String attachmentid=request.getParameter("attachmentid");                             //用来判断是否执行增加
		String attachmentid1=request.getParameter("attachmentid1");   			
		
		System.out.println("attachmentid="+attachmentid+"    attachmentid1="+attachmentid1);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctype = (String)map.get("ctype");   
		String loginid = (String)map.get("loginid"); 
		String loginName = (String)map.get("loginname");
		try {
					
			aTrainHourElse.setApplyHours(asf.showNull(request.getParameter("applyHours")));           
			aTrainHourElse.setEducationType(asf.showNull(request.getParameter("educationType")));              
			aTrainHourElse.setCompanyChecked("等待审核");
			aTrainHourElse.setProvinceChecked("等待审核");
			
			aTrainHourElse.setCompanyOpinion(asf.showNull(request.getParameter("companyOpinion")));                                          
			aTrainHourElse.setSocietyOpinion(asf.showNull(request.getParameter("societyOpinion"))); 
			aTrainHourElse.setEducationNote( asf.showNull(request.getParameter("educationNote"))); 

			aTrainHourElse.setApplyDate(hour);  //申请日期
			aTrainHourElse.setCtype(ctype);   
			aTrainHourElse.setLoginid(loginid);
			aTrainHourElse.setLoginName(loginName);
			
			connection=new DBConnect().getConnect(); 
			ApplyTrainHourElseService aElseService= new ApplyTrainHourElseService(connection);
			
		    if("".equals(id) || null == id){    //相等执行    INSERT		
			   aTrainHourElse.setId(UUID.randomUUID().toString());       
			   aTrainHourElse.setAttachmentid(attachmentid1);
			   aElseService.addApplyTrain(aTrainHourElse);                          				
	        }else{ 
	    	   aTrainHourElse.setId(id);
	    	   aTrainHourElse.setAttachmentid(attachmentid);
	    	   aElseService.updateCnteExpElse(aTrainHourElse);                      											
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
		 ApplyTrainHourElse aTrainHourElse =new ApplyTrainHourElse();
		 Connection connection=null;
         String id=request.getParameter("id");
         try {
			connection= new DBConnect().getConnect(); 
			ApplyTrainHourElseService aElseService= new ApplyTrainHourElseService(connection); 
			aTrainHourElse=aElseService.getAplyTrHTaElseById(id);
         } catch (Exception e){
			e.printStackTrace();
         } finally{
			DbUtil.close(connection); 
         }
		modelandview.addObject("aTrainHourElse", aTrainHourElse);  //传值对象
		return modelandview;
	}
	
	 
	/**
	 * 得到审核状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewState(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection connection = null;
		String id = request.getParameter("id");
		PrintWriter out = null ;
		try {
			connection = new DBConnect().getConnect();
		 	ApplyTrainHourElse aHourElse = new ApplyTrainHourElseService(connection).getAplyTrHTaElseById(id);
		 	response.setContentType("text/html;charset=UTF-8") ;
		 	out = response.getWriter() ;
		 	if(aHourElse.getId()!=null){
			 	if("通过".equals(aHourElse.getCompanyChecked()) || "通过".equals(aHourElse.getProvinceChecked())){
			 		out.print("N");
			 	}else{
			 		out.print("Y");
			 	}
		 	}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(connection);
		}
		return null;
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
		 ApplyTrainHourElse aTrainHourElse =new ApplyTrainHourElse();
		 Connection connection=null;
         String id=request.getParameter("id");
         try {
			connection= new DBConnect().getConnect(); 
			ApplyTrainHourElseService aElseService= new ApplyTrainHourElseService(connection); 
			aTrainHourElse=aElseService.getAplyTrHTaElseById(id);
         } catch (Exception e){
			e.printStackTrace();
         } finally{
			DbUtil.close(connection); 
         }
		modelandview.addObject("aTrainHourElse", aTrainHourElse);  //传值对象
		return modelandview;
	}
	
	
}
