package cn.org.gdicpa.web.service.scheduler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.scheduler.model.Sms;
/**
 * 短信业务类
 * @author Administrator
 *
 */
public class SmsService {
	private Connection conn = null;
	
	public SmsService() {
	}
	
	public SmsService(Connection conn){
		this.conn = conn;
	}
	/**
	 * 获取状态为0并且在有效期内的未发送的短信集合
	 * @return
	 */
	public List<Sms> getSmsList(){
		String time = new ASFuntion().getDateAndTime1();
		String sql = "select id,caption,reference,mobiles,smsContent,username,userid,sendTime," +
				"vaildTime,status from K_SMS_TASK where status='0' and vaildTime>='"+time+"' " +
				"order by sendTime";
		
		List<Sms> list = new ArrayList<Sms>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Sms s = new Sms();
				s.setId(StringUtil.showNull(rs.getString("id")));
				s.setCaption(StringUtil.showNull(rs.getString("caption")));
				s.setReference(StringUtil.showNull(rs.getString("reference")));
				s.setMobiles(StringUtil.showNull(rs.getString("mobiles")));
				s.setSmsContent(StringUtil.showNull(rs.getString("smsContent")));
				s.setUsername(StringUtil.showNull(rs.getString("username")));
				s.setUserid(StringUtil.showNull(rs.getString("userid")));
				s.setSendTime(StringUtil.showNull(rs.getString("sendTime")));
				s.setVaildTime(StringUtil.showNull(rs.getString("vaildTime")));
				s.setStatus(StringUtil.showNull(rs.getString("status")));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(stmt);
		}
		return list;
	}
	
	/**
	 * 如果短信的手机号码超过200的就尽量平分等份，等份为最少等份并每条不超过200条
	 * @return
	 */
	public List<Sms> cutSms(Sms s){
		List<Sms> list = new ArrayList<Sms>();
		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = new DBConnect().getConnect();
		List<Sms> list = new SmsService(conn).getSmsList();
		System.out.println(list);
		for(Sms s : list){
			System.out.println(s.getCaption());
		}
		System.out.println("-----------------------------------------");
//		String bbbh = new DELAutocode().getAutoCode("报备编号", "2013");
//		System.out.println("报备编号 : -->"+bbbh);
	}
}
