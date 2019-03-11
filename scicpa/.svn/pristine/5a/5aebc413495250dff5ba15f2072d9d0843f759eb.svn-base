package cn.org.gdicpa.web.pub.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: WEB访问控制类</p>
 * <p>Description: WEB访问控制类</p>
 * <p>Copyright: Copyright (c) 2006, 2008 MaTech Corporation.All rights reserved. </p>
 * <p>Company: Matech  广州铭太信息科技有限公司</p>
 *
 * 本程序及其相关的所有资源均为铭太科技公司研发中心审计开发组所有，
 * 版本发行及解释权归研发中心，公司网站为：http://www.matech.cn
 *
 * 贡献者团队:
 *     铭太科技 - 研发中心，审计开发组
 *
 * @author void
 * 2008-3-5
 */
public class Web {
	/**
	 * 判断地址是否可以访问
	 */
	public boolean canAccess(String urlAddress) {
		try {
			URL url = new URL(urlAddress);
			url.openStream();
			return true;
		} catch (Exception e) {
			System.out.println("连接" + urlAddress + "失败 \n");
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 获得指定地址的html
	 */
	public String getUrlHtml(String urlAddress) {
		String weather = "";
		String weatherAll = "暂时无法访问该网页" + urlAddress;
		try {
			URL url = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream()));
			String str = "";
			while ((str = in.readLine()) != null) {
				weather += str;
			}
			in.close();
			weatherAll = weather;

		} catch (Exception e) {
			e.printStackTrace();
			weather = weatherAll;
		}

		return weatherAll;
	}

	/**
	 * 获得E审通的外部访问地址
	 */
	public String getEstOuterUrl(String url) {
		url = "http://" + url + ":5199/AuditSystem/AS_SYSTEM/";
		return url;
	}

	/**
	 * 生成密码key
	 * 先生成一个8位的随机数据 得到变量a
	 * 前2位取asc码相加，取5的模  再+5。得到变量x
	 * 把后六位用作java md5 取前x位，得到变量y
	 * 最后key  为 a+y
	 */
	public String getWebKey() {

		return "";
	}

	public boolean validateWebKey() {
		return false;
	}

	/**
	 * 得到一个指定长度的随机字符串
	 * @param length
	 * @return
	 */
	public String getRanDom(int length) {

		for (int i = 0; i < length; i++) {

		}

		return "";
	}

	/**
	 * 获取浏览器客户端得真实IP地址
	 * @param req
	 * @return
	 */
	public static String getIp(HttpServletRequest req) {
		String ip_for = req.getHeader("x-forwarded-for");
		String ip_client = req.getHeader("http_client_ip");
		String un = "unknown";

		if (ip_for != null && !ip_for.equalsIgnoreCase(un)
				&& ip_for.trim().length() > 0) {
			return ip_for;
		} else if (ip_client != null && !ip_client.equalsIgnoreCase(un)
				&& ip_client.trim().length() > 0) {
			return ip_client;
		} else {
			return req.getRemoteAddr();
		}
	}

	/**
	 * 判断是否内网ip
	 * @param ipAddress
	 * @return
	 */
	public static boolean isInnerIP(String ipAddress) {
		boolean isInnerIp = false;
		long ipNum = getIpNum(ipAddress);
		/**
		私有IP：A类  10.0.0.0-10.255.255.255
		       B类  172.16.0.0-172.31.255.255
		       C类  192.168.0.0-192.168.255.255
		当然，还有127这个网段是环回地址
		 **/
		long aBegin = getIpNum("10.0.0.0");
		long aEnd = getIpNum("10.255.255.255");
		long bBegin = getIpNum("172.16.0.0");
		long bEnd = getIpNum("172.31.255.255");
		long cBegin = getIpNum("192.168.0.0");
		long cEnd = getIpNum("192.168.255.255");
		isInnerIp = isInner(ipNum, aBegin, aEnd)
				|| isInner(ipNum, bBegin, bEnd) || isInner(ipNum, cBegin, cEnd)
				|| ipAddress.equals("127.0.0.1");
		return isInnerIp;
	}

	/**
	 * 获得ip
	 * @param ipAddress
	 * @return
	 */
	private static long getIpNum(String ipAddress) {
		String[] ip = ipAddress.split("\\.");
		long a = Integer.parseInt(ip[0]);
		long b = Integer.parseInt(ip[1]);
		long c = Integer.parseInt(ip[2]);
		long d = Integer.parseInt(ip[3]);

		long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
		return ipNum;
	}

	/**
	 * 判断是否内网ip
	 * @param userIp
	 * @param begin
	 * @param end
	 * @return
	 */
	private static boolean isInner(long userIp, long begin, long end) {
		return (userIp >= begin) && (userIp <= end);
	}
}
