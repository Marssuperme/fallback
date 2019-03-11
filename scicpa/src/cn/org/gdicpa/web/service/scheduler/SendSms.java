package cn.org.gdicpa.web.service.scheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.log.LogService;
import cn.org.gdicpa.web.service.log.model.LogTable;
import cn.org.gdicpa.web.service.scheduler.model.Sms;

/**
 * 定时发送短信
 * @author void
 *
 */ 
public class SendSms {
	
	public void execute() {
		System.out.println("短信发送任务定时调度:" + new Date());
		
		// 发短信
		send();
	}

	/**
	 * 执行发送动作
	 */
	private void send() {
		ASFuntion af = new ASFuntion();
		String mobiles = null;
		String smsContent = null;
		String userName = null;
		String userId = null;
		
		// 撰稿编号
		String id = "";
		String caption=""; 
		String reference=""; 
		String sendCount="0";
		String usefulCount="";
		String sendTime="";
		String propertys = "";
		
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			SmsService smsService = new SmsService(conn);
			List<Sms> list = smsService.getSmsList();
			
			//设置短信息为发送中状态
			for(Sms s : list){
				new DbUtil(conn).executeUpdate("update K_SMS_TASK set status=1 where id='"+s.getId()+"'");
			}			
						
			for(Sms s : list){
				System.out.println("Sms Name : "+s.getCaption());
				mobiles = s.getMobiles();

				mobiles = mobiles.replaceAll(" ", "");
			
				smsContent = s.getSmsContent();
				userName = s.getUsername();
				userId = s.getUserid(); 
			
				// 撰稿编号
				id = s.getId();
				propertys = id ;
			
				caption = s.getCaption();
				reference = s.getReference();
			
				String result = "没有电话号码,不调用发短信的方法！";
				
				//发送短信
				Map<String,String> msg = SmsOpt.send(smsContent,mobiles);
				result = msg.get("description");
				
				System.out.println("短信发送结果："+result);
				
				if("发送短信成功".equals(result)){
					//设置短信息为发送中状态
					new DbUtil(conn).executeUpdate("update K_SMS_TASK set status=2 where id='"+s.getId()+"'");
					// 获取余额
					usefulCount = SmsOpt.getBalance();
					// 发送条数
					sendCount = msg.get("total");
					// 发送成功后的信息
					System.out.println("短信发送结果："+ msg);
					
					//
					if(msg.get("faillist")!=null && !"".equals(msg.get("faillist"))){
						result += " (其中有异常号码没发送成功："+ msg.get("faillist") +")";
					}
					
				}else{
					//设置短信息为发送中状态
					new DbUtil(conn).executeUpdate("update K_SMS_TASK set status=3 where id='"+s.getId()+"'");
					result = "短信失败：" + result;
					usefulCount = SmsOpt.getBalance();
				}						
				
				// 主键
				String uuid = UUID.randomUUID().toString();
					
				System.out.println("使用短信任务表K_SMS_TASK"+"     uuid="+uuid+ "    id_propertys="+id+"   caption="+caption+"   reference="+reference+"  mobiles="+mobiles+ "   发送结果：result" + result+"   smsContent="+smsContent);
				
				sendTime = af.getDateAndTime1();
			
				// 保存当次发送短信的信息
				saveMessage(uuid,caption,reference,mobiles,smsContent,sendCount,result,usefulCount,userName,userId,sendTime,propertys);
				
				// 记录日志
				log(userName, userId, result);			
			}
		} catch (Exception e) {
			System.out.println(this.getClass()+"||| 发送短信出错了：请先严格检查 短信文件内容格式 ！再看是否 sdk 短信方问题。");
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}
	
	/**
	 * 记录日志
	 */
	private void log(String userName, String userId, String result) {
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			
			ASFuntion CHF = new ASFuntion();
			String date = CHF.getCurrentDate();
			String time = CHF.getCurrentTime();
			
			LogTable lt = new LogTable();
			lt.setUserId(userId);
			lt.setUserName(userName);
			lt.setIp("0.0.0.0");
			lt.setLoginDate(date);
			lt.setLoginTime(time);
			lt.setOperation("发送短信"); 
			lt.setMemo("发送结果：" + result);
			
			new LogService(conn).saveLogInfo(lt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}		
	}
	
	/**
	 * 记录本次发短信过程信息
	 * ID、标题、文号、短信内容、本次发送条数、发送结果、剩下短信条数、发送人、发送时间
	 */
	private void saveMessage(String uuid,String caption,String reference,String mobiles,String smsContent,String sendCount,String result,String usefulCount,String userName,String userId,String sendTime,String propertys) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			int i = 1;

			sql = " insert into k_messageInfo(id,caption,reference,mobiles,smsContent,sendCount," 
				+ " result,usefulCount,userName,userId,sendTime, propertys) "
				+ " values(?,?,?,?,?,?, ?,?,?,?,?, ?) ";
			
			conn = new DBConnect().getConnect();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, uuid);
			ps.setString(i++, caption);
			ps.setString(i++, reference);
			ps.setString(i++, mobiles);
			ps.setString(i++, smsContent);
			ps.setString(i++, sendCount);
			
			ps.setString(i++, result);
			ps.setString(i++, usefulCount);
			ps.setString(i++, userName);
			ps.setString(i++, userId);
			ps.setString(i++, sendTime);
			
			ps.setString(i++, propertys);
			
			int rs = ps.executeUpdate();
			
			System.out.println(" 添加本次短信信息 返回值为 rs="+rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
			DbUtil.close(conn);
		}		
	}

	public static void main(String[] args) {
//		System.out.println("aaaaa");
//		new SendSmsNew().send();
	}
}
