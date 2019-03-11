package cn.org.gdicpa.web.service.education;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.education.model.EducationLogTable;

public class ExportZIP{
	private  String ZIP_TO_DIR = ConfigUtil.getString("ZIP_TO_DIR"); // 压缩后的存放文件名的目录
	private  String ZIP_FROM_DIR = ConfigUtil.getString("ZIP_FROM_DIR"); // 需要压缩的文件目录
	private  String ZX_PERFIX = ConfigUtil.getString("ZX_PERFIX");// 文件前辍
	private  String CHARSET = ConfigUtil.getString("CHARSET");//编码
	private  String MEMBERNAME = ConfigUtil.getString("MEMBERNAME");
	private  int ZX_BUFFER = ConfigUtil.getInt("ZX_BUFFER"); // 缓存大小
	
//	private  String ZIPNAME = ZX_PERFIX+DateUtil.getCurrentDate("yyyyMMdd") + ".zip"; // 压缩后的文件名
//	private  String TXTNAME = MEMBERNAME+DateUtil.getCurrentDate("yyyyMMdd") + ".txt"; // 压缩前的文件名
	
	private String dcxs = "自动导出会员信息";//导出形式（dcxs）包括“自动”各“手动”

	public void execute(){
		String zipName = ZX_PERFIX+DateUtil.getCurrentDate("yyyyMMdd") + ".zip"; // 压缩后的文件名
		String txtName = MEMBERNAME+DateUtil.getCurrentDate("yyyyMMdd") + ".txt"; // 压缩前的文件名
		System.out.println(this.getClass().getName()+":"+"运行了！");
		try {
			List<Map<String, String>> list = getList();
			//从数据表中导出.txt文件
			exportZIP(list,txtName);
			//压缩.txt文件
			zipFile(zipName,txtName);
			//记录日志
			log("成功","完成");
		} catch (Exception e) {
			//记录日志
			log("失败",e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	public void execute(String date){
		dcxs = "手动导出会员信息";
		String zipName = ZX_PERFIX + date + ".zip";
		String txtName = MEMBERNAME + date + ".txt";
		try {
			List<Map<String, String>> list = getList();
			//从数据表中导出.txt文件
			exportZIP(list,txtName);
			//压缩.txt文件
			zipFile(zipName,txtName);
			//记录日志
			log("成功","完成");
		} catch (Exception e) {
			//记录日志
			log("失败",e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

	public List<Map<String, String>> getList() throws Exception {
//		String sql = "select loginid,loginName,mobile=case isnull(mobile,'NULL') when 'NULL' then phone when '' then phone else mobile end,Ctype,State from (" +
//				"select loginid,loginName,mobile,phone,Ctype,State from k_micfo" +
//			    " union "+
//			    "select loginid,loginName,mobile,phone,Ctype,State from k_micfono" +
//			    ") as k_user where loginName not like '%测试%'";
		
		String sql = "select loginid,loginName,mobile=case isnull(mobile,'NULL') when 'NULL' then phone when '' then phone else mobile end,Ctype,State from (" +
		"select loginid,loginName,mobile,phone,Ctype,State from k_micfo" +
	    " union "+
	    "select loginid,loginName,mobile,phone,Ctype,State from k_micfono" +
	    ") as k_user;";

		System.out.println("SQL : "+sql);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			conn = new DBConnect().getConnect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			ResultSetMetaData RSMD = null;
			while (rs.next()) {
				RSMD = rs.getMetaData();
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(),
							StringUtil.showNull(rs.getString(RSMD.getColumnName(i))));
				}
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()+" : 在调用getList()方法获取会员信息时出现异常！",e);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}
		return list;
	}

	public void exportZIP(List<Map<String, String>> list,String txtName) throws Exception {
		File file = new File(ZIP_FROM_DIR);
		if(!file.exists()){
			file.mkdir();
		}
		try {
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(ZIP_FROM_DIR + File.separator + txtName),CHARSET));
			for (Map<String, String> map : list) {
				String str = getString(map);
				out.write(str);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()+" : 在调用exportZIP()方法导出会员信息ZIP包时出现异常！",e);
		} 
	}

	private String getString(Map<String, String> map){
		StringBuffer buf = new StringBuffer();
		buf.append(map.get("loginid")).append("~~")
			.append(map.get("loginname")).append("~~")
			.append(map.get("mobile")==null || "".equals(map.get("mobile")) ? "NULL" : map.get("mobile")).append("~~")
			.append(map.get("ctype")).append("~~")
			.append(map.get("state")).append("\r\n");
		return buf.toString();
	}

	@SuppressWarnings("rawtypes")
	public void zipFile(String zipName,String txtName)throws Exception{
		//TODO
		
		try {
			File file = new File(ZIP_TO_DIR);
			if(!file.exists()){
				file.mkdir();
			}
			List fileList = getSubFiles(new File(ZIP_FROM_DIR),txtName);
			ZipOutputStream zos = new ZipOutputStream(
					new FileOutputStream(ZIP_TO_DIR + File.separator + zipName));
			ZipEntry ze = null;
			byte[] buf = new byte[ZX_BUFFER];
			int readLen = 0;
			for (int i = 0; i < fileList.size(); i++) {
				File f = (File) fileList.get(i);
				ze = new ZipEntry(getAbsFileName(ZIP_FROM_DIR, f));
				ze.setSize(f.length());
				ze.setTime(f.lastModified());
				zos.putNextEntry(ze);
				InputStream is = new BufferedInputStream(new FileInputStream(f));
				while ((readLen = is.read(buf, 0, ZX_BUFFER)) != -1) {
					zos.write(buf, 0, readLen);
				}
				is.close();
			}
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()+" : 在调用zipFile()方法压缩会员信息时出现异常！",e);
		}
	}

	private String getAbsFileName(String baseDir, File realFileName) {
		File real = realFileName;
		File base = new File(baseDir);
		String ret = real.getName();
		while (true) {
			real = real.getParentFile();
			if (real == null)
				break;
			if (real.equals(base))
				break;
			else
				ret = real.getName() + "/" + ret;
		}
		return ret;
}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List getSubFiles(File baseDir,String txtName){
		List ret = new ArrayList();
		File[] tmp = baseDir.listFiles();
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i].getName());
			if (tmp[i].isFile() && tmp[i].getName().equals(txtName))
				ret.add(tmp[i]);
			if (tmp[i].isDirectory())
				ret.addAll(getSubFiles(tmp[i],txtName));
		}
		return ret;
	}
	
	/**
	 * 记录日志
	 */
	private void log(String status, String info) {
		try {
			EducationLogService eduService = new EducationLogService();
			EducationLogTable eduLogTab = new EducationLogTable();
			eduLogTab.setOperation(dcxs);//默认为自动导出
			eduLogTab.setClassName(this.getClass().getName());
//			eduLogTab.setId(new Date().getTime()+"");//使用SQLserver newidI()
			eduLogTab.setIp("127.0.0.1");
			eduLogTab.setTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			eduLogTab.setStatus(status);
			eduLogTab.setInfo(info);
			eduService.save(eduLogTab);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage()+" : "+"写日志时出现异常！",e);
		}
	}
}
