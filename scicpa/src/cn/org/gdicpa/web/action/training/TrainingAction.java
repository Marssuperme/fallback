package cn.org.gdicpa.web.action.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.net.Web;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.service.education.Md5;
import cn.org.gdicpa.web.service.pay.Order;
import cn.org.gdicpa.web.service.pay.OrderService;
import cn.org.gdicpa.web.service.training.TrainingService;

public class TrainingAction extends MultiActionController {
	
	private final String TRAINING_LIST = "/training/list.jsp";
	private final String TRAINING_VIEW = "/training/view.jsp";
	
	private final String TRAINING_EXPENSE = "/training/expense.jsp";
	private final String TRAINING_TLIST = "/training/tlist.jsp";
	
	private final String TRAINING_SUCCESS = "/training/success.jsp";
	
	private final String LISTSEATNO = "/training/listSeatNo.jsp";
	private final String KQLIST = "/training/kqlist.jsp";
	
	private final String NETWORKSCHOOLLIST = "/training/netschoollist.jsp";
	private final String NETSCHOOLINFO = "/training/netschoolinfo.jsp";
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TRAINING_LIST);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String loginid = "";
			String officecode = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
			}
			
			
			/**
			 * 1.如果是注师，且合伙人字段为是，就可以看到全部课程；
			 * 2.如果只是注师，就可以看到（注师班，普通班）
			 * 3.如果只是非执业会员，就只能看到普通班内容；
			 */
			// 最新培训
			
			String sql = null;
			String p = CHF.showNull(request.getParameter("param"));
			
			// 状态
			String statusTemp = " case when enrollbdate is null then '审批中' " 
							  + " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
							  + " when convert(Varchar(10),getdate(),120) between enrollbdate and enrolledate " 
							  + " then '报名中' else '报名结束' end as statusTemp ";
			// 可报人数 
			String canquote = " case when (quote-tcountss)<0 then 0 else (quote-tcountss) end as canquote ";
			
			if("company".equals(p)){
				//事务所改制
				String getOldLoginIdSql = "select oldLoginId from k_company where loginid=?";
				String oldLoginId = new DbUtil(conn).queryForString(getOldLoginIdSql, new Object[]{loginid});	
				if(oldLoginId==null){
					sql = "	select *,"+canquote+" from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
					 	  " from b_training a left join b_reader r on a.id=r.nid left join (" +
					 	  " select distinct trainingID ,1 as opt 	 " +
					 	  " from b_enroll " +
					 	  " where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
					 	  " ) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
					 	  " where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
					 	  " where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"'  ) t where t.statusTemp != '审批中' " ;
				}else{
					sql = "	select *,"+canquote+" from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
				 	  " from b_training a left join b_reader r on a.id=r.nid left join (" +
				 	  " select distinct trainingID ,1 as opt 	 " +
				 	  " from b_enroll " +
				 	  " where 1=1 and (loginid in ('" + loginid +"','"+oldLoginId+"') or tid = '"+loginid+"')  " +
				 	  " ) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
				 	  " where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
				 	  " where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"'  ) t where t.statusTemp != '审批中' " ;
				}
			}else if("micfo".equals(p)){
				sql = "select isshareholder from k_micfo where loginid = '"+loginid + "'";
//				Connection conn=new DBConnect().getConnect(); 
				String isshareholder = CHF.showNull(new DbUtil(conn).queryForString(sql));
				//DbUtil.close(conn);
				if("是".equals(isshareholder)){			// 1
					sql = "select *,"+canquote+" from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
						"	from b_training a left join b_reader r on a.id=r.nid left join (" +
						"		select distinct trainingID ,1 as opt 	 " +
						"		from b_enroll " +
						"		where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
						"	) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
						" where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
				 	    " where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"' ) t where t.statusTemp != '审批中' " ;
					
				}else{									//  2
				    sql = "select *,"+canquote+"  from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
						"	from b_training a left join b_reader r on a.id=r.nid left join (" +
						"		select distinct trainingID ,1 as opt 	 " +
						"		from b_enroll " +
						"		where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
						"	) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
						" where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
						" where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"' ) t where t.statusTemp != '审批中' ";
				}
				
			}else{
				sql = "select *,"+canquote+" from (select *,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
					"	from b_training a left join (" +
					"		select distinct trainingID ,1 as opt 	 " +
					"		from b_enroll " +
					"		where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
					"	) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
						" where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
					"   where a.ctype='k_micfono' ) t where t.statusTemp != '审批中' ";
		
			}
			
			System.out.println("TrainingAction--->sql="+sql);
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("培训信息");
			pp.setTableID("trainingList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("名称", "trainingName").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("培训结束日期", "trainingedate","showCenter");
			pp.addColumn("讲师教师", "teacher");
//			pp.addColumn("第几期", "term","showCenter");
			pp.addColumn("限定人数", "quote","showCenter");
			pp.addColumn("可报人数", "canquote","showCenter");
			pp.addColumn("是否报名", "bm","showCenter");
			pp.addColumn("状态", "statusTemp","showCenter");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(15);
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}
	
	
	public ModelAndView indexFromeHYJ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TRAINING_LIST);
		try {
			
			ASFuntion CHF = new ASFuntion();
			String source = CHF.showNull(request.getParameter("source"));
			String opttype = CHF.showNull(request.getParameter("optType"));
			String ctypetabname = CHF.showNull(request.getParameter("ctypeTabName"));
			System.out.println("source="+source+"   ctypeTabName="+ctypetabname);
			String loginid = CHF.showNull(request.getParameter("loginId"));
			String loginname = CHF.showNull(request.getParameter("loginName"));
			String officecode = CHF.showNull(request.getParameter("officeCode"));
			String sql = "";
			// 广东省注协自助会员机链接入口
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				
				// 状态
				String statusTemp = " case when enrollbdate is null then '审批中' " 
								  + " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
								  + " when convert(Varchar(10),getdate(),120) between enrollbdate and enrolledate " 
								  + " then '报名中' else '报名结束' end as statusTemp ";
				// 可报人数
				String canquote = " case when (quote-tcountss)<0 then 0 else (quote-tcountss) end as canquote ";
				
				if("k_cicpa".equalsIgnoreCase(ctypetabname)){
					sql = "	select * from ("+ 
					  " select distinct *,"+canquote+" from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
				 	  " from b_training a left join b_reader r on a.id=r.nid left join (" +
				 	  " select distinct trainingID ,1 as opt 	 " +
				 	  " from b_enroll " +
				 	  " ) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
				 	  " where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
				 	  " where isnull(a.ctype,'')<>'k_micfono' ) t where t.statusTemp != '审批中') a " ;
				}else{
					sql = "select isshareholder from k_micfo where loginid = '"+loginid + "'";
					Connection conn=new DBConnect().getConnect(); 
					String isshareholder = CHF.showNull(new DbUtil(conn).queryForString(sql));
					DbUtil.close(conn);
					String sqlWhere = " and convert(Varchar(10),getdate(),120) between enrollbdate and trainingedate ";
					if("是".equals(isshareholder)){			// 1
						sql = "select *,"+canquote+" from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
							"	from b_training a left join b_reader r on a.id=r.nid left join (" +
							"		select distinct trainingID ,1 as opt 	 " +
							"		from b_enroll " +
							"		where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
							"	) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
							" where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
					 	    " where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"' ) t where t.statusTemp != '审批中' " + sqlWhere ;
						
					}else{//  2
					    sql = "select *,"+canquote+"  from (select a.*,"+statusTemp+",case opt when '1' then '已报名' else '未报名' end as bm,isnull(tcounts,0) as tcountss " +
							"	from b_training a left join b_reader r on a.id=r.nid left join (" +
							"		select distinct trainingID ,1 as opt 	 " +
							"		from b_enroll " +
							"		where 1=1 and (loginid = '"+loginid+"'	or tid = '"+loginid+"')  " +
							"	) b on a.id = b.trainingID left join ( select isnull(count(trainingID),0) as tcounts,trainingID as trainingIDs  from b_enroll "+ 
							" where  source = 'b_training' group by trainingID) c on a.id = c.trainingids " +
							" where isnull(a.ctype,'')<>'k_micfono' and r.reader='"+officecode+"' ) t where t.statusTemp != '审批中' " + sqlWhere ;
					}
				}
			
			}
			
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("培训信息");
			pp.setTableID("trainingList");
			pp.setWhichFieldIsValue(1);
			if(("k_cicpa".equalsIgnoreCase(ctypetabname) || "k_micfo".equalsIgnoreCase(ctypetabname)) && ("kqpxb".equalsIgnoreCase(opttype) || "kq_cx_szx".equalsIgnoreCase(opttype) || "kq_cx_zx".equalsIgnoreCase(opttype))){
				pp.addColumn("名称", "trainingName").setTdProperty(" onclick=\"goExcute('${id}');\" ");
			}else{
				pp.addColumn("名称", "trainingName").setTdProperty(" onclick=\"goExcute('${id}');\" ");
//				pp.addColumn("名称", "trainingName").setTdProperty(" onclick=\"goView('${id}');\" ");
			}
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("培训结束日期", "trainingedate","showCenter");
			pp.addColumn("讲师教师", "teacher");
