package cn.org.gdicpa.web.action.policy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//import cn.org.gdicpa.web.action.record.RecordAction;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.pub.util.diff_match_patch;
import cn.org.gdicpa.web.pub.util.diff_match_patch.Diff;
import cn.org.gdicpa.web.service.policy.PolicyService;
import cn.org.gdicpa.web.service.policy.model.Policy;
import cn.org.gdicpa.web.service.policy.model.PolicyCheck;
import cn.org.gdicpa.web.service.question.QuestionService;
import cn.org.gdicpa.web.service.question.model.Question;
import cn.org.gdicpa.web.service.toHTML.ToHTML;

public class PolicyAction extends MultiActionController {
	private final static String MAIN_VIEW = "/Policy/main.jsp";
	private final static String VIEW = "/Policy/view.jsp";
	private final static String OAVIEW = "/Policy/oaView.jsp";
	private final static String SEARCH_VIEW = "/Policy/search.jsp";
	private final static String UPDATE_VIEW = "/Policy/add.jsp";
	private final static String AUDITLIST_VIEW = "/Policy/auditList.jsp";
	
	public ModelAndView getTree(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			conn = new DBConnect().getConnect();
			String id = request.getParameter("id");
			if (id == null || "".equals(id)) {
				id = "00";
			}
			List list = new PolicyService(conn).getTypeTree(id);
			String treeStr = JSONArray.fromObject(list).toString();
			System.out.println(treeStr);
			response.getWriter().write(treeStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}

	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			String title = StringUtil.showNull(request.getParameter("title"));
			String sendDepartment = StringUtil.showNull(request
					.getParameter("sendDepartment"));
			String wordNum = StringUtil.showNull(request
					.getParameter("wordNum"));
			String content = StringUtil.showNull(request
					.getParameter("content"));

			Policy policy = new Policy();
			policy.setTitle(title);
			policy.setSendDepartment(sendDepartment);
			policy.setWordNum(wordNum);
			policy.setContent(content);

			PolicyService ps = new PolicyService(conn);
			ps.addPolicy(policy);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}

	public ModelAndView addView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(UPDATE_VIEW);
		String typeId = StringUtil.showNull(request.getParameter("typeId"));

