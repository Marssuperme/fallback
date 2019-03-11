package cn.org.gdicpa.web.service.dataupload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.FileUtil;
import cn.org.gdicpa.web.service.log.LogService;
import cn.org.gdicpa.web.service.log.model.LogTable;

public class CopyOfUploadDataService extends DefaultHandler {
	private Connection conn = null;

	private SAXBuilder sb = null;

	private Document doc = null;

	private String TableName = "";

	private String[] xmlFiles;

	private String formatFile = "";

	private String strDir = "";

	private ResultSetMetaData rsmd = null;

	private int pkgidPosition = -1;

	private DisposeTableService dts = null;

	private String value="";
	
	private SAXParserFactory saxsf = SAXParserFactory.newInstance();
	private SAXParser saxsp = saxsf.newSAXParser();
	
	private String newpackageid="";
	private int iField=1,iRecord=0;
	PreparedStatement saxps = null;
	private String upFileName="";
	
	
	public String getUpFileName() {
		return upFileName;
	}

	public void setUpFileName(String upFileName) {
		this.upFileName = upFileName;
	}

	public Map dataMap = new HashMap();	//用来保存结果sql
	
	public void setTableName(String strTableName) {
		this.TableName = strTableName; 
		// 找到指定数据表的所有数据文件（表名_N.xml）
		this.xmlFiles = FileUtil.getFilesAndDir(strDir, strTableName + "_");
		for (int filei = 0; filei < xmlFiles.length; filei++) {
			System.out.println(filei + "|xmlFiles=|"+xmlFiles[filei]);
		}
		System.out.println(strTableName +"|"+xmlFiles.length + "|"+xmlFiles);
		this.formatFile = strTableName + "_1.xml"; 
	}

	public CopyOfUploadDataService(String filePath, Connection conn1)
			throws Exception {
		if (filePath == null || filePath.equals("")) {
			throw new Exception("请先设置filePath属性");
		}

		DbUtil.checkConn(conn1);

		this.strDir = filePath;

		this.conn = conn1;
		this.dts = new DisposeTableService(conn1);
		this.sb = new SAXBuilder();
		if (this.sb == null)
			throw new Exception("XML分析器加载错误！");
		
	}

	
	
	public String[] getPackageId() throws Exception {
		
		String result[] = null;
		String [] sFile = FileUtil.getFilesAndDir(this.strDir,"c_AccPackage_");
		boolean bool = true;
		for (int i = 0; i < sFile.length; i++) {
			String filename = sFile[i];
			
			if(filename.toLowerCase().indexOf(".txt")>-1){
				bool = false;
				break;
			}
		}
		
		if(bool){
			result = getPackageIdFromXmlFile();
		}else{
			result = getPackageIdFromTxtFile();
		}
		return result;
	}
	
	/*
	 * 直接分析解压的TXT帐套文件，获取帐套编号 
	 * @return String 
	 * @throws Exception
	 */
	public String[] getPackageIdFromTxtFile() throws Exception {
		
		BufferedInputStream bis=null;
		
		try {
			String result[] = new String[2];
			
			String formatFile1 = "c_AccPackage_2.txt";
			
			byte[] buff = new byte[2048];
			bis = new BufferedInputStream(new FileInputStream(this.strDir + formatFile1));
			bis.read(buff);
			char a=0x10;
			String [] str = new String(buff).split(String.valueOf(a));
			result[0] = str[0]; 
			result[1] = str[1];
			
			return result; 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			bis.close();
		}
		
	}
	
