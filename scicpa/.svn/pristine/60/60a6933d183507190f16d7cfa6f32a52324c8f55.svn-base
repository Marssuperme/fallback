package cn.org.gdicpa.web.action.micfono;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.document.DocumentService;
import cn.org.gdicpa.web.service.question.model.Question;
import cn.org.gdicpa.web.service.user.UserService;


public class MicfonoAction extends MultiActionController {

	private final String MICFONO_ADD_VIEW = "/micfono/add.jsp";
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(MICFONO_ADD_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			conn  = new DBConnect().getConnect();
			
			Map map = userSession.getUserMap();
			
			UserService user = new UserService(conn);
			
			String tabname = (String)map.get("ctypetabname");
			String loginid = (String)map.get("loginid");
			
			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoSrc = "";
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("\\common\\attachFile\\K_MicfoNo");
			String fileTempName = loginid  ; 
			userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
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
			
//			String pwd_old = CHF.showNull(request.getParameter("pwd_old"));  //  旧密码
//			String pwd_one = CHF.showNull(request.getParameter("pwd_one"));  //  新密码
			
			conn  = new DBConnect().getConnect();
			String result = "" ,result1 = "",result2 = "";
			UserService user = new UserService(conn);
			
//			//修改密码
//			if(!"".equals(pwd_one)){
//				result1 = user.updatePwd(ctypetabname, (String)userMap.get("loginid"), pwd_one, pwd_old);
//				if("".equals(result1)){
//					parameters.put("pwd", pwd_one);
//				}
//			}
			
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
			
			System.out.println("sssssss  approval = "+parameters.get("approval"));
			
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
			out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+"/" + tableName + "/" + tableName+".do\"</script>");
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
			ASFuntion CHF=new ASFuntion();
			String loginid = CHF.showNull((String)userMap.get("loginid"));  //  用户
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			String uploadtemppath = myfileUpload.UploadFile(loginid, null);
			Map parameters = myfileUpload.getMap();
			
			String userphotoname = loginid;  //图片  
			String ctypetabname = CHF.showNull((String)userMap.get("ctypetabname"));    
			
			Foder foder  = new Foder("",request);
			String path = foder.createFoder("common\\attachFile\\K_MicfoNo");
			
			// 先删除原来的图片
			File newFile = new File(path+"\\"+loginid) ;
			System.out.println("qwh:"+path);
			if(newFile.exists()) {
				newFile.delete();
			}
			
			//把文件从临时文件夹中拷走
			FileInputStream input=null;
			FileOutputStream output=null;
			try{
				File tempFile = new File(uploadtemppath+"\\"+userphotoname) ;
				input = new FileInputStream(tempFile);
				output = new FileOutputStream(path+"\\"+loginid);
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				
				//拷	贝后删除临时文件夹里的文件 
				tempFile.delete() ;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				output.close();
				input.close();	
			}
			
			//保存数据库
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			String result = user.savePhoto( ctypetabname, loginid, uploadtemppath, parameters);
			
			//更新SESSION
			userMap.put("userphotoname", loginid);
			userSession.setUserMap(userMap);
			request.getSession().setAttribute("userSession", userSession);
			
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.println("<script>window.parent.changePhoto('"+loginid+"');alert(\""+result+"\");</script>");
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
			String path = foder.createFoder("\\common\\attachFile\\K_MicfoNo");
			
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
	
	/**
	 * 去框架页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public ModelAndView goAddFrame(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		String p = request.getParameter("param");
		System.out.println(this.getClass()+"     >>>>>>>>>>>>>>>>>>goAddFrame       p = "+p);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ModelAndView model = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map userMap = userSession.getUserMap();
		String loginid = (String)userMap.get("loginid");
		String sql = "";
		if("mainFrame".equals(p)){
			model = new ModelAndView("/micfono/mainFrame.jsp");
			try{
				conn  = new DBConnect().getConnect();
				// 我的问题
				sql = " select top 5 id,ctype,typeid,title,question,userid,createDate,state,fullPath,isnull(b.answerCount,'0') as answerCount"
					+ " from p_question a left join (" 
					+ " 	select a.questionid,count(*) as answerCount from p_answer a  group by a.questionid" 
					+ " ) b on a.id = b.questionid" 
					+ " where userid = ?  order by createDate desc";
				ps = conn.prepareStatement(sql);
				ps.setString(1, loginid);
				rs = ps.executeQuery();
				List<Question> qlist = new ArrayList<Question>();
				while(rs.next()){
					Question q = new Question();
					q.setId(rs.getString(1));
					q.setTitle(rs.getString(4));
					q.setCreateDate(rs.getString(7));
					q.setState(rs.getString(8));
					q.setAnswerCount(rs.getString(10));
					qlist.add(q);
				}
				model.addObject("qlist", qlist);
				
				// 最新通知
				DocumentService ds = new DocumentService(conn);
				ArrayList noticeList = ds.getForMicfono("b_notice", loginid, 5);
				model.addObject("noticeList", noticeList);
				
				
				// 最新培训
				/**
				 * 1.如果是注师，且合伙人字段为是，就可以看到全部课程；
				 * 2.如果只是注师，就可以看到（注师班，普通班）
				 * 3.如果只是非执业会员，就只能看到普通班内容；
				 */

