package cn.org.gdicpa.web.action.cicpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.user.UserService;


public class CicpaAction extends MultiActionController {

//	private final String CICPA_VIEW = "cicpa/list.jsp";
	private final String CICPA_ADD_VIEW = "/cicpa/add.jsp";
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(CICPA_ADD_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			conn  = new DBConnect().getConnect();
			
			Map map = userSession.getUserMap();
			
			UserService user = new UserService(conn);
			
			String tabname = (String)map.get("ctypetabname");
			String loginid = (String)map.get("loginid");
			
			Map userMap = user.getUser( tabname, loginid);
			
			InputStream input = (InputStream)userMap.get("userphoto");
			String userPhotoName = CHF.showNull((String)userMap.get("userphotoname"));
			
			String userPhotoSrc = "";
			if(input != null){	//已经有个人图片了
				if("".equals(userPhotoName)){//没有显示的名字,要重新生成
					Foder foder  = new Foder("",request);
					String newPath = foder.createFoder("photo") ;
					String fileTempName = DELUnid.getNumUnid()  ; 
					user.getPhoto(tabname, loginid, newPath,fileTempName);
					userPhotoSrc = "/photo/" + fileTempName;
				}else{
					userPhotoSrc = "/photo/" + userPhotoName;
				}
				
				input.close();			
			}else{	//没有图片
				userPhotoSrc = "/images/noPhoto.gif";
			}
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			

			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
	/**
	 * 修改用户信息
	 */
	public ModelAndView updateSave(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			
			ASFuntion CHF=new ASFuntion();
			
			Map parameters = new HashMap();
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				parameters.put(paramName, paramValue);
			
			}
			
			parameters.put("loginid",(String)userMap.get("loginid"));
			
			String ctypetabname = CHF.showNull(request.getParameter("ctypetabname")); // 会员类型对应的表名
			String tableName = ctypetabname.split("\\_")[1].toLowerCase();
			
			String pwd_old = CHF.showNull(request.getParameter("pwd_old"));  //  旧密码
			String pwd_one = CHF.showNull(request.getParameter("pwd_one"));  //  新密码
			
			conn  = new DBConnect().getConnect();
			String result = "" ,result1 = "",result2 = "";
			UserService user = new UserService(conn);
			
			//修改密码
			if(!"".equals(pwd_one)){
				result1 = user.updatePwd(ctypetabname, (String)userMap.get("loginid"), pwd_one, pwd_old);
				if("".equals(result1)){
					parameters.put("pwd", pwd_one);
				}
			}
			
//			Set coll = userMap.keySet();
//			for (Iterator iter = coll.iterator(); iter.hasNext();) {
//				String key = (String) iter.next();
//				if(!"loginid".equals(key) 
//					&& !"pwd".equals(key)
//					&& !"userphoto".equals(key)
//					&& !"userphotoname".equals(key)
//					){
//					String paramValue = request.getParameter(key);
//					if(paramValue != null && !"".equals(paramValue)){
//						userMap.put(key,paramValue);
//					}
//				}
//				
//			}
			
			result2 = user.saveInfo(parameters);
			if("".equals(result1)){ //修改密码成功
				if("".equals(result2)){//修改个人信息成功
//					userSession.setUserMap(userMap);
//					request.getSession().setAttribute("userSession", userSession);
					result = "修改个人信息成功!";
				}else{//修改个人信息失败
					result = result2;
				}
			}else{ 	//修改密码失败
				result = result1;
				if("".equals(result2)){//修改个人信息成功
//					userSession.setUserMap(userMap);
//					request.getSession().setAttribute("userSession", userSession);
				}
			}
			
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+ "/" + tableName + "/" + tableName + ".do\"</script>");
			out.close();
			return null;
//			return index( request,  response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
	}
	
	/**
	 * 用于［密码建议］
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView Help(HttpServletRequest request, HttpServletResponse response) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String ctypetabname = (String)userMap.get("ctypetabname"); // 会员类型对应的表名
		String tableName = ctypetabname.split("\\_")[1].toLowerCase();
		
		return new ModelAndView("/"+tableName+"/PasswordHelp.jsp");
	}
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			String uploadtemppath = myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			
			String tabname = (String)userMap.get("ctypetabname");
			String loginid = (String)userMap.get("loginid");
			
			String result = user.savePhoto( tabname, loginid, uploadtemppath, parameters);
			
			String trace = uploadtemppath + (String) parameters.get("filename");
			File file = new File(trace);  
			
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("photo") ;
			String fileTempName = DELUnid.getNumUnid() ; 
			String str = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
			if("".equals(str)){
				userMap.put("userphoto",  new FileInputStream(file));
				userMap.put("userphotoname", fileTempName);
				userSession.setUserMap(userMap);
				request.getSession().setAttribute("userSession", userSession);
			}
			
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.println("<script>window.parent.changePhoto('"+fileTempName+"');alert(\""+result+"\");</script>");
			out.close() ;
			
			return null;	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
	/**
	 * 删除个人图片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deletePhoto(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			Map userMap = userSession.getUserMap();
			
			String userphotoname = CHF.showNull(request.getParameter("userphotoname"));  //图片  
			String loginid = CHF.showNull(request.getParameter("loginid"));  //  用户
			String ctypetabname = CHF.showNull(request.getParameter("ctypetabname"));    
			
			Foder foder  = new Foder("",request);
			String path = foder.createFoder("photo") ;
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			String result = user.delPhoto(ctypetabname, loginid, path, userphotoname);
			
			if("".equals(result)){
				userMap.put("userphotoname", "");
				userMap.put("userphoto", null);
				userSession.setUserMap(userMap);
				request.getSession().setAttribute("userSession", userSession);
				
				result = "删除个人图片成功！";
			}
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.println(result);
			out.close() ;
			
			return null;	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}	
	}
	
	
}
