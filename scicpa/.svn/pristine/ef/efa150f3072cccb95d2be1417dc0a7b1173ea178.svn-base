package cn.org.gdicpa.web.action.shzrtb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.bb.BbNewService;
import cn.org.gdicpa.web.service.content.model.ContentTable;
import net.sf.json.JSONArray;
/**
 * 事务所社会责任填报
 * @author Administrator
 *
 */
public class ShzrtbAction extends MultiActionController {
	private static String SHZRTBADD = "/shzrtb/shzrtbAdd.jsp";
	private static String PRINT = "/shzrtb/print.jsp";
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView(SHZRTBADD);
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map userMap = userSession.getUserMap();
		String officecode = (String)userMap.get("officecode"); //获得当前用户的事务所编号
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//获得当前的时间
		String year=now.substring(0, 4);//获得当前的年份
		
		String sql="select * from R_SHZRLXTJB a left join R_DXALDJB b on a.Guid=b.ZBID  where officecode='"+officecode+"' and year='"+year+"' ";
		try {
			conn = new DBConnect().getConnect();	
			Map map=new DbUtil(conn).getMap(sql);
            String arr1[]= {"KHSL_XZ","KHSL_GY","KHSL_MY","KHSL_SH","KHSL_QT"};
            String arr2[]= {"SYZJ_XZ","SYZJ_GY","SYZJ_MY","SYZJ_SH","SYZJ_QT"};
            String arr3[]= {"AGSL","HGSL","XSBSL","SBSL"};
            String arr4[]= {"AGJE","HGJE","XSBJE","SBJE"};
            int fwkhxj=0;//服务客户数量小计
            double fwkhje=0.0;//服务客户涉及金额小计
            int fwzbxj=0;//帮助企业成功首发上市融资数量小计
            double fwzbje=0.0;//帮助企业成功首发上市融资涉及金额小计
            if(map !=null) {
            for (int i = 0; i < 5; i++) {
				if(!"".equals(map.get(arr1[i]).toString())||map.get(arr1[i]).toString()!=null) {
					int fwkhxj_xj=Integer.parseInt(map.get(arr1[i]).toString());
					fwkhxj+=fwkhxj_xj;
					map.put("FWKHXJ", fwkhxj);//服务客户数量小计
				}
				if(!"".equals(map.get(arr2[i]).toString())||map.get(arr2[i]).toString()!=null) {
					double fwkhje_xj=Double.parseDouble(map.get(arr2[i]).toString());
					fwkhje+=fwkhje_xj;
					map.put("FWKHJE", fwkhje);//服务客户涉及金额小计
				}
			}
            for (int i = 0; i < 4; i++) {
            	if(!"".equals(map.get(arr3[i]).toString())||map.get(arr3[i]).toString()!=null) {
					int fwzbxj_xj=Integer.parseInt(map.get(arr3[i]).toString());
					fwzbxj+=fwzbxj_xj;
					map.put("FWZBXJ", fwzbxj);//帮助企业成功首发上市融资数量小计
				}
				if(!"".equals(map.get(arr4[i]).toString())||map.get(arr4[i]).toString()!=null) {
					double fwzbje_xj=Double.parseDouble(map.get(arr4[i]).toString());
					fwzbje+=fwzbje_xj;
					map.put("FWZBJE", fwzbje);//帮助企业成功首发上市融资涉及金额小计
				}
            }
            }
            model.addObject("map",map);//将查到的数据以map的方式返回到网页
			String type=request.getParameter("Type");
			if("dy".equals(type)) {
				ModelAndView model_print=new ModelAndView(PRINT);
				model_print.addObject("map",map);//将查到的数据以map的方式返回到打印页面
				return model_print;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * 暂存、修改、提交申请
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView shzrtbApply(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Connection conn = null;
		PrintWriter out = null;
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession==null){
			return new ModelAndView("/login.jsp");
		}
		Map userMap = userSession.getUserMap();
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=UTF-8");
			out=response.getWriter();
			
			Map map = new HashMap();
			Map map2 = new HashMap();
			
			Enumeration enum1 = request.getParameterNames();//获得前台所有name属性
			while (enum1.hasMoreElements()) {//遍历前台name属性，把值放入map中
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				map.put(paramName, paramValue);
			}
			
			String officecode = (String)userMap.get("officecode"); //获得当前用户的事务所编号
			map.put("OfficeCode", officecode);
			
			String Guid = request.getParameter("Guid");//获得网页的guid,用于判断是否已经存在记录
            if("".equals(Guid)||Guid==null) {
            	map.put("Guid", UUID.randomUUID().toString());
            }else {
            	map.put("Guid",Guid);
            }
            
            String saveType = request.getParameter("saveType");//获得网页想保存的类型,暂存或者提交审核
            if("tjsh".equals(saveType)) {
			    map.put("AuditState", "提交审核");
			}else if("zc".equals(saveType)) {
				map.put("AuditState", "暂存");	
			}
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String year=now.substring(0, 4);
			map.put("ApplyTime", now);
			map.put("Year", year);
			
			BbNewService bns = new BbNewService(conn);
			int i = bns.saveAppli("R_SHZRLXTJB","Guid", map);//保存信息到表R_SHZRLXTJB
			
			
			String Title=(String) map.get("Title");
			String ZBID=(String) map.get("Guid");
			String Type=(String) map.get("Type");
			String ALContent=(String) map.get("ALContent");
			map2.put("Guid", UUID.randomUUID().toString());
			map2.put("Title", Title);
			map2.put("ZBID", ZBID);
			map2.put("Type", Type);
			map2.put("ALContent", ALContent);
			int j = bns.saveAppli("R_DXALDJB","ZBID", map2);//保存信息到表R_DXALDJB
			String contentPath=request.getContextPath();
		    out = response.getWriter();
			if (i > 0 && j>0 && "tjsh".equals(saveType)) {
				out.print("<script>alert('提交成功，请等待注协审核');window.location.href= \""+contentPath+"/common/shzrtb.do?method=index\";</script>");

			}else if (i > 0 && j>0 && "zc".equals(saveType)) {
				out.print("<script>alert('暂存成功');window.location.href= \""+contentPath+"/common/shzrtb.do?method=index\";</script>");
			} else {
				out.print("<script>alert('操作失败，请稍后重试');window.location.href= \""+contentPath+"/common/shzrtb.do?method=index\";</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
}
