package cn.org.gdicpa.web.action.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
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
import cn.org.gdicpa.web.service.trainingHoldSelf.TrainingHoldSelfService;
import cn.org.gdicpa.web.service.user.UserService;

public class CompanyAction extends MultiActionController {

	private final String COMPANY_ADD_VIEW = "/company/addAndEdit.jsp";
	private final String COMPANY_ADD_VIEW1 = "/common/addAndEdit1.jsp";
	private final String MICFO_ADD_VIEW = "/common/add1.jsp";
	
	public ModelAndView micfoBaoBei(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(MICFO_ADD_VIEW);
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			 
			String tabname = "";
			String loginid = "";
			// 如果从报备 过来就 只能看 个人资料信息不能修改
			String baobei = CHF.showNull(request.getParameter("baobei"));	
			conn  = new DBConnect().getConnect();
			loginid = CHF.showNull(request.getParameter("loginid"));
			tabname = CHF.showNull(request.getParameter("ctypetabname"));	

			UserService user = new UserService(conn);
			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoSrc = "";
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("\\common\\attachFile\\K_Company") ;
			String fileTempName = loginid ; 
			userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
			userMap.put("lastmodified", CHF.getCurrentDate());
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			modelAndView.addObject("types",baobei);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(COMPANY_ADD_VIEW);
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			conn  = new DBConnect().getConnect();
			
			Map map = userSession.getUserMap();
			
			UserService user = new UserService(conn);
			
			String tabname = CHF.showNull((String)map.get("ctypetabname"));
			String loginid = CHF.showNull((String)map.get("loginid"));
			
			String baobei = CHF.showNull(request.getParameter("baobei"));
			if(baobei.equals("baobei")){
				modelAndView = new ModelAndView(COMPANY_ADD_VIEW1);
			}
			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoName = CHF.showNull((String)userMap.get("userphotoname"));
			
			String userPhotoSrc = userPhotoSrc = "/common/attachFile/K_Company/" + loginid;
			if(userPhotoName == null || "".equals(userPhotoName)){	
				//没有图片
				userPhotoSrc = "/images/comp.png";
			}
			
			System.out.println(this.getClass()+"  >>>>>>>>>>>>>>>    userPhotoSrc ="+userPhotoSrc);
			//CPA总数
			String cpaCount = new DbUtil(conn).queryForString(" select count(*) from K_Micfo Where State = ? and OfficeCode = ?",new Object[]{"0",loginid});
			
			String sql = "SELECT loginName FROM K_Micfo WHERE State='0' AND isShareholder='是' AND OfficeCode=?";
			//股东或合伙人总数
			int shareholderCount = 0;
			//股东或合伙人姓名
			String shareholderNames = "";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				shareholderCount++;
				shareholderNames +=rs.getString("loginName")+",";
			}
			shareholderNames = !"".equals(shareholderNames) ? shareholderNames.substring(0,shareholderNames.length()-1) : shareholderNames;
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			modelAndView.addObject("types",baobei);
			modelAndView.addObject("cpaCount",cpaCount);
			modelAndView.addObject("shareholderCount",shareholderCount);
			modelAndView.addObject("shareholderNames",shareholderNames);

			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
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
			
			String ctypetabname = CHF.showNull(request.getParameter("ctypetabname")); // 会员类型对应的表名
			
			if("k_company".equalsIgnoreCase(ctypetabname)){
				parameters.put("loginid",(String)userMap.get("loginid"));
			}
			
			String tableName = ctypetabname.split("\\_")[1].toLowerCase();
//			
//			String pwd_old = CHF.showNull(request.getParameter("pwd_old"));  //  旧密码
//			String pwd_one = CHF.showNull(request.getParameter("pwd_one"));  //  新密码
//			
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
			
			// 联系人手机号是否可以修改
			String linkphone = parameters.get("linkphone")+"";
			String linkphone_before = parameters.get("linkphone_before")+"";
			if(!linkphone.equals(linkphone_before)){
				parameters.put("linkphoneupdate", "N");
			}
			
			// 主任会计师手机号是否可以修改
			String corporatephone = parameters.get("corporatephone")+"";
			String corporatephone_bofore = parameters.get("corporatephone_bofore")+"";
			if(!corporatephone.equals(corporatephone_bofore)){
				parameters.put("corporatephoneupdate", "N");
			}			
			
