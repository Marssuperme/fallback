package cn.org.gdicpa.web.action.micfoApplyTrainHour;

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
import cn.org.gdicpa.web.service.micfoApplyTrainHour.MicfoApplyTrainHourService;
import cn.org.gdicpa.web.service.micfoApplyTrainHour.model.MicfoApplyTrainHour;

/**
 * 职业会员的其它学时申报 Action
 * 
 * @author YDZ
 * 
 */
public class MicfoApplyTrainHourAction  extends MultiActionController{
	private static final String LIST_VIEW = "/micfoApplyTrainHour/list.jsp"; // list页面
	private static final String _SAVE = "/micfoApplyTrainHour/save.jsp";        //保存页面
   
	/**
	 * List 方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws IOException { 		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
	
		String ctypetabname = (String)map.get("ctypetabname"); 
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);			
		try {

			String sql = " select" +
					     " a.id,a.loginid,a.loginName,a.applyHours," +
					     " b.Ctype,a.educationType,a.educationNote, a.applyDate,"+
						 " a.companyOpinion,a.societyOpinion,a.attachmentid,a.companyChecked,"+
						 " a.provinceChecked " +
						 " from XS_ApplyTrainHour a"+
						 " left join k_user b on a.loginid=b.loginid"+
					     " where 1=1 and isnull(a.Ctype,'')!='非执业会员'"+
			            " ${loginName} ${applyHours}";

			
	         // 实现查询		
		    DataGridProperty pp = new DataGridProperty();
			pp.addSqlWhere("loginName", " and a.loginName like'%${loginName}%'");	
			pp.addSqlWhere("applyHours", " and a.applyHours like'%${applyHours}%'");	
					
			pp.setWhichFieldIsValue(1);
			pp.setSQL(sql);
			pp.setOrderBy_CH("applyDate");
			pp.setDirection("desc");
			pp.setTableID("mTrainHourList");
			pp.setInputType("radio");

			pp.setWhichFieldIsValue(1);
			pp.setTitle("执业会员其它学时申报");
			pp.addColumn("申报者","loginName","showCenter");
			pp.addColumn("会员证号","loginid","showCenter");
			pp.addColumn("申请时数","applyHours","showCenter");
			pp.addColumn("事务所意见","companyOpinion","showCenter");
			pp.addColumn("省注协意见","societyOpinion","showCenter");
			pp.addColumn("继续教育情况说明","educationNote","showCenter");
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
	public ModelAndView deletemTrainHour(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");
		Connection connection=null;  
		try {
			String id=request.getParameter("id"); 
			connection = new DBConnect().getConnect();
			MicfoApplyTrainHourService mHourService= new MicfoApplyTrainHourService(connection);
			mHourService.deletemTrainHourId(id);
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
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
		modelandview.addObject("attachmentid", DELUnid.getNumUnid());
	    modelandview.addObject("ctypetabname",ctypetabname.toLowerCase() );
		return modelandview;
		
	 }
	


	/** 
	 *  保存
	 * @param id
	 * @return Collection 
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,MicfoApplyTrainHour mTrainHour) throws Exception{			
		ModelAndView modelandview = new ModelAndView(LIST_VIEW);
		ASFuntion asf= new ASFuntion();
		Connection connection=null;			
		String add=request.getParameter("add");                             //用来判断是否执行增加
		String id=request.getParameter("id");   			
		String hour= asf.getDateAndTime1();                                  // 年-月-日		
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname");     
		String loginid = (String)map.get("loginid"); 
		String loginName = (String)map.get("loginname");
		try {
					
			mTrainHour.setApplyHours(asf.showNull(request.getParameter("applyHours")));           
			mTrainHour.setEducationType(asf.showNull(request.getParameter("educationType")));              
			mTrainHour.setCompanyChecked("等待审核");
			mTrainHour.setProvinceChecked("等待审核");
			
			mTrainHour.setCompanyOpinion(asf.showNull(request.getParameter("companyOpinion")));                                          
			mTrainHour.setSocietyOpinion(asf.showNull(request.getParameter("societyOpinion"))); 
			mTrainHour.setEducationNote( asf.showNull(request.getParameter("educationNote")));
			
			mTrainHour.setProperty1(asf.showNull(request.getParameter("property1")));
			mTrainHour.setProperty2(asf.showNull(request.getParameter("property2")));
			mTrainHour.setApplyDate(hour);  //申请日期
			
			mTrainHour.setCtype(ctypetabname);   
			mTrainHour.setLoginid(loginid);
			mTrainHour.setLoginName(loginName);
			
			connection=new DBConnect().getConnect(); 
			MicfoApplyTrainHourService mHourService= new MicfoApplyTrainHourService(connection);
			
			   if("add".equals(add)){    //相等执行    INSERT		
				   mTrainHour.setId(UUID.randomUUID().toString());       		
				   mHourService.addmTrainHour(mTrainHour);                         //新增					
		       }else{ 
		    	   mTrainHour.setId(id);
		    	   mHourService.updatemTrainHour(mTrainHour);                      //执行UPDATE													
				}	
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		finally{
			DbUtil.close(connection); 
		}
	      modelandview.addObject("ctypetabname", ctypetabname.toLowerCase());
		return modelandview;
		}
	
	/** 
	 *点击修改按钮跳到修改页面
	 *  根据id查询一条记录
	 * @param id
	 * @return approval 
	 */
	public ModelAndView selectmTrainHourId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 ModelAndView modelandview = new ModelAndView(_SAVE);
		 MicfoApplyTrainHour mTrainHour =new MicfoApplyTrainHour();
		 Connection connection=null;
         String id=request.getParameter("id");
         try {
			connection= new DBConnect().getConnect(); 
			MicfoApplyTrainHourService mHourService= new MicfoApplyTrainHourService(connection); 
			mTrainHour=mHourService.selectmTrainHourId(id);
         } catch (Exception e){
			
			e.printStackTrace();
         } finally{
			DbUtil.close(connection); 
         }	 		
		modelandview.addObject("mTrainHour", mTrainHour);  //传值对象
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
			MicfoApplyTrainHour mTrainHour = new MicfoApplyTrainHourService(connection).selectmTrainHourId(id);
		 	response.setContentType("text/html;charset=UTF-8") ;
		 	out = response.getWriter() ;
		 	if(mTrainHour.getId()!=null){
			 	if("通过".equals(mTrainHour.getCompanyChecked()) || "通过".equals(mTrainHour.getProvinceChecked())){
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
	
	
}
