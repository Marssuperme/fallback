package cn.org.gdicpa.web.action.micfoInfo;

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
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.user.UserService;

public class MicfoInfoAction extends MultiActionController{
	private final String MICFO_LIST_VIEW = "/micfo/list.jsp";
	private final String MICFO_AddAndEdit_VIEW = "/micfo/addAndEdit2.jsp";

	/**
	 * list
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(MICFO_LIST_VIEW);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		
		try {
			String sql = " select * from k_micfo where state='0' and officecode = '"+loginid+"'";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("注师信息");
			 
			pp.setInputType("radio");
			pp.setTableID("micfo");
			pp.setWhichFieldIsValue(1);
			
			/*姓名、CPA号、性别、身份证号、全科合格证号（考核批准文号）、学历 */
			pp.addColumn("注师名称", "loginname","showCenter");
			pp.addColumn("CPA号", "cpano","showCenter");
			pp.addColumn("性别", "sex","showCenter");
			pp.addColumn("身份证号","idnumber","showCenter");
			pp.addColumn("全科合格证号或考核批准文号", "certificate", "showCenter");
			pp.addColumn("学历", "diploma", "showCenter");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("loginname");
			pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(MICFO_AddAndEdit_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			conn  = new DBConnect().getConnect();
			
			Map map = userSession.getUserMap();
			
			UserService user = new UserService(conn);
			
			String tabname = "K_Micfo";
			String loginid = request.getParameter("loginid");
			
			System.out.println(this.getClass()+"        loginid="+loginid);
			
			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoSrc = "";
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("\\common\\attachFile\\K_Micfo");
			String fileTempName = loginid ; 
			userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
			userMap.put("lastmodified", CHF.getCurrentDate());
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			modelAndView.addObject("tabname",tabname);
			modelAndView.addObject("loginid",loginid);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
}