				sql = " select top 5 * from (" 
					+ " select id,trainingName,subString(trainingdate,1,10) as trainingdate," 
					+ " teacher,curriculum,place,quote,term,areas,ctype,"
					+ " subString(enrollbdate,1,10) as enrollbdate,subString(enrolledate,1,10) as enrolledate,expense," 
					+ " subString(expensebdate,1,10) as expensebdate,subString(expenseedate,1,10) as expenseedate,status," 
					+ " attachmentid,traintype,subString(trainingbdate,1,10) as trainingbdate,subString(trainingedate,1,10) as trainingedate, "
					+ " statustemp = case when enrollbdate is null then '审批中' " 
					+ " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
					+ " when convert(Varchar(10),getdate(),120) between enrollbdate and enrolledate " 
					+ " then '报名中' else '报名结束' end  " 
					+ " from b_training ) t " 
					+ " where statustemp != '审批中' and ctype='k_micfono' order by trainingbdate desc";
			
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List nlist = new ArrayList();
				Map m = null;
				ResultSetMetaData RSMD = rs.getMetaData();
				while(rs.next()){
					m = new HashMap();
					for (int i = 1; i <= RSMD.getColumnCount();i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i)));
					}
					nlist.add(m);
				}
				
				model.addObject("nlist", nlist);
				
				// 最新等待回答的问题
				sql = " select top 5 id,title,subString(createDate,1,10) as createDate,state,isnull(b.answerCount,'0') as answerCount"
					+ " from p_question a left join ( " 
					+  "	select a.questionid,count(*) as answerCount from p_answer a  group by a.questionid" 
					+  ") b on a.id = b.questionid" 
					+  " where state = '未解决' order by createDate desc";
System.out.println("###"+sql);				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List nqlist = new ArrayList();
				RSMD = rs.getMetaData();
				while(rs.next()){
					m = new HashMap(); 
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
					}
					nqlist.add(m);
				}
				model.addObject("nqlist", nqlist);
				
				
				// 最新实习
				sql = " select top 5 t.topicID,t.topicName,subString(t.dateandtime,1,10) as dateandtime,k.loginname from " 
					+ " b_topic as t left join k_user  as k" 
					+ " on t.loginid = k.loginid where t.btype = '实习' and k.ctypetabname not in ('k_micfo','k_micfono') order by dateandtime desc";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List topicList = new ArrayList();
				RSMD = rs.getMetaData();
				while(rs.next()){
					m = new HashMap();
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
					}
					topicList.add(m);
				}
				model.addObject("topicList", topicList);
				
				
				// 最新招聘
				sql = " select top 5 t.topicID,t.topicName,subString(t.dateandtime,1,10) as dateandtime,k.loginname from " 
					+ " b_topic as t left join k_user  as k" 
					+ " on t.loginid = k.loginid where t.btype = '招聘' and k.ctypetabname not in ('k_micfo','k_micfono') order by dateandtime desc";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List zpList = new ArrayList();
				RSMD = rs.getMetaData();
				while(rs.next()){
					m = new HashMap();
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
					}
					zpList.add(m);
				}
				model.addObject("zpList", zpList);
				
				// 投票信息
				sql = "select top 1 * from k_ticket " +
				"	WHERE (tcenddate >= convert(varchar(10),getdate(),120))  " +
				"	and ', '+fillarea+',' like '%, " + loginid + ",%' " +
				"	order by tcenddate,id desc";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List tpList = new ArrayList();
				RSMD = rs.getMetaData();
				while(rs.next()){
					m = new HashMap();
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
					}
					tpList.add(m);
				}
				model.addObject("tpList", tpList);
				
											
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs);
				DbUtil.close(ps);
				DbUtil.close(conn);
			}
		}else{
			model = new ModelAndView("/micfono/addframe.jsp");
		}
		 
		 return model;
	}
	
	

	/**
	 * 修改密码
	 */
	public ModelAndView updatePwds(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			
			ASFuntion CHF=new ASFuntion();
			
			String ctypetabname = CHF.showNull(request.getParameter("ctypetabname")); // 会员类型对应的表名
			String tableName = ctypetabname.split("\\_")[1].toLowerCase();
			
			String pwd_old = CHF.showNull(request.getParameter("pwd_old"));  //  旧密码
			String pwd_one = CHF.showNull(request.getParameter("pwd_one"));  //  新密码
			
			System.out.println(this.getClass()+"    |ctypetabname="+ctypetabname+"|pwd_old="+pwd_old+"|pwd_one="+pwd_one);
			
			conn  = new DBConnect().getConnect();
			String result = "";
			UserService user = new UserService(conn);
			
			//修改密码
			if(!"".equals(pwd_one)){
				result = user.updatePwd(ctypetabname, (String)userMap.get("loginid"), pwd_one, pwd_old);
			}
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println(result);
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
}
