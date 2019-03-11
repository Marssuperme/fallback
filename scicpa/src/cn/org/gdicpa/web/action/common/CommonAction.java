package cn.org.gdicpa.web.action.common;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.metadata.commons.CommonsAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.common.CommonService;

public class CommonAction extends MultiActionController {
	public ModelAndView datagrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			String csn = request.getParameter("csn");
			String tp = StringUtil.showNull(request.getParameter("tp"));
			String vl = StringUtil.showNull(request.getParameter("vl"));
			String xml = StringUtil.showNull(request.getParameter("xml"));

			HttpSession session = request.getSession();

			DataGridProperty pp = (DataGridProperty) session
					.getAttribute(DataGrid.sessionPre + csn);
			if (request.getParameter("forcetofirstpage") != null) {
				pp.setPage_CH("1");
			}

			pp.setPage_xml(xml, tp, vl, session, request, response);

			session.setAttribute(DataGrid.sessionPre + csn, pp);

			Writer out = null;
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();

			new DataGrid(session, request, response, pp).printGridBody(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 导出成EXCEL
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView expExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//String expSql = request.getParameter("expSql");
		String expSql = (String)request.getSession().getAttribute("ExpSQL");
		
		//加上了序号
		expSql = expSql.replaceFirst("select", "select ROW_NUMBER() OVER( order by bbtime desc) AS ROW_NUM,");
		
		System.out.println("sql:"+expSql);
		
		String expDisplayColName = request.getParameter("expDisplayColName");
		String expColName = request.getParameter("expColName");
		String fileName = request.getParameter("fileName");
		Connection conn = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		OutputStream os = null;

		try {
						
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			
			String sheetName = fileName;
			fileName += simpleDateFormat.format(new Date()) + ".xls";
			fileName = URLEncoder.encode(fileName, "UTF-8");

			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);

			os = response.getOutputStream();
			//创建EXCEL
			WritableWorkbook wwb = Workbook.createWorkbook(os);

			//创建表页
			WritableSheet ws = wwb.createSheet(sheetName, 0);

			conn = new DBConnect().getConnect();
			
			ps = conn.prepareStatement(expSql);
			rs = ps.executeQuery();

			String displayColName[] = expDisplayColName.split(",");
			String colName[] = expColName.split(",");
			Label label = null;

			//写入表头
			for (int i = 0; i < displayColName.length; i++) {
				label = new Label(i, 0, displayColName[i]);
				ws.addCell(label);
			}

			//写入数据行
			int row = 1;
			while (rs.next()) {
				for (int i = 0; i < colName.length; i++) {
//					if("row_num".equals(colName[i]))              //TODO-----------
//						continue;
					label = new Label(i, row, rs.getString(colName[i]));
					ws.addCell(label);
				}
				row ++;
			}

			//写入EXCEL
			wwb.write();
			
			//关闭EXCEL
			wwb.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);

			os.close();
		}

		return null;
	}

	/**
	 * 导出成EXCEL
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView expExcel_1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String expSql = request.getParameter("expSql");
		String expDisplayColName = request.getParameter("expDisplayColName");
		String expColName = request.getParameter("expColName");
		String fileName = request.getParameter("fileName");
		
		Connection conn = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		OutputStream os = null;

		try {
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			
			String sheetName = fileName;
			fileName += simpleDateFormat.format(new Date()) + ".xls";
			fileName = URLEncoder.encode(fileName, "UTF-8");

			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);

			os = response.getOutputStream();
			//创建EXCEL
			WritableWorkbook wwb = Workbook.createWorkbook(os);

			//创建表页
			WritableSheet ws = wwb.createSheet(sheetName, 0);

			conn = new DBConnect().getConnect();
			System.out.println("下周下载1=====》"+expSql);
			System.out.println("下周下载2=====》"+expDisplayColName);
			System.out.println("下周下载3=====》"+expColName);
			ps = conn.prepareStatement(expSql);
			rs = ps.executeQuery();

			String displayColName[] = expDisplayColName.split(",");
			String colName[] = expColName.split(",");
			Label label = null;

			//写入表头
			for (int i = 0; i < displayColName.length; i++) {
				label = new Label(i, 0, displayColName[i]);
				ws.addCell(label);
			}

			//写入数据行
			int row = 1;
			while (rs.next()) {
				for (int i = 0; i < colName.length; i++) {
					//System.out.println(colName[i]);
					label = new Label(i, row, rs.getString(colName[i]));
					ws.addCell(label);
				}
				row ++;
			}

			//写入EXCEL
			wwb.write();
			
			//关闭EXCEL
			wwb.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
			os.close();
		}
		return null;
	}
	
	/**
	 * 短信注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView regist(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try{
			CommonService ms = new CommonService();

			out = response.getWriter();
	
			// 注册
			String r = ms.registEx();
			System.out.println("注册和激活序列号 r="+r);
	
			out.print("<script>");
			out.print("alert('注册和激活序列号  注册情况信息："+r+"')");
			out.print("</script>");
		}catch(Exception e){ 
			e.printStackTrace();
			throw e;
		}
		return null;

	}
	
	
	/**
	 * 发送短信
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView sendSMS(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try{
			CommonService ms = new CommonService();
			out = response.getWriter();
			String mobiles = request.getParameter("mobiles"); 
			String smsContent = request.getParameter("smsContent");  
			String addSerial = request.getParameter("addSerial"); 
			String smsPriorityTemp = request.getParameter("smsPriority");
			int smsPriority = 1; 
			if(smsPriorityTemp!=null && !"".equals(smsPriorityTemp)){
				smsPriority = Integer.parseInt(smsPriorityTemp);
			}
	
			// 发短信
			String result = "";
			if(null == mobiles || "".equals(mobiles)){
				mobiles = "默认电话号码为：15920520502";
				result = ms.sendSMS("15920520502","袁波 你好 。 这里是省注协短信测试信息! ","type",4);
			}else{
				result = ms.sendSMS(mobiles,smsContent,addSerial,smsPriority);
			}
			System.out.println("发短信 后 result="+result);
	
			out.print("<script>");
			out.print("alert('发短信 信息：result="+result+"    ||| mobiles="+mobiles+"')");
			out.print("</script>");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null;

	}
	
	
	/**
	 * 查看余额
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getBalance(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
		
			CommonService ms = new CommonService();
			
			// 查看余额
			String r = ms.getBalance();
			System.out.println("余额 ："+r);
			out.print("<script>");
			out.print("alert('余额    yu e =："+r+"')");
			out.print("</script>");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	
	/**
	 * 短信注销
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
		
			CommonService ms = new CommonService();
	
			// 注销
			String r = ms.logout();
			System.out.println("注销序列号 r="+r);
	
			out.print("<script>");
			out.print("alert('注销序列号 注销情况信息："+r+"')");
			out.print("</script>");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null;

	}
}
