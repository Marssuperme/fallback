package cn.org.gdicpa.web.tags;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.datagrid.SqlWhereVariable;
import cn.org.gdicpa.web.pub.util.StringUtil;


/**
 * <p>Title: 查询模块控件</p>
 * <p>Description: 查询模块控件，，
 * 用来输出数据table到jsp</p>
 * <p>Copyright: Copyright (c) 2006, 2008 MaTech Corporation.All rights reserved. </p>
 * <p>Company: Matech  广州铭太信息科技有限公司</p>
 *
 * 本程序及其相关的所有资源均为铭太科技公司研发中心审计开发组所有，
 * 版本发行及解释权归研发中心，公司网站为：http://www.matech.cn
 *
 * 贡献者团队:
 *     铭太科技 - 研发中心，审计开发组
 *
 * @author k
 * 2007-6-8
 */
public class DataGridTag extends BodyTagSupport {

	private static final long serialVersionUID = 1000000001L;

	private String dbDepartid = "";

	private String sql = "";

	private String sqlWhere = "";

	private String id = "";

	private String tableHead = null;

	private boolean trActionProperty = false;

	private String trAction = "";

	private int pageSize = 20;

	private String inputType = "";

	private int whichFieldIsValue = 1;

	private String preOrderBy = "";

	private String direction = "";

	private String bodyContentStr = "";

	DataGridProperty pp = null;

	public int doEndTag() {
		pp = new DataGridProperty();
		try {

			JspWriter out = pageContext.getOut();
			HttpSession session = pageContext.getSession();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

			bodyContentStr = this.bodyContent.getString();

			SAXBuilder sb = new SAXBuilder();

			Document doc = sb.build(new StringReader("<root>"
									+ StringUtil.getXMLData(bodyContentStr, "columns")
									+ "</root>"));
			Element root = doc.getRootElement();

			//获得所有的column元素

			List columns = root.getChildren("column");
			int colLength = columns.size();

			//有待改进，把每列的属性封装一个column对象
			for (int i = 0; i < colLength; i++) {
				Element column = (Element) columns.get(i);
				pp.addColumn(column.getAttributeValue("displayName"), 
						column.getAttributeValue("colName"), 
						column.getAttributeValue("format"), 
						column.getAttributeValue("fieldProcess"), 
						column.getTextTrim());
			}

			this.setSqlWhere(StringUtil.getXMLData(bodyContentStr, "sqlWheres"));

			pp.setTableID(getId());

			pp.setInputType(getInputType());
			pp.setTableHead(getTableHead());

			pp.setTrActionProperty(isTrActionProperty());
			pp.setTrAction(getTrAction());

			pp.setPageSize_CH(getPageSize());

			pp.setWhichFieldIsValue(getWhichFieldIsValue());

			pp.setOrderBy_CH(getPreOrderBy());
			pp.setDirection(getDirection());

			pp.setSqlWhere(getSqlWhere_map());

			pp.setSQL(sql);

			DataGrid dg = new DataGrid(session, request, response, pp);
			dg.printGrid(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPreOrderBy() {
		return preOrderBy;
	}

	public void setPreOrderBy(String preOrderBy) {
		this.preOrderBy = preOrderBy;
	}

	public String getTrAction() {
		return trAction;
	}

	public void setTrAction(String trAction) {
		this.trAction = trAction;
	}

	public boolean isTrActionProperty() {
		return trActionProperty;
	}

	public void setTrActionProperty(boolean trActionProperty) {
		this.trActionProperty = trActionProperty;
	}

	public int getWhichFieldIsValue() {
		return whichFieldIsValue;
	}

	public void setWhichFieldIsValue(int whichFieldIsValue) {
		this.whichFieldIsValue = whichFieldIsValue;
	}

	public String getSqlWhere() {
		return sqlWhere;
	}

	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	// 将页面上的sqlWhere字符串格式化为map对象
	public HashMap getSqlWhere_map() {

		HashMap sw = new java.util.HashMap();

		for (int i = -1, j = -1; (i = sqlWhere.indexOf("<sqlWhere>", i + 1)) >= 0
				&& (j = sqlWhere.indexOf("</sqlWhere>", j + 1)) >= 0;) {
			i += 10;
			String xml = sqlWhere.substring(i, j);
			sw.put(StringUtil.getXMLData(xml, "id"), new SqlWhereVariable(StringUtil.getXMLData(xml, "sql")));
		}
		return sw;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getTableHead() {
		return tableHead;
	}

	public void setTableHead(String tableHead) {
		this.tableHead = tableHead;
	}

	public String getDbDepartid() {
		return dbDepartid;
	}

	public void setDbDepartid(String dbDepartid) {
		this.dbDepartid = dbDepartid;
	}
}