//			pp.addColumn("第几期", "term","showCenter");
			pp.addColumn("限定人数", "quote","showCenter");
			pp.addColumn("可报人数", "canquote","showCenter");
			pp.addColumn("是否报名", "bm","showCenter");
			pp.addColumn("状态", "statusTemp","showCenter");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			pp.setPageSize_CH(15);
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
			modelAndView.addObject("source", source);
			modelAndView.addObject("opttype", opttype);
			modelAndView.addObject("loginid", loginid);
			modelAndView.addObject("loginname", loginname);
			modelAndView.addObject("ctypetabname", ctypetabname);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
	
	
	
	
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TRAINING_VIEW);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String table = "b_training";
			
			String nid = CHF.showNull(request.getParameter("nid"));
			System.out.println(this.getClass()+ "      nid = "+nid);
			
			conn  = new DBConnect().getConnect();
			TrainingService ts = new TrainingService(conn);
			
			// 查看该培训是否中转
			Map map = ts.getIsTransit(nid);
			String istransit = (String)map.get("istransit");
			String istransit2 = (String)map.get("istransit1");
			
			System.out.println(this.getClass()+"   istransit2 = "+istransit2);
			
			String loginid = "",loginname = "",ctypetabname = "",sql = "",officecode="";
			String source = request.getParameter("source");
			// 广东省注协自助会员机链接入口
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				loginid = CHF.showNull(request.getParameter("loginid"));
				loginname = new DbUtil(conn).queryForString(" select loginname from k_user where loginid = ?",new Object[]{loginid});
				ctypetabname = new DbUtil(conn).queryForString(" select ctypetabname from k_user where loginid = ?",new Object[]{loginid}); 
				officecode = new DbUtil(conn).queryForString(" select officecode from k_user where loginid = ?",new Object[]{loginid});
			}else{
				if(userSession != null){
					loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
					loginname = CHF.showNull((String)userSession.getUserMap().get("loginname"));
					ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname")).toLowerCase(); 
				}
			}
			
			// 改培训班已报名人数
			String sql2 = "select count(trainingID) as tcount from b_enroll where trainingID = '"+nid+"' and source = 'b_training' ";
			String count = new DbUtil(conn).queryForString(sql2);
			
			
			// 得到该培训班信息、 该培训报名的总人数、对应订单状态
			map = ts.get(table, nid, loginid,ctypetabname);
			String loginid1 = (String)map.get("loginid");
			map.put("table", table);
			if(loginid1 == null || "".equals(loginid1)){
				map.put("loginid", loginid);
			}
			map.put("loginname", loginname);
			map.put("ctypetabname", ctypetabname);
			
			/**
			 * 针对执业会员个人登录网站 进行 该培训报名 :1.取最近一次培训时写的电话、所属职称    2. 如果没有就从机构信息取
			 */
			
			
			// 执业会员 报名 电话号码
			if("".equals((String)map.get("phone")) || (String)map.get("phone")==null){
				// 1.取最近一次培训时写的电话、所属职称
				String phone = new DbUtil(conn).queryForString("select top 1 phone from b_enroll where tid = ? order by edate desc ",new Object[]{loginid});
				if("".equals(phone) || null == phone){
					// 2. 如果没有就从机构信息取
					phone = new DbUtil(conn).queryForString("select mobile from k_micfo where loginid = ?",new Object[]{loginid});
				}
				map.put("phone", phone);
			}
			String isshareholder=new DbUtil(conn).queryForString("select isshareholder from k_micfo where loginid = ?",new Object[]{loginid});
			isshareholder=isshareholder==null?"":isshareholder;
			map.put("isshareholder", isshareholder);
			
			// 执业会员 报名 职务
			if("".equals((String)map.get("leval")) || (String)map.get("leval")==null){
				// 1.取最近一次培训时写的电话、所属职称
				String leval = new DbUtil(conn).queryForString("select top 1 leval from b_enroll where tid = ? order by edate desc ",new Object[]{loginid});
				if("".equals(leval) || null == leval){
					leval = new DbUtil(conn).queryForString("select post from k_micfo where loginid = ?",new Object[]{loginid});
				}
				map.put("leval", leval);
			}
			
			
			// 报名状态
			sql = " select case when enrollbdate is null then '审批中' " 
				+ " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
				+ " when convert(Varchar(10),getdate(),120) between enrollbdate and enrolledate " 
				+ " then '报名中' else '报名结束' end as statusEx "
				+ " from b_training where id = ? ";
			
			// 广东省注协自助会员机链接入口：可以在培训日期开始的第二天前进行补报名
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				// 报名状态
				sql = " select case when enrollbdate is null then '审批中' " 
					+ " when convert(Varchar(10),getdate(),120) < enrollbdate then '审批中' "
					+ " when convert(Varchar(10),getdate(),120) between enrollbdate and trainingedate " 
					+ " then '报名中' else '报名结束' end as statusEx "
					+ " from b_training where id = ? ";
			}
			
			String status = new DbUtil(conn).queryForString(sql,new Object[]{nid});
			map.put("status", status);
			String bedPresentation=new DbUtil(conn).queryForString("select bedPresentation from b_training where id = ? ",new Object[]{nid});
			String ZZPresentation=new DbUtil(conn).queryForString("select ZZPresentation from b_training where id = ? ",new Object[]{nid});
			System.err.println(bedPresentation+"==============================="+ZZPresentation);
			modelAndView.addObject("bedPresentation", bedPresentation);
			modelAndView.addObject("ZZPresentation", ZZPresentation);
			
			// 广东省注协自助会员机链接入口：可以在培训日期开始的第二天前进行补报名
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				String trainingbdate = map.get("trainingbdate")+"";
				String enrolledate = map.get("enrolledate")+"";
				// 如果培训开始日期大于报名结束日期，那么补报名的截止时间是培训开始日期的第二天，
				// 如果培训开始日期小于报名结束日期，那么补报名的截止时间是报名结束日期。
				int rs = new DateUtil().equalDate(trainingbdate, enrolledate);
				if(rs<0){
					map.put("enrolledate", getNextDay(trainingbdate));
				}else{
					map.put("enrolledate", enrolledate);
				}
			}
			
			modelAndView.addObject("trainingMap", map);
			
			System.out.println("traintype="+(String)map.get("traintype"));
			
			String lessonid = (String)map.get("lessonid");
			
