package cn.org.gdicpa.web.action.message;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;

public class MessageAction extends MultiActionController {

	private static final String MESSAGELIST = "/message/list.jsp";
	private static final String MESSAGEVIEW = "/message/view.jsp";

	/**
	 * 消息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView messageList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView(MESSAGELIST);
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();

			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			String loginid = (String) userSession.getUserMap().get("loginid");

			String sql = " select a.id,a.caption,a.loginname,a.ntime, case when b.IsView = '0' then '未阅' else '已阅' end as isview"
					+ " from K_MicfoNoAuditMsg a left join K_MicfoNoMsgView b on a.id = b.MsgID "
					+ " where b.loginid = '"+loginid+"' ";
			
			StringBuffer sb = new StringBuffer(sql);

			// 搜索条件
			String caption = StringUtil.showNull(request.getParameter("caption")); 	// 标题
			String ntime1 = StringUtil.showNull(request.getParameter("ntime1")); 	// 开始时间
			String ntime2 = StringUtil.showNull(request.getParameter("ntime2")); 	// 结束时间
			String isview = StringUtil.showNull(request.getParameter("isview")); 	// 状态

			if (!"".equals(caption)) {
				sb.append(" and a.caption like '%").append(caption).append("%'");
			}

			if (!"".equals(ntime1) && !"".equals(ntime2)) {

				sb.append(" and ( a.ntime between '").append(ntime1).append("' and '").append(ntime2).append("' ) ");

			} else {

				if (!"".equals(ntime1)) {
					sb.append(" and a.ntime like '%").append(ntime1).append("%'");
				}
				if (!"".equals(ntime2)) {
					sb.append(" and a.ntime like '%").append(ntime2).append("%'");
				}
			}

			if (!"".equals(isview)) {
				sb.append(" and b.IsView = '").append(isview).append("'");
			}

			String property = " align=center onclick=\"goDetail('${id}');\"  nowrap=\"nowrap\" ";
			
			DataGridProperty pp = new DataGridProperty();

			pp.setTitle("消息");
			pp.setTableID("messageList");
			pp.setTableHead("标题,发布人,发布时间,状态");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("标题", "caption", "showCenter").setTdProperty(property);
			pp.addColumn("发布人", "loginname", "showCenter").setTdProperty(property);;
			pp.addColumn("发布时间", "ntime", "showCenter").setTdProperty(property);;
			pp.addColumn("状态", "isview", "showCenter").setTdProperty(property);;

			pp.setPageAlign("left");
			pp.setPageSize_CH(10);
			pp.setSQL(sb.toString());
			pp.setOrderBy_CH("ntime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}

	/**
	 * 消息详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView messageView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView model = new ModelAndView(MESSAGEVIEW);
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			DbUtil db = new DbUtil(conn);
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			String loginid = (String) userSession.getUserMap().get("loginid");
			String id = request.getParameter("id");
			
			// 主表
			String sql = "select id, loginname, ntime, caption, body, attachmentid from K_MicfoNoAuditMsg where id=?";
			
			Map<String, Object> map = db.getOneObject2Map(sql, new Object[]{id});
			
			// 附件
			String attachmentid = (String)map.get("attachmentid");
			
			sql = "select autoid, fileTempName, filename, isnull(isDownload, '0') as isDownload, "
				+ " case when isnull(isDownload, '0') = '0' then '未下载' else '已下载' end as download "
				+ " from k_attachfile where indexid=? group by autoid, fileTempName, filename, isDownload ";
			
			List<Map<String, Object>> files = db.getAllObject2ListMap(sql, new Object[]{attachmentid});
			
			model.addObject("files", files);
			model.addObject("msg", map);
			
			// 状态为 “未阅” 的更新为 “已阅”
			Map<String, Object> map2 = db.getOneObject2Map("select guid, isView from K_MicfoNoMsgView where LoginID=? and MsgID=?", new Object[]{loginid, id});
			
			String isView = map2.get("isView").toString();
			String guid	  = map2.get("guid").toString();
			
			if("0".equals(isView)){
				
				Object[] obj = new Object[]{1, DateUtil.getDate("yyyy-MM-dd HH:mm:ss"), guid};
				
				db.update("update K_MicfoNoMsgView set isView=?, ViewTime=? where Guid=?", obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 下载附件
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OutputStream outp = null;
        InputStream in = null;
        Connection conn = null;
        int b ;
		
		try {
			conn = new DBConnect().getConnect();
			conn.setAutoCommit(false);
			
        	StringBuffer sb = new StringBuffer("/common/attachFile/b_notice/");
        	
        	String code = request.getParameter("code");			// 路径文件
        	String name = request.getParameter("name");			// 文件名
        	String down = request.getParameter("down");			// 是否已下载
        	String autoid = request.getParameter("autoid");		// 文件id
        	
        	String path = sb.append(code).toString();
        	
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename="+name);
            
            outp = response.getOutputStream();
            
            in = new FileInputStream(getServletContext().getRealPath(path));
            
            while ((b = in.read()) != -1) {
            	outp.write(b);
            }
            
            // 更新下载次数
            int downCount = Integer.parseInt(down) + 1;
            
            int n = new DbUtil(conn).update("update k_attachfile set isDownload=? where autoid=?", new Object[]{downCount, autoid});
        	
            System.out.println(name + " 下载：" + downCount + "_" + n);
            
        	conn.commit();
        	
        } catch (Exception e) {
        	conn.rollback();
            e.printStackTrace();
        } finally {
            in.close();
            outp.close();
            conn.close();
        }
	}
	
	
}
