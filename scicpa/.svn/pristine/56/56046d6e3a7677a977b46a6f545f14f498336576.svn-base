package cn.org.gdicpa.web.action.reportValidate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.listener.UserSession;

public class ReportValidateAction extends MultiActionController{
	private static final String LIST = "/reportValidate/list.jsp";
	
	
	/**
	 * 显示list页面，但是团体会员和个人会员的SQL逻辑不同；
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String ctype=(String)userSession.getUserMap().get("ctype");
		String cpano=(String)userSession.getUserMap().get("cpano");//注师编号
		
		
		
	
		//String 
		System.out.println("显示："+ctype);
		
		try {
			
			String sql = "select a.*,b.typename from bb_view a left join bb_type b on a.typeid=b.guid where 1=1 ${ywlx} ${bgwh}";
			
			
			if ("团体会员".equals(ctype)){
				//显示全部是我这个机构的；
				sql+=" and BBPERSON = '"+loginid+"' and bbstate<>'暂存' ";
			}else{
				//显示是我审计的；
				sql+=" and (cpa1 = '"+cpano+"' or cpa2 = '"+cpano+"'  or cpa3 = '"+cpano+"' or cpa4 = '"+cpano+"' or cpa5 = '"+cpano+"' or cpa6 = '"+cpano+"') and bbstate<>'暂存' ";
			}
			
			System.out.println(this.getClass()+"              sql="+sql);
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					
					String ywlx = getRequestValue("ywlx");
					String bgwh = getRequestValue("bgwh");
					
					if(ywlx != null && !"".equals(ywlx)) {
						ywlx = " and wtxmlx like '%"+ywlx+"%'";
					} 
					
					if(bgwh!=null && !"".equals(bgwh)){
						if(bgwh.indexOf("[")>-1){
							bgwh=bgwh.replaceAll("\\[","%");
						}
						if(bgwh.indexOf("]")>-1){
							bgwh=bgwh.replaceAll("\\]","%");
						}
						if(bgwh.indexOf("【")>-1){
							bgwh=bgwh.replaceAll("【","%");
						}
						if(bgwh.indexOf("】")>-1){
							bgwh=bgwh.replaceAll("】","%");
						}
						bgwh = "  and bgwh like '%"+bgwh+"%'";
					}
					
					this.setOrAddRequestValue("ywlx", ywlx);
					this.setOrAddRequestValue("bgwh", bgwh);
				}
			};
			
			pp.setTitle("报告签证经历信息");
			
			pp.addSqlWhere("ywlx","${ywlx}") ;
			pp.addSqlWhere("bgwh","${bgwh}") ;
			
			pp.setTableID("reportValidate");
			
			//pp.setInputType("radio");
			//pp.setWhichFieldIsValue(1);
			
			//委托单位、业务约定书号码、报告文号、签字注师1、签字注师2、签字注师3
			pp.addColumn("被审验单位名称", "bsdwmc").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("报备时间", "bbtime").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("防伪编号", "bbbh").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("已收业务费用", "ysywfed").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			
			pp.addColumn("委托单位名称", "WTDWMC").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("业务类型", "typename").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			
			//pp.addColumn("业务约定书号码", "ywyds").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			//pp.addColumn("报告年度", "BGND").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("报告文号", "BGWH").setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			
			
			pp.addColumn("注师1", "QMZS1")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("注师2", "QMZS2")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("注师3", "QMZS3")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			
			pp.addColumn("注师4", "QMZS4")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("注师5", "QMZS5")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			pp.addColumn("注师6", "QMZS6")  .setTdProperty("onclick=f_viewTD('${GUID}','${typeid}')");
			
			pp.setColumnWidth("220,150,30,30,220,20,230,60,60,60,60,60,60");
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("BBTIME");
			pp.setDirection("DESC");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
}
