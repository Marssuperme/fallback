package cn.org.gdicpa.web.service.education;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.education.model.EducationLogTable;

public class InportZIP {
	
	private String CHARSET = ConfigUtil.getString("CHARSET"); //字符集
//	private static final String CHARSET = "GBK"; //字符集
	private String UNZIP_TO_DIR = ConfigUtil.getString("UNZIP_TO_DIR"); // 解压缩存放的文件目录
	private String UNZIP_FROM_DIR = ConfigUtil.getString("UNZIP_FROM_DIR"); // 要解压的文件目录
	private String YJ_PERFIX = ConfigUtil.getString("YJ_PERFIX");
	private int YJ_BUFFER = 1024; // 缓存大小
	
	private String CHARSET2 = ConfigUtil.getString("CHARSET2");
	
//	private String DATE_STRING = DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd"));
	private String drxs = "自动导入会员培训信息";//导入形式（drxs）包括“自动”各“手动”
	
	public static void main(String[] args) {
		new InportZIP().execute();
	}
	
	//重载方法，为手动导入数据使用
	public void execute(String date){
		drxs = "手动导入会员培训信息";
		String dateString = date;
		try {
			System.out.println(this.getClass().getName()+":"+"运行了！");
			//解压ZIP文件
			upZipFile(dateString);
			//导入临时库
			inporteDate(dateString);
			//更新正式表学时表、培训班表
			updateTable();
			
			log("成功","完成");
		} catch (Exception e) {
			e.printStackTrace();
			log("失败",e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	public void execute(){
		String dateString = DateUtil.getBeforeDate();
		try {
			System.out.println(this.getClass().getName()+":"+"运行了！");
			//解压ZIP文件
			upZipFile(dateString);
			//导入临时库
			inporteDate(dateString);
			//更新正式表学时表、培训班表
			updateTable();
			
			log("成功","完成");
		} catch (Exception e) {
			e.printStackTrace();
			log("失败",e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
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
	
	/**
	 * 解压指定目录下的ZIP文件到目标目
	 * upZipFile()方法
	 * @throws Exception
	 */
	public void upZipFile(String dateString) throws Exception {
		try {
			String dir = UNZIP_FROM_DIR+File.separator+YJ_PERFIX+dateString+".zip";
//			String dir = UNZIP_FROM_DIR+File.separator+YJ_PERFIX+"20130422"+".zip";//--测试
			System.out.println("--------------------->:"+dir);
			File f = new File(dir);
			if(!f.exists()){
				log("失败",dir+"文件不存在！");
				throw new RuntimeException(dir+"文件不存在！");
			}
			ZipFile zfile = new ZipFile(f,CHARSET2);
			
			Enumeration<?> zList = zfile.getEntries();
			
			byte[] buf = new byte[YJ_BUFFER];
			
			while (zList.hasMoreElements()) {
				File file = new File(UNZIP_TO_DIR+File.separator+dateString);
//				File file = new File(UNZIP_TO_DIR+File.separator+"20130422");//--测试
				if(!file.exists()){
					file.mkdir();
				}
				ZipEntry ze = (ZipEntry) zList.nextElement();
				
				System.out.println(ze.getName());
				
				OutputStream os = new BufferedOutputStream(new FileOutputStream(UNZIP_TO_DIR+File.separator+dateString+File.separator+ze.getName()));
//				OutputStream os = new BufferedOutputStream(new FileOutputStream(UNZIP_TO_DIR+File.separator+"20130422"+File.separator+ze.getName()));//--测试
				InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
				int readLen = 0;
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					os.write(buf, 0, readLen);
				}
				is.close();
				os.close();
			}
			zfile.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()+" : "+"在调用upZipFile()方法解压培训信息时出现异常！",e);
		}
	}

	private void inporteDate(String dateString) throws Exception {
		try {
			File file = new File(UNZIP_TO_DIR+File.separator+dateString);
//			File file = new File(UNZIP_TO_DIR+File.separator+"20130422");//--测试
			String[] files = file.list();
			if(files.length==0){
				log("失败","文件不存在！");
				throw new RuntimeException("文件不存在！");
			}
			for (int i = 0; i < files.length; i++) {
				File f = new File(UNZIP_TO_DIR+File.separator+dateString+File.separator+files[i]);
//				File f = new File(UNZIP_TO_DIR+File.separator+"20130422"+File.separator+files[i]);//--测试
				List<String> list = new ArrayList<String>();
				try {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream(f),CHARSET));
					String str = null;
					while((str = reader.readLine())!=null){
						System.out.println(str);
						list.add(str);
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				save(list,files[i].substring(0,2));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()+" : "+"在调用inporteDate()方法导入培训信息到数据表时出现异常！",e);
		}
	}

	private void save(List<String> list, String name) {
		Connection conn = null;
		Statement stmt = null;
		String year = DateUtil.getCurrentDate("yyyy");
		try {
			conn = new DBConnect().getConnect();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			if("学时".equals(name)){
				stmt.executeUpdate("delete from PERIOD_TEMP where Year="+year);
			}else if("在线".equals(name)){
				stmt.executeUpdate("delete from ONLINE_TEMP where Year="+year);
			}else if("课评".equals(name)){
				stmt.executeUpdate("delete from COURSE_ASSESS_TEMP where Year="+year);
			}else if("考分".equals(name)){
				stmt.executeUpdate("delete from ONLINE_TEST_TEMP where Year="+year);
			}else if("远教".equals(name)){
				stmt.executeUpdate("delete from TRAINING_TEMP where Year="+year);
			}
			for (int i = 0; i < list.size(); i++) {
				String [] str = list.get(i).split("~~",100);
				String sql = null;
				System.out.println("++++++++++++++++++++++++++++++++++====="+name);
				if("学时".equals(name)){
					sql = "insert into PERIOD_TEMP (ID,MemberNo,MemberName,GetPeriodDate,PeriodCount,CourseNo,CourseName,TrainingNo,TrainingName,Year) " +
							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+year+"')";
				}else if("在线".equals(name)){
					sql = "insert into ONLINE_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,OnlineStartTime,OnlineEndTime,OnlineHoure,Year) " +
							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+year+"')";
				}else if("课评".equals(name)){
					sql = "insert into COURSE_ASSESS_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,AssessTime,CourseAssess,ServiceAssess,AssessScore,AssessComment,Year) " +
							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+str[8]+"','"+year+"')";
				}else if("考分".equals(name)){
					sql = "insert into ONLINE_TEST_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,TestTime,TestScore,Year) " +
							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+year+"')";
				}else if("远教".equals(name)){
					sql = "insert into TRAINING_TEMP (TrainingNo,TrainingName,StartDate,EndDate,MemberNo,MemberName,TotalScore,Year) " +
							"values ('"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+year+"')";
				}
				
				System.out.println("------------------->"+sql);
				if(sql!=null){
					stmt.addBatch(sql);
				}
			}
			stmt.executeBatch();
			conn.commit();
			log("成功",name+"信息导入完成");
		} catch (Exception e) {
			e.printStackTrace();
			log("失败",e.getMessage()+" : "+name+"信息导入异常");
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
		} finally{
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}
	}
	
	public void updateTable(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = new DBConnect().getConnect();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			//备份b_training
//			stmt.executeUpdate("select * into b_training_"+(new Date().getTime())+" from b_training");
			//删除原来上海会院培训数据
			stmt.executeUpdate("delete from b_training where substring(trainingbdate,1,4)='"+DateUtil.getCurrentDate("yyyy")+"' AND proxy='上海会院'");
			//插入全量培训数据
			stmt.executeUpdate("insert into b_training (id,trainingname,trainingbdate,trainingedate,ctype,proxy ) select distinct trainingno as id,trainingname,startdate as trainingbdate,enddate as trainingedate,ctype=case when trainingname like '%非执业%' then '非执业会员' else '执业会员' end,'上海会院' as proxy from TRAINING_TEMP;");
			
			//备份xs_content
//			stmt.executeUpdate("select * into xs_content_"+(new Date().getTime())+" from xs_content");
			//删除原来上海会院培训数据
			stmt.executeUpdate("delete from xs_content where xstype='网络培训班' and currYear='"+DateUtil.getCurrentDate("yyyy")+"' AND proxy='上海会院'");
			//插入全量培训数据
			stmt.executeUpdate("insert into xs_content (PSB_Guid,APPID,APPNAME,XS_GUID,SFJY,PeriodResult,PSB_MC,CurrYear,GUID,XSType,ISPrintCertificate,ISPrintPeriod,proxy) " +
					"select trainingno as PSB_Guid,memberno as APPID,membername as APPNAME,'{BF67A70D-F04B-45AA-84E0-3EF11BEC5F41}' as XS_GUID,'1' as SFJY,totalscore as PeriodResult,'审核通过' as PSB_MC," +
					"year as CurrYear,newid() as guid,'网络培训班' as xstype,'是' as ISPrintCertificate,'是' as ISPrintPeriod,'上海会院' as proxy from TRAINING_TEMP");
			conn.commit();
			log("成功","更新学时表或培训班表完成");
		}catch(Exception e){
			log("失败",e.getMessage()+" : " +"更新学时表或培训班表异常");
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally{
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}
	}
	
	/**
	 * 记录日志
	 */
	private void log(String status, String info) {
		try {
			EducationLogService eduService = new EducationLogService();
			EducationLogTable eduLogTab = new EducationLogTable();
			eduLogTab.setOperation(drxs);//默认自动导入
			eduLogTab.setClassName(this.getClass().getName());
//			eduLogTab.setId(new Date().getTime()+"");
			eduLogTab.setIp("127.0.0.1");
			eduLogTab.setTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			eduLogTab.setStatus(status);
			eduLogTab.setInfo(info);
			eduService.save(eduLogTab);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage()+" : "+"写日志时出现异常",e);
		}
	}
}