	/*
	 * 直接分析解压的XML帐套文件，获取帐套编号 
	 * @return String 
	 * @throws Exception
	 */
	public String[] getPackageIdFromXmlFile() throws Exception {

		String result[] = new String[2];

		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		Document doc1 = null;
		try {
			// 先分析xml1的文件，获得帐套编号和年份的位置
			doc1 = builder.build(new File(this.strDir + "c_AccPackage_1.xml"));
			Element root1 = doc1.getRootElement();
			List metadata1 = root1.getChildren("metadata");
			Element Fields1 = (Element) metadata1.get(0);
			List cols = Fields1.getChildren("field");
			int i = 0, iPackageid = -1, iYear = -1;
			for (Iterator iter = cols.iterator(); iter.hasNext();) {
				i++;
				String name = ((Element) iter.next()).getChildText("name");
				if (name.toLowerCase().equals("accpackageid")) {
					iPackageid = i;
				}
				if (name.toLowerCase().equals("accpackageyear")) {
					iYear = i;
				}
			}

			if (iPackageid < 0) {
				throw new Exception("帐套表XML文件内没有AccPackageID字段");
			}
			if (iYear < 0) {
				throw new Exception("帐套表XML文件内没有AccPackageYear字段");
			}

			// 再取得对应的值
			
			doc = builder.build(new File(this.strDir + "c_AccPackage_2.xml"));
			Element root = doc.getRootElement();
			List datas = root.getChildren("data");
			List records = ((Element) datas.get(0)).getChildren("record");
			for (Iterator iter = records.iterator(); iter.hasNext();) {
				Element Fields = (Element) iter.next();
				List colsValue = Fields.getChildren("field");
				i = 0;
				for (Iterator it = colsValue.iterator(); it.hasNext();) {
					Element e = (Element) it.next();
					i++;
					if (i == iPackageid) {
						// 客户原有帐套的编号,提取出来用于后面的批量更改;
						result[0] = e.getText().trim();
					}
					if (i == iYear) {
						// 客户帐套的年份
						result[1] = e.getText().trim();
					}
					// System.out.println(String.valueOf(i)+e.getText());
				}
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("预处理帐套文件失败：" + e.getMessage(), e);
		}
		
		return result;
	}

	
	public String getExportDate() throws Exception {
		String result = ""; 
		String [] sFile = FileUtil.getFilesAndDir(this.strDir,"c_AccPackage_");
		boolean bool = true;
		for (int i = 0; i < sFile.length; i++) {
			String filename = sFile[i];
			if(filename.toLowerCase().indexOf(".txt")>-1){
				bool = false;
				break;
			}
		}
		if(bool){
			result = getExportDateFromXmlFile();
		}else{
			result = getExportDateFromTxtFile();
		}
		return result;
	}
	
	public String getExportDateFromTxtFile() throws Exception {
		try {
			String result= "";
			String formatFile1 = "c_AccPackage_2.txt";
			
			byte[] buff = new byte[2048];
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(this.strDir + formatFile1));
			bis.read(buff);
			char a=0x10;
			String [] str = new String(buff).split(String.valueOf(a));
			result = str[3];
			bis.close();
			return result; 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
	}
	
	/*
	 * 直接分析解压的XML帐套文件，获取采集时间 @return String @throws Exception
	 */
	public String getExportDateFromXmlFile() throws Exception {

		String result = "";
		// this.strDir = "c:\\temp\\1208413670828\\";
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		Document doc1 = null;
		try {
			// 先分析xml1的文件，获得帐套编号和年份的位置
			doc1 = builder.build(new File(this.strDir + "c_AccPackage_1.xml"));
			Element root1 = doc1.getRootElement();
			List metadata1 = root1.getChildren("metadata");
			Element Fields1 = (Element) metadata1.get(0);
			List cols = Fields1.getChildren("field");
			int i = 0, iExportdate = -1;
			for (Iterator iter = cols.iterator(); iter.hasNext();) {
				i++;
				String name = ((Element) iter.next()).getChildText("name");
				if (name.toLowerCase().equals("exportdate")) {
					iExportdate = i;
				}
			}

			if (iExportdate < 0) {
				throw new Exception("帐套表XML文件内没有exportdate字段");
			}

			// 再取得对应的值
			doc = builder.build(new File(this.strDir + "c_AccPackage_2.xml"));
			Element root = doc.getRootElement();
			List datas = root.getChildren("data");
			List records = ((Element) datas.get(0)).getChildren("record");
			for (Iterator iter = records.iterator(); iter.hasNext();) {
				Element Fields = (Element) iter.next();
				List colsValue = Fields.getChildren("field");
				i = 0;
				for (Iterator it = colsValue.iterator(); it.hasNext();) {
					Element e = (Element) it.next();
					i++;
					if (i == iExportdate) {
						// 客户原有帐套的编号,提取出来用于后面的批量更改;
						result = e.getText().trim();
					}
					// System.out.println(String.valueOf(i)+e.getText());
				}
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("预处理帐套文件失败：" + e.getMessage(), e);
		}

		return result;
	}


	/**
	 * 分析某一个数据库表结构，构造插入SQL；
	 * 
	 * @return
	 * @throws Exception
	 */
	public String readSQL() throws Exception {//已注销了不执业
		if (conn == null) {
			new Exception("数据库联结不能为空");
		}

		StringBuffer sbf = new StringBuffer("insert into ");
		StringBuffer sbfv = new StringBuffer(" values( ");
		Element root = doc.getRootElement();
		// 先导入到临时表,所以要用T_开头;
		TableName = "t_" + root.getAttributeValue("name");

		this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
		sbf.append(TableName);
		sbf.append(" (");
		List metadata = root.getChildren("metadata");
		Element Fields = (Element) metadata.get(0);
		List cols = Fields.getChildren("field");
		int i = 0;
		String strFields = "";
		pkgidPosition = -1; // 每次分析都必须强制置帐套ID位置为-1;
		for (Iterator iter = cols.iterator(); iter.hasNext();) {
			i++;
			String name = ((Element) iter.next()).getChildText("name");

			// System.out.println("XML 的表："+name);

			if (name.toUpperCase().equals("ACCPACKAGEID")) {
				pkgidPosition = i;
			}
			sbf.append(name);
			sbfv.append("?");
			strFields += name + ",";
			if (iter.hasNext()) {
				sbf.append(",");
				sbfv.append(",");
			}
		}
		sbf.append(")");
		sbfv.append(")");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			strFields = "select " + strFields + "1 from " + TableName
					+ " where 1=2";
			ps = conn.prepareStatement(strFields);
			rs = ps.executeQuery();
			if (rs == null) {
				throw new Exception("无法获取" + TableName + "表信息");
			}
			rsmd = rs.getMetaData();
			if (rsmd == null) {
				throw new Exception("无法获取" + TableName + "表的字段信息");
			}
		} catch (Exception e) {
			throw new Exception("无法获取" + TableName + "表信息", e);
		}

		System.out.println("sql=" + sbf.toString() + sbfv.toString());
		return sbf.toString() + sbfv.toString();
	}

	/**
	 * 读取XML的列值
	 * 
	 * @throws Exception
	 */
	public void readColsValue() throws Exception {
		Element root = doc.getRootElement();
		List datas = root.getChildren("data");
		List records = ((Element) datas.get(0)).getChildren("record");
		for (Iterator iter = records.iterator(); iter.hasNext();) {
			Element Fields = (Element) iter.next();
			List colsValue = Fields.getChildren("field");
			for (Iterator it = colsValue.iterator(); it.hasNext();) {
				System.out.print(((Element) it.next()).getText() + "|");
			}
			System.out.println("");
		}
		System.out.println(records.size());
	}

	public String insertToDB(String newpackageid) throws Exception {
		
		String [] sFile = FileUtil.getFilesAndDir(this.strDir,this.TableName + "_");
		System.out.println("insertToDB sFile=|"+sFile);
		
		boolean bool = true;
		for (int i = 0; i < sFile.length; i++) {
			String filename = sFile[i];
			if(filename.toLowerCase().indexOf(".txt")>-1){
				bool = false;
				break;
			}
		} 
//		
//		String result = "";
//		if(bool){
//			result = insertXmlToDB(newpackageid); 
//		}else{
//			result = insertTxtToDB(newpackageid) ;
//		}
		
		String result = insertTxtToDB(newpackageid) ;
		
		return result;
	}
	
	/**
	 * 
	 * 将TXT数据文件导入到指定表中
	 * @param newpackageid
	 * @return
	 * @throws Exception
	 */
	public String insertTxtToDB(String newpackageid) throws Exception {
		if (conn == null) {
			new Exception("数据库联结不能为空");
		}
		PreparedStatement ps = null;
		try {
			
			this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
			if (doc == null)
				throw new Exception("表格式定义文件:" + xmlFiles[0] + "访问失败！");
			
			StringBuffer sbf = new StringBuffer("");
			
			Element root = doc.getRootElement();
			TableName = "tt_" + root.getAttributeValue("name") + newpackageid;//临时表名
			this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
			
			List metadata = root.getChildren("metadata");
			Element Fields = (Element) metadata.get(0);
			List cols = Fields.getChildren("field");
			int i = 0;
			String strFields = "";
			pkgidPosition = -1; // 每次分析都必须强制置帐套ID位置为-1;
			for (Iterator iter = cols.iterator(); iter.hasNext();) {
				i++;
				String name = ((Element) iter.next()).getChildText("name");

				// System.out.println("XML 的表："+name);

				if (name.toUpperCase().equals("ACCPACKAGEID")) {
					pkgidPosition = i;
				}
				sbf.append(name);
				strFields += name + ",";
				if (iter.hasNext()) {
					sbf.append(",");
				}
			}
			
			dataMap.put(root.getAttributeValue("name").toUpperCase(), sbf.toString());//表名与sql
			//System.out.println(sbf.toString());
 
			System.out.println(this.strDir + "|xmlFiles=|"+xmlFiles);
			
			for (int filei = 1; filei < xmlFiles.length; filei++) {
				String xmlFile =  this.strDir + xmlFiles[filei];
				xmlFile = new ASFuntion().replaceStr(xmlFile, "\\", "/");
//				String sql = "load data  infile '"+xmlFile+"' into table "+TableName+" " +
//						" fields terminated by x'10' " +
//						" optionally enclosed by x'11' escaped by x'13' " +
//						" lines terminated by x'12' " + 
//						" ("+sbf.toString()+") " + 
//						" set AccPackageID = ? ";
				
				String sql = "bulk insert "+TableName+" " +
				"	from '"+xmlFile+"'" +
				"	with(" +
				"		FIELDTERMINATOR = '0x10'," +
				"		ROWTERMINATOR = '0x12'" +
				"	) ";
				        
//				EXEC master..xp_cmdshell 'BCP MTOA_GDICPA.dbo.t_BB_CompanyList  in C:/temp/1283329419468/BB_CompanyList_2.txt -c -t0x10 -r0x12 -S192.168.1.7 -Usa -PMatech123' 

				System.out.println(xmlFile + "|" + sql);
				ps = conn.prepareStatement(sql);
//				ps.setString(1, newpackageid);
				ps.execute();
				DbUtil.close(ps);
			}
			
			return TableName;
		} catch (Exception e) {
			
			// 记录日志
			saveLog(conn,e);
			
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 
	 * 读 xml 里面的配置字段保存到 Map 
	 * @param newpackageid
	 * @return
	 * @throws Exception
	 */
	public void setFieldToMap() throws Exception {
		if (conn == null) {
			new Exception("数据库联结不能为空");
		}
		PreparedStatement ps = null;
		try {
			this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
			if (doc == null)
				throw new Exception("表格式定义文件:" + xmlFiles[0] + "访问失败！");
			
			StringBuffer sbf = new StringBuffer("");
			
			Element root = doc.getRootElement();
			this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
			
			List metadata = root.getChildren("metadata");
			Element Fields = (Element) metadata.get(0);
			List cols = Fields.getChildren("field");
			int i = 0;
			String strFields = "";
			pkgidPosition = -1; // 每次分析都必须强制置帐套ID位置为-1;
			for (Iterator iter = cols.iterator(); iter.hasNext();) {
				i++;
				String name = ((Element) iter.next()).getChildText("name");

				// System.out.println("XML 的表："+name);

				if (name.toUpperCase().equals("ACCPACKAGEID")) {
					pkgidPosition = i;
				}
				sbf.append(name);
				
				if (iter.hasNext()) {
					sbf.append(",");
				}
				
			}
			
			dataMap.put(root.getAttributeValue("name").toUpperCase(), sbf.toString());//表名与sql
			//System.out.println(sbf.toString());
 
			System.out.println(this.strDir + "|xmlFiles=|"+xmlFiles);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	/**
	 * ====从这里开始，到后面标记结束的地方，都是SAX需要用到的
	 */
	
	/**
	 * 将XML导入到指定表中
	 * 
	 * @param newpackageid
	 * @return
	 * @throws Exception
	 */
	public String insertXmlToDB(String newpackageid) throws Exception {//已注销了不执业
		if (conn == null) {
			new Exception("数据库联结不能为空");
		}
		this.newpackageid=newpackageid;
		
		try{
			conn.setAutoCommit(false);
			this.doc = sb.build(new FileInputStream(this.strDir + formatFile));
			if (doc == null)
				throw new Exception("表格式定义文件:" + xmlFiles[0] + "访问失败！");
			saxps = conn.prepareStatement(readSQL());
	
			System.out.println("qwh:formatFile=" + formatFile);
	
			// 遍历所有文件，完成装载
			for (int filei = 1; filei < xmlFiles.length; filei++) {
				iField=1;
				iRecord=0;
				System.out.println("处理："+this.strDir+ xmlFiles[filei]);
				saxsp.parse(new InputSource(this.strDir+ xmlFiles[filei]), this);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("将XML导入到指定表中失败,当前记录数"+iField+",错误原因:"+e.getMessage());
		}finally{
			DbUtil.close(saxps);
		}
		
		return TableName;
	}

	/**
	 * SAX:要求实例化的代码，记录中间处理的characters，切记，在一个<aaa>12313123</aaa>,这一段有可能被反复调用
	 */
	public   void   characters(char[] ch,int start,int length) throws SAXException   { 
		
		try{
			
			String temp = new String(ch,start,length); 
			
			if("".equals(temp.trim())) {
				return;
			}
			
			this.value+=temp;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	} 

	/**
	 * SAX:要求实例化的代码，最后文档结束时把还没有来得及插入的记录插入到表中
	 */
	public   void   endDocument() throws   SAXException{ 	
		try{
			super.endDocument();
			//最后一次插入
			
			if (iRecord % 100 != 0) {
					saxps.executeBatch();
					conn.commit();
			}
		}catch(Exception e){
			throw new SAXException("导入"+this.TableName+"在endDocument失败，错误:"+e.getMessage());
		}
		
	} 

	/**
	 * SAX:要求实例化的代码，每个</aaa>时激发
	 */
	public void endElement(String   uri,   String   localName,   String   qName) throws SAXException{
		
		try{
			super.endElement(uri,   localName,   qName); 
			
			if ("field".equals(qName)){
				//响应每个字段结束，填充PS的参数值
				//System.out.println("value="+value);
				
				if (iField == pkgidPosition) {
					// 为了提高效率,在插入时直接替换掉帐套编号
					saxps.setString(iField, newpackageid);
				} else {

					switch (rsmd.getColumnType(iField)) {
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
						
						//System.out.println("value="+value);
						
						saxps.setString(iField, this.value.trim());
						break;
					case java.sql.Types.INTEGER:
						if (this.value == null || this.value.equals(""))
							saxps.setInt(iField, 0);
						else
							saxps.setString(iField, this.value);
						break;
					case java.sql.Types.DECIMAL:
						if (this.value == null || this.value.equals(""))
							saxps.setInt(iField, 0);
						else {
							saxps.setString(iField,  new java.text.DecimalFormat("#0.00").format(Double.parseDouble(this.value)));
						}
						break;
					default:
						saxps.setString(iField, this.value);
					}// end of switch
				}
				
				iField++;
				
			}
			if ("record".equals(qName)){
				//执行一次插入
				iRecord++;
				saxps.addBatch();
				iField=1;
				
				if (iRecord % 100 == 0) {
					saxps.executeBatch();
					conn.commit();
				}
			}
			
		}catch(Exception e){
			throw new SAXException("导入"+this.TableName+"在endElement失败，错误:"+e.getMessage());
		}
		
		//清零中间缓存结果
		this.value="";
	} 
		
	/**
	 * ======================这里是SAX解析结束的地方===================================
	 */
	
	//生成报备的临时表
	public void setTable(Map tableMap,String random)throws Exception{
		this.newpackageid = random;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			
			String sql = "";
			
			Set coll = tableMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) tableMap.get(key);
				
				// 设置 formatFile
				setTableName(key);
				
				// 读 xml 里面的配置字段保存到 Map 
				setFieldToMap();
				
				
				try {
					sql = "select * from tt_" + key + random + " where 1=2";
					rs = st.executeQuery(sql);
					continue;
				} catch (Exception e) {
					//不存在新增
					// sql = "select * into tt_" + key + random + " from " + key + " where 1=2 ";
					sql = " ( select "+dataMap.get(key.toUpperCase())+" from "+ key +") as "+key;
					sql = "select * into tt_" + key + random + " from " + sql + " where 1=2 ";
					st.execute(sql);
					
//					sql = "alter table t_" + key + " add AccPackageID varchar (30) null ";
//					st.execute(sql);
					
				} finally {
					DbUtil.close(rs);
				}
				
				System.out.println(sql);
				 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
		}
	}
	
	
	//删除临时表
	public void delTable(String table) throws Exception{
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "drop table " + table;
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(st);
		}
	}
	
	public void delTable(Map tableMap,String random)throws Exception{
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String sql = "";
			
			Set coll = tableMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) tableMap.get(key);
				
				try {
					sql = "drop table tt_" + key + random;
					st.execute(sql);
				} catch (Exception e) { 
				} 
				System.out.println(sql);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(st);
		}
	}
	
	//删除报备表的重复数据
	public void del(Map tableMap,String random,String area) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//1、加入临时表，保存bbbh和bbtime一样的数据
			/*
			 *  因为后面日期的数据会覆盖前面日期的数据，所以导入去的数据要检查，
				要是防伪编号在数据库里没有就自动新增进去，要是有的就判断该报备
				记录的报备时间是否在同防伪编号的报备时间之前，如果为是不覆
				盖进去，如果为否覆盖进去（附东莞方提供给我们下面日期的
				数据：“丢失数据”
			 */
			if("广州".equals(area) || "东莞".equals(area)){
				sql = "select a.guid,a.companyguid into tt_BB_CONTENT1" + random + "_1 " +
				"	from BB_CONTENT1 a ,tt_BB_CONTENT1" + random + " b  " +
				"	where 1=1 " +
				"	and a.ywarea = b.ywarea " +
				"	and a.bbbh = b.bbbh  " + 
				"	and a.bbtime < b.bbtime " ;
				ps = conn.prepareStatement(sql);
				ps.execute();
				DbUtil.close(ps);	
			}else{
				sql = "select a.guid,a.companyguid into tt_BB_CONTENT1" + random + "_1 " +
				"	from BB_CONTENT1 a ,tt_BB_CONTENT1" + random + " b  " +
				"	where a.BBPERSON = b.BBPERSON " +
				"	and a.ywarea = b.ywarea " +
				"	and a.bbbh = b.bbbh  " +
				"	and a.bbtime = b.bbtime  " ;
				ps = conn.prepareStatement(sql);
				ps.execute();
				DbUtil.close(ps);
				
				sql = "insert into tt_BB_CONTENT1" + random + "_1  " +
				"	select a.guid,a.companyguid  " +
				"	from BB_CONTENT1 a ,tt_BB_CONTENT1" + random + " b  " +
				"	where a.BBPERSON = b.BBPERSON " +
				"	and a.ywarea = b.ywarea " +
				"	and a.bbbh = b.bbbh  " +
				"	and a.bbtime < b.bbtime  " ;
				ps = conn.prepareStatement(sql);
				ps.execute();
				DbUtil.close(ps);
			}
			
			//3、删除除BB_CompanyList与BB_CONTENT1表以外的
			Set coll = tableMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) tableMap.get(key);
				if(!(key.toUpperCase().equals("BB_CompanyList".toUpperCase()) 
//					|| 	key.toUpperCase().equals("BB_CONTENT1".toUpperCase())
					)
					//最后复制这两张表 
				){
					sql = "delete a from " + key + " a , tt_BB_CONTENT1" + random + "_1 b where a.guid = b.guid";
					ps = conn.prepareStatement(sql);
					ps.execute();
					DbUtil.close(ps);
				} 
			}
			//4.删除BB_CompanyList 表
//			sql = "delete a from BB_CompanyList a ,tt_BB_CompanyList" + random + "_1 b where a.guid = b.companyguid";
//			sql = "delete from BB_CompanyList where area in (select distinct area from tt_BB_CompanyList" + random + " )";
//			sql = "delete a from BB_CompanyList a,tt_BB_CompanyList" + random + " b where a.loginid = b.loginid ";
//			ps = conn.prepareStatement(sql);
//			ps.execute();
//			DbUtil.close(ps);
			