//			// 系统报名人员
//			sql = "select distinct a.*,b.trainingid,b.isexpense,b.tid as btid,d.tid as dtid,b.orderid,b.ispass,b.istransit,b.isdormitory,c.orderstate," +
//				"	case d.ispass when 1 then '已通过' else case b.ispass when 1 then '已通过' else case c.orderstate when 1 then '已缴费' else " +
//				"	case when isnull(b.orderid,'') = '' then '' else b.enrollType end  end end end as ttype, " +
//				" 	b.leval,b.phone from ( select loginid,loginname,ctype,ctypetabname,officecode,cpano,isShareholder,mobile,post from K_Micfo "+
//				"	where officecode ='"+loginid+"' ) a  " +
//				"	left join b_enroll b on b.trainingID ='"+nid+"' and  a.loginid = b.tid " +
//				"	left join b_enroll d on d.lessonid ='"+lessonid+"' and a.loginid = d.tid  " +
//				"	left join k_order c on b.orderid = c.orderid"; 
			 
			// 系统报名人员
			if ("主任会计师班".equals((String)map.get("traintype"))){
				sql = "select distinct a.*,b.trainingid,b.isexpense,b.tid as btid,b.orderid,b.ispass,b.istransit,b.istransit1,b.isdormitory,c.orderstate," +
						"	case b.ispass when 1 then '已通过' else case c.orderstate when 1 then '已缴费' else " +
						"	case when isnull(b.orderid,'') = '' then '' else b.enrollType end  end end as ttype, " +
						" 	b.leval,b.phone from ( select loginid,loginname,ctype,ctypetabname,officecode,cpano,isShareholder,mobile,post from K_Micfo "+
						"	where officecode ='"+loginid+"' and state='0' and association='广东省注册会计师协会' and isShareholder='是') a  " +
						"	left join b_enroll b on b.trainingID ='"+nid+"' and  a.loginid = b.tid " +
						"	left join b_enroll d on d.lessonid ='"+lessonid+"' and a.loginid = d.tid  " +
						"	left join k_order c on b.orderid = c.orderid";  
			}else{
				sql = "select distinct a.*,b.trainingid,b.isexpense,b.tid as btid,b.orderid,b.ispass,b.istransit,b.istransit1,b.isdormitory,c.orderstate," +
						"	case b.ispass when 1 then '已通过' else case c.orderstate when 1 then '已缴费' else " +
						"	case when isnull(b.orderid,'') = '' then '' else b.enrollType end  end end as ttype, " +
						" 	b.leval,b.phone from ( select loginid,loginname,ctype,ctypetabname,officecode,cpano,isShareholder,mobile,post from K_Micfo "+
						"	where officecode ='"+loginid+"' and state='0' and association='广东省注册会计师协会' ) a  " +
						"	left join b_enroll b on b.trainingID ='"+nid+"' and  a.loginid = b.tid " +
						"	left join b_enroll d on d.lessonid ='"+lessonid+"' and a.loginid = d.tid  " +
						"	left join k_order c on b.orderid = c.orderid";  
			}
			

    
			
			System.out.println("py:" + sql);
			
			List userList = ts.getLists(sql,loginid);
			
			System.out.println(this.getClass()+"   ## sql="+sql);
			// 手动录入的报名人员
			sql = "select * from b_enroll where loginid = '"+loginid+"' and trainingid = '"+map.get("trainingid")+"' and lessonid = '"+lessonid+"' and usertype = 'companyToMicfoNo'";
			List companyToMicfoNoList = ts.getList(sql);
			modelAndView.addObject("userList", userList);
			modelAndView.addObject("companyToMicfoNoList", companyToMicfoNoList);
			modelAndView.addObject("companyToMicfoNoListSize", companyToMicfoNoList.size());
			
			/**
			 * 针对事务所登录网站为小朋友 进行 该培训班报名
			 */
			
			// 该培训班可报名人数
			
			int countEnroll = Integer.parseInt((String)map.get("quote"))-Integer.parseInt(count);
			if(countEnroll<0){
				countEnroll = 0;
			}
			
			
			modelAndView.addObject("source", source);
			modelAndView.addObject("loginid", loginid);
			modelAndView.addObject("loginname", loginname);
			modelAndView.addObject("officecode", officecode);
			modelAndView.addObject("ctypetabname", ctypetabname);
			modelAndView.addObject("countEnroll", countEnroll);
			modelAndView.addObject("today", new ASFuntion().getCurrentDate());
			modelAndView.addObject("istransit", istransit);
			modelAndView.addObject("istransit2", istransit2);
			
			String sZzRemarks=(String)map.get("szzremarks");
			String sZzRemarks2=(String)map.get("szzremarks1");
			modelAndView.addObject("sZzRemarks", sZzRemarks);
			modelAndView.addObject("sZzRemarks2", sZzRemarks2);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	/**
	 * 团体会员报名
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("调用了save()的方法-------------------------------------------");
		Connection conn=null;
		
		ModelAndView modelAndView = new ModelAndView(TRAINING_SUCCESS);
		
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			String loginuser = (String)userSession.getUserMap().get("loginid");
			String ctypetabname = (String)userSession.getUserMap().get("ctypetabname");
			myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			
			parameters.put("edate", CHF.getDateAndTime()); 
			
			parameters.put("loginuser", loginuser);
			parameters.put("ctypetabname", ctypetabname);
			
			String nid = CHF.showNull((String)parameters.get("trainingid"));
			String table = "b_training";
			conn  = new DBConnect().getConnect();
			
			TrainingService tss = new TrainingService(conn);
			String loginid = (String)parameters.get("loginid");
			String trainingid = (String)parameters.get("trainingid");
			
			String orderId = (String)parameters.get("orderid");
			PreparedStatement qps1=null;
			ResultSet rs=null;
			String qsql="";
			String tnames = (String)parameters.get("tname");
			String [] ts = tnames.split(",");
			List<String> sNames=new ArrayList<String>();
				//1、判断是否已有，有就不增加
			qsql = "select tname from b_enroll where trainingID = ? and source = ? and loginid = ?  ";
			qps1 = conn.prepareStatement(qsql);
			qps1.setString(1, (String)parameters.get("trainingid"));
			qps1.setString(2, table);
			qps1.setString(3, loginid);				
			rs = qps1.executeQuery();
				while(rs.next()){
					sNames.add(rs.getString("tname"));
				}
			DbUtil.close(rs);
			DbUtil.close(qps1);
			
			
			String[] syzss = {};
			String[] syzzs = {};
			String[] syzzs2 = {};
			String[] phones = {};
			String syzs = (String)parameters.get("syzs");  //手动是否住宿 
			String syzz = (String)parameters.get("syzz"); //手动是否中转   为空就不处理  
			
			String syzz2 = (String)parameters.get("syzz2"); //手动是否中转   为空就不处理  
			
			if(syzs!=null && !"".equals(syzs)){
				syzss = syzs.split(",");
			}
			if(syzz!=null && !"".equals(syzz)){
				 syzzs = syzz.split(",");
			}
			if(syzz2!=null && !"".equals(syzz2)){
				 syzzs2 = syzz2.split(",");
			}
			String phone = (String)parameters.get("phones"); //  记录电话号码
			if(phone!=null && !"".equals(phone)){
				phones = phone.split(",");
			}
			
			
			String leval = (String)parameters.get("leval2");
			String[] levals = leval.split(",");
			for (String string : sNames) {
				boolean boo=false;
				for (int i = 0; i < ts.length; i++) {
					/*System.err.println(ts[i]+"-------------------------this is tname");
					System.err.println(string+"-------------------------this is sql tname");*/
					if(string.equals(ts[i])){
						String[] str={syzss[i],syzzs[i],phones[i],syzzs2[i],levals[i]};
						tss.upByid(trainingid, string, str);
						System.out.println(ts[i]+"-----------what this is?");
						boo=true;
					}
				}
				if(!boo){
					System.err.println(string+"this is tname == false");
					tss.delByName(loginid, trainingid, table, string);
				}
			}
			//tss.del( loginid, trainingid ,table);//删除原来的报名
			
			OrderService orderService = new OrderService(conn);
			orderService.remove(orderId);	//删除订单
			
			orderId = orderService.getOrderId();
			
			parameters.put("orderid", orderId);
			
			String result = tss.save( table, parameters) ;//保存
			
			
			// 更新 记录到 学时表 里面
			
			
			Order order = orderService.getOrder(orderId);
			
			Map map = tss.get(table, trainingid, loginid,ctypetabname);
			modelAndView.addObject("map", map);
			modelAndView.addObject("order", order);
			modelAndView.addObject("orderId", orderId);
			modelAndView.addObject("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		response.sendRedirect(request.getContextPath()+"/common/certificateReceipt.do?method=receiptList");
		return null;
		//return modelAndView;
	}
	
	//我的报名
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TRAINING_TLIST);
		String t = request.getParameter("t");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String loginid = "",ctypetabname="",officecode="";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				
				System.out.println("loginid:"+loginid);
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
				System.out.println("ctypetabname:"+ctypetabname);
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
				System.out.println("officecode:"+officecode);
			}
			String table = "b_training";
			
			//改制修改
			String getOldLoginIdSql = "select oldLoginId from k_company where loginid=?";
			String oldLoginId = new DbUtil(conn).queryForString(getOldLoginIdSql, new Object[]{loginid});
			
			/**
			 * 1.  处理  pp.addColumn("培训费用", "expense2","showMoney") 为空的时候的异常
			 * 2.  是否已缴费字段从     k_order 表中的 orderState 换成 b_enroll 表中的isExpense
			 */
			String sql = ""; 
			
			sql= " select a.* ,case isnull(expense,'') when ''  then 0 else expense end as expense2,b.orderstate,case  b.orderstate when 1 then '已缴费' else '未缴费' end as isexp," +
			   "   paytype,paytarget from (" +
			   "   select distinct a.*," +
			   "   b.isexpense,b.orderid,memo, " +
			   "   case when enrolltype = '团体代报名' then 1 else 0 end as opt  " +
			   "   from b_training a ,b_enroll b " +
			   "   where 1=1 and b.source = '"+table+"' ";
			
			if("K_Company".equalsIgnoreCase(ctypetabname)){
				if(oldLoginId==null){
					sql = sql + "  and loginid = '"+loginid+"' and isnull(a.ctype,'')<>'k_micfono' " ;
				}else{
					sql = sql + "  and loginid in ('" + loginid +"','"+oldLoginId+"') and isnull(a.ctype,'')<>'k_micfono' " ;
				}
			}else if("k_micfo".equalsIgnoreCase(ctypetabname)){
				sql = sql + "  and tid = '"+loginid+"' and isnull(a.ctype,'')<>'k_micfono' ";
			}else{
				sql = sql + "  and tid = '"+loginid+"' and a.ctype = 'k_micfono' ";
			}
			
			sql = sql + "   and a.id = b.trainingid ) a left join k_order b on a.orderid = b.orderid  " ;
			if(!"k_micfono".equalsIgnoreCase(ctypetabname)){
				sql = sql + " left join b_reader r on a.id = r.nid where r.reader = '"+officecode+"'" ;
			}
			
			System.out.println("sql----->:"+sql);
			
			DataGridProperty pp = new DataGridProperty();
			
			if("K_Company".equalsIgnoreCase(ctypetabname)){
				String sql2 = null;
				if(oldLoginId==null){
					sql2 = " select n.userid,n.title,n.customername,n.timelimit,c.id,c.tcname,c.applytime,c.isJoin," 
								+ " c.notJoinReason,(substring(c.NoApproveReason,1,7)+'...') as NoApproveReason1,c.NoApproveReason, " 
								+ " case isnull(c.astate,'') " 
								+ " when '' then '审批中' "
								+ " when 'null' then '审批中' "
								+ " when '初步批准' then '审批中' "
								+ " when '初步不批准' then '不批准' "
								+ " when '未批准' then '待批准' "
								+ " else c.astate "
								+ " end astate "
								+ " from k_testernotice n left join k_TesterComposition c "
								+ " on n.id = c.noticeid "
								+ " where n.status = '1' and c.companyId = '"+loginid+"'";
				}else{
					sql2 = " select n.userid,n.title,n.customername,n.timelimit,c.id,c.tcname,c.applytime,c.isJoin," 
						+ " c.notJoinReason,(substring(c.NoApproveReason,1,7)+'...') as NoApproveReason1,c.NoApproveReason, " 
						+ " case isnull(c.astate,'') " 
						+ " when '' then '审批中' "
						+ " when 'null' then '审批中' "
						+ " when '初步批准' then '审批中' "
						+ " when '初步不批准' then '不批准' " 
						+ " when '未批准' then '待批准' "
						+ " else c.astate "
						+ " end astate "
						+ " from k_testernotice n left join k_TesterComposition c "
						+ " on n.id = c.noticeid "
						+ " where n.status = '1' and c.companyId in ('" + loginid +"','"+oldLoginId+"')";
				}
				
				System.out.println("sql2:"+sql2);
				 
				DataGridProperty pp2 = new DataGridProperty();
				
				pp2.setTitle("检查组人员通知报名");
				pp2.setTableID("testerNoticeBM");
				pp2.addColumn("通知", "title","showCenter");
				pp2.addColumn("截止日期", "timelimit","showCenter");
//				pp2.addColumn("发布人", "loginname","showCenter");			
				pp2.addColumn("发布机构", "customername","showCenter");			
				pp2.addColumn("报名人", "tcname","showCenter");
				pp2.addColumn("报名时间", "applytime","showCenter");
				pp2.addColumn("状态", "astate","showCenter");
				pp2.addColumn("确认参加", "astate","showCenter","cn.org.gdicpa.web.action.training.TrainingFieldProcess","");	
				//pp2.addColumn("不批准原因", "NoApproveReason","showCenter","cn.org.gdicpa.web.action.training.TrainingFieldProcess","");	
				pp2.addColumn("不批准原因", "NoApproveReason").setColContent(" <span style='border:1px dashed white' title='${NoApproveReason}'>${NoApproveReason1}</span> ");
				
				pp2.setSQL(sql2);
				pp2.setOrderBy_CH("timelimit");
				pp2.setDirection("desc");
				request.getSession().setAttribute(DataGrid.sessionPre + pp2.getTableID(), pp2);
				
				pp.setTitle("培训班报名");
			}else{
				pp.setTitle("我的报名");
			}
			pp.setTableID("tList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("培训名称", "trainingName").setTdProperty(" align='center' onclick=\"goView('${id}');\" ");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("培训结束日期", "trainingedate","showCenter");
			pp.addColumn("讲师教师", "teacher","showCenter");			
			pp.addColumn("每人费用", "expense2","showMoney").setTdProperty(" align='right' ");
			pp.addColumn("培训状态", "status","showCenter");
			pp.addColumn("缴费状态", "isexp","showCenter");
			pp.addColumn("缴费方式", "paytype","showCenter");
			pp.addColumn("缴费类型", "payTarget","showCenter");
			pp.addColumn("操作", "isexpense").setColContent("<center><a style='text-decoration:underline;' href='###' onclick=\"save('${orderid}','${orderstate}','${opt}');\">缴费</a>&nbsp;&nbsp;&nbsp;&nbsp;<a style='text-decoration:underline;' href='javascript:void(0);' onclick=\"del('${id}','${orderstate}','${opt}');\">取消</a></center>");
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
			
			System.out.println("sql:"+sql);
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			modelAndView.addObject("tableName", ctypetabname);   // 如果是团体才能看到检查组人员报名信息
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		modelAndView.addObject("t",t);
		return modelAndView;
	}
	
	//缴费 
	public ModelAndView expense(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TRAINING_EXPENSE);
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			String nid = CHF.showNull((String)request.getParameter("nid"));
			String eid = CHF.showNull((String)request.getParameter("eid"));
			String loginid = "";
			String officecode = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
			}
			String ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname")).toLowerCase(); 
			
			conn  = new DBConnect().getConnect();
			TrainingService ts = new TrainingService(conn);
			
