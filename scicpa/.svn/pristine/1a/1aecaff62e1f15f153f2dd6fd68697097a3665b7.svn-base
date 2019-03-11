package cn.org.gdicpa.web.pub.datagrid;

/**
 * <p>Title: DataGrid每列的属性</p>
 * <p>Description: DataGrid每列的属性</p>
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
 * 2007-6-12
 */
public class Column {
	//显示的列名
	private String displayColName="";
	//displayColName对应的数据字段名
	private String colName="";
	//显示到jsp的格式
	private String format="";
	//特殊处理类
	private DataGridFieldProcess fieldProcess;
	//自定义输出
	private String colContent="";
	
	private String thContent = "";
	
	public String getThContent() {
		return thContent;
	}
	public Column setThContent(String thContent) {
		this.thContent = thContent;
		
		return this;
	}
	private String tdProperty = "";

	public String getTdProperty() {
		return tdProperty;
	}
	public Column setTdProperty(String tdProperty) {
		this.tdProperty = tdProperty;
		
		return this;
	}
	public String getColContent() {
		return colContent;
	}
	public Column setColContent(String colContent) {
		if(colContent!=null)
		this.colContent = colContent;
		
		return this;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		if(colName!=null)
		this.colName = colName.toLowerCase();
	}
	public String getDisplayColName() {
		return displayColName;
	}
	public void setDisplayColName(String displayColName) {
		if(displayColName!=null)
		this.displayColName = displayColName;
	}
	public DataGridFieldProcess getFieldProcess() {
		return fieldProcess;
	}
	public void setFieldProcess(DataGridFieldProcess fieldProcess) {
		this.fieldProcess = fieldProcess;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		if(format!=null)
		this.format = format;
	}

}
