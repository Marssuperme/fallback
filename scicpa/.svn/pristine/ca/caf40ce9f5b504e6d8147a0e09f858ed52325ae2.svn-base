package cn.org.gdicpa.web.action.bb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELAutocode;
import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.bbCommon.BbService;
import cn.org.gdicpa.web.service.bbbbqtb.BbqtbService;
import cn.org.gdicpa.web.service.bbbbqtb.model.BbPrint;
import cn.org.gdicpa.web.service.bbbbqtb.model.BbqtbTable;
import cn.org.gdicpa.web.service.bbccsssqkcjjb.CcsssqkcjjbService;
import cn.org.gdicpa.web.service.bbccsssqkcjjb.model.CcsssqkcjjbTable;
import cn.org.gdicpa.web.service.bbdxzhpgb.DxzhpgbService;
import cn.org.gdicpa.web.service.bbdxzhpgb.model.DxzhpgbTable;
import cn.org.gdicpa.web.service.bbflsjb.FlsjbService;
import cn.org.gdicpa.web.service.bbflsjb.model.FlsjbTable;
import cn.org.gdicpa.web.service.bbhbsjb.HbsjbService;
import cn.org.gdicpa.web.service.bbhbsjb.model.HbsjbTable;
import cn.org.gdicpa.web.service.bbjrzcpg.JrzcpgService;
import cn.org.gdicpa.web.service.bbjrzcpg.model.JrzcpgTable;
import cn.org.gdicpa.web.service.bbkjdshb.KjdshbService;
import cn.org.gdicpa.web.service.bbkjdshb.model.KjdshbTable;
import cn.org.gdicpa.web.service.bbkjzsb.KjzsbService;
import cn.org.gdicpa.web.service.bbkjzsb.model.KjzsbTable;
import cn.org.gdicpa.web.service.bbqchzb.QchzbService;
import cn.org.gdicpa.web.service.bbqchzb.model.QchzbTable;
import cn.org.gdicpa.web.service.bbqsshb.QsshbService;
import cn.org.gdicpa.web.service.bbqsshb.model.QsshbTable;
import cn.org.gdicpa.web.service.bbqtssjjb.QtssjjbService;
import cn.org.gdicpa.web.service.bbqtssjjb.model.QtssjjbTable;
import cn.org.gdicpa.web.service.bbqtzcpg.QtzcpgService;
import cn.org.gdicpa.web.service.bbqtzcpg.model.QtzcpgTable;
import cn.org.gdicpa.web.service.bbqyjzpg.QyjzpgService;
import cn.org.gdicpa.web.service.bbqyjzpg.model.QyjzpgTable;
import cn.org.gdicpa.web.service.bbsdshsqj.SdshsqjService;
import cn.org.gdicpa.web.service.bbsdshsqj.model.SdshsqjTable;
import cn.org.gdicpa.web.service.bbsj.SjService;
import cn.org.gdicpa.web.service.bbsj.model.SjTable;
import cn.org.gdicpa.web.service.bbswdlb.SwdlbService;
import cn.org.gdicpa.web.service.bbswdlb.model.SwdlbTable;
import cn.org.gdicpa.web.service.bbwhnjb.WhnjService;
import cn.org.gdicpa.web.service.bbwhnjb.model.WhnjTable;
import cn.org.gdicpa.web.service.bbyzb.YzbService;
import cn.org.gdicpa.web.service.bbyzb.model.YzbTable;
import cn.org.gdicpa.web.service.bbzcpgb.ZcpgbService;
import cn.org.gdicpa.web.service.bbzcpgb.model.ZcpgbTable;
import cn.org.gdicpa.web.service.company.CompanyService;
import cn.org.gdicpa.web.service.company.model.CompanyTable;
import cn.org.gdicpa.web.service.companyList.CompanyListService;
import cn.org.gdicpa.web.service.companyList.model.CompanyListTable;
import cn.org.gdicpa.web.service.content.BBApplyService;
import cn.org.gdicpa.web.service.content.BBHourService;
import cn.org.gdicpa.web.service.content.ContentService;
import cn.org.gdicpa.web.service.content.SJMoneyService;
import cn.org.gdicpa.web.service.content.model.BBApplyTable;
import cn.org.gdicpa.web.service.content.model.BBHourTable;
import cn.org.gdicpa.web.service.content.model.ContentTable;
import cn.org.gdicpa.web.service.content.model.SJMoneyTable;
import cn.org.gdicpa.web.service.log.LogService;
import cn.org.gdicpa.web.service.log.model.LogTable;
import cn.org.gdicpa.web.service.sfkjjdb.SfkjjdbService;
import cn.org.gdicpa.web.service.sfkjjdb.model.SfkjjdbTable;
import cn.org.gdicpa.web.service.user.UserService;
import et.otp.ETOtpOpp;

public class BbAction extends MultiActionController{
	
	private static String LIST = "/bb/list.jsp";
	private static String PRINT = "/bb/print.jsp";
	private static String PRINTLIST = "/bb/printList.jsp";
	private static String BBHISTORYLIST = "/bb/bbHistoryList.jsp";
	private static String FS_LIST = "/bb/fs_list.jsp";
	