//			String sql = "select b.*,a.trainingName,a.expense,a.trainingbdate,a.trainingedate " +
//			"	from b_training a ,b_enroll b " +
//			"	where 1=1 " +
//			"	and isnull(b.isexpense,0) = 0 " +
//			"	and ( b.loginid = '"+loginid+"' or b.tid = '"+loginid+"')" +
//			"	and a.id = '"+nid+"' " +
//			"	and a.id = b.trainingid" ;
			
			String sql = "";
			
			if("k_company".equalsIgnoreCase(ctypetabname) || "k_micfo".equalsIgnoreCase(ctypetabname)){
				sql = " select a.*,r.reader from (select b.*,a.id as aid,a.ctype,a.trainingName,a.expense,a.trainingbdate,a.trainingedate " +
					"	from b_training a ,b_enroll b" +
					"	where 1=1 " +
					"	and  b.loginid = '"+loginid+"' "+
					"	and a.id = '"+nid+"' " +
					"	and a.id = b.trainingid ) a left join b_reader r on a.aid=r.nid where a.ctype<>'k_micfono' and reader = '"+officecode+"'" ;
			}else{
				sql = " select b.*,a.ctype,a.trainingName,a.expense,a.trainingbdate,a.trainingedate " +
					"	from b_training a ,b_enroll b " +
					"	where 1=1 " +
					"	and  b.tid = '"+loginid+"' " +
					"	and a.id = '"+nid+"' " +
					"	and a.id = b.trainingid and ctype='k_micfono' " ;
			}
			
			
			Map allMap = ts.get(sql);
			allMap.put("expall", CHF.showMoney3((String)allMap.get("expenseall")));
			allMap.put("nid", nid);
			modelAndView.addObject("allMap", allMap);
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("缴费统计");
			pp.setTableID("expense");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("培训名称", "trainingName");
			pp.addColumn("参与人", "tname","showCenter");
			pp.addColumn("培训费用", "expense","showMoney");
