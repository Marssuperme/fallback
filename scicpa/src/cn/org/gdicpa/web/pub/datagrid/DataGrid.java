package cn.org.gdicpa.web.pub.datagrid;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;

/**
 * 
 * <p>
 * Title:查询模块控件,用来输出数据table到jsp 需要继承才能使用
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: Matech 广州铭太信息科技有限公司
 * </p>
 * 
 * @author winnerQ
 * @version 3.0
 */
public class DataGrid {

	public static final String sessionPre = "DGProperty_";// 默认的session前缀

	private final static String tdSuffix = "_td";

	private Writer out = null; // jsp页面输出对象

	private HttpSession session = null; // session对象

	private HttpServletRequest request = null;

	private HttpServletResponse response = null;

	private String DOWN_IMG = null;
	private String UP_IMG = null;

	// datagrid的各种属性
	private DataGridProperty pp = null;

	public DataGrid(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, DataGridProperty property) {

		this.session = session;
		this.request = request;
		this.response = response;
		this.pp = property;

		// 定位页码
		String current_Page = (String) session.getAttribute(pp.getTableID()
				+ "_currentPage");
		if ("".equals(pp.getPage_CH())) {
			pp.setPage_CH(current_Page);
		}

		DOWN_IMG = "<img src=\"" + request.getContextPath()
				+ "/images/datagrid/down.gif\" />";
		UP_IMG = "<img src=\"" + request.getContextPath()
				+ "/images/datagrid/up.gif\" />";
	}