			//系统表删除完------------------------------------------------------------
			//5.删除tt表
			sql = "delete from tt_BB_CONTENT1" + random + "_1 ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			sql = "insert into tt_BB_CONTENT1" + random + "_1  " +
			"	select b.guid,b.companyguid  " +
			"	from BB_CONTENT1 a ,tt_BB_CONTENT1" + random + " b  " +
			"	where a.BBPERSON = b.BBPERSON " +
			"	and a.ywarea = b.ywarea " +
			"	and a.bbbh = b.bbbh  " +
			"	and a.bbtime > b.bbtime  " ;
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			//6、删除除tt_BB_CompanyList表以外的
			for (Iterator iter = coll.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) tableMap.get(key);
				if(
					!(key.toUpperCase().equals("BB_CompanyList".toUpperCase())
					|| key.toUpperCase().equals("BB_SUM".toUpperCase())
//					|| 	key.toUpperCase().equals("BB_CONTENT1".toUpperCase())
					)
					//最后复制这两张表 
				){
					sql = "delete a from tt_" + key + random + " a , tt_BB_CONTENT1" + random + "_1 b where a.guid = b.guid";
					ps = conn.prepareStatement(sql);
					ps.execute();
					DbUtil.close(ps);
				}
			}
			
			/*
			 *  删除文件里面的报备事务所数据： 数据库里面和文件里面的 事务所编号 一样的报备数据
			 *  然后 修改 文件里面报备数据的事务所编号companguid变成 数据库里面已经存在的 该事务所的对应的 bb_companylist 表里面的guid
			 *  这样的话 造成了 报备数据与事务所不对应 所以注释了 这段
			 *  
			//7.删除tt_BB_CompanyList 表
			sql = "select min(a.guid) as guid,a.loginid,b.guid as bguid,b.loginid as bloginid " +
			"	into tt_BB_CompanyList" + random + "_1 " +
			"	from BB_CompanyList a,tt_BB_CompanyList" + random + " b " +
			"	where a.loginid = b.loginid " +
			"	group by a.loginid,b.loginid,b.guid " +
			"	order by a.loginid " ;
			ps = conn.prepareStatement(sql);
			ps.execute(); 
			DbUtil.close(ps);
			
			// 删除记录之后 该报备数据就找不到对应的事务所名称了。
			sql = "delete b from tt_BB_CompanyList" + random + "_1 a , tt_BB_CompanyList" + random + " b where a.bguid = b.guid ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			sql = "update b set b.companyguid = a.guid from tt_BB_CompanyList" + random + "_1 a, tt_BB_CONTENT1" + random + " b where a.bguid = b.companyguid";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			*/
			
