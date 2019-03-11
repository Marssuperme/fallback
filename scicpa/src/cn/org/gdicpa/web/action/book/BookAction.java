package cn.org.gdicpa.web.action.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.listener.UserSession;

public class BookAction extends MultiActionController{
	private static final String LIST = "/book/list.jsp";
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		
		try {
			String sql = "select * from b_book ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("图书信息");
			 
			pp.setInputType("radio");
			pp.setTableID("book");
			pp.setWhichFieldIsValue(1);
			
			
			pp.addColumn("书名", "BookName","showCenter");
			pp.addColumn("种类", "Btype","showCenter");

			pp.addColumn("出版社", "Press","showCenter");
			pp.addColumn("推荐单位", "Recommendedunits","showCenter");
			pp.addColumn("单价 ", "Price").setTdProperty("align=right");
			pp.addColumn("备注", "Remark","showCenter");
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("Price");
			pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
}
