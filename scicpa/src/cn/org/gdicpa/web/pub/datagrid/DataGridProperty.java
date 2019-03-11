package cn.org.gdicpa.web.pub.datagrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import cn.org.gdicpa.web.pub.util.StringUtil;

public class DataGridProperty {

	// 分页标签对齐方式
	private String pageAlign = "center";

	// 显示列的值的长度
	private int valueMaxLength = 0;
	
	private boolean expExcel = false;
	
	public boolean isExpExcel() {
		return expExcel;
	}

	public void setExpExcel(boolean expExcel) {
		this.expExcel = expExcel;
	}

	private String bgColor;

	public String bgColorColumn;

	public String bgColorValue;

	public String changBgColorColumn = null;

	private boolean cancelOrderby = false;// 取消排序

	private boolean cancelPage = false;// 取消翻页

	private String checkboxField = "";

	public boolean checkboxIsChecked = false;

	private String checkboxValue = "";
	
	public ArrayList columns = new ArrayList();

	private String columnWidth = "";// 设置单元格宽度

	private boolean complexTitle = true;

	public DataGridFieldProcess dfp = null;

	public String direction_CH = ""; // 升序降序的字段

	public String DOWNROW;

	protected boolean EnableCountTr = true;

	// 当实列化这个类时，需要扩展方法或变量时，就可以用到这个特殊的Map。
	// DataGrid 和DaataGridProperty不会用到这个Map，可以在实列化的时候放心使用
	public HashMap extraMap = new HashMap();

	protected String finishCountsql = null;// 通过DataGrid处理过后的countsql

	protected String finishSQL = "";// 通过DataGrid处理过后的SQL

	// 设置哪些列是否重复就不输出
	private String[] hiddenCol;

	private String inputAction = "";

	private String inputAttribute = "";

	public String inputType = ""; // 列表选中框类型，一般为checkbox或radio
	public String inputTypeStyle = ""; // 表格标题样式

	private String methodCalled = null;

	private String noDataHint;

	private String allCount;

	private String noPrintColName; // 不需要打印的列

	private String notRepalce = ""; // 不被getSqlWhere翻译的字段

	public String orderBy_CH = ""; // orderby的字段
	public String page_CH = ""; // 当前页码
	public int pageSize_CH = 20;

	private String repalcedSQL = ""; // 实际调用别repalceSqlWhere替换的sql
	private String requestUrl = "";

	// 如果调用了goSearch的js方法。那么requestValueXML就包含了所需要的变量的值
	private String requestValueXML;

	protected boolean serialCol = false;
	protected String serialColName = "序";
	
	private String expSql = "";

	public String SQL = ""; // 数据列表的sql语句

	// 每个查询条件
	public HashMap sqlWhere = new HashMap();

	// 每个查询条件对应的中文
	public HashMap sqlWhereCName = new HashMap();

	// 每个查询条件中用到的页面上的INPUT对像的ID(从查询里面取的
	public HashMap sqlWhereVariable = new HashMap();

	public String sqlWhereVariable_CH = ""; // 查询条件变量

	public String tableHead;

	public String tableID = "DataGridTable";

	private String title; // 表格标题

	// private Vector VC_WC = new Vector();
	public String TrAction = ",";

	// 是否用数据字段添加到TR属性
	public boolean TrActionProperty = false;

	public String TrColor;

	public String UPROW;

	public int whichFieldIsValue = -1;

	public String TdtoValue = ""; // 设置td的值显示
	
	private boolean cancelFoot = false; 

	public boolean isCancelFoot() {
		return cancelFoot;
	}

	public void setCancelFoot(boolean cancelFoot) {
		this.cancelFoot = cancelFoot;
	}

	public DataGridProperty() {
		UPROW = "↑";
		DOWNROW = "↓";

	}

	public Column addColumn(String displayColName, String colName)
			throws Exception {
		return this.addColumn(displayColName, colName, null, null, null);
	}

	public Column addColumn(String displayColName, String colName, String format)
			throws Exception {
		return this.addColumn(displayColName, colName, format, null, null);
	}