//			sql = "delete a from tt_BB_CompanyList" + random + " a ,tt_BB_CONTENT1" + random + "_1 b where a.guid = b.companyguid";
//			ps = conn.prepareStatement(sql);
//			ps.execute();
//			DbUtil.close(ps);
			
//			sql = "update b set b.companyguid = a.guid " +
//			"	from tt_BB_CompanyList" + random + " a ,tt_BB_CONTENT1" + random + " b " +
//			"	where a.area ='"+area+"'" +
//			"	and b.ywarea = '"+area+"' " +
//			"	and a.loginid = b.bbperson ";
//			ps = conn.prepareStatement(sql);//复制数据BB_CompanyList
//			ps.execute(); 
//			DbUtil.close(ps);
			
			//8.drop 
			sql = "drop table tt_BB_CONTENT1" + random + "_1 ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			/*
			sql = "drop table tt_BB_CompanyList" + random + "_1 ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			*/
			
			//修改东莞、佛山、惠州等地区的事务所代码不一致，用名称来关联
			sql = "update b set b.loginid = a.loginid " +
			"	from k_company a,tt_BB_CompanyList" + random + " b " +
			"	where a.area = '"+area+"' " +
			"	and b.area = '"+area+"' " +
			"	and a.loginname = b.companyname";
			ps = conn.prepareStatement(sql);//复制数据BB_CompanyList
			ps.execute(); 
			DbUtil.close(ps);
			
			sql = "update b set b.bbperson = a.loginid " +
			"	from tt_BB_CompanyList" + random + " a,tt_BB_CONTENT1" + random + " b " +
			"	where a.area = '"+area+"' " +
			"	and b.ywarea = '"+area+"' " +
			"	and a.guid = b.companyguid;";
			ps = conn.prepareStatement(sql);//复制数据BB_CompanyList
			ps.execute(); 
			DbUtil.close(ps);
			
		} catch (Exception e) {
			System.out.println("我的del sql:="+sql);
			
			// 记录日志
			saveLog(conn,e);
			
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	//删除数据库同地区的数据，并复制数据到系统表
	/**
	 * @param tableMap
	 * @param random
	 * @return
	 * @throws Exception
	 */
	public String createTable(Map tableMap,String random)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//控制事务（默认不提交）
			conn.setAutoCommit(false);
			ASFuntion CHF = new ASFuntion();
			
			String sql = "",area = "";
			
			sql = "select distinct area from tt_BB_CompanyList" + random + " where area <> '' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				area = rs.getString("area");
			}else{
				throw new Exception("报备事务所表没有地区，不能装载");
			}
			DbUtil.close(ps);
			System.out.println("时间开始A："+CHF.getCurrentTime());
			
			del( tableMap, random,area);//清理数据                                        --------------------------TODO----------------------------------
			
			Set coll = tableMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) tableMap.get(key);
				
				if(!(key.toUpperCase().equals("BB_CompanyList".toUpperCase()) 
					|| 	key.toUpperCase().equals("BB_CONTENT1".toUpperCase())
					|| 	key.toUpperCase().equals("BB_SUM".toUpperCase()))
					//最后复制这两张表 
				){	
					//更新相应业务的报备内容二的信息
					String tableField = (String)dataMap.get(key.toUpperCase());
					
					String [] tableFields = tableField.split(",");
					StringBuffer buf = new StringBuffer();
					sql = "update a set ";
					buf.append(sql);
					for(int i=0;i<tableFields.length;i++){
						buf.append("a."+tableFields[i]+"=b."+tableFields[i]);
						if(i!=tableFields.length-1){
							buf.append(",");
						}
					}					
//					buf.append(" from "+"(select x1.*,c1.bbbh,c1.ywarea from "+key+" x1 left join BB_CONTENT1 c1 on x1.guid=c1.guid) a," +
//							"(select x2.*,c2.bbbh,c2.ywarea from tt_"+key+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.guid) b " +
//									"where a.bbbh=b.bbbh and a.ywarea=b.ywarea and a.guid=b.guid");
					
					buf.append(" from "+"(select x1.*,c1.bbbh,c1.ywarea from "+key+" x1 left join BB_CONTENT1 c1 on x1.guid=c1.guid) a," +
							"(select x2.*,c2.bbbh,c2.ywarea from tt_"+key+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.guid) b " +
									"where a.guid=b.guid");
					
					System.out.println("我的测式--> BUF :    " +buf.toString());
					sql = buf.toString();
					ps = conn.prepareStatement(sql);//
					int update_num = ps.executeUpdate();
					System.out.println("更新了表: "+key+" 的记录: "+update_num+" 条");
					DbUtil.close(ps);
					//增加相应业务的报备内容二的信息
