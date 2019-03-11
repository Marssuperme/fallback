package cn.org.gdicpa.web.action.Paper;

import java.io.IOException;
import java.sql.Connection;
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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.Paper.PaperService;
import cn.org.gdicpa.web.service.Paper.model.PaperTable;
import cn.org.gdicpa.web.service.attachFileUploadService.AttachFileUploadService;
/**
 * 投稿业务类
 * @author kq
 *
 */
public class PaperAction extends MultiActionController {
	private static final String PAPERLIST="/paper/paperList.jsp";
	private static final String PAPERADD="/paper/addPaper.jsp";
	/**
	 * 显示投稿信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView paperIndex(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(PAPERLIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = " select * from b_Paper p left join " 
					   + " ( select indexid," 
					   + " filename=stuff((select ','+filename from k_attachfile where indexid=a.indexid for xml path('')),1,1,'') " 
					   + " from k_attachfile a " 
					   + " where indexTable = 'b_Paper' " 
					   + " group by indexid ) a " 
					   + " on p.AttachID=a.indexid" 
					   + " where p.OfficeCode = '"+loginid+"' ";
			
			DataGridProperty dp = new DataGridProperty();
			
			dp.setInputType("radio");
			dp.setWhichFieldIsValue(1);
			
			dp.setTitle("投稿信息");
			
			dp.setTableID("paper");
			
			dp.addColumn("标题", "title", "showCenter").setTdProperty(" style=\" text-align:center; \" onclick=\"goView('${id}');\" ");
			dp.addColumn("工作单位", "workUnit", "showCenter");
			dp.addColumn("附件", "filename", "showCenter");
			dp.addColumn("是否使用", "isUse", "showCenter");
			dp.addColumn("使用说明", "useRemark", "showCenter");
			
			
			dp.setSQL(sql);
			dp.setPageSize_CH("10");
			dp.setOrderBy_CH("OfficeCode");
			dp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre+dp.getTableID(), dp);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		
		return model;
	}
	/**
	 * 保存投稿信息
	 * @param request
	 * @param response
	 * @param paper
	 * @return
	 * @throws IOException
	 */
	public ModelAndView addPaperNo(HttpServletRequest request,HttpServletResponse response,PaperTable paper) throws IOException{
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String loginname = (String)userSession.getUserMap().get("loginname");
		Connection con = null;
		try {
			con = new DBConnect().getConnect();
			PaperService ps = new PaperService(con);
			
			//PaperTable 的主建ID
			String id = UUID.randomUUID().toString();
			//附件ID
			String attachID = request.getParameter("uploadFilesPaper");
			//备注
			String remark = request.getParameter("remark");
			//是否使用
			String isUse = request.getParameter("isUse");
			//使用说明
			String useRemark = request.getParameter("useRemark");
			//当前时间
			String sDate = af.getCurrentDate();
			//标题
			String title = request.getParameter("title");
			//工作单位
			String workUnit = request.getParameter("workUnit");
			
			//set到实体类里
			paper.setId(id);
			//事务所编号
			paper.setOfficeCode(loginid);
			//事务所名称
			paper.setOfficeName(loginname);
			//保存附件
			paper.setAttachID(attachID);
			paper.setRemark(remark);
			paper.setIsUse(isUse);
			paper.setUseRemark(useRemark);
			paper.setSDate(sDate);
			paper.setTitle(title);
			paper.setWorkUnit(workUnit);
			
			//添加
			ps.addPaper(paper);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		
		System.out.println("addd111111111111");
		response.sendRedirect("paper.do?method=paperIndex");
		System.out.println("addd11111111111122222222222222222");
		
		return null;
	}
	/**
	 * 更新投稿信息
	 * @param request
	 * @param response
	 * @param paper
	 * @return
	 * @throws IOException
	 */
	public ModelAndView updatePaperNo(HttpServletRequest request,HttpServletResponse response,PaperTable paper) throws IOException{
		//获取当前时间
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String loginname = (String)userSession.getUserMap().get("loginname");
		Connection con = null;
		try {
			con = new DBConnect().getConnect();
			PaperService ps = new PaperService(con);
			
			//PaperTable 的主建ID
			String id = request.getParameter("id");
			
			//附件ID
			String attachID = request.getParameter("uploadFilesPaper");
			//备注
			String remark = request.getParameter("remark");
			//是否使用
			String isUse = request.getParameter("isUse");
			//使用说明
			String useRemark = request.getParameter("useRemark");
			//当前时间
			String sDate = af.getCurrentDate();
			//标题
			String title = request.getParameter("title");
			//工作单位
			String workUnit = request.getParameter("workUnit");
			
			//事务所编号
			paper.setOfficeCode(loginid);
			//事务所名称
			paper.setOfficeName(loginname);
			//保存附件
			paper.setAttachID(attachID);
			paper.setRemark(remark);
			paper.setIsUse(isUse);
			paper.setUseRemark(useRemark);
			paper.setSDate(sDate);
			paper.setTitle(title);
			paper.setWorkUnit(workUnit);
			//set到实体类里
			paper.setId(id);
			
			//添加
			ps.updatePaperNo(paper);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		response.sendRedirect("paper.do?method=paperIndex");
		return null;
	}
	/**
	 * 删除投稿信息
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView deletePaperNo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection con = null;
		PaperTable paper = new PaperTable();
		try {
			con = new DBConnect().getConnect();
			
			//查找投稿ID
			PaperService ps = new PaperService(con);
			String id = request.getParameter("id");
			paper = ps.getPaperTable(id); 
			
			//删除附件
			AttachFileUploadService pfu = new AttachFileUploadService(con);
			pfu.delete(paper.getAttachFile().getIndexTable(), paper.getAttachFile().getIndexId(), paper.getAttachFile().getFileTempName()); 
			
			//删除投稿信息
			PaperService prs = new PaperService(con);
			prs.deletePaperNo(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		response.sendRedirect("paper.do?method=paperIndex");
		return null;
	}
	/**
	 * 查询投稿信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addPaperAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(PAPERADD);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String loginname = (String)userSession.getUserMap().get("loginname");
		
		Connection con = null;
		String p = StringUtil.showNull(request.getParameter("p"));
		PaperTable papers = null;
		try {
			//上传附件时自动生成的ID号
			String attachID = "";
			if ("update".equalsIgnoreCase(p) || "search".equalsIgnoreCase(p)) {
				con = new DBConnect().getConnect();
				// 和 new ParticularService(con);
				PaperService ps = new PaperService(con);
				//Particular 表的 主建ID
				String id = request.getParameter("id");
				//根据ID查询投稿信息	
				papers = ps.getPaperTable(id);
				//如果上传附件存在就获取上传附件时的indexId字段用来显示在页面上
				attachID = papers.getAttachID();
			}else if("add".equalsIgnoreCase(p)){
				papers = new PaperTable();
				//当前事务所编号
				papers.setOfficeCode(loginid);
				//当前事务所名称
				papers.setOfficeName(loginname);
				//如果上传附件不存在就创建一个indexId字段
				attachID = DELUnid.getNumUnid();
				model.addObject("uploadFilesPaper",attachID);
			}
			model.addObject("uploadFilesPaper",attachID);
			model.addObject("paperTable",papers.getPapers());
			model.addObject("papers",papers);
			model.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(con);
		}
		return model;
	}
}