	public Column addColumn(String displayColName, String colName, String format,
			String fieldProcess, String colContent) throws Exception {
		DataGridFieldProcess dgfp = null;
		if (fieldProcess != null && !"".equals(fieldProcess)) {
			try {
				dgfp = (DataGridFieldProcess) Class.forName(fieldProcess)
						.newInstance();
			} catch (Exception ee) {
				ee.printStackTrace();
				throw new Exception("实例化" + fieldProcess + "时出错！");
			}
		}

		Column column = new Column();
		column.setDisplayColName(displayColName);
		column.setColName(colName);
		column.setFormat(format);
		column.setFieldProcess(dgfp);
		column.setColContent(colContent);

		this.columns.add(column);
		
		return column;
	}

	public void addColumn(String displayColName, String colName, String format,
			String fieldProcess, String colContent, Object obj)
			throws Exception {
		DataGridFieldProcess dgfp = null;

		if (fieldProcess != null && !"".equals(fieldProcess)) {
			try {
				dgfp = (DataGridFieldProcess) Class.forName(fieldProcess)
						.newInstance();
				dgfp.setObj(obj);
			} catch (Exception ee) {
				ee.printStackTrace();
				throw new Exception("实例化" + fieldProcess + "时出错！");
			}
		}

		Column column = new Column();
		column.setDisplayColName(displayColName);
		column.setColName(colName);
		column.setFormat(format);
		column.setFieldProcess(dgfp);
		column.setColContent(colContent);

		this.columns.add(column);
	}

	public void addColumnCustom(String displayColName, String colContent)
			throws Exception {
		this.addColumn(displayColName, null, null, null, colContent);
	}

	public void addColumnFormat(String displayColName, String format)
			throws Exception {
		this.addColumn(displayColName, null, format, null, null);
	}

	public void addInputValue(String id) {
		sqlWhereVariable.put(id, "");
	}

	public void addSqlWhere(String key, String valule) {
		this.sqlWhere.put(key, new SqlWhereVariable(valule));
		this.sqlWhereCName.put(key, key);
	}

	// 新增方法，增加了一个中文参数，方便翻译查询条件
	public void addSqlWhere(String key, String Cname, String valule) {
		this.sqlWhere.put(key, new SqlWhereVariable(valule));
		this.sqlWhereCName.put(key, Cname);
	}

	public void addSqlWhere(String key, String valule, String defaultKey,
			String defaultValue) {
		this.sqlWhere.put(key, new SqlWhereVariable(valule).setDefaultValue(
				defaultKey, defaultValue));
		this.sqlWhereCName.put(key, key);
	}

	public void cleanColumn() {
		columns = new ArrayList();
	}

	public String getBgColor() {
		return bgColor;
	}

	public String getBgColorColumn() {
		return bgColorColumn;
	}

	public String getBgColorValue() {
		return bgColorValue;
	}

	public String getCheckboxField() {
		return checkboxField;
	}

	public String getCheckboxValue() {
		return checkboxValue;
	}

	public String[] getColName() {
		ArrayList columns = this.columns;
		String[] colName = new String[columns.size()];

		for (int i = 0; i < columns.size(); i++) {
			Column column = (Column) columns.get(i);
			colName[i] = column.getColName();
		}

		return colName;
	}

	public ArrayList getColumns() {
		return columns;
	}

	public String getColumnWidth() {
		return columnWidth;
	}

	public int getCurrentPage_CH() {
		return Integer.parseInt(this.page_CH);
	}

	public DataGridFieldProcess getDfp() {
		return dfp;
	}

	// public String getDatabaseDepartID() {
	// return databaseDepartID;
	// }
	//
	// public void setDatabaseDepartID(String databaseDepartID) {
	// this.databaseDepartID = databaseDepartID;
	// }

	public String getDirection_CH() {
		return direction_CH;
	}

	public String getDOWNROW() {
		return DOWNROW;
	}

	public HashMap getExtraMap() {
		return extraMap;
	}

	// public void setDisplayColName(String[] displayColName) {
	// this.displayColName = displayColName;
	// }

	public String getFinishCountsql() {
		return finishCountsql;
	}

	public String getFinishSQL() {
		return finishSQL;
	}

