package cn.org.gdicpa.web.action.content;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.Foder;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.net.Web;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.bbbbqtb.model.BbPrint;
import cn.org.gdicpa.web.service.companyList.CompanyListService;
import cn.org.gdicpa.web.service.companyList.model.CompanyListTable;
import cn.org.gdicpa.web.service.content.BBApplyService;
import cn.org.gdicpa.web.service.content.ContentService;
import cn.org.gdicpa.web.service.content.model.ContentTable;
import cn.org.gdicpa.web.service.user.UserService;

import com.swetake.util.Qrcode;

public class ContentAction extends MultiActionController{
	private static String LIST = "/content/list.jsp";
	private static String SEARCH = "/content/search.jsp";
	private static String PUNISHLIST = "/common/punishList.jsp";
	
	/**
	 * 页面跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		String p = request.getParameter("p");
		System.out.println(this.getClass()+" >>>>>   p = "+p);
		if("search".equals(p)){
			model = new ModelAndView(SEARCH);
		} 
		
		return model;
	}
		
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ASFuntion af = new ASFuntion();
		ModelAndView model = null;
		String p = af.showNull(request.getParameter("p"));
		String bgnd = "";
		if("ywfxtj".equals(p)){
			model = new ModelAndView(LIST);
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String loginid = (String)userSession.getUserMap().get("loginid");
			String ctype=(String)userSession.getUserMap().get("ctype");
			String cpano=(String)userSession.getUserMap().get("cpano");//注师编号
			
			try {
				String sql = "";
				String sql0 = "";
							
				if ("团体会员".equals(ctype)){
					//显示全部是我这个机构的；
					sql+=" and BBPERSON = '"+loginid+"' ";
				}else{
					//显示是我审计的；
					sql+=" and (cpa1 = '"+cpano+"' or cpa2 = '"+cpano+"'  or cpa3 = '"+cpano+"' or cpa4 = '"+cpano+"' or cpa5 = '"+cpano+"' or cpa6 = '"+cpano+"')";
				}
				
				
				sql0 = "select * from "
						+" ("
						+" select typeid  , wtxmlx  from bb_content1 where bbperson = '"+loginid+"' group by typeid ,wtxmlx "
						+" ) aa left join "
						+" ("
						+" select typeid as typeid2,wtxmlx as wtxmlx2,count(wtxmlx) as bs,left(sum(ysywf),len(sum(ysywf))) as ysywf," 
						+ " left(sum(ysywfed),len(sum(ysywfed))) as ysywfed,max(bgnd) as bgnd,max(bbtime) as bbtime,"
						+ " bbperson,max(cpa1) as cpa1,max(cpa2) as cpa2,"
						+ " max(cpa3) as cpa3,max(cpa4) as cpa4,max(cpa5) as cpa5,max(cpa6) as cpa6"
						+ " from BB_CONTENT1 where 1=1   "+sql ;
				 
				sql = " select * from (select typeid,wtxmlx,count(wtxmlx) as bs,left(sum(ysywf),len(sum(ysywf))) as ysywf," 
						   + " left(sum(ysywfed),len(sum(ysywfed))) as ysywfed,max(bgnd) as bgnd,max(bbtime) as bbtime,"
						   + " bbperson,max(cpa1) as cpa1,max(cpa2) as cpa2,"
						   + " max(cpa3) as cpa3,max(cpa4) as cpa4,max(cpa5) as cpa5,max(cpa6) as cpa6"
						   + " from BB_CONTENT1 where 1=1 and bbstate!='暂存' and bbstate!='作废'  "+sql;
				
				DataGridProperty pp = new DataGridProperty();
				
				
				//搜索条件参数
				//报备年度：          委托项目类型：    
				bgnd = af.showNull(request.getParameter("bgnd"));
				String wtxmlx = af.showNull(request.getParameter("wtxmlx"));
				request.getSession().setAttribute("wtxmlx", wtxmlx);
				
				//委托单位：          被审（验）单位：  
				String wtdw = af.showNull(request.getParameter("wtdw"));
				String bsydw = af.showNull(request.getParameter("bsydw"));
				request.getSession().setAttribute("wtdw", wtdw);
				request.getSession().setAttribute("bsydw", bsydw);
				
				//客户出资类型：         客户经济性质：  
				String khczlx = af.showNull(request.getParameter("khczlx"));
				String khjjxz = af.showNull(request.getParameter("khjjxz"));
				request.getSession().setAttribute("khczlx", khczlx);
				request.getSession().setAttribute("khjjxz", khjjxz);
				
				//客户行业类型：         是否上市企业：   
				String khhylx = af.showNull(request.getParameter("khhylx"));
				String sfssqy = af.showNull(request.getParameter("sfssqy"));
				request.getSession().setAttribute("khhylx", khhylx);
				request.getSession().setAttribute("sfssqy", sfssqy);
				
				//报告 意见 类型：         报   备    状   态：  
				String bgyjlx = af.showNull(request.getParameter("bgyjlx"));
				String bbstate = af.showNull(request.getParameter("bbstate"));
				request.getSession().setAttribute("bgyjlx", bgyjlx);
				request.getSession().setAttribute("bbstate", bbstate);
				
				// 业  务  所 在 地：  
				String ywarea = af.showNull(request.getParameter("ywarea"));
				request.getSession().setAttribute("ywarea", ywarea);
				

				String qmzs = af.showNull(request.getParameter("qmzs"));
				request.getSession().setAttribute("qmzs", qmzs);
				
				// 签名注师 cpa 定位或者模糊参数
				String qmzscpa = request.getParameter("qmzscpa");
				request.getSession().setAttribute("qmzscpa", qmzscpa);
				
				String qmzs1 = af.showNull(request.getParameter("qmzs1"));
				String qmzs2 = af.showNull(request.getParameter("qmzs2"));
				String qmzs3 = af.showNull(request.getParameter("qmzs3"));
				request.getSession().setAttribute("qmzs1", qmzs1);
				request.getSession().setAttribute("qmzs2", qmzs2);
				request.getSession().setAttribute("qmzs3", qmzs3);
				
				String qmzs4 = af.showNull(request.getParameter("qmzs4"));
				String qmzs5 = af.showNull(request.getParameter("qmzs5"));
				String qmzs6 = af.showNull(request.getParameter("qmzs6"));
				request.getSession().setAttribute("qmzs4", qmzs4);
				request.getSession().setAttribute("qmzs5", qmzs5);
				request.getSession().setAttribute("qmzs6", qmzs6);
				
				String ysywf="";
				String ysywf1 = af.showNull(request.getParameter("ysywf1"));
				String ysywf2 = af.showNull(request.getParameter("ysywf2"));
				request.getSession().setAttribute("ysywf1", ysywf1);
				request.getSession().setAttribute("ysywf2", ysywf2);
				
				
				String ysywfed="";
				String ysywfed1 = af.showNull(request.getParameter("ysywf11"));
				String ysywfed2 = af.showNull(request.getParameter("ysywf12"));
				request.getSession().setAttribute("ysywfed1", ysywfed1);
				request.getSession().setAttribute("ysywfed2", ysywfed2);
				
				String bbtime="";
				String bbtime1 = af.showNull(request.getParameter("bbtime1"));
				String bbtime2 = af.showNull(request.getParameter("bbtime2"));
				request.getSession().setAttribute("bbtime1", bbtime1);
				request.getSession().setAttribute("bbtime2", bbtime2);
				
				String bgtime="";
				String bgtime1 = af.showNull(request.getParameter("bgtime1"));
				String bgtime2 = af.showNull(request.getParameter("bgtime2"));
				request.getSession().setAttribute("bgtime1", bgtime1);
				request.getSession().setAttribute("bgtime2", bgtime2);
				
				
				
				
				//搜索条件sql语句的拼接
				//报备年度：          委托项目类型：    
				/*if(!"".equals(bgnd)) {
					bgnd = "  and  bgnd like '%"+bgnd+"%'" ;
				}*/
				
				if(!"".equals(wtxmlx)) {
					//wtxmlx = "  and  wtxmlx like '%"+wtxmlx+"%'" ;
					wtxmlx = "  and  wtxmlx = '" + wtxmlx + "'";
				}
				
				//委托单位：          被审（验）单位：  
				if(!"".equals(wtdw)) {
					wtdw = "  and  wtdwmc like '%"+wtdw+"%'" ;
				}
				if(!"".equals(bsydw)) {
					bsydw = "  and  bsdwmc like '%"+bsydw+"%'" ;
				}
				
				
				//客户出资类型：         客户经济性质：  
				if(!"".equals(khczlx)) {
					khczlx = "  and  khczlx like '%"+khczlx+"%'" ;
				}
				if(!"".equals(khjjxz)) {
					khjjxz = "  and  khjjxj like '%"+khjjxz+"%'" ;
				}
				
				//客户行业类型：         是否上市企业：   
				if(!"".equals(khhylx)) {
					khhylx = "  and  kmhylx like '%"+khhylx+"%'" ;
				}
				if(!"".equals(sfssqy)) {
					sfssqy = "  and  sfssqy like '%"+sfssqy+"%'" ;
				}
				
				//报告 意见 类型：         报   备    状   态：  
				if(!"".equals(bgyjlx)) {
					bgyjlx = "  and  bgyjlx like '%"+bgyjlx+"%'" ;
				}
				if(!"".equals(bbstate)) {
					bbstate = "  and  bbstate like '%"+bbstate+"%'" ;
				}
				
				// 业  务  所 在 地：  
				if(!"".equals(ywarea)) {
					ywarea = "  and  ywarea like '%"+ywarea+"%'" ;
				}
				
				//注师的定位查询与模糊查询、
				
