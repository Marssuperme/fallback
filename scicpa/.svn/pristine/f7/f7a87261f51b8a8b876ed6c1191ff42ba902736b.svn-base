package cn.org.gdicpa.web.action.surveyItem;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.HashMap;
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
import cn.org.gdicpa.web.service.surveyItem.SurveyItemService;

public class SurveyItemAction extends MultiActionController{
	private final String surveyItem_list = "/surveyItem/surveyItemList.jsp";
	private final String surveyItem_detail = "/surveyItem/surveyItemDetail.jsp";
	
	/**
	 * 问卷list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView surveyItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(surveyItem_list);
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
				// + " left join K_SurveyType st on st.id = sy.typeid "
				+ " where r.source = 'K_Survey' and r.ctype='k_company' and sy.state='启用' and sy.initflag='0' and reader  = '"+loginid+"'  ) a " ;
				
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("问卷信息");
			pp.setTableID("surveyItemList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("问卷标题", "surname","showCenter");
			//pp.addColumn("问卷类型", "typename","showCenter");
			pp.addColumn("发布日期", "createtime","showCenter");
//			pp.addColumn("问卷状态", "state","showCenter");
			pp.addColumn("提交状态", "isview","showCenter");
			pp.addColumn("操作", "id").setColContent(" <div style='text-align: center;'> <a href=\"###\" onclick=\"joinSurveyItem('${id}','${loginid}');\">我要参与调查</a> </div>");;
			
//			pp.setColumnWidth("150,50,20,10,10,50,10");
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
	 * 问卷调查详细
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goSurveyItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(surveyItem_detail);
		
		String id = request.getParameter("id");
		
		Connection conn = null ;
		try {

			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			ASFuntion CHF=new ASFuntion();
			Map userMap = userSession.getUserMap();
			
			conn = new DBConnect().getConnect();
			SurveyItemService sis = new SurveyItemService(conn) ;
			
			//取得问卷信息
			List surveyItemList = sis.getSurveyItemDetails(id,userMap) ;   
			
			// 问卷标题和说明
			String sql = " select surname,remark from K_Survey where id = '"+id+"'";
			Map map = sis.getMapInfoBySql(sql);
			
			// 大类
			String typeSql = " select std.initflag,std.typename from K_Survey  s "
						   + " left join K_SurveyTypeDetail std "
						   + " on s.typeid = std.mainid "
						   + " where s.id = '"+id+"' order by std.initflag " ;
			
			List typeList = sis.getListBySql(typeSql);
			System.out.println("typeList.size()typeList.size()="+typeList.size());
			
			model.addObject("k_survey_id", id);
			
			model.addObject("typeList", typeList);
			model.addObject("titleOptionsList", surveyItemList);
			
			model.addObject("map", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);

		}
		return model;
	}
	
	
	/**
	 * 将考生答案保存起来
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveSurveyItemAnswer(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ;
		
		// id(主键) surveyid(试卷编号) surveyItemId(题目编号) surveyItemDetailid(答案编号) Sequence(答案序号)  answerContents(答案内容) 
		// answerByUserId(作答人编号) answerByUserName(作答人名称)  answerTime(作答时间)   initFlag       TimeFlag
		
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		try {
			conn = new DBConnect().getConnect();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			
			// 试卷编号
			String surveyid = request.getParameter("surveyid");
			String answerByUserId = map.get("loginid").toString();
			String answerByUserName = map.get("loginname").toString();
			String answerTime = af.getDateAndTime1();
			
			
			map.put("surveyid", surveyid);
			map.put("answerbyuserid", answerByUserId);
			map.put("answerbyusername", answerByUserName);
			map.put("answertime", answerTime);
			
			
			SurveyItemService sis = new SurveyItemService(conn);
			
			Enumeration enum1 = request.getParameterNames();
			
			String paramName = "";
			String paramValue[] = null;
			 
			// 删除 该用户 所操作的这张试卷
			sis.delSurveyItem(surveyid, answerByUserId);
			
			String sequence = "-1";
			while (enum1.hasMoreElements()) {// 遍历整页试卷，更新对应序号的考生答案
				paramName = (String) enum1.nextElement();
				paramValue = request.getParameterValues(paramName);
				
				if("填空题".equals(paramName.substring(paramName.indexOf("_**_")+4))){
					String lastValue = "";
					for (int j = 0; j < paramValue.length; j++) {
						lastValue = lastValue + paramValue[j] + "&@&";
					}
					
//					map.put("siid", paramName.substring(0,paramName.indexOf("_**_")));
					map.put("siid", paramName.substring(0,paramName.indexOf("_@_")));
					map.put("answercontents", lastValue);
					map.put("sequence",paramName.substring(paramName.indexOf("_@_")+3,paramName.indexOf("_**_")));
					
					map.put("id", UUID.randomUUID().toString());
					sis.saveSurveyItem(map);
				}else{
					for (int i = 0; i < paramValue.length; i++) {
						System.out.println("-----paramValue:"+paramValue[i]+"     i="+i+"     paramName="+paramName);
						if(!"surveyid".equalsIgnoreCase(paramName) && !"loginid".equalsIgnoreCase(paramName) 
								&& !"loginname".equalsIgnoreCase(paramName) && !"method".equalsIgnoreCase(paramName)
								&& !"tempSeq".equalsIgnoreCase(paramName) ){
							
							// 如果 name 属性里面 有 seq 就 用 name 里面的 seq
							if(paramName.indexOf("_**_")>-1){
								sequence = paramName.substring(paramName.indexOf("_**_")+4);
								paramName = paramName.substring(0,paramName.indexOf("_**_"));
							}else{
								if(paramValue[i].indexOf("_**_")>-1){
									sequence = paramValue[i].substring(paramValue[i].indexOf("_**_")+4);
									paramValue[i] = paramValue[i].substring(0,paramValue[i].indexOf("_**_"));
								}
							}
							
							map.put("siid", paramName);
							map.put("answercontents", paramValue[i]);
							map.put("sequence", sequence);
							
							map.put("id", UUID.randomUUID().toString());
							
							if(!"".equals(paramValue[i]) && paramValue[i]!=null){
								sis.saveSurveyItem(map);
							}
						}
						
					}
				}
			}
			
			// 更改状态
			new DbUtil(conn).executeUpdate("update  b_reader set isview = '1',viewTime=? where reader=? and source=? and nid=? ", 
					new Object[]{af.getCurrentDate()+" "+af.getCurrentTime(),answerByUserId,"K_Survey",surveyid});
			
			out.write("<script>");
			out.write("	alert(\" 提交成功! \");");
			out.write("	window.opener.location.reload();window.close();");
			out.write("</script>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	/**
	 * 市注协或省注协不登陆 进入到 问卷调查详细
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	public ModelAndView goSurveyItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(surveyItem_detail);
		
		
		String opt = request.getParameter("opt");
		String surveyId = request.getParameter("surveyId");
		String loginId = request.getParameter("loginId");
		String loginName = request.getParameter("loginName");
		
		Connection conn = null ;
		try {

			Map userMap = new HashMap();
			userMap.put("loginid", loginId);
			userMap.put("loginname", loginName);
			
			conn = new DBConnect().getConnect();
			SurveyItemService sis = new SurveyItemService(conn) ;
			
			//取得问卷信息
			List surveyItemList = sis.getSurveyItemDetails(surveyId,userMap) ;   
			
			// 问卷标题和说明
			String sql = " select surname,remark from K_Survey where id = '"+surveyId+"'";
			Map map = sis.getMapInfoBySql(sql);
			
			// 大类
			String typeSql = " select std.initflag,std.typename from K_Survey  s "
						   + " left join K_SurveyTypeDetail std "
						   + " on s.typeid = std.mainid "
						   + " where s.id = '"+surveyId+"' order by std.initflag " ;
			
			List typeList = sis.getListBySql(typeSql);
			
			model.addObject("opt", opt);
			model.addObject("k_survey_id", surveyId);
			model.addObject("loginid", loginId);
			model.addObject("loginname", loginName);
			
			model.addObject("typeList", typeList);
			model.addObject("titleOptionsList", surveyItemList);
			
			model.addObject("map", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);

		}
		return model;
	}
	
	
	/**
	 * 市注协或省注协不登陆 将 答案保存起来
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveSurveyItemAnswers(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ;
		
		// id(主键) surveyid(试卷编号) surveyItemId(题目编号) surveyItemDetailid(答案编号) Sequence(答案序号)  answerContents(答案内容) 
		// answerByUserId(作答人编号) answerByUserName(作答人名称)  answerTime(作答时间)   initFlag       TimeFlag
		
		Connection conn = null;
		PreparedStatement ps = null;
		ASFuntion af = new ASFuntion();
		try {
			conn = new DBConnect().getConnect();
			
			Map map = new HashMap();
			
			// 试卷编号
			String surveyid = request.getParameter("surveyid");
			String answerByUserId = request.getParameter("loginid");
			// String answerByUserName = request.getParameter("loginname");
			String answerByUserName = new DbUtil(conn).queryForString(" select loginname from k_user where loginid = ? ",new Object[]{answerByUserId});
			
			String answerTime = af.getDateAndTime1();
			
			map.put("surveyid", surveyid);
			map.put("answerbyuserid", answerByUserId);
			map.put("answerbyusername", answerByUserName);
			map.put("answertime", answerTime);
			
			
			SurveyItemService sis = new SurveyItemService(conn);
			
			Enumeration enum1 = request.getParameterNames();
			
			String paramName = "";
			String paramValue[] = null;
			 
			// 删除 该用户 所操作的这张试卷
			sis.delSurveyItem(surveyid, answerByUserId);
			
			String sequence = "-1";
			while (enum1.hasMoreElements()) {// 遍历整页试卷，更新对应序号的考生答案
				paramName = (String) enum1.nextElement();
				paramValue = request.getParameterValues(paramName);
				
				if("填空题".equals(paramName.substring(paramName.indexOf("_**_")+4))){
					String lastValue = "";
					for (int j = 0; j < paramValue.length; j++) {
						lastValue = lastValue + paramValue[j] + "&@&";
					}
					
					map.put("siid", paramName.substring(0,paramName.indexOf("_**_")));
					map.put("answercontents", lastValue);
					map.put("sequence","1");
					
					map.put("id", UUID.randomUUID().toString());
					sis.saveSurveyItem(map);
				}else{
					for (int i = 0; i < paramValue.length; i++) {
						System.out.println("-----paramValue:"+paramValue[i]+"     i="+i+"     paramName="+paramName);
						if(!"surveyid".equalsIgnoreCase(paramName) && !"loginid".equalsIgnoreCase(paramName) 
								&& !"loginname".equalsIgnoreCase(paramName) && !"method".equalsIgnoreCase(paramName)
								&& !"tempSeq".equalsIgnoreCase(paramName) ){
							
							// 如果 name 属性里面 有 seq 就 用 name 里面的 seq
							if(paramName.indexOf("_**_")>-1){
								sequence = paramName.substring(paramName.indexOf("_**_")+4);
								paramName = paramName.substring(0,paramName.indexOf("_**_"));
							}else{
								if(paramValue[i].indexOf("_**_")>-1){
									sequence = paramValue[i].substring(paramValue[i].indexOf("_**_")+4);
									paramValue[i] = paramValue[i].substring(0,paramValue[i].indexOf("_**_"));
								}
							}
							
							map.put("siid", paramName);
							map.put("answercontents", paramValue[i]);
							map.put("sequence", sequence);
							
							map.put("id", UUID.randomUUID().toString());
							
							if(!"".equals(paramValue[i]) && paramValue[i]!=null){
								sis.saveSurveyItem(map);
							}
						}
						
					}
				}
			}
			
			// 更改状态
			new DbUtil(conn).executeUpdate("update  b_reader set isview = '1',viewTime=? where reader=? and source=? and nid=? ", 
					new Object[]{af.getCurrentDate()+" "+af.getCurrentTime(),answerByUserId,"K_Survey",surveyid});
			
			out.write("<script>");
			out.write("	alert(\" 提交成功! \");");
			out.write("	window.location=\"surveyItem.do?method=goSucess\";");
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