	public String getFinishSQLDeleteLimit() {
		return finishSQL.replaceAll("\\$\\{LIMIT\\}", " ");
	}

	public String[] getHiddenCol() {
		return hiddenCol;
	}

	public String getInputAction() {
		return inputAction;
	}

	public String getInputAttribute() {
		return inputAttribute;
	}

	public String getInputType() {
		return inputType;
	}

	public String getInputTypeStyle() {
		return inputTypeStyle;
	}

	public String getMethodCalled() {
		return methodCalled;
	}

	public String getNoDataHint() {
		return this.noDataHint;
	}

	public String getNoPrintColName() {

		return noPrintColName;
	}

	public String getNotRepalce() {
		return notRepalce;
	}

	public String getOrderBy_CH() {
		return orderBy_CH;
	}

	public String getPage_CH() {
		return page_CH;
	}

	public int getPageSize_CH() {
		return pageSize_CH;
	}

	public String getRepalcedSQL() {
		return repalcedSQL;
	}

	public String getRequestUrl() {
		return this.requestUrl;
	}

	public String getRequestValue(String id) {
		return StringUtil.getXMLData(requestValueXML, id);
	}

	public String getRequestValueXML() {
		return requestValueXML;
	}

	public String getSerialColName() {
		return serialColName;
	}

	public String getSql() {
		return SQL;
	}

	public String getSQL() {
		return SQL;
	}

	public HashMap getSqlWhere() {
		return sqlWhere;
	}

	public HashMap getSqlWhereCName() {
		return sqlWhereCName;
	}

	public HashMap getSqlWhereVariable() {
		return sqlWhereVariable;
	}

	public String getSqlWhereVariable_CH() {
		return sqlWhereVariable_CH;
	}

	public String getTableHead() {
		return tableHead;
	}

	//
	// public void setOrAddPreSqlWhereValue(String key,String value){
	// if(sqlWhereVariable_CH.indexOf("<"+key+">")==-1){
	// sqlWhereVariable_CH+="<"+key+">"+value+"</"+key+">";
	// }else{
	// sqlWhereVariable_CH=CHF.setXMLData(sqlWhereVariable_CH, key,value);
	// }
	//
	// }

	public String getTableID() {
		return tableID;
	}

	public String getTitle() {
		return title;
	}

	public String getTrAction() {
		return TrAction;
	}

	public String getTrColor() {
		return TrColor;
	}

	public String getUPROW() {
		return UPROW;
	}

	public int getWhichFieldIsValue() {
		return whichFieldIsValue;
	}

	/**
	 * 输出到js的搜索变量名称 使用map的原因是不会出现重复的key
	 * 
	 * @return
	 */
	public void initScriptVariable() {

		for (Iterator it = sqlWhere.keySet().iterator(); it.hasNext();) {
			SqlWhereVariable swv = (SqlWhereVariable) sqlWhere.get(it.next());
			String[] tt = StringUtil.getVaribles(swv.getSourceSentence());
			for (int i = 0; tt != null && i < tt.length; i++) {
				sqlWhereVariable.put(tt[i], "");
			}
		}
	}

	public boolean isCancelOrderby() {
		return cancelOrderby;
	}

	public boolean isCancelPage() {
		return cancelPage;
	}

	public boolean isCheckboxIsChecked() {
		return checkboxIsChecked;
	}

	public boolean isComplexTitle() {
		return complexTitle;
	}

	public boolean isEnableCountTr() {
		return EnableCountTr;
	}

	public boolean isSerialCol() {
		return serialCol;
	}

	public boolean isTrActionProperty() {
		return TrActionProperty;
	}

