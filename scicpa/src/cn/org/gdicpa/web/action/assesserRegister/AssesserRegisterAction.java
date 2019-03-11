package cn.org.gdicpa.web.action.assesserRegister;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.service.assesserRegister.AssesserRegisterService;
import cn.org.gdicpa.web.service.assesserRegister.model.AssesserRegister;
import cn.org.gdicpa.web.service.candidates.CandidateService;
import cn.org.gdicpa.web.service.candidates.model.Candidates;

public class AssesserRegisterAction extends MultiActionController{
	private static final String LIST = "/assesserRegister/list.jsp";
	private static final String ADDANDEDIT = "/assesserRegister/addAndEdit.jsp";
	private static final String REGIST = "/assesserRegister/regist.jsp";
	private static final String SEARCH = "/assesserRegister/search.jsp";
	private static final String PRINT = "/assesserRegister/print.jsp";
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"     index........");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String ctypetabname = (String)map.get("ctypetabname"); 
		
		
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql = " select * from k_assesserRegister "
				+ " where officeCode = '"+loginid+"' ${loginName} ${idnumber} ${certificate}";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String loginName = getRequestValue("loginName");
					String idnumber = getRequestValue("idnumber");
					String certificate = getRequestValue("certificate");
					
					if(loginName != null && !"".equals(loginName)) {
						loginName = " and loginName like '%"+loginName+"%'";
					} 
					if(idnumber != null && !"".equals(idnumber)) {
						idnumber = " and idnumber like '%"+idnumber+"%'";
					}
					if(certificate != null && !"".equals(certificate)) {
						certificate = " and certificate like '%"+certificate+"%'";
					} 
					this.setOrAddRequestValue("loginName", loginName);
					this.setOrAddRequestValue("idnumber", idnumber);
					this.setOrAddRequestValue("certificate", certificate);
				}
			};
			pp.setInputType("radio");
			
			pp.addSqlWhere("loginName","${loginName}") ;
			pp.addSqlWhere("idnumber","${idnumber}") ;
			pp.addSqlWhere("certificate","${certificate}") ;
			
			pp.setTableID("assesserRegister");
			pp.setWhichFieldIsValue(1);
			
			pp.setTitle("评估师注册信息");
			
			pp.addColumn("评估师名称", "loginName","showCenter").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("身份证号", "idnumber","showCenter");
			pp.addColumn("批准文号", "certificate","showCenter");
			pp.addColumn("联系电话", "phone","showCenter");
			
			pp.setColumnWidth("20%,20%,20%,20%,20%");
			pp.setSQL(sql);
			pp.setOrderBy_CH("loginID");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("ctypetabname", ctypetabname.toLowerCase());
		return model;
	} 
	
	
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		Connection conn = null;
		String p = request.getParameter("p");
		String id = request.getParameter("id");
		System.out.println("p="+p);
		try {
			if("add".equals(p)){
				model = new ModelAndView(ADDANDEDIT);
				model.addObject("p", "m");
				model.addObject("pd", "add");
			}else if("update".equals(p)){
				conn = new DBConnect().getConnect();
				AssesserRegisterService as = new AssesserRegisterService(conn);
				AssesserRegister ar = as.getAssesserRegisterById(id);
				model = new ModelAndView(ADDANDEDIT);
				model.addObject("mr", ar);
				model.addObject("p", "m");
				model.addObject("pd", "update");
			}else if("search".equalsIgnoreCase(p)){
				conn = new DBConnect().getConnect();
				AssesserRegisterService ms = new AssesserRegisterService(conn);
				AssesserRegister ar = ms.getAssesserRegisterById(id);
				model = new ModelAndView(SEARCH);
				model.addObject("mr", ar);
				model.addObject("param", "search");
			}else{
				model = new ModelAndView(REGIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	public ModelAndView goRegist(HttpServletRequest request,HttpServletResponse response){
		ModelAndView  model = new ModelAndView(ADDANDEDIT);
		String name = request.getParameter("name");
		String idCardNum = request.getParameter("idCardNum");
		Connection conn = null;
		String sql = "";
		String p = "m";
		try {
			// 1. 执业会员注册表里面是否已经存在该注师
			// 2. 执业会员注册表里面已经存在就取该里面对应的信息，没有就找 合格证号 表里面
			// 3. 合格证号 表里面存在相关信息就 找考生信息表
			conn = new DBConnect().getConnect();
			AssesserRegisterService ms = new AssesserRegisterService(conn);
			AssesserRegister mr = ms.getAssesserRegisterByMore(idCardNum, name);
			if(mr.getId()==null || "".equals(mr.getId())){
				sql = " select general from K_Certificate where loginname = ? and idnumber = ? ";
				String general = new DbUtil(conn).queryForString(sql,new Object[]{name,idCardNum});
				if(general!=null && !"".equals(general)){	// 存在 K_Certificate   合格证号 就 找出 考生信息表里面 最后一条记录
					CandidateService cs = new CandidateService(conn);
					Candidates cd = cs.getCandidatesByMore(name, idCardNum);
					cd.setId("");
					model.addObject("mr", cd);
					p = "c";
				}
			}else{
				model.addObject("mr", mr);
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
	 * 修改
	 * @param request
	 * @param response
	 * @param mr
	 * @return
	 */
	public ModelAndView updateAssesserRegister(HttpServletRequest request,HttpServletResponse response,AssesserRegister mr){
		Connection conn = null;
		try {
//			String userphotoname = request.getParameter("userphotoname");
//			mr.setPhoto(userphotoname);
			conn = new DBConnect().getConnect();
			AssesserRegisterService ms = new AssesserRegisterService(conn);
			ms.updateAssesserRegister(mr);
			response.sendRedirect(request.getContextPath()+"/common/assesserRegister.do?method=index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	

	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param mr
	 * @return
	 */
	public ModelAndView addAssesserRegister(HttpServletRequest request,HttpServletResponse response,AssesserRegister ar){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		Connection conn = null;
		// 照片的 名称 作为 唯一 标识  上传了照片 就会生成 id
		String id = UUID.randomUUID().toString();
		ar.setId(id);
		String userphotoname = request.getParameter("userphotoname");
		ar.setPhoto(userphotoname);
		try {
			conn = new DBConnect().getConnect();
			ar.setOfficeCode(loginid);
			AssesserRegisterService ms = new AssesserRegisterService(conn);
			ms.addAssesserRegister(ar);
			response.sendRedirect(request.getContextPath()+"/common/assesserRegister.do?method=index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param mr
	 * @return
	 */
	public ModelAndView delAssesserRegister(HttpServletRequest request,HttpServletResponse response,AssesserRegister mr){
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			AssesserRegisterService ms = new AssesserRegisterService(conn);
			ms.deleteAssesserRegister(id);
			response.sendRedirect(request.getContextPath()+"/common/assesserRegister.do?method=index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		try {
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			
			String photoName = UUID.randomUUID().toString();
			
			String uploadtemppath = myfileUpload.UploadFile(photoName, null);

			Foder foder  = new Foder("",request);
			String path = foder.createFoder("common\\attachFile\\K_AssesserRegister") ;
			
			// 先删除原来的图片
			File newFile = new File(path+"\\"+photoName) ;
			if(newFile.exists()) {
				newFile.delete();
			}
			
			//把文件从临时文件夹中拷走
			FileInputStream input=null;
			FileOutputStream output=null;
			try{
				File tempFile = new File(uploadtemppath+"\\"+photoName) ;
				input = new FileInputStream(tempFile);
				output = new FileOutputStream(path+"\\"+photoName);
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
			
			String result = "上传照片成功!";
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.println("<script>window.parent.changePhoto('"+photoName+"');alert(\""+result+"\");</script>");
			out.close() ;
			
			return null;	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		
	}
	
	public ModelAndView goField(HttpServletRequest request,HttpServletResponse response){
		Connection conn = null;
		String loginName = request.getParameter("n");
		try {
			conn = new DBConnect().getConnect();
			AssesserRegisterService ms = new AssesserRegisterService(conn);
			AssesserRegister mr = ms.getAssesserRegisterDefineField("loginname", loginName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
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
			AssesserRegister mr = new AssesserRegisterService(conn).getAssesserRegisterById(id);
			model.addObject("mr", mr);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
