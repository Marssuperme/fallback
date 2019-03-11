package cn.org.gdicpa.web.service.bbCommon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import cn.org.gdicpa.web.pub.db.DBConnect;

/**
 * 1. 拼凑 sql
 * 	a. 拼凑 列名
 * 	b. 关联表名
 * 2. 设置 datagrid 要显示的列
 * 	a. 存储  字段、中文列名、对齐类型 
 * @author 强悍的 qiu ye
 *
 */
public class BbService {
	private static final String CONFIG_FILE = "bbConfig.xml";
	private static final String CONFIGSQL_FILE = "bbSqlConfig.xml";
	
	private String sql = null;
	private List column = new ArrayList();		// 字段名
	private List columnName = new ArrayList();	// 中文列名
	private List align = new ArrayList();		// 对齐类型   [ left  right   center ]
	private List columnWidth = new ArrayList();	// 列的宽度   [ left  right   center ]
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List getColumnName() {
		return columnName;
	}

	public void setColumnName(List columnName) {
		this.columnName = columnName;
	}

	public List getColumn() {
		return column;
	}

	public void setColumn(List column) {
		this.column = column;
	}
	
	public List getAlign() {
		return align;
	}

	public void setAlign(List align) {
		this.align = align;
	}
	
	
	public List getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(List columnWidth) {
		this.columnWidth = columnWidth;
	}

	/**
	 * jdom  读取 xml    
	 * @param typeId
	 * @throws Exception
	 */
	public void setSqlByXml(String typeId) throws Exception {
		// 这句话 服务器上面出现乱码
		String classPath = DBConnect.class.getClassLoader().getResource(".").getPath();
		System.out.println(this.getClass()+"      classPath="+classPath);
		classPath = this.getClass().getResource("/").getPath();
		System.out.println(this.getClass()+"      classPath="+classPath);
		
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(new FileInputStream(classPath + CONFIG_FILE));
		Element root = doc.getRootElement();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select ");
		
		// 报备表
		Element mainElement = root.getChild("mainTable");
		String mainTableName = mainElement.getAttribute("tableName").getValue();
		String mainColumn = mainElement.getChild("column").getValue();
		String mainColumnName = mainElement.getChild("columnName").getValue();
		if("dxzhpg001".equals(typeId) || "jrblpg001".equals(typeId) || "qyjzpg001".equals(typeId) || "qtzcpg001".equals(typeId)){
			mainColumnName = mainColumnName.replaceAll("注师", "评估师");
		}
		String mainAlign = mainElement.getChild("align").getValue();
		String mainColumnWidth = mainElement.getChild("columnWidth").getValue();
		
		// 报备表 中的列名
		sql.append(mainColumn).append(",");
		
		
		// 事务所表
		Element companyElement = root.getChild("companyTable");
		String companyTableName = companyElement.getAttribute("tableName").getValue();
		String companyColumn = companyElement.getChild("column").getValue();
		String companyColumnName = companyElement.getChild("columnName").getValue();
		String companyAlign = companyElement.getChild("align").getValue();
		String companyColumnWidth = companyElement.getChild("columnWidth").getValue();
		
		// 事务所表 中的列名
		sql.append(companyColumn).append(",");
		
		
		// 所有的 分类 报备表  [验资、审计、外汇年检......]
		List list = root.getChild("tables").getChildren("table");
		
		String column = null;
		String columnName = null;
		String tableName = null;	
		String align = null;	
		String columnWidth = null;
		Element bbElement = null;
		
		for (int i = 0; i < list.size(); i++) {
			bbElement = (Element)list.get(i);
			
			if(bbElement != null && bbElement.getAttribute("typeId") != null) {
				String tempTypeId = bbElement.getAttribute("typeId").getValue();
				
				if(typeId.equalsIgnoreCase(tempTypeId)) {
					tableName = bbElement.getAttribute("tableName").getValue();
					column = bbElement.getChild("column").getValue();
					columnName = bbElement.getChild("columnName").getValue();
					align = bbElement.getChild("align").getValue();
					columnWidth = bbElement.getChild("columnWidth").getValue();
					break;
				}
			}
		}
		
		//对应的  分类报备表 中的 列名
		sql.append(column).append("  ");
		
		// 报备表 left join 事务所表 on 报备表.companyguid = 事务所表.guid
		sql.append(" from ")
			.append(mainTableName)
			.append(" left join ")
			.append(companyTableName)
			.append(" on ")
			.append(mainTableName).append(".companyguid=").append(companyTableName).append(".guid");
		
		// left join 报备分类表 on 报备表.guid = 报备分类表.guid
		if(tableName != null) {
			sql.append(" left join ")
				.append(tableName)
				.append(" on ")
				.append(mainTableName).append(".guid=").append(tableName).append(".guid");
		}
		
		
		// 报备表 字段
		String[] mainCol = mainColumn.split(",");
		// 报备表中文列名
		String[] mainColName = mainColumnName.split(",");
		
		// 报备表 字段内容 对齐 类型
		String[] mainColAlign = mainAlign.split(",");
		// 报备表 字段内容 宽度
		String[] mainColWidth = mainColumnWidth.split(",");
		for (int i = 0; i < mainCol.length; i++) {
			this.column.add(mainCol[i]);
			this.columnName.add(mainColName[i]);
			this.align.add(mainColAlign[i]);
			this.columnWidth.add(mainColWidth[i]);
		}
		
		// 分类表 字段
		String[] col = column.split(",");
		// 分类表中文列名
		String[] colName = columnName.split(",");
		// 分类表 字段内容 对齐 类型
		String[] colAlign = align.split(",");
		// 分类表 字段内容 宽度
		String[] colWidth = columnWidth.split(",");
		for (int i = 0; i < col.length; i++) {
			if("BB_WHNJB.bz".equalsIgnoreCase(col[i]) && "bb_whnjb".equalsIgnoreCase(tableName)){
				this.column.add("bz");
			}else{
				this.column.add(col[i]);
			}

			this.columnName.add(colName[i]);
			this.align.add(colAlign[i]);
			this.columnWidth.add(colWidth[i]);
		}
		
		
		// 事务所表 字段
		String[] companyCol = companyColumn.split(",");
		// 事务所表中文列名
		String[] companyColName = companyColumnName.split(",");
		// 事务所表 字段内容 对齐 类型
		String[] companyColAlign = companyAlign.split(",");
		// 事务所表 字段内容 宽度
		String[] companyColWidth = companyColumnWidth.split(",");
		for (int i = 0; i < companyCol.length; i++) {
			this.column.add(companyCol[i]);
			this.columnName.add(companyColName[i]);
			this.align.add(companyColAlign[i]);
			this.columnWidth.add(companyColWidth[i]);
		}
		
		this.sql = sql.toString();
	}


