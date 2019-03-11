//package cn.org.gdicpa.web.service.education;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.List;
//
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipFile;
//
//import cn.org.gdicpa.web.pub.db.DBConnect;
//import cn.org.gdicpa.web.pub.db.DbUtil;
//import cn.org.gdicpa.web.service.education.model.EducationLogTable;
//
//
//public class InportZIP {
//	
//	private static final String CHARSET = ConfigUtil.getString("CHARSET"); //字符集
//	private static final String UNZIP_TO_DIR = ConfigUtil.getString("UNZIP_TO_DIR"); // 解压缩存放的文件目录
//	private static final String UNZIP_FROM_DIR = ConfigUtil.getString("UNZIP_FROM_DIR"); // 要解压的文件目录
//	private static final String YJ_PERFIX = ConfigUtil.getString("YJ_PERFIX");
//	private static final int YJ_BUFFER = 1024; // 缓存大小
//	
//	public void execute(){
//		try {
//			System.out.println(this.getClass().getName()+":"+"运行了！");
//			//解压ZIP文件
//			upZipFile();
//			//导入远教数据
//			inporteDate();
//			//更新正式表学时表、培训班表
//			updateTable();
//			//写日志
//			log("成功","完成");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log("失败",e.getMessage());
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private String getAbsFileName(String baseDir, File realFileName) {
//		File real = realFileName;
//		File base = new File(baseDir);
//		String ret = real.getName();
//		while (true) {
//			real = real.getParentFile();
//			if (real == null)
//				break;
//			if (real.equals(base))
//				break;
//			else
//				ret = real.getName() + "/" + ret;
//		}
//		return ret;
//	}
//	
//	/**
//	 * 解压指定目录下的ZIP文件到目标目
//	 * upZipFile()方法
//	 * @throws Exception
//	 */
//	public void upZipFile() throws Exception {
//		try {
//			String dir = UNZIP_FROM_DIR+File.separator+YJ_PERFIX+DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd"))+".zip";
//			System.out.println("--------------------->:"+dir);
//			File f = new File(dir);
//			if(!f.exists()){
//				log("失败",dir+"文件不存在！");
//				throw new RuntimeException(dir+"文件不存在！");
//			}
//			ZipFile zfile = new ZipFile(f);
//			
//			Enumeration<?> zList = zfile.getEntries();
//			
//			byte[] buf = new byte[YJ_BUFFER];
//			
//			while (zList.hasMoreElements()) {
//				File file = new File(UNZIP_TO_DIR+File.separator+DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd")));
//				if(!file.exists()){
//					file.mkdir();
//				}
//				ZipEntry ze = (ZipEntry) zList.nextElement();
//				OutputStream os = new BufferedOutputStream(new FileOutputStream(UNZIP_TO_DIR+File.separator+DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd"))+File.separator+ze.getName()));
//				InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
//				int readLen = 0;
//				while ((readLen = is.read(buf, 0, 1024)) != -1) {
//					os.write(buf, 0, readLen);
//				}
//				is.close();
//				os.close();
//			}
//			zfile.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e.getMessage()+" : "+"在调用upZipFile()方法解压培训信息时出现异常！",e);
//		}
//	}
//
//	private void inporteDate() throws Exception {
//		try {
//			File file = new File(UNZIP_TO_DIR+File.separator+DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd")));
//			String[] files = file.list();
//			if(files.length==0){
//				log("失败","文件不存在！");
//				throw new RuntimeException("文件不存在！");
//			}
//			for (int i = 0; i < files.length; i++) {
//				File f = new File(UNZIP_TO_DIR+File.separator+DateUtil.getBeforeDate(DateUtil.getCurrentDate("yyyyMMdd"))+File.separator+files[i]);
//				List<String> list = new ArrayList<String>();
//				try {
//					BufferedReader reader = new BufferedReader(
//							new InputStreamReader(
//									new FileInputStream(f),CHARSET));
//					String str = null;
//					while((str = reader.readLine())!=null){
//						list.add(str);
//						
//						System.out.println(str);
//					}
//					reader.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				save(list,files[i].substring(0,2));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e.getMessage()+" : "+"在调用inporteDate()方法导入培训信息到数据表时出现异常！",e);
//		}
//	}
//
//	private void save(List<String> list, String name) {
//		Connection conn = null;
//		Statement stmt = null;
//		String year = DateUtil.getCurrentDate("yyyy");
//		try {
//			conn = new DBConnect().getConnect();
//			conn.setAutoCommit(false);
//			stmt = conn.createStatement();
//			if("学时".equals(name)){
//				stmt.executeUpdate("delete from PERIOD_TEMP where Year="+year);
//			}else if("在线".equals(name)){
//				stmt.executeUpdate("delete from ONLINE_TEMP where Year="+year);
//			}else if("课评".equals(name)){
//				stmt.executeUpdate("delete from COURSE_ASSESS_TEMP where Year="+year);
//			}else if("考分".equals(name)){
//				stmt.executeUpdate("delete from ONLINE_TEST_TEMP where Year="+year);
//			}else if("远教".equals(name)){
//				stmt.executeUpdate("delete from TRAINING_TEMP where Year="+year);
//			}
//		
//			for (int i = 0; i < list.size(); i++) {
//				String [] str = list.get(i).split("~~");
//				String sql = "";
//				if("学时".equals(name)){
//					sql = "insert into PERIOD_TEMP (ID,MemberNo,MemberName,GetPeriodDate,PeriodCount,CourseNo,CourseName,TrainingNo,TrainingName,Year) " +
//							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+year+"')";
//				}else if("在线".equals(name)){
//					sql = "insert into ONLINE_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,OnlineStartTime,OnlineEndTime,OnlineHoure,Year) " +
//							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+year+"')";
//				}else if("课评".equals(name)){
//					sql = "insert into COURSE_ASSESS_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,AssessTime,AssessScore,Year) " +
//							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+year+"')";
//				}else if("考分".equals(name)){
//					sql = "insert into ONLINE_TEST_TEMP (ID,MemberNo,MemberName,CourseNo,CourseName,TestTime,TestScore,Year) " +
//							"values (newid(),'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+year+"')";
//				}else if("远教".equals(name)){
//					sql = "insert into TRAINING_TEMP (TrainingNo,TrainingName,StartDate,EndDate,MemberNo,MemberName,TotalScore,Year) " +
//							"values ('"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+year+"')";
//				}
//				
//				System.out.println(sql);
//				stmt.addBatch(sql);
//			}
//			stmt.executeBatch();
//			conn.commit();
//			log("成功",name+"信息导入完成");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log("失败",e.getMessage()+" : "+name+"信息导入异常");
//			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
//		} finally{
//			DbUtil.close(stmt);
//			DbUtil.close(conn);
//		}
//	}
//	
//	public void updateTable(){
//		Connection conn = null;
//		Statement stmt = null;
//		try{
//			conn = new DBConnect().getConnect();
//			conn.setAutoCommit(false);
//			
//			stmt = conn.createStatement();
//			stmt.executeUpdate("delete from b_training where substring(trainingbdate,1,4)='"+DateUtil.getCurrentDate("yyyy")+"'");
//			stmt.executeUpdate("insert into b_training (id,trainingname,trainingbdate,trainingedate ) select distinct trainingno as id,trainingname,startdate as trainingbdate,enddate as trainingedate from TRAINING_TEMP;");
//			
//			stmt.executeUpdate("delete from xs_content where xstype='上会网络培训班' and currYear='"+DateUtil.getCurrentDate("yyyy")+"'");
//			stmt.executeUpdate("insert into xs_content (PSB_Guid,APPID,APPNAME,XS_GUID,PeriodResult,CurrYear,GUID,XSType,ISPrintCertificate,ISPrintPeriod) " +
//					"select trainingno as PSB_Guid,memberno as APPID,membername as APPNAME,'{BF67A70D-F04B-45AA-84E0-3EF11BEC5F41}' as XS_GUID,totalscore as PeriodResult," +
//					"year as CurrYear,newid() as guid,'上会网络培训班' as xstype,'否' as ISPrintCertificate,'否' as ISPrintPeriod from TRAINING_TEMP");
//			conn.commit();
//			log("成功","更新学时表或培训班表完成");
//		}catch(Exception e){
//			log("失败",e.getMessage()+" : " +"更新学时表或培训班表异常");
//			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
//			e.printStackTrace();
//		} finally{
//			DbUtil.close(stmt);
//			DbUtil.close(conn);
//		}
//	}
//	
//	/**
//	 * 记录日志
//	 */
//	private void log(String status, String info) {
//		try {
//			EducationLogService eduService = new EducationLogService();
//			EducationLogTable eduLogTab = new EducationLogTable();
//			eduLogTab.setOperation("定时导入会员培训信息");
//			eduLogTab.setClassName(this.getClass().getName());
////			eduLogTab.setId(new Date().getTime()+"");//使用SQLserver newidI()
//			eduLogTab.setIp("127.0.0.1");
//			eduLogTab.setTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
//			eduLogTab.setStatus(status);
//			eduLogTab.setInfo(info);
//			eduService.save(eduLogTab);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage()+" : "+"写日志时出现异常",e);
//		}
//	}
//}