			// 保存
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
			if("k_company".equalsIgnoreCase(ctypetabname)){
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+"/"+tableName+"/"+tableName+".do\"</script>");
			}else{
				out.println("<script>alert(\""+result+"\");window.location=\""+request.getContextPath()+"/common/micfoInfo.do?method=list\"</script>");
			}
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
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			String loginid = CHF.showNull((String)userMap.get("loginid"));  //  用户
			String uploadtemppath = myfileUpload.UploadFile(loginid, null);
			
			System.out.println(this.getClass()+"     | uploadtemppath="+uploadtemppath);
			
			Map parameters = myfileUpload.getMap();
			
			String userphotoname = loginid;

			String ctypetabname = CHF.showNull((String)userMap.get("ctypetabname"));    
			
			Foder foder  = new Foder("",request);
			String path = foder.createFoder("common\\attachFile\\K_Company") ;
			
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
			
			//更新数据库
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			
			String tabname = (String)userMap.get("ctypetabname");
			String result = user.savePhoto( tabname, loginid, uploadtemppath, parameters);
			
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
			String path = foder.createFoder("\\common\\attachFile\\K_Company") ;
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			String result = user.delPhoto(ctypetabname, loginid, path, userphotoname);
			
			if("".equals(result)){
				userMap.put("userphotoname", "");
				userMap.put("userphoto", null);
				userSession.setUserMap(userMap);
				request.getSession().setAttribute("userSession", userSession);
				
				result = "删除图片成功！";
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
		String ctypetabname = (String)userMap.get("ctypetabname");
		String officecode = (String)userMap.get("officecode");
		String sql = "";
		if("mainFrame".equals(p)){
			model = new ModelAndView("/company/mainFrame.jsp");
			try{
				conn  = new DBConnect().getConnect();
				 
				
				
				// 最新通知
				DocumentService ds = new DocumentService(conn);
				ArrayList noticeList = ds.get("b_notice", loginid, 5,ctypetabname,officecode);
				model.addObject("noticeList", noticeList);
				
				/**
				
				// 检查人员通知
				TesterNoticeService tns = new TesterNoticeService(conn);
				ArrayList testerNoticeList = tns.get();
				model.addObject("testerNoticeList", testerNoticeList);
				 * 
				 */
				
				
				// 最新培训
				sql = " select top 5 * from (select t.id,trainingName,substring(trainingdate,1,10) as trainingdate," 
					+ " teacher,curriculum,place,quote,term,areas,r.ctype,r.reader,"
					+ " substring(enrollbdate,1,10) as enrollbdate,substring(enrolledate,1,10) as enrolledate,expense," 
					+ " substring(expensebdate,1,10) as expensebdate,substring(expenseedate,1,10) as expenseedate,status,attachmentid," 
					+ " substring(trainingbdate,1,10) trainingbdate,substring(trainingedate,1,10) as trainingedate,  "
					+ " statustemp = case when enrollbdate is null then '审批中' " 
					+ " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
					+ " when convert(Varchar(10),getdate(),120) between enrollbdate and enrolledate " 
					+ " then '报名中' else '报名结束' end  " 
					+ " from b_training t left join b_reader r on t.id = r.nid " 
					+ " ) as t where statustemp!='审批中' and isnull(t.ctype,'')<>'k_micfono' and t.reader = '"+loginid+"' order by trainingbdate desc";
				
				
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
				
				//投票信息
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
				
				// 公文收文
				sql = " select top 5 a.*,c.name as agencyname from ( "
					+ " select d.id,caption = case when LEN(d.caption)>50 then substring(d.caption,1,50)+'...' else d.caption end," 
					+ " d.body,d.attachmentid,subString(d.ntime,1,10) as ntime,d.agency,d.loginname,d.reference,d.status,r.nid,r.source,r.reader,r.isview,r.viewtime "  
					+ " from b_document d left join b_reader r on d.id = r.nid where r.reader = '"+loginid+"' "
					+ " ) as a left join k_customer as c on a.agency=c.id order by a.ntime desc ";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List bdList = new ArrayList();
				RSMD = rs.getMetaData();
				while (rs.next()) {
					m = new HashMap();
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						m.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i)));
					}
					bdList.add(m);
				}
				model.addObject("bdList", bdList);
				
				// 对应事务所下的执业会员 
				TrainingHoldSelfService ts = new TrainingHoldSelfService(conn);
				String count = new ASFuntion().showNull(ts.getMicfosInCompany(loginid));
				int num = 0;
				System.out.println(this.getClass()+"          count1="+count);
				if(count!=null && !"".equals(count)){
					num = Integer.parseInt(count);
				}
				if(num>=30){
					count = "Y";
				}else{
					count = "N";
				}
				System.out.println(this.getClass()+"          count2="+count);
				request.getSession().setAttribute("micfocount", count);
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs);
				DbUtil.close(ps);
				DbUtil.close(conn);
			}
		}else{
			model = new ModelAndView("/company/addframe.jsp");
		}
		return model;
	}
	
	public ModelAndView updatePwds(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			Map userMap = userSession.getUserMap();
			
			ASFuntion CHF=new ASFuntion();
			
			Map parameters = new HashMap();
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
				if("".equals(result)){
					parameters.put("pwd", pwd_one);
				}
			}
			
			System.out.println(this.getClass()+"   result="+result+"    pwd_one="+pwd_one);
			
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
