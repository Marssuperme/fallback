package cn.org.gdicpa.web.service.certificateReceipt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;

public class CertificateReceiptService {
	private Connection conn;
	public CertificateReceiptService(Connection conn){
		this.conn = conn;
	}
	
	
	/** Map
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Map getInfoBySql(String sql) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Map map = new HashMap();
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
				}
			}
	        return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	

	/** 
	* 将Date按照中文日期格式转换成String.
	*/
	public static String dateToChineseStyle(String dateString) {

		// 用来存储加工重组字符符串日期 
		String[] changeDate = new String[9];
	
	
		// 重组字符串格式日期，方便下一步对其进行操作 
		for(int i=0;i<dateString.length();i++) {
	
	
			if(i < 5) { 
				changeDate[i] = String.valueOf(dateString.charAt(i));
			}
			// 将月份的数值的两位字符合并成一个字符串
			changeDate[5] = String.valueOf(dateString.charAt(5)) + String.valueOf(dateString.charAt(6));
			changeDate[6] = String.valueOf(dateString.charAt(7));
			// 将日期的数值的两位字符合并成一个字符串
			changeDate[7] = String.valueOf(dateString.charAt(8)) + String.valueOf(dateString.charAt(9));
			changeDate[8] = String.valueOf(dateString.charAt(10));           
		
		
		} 

	
		// 遍历重组后的字符串格式日期数组，生成中文日期格式字符串 
		String targetString = new String();
		for(int i=0;i<changeDate.length;i++) {
	
	
			if("0".equals(changeDate[i])) { 
				targetString += "〇";
				continue;
			}               
		
		
			if("1".equals(changeDate[i]) || "01".equals(changeDate[i])) { 
				targetString += "一";
				continue;
			}
		
		
			if("2".equals(changeDate[i]) || "02".equals(changeDate[i])) { 
				targetString += "二";
				continue;
			}
		
		
			if("3".equals(changeDate[i])|| "03".equals(changeDate[i])) { 
				targetString += "三";
				continue;
			}
		
		
			if("4".equals(changeDate[i])|| "04".equals(changeDate[i])) { 
				targetString += "四";
				continue;
			}
		
		
			if("5".equals(changeDate[i])|| "05".equals(changeDate[i])) { 
				targetString += "五";
				continue;
			}
		
		
			if("6".equals(changeDate[i])|| "06".equals(changeDate[i])) { 
				targetString += "六";
				continue;
			}
		
		
			if("7".equals(changeDate[i])|| "07".equals(changeDate[i])) { 
				targetString += "七";
				continue;
			}
		
		
			if("8".equals(changeDate[i])|| "08".equals(changeDate[i])) { 
				targetString += "八";
				continue;
			}
		
		
			if("9".equals(changeDate[i])|| "09".equals(changeDate[i])) { 
				targetString += "九";
				continue;
			}
		
		
			if("10".equals(changeDate[i])) { 
				targetString += "十";
				continue;
			}
		
		
			if("11".equals(changeDate[i])) { 
				targetString += "十一";
				continue;
			}
		
		
			if("12".equals(changeDate[i])) { 
				targetString += "十二";
				continue;
			}
		
		
			if("13".equals(changeDate[i])) { 
				targetString += "十三";
				continue;
			}
		
		
			if("14".equals(changeDate[i])) { 
				targetString += "十四";
				continue;
			}
		
		
			if("15".equals(changeDate[i])) { 
				targetString += "十五";
				continue;
			}
		
		
			if("16".equals(changeDate[i])) { 
				targetString += "十六";
				continue;
			}
		
		
			if("17".equals(changeDate[i])) { 
				targetString += "十七";
				continue;
			}
		
		
			if("18".equals(changeDate[i])) { 
				targetString += "十八";
				continue;
			}
		
		
			if("19".equals(changeDate[i])) { 
				targetString += "十九";
				continue;
			}
		
		
			if("20".equals(changeDate[i])) { 
				targetString += "二十";
				continue;
			}
		
		
			if("21".equals(changeDate[i])) { 
				targetString += "二十一";
				continue;
			}
		
		
			if("22".equals(changeDate[i])) { 
				targetString += "二十二";
				continue;
			}
		
		
			if("23".equals(changeDate[i])) { 
				targetString += "二十三";
				continue;
			}
		
		
			if("24".equals(changeDate[i])) { 
				targetString += "二十四";
				continue;
			}
		
		
			if("25".equals(changeDate[i])) { 
				targetString += "二十五";
				continue;
			}
		
		
			if("26".equals(changeDate[i])) { 
				targetString += "二十六";
				continue;
			}
		
		
			if("27".equals(changeDate[i])) { 
				targetString += "二十七";
				continue;
			}
		
		
			if("28".equals(changeDate[i])) { 
				targetString += "二十八";
				continue;
			}
		
		
			if("29".equals(changeDate[i])) { 
				targetString += "二十九";
				continue;
			}
		
		
			if("30".equals(changeDate[i])) { 
				targetString += "三十";   
				continue;
			}
		
		
			if("31".equals(changeDate[i])) { 
				targetString += "三十一";
				continue;
			}
		
		
			if("年".equals(changeDate[i])) { 
				targetString += "年";
				continue;
			}
		
		
			if("月".equals(changeDate[i])) { 
				targetString += "月";
				continue;
			}
		
		
			if("日".equals(changeDate[i])) { 
				targetString += "日";
				continue;
			}                           
		}               
		return targetString;
	}
	
}
