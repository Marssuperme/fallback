package cn.org.gdicpa.web.service.scheduler;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.com.flaginfo.ws.SmsStub;

/**
 * 短信操作类
 * @author Administrator
 *
 */
public class SmsOpt {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SmsStub stub = null;
	private static Properties ps = new Properties();
	private static String url = "";//接口
	private static String In0 = "";//企业编号
	private static String In1 = "";//用户名称
	private static String In2 = "";//用户密码
	private static String In7 = "";//提交时检测方式 1为提交号码中有效的号码仍正常发出短信，无效的号码在返回参数faillist中列出
	static{
		try {
			ps.load(SmsOpt.class.getClassLoader().getResourceAsStream("config.properties"));
			url = ps.getProperty("URL");
			In0 = ps.getProperty("In0");
			In1 = ps.getProperty("In1");
			In2 = ps.getProperty("In2");
			In7 = ps.getProperty("In7");
			stub = new SmsStub(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//短信发送
	public static Map<String,String> send(String smsContent,String mobiles){
		try{
			//发送接口
			SmsStub.Sms sms0 = new SmsStub.Sms();
			sms0.setIn0(In0);//企业编号
			sms0.setIn1(In1);//登录名
			sms0.setIn2(In2);//密码
			sms0.setIn3(smsContent);//短信内容：1、您有一份文件，广州铭太短信平台测试，请尽快收阅。2、您有一份培训通知，请尽快办理。3、您的,广州铭太短信平台测试,办件已超期
			sms0.setIn4(mobiles);//手机号码
			sms0.setIn5("079100"+format.format(new Date()));
			sms0.setIn6("");
			sms0.setIn7(In7);
			sms0.setIn8("");
			SmsStub.SmsResponse resp = stub.Sms(sms0);
			String res = resp.getOut();//结果信息
			System.out.println(resp.getOut());
			//结果信息
			Map<String,String> map = getResultMap(res);
			System.out.println(map);
			int total = Integer.parseInt(mobiles.split(",").length+"");//电话总数
			int faillist = Integer.parseInt(map.get("faillist")!=null && !"".equals(map.get("faillist"))  ? map.get("faillist").split(",").length+"" : "0" );//发送失败的号码数
			
			System.out.println(total + ":" + faillist);
			
			map.put("total", (total - faillist)+"");//成功发送号码总数
			
			return map;
		}catch (Exception e){
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("description", e.getMessage()+": 请检查网络或联系短信营运商。");
			return map;
		}
		
	}
	//
	private static Map<String, String> getResultMap(String res) {
		Map<String,String> map = new HashMap<String,String>();
		String[] r = res.split("&");
		for (int i = 0; i < r.length; i++) {
			String[] r2 = r[i].split("=",2);
			map.put(r2[0], r2[1]);
		}
		return map;
	}

	//查询余额接口
	public static String getBalance(){
		try {
			SmsStub.SearchSmsNumRequest searchSmsNumRequest = new SmsStub.SearchSmsNumRequest();
			searchSmsNumRequest.setIn0(In0);//企业编号
			searchSmsNumRequest.setIn1(In1);//登录名
			searchSmsNumRequest.setIn2(In2);//密码
			SmsStub.SearchSmsNumResponse resp4= stub.SearchSmsNum(searchSmsNumRequest);
			return resp4.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//测试
	public static void main(String[] args) {
		try {
//			Map<String,String> map = SmsOpt.send("您的《广州铭太1》办件已超期。", "13556942212");
			Map<String,String> map = SmsOpt.send("您有一份培训通知，请尽快办理。", "13556942212");
			
			String balance = SmsOpt.getBalance();
			System.out.println("余额 ： " + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