	/**
	 * 检查唯一性
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView isOnly(HttpServletRequest request,HttpServletResponse response){
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConnect();
			
			String typeid = request.getParameter("typeid");
			String bgnd = request.getParameter("bgnd");
			String wtdwmc = request.getParameter("wtdwmc");
			
			String sql = "select 1 from dbo.BB_CONTENT1 where typeid = ? and wtdwmc = ? and bgnd = ? and bbstate <> '作废'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, typeid);
			ps.setString(2, wtdwmc);
			ps.setString(3, bgnd);
			rs = ps.executeQuery();
			String output = "true";
			if(rs.next()){
				output = "false";
			}
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.print(output);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 页面跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		String tongji=request.getParameter("model");
		request.getSession().setAttribute("model", tongji);
		model = new ModelAndView("/bb/addTree.jsp");
		return model;
	}
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			if(userSession==null){
				return new ModelAndView("/login.jsp");
			}
			if(userSession==null || "".equals(userSession)){
				return new ModelAndView("/login.jsp");
			}
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			String typeid = request.getParameter("typeid");
			String bbnum = request.getParameter("bbnum");
			
			// 在此添加一参数判断在分析显示的时候添加一个返回键
			
			String tongji = request.getParameter("model");
			if(tongji==null){
				tongji=(String) request.getSession().getAttribute("model");
			}
			request.getSession().setAttribute("model",tongji);
			// 防伪编号
			String bbbh = request.getParameter("bbbh");
			// 项目名称
			String xmmc = request.getParameter("xmmc");
			// 委托单位
			String wtdw = request.getParameter("wtdw");
			// 被审( 验)单位
			String bsydw = request.getParameter("bsydw");
			// 客户出资类型
			String khczlx = request.getParameter("khczlx");
			// 客户经济性质
			String khjjxz = request.getParameter("khjjxz");
			// 客户行业类型
			String khhylx = request.getParameter("khhylx");
			// 是否上市企业
			String sfssqy = request.getParameter("sfssqy");
			// 报告年度
			String bgnd = request.getParameter("bgnd");
			// 报告意见类型
			String bgyjlx = request.getParameter("bgyjlx");
			// 报告文号
			String bgwh = request.getParameter("bgwh");

			// 业务约定书号
			String ywyds = request.getParameter("ywyds");
			// 业务所在地
			String ywarea = request.getParameter("ywarea");
			// 报备状态
			String bbstate = request.getParameter("bbstate");
			
			// 签名注师 cpa 
			String qmzscpa = request.getParameter("qmzscpa");
			
			// 签名注师名称
			String qmzs = request.getParameter("qmzs");
			String qmzs1 = request.getParameter("qmzs1");
			String qmzs2 = request.getParameter("qmzs2");
			String qmzs3 = request.getParameter("qmzs3");
			String qmzs4 = request.getParameter("qmzs4");
			String qmzs5 = request.getParameter("qmzs5");
			String qmzs6 = request.getParameter("qmzs6");
			
			// 应收业务费
			String ysywf1 = request.getParameter("ysywf1");
			// 应收业务费
			String ysywf2 = request.getParameter("ysywf2");
			// 已收业务费
			String ysywfed1 = request.getParameter("ysywfed1");
			// 已收业务费
			String ysywfed2 = request.getParameter("ysywfed2");
			// 报备时间
			String bbtime1 = request.getParameter("bbtime1");
			String bbtime2 = request.getParameter("bbtime2");
			
			// 报告日期
			String bgrq1 = request.getParameter("bgrq1");
			String bgrq2 = request.getParameter("bgrq2");
			
			String titleSql = "select typename from bb_type where guid = '"+typeid+"' ";
			String title = new DbUtil(conn).queryForString(titleSql);
			
			DataGridProperty pp = new DataGridProperty();
			
			// 根据 typeid  XML 拼凑 sql
			BbService bs = new BbService();
			bs.setSqlByXml(typeid);
			String sql = bs.getSql();	
			
			sql = sql + " where typeid = '"+typeid+"' and  BBPERSON = '"+loginid+"'";
			
			// 防伪编号
			if(bbbh!=null && !"".equals(bbbh)){
				sql += "  and bbbh like '%"+bbbh+"%'";
			}
			// 项目名称
			if(xmmc!=null && !"".equals(xmmc)){
				sql += "  and xmmc like '%"+xmmc+"%'";
			}
			// 委托单位
			
			//统计功能当中的列表查询功能
			if(wtdw==null&&"tongji".equals(tongji)){
				wtdw=(String) request.getSession().getAttribute("wtdw");
			}
			if(wtdw!=null && !"".equals(wtdw)){
				sql += "  and wtdwmc like '%"+wtdw+"%'";
			}
			// 被审验单位
			
			//统计功能当中的列表查询功能
			if(bsydw==null&&"tongji".equals(tongji)){
				bsydw=(String) request.getSession().getAttribute("bsydw");
			}
			if(bsydw!=null && !"".equals(bsydw)){
				sql += "  and bsdwmc like '%"+bsydw+"%'";
			}
			// 客户出资类型
			//统计功能当中的列表查询功能
			if(khczlx==null&&"tongji".equals(tongji)){
				khczlx=(String) request.getSession().getAttribute("khczlx");
			}
			if(khczlx!=null && !"".equals(khczlx)){
				sql += "  and khczlx like '%"+khczlx+"%'";
			}
			
			// 客户经济性质
			//统计功能当中的列表查询功能
			if(khjjxz==null&&"tongji".equals(tongji)){
				khjjxz=(String) request.getSession().getAttribute("khjjxz");
			}
			if(khjjxz!=null && !"".equals(khjjxz)){
				sql += "  and khjjxj like '%"+khjjxz+"%'";
			}
			// 客户行业类型
			//统计功能当中的列表查询功能
			if(khhylx==null&&"tongji".equals(tongji)){
				khhylx=(String) request.getSession().getAttribute("khhylx");
			}
			if(khhylx!=null && !"".equals(khhylx)){
				sql += "  and kmhylx like '%"+khhylx+"%'";
			}
			// 是否上市企业
			//统计功能当中的列表查询功能
			if(sfssqy==null&&"tongji".equals(tongji)){
				sfssqy=(String) request.getSession().getAttribute("sfssqy");
			}
			if(sfssqy!=null && !"".equals(sfssqy)){
				sql += "  and sfssqy = '"+sfssqy+"'";
			}
			// 报告年度
			if(bgnd!=null && !"".equals(bgnd)){
				sql += "  and bgnd like '%"+bgnd+"%'";
			}
			
			
			// 报告意见类型
			if(bgyjlx!=null && !"".equals(bgyjlx)){
				if("yz001".equals(typeid) || "sj001".equals(typeid) ){
					sql += "  and sjbgyjlx like '%"+bgyjlx+"%'";
				}
				if("sdshsqj001".equals(typeid) || "ccsssqkcjj001".equals(typeid) || "qssh001".equals(typeid) || "qtssjj001".equals(typeid)){
					sql += "  and bgyjlx like '%"+bgyjlx+"%'";
				}
			}
			
			// 报告文号
			if(bgwh!=null && !"".equals(bgwh)){
				bgwh=bgwh.replace("[", "[[]");
				sql += "  and bgwh like '%"+bgwh+"%'";
			}
			// 业务约定书号
			if(ywyds!=null && !"".equals(ywyds)){
				sql += "  and ywyds like '%"+ywyds+"%'";
			}
			// 业务所在地
			//统计功能当中的列表查询功能
			if(ywarea==null&&"tongji".equals(tongji)){
				ywarea=(String) request.getSession().getAttribute("ywarea");
			}
			if(ywarea!=null && !"".equals(ywarea)){
				sql += "  and ywarea like '%"+ywarea+"%'";
			}
			// 报备状态
			//统计功能当中的列表查询功能
			if(bbstate==null&&"tongji".equals(tongji)){
				bbstate=(String) request.getSession().getAttribute("bbstate");
			}
			if(bbstate!=null && !"".equals(bbstate)){
				sql += "  and bbstate = '"+bbstate+"'";
			}
			
			
			// 签名注师名称
			if("dw".equals(qmzscpa)){	// 定位查询
				
				//统计功能当中的列表查询功能
				if(qmzs1==null&&"tongji".equals(tongji)){
					qmzs1=(String) request.getSession().getAttribute("qmzs1");
				}
				if(qmzs2==null&&"tongji".equals(tongji)){
					qmzs2=(String) request.getSession().getAttribute("qmzs2");
				}
				if(qmzs3==null&&"tongji".equals(tongji)){
					qmzs3=(String) request.getSession().getAttribute("qmzs3");
				}
				if(qmzs4==null&&"tongji".equals(tongji)){
					qmzs4=(String) request.getSession().getAttribute("qmzs4");
				}
				if(qmzs5==null&&"tongji".equals(tongji)){
					qmzs5=(String) request.getSession().getAttribute("qmzs5");
				}
				if(qmzs6==null&&"tongji".equals(tongji)){
					qmzs6=(String) request.getSession().getAttribute("qmzs6");
				}
				if(qmzs1!=null && !"".equals(qmzs1)){
					sql += "  and ( qmzs1 = '"+qmzs1+"' or cpa1 = '"+qmzs1+"' )";
				}
				if(qmzs2!=null && !"".equals(qmzs2)){
					sql += "  and ( qmzs2 = '"+qmzs2+"' or cpa2 = '"+qmzs2+"' )";
				}
				if(qmzs3!=null && !"".equals(qmzs3)){
					sql += "  and ( qmzs3 = '"+qmzs3+"' or cpa3 = '"+qmzs3+"' )";
				}
				if(qmzs4!=null && !"".equals(qmzs4)){
					sql += "  and ( qmzs4 = '"+qmzs4+"' or cpa4 = '"+qmzs4+"' )";
				}
				if(qmzs5!=null && !"".equals(qmzs5)){
					sql += "  and ( qmzs5 = '"+qmzs5+"' or cpa5 = '"+qmzs5+"' )";
				}
				if(qmzs6!=null && !"".equals(qmzs6)){
					sql += "  and ( qmzs6 = '"+qmzs6+"' or cpa6 = '"+qmzs6+"' )";
				}
			}else{	// 模糊查询
				
				if(qmzs==null&&"tongji".equals(tongji)){
					qmzs=(String) request.getSession().getAttribute("qmzs");
				}
				if(qmzs!=null && !"".equals(qmzs)){
					sql += "  and ( qmzs1 = '"+qmzs+"' or cpa1 = '"+qmzs+"' or qmzs2 = '"+qmzs+"' or cpa2 = '"+qmzs+"' or qmzs3 = '"+qmzs+"' or cpa3 = '"+qmzs+"' or qmzs4 = '"+qmzs+"' or cpa4 = '"+qmzs+"' or qmzs5 = '"+qmzs+"' or cpa5 = '"+qmzs+"' or qmzs6 = '"+qmzs+"' or cpa6 = '"+qmzs+"' ) ";
				}
			}
			
			
			//统计功能当中的列表查询功能
			if(ysywf1==null&&"tongji".equals(tongji)){
				ysywf1=(String) request.getSession().getAttribute("ysywf1");
			}
			if(ysywf2==null&&"tongji".equals(tongji)){
				ysywf2=(String) request.getSession().getAttribute("ysywf2");
			}
			
			// 应收业务费
			
			
			if(ysywf1!=null && !"".equals(ysywf1) && ysywf2!=null && !"".equals(ysywf2)){
				sql += "  and ( ysywf >= '"+ysywf1+"' and ysywf<= '"+ysywf2+"' ) ";
			}else{
				if(ysywf1!=null && !"".equals(ysywf1)){
					sql += "  and ysywf = '"+ysywf1+"'";
				}
				if(ysywf2!=null && !"".equals(ysywf2)){
					sql += "  and ysywf = '"+ysywf2+"'";
				}
			}
			
			// 已收业务费
			
			
			if(ysywfed1==null&&"tongji".equals(tongji)){
				ysywfed1=(String) request.getSession().getAttribute("ysywfed1");
			}
			if(ysywfed2==null&&"tongji".equals(tongji)){
				ysywfed2=(String) request.getSession().getAttribute("ysywfed2");
			}
			
			
			if(ysywfed1!=null && !"".equals(ysywfed1) && ysywfed2!=null && !"".equals(ysywfed2)){
				sql += "  and ( ysywfed >= '"+ysywfed1+"' and ysywfed<= '"+ysywfed2+"' ) ";
			}else{
				if(ysywfed1!=null && !"".equals(ysywfed1)){
					sql += "  and ysywfed >= '"+ysywfed1+"'";
				}
				if(ysywfed2!=null && !"".equals(ysywfed2)){
					sql += "  and ysywfed <= '"+ysywfed2+"'";
				}
			}
			
			// 报备时间
			
			if(bbtime1==null&&"tongji".equals(tongji)){
				bbtime1=(String) request.getSession().getAttribute("bbtime1");
			}
			if(bbtime2==null&&"tongji".equals(tongji)){
				bbtime2=(String) request.getSession().getAttribute("bbtime2");
			}
			
			if(bbtime1!=null && !"".equals(bbtime1) && bbtime2!=null && !"".equals(bbtime2)){
				sql += "  and bbtime <>'' and ( cast(bbtime as DateTime) between cast('"+bbtime1+"' as DateTime) and cast('"+bbtime2+"' as DateTime) ) ";
			}else{
				if(bbtime1!=null && !"".equals(bbtime1)){
					sql += " and bbtime <>'' and cast(bbtime as DateTime) <= cast('"+bbtime1+"' as DateTime) ";
				}
				if(bbtime2!=null && !"".equals(bbtime2)){
					sql += " and bbtime <>'' and cast(bbtime as DateTime) >= cast('"+bbtime2+"' as DateTime) ";
				}
			}
			// 报告日期
			
			if(bgrq1==null&&"tongji".equals(tongji)){
				bgrq1=(String) request.getSession().getAttribute("bgtime1");
			}
			if(bgrq2==null&&"tongji".equals(tongji)){
				bgrq2=(String) request.getSession().getAttribute("bgtime2");
			}
			
			if(bgrq1!=null && !"".equals(bgrq1) && bgrq2!=null && !"".equals(bgrq2)){
				sql += "  and ( bgrq between '"+bgrq1+"' and '"+bgrq2+" 24:00:00' )";
			}else{
				if(bgrq1!=null && !"".equals(bgrq1)){
					sql += "  and bgrq >= '"+bgrq1+"'";
				}
				if(bgrq2!=null && !"".equals(bgrq2)){
					sql += "  and bgrq <= '"+bgrq2+"'";
				}
			}
			
			sql = sql+" and bbstate<>'初审通过' ";//过滤了初审通过(四川要求，没有市注协，初审是领导审批的状态)
			
			System.out.println(this.getClass()+"　　　　　　index()　　sql="+sql);
			
			pp.setTitle(title);
			 
			pp.addColumn("序号","ROW_NUM","showCenter").setTdProperty("color:blue");//TODO--
			
			pp.setPageAlign("left");
			
			pp.setInputType("radio");
			
			//序号
			
			pp.setTableID(typeid);
			pp.setWhichFieldIsValue(1);
			
			//pp.setPrintColumnWidth("20,20,20");
			
			
			
			// 宽度
			String columnWidth = "";
			List columnWidthList = bs.getColumnWidth();
			// 得到 中文 列名称
			List columnName = bs.getColumnName();
			
			// 得到 英文 列名  【 字段名 】
			List column = bs.getColumn();
			// 得到 对齐类型 
			List align = bs.getAlign();
			for (int i = 0; i < align.size(); i++) {
				
				//字段里的“报表年度”如果是typeid='yz001'是验资时要改名为“验资期间”
				String colName = "yz001".equals(typeid) && "报表年度".equals(((String)columnName.get(i)).trim()) ? "验资期间" : (String)columnName.get(i);
				if(!"bb_content1.guid as guid".equalsIgnoreCase((String)column.get(i)) && !"bb_content1.companyGUID as companyGUID".equalsIgnoreCase((String)column.get(i))){
					if(((String)column.get(i)).indexOf(" as ")>-1){
						System.out.println("列名中 带有  as  作 别名的 ："+column.get(i)+"          列名 "+(((String)column.get(i)).indexOf(" as ")+4));
						pp.addColumn(colName,((String)column.get(i)).substring(((String)column.get(i)).indexOf(" as ")+4)).setTdProperty("align='"+align.get(i)+"' onclick=f_viewTD('${guid}','${companyGUID}')");
					}else{
						pp.addColumn(colName,(String)column.get(i)).setTdProperty("align='"+align.get(i)+"' onclick=f_viewTD('${guid}','${companyGUID}')");
					}
					columnWidth=columnWidth+columnWidthList.get(i)+",";
				}
			}
			
			// 设置字段值的 省略显示
			pp.setValueMaxLength(20);
			
			columnWidth = columnWidth.substring(0,columnWidth.length()-1);
			
			pp.setColumnWidth(columnWidth);
		
//			pp.setExpExcel(true);
			pp.setSQL(sql);
			System.out.println(sql);
			System.out.println(title);
			pp.setOrderBy_CH("bbtime");
			pp.setDirection("desc");
			pp.setPageSize_CH(10);
			model.addObject("typeid",typeid);
			model.addObject("title",title);
			model.addObject("model",tongji);
			model.addObject("bbnum",bbnum);
			
			//保存SQL
			request.getSession().setAttribute("ExpSQL", pp.getSql()+" order by bbtime desc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	//新增、修改、查看
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		ASFuntion af = new ASFuntion();
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "";
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			if(userSession==null){
				return new ModelAndView("/login.jsp");
			}
			Map map = userSession.getUserMap();
			
			//用于报备统计添加个返回按钮设置的参数
			String tongji = af.showNull(request.getParameter("model"));
			String loginid = af.showNull((String)map.get("loginid"));
			String loginname = af.showNull((String)map.get("loginname"));
			
			String param = af.showNull(request.getParameter("param"));
			String typeid = af.showNull(request.getParameter("typeid"));
			String view = af.showNull(request.getParameter("view"));
			
			String p = af.showNull(request.getParameter("p"));   //  查看还是作废依据
			String GUID = af.showNull(request.getParameter("GUID"));
			
			String area = af.showNull((String)map.get("area"));//事务所所在地区
			
			model.addObject("view", view);
			model.addObject("typeid", typeid);
			
			conn = new DBConnect().getConnect();
			
			ContentTable ct= null;
			CompanyListTable clt= null;
			CompanyListTable clt_KCompany= null;
			
			CompanyListService cls = new CompanyListService(conn);
			ContentService cs = new ContentService(conn);
			
			String busSum = "",isOnly = "";
			sql = "select * from k_autocode where atype = '报备编号' and aowner = ?  ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, area);
			rs = ps.executeQuery();
			if(rs.next()){
				busSum = rs.getString("businessSum");
				isOnly = rs.getString("isOnly");
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			model.addObject("busSum", busSum);
			model.addObject("isOnly", isOnly);
			
			// 联系人
			String linkman = "";
			// 联系电话
			String linkphone = "";
			String guid = "";
			
			//公共表页
			if(param.equals("search")){
				// 代报备内容
				ct = cs.getContentTableById(GUID);
//				String bbstate=ct.getBbstate().equals("申请审核")?"待市注协审核":
//							   ct.getBbstate().equals("初审通过")?"市注协初审通过，待省注协审核":
//							   ct.getBbstate().equals("审核通过")?"省注协审核通过，可点击报备完成":
//							   ct.getBbstate().equals("审核未通过")?"注协审核不通过，修改有关内容再重新发起申请审核":ct.getBbstate();
				
				String bbstate=ct.getBbstate();
				
				if("申请审核".equals(ct.getBbstate())){
					bbstate = "待省注协审核";
				}else if("初审通过".equals(ct.getBbstate())){
//					bbstate = "市注协初审通过，待省注协审核";
					bbstate = "待省注协审核";
				}else if("审核通过".equals(ct.getBbstate())){
					bbstate = "省注协审核通过，可点击报备完成";
				}else if("审核未通过".equals(ct.getBbstate())){//标识“审核未通过”的时候，明确指出是省注协的审核还是市注协的审核
					//找审核人来确定该报备是市还是省进行了审核
					BBApplyTable at = new BBApplyService(conn).getApply(GUID);
					String auditBy = at.getAuditBy();
					String jb = new DbUtil(conn).queryForString("select r.name from k_userrole u join k_role r on u.roleID=r.id where loginid=? and name like '%监管部%'",new Object[]{auditBy});
					System.out.println("auditBy : --------->"+auditBy);
					System.out.println("jb : --------->"+jb);
					if("省注协监管部".equals(jb)){
						bbstate = "省注协审核未通过，可修改有关内容再重新发起申请审核";
					}else if("市注协监管部".equals(jb)){
						bbstate = "市注协审核未通过，可修改有关内容再重新发起申请审核";
					}else{
						bbstate = "省注协审核未通过，可修改有关内容再重新发起申请审核";
					}
				}	
				
				model.addObject("Bbstate", bbstate);
				// oa 导入的数据
				if("审核通过".equals(ct.getBbstate()) && "".equals(af.showNull(ct.getSfbz()))){
					ct.setSfbz("计件收费");
				}
				
				if("审核通过".equals(ct.getBbstate()) && "".equals(af.showNull(ct.getYwarea()))){
					ct.setYwarea(area);
				}
				
				// 如果报备编号为空， OA 导入报备数据没有报备编号
				if("".equals(af.showNull(ct.getBbbh()))){
					DbUtil db = new DbUtil(conn);
					String field = " ComPanyGUID,GUID,Typeid,WTDWMC,BSDWMC, KHCZLX,KHJJXJ,KMHYLX,SFSSQY,YYZZHM,"
							     + "ZCDZ,ZCZBBZ,BSDWZCZB,FZRMC,LXRXM, LXRDH,WTXMLX,YWYDS,QYRQ,BGWH,"
							     + "XMMC,BGRQ,BGND,FCBGFS,QMZYSZL, QMZS1,QMZS2,QMZS3,QMZS4,QMZS5,"
							     + "QMZS6,ZLRY,SFYJ,YSYWF,YSYWFed, KJSKDFPHD,SFRQ,SFSM,LEAVEWORD,BBPERSON," 
							     + "BBTIME,BBSTATE,CPA1,CPA2,CPA3, CPA4,CPA5,CPA6,BBBH,BBREASON,"
							     + "ZFPERSON,ReviewerID,ReviewerName,ReviewTime,Reason, IsReviewed,ywarea,bgnd2,bz,reportCount," 
							     + "linkman,linkphone,sfbz,xmkhlx,kjskdfphd2, zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime," 
							     + "baogaoniandu,isnexts,pattern,ReportYear,attachfileId, syskhlx ";
			
					String sqlTemp = "";
					
					// 复制报备内容到 bb_content2 表
					sqlTemp = " insert into bb_content2 ("+field+") select "+field+" from bb_content1 where guid = ? ";
					db.execute(sqlTemp, new Object[]{GUID});
					
					// update bb_content2 表 的状态
					sqlTemp = " update bb_content2 set bbstate = bbstate+'_点击查询修改了报备编号' where guid = ? ";
					db.execute(sqlTemp,new Object[]{GUID});
					
					// 设置报备编号
					String bbbh = createBbbh(area) + getRandom();
					System.out.println("749: bbbh"+bbbh);
					sql = " update bb_content1 set bbbh = ? where guid = ? ";
					db.executeUpdate(sql, new Object[]{bbbh,GUID});
					
					// 记录报备修改痕迹
					this.addBBStateInfoHistory(conn,"typeid="+typeid+",GUID="+GUID+"<<用户点击了查看按钮后判断防伪编号为空,bbAction 中的 addAndEdit方法。before_bbbh("+ct.getBbbh()+")","ct.getCompanyGUID()="+ct.getCompanyGUID()+"<<ct.getGuid()="+ct.getGuid()+"<<用户点击了查看按钮后判断防伪编号为空,bbAction 中的 addAndEdit方法。after_bbbh("+bbbh+")",ct,loginid,loginname);
					
					ct.setBbbh(bbbh);
				}
				
				// 设置委托项目类型
				if("".equals(af.showNull(ct.getWtxmlx()))){
					sql = " select typename from bb_type where guid = ? ";
					String wtxmlx = new DbUtil(conn).queryForString(sql, new Object[]{typeid});
					ct.setWtxmlx(wtxmlx);
				}
				
				// 代表事务所
 				clt = cls.getCompanyListTable(ct.getCompanyGUID());
 				
 			// 有可能因为 导入数据的原因 报备事务所信息看你有为空的，这种情况也从事务所资料那边去响应的信息
				sql = " select loginid,loginname,linkman,phone,postalcode,postcode,address,email,url,area from k_company where loginid= ? " ;
		    	
		    	ps = conn.prepareStatement(sql);
		    	ps.setString(1, loginid);
		    	rs = ps.executeQuery();
		    	CompanyListTable clt2 = new CompanyListTable();
		    	if(rs.next()){
		    		clt2.setLoginid(rs.getString("loginid"));
		    		clt2.setCompanyName(rs.getString("loginname"));
		    		clt2.setPerson(rs.getString("linkman"));
		    		clt2.setPhone(rs.getString("phone"));
		    		clt2.setFaxes(rs.getString("postalcode"));
		    		clt2.setPost(rs.getString("postcode")); 
		    		clt2.setAddress(rs.getString("address"));
		    		clt2.setEmail(rs.getString("email"));
		    		clt2.setUrl(rs.getString("url"));
		    		clt2.setArea(rs.getString("area"));
		    	}
		    	if("".equals(clt.getCompanyName()) || null == clt.getCompanyName()){
		    		clt.setCompanyName(clt2.getCompanyName());
		    	}
		    	if("".equals(clt.getArea()) || null == clt.getArea()){
		    		clt.setArea(clt2.getArea());
		    	}
		    	
		    	if("".equals(ct.getLinkman()) || null == ct.getLinkman()){
		    		ct.setLinkman(clt2.getPerson());
		    	}
		    	if("".equals(ct.getLinkphone()) || null == ct.getLinkphone()){
		    		ct.setLinkphone(clt2.getPhone());
		    	}
		    	if("".equals(clt.getFaxes()) || null == clt.getFaxes()){
		    		clt.setFaxes(clt2.getFaxes());
		    	}
		    	if("".equals(clt.getPost()) || null == clt.getPerson()){
		    		clt.setPost(clt2.getPost());
		    	}
		    	if("".equals(clt.getAddress()) || null == clt.getAddress()){
		    		clt.setAddress(clt2.getAddress());
		    	}
		    	if("".equals(clt.getEmail()) || null == clt.getEmail()){
		    		clt.setEmail(clt2.getEmail());
		    	}
		    	if("".equals(clt.getUrl()) || null == clt.getUrl()){
		    		clt.setUrl(clt2.getUrl());
		    	}
 				
				model.addObject("p", p);
 				model.addObject("clt", clt);

			}else if(param.equals("update")){
				// 代报备内容
				ct = cs.getContentTableById(GUID);
				
				String bbstate=ct.getBbstate();
				if("申请审核".equals(ct.getBbstate())){
					bbstate = "待省注协审核";
				}else if("初审通过".equals(ct.getBbstate())){
//					bbstate = "市注协初审通过，待省注协审核";
					bbstate = "待省注协审核";
				}else if("审核通过".equals(ct.getBbstate())){
					bbstate = "省注协审核通过，可点击报备完成";
				}else if("审核未通过".equals(ct.getBbstate())){//标识“审核未通过”的时候，明确指出是省注协的审核还是市注协的审核
					//找审核人来确定该报备是市还是省进行了审核
					BBApplyTable at = new BBApplyService(conn).getApply(GUID);
					String auditBy = at.getAuditBy();
					String jb = new DbUtil(conn).queryForString("select r.name from k_userrole u join k_role r on u.roleID=r.id where loginid=? and name like '%监管部%'",new Object[]{auditBy});
					System.out.println("auditBy : --------->"+auditBy);
					System.out.println("jb : --------->"+jb);
					if("省注协监管部".equals(jb)){
						bbstate = "省注协审核未通过，可修改有关内容再重新发起申请审核";
					}else if("市注协监管部".equals(jb)){
						bbstate = "市注协审核未通过，可修改有关内容再重新发起申请审核";
					}else{
						bbstate = "省注协审核未通过，可修改有关内容再重新发起申请审核";
					}
				}
				
				model.addObject("Bbstate", bbstate);
				// oa 导入的数据
				if("审核通过".equals(ct.getBbstate()) && "".equals(af.showNull(ct.getSfbz()))){
					ct.setSfbz("计件收费");
				}
				
				if("审核通过".equals(ct.getBbstate()) && "".equals(af.showNull(ct.getYwarea()))){
					ct.setYwarea(area);
				}
				
				// 如果报备编号为空， OA 导入报备数据没有报备编号
				if("".equals(af.showNull(ct.getBbbh()))){
					DbUtil db = new DbUtil(conn);
					String field = "ComPanyGUID,GUID,Typeid,WTDWMC,BSDWMC, KHCZLX,KHJJXJ,KMHYLX,SFSSQY,YYZZHM,"
							     + "ZCDZ,ZCZBBZ,BSDWZCZB,FZRMC,LXRXM, LXRDH,WTXMLX,YWYDS,QYRQ,BGWH,"
							     + "XMMC,BGRQ,BGND,FCBGFS,QMZYSZL, QMZS1,QMZS2,QMZS3,QMZS4,QMZS5,"
							     + "QMZS6,ZLRY,SFYJ,YSYWF,YSYWFed, KJSKDFPHD,SFRQ,SFSM,LEAVEWORD,BBPERSON," 
							     + "BBTIME,BBSTATE,CPA1,CPA2,CPA3, CPA4,CPA5,CPA6,BBBH,BBREASON,"
							     + "ZFPERSON,ReviewerID,ReviewerName,ReviewTime,Reason, IsReviewed,ywarea,bgnd2,bz,reportCount," 
							     + "linkman,linkphone,sfbz,xmkhlx,kjskdfphd2, zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime," 
							     + "baogaoniandu,isnexts,pattern,ReportYear,attachfileId, syskhlx";
			
					String sqlTemp = "";
					
					// 复制报备内容到 bb_content2 表
					sqlTemp = " insert into bb_content2 ("+field+") select "+field+" from bb_content1 where guid = ? ";
					db.execute(sqlTemp, new Object[]{GUID});
					
					// update bb_content2 表 的状态 
					sqlTemp = " update bb_content2 set bbstate = bbstate+'_点击修改修改了报备编号' where guid = ? ";
					db.execute(sqlTemp,new Object[]{GUID});
					
					// 设置报备编号
					String bbbh = createBbbh(area) + getRandom();
					System.out.println("881: bbbh"+bbbh);
					sql = " update bb_content1 set bbbh = ? where guid = ? ";
					db.executeUpdate(sql, new Object[]{bbbh,GUID});

					// 记录报备修改痕迹
					this.addBBStateInfoHistory(conn,"typeid="+typeid+",GUID="+GUID+"<<用户点击了修改按钮后判断防伪编号为空,bbAction 中的 addAndEdit方法。before_bbbh("+ct.getBbbh()+")","ct.getCompanyGUID()="+ct.getCompanyGUID()+"<<ct.getGuid()="+ct.getGuid()+"<<用户点击了修改按钮后判断防伪编号为空,bbAction 中的 addAndEdit方法。after_bbbh("+bbbh+")",ct,loginid,loginname);
					
					ct.setBbbh(bbbh);
				}
				 
				// 设置委托项目类型
				if("".equals(af.showNull(ct.getWtxmlx()))){
					sql = " select typename from bb_type where guid = ? ";
					String wtxmlx = new DbUtil(conn).queryForString(sql, new Object[]{typeid});
					ct.setWtxmlx(wtxmlx);
				}
				
				// 代表事务所
 				clt = cls.getCompanyListTable(ct.getCompanyGUID());
 
				model.addObject("clt", clt);
				
				// 有可能因为 导入数据的原因 报备事务所信息看你有为空的，这种情况也从事务所资料那边去响应的信息
				sql = " select loginid,loginname,linkman,phone,postalcode,postcode,address,email,url,area from k_company where loginid= ? " ;
		    	
		    	ps = conn.prepareStatement(sql);
		    	ps.setString(1, loginid);
		    	rs = ps.executeQuery();
		    	CompanyListTable clt2 = new CompanyListTable();
		    	if(rs.next()){
		    		clt2.setLoginid(rs.getString("loginid"));
		    		clt2.setCompanyName(rs.getString("loginname"));
		    		clt2.setPerson(rs.getString("linkman"));
		    		clt2.setPhone(rs.getString("phone"));
		    		clt2.setFaxes(rs.getString("postalcode"));
		    		clt2.setPost(rs.getString("postcode"));
		    		clt2.setAddress(rs.getString("address"));
		    		clt2.setEmail(rs.getString("email"));
		    		clt2.setUrl(rs.getString("url"));
		    		clt2.setArea(rs.getString("area"));
		    	}
		    	if("".equals(clt.getCompanyName()) || null == clt.getCompanyName()){
		    		clt.setCompanyName(clt2.getCompanyName());
		    	}
		    	if("".equals(clt.getArea()) || null == clt.getArea()){
		    		clt.setArea(clt2.getArea());
		    	}
		    	
		    	if("".equals(ct.getLinkman()) || null == ct.getLinkman()){
		    		ct.setLinkman(clt2.getPerson());
		    	}
		    	if("".equals(ct.getLinkphone()) || null == ct.getLinkphone()){
		    		ct.setLinkphone(clt2.getPhone());
		    	}
		    	if("".equals(clt.getFaxes()) || null == clt.getFaxes()){
		    		clt.setFaxes(clt2.getFaxes());
		    	}
		    	if("".equals(clt.getPost()) || null == clt.getPerson()){
		    		clt.setPost(clt2.getPost());
		    	}
		    	if("".equals(clt.getAddress()) || null == clt.getAddress()){
		    		clt.setAddress(clt2.getAddress());
		    	}
		    	if("".equals(clt.getEmail()) || null == clt.getEmail()){
		    		clt.setEmail(clt2.getEmail());
		    	}
		    	if("".equals(clt.getUrl()) || null == clt.getUrl()){
		    		clt.setUrl(clt2.getUrl());
		    	}
		    	
			}else{
				
				// 无条件 找 机构信息表  由于报备信息的导入    以防报备这边的事务所 名称和机构信息表那边的名称 不一样
		    	sql = " select loginid,loginname,linkman,phone,postalcode,postcode,address,email,url,area from k_company where loginid= ? " ;
		    	
		    	ps = conn.prepareStatement(sql);
		    	ps.setString(1, loginid);
		    	rs = ps.executeQuery();
		    	clt = new CompanyListTable();
		    	if(rs.next()){
		    		clt.setLoginid(rs.getString("loginid"));
		    		clt.setCompanyName(rs.getString("loginname"));
		    		clt.setPerson(rs.getString("linkman"));
		    		clt.setPhone(rs.getString("phone"));
		    		clt.setFaxes(rs.getString("postalcode"));
		    		clt.setPost(rs.getString("postcode"));
		    		clt.setAddress(rs.getString("address"));
		    		clt.setEmail(rs.getString("email"));
		    		clt.setUrl(rs.getString("url"));
		    		clt.setArea(rs.getString("area"));
		    	}
		    	
		    	DbUtil.close(rs);
		    	DbUtil.close(ps);
		    	
			}
			//公共表页exit
			
			//第三表页(私有)
			String searchHtml = "";
			String twoHtml = "";
			
			if(GUID!=null && !"".equals(GUID)){
				BBHourService bhs = new BBHourService(conn);
				List list = bhs.getHourList(GUID);
				
				Map mapTotal = listToMap(list);
				
				System.out.println(mapTotal);
				
				BBApplyService as = new BBApplyService(conn);
				BBApplyTable at = as.getApply(GUID);
				model.addObject("mapTotal", mapTotal);
				model.addObject("at", at);
			}
			
			if("yz001".equals(typeid)){ //验资
				twoHtml = "addBbyzb.jsp";
				if(param.equals("search") || param.equals("update")){
					YzbService ys = new YzbService(conn); 
					YzbTable yt = ys.getYzbTable(GUID);
					model.addObject("yt", yt);
				
					//if(param.equals("search")) searchHtml = "/bbyzb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("验资");
				}
			}else if("sj001".equals(typeid)){ //审计
				twoHtml = "addBbsjb.jsp";
				if(param.equals("search") || param.equals("update")){
					SjService ss = new SjService(conn);
					SjTable st = ss.getSjTable(GUID);
					model.addObject("st", st);
					
					SJMoneyService sjms = new SJMoneyService(conn);
					List listMoney = sjms.getSJMoneyList(GUID);
					// 兼容之前的数据
					if(listMoney.size()<1){
						listMoney = setBeanToList(st,typeid);
					}
					Map mapTotalMoney = listToMaps(listMoney);
					model.addObject("mapTotalMoney", mapTotalMoney);
					
					//if(param.equals("search")) searchHtml = "/bbsjb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("审计");
				}
			}else if("sfkjjd001".equals(typeid)){//	司法会计鉴定
				twoHtml = "addBbsfkjjdb.jsp";
				if(param.equals("search") || param.equals("update")){
					SfkjjdbService ss = new SfkjjdbService(conn);
					SfkjjdbTable st = ss.getSfkjjdbTable(GUID);
					model.addObject("st", st);
					//if(param.equals("search")) searchHtml = "/bbsfkjjdb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("司法会计鉴定");
				}
			}else if("sdshsqj001".equals(typeid)){	//所得税汇算清缴
				twoHtml = "addBbsdshsqjb.jsp";
				if(param.equals("search") || param.equals("update")){
					SdshsqjService ss = new SdshsqjService(conn);
					SdshsqjTable st = ss.getSdshsqjTable(GUID);
					model.addObject("st", st);
					//if(param.equals("search")) searchHtml = "/bbsdshsqjb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("所得税汇算清缴");
				}
			}else if("whnj001".equals(typeid)){	//	外汇年检
				twoHtml = "addBbwhnj.jsp";
				if(param.equals("search") || param.equals("update")){
					WhnjService ws = new WhnjService(conn);
					WhnjTable wt = ws.getWhnjTable(GUID);
					model.addObject("wt", wt);
					//if(param.equals("search")) searchHtml = "/bbwhnj/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("外汇年检");
				}
			}else if("ccsssqkcjj001".equals(typeid)){	//	财产损失税前扣除鉴证
				twoHtml = "addBbccsssqkcjjb.jsp";
				if(param.equals("search") || param.equals("update")){
					CcsssqkcjjbService ccs = new CcsssqkcjjbService(conn);
					CcsssqkcjjbTable cct = ccs.getCcsssqkcjjbTable(GUID);
					model.addObject("cct", cct);
					//if(param.equals("search")) searchHtml = "/bbccsssqkcjjb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("财产损失税前扣除鉴证");
				}
			}else if("qssh001".equals(typeid)){	//	清算审计
				twoHtml = "addBbqsshb.jsp";
				if(param.equals("search") || param.equals("update")){
					QsshbService qs = new QsshbService(conn);
					QsshbTable qt = qs.getQsshbTable(GUID);
					model.addObject("qt", qt);
					
					SJMoneyService sjms = new SJMoneyService(conn);
					List listMoney = sjms.getSJMoneyList(GUID);
					// 兼容之前的数据					
					if(listMoney.size()<1){
						listMoney = setBeanToList(qt,typeid);
					}
					Map mapTotalMoney = listToMaps(listMoney);
					model.addObject("mapTotalMoney", mapTotalMoney);
					
					//if(param.equals("search")) searchHtml = "/bbqsshb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("清算审计");
				}
			}else if("flsj001".equals(typeid)){	//	分立审计
				twoHtml = "addBbflsjb.jsp";
				if(param.equals("search") || param.equals("update")){
					FlsjbService fs = new FlsjbService(conn);
					FlsjbTable ft = fs.getFlsjbTable(GUID);
					model.addObject("ft", ft);
					//if(param.equals("search")) searchHtml = "/bbqsshb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("分立审计");
				}
			}else if("hbsj001".equals(typeid)){	//	合并审计
				twoHtml = "addBbhbsjb.jsp";
				if(param.equals("search") || param.equals("update")){
					HbsjbService hs = new HbsjbService(conn);
					HbsjbTable ht = hs.getHbsjbTable(GUID);
					model.addObject("ht", ht);
					//if(param.equals("search")) searchHtml = "/bbqsshb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("合并审计");
				}
			}else if("qtssjj001".equals(typeid)){	//	其他涉税鉴证
				twoHtml = "addBbqtssjjb.jsp";
				if(param.equals("search") || param.equals("update")){
					QtssjjbService qs = new QtssjjbService(conn);
					QtssjjbTable qt = qs.getQtssjjTable(GUID);
					model.addObject("qt", qt);
					//if(param.equals("search")) searchHtml = "/bbqtssjjb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("其他涉税鉴证");
				}
			}else if("swdl001".equals(typeid)){	//	税务代理
				twoHtml = "addBbswdlb.jsp";
				if(param.equals("search") || param.equals("update")){
					SwdlbService ss = new SwdlbService(conn);
					SwdlbTable st = ss.getSwdlbTable(GUID);
					model.addObject("st", st);
					//if(param.equals("search")) searchHtml = "/bbswdlb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("税务代理");
				}
			}else if("qchz001".equals(typeid)){	//	清产核资
				twoHtml = "addBbqchzb.jsp";
				if(param.equals("search") || param.equals("update")){
					QchzbService qs = new QchzbService(conn);
					QchzbTable qt = qs.getQchzbTable(GUID);
					model.addObject("qt", qt);
					//if(param.equals("search")) searchHtml = "/bbqchzb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("清产核资");
				}
			}else if("kjdsh001".equals(typeid)){	//	会计电算化
				twoHtml = "addBbkjdshb.jsp";
				if(param.equals("search") || param.equals("update")){
					KjdshbService ks = new KjdshbService(conn);
					KjdshbTable kt = ks.getKjdshbTable(GUID);
					model.addObject("kt", kt);
					//if(param.equals("search")) searchHtml = "/bbkjdshb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("会计电算化");
				}
			}else if("kjzs001".equals(typeid)){	//	会计咨询
				twoHtml = "addBbkjzsb.jsp";
				if(param.equals("search") || param.equals("update")){
					KjzsbService ks = new KjzsbService(conn);
					KjzsbTable kt = ks.getKjzsTable(GUID);
					model.addObject("kt", kt);
					//if(param.equals("search")) searchHtml = "/bbkjzsb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("会计咨询");
				}
			}else if("bbqt001".equals(typeid)){//	报备其他
				twoHtml = "addBbbbqtb.jsp";
				if(param.equals("search") || param.equals("update")){
					BbqtbService bs = new BbqtbService(conn);
					BbqtbTable bt = bs.getBbqtbTable(GUID);
					model.addObject("bt", bt);
					//if(param.equals("search")) searchHtml = "/bbbbqtb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("报备其他");
				}
			}else if("zcpg001".equals(typeid)){	//	资产评估
				twoHtml = "addBbzcpgb.jsp";
				if(param.equals("search") || param.equals("update")){
					ZcpgbService zs = new ZcpgbService(conn);
					ZcpgbTable zt = zs.getZcpgbTable(GUID);
					model.addObject("zt", zt);
					//if(param.equals("search")) searchHtml = "/bbzcpgb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("资产评估");
				}
			}else if("dxzhpg001".equals(typeid)){//	单项资产或资产组合评估
				twoHtml = "addBbdxzhpgb.jsp";
				if(param.equals("search") || param.equals("update")){
					DxzhpgbService ds = new DxzhpgbService(conn);
					DxzhpgbTable dt = ds.getBbdxzhpgbTable(GUID);
					model.addObject("dt", dt);
					//if(param.equals("search")) searchHtml = "/bbbbqtb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("单项资产或资产组合评估");
				}
			}else if("qyjzpg001".equals(typeid)){//	企业价值评估
				twoHtml = "addBbqyjzpgb.jsp";
				if(param.equals("search") || param.equals("update")){
					QyjzpgService qs = new QyjzpgService(conn);
					QyjzpgTable qt = qs.getBbqyjzpgTable(GUID);
					model.addObject("qt", qt);
					//if(param.equals("search")) searchHtml = "/bbbbqtb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("企业价值评估");
				}
			}else if("jrblpg001".equals(typeid)){//	金融不良资产评估
				twoHtml = "addBbjrblpgb.jsp";
				if(param.equals("search") || param.equals("update")){
					
					JrzcpgService js = new JrzcpgService(conn);
					JrzcpgTable jt = js.getJrzcpgTable(GUID);
					model.addObject("jt", jt);
					//if(param.equals("search")) searchHtml = "/bbbbqtb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("金融不良资产评估");
				}
			}else if("qtzcpg001".equals(typeid)){//	其他资产评估 
				twoHtml = "addBbqtzcpgb.jsp";
				if(param.equals("search") || param.equals("update")){
					QtzcpgService qs = new QtzcpgService(conn);
					QtzcpgTable qt = qs.getQtzcpgTable(GUID);
					model.addObject("qt", qt);
					//if(param.equals("search")) searchHtml = "/bbbbqtb/search.jsp";
				} else{
					ct = new ContentTable();
					if(guid!=null && !"".equals(guid)){ 
					   if("".equals(linkman) || null == linkman){
						   ct.setLinkman(clt.getPerson());
					   }else{
						   ct.setLinkman(linkman);
					   }
					   if("".equals(linkphone) || null == linkphone){
						   ct.setLinkphone(clt.getPhone());
					   }else{
						   ct.setLinkphone(linkphone);
					   }
					}else{
				       ct.setLinkman(clt.getPerson());
				       ct.setLinkphone(clt.getPhone());
					}
					ct.setWtxmlx("其他资产评估 ");
				}
			}
		
			// 初始化上传附件
		    String attachfileId = ct.getAttachfileId();
		    if(attachfileId==null || "".equals(attachfileId)){
		    	attachfileId = DELUnid.getNumUnid();
		    	ct.setAttachfileId(attachfileId);
		    }
		    
		    model.addObject("ct", ct);
			model.addObject("clt", clt);
		
			if(param.equals("search")) {
				searchHtml = "/bb/search.jsp";
			}else{
				if("报备完成".equals(ct.getBbstate()) || "待审报备完成".equals(ct.getBbstate())){
					searchHtml = "/bb/add1.jsp";
				}else{
					searchHtml = "/bb/add.jsp";
				}
			}
			
			// 控制 进入 只能修改已收业务金额页面
			String updatemoney = af.showNull(request.getParameter("updatemoney"));
			if(updatemoney.equals("updatemoney") && "报备完成".equals(ct.getBbstate())){
				searchHtml = "/bb/updateMoney.jsp";
				model.addObject("updatemoney", updatemoney);
			}
			
		    //是否分公司(如果存在parentId)
	    	String parentId = new DbUtil(conn).queryForString("select parentId from k_company where loginid='"+loginid+"'");
	    	System.out.println("总公司ID : " + parentId);
			model.addObject("parentId", parentId);
			model.addObject("clt", clt);
			
			model.setViewName(searchHtml);
			model.addObject("twoHtml", twoHtml);
			
			model.addObject("model", tongji);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		return model;
		
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			CompanyListService cls = new CompanyListService(conn);
			ContentService cs = new ContentService(conn);
			String typeid = request.getParameter("typeid");
			String GUID = request.getParameter("GUID");
			ContentTable ct = cs.getContentTableById(GUID,typeid);
			// 代表事务所
			cls.deleteCompanyListTable(ct.getCompanyGUID());
			// 代报内容
			cs.deleteContentTable(GUID);
			
			if("yz001".equals(typeid)){ //验资
				YzbService ys = new YzbService(conn); 
				ys.deleteYzbTable(GUID);
			}else if("sj001".equals(typeid)){ //审计
				SjService ss = new SjService(conn);
				ss.deleteSjTable(GUID);
			}else if("sfkjjd001".equals(typeid)){//	司法会计鉴定
				SfkjjdbService ss = new SfkjjdbService(conn);
				ss.deleteSfkjjdbTable(GUID);
			}else if("sdshsqj001".equals(typeid)){	//所得税汇算清缴
				SdshsqjService ss = new SdshsqjService(conn);
				ss.deleteSdshsqjTable(GUID);
			}else if("whnj001".equals(typeid)){	//	外汇年检
				WhnjService ws = new WhnjService(conn);
				ws.deleteWhnjTable(GUID);
			}else if("ccsssqkcjj001".equals(typeid)){	//	财产损失税前扣除鉴证
				CcsssqkcjjbService ccs = new CcsssqkcjjbService(conn);
				ccs.deleteCcsssqkcjjbTable(GUID);
			}else if("qssh001".equals(typeid)){	//	清算审计
				QsshbService qs = new QsshbService(conn);
				qs.deleteQsshbTable(GUID);
			}else if("flsj001".equals(typeid)){	//	分立审计
				FlsjbService fs = new FlsjbService(conn);
				fs.deleteFlsjbTable(GUID);
			}else if("hbsj001".equals(typeid)){	//	合并审计
				HbsjbService hs = new HbsjbService(conn);
				hs.deleteHbsjbTable(GUID);
			}else if("qtssjj001".equals(typeid)){	//	其他涉税鉴证
				QtssjjbService qs = new QtssjjbService(conn);
				qs.deleteQtssjjTable(GUID);
			}else if("swdl001".equals(typeid)){	//	税务代理
				SwdlbService ss = new SwdlbService(conn);
				ss.deleteSwdlbTable(GUID);
			}else if("zcpg001".equals(typeid)){	//	资产评估
				ZcpgbService zs = new ZcpgbService(conn);
				zs.deleteZcpgbTable(GUID);
			}else if("qchz001".equals(typeid)){	//	清产核资
				QchzbService qs = new QchzbService(conn);
				qs.deleteQchzbTable(GUID);
			}else if("kjdsh001".equals(typeid)){	//	会计电算化
				KjdshbService ks = new KjdshbService(conn);
				ks.deleteKjdshTable(GUID);
			}else if("kjzs001".equals(typeid)){	//	会计咨询
				KjzsbService ks = new KjzsbService(conn);
				ks.deleteKjzsbTable(GUID);
			}else if("bbqt001".equals(typeid)){//	报备其他
				BbqtbService bs = new BbqtbService(conn);
				bs.deleteBbqtbTable(GUID);
			}
			
			// 删除bb_apply报备申请表记录
			delApply(GUID,typeid);
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	*/
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String typeid = request.getParameter("typeid");
			String GUID = request.getParameter("GUID");
			