//					sql = "insert into " + key + " (" + dataMap.get(key.toUpperCase()) + ") " +
//					" select distinct " + dataMap.get(key.toUpperCase()) + " from (" +
//					"	select c.* from tt_" + key + random + " c " +
//					"	where c.guid in (select b.guid from "+
//					"(select x2.*,c2.bbbh,c2.ywarea from tt_"+key+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.guid) b "+
//					"left join "+
//					"(select x1.*,c1.bbbh,c1.ywarea from "+key+" x1 left join BB_CONTENT1 c1 on x1.guid=c1.guid) a "+
//					"on b.bbbh=a.bbbh and b.ywarea=a.ywarea and a.guid=b.guid where a.bbbh is null)) z";
					
					sql = "insert into " + key + " (" + dataMap.get(key.toUpperCase()) + ") " +
					" select distinct " + dataMap.get(key.toUpperCase()) + " from (" +
					"	select c.* from tt_" + key + random + " c " +
					"	where c.guid in (select b.guid from "+
					"(select x2.*,c2.bbbh,c2.ywarea from tt_"+key+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.guid) b "+
					"left join "+
					"(select x1.*,c1.bbbh,c1.ywarea from "+key+" x1 left join BB_CONTENT1 c1 on x1.guid=c1.guid) a "+
					"on a.guid=b.guid where a.bbbh is null)) z";
					
					System.out.println("插入表"+key+"----->" + sql);
					
					ps = conn.prepareStatement(sql);//复制数据	
					int insert_num = ps.executeUpdate();
					System.out.println("表"+key+" 增加的记录数: "+insert_num+" 条");
					DbUtil.close(ps);
					System.out.println("for B："+CHF.getCurrentTime());
				}
			}
					
			System.out.println("C1："+CHF.getCurrentTime());
			
			System.out.println("upFileName "+upFileName);
			
			String uprea=upFileName.startsWith("dgbb")?"东莞导入":upFileName.startsWith("gzbb")?"广州导入":"其他导入";
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=new Date();
			String newdate=sd.format(d);
			
			//更新已存在的报备内容一的报备记录
			String tableField = (String)dataMap.get("BB_CONTENT1".toUpperCase());
			String [] tableFields = tableField.split(",");
			StringBuffer buf = new StringBuffer();
			sql = "update a set ";
			buf.append(sql);
			for(int i=0;i<tableFields.length;i++){
				buf.append("a."+tableFields[i]+"=b."+tableFields[i]);
				if(i!=tableFields.length-1){
					buf.append(",");
				}
			}					
