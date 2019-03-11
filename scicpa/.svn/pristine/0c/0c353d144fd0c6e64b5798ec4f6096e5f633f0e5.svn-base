package cn.org.gdicpa.web.action.scoreItem;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.scoreItem.ScoreItemService;

public class ScoreItemAction extends MultiActionController{
	private final String scoreItem_list = "/scoreItem/scoreItemList.jsp";
	private final String scoreItem_detail = "/scoreItem/scoreItemDetail.jsp";
	
	/**
	 * 评分list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView scoreItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(scoreItem_list);
		try {
			
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();

			String sql = "";
			String officecode = "";
			String ctypetabname = "";
			String loginid = "";
			if(userSession != null){
				officecode = CHF.showNull((String)userSession.getUserMap().get("officecode"));
				ctypetabname = CHF.showNull((String)userSession.getUserMap().get("ctypetabname"));
				loginid = CHF.showNull((String)userSession.getUserMap().get("loginid"));
			}
			
			sql = " select * from (" 
				+ " select sy.id,sy.surname,sy.state,substring(sy.createtime,1,10) as createtime,reader, "
				+ " isview = case when r.isview ='1' then '已提交' else '未提交' end "
				+ " from b_reader r " 
				+ " inner join K_Survey sy "
				+ " on r.nid = sy.id " 
				+ " where r.source = 'K_Survey' and r.ctype='k_company' and sy.state='启用' and sy.initflag='1' and reader  = '"+loginid+"'  ) a " ;
				
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("评分项目信息");
			pp.setTableID("scoreItemList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("评分项目标题", "surname","showCenter");
			pp.addColumn("发布日期", "createtime","showCenter");
			pp.addColumn("提交状态", "isview","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <c:if test='${isview!='1'}'><a href=\"###\" onclick=\"joinScoreItem('${id}','${loginid}');\">我要参与调查</a> </div>");;
			
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("createtime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return modelAndView;
	}
	
	
	/**
	 * 评分项目详细
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goScoreItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(scoreItem_detail);
		ASFuntion af = new ASFuntion();
		String id = request.getParameter("id");
		String userType = request.getParameter("userType");
		if("".equals(userType) || null==userType){
			userType = "office";
		}
		String loginid = af.showNull(request.getParameter("loginid"));
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		if("".equals(loginid) ){
			if(userSession != null){
				loginid = af.showNull((String)userSession.getUserMap().get("loginid"));
			}
		}
		
		
		Connection conn = null ;
		try {

			conn = new DBConnect().getConnect();
			ScoreItemService sis = new ScoreItemService(conn) ;
			
			// 问卷标题和说明
			String sql = " select surname,remark from K_Survey where id = '"+id+"'";
			System.out.println("问卷标题和说明 SQL : " + sql);
			Map map = sis.getMapInfoBySql(sql);
			System.out.println("MAP : " + map);
			
			
			// 每一个类型的总分数和总题目数
			sql = " select typedetail,count(typedetail) counts,sum(cast(si.score as float)) as scoretotal " 
				+ " from K_SurveyDetail sd " 
				+ " left join b_scoreitem si on sd.itemid = si.id "
				+ " where mainid = '"+id+"' group by typedetail ";
			
			System.out.println("每一个类型的总分数和总题目数 SQL : " + sql);
			List typeList = sis.getListBySql(sql);
			
			// 评分项目信息
			String allSql = " select sd.mainid,si.id,s.typeid,sd.TypeDetail,s.surname,s.state,si.question,si.Score, " 
						  + " sd.sequence,std.TypeName,si.score1,si.score2,si.score3,std.initflag,sd.initflag as typesequence "
						  + " from K_Survey s "
						  + " left join K_SurveyDetail sd on s.id = sd.mainid "  
						  + " left join (select si.id,si.question,si.Score,sc.score1,sc.score2,sc.score3,sc.loginid  from " 
						  + " b_ScoreItem si left join b_Score sc on sc.itemid = si.id and sc.loginid = '"+loginid+"') si on sd.itemid = si.id "
						  + " left join (K_Survey k inner join K_SurveyTypeDetail std on k.TypeID=std.MainID) "
						  + " on sd.MainID=k.ID and sd.TypeDetail=std.ID "
						  + " where s.id = '"+id+"' order by sd.Sequence asc  " ;
			
			System.out.println("评分项目信息 SQL : " + allSql);
			
			List allList = sis.getListBySql(allSql);
			
			System.out.println("allSql="+allSql);
			
			model.addObject("userType", userType);
			model.addObject("surname", map.get("surname"));
			model.addObject("remark", map.get("remark"));
			model.addObject("typeList", typeList);
			model.addObject("allList", allList);
			model.addObject("k_survey_id", id);
			model.addObject("loginid", loginid);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);

		}
		return model;
	}
	
	
	
	
	
	/**
	 * 保存评分
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveScoreItemAnswer(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ;
		
		// id(主键),mainid(问卷Id),itemId(题目Id),loginid,loginname,
		// score1(事务所评分),score2(市注协评分),score3(省注协评分),surveyTime(当前时间)
		
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		try {
			conn = new DBConnect().getConnect();
			
			
			// 试卷编号
			String mainid = request.getParameter("surveyid");
			// 用户类型
			String userType = request.getParameter("userType");
			String loginid = request.getParameter("loginid");
			String loginname = request.getParameter("loginname");
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			if("".equals(loginid) ){
				if(userSession != null){
					loginid = af.showNull((String)userSession.getUserMap().get("loginid"));
					loginname = af.showNull((String)userSession.getUserMap().get("loginname"));
				}
			}
			
			String surveyTime = af.getDateAndTime1();
			String scoreTemp = "";
			
			ScoreItemService sis = new ScoreItemService(conn);
			
			String sql = " select itemId from K_SurveyDetail where mainid = '"+mainid+"' ";
			
			// 找出该问卷下的所有题目 Id
			List list = sis.getListBySql(sql); 
			
			// 该 事务所 用户是否已经进行过评分了
			sql = " select id from b_Score where mainid = ? and loginid = ? ";
			DbUtil db = new DbUtil(conn);
			String score_id = db.queryForString(sql, new Object[]{mainid,loginid}) + "";
			
			// 非 事务所用户
			if(!"office".equalsIgnoreCase(userType)){
				// 用户名称
				sql = " select loginname from k_user where loginid = ? ";
				loginname = db.queryForString(sql, new Object[]{loginid}) + "";
			}
			
			
			Enumeration enum1 = request.getParameterNames();
			
			String paramName = "";
			String paramValue[] = null;
			 
			while (enum1.hasMoreElements()) {
				paramName = enum1.nextElement() + "";
				
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Map m = (Map) iterator.next();
					if(paramName.equals(m.get("itemid"))){
						scoreTemp = request.getParameter(paramName);
						// 存在记录就修改
						if(!"".equals(score_id) && !"null".equals(score_id)){
							if("office".equalsIgnoreCase(userType)){
								sql = " update b_Score set score1=? where itemId=? and loginid = ?";
							}else if("city".equalsIgnoreCase(userType)){
								sql = " update b_Score set score2=? where itemId=? and loginid = ?";
							}else{
								sql = " update b_Score set score3=? where itemId=? and loginid = ?";
							}
							db.executeUpdate(sql, new Object[]{scoreTemp,paramName,loginid});
						}else{
							sql = " insert into b_score(id,mainid,itemid,loginid,loginname,score1,surveyTime) " 
								+ " values(?,?,?,?,?,?,?)";
							String uuid = UUID.randomUUID().toString();
							db.executeUpdate(sql, new Object[]{uuid,mainid,paramName,loginid,loginname,scoreTemp,surveyTime});
						}
						
					}
				}
			}
			
			// 更改状态
			new DbUtil(conn).executeUpdate("update  b_reader set isview = '1',viewTime=? where reader=? and source=? and nid=? ", 
					new Object[]{af.getCurrentDate()+" "+af.getCurrentTime(),loginid,"k_survey",mainid});
			
			out.write("<script>");
			out.write("	alert(\" 提交成功! \");");
			if("office".equalsIgnoreCase(userType)){
				out.write("	window.opener.location.reload();window.close();");
			}else{
				out.write("	window.location=\"scoreItem.do?method=goSucess\";");
			}
			out.write("</script>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	public ModelAndView goSucess(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("/surveyItem/sucess.jsp");
	}
	
}