	// 父类DataGrid会调这个方法取连接，并在父类里关闭连接。
	public Connection getConnect() {
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 如果获得数据的方法
	public String newString(ResultSetMetaData RSMD,ResultSet rs, int colIndex) throws Exception {
		
		return rs.getString(colIndex);
		// byte[] b = rs.getBytes(colIndex);
		// if (b == null)
		// return "";
		// else
		// return new String(b, "GBK");
	}

	public void printGrid(JspWriter out) {
		this.out = out;
		try {

			pp.initScriptVariable();

			printScript(out, pp.sqlWhereVariable);

			// 1 开始打印表格
			out
					.write("<span><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">");
			out.write("<tr>");
			out
					.write("<td valign=top id='" + pp.getTableID() + tdSuffix
							+ "'>");

			this.printGridBody(out);

			out.write("</td>");
			out.write("</tr>");
			out.write("</table></span>");
			out.write("<input type=\"hidden\" id=\"chooseValue_"
					+ pp.getTableID() + "\" name=\"chooseValue_"
					+ pp.getTableID() + "\" value=\"\">");
			out.write("<input type=\"hidden\" id=\"hideColumnsStr_"
					+ pp.tableID + "\" value=\"\" />");
			out.write("<input type=\"hidden\" id=\"fixColNum_" + pp.tableID
					+ "\" value=\"0\" />");

		} catch (Exception e) {
			session.setAttribute(sessionPre + pp.getTableID(), "");
			e.printStackTrace();
		}
	}

	public void printGridFrame(JspWriter out, String message) {
		this.out = out;

		try {

			pp.initScriptVariable();

			// 1 开始打印表格
			out.write("<span>");
			out
					.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">");
			out.write("<tr>");
			out
					.write("<td valign=top id='" + pp.getTableID() + tdSuffix
							+ "'>");

			if (message != null) {
				out.write("<table id=\"" + pp.tableID
						+ "\" width=\"100%\"> <tr><td align=\"center\">");
				out.write(message);
				out.write("</td></tr></table>");
			}

			out.write("<input type=\"hidden\" id=\"page_xml_" + pp.getTableID()
					+ "\" name=\"page_xml_" + pp.getTableID() + "\" value=\""
					+ "<direction_CH>" + pp.getDirection_CH()
					+ "</direction_CH>" + "<orderBy_CH>" + pp.getOrderBy_CH()
					+ "</orderBy_CH>" + "<page_CH>" + pp.getPage_CH()
					+ "</page_CH>" + "<pageSize_CH>" + pp.getPageSize_CH()
					+ "</pageSize_CH>" + "<sqlWhereVariable_CH>"
					+ pp.getSqlWhereVariable_CH() + "</sqlWhereVariable_CH>"
					+ "\">");

			out.write("</td>");
			out.write("</tr>");
			out.write("</table></span>");

			out.write("<input type=\"hidden\" id=\"chooseValue_"
					+ pp.getTableID() + "\" name=\"chooseValue_"
					+ pp.getTableID() + "\" value=\"\">");
			out.write("<input type=\"hidden\" id=\"hideColumnsStr_"
					+ pp.tableID + "\" value=\"\" />");
			out.write("<input type=\"hidden\" id=\"fixColNum_" + pp.tableID
					+ "\" value=\"0\" />");

			printScript(out, pp.sqlWhereVariable);

		} catch (Exception e) {
			session.setAttribute(sessionPre + pp.getTableID(), "");
			e.printStackTrace();
		}
	}

	public void printGridBody(Writer out) {
		this.out = out;
		Statement stmt = null;
		ResultSet RS = null;
		Connection conn = null;
		try {
			int allColumnLen = 0;
			int colCount = 0;
			int rowCount = 0;
			int displayColCount = 0;
			int width = 0;
			int preWidthLength = 0;

			// 用来存储field记录的数组,定义长度为 colCount 的大小
			String[] fieldValue = null;

			// 列名的小写
			String[] lowerFieldName = null;
			String strOrderBy = "";
			String[] orderFields = null;
			String[] orderDirection = null;

			String sql = "";
			boolean DisplayNext = true;

			// 如果删除某页码的记录成功，则返回其页码
			if (session.getAttribute("currentPageDel") != null) {
				pp.setPage_CH((String) session.getAttribute("currentPage"));
			} else {
				// 如果没有传页码，则当前而码为第1页
				if ("".equals(StringUtil.showNull(pp.page_CH))) {
					pp.setPage_CH("1");
				}
			}

			// 如果session中有值～ 就取session里的用户分页数,by void,2006-10-15
			// 每页行数
			if (pp.pageSize_CH < 1) {
				pp.pageSize_CH = 20;
			}

			// 拼装sql，得到结果集
			conn = getConnect();
			stmt = conn.createStatement();

			if (pp.getOrderBy_CH().indexOf(",") > 0) {
				// 得到排序字段
				orderFields = pp.getOrderBy_CH().split(",");
				// 相应的升降序
				orderDirection = pp.getDirection_CH().split(",");

				for (int i = 0; i < orderFields.length; i++) {

					if (i >= orderDirection.length) {
						strOrderBy += orderFields[i] + ",";
					} else {
						strOrderBy += orderFields[i] + " " + orderDirection[i]
								+ ",";
					}

				}

				strOrderBy = StringUtil.killEndToken(strOrderBy, ",");
			} else {
				orderFields = new String[] { pp.getOrderBy_CH() };
				orderDirection = new String[] { pp.getDirection_CH() };
				strOrderBy = pp.getOrderBy_CH() + " " + pp.getDirection_CH();
			}

			strOrderBy = !pp.isCancelOrderby() ? " order by " + strOrderBy : "";

			sql = pp.SQL;
			System.out.println(sql);
			// 替换sql中的变量
			sql = replaceSqlWhere(sql);

			rowCount = getRowCount(conn, sql);

			if (!pp.isCancelPage()) {

				// 定位页码
				int lastPage = 1;
				if (rowCount > 0) {
					lastPage = rowCount % pp.pageSize_CH == 0 ? rowCount
							/ pp.pageSize_CH : rowCount / pp.pageSize_CH + 1;
				}
				if (pp.getCurrentPage_CH() <= 1) {
					pp.setPage_CH("1");
				}
				if (pp.getCurrentPage_CH() > lastPage) {
					pp.setPage_CH(String.valueOf(lastPage));
				}
				session.setAttribute(pp.getTableID() + "_currentPage", String
						.valueOf(pp.getCurrentPage_CH()));

				// 增加分页的sql~~
				int limitStart = (pp.getCurrentPage_CH() - 1)
						* pp.getPageSize_CH();
				int limitEnd = limitStart + pp.getPageSize_CH();

				if (limitStart != 0) {
					limitStart++;
				}
				
				
				pp.setExpSql(sql  + " " + strOrderBy);

				String pageString = " ,ROW_NUMBER() OVER(" + strOrderBy
						+ ") AS ROW_NUM FROM";
				sql = sql.toLowerCase().replaceFirst("from", pageString);
				sql = " select * FROM (" + sql + " ) AS DG_TABLE "
						+ " where ROW_NUM BETWEEN " + limitStart + " AND "
						+ limitEnd + " " + strOrderBy;

			}else {
				sql = sql + strOrderBy;
				pp.setExpSql(sql  + " " + strOrderBy);
			}

			pp.setFinishSQL(sql);

			System.out.println(pp.getExpSql());
			System.out.println(sql);

			RS = stmt.executeQuery(sql);

			pp.setAllCount(rowCount + "");

			String vc[] = pp.getColName();
			ResultSetMetaData RSMD = RS.getMetaData();
			// 得到列与行数，如果为条件查询，显示所有行
			colCount = RSMD.getColumnCount();

			lowerFieldName = new String[RSMD.getColumnCount()];
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				lowerFieldName[i - 1] = RSMD.getColumnName(i).toLowerCase();

				// out.write(lowerFieldName[i - 1]);
			}

			displayColCount = pp.columns.size();

			if (pp.whichFieldIsValue == -1 || pp.whichFieldIsValue > colCount) {
				pp.setWhichFieldIsValue(colCount);
			}

			// defaultCol的总长度
			for (int i = 1; i <= displayColCount; i++) {
				if (i <= RSMD.getColumnCount()) {
					allColumnLen = allColumnLen + RSMD.getColumnDisplaySize(i);
				} else {
					allColumnLen = allColumnLen + 10;
				}

			}

			fieldValue = new String[colCount];

			StringBuffer tempStrb = new StringBuffer();
			tempStrb.append("");
			if (pp.getTitle() != null) {

				tempStrb.append("<div class=\"dgTitle\">");
				tempStrb.append("<span id=\"dgTitleLeft\">" + pp.getTitle() + "</span>");
				if(pp.isExpExcel()) {
					tempStrb.append("<span id=\"dgTitleRight\"><a href=\"javascript:expExcel('" + pp.getTableID() + "','" + pp.getTitle() + "');\">导出成Excel</a></span>");
				}
				
				tempStrb.append("</div>");
				out.write(tempStrb.toString());

			}

			out.write("<table class=\"dgTable\" id=\"" + pp.tableID
					+ "\" cellspacing=\"0\" width=\"100%\" >");
			if (!"".equals(pp.inputType)) {
				out.write("<col id=\"input_col\">");
			}

			for (int i = 0; i < pp.columns.size(); i++) {
				out.write("<col id=\"" + pp.getTableID() + "_col" + (i + 1)
						+ "\">");
			}

			String hideColName = "";
			String colName = "";
			for (int i = 0; i < pp.columns.size(); i++) {
				Column column = (Column) pp.columns.get(i);

				if (column.getDisplayColName().indexOf("\"") > -1
						|| column.getDisplayColName().indexOf("<input") > -1) {
					hideColName += "" + "`";
				} else {
					hideColName += column.getDisplayColName().replaceAll(
							"<br/>", "")
							+ "`";
				}
				colName += column.getColName() + "`";
			}

			hideColName = hideColName.substring(0, hideColName.length() - 1);
			colName = colName.substring(0, colName.length() - 1);

			out.write("<input type=\"hidden\" id=\"colName_" + pp.tableID
					+ "\" value=\"" + StringUtil.showNull(colName) + "\" />");
			out.write("<input type=\"hidden\" id=\"hideColName_" + pp.tableID
					+ "\" value=\"" + StringUtil.showNull(hideColName)
					+ "\" />");
			out.write("<input type=\"hidden\" id=\"tableHead_" + pp.tableID
					+ "\" value=\"" + StringUtil.showNull(pp.tableHead)
					+ "\" />");

			int colspan = displayColCount;
			if (!"".equals(pp.inputType)) {
				colspan++;
			}

			// 如果有序号列
			if (pp.isSerialCol()) {
				colspan++;
			}

			printTableHead(width, RSMD, preWidthLength, allColumnLen, vc,
					orderFields, orderDirection, pp.columns);

			if (rowCount == 0) {
				DisplayNext = false;
				if (pp.getNoDataHint() == null || pp.getNoDataHint().equals("")) {
					out
							.write("<tr><td colspan=\""
									+ colspan
									+ "\" align=\"center\" ><font size=\"2\">没有数据</font></td></tr>");
				} else {
					out.write("<tr><td colspan=\"" + colspan
							+ "\" align=\"center\" ><font size=\"2\">"
							+ pp.getNoDataHint() + "</font></td></tr>");
				}

			} else {
				if (pp.isCancelPage()) {
					pp.pageSize_CH = rowCount; // RS的所有记录的行数
				}

				// 分析一下是否需要隐藏重复行
				String preFieldValue = "", curFieldValue = "";
				String[] hiddenCol = pp.getHiddenCol();

				// 替换TrAction
				String showTrAction = "", strParam = "";

				String isChecked = "";

				String t1[] = null;
				if (pp.isTrActionProperty()) {
					showTrAction = pp.TrAction;
					t1 = StringUtil.getVaribles(showTrAction);
				}

				Map fieldMap = new HashMap();

				int ii = 1;
				for (int i = 1; RS.next(); i++) {
					ii++;
					// 这段是获取数据
					for (int j = 1; j <= colCount; j++) {
						
						String value = newString(RSMD,RS, j);
						
						fieldValue[j - 1] = value;
						
						fieldMap.put(lowerFieldName[j - 1], fieldValue[j - 1]);
					}

					curFieldValue = "";

					// 判断本行是否重复,有重复就用空格代替原来的值以免输出
					if (hiddenCol != null) {
						for (int j = 0; j < hiddenCol.length; j++) {
							curFieldValue += "`"
									+ StringUtil.showNull((String) fieldMap
											.get(hiddenCol[j]));
						}
						if (preFieldValue.equals(curFieldValue)) {
							ii--;
							// 如果相等，说明是重复行
							for (int j = 0; j < hiddenCol.length; j++) {
								fieldMap.put(hiddenCol[j], " ");
							}
						} else {
							preFieldValue = curFieldValue;
						}
					}

					boolean flag4Click = false;

					if (pp.isTrActionProperty()) {
						showTrAction = pp.TrAction;
						// 无条件替换一下：
						showTrAction = showTrAction.replaceAll(
								"\\$\\{rowindex\\}", String.valueOf(i));

						for (int j = 0; j < t1.length; j++) {
							try {
								strParam = (String) RS.getString(t1[j]);
								if (strParam == null) {
									strParam = "";
								}
							} catch (Exception e) {
							}
							showTrAction = showTrAction.replaceAll("\\$\\{"
									+ t1[j] + "\\}", strParam);
						}
					}

					// 替换inputAction和inputAttribute
					String inputAction = pp.getInputAction();
					String inputAttribute = pp.getInputAttribute();
					String checkboxField = StringUtil.showNull(pp
							.getCheckboxField());
					String checkboxValue = StringUtil.showNull(pp
							.getCheckboxValue());

					if (!"".equals(pp.getInputAction())) {
						for (int j = 0; inputAction.length() > 0
								&& j < colCount; j++) {
							inputAction = inputAction.replaceAll("\\$\\{"
									+ lowerFieldName[j] + "\\}", fieldValue[j]);
						}
					}
					if (!"".equals(pp.getInputAttribute())) {
						for (int j = 0; inputAttribute.length() > 0
								&& j < colCount; j++) {
							inputAttribute = inputAttribute.replaceAll("\\$\\{"
									+ lowerFieldName[j] + "\\}", fieldValue[j]);
						}
					}

					//
					if (!"".equals(checkboxField) && !"".equals(checkboxValue)) {
						for (int j = 0; checkboxField.length() > 0
								&& j < colCount; j++) {
							checkboxField = checkboxField.replaceAll("\\$\\{"
									+ lowerFieldName[j] + "\\}", fieldValue[j]);
						}
					}

					out.write("<tr height=18 nowrap dataRow=\"yes\" "
							+ showTrAction + ">");

					if (!"".equals(pp.inputType)) {

						if ((!"".equals(checkboxField) && checkboxField
								.equals(checkboxValue))
								|| pp.checkboxIsChecked) {
							isChecked = "checked=\"checked\"";
						} else {
							isChecked = "";
						}

						out.write("<td align=\"center\">");
						out
								.write("<input type=\""
										+ pp.inputType
										+ "\" "
										+ isChecked
										+ "  name=\"choose_"
										+ pp.getTableID()
										+ "\" id=\"choose_"
										+ pp.getTableID()
										+ "\" value='"
										+ StringUtil
												.showNull(fieldValue[pp.whichFieldIsValue])
										+ "' onmouseup=\"nothing();\" ");

						if (!"".equals(pp.getInputAction())) {
							out.write(" " + inputAction + " " + inputAttribute);
						} else {
							out
									.write(" onClick=\"setChooseValue_CH('"
											+ pp.getTableID()
											+ "','"
											+ StringUtil
													.showNull(fieldValue[pp.whichFieldIsValue])
											+ "');\" " + inputAttribute);
						}

						out.write(" style='height:16px;width:12px;'>");
						out.write("</td>");
					}

					if (pp.isSerialCol()) {
						out.write("<td align=\"center\">");

						String rows = String
								.valueOf((pp.getCurrentPage_CH() - 1)
										* pp.getPageSize_CH() + i);
						System.out.println("rows:" + rows);
						out.write(rows);
						out.write("</td>");
					}

					// 具体输出每一列的数据
					for (int j = 0; j < displayColCount; j++) {
					
						String value = new ASFuntion().showNull((String) fieldMap.get(vc[j]));
						if(pp.getValueMaxLength() != 0 && value.length() > pp.getValueMaxLength()) {
							value = "<span title=\"" + value + "\">" + value.substring(0, pp.getValueMaxLength()) + "...</span>";
						}
						
						String tdStr = fieldProcess(i, j + 1, colCount, RS,
								value,fieldValue[pp.whichFieldIsValue]);

						out.write(tdStr);
					}

					// 输出列至此结束
					out.write("</tr>");

				}
			}

			if (DisplayNext) {

				out.write("<tr>");
				int colNum = 0;
				if (pp.inputType != "")
					colNum = pp.getColumns().size() + 1;
				else
					colNum = pp.getColumns().size();

				if (pp.isSerialCol())
					colNum += 1;

				out.write("<td id=\"selectPage\" align=\"center\" colSpan=\""
						+ colNum + "\" >");

				if (!pp.isCancelFoot()) {
					if (!pp.isCancelPage()) {
						selectPage(out, rowCount, pp.pageSize_CH, pp
								.getCurrentPage_CH());
					} else {
						selectPage(out, rowCount);
					}
				}

				out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");

			out.write("<input type=\"hidden\" name=\"page_xml_"
					+ pp.getTableID() + "\" value=\"" + "<direction_CH>"
					+ pp.getDirection_CH() + "</direction_CH>" + "<orderBy_CH>"
					+ pp.getOrderBy_CH() + "</orderBy_CH>" + "<page_CH>"
					+ pp.getPage_CH() + "</page_CH>" + "<pageSize_CH>"
					+ pp.getPageSize_CH() + "</pageSize_CH>"
					+ "<sqlWhereVariable_CH>" + pp.getSqlWhereVariable_CH()
					+ "</sqlWhereVariable_CH>" + "\">");

			setExpExcel(out);
			
			session.setAttribute(sessionPre + pp.getTableID(), pp);

		} catch (Exception e) {
			try {
				out
						.write("<table id=\""
								+ pp.tableID
								+ "\"  border=\"0\" cellpadding=\"2\" cellspacing=\"1\" width=\"100%\" >");
				out
						.write("<tr><td colspan=\"100\" align=\"center\" bgColor=\"#f6f6f6\"><font size=\"2\" color=\"red\">查询发生异常，请联系管理员。<br>"
								+ "详细错误原因："
								+ e.getMessage()
								+ "</font></td></tr>");
				out.write("</table>");

				out.write("<input type=\"hidden\" name=\"page_xml_"
						+ pp.getTableID() + "\" value=\"" + "<direction_CH>"
						+ pp.getDirection_CH() + "</direction_CH>"
						+ "<orderBy_CH>" + pp.getOrderBy_CH() + "</orderBy_CH>"
						+ "<page_CH>" + pp.getPage_CH() + "</page_CH>"
						+ "<pageSize_CH>" + pp.getPageSize_CH()
						+ "</pageSize_CH>" + "<sqlWhereVariable_CH>"
						+ pp.getSqlWhereVariable_CH()
						+ "</sqlWhereVariable_CH>" + "\">");

			} catch (Exception ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.close(RS);
			DbUtil.close(stmt);
			DbUtil.close(conn);

		}

	}

	private void printTableHead(int width, ResultSetMetaData RSMD,
			int preWidthLength, int allColumnLen, String[] vc,
			String[] orderField, String[] orderDirection, ArrayList columns)
			throws Exception {

		out.write("<tr height=\"20\" dataRow=\"yes\" >");

		if (pp.inputType.equals("checkbox")) {
			out.write("<th align=\"center\" nowrap=\"nowrap\" width=\"3%\" ");

			out.write(">");
			if ("".equals(pp.inputTypeStyle)) {
				out.write("<input type=\"checkbox\" "
						+ (pp.checkboxIsChecked ? "checked=\"checked\" " : "")
						+ " onclick=\"selectAll_CH('" + pp.getTableID()
						+ "',this);\"  >");
			} else {
				out.write("<input type=\"checkbox\"  " + pp.inputTypeStyle
						+ " "
						+ (pp.checkboxIsChecked ? "checked=\"checked\" " : "")
						+ ">");
			}

			out.write("</th>");
		} else if (!pp.inputType.equals("")) {
			out.write("<th align=\"center\" nowrap=\"nowrap\" width=\"3%\">");
			out.write("选");
			out.write("</th>");
		}

		if (pp.isSerialCol()) {
			out.write("<th align=\"center\" width=\"3%\" >");
			out.write(pp.getSerialColName());
			out.write("</th>");
		}

		// 设置列宽
		String columnWidth = pp.getColumnWidth();
		String[] preColumnWidths = columnWidth.split(",");
		String[] columnWidths = new String[columns.size()];

		// 初始化数组
		for (int i = 0; i < columnWidths.length; i++) {
			columnWidths[i] = "0";
		}

		// 接收到的参数个数小于列宽个数
		if (preColumnWidths.length < columns.size()) {
			for (int i = 0; i < preColumnWidths.length; i++) {
				if (!"".equals(preColumnWidths[i]))
					columnWidths[i] = preColumnWidths[i];
			}
		}

		// 接收到的参数个数大于列宽个数
		if (preColumnWidths.length >= columns.size()) {
			for (int i = 0; i < columns.size(); i++) {
				if (!"".equals(preColumnWidths[i]))
					columnWidths[i] = preColumnWidths[i];
			}
		}

		for (int i = 1; i <= columns.size(); i++) {
			// out.write("<col id=\""+pp.getTableID()+"_col"+i+"\">");
			Column column = (Column) columns.get(i - 1);

			if (i <= RSMD.getColumnCount()) {
				width = RSMD.getColumnDisplaySize(i) * 95 / allColumnLen;
			} else {
				width = 10 * 95 / allColumnLen;
			}

			preWidthLength = preWidthLength + width;

			String getFormat = column.getFormat();
			String styleCol = ""; // 隐藏列
			if (getFormat != null && getFormat.indexOf("showHidden") >= 0) {
				styleCol = "display:none;";
			}

			if (!pp.isCancelOrderby() && vc[i - 1] != null
					&& !"".equals(vc[i - 1])) {

				out.write("<th id=\"orderById_CH$_" + pp.getTableID() + "" + i
						+ "\" width=\"" + columnWidths[i - 1] + "\" style=\""
						+ styleCol + "\" nowrap ");

			} else {

				out.write("<th id=\"orderById_CH$_" + pp.getTableID() + "" + i
						+ "\" align=\"center\" width=\"" + columnWidths[i - 1]
						+ "\" style=\"" + styleCol + "\" nowrap ");
			}

			out.write(">");

			out.write(column.getThContent());

			if (!pp.isCancelOrderby() && vc[i - 1] != null
					&& !"".equals(vc[i - 1])) {
				out.write("<span class=\"thSpan\" onClick=\"orderby_CH('"
						+ pp.getTableID() + "','" + vc[i - 1] + "');\" >");
			} else {
				out.write("<span class=\"thSpan\">");
			}

			if (i <= columns.size()) {
				out.write(column.getDisplayColName());

			} else {
				out.write("" + vc[i - 1]);
			}

			int tt = this.getOrderFieldIndex(String.valueOf(i), vc[i - 1],
					orderField);
			if (tt >= 0) {
				if (tt < orderDirection.length
						&& orderDirection[tt].equals("desc")) {
					out.write(DOWN_IMG);
				} else {

					out.write(UP_IMG);
				}
			}
		}

		out.write("</span>");
		out.write("</th></tr>");

	}

	private void printScript(JspWriter out, Map sqlWhereVariable)
			throws Exception {

		out.write("<script language=\"javaScript\">");

		// 搜索要用到的INPUT对象ID
		Iterator swvi = sqlWhereVariable.keySet().iterator();
		String swvi_ = "";
		out.write("var sqlWhereVariables_" + pp.getTableID()
				+ " = new Array();");

		while (swvi.hasNext()) {
			swvi_ = (String) swvi.next();

			out.write(" sqlWhereVariables_" + pp.getTableID() + ".push(\""
					+ swvi_ + "\"); \n");
		}

		out.write("</script>");

	}

	private void selectPage(Writer out, int rowCount, int pageSize,
			int currentPage) throws Exception {

		// out.write("第" + currentPage + "/" + pages + "页&nbsp;&nbsp;");

		int firstPage = 1;
		int lastPage = (rowCount + (pageSize - 1)) / pageSize;
		if (rowCount == 0) {
			lastPage = 1;
		}
		
		// 分页标签默认是剧中对齐，有的情况由于列表字段个数太多所有就可以手动设置对齐方式
		if(!"center".equalsIgnoreCase(pp.getPageAlign())){
			out.write("<div style='text-align:"+pp.getPageAlign()+"'>");
		}
		
		if (currentPage == firstPage) {
			out.write("<span class='dgBtn_disable'>首页</span>");
			out.write("<span class='dgBtn_disable'>上一页</span>");
		} else {
			out.write("<span class='dgBtn_enable' onClick=\"changeGrid_CH('"
					+ pp.getTableID() + "','page_CH',1);\">首页</span>");
			out.write("<span class='dgBtn_enable' onClick=\"changeGrid_CH('"
					+ pp.getTableID() + "','page_CH'," + (currentPage - 1)
					+ ");\">上一页</span>");
		}

		int pageCount = (int) Math.ceil((double) rowCount / pageSize); // 总页数
		int begin = 0;
		int end = 0;
		int center = 10;

		if (currentPage < center && pageCount > center) {
			begin = 1;
			end = center;
		} else if (currentPage < center && pageCount <= center * 2) {
			begin = 1;
			end = pageCount;
		} else if (currentPage == center && pageCount <= center * 2) {
			begin = 1;
			end = pageCount;
		} else if (currentPage == center && pageCount >= center) {
			begin = 1;
			end = currentPage + center;
		} else if (currentPage > center && currentPage + center > pageCount) {
			begin = pageCount - center - (pageCount - currentPage);
			end = pageCount;
		} else if (currentPage > center && currentPage + center <= pageCount) {
			begin = currentPage - center + 1;
			end = currentPage + center;
		}

		for (int i = begin; i <= end; i++) {

			if (i == currentPage) {
				out.write("<span class='dgBtn_curr'>" + i + "</span>");
			} else {
				out.write("<span class='dgBtn_enable' onClick=\"changeGrid_CH('"
								+ pp.getTableID()
								+ "','page_CH',"
								+ i
								+ ");\">" + i + "</span>");
			}
		}

		if (currentPage == lastPage) {
			out.write("<span class='dgBtn_disable'>下一页</span>");
			out.write("<span class='dgBtn_disable'>尾页</span>");
		} else {
			out.write("<span class='dgBtn_enable' onClick=\"changeGrid_CH('"
					+ pp.getTableID() + "','page_CH'," + (currentPage + 1)
					+ ");\" >下一页</span>");
			out.write("<span class='dgBtn_enable' onClick=\"changeGrid_CH('"
					+ pp.getTableID() + "','page_CH'," + pageCount
					+ ");\" >尾页</span>");
		}
		
		
		if(!"center".equalsIgnoreCase(pp.getPageAlign())){
			out.write("</div>");
		}
		
		//		
		// out.write("第" + currentPage + "页&nbsp;&nbsp;共有记录：" + rowCount);
		//			
		// out.write("<input id=\"" + pp.getTableID() + "_rowCount\" name=\""
		// + pp.getTableID() + "_rowCount\" type=\"hidden\" value=\""
		// + rowCount + "\" >");
		// out.write("<input name=\"choose\" type=\"hidden\">");
	}

	public void printCountTr(Connection conn, Writer out, ArrayList columns) {
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String bgColor = "#F3F5F8";
		String value = "";
		try {
			st = conn.createStatement();
			// 移到前面的取总记录数那一段来替换

			rs = st.executeQuery(pp.getFinishCountsql());
			rsmd = rs.getMetaData();
			// int ii = 1;
			for (int j = 0; rs.next(); j++) {
				if (j % 2 == 0) {
					bgColor = "#F3F5F8";
				} else {
					bgColor = "#ffffff";
				}
				out
						.write("<tr height=18 onMouseOver=\"this.bgColor='#E4E8EF';\" onMouseOut=\"this.bgColor='"
								+ bgColor
								+ "';\"  bgColor=\""
								+ bgColor
								+ "\" >");

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					value = rs.getString(i);
					if (!"datagrid_count".equals(rsmd.getColumnName(i))
							&& !"strVoucherids".equals(rsmd.getColumnName(i))
							&& !"otherCount".equals(rsmd.getColumnName(i))) {

						if (i < columns.size()) {

							if (value.length() > 3
									&& "<td".equals(value.substring(0, 3)
											.toLowerCase())) {
								out.write(value);
								continue;
							}
						} else {
							if (value.length() > 3
									&& "<td".equals(value.substring(0, 3)
											.toLowerCase())) {
								out.write(value);
								continue;
							}
						}

					} else if ("strVoucherids".equals(rsmd.getColumnName(i))) {
						pp.extraMap.put("strVoucherids", rs.getString(i));
					} else if ("otherCount".equals(rsmd.getColumnName(i))) {
						pp.extraMap.put("otherCount", rs.getString(i));
					}
				}
				out.write("</tr>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

	public boolean whetherExist(String[] args1, String args2) {
		for (int i = 0; i < args1.length; i++) {
			if (args1[i].equals(args2))
				return true;
		}
		return false;
	}

	public int getOrderFieldIndex(String filedIndex, String filed,
			String[] orderField) {
		for (int i = 0; i < orderField.length; i++) {
			if (filed.equals(orderField[i])) {
				return i;
			}

			if (filedIndex.equals(orderField[i])) {
				return i;
			}
		}

		return -1;
	}

	private void selectPage(Writer out, int rowCount) throws Exception {
		out.write("共有记录：" + rowCount);
	}

	// 替换sqlWhere的值
	private String replaceSqlWhere(String sql) {
		String sqlVariableSentence = "";
		// sql的外部变量替换
		// 存储模式:
		// ${name}
		// 值一般形式是 and id=10
		String[] sqlVariables = null;
		sqlVariables = StringUtil.getVaribles(sql);

		// 定义javascrip变量sqlVariable需要在SQL里使用的页面的input对象ID
		for (int i = 0; i < sqlVariables.length; i++) {
			SqlWhereVariable swv = (SqlWhereVariable) pp.sqlWhere
					.get(sqlVariables[i]);
			if (swv != null && !sqlVariables[i].equals("LIMIT")) {
				// if (swv != null ) {
				sqlVariableSentence = swv.getSentence(session, request,
						response, out, pp.sqlWhereVariable,
						pp.sqlWhereVariable_CH);

				sql = sql.replaceAll("\\$\\{" + sqlVariables[i] + "\\}",
						sqlVariableSentence);

			}
		}

		return sql;
	}

	/**
	 * 得到记录集的行数。
	 * 
	 */
	public int getRowCount(ResultSet RS) {
		// System.out.write("没有分页的sql");
		int rowCount = 0;

		try {
			String rowStatus = "";
			int preRow = 0;

			if (RS.isBeforeFirst()) {
				rowStatus = "isBeforeFirst";
			} else {

				if (RS.isAfterLast()) {
					rowStatus = "isAfterLast";
				} else {
					rowStatus = "normal";
					preRow = RS.getRow();
				}
			}

			RS.last();
			rowCount = RS.getRow();

			if (rowStatus.equals("isBeforeFirst")) {
				RS.beforeFirst();
			} else {

				if (rowStatus.equals("isAfterLast")) {
					RS.afterLast();
				} else {
					RS.absolute(preRow);
				}
			}

		} catch (SQLException e) {
			rowCount = -1;
		}
		return rowCount;
	}

	/**
	 * 得到记录集的行数。
	 * 
	 */
	public int getRowCount(Connection conn, String sql) {
		// System.out.write("分页sql");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rowCount = 0;

		try {
			String strSql = " select count(1) from (" + sql + ") a ";

			System.out.println(strSql);
			ps = conn.prepareStatement(strSql);
			rs = ps.executeQuery();

			if (rs.next()) {
				rowCount = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

	public int getRowCount(Connection conn, String sql, String colname) {
		// System.out.write("分页sql");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rowCount = 0;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				rowCount = rs.getInt(colname);
			}

		} catch (Exception e) {
			rowCount = -1;
			System.out.println("getRowCount:sql=" + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

	/**
	 * 用于给外部处理的 rowIndex、colIndex 从1开始 length 列的长度 value 当前的值
	 */
	public String fieldProcess(int rowIndex, int colIndex, int length,
			ResultSet rs, String colValue, String whichFieldIsValue)
			throws Exception {

		Column column = (Column) pp.columns.get(colIndex - 1);

		DataGridFieldProcess feildProcess = column.getFieldProcess();
		String colContent = column.getColContent();
		String tdProperty = column.getTdProperty();

		String result = "";

		String value = colValue;

		if (colValue == null || colValue.trim().length() == 0) {
			value = "&nbsp;";
		}

		if (feildProcess != null) {
			result = feildProcess.fieldProcess(this.pp, rowIndex, colIndex + 1,
					length, rs, value);
		} else if (colContent != null && colContent.trim().length() > 0) {

			System.out.println("content:" + colContent);
			String content[] = StringUtil.getVaribles(colContent);

			if (content != null) {
				String strParam = null;

				for (int i = 0; i < content.length; i++) {
					try {
						strParam = (String) rs.getString(content[i]);
						if (strParam == null) {
							strParam = "";
						}
					} catch (Exception e) {
						// e.printStackTrace();
					}
					colContent = colContent.replaceAll("\\$\\{" + content[i]
							+ "\\}", strParam);
				}
			}

			result = "<td>" + colContent + "</td>";
		} else if (tdProperty != null && tdProperty.trim().length() > 0) {

//			System.out.println(tdProperty);
			String property[] = StringUtil.getVaribles(tdProperty);

			if (property != null) {
				String strParam = null;

				for (int i = 0; i < property.length; i++) {
					try {
						strParam = (String) rs.getString(property[i]);
						if (strParam == null) {
							strParam = "";
						}
					} catch (Exception e) {
						// e.printStackTrace();
					}
					tdProperty = tdProperty.replaceAll("\\$\\{" + property[i]
							+ "\\}", strParam);
				}
			}

			result = "<td style=\"color:#133db6;\" onmouseover=\"dgTdMouseOver(this);\" onmouseout=\"dgTdMouseOut(this);\" "
					+ tdProperty + " >" + value + "</td>";
		} else {
			// System.out.write("value:" + value);
			result = DealData.format("" + column.getFormat(), value,
					whichFieldIsValue);
		}

		if (pp.TdtoValue != null && !"".equals(pp.TdtoValue.trim())) {
			String tdValue = pp.TdtoValue.trim().replaceAll("\\$\\{value\\}",
					value);

			String tdValue1 = result.substring(result.indexOf(">") + 1, result
					.indexOf("</td>".toLowerCase()));

			tdValue = tdValue.replaceAll("\\$\\{tdvalue\\}", tdValue1);

			result = result.substring(0, result.indexOf(">") + 1) + tdValue
					+ "</td>";

		}

		return result;

	}

	public void invokeSearch(JspWriter out) {
		try {
			out.write("<script>goSearch('" + pp.getTableID() + "');</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setExpExcel(Writer out) {
		try {
			String displayColName = "";
			String colName = "";

			for (int i = 0; i < pp.columns.size(); i++) {
				Column column = (Column) pp.columns.get(i);

				displayColName += column.getDisplayColName() + ",";
				colName += column.getColName() + ",";
			}

			displayColName = displayColName.substring(0, displayColName.length() - 1);
			colName = colName.substring(0, colName.length() - 1);

			out.write("<input type=\"hidden\" id=\"dgExpTableID_" + pp.getTableID() + "\" name=\"dgExpTableID_" + pp.getTableID() + "\" value=\"" + pp.getTableID() + "\" />");
			//有防火墙拦截SQL注入，因些注释掉。
			//out.write("<input type=\"hidden\" id=\"dgExpSql_" + pp.tableID + "\" name=\"dgExpSql_" + pp.tableID + "\" value=\"" + pp.getExpSql() + "\" />");
			out.write("<input type=\"hidden\" id=\"dgExpDisplayColName_" + pp.tableID + "\" name=\"dgExpDisplayColName_" + pp.tableID + "\" value=\"" + displayColName + "\" />");
			out.write("<input type=\"hidden\" id=\"dgExpColName_" + pp.tableID + "\" name=\"dgExpColName_" + pp.tableID + "\" value=\"" + colName + "\" />");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           