			DbUtil db = new DbUtil(conn);
			
			String field = "ComPanyGUID,GUID,Typeid,WTDWMC,BSDWMC, KHCZLX,KHJJXJ,KMHYLX,SFSSQY,YYZZHM,"
					     + "ZCDZ,ZCZBBZ,BSDWZCZB,FZRMC,LXRXM, LXRDH,WTXMLX,YWYDS,QYRQ,BGWH,"
					     + "XMMC,BGRQ,BGND,FCBGFS,QMZYSZL, QMZS1,QMZS2,QMZS3,QMZS4,QMZS5,"
					     + "QMZS6,ZLRY,SFYJ,YSYWF,YSYWFed, KJSKDFPHD,SFRQ,SFSM,LEAVEWORD,BBPERSON," 
					     + "BBTIME,BBSTATE,CPA1,CPA2,CPA3, CPA4,CPA5,CPA6,BBBH,BBREASON,"
					     + "ZFPERSON,ReviewerID,ReviewerName,ReviewTime,Reason, IsReviewed,ywarea,bgnd2,bz,reportCount," 
					     + "linkman,linkphone,sfbz,xmkhlx,kjskdfphd2, zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime," 
					     + "baogaoniandu,isnexts,pattern,ReportYear,attachfileId, syskhlx";
			
			String sql = "";
			
			// 复制报备内容到 bb_content2 表
			sql = " insert into bb_content2 ("+field+") select "+field+" from bb_content1 where guid = ? ";
			db.execute(sql, new Object[]{GUID});
			
			// update bb_content2 表 的状态为 删除
			sql = " update bb_content2 set bbstate = '已删除' where guid = ? ";
			db.execute(sql,new Object[]{GUID});
			
