package cn.org.gdicpa.web.action.manaGement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;

public class ManaGementAction extends MultiActionController{
private static final String LIST_VIEW = "/management/list.jsp";
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW);
		String sql = "";
		try {			
			sql= "select autoId,year,result,situation,annex from k_management";	
			DataGridProperty pp = new DataGridProperty();
			pp.setSQL(sql);
			pp.setOrderBy_CH("year");
			pp.setDirection("desc");
			pp.setTableID("managementList");

			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			pp.setColumnWidth("15,10,10,10");
			pp.setTitle("事务所自查管理信息");
			
			pp.addColumn("自查年度", "year");
			pp.addColumn("自查结果", "result");
			pp.addColumn("整改情况", "situation");
			pp.addColumn("附件", "annex");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}
}