				if(!"".equals(qmzs)){
					 qmzs =" and ( qmzs1 = '"+qmzs+"' or cpa1 = '"+qmzs+"' or qmzs2 = '"+qmzs+"' or cpa2 = '"+qmzs+"' or qmzs3 = '"+qmzs+"' or cpa3 = '"+qmzs+"' or qmzs4 = '"+qmzs+"' or cpa4 = '"+qmzs+"' or qmzs5 = '"+qmzs+"' or cpa5 = '"+qmzs+"' or qmzs6 = '"+qmzs+"' or cpa6 = '"+qmzs+"' ) ";
				}
				
				if(!"".equals(qmzs1)){
					qmzs1="  and ( qmzs1 = '"+qmzs1+"' or cpa1 = '"+qmzs1+"' )";
				}
				
				if(!"".equals(qmzs2)){
					qmzs2="  and ( qmzs2 = '"+qmzs2+"' or cpa2 = '"+qmzs2+"' )";
				}
				
				if(!"".equals(qmzs3)){
					qmzs3="  and ( qmzs3 = '"+qmzs3+"' or cpa3 = '"+qmzs3+"' )";
				}
				
				if(!"".equals(qmzs4)){
					qmzs4="  and ( qmzs4 = '"+qmzs4+"' or cpa4 = '"+qmzs4+"' )";
				}
				
				if(!"".equals(qmzs5)){
					qmzs5="  and ( qmzs5 = '"+qmzs5+"' or cpa5 = '"+qmzs5+"' )";
				}
				
				if(!"".equals(qmzs6)){
					qmzs6="  and ( qmzs6 = '"+qmzs6+"' or cpa6 = '"+qmzs6+"' )";
				}
				
				//应收业务费：
				
				if(!"".equals(ysywf1) && !"".equals(ysywf2)){
					ysywf= "  and ( ysywf >= '"+ysywf1+"' and ysywf<= '"+ysywf2+"' ) ";
				}else{
					if(!"".equals(ysywf1)){
						ysywf= "  and ysywf >= '"+ysywf1+"'";
					}
					if( !"".equals(ysywf2)){
						ysywf= "  and ysywf <= '"+ysywf2+"'";
					}
				}
				// 已收业务费：
				
				// 已收业务费
				if( !"".equals(ysywfed1) &&  !"".equals(ysywfed2)){
					ysywfed = "  and ( ysywfed >= '"+ysywfed1+"' and ysywfed<= '"+ysywfed2+"' ) ";
				}else{
					if( !"".equals(ysywfed1)){
						ysywfed = "  and ysywfed >= '"+ysywfed1+"'";
					}
					if( !"".equals(ysywfed2)){
						ysywfed = "  and ysywfed <= '"+ysywfed2+"'";
					}
				}
				
				//报备时间
				
				if( !"".equals(bbtime1) &&  !"".equals(bbtime2)){
					bbtime= "  and bbtime <>'' and ( cast(bbtime as DateTime) between cast('"+bbtime1+"' as DateTime) and cast('"+bbtime2+"' as DateTime) ) ";
				}else{
					if(!"".equals(bbtime1)){
						bbtime= " and bbtime <>'' and cast(bbtime as DateTime) <= cast('"+bbtime1+"' as DateTime) ";
					}
					if(!"".equals(bbtime2)){
						bbtime= " and bbtime <>'' and cast(bbtime as DateTime) >= cast('"+bbtime2+"' as DateTime) ";
					}
				}
				
				// 报告日期
				if(!"".equals(bgtime1) && !"".equals(bgtime2)){
					bgtime= "  and ( bgrq between '"+bgtime1+"' and '"+bgtime2+" 24:00:00' )";
				}else{
					if(!"".equals(bgtime1)){
						bgtime= "   and bgrq  >= '"+bgtime1+"'";
					}
					if(!"".equals(bgtime2)){
						bgtime= "  and bgrq <= '"+bgtime2+"'";
					}
				}
				
				
				sql = sql 
						+wtxmlx+wtdw+bsydw+khczlx+khjjxz+khhylx+sfssqy+bbstate+ywarea
						+qmzs+qmzs1+qmzs2+qmzs3+qmzs4+qmzs5+qmzs6
						+ysywf+ysywfed+bbtime+bgtime
						+ "  group by typeid,wtxmlx,bbperson)  as a where 1=1 ";
				
				
				sql0=sql0
						+wtxmlx+wtdw+bsydw+khczlx+khjjxz+khhylx+sfssqy+bbstate+ywarea
						+qmzs+qmzs1+qmzs2+qmzs3+qmzs4+qmzs5+qmzs6
						+ysywf+ysywfed+bbtime+bgtime
						+ "  group by typeid,wtxmlx,bbperson) bb on aa.typeid=bb.typeid2 ";
				
				/*if("".equals(wtxmlx)) {
					sql=sql0;
				}*/
				
				System.out.println("sql======="+sql);
				
				pp.setTitle("业务分析统计");
				 