//			pp.addColumn("缴费方式", "memo","showCenter");
			
//			pp.setColumnWidth("170,50,70");
			
			pp.setCancelOrderby(true);
			pp.setCancelPage(true);
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		
		
		return modelAndView;
	}
	
	//缴费保存
	public ModelAndView esave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String loginid = "",ctypetabname = "",memo = "个人缴费";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname")).toLowerCase(); 
			}
			if("k_company".equals(ctypetabname)){
				memo = "团体缴费";
			}
			
			String nid = CHF.showNull((String)request.getParameter("nid"));
			conn  = new DBConnect().getConnect();
			
			TrainingService ts = new TrainingService(conn);
			
			ts.expense( nid, loginid, memo);
			
			response.setContentType("text/html;charset=UTF-8") ;
			PrintWriter out = response.getWriter() ;
			out.println("缴费成功");
			out.close() ;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
	}
	
	//删除我的报名
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			ASFuntion CHF=new ASFuntion();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			
			String loginid = "";
			String ctypetabname = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
			}else{
				loginid = CHF.showNull(request.getParameter("loginid"));
				ctypetabname = CHF.showNull(request.getParameter("ctypetabname"));
			}
			if("".equals(loginid) || null==loginid){
				loginid = request.getParameter("loginid_hyj");
			}
			if("".equals(ctypetabname) || null==ctypetabname){
				ctypetabname = request.getParameter("ctypetabname_hyj");
			}
			String nid = CHF.showNull((String)request.getParameter("nid"));
			conn  = new DBConnect().getConnect();
			
			TrainingService ts = new TrainingService(conn);
			
			String result = ts.del(nid,loginid,ctypetabname,"p");
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
	
	//判断是否可以报名
	public ModelAndView lesson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String loginid = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			String nid = CHF.showNull((String)request.getParameter("trainingid"));
			String lid = CHF.showNull((String)request.getParameter("lessonid"));
			
			conn  = new DBConnect().getConnect();
			
			TrainingService ts = new TrainingService(conn);
			String result = ts.isLesson(lid, loginid);
			
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.println(result);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 已报名人数
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView viewCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn=null;
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			String loginid = "";
			if(userSession != null){
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			String trainingid = CHF.showNull((String)request.getParameter("trainingid"));
			conn  = new DBConnect().getConnect();
			String sql = "select count(trainingID) as tcount from b_enroll where trainingID = '"+trainingid+"' and source = 'b_training' and loginid !='"+loginid+"' ";
			String count = CHF.showNull(new DbUtil(conn).queryForString(sql));
			System.out.println(this.getClass()+"     sqll="+sql+" trainingid="+trainingid+"   count="+count);
			PrintWriter out = null ;
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(count==null || count.equals("")){
				count = "0";
			}
			out.println(count);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 个人报名
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView savePerson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Connection conn=null;
		ModelAndView modelAndView = new ModelAndView(TRAINING_SUCCESS);
		
		String url = "";
		String loginuser = "";
		String loginname = "";
		String ctypetabname = "";
		String officecode = "";
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			
			MyFileUpload myfileUpload = new MyFileUpload(request);
			myfileUpload.UploadFile(null, null);
			Map parameters = myfileUpload.getMap();
			String source = (String)parameters.get("source");
			// 广东省注协自助会员机链接入口
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				loginuser = (String)parameters.get("loginid_hyj");
				loginname = (String)parameters.get("loginname_hyj");
				ctypetabname = (String)parameters.get("ctypetabname_hyj");
				officecode = (String)parameters.get("officecode_hyj");
			}else{
				loginuser = (String)userSession.getUserMap().get("loginid");
				loginname = (String)userSession.getUserMap().get("loginname");
				ctypetabname = (String)userSession.getUserMap().get("ctypetabname");
				officecode = (String)userSession.getUserMap().get("officecode");
			}
			
			parameters.put("edate", CHF.getDateAndTime()); 
			
			parameters.put("loginuser", loginuser);
			parameters.put("ctypetabname", ctypetabname);
			parameters.put("officecode",officecode);
			parameters.put("loginname",loginname);
			
			String nid = CHF.showNull((String)parameters.get("trainingid"));
			String table = "b_training";
			conn  = new DBConnect().getConnect();
			
			TrainingService ts = new TrainingService(conn);
			String loginid = (String)parameters.get("loginid");
			String trainingid = (String)parameters.get("trainingid");
			
			
			String orderId = (String)parameters.get("orderid");
			
			ts.del( loginid, trainingid ,table);//删除原来的报名
			
			OrderService orderService = new OrderService(conn);
			orderService.remove(orderId);	//删除订单
			
			orderId = orderService.getOrderId();
			
			parameters.put("orderid", orderId);
			
			String result = ts.savePerson( table, parameters) ;//保存
			
			
			Order order = orderService.getOrder(orderId);
			
			Map map = ts.get(table, trainingid, loginid,ctypetabname);
			modelAndView.addObject("map", map);
			modelAndView.addObject("order", order);
			modelAndView.addObject("orderId", orderId);
			modelAndView.addObject("result", result);
			
			// 广东省注协自助会员机链接入口
			if("hyj_kqpxb".equalsIgnoreCase(source)){
				response.sendRedirect(request.getContextPath()+"/common/certificateReceipt.do?method=receiptListFromHYJ&loginId="+loginuser+"&ctypetabname="+ctypetabname);
			}else{
				response.sendRedirect(request.getContextPath()+"/common/certificateReceipt.do?method=receiptList&loginid="+loginuser+"&ctypetabname="+ctypetabname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
		//return modelAndView;
	}
	

	/**
	 * 参加/不参加
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView isJoin(HttpServletRequest request,HttpServletResponse response) {
		ASFuntion af = new ASFuntion();
		Connection conn = null;
		String id = af.showNull(request.getParameter("id"));
		String isJoin = af.showNull(request.getParameter("isJoin"));
		String notJoinReason = af.showNull(request.getParameter("notJoinReason"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " update k_TesterComposition set isJoin=?,notJoinReason=? where id = ? ";
			Object[] obj = null;
			if("YES".equalsIgnoreCase(isJoin)){
				obj = new Object[]{"参加","",id};
			}else{
				obj = new Object[]{"不参加",notJoinReason,id};
			}
			
			// 修改
			new DbUtil(conn).executeUpdate(sql,obj);
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.print("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 座位号查询
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView indexSeatNoSearch(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LISTSEATNO);
		String loginId = request.getParameter("loginId");
		String userType = request.getParameter("userType");
		try {
			String sql = "";
			// 注师用户
			if("zs_".equals(userType)){
				sql = " select a.id as aid,b.id as bid,trainingname,tid,tname,seatno,trainingbdate,trainingedate " 
					+ " from b_training a left join b_enroll b " 
					+ " on a.id = b.trainingid "
					+ " where tid = '"+loginId+"' and len(seatno)>0 ${cpa} ${trainingname} ${seatno} ";
			}else{
				sql = " select a.id as aid,b.id as bid,trainingname,tid,tname,seatno,trainingbdate,trainingedate " 
					+ " from b_training a left join b_enroll b " 
					+ " on a.id = b.trainingid "
					+ " where len(seatno)>0 ${cpa} ${trainingname} ${seatno} ";
			}
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.addSqlWhere("cpa"," and (tid like '%${cpa}%' or tName like '%${cpa}%' ) ") ;
			pp.addSqlWhere("trainingname"," and trainingname like '%${trainingname}%' ") ;
			pp.addSqlWhere("seatno"," and seatno like '%${seatno}%' ") ;
			
			pp.setTitle("座位号信息：(已经参加过的培训班)");
			
			pp.setTableID("seatNoList");

			pp.addColumn("姓名", "tname","showCenter");
			pp.addColumn("培训班名称", "trainingname","showCenter");
			pp.addColumn("座位号", "seatno","showCenter");
			pp.addColumn("培训开始日期", "trainingbdate","showCenter");
			pp.addColumn("培训结束日期", "trainingedate","showCenter");
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("trainingbdate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		
		// 培训班名称
		setTrainingNameList(request,response,model);
		
		return model;
	}
	
	
	/**
	 * 考勤查询
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView kqSearch(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(KQLIST);
		String loginId = request.getParameter("loginId");
		try {
			String sql = " select * from (" 
					   + " Select a.sDate,a.seDate,(a.sDate+' '+a.sbDate) as startTime,b.checktime,t.trainingname, "
					   + " Case When b.checktime is null Then '未考勤' "
					   + " When b.checktime>a.sDate+ ' ' +a.seDate Then '迟到' " 
					   + " else '正常' end as isDelay,b.loginid,b.loginname "
					   + " From workTime a left join working b "
					   + " on a.TrainingID=b.TrainingID and a.sID=b.TimeID and b.loginid = '"+loginId+"' "
					   + " left join b_training t on a.trainingid = t.id ) a "
					   + " where 1=1 ${trainingname} ${isDelay} ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.addSqlWhere("trainingname"," and trainingname like '%${trainingname}%' ") ;
			pp.addSqlWhere("isDelay"," and isDelay = '${isDelay}' ") ;
			
			pp.setTitle("考勤信息");
			
			pp.setTableID("kqList");

			pp.addColumn("培训班名称", "trainingname","showCenter");
			pp.addColumn("开始考勤时间", "startTime","showCenter");
			pp.addColumn("本次考勤时间", "checktime","showCenter");
			pp.addColumn("考勤情况", "isDelay","showCenter");
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("trainingname");
			pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		
		// 培训班名称
		setTrainingNameList(request,response,model);
		
		return model;
	}
	
	
	/**
	 * 自助机：是否到了退出时间
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView checkExit(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String trainingid = af.showNull(request.getParameter("trainingid"));
		String nowTime = af.getCurrentTime();
		String nowDate = af.getCurrentDate();
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " Select sid From ( select top 1 * from worktime " 
					   + " Where trainingid=? and sDate=? order by sAutoCloseTime desc ) a  " 
					   + " where a.sbDate<? and a.sAutoCloseTime<?  ";
			String rs = af.showNull(new DbUtil(conn).queryForString(sql, new Object[]{trainingid,nowTime,nowTime,nowDate}));
			System.out.println("trainingid="+trainingid+"nowTime="+nowTime+"nowDate="+nowDate+"rs="+rs+"sql="+sql);
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("exit");
			}else{
				out.print("notexit");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	/**
	 * 自助机：自动退出
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView exit_hyj(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String time = af.getDateAndTime1();
		String id = UUID.randomUUID()+"";
		try {
			conn = new DBConnect().getConnect();
			String sql = " insert into m_selfexit(id,propertys,operationTime) values(?,?,?) ";
			System.out.println("exit_hyj    sql="+sql);
			new DbUtil(conn).executeUpdate(sql, new Object[]{id,"自助平台退出登录",time});
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 自助机：是否要退出登录
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView checkExitSelf(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " select id From m_selfexit ";
			System.out.println("checkExitSelf    sql="+sql);
			String rs = af.showNull(new DbUtil(conn).queryForString(sql));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("exit");
			}else{
				out.print("notexit");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 自助机：删除自动退出标识数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView deleteFromExit(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			String sql = " delete from m_selfexit ";
			System.out.println("deleteFromExit    sql="+sql);
			new DbUtil(conn).executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	// 获取下一天
	public String getNextDay(String time){
		String nextDate = "";
        Calendar cal = Calendar.getInstance(); 
        Date date = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        try   { 
                date   =   sdf.parse(time); 
                cal.setTime(date); 
                cal.add(cal.DATE,1); 
                nextDate = sdf.format(cal.getTime());
                System.out.println( "下一天的时间是： "   +   sdf.format(cal.getTime())); 
        }   catch   (Exception   e)   { 
                //   TODO   Auto-generated   catch   block 
                e.printStackTrace(); 
        } 
        return nextDate;
	} 
	
	
	
	/**
	 * 得到培训班
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getTrainingName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 处理ajax返回中文出现乱码问题
		response.setContentType("text/html;charset=UTF-8");
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		PrintWriter out  = response.getWriter() ;
		String ctypeTabName = CHF.showNull(request.getParameter("ctypeTabName"));
		try {
			conn = new DBConnect().getConnect();
			
			if(!"k_cicpa".equalsIgnoreCase(ctypeTabName)){
				sql = " select trainingname from b_training where enrollbdate<=convert(Varchar(10),getdate(),120) " 
					+ " and convert(Varchar(10),getdate(),120)<trainingedate "
					+ " order by trainingbdate desc ";
			}else{
				sql = " select trainingname from b_training order by trainingbdate desc ";
			}
			
			System.out.println("ctypeTabName="+ctypeTabName);
			System.out.println("sql="+sql);
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();

			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getString("trainingname"));
			}
			
			// 去除重复元素
			Set set = new HashSet();
			List newList = new ArrayList();
			for(Iterator iter = list.iterator();iter.hasNext();){
				Object element = iter.next();
		        if(set.add(element)){
		           newList.add(element);
		        };
		    } 
		    list.clear();
		    list.addAll(newList);
			
			String json = JSONArray.fromObject(list).toString();
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
	 * 得到培训班
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView setTrainingNameList(HttpServletRequest request,
			HttpServletResponse response,ModelAndView model) {
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		String ctypeTabName = CHF.showNull(request.getParameter("ctypeTabName"));
		try {
			conn = new DBConnect().getConnect();
			
			if(!"k_cicpa".equalsIgnoreCase(ctypeTabName)){
				sql = " select trainingname from b_training where enrollbdate<=convert(Varchar(10),getdate(),120) " 
					+ " and convert(Varchar(10),getdate(),120)<trainingedate "
					+ " order by trainingbdate desc ";
			}else{
				sql = " select trainingname from b_training order by trainingbdate desc ";
			}
			
			System.out.println("ctypeTabName="+ctypeTabName);
			System.out.println("sql="+sql);
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();

			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getString("trainingname"));
			}
			
			// 去除重复元素
			Set set = new HashSet();
			List newList = new ArrayList();
			for(Iterator iter = list.iterator();iter.hasNext();){
				Object element = iter.next();
		        if(set.add(element)){
		           newList.add(element);
		        };
		    } 
		    list.clear();
		    list.addAll(newList);
		    
			model.addObject("trainNameList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	public ModelAndView networkSchool(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(NETWORKSCHOOLLIST);
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = new DBConnect().getConnect();
			DbUtil dbut=new DbUtil(conn);
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			Map umap=userSession.getUserMap();
			String loginid = (String)umap.get("loginid");
			
		
			
			TrainingService ts=new TrainingService(conn);
			String netschools=ts.netSchList(loginid);
			
			modelAndView.addObject("netschools", netschools);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}	
		return modelAndView;
		
	}
	/**
	 * 判断是否已经报名了 ，如果是则不能继续报名，否则添加报名记录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView netSchoolCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String now=af.getDateAndTime1();
		PrintWriter out = null ;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sid = af.showNull(request.getParameter("sid"));
			conn = new DBConnect().getConnect();
			DbUtil dbut=new DbUtil(conn);
			response.setContentType("text/html;charset=UTF-8") ;
			Map<String,String> mrs=new HashMap<String,String>();
			out=response.getWriter();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map umap=userSession.getUserMap();
			String loginid = (String)umap.get("loginid");
			String loginname = (String)umap.get("loginname");
			String crsa = (String)umap.get("crsa");
			
			
			
			String sql = "select b.netSchoolname from  k_netSchoolrecord a,k_netSchool b where a.netSchoolid=b.uuid and a.loginid =? and SUBSTRING(a.applytime,1,4)='"+DateUtil.getDate("yyyy")+"'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginid);
			//ps.setString(2, loginid);
			rs=ps.executeQuery();
			
			//已经报名了网校
			if(rs.next()){
				mrs.put("state", "exist");
				String Schooltype=rs.getString(1);
				if(sid.equals(Schooltype)){
					mrs.put("msg", "您已经报名了，不能重复报名！");
				}else{
					mrs.put("msg", "您已经报名了"+Schooltype+"，不能报名该网校！");
				}
				
			}else{
				
				/*sql="select checkrule from k_netSchool where uuid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sid);
				rs=ps.executeQuery();
				if(rs.next()){
					umap.put("checkcode", MD5.getMD5String(loginid+loginname+rs.getString(1)));
				}*/
				umap.put("uuid", UUID.randomUUID().toString());
				umap.put("applytime", now);
				umap.put("netschoolid", sid);
				umap.put("certificateno", loginid);
				int rrs=dbut.insertInfo("k_netSchoolrecord","uuid,loginid,loginname,applytime,netschoolid,certificateno", umap);
				if(rrs>0){
					mrs.put("state", "succeed");
					mrs.put("msg", "报名成功！");
				}else{
					mrs.put("state", "error");
					mrs.put("msg", "报名出错了！请稍后重试");
					
				}
			}
			String json=JSONObject.fromObject(mrs).toString();
			out.write(json);
		} catch (Exception e) {
			e.printStackTrace();
			out.write("error");
		}finally{
			out.close();
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		
		return null;
		
	}
	/**
	 * 判断是否已经报名了 ，如果是则不能继续报名，否则添加报名记录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView netSchoolRepareCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String now=af.getDateAndTime1();
		PrintWriter out = null ;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sid = af.showNull(request.getParameter("sid"));
			conn = new DBConnect().getConnect();
			DbUtil dbut=new DbUtil(conn);
			response.setContentType("text/html;charset=UTF-8") ;
			Map<String,String> mrs=new HashMap<String,String>();
			out=response.getWriter();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map umap=userSession.getUserMap();
			String loginid = (String)umap.get("loginid");
			String loginname = (String)umap.get("loginname");
			String crsa = (String)umap.get("crsa");
			String year= af.showNull(request.getParameter("year"));
			
			
			String sql = "select b.netSchoolname,a.isrepare,b.uuid from  k_netSchoolrecord a,k_netSchool b where a.netSchoolid=b.uuid and a.loginid =? and SUBSTRING(a.applytime,1,4)='"+year+"'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginid);
			//ps.setString(2, loginid);
			rs=ps.executeQuery();
			
			//已经报名过了网校（不能补考）
			if(rs.next()){
				String Schooltype=rs.getString(1);
				String Schoolid=rs.getString(3);
				if("是".equals(rs.getString(2))){
					if(sid.equals(Schoolid)){
						mrs.put("state", "go");
						//进入学习
						
					}else{
						mrs.put("state", "existR");
						mrs.put("msg", "您已经报名了"+Schooltype+"，不能从该网校补充学时！");
					}
				}else{
					mrs.put("state", "exist");
					mrs.put("msg", year+"年，您已经报名了"+Schooltype+"，不能继续补充学时！");
				}
			}else{
				
				/*sql="select checkrule from k_netSchool where uuid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sid);
				rs=ps.executeQuery();
				if(rs.next()){
					umap.put("checkcode", MD5.getMD5String(loginid+loginname+rs.getString(1)));
				}*/
				umap.put("uuid", UUID.randomUUID().toString());
				umap.put("applytime", year+"-12-31");//补考默认为年份最后一天
				umap.put("netschoolid", sid);
				umap.put("certificateno", loginid);
				umap.put("reparetime", now);
				umap.put("isrepare", "是");
				int rrs=dbut.insertInfo("k_netSchoolrecord","uuid,loginid,loginname,applytime,netschoolid,certificateno,reparetime,isrepare", umap);
				if(rrs>0){
					mrs.put("state", "succeed");
					mrs.put("msg", "报名学时补充成功！");
				}else{
					mrs.put("state", "error");
					mrs.put("msg", "报名出错了！请稍后重试");
					
				}
			}
			String json=JSONObject.fromObject(mrs).toString();
			out.write(json);
		} catch (Exception e) {
			e.printStackTrace();
			out.write("error");
		}finally{
			out.close();
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		
		return null;
		
	}
	
	public ModelAndView netSchInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(NETSCHOOLINFO);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			
			String sid=request.getParameter("sid");
			
			TrainingService ts=new TrainingService(conn);
			String netschinfos=ts.netSchInfo(sid);
			modelAndView.addObject("netschinfos", netschinfos);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}	
		return modelAndView;
		
	}
	public ModelAndView netSchLearn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8") ;
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter out = response.getWriter();
		try {
			String sid=request.getParameter("sid");
			conn = new DBConnect().getConnect();
			
			DbUtil dbut=new DbUtil(conn);
			ASFuntion af = new ASFuntion();
			String now=af.getDateAndTime1();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map umap=userSession.getUserMap();
			String loginid = (String)umap.get("loginid");
			String loginname = (String)umap.get("loginname");
			
			
			umap.put("uuid", UUID.randomUUID().toString());
			umap.put("netschoolid", sid);
			umap.put("logindate", now);
			umap.put("ip", Web.getIp(request));
			
			int rrs=dbut.insertInfo("k_netSchoolLoginInfo","uuid,loginid,netschoolid,logindate,ip", umap);
			
			String sql="select b.loginurl,b.checkrule from  k_netSchoolrecord a,k_netSchool b where a.netSchoolid=b.uuid and a.loginid =? and b.uuid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, sid);
			
			System.out.println("SID >> " + sid);
			Map<String,String> map = new HashMap<String,String>();
			rs=ps.executeQuery();
			if(rs.next()){
				String url=rs.getString("loginurl");
				String checkrule=rs.getString("checkrule");
				String str = loginname+loginid+checkrule+now;
				String sign=Md5.md5(str);
				
				System.out.println("URL >> " + url);
				System.out.println("checkrule >> " + checkrule);
				System.out.println("str >> " + str);
				System.out.println("sign >> " + sign);
				System.out.println("signtime >> " + now);
				
				map.put("url", url);
				map.put("name", loginname);
				map.put("certno", loginid);
				map.put("sign", sign);
				map.put("signtime", now);
			}
			
			JSONObject json = JSONObject.fromObject(map);
			System.out.println(">>>>> " +json.toString());
			out.write(json.toString());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}	
		return null;
		
	}
	
}