//			buf.append(" from BB_CONTENT1 a,tt_BB_CONTENT1"+random+" b where a.bbbh=b.bbbh and a.ywarea=b.ywarea and a.guid=b.guid");
			
			buf.append(" from BB_CONTENT1 a,tt_BB_CONTENT1"+random+" b where a.guid=b.guid");
			System.out.println("更新了表: BB_CONTENT1 的SQL : "+buf.toString());
			sql = buf.toString();
			ps = conn.prepareStatement(sql);
			int update_c_num = ps.executeUpdate();
			System.out.println("更新了表: BB_CONTENT1 的记录: "+update_c_num+" 条");
			DbUtil.close(ps);
			
			//增加新的报备内容一的报备信息
//			sql = "insert into BB_CONTENT1 (" + dataMap.get("BB_CONTENT1".toUpperCase()) + ",updata,upreason) " +
//			" select distinct " + dataMap.get("BB_CONTENT1".toUpperCase()) + " ,'"+newdate+"' as updata,'"+uprea+"' as upreason from (" +
//			"	select a.* from tt_BB_CONTENT1" + random + " a " +
//			"	left join BB_CONTENT1 b on a.bbbh = b.bbbh and a.ywarea=b.ywarea and a.guid=b.guid " +
//			"	where b.guid is null " +
//			") c ";
			
			sql = "insert into BB_CONTENT1 (" + dataMap.get("BB_CONTENT1".toUpperCase()) + ",updata,upreason) " +
			" select distinct " + dataMap.get("BB_CONTENT1".toUpperCase()) + " ,'"+newdate+"' as updata,'"+uprea+"' as upreason from (" +
			"	select a.* from tt_BB_CONTENT1" + random + " a " +
			"	left join BB_CONTENT1 b on a.guid=b.guid " +
			"	where b.guid is null " +
			") c ";
			
			System.out.println("BB_CONTENT1 : SQL -->"+sql);
			ps = conn.prepareStatement(sql);//复制数据BB_CONTENT1
			int insert_c_num = ps.executeUpdate();	
			System.out.println("BB_CONTENT1插入的数 ：--->"+insert_c_num);
			DbUtil.close(ps);
			
			String upsql = " insert into BB_InfoChange  (id,bbid,bbtype,changetime,changereason) " +
			" select newid() as id,guid as bbid ,wtxmlx as bbtype,'"+newdate+"' as changetime ,'"+uprea+"' as changereasion  " +
			" from BB_CONTENT1 where updata='"+newdate+"' and upreason = '"+uprea+"' ";
			ps=conn.prepareStatement(upsql);
			ps.execute();
			System.out.println("C2："+CHF.getCurrentTime());
			
			System.out.println("D1："+CHF.getCurrentTime());
			
			//更新报备事务所信息
			tableField = (String)dataMap.get("BB_CompanyList".toUpperCase());
			tableFields = tableField.split(",");
			buf = new StringBuffer();
			sql = "update a set ";
			buf.append(sql);
			for(int i=0;i<tableFields.length;i++){
				buf.append("a."+tableFields[i]+"=b."+tableFields[i]);
				if(i!=tableFields.length-1){
					buf.append(",");
				}
			}					
//			buf.append(" from "+"(select x1.*,c1.bbbh,c1.ywarea from BB_CompanyList x1 left join BB_CONTENT1 c1 on x1.guid=c1.ComPanyGUID) a," +
//					"(select x2.*,c2.bbbh,c2.ywarea from tt_BB_CompanyList"+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.ComPanyGUID) b " +
//							"where a.bbbh=b.bbbh and a.ywarea=b.ywarea and a.guid=b.guid");
			
			buf.append(" from "+"(select x1.*,c1.bbbh,c1.ywarea from BB_CompanyList x1 left join BB_CONTENT1 c1 on x1.guid=c1.ComPanyGUID) a," +
					"(select x2.*,c2.bbbh,c2.ywarea from tt_BB_CompanyList"+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.ComPanyGUID) b " +
							"where a.guid=b.guid");
			sql = buf.toString();
			System.out.println("更新BB_CompanyList-->"+sql);
			ps = conn.prepareStatement(sql);//删除数据BB_CompanyList
			int update_com_num = ps.executeUpdate();
			System.out.println("更新了表: BB_CompanyList 的记录: "+update_com_num+" 条");
			DbUtil.close(ps);
			
			//增加新的报备事务所信息