	public void onSearch(javax.servlet.http.HttpSession session,
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws Exception {

	}

	/**
	 * 专为ONSEARCH方法自己获得STRSQL，去搞定汇总等值使用 使用范例：参考凭证查询的相关代码段
	 * 
	 * @param strSql
	 * @return
	 */
	public String replaceSqlWhere(String strSql) {

		if (strSql != null) {

			String[] sqlVariables = null;
			sqlVariables = StringUtil.getVaribles(strSql);

			String sqlVariableSentence = "";

			// 定义javascrip变量sqlVariable需要在SQL里使用的页面的input对象ID
			for (int i = 0; i < sqlVariables.length; i++) {
				SqlWhereVariable swv = (SqlWhereVariable) sqlWhere
						.get(sqlVariables[i]);
				if (swv != null && !sqlVariables[i].equals("LIMIT")) {
					sqlVariableSentence = swv.getSentence(null, null, null,
							null, sqlWhereVariable, requestValueXML);
					// sqlWhereVariable_CH);

					// CHF.getXMLData(requestValueXML, id);

					strSql = strSql.replaceAll("\\$\\{" + sqlVariables[i]
							+ "\\}", sqlVariableSentence);
				}
			}
		}

		return strSql;

	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public void setBgColorColumn(String bgColorColumn) {
		this.bgColorColumn = bgColorColumn;
	}

	public void setBgColorValue(String bgColorValue) {
		this.bgColorValue = bgColorValue;
	}

	public void setCancelOrderby(boolean cancelOrderby) {
		this.cancelOrderby = cancelOrderby;
	}

	/**
	 * 是否翻页
	 * 
	 * @param cancelPage
	 *            boolean
	 */
	public void setCancelPage(boolean cancelPage) {
		this.cancelPage = cancelPage;
	}

	public void setCheckboxField(String checkboxField) {
		this.checkboxField = checkboxField;
	}

	public void setCheckboxIsChecked(boolean checkboxIsChecked) {
		this.checkboxIsChecked = checkboxIsChecked;
	}

	/**
	 * set checkbox is checked
	 * 
	 * @param checkboxField
	 * @param checkboxValue
	 */
	public void setCheckboxIsChecked(String checkboxField, String checkboxValue) {
		this.checkboxField = checkboxField;
		this.checkboxValue = checkboxValue;
	}

	public void setCheckboxValue(String checkboxValue) {
		this.checkboxValue = checkboxValue;
	}

	public void setColumnWidth(String columnWidth) {
		this.columnWidth = columnWidth;
	}

	public void setComplexTitle(boolean complexTitle) {
		this.complexTitle = complexTitle;
	}

	public void setDataGridFieldProcess(String dataGridFieldProcess)
			throws Exception {
		Class c = Class.forName(dataGridFieldProcess);
		this.dfp = (DataGridFieldProcess) c.newInstance();
	}

	public void setDfp(DataGridFieldProcess dfp) {
		this.dfp = dfp;
	}

	public void setDirection(String direction_CH) {
		this.direction_CH = direction_CH;
	}

	public void setDirection_CH(String direction_CH) {
		this.direction_CH = direction_CH;
	}

	public void setDOWNROW(String downrow) {
		DOWNROW = downrow;
	}

	public void setEnableCountTr(boolean enableCountTr) {
		EnableCountTr = enableCountTr;
	}

	public void setExtraMap(HashMap extraMap) {
		this.extraMap = extraMap;
	}

	public void setFinishCountsql(String finishCountsql) {
		this.finishCountsql = finishCountsql;
	}

	public void setFinishSQL(String finishSQL) {
		this.finishSQL = finishSQL;
	}

	public void setHiddenCol(String[] hiddenCol) {
		this.hiddenCol = hiddenCol;

		// hiddenCol格式化成小写
		if (hiddenCol != null) {
			for (int i = 0; i < hiddenCol.length; i++) {
				if (hiddenCol[i] != null) {
					this.hiddenCol[i] = hiddenCol[i].toLowerCase();
				}
			}
		}
	}

	/**
	 * 设置checkbox或radio的事件属性
	 * 
	 * @param inputAction
	 */
	public void setInputAction(String inputAction) {
		for (int i = -1, j = 0; (i = inputAction.indexOf("${", j)) >= 0
				&& (j = inputAction.indexOf("}", i)) >= 0;) {
			i += 2;
			inputAction = inputAction.substring(0, i)
					+ inputAction.substring(i, j).toLowerCase()
					+ inputAction.substring(j);
		}

		this.inputAction = inputAction;

		System.out.println("qwh:setInputAction:inputAction" + inputAction);

	}

	/**
	 * 设置checkbox或radio的属性
	 * 
	 * @param inputAction
	 */
	public void setInputAttribute(String inputAttribute) {
		for (int i = -1, j = 0; (i = inputAttribute.indexOf("${", j)) >= 0
				&& (j = inputAttribute.indexOf("}", i)) >= 0;) {
			i += 2;
			inputAttribute = inputAttribute.substring(0, i)
					+ inputAttribute.substring(i, j).toLowerCase()
					+ inputAttribute.substring(j);
		}

		this.inputAttribute = inputAttribute;
	}

	public void setInputType(String s) {
		inputType = s;
	}

	/**
	 * 与setInputType()一起用
	 * 
	 * @param s
	 */
	public void setInputTypeStyle(String s) {
		inputTypeStyle = s;
	}

	public void setMethodCalled(String methodCalled) {
		this.methodCalled = methodCalled;
	}

	public void setNoDataHint(String noDataHint) {
		this.noDataHint = noDataHint;
	}

	/**
	 * 设置不需要打印的列,例如:"p1,p2,p3",对应sql中的列
	 * 
	 * @param noPrintColName
	 */
	public void setNoPrintColName(String noPrintColName) {
		this.noPrintColName = noPrintColName;
	}

	public void setNotRepalce(String notRepalce) {
		this.notRepalce = notRepalce;
	}

	public void setOrAddRequestValue(String id, String value) {
		if (requestValueXML.indexOf("<" + id + ">") == -1) {
			requestValueXML += "<" + id + ">" + value + "</" + id + ">";
		} else {
			requestValueXML = StringUtil.setXMLData(requestValueXML, id, value);
		}

	}

	public void setOrderBy_CH(String orderBy_CH) {
		this.orderBy_CH = orderBy_CH.toLowerCase();
	}

	public void setPage_CH(String page_CH) {
		this.page_CH = page_CH;
	}

	public void setPage_xml(String xml, String tp, String vl,
			javax.servlet.http.HttpSession session,
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws Exception {

		if ("orderByAdd_CH_ASC".equals(tp)) {
			String orderByValue = StringUtil.getXMLData(xml, "orderBy_CH");
			String directionValue = StringUtil.getXMLData(xml, "direction_CH");

			if (orderByValue.trim().length() > 0) {

				// 只有一个值
				if (orderByValue.indexOf(",") == -1
						&& directionValue.trim().length() <= 0) {
					directionValue = "asc";
				}

				int orderByValueComma = StringUtil.getStrDisplayTime(
						orderByValue, ",");
				int directionValueComma = StringUtil.getStrDisplayTime(
						directionValue, ",");
				for (int i = 0, t = orderByValueComma - directionValueComma; i < t; i++) {
					directionValue += ",asc";
				}
			}

			if (orderByValue.equals(vl)) {
				xml = StringUtil.setXMLData(xml, "direction_CH", "asc");
			} else {
				String[] aOrderByValue = orderByValue.split(",");
				String[] aDirectionValue = directionValue.split(",");

				boolean bSign = false;// 以前排序字段是否包含当前用户单击排序字段
				orderByValue = "";
				directionValue = "";
				for (int i = 0; i < aOrderByValue.length; i++) {
					if (vl.equals(aOrderByValue[i])) {

						orderByValue += aOrderByValue[i] + ",";
						directionValue += "asc,";

						bSign = true;
					} else {
						orderByValue += aOrderByValue[i] + ",";
						directionValue += aDirectionValue[i] + ",";
					}
				}

				if (bSign) {
					// 去掉最后一个token
					orderByValue = StringUtil.killEndToken(orderByValue, ",");
					directionValue = StringUtil.killEndToken(directionValue,
							",");
				} else {
					orderByValue += vl;
					directionValue += "asc";
				}

				xml = StringUtil.setXMLData(xml, "orderBy_CH", orderByValue);
				xml = StringUtil
						.setXMLData(xml, "direction_CH", directionValue);
			}

			if (orderByValue.trim().length() > 0) {
				vl = orderByValue + "," + vl;
			}

		}

		if ("orderByAdd_CH_DESC".equals(tp)) {
			String orderByValue = StringUtil.getXMLData(xml, "orderBy_CH");
			String directionValue = StringUtil.getXMLData(xml, "direction_CH");

			if (orderByValue.trim().length() > 0) {

				if (orderByValue.indexOf(",") == -1
						&& directionValue.trim().length() <= 0) {
					directionValue = "asc";
				}

				int orderByValueComma = StringUtil.getStrDisplayTime(
						orderByValue, ",");
				int directionValueComma = StringUtil.getStrDisplayTime(
						directionValue, ",");
				for (int i = 0, t = orderByValueComma - directionValueComma; i < t; i++) {
					directionValue += ",asc";
				}
			}

			if (orderByValue.equals(vl)) {
				xml = StringUtil.setXMLData(xml, "direction_CH", "desc");
			} else {
				String[] aOrderByValue = orderByValue.split(",");
				String[] aDirectionValue = directionValue.split(",");

				boolean bSign = false;// 以前排序字段是否包含当前用户单击排序字段

				orderByValue = "";
				directionValue = "";
				for (int i = 0; i < aOrderByValue.length; i++) {
					if (vl.equals(aOrderByValue[i])) {

						orderByValue += aOrderByValue[i] + ",";
						directionValue += "desc,";
						bSign = true;
					} else {
						orderByValue += aOrderByValue[i] + ",";
						directionValue += aDirectionValue[i] + ",";
					}
				}

				if (bSign) {
					// 去掉最后一个token
					orderByValue = StringUtil.killEndToken(orderByValue, ",");
					directionValue = StringUtil.killEndToken(directionValue,
							",");
				} else {
					orderByValue += vl;
					directionValue += "desc";
				}

				xml = StringUtil.setXMLData(xml, "orderBy_CH", orderByValue);
				xml = StringUtil
						.setXMLData(xml, "direction_CH", directionValue);
			}

			if (orderByValue.trim().length() > 0) {
				vl = orderByValue + "," + vl;
			}

		}

		if ("orderBy_CH".equals(tp)) {
			String orderByValue = StringUtil.getXMLData(xml, "orderBy_CH");
			String directionValue = StringUtil.getXMLData(xml, "direction_CH");
			if (orderByValue.equals(vl) && !directionValue.equals("desc")) {
				xml = StringUtil.setXMLData(xml, "direction_CH", "desc");
			} else {
				xml = StringUtil.setXMLData(xml, "direction_CH", "asc");
			}
		}

		// 如果是查询条件，或者改变pageSize，那么自动跳回第一页
		if ("sqlWhereVariable_CH".equals(tp) || "pageSize_CH".equals(tp)) {
			xml = StringUtil.setXMLData(xml, "page_CH", "1");
		}
		// 如果是查询，就会默认调用onSearch()方法
		if ("sqlWhereVariable_CH".equals(tp)) {
			requestValueXML = vl;
			onSearch(session, request, response);
			vl = requestValueXML;
			xml = StringUtil.setXMLData(xml, tp, vl);
		} else {
			xml = StringUtil.setXMLData(xml, tp, vl);
			this.setDirection_CH(StringUtil.getXMLData(xml, "direction_CH"));
			this.setOrderBy_CH(StringUtil.getXMLData(xml, "orderBy_CH"));
			this.setPage_CH(StringUtil.getXMLData(xml, "page_CH"));
			this.setPageSize_CH(StringUtil.getXMLData(xml, "pageSize_CH"));
		}

		this.setSqlWhereVariable_CH(StringUtil.getXMLData(xml,
				"sqlWhereVariable_CH"));

	}

	public void setPageSize_CH(int pageSize_CH) {
		this.pageSize_CH = pageSize_CH;
	}

	public void setPageSize_CH(String pageSize_CH) {
		if ("".equals(pageSize_CH)) {
			this.setPageSize_CH(1);
		} else {
			int pageSize_CH_int = Integer.parseInt(pageSize_CH);
			this.setPageSize_CH(pageSize_CH_int);
		}
	}

	public void setRepalcedSQL(String repalcedSQL) {
		this.repalcedSQL = repalcedSQL;
	}

	// 保存前台提交的URL
	public void setRequestUrl(HttpServletRequest request) {
		requestUrl = request.getRequestURL().toString();
		if (request.getQueryString() != null) {
			requestUrl += '?' + request.getQueryString();
		}
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void setRequestValue(String id, String value) {
		requestValueXML = StringUtil.setXMLData(requestValueXML, id, value);
	}

	public void setRequestValueXML(String requestValueXML) {
		this.requestValueXML = requestValueXML;
	}

	public void setSerialCol(boolean serialCol) {
		this.serialCol = serialCol;
	}

	public void setSerialColName(String serialColName) {
		this.serialColName = serialColName;
	}

	public void setSQL(String s) {
		SQL = s;
	}

	public void setSqlWhere(HashMap sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	public void setSqlWhereCName(HashMap sqlWhereCName) {
		this.sqlWhereCName = sqlWhereCName;
	}

	public void setSqlWhereVariable(HashMap sqlWhereVariable) {
		this.sqlWhereVariable = sqlWhereVariable;
	}

	public void setSqlWhereVariable_CH(String sqlWhereVariable_CH) {
		this.sqlWhereVariable_CH = sqlWhereVariable_CH;
	}

	// 手动设置表头
	public void setTableHead(String tableHead) {

		this.tableHead = tableHead;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTrAction(String TrAction) {

		for (int i = -1, j = 0; (i = TrAction.indexOf("${", j)) >= 0
				&& (j = TrAction.indexOf("}", i)) >= 0;) {
			i += 2;
			TrAction = TrAction.substring(0, i)
					+ TrAction.substring(i, j).toLowerCase()
					+ TrAction.substring(j);
		}

		this.TrAction = TrAction;
	}

	public void setTrActionProperty(boolean trActionProperty) {
		TrActionProperty = trActionProperty;
	}

	/**
	 * 修改TR的bgColor 通过判断bgColorColumn的值来改变bgColor
	 * 
	 * @param bgColorColumn
	 * @param bgColorValue
	 * @param TrColor
	 */
	public void setTrBgColor(String bgColorColumn, String bgColorValue,
			String TrColor) {
		this.bgColorColumn = bgColorColumn;
		this.bgColorValue = bgColorValue;
		this.TrColor = TrColor;
	}

	/**
	 * 将单击后事件集成到Datagrid
	 * 
	 * @param bgColorColumn
	 * @param bgColorValue
	 * @param TrColor
	 */
	public void setTrBgColor(String bgColorColumn, String bgColorValue,
			String TrColor, String methodCalled) {
		this.bgColorColumn = bgColorColumn;
		this.bgColorValue = bgColorValue;
		this.TrColor = TrColor;
		this.methodCalled = methodCalled;
	}

	public void setTrColor(String trColor) {
		TrColor = trColor;
	}

	public void setUPROW(String uprow) {
		UPROW = uprow;
	}

	public void setWhichFieldIsValue(int s) {
		// 页面上统一从1开始，但是实际上是从0开始
		s--;
		whichFieldIsValue = s;
	}

	public String getAllCount() {
		return allCount;
	}

	public void setAllCount(String allCount) {
		this.allCount = allCount;
	}

	public String getChangBgColorColumn() {
		return changBgColorColumn;
	}

	public void setChangBgColorColumn(String changBgColorColumn) {
		this.changBgColorColumn = changBgColorColumn;
	}

	public String getTdtoValue() {
		return TdtoValue;
	}

	/**
	 * 设置td的值显示，例<a href='St://${value}'>${tdvalue}</a>
	 * 
	 * ${tdvalue} 为td的显示的值，保留字 ${value} 为当前rs的值
	 * 
	 * @param tdtoValue
	 */
	public void setTdtoValue(String tdtoValue) {
		TdtoValue = tdtoValue;
	}

	public String getExpSql() {
		return expSql;
	}

	public void setExpSql(String expSql) {
		this.expSql = expSql;
	}

	public String getPageAlign() {
		return pageAlign;
	}

	public void setPageAlign(String pageAlign) {
		this.pageAlign = pageAlign;
	}

	public int getValueMaxLength() {
		return valueMaxLength;
	}

	public void setValueMaxLength(int valueMaxLength) {
		this.valueMaxLength = valueMaxLength;
	}
   
}