				pp.setTableID("content"); 
				
				
				pp.addColumn("委托项目类型", "wtxmlx").setTdProperty("align='left' onclick=go_this('${typeid}'); " );
				pp.addColumn("报备业务总笔数", "bs").setTdProperty("align='center' onclick=go_this('${typeid}'); ");
				pp.addColumn("业务约定书收费金额", "ysywf","showMoney").setTdProperty("align='right'");
				pp.addColumn("已收业务费", "ysywfed","showMoney").setTdProperty("align='right'");
				
				
				pp.setSQL(sql);
				pp.setPageSize_CH("10");
				pp.setOrderBy_CH("bs");
				pp.setDirection("desc");
				System.out.println(this.getClass()+"    sql="+sql);
				request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
				request.getSession().setAttribute("loginid", loginid);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			}
		}else{
			model = new ModelAndView(SEARCH);
		}
		model.addObject("bgnd", bgnd);
		return model;
	}
	
	
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index_bak(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ASFuntion af = new ASFuntion();
		ModelAndView model = null;
		String p = af.showNull(request.getParameter("p"));
		System.out.println(this.getClass()+"         p="+p);
		if("ywfxtj".equals(p)){
			model = new ModelAndView(LIST);
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			String loginid = (String)userSession.getUserMap().get("loginid");
			String ctype=(String)userSession.getUserMap().get("ctype");
			String cpano=(String)userSession.getUserMap().get("cpano");//注师编号
			
			try {
				String sql = "";
							
				if ("团体会员".equals(ctype)){
					//显示全部是我这个机构的；
					sql+=" and BBPERSON = '"+loginid+"' ";
				}else{
					//显示是我审计的；
					sql+=" and (cpa1 = '"+cpano+"' or cpa2 = '"+cpano+"'  or cpa3 = '"+cpano+"' or cpa4 = '"+cpano+"' or cpa5 = '"+cpano+"' or cpa6 = '"+cpano+"')";
				}
				
				sql = " select * from (select wtxmlx,count(wtxmlx) as bs,left(sum(ysywf),len(sum(ysywf))) as ysywf," 
				   + " left(sum(ysywfed),len(sum(ysywfed))) as ysywfed,max(bgnd) as bgnd,max(bbtime) as bbtime,"
				   + " bbperson,max(cpa1) as cpa1,max(cpa2) as cpa2,"
				   + " max(cpa3) as cpa3,max(cpa4) as cpa4,max(cpa5) as cpa5,max(cpa6) as cpa6"
				   + " from BB_CONTENT1 where 1=1 and bbstate!='暂存' and bbstate!='作废'  "+sql+"  ${bgndmatech} ${wtxmlx} group by wtxmlx,bbperson) as a where 1=1 ";
				   
				
				System.out.println(sql);
				DataGridProperty pp = new DataGridProperty(){
					public void onSearch(HttpSession session,HttpServletRequest request,
							HttpServletResponse response) throws Exception {
						 
							String bgndmatech = getRequestValue("bgndmatech");
							String wtxmlx = getRequestValue("wtxmlx");
							System.out.println("bgndmatech="+bgndmatech+"  wtxmlx="+wtxmlx);
							if(bgndmatech!=null && !"".equals(bgndmatech)) {
								bgndmatech = "  and  bgnd like '%"+bgndmatech+"%'" ;
								System.out.println("22222222222222     bgndmatech="+bgndmatech);
							}
							if(wtxmlx!=null && !"".equals(wtxmlx)) {
								wtxmlx = "  and  wtxmlx like '%"+wtxmlx+"%'" ;
							}
							this.setOrAddRequestValue("bgndmatech", bgndmatech);
							this.setOrAddRequestValue("wtxmlx", wtxmlx);
					}
				};
				
				pp.setTitle("业务分析统计");
				 
				pp.setTableID("content"); 
				
				
				pp.addColumn("委托项目类型", "wtxmlx").setTdProperty("align='left'");
				pp.addColumn("报备业务笔数", "bs").setTdProperty("align='center'");
				pp.addColumn("业务约定书收费金额", "ysywf","showMoney").setTdProperty("align='right'");
				pp.addColumn("已收业务费", "ysywfed","showMoney").setTdProperty("align='right'");
				
				
				pp.setSQL(sql);
				pp.addSqlWhere("bgndmatech", "${bgndmatech}");
				pp.addSqlWhere("wtxmlx", "${wtxmlx}");
				pp.setOrderBy_CH("bs");
				pp.setDirection("desc");
				System.out.println(this.getClass()+"    sql="+sql);
				request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			}
		}else{
			model = new ModelAndView(SEARCH);
		}
		model.addObject("bgbdmatech", "209922年");
		return model;
	}
	
	

	/**
	 * 作废
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView invalid(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
//		String bbreason = new String(request.getParameter("bbreason").getBytes("ISO8859_1"),"GB2312");  
		String bbreason = request.getParameter("bbreason");  
		String GUID = request.getParameter("ctguid");
		String typeid = request.getParameter("typeid");
		String bbstate = request.getParameter("bbstate");
		String reportCount = request.getParameter("reportCount");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			// 判断报备时间
			String temp = "";
			String bbtime = cs.getBBTime(GUID);
			
			String now = new ASFuntion().getDateAndTime();
			System.out.println(this.getClass()+" >>>>>>>>>>>>>>>>>>>>>>>>  bbtime = "+bbtime+"        now = "+now+"reportCount="+reportCount+"bbstate="+bbstate);
			
			// 得到报备时间下一个月的这个时间与当前时间比较
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 格式化对象
			Calendar calendar = Calendar.getInstance();// 日历对象
			if(bbtime==null || "".equals((bbtime))){
				bbtime = "2011-01-01 01:01";
			}
			if(bbtime!=null && !"".equals((bbtime))){
				if(bbtime.length()<16 && bbtime.length()>=10){
					bbtime = bbtime.substring(0, 10)+" 01:01";
				}else{
					bbtime = bbtime.substring(0, bbtime.length())+" 01:01";
				}
			}
			calendar.setTime(sdf.parse(bbtime));// 设置报备日期
			calendar.add(Calendar.MONTH, 1);// 月份加一
			temp=sdf.format(calendar.getTime());
			
			DateUtil dateutile = new DateUtil();
			int days = dateutile.equalDate(temp, now);
			System.out.println("报备时间的下一月的时间为temp = "+temp+"    days = "+days);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			
			if(days<=0){
				Boolean bl = cs.invalid(GUID, bbreason,loginid,reportCount);
				if(bl){
					// 记录 报备 数据 修改 轨迹
					addBBInfoHistory(request,GUID,bbreason,typeid,bbstate);
					
					// 修改报备申请表状态
					BBApplyService bbs = new BBApplyService(conn);
					bbs.updateAuditProperty(GUID, "作废");
					
					out.print("true");   // 作废成功
				}else{
					out.print("false");  // 作废失败
				}
			}else{
				out.print("cannot");   //  超过时间限定当前人不能作废了
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
	 * 得到报备状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewState(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String GUID = StringUtil.showNull(request.getParameter("ctguid"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String state = StringUtil.showNull(cs.viewState(GUID));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(state.equals("作废")){
				out.print("true");
			}else{
				out.print("false");
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
	 * 报备查询
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(SEARCH);
		ASFuntion af = new ASFuntion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null; 
		String bbhm = request.getParameter("bbhm");
		String ywarea = request.getParameter("ywarea");
		System.out.println(this.getClass()+"  <>>>>>>>>>>>>>> bbhm="+bbhm+"     ywarea="+ywarea);
		ContentTable ct= new ContentTable();
		ct.setBbbh(bbhm);
		CompanyListTable clt= null;
		String count = "0";
		String date = af.getCurrentDate();
		String sql = "";
		try {
			String time = af.getDateAndTime1();
			conn = new DBConnect().getConnect();
			if(!"".equals(bbhm) && null!=bbhm){
				// 记录 报备查询 日志 bbl_log
				Web web = new Web();
				String ip = web.getIp(request);
				System.out.println(this.getClass()+"   ||  ip="+ip+"     time="+time+"   bbhm="+bbhm+"   ywarea="+ywarea);
				sql = "insert into l_bblog(datetimes,ip,bbbh) values(?,?,?)";
				new DbUtil(conn).executeUpdate(sql, new Object[]{time,ip,bbhm});
			}
			sql = " select svalue from s_config where sname='系统省注协' ";
			String sys_province_cicpa = new DbUtil(conn).queryForString(sql);
			model.addObject("sys_province_cicpa", sys_province_cicpa);
			
			 // 把 bb_content1 的字段 信息 存到 回家变量里面，兼容不是注协 使用的 报备字段
            sql = " select tableName,fieldName,fieldMean from s_meaning where tableName = 'bb_content1' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            Map map = new HashMap();
            while(rs.next()){
        		map.put(rs.getString("tableName").toLowerCase()+"_"+rs.getString("fieldName").toLowerCase(),rs.getString("fieldMean"));
            }
			
            model.addObject("map", map);
			
			if("".equals(ywarea) || ywarea==null){	// 没有业务所在地
				sql = " select count(*) from bb_content1 where bbbh = ? ";
				count = new DbUtil(conn).queryForString(sql, new Object[]{bbhm});
				System.out.println("没有业务所在地  count="+count+"   ywarea="+ywarea);
				if(Integer.parseInt(count)<1){		// 没有报备信息
					System.out.println("没有业务所在地  并且查询没有报备信息");
					model.addObject("search", "noInfo");
				}else if(Integer.parseInt(count)==1){	// 唯一报备信息
					ContentService cs = new ContentService(conn);
					ct = cs.getContentTableBybbbh(bbhm);
					if("暂存".equals(ct.getBbstate()) || "申请审核".equals(ct.getBbstate()) || "审核通过".equals(ct.getBbstate())
							|| "审核未通过".equals(ct.getBbstate()) || "初审通过".equals(ct.getBbstate()) ){
						System.out.println("  没有业务所在地  报备信息唯一   并且是暂存状态  ");
						model.addObject("search", "notValidState");
					}else{
						System.out.println("  没有业务所在地  报备信息唯一   正常记录  ");
						CompanyListService cls = new CompanyListService(conn);
						clt = cls.getCompanyListTable(ct.getCompanyGUID());
						
						
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
						System.out.println(ct.getWtxmlx());
						System.out.println(ct.getGuid());
						System.out.println(conn);
						
						// 根据报备类型查询报备属性
						Map map_field = getBbInfo(ct.getWtxmlx(),ct.getGuid(),conn);
						
						model.addObject("ct", ct);
						model.addObject("clt", clt);
						model.addObject("search", "ok");
						model.addObject("map_field", map_field);
					}
				}else{	// 报备信息重复  ， 让客户录入业务所在地
					System.out.println("  没有业务所在地  报备信息重复  ， 让客户录入业务所在地  ");
					model.addObject("search", "repeat");
				}
			}else{		// 有业务所在地
				sql = " select count(*) from bb_content1 where bbbh = ? and ywarea = ? ";
				count = new DbUtil(conn).queryForString(sql, new Object[]{bbhm,ywarea});
				System.out.println("有业务所在地  count="+count+"  ywarea="+ywarea);
				if(Integer.parseInt(count)<1){		// 没有报备信息
					System.out.println(" 有业务所在地  没有报备信息     count="+count+"   ywarea="+ywarea);
					model.addObject("search", "noInfo");
				}else if(Integer.parseInt(count)==1){	// 唯一报备信息
					System.out.println(" 有业务所在地  唯一报备信息     count="+count+"   ywarea="+ywarea);
					ContentService cs = new ContentService(conn);
					ct = cs.getContentTableBybbbhAndYwarea(bbhm,ywarea);
					if("暂存".equals(ct.getBbstate()) || "申请审核".equals(ct.getBbstate()) || "审核通过".equals(ct.getBbstate())
							|| "审核未通过".equals(ct.getBbstate()) || "初审通过".equals(ct.getBbstate()) ){
						System.out.println(" 有业务所在地  唯一报备信息     暂存   count="+count+"   ywarea="+ywarea);
						model.addObject("search", "notValidState");
					}else{
						System.out.println(" 有业务所在地  唯一报备信息     正常状态  记录   count="+count+"   ywarea="+ywarea);
						CompanyListService cls = new CompanyListService(conn);
						clt = cls.getCompanyListTable(ct.getCompanyGUID());
						
						// 根据报备类型查询报备属性
						Map map_field = getBbInfo(ct.getWtxmlx(),ct.getGuid(),conn);
						
						model.addObject("ct", ct);
						model.addObject("clt", clt);
						model.addObject("search", "ok");
						model.addObject("map_field", map_field);
					}
				}else{	// 报备信息重复  
					sql = " select count(*) from bb_content1 where bbbh = ? " 
						+ " and ywarea = ? and bbstate != '暂存' and bbstate != '申请审核' " 
						+ " and bbstate != '审核通过' and bbstate != '审核未通过' and bbstate != '初审通过'";
					count = new DbUtil(conn).queryForString(sql, new Object[]{bbhm,ywarea});
					System.out.println("有业务所在地  报备信息重复  count="+count+"  ywarea="+ywarea);
					if(Integer.parseInt(count)<1){	// 报备数据重复,但是状态都为 非报备完成或者作废状态的其他状态  就提示 无相关信息
						System.out.println("有业务所在地  报备信息重复 and bbstate != '暂存' 的情况   没有记录  count="+count+"  ywarea="+ywarea);
						model.addObject("search", "notValidState");
					}else if(Integer.parseInt(count)==1){	// 报备数据重复,但是只有一条状态为 报备完成或者作废状态的
						System.out.println("有业务所在地  报备信息重复 and bbstate != '暂存' 的情况   记录唯一  count="+count+"  ywarea="+ywarea);
						ContentService cs = new ContentService(conn);
						ct = cs.getContentTableBybbbhAndYwareaAndBbstate(bbhm,ywarea);
						CompanyListService cls = new CompanyListService(conn);
						clt = cls.getCompanyListTable(ct.getCompanyGUID());
						
						// 根据报备类型查询报备属性
						Map map_field = getBbInfo(ct.getWtxmlx(),ct.getGuid(),conn);
						
						model.addObject("ct", ct);
						model.addObject("clt", clt);
						model.addObject("search", "repeatOk");
						model.addObject("map_field", map_field);
						
					}else{	// 报备数据重复, 并且状态为 正常状态，  就显示 最近的那条报备数据
						System.out.println("有业务所在地  报备信息重复 and bbstate != '暂存' 的情况 多条记录 显示最近一条记录  count="+count+"  ywarea="+ywarea);
						ContentService cs = new ContentService(conn);
						ct = cs.getContentTableBybbbhAndYwareaAndBbstate(bbhm,ywarea);
						CompanyListService cls = new CompanyListService(conn);
						clt = cls.getCompanyListTable(ct.getCompanyGUID());
						
						// 根据报备类型查询报备属性
						Map map_field = getBbInfo(ct.getWtxmlx(),ct.getGuid(),conn);
						
						model.addObject("ct", ct);
						model.addObject("clt", clt);
						model.addObject("search", "repeatOk");
						model.addObject("map_field", map_field);
					}
					
				}
			}
			 
			model.addObject("count",count);
			model.addObject("time",time);
			model.addObject("ct",ct);
			//综合评分排名
			String ranking = new DbUtil(conn).queryForString("select ranking from k_company where loginid='"+ct.getBbperson()+"'");
			model.addObject("ranking",ranking);
			//事务所类型（事务所、评估所）
			String officeType = new DbUtil(conn).queryForString("select officeType from k_company where loginid='"+ct.getBbperson()+"'");
			model.addObject("officeType",officeType);
			
			
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
	 * 根据报备类型查询报备属性
	 * @param bbType
	 * @return
	 * @throws Exception 
	 */
	private Map getBbInfo(String bbType,String guid,Connection conn) throws Exception{
		// 报备类型
		String[] bbTypes = {
					"验资",
					"审计",
					"外汇年检",
					"所得税汇算清缴",
					"财产损失税前扣除鉴证",
					"清算审计",
					"分立审计",
					"合并审计",
					"其他涉税鉴证",
					"税务代理",
					"资产评估",
					"清产核资",
					"司法会计鉴定",
					"会计电算化",
					"会计咨询",
					"报备其他"};
		
		// 报备分类的金额验证字段：没标明字段的表示该分类报备只验证 注册资本/开办资金
		String [] fields = {
					"(yzbzje+yzswje+yztdsyje+yzqtwszcje+yzqtje) as yzje",
					"zcze,xssr,yysr,zxsjje",
					"jchj as zcze",
					"",
					"",
					"zcze,yysr",
					"zcze,xssr",
					"zcze,xssr",
					"",
					"",
					"",
					"zcze,xssr",
					"zcze,xssr",
					"",
					"",
					""};
		
		// 报备分类的调整后金额验证字段：没标明字段的表示该分类报备只验证 注册资本/开办资金
		String [] fields_tzh = {
					"(yzbzje+yzswje+yztdsyje+yzqtwszcje+yzqtje) as yzje",
					"zczetzh as zcze,xssrtzh as xssr,yysrtzh as yysr",
					"zczetzh as zcze",
					"",
					"",
					"zczetzh as zcze,xssrtzh as xssr",
					"zczetzh as zcze,xssrtzh as xssr",
					"zczetzh as zcze,xssrtzh as xssr",
					"",
					"",
					"",
					"zczetzh as zcze,xssrtzh as xssr",
					"zczetzh as zcze,xssrtzh as xssr",
					"",
					"",
					""};
		
		// 对应报备表
		String [] tableNames = {
					"bb_yzb",
					"bb_sjb",
					"bb_whnjb",
					"bb_sdshsqjb",
					"bb_ccsssqkcjjb",
					"bb_qsshb",
					"bb_flsjb",
					"bb_hbsjb",
					"bb_qtssjjb",
					"bb_swdlb",
					"bb_zcpgb",
					"bb_qchzb",
					"bb_sfkjjdb",
					"bb_kjdshb",
					"bb_kjzsb",
					"bb_bbqtb"};
		
		Map map = new HashMap();
		String tableName = "";
		String field = "";
		String field_tzh = "";
		
		for(int i=0;i<bbTypes.length;i++){
			if(bbTypes[i].equals(bbType)){
				field = fields[i];
				field_tzh = fields_tzh[i];
				tableName = tableNames[i];
				System.out.println("i="+i);
				break;
			}
		}
		
		if("验资".equals(bbType)){
			if(field!=null && !"".equals(field)){
				String sql = " select "+field+" from "+tableName+" where guid = '"+guid+"' ";
				ContentService cs = new ContentService(conn);
				map = cs.getMapInfoBySql(sql);
			}
		}else{
			if(field!=null && !"".equals(field)){
				// 该报备分类是否调整金额
				String sftzje_sql = " select sftzje from "+tableName+" where guid = '"+guid+"' ";
				String sftzjeValue = new DbUtil(conn).queryForString(sftzje_sql);
				if("是".equals(sftzjeValue)){
					// 获取调整后金额
					String sql = " select "+field_tzh+" from "+tableName+" where guid = '"+guid+"' ";
					ContentService cs = new ContentService(conn);
					map = cs.getMapInfoBySql(sql);
				}else{
					// 获取多年审计下的最后一年金额数
					if("审计".equals(bbType) || "清算审计".equals(bbType)){
						String sql = " select top 1 "+field+" from bb_sjmoney where bbguid='"+guid+"' order by cast(propertys as int) desc ";
						ContentService cs = new ContentService(conn);
						map = cs.getMapInfoBySql(sql);
						System.out.println("==============qwh:sql="+sql);
						if(map.size()<=0){
							sql = " select "+field+" from "+tableName+" where guid = '"+guid+"' ";
							System.out.println("==============qwh:sql="+sql);
							map = cs.getMapInfoBySql(sql);
						}
					}else{
						String sql = " select "+field+" from "+tableName+" where guid = '"+guid+"' ";												
						ContentService cs = new ContentService(conn);
						map = cs.getMapInfoBySql(sql);
					}
				}
			}else{
				String sql = " select zcze,xssr,yysr from bb_sjb where guid = '"+guid+"' ";
				System.out.println(sql+"**********************************");
				ContentService cs = new ContentService(conn);
				map = cs.getMapInfoBySql(sql);
			}
		}
		return map;
	}
	
	/**
	 * 报备查询
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView search2(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+  ">>>>>>>>>>>  addAndEdit() ......");
		ModelAndView model = new ModelAndView(SEARCH);
		ASFuntion af = new ASFuntion();
		Connection conn = null; 
		String bbhm = request.getParameter("bbhm");
		System.out.println(this.getClass()+"  <>>>>>>>>>>>>>> bbhm="+bbhm);
		ContentTable ct= null;
		CompanyListTable clt= null;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			CompanyListService cls = new CompanyListService(conn);
			 
			ct = cs.getContentTableBybbbh(bbhm);
			clt = cls.getCompanyListTable(ct.getCompanyGUID());
			model.addObject("ct", ct);
			model.addObject("clt", clt);
			String sql = "";
			
			String time = af.getDateAndTime1();
			if(!"".equals(bbhm) && null!=bbhm){
				// 记录 报备查询 日志 bbl_log
				Web web = new Web();
				String ip = web.getIp(request);
				sql = "insert into l_bblog(datetimes,ip,bbbh) values(?,?,?)";
				new DbUtil(conn).execute(sql, new Object[]{time,ip,bbhm});
			}
			
			if("".equalsIgnoreCase(ct.getGuid()) || ct.getGuid()==null){
				model.addObject("search", "search");
			}else{
				model.addObject("search", "s");
			}
			model.addObject("time",time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 得到报备状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewIsReviewed(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String GUID = request.getParameter("ctguid");
		System.out.println(this.getClass()+"     GUID = "+GUID);
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String isReviewed = cs.viewIsReviewed(GUID);
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> isReviewed = "+isReviewed);
			if("是".equals(isReviewed)){
				out.print("true");
			}else{
				out.print("false");
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
	 * 得到时间
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getTimes(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		PrintWriter out = null ;
		try {
			
			conn = new DBConnect().getConnect();
			Web web = new Web();
			DbUtil dt = new DbUtil(conn);
			ASFuntion af = new ASFuntion();
			String ip = web.getIp(request);
			response.setContentType("text/html;charset=UTF-8");
			// 找出 上次 报备查询 记录日志的时间
			String sql = "select top 1 datetimes from l_bblog where ip = ? order by datetimes desc ";
			String oldtime = dt.queryForString(sql, new Object[]{ip});
			System.out.println(this.getClass()+"　　　｜　　ip="+ip+" | oldtime="+oldtime);
			out = response.getWriter() ;
			if(oldtime==null || "".equals(oldtime)){
				out.print(61000);
			}else{
				String nowtime = af.getDateAndTime1();
				
				// 得到 秒数
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Date ot = formatter.parse(oldtime);
				Date nt = formatter.parse(nowtime);
				int result = (int)(nt.getTime() - ot.getTime());
	
				out.print(result);
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
	 * 作废
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getDays(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String GUID = request.getParameter("ctguid");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			// 判断报备时间
			String temp = "";
			String bbtime = cs.getBBTime(GUID);
			
			String now = new ASFuntion().getDateAndTime();
			
			// 得到报备时间下一个月的这个时间与当前时间比较
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 格式化对象
			Calendar calendar = Calendar.getInstance();// 日历对象
			if(bbtime==null || "".equals((bbtime))){
				bbtime = "2011-01-01 01:01";
			}
			
			if(bbtime!=null && !"".equals((bbtime))){
				if(bbtime.length()<16 && bbtime.length()>=10){
					bbtime = bbtime.substring(0, 10)+" 01:01";
				}else{
					bbtime = bbtime.substring(0, bbtime.length())+" 01:01";
				}
			}
			calendar.setTime(sdf.parse(bbtime));// 设置报备日期
			calendar.add(Calendar.MONTH, 1);// 月份加一
			temp=sdf.format(calendar.getTime());
			
			DateUtil dateutile = new DateUtil();
			int days = dateutile.equalDate(temp, now);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+" >>>>>>>>>>>>>>>>>>>>>>>>  bbtime = "+bbtime+"        now = "+now+"  days="+days+"    guid="+GUID);
			
			if(days<=0){
				out.print("yes");
			}else{
				out.print("cannot");   //  超过时间限定只能修改已收业务费用
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
	 * 报备 打印 处的 事务所链接
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goCompanyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/addAndEdit1.jsp");
		Connection conn=null;
		ASFuntion af=new ASFuntion();
		try {
			String users = af.showNull(request.getParameter("id"));
			String tabname = af.showNull(request.getParameter("name"));
			String loginid = getLoginid(tabname,users);
			
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			
			
			String baobei = af.showNull(request.getParameter("baobei"));

			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoName = af.showNull((String)userMap.get("userphotoname"));
			
			String userPhotoSrc = userPhotoSrc = "/common/attachFile/K_Company/" + loginid;
			if(userPhotoName == null || "".equals(userPhotoName)){	
				//没有图片
				userPhotoSrc = "/images/comp.png";
			}
			
			String cpaCount = new DbUtil(conn).queryForString(" select count(*) from K_Micfo Where State = ? and OfficeCode = ?",new Object[]{"0",loginid});
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			modelAndView.addObject("types",baobei);
			modelAndView.addObject("cpaCount",cpaCount);		
			
			// 惩戒
			punish(request,response,modelAndView,loginid,tabname);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
	
	/**
	 * 报备 打印 处的 注册会计师所链接
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView micfoBaoBei(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/add1.jsp");
		Connection conn=null;
		ASFuntion CHF=new ASFuntion();
		try {
			// 如果从报备 过来就 只能看 个人资料信息不能修改
			String baobei = CHF.showNull(request.getParameter("baobei"));	
			String loginid = CHF.showNull(request.getParameter("id"));
			String tabname = CHF.showNull(request.getParameter("name"));	
			String opt = CHF.showNull(request.getParameter("opt"));
			
			System.out.println("==============="+loginid+"========="+tabname+"-------"+opt);
			System.out.println(this.getClass()+"    tabname="+tabname+"     loginid="+loginid);
			
			conn  = new DBConnect().getConnect();
			UserService user = new UserService(conn);
			Map userMap = user.getUser( tabname, loginid);
			
			System.out.println("==============="+userMap);
			
			if("k_assesser".equalsIgnoreCase(tabname)){
				tabname = "K_Assesser";
			}else{
				tabname = "K_Micfo";
			}
			String userPhotoSrc = "";
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("\\common\\attachFile\\"+tabname) ;
			String fileTempName = loginid ; 
			userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
			userMap.put("lastmodified", CHF.getCurrentDate());
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			modelAndView.addObject("types",baobei);
			modelAndView.addObject("opt",opt);
			modelAndView.addObject("tablename","K_Assesser");
			
			// 惩戒
			punish(request,response,modelAndView,loginid,tabname);
			
			System.out.println("==============="+userMap);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}
	
	
	/**
	 * 非执业 用户公众查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView gomicfono(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/micfonoAddAndEdit.jsp");
		Connection conn=null;
		ASFuntion af = new ASFuntion();
		try {
			// 如果从报备 过来就 只能看 个人资料信息不能修改
			String users = af.showNull(request.getParameter("id"));
			String tabname = af.showNull(request.getParameter("name"));	
			String loginid = this.getLoginid(tabname,users);
			conn  = new DBConnect().getConnect();
			
			UserService user = new UserService(conn);
			Map userMap = user.getUser( tabname, loginid);
			
			String userPhotoSrc = "";
			Foder foder  = new Foder("",request);
			String newPath = foder.createFoder("\\common\\attachFile\\K_MicfoNo") ;
			String fileTempName = loginid ; 
			userPhotoSrc = user.getPhoto(tabname, loginid, newPath,fileTempName);
			
			userMap.put("lastmodified", af.getCurrentDate());
			
			modelAndView.addObject("userPhotoSrc",userPhotoSrc);
			modelAndView.addObject("userMap",userMap);
			
			// 惩戒
			punish(request,response,modelAndView,loginid,tabname);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
	}

	/**
	 * 是否存在该用户
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ASFuntion af = new ASFuntion();
		String user = af.showNull(request.getParameter("id"));
		String table = af.showNull(request.getParameter("name"));
		PrintWriter out = null ;
		try {
			String rs = this.getLoginid(table,user);
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("Y");
			}else{
				out.print("N");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
		return null;
	}
	
	private String getLoginid(String ctypetabname,String user){
		String loginId = "";
		Connection conn = null;

		try {
			conn = new DBConnect().getConnect();
			String sql = " select loginid from k_user where ctypetabname=? and (loginid=? or loginname=?) ";
			Object[] obj = new Object[]{ctypetabname,user,user};
			if("k_micfo".equalsIgnoreCase(ctypetabname) || "k_micfono".equalsIgnoreCase(ctypetabname)){
				sql = " select loginid from "+ctypetabname+" where ctypetabname=? and (loginid=? or loginname=? or idnumber=?) ";
				obj = new Object[]{ctypetabname,user,user,user};
			}
			loginId = StringUtil.showNull(new DbUtil(conn).queryForString(sql,obj));
			System.out.println("ctypetabname="+ctypetabname+"||user="+user+"||loginid="+loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return loginId;
		
	}
	
	public void punish(HttpServletRequest request, HttpServletResponse response,ModelAndView model,String loginid,String userType){
		ASFuntion af = new ASFuntion();
		Connection conn=null;
		String date = af.getCurrentDate();
		try {
			conn = new DBConnect().getConnect();
			// 事务所是否有过惩戒信息
			String sqlCount = " select max(id) from K_SupPunish " 
							+ " where '"+date+"' <= validdate and state='领导审核' and loginId = '"+loginid+"' and opentype='公众' " ;
			
			String rs = af.showNull(new DbUtil(conn).queryForString(sqlCount));
			
			if(!"".equals(rs)){
				/**
				 * 公众网站查询：
					1.判断条件按照：是否该用户编号，是否领导审核，当前时间是否在有效公开期限
					2.显示列表：惩戒日期、惩戒类型、惩戒机构
				 */
				
				String sql = " select customer,punishType,punishDate from K_SupPunish " 
						   + " where '"+date+"' <= validdate and state='领导审核' and loginId = '"+loginid+"' " 
						   + " and opentype='公众'  ";
				
				
				
				DataGridProperty pp = new DataGridProperty();
				
				pp.setTitle("事务所惩戒信息");
				
				pp.setTableID("punishList");
		
				pp.addColumn("惩戒机构", "customer","showCenter");
				pp.addColumn("惩戒类型", "punishType","showCenter");
				pp.addColumn("惩戒日期", "punishDate","showCenter");
				
				
				pp.setSQL(sql);
				pp.setPageSize_CH("10");
				pp.setOrderBy_CH("punishDate");
				pp.setDirection("desc");
				request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
				
				model.addObject("ispunish", "Y");
			}else{
				model.addObject("ispunish", "N");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}
	
	/**
	 * 根据报备编号得到报备状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getStateByBbbh(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String bbbh = StringUtil.showNull(request.getParameter("bbbh"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String state = StringUtil.showNull(cs.getStateByBbbh(bbbh));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> bbbh = "+bbbh);
			if(state.equals("作废")){
				out.print("zuofei");
			}else if(state.equals("暂存")){
				out.print("zancun");
			}else if(state.equals("报备完成")){
				out.print("wanch");
			}else if(state.equals("申请审核")){
				out.print("sqsh");
			}else if(state.equals("审核通过")){
				out.print("shtg");
			}else if(state.equals("审核未通过")){
				out.print("shwtg");
			}else if(state.equals("初审通过")){
				out.print("cstg");
			}else if(state.equals("待审申请审核")){
				out.print("dssqsh");
			}else if(state.equals("待审报备完成")){
				out.print("dsbbwc");
			}else if(state.equals("初次报备")){
				out.print("ccbb");
			}else{
				out.print("zancun");
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
	 * 根据 guid 得到报备状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getStateByGuid(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String guid = StringUtil.showNull(request.getParameter("ctguid"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			ContentService cs = new ContentService(conn);
			String state = StringUtil.showNull(cs.getStateByGuid(guid));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			System.out.println(this.getClass()+"  >>>>>>> ctguid = "+guid);
			if(state.equals("作废")){
				out.print("zuofei");
			}else if(state.equals("暂存")){
				out.print("zancun");
			}else if(state.equals("报备完成")){
				out.print("wanch");
			}else if(state.equals("申请审核")){
				out.print("sqsh");
			}else if(state.equals("审核通过")){
				out.print("shtg");
			}else if(state.equals("审核未通过")){
				out.print("shwtg");
			}else if(state.equals("初审通过")){
				out.print("cstg");
			}else if(state.equals("待审申请审核")){
				out.print("dssqsh");
			}else if(state.equals("待审报备完成")){
				out.print("dsbbwc");
			}else if(state.equals("初次报备")){
				out.print("ccbb");
			}else{
				out.print("zancun"); 
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
	 * 得到客户信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getInfoByWtdwmc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String wtdwmc = "";
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		PrintWriter out  = response.getWriter() ;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map userMap = userSession.getUserMap();
			String loginid = (String)userMap.get("loginid");
			conn = new DBConnect().getConnect();
			wtdwmc = CHF.showNull(request.getParameter("wtdwmc")) ;
			
			
			sql = " select * from bb_content1 where wtdwmc = ? and bbperson = ? order by bbtime desc";
			System.out.println(this.getClass()+"     wtdwmc="+wtdwmc+" loginid="+loginid+"  sql="+sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, wtdwmc);
			ps.setString(2, loginid);
			
			rs = ps.executeQuery();
			Map<String, String> map = new HashMap<String, String>();

			//被审(验)单位名称
			String bsdwmc = "";
			//客户出资类型
			String khczlx = "";
			//营业执照号码或核准通知书号
			String yyzzhm = "";
			//客户经济性质
			String khjjxj = "";
			//被审(验)单位注册资本/开办资金
			String bsdwzczb = "";
			//币种
			String zczbbz = "";
			//客户行业类型
			String kmhylx = "";
			//是否上市企业
			String sfssqy = "";
			//注册地址
			String zcdz = "";
			//负责人姓名
			String fzrmc = "";
			//项目客户类型
			String xmkhlx = "";
			//联系人姓名
			String lxrxm = "";
			//联系人电话
			String lxrdh = "";
			
			if (rs.next()) {
				bsdwmc = rs.getString("bsdwmc");
				khczlx = rs.getString("khczlx");
				yyzzhm = rs.getString("yyzzhm");
				
				khjjxj = rs.getString("khjjxj");
				bsdwzczb = rs.getString("bsdwzczb");
				zczbbz = rs.getString("zczbbz");
				
				kmhylx = rs.getString("kmhylx");
				sfssqy = rs.getString("sfssqy");
				zcdz = rs.getString("zcdz");
				
				fzrmc = rs.getString("fzrmc");
				xmkhlx = rs.getString("xmkhlx");
				lxrxm = rs.getString("lxrxm");
				
				lxrdh = rs.getString("lxrdh");
			}
			map.put("bsdwmc", CHF.showNull(bsdwmc));
			map.put("khczlx", CHF.showNull(khczlx));
			map.put("yyzzhm", CHF.showNull(yyzzhm));
			
			map.put("khjjxj", CHF.showNull(khjjxj));
			map.put("bsdwzczb", CHF.showNull(bsdwzczb));
			map.put("zczbbz", CHF.showNull(zczbbz));
			
			map.put("kmhylx", CHF.showNull(kmhylx));
			map.put("sfssqy", CHF.showNull(sfssqy));
			map.put("zcdz", CHF.showNull(zcdz));
			
			map.put("fzrmc", CHF.showNull(fzrmc));
			map.put("xmkhlx", CHF.showNull(xmkhlx));
			map.put("lxrxm", CHF.showNull(lxrxm));
			map.put("lxrdh", CHF.showNull(lxrdh));
			System.out.println(this.getClass()+"    bsdwmc="+bsdwmc+"   khczlx="+khczlx);
			String json = JSONArray.fromObject(map).toString();
			out.write(json) ;
			out.close() ;
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
	 * 查看报告文号是否重复
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView seeBgwh(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		Connection conn = null;

		String loginid = request.getParameter("loginid");
		String typeid = request.getParameter("typeid");
		String bgwh = request.getParameter("bgwh");
		// bgwh = new String(request.getParameter("bgwh").getBytes("iso8859-1"), "gbk");
		
		System.out.println("seeBgwh      loginid="+loginid+"       typeid="+typeid+"      bgwh="+bgwh);
		
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			out = response.getWriter() ;
			String p = new DbUtil(conn).queryForString("select status from k_bgwhExcePect where loginid = ?", new Object[]{loginid});
			
			if("Y".equalsIgnoreCase(p)){
				out.print("Y");
			}else{
				//String sql = "select bgwh from bb_content1 where bbperson = ? and typeid = ? and bgwh = ? and bbstate !=? ";
				// 报备事务所内的报告文号不能为空
				String sql = "select bgwh from bb_content1 where bbperson = ? and bgwh = ? and bbstate !=? ";
				String value = new DbUtil(conn).queryForString(sql, new Object[]{loginid,bgwh,"作废"});
				
				if(!"".equals(value) && value!=null ){
					// out.print("N");
					// 具体到事务所下的报备分类 报告文号不能重复
					// sql = "select xmmc,bbtime,bgwh,bbbh from bb_content1 where bbperson = ? and typeid = ? and bgwh = ? and bbstate !=? ";
					// 具体到事务所 报告文号不能重复
					sql = "select xmmc,bbtime,bgwh,bbbh from bb_content1 where bbperson = ? and bgwh = ? and bbstate !=? ";
					PreparedStatement ps = null;
					ResultSet rs = null;
					try{
						ps = conn.prepareStatement(sql);
						ps.setString(1, loginid);
						// ps.setString(2, typeid);
						ps.setString(2, bgwh);
						ps.setString(3, "作废");
						rs = ps.executeQuery();
						if (rs.next()) {
							value = rs.getString("xmmc");
							value = value +",#$"+rs.getString("bbtime");
							value = value +",#$"+rs.getString("bgwh");
							value = value +",#$"+rs.getString("bbbh");
						}
						System.out.println(this.getClass()+"     $$$$$$$$$: seeBgwh ......value="+value);
						out.print(value);
					}catch(SQLException e){
						System.out.println(this.getClass()+"  执行sql出错 sql="+sql+"  /n"+e.getMessage());
						e.printStackTrace();
					}finally{
						DbUtil.close(rs);
						DbUtil.close(ps);
					}
				}else{
					out.print("Y");
				}
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
	 * 查看报告文号是否重复    修改操作
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView seeBgwhUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		Connection conn = null;

		String loginid = request.getParameter("loginid");
		String typeid = request.getParameter("typeid");
		String bgwh = request.getParameter("bgwh");
		// bgwh = new String(request.getParameter("bgwh").getBytes("iso8859-1"), "utf-8");
		String guid = request.getParameter("guid");
		System.out.println("seeBgwh      loginid="+loginid+"       typeid="+typeid+"      bgwh="+bgwh+"   guid="+guid);
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			out = response.getWriter() ;
			String p = new DbUtil(conn).queryForString("select status from k_bgwhExcePect where loginid = ?", new Object[]{loginid});
			
			if("Y".equalsIgnoreCase(p)){
				out.print("Y");
			}else{
				//String sql = "select bgwh from bb_content1 where bbperson = ? and typeid = ? and bgwh = ? and bbstate !=? and guid!=? ";
				
				// 具体到事务所 报告文号不能重复
				String sql = "select bgwh from bb_content1 where bbperson = ? and bgwh = ? and bbstate !=? and guid!=? ";
				String value = new DbUtil(conn).queryForString(sql, new Object[]{loginid,bgwh,"作废",guid});
				
				if(!"".equals(value) && value!=null ){
					// 具体到事务所下的报备分类 报告文号不能重复
					// sql = "select xmmc,bbtime,bgwh,bbbh from bb_content1 where bbperson = ? and typeid = ? and bgwh = ? and bbstate !=? and guid!=?  ";
					
					// 具体到事务所 报告文号不能重复
					sql = "select xmmc,bbtime,bgwh,bbbh from bb_content1 where bbperson = ? and bgwh = ? and bbstate !=? and guid!=?  ";
					
					PreparedStatement ps = null;
					ResultSet rs = null;
					try{
						ps = conn.prepareStatement(sql);
						ps.setString(1, loginid);
						//ps.setString(2, typeid);
						ps.setString(2, bgwh);
						ps.setString(3, "作废");
						ps.setString(4, guid);
						rs = ps.executeQuery();
						if (rs.next()) {
							value = rs.getString("xmmc");
							value = value +",#$"+rs.getString("bbtime");
							value = value +",#$"+rs.getString("bgwh");
							value = value +",#$"+rs.getString("bbbh");
						}
						System.out.println(this.getClass()+"     $$$$$$$$$: seeBgwhUpdate ......value="+value);
						out.print(value);
					}catch(SQLException e){
						System.out.println(this.getClass()+"  执行sql出错 sql="+sql+"  /n"+e.getMessage());
						e.printStackTrace();
					}finally{
						DbUtil.close(rs);
						DbUtil.close(ps);
					}
				}else{
					out.print("Y");
				}
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
	 * 记录 报备 数据 修改 轨迹
	 * @param request
	 * @param beforeBBMap
	 * @param ctguid
	 * @param tabTypeName
	 * 
	 */  
	public void addBBInfoHistory(HttpServletRequest request,String bbid,String bbreason,String typeid,String bbstate){
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String loginname = (String)map.get("loginname");
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		 
		try{
			conn = new DBConnect().getConnect();
			
			ContentService cs = new ContentService(conn);
			
			DbUtil db = new DbUtil(conn);
			String sql = "select typeName from bb_type where guid = '"+typeid+"' ";
			String bbType = db.queryForString(sql);
			
			Map bbInfoMap = new HashMap();
			
			bbInfoMap.put("bbid", bbid);
			bbInfoMap.put("bbtype", bbType);
			bbInfoMap.put("changetime", new ASFuntion().getDateAndTime1());
			bbInfoMap.put("changereason", bbreason);
			bbInfoMap.put("loginid", loginid);
			bbInfoMap.put("loginname", loginname);
			String id = UUID.randomUUID().toString();
	    	bbInfoMap.put("id", id);
	    	  
	    	bbInfoMap.put("beforevalue", bbstate);
	    	bbInfoMap.put("nowvalue", "作废");
	    	bbInfoMap.put("changefield", "报备状态");
			// 保存 修改 报备数据 痕迹
	    	cs.addBBInfoHistory(bbInfoMap);
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	/**
	 * 得到 事务所 是否可以进行报备
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getCompanyCanReport(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String loginid = StringUtil.showNull(request.getParameter("loginid"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(" select CanReport from k_company where loginid = ? ",new Object[]{loginid}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"禁止".equals(rs)){
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
	
	/**
	 * 该 事务所已报备的验资报备份数
	 * 该事务所当年的报备份数 验资 分类不能超过150*注师个数 份
	 * 验资分类的总和不能超过150*注师个数 份
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getCPAYZReportCount(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;

		String officeCode = StringUtil.showNull(request.getParameter("officeCode"));
		ASFuntion af = new ASFuntion();
		String year = af.getCurrentDate().substring(0,4);
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			// 验资 分类不能超过150 份
			String sql = " select count(bbbh) from bb_content1 "
					   + " where bbperson = ? and typeid = ? and substring(bgrq,1,4) = ? and bbstate=? ";  
			
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{officeCode,"yz001",year,"报备完成"}));
			
			if("".equals(rs)){
				rs = "0";
			}
			int totalReport = Integer.parseInt(rs);

			// 申请的 报备份数
			sql = " select YZNum from BB_CompanyReportCount where CompanyID = ? and BB_Year = ? ";
			String rs2 = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{officeCode,year}));
			if("".equals(rs2)){
				rs2 = "0";
			}
			
			//验资限制数量
			sql = "select count from BB_LimitQuantity where type='YZ'";
			int count = "".equals(StringUtil.showNull(new DbUtil(conn).queryForString(sql))) ? 0 : Integer.parseInt(StringUtil.showNull(new DbUtil(conn).queryForString(sql)));
			int validReport = Integer.parseInt(rs2) + count*getCompanyCpa(officeCode);
			
			if(totalReport>=validReport){
				out.print("N");
			}else{
				out.print("Y");
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
	 * 该 事务所已报备的验资报备份数
	 * 该事务所当年的报备份数 验资 分类不能超过150*注师个数 份
	 * 其他分类的总和不能超过150*注师个数 份
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView getCPAFYZReportCount(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
 
		String officeCode = StringUtil.showNull(request.getParameter("officeCode"));
		ASFuntion af = new ASFuntion();
		String year = af.getCurrentDate().substring(0,4);
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			// 非验资的其他分类的总和不能超过150
			String sql = " select count(bbbh) from bb_content1 "
					   + " where bbperson = ? and typeid != ? and substring(bgrq,1,4) = ? and bbstate=? ";
			
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{officeCode,"yz001",year,"报备完成"}));
			
			if("".equals(rs)){
				rs = "0";
			}
			int totalReport = Integer.parseInt(rs);
			
			// 申请的 报备份数
			sql = " select NoYZNum from BB_CompanyReportCount where CompanyID = ? and BB_Year = ? ";
			String rs2 = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{officeCode,year}));
			if("".equals(rs2)){
				rs2 = "0";
			}
			
			//非验资限制数量
			sql = "select count from BB_LimitQuantity where type='NOYZ'";
			int count = "".equals(StringUtil.showNull(new DbUtil(conn).queryForString(sql))) ? 0 : Integer.parseInt(StringUtil.showNull(new DbUtil(conn).queryForString(sql)));
			int validReport = Integer.parseInt(rs2) + count*getCompanyCpa(officeCode);
			
			if(totalReport>=validReport){
				out.print("N");
			}else{
				out.print("Y");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	// 得到注师数
	public int getCompanyCpa(String officeCode){
		Connection conn = null;
		int cpaCount = 0;
		String sql = " select count(loginname) from k_micfo where officecode = ? and state='0' ";
		try {
			conn = new DBConnect().getConnect();
			String rs = new DbUtil(conn).queryForString(sql, new Object[]{officeCode});
			if(rs!=null && !"".equals(rs)){
				cpaCount = Integer.parseInt(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return cpaCount;
	}
	
	
	/**
	 * 检查上一年是否不存在的老客户
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView sflkh(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginId = map.get("loginid")+"";
		String year = (Integer.parseInt(af.getCurrentDate().substring(0,4))-1)+"";
		String typeId = request.getParameter("typeId");
		String bsdwmc = request.getParameter("bsdwmc");
		
		
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select guid from bb_content1 where bsdwmc = ? and bbperson = ? " 
					   + " and typeid = ? and substring(bgrq,1,4) = ? and bbstate='报备完成' ";
			String guid = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{bsdwmc,loginId,typeId,year}));
			
			System.out.println("检查上一年是否不存在的老客户  sflkh()方法 .. typeId="+typeId+"||bsdwmc="+bsdwmc+"||guid="+guid);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			
			if("".equals(guid)){
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
		
	/**
	 * 新规则（2013-06-13修改）;
	 * 接下家和客户类型的规则：
	 * 1.审计类型：年报审计
	 * 2.以报备时间来作审定时间
	 * 3.参照判断的老客户必须是当前报备的报备时间的上一年
	 * 4.按照同一被审验单位的是否同一个事务所来判断，注意以前的判断还兼容只要其中同一被审验单位的是否同一个注师来判断，现在要去掉这个注师判断 
	 * 5.要是不是要判断的类型“审计-年报审计”，值为空白（0为否，1为是，2为空白）
	 * 6.新客户的是否接下家为否	
	 * 
	 * （旧规则）	
	 * （是否接下家：同一种报备类型、同一家被审验单位、不同事务所、不同注师、报告日期是当前年的上一年）
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView checkTookHome(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8") ;
		ASFuntion af = new ASFuntion();
		String year = af.getCurrentDate().substring(0,4);
		year = (Integer.parseInt(year)-1)+"";
		Connection conn = null;

		String bsdwmc = StringUtil.showNull(request.getParameter("bsdwmc")).replaceAll("\\s*", "");
		String loginid = StringUtil.showNull(request.getParameter("loginid"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select c.guid from bb_content1 c,bb_sjb s where c.guid=s.guid and s.sjlx='年报审计' and c.bbstate='报备完成' and c.typeid='sj001' and bsdwmc=? and c.bbperson<>? and substring(c.bbtime,1,4)=? ";
			System.out.println("SQL1 : "+sql);
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{bsdwmc,loginid,year}));
			
			sql = " select c.guid from bb_content1 c,bb_sjb s where c.guid=s.guid and s.sjlx='年报审计' and c.bbstate='报备完成' and c.typeid='sj001' and bsdwmc=? and c.bbperson=? and substring(c.bbtime,1,4)=? ";
			System.out.println("SQL2 : "+sql);			
			String rs2 = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{bsdwmc,loginid,year}));
			
			out = response.getWriter() ;
			if("".equals(rs2) && !"".equals(rs)){
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
	
	
	/**
	 * 报备公共查询联动：奖惩经历
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView punishList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(PUNISHLIST);
		ASFuntion af = new ASFuntion();
		String date = af.getCurrentDate();
		String userId = request.getParameter("userId");
		Connection conn = null;
		try {
			String sql = " select customer,punishType,punishDate from K_SupPunish " 
					+ " where '"+date+"' <= validdate and state='领导审核' and loginId = ? " 
					+ " and ( punishType='通报批评' or punishType='公开谴责' ) ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("奖惩信息");
			
			pp.setTableID("punishList");

			pp.addColumn("惩戒机构", "customer","showCenter");
			pp.addColumn("惩戒类型", "punishType","showCenter");
			pp.addColumn("惩戒日期", "punishDate","showCenter");
			
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("punishDate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}

	

	/**
	 * 报备选审计，审计类型选年报审计，被审验单位一样，同一年的报备时间，事务所不一样时，
	 * 申请审核或报备完成时不给通过，提示“该企业本年度已出具年度审计报告。”
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkNbsjReport(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = af.showNull(map.get("loginid")+"");
		Connection conn = null;
		String bsdwmcValue = af.showNull(request.getParameter("bsdwmcValue"));
		String year = af.getCurrentDate().substring(0,4);
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select a.guid from bb_content1 a inner join bb_sjb b on a.guid=b.guid where bsdwmc=? " 
					   + " and subString(bbtime,1,4)='"+year+"' and bbperson <> '"+loginid+"' "
					   + " and (b.sjlx='年报审计' or b.sjlx='中央企业集团年报审计' or b.sjlx='上市公司年报审计') ";
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{bsdwmcValue}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
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
	
	

	/**
	 * 检查项目客户类型
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkKhlx(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String bsdwmcValue = af.showNull(request.getParameter("bsdwmcValue"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select guid from bb_content1 where bbstate=? and bsdwmc = ? ";
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{"报备完成",bsdwmcValue}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("Y");//非新客户
			}else{
				out.print("N");//新客户
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
	 * 得到上一个已收业务费
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getLastYsywf(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String bsdwmcValue = af.showNull(request.getParameter("bsdwmcValue"));
		String typeid = af.showNull(request.getParameter("typeid"));
		//年报审计
		String isNbsj = af.showNull(request.getParameter("isNbsj"));
		
		PrintWriter out = null ;
		response.setContentType("text/html;charset=UTF-8") ;
		
		try {
			out = response.getWriter() ;
			
			conn = new DBConnect().getConnect();
			
			String sql = " select a.ysywf from bb_content1 a,bb_sjb b where a.bbstate=? and a.bsdwmc = ? and a.typeid=? \n"
						+" and a.guid=b.guid and b.sjlx like '%年报%' \n"
						+" order by a.bgrq desc";
			
			//如果是年报审计则使用以下SQL
			if("isNbsj".equals(isNbsj)){
				sql = " select a.ysywf from bb_content1 a,bb_sjb b where a.bbstate=? and a.bsdwmc = ? and a.typeid=? \n"
					+" and a.guid=b.guid and b.sjlx like '%年报%' \n"
					+" order by a.bbtime desc";
			}
			
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{"报备完成",bsdwmcValue,typeid}));
			
			if(!"".equals(rs)){
				out.print(rs);
			}else{
				out.print("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("0");
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null; 
	}
	//获取老客户业务费
	public ModelAndView getLkhYwf(HttpServletRequest request,HttpServletResponse response) {
		
		ASFuntion af = new ASFuntion();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = af.showNull(map.get("loginid")+"");
		Connection conn = null;
		String bsdwmcValue = af.showNull(request.getParameter("bsdwmcValue")).replaceAll("\\s*", "");
		String typeid = af.showNull(request.getParameter("typeid"));
		String year = af.showNull(request.getParameter("year"));
		
		System.out.println(bsdwmcValue+"--+++--"+typeid+"--+++--"+year);
		
		PrintWriter out = null ;
		response.setContentType("text/html;charset=UTF-8") ;
		 
		try {
			out = response.getWriter() ;
			conn = new DBConnect().getConnect();
			
			String oldLoginId = StringUtil.showNull(new DbUtil(conn).queryForString("select oldloginid from K_Company where loginid=?",new Object[]{loginid}));
			String sql = null;
			if(!"".equals(oldLoginId)){//兼容改制后的数据    (2013年05月08日改为除'经济责任审计'和'专项审计'之外都认老客户)
				sql = "select a.ysywf from bb_content1 a,bb_sjb b where a.bbstate='报备完成' and typeid=? " +
						"and a.bsdwmc =? and substring(a.bbtime,1,4)=? and a.guid=b.guid and b.sjlx<>'经济责任审计' and b.sjlx<>'专项审计' and b.sjlx<>'' and b.sjlx is not null and a.bbperson in('"+loginid+"','"+oldLoginId+"') order by bbtime desc";
				System.out.println("SQL3 : "+sql);
			}else{
				sql = "select a.ysywf from bb_content1 a,bb_sjb b where a.bbstate='报备完成' and typeid=? " +
						"and a.bsdwmc =? and substring(a.bbtime,1,4)=? and a.guid=b.guid and b.sjlx<>'经济责任审计' and b.sjlx<>'专项审计' and b.sjlx<>'' and b.sjlx is not null and a.bbperson='"+loginid+"' order by bbtime desc";
				System.out.println("SQL4 : "+sql);
			}
			System.out.println(sql);
			String rs = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{typeid,bsdwmcValue,year}));
			
			if(!"".equals(rs)){
				out.write("YES|"+rs);
			}else{   
				out.write("NO");  
			} 
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(out!=null)out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	//检查能否自动报备
	public ModelAndView isAuto(HttpServletRequest request,HttpServletResponse response){
		
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String loginid = af.showNull(request.getParameter("loginid"));
		System.out.println(loginid+"--+++--"+loginid+"--+++--"+loginid);
		
		PrintWriter out = null ;
		response.setContentType("text/html;charset=UTF-8") ;
		 
		try {
			out = response.getWriter() ;
			conn = new DBConnect().getConnect();
			String sql = "select isAuto from k_company where loginid=?";
			String isAuto = af.showNull(new DbUtil(conn).queryForString(sql,new Object[]{loginid}));
			System.out.println("isAuto : "+isAuto);
			out.write(isAuto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){out.close();}
			DbUtil.close(conn);
		}
		return null;
	}
	
	//计算收费标准(调用存储过程)
	public synchronized ModelAndView getChargeStandard(HttpServletRequest request,HttpServletResponse response){
		Connection conn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		PrintWriter out = null;
		try {				
			request.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			conn = new DBConnect().getConnect();

			String type = StringUtil.showNull(request.getParameter("type"));
//			double zcze = Double.parseDouble(StringUtil.showNull(request.getParameter("zcze")));
			String zcze = StringUtil.showNull(request.getParameter("zcze"));
			int kind = Integer.parseInt(StringUtil.showNull(request.getParameter("kind")));
			int year = Integer.parseInt(StringUtil.showNull(request.getParameter("year")));
			int hour = Integer.parseInt(StringUtil.showNull(request.getParameter("hour")));
			System.out.println(type + " : "+ zcze + " : " + kind + " : " + year + " : " + hour);
			
			cStmt = conn.prepareCall("{call SP_CalcChargePrice(?,?,?,?,?) }"); 
			cStmt.setString(1, type);
			cStmt.setString(2, zcze);
			cStmt.setInt(3, kind);
			cStmt.setInt(4, year);
			cStmt.setInt(5, hour);
			
			rs = cStmt.executeQuery();
			double sum = 0.0;//已打折
			double price = 0.0;//未打折
			while(rs.next()){
				sum += rs.getDouble("Result");
				price += rs.getDouble("price");
			}
			//不以科学记数法显示
			NumberFormat nf = NumberFormat.getInstance();
			nf.setGroupingUsed(false);
			Map<String,String> map = new HashMap<String,String>();
			map.put("discount", nf.format(sum));//打折
			map.put("standardPrice", nf.format(price));//标准价
			JSONObject json = JSONObject.fromObject(map);
			System.out.println("打折价discount与标准价standardPrice  JSON String >>>>>>  " + json.toString());
			out.write(json.toString());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			out.close();
			DbUtil.close(rs);
			DbUtil.close(cStmt);
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 生成二维码
	 * 防伪号：xxxxxxx
	 * 委托单位：xxxxxx
	 * 省注协系统管理员电话：xxxxxx
	 * 报告日期：xxxxxx
	 * 注师：xxxxxx
	 * 业务类型：xxxxxx
	 * 验资金额：1000万
	 * 以上内容仅供参考，以www.scicpa.org.cn查询结果为准
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getQrcode(HttpServletRequest request,HttpServletResponse response){
		OutputStream out = null;
		try {
			out = response.getOutputStream();

			String guid = "";
			
			String printType = StringUtil.showNull(request.getParameter("printType"));
			
			if("printBatch".equals(printType)){
				guid = StringUtil.showNull(request.getParameter("guid"));
			}else{
				BbPrint bbprint = (BbPrint)request.getSession().getAttribute("bbprint");			
				guid = bbprint.getGuid();
			}
			
			
			StringBuffer buf = new StringBuffer();
			
			//生成返回二维码内容的链接
			buf.append(request.getRequestURL()).append("?method=executeQrcode&guid=").append(guid);
			
			String content = buf.toString();
			Qrcode handler = new Qrcode();
			handler.setQrcodeErrorCorrect('M');
			handler.setQrcodeEncodeMode('B');
			handler.setQrcodeVersion(13);

			System.out.println(content);
			byte[] contentBytes = content.getBytes("GB2312");

			BufferedImage bufImg = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 150, 150);

			// 设定图像颜色：BLACK
			gs.setColor(Color.BLACK);

			// 设置偏移量 不设置肯能导致解析出错
			int pixoff = 2;
			// 输出内容：二维码
			if (contentBytes.length > 0 && contentBytes.length < 335) {
				boolean[][] codeOut = handler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 2 + pixoff, i * 2 + pixoff, 2, 2);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = "
						+ contentBytes.length + " not in [ 0,334 ]. ");
			}
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "jpg", out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {out.close();} catch (IOException e) {}
		}
		return null;
	}
	
	/**
	 * 扫二维码执行链接返回信息
	 * 
	 * 防伪编号：xxxxxxx
	 * 被审（验）单位：xxxxxx
	 * 事务所：xxxxxx
	 * 电话：xxxxxx
	 * 报告文号：xxxxxx
	 * 报告日期：xxxxxx
	 * 注师：xxxxxx
	 * 业务类型：xxxxxx
	 * 如需对报告详细信息进行验证，请登录www.scicpa.org.cn。
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView executeQrcode(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		Connection conn = null;
		ContentTable ct = null;
		CompanyListTable clt = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			String guid = request.getParameter("guid");
			
			ContentService cs = new ContentService(conn);
			ct = cs.getContentTableById(guid);
			CompanyListService cls = new CompanyListService(conn);
			clt = cls.getCompanyListTable(ct.getCompanyGUID());
			String typename = new DbUtil(conn).queryForString("SELECT TypeName FROM dbo.BB_Type WHERE guid=? ", new Object[]{ct.getTypeid()});

			
			/*buf.append("防伪编号：").append(bbprint.getBbbh())
			.append("；\n被审（验）单位：").append(bbprint.getBsdwmc())
			.append("；\n事务所：").append(bbprint.getCompanyName())
			.append("；\n电话：").append(bbprint.getPhone())
			.append("；\n报告文号：").append(bbprint.getBgwh())
			.append("；\n报告日期：").append(bbprint.getBgrq())
			.append("；\n注师：").append(bbprint.getQmzs1()+"、"+bbprint.getQmzs2())
			.append("；\n业务类型：").append(typename).append("。\n");

			buf.append("如需对报告详细信息进行验证，请登录www.scicpa.org.cn。");*/
			
			StringBuffer buf = new StringBuffer();
			buf.append("<font size='15'>防伪编号：").append(StringUtil.showNull(ct.getBbbh()))
				.append("；<br/>被审（验）单位：").append(StringUtil.showNull(ct.getBsdwmc()))
				.append("；<br/>事务所：").append(StringUtil.showNull(clt.getCompanyName()))
				.append("；<br/>电话：").append(StringUtil.showNull(clt.getPhone()))
				.append("；<br/>报告文号：").append(StringUtil.showNull(ct.getBgwh()))
				.append("；<br/>报告日期：").append(StringUtil.showNull(ct.getBgrq()))
				.append("；<br/>注师：").append(StringUtil.showNull(ct.getQmzs1()+"、"+ct.getQmzs2()))
				.append("；<br/>业务类型：").append(StringUtil.showNull(typename)).append("。<br/>");			
			
			buf.append("如需对报告详细信息进行验证，请登录www.scicpa.org.cn。</font>");
			
			String content = buf.toString();
			
			System.out.println("查询内容: >> " + content);
			
			out.write(content);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	public ModelAndView checkBbIsExist(HttpServletRequest request,HttpServletResponse response){
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String sjlx = af.showNull(request.getParameter("sjlx"));
		String bsdwmc = af.showNull(request.getParameter("bsdwmc"));
		String bgnd = af.showNull(request.getParameter("bgnd"));
		
		PrintWriter out = null ;
		response.setContentType("text/html;charset=UTF-8") ;		 
		try {
			out = response.getWriter() ;
			conn = new DBConnect().getConnect();
			String sql = "select 1 from bb_content1 a inner join bb_sjb b on a.guid=b.guid where a.typeid='sj001' and a.bbstate='报备完成' and a.bsdwmc=? and a.bgnd=? and b.sjlx=?";
			String isExist = af.showNull(new DbUtil(conn).queryForString(sql,new Object[]{bsdwmc,bgnd,sjlx}));
			System.out.println("isExist : "+isExist);
			out.write(isExist);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
}