//			sql = "insert into BB_CompanyList (" + dataMap.get("BB_CompanyList".toUpperCase()) + ") " +
//			" select distinct " + dataMap.get("BB_CompanyList".toUpperCase()) + " from (" +
//			"	select c.* from tt_BB_CompanyList" + random + " c " +
//			"	where c.guid in (select b.guid from "+
//			"(select x2.*,c2.bbbh,c2.ywarea from tt_BB_CompanyList"+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.ComPanyGUID) b "+
//			"left join "+
//			"(select x1.*,c1.bbbh,c1.ywarea from BB_CompanyList x1 left join BB_CONTENT1 c1 on x1.guid=c1.ComPanyGUID) a "+
//			"on b.bbbh=a.bbbh and b.ywarea=a.ywarea and a.guid=b.guid where a.bbbh is null)) z";
			
			sql = "insert into BB_CompanyList (" + dataMap.get("BB_CompanyList".toUpperCase()) + ") " +
			" select distinct " + dataMap.get("BB_CompanyList".toUpperCase()) + " from (" +
			"	select c.* from tt_BB_CompanyList" + random + " c " +
			"	where c.guid in (select b.guid from "+
			"(select x2.*,c2.bbbh,c2.ywarea from tt_BB_CompanyList"+random+" x2 left join tt_BB_CONTENT1"+random+" c2 on x2.guid=c2.ComPanyGUID) b "+
			"left join "+
			"(select x1.*,c1.bbbh,c1.ywarea from BB_CompanyList x1 left join BB_CONTENT1 c1 on x1.guid=c1.ComPanyGUID) a "+
			"on a.guid=b.guid where a.bbbh is null)) z";
			
			System.out.println("增加BB_CompanyList-->"+sql);
			
			ps = conn.prepareStatement(sql);//复制数据BB_CompanyList
			int insert_com_num = ps.executeUpdate();
			System.out.println("表BB_CompanyList 增加的记录数 : "+insert_com_num+" 条");
			DbUtil.close(ps);
			System.out.println("D2："+CHF.getCurrentTime());
			
			System.out.println("时间结束A："+CHF.getCurrentTime());
			
			//加载检证的汇总数据
			sql="insert into BB_SUM (Guid,Tbrq,Sjqjq,Sjqjz,Tbfs,Jls,Area,Content1_update_num,Content1_insert_num,Content1_total,Time) " +
					"select newid(),s.*,'"+area+"' as Area,"+update_c_num+" as Content1_update_num,"+insert_c_num+" as Content1_insert_num,"+
					(update_c_num+insert_c_num)+" as Content1_total,CONVERT(varchar,getdate(),120) as Time from tt_BB_SUM"+random+" s";
			System.out.println(sql+"    LOLOLOLOLO");
			ps = conn.prepareStatement(sql);
			int log_num = ps.executeUpdate();
			System.out.println("表BB_SUM 增加的记录数 : "+log_num+" 条");
			DbUtil.close(ps);
			
			
			// 记录汇总报备份数
			saveCount(conn,area,"tt_BB_CONTENT1"+random);
			//提交事务
			conn.commit();
			return area;
		} catch (Exception e) {
			//回滚事务
			conn.rollback();
			// 记录日志
			saveLog(conn,e);
			//提交日志的事务
			conn.commit();
			e.printStackTrace();
			throw e;
		} finally {
			//控制事务（默认提交）
			conn.setAutoCommit(true);
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	//1、检查上报的记录数与实际记录数是否一致
	public void testBbCount() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select s.Jls as Jls,c.Sum from tt_BB_SUM"+newpackageid+
			" s,(select count(*) as sum from tt_BB_CONTENT1"+newpackageid+") c ";
			
			System.out.println("<1>SQL : " + sql);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("Jls")+" --- "+rs.getInt("Sum"));
				if(rs.getInt("Jls")!=rs.getInt("Sum")){
					throw new RuntimeException("提交失败：实际报备记录数目与广州注协上报记录数目不一致！");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	//2、（临时表）业务表的总记录跟报备表的总记录要一致
	public void testYwtabAndBbtabCountSame() throws Exception{
		String sql = "select count(1) from tt_BB_CONTENT1"+newpackageid;
		int temp_bb = Integer.parseInt(new DbUtil(conn).queryForString(sql));
		System.out.println("<2>SQL1 : " + sql);
		
		sql = "select count(a.GUID) as total from ("+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_SJB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_YZB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_WHNJB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_BBQTB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJZSB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_QCHZB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_QSSHB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_SWDLB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_ZCPGB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJDSHB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_QTSSJJB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_SFKJJDB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_SDSHSQJB"+newpackageid+" union all "+
		"select ltrim(rtrim(GUID)) as GUID from tt_BB_CCSSSQKCJJB"+newpackageid+" ) a";
		
		int temp_Ywtab = Integer.parseInt(new DbUtil(conn).queryForString(sql));
				
		System.out.println("<2>SQL2 : " + sql);
		
		if(temp_bb!=temp_Ywtab){
			throw new RuntimeException("提交失败：业务表的总记录跟报备表的总记录不一致！");
		}
	}
	//3、报备记录中是否存在相同GUID号的记录。
	public void testBbGUID() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select ltrim(rtrim(GUID)) as GUID from tt_BB_CONTENT1"+newpackageid+" group by ltrim(rtrim(GUID)) having count(1)>1";
			
			System.out.println("<3>SQL : " + sql);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			StringBuffer buf = null;
			while(rs.next()){
				buf = new StringBuffer();
				buf.append(rs.getString("GUID")).append(",");
			}
			if(buf!=null){
				throw new RuntimeException("提交失败：报备记录中存在相同的GUID主键记录，相同记录为：（"+buf.substring(0, buf.lastIndexOf(","))+"）！");
			}
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	//4、业务记录中是否存在相同GUID号的记录。
	public void testYwGUID() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select a.GUID from (" +
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_SJB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_YZB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_WHNJB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_BBQTB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJZSB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_QCHZB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_QSSHB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_SWDLB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_ZCPGB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJDSHB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_QTSSJJB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_SFKJJDB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_SDSHSQJB"+newpackageid+" union all "+
				"select ltrim(rtrim(GUID)) as GUID from tt_BB_CCSSSQKCJJB"+newpackageid+") a group by a.GUID having count(1)>1";
			
			System.out.println("<4>SQL : " + sql);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			StringBuffer buf = null;
			while(rs.next()){
				buf = new StringBuffer();
				buf.append(rs.getString("GUID")).append(",");
			}
			if(buf!=null){
				throw new RuntimeException("提交失败：业务表的总记录中存在相同的GUID主键记录，相同GUID为：（"+buf.substring(0, buf.lastIndexOf(","))+"）！");
			}
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	//5、报备记录中是否存在相同报备编号的记录。
	public void testBbBBBH() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select BBBH from BB_CONTENT1 group by BBBH having count(BBBH)>1";
			
			System.out.println("<5>SQL : " + sql);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			StringBuffer buf = null;
			while(rs.next()){
				buf = new StringBuffer();
				buf.append(rs.getString("BBBH")).append(",");
			}
			if(buf!=null){
				throw new RuntimeException("提交失败：报备记录中存在相同报备编号的记录，相同报备编号为：（"+buf.substring(0, buf.lastIndexOf(","))+"）！");
			}
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	//6、（临时表）业务表的总记录跟报备表的记录没有一一对应（GUID关联）
	public void testYwtabJoinBbtab() throws Exception{
		int temp_bb = Integer.parseInt(new DbUtil(conn).queryForString("select count(1) from tt_BB_CONTENT1"+newpackageid));
		
		System.out.println("<6>SQL1 : " + "select count(1) from tt_BB_CONTENT1"+newpackageid);
		
		String sql = "select count(c.GUID) as total from tt_BB_CONTENT1"+newpackageid+" c,(" +
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_SJB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_YZB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_WHNJB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_BBQTB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJZSB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_QCHZB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_QSSHB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_SWDLB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_ZCPGB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_KJDSHB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_QTSSJJB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_SFKJJDB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_SDSHSQJB"+newpackageid+" union all "+
							"select ltrim(rtrim(GUID)) as GUID from tt_BB_CCSSSQKCJJB"+newpackageid+") a where ltrim(rtrim(c.GUID));=a.GUID";
		
		System.out.println("<6>SQL2 : " + sql);
		
		int temp_join_count = Integer.parseInt(new DbUtil(conn).queryForString(sql));
		if(temp_bb!=temp_join_count){
			throw new RuntimeException("提交失败：业务表的总记录跟报备表的记录没有一一对应！");
		}
	}
	
	/**
	 * 记录汇总报备份数
	 * @param conn
	 * @param e
	 */
	private void saveCount(Connection conn,String area,String table){
		ASFuntion af = new ASFuntion();
		String id = UUID.randomUUID()+"";
		String incomeTime = af.getDateAndTime1();
		String sql = " select count(*) ct from " + table ;
		try {
			DbUtil db = new DbUtil(conn);
			String ct = db.queryForString(sql);
			sql = " insert into bb_content_count (id,recordCount,area,incomeTime,propertys) values(?,?,?,?,?) ";
			db.execute(sql,new Object[]{id,ct,area,incomeTime,table});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 记录日志
	 * @param conn
	 * @param e
	 */
	private void saveLog(Connection conn,Exception e){
		
		LogService ls = new LogService(conn);
		LogTable lt = new LogTable();
		
		ASFuntion af = new ASFuntion();
		
		lt.setUserId("GZ_DG");
		lt.setUserName("广州_东莞");
		lt.setIp("210.76.65.58");
		lt.setLoginDate(af.getCurrentDate());
		lt.setLoginTime(af.getCurrentTime());
		lt.setOperation("广州东莞报备数据导入");
		lt.setMemo(e.getMessage());
		lt.setCtype("报备导入");
		
		ls.saveLogInfo(lt);
	}
	
	//写日志
	//采集时间、采集类型、地区、装载时间、装载人、备注
	public void table(String random)throws Exception {
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "CREATE TABLE tt_c_accpackage"+random+" ( " +
			"	  AccPackageID varchar(20) , " +
			"	  AccPackageYear VARCHAR(20) , " +
			"	  AccPackageType varchar(10) , " +
			"	  ExportDate varchar(40) , " +	//采集时间
			"	  SoftVersion VARCHAR(100) ,   " +	//采集类型
			"	  SubjectCodeRule varchar(200) , " +
			"	  CurrName varchar(100)  " +
			"	) ";
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(st);
		}	
	}
	
	
//日志表
//	CREATE TABLE [dbo].[t_log](
//		[id] [INT] IDENTITY(1,1) NOT NULL, //自动
	
//		[UDate] [VARCHAR](40) ,//写日志日期
//		[UTime] [VARCHAR](40) ,//写日志时间
//		[loginid] [VARCHAR](100) ,//装载人
//		[loginName] [VARCHAR](100) ,//名称(装载)
//		[area] [VARCHAR](40) ,//采集地区
	
//		[CDate] [VARCHAR](300) , //采集日期
//		[CMDName] [VARCHAR](300) ,//类型
//		[memo] [VARCHAR](MAX) ,//备注
//		[url] [VARCHAR](20) ,//url
//	 CONSTRAINT [PK_t_log] PRIMARY KEY CLUSTERED 
//	(
//		[id] ASC
//	)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
//	) ON [PRIMARY]
	//日志
	public void log(String area,String url,String memo,String random,String loginid,String loginname)throws Exception {
		Statement st = null;
		ResultSet rs = null;
		try {
			ASFuntion CHF = new ASFuntion();
			
			String ExportDate = "",SoftVersion = "";
			st = conn.createStatement();
			String sql = "select * from tt_c_accpackage"+random+" ";
			rs = st.executeQuery(sql);
			if(rs.next()){
				ExportDate = rs.getString("ExportDate");//采集时间
				SoftVersion = rs.getString("SoftVersion"); //采集类型
			}
			
			sql = "insert into t_log (UDate,UTime,loginid,loginName,area, CDate,CMDName,memo,url) values (" +
			"'"+CHF.getCurrentDate()+"'," +
			"'"+CHF.getCurrentTime()+"'," +
			"'"+loginid+"'," +
			"'"+loginname+"'," +
			"'"+area+"'," +
			
			"'"+ExportDate+"'," +
			"'"+SoftVersion+"'," +
			"'"+memo+"'," +
			"'"+url+"'" +
			")";
			st.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
		}
	}
	
}