			// 删除 bb_content1 表 报备内容
			cs.deleteContentTable(GUID);
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	/**
	 * 删除bb_apply报备申请表记录
	 * @param guid
	 * @param typeid
	 */
	public void delApply(String guid,String typeid){
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			if("yz001".equals(typeid) || "sj001".equals(typeid) || "whnj001".equals(typeid) || "hbsj001".equals(typeid)
				|| "sfkjjd001".equals(typeid)|| "flsj001".equals(typeid) || "qssh001".equals(typeid) || "qchz001".equals(typeid)  
				|| "bbqt001".equals(typeid) ){
				
				BBApplyService bbs = new BBApplyService(conn);
				bbs.delApply(guid);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
	}
	
	public ModelAndView print(HttpServletRequest request,HttpServletResponse response){
		Connection conn = null;
		ModelAndView modelAndView = new ModelAndView(PRINT) ;
		try {
			conn = new DBConnect().getConnect();
			String guid = StringUtil.showNull(request.getParameter("guid"));
			String typeid = StringUtil.showNull(request.getParameter("typeid"));
			BbqtbService bs = new BbqtbService(conn) ;
			BbPrint bbprint = bs.getPrintInfo(guid) ;
			if(typeid == null || "".equals(typeid)){
				typeid = bbprint.getTypeid();
			}
			ContentTable ctt = new ContentService(conn).getContentTableById(guid);
			bbprint.setYsywf(ctt.getYsywf());
			bbprint.setYsywfed(ctt.getYsywfed());
		    bbprint.setYyzzhm(ctt.getYyzzhm());
			
			String sql = "select typename from bb_type where guid = ?";
			String typename = StringUtil.showNull(new DbUtil(conn).queryForString(sql, new String[]{typeid}));
			CompanyListTable ct = new CompanyListService(conn).getCompanyListTable(ctt.getCompanyGUID());
			
			bbprint.setEmail(ct.getEmail());
			bbprint.setCompanyName(ct.getCompanyName());
			bbprint.setAddress(ct.getAddress());
			bbprint.setPhone(ct.getPhone());
			bbprint.setFaxes(ct.getFaxes());
			
			// 如果 报备数据里面的 事务所网址是空的就从 机构信息取 
			if("".equals(bbprint.getUrl()) || null == bbprint.getUrl()){
				sql = "select url from k_company where loginid = ?";
				String url = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getBbperson()});
				bbprint.setUrl(url);
			}
			
			SjTable sj = null;
			BbqtbTable qt = null;
			// 如果是审计报告类型 
			if(typename.equals("审计")){
				// 如果是审计报告类型 下的 专项审计  就 找到审计表里面的  专项审计名称 zxsjmc  是不是  【专项审计】
				sj = new SjService(conn).getSjTable(guid); 
			}
			if(typename.equals("报备其他")){
				// 如果是报备其他类型 下的  报备
				// 根据 报备编号找到  bb_content1 表里面的 guid
				qt = new BbqtbService(conn).getBbqtbTable(guid);
			}
			
			sql = "select phone from k_micfo where cpano = ? or loginid = ? ";
			String phone1 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa1(),bbprint.getCpa1()});
			String phone2 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa2(),bbprint.getCpa2()});
			String phone3 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa3(),bbprint.getCpa3()});
			String phone4 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa4(),bbprint.getCpa4()});
			String phone5 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa5(),bbprint.getCpa5()});
			String phone6 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa6(),bbprint.getCpa6()});
			
			modelAndView.addObject("phone1", phone1);
			modelAndView.addObject("phone2", phone2);
			modelAndView.addObject("phone3", phone3);
			modelAndView.addObject("phone4", phone4);
			modelAndView.addObject("phone5", phone5);
			modelAndView.addObject("phone6", phone6);
			

			String beforeYear = (Integer.parseInt(DateUtil.getDate("yyyy"))-1)+"";
			sql = "SELECT 1 FROM t_inspection WHERE iuser=? AND iyear=?";
			System.out.println("beforeYear : " +beforeYear);
			String isInspection1 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa1(),beforeYear});
			String isInspection2 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa2(),beforeYear});
			String isInspection3 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa3(),beforeYear});
			String isInspection4 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa4(),beforeYear});
			String isInspection5 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa5(),beforeYear});
			String isInspection6 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa6(),beforeYear});
			
			modelAndView.addObject("isInspection1", isInspection1);
			modelAndView.addObject("isInspection2", isInspection2);
			modelAndView.addObject("isInspection3", isInspection3);
			modelAndView.addObject("isInspection4", isInspection4);
			modelAndView.addObject("isInspection5", isInspection5);
			modelAndView.addObject("isInspection6", isInspection6);
			
			modelAndView.addObject("inspectionYear", beforeYear);
			
			modelAndView.addObject("sj", sj);
			modelAndView.addObject("qt", qt);
			modelAndView.addObject("typename", typename);
			modelAndView.addObject("print", bbprint);
			
			request.getSession().setAttribute("bbprint", bbprint);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	
	public ModelAndView printBatch(HttpServletRequest request,HttpServletResponse response){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModelAndView modelAndView = new ModelAndView("/bb/printBatch.jsp");
		try {
			conn = new DBConnect().getConnect();
			
			String PrintID = StringUtil.showNull(request.getParameter("PrintID"));
			
			String guid = "";
			String typeid = "";
			
			Map bbprint = new HashMap();
			List<Map> listPrint = new ArrayList<Map>();
			
			String sql = " select * from K_BatchPrint where PrintID='"+PrintID+"' order by SortFlag ";
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				
				guid = StringUtil.showNull(rs.getString("guid"));
				typeid = StringUtil.showNull(rs.getString("typeid"));
				
				//BbqtbService bs = new BbqtbService(conn) ;
				//BbPrint bbprint = bs.getPrintInfo(guid) ;
				
				
				sql = " select bbbh,bgwh,wtdwmc,a.companyName,bgrq,bbtime,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,bgnd,bgnd2,"
					+ " b.phone,b.faxes,b.address,b.email,b.url,a.typeid,bsdwmc,bbperson,wtxmlx,ywyds,bbstate,ywarea from bb_view a left join "
					+ " BB_CompanyList b on a.companyid = b.guid where a.guid='" + guid + "' " ;	//where replace(REPLACE(a.guid,'{',''),'}','')='" + guid + "' " ;
				
				System.out.println("printBatch - sql========================"+sql);
				
				bbprint = new DbUtil(conn).getMap(sql);
				
				
				
				if(typeid == null || "".equals(typeid)){
					typeid = (String)bbprint.get("typeid");
				}
				ContentTable ctt = new ContentService(conn).getContentTableById(guid);
				bbprint.put("ysywf",ctt.getYsywf());
				bbprint.put("ysywfed",ctt.getYsywfed());
				
				
				sql = "select typename from bb_type where guid = ?";
				String typename = StringUtil.showNull(new DbUtil(conn).queryForString(sql, new String[]{typeid}));
				CompanyListTable ct = new CompanyListService(conn).getCompanyListTable(ctt.getCompanyGUID());
				
				bbprint.put("email",ct.getEmail());
				bbprint.put("companyName",ct.getCompanyName());
				bbprint.put("address",ct.getAddress());
				bbprint.put("Phone",ct.getPhone());
				bbprint.put("faxes",ct.getFaxes());
				
				// 如果 报备数据里面的 事务所网址是空的就从 机构信息取 
				if("".equals((String)bbprint.get("url")) || null == (String)bbprint.get("url")){
					sql = "select url from k_company where loginid = ?";
					String url = new DbUtil(conn).queryForString(sql, new String[]{(String)bbprint.get("bbperson")});
					bbprint.put("url",url);
				}
				
				SjTable sj = null;
				BbqtbTable qt = null;
				// 如果是审计报告类型 
				if(typename.equals("审计")){
					// 如果是审计报告类型 下的 专项审计  就 找到审计表里面的  专项审计名称 zxsjmc  是不是  【专项审计】
					sj = new SjService(conn).getSjTable(guid);

					bbprint.put("sjlx",sj.getSjlx());
					bbprint.put("zxsjmc",sj.getZxsjmc());
				}
				if(typename.equals("报备其他")){
					// 如果是报备其他类型 下的  报备
					// 根据 报备编号找到  bb_content1 表里面的 guid
					qt = new BbqtbService(conn).getBbqtbTable(guid);

					bbprint.put("bustype",qt.getBustype());
				}
				
				bbprint.put("typename",typename);
				bbprint.put("guid",guid);
				
				listPrint.add(bbprint);
				
			}
			
			
			
			
			/*
			sql = "select phone from k_micfo where cpano = ? or loginid = ? ";
			String phone1 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa1(),bbprint.getCpa1()});
			String phone2 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa2(),bbprint.getCpa2()});
			String phone3 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa3(),bbprint.getCpa3()});
			String phone4 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa4(),bbprint.getCpa4()});
			String phone5 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa5(),bbprint.getCpa5()});
			String phone6 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa6(),bbprint.getCpa6()});
			
			modelAndView.addObject("phone1", phone1);
			modelAndView.addObject("phone2", phone2);
			modelAndView.addObject("phone3", phone3);
			modelAndView.addObject("phone4", phone4);
			modelAndView.addObject("phone5", phone5);
			modelAndView.addObject("phone6", phone6);
			
			
			String beforeYear = (Integer.parseInt(DateUtil.getDate("yyyy"))-1)+"";
			sql = "SELECT 1 FROM t_inspection WHERE iuser=? AND iyear=?";
			System.out.println("beforeYear : " +beforeYear);
			String isInspection1 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa1(),beforeYear});
			String isInspection2 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa2(),beforeYear});
			String isInspection3 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa3(),beforeYear});
			String isInspection4 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa4(),beforeYear});
			String isInspection5 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa5(),beforeYear});
			String isInspection6 = new DbUtil(conn).queryForString(sql, new String[]{bbprint.getCpa6(),beforeYear});
			
			modelAndView.addObject("isInspection1", isInspection1);
			modelAndView.addObject("isInspection2", isInspection2);
			modelAndView.addObject("isInspection3", isInspection3);
			modelAndView.addObject("isInspection4", isInspection4);
			modelAndView.addObject("isInspection5", isInspection5);
			modelAndView.addObject("isInspection6", isInspection6);
			
			modelAndView.addObject("inspectionYear", beforeYear);
			*/
			
			//modelAndView.addObject("sj", sj);
			//modelAndView.addObject("qt", qt);
			//modelAndView.addObject("typename", typename);
			
			//modelAndView.addObject("print", bbprint);
			//request.getSession().setAttribute("bbprint", bbprint);
			
			modelAndView.addObject("listPrint", listPrint);
			
			request.getSession().setAttribute("listPrint", listPrint);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	public ModelAndView printList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(PRINTLIST);
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		String loginid = (String)userSession.getUserMap().get("loginid");
		String ctype=(String)userSession.getUserMap().get("ctype");
		String cpano=(String)userSession.getUserMap().get("cpano");//注师编号
	
		String wtxmlx = request.getParameter("wtxmlx");
		String wtdw = request.getParameter("wtdw") ;
		String bbtime1 = request.getParameter("bbtime1") ;
		String bbtime2 = request.getParameter("bbtime2") ;
		
		try {
			
			String sql = "select *,left(ysywf,len(ysywf)) as ysywf2,left(ysywfed,len(ysywfed)) as ysywfed2 from bb_view ";
			
			if ("团体会员".equals(ctype)){
				//显示全部是我这个机构的；
				sql+="where BBPERSON = '"+loginid+"' ";
			}else{
				//显示是我审计的；
				sql+="where (cpa1 = '"+cpano+"' or cpa2 = '"+cpano+"'  or cpa3 = '"+cpano+"' or cpa4 = '"+cpano+"' or cpa5 = '"+cpano+"' or cpa6 = '"+cpano+"')";
			}
			
			sql += " and bbstate!='暂存' and bbstate!='作废'  ${person} ";
			
			if(wtxmlx!=null && !"".equals(wtxmlx)){
				//sql += " and wtxmlx like '%"+wtxmlx+"%' ";
				sql += " and wtxmlx = '"+wtxmlx+"' ";
			}
			
			if(wtdw!=null && !"".equals(wtdw)){
				sql += " and wtdwmc like '%"+wtdw+"%' ";
			}
			
			if(bbtime1!=null && !"".equals(bbtime1) && bbtime2!=null && !"".equals(bbtime2)){
				sql += " and bbtime between '"+bbtime1+"' and '"+bbtime2+"' ";
			}else{
				if(bbtime1!=null && !"".equals(bbtime1)){
					sql += " and bbtime like '%"+bbtime1+"%' ";
				}
				if(bbtime2!=null && !"".equals(bbtime2)){
					sql += " and bbtime like '%"+bbtime2+"%' ";
				}
			}
			
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String bbbh = getRequestValue("bbbh") ;
					
					if(bbbh == null || "".equals(bbbh)) {
						bbbh = "" ;
					}else {
						bbbh = " and bbbh= '"+bbbh+"'";
					}
					this.setOrAddRequestValue("bbbh", bbbh);
				}
			};
			
			pp.setTitle("报告打印信息");
			
			pp.addSqlWhere("person","${person}") ;
			pp.setTableID("reportPrintList");
			
			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			
			
			pp.addColumn("委托项目类型", "wtxmlx").setTdProperty("align='left'");
			pp.addColumn("防伪编号", "bbbh").setTdProperty("align='center'");
			
			pp.addColumn("委托单位", "wtdwmc").setTdProperty("align='left'");
			pp.addColumn("被审（验）单位", "bsdwmc").setTdProperty("align='left'");
			pp.addColumn("业务所在地", "ywarea").setTdProperty("align='center'");
			
			
			pp.addColumn("业务约定书编号", "ywyds").setTdProperty("align='center'");
			pp.addColumn("报告文号 ", "bgwh").setTdProperty("align='center'");
			pp.addColumn("报备状态", "bbstate").setTdProperty("align='center'");
			pp.addColumn("报备时间", "bbtime").setTdProperty("align='center'");
			pp.addColumn("报告日期", "bgrq").setTdProperty("align='center'");
			pp.addColumn("报告年度", "bgnd").setTdProperty("align='center'");
			
			if("事务所".equals((String)userSession.getUserMap().get("officetype"))){
				pp.addColumn("签名注师1", "qmzs1").setTdProperty("align='center'");
				pp.addColumn("签名注师2", "qmzs2").setTdProperty("align='center'");
				pp.addColumn("签名注师3", "qmzs3").setTdProperty("align='center'");
			}else{
				pp.addColumn("签名评估师1", "qmzs1").setTdProperty("align='center'");
				pp.addColumn("签名评估师2", "qmzs2").setTdProperty("align='center'");
				pp.addColumn("签名评估师3", "qmzs3").setTdProperty("align='center'");
			}
			pp.addColumn("业务约定书收费金额", "ysywf2").setTdProperty("align='right'");
			pp.addColumn("已收业务费", "ysywfed2").setTdProperty("align='right'");
			
 			pp.setColumnWidth("150,100,150,150,50,50,50,50,120,100,50,50,50,50,50,50");
			
			pp.setSQL(sql);
			pp.setPageSize_CH(10);
			pp.setOrderBy_CH("bbbh");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addBbqtbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = af.showNull(request.getParameter("typeid"));
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 报备其他
			BbqtbService bs = new BbqtbService(conn);
			
			//　guid,qtcbdxm

			// 报备其他
			BbqtbTable bt = new BbqtbTable();
			bt.setGuid(GUID);
			bt.setQtcbdxm(request.getParameter("qtcbdxm"));
			bt.setBustype(request.getParameter("bustype"));
			bt.setZcze(request.getParameter("zcze"));
			bt.setXssr(request.getParameter("xssr"));
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 报备其他
			bs.addBbqtbTable(bt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 代报事务所
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateBbqtbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area"); 
		String sys_province_cicpa = (String)map.get("sys_province_cicpa"); 
		String tempORFinish = af.showNull(request.getParameter("tempORFinish")); 
		String beforeValue = af.showNull(ct.getBbstate()); 
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 报备其他
			BbqtbTable bt = new BbqtbTable();
			bt.setGuid(request.getParameter("bbqtbguid"));
			bt.setQtcbdxm(request.getParameter("qtcbdxm"));
			bt.setBustype(request.getParameter("bustype"));
			bt.setZcze(request.getParameter("zcze"));
			bt.setXssr(request.getParameter("xssr"));
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 报备其他
			BbqtbService bs = new BbqtbService(conn);
			
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_bbqtb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			
			//一开始没有第三个表页，修改时要新增
			if(bt.getGuid() == null || "".equals(bt.getGuid())){
				bt.setGuid(ct.getGuid());
				bs.addBbqtbTable(bt);
			}else{
				bs.updateBbqtbTable(bt);
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish) 
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			 
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"报备其他","bb_bbqtb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addCcsssqkcjjbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 财产损失税前扣除鉴证
			CcsssqkcjjbService ccs = new CcsssqkcjjbService(conn);
			
			//guid,ccsslb,khsbssje,jzssje,bgyjlx,notblyjly,blyjly 

			// 财产损失税前扣除鉴证
			CcsssqkcjjbTable cct = new CcsssqkcjjbTable();
			cct.setGuid(GUID);
			cct.setCcsslb(request.getParameter("ccsslb"));
			cct.setKhsbssje(request.getParameter("khsbssje"));
			cct.setJzssje(request.getParameter("jzssje"));
			cct.setBgyjlx(request.getParameter("bgyjlx"));
			cct.setNotblyjly(request.getParameter("notblyjly"));
			cct.setBlyjly(request.getParameter("blyjly"));
			

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 财产损失税前扣除鉴证
			ccs.addCcsssqkcjjbTable(cct);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
				
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateCcsssqkcjjbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area"); 
		String sys_province_cicpa = (String)map.get("sys_province_cicpa"); 
		String tempORFinish = af.showNull(request.getParameter("tempORFinish")); 
		String beforeValue = af.showNull(ct.getBbstate()); 
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 财产损失税前扣除鉴证
			CcsssqkcjjbTable cct = new CcsssqkcjjbTable();
			cct.setGuid(request.getParameter("ccsssqkjjguid"));
			cct.setCcsslb(request.getParameter("ccsslb"));
			cct.setKhsbssje(request.getParameter("khsbssje"));
			cct.setJzssje(request.getParameter("jzssje"));
			cct.setBgyjlx(request.getParameter("bgyjlx"));
			cct.setNotblyjly(request.getParameter("notblyjly"));
			cct.setBlyjly(request.getParameter("blyjly"));

			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 财产损失税前扣除鉴证
			CcsssqkcjjbService ccs = new CcsssqkcjjbService(conn);
			
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_ccsssqkcjjb");
			}
			
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(cct.getGuid() == null || "".equals(cct.getGuid())){
				cct.setGuid(ct.getGuid());
				ccs.addCcsssqkcjjbTable(cct);
			}else{
				ccs.updateCcsssqkcjjbTable(cct);
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"财产损失税前扣除鉴证","bb_ccsssqkcjjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addKjdshbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 会计电算化
			KjdshbService ks = new KjdshbService(conn);
			
			//　guid,pjjs

			// 会计电算化
			KjdshbTable kt = new KjdshbTable();
			kt.setGuid(GUID);
			kt.setPjjs(request.getParameter("pjjs"));

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 会计电算化
			ks.addKjdshbTable(kt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
				
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 报备事务所
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateKjdshbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area"); 
		String sys_province_cicpa = (String)map.get("sys_province_cicpa"); 
		String tempORFinish = af.showNull(request.getParameter("tempORFinish")); 
		String beforeValue = af.showNull(ct.getBbstate()); 
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 会计电算化
			KjdshbTable kt = new KjdshbTable();
			kt.setGuid(request.getParameter("kjdshbguid"));
			kt.setPjjs(request.getParameter("pjjs"));

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 会计电算化
			KjdshbService ks = new KjdshbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_kjdshb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(kt.getGuid() == null || "".equals(kt.getGuid())){
				kt.setGuid(ct.getGuid());
				ks.addKjdshbTable(kt);
			}else{
				ks.updateKjdshbTable(kt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"会计电算化","bb_kjdshb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addKjzsbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 会计咨询
			KjzsbService ks = new KjzsbService(conn);
			
			//　guid,zsxm

			// 会计咨询
			KjzsbTable kt = new KjzsbTable();
			kt.setGuid(GUID);
			kt.setZsxm(request.getParameter("zsxm"));

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 会计咨询
			ks.addKjzsbTable(kt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
				
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	

	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateKjzsbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 会计咨询
			KjzsbTable kt = new KjzsbTable();
			kt.setGuid(request.getParameter("kjzsbguid"));
			kt.setZsxm(request.getParameter("zsxm"));

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 会计咨询
			KjzsbService ks = new KjzsbService(conn);
			
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_kjzsb");
			}
			
			
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(kt.getGuid() == null || "".equals(kt.getGuid())){
				kt.setGuid(ct.getGuid());
				ks.addKjzsbTable(kt);
			}else{
				ks.updateKjzsbTable(kt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"会计咨询","bb_kjzsb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addQchzbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 清产核资
			QchzbService qs = new QchzbService(conn);
			
			//　guid,zcze,fzze,jzze

			// 清产核资
			QchzbTable qt = new QchzbTable();
			qt.setGuid(GUID);
			qt.setZcze(request.getParameter("zcze"));
			qt.setFzze(request.getParameter("fzze"));
			qt.setJzze(request.getParameter("jzze")); 
			qt.setCyry(request.getParameter("cyry")); 
			qt.setXssr(request.getParameter("xssr")); 
			
			String sftzje = request.getParameter("sftzje");
			qt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				qt.setZczetzh(request.getParameter("zczetzh"));
				qt.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				qt.setZczetzh("0");
				qt.setXssrtzh("0");
			}
			qt.setJzrq(request.getParameter("jzrq"));//截止日期

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 清产核资
			qs.addQchzbTable(qt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateQchzbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 清产核资
			QchzbTable qt = new QchzbTable();
			qt.setGuid(request.getParameter("qchzbguid"));
			qt.setZcze(request.getParameter("zcze"));
			qt.setFzze(request.getParameter("fzze"));
			qt.setJzze(request.getParameter("jzze")); 
			qt.setCyry(request.getParameter("cyry")); 
			qt.setXssr(request.getParameter("xssr")); 
			
			String sftzje = request.getParameter("sftzje");
			qt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				qt.setZczetzh(request.getParameter("zczetzh"));
				qt.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				qt.setZczetzh("0");
				qt.setXssrtzh("0");
			}
			qt.setJzrq(request.getParameter("jzrq"));//截止日期
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 清产核资
			QchzbService qs = new QchzbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_qchzb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(qt.getGuid() == null || "".equals(qt.getGuid())){
				qt.setGuid(ct.getGuid());
				qs.addQchzbTable(qt);
			}else{
				qs.updateQchzbTable(qt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"清产核资","bb_qchzb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addQsshbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 清算审计
			QsshbService qs = new QsshbService(conn);
			
			//guid,qslx,qsjsy,qssd,ylssde,ylsde,bgyjlx,notblyjly,bjyjly

			// 清算审计
			QsshbTable qt = new QsshbTable();
			qt.setGuid(GUID);
			qt.setQslx(request.getParameter("qslx"));
			qt.setQsjsy(request.getParameter("qsjsy"));
			
			/*
			qt.setZcze(request.getParameter("zcze"));
			qt.setXssr(request.getParameter("xssr"));
			*/
			
			qt.setZcze(request.getParameter("zczetotal"));
			qt.setXssr(request.getParameter("xssrtotal"));
			qt.setYysr(request.getParameter("yysrtotal"));
			
			qt.setQssd(request.getParameter("qssd")); 
			qt.setYlssde(request.getParameter("ylssde"));
			qt.setYlsde(request.getParameter("ylsde"));
			qt.setBgyjlx(request.getParameter("bgyjlx"));
			qt.setNotblyjly(request.getParameter("notblyjly"));
			qt.setBjyjly(request.getParameter("bjyjly"));
			
			String sftzje = request.getParameter("sftzje");
			qt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				qt.setZczetzh(request.getParameter("zczetzh"));
				qt.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				qt.setZczetzh("");
				qt.setXssrtzh("");
			}
			
			/*
			qt.setCyry(request.getParameter("cyry"));
			*/
			qt.setCyry(request.getParameter("cyrytotal"));
			qt.setSjns(request.getParameter("sjns"));
			qt.setZxsjje(request.getParameter("zxsjjetotal"));

			
			
			
			
			

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 清算审计
			qs.addQsshbTable(qt);

			// 保存审计金额
			saveMoney(request,conn,GUID,typeid);
			
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
 		   
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			 // 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateQsshbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 清算审计
			QsshbTable qt = new QsshbTable();
			qt.setGuid(request.getParameter("qsshbguid"));
			qt.setQslx(request.getParameter("qslx"));
			qt.setQsjsy(request.getParameter("qsjsy"));
			
			/*
			qt.setZcze(request.getParameter("zcze"));
			qt.setXssr(request.getParameter("xssr"));
			*/
			qt.setZcze(request.getParameter("zczetotal"));
			qt.setXssr(request.getParameter("xssrtotal"));
			qt.setYysr(request.getParameter("yysrtotal"));
			
			qt.setQssd(request.getParameter("qssd"));
			qt.setYlssde(request.getParameter("ylssde"));
			qt.setYlsde(request.getParameter("ylsde"));
			qt.setBgyjlx(request.getParameter("bgyjlx"));
			qt.setNotblyjly(request.getParameter("notblyjly"));
			qt.setBjyjly(request.getParameter("bjyjly"));
			
			String sftzje = request.getParameter("sftzje");
			qt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				qt.setZczetzh(request.getParameter("zczetzh"));
				qt.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				qt.setZczetzh("0");
				qt.setXssrtzh("0");
			}
			
			
			/*
			qt.setCyry(request.getParameter("cyry"));
			*/
			qt.setCyry(request.getParameter("cyrytotal"));
			qt.setSjns(request.getParameter("sjns"));
			qt.setZxsjje(request.getParameter("zxsjjetotal"));

			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 清算审计
			QsshbService qs = new QsshbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_qsshb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(qt.getGuid() == null || "".equals(qt.getGuid())){
				qt.setGuid(ct.getGuid());
				qs.addQsshbTable(qt);
				// 保存审计金额
				saveMoney(request,conn,ct.getGuid(),typeid);
			}else{
				qs.updateQsshbTable(qt);	
				// 保存审计金额
				saveMoney(request,conn,qt.getGuid(),typeid);
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"清算审计","bb_qsshb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addFlsjbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 分立审计
			FlsjbService fl = new FlsjbService(conn);
			
			//guid,qslx,qsjsy,qssd,ylssde,ylsde,bgyjlx,notblyjly,bjyjly

			// 分立审计
			FlsjbTable ft = new FlsjbTable();
			ft.setGuid(GUID);
			ft.setQslx(request.getParameter("qslx"));
			ft.setQsjsy(request.getParameter("qsjsy"));
			ft.setZcze(request.getParameter("zcze"));
			ft.setXssr(request.getParameter("xssr"));
			ft.setQssd(request.getParameter("qssd")); 
			ft.setYlssde(request.getParameter("ylssde"));
			ft.setYlsde(request.getParameter("ylsde"));
			ft.setBgyjlx(request.getParameter("bgyjlx"));
			ft.setNotblyjly(request.getParameter("notblyjly"));
			ft.setBjyjly(request.getParameter("bjyjly"));
			ft.setCyry(request.getParameter("cyry"));
			
			String sftzje = request.getParameter("sftzje");
			ft.setSftzje(sftzje);
			if("是".equals(sftzje)){
				ft.setZczetzh(request.getParameter("zczetzh"));
				ft.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				ft.setZczetzh("0");
				ft.setXssrtzh("0");
			}
			

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 分立审计
			fl.addFlsjbTable(ft);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
				
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			 // 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateFlsjbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 分立审计
			FlsjbTable fl = new FlsjbTable();
			fl.setGuid(request.getParameter("qsshbguid"));
			fl.setQslx(request.getParameter("qslx"));
			fl.setQsjsy(request.getParameter("qsjsy"));
			fl.setZcze(request.getParameter("zcze"));
			fl.setXssr(request.getParameter("xssr"));
			fl.setQssd(request.getParameter("qssd"));
			fl.setYlssde(request.getParameter("ylssde"));
			fl.setYlsde(request.getParameter("ylsde"));
			fl.setBgyjlx(request.getParameter("bgyjlx"));
			fl.setNotblyjly(request.getParameter("notblyjly"));
			fl.setBjyjly(request.getParameter("bjyjly"));
			fl.setCyry(request.getParameter("cyry"));
			
			String sftzje = request.getParameter("sftzje");
			fl.setSftzje(sftzje);
			if("是".equals(sftzje)){
				fl.setZczetzh(request.getParameter("zczetzh"));
				fl.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				fl.setZczetzh("0");
				fl.setXssrtzh("0");
			}
			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 分立审计
			FlsjbService fls = new FlsjbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_flsjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(fl.getGuid() == null || "".equals(fl.getGuid())){
				fl.setGuid(ct.getGuid());
				fls.addFlsjbTable(fl);
			}else{
				fls.updateFlsjbTable(fl);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"分立审计","bb_flsjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addHbsjbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 合并审计
			HbsjbService hs = new HbsjbService(conn);
			
			//guid,qslx,qsjsy,qssd,ylssde,ylsde,bgyjlx,notblyjly,bjyjly

			// 合并审计
			HbsjbTable ht = new HbsjbTable();
			
			ht.setGuid(GUID);
			ht.setQslx(request.getParameter("qslx"));
			ht.setQsjsy(request.getParameter("qsjsy"));
			ht.setZcze(request.getParameter("zcze"));
			ht.setXssr(request.getParameter("xssr"));
			
			ht.setQssd(request.getParameter("qssd")); 
			ht.setYlssde(request.getParameter("ylssde"));
			ht.setYlsde(request.getParameter("ylsde"));
			ht.setBgyjlx(request.getParameter("bgyjlx"));
			ht.setNotblyjly(request.getParameter("notblyjly"));
			
			ht.setBjyjly(request.getParameter("bjyjly"));
			ht.setCyry(request.getParameter("cyry"));
			
			String sftzje = request.getParameter("sftzje");
			ht.setSftzje(sftzje);
			if("是".equals(sftzje)){
				ht.setZczetzh(request.getParameter("zczetzh"));
				ht.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				ht.setZczetzh("0");
				ht.setXssrtzh("0");
			}
			

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 合并审计
			hs.addHbsjbTable(ht);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}

 		    // 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateHbsjbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 合并审计
			HbsjbTable ht = new HbsjbTable();

			ht.setGuid(request.getParameter("qsshbguid"));
			ht.setQslx(request.getParameter("qslx"));
			ht.setQsjsy(request.getParameter("qsjsy"));
			ht.setZcze(request.getParameter("zcze"));
			ht.setXssr(request.getParameter("xssr"));
			
			ht.setQssd(request.getParameter("qssd"));
			ht.setYlssde(request.getParameter("ylssde"));
			ht.setYlsde(request.getParameter("ylsde"));
			ht.setBgyjlx(request.getParameter("bgyjlx"));
			ht.setNotblyjly(request.getParameter("notblyjly"));

			ht.setBjyjly(request.getParameter("bjyjly"));
			ht.setCyry(request.getParameter("cyry"));
			String sftzje = request.getParameter("sftzje");
			ht.setSftzje(sftzje);
			if("是".equals(sftzje)){
				ht.setZczetzh(request.getParameter("zczetzh"));
				ht.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				ht.setZczetzh("0");
				ht.setXssrtzh("0");
			}
			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 合并审计
			HbsjbService hs = new HbsjbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_hbsjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(ht.getGuid() == null || "".equals(ht.getGuid())){
				ht.setGuid(ct.getGuid());
				hs.addHbsjbTable(ht);
			}else{
				hs.updateHbsjbTable(ht);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"合并审计","bb_hbsjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addQtssjjbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 其他涉税鉴证表
			QtssjjbService qs = new QtssjjbService(conn);
			
			//guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,lstzzje,lstzjse,ylssde,sysl,sjylssd,
			//yyjsdse,bqybsdlse,slsjg,gsswdjh,dsswdjh,slswjgmc,bgyjlx,notblyjly,blyjly

			// 其他涉税鉴证表
			QtssjjbTable qt = new QtssjjbTable();
			qt.setGuid(GUID);
			qt.setSrze(request.getParameter("srze"));
			qt.setXssr(request.getParameter("xssr"));
			qt.setXscb(request.getParameter("xscb"));
			qt.setQjfy(request.getParameter("qjfy"));
			qt.setLrze(request.getParameter("lrze"));
			qt.setLstzqsde(request.getParameter("lstzqsde"));
			qt.setLstzzje(request.getParameter("lstzzje"));
			qt.setLstzjse(request.getParameter("lstzjse"));
			qt.setYlssde(request.getParameter("ylssde"));
			qt.setSysl(request.getParameter("sysl"));
			qt.setSjylssd(request.getParameter("sjylssd")); 
			
			qt.setYyjsdse(request.getParameter("yyjsdse"));
			qt.setBqybsdlse(request.getParameter("bqybsdlse"));
			qt.setSlsjg(request.getParameter("slsjg"));
			qt.setGsswdjh(request.getParameter("gsswdjh"));
			qt.setDsswdjh(request.getParameter("dsswdjh"));
			qt.setSlswjgmc(request.getParameter("slswjgmc"));
			qt.setBgyjlx(request.getParameter("bgyjlx"));
			qt.setNotblyjly(request.getParameter("notblyjly"));
			qt.setBlyjly(request.getParameter("blyjly"));

			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 其他涉税鉴证表
			qs.addQtssjjTable(qt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}

			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateQtssjjbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 其他涉税鉴证表
			QtssjjbTable qt = new QtssjjbTable();
			qt.setGuid(request.getParameter("qtssjjbguid"));
			qt.setSrze(request.getParameter("srze"));
			qt.setXssr(request.getParameter("xssr"));
			qt.setXscb(request.getParameter("xscb"));
			qt.setQjfy(request.getParameter("qjfy"));
			qt.setLrze(request.getParameter("lrze"));
			qt.setLstzqsde(request.getParameter("lstzqsde"));
			qt.setLstzzje(request.getParameter("lstzzje"));
			qt.setLstzjse(request.getParameter("lstzjse"));
			qt.setYlssde(request.getParameter("ylssde"));
			qt.setSysl(request.getParameter("sysl"));
			qt.setSjylssd(request.getParameter("sjylssd")); 
			
			qt.setYyjsdse(request.getParameter("yyjsdse"));
			qt.setBqybsdlse(request.getParameter("bqybsdlse"));
			qt.setSlsjg(request.getParameter("slsjg"));
			qt.setGsswdjh(request.getParameter("gsswdjh"));
			qt.setDsswdjh(request.getParameter("dsswdjh"));
			qt.setSlswjgmc(request.getParameter("slswjgmc"));
			qt.setBgyjlx(request.getParameter("bgyjlx"));
			qt.setNotblyjly(request.getParameter("notblyjly"));
			qt.setBlyjly(request.getParameter("blyjly"));

			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 其他涉税鉴证表
			QtssjjbService qs = new QtssjjbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_qtssjjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(qt.getGuid() == null || "".equals(qt.getGuid())){
				qt.setGuid(ct.getGuid());
				qs.addQtssjjTable(qt);
			}else{
				qs.updateQtssjjTable(qt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"其他涉税鉴证","bb_qtssjjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addSdshsqjTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");  
		String loginname = (String)map.get("loginname");  
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 所得税汇算清缴信息
			SdshsqjService ss = new SdshsqjService(conn);
			
			//guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,
			//lstzzje,lstzjse,ylssde,sysl,sjylssd,yjlssde,bqybsde,
			//slswjg,gsswdjh,dsswdjh,sjswjgmc,bgyjlx,notblyj,blyj

			// 所得税汇算清缴信息
			SdshsqjTable st = new SdshsqjTable();
			st.setGuid(GUID);
			st.setSrze(request.getParameter("srze"));
			st.setXssr(request.getParameter("xssr"));
			st.setXscb(request.getParameter("xscb"));
			st.setQjfy(request.getParameter("qjfy"));
			st.setLrze(request.getParameter("lrze"));
			st.setLstzqsde(request.getParameter("lstzqsde"));
			
			st.setLstzzje(request.getParameter("lstzzje"));
			st.setLstzjse(request.getParameter("lstzjse"));
			st.setYlssde(request.getParameter("ylssde"));
			st.setSysl(request.getParameter("sysl"));
			st.setSjylssd(request.getParameter("sjylssd"));
			st.setYjlssde(request.getParameter("yjlssde"));
			st.setBqybsde(request.getParameter("bqybsde"));
			
			st.setSlswjg(request.getParameter("slswjg"));
			st.setGsswdjh(request.getParameter("gsswdjh"));
			st.setDsswdjh(request.getParameter("dsswdjh"));
			st.setSjswjgmc(request.getParameter("sjswjgmc"));
			st.setBgyjlx(request.getParameter("bgyjlx"));
			st.setNotblyj(request.getParameter("notblyj"));
			st.setBlyj(request.getParameter("blyj"));

			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 所得税汇算清缴
			ss.addSdshsqjTable(st);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateSdshsqjTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		 
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 所得税汇算清缴信息
			SdshsqjTable st = new SdshsqjTable();
			st.setGuid(request.getParameter("stguid"));
			st.setSrze(request.getParameter("srze"));
			st.setXssr(request.getParameter("xssr"));
			st.setXscb(request.getParameter("xscb"));
			st.setQjfy(request.getParameter("qjfy"));
			st.setLrze(request.getParameter("lrze"));
			st.setLstzqsde(request.getParameter("lstzqsde"));
			
			st.setLstzzje(request.getParameter("lstzzje"));
			st.setLstzjse(request.getParameter("lstzjse"));
			st.setYlssde(request.getParameter("ylssde"));
			st.setSysl(request.getParameter("sysl"));
			st.setSjylssd(request.getParameter("sjylssd"));
			st.setYjlssde(request.getParameter("yjlssde"));
			st.setBqybsde(request.getParameter("bqybsde"));
			
			st.setSlswjg(request.getParameter("slswjg"));
			st.setGsswdjh(request.getParameter("gsswdjh"));
			st.setDsswdjh(request.getParameter("dsswdjh"));
			st.setSjswjgmc(request.getParameter("sjswjgmc"));
			st.setBgyjlx(request.getParameter("bgyjlx"));
			st.setNotblyj(request.getParameter("notblyj"));
			st.setBlyj(request.getParameter("blyj"));

			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 所得税汇算清缴
			SdshsqjService ss = new SdshsqjService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_sdshsqjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(st.getGuid() == null || "".equals(st.getGuid())){
				st.setGuid(ct.getGuid());
				ss.addSdshsqjTable(st);
			}else{
				ss.updateSdshsqjTable(st);	
			}
			

			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			

			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"所得税汇算清缴","bb_sdshsqjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addSjTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 审计信息
			SjService ss = new SjService(conn);
			
			//guid,sjlx,zxsjmc,bgyt,sjbgnd,hbhs,kgssgss,
			//gpdm,sflxsj,qykjsswsmc,sjbgyjlx,notblyjlx,blyjlx,
			//xssr,yysr,zcze,fzze,lrze,ylsde,jlr,ylsdse,xmzrs,wqgzts

			// 审计信息
			SjTable st = new SjTable();
			st.setGuid(GUID);
			st.setSjlx(request.getParameter("sjlx"));
			st.setZxsjmc(request.getParameter("zxsjmc"));
			st.setBgyt(request.getParameter("bgyt"));
			st.setSjbgnd(request.getParameter("sjbgnd"));
			st.setHbhs(request.getParameter("hbhs"));
			st.setKgssgss(request.getParameter("kgssgss"));
			st.setGpdm(request.getParameter("gpdm"));
			st.setSflxsj(request.getParameter("sflxsj"));
			st.setQykjsswsmc(request.getParameter("qykjsswsmc"));
			
			st.setSjbgyjlx(request.getParameter("sjbgyjlx"));
			st.setNotblyjlx(request.getParameter("notblyjlx"));
			st.setBlyjlx(request.getParameter("blyjlx"));
			
			/*
			st.setXssr(request.getParameter("xssr"));
			st.setYysr(request.getParameter("yysr"));
			st.setZcze(request.getParameter("zcze"));
			*/

			st.setXssr(request.getParameter("xssrtotal"));
			st.setYysr(request.getParameter("yysrtotal"));
			st.setZcze(request.getParameter("zczetotal"));
			
			st.setFzze(request.getParameter("fzze"));
			st.setLrze(request.getParameter("lrze"));
			st.setYlsde(request.getParameter("ylsde"));
			
			st.setJlr(request.getParameter("jlr"));
			st.setYlsdse(request.getParameter("ylsdse"));
			st.setXmzrs(request.getParameter("xmzrs"));
			st.setWqgzts(request.getParameter("wqgzts"));

			/*
			st.setCyry(request.getParameter("cyry"));
			*/
			
			st.setCyry(request.getParameter("cyrytotal"));
			
			st.setSjns(request.getParameter("sjns"));
			st.setZxsjje(request.getParameter("zxsjjetotal"));
			
			st.setSyzqy(request.getParameter("syzqy"));//增加所有者权益
			
			// 设置最后一年调整后金额
			String sftzje = request.getParameter("sftzje");
			st.setSftzje(sftzje);
			if("是".equals(sftzje)){
				String sjlx = request.getParameter("sjlx");
				if("经济责任审计".equals(sjlx)){
					st.setZczetzh(request.getParameter("zczetzh"));
					st.setXssrtzh(request.getParameter("xssrtzh"));
					st.setYysrtzh("0");
					st.setZxsjjetzh("0");
				}else if("专项审计".equals(sjlx)){
					st.setZczetzh("0");
					st.setXssrtzh("0");
					st.setYysrtzh("0");
					st.setZxsjjetzh(request.getParameter("zxsjjetzh"));
				}else{
					st.setZczetzh(request.getParameter("zczetzh"));
					st.setXssrtzh(request.getParameter("xssrtzh"));
					st.setYysrtzh(request.getParameter("yysrtzh"));
					//增加
					st.setFzzetzh(request.getParameter("fzzetzh"));
					st.setSyzqytzh(request.getParameter("syzqytzh"));
					st.setJlrtzh(request.getParameter("jlrtzh"));
					st.setZxsjjetzh("0");
				}
			}else{
				st.setZczetzh("0");
				st.setXssrtzh("0");
				st.setYysrtzh("0");
				st.setZxsjjetzh("0");
			}
			
			st.setXywtz(request.getParameter("xywtz"));
			st.setZctz(request.getParameter("zctz"));
			st.setZctj(request.getParameter("zctj"));
			st.setLrtz(request.getParameter("lrtz"));
			st.setLrtj(request.getParameter("lrtj"));
			st.setSstz(request.getParameter("sstz"));
			st.setSstj(request.getParameter("sstj"));
			st.setFzgyzclsje(request.getParameter("fzgyzclsje"));
			st.setXmjzje(request.getParameter("xmjzje"));
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 审计
			ss.addSjTable(st);
			
			// 保存审计金额
			saveMoney(request,conn,GUID,typeid);
			
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
				
			}
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}

			// 每一笔报备的联系人可能都不一样
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateSjTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			/// 审计信息
			SjTable st = new SjTable();
			st.setGuid(request.getParameter("sjguid"));
			st.setSjlx(request.getParameter("sjlx"));
			st.setZxsjmc(request.getParameter("zxsjmc"));
			st.setBgyt(request.getParameter("bgyt"));
			st.setSjbgnd(request.getParameter("sjbgnd"));
			st.setHbhs(request.getParameter("hbhs"));
			st.setKgssgss(request.getParameter("kgssgss"));
			st.setGpdm(request.getParameter("gpdm"));
			st.setSflxsj(request.getParameter("sflxsj"));
			st.setQykjsswsmc(request.getParameter("qykjsswsmc"));
			
			st.setSjbgyjlx(request.getParameter("sjbgyjlx"));
			st.setNotblyjlx(request.getParameter("notblyjlx"));
			st.setBlyjlx(request.getParameter("blyjlx"));
			
			/*
			st.setXssr(request.getParameter("xssr"));
			st.setYysr(request.getParameter("yysr"));
			st.setZcze(request.getParameter("zcze"));
			*/
			
			st.setXssr(request.getParameter("xssrtotal"));
			st.setYysr(request.getParameter("yysrtotal"));
			st.setZcze(request.getParameter("zczetotal"));
			
			st.setFzze(request.getParameter("fzze"));
			st.setLrze(request.getParameter("lrze"));
			st.setYlsde(request.getParameter("ylsde"));
			st.setJlr(request.getParameter("jlr"));

			st.setYlsdse(request.getParameter("ylsdse"));
			st.setXmzrs(request.getParameter("xmzrs"));
			st.setWqgzts(request.getParameter("wqgzts"));
			
			/*
			st.setCyry(request.getParameter("cyry"));
			*/
			
			st.setCyry(request.getParameter("cyrytotal"));
			st.setSjns(request.getParameter("sjns"));
			st.setZxsjje(request.getParameter("zxsjjetotal"));

			st.setSyzqy(request.getParameter("syzqy"));//增加所有者权益
			
			// 设置最后一年调整后金额
			String sftzje = request.getParameter("sftzje");
			st.setSftzje(sftzje);
			if("是".equals(sftzje)){
				String sjlx = request.getParameter("sjlx");
				if("经济责任审计".equals(sjlx)){
					st.setZczetzh(request.getParameter("zczetzh"));
					st.setXssrtzh(request.getParameter("xssrtzh"));
					st.setYysrtzh("0");
					st.setZxsjjetzh("0");
				}else if("专项审计".equals(sjlx)){
					st.setZczetzh("0");
					st.setXssrtzh("0");
					st.setYysrtzh("0");
					st.setZxsjjetzh(request.getParameter("zxsjjetzh"));
				}else{
					st.setZczetzh(request.getParameter("zczetzh"));
					st.setXssrtzh(request.getParameter("xssrtzh"));
					st.setYysrtzh(request.getParameter("yysrtzh"));
					//增加
					st.setFzzetzh(request.getParameter("fzzetzh"));
					st.setSyzqytzh(request.getParameter("syzqytzh"));
					st.setJlrtzh(request.getParameter("jlrtzh"));
					st.setZxsjjetzh("0");
				}
			}else{
				st.setZczetzh("0");
				st.setXssrtzh("0");
				st.setYysrtzh("0");
				st.setZxsjjetzh("0");
			}
			
			st.setXywtz(request.getParameter("xywtz"));
			st.setZctz(request.getParameter("zctz"));
			st.setZctj(request.getParameter("zctj"));
			st.setLrtz(request.getParameter("lrtz"));
			st.setLrtj(request.getParameter("lrtj"));
			st.setSstz(request.getParameter("sstz"));
			st.setSstj(request.getParameter("sstj"));
			st.setFzgyzclsje(request.getParameter("fzgyzclsje"));
			st.setXmjzje(request.getParameter("xmjzje"));
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 审计
			SjService ss = new SjService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_sjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(st.getGuid() == null || "".equals(st.getGuid())){
				st.setGuid(ct.getGuid());
				ss.addSjTable(st);
				// 保存审计金额
				saveMoney(request,conn,ct.getGuid(),typeid);
			}else{
				ss.updateSjTable(st);
				// 保存审计金额
				saveMoney(request,conn,st.getGuid(),typeid);	
			}
			

			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"审计","bb_sjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addSwdlbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		System.out.println("addSwdlbTable报备号："+ct.getBbbh());
		
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginnam"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {

			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 税务代理
			SwdlbService ss = new SwdlbService(conn);
			
			//guid,dlxm

			// 税务代理
			SwdlbTable st = new SwdlbTable();
			st.setGuid(GUID);
			st.setDlxm(request.getParameter("dlxm")); 

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 税务代理
			ss.addSwdlbTable(st);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}				
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateSwdlbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 税务代理
			SwdlbTable st = new SwdlbTable();
			st.setGuid(request.getParameter("swdlbguid"));
			st.setDlxm(request.getParameter("dlxm")); 

			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 税务代理
			SwdlbService ss = new SwdlbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_swdlb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(st.getGuid() == null || "".equals(st.getGuid())){
				st.setGuid(ct.getGuid());
				ss.addSwdlbTable(st);
			}else{
				ss.updateSwdlbTable(st);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"税务代理","bb_swdlb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addWhnjTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");  
		String loginname = (String)map.get("loginname");  
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 外汇年检信息
			WhnjService ws = new WhnjService(conn);
			
			// guid,whdjzh,bz,whsrzj,whzczj,jcxmce,qtzc,whhbjj,
			// jchj,ssjwjb,ssjlwhjb,jwjk,xmzrs,wqgzts
			

			// 外汇年检信息
			WhnjTable wt = new WhnjTable();
			wt.setGuid(GUID);
			wt.setWhdjzh(request.getParameter("whdjzh"));
			wt.setBz(request.getParameter("bz"));
			wt.setWhsrzj(request.getParameter("whsrzj"));
			wt.setWhzczj(request.getParameter("whzczj"));
			wt.setJcxmce(request.getParameter("jcxmce"));
			wt.setQtzc(request.getParameter("qtzc"));
			wt.setWhhbjj(request.getParameter("whhbjj"));
			wt.setJchj(request.getParameter("jchj"));
			wt.setSsjwjb(request.getParameter("ssjwjb"));
			wt.setSsjlwhjb(request.getParameter("ssjlwhjb"));
			wt.setJwjk(request.getParameter("jwjk"));
			wt.setXmzrs(request.getParameter("xmzrs"));
			wt.setWqgzts(request.getParameter("wqgzts")); 
			String sftzje = request.getParameter("sftzje");
			wt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				wt.setZczetzh(request.getParameter("zczetzh"));
			}else{
				wt.setZczetzh("0");
			}
			
			//新增加wfcze,whcdwfgl,wfdlcsye,whzhye
			wt.setWfcze(request.getParameter("wfcze"));
			wt.setWhcdwfgl(request.getParameter("whcdwfgl"));
			wt.setWfdlcsye(request.getParameter("wfdlcsye"));
			wt.setWhzhye(request.getParameter("whzhye"));
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 外汇年检
			ws.addWhnjTable(wt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}				
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateWhnjTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		

		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 外汇年检信息
			WhnjTable wt = new WhnjTable();
			wt.setGuid(request.getParameter("whnjguid"));
			wt.setWhdjzh(request.getParameter("whdjzh"));
			wt.setBz(request.getParameter("bz"));
			wt.setWhsrzj(request.getParameter("whsrzj"));
			wt.setWhzczj(request.getParameter("whzczj"));
			wt.setJcxmce(request.getParameter("jcxmce"));
			wt.setQtzc(request.getParameter("qtzc"));
			wt.setWhhbjj(request.getParameter("whhbjj"));
			wt.setJchj(request.getParameter("jchj"));
			wt.setSsjwjb(request.getParameter("ssjwjb"));
			wt.setSsjlwhjb(request.getParameter("ssjlwhjb"));
			wt.setJwjk(request.getParameter("jwjk"));
			wt.setXmzrs(request.getParameter("xmzrs"));
			wt.setWqgzts(request.getParameter("wqgzts")); 
			String sftzje = request.getParameter("sftzje");
			wt.setSftzje(sftzje);
			if("是".equals(sftzje)){
				wt.setZczetzh(request.getParameter("zczetzh"));
			}else{
				wt.setZczetzh("0");
			}
			
			//新增加wfcze,whcdwfgl,wfdlcsye,whzhye
			wt.setWfcze(request.getParameter("wfcze"));
			wt.setWhcdwfgl(request.getParameter("whcdwfgl"));
			wt.setWfdlcsye(request.getParameter("wfdlcsye"));
			wt.setWhzhye(request.getParameter("whzhye"));
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 外汇年检
			WhnjService ws = new WhnjService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_whnjb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(wt.getGuid() == null || "".equals(wt.getGuid())){
				wt.setGuid(ct.getGuid());
				ws.addWhnjTable(wt);
			}else{
				ws.updateWhnjTable(wt);	
			}
			

			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			

			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"外汇年检","bb_whnjb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addYzbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		System.out.println("addSwdlbTable报备号："+ct.getBbbh());
		System.out.println("是否打包项目："+ct.getSfdbxm());
		System.out.println("打包项目名称："+ct.getDbxmmc());
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 验资信息
			YzbService ys = new YzbService(conn);
			

			// 验资信息
			YzbTable yt = new YzbTable();
			yt.setGuid(GUID);
			yt.setYzbz(request.getParameter("yzbz"));
			yt.setYzhl(request.getParameter("yzhl"));
			yt.setYzbzje(request.getParameter("yzbzje"));
			
			yt.setYzswje(request.getParameter("yzswje"));
			yt.setYztdsyje(request.getParameter("yztdsyje"));
			yt.setYzqtwszcje(request.getParameter("yzqtwszcje"));
			yt.setYzqtje(request.getParameter("yzqtje"));
			yt.setBqyzwfczxhje(request.getParameter("bqyzwfczxhje"));
			yt.setBqyzwfczswje(request.getParameter("bqyzwfczswje"));
			yt.setBqyzwfczlyztzje(request.getParameter("bqyzwfczlyztzje"));
			yt.setBqyzwfczwxzcje(request.getParameter("bqyzwfczwxzcje"));
			yt.setBqyzwfczqtje(request.getParameter("bqyzwfczqtje"));
			yt.setYzzl(request.getParameter("yzzl"));
			yt.setZj(request.getParameter("zj"));
			yt.setGfzy(request.getParameter("gfzy"));
			yt.setJz(request.getParameter("jz"));
			yt.setYzjzr(request.getParameter("yzjzr"));
			yt.setGd1(request.getParameter("gd1"));
			yt.setGd2(request.getParameter("gd2"));
			yt.setGd3(request.getParameter("gd3"));
			yt.setGd4(request.getParameter("gd4"));
			yt.setQtgd(request.getParameter("qtgd"));
			yt.setSjbgyjlx(request.getParameter("sjbgyjlx"));
			yt.setBlyjlx(request.getParameter("blyjlx"));
			yt.setNotblyjlx(request.getParameter("notblyjlx"));

			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 验资
			ys.addYzbTable(yt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
		
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateYzbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		System.out.println(this.getClass()+"        updateSfkjjdbTableById   >>>>>>>>>>>>>>>> cjt.getWtdwmc() ="+ct.getWtdwmc()+"     typeid ="+typeid );
		
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			
			// 验资信息
			YzbTable yt = new YzbTable();
			
			yt.setGuid(request.getParameter("yzbguid"));
			
			yt.setYzbz(request.getParameter("yzbz"));
			yt.setYzhl(request.getParameter("yzhl"));
			yt.setYzbzje(request.getParameter("yzbzje"));
			yt.setYzswje(request.getParameter("yzswje"));
			yt.setYztdsyje(request.getParameter("yztdsyje"));
			yt.setYzqtwszcje(request.getParameter("yzqtwszcje"));
			yt.setYzqtje(request.getParameter("yzqtje"));
			yt.setBqyzwfczxhje(request.getParameter("bqyzwfczxhje"));
			yt.setBqyzwfczswje(request.getParameter("bqyzwfczswje"));
			yt.setBqyzwfczlyztzje(request.getParameter("bqyzwfczlyztzje"));
			yt.setBqyzwfczwxzcje(request.getParameter("bqyzwfczwxzcje"));
			yt.setBqyzwfczqtje(request.getParameter("bqyzwfczqtje"));
			yt.setYzzl(request.getParameter("yzzl"));
			yt.setZj(request.getParameter("zj"));
			yt.setGfzy(request.getParameter("gfzy"));
			yt.setJz(request.getParameter("jz"));
			yt.setYzjzr(request.getParameter("yzjzr"));
			yt.setGd1(request.getParameter("gd1"));
			yt.setGd2(request.getParameter("gd2"));
			yt.setGd3(request.getParameter("gd3"));
			yt.setGd4(request.getParameter("gd4"));
			yt.setQtgd(request.getParameter("qtgd"));
			yt.setSjbgyjlx(request.getParameter("sjbgyjlx"));
			yt.setBlyjlx(request.getParameter("blyjlx"));
			yt.setNotblyjlx(request.getParameter("notblyjlx"));
			
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			// 报备编号
			//ct.setBbbh(new DELAutocode().getAutoCode("报备编号", address));
			//System.out.println(this.getClass()+"     >>>>>>>>  new DELAutocode().getAutoCode(报备编号, address)="+new DELAutocode().getAutoCode("报备编号", address));

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 验资
			YzbService ys = new YzbService(conn);

			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_yzb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(yt.getGuid() == null || "".equals(yt.getGuid())){
				yt.setGuid(ct.getGuid());
				ys.addYzbTable(yt);
			}else{
				ys.updateYzbTable(yt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}

			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});

			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"验资","bb_yzb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addZcpgbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");  
		String loginname = (String)map.get("loginname");  
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {

			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 资产评估
			ZcpgbService zs = new ZcpgbService(conn);
			
			//guid,pgmd,pgdx,pglx,pgff,pgjzr,zcze,fzze,jzze

			// 资产评估
			ZcpgbTable zt = new ZcpgbTable();
			zt.setGuid(GUID);
			zt.setPgmd(request.getParameter("pgmd"));
			zt.setPgdx(request.getParameter("pgdx"));
			zt.setPglx(request.getParameter("pglx"));
			zt.setPgff(request.getParameter("pgff"));
			zt.setPgjzr(request.getParameter("pgjzr"));
			zt.setZcze(request.getParameter("zcze"));
			zt.setFzze(request.getParameter("fzze"));
			zt.setJzze(request.getParameter("jzze"));
			zt.setSjdwmc(request.getParameter("sjdwmc"));

			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 资产评估
			zs.addZcpgbTable(zt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateZcpgbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");  
		String loginname = (String)map.get("loginname");  
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			

			// 资产评估
			ZcpgbTable zt = new ZcpgbTable();
			zt.setGuid(request.getParameter("zcpgbguid"));
			zt.setPgmd(request.getParameter("pgmd"));
			zt.setPgdx(request.getParameter("pgdx"));
			zt.setPglx(request.getParameter("pglx"));
			zt.setPgff(request.getParameter("pgff"));
			zt.setPgjzr(request.getParameter("pgjzr"));
			zt.setZcze(request.getParameter("zcze"));
			zt.setFzze(request.getParameter("fzze"));
			zt.setJzze(request.getParameter("jzze"));
			zt.setSjdwmc(request.getParameter("sjdwmc"));
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 代报内容1
			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			// 代报内容1
			ContentService cs = new ContentService(conn);
			// 代报事务所
			CompanyListService cls = new CompanyListService(conn);
			// 资产评估
			ZcpgbService zs = new ZcpgbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_zcpgb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(zt.getGuid() == null || "".equals(zt.getGuid())){
				zt.setGuid(ct.getGuid());
				zs.addZcpgbTable(zt);
			}else{
				zs.updateZcpgbTable(zt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			

			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"资产评估","bb_zcpgb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addSfkjjdbTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());

		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 司法会计鉴定
			SfkjjdbService ss = new SfkjjdbService(conn);
			

			SfkjjdbTable st = new SfkjjdbTable();
			st.setGuid(GUID);  // 设置与相应报备内容的id
			st.setJdjg(request.getParameter("jdjg"));
			st.setZcze(request.getParameter("zcze"));
			st.setXssr(request.getParameter("xssr"));
			st.setCyry(request.getParameter("cyry"));
			String sftzje = request.getParameter("sftzje");
			st.setSftzje(sftzje);
			if("是".equals(sftzje)){
				st.setZczetzh(request.getParameter("zczetzh"));
				st.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				st.setZczetzh("0");
				st.setXssrtzh("0");
			}

			// 设置主键
			ct.setGuid(GUID); 
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			// 司法会计鉴定
			ss.addSfkjjdbTable(st);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样 
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateSfkjjdbTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 内容二
			SfkjjdbTable st = new SfkjjdbTable();
			st.setGuid(request.getParameter("stguid"));
			st.setJdjg(request.getParameter("jdjg"));
			st.setZcze(request.getParameter("zcze"));
			st.setXssr(request.getParameter("xssr"));
			st.setCyry(request.getParameter("cyry"));
			String sftzje = request.getParameter("sftzje");
			st.setSftzje(sftzje);
			if("是".equals(sftzje)){
				st.setZczetzh(request.getParameter("zczetzh"));
				st.setXssrtzh(request.getParameter("xssrtzh"));
			}else{
				st.setZczetzh("0");
				st.setXssrtzh("0");
			}
			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			SfkjjdbService ss = new SfkjjdbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_sfkjjdb");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(st.getGuid() == null || "".equals(st.getGuid())){
				st.setGuid(ct.getGuid());
				ss.addSfkjjdbTable(st);
			}else{
				ss.updateSfkjjdbTable(st);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) || "待审申请审核".equals(tempORFinish) || "待审报备完成".equals(tempORFinish)  
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"司法会计鉴定","bb_sfkjjdb");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加：企业价值评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addQyjzpgTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 企业价值评估
			QyjzpgService qs = new QyjzpgService(conn);
			
			//guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
			//othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
			//zmzczj,zmldfz,zmlqfz,zmfzzj,zmjzc, zmgdbfqyjz,pgldzc,pgcqzc,pggdzc,pgzjgc, "
			//pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, pgzczj,pgldfz,pglqfz,pgfzzj,pgjzc, pggdbfqyjz

			// 企业价值评估
			QyjzpgTable qt = new QyjzpgTable();
			qt.setGuid(GUID);
			
			qt.setYwlx(af.showNull(request.getParameter("ywlx")));
			qt.setPgjzr(af.showNull(request.getParameter("pgjzr")));
			qt.setJzlx(af.showNull(request.getParameter("jzlx")));
			qt.setPgmd(af.showNull(request.getParameter("pgmd")));
			
			qt.setPgdx(af.showNull(request.getParameter("pgdx")));
			qt.setPgfw(af.showNull(request.getParameter("pgfw")));
			qt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			qt.setCypgffxz(af.showNull(request.getParameter("cypgffxz")));
			qt.setOtheruser(af.showNull(request.getParameter("otheruser")));

			
			qt.setOthervalue(af.showNull(request.getParameter("othervalue")));
			qt.setZmldzc(af.showNull(request.getParameter("zmldzc")));
			qt.setZmcqzc(af.showNull(request.getParameter("zmcqzc")));
			qt.setZmgdzc(af.showNull(request.getParameter("zmgdzc")));
			qt.setZmzjgc(af.showNull(request.getParameter("zmzjgc")));
			
			qt.setZmjzw(af.showNull(request.getParameter("zmjzw")));
			qt.setZmsb(af.showNull(request.getParameter("zmsb")));
			qt.setZmwxzc(af.showNull(request.getParameter("zmwxzc")));
			qt.setZmtdsyq(af.showNull(request.getParameter("zmtdsyq")));
			qt.setZmqtzc(af.showNull(request.getParameter("zmqtzc")));
			
			qt.setZmzczj(af.showNull(request.getParameter("zmzczj")));
			qt.setZmldfz(af.showNull(request.getParameter("zmldfz")));
			qt.setZmlqfz(af.showNull(request.getParameter("zmlqfz")));
			qt.setZmfzzj(af.showNull(request.getParameter("zmfzzj")));
			qt.setZmjzc(af.showNull(request.getParameter("zmjzc")));
			
			qt.setZmgdbfqyjz(af.showNull(request.getParameter("zmgdbfqyjz")));
			qt.setPgldzc(af.showNull(request.getParameter("pgldzc")));
			qt.setPgcqzc(af.showNull(request.getParameter("pgcqzc")));
			qt.setPggdzc(af.showNull(request.getParameter("pggdzc")));
			qt.setPgzjgc(af.showNull(request.getParameter("pgzjgc")));
			
			qt.setPgjzw(af.showNull(request.getParameter("pgjzw")));
			qt.setPgsb(af.showNull(request.getParameter("pgsb")));
			qt.setPgwxzc(af.showNull(request.getParameter("pgwxzc")));
			qt.setPgtdsyq(af.showNull(request.getParameter("pgtdsyq")));
			qt.setPgqtzc(af.showNull(request.getParameter("pgqtzc")));
			
			qt.setPgzczj(af.showNull(request.getParameter("pgzczj")));
			qt.setPgldfz(af.showNull(request.getParameter("pgldfz")));
			qt.setPglqfz(af.showNull(request.getParameter("pglqfz")));
			qt.setPgfzzj(af.showNull(request.getParameter("pgfzzj")));
			qt.setPgjzc(af.showNull(request.getParameter("pgjzc")));
			
			qt.setPggdbfqyjz(af.showNull(request.getParameter("pggdbfqyjz")));
			
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 企业价值评估
			qs.addBbqyjzpgTable(qt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
			
			// 每一笔报备的联系人可能都不一样
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	/**
	 * 修改：企业价值评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateQyjzpgTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		
		ASFuntion af = new ASFuntion();
		
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 企业价值评估
			QyjzpgTable qt = new QyjzpgTable();
			
			qt.setGuid(request.getParameter("qtguid"));
			qt.setYwlx(af.showNull(request.getParameter("ywlx")));
			qt.setPgjzr(af.showNull(request.getParameter("pgjzr")));
			qt.setJzlx(af.showNull(request.getParameter("jzlx")));
			qt.setPgmd(af.showNull(request.getParameter("pgmd")));
			
			qt.setPgdx(af.showNull(request.getParameter("pgdx")));
			qt.setPgfw(af.showNull(request.getParameter("pgfw")));
			qt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			qt.setCypgffxz(af.showNull(request.getParameter("cypgffxz")));
			qt.setOtheruser(af.showNull(request.getParameter("otheruser")));

			
			qt.setOthervalue(af.showNull(request.getParameter("othervalue")));
			qt.setZmldzc(af.showNull(request.getParameter("zmldzc")));
			qt.setZmcqzc(af.showNull(request.getParameter("zmcqzc")));
			qt.setZmgdzc(af.showNull(request.getParameter("zmgdzc")));
			qt.setZmzjgc(af.showNull(request.getParameter("zmzjgc")));
			
			qt.setZmjzw(af.showNull(request.getParameter("zmjzw")));
			qt.setZmsb(af.showNull(request.getParameter("zmsb")));
			qt.setZmwxzc(af.showNull(request.getParameter("zmwxzc")));
			qt.setZmtdsyq(af.showNull(request.getParameter("zmtdsyq")));
			qt.setZmqtzc(af.showNull(request.getParameter("zmqtzc")));
			
			qt.setZmzczj(af.showNull(request.getParameter("zmzczj")));
			qt.setZmldfz(af.showNull(request.getParameter("zmldfz")));
			qt.setZmlqfz(af.showNull(request.getParameter("zmlqfz")));
			qt.setZmfzzj(af.showNull(request.getParameter("zmfzzj")));
			qt.setZmjzc(af.showNull(request.getParameter("zmjzc")));
			
			qt.setZmgdbfqyjz(af.showNull(request.getParameter("zmgdbfqyjz")));
			qt.setPgldzc(af.showNull(request.getParameter("pgldzc")));
			qt.setPgcqzc(af.showNull(request.getParameter("pgcqzc")));
			qt.setPggdzc(af.showNull(request.getParameter("pggdzc")));
			qt.setPgzjgc(af.showNull(request.getParameter("pgzjgc")));
			
			qt.setPgjzw(af.showNull(request.getParameter("pgjzw")));
			qt.setPgsb(af.showNull(request.getParameter("pgsb")));
			qt.setPgwxzc(af.showNull(request.getParameter("pgwxzc")));
			qt.setPgtdsyq(af.showNull(request.getParameter("pgtdsyq")));
			qt.setPgqtzc(af.showNull(request.getParameter("pgqtzc")));
			
			qt.setPgzczj(af.showNull(request.getParameter("pgzczj")));
			qt.setPgldfz(af.showNull(request.getParameter("pgldfz")));
			qt.setPglqfz(af.showNull(request.getParameter("pglqfz")));
			qt.setPgfzzj(af.showNull(request.getParameter("pgfzzj")));
			qt.setPgjzc(af.showNull(request.getParameter("pgjzc")));
			
			qt.setPggdbfqyjz(af.showNull(request.getParameter("pggdbfqyjz")));

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			QyjzpgService qs = new QyjzpgService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_qyjzpg");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(qt.getGuid() == null || "".equals(qt.getGuid())){
				qt.setGuid(ct.getGuid());
				qs.addBbqyjzpgTable(qt);
			}else{
				qs.updateBbqyjzpgTable(qt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) 
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}

			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"企业价值评估","bb_qyjzpg");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	
	/**
	 * 添加：单项资产或资产组合评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addDxzhpgTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 单项资产或资产组合评估
			DxzhpgbService ds = new DxzhpgbService(conn);
			
			//guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
			//othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
			//zmzczj,pgldzc,pgcqzc,pggdzc,pgzjgc, pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, 

			// 单项资产或资产组合评估
			DxzhpgbTable dt = new DxzhpgbTable();
			
			dt.setGuid(GUID);
			
			dt.setYwlx(af.showNull(request.getParameter("ywlx")));
			dt.setPgjzr(af.showNull(request.getParameter("pgjzr")));
			dt.setJzlx(af.showNull(request.getParameter("jzlx")));
			dt.setPgmd(af.showNull(request.getParameter("pgmd")));
			
			dt.setPgdx(af.showNull(request.getParameter("pgdx")));
			dt.setPgfw(af.showNull(request.getParameter("pgfw")));
			dt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			dt.setCypgffxz(af.showNull(request.getParameter("cypgffxz")));
			dt.setOtheruser(af.showNull(request.getParameter("otheruser")));

			
			dt.setOthervalue(af.showNull(request.getParameter("othervalue")));
			dt.setZmldzc(af.showNull(request.getParameter("zmldzc")));
			dt.setZmcqzc(af.showNull(request.getParameter("zmcqzc")));
			dt.setZmgdzc(af.showNull(request.getParameter("zmgdzc")));
			dt.setZmzjgc(af.showNull(request.getParameter("zmzjgc")));
			
			dt.setZmjzw(af.showNull(request.getParameter("zmjzw")));
			dt.setZmsb(af.showNull(request.getParameter("zmsb")));
			dt.setZmwxzc(af.showNull(request.getParameter("zmwxzc")));
			dt.setZmtdsyq(af.showNull(request.getParameter("zmtdsyq")));
			dt.setZmqtzc(af.showNull(request.getParameter("zmqtzc")));
			
			dt.setZmzczj(af.showNull(request.getParameter("zmzczj")));
			dt.setPgldzc(af.showNull(request.getParameter("pgldzc")));
			dt.setPgcqzc(af.showNull(request.getParameter("pgcqzc")));
			dt.setPggdzc(af.showNull(request.getParameter("pggdzc")));
			dt.setPgzjgc(af.showNull(request.getParameter("pgzjgc")));
			
			dt.setPgjzw(af.showNull(request.getParameter("pgjzw")));
			dt.setPgsb(af.showNull(request.getParameter("pgsb")));
			dt.setPgwxzc(af.showNull(request.getParameter("pgwxzc")));
			dt.setPgtdsyq(af.showNull(request.getParameter("pgtdsyq")));
			dt.setPgqtzc(af.showNull(request.getParameter("pgqtzc")));
			dt.setPgzczj(af.showNull(request.getParameter("pgzczj")));
			
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 单项资产或资产组合评估
			ds.addBbDxzhpgbTable(dt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}
		
			// 每一笔报备的联系人可能都不一样
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改：单项资产或资产组合评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateDxzhpgTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		
		ASFuntion af = new ASFuntion();
		
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 单项资产或资产组合评估
			DxzhpgbTable dt = new DxzhpgbTable();
			
			dt.setGuid(request.getParameter("dtguid"));
			
			dt.setYwlx(af.showNull(request.getParameter("ywlx")));
			dt.setPgjzr(af.showNull(request.getParameter("pgjzr")));
			dt.setJzlx(af.showNull(request.getParameter("jzlx")));
			dt.setPgmd(af.showNull(request.getParameter("pgmd")));
			
			dt.setPgdx(af.showNull(request.getParameter("pgdx")));
			dt.setPgfw(af.showNull(request.getParameter("pgfw")));
			dt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			dt.setCypgffxz(af.showNull(request.getParameter("cypgffxz")));
			dt.setOtheruser(af.showNull(request.getParameter("otheruser")));

			
			dt.setOthervalue(af.showNull(request.getParameter("othervalue")));
			dt.setZmldzc(af.showNull(request.getParameter("zmldzc")));
			dt.setZmcqzc(af.showNull(request.getParameter("zmcqzc")));
			dt.setZmgdzc(af.showNull(request.getParameter("zmgdzc")));
			dt.setZmzjgc(af.showNull(request.getParameter("zmzjgc")));
			
			dt.setZmjzw(af.showNull(request.getParameter("zmjzw")));
			dt.setZmsb(af.showNull(request.getParameter("zmsb")));
			dt.setZmwxzc(af.showNull(request.getParameter("zmwxzc")));
			dt.setZmtdsyq(af.showNull(request.getParameter("zmtdsyq")));
			dt.setZmqtzc(af.showNull(request.getParameter("zmqtzc")));
			
			dt.setZmzczj(af.showNull(request.getParameter("zmzczj")));
			dt.setPgldzc(af.showNull(request.getParameter("pgldzc")));
			dt.setPgcqzc(af.showNull(request.getParameter("pgcqzc")));
			dt.setPggdzc(af.showNull(request.getParameter("pggdzc")));
			dt.setPgzjgc(af.showNull(request.getParameter("pgzjgc")));
			
			dt.setPgjzw(af.showNull(request.getParameter("pgjzw")));
			dt.setPgsb(af.showNull(request.getParameter("pgsb")));
			dt.setPgwxzc(af.showNull(request.getParameter("pgwxzc")));
			dt.setPgtdsyq(af.showNull(request.getParameter("pgtdsyq")));
			dt.setPgqtzc(af.showNull(request.getParameter("pgqtzc")));
			dt.setPgzczj(af.showNull(request.getParameter("pgzczj")));
			

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			DxzhpgbService ds = new DxzhpgbService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_dxzhpg");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(dt.getGuid() == null || "".equals(dt.getGuid())){
				dt.setGuid(ct.getGuid());
				ds.addBbDxzhpgbTable(dt);
			}else{
				ds.updateBbDxzhpgTable(dt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) 
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}

			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"单项资产或资产组合评估","bb_dxzhpg");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加：金融不良资产评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addJrblpgTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 金融不良资产评估
			JrzcpgService js = new JrzcpgService(conn);
			
			 
			// guid,ywlx,bglx,hzzs,zqje, swlzc,gqlzc,qtzc,zqlzc,hj
			// 金融不良资产评估
			JrzcpgTable jt = new JrzcpgTable();
			
			jt.setGuid(GUID);
			
			jt.setYwlx(af.showNull(request.getParameter("ywlx")));
			jt.setBglx(af.showNull(request.getParameter("bglx")));
			jt.setHzzs(af.showNull(request.getParameter("hzzs")));
			jt.setZqje(af.showNull(request.getParameter("zqje")));
			
			jt.setSwlzc(af.showNull(request.getParameter("swlzc")));
			jt.setGqlzc(af.showNull(request.getParameter("gqlzc")));
			jt.setQtzc(af.showNull(request.getParameter("qtzc")));
			jt.setZqlzc(af.showNull(request.getParameter("zqlzc")));
			jt.setHj(af.showNull(request.getParameter("hj")));
			
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 金融不良资产评估
			js.addJrzcpgTable(jt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
			
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}

			// 每一笔报备的联系人可能都不一样
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改：金融不良资产评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateJrblpgTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			
			// guid,ywlx,bglx,hzzs,zqje, swlzc,gqlzc,qtzc,zqlzc,hj
			// 金融不良资产评估
			JrzcpgTable jt = new JrzcpgTable();
			
			jt.setGuid(request.getParameter("jtguid"));
			
			jt.setYwlx(af.showNull(request.getParameter("ywlx")));
			jt.setBglx(af.showNull(request.getParameter("bglx")));
			jt.setHzzs(af.showNull(request.getParameter("hzzs")));
			jt.setZqje(af.showNull(request.getParameter("zqje")));
			
			jt.setSwlzc(af.showNull(request.getParameter("swlzc")));
			jt.setGqlzc(af.showNull(request.getParameter("gqlzc")));
			jt.setQtzc(af.showNull(request.getParameter("qtzc")));
			jt.setZqlzc(af.showNull(request.getParameter("zqlzc")));
			jt.setHj(af.showNull(request.getParameter("hj")));
			
			

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			JrzcpgService js = new JrzcpgService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_jrzcpg");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(jt.getGuid() == null || "".equals(jt.getGuid())){
				jt.setGuid(ct.getGuid());
				js.addJrzcpgTable(jt);
			}else{
				js.updateJrzcpgTable(jt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) 
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}

			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"金融不良资产评估","bb_jrzcpg");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	/**
	 * 添加：其他资产评估 
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addQtzcpgTable(HttpServletRequest request,HttpServletResponse response,ContentTable ct){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		
		// 全球唯一标识号
		String companyGUID = UUID.randomUUID().toString();
		// 获取报备类型的编号
		String typeid = request.getParameter("typeid");
		// 全球唯一标识号	代报内容一		
		String GUID = UUID.randomUUID().toString();
		
		try {
			
			conn = new DBConnect().getConnect();
			// 代报事务所信息
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(companyGUID);
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			// 报备内容
			ContentService cs = new ContentService(conn);
			// 代报事务所信息
			CompanyListService cls = new CompanyListService(conn);
			// 其他资产评估 
			QtzcpgService qs = new QtzcpgService(conn);
			
			 
			// guid,pgmd,ywlx,pgdx,zypgffxz, zmyz,pgjz
			// 其他资产评估 
			QtzcpgTable qt = new QtzcpgTable();
			
			qt.setGuid(GUID);
			
			qt.setPgmd(af.showNull(request.getParameter("pgmd")));
			qt.setYwlx(af.showNull(request.getParameter("ywlx")));
			qt.setPgdx(af.showNull(request.getParameter("pgdx")));
			qt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			
			qt.setZmyz(af.showNull(request.getParameter("zmyz")));
			qt.setPgjz(af.showNull(request.getParameter("pgjz")));
			
			
			// 设置主键
			ct.setGuid(GUID);
			// 代报备事务所信息表的编号
			ct.setCompanyGUID(companyGUID);
			// 设置所属报备类型的编号
			ct.setTypeid(typeid);
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);
			
			// 其他资产评估 
			qs.addQtzcpgTable(qt);
			// 报备内容
			cs.addContentTable(ct,officecode,area,sys_province_cicpa);
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
				// 报备申请 bb_apply
				this.saveApply(request, conn,GUID,"add");
			}
				
			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,GUID,"add");
			}

			// 每一笔报备的联系人可能都不一样
			cls.addCompanyListTable(clt);
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+GUID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	

	/**
	 * 修改：其他资产评估
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateQtzcpgTableById(HttpServletRequest request,HttpServletResponse response,ContentTable ct) throws IOException{
		String typeid = request.getParameter("typeid");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		String officecode = (String)map.get("officecode");
		String area = (String)map.get("area");
		String sys_province_cicpa = (String)map.get("sys_province_cicpa");
		String tempORFinish = af.showNull(request.getParameter("tempORFinish"));
		String beforeValue = af.showNull(ct.getBbstate());
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			// 代报事务所
			CompanyListTable clt = new CompanyListTable();
			clt.setGuid(request.getParameter("cltguid"));
			clt.setLoginid(loginid);
			clt.setCompanyName(request.getParameter("companyName"));
			//clt.setLanguageSelectName(request.getParameter("languageSelectName"));
			clt.setLanguageSelectName("事务所语音调查名称");
			clt.setPerson(ct.getLinkman());
			clt.setPhone(ct.getLinkphone());
			clt.setFaxes(request.getParameter("faxes"));
			clt.setPost(request.getParameter("post"));
			clt.setAddress(request.getParameter("address"));
			clt.setEmail(request.getParameter("email"));
			clt.setUrl(request.getParameter("url"));
			clt.setArea(area);
			
			
			
			// guid,pgmd,ywlx,pgdx,zypgffxz, zmyz,pgjz
			// 其他资产评估 
			QtzcpgTable qt = new QtzcpgTable();
			
			qt.setGuid(request.getParameter("qtguid"));
			
			qt.setPgmd(af.showNull(request.getParameter("pgmd")));
			qt.setYwlx(af.showNull(request.getParameter("ywlx")));
			qt.setPgdx(af.showNull(request.getParameter("pgdx")));
			qt.setZypgffxz(af.showNull(request.getParameter("zypgffxz")));
			
			qt.setZmyz(af.showNull(request.getParameter("zmyz")));
			qt.setPgjz(af.showNull(request.getParameter("pgjz")));
			
			

			
			// 设置报备人
			ct.setBbperson(loginid);
			// 设置报备时间
			ct.setBbtime(new ASFuntion().getDateAndTime());
			// 设置报备状态
			ct.setBbstate(tempORFinish);

			String ctguid = request.getParameter("ctguid");
			ct.setGuid(ctguid);
			
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			QtzcpgService qs = new QtzcpgService(conn);
			
			String bcbBtn = request.getParameter("bcbBtn");
			Map beforeBBMap = null;
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				beforeBBMap = cs.getBBInfo(ctguid, "bb_qtzcpg");
			}
			
			cs.updateContentTable(ct,officecode,sys_province_cicpa);
			cls.updateCompanyListTable(clt);
			//一开始没有第三个表页，修改时要新增
			if(qt.getGuid() == null || "".equals(qt.getGuid())){
				qt.setGuid(ct.getGuid());
				qs.addQtzcpgTable(qt);
			}else{
				qs.updateQtzcpgTable(qt);	
			}
			
			// 收费标准
			String sfbz = request.getParameter("sfbz");
			
			if("暂存".equals(tempORFinish) || "申请审核".equals(tempORFinish) || "报备完成".equals(tempORFinish) 
					|| "初审通过".equals(tempORFinish) || "审核通过".equals(tempORFinish) ){
				// 报备申请 bb_apply
				this.saveApply(request, conn,ct.getGuid(),"update");
			}

			if("计时收费".equals(sfbz)){
				// 报备工时 bb_hour
				this.saveHour(request, conn,ct.getGuid(),"update");
			}
			
			// 如果是第一次申请审核或者第一次报备完成就记录日志
			if(!tempORFinish.equals(beforeValue) && (tempORFinish.equals("申请审核") || tempORFinish.equals("报备完成") || tempORFinish.equals("待审申请审核") || tempORFinish.equals("待审报备完成"))){
				// 记录报备修改痕迹
				this.addBBStateInfoHistory(conn,beforeValue,tempORFinish,ct,loginid,loginname);
				
			}
			
			//把事务所的修改信息回写到机构表中，从BB_companyList到K_Company 
			// 机构那边如果为空 并且 报备的时候报备事务所信息不为空才同步到机构信息那边
			UserService user = new UserService(conn);
			Map userMap = user.getUser( "K_Company", clt.getLoginid());//团体表
			if("".equals(userMap.get("linkman")) || userMap.get("linkman")==null){
				if(!"".equals(clt.getPerson()) && clt.getPerson()!=null){
					userMap.put("linkman", clt.getPerson());//联系人
				}
			}
			if("".equals(userMap.get("phone")) || userMap.get("phone")==null){
				if(!"".equals(clt.getPhone()) && clt.getPhone()!=null){
					userMap.put("phone", clt.getPhone());//联系电话
				}
			}
			if("".equals(userMap.get("postalcode")) || userMap.get("postalcode")==null){
				if(!"".equals(clt.getFaxes()) && clt.getFaxes()!=null){
					userMap.put("postalcode", clt.getFaxes());//传    真 
				}
			}
			
			if("".equals(userMap.get("postcode")) || userMap.get("postcode")==null){
				if(!"".equals(clt.getPost()) && clt.getPost()!=null){
					userMap.put("postcode", clt.getPost());//邮     编
				}
			}
			
			if("".equals(userMap.get("address")) || userMap.get("address")==null){
				if(!"".equals(clt.getAddress()) && clt.getAddress()!=null){
					userMap.put("address", clt.getAddress());//地  址
				}
			}
			if("".equals(userMap.get("email")) || userMap.get("email")==null){
				if(!"".equals(clt.getEmail()) && clt.getEmail()!=null){
					userMap.put("email", clt.getEmail());//E-Mial 
				}
			}
			if("".equals(userMap.get("url")) || userMap.get("url")==null){
				if(!"".equals(clt.getUrl()) && clt.getUrl()!=null){
					userMap.put("url", clt.getUrl());//网     址
				}
			}
			user.saveInfo(userMap);
			
			//同步事务所信息
			String sql = "update K_Company set linkman=?,phone=?,postalcode=?,postcode=?,address=?,email=?,url=? where loginid=?";
			new DbUtil(conn).execute(sql, new Object[]{clt.getPerson(),clt.getPhone(),clt.getFaxes(),clt.getPost(),
					clt.getAddress(),clt.getEmail(),clt.getUrl(),clt.getLoginid()});
			
			
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			if("保存".equals(bcbBtn)){	// 如果 是 点击 保存 那说明 该 报备数据 已经是 报备完成过了。才去记录 报备字段信息 变更 记录
				this.addBBInfoHistory(request,beforeBBMap,ctguid,"其他资产评估","bb_qtzcpg");
				// 不弹出 是否打印封面 提示
				response.sendRedirect("bb.do?method=index&typeid="+typeid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		if("报备完成".equals(tempORFinish) || "初次报备".equals(tempORFinish)){
			response.sendRedirect("bb.do?method=index&typeid="+typeid+"&bbnum="+ct.getGuid());
		}else{
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		}
		return null;
	}
	
	
	
	/**
	 * 修改已收业务费用
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateMoney(HttpServletRequest request,HttpServletResponse response) {
		String guid = request.getParameter("ctguid");
		String typeid = request.getParameter("typeid");
		String ysywfed = request.getParameter("ysywfed");   	// 已收业务费用
		String sfrq = request.getParameter("sfrq");   			// 费用日期
		String kjskdfphd = request.getParameter("kjskdfphd");   // 开具收款发票号码
		String kjskdfphd2 = request.getParameter("kjskdfphd2");   // 开具收款发票号码2
		String sfsm = request.getParameter("sfsm");   			// 收费说明
		String ysywfedUpdateTime = request.getParameter("ysywfedUpdateTime");   // 已收业务费修改时间
		String kjskdfphd2UpdateTime = request.getParameter("kjskdfphd2UpdateTime");   // 开具收款发票号码2修改时间
		String attachfileId = request.getParameter("attachfileId");
		
		String tabTypeName = "bb_"+typeid.replace("001", "b");
		String bbType = "";
		String sql = "";
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			
			DbUtil db = new DbUtil(conn);
			sql = "select typeName from bb_type where guid = '"+typeid+"' ";
			bbType = db.queryForString(sql);
			ContentService cs = new ContentService(conn);
			Map beforeBBMap = cs.getBBInfo(guid, tabTypeName);
			
			
			sql = "update bb_content1 set ysywfed = ?,sfrq = ?,kjskdfphd = ?,sfsm = ?,kjskdfphd2=?,ysywfedUpdateTime=?,kjskdfphd2UpdateTime=?,attachfileId=? where guid = ?";
			db.executeUpdate(sql, new Object[]{ysywfed,sfrq,kjskdfphd,sfsm,kjskdfphd2,ysywfedUpdateTime,kjskdfphd2UpdateTime,attachfileId,guid});
			
			/**
			 * 记录 报备 数据 修改 轨迹
			 */
			addBBInfoHistory(request,beforeBBMap,guid,bbType,tabTypeName);
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/** 还原状态
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView reset(HttpServletRequest request,HttpServletResponse response) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		
		String guid	= request.getParameter("GUID");
		String typeid	= request.getParameter("typeid");
		
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			String sql = "update bb_content1 set bbstate = '暂存' where guid=? and bbstate = '报备完成' ";
			new DbUtil(conn).executeUpdate(sql, new Object[]{guid});
			
			// 记录登录日志信息  l_log 表
			ASFuntion CHF=new ASFuntion();
			LogService logs = new LogService(conn);
			String ip = request.getRemoteAddr();
			String date = CHF.getCurrentDate();
			String time = CHF.getCurrentTime();
			String userid = (String) map.get("loginid");
			String loginname = (String) map.get("loginname");
			
 
			LogTable lt = new LogTable();
			lt.setUserId(userid);
			lt.setUserName(loginname);
			lt.setIp(ip);
			lt.setLoginDate(date);
			lt.setLoginTime(time);
			lt.setOperation("还原报备数据的状态"); 
			lt.setMemo(date+":"+time+","+userid+"  事务所还原了主键为:"+guid+"的报备数据！");
			lt.setCtype("K_Company");
			lt.setInitFlag("3");
			logs.saveLogInfo(lt);
			
			response.sendRedirect("bb.do?method=index&typeid="+typeid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 查看报备时间
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView seebbTime(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String guid	= request.getParameter("GUID");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			String sql = "select bbtime from bb_content1 where guid = ?";
			String time = "2011-01-01"; // 2011-01-01 以后的 报备数据才能还原 
			String bbtime = new DbUtil(conn).queryForString(sql, new Object[]{guid});
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date ttime = formatter.parse(bbtime);
			bbtime = formatter.format(ttime);
			int result = DateUtil.equalDate(time, bbtime);
			
			
			if(result>=0){
				out.print("Y");
			}else{
				out.print("N");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	/** 根据类型 处理 sql 
	 * @param typeid
	 * @param loginid
	 * @return
	 */
	public String getSqlByTypeId(String typeid,String loginid){
		// where typeid = '"+typeid+"' and  BBPERSON = '"+loginid+"'   默认条件
		// bbqt001		ccsssqkcjj001		kjdsh001		kjzs001		qchz001		qssh001		qtssjj001
		// sdshsqj001		sfkjjd001		sj001		swdl001		whnj001		yz001		zcpg001
		
		// BB_CompanyList : Guid  Loginid  CompanyName  LanguageSelectName  Person	 Phone	 Faxes	 Post  Address	 Email 	Url  area
		
		// BB_CONTENT1:ComPanyGUID,GUID,Typeid,WTDWMC,BSDWMC,KHCZLX,KHJJXJ,KMHYLX,SFSSQY,YYZZHM,ZCDZ,ZCZBBZ,BSDWZCZB,FZRMC,LXRXM,LXRDH,
		//				WTXMLX,YWYDS,QYRQ,BGWH,XMMC,BGRQ,BGND,FCBGFS,QMZYSZL,QMZS1,QMZS2,QMZS3,QMZS4,QMZS5,QMZS6,ZLRY,SFYJ,YSYWF,YSYWFed
		// 				KJSKDFPHD,SFRQ,SFSM,LEAVEWORD,BBPERSON,BBTIME,BBSTATE,CPA1,CPA2,CPA3,CPA4,CPA5,CPA6,BBBH,BBREASON,ZFPERSON,ID
		// 				Reviewer,ReviewerName,ReviewTime,Reason,IsReviewed,ywarea,bgnd2,bz,reportCount,linkman,linkphone
		
		String sql = " select cl.Guid as clguid,cl.Loginid,cl.CompanyName,cl.LanguageSelectName,cl.Person," 
				   + " cl.Phone,cl.Faxes,cl.Post,cl.Address,cl.Email,cl.Url,cl.area," 
				   + " c.guid,c.companyGUID,c.typeid,c.wtdwmc,c.khjjxj,c.bsdwmc,c.kmhylx,c.wtxmlx,c.ywyds,c.qyrq,c.bgwh,c.qmzs1, "
				   + " c.qmzs2,c.qmzs3,c.bbbh,isnull(isreviewed,'否') as isreviewed,c.bbstate,c.ywarea,c.bbtime "
				   + " from [BB_CONTENT1] c left join BB_CompanyList cl on c.companyguid = cl.guid ";
		
		if("bbqt001".equals(typeid)){
			sql = sql + " left join BB_BBQTB qtb on c.guid=qtb.guid ";
		}else if("ccsssqkcjj001".equals(typeid)){
			sql = sql + " left join BB_CCSSSQKCJJB ccs on c.guid=ccs.guid ";
		}else if("kjdsh001".equals(typeid)){
			sql = sql + " left join BB_KJDSHB kjd on c.guid=kjd.guid ";
		}else if("kjzs001".equals(typeid)){
			sql = sql + " left join BB_KJZSB kjz on c.guid=kjz.guid ";
		}else if("qchz001".equals(typeid)){
			sql = sql + " left join BB_QCHZB qch on c.guid=qch.guid ";
		}else if("qssh001".equals(typeid)){
			sql = sql + " left join BB_QSSHB qss on c.guid=qss.guid ";
		}else if("qtssjj001".equals(typeid)){
			sql = sql + " left join BB_QTSSJJB qts on c.guid=qts.guid ";
		}else if("sdshsqj001".equals(typeid)){
			sql = sql + " left join BB_SDSHSQJB sds on c.guid=sds.guid ";
		}else if("sfkjjd001".equals(typeid)){
			sql = sql + " left join BB_SFKJJDB sfk on c.guid=sfk.guid ";
		}else if("sj001".equals(typeid)){
			sql = sql + " left join BB_SJB sjb on c.guid=sjb.guid ";
		}else if("swdl001".equals(typeid)){
			sql = sql + " left join BB_SWDLB swd on c.guid=swd.guid ";
		}else if("whnj001".equals(typeid)){
			sql = sql + " left join BB_WHNJB whn on c.guid=whn.guid ";
		}else if("yz001".equals(typeid)){
			sql = sql + " left join BB_YZB yzb on c.guid=yzb.guid ";
		}else if("zcpg001".equals(typeid)){
			sql = sql + " left join BB_ZCPGB zcp on c.guid=zcp.guid ";
		}
		
		sql = sql + " where 1=1  and c.typeid = '"+typeid+"' and  c.BBPERSON = '"+loginid+"'  ";
		
		return sql;
	}
	
	
	
	/**
	 * 从 E 审通 过 报备数据 过来
	 * @param requset
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ModelAndView addBBInfoFromEAudit(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		// 事务所
		String companyMap = request.getParameter("companyMap");
		// 报备内容一
		String contentMap = request.getParameter("contentMap");
		// 报备分类
		String bbsjMap = request.getParameter("bbsjMap");
		
		// 事务所编号
		String officeCode = request.getParameter("officeCode");
		// 地区
		String area = request.getParameter("area");
		
		// 联系人  因为在 bb_companylist表有     在 bb_content1表 也有
		String linkman = request.getParameter("person");
		// 联系电话  因为在 bb_companylist表有     在 bb_content1表 也有
		String linkphone = request.getParameter("phone");
		
		System.out.println(this.getClass()+"  companyMap="+companyMap);
		System.out.println(this.getClass()+"  contentMap="+contentMap);
		System.out.println(this.getClass()+"  bbsjMap="+bbsjMap);
		
		response.setContentType("text/html;charset=utf-8");  //设置编码
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		
		try{
			// 事务所 guid
			String companyGuid = UUID.randomUUID().toString();
			
			// 报备表 guid
			String contentGuid = UUID.randomUUID().toString();
			
			// 报备编号
			String bbbh = new DELAutocode().getAutoCode("报备编号", area);
			
			bbbh = bbbh + getRandom();
			
			System.out.println("防伪编号：bbbh="+bbbh);
			
			// 报备人
			String bbperon = officeCode;
			// 报备时间
			String bbtime = new ASFuntion().getDateAndTime();
			
			conn = new DBConnect().getConnect();
			// 事务所
			companyMap = companyMap.substring(1,companyMap.length()-1);
			String[] companyMaps = companyMap.split(",");
			String companyColumn = "guid,loginid,";
			String companyColumnMark = "?,?,";
			String companyColumnValue = companyGuid+","+officeCode+",";
			
			// 拼凑列和列对应的值
			for(int i=0;i<companyMaps.length;i++){
				companyColumn = companyColumn + companyMaps[i].split("=")[0]+",";
				companyColumnMark = companyColumnMark + "?,";
				if(companyMaps[i].split("=").length<2){
					companyColumnValue = companyColumnValue + ",";
				}else{
					companyColumnValue = companyColumnValue + companyMaps[i].split("=")[1]+",";
				}
			}
			companyColumn = companyColumn.substring(0,companyColumn.length()-1);
			companyColumnMark = companyColumnMark.substring(0,companyColumnMark.length()-1);
			companyColumnValue = companyColumnValue.substring(0,companyColumnValue.length()-1);
			
			System.out.println("事务所 companyColumn="+companyColumn);
			System.out.println("事务所 companyColumnMark="+companyColumnMark);
			System.out.println("事务所 companyColumnValue="+companyColumnValue);
			
			String[] companys = companyColumnValue.split(",");
			
			String sql = " insert into bb_companylist ("+companyColumn+") values("+companyColumnMark+")";
			
			for (int i = 0; i < companys.length; i++) {
				String string = companys[i];
			}
			
			int c = new DbUtil(conn).executeUpdate(sql,companys);
			
			System.out.println("执行 insert into 到 事务所表 返回值="+c);
			
			
			// 报备内容一
			contentMap = contentMap.substring(1,contentMap.length()-1);
			String[] contentMaps = contentMap.split(",");
			String contentColumn = "companyguid,guid,bbperson,bbtime,linkman,linkphone,bbstate,typeid,bbbh,";
			String contentColumnMark = "?,?,?,?,?,?,?,?,?,";
			String contentColumnValue = companyGuid+","+contentGuid+","+officeCode+","+bbtime+","+linkman+","+linkphone+","+"暂存,"+"sj001,"+bbbh+",";
			// 拼凑列和列对应的值
			for(int i=0;i<contentMaps.length;i++){
				contentColumn = contentColumn + contentMaps[i].split("=")[0]+",";
				contentColumnMark = contentColumnMark + "?,";
				if(contentMaps[i].split("=").length<2){
					contentColumnValue = contentColumnValue + ",";
				}else{
					contentColumnValue = contentColumnValue + contentMaps[i].split("=")[1]+",";
				}
			}
			contentColumn = contentColumn.substring(0,contentColumn.length()-1)+",?";
			contentColumnMark = contentColumnMark.substring(0,contentColumnMark.length()-1)+",pattern";
			contentColumnValue = contentColumnValue.substring(0,contentColumnValue.length()-1)+",E审通报备";
			System.out.println("报备内容一 contentColumn="+contentColumn);
			System.out.println("报备内容一 contentColumnMark="+contentColumnMark);
			System.out.println("报备内容一 contentColumnValue="+contentColumnValue);
			
			String[] content = contentColumnValue.split(",");
			
			sql = " insert into bb_content1 ("+contentColumn+") values("+contentColumnMark+")";
			int cc = new DbUtil(conn).executeUpdate(sql,content);
			
			System.out.println("执行 insert into 到 报备表 返回值="+cc);
			
			
			// 报备分类
			bbsjMap = bbsjMap.substring(1,bbsjMap.length()-1);
			String[] bbsjMaps = bbsjMap.split(",");
			String bbsjColumn = "guid,";
			String bbsjColumnMark = "?,";
			String bbsjColumnVlaue = contentGuid+",";
			// 拼凑 列 和 列 对应的值
			for(int i=0;i<bbsjMaps.length;i++){
				bbsjColumn = bbsjColumn + bbsjMaps[i].split("=")[0]+",";
				bbsjColumnMark = bbsjColumnMark + "?,";
				if(bbsjMaps[i].split("=").length<2){
					bbsjColumnVlaue = bbsjColumnVlaue + ",";
				}else{
					bbsjColumnVlaue = bbsjColumnVlaue + bbsjMaps[i].split("=")[1]+",";
				}
			}
			bbsjColumn = bbsjColumn.substring(0,bbsjColumn.length()-1);
			bbsjColumnMark = bbsjColumnMark.substring(0,bbsjColumnMark.length()-1);
			bbsjColumnVlaue = bbsjColumnVlaue.substring(0,bbsjColumnVlaue.length()-1);
			
			
			System.out.println("报备分类 bbsjColumn="+bbsjColumn);
			System.out.println("报备分类 bbsjColumnMark="+bbsjColumnMark);
			System.out.println("报备分类 bbsjColumnVlaue="+bbsjColumnVlaue);
			

			String[] bbsj = bbsjColumnVlaue.split(",");
			
			sql = " insert into bb_sjb ("+bbsjColumn+") values("+bbsjColumnMark+")";
			int sj = new DbUtil(conn).executeUpdate(sql,bbsj);
			
			System.out.println("执行 insert into 到 报备分类表 返回值="+sj);
			
			if(c==1 && cc==1 && sj==1){
				out.print("报备成功,"+contentGuid+","+bbbh);
			}else{
				out.print("报备失败!");
			}
			
		}catch(Exception e){
			System.out.println("出错了   errorInfo     e.getmessage()="+e.getMessage());
			out.print("错误信息："+e.getMessage());
			throw e;
		} finally{
			out.close();
		}
		 
		return null;
	}
	
	
	/**
	 * 从 E 审通 过 报备数据 过来
	 * @param requset
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ModelAndView updateBBInfoFromEAudit(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		// 防伪编号
		String bbbh = request.getParameter("bbbh");
		// 事务所
		String companyMap = request.getParameter("companyMap");
		// 报备内容一
		String contentMap = request.getParameter("contentMap");
		// 报备分类
		String bbsjMap = request.getParameter("bbsjMap");
		
		// 事务所编号
		String officeCode = request.getParameter("officeCode");
		// 地区
		String area = request.getParameter("area");
		// 报备人
		String bbPerson = request.getParameter("bbPerson");
		
		// 联系人  因为在 bb_companylist表有     在 bb_content1表 也有
		String linkman = request.getParameter("person");
		// 联系电话  因为在 bb_companylist表有     在 bb_content1表 也有
		String linkphone = request.getParameter("phone");
		
		System.out.println(this.getClass()+"  companyMap="+companyMap);
		System.out.println(this.getClass()+"  contentMap="+contentMap);
		System.out.println(this.getClass()+"  bbsjMap="+bbsjMap);
		
		response.setContentType("text/html;charset=utf-8");  //设置编码
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		
		try{
			// 报备时间
			String bbtime = new ASFuntion().getDateAndTime();
			
			conn = new DBConnect().getConnect();
			// 事务所     guid;loginid;companyName;languageSelectName;person;phone;faxes;post;address;email;area;url;

			companyMap = companyMap.substring(1,companyMap.length()-1);
			String[] companyMaps = companyMap.split(",");
			// 找出事务所表主键
			String companyGuid = new DbUtil(conn).queryForString(" select companyGuid from bb_content1 where bbbh = ? and bbperson=?",new Object[]{bbbh,bbPerson});
			System.out.println("找出事务所表主键  companyGuid="+companyGuid);
			String companyColumn = "";
			String companyColumnValue = "";
			// 拼凑列和列对应的值
			for(int i=0;i<companyMaps.length;i++){
				companyColumn = companyColumn + companyMaps[i].split("=")[0]+"=?,";
				if(companyMaps[i].split("=").length<2){
					companyColumnValue = companyColumnValue + ",";
				}else{
					companyColumnValue = companyColumnValue + companyMaps[i].split("=")[1]+",";
				}
			}
			companyColumn = companyColumn.substring(0,companyColumn.length()-1);
			companyColumnValue = companyColumnValue.substring(0,companyColumnValue.length()-1);
			
			System.out.println("事务所 companyColumn="+companyColumn);
			System.out.println("事务所 companyColumnValue="+companyColumnValue);
			
			String[] companys = companyColumnValue.split(",");
			
			String sql = " update bb_companylist set  "+companyColumn+"  where guid='"+companyGuid+"'";
			
			for (int i = 0; i < companys.length; i++) {
				String string = companys[i];
				System.out.println("修改事务所companys值="+string);
			}
			System.out.println("========================     修改事务所 bb_companylist  sql  值="+sql);
			
			int c = new DbUtil(conn).executeUpdate(sql,companys);
			
			System.out.println("执行 update 到 事务所表 返回值="+c);
			
			
			// 报备内容一  wtdwmc,bsdwmc,khczlx,yyzzhm,khjjxj,bsdwzczb,zczbbz,kmhylx,sfssqy,wtxmlx,ywyds,bgwh,ywarea,xmmc,ysywf,sfyj
			contentMap = contentMap.substring(1,contentMap.length()-1);
			String[] contentMaps = contentMap.split(",");
			String contentColumn = "bbtime=?,";
			String contentColumnValue = bbtime+",";
			// 拼凑列和列对应的值
			for(int i=0;i<contentMaps.length;i++){
				contentColumn = contentColumn + contentMaps[i].split("=")[0]+"=?,";
				if(contentMaps[i].split("=").length<2){
					contentColumnValue = contentColumnValue + ",";
				}else{
					contentColumnValue = contentColumnValue + contentMaps[i].split("=")[1]+",";
				}
			}
			contentColumn = contentColumn.substring(0,contentColumn.length()-1);
			contentColumnValue = contentColumnValue.substring(0,contentColumnValue.length()-1);
			System.out.println("报备内容一 contentColumn="+contentColumn);
			System.out.println("报备内容一 contentColumnValue="+contentColumnValue);
			
			String[] content = contentColumnValue.split(",");
			
			// 找出报备表主键
			String contentGuid = new DbUtil(conn).queryForString(" select guid from bb_content1 where bbbh = ? and bbperson=?",new Object[]{bbbh,bbPerson});
			System.out.println("找出事务所表主键  companyGuid="+companyGuid);
			
			sql = " update bb_content1 set "+contentColumn+" where guid='"+contentGuid+"'";
			
			System.out.println("========================     修改报备内容bb_content1  sql  值="+sql);
			
			int cc = new DbUtil(conn).executeUpdate(sql,content);
			
			System.out.println("执行 update 到 报备表 返回值="+cc);
			
			
			// 报备分类   审计  类 报备   sjlx,sjbgyjlx
			bbsjMap = bbsjMap.substring(1,bbsjMap.length()-1);
			String[] bbsjMaps = bbsjMap.split(",");
			String bbsjColumn = "";
			String bbsjColumnVlaue = "";
			// 拼凑 列 和 列 对应的值
			for(int i=0;i<bbsjMaps.length;i++){
				bbsjColumn = bbsjColumn + bbsjMaps[i].split("=")[0]+"=?,";
				if(bbsjMaps[i].split("=").length<2){
					bbsjColumnVlaue = bbsjColumnVlaue + ",";
				}else{
					bbsjColumnVlaue = bbsjColumnVlaue + bbsjMaps[i].split("=")[1]+",";
				}
			}
			bbsjColumn = bbsjColumn.substring(0,bbsjColumn.length()-1);
			bbsjColumnVlaue = bbsjColumnVlaue.substring(0,bbsjColumnVlaue.length()-1);
			
			
			System.out.println("报备分类 bbsjColumn="+bbsjColumn);
			System.out.println("报备分类 bbsjColumnVlaue="+bbsjColumnVlaue);
			

			String[] bbsj = bbsjColumnVlaue.split(",");
			
			sql = " update bb_sjb set "+bbsjColumn+" where guid='"+contentGuid+"'";
			
			System.out.println("========================     修改报备内容 bb_sjb    sql  值="+sql);
			
			int sj = new DbUtil(conn).executeUpdate(sql,bbsj);
			
			System.out.println("执行 update 到 报备分类表 返回值="+sj);
			
			if(c==1 && cc==1 && sj==1){
				out.print("报备成功,"+contentGuid);
			}else{
				out.print("报备失败!");
			}
			
			
		}catch(Exception e){
			System.out.println("出错了   errorInfo     e.getmessage()="+e.getMessage());
			out.print("错误信息："+e.getMessage());
			throw e;
		} finally{
			out.close();
		}
		 
		return null;
	}
	
	
	/**
	 * 根据 guid 得到报备状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getStateByBbbhAndBbperson(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String bbbh = request.getParameter("bbbh");
		String bbPerson = request.getParameter("bbPerson");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String state = cs.getStateByBbbhAndBbperson(bbbh,bbPerson);
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> bbbh = "+bbbh+"  state="+state+"  bbPerson="+bbPerson);
			if("作废".equals(state)){
				out.print("zuofei");
			}else if("暂存".equals(state)){
				out.print("zancun");
			}else if("报备完成".equals(state)){
				out.print("wanch");
			}else{
				out.write("noInfo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 得到 报备信息  供 E审通调用
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getContentTableByLoginidAndBbbh(HttpServletRequest request,HttpServletResponse response){
		String bbbh = request.getParameter("bbbh");
		String bbPerson = request.getParameter("bbPerson");
		System.out.println("2222    getBBInfoByGuid      bbbh ="+bbbh+"  bbPerson="+bbPerson);
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter out = null ;
		Connection conn = null;
		try{
			
			Map map = new HashMap();
			conn = new DBConnect().getConnect();
			
			// 报备表信息
			ContentService cs = new ContentService(conn);
			ContentTable ct = cs.getContentTableByLoginidAndBbbh(bbPerson, bbbh);
			
			// 事务所信息
			CompanyListService cls = new CompanyListService(conn);
			CompanyListTable clt = cls.getCompanyListTable(ct.getCompanyGUID());
			
			// 报备分类信息  审计
			SjService ss = new SjService(conn);
			SjTable st = ss.getSjTable(ct.getGuid());
			
			
			String content = JSONArray.fromObject(ct).toString();
			String companylist = JSONArray.fromObject(clt).toString();
			String sj = JSONArray.fromObject(st).toString();
			
			map.put("content", content);
			map.put("companylist", companylist);
			map.put("sj", sj);
			
			out = response.getWriter();
			out.print(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 检查动态密钥
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkDynamic(HttpServletRequest request,HttpServletResponse response){
		String usr = request.getParameter("loginid");
		String dynamicPwd = request.getParameter("dynamicPwd");
		String pwd = request.getParameter("pwd");
		System.out.println("checkDynamic().........................usr="+usr+"  dynamicPwd="+dynamicPwd+"  pwd="+pwd);
		PrintWriter out = null ;
		Connection conn = null;
		try{
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			// 如果设置特殊用户就不用检查动态密钥
			String sql = " select loginid from k_dogexcepect where loginid = ? and propertys = ?";
			String value = new DbUtil(conn).queryForString(sql, new Object[]{usr,pwd});
			if(value==null || "".equals(value)){
				sql = " select loginid from k_company where loginid=?";
				String result = new DbUtil(conn).queryForString(sql,new Object[]{usr});
				if(result==null || "".equals(result)){	// 是否有该用户
					out.print("noUser");
				}else{		// 密码是否正确
					sql = "select loginid from k_company where loginid=? and pwd = ? ";
					result = new DbUtil(conn).queryForString(sql,new Object[]{usr,MD5.getMD5String(pwd)});
					if(result==null || "".equals(result)){	// 密码是否正确
						out.print("pwdError");
					}else{
						String resultStr = new ETOtpOpp(conn).checkPwdz201(usr, dynamicPwd);
						if(!"ok".equals(resultStr)) {	// 动态密钥是否正确
							out.print("noDynamicPwd");
						}else{
							out.print("ok");
						}
					}
				}
			}else{
				out.print("ok");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 更加事务所编号得到事务所信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getCompanyInfoByLoginid(HttpServletRequest request,HttpServletResponse response){
		String loginid = request.getParameter("loginid");
		System.out.println("getCompanyInfoByLoginid(            loginid="+loginid);
		response.setContentType("text/html;charset=UTF-8") ;
		Connection conn = null;
		PrintWriter out = null;
		try{
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			CompanyService cs = new CompanyService(conn);
			CompanyTable ct = cs.getCompanyTableById(loginid);
			String company = JSONArray.fromObject(ct).toString();
			out.print(company);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	
	/**
	 * 记录 报备 数据 修改 轨迹
	 * @param request
	 * @param beforeBBMap
	 * @param ctguid
	 * @param tabTypeName
	 * 
	 * 1. 生成一个 存放修改后的报备数据的 map
	 * 2. 生成一个 存放修改前的报备数据的 map
	 * 3. 生成一个 存放要比较的字段名称的 map 
	 */  
	public void addBBInfoHistory(HttpServletRequest request,Map beforeBBMap,String ctguid,String bbType,String tabTypeName){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		 
		try{
			conn = new DBConnect().getConnect();
			
			ContentService cs = new ContentService(conn);
			
			/**
			 * 得到 修改前的 该条 报备 数据 的 map
			 */
			Map beforeBBMaps = beforeBBMap;
			
			/**
			 *  得到修改后的该报备数据 map
			 */
			Map nowBBMap = cs.getBBInfo(ctguid,tabTypeName);
			
			/**
			 * 要比较的字段
			 */
			Map fieldMap = cs.getBBField(tabTypeName);
			
			String id = "";
			String beforeValue = "";
			String nowValue = "";
			String fieldChineseName = "";
			
			
			String bbId = ctguid;
			String bbTypes = bbType;
			String changeTime = af.getCurrentDate()+" "+af.getCurrentTime();
			String changeReason = request.getParameter("changeReason");
			
			Map bbInfoMap = new HashMap();
			
			bbInfoMap.put("bbid", bbId);
			bbInfoMap.put("bbtype", bbTypes);
			bbInfoMap.put("changetime", changeTime);
			bbInfoMap.put("changereason", changeReason);
			bbInfoMap.put("loginid", loginid);
			bbInfoMap.put("loginname", loginname);
			
			
			for(Object key : fieldMap.keySet()){
				beforeValue = af.showNull(beforeBBMaps.get(key)+"");
				nowValue = af.showNull(nowBBMap.get(key)+"");
			      if(!beforeValue.trim().equals(nowValue.trim())){
			    	  fieldChineseName = cs.getBBFieldChineseName(key.toString(), tabTypeName);
			    	  
			    	  id = UUID.randomUUID().toString();
			    	  bbInfoMap.put("id", id);
			    	  
			    	  bbInfoMap.put("beforevalue", beforeValue);
			    	  bbInfoMap.put("nowvalue", nowValue);
			    	  bbInfoMap.put("changefield", fieldChineseName);
			    	  
			    	  // 保存 修改 报备数据 痕迹
			    	  cs.addBBInfoHistory(bbInfoMap);
			      }
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}
	
	
	/**
	 * 报备数据修改变更 记录
	 * @param request  
	 * @param response
	 * @return
	 */
	public ModelAndView bbHistoryList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(BBHISTORYLIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		
		// 防伪编号
		String bbbh = request.getParameter("bbbh");
		// 报备类型
		String bbType = request.getParameter("bbType");
		// 变更字段
		String changeField = request.getParameter("changeField");
		// 变更时间
		String changeTime1 = request.getParameter("changeTime1");
		String changeTime2 = request.getParameter("changeTime2");
		
		
		try {
			//备份之前的的sql语句
			String sql = " select i.*,c.bbbh from BB_InfoChange i left join bb_content1 c on i.bbid = c.guid where c.bbperson='"+loginid+"' and loginid<>'' and i.changefield<>'基准价' ";
			//废弃
			//String sql="select * FROM ( select * from (select i.*,c.bbbh   FROM bb_infochange i left join bb_content1 c on i.bbid = c.guid where c.bbperson='111212' and loginid<>'' union all select '' as id,''as bbid,wtxmlx as bbtype,'' as changefield , '' as beforevaluem,''as noewvalue,'111212' as loginid,'111212' as loginname,updata as changetime,upreason as changereason,'' as initflag,'' as timeflag,bbbh from bb_content1 where updata is not null) as kk ) as t";
			
			if(bbbh!=null && !"".equals(bbbh)){
				sql += "  and bbbh like '%"+bbbh+"%'";
			}
			
			if(bbType!=null && !"".equals(bbType)){
				sql += "  and bbType like '%"+bbType+"%'";
			}
			
			if(changeField!=null && !"".equals(changeField)){
				sql += "  and changeField like '%"+changeField+"%'";
			}
			
			
			if(changeTime1!=null && !"".equals(changeTime1) && changeTime2!=null && !"".equals(changeTime2)){
				sql += "  and ( changeTime between '"+changeTime1+" 00:00:00' and '"+changeTime2+" 24:00:00' ) ";
			}else{
				if(changeTime1!=null && !"".equals(changeTime1)){
					sql += "  and changeTime like '%"+changeTime1+"%'";
				}
				if(changeTime2!=null && !"".equals(changeTime2)){
					sql += "  and changeTime like '%"+changeTime2+"%'";
				}
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("报备数据修改变更记录");
			 
			pp.setTableID("bbHistoryList");
			
			pp.addColumn("防伪编号", "bbbh","showCenter"); 
			pp.addColumn("报备类型", "bbtype","showCenter");
			pp.addColumn("变更字段", "changefield","showCenter");
			pp.addColumn("变更前的值", "beforevalue","showCenter");
			pp.addColumn("变更后的值", "nowvalue","showCenter");
			pp.addColumn("变更时间", "changetime","showCenter");
			//pp.addColumn("变更原因", "changereason","showCenter");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("changetime");
			pp.setDirection("desc");
			pp.setPageSize_CH(10);
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param conn
	 * @param guid
	 */
	public void saveApply(HttpServletRequest request,Connection conn,String guid,String opt){
		ASFuntion af = new ASFuntion();
		String applyDate = af.getCurrentDate()+" "+af.getCurrentTime();
		String isauditPropery = af.showNull(request.getParameter("isauditPropery"));
		
		System.out.println("========================================================isauditPropery:"+isauditPropery);
		
		if("".equals(isauditPropery)){
			isauditPropery = "否";
		}
		
		// 收费标准 
		String sfbz = request.getParameter("sfbz");
		String standard = request.getParameter("standard");
		String standerPrice = request.getParameter("standerPrice");
		
		String autoAudit = request.getParameter("autoAudit");
		String isnext = request.getParameter("isnext");
		String discountBySeven = request.getParameter("discountBySeven");
		String iszxw = request.getParameter("iszxw");
		
		BBApplyTable at = new BBApplyTable();
		
		at.setGuid(guid);
		at.setApplyDate(applyDate);
		at.setIsauditPropery(isauditPropery);
		at.setStandard(standard);
		at.setStanderPrice(standerPrice);
		at.setPropertys(sfbz);
		
		at.setAutoAudit(autoAudit);
		at.setIsnext(isnext);
		at.setDiscountBySeven(discountBySeven);
		at.setIszxw(iszxw);
		
		BBApplyService as = new BBApplyService(conn);
		if("add".equalsIgnoreCase(opt)){
			at.setAuditPropery("申请审核");
			as.addApply(at);
		}else{
			try {
				String tempORFinish = request.getParameter("tempORFinish");
				if("申请审核".equals(tempORFinish) || "待审申请审核".equals(tempORFinish)){
					String sql = " select guid from bb_apply where guid = ? ";
					String guid2 = af.showNull(new DbUtil(conn).queryForString(sql, new Object[]{at.getGuid()}));
					if(guid2==null || "".equals(guid2)){
						at.setAuditPropery(tempORFinish);
						as.addApply(at);
					}else{
						at.setAuditPropery(tempORFinish);
						as.updateApply(at);
					}
				}else{
					at.setAuditPropery(tempORFinish);
					as.updateApply(at);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
	}
	
	/**
	 * 保存
	 * @param request
	 * @param conn
	 * @param guid
	 */
	public void saveHour(HttpServletRequest request,Connection conn,String bbguid,String opt){
		ASFuntion af = new ASFuntion();
		
		String[] duty = request.getParameterValues("duty");
		String[] countPeople = request.getParameterValues("countPeople");
		String[] countHour = request.getParameterValues("countHour");
		String[] countMoney = request.getParameterValues("countMoney");
		String[] property = request.getParameterValues("property");
		
		BBHourService hs = new BBHourService(conn);
		
		
		try {
			
			new DbUtil(conn).executeUpdate(" delete from bb_hour where bbguid = ? ", new Object[]{bbguid});
			
			for (int i = 0; i < duty.length; i++) {
				BBHourTable ht = new BBHourTable();
				ht.setGuid(UUID.randomUUID().toString());
				ht.setBbguid(bbguid);
				ht.setDuty(duty[i]);
				ht.setCountPeople(countPeople[i]);
				ht.setCountHour(countHour[i]);
				ht.setCountMoney(countMoney[i]);
				ht.setPropertys(property[i]);
				ht.setIrecno((i+1)+"");
				// 工时表
				hs.addBBHour(ht);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	
	/**
	 * List 转 Map
	 * @param list
	 * @return
	 */
	public Map listToMap(List list){
		
		Map mapTotal = new HashMap();
		
		for (Object object : list) {
			BBHourTable bt = (BBHourTable)object;
//			if("初级助理".equals(bt.getDuty())){
//				mapTotal.put("primaryAssistant", bt);
//			};
			if("助理".equals(bt.getDuty())){
				mapTotal.put("assistant", bt);
			};
			if("注册会计师".equals(bt.getDuty())){
				mapTotal.put("cpa", bt);
			};
			if("项目经理".equals(bt.getDuty())){
				mapTotal.put("projecter", bt);
			};
			if("部门经理".equals(bt.getDuty())){
				mapTotal.put("department", bt);
			};
			if("主任会计师".equals(bt.getDuty())){
				mapTotal.put("chairman", bt);
			};
//			if("评估所法人代表、首席评估师".equals(bt.getDuty())){
//				mapTotal.put("duty1", bt);
//			};
//			if("评估所合伙人、部门经理".equals(bt.getDuty())){
//				mapTotal.put("duty2", bt);
//			};
//			if("注册评估师".equals(bt.getDuty())){
//				mapTotal.put("duty3", bt);
//			};
//			if("助理评估人员".equals(bt.getDuty())){
//				mapTotal.put("duty4", bt);
//			};
		}
		
		return mapTotal;
		
	}
	
	/**
	 * 生成报备编号
	 * @param area
	 * @return
	 */
	public synchronized String createBbbh(String area){
		String bbbh="";
		try {
			bbbh = new DELAutocode().getAutoCode("报备编号", area);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bbbh;
	}
	
	/**
	 * 清算审计和审计保存金额
	 * @param request
	 * @param conn
	 * @param bbguid
	 */
	public void saveMoney(HttpServletRequest request,Connection conn,String bbguid,String typeid){
		
		String[] years = request.getParameterValues("years");
		String[] zcze = request.getParameterValues("zcze");
		String[] xssr = request.getParameterValues("xssr");
		String[] yysr = request.getParameterValues("yysr");
		String[] zxsjje = request.getParameterValues("zxsjje");
		String[] cyry = request.getParameterValues("cyry");
		
		SJMoneyService ss = new SJMoneyService(conn);
		
		try {
			
			new DbUtil(conn).executeUpdate(" delete from bb_sjmoney where bbguid = ? ", new Object[]{bbguid});
			
			for (int i = 0; i < years.length; i++) {
				SJMoneyTable st = new SJMoneyTable();
				st.setGuid(UUID.randomUUID().toString());
				st.setBbguid(bbguid);
				st.setTypeid(typeid);
				st.setYears(years[i]);
				st.setZcze(zcze[i]);
				st.setXssr(xssr[i]);
				st.setYysr(yysr[i]);
				st.setZxsjje(zxsjje[i]);
				st.setCyry(cyry[i]);
				st.setPropertys((i+1)+"");
				
				// 审计金额
				ss.addSJMoney(st);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	
	/**
	 * List 转 Map
	 * @param list
	 * @return
	 */
	public Map listToMaps(List list){
		
		Map mapTotal = new HashMap();
		
		String[] yearCHArray = {
				"第一年","第二年","第三年","第四年","第五年","第六年","第七年","第八年","第九年","第十年",
				"第十一年","第十二年","第十三年","第十四年","第十五年","第十六年","第十七年","第十八年","第十九年","第二十年",
				"第二十一年","第二十二年","第二十三年","第二十四年","第二十五年","第二十六年","第二十七年","第二十八年","第二十九年","第三十年"};
		
		String[] yearENArray = {
				"oneYear","twoYear","threeYear","fourYear","fiveYear","sixYear","sevenYear","eightYear","nineYear","tenYear",
				"elevenYear","twelveYear","thirteenYear","fourteenYear","fifteenYear","sixteenYear","seventeenYear","eightteenYear","nineteenYear","twentyYear",
				"twentyoneYear","twentytwoYear","twentythreeYear","twentyfourYear","twentyfiveYear","twentysixYear","twentysevenYear","twentyeightYear","twentynineYear","thirtyYear"};
					
		for (Object object : list) {
			SJMoneyTable st = (SJMoneyTable)object;
			for(int i=0;i<yearCHArray.length;i++){
				if(yearCHArray[i].equals(st.getYears())){
					mapTotal.put(yearENArray[i], st);
				}
			}
		}
		
		return mapTotal;
	}
	
	/**
	 * 审计、清算申请
	 * @param obj
	 * @param typeId
	 * @return
	 */
	public List setBeanToList(Object obj,String typeId){
		List list = new ArrayList();
		SJMoneyTable smt = new SJMoneyTable();
		if("sj001".equalsIgnoreCase(typeId)){
			SjTable st = (SjTable)obj;
			smt.setBbguid(st.getGuid());
			smt.setTypeid(typeId);
			smt.setYears("第一年");
			smt.setZcze(st.getZcze());
			smt.setXssr(st.getXssr());
			smt.setYysr(st.getYysr());
			if("".equals(st.getZxsjje()) || null==st.getZxsjje()){
				smt.setZxsjje("0");
			}else{
				smt.setZxsjje(st.getZxsjje());
			}
			smt.setCyry(st.getCyry());
		}else if("qssh001".equalsIgnoreCase(typeId)){
			QsshbTable qt = (QsshbTable)obj;
			smt.setBbguid(qt.getGuid());
			smt.setTypeid(typeId);
			smt.setYears("第一年");
			smt.setZcze(qt.getZcze());
			smt.setXssr(qt.getXssr());
			if("".equals(qt.getYysr()) || null==qt.getYysr()){
				smt.setYysr("0");
			}else{
				smt.setYysr(qt.getYysr());
			}
			if("".equals(qt.getZxsjje()) || null==qt.getZxsjje()){
				smt.setZxsjje("0");
			}else{
				smt.setZxsjje(qt.getZxsjje());
			}
			smt.setCyry(qt.getCyry());
		}
		
		list.add(smt);
		
		return list;
	}
	
	

	/**
	 * 生成四位随机数
	 * @return
	 */
	public synchronized String getRandom(){
		String random = "";
		double drm = Math.random() * 10000;
		int irm = (int)drm;
		if(String.valueOf(irm).length()!=4){
			String currentTimeMillis = System.currentTimeMillis()+"";
			random = currentTimeMillis.substring(currentTimeMillis.length()-4,currentTimeMillis.length());
		}else{
			random = irm+"";
		}
		
		return random;
	}
	
	
	/**
	 * 申请审核或者报备完成记录 报备修改痕迹
	 * @param conn
	 * @param beforeValue
	 * @param nowValue
	 * @param ct
	 * @param loginId
	 * @param loginName
	 */
	public void addBBStateInfoHistory(Connection conn,String beforeValue,String nowValue,ContentTable ct,String loginId,String loginName){
		ASFuntion af = new ASFuntion();
		
		Map map = new HashMap();
		String id = UUID.randomUUID().toString();
		String bbid = ct.getGuid();
		String bbtype = ct.getWtxmlx();
		String changefield = "报备状态";
		String changetime = af.getCurrentDate()+" "+af.getCurrentTime();
		String changereason = loginName+"进行了"+nowValue+"操作！";
		
		//如果是"申请审核"时报备轨迹里显示申请审核的"情况说明"
		if("申请审核".equals(nowValue)){
			try {
				changereason = new DbUtil(conn).queryForString("select standard from bb_apply where guid=?",new Object[]{bbid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		map.put("id",id);
		map.put("bbid",bbid);
		map.put("bbtype",bbtype);
		map.put("changefield",changefield);
		map.put("beforevalue",beforeValue);
		map.put("nowvalue",nowValue);
		
		map.put("loginid",loginId);
		map.put("loginname",loginName);
		map.put("changetime",changetime);
	    map.put("changereason",changereason);
	
	    ContentService cs = new ContentService(conn);
	    
	    try {
	    	// 增加历史记录
			cs.addBBInfoHistory(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ModelAndView checkIsOldRecord(HttpServletRequest request,HttpServletResponse response){
		String chooseValue = StringUtil.showNull(request.getParameter("GUID"));
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String oldLoginId = null;
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter out = null ;
		try {
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			String sql = "select BBPERSON from BB_CONTENT1 where GUID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, chooseValue);
			rs = ps.executeQuery();
			if(rs.next()){
				oldLoginId = rs.getString("BBPERSON");
			}
			if(!loginid.equals(oldLoginId)){
				out.print("NO");				
			}else{ 
				out.print("OK");
			}
		} catch (Exception e) {
			out.print("系统错误,请联系管理员！"); 
			e.printStackTrace();
		} finally{
			if(out!=null)out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 分所报备列表
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goFsList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(FS_LIST);
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");			
			String sql = "SELECT c.guid,c.companyGUID,c.WTXMLX,m.loginname,c.bbstate," +
					"c.BBBH,c.BSDWMC,c.ywarea,c.sfbz,c.YSYWF,c.YSYWFed,c.bbtime,c.typeid FROM dbo.BB_CONTENT1 c INNER JOIN " +
					"K_Company m ON c.BBPERSON=m.loginid WHERE parentId='"+loginid+"' and (bbstate='待审报备完成' or bbstate='待审申请审核')";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("分所报备审核列表");
			pp.setTableID("reportPrintList");
//			pp.setInputType("radio");
			pp.addColumn("委托项目类型", "WTXMLX").setTdProperty("align='left' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("分所名称", "loginname").setTdProperty("align='left' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("防伪编号", "BBBH").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("被审（验）单位", "BSDWMC").setTdProperty("align='left' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("业务所在地", "ywarea").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("计费方式", "sfbz").setTdProperty("align='left' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("业务约定书收费金额", "YSYWF").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("已收业务费", "YSYWFed").setTdProperty("align='center' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.addColumn("报备状态", "bbstate").setTdProperty("align='left' onclick=f_viewTD('${guid}','${companyGUID}','${typeid}')");
			pp.setOrderBy_CH("bbtime");
			pp.setDirection("desc");
			pp.setSQL(sql);			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	/**
	 * 总所审批
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView passOrNopass(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(FS_LIST);
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid");
			String guid = request.getParameter("guid");
			String p = request.getParameter("p");
			if("pass".equals(p)){
				String bbstate = new DbUtil(conn).queryForString("select bbstate from bb_content1 where guid='"+guid+"'");
				new DbUtil(conn).executeUpdate("update bb_content1 set bbstate='"+bbstate.substring(2)+"' where guid='"+guid+"'");
				if("待审申请审核".equals(bbstate)){
					new DbUtil(conn).executeUpdate("update bb_apply set auditPropery='"+bbstate.substring(2)+"' where guid='"+guid+"'");
				}
			}else{
//				String bbstate = new DbUtil(conn).queryForString("select bbstate from bb_content1 where guid='"+guid+"'");
				new DbUtil(conn).executeUpdate("update bb_content1 set bbstate='审核未通过' where guid='"+guid+"'");
			}
			response.sendRedirect("bb.do?method=goFsList");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