	/**
	 * 根据报备编号类型 or 报备类型得到 sql和tableName
	 * @param type
	 * @return
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 */
	public Map getSqlByType(String type) throws FileNotFoundException, JDOMException, IOException{
		System.out.println("======PPP " +type);
		Map map = null;
		// 事务所信息
		String bb_companyListCol = "";
		String bb_companyListColValue = "";
		String bb_companyListTableName = "";
		String bb_companyListColStartIndex = "";
		String bb_companyListColEndIndex = "";

		// 报备内容一信息
		String bb_content1Col = "";
		String bb_content1ColName = "";
		String bb_content1ColValue = "";
		String bb_content1TableName = "";
		String bb_content1ColStartIndex = "";
		String bb_content1ColEndIndex = "";
		
		// 报备内容二信息
		String bb_detailCol = "";
		String bb_detailColName = "";
		String bb_detailColValue = "";
		String bb_detailTableName = "";
		String bb_detailColStartIndex = "";
		String bb_detailColEndIndex = "";
		
		
		String classPath = this.getClass().getResource("/").getPath();
		
		SAXBuilder sb = new SAXBuilder();
		System.out.println("classPath="+(classPath + CONFIGSQL_FILE));
		Document doc = sb.build(new FileInputStream(classPath + CONFIGSQL_FILE));
		System.out.println("classPath="+(classPath + CONFIGSQL_FILE));
		Element root = doc.getRootElement();
		
		// 报备表
		Element mainElement = root.getChild("mainTable");
		if("单项资产或资产组合评估".equals(type) || "金融不良资产评估".equals(type) || "企业价值评估".equals(type) || "其他资产评估".equals(type)){
			mainElement = root.getChild("mainTable2");
		}
		bb_content1TableName = mainElement.getAttribute("tableName").getValue();
		bb_content1Col = mainElement.getChild("column").getValue();
		bb_content1ColName = mainElement.getChild("columnName").getValue();
		bb_content1ColValue = mainElement.getChild("columnValue").getValue();
		bb_content1ColStartIndex = mainElement.getChild("columnStartIndex").getValue();
		bb_content1ColEndIndex = mainElement.getChild("columnEndIndex").getValue();
		
		// 事务所表
		Element companyElement = root.getChild("companyTable");
		bb_companyListTableName = companyElement.getAttribute("tableName").getValue();
		bb_companyListCol = companyElement.getChild("column").getValue();
		bb_companyListColValue = companyElement.getChild("columnValue").getValue();
		bb_companyListColStartIndex = companyElement.getChild("columnStartIndex").getValue();
		bb_companyListColEndIndex = companyElement.getChild("columnEndIndex").getValue();
		
		// 所有的 分类 报备表  [验资、审计、外汇年检......]
		List list = root.getChild("tables").getChildren("table");
		
		Element bbElement = null;
		String typeId = "";
		String typeName = "";
		for (int i = 0; i < list.size(); i++) {
			bbElement = (Element)list.get(i);
			
			if(bbElement != null && bbElement.getAttribute("typeId") != null) {
				typeId = bbElement.getAttribute("typeId").getValue();
				typeName = bbElement.getAttribute("typeName").getValue();
				if(type.equalsIgnoreCase(typeId) || type.equals(typeName)) {
					bb_detailTableName = bbElement.getAttribute("tableName").getValue();
					bb_detailCol = bbElement.getChild("column").getValue();
					bb_detailColName = bbElement.getChild("columnName").getValue();
					bb_detailColValue = bbElement.getChild("columnValue").getValue();
					bb_detailColStartIndex= bbElement.getChild("columnStartIndex").getValue();
					bb_detailColEndIndex = bbElement.getChild("columnEndIndex").getValue();
					break;
				}
			}
		}
		map = new HashMap();
		// 事务所
		map.put("companyListTable", bb_companyListTableName);
		map.put("companyListCol",bb_companyListCol);
		map.put("companyListColValue",bb_companyListColValue);
		map.put("companyListColStartIndex",bb_companyListColStartIndex);
		map.put("companyListColEndIndex",bb_companyListColEndIndex);

		// 报备内容一
		map.put("content1Table",bb_content1TableName);
		map.put("content1Col",bb_content1Col);
		map.put("content1ColName",bb_content1ColName);
		map.put("content1ColValue",bb_content1ColValue);
		map.put("content1ColStartIndex",bb_content1ColStartIndex);
		map.put("content1ColEndIndex",bb_content1ColEndIndex);
		
		// 报备内容二
		map.put("detailTable", bb_detailTableName);
		map.put("detailCol",bb_detailCol);
		map.put("detailColName",bb_detailColName);
		map.put("detailColValue",bb_detailColValue);
		map.put("detailColStartIndex",bb_detailColStartIndex);
		map.put("detailColEndIndex",bb_detailColEndIndex);
		
		map.put("typeName", typeName);
		System.out.println(this.getClass()+"             ##: map="+map);
		
		return map;
	}
	
	
	