		// 找到对应发文的单位
		UserSession userSession = (UserSession) request.getSession()
				.getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String) map.get("loginid");
		String loginname = (String) map.get("loginname");
		Policy policy = new Policy();
		policy.setSendDepartment(loginname);

		modelAndView.addObject("policy", policy);
		modelAndView.addObject("typeId", typeId);
		return modelAndView;
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		ModelAndView modelAndView = new ModelAndView(MAIN_VIEW);
		
		try {
			conn = new DBConnect().getConnect();
			// String sql =
			// "select id,wordNum,sendDate,sendDepartment,title,content,validityStatus,viewCount,c.loginName "
			// +" from  p_policy a left join ("
			// +" 	select a.updateUserId,a.policyId from p_policy_check a,("
			// +" 		select max(updateDate) as updateDate,policyId from p_policy_check where state='1' group by policyId"
			// +" 	) b where a.updateDate = b.updateDate and a.policyId = b.policyId"
			// +" ) b on a.id = b.policyId "
			// +" left join k_user c  on c.loginId = b.updateUserId where 1=1 ${fullPath}";
			String sql = "select '<div id=jiantiaoid>\032</div>' as jiantiao, id,wordNum,sendDate,sendDepartment,title,content,validityStatus,viewCount,c.loginName,levelEffect  from  p_policy a left join ( \tselect a.updateUserId,a.policyId from p_policy_check a,( \t\tselect max(updateDate) as updateDate,policyId from p_policy_check where state='1' group by policyId \t) b where a.updateDate = b.updateDate and a.policyId = b.policyId ) b on a.id = b.policyId  left join k_user c  on c.loginId = b.updateUserId where 1=1 ${fullPath}";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,
						HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					Connection conn = null;
					try {
						conn = new DBConnect().getConnect();
						String fullPath = getRequestValue("fullPath");
						
//						String typeId = fullPath.substring(fullPath.lastIndexOf('|')+1, fullPath.length());						
//						modelAndView.addObject("typeId1", typeId);
//						System.out.println("------------------------------------------------分类全ID："+fullPath);
//						System.out.println("------------------------------------------------ID："+typeId);
						
						if (fullPath == null || "".equals(fullPath)) {
							fullPath = "";
						} else {
							PolicyService ps = new PolicyService(conn);
							String typeIds = ps.getPolicyTypeIds(fullPath);
							if (!"".equals(typeIds)) {
								// 88888 按照地域性分类
								if (fullPath.indexOf("88888|") >= 0) {
									fullPath = " and id in (select policyId from p_policyAndType where typeId in ("
											+ typeIds
											+ ")) or wkid = '"
											+ typeIds + "'  ";
								} else {
									fullPath = " and id in (select policyId from p_policyAndType where typeId in ("
											+ typeIds
											+ ")) or wkid in ("
											+ typeIds + ")  ";
								}
							} else {
								fullPath = "";
							}
						}
						this.setOrAddRequestValue("fullPath", fullPath);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DbUtil.close(conn);
					}
				}
			};
			pp.addSqlWhere("fullPath", "${fullPath}");
			pp.setTableID("policyList");
			pp.setWhichFieldIsValue(1);

		//	pp.addColumn("", "jiantiao");
			pp.addColumn("标题", "title").setTdProperty(	" onclick='view(\"${id}\");'");
			pp.addColumn("发布日期", "sendDate");
			pp.addColumn("发文机关", "sendDepartment");
			pp.addColumn("效力状态", "validityStatus", "showCenter");
			//pp.addColumn("最后维护人", "loginName");

			// pp.setColumnWidth("50,70,70,80");
			//pp.setColumnWidth("1%,49%,10%,20%,10%,10%");
			pp.setColumnWidth("49%,10%,20%,10%");
			pp.setSQL(sql);
			pp.setOrderBy_CH("sendDate");
			pp.setDirection("desc");
			request.getSession().setAttribute(
					DataGrid.sessionPre + pp.getTableID(), pp);
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("userSession");

			boolean isCicpa = "k_cicpa".equals(((String) userSession
					.getUserMap().get("ctypetabname")).toLowerCase());
			modelAndView.addObject("isCicpa", isCicpa);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}

	public ModelAndView auditList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		ModelAndView modelAndView = new ModelAndView(AUDITLIST_VIEW);
		try {
			conn = new DBConnect().getConnect();
			String sql = "select * from (select a.id,a.title,a.updateDate,loginName,a.state from p_policy_check a left join p_policy b on a.policyId = b.id"
					+ " left join k_user c on a.updateUserId = c.loginId where (a.state = '' or a.state is null)) a";

			DataGridProperty pp = new DataGridProperty();
			pp.setTableID("auditPolicyList");
			pp.setWhichFieldIsValue(1);
			pp.addColumn("标题", "title").setTdProperty(	" onclick='audit(\"${id}\");'");
			pp.addColumn("修改日期", "updateDate");
			pp.addColumn("修改人", "loginName");
			pp.setColumnWidth("350,70,70");
			pp.setSQL(sql);
			pp.setOrderBy_CH("updateDate,id");
			pp.setDirection("desc,desc");
			request.getSession().setAttribute(
					DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}

	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		ModelAndView modelAndView = new ModelAndView(VIEW);
		
		
		try {
			conn = new DBConnect().getConnect();
			String pId = request.getParameter("id");

			System.out.println("-----------------------测试：" + pId);

			PolicyService ps = new PolicyService(conn);
			Policy policy = ps.getPolicy(pId);

			//行业分类TODO---------------------
			String hangyeSql = "select a.typeName from p_policyType a inner join p_policyAndType " +
					"b on a.id=b.typeid where a.fullPath like '1542%' and  b.policyId=?";
			String hangye = new DbUtil(conn).queryForString(hangyeSql,new Object[]{pId});
			modelAndView.addObject("hangye", hangye);
			
			//效力级别
			String xiaoliSql = "select a.typeName from p_policyType a inner join p_policyAndType b " +
					"on a.id=b.typeid where a.parentId='99999' and b.policyId=?";
			String xiaoli = new DbUtil(conn).queryForString(xiaoliSql,new Object[]{pId});
			modelAndView.addObject("xiaoli", xiaoli);
			
			// 法律法规的附件
			List listAttach = ps.getPolicyAttachFileList(pId);
			String isAttach = "N";
			if (listAttach.size() > 0) {
				isAttach = "Y";
			}

			// 取出相关问题
			QuestionService qs = new QuestionService(conn);
			List<Question> list = qs.getQuestions("policy", pId);

			
			//主题分类
//			String zhutiSql = (new StringBuilder(
//					"select typeName from p_policyType where id in (select typeId from p_policyAndType where policyId = '"))
//					.append(pId).append("') and  parentId < '1542'").toString();
			String zhutiSql = "select a.typeName from p_policyType a inner join p_policyAndType b " +
					"on a.id=b.typeid where a.fullPath like '1369%' and b.policyId=?";
			PreparedStatement zhutiPs = conn.prepareStatement(zhutiSql);
			zhutiPs.setString(1, pId);
			ResultSet zhutiRs = zhutiPs.executeQuery();
			String ss = "";
			while (zhutiRs.next()) {
				ss+=zhutiRs.getString("typeName")+",";
			}
			DbUtil.close(zhutiRs);
			DbUtil.close(zhutiPs);
			modelAndView.addObject("zhuti", ss.substring(0, ss.lastIndexOf(",")));
			
			//行业分类
//			String hangyanSql = (new StringBuilder(
//					"select typeName from p_policyType where id in (select typeId from p_policyAndType where policyId = '"))
//					.append(pId)
//					.append("') and '1542' <= parentId and parentId < '1547'")
//					.toString();
//			PreparedStatement hangyanPs = conn.prepareStatement(hangyanSql);
//			ResultSet hangyanRs = hangyanPs.executeQuery();
//			if (hangyanRs.next()) {
//				String hangyan = hangyanRs.getString(1);
//				modelAndView.addObject("hangyan", hangyan);
//			}
			
			//地域分类
//			String diyuSql = (new StringBuilder(
//					"select typeName from p_policyType where id in (select typeId from p_policyAndType where policyId = '"))
//					.append(pId)
//					.append("') and '1547' < parentId and parentId <= '88888'")
//					.toString();
			String diyuSql = "select a.typeName from p_policyType a inner join p_policyAndType b " +
			"on a.id=b.typeid where ((b.typeid>='1900' and b.typeid<='2091') or b.typeid='88888') and b.policyId=?";
			String diyu = new DbUtil(conn).queryForString(diyuSql,new Object[]{pId});
			modelAndView.addObject("diyu", diyu);
			
			String sql = (new StringBuilder(
					"select * from p_policy where id = '")).append(pId)
					.append("'").toString();
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			modelAndView.addObject("validityStatus",rs2.getString("validityStatus"));
			modelAndView.addObject("levelEffect", rs2.getString("levelEffect"));
			modelAndView.addObject("documentNumber",rs2.getString("documentNumber"));
			modelAndView.addObject("policy", policy);
			modelAndView.addObject("isAttach", isAttach);
			modelAndView.addObject("listAttach", listAttach);
			modelAndView.addObject("content", policy.getContent());
			modelAndView.addObject("questions", list);
			modelAndView.addObject("view", "view");

			// modelAndView.addObject("policy", policy) ;
			// modelAndView.addObject("isAttach", isAttach) ;
			// modelAndView.addObject("listAttach", listAttach) ;
			// modelAndView.addObject("content", policy.getContent()) ;
			// modelAndView.addObject("questions", list) ;
			// modelAndView.addObject("view", "view") ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}

	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		ModelAndView modelAndView = new ModelAndView(UPDATE_VIEW);
		try {
			conn = new DBConnect().getConnect();
			String pId = request.getParameter("id");
			PolicyService ps = new PolicyService(conn);
			Policy policy = ps.getPolicy(pId);
			modelAndView.addObject("policy", policy);
			modelAndView.addObject("typeId", policy.getTypeId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}

	// 审核时查看的法律法规
	public ModelAndView checkView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;

		String view = "";
		String oaView = StringUtil.showNull(request.getParameter("oaView"));
		if (!"".equals(oaView)) {
			view = OAVIEW;
		} else {
			view = VIEW;
		}
		ModelAndView modelAndView = new ModelAndView(view);
		try {
			conn = new DBConnect().getConnect();
			String pId = request.getParameter("id");
			PolicyService ps = new PolicyService(conn);
			PolicyCheck pc = ps.getCheck(pId);
			String updateContent = pc.getUpdateConent(); // 修改过的法律法规内容
			String policyId = StringUtil.showNull(pc.getPolicyId());
			String content = "";
			if (!"".equals(policyId)) {
				// 说明是修改待审核的法律法规
				Policy policy = ps.getPolicy(pc.getPolicyId());
				// 对比两段字符串，找出差异
				diff_match_patch dmp = new diff_match_patch();
				content = dmp.diff_prettyHtml(dmp.diff_main(
						policy.getContent(), updateContent));
				pc.setUpdateConent(content.replaceAll("&lt;p&gt;", "")
						.replaceAll("&amp;", "&").replaceAll("&lt;", "<")
						.replaceAll("&gt;", ">").replaceAll("&para;", ""));
				modelAndView.addObject("viewCount", policy.getViewCount());
			}

			modelAndView.addObject("policy", pc);
			modelAndView.addObject("content", pc.getUpdateConent());
			modelAndView.addObject("check", "check");
			modelAndView.addObject("checkId", pId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}

	public void audit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Connection conn = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("userSession");
			String id = request.getParameter("id");
			String state = request.getParameter("state");
			PolicyService ps = new PolicyService(conn);
			String userId = (String) userSession.getUserMap().get("loginid"); // 从session中取
			ps.updateCheck(id, state, userId);
			PolicyCheck pc = ps.getCheck(id);
			if ("1".equals(state)) {
				// 审核通过，更新原来的法律法规文件！！
				String autoIncreamtId = ps.addOrUpdatePolicy(pc);

				// 重新生成法律法规静态文件
				ToHTML tohtml = new ToHTML();
				String url = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/common/policy.do?method=view&id=" + autoIncreamtId;
				String path = request.getSession().getServletContext()
						.getRealPath("/")
						+ "common/policyHtml/";
				tohtml.convertToHtml(url, autoIncreamtId + ".html", path);
			}

			PrintWriter out = response.getWriter();
			out.write("审核成功!");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	public void createHtml(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			conn = new DBConnect().getConnect();
			String sql = "select id,title from p_policy order by id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ToHTML tohtml = new ToHTML();
			PrintWriter out = response.getWriter();
			out.println("开始生成法律法规静态文件....<br>");
			while (rs.next()) {
				// 重新生成法律法规静态文件
				String url = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/common/policy.do?method=view&id=" + rs.getString(1);
				String path = request.getSession().getServletContext()
						.getRealPath("/")
						+ "common/policyHtml/";
				tohtml.convertToHtml(url, rs.getString(1) + ".html", path);
				out.println("生成[" + rs.getString(2) + "]静态文件成功...<br>");
			}

			sql = "select id,title from p_cases order by id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			out.println("<br><br>开始生成案例静态文件....<br>");
			while (rs.next()) {
				// 重新生成案例静态文件
				String url = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/common/case.do?method=view&id=" + rs.getString(1);
				String path = request.getSession().getServletContext()
						.getRealPath("/")
						+ "common/caseHtml/";
				tohtml.convertToHtml(url, rs.getString(1) + ".html", path);
				out.println("生成[" + rs.getString(2) + "]静态文件成功...<br>");
			}

			sql = "select id,title from p_question order by id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			out.println("<br><br>开始生成问题静态文件....<br>");
			while (rs.next()) {
				// 重新生成案例静态文件
				String url = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/common/question.do?method=view&id="
						+ rs.getString(1);
				String path = request.getSession().getServletContext()
						.getRealPath("/")
						+ "common/questionHtml/";
				tohtml.convertToHtml(url, rs.getString(1) + ".html", path);
				out.println("生成[" + rs.getString(2) + "]静态文件成功...<br>");
			}
			out.println("<br><br>全部静态文件生成完毕....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	public void createPolicyHtml(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			ToHTML tohtml = new ToHTML();
			String policyId = StringUtil.showNull(request.getParameter("id"));
			// 重新生成法律法规静态文件
			String url = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/common/policy.do?method=view&id=" + policyId;
			String path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "common/policyHtml/";
			tohtml.convertToHtml(url, policyId + ".html", path);
			out.write("suc");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("fail");
		} finally {
		}
	}

	public ModelAndView searchView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView =  new ModelAndView(SEARCH_VIEW);
		String typeId = StringUtil.showNull(request.getParameter("typeId"));
		System.out.println("++++++++++++++++++++++++++++++++searchView:"+typeId);
		modelAndView.addObject("typeId", typeId);
		return modelAndView;
	}

	public ModelAndView search(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ModelAndView modelAndView = new ModelAndView(SEARCH_VIEW);
		
		//保存行业类型ID查询页面
		String typeId = StringUtil.showNull(request.getParameter("typeId"));
		System.out.println("------------------->search:"+typeId);
		modelAndView.addObject("typeId", typeId);
		
		try {
			String searhArea = StringUtil.showNull(request
					.getParameter("searchArea"));
			String srAbout = StringUtil.showNull(request
					.getParameter("srAbout"));
			
			int pagesize = 10;// 每页显示记录数
			int liststep = 9;// 最多显示分页页数
			int pages = 1;// 默认显示第一页
			if (request.getParameter("page") != null) {
				try {
					pages = Integer.parseInt(request.getParameter("page"));// 分页页码变量
				} catch (Exception e) {
					//e.printStackTrace();
					pages = 1;
				}
			}

			StringBuffer sql = new StringBuffer(
					"select top 10 id,title,substring(content,1,200)+'......' as content,wordNum,sendDepartment from p_policy where ");
			StringBuffer sqlCount = new StringBuffer(
					"select count(*) from p_policy where");
			String ext = "typeId IN (SELECT id from p_policytype where TypeName ";

			int totalCount = -1;
			int from = 0;
			int to = 0;
			StringBuffer resultHTML = new StringBuffer();
			StringBuffer pageInfo = new StringBuffer();

			StringBuffer sqlTemp = new StringBuffer();
			if (!"".equals(searhArea)) {
				String[] conditions = srAbout.split(",");
				for (int i = 0; i < conditions.length; i++) {
					if (i != 0) {
						sqlTemp.append(" or " + conditions[i] + " like '%"
								+ searhArea + "%'");
						sqlCount.append(" or " + conditions[i] + " like '%"
								+ searhArea + "%'");
					} else {
						sqlTemp.append(" " + conditions[i] + " like '%" + searhArea
								+ "%'");
						sqlCount.append(" " + conditions[i] + " like '%"
								+ searhArea + "%'");
					}
				}
				sql.append(sqlTemp.toString());
				//sql.append(" or " + ext + " like '%" + searhArea + "%')");
				sql.append(" and id NOT IN (SELECT TOP " + (10 * (pages - 1))
						+ " ID FROM p_policy WHERE "+sqlTemp+" ORDER BY ID DESC)");
				sqlCount.append(" or " + ext + " like '%" + searhArea + "%')");
				sql.append(" order by ID desc");

				
				System.out.println("&&&&&&&&&&&&&&&&---->sqlCount:"+sqlCount.toString());
				conn = new DBConnect().getConnect();
				ps = conn.prepareStatement(sqlCount.toString());
				rs = ps.executeQuery();
				if (rs.next()) {
					totalCount = rs.getInt(1);
				} else {

					totalCount = 0;
				}

				int count = totalCount;// 假设取出记录总数
				int pagescount = (int) Math.ceil((double) count / pagesize);// 求总页数，ceil（num）取整不小于num
				if (pagescount < pages) {
					pages = pagescount;// 如果分页变量大总页数，则将分页变量设计为总页数
				}
				if (pages < 1) {
					pages = 1;// 如果分页变量小于１,则将分页变量设为１
				}
				int listbegin = (pages - (int) Math.ceil((double) liststep / 2));// 从第几页开始显示分页信息
				if (listbegin < 1) {
					listbegin = 1;
				}
				int listend = pages + liststep / 2;// 分页信息显示到第几页
				if (listend > pagescount) {
					listend = pagescount + 1;
				}

				// 显示数据部分
				int recordbegin = (pages - 1) * pagesize;// 起始记录
				int recordend = 0;
				recordend = recordbegin + pagesize;
				// 最后一页记录显示处理
				if (pages == pagescount) {
					recordend = (int) (recordbegin + pagesize
							* (count % pagesize) * 0.1);
				}

				from = recordbegin + 1;
				to = from + pagesize - 1;
				if (to > count) {
					to = count;
				}
				
				System.out.println("&&&&&&&&&&&&&&&&---->sql:"+sql.toString());
				ps = conn.prepareStatement(sql.toString());
				rs = ps.executeQuery();
				
				
				
				while (rs.next()) {
					System.out.println("当查询为 1 时："+rs.getString("id"));
					resultHTML.append("<div style=\"margin-bottom:15px;\">");
					resultHTML.append("<span>");
					resultHTML
							.append("<a style=\"text-decoration:underline; \" href=\""
									+ request.getContextPath()								
									+ "/common/policy.do?method=view&id="+rs.getString("id")+"&typeId="+typeId);
					resultHTML.append("\">");
					
//						+ "/common/policyHtml/");
//					resultHTML.append(rs.getString("id"));
//					resultHTML.append(".html\">");
										
					resultHTML.append("<font style=\"font-size:15; \">"
							+ rs.getString("title") + "</font>");
					resultHTML.append("</a></span>");
					resultHTML
							.append("<span style=\"font-size:12px;color:#000\">");
					resultHTML.append(rs.getString("content").replace(
							rs.getString("title"), ""));
					resultHTML.append("</span>");
					resultHTML.append("</div><br>");
				}

				pageInfo.append("<div style=\"font-size:16px;text-align:center;\">");
				if (pages > 1) {
					pageInfo.append("<a href=javascript:goTo(" + (pages - 1)
							+ ")>上一页</a>");
					
					
				}// >显示上一页
					// <显示分页码
				for (int i = listbegin; i < listend; i++) {
					if (i != pages) {// 如果i不等于当前页
						pageInfo.append("<a href=javascript:goTo(" + i + ")>["
								+ i + "]</a>");
					} else {
						pageInfo.append("[" + i + "]");
					}
				}// 显示分页码>
					// <显示下一页
				if (pages != pagescount) {
					pageInfo.append("<a href=javascript:goTo(" + (pages + 1)
							+ ")>下一页</a>");
				}// >显示下一页
					// >显示分页信息
				pageInfo.append("</div>");

				String rsHTML = resultHTML.toString();
				rsHTML = rsHTML.replaceAll(searhArea,
						"<font color='red' style='font-size:15'>" + searhArea
								+ "</font>");

				modelAndView.addObject("searhArea", searhArea);
				modelAndView.addObject("resultHTML", rsHTML);
				modelAndView.addObject("totalCount", totalCount);
				modelAndView.addObject("pageInfo", pageInfo.toString());
				modelAndView.addObject("srAbout", srAbout);
				modelAndView.addObject("from", from);
				modelAndView.addObject("to", to);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return modelAndView;
	}

	public ModelAndView submitAudit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Connection conn = null;
		try {
			request.setCharacterEncoding("UTF-8");
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("userSession");
			String id = StringUtil.showNull(request.getParameter("id"));
			String content = StringUtil.showNull(
					request.getParameter("content")).toLowerCase();
			
			String title = StringUtil.showNull(request.getParameter("title"));
			String sendDepartment = StringUtil.showNull(request
					.getParameter("sendDepartment"));
			String wordNum = StringUtil.showNull(request
					.getParameter("wordNum"));
			String sendDate = StringUtil.showNull(request
					.getParameter("sendDate"));
			String typeId = StringUtil.showNull(request.getParameter("typeId"));

			PolicyService ps = new PolicyService(conn);
			
			String userId = (String) userSession.getUserMap().get("loginid"); // 从session中取
			// 保存审核信息
			PolicyCheck pc = new PolicyCheck();
			pc.setPolicyId(id);
			pc.setUpdateConent(content);
			pc.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS")
					.format(new Date()));
			pc.setUpdateUserId(userId);
			pc.setWordNum(wordNum);
			pc.setSendDepartment(sendDepartment);
			pc.setTitle(title);
			pc.setSendDate(sendDate);
			pc.setTypeId(typeId);
			ps.addCheck(pc);

			response.sendRedirect(request.getContextPath()
					+ "/common/policy.do?method=list");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		System.out.println("-----------------------------------9999999999999999999-------------------------------");
		return null;
	}

	public ModelAndView saveQuestion(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("88888888888888888888888888888-->:"+"saveQuestion");
		
		Connection conn = null;
		try {
			request.setCharacterEncoding("UTF-8");
			conn = new DBConnect().getConnect();
			String policyId = request.getParameter("policyId");
			String content = request.getParameter("content");
			String title = request.getParameter("title");
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("userSession");

			Question question = new Question();
			question.setCtype("policy");
			question.setTypeId(policyId);
			question.setUserId((String) userSession.getUserMap().get("loginid"));
			question.setTitle(title);
			question.setQuestion(content);
			question.setState("0");
			question.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.format(new Date()));

			QuestionService qs = new QuestionService(conn);
			String questionId = qs.add(question);
			// 更新全路径
			String fullPath = new PolicyService(conn).getPolicy(policyId)
					.getFullPath();
			qs.updateFullPath(questionId, fullPath);

			// 重新生成法律法规静态文件
			ToHTML tohtml = new ToHTML();
			String url = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/common/policy.do?method=view&id=" + policyId;
			String path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "common/policyHtml/";
			tohtml.convertToHtml(url, policyId + ".html", path);

			// 重新生成问题静态文件
			String url2 = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/common/question.do?method=view&id=" + questionId;
			String path2 = request.getSession().getServletContext()
					.getRealPath("/")
					+ "common/questionHtml/";
			tohtml.convertToHtml(url2, questionId + ".html", path2);

			response.sendRedirect(request.getContextPath()
					+ "/common/policyHtml/" + policyId + ".html");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}

	/**
	 * 
	 * 文件下载
	 * 
	 **/
	public ModelAndView downPolicy(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		try {
			response.setContentType("text/html;charset=utf-8");
			String attachmentId = CHF.showNull(request
					.getParameter("attachmentId"));

			conn = new DBConnect().getConnect();

			Map map = new PolicyService(conn).getPolicyAttachFile(attachmentId);
			String filename = map.get("filename") + "";

			System.out
					.println("---------------------------------------------------------------------filename:"
							+ filename);

			filename = filename.replace("Download_File", "").replaceAll("\\\\",
					"/");
			String path = PolicyAction.class.getClassLoader().getResource("")
					.getPath();
			// path = path.substring(0, (path.indexOf("-") - 3))+
			// "common/attachFile/p_policy"+filename;
			// path = path.substring(0, (path.indexOf("-") - 3))+
			// "Download_File"+filename;
			path = path.substring(0, (path.indexOf("-") - 3)) + filename;

			System.out
					.println("---------------------------------------------------------------------path:"
							+ path);

			if (!new File(path).exists()) {
				PrintWriter out = response.getWriter();
				out.println("<script language=javascript>");
				out.println("	window.parent.alert(\"下载文件失败，找不到对应文件，请联系管理员！\");");
				out.println("</script>");
				out.close();
				System.out.println("error:下载文件出错了,找不到对应的文件!");
				return null;
			} else {
				String attachfile = map.get("displayname") + "."
						+ map.get("type");
				attachfile = URLEncoder.encode(attachfile, "UTF-8");
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-disposition",
						"attachment;filename=" + attachfile);
				OutputStream os = response.getOutputStream();
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream(new File(path)));

				byte b[] = new byte[512];
				int len;

				while ((len = bis.read(b)) != -1) {
					os.write(b, 0, len);
				}

				os.flush();
				bis.close();
				os.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(conn);
		}

		return null;
	}

	private static LinkedList<Diff> diffList(Diff... diffs) {
		LinkedList<Diff> myDiffList = new LinkedList<Diff>();
		for (Diff myDiff : diffs) {
			myDiffList.add(myDiff);
		}
		return myDiffList;
	}

}