	public Map getMapInfo(){
		Map map = new HashMap();
		String classPath = this.getClass().getResource("/").getPath();
		map.put("classPath", classPath);
		return map;
	}
	
	
	public static void main(String[] args) {
		
		/**   bb_content1
		 *  companyguid,guid,typeid,wtdwmc,
			bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,
			yyzzhm,zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,
			lxrdh,wtxmlx,ywyds,qyrq,bgwh,xmmc,bgrq,bgnd,fcbgfs,qmzyszl,qmzs1,
			qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,zlry,sfyj,ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword,bbperson,
			bbtime,bbstate,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,bbbh,bbreason,zfperson,reviewerid,reviewername,reviewtime,
			reason,isreviewed,ywarea,bgnd2,bz,reportcount,linkman,linkphone
		 */
		
		/**	 bb_companylist
		 *   Guid,Loginid,CompanyName,LanguageSelectName,Person,Phone,Faxes,Post,Address,Email,Url,area
		 */
		
		
		 
		
		/**  BB_BBQTB
		 *   GUID,QTCBDXM,bustype
		 */
		
		/**  BB_CCSSSQKCJJB
		 *    GUID,CCSSLB,KHSBSSJE,JZSSJE,BGYJLX,NotBLYJLY,BLYJLY
		 */
		
		
		

		/**  BB_KJDSHB
		 *   GUID,PJJS
		 */
		
		
		/**  BB_KJZSB
		 *   GUID,zsxm
		 */
		
		/**  BB_QCHZB
		 *   GUID,ZCZE,FZZE,JZZE
		 */
		
		/**  BB_QSSHB
		 *   GUID,QSLX,QSJSY,QSSD,YLSSDE,YLSDE,BGYJLX,NotBLYJLY,BJYJLY
		 */
		
		/**  BB_QTSSJJB
		 *   GUID,SRZE,XSSR,XSCB,QJFY,LRZE,LSTZQSDE,LSTZZJE,LSTZJSE,YLSSDE,SYSL,SJYLSSD,YYJSDSE,BQYBSDLSE
		 */
		
		/**  BB_SDSHSQJB
		 *   GUID,SRZE,XSSR,XSCB,QJFY,LRZE,LSTZQSDE,LSTZZJE,LSTZJSE,YLSSDE,SYSL,SJYLSSD,
		 *   YJLSSDE,BQYBSDE,SLSWJG,GSSWDJH,DSSWDJH,SJSWJGMC,BGYJLX,NotBLYJ,BLYJ
		 */
		
		/**  BB_SFKJJDB
		 *   GUID,JDJG
		 */
		
		/** BB_SJB
		 *  GUID,SJLX,ZXSJMC,BGYT,SJBGND,HBHS,KGSSGSS,GPDM,SFLXSJ,QYKJSSWSMC,SJBGYJLX,NotBLYJLX,BLYJLX,XSSR,
 		 *  YYSR,ZCZE,FZZE,LRZE,YLSDE,JLR,YLSDSE,XMZRS,WQGZTS
		 */
		
		/**  BB_WHNJB
		 *   GUID,WHDJZH,BZ,WHSRZJ,WHZCZJ,JCXMCE,QTZC,WHHBJJ,JCHJ,SSJWJB,SSJLWHJB,JWJK,XMZRS,WQGZTS
		 */
		
		/**  BB_YZB
		 *   GUID,YZBZ,YZBZJE,YZSWJE,YZTDSYJE,YZQTWSZCJE,YZQTJE,BQYZWFCZXHJE,BQYZWFCZSWJE
		 *   BQYZWFCZLYZTZJE,BQYZWFCZWXZCJE,BQYZWFCZQTJE,YZZL,ZJ,GFZY,JZ,YZJZR,GD1,GD2
		 *   GD3,GD4,QTGD,sjbgyjlx,blyjlx,notblyjlx
		 */
		
		/**  BB_ZCPGB
		 *   GUID,PGMD,PGDX,PGLX,PGFF,PGJZR,ZCZE,FZZE,JZZE,SJDWMC
		 */
		
		
		/**  BB_SWDLB
		 *  GUID,DLXM
		 */
		
		 
		
		
		
		BbService bbService = new BbService();
		try {
			bbService.setSqlByXml("sj001");
			
			String sql = bbService.getSql();
			List col = bbService.getColumn();
			List colName = bbService.getColumnName();
			List align = bbService.getAlign();
			
			System.out.println(sql);
			
			for (int i = 0; i < col.size(); i++) {
				System.out.print(col.get(i) + ",");
			}
			System.out.println();
			
			for (int i = 0; i < colName.size(); i++) {
				System.out.print(colName.get(i) + ",");
			}
			System.out.println();
			for (int i = 0; i < align.size(); i++) {
				System.out.print(align.get(i) + ",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=======================");
		try {
			bbService.getSqlByType("审计");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
