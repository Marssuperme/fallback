package cn.org.gdicpa.web.pub.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static String showNull(String str) {
		if(str == null || "null".equalsIgnoreCase(str)) {
			return "";
		} else {
			return str;
		}
	}
	/**
     * 处理null值为空
     * 
     * @String 字符串
     * @return String
     */	
	public static String showNull(Object str) {
		if (str == null || "null".equalsIgnoreCase(str.toString())) {
			return "";
		} else {
			return str.toString();
		}
	}
	public static String kill1(String strIn) {
		if (strIn.length() > 0) {
			if (strIn.substring(0, 1).equals("-"))
				return strIn.substring(1);
			else
				return strIn;

		} else {
			return strIn;
		}
	}

	// 将n个字符c组装为一个字符串String
	public static String nCharToString(char c, int n) {
		String ret = "";
		for (int i = 0; i < n; i++) {
			ret += c;
		}
		return ret;
	}

	public static String nCharToString(String c, int n) {
		String ret = "";
		for (int i = 0; i < n; i++) {
			ret += c;
		}
		return ret;
	}

	public static String killEndToken(String c, String token) {
		String result = c;
		if (c == null || c.equals(""))
			return result;
		int opt = token.length();
		if (result.substring(result.length() - opt).equals(token)) {
			result = result.substring(0, result.length() - opt);
		}
		return result;
	}

	/**
	 * 把字符串数组拼装成一个长字符串，之间用STRTOKEN分隔， 请注意，
	 * getStringFromArray：会把最后多出来的STRTOKEN截掉，比如1,2,3
	 * getStringFromArray：会把最后多出来的STRTOKEN截掉，比如1,2,3,
	 * 
	 * @param strArray
	 *            String[]
	 * @param strToken
	 *            String
	 * @return String
	 */
	public static String getStringFromArray(String[] strArray, String strToken) {
		return killEndToken(getStringFromArray1(strArray, strToken),
				strToken);
	}

	/**
	 * 把字符串数组拼装成一个长字符串，之间用STRTOKEN分隔， 请注意，
	 * getStringFromArray：会把最后多出来的STRTOKEN截掉，比如1,2,3
	 * getStringFromArray：会把最后多出来的STRTOKEN截掉，比如1,2,3,
	 * 
	 * @param strArray
	 *            String[]
	 * @param strToken
	 *            String
	 * @return String
	 */
	public static String getStringFromArray1(String[] strArray, String strToken) {
		String strResult = "";
		if (strArray == null)
			return "";
		for (int i = 0; i < strArray.length; i++) {
			strResult += strArray[i] + strToken;
		}
		return strResult;
	}

	/**
	 * 从类似select a.* FROM c_account a,c_accpkgsubject b where
	 * a.accpackageid='${curPackageid}' and a.submonth=${submonth} and
	 * b.accpackageid='${curPackageid}' and b.SubjectFullName like
	 * CONCAT('${kmmc}','%') and b.isleaf=1 and a.subjectid=b.subjectid order by
	 * a.subjectid 的SQL语句中取出${}包括的部分，放到字符串数组中返回
	 * 
	 * @param str
	 *            String
	 * @return String[]
	 */
	public final static String[] getVaribles(String str) {
		if (str == null || str.equals(""))
			return null;
		int i1 = 0, i2 = 0, i = 0;
		String[] _retStr = new String[str.length() / 3];
		String[] retStr;
		while ((i1 = str.indexOf("${", i2)) != -1) {
			i2 = str.indexOf("}", i1);
			_retStr[i++] = str.substring(i1 + 2, i2);
		}
		retStr = new String[i];
		for (int j = 0; j < i; j++) {
			retStr[j] = _retStr[j];
		}
		return retStr;
	}

	/**
	 * 数据库的PROPERTY字段是按照位进行控制，比如第一位控制是否显示，
	 * 第二位控制是否允许为空等；为了方便大家操纵数据库表PROPERTY字段，设立本函数 实现读取指定位置的位值
	 * 注意:目前是按一位控制，位与位之间没有间隔符
	 * 
	 * @param s
	 *            Property字段的初始值
	 * @param index
	 *            设置第几位
	 * @return char 读取的Property相应位置的值;注意返回-1表示INDEX出错； 例如：
	 * 
	 */
	public static String getProperty(String s, int index) {
		if (s == null)
			return "";
		if (index <= 0)
			return "";
		// 一般习惯是从1到5，而不是JAVA的从0到4，这里作一个替换；
		index--;
		int length = s.length();
		String ret = "";
		if (index <= length - 1) {
			ret = s.substring(index, index + 1);
		}
		return ret;
	}

	/**
	 * 数据库的PROPERTY字段是按照位进行控制，比如第一位控制是否显示，
	 * 第二位控制是否允许为空等；为了方便大家操纵数据库表PROPERTY字段，设立本函数 实现设置指定位置的位值
	 * 注意:目前是按一位控制，位与位之间没有间隔符
	 * 
	 * @param s
	 *            Property字段的初始值
	 * @param index
	 *            设置第几位
	 * @param c
	 *            需要设置的值
	 * @return String 设置完毕的Property字段; 例如：
	 * 
	 */
	public static String SetProperty(String s, int index, char c) {
		index--;
		// 如果index值非法，则返回初始Property;
		if (index < 0)
			return s;

		if (s == null) {
			s = "";
		}

		String result = "";
		int length = s.length();

		// 如果index值<当前Property长度，则修改制定串
		if (index < length - 1) {
			String front = s.substring(0, index);
			String end = s.substring(index + 1);
			result = front + c + end;
		}

		// 如果 index值=当前Property长度，则修改末尾值
		if (index == length - 1) {
			String front = s.substring(0, index);
			result = front + c;
		}

		// 如果index超出当前Property长度，则中间补充空格
		if (index >= length) {
			result = s + nCharToString(' ', index - length) + c;
		}
		return result;
	}

	/**
	 * 字符串格式转换函数，将字符串由ISO8859_1转换为UTF-8
	 * 
	 * @param strIn
	 * @return
	 */
	public String GBToUTF(String strIn) {
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals(""))
			return strIn;
		try {
			byte[] b = strIn.getBytes("ISO8859_1");
			strOut = new String(b, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strOut;
	}

	/**
	 * 
	 * @param strIn
	 *            源字符串
	 * @param sourceCode
	 *            源字符串的编码.比如"ISO8859_1"
	 * @param targetCode
	 *            目标字符串的编码，比如"UTF-8"
	 * @return 目标字符串
	 */
	public static String code2code(String strIn, String sourceCode,
			String targetCode) {
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals(""))
			return strIn;
		try {
			byte[] b = strIn.getBytes(sourceCode);
			strOut = new String(b, targetCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strOut;
	}

	/**
	 * 将UTF8的编码汉字转换回来 反函数是
	 * 
	 * @param s
	 * @param enc
	 * @return
	 * @throws java.lang.Exception
	 */
	public static String decode(String s, String enc) throws Exception {

		boolean needToChange = false;
		StringBuffer sb = new StringBuffer();
		int numChars = s.length();
		int i = 0;

		if (enc.length() == 0) {
			throw new Exception("URLDecoder: empty string enc parameter");
		}

		while (i < numChars) {
			char c = s.charAt(i);
			switch (c) {
			case '+':
				sb.append(' ');
				i++;
				needToChange = true;
				break;
			case '%':

				/*
				 * Starting with this instance of %, process all consecutive
				 * substrings of the form %xy. Each substring %xy will yield a
				 * byte. Convert all consecutive bytes obtained this way to
				 * whatever character(s) they represent in the provided
				 * encoding.
				 */

				try {

					// (numChars-i)/3 is an upper bound for the number
					// of remaining bytes
					byte[] bytes = new byte[(numChars - i) / 3];
					int pos = 0;

					while (((i + 2) < numChars) && (c == '%')) {
						bytes[pos++] = (byte) Integer.parseInt(s.substring(
								i + 1, i + 3), 16);
						i += 3;
						if (i < numChars)
							c = s.charAt(i);
					}

					// A trailing, incomplete byte encoding such as
					// "%x" will cause an exception to be thrown

					if ((i < numChars) && (c == '%'))
						throw new IllegalArgumentException(
								"URLDecoder: Incomplete trailing escape (%) pattern");

					sb.append(new String(bytes, 0, pos, enc));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(
							"URLDecoder: Illegal hex characters in escape (%) pattern - "
									+ e.getMessage());
				}
				needToChange = true;
				break;
			default:
				sb.append(c);
				i++;
				break;
			}
		}

		return (needToChange ? sb.toString() : s);
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名. 纵横软件制作中心雨亦奇2003.08.01
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将文件名中的汉字转为类似UTF8编码的串,以便上传和下载时能正确访问而不被程序错误转换. 类似将%转变成了.号，以方便文件存放。
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtfQQ8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("." + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 把乱七八糟的底稿编号，翻译成可以正常排序的排序编号
	 * 
	 * @param taskCode
	 *            String 底稿编号
	 * @return String 排序编号 例子：
	 *         org.util.Debug.prtOut(UTILString.getOrderId("测试A1－77(3-1)"));
	 *         org.util.Debug.prtOut(UTILString.getOrderId("测试A1－77"));
	 *         org.util.Debug.prtOut(UTILString.getOrderId("测试A1"));
	 *         org.util.Debug.prtOut(UTILString.getOrderId("1")); 返回结果如下：
	 *         测试A00001－00077(00003-00001) 测试A00001－00077 测试A00001 00001
	 */
	public static String getOrderId(String taskCode) {
		if ("".equals(taskCode) || taskCode == null)
			return "";
		String orderId = "";
		String strTemp = "";
		String strCTemp;
		int iStart = -1, iEnd = -1;

		if (taskCode == null || taskCode.equals("")) {
			return "";
		}
		for (int i = 0; i < taskCode.length(); i++) {
			strCTemp = taskCode.substring(i, i + 1);
			try {
				// 尝试做一次转换，成功说明是数字
				Integer.parseInt(strCTemp);
				// 如果是数字
				if (iStart == -1) {
					// 记录起始位置
					iStart = i;
					iEnd = i;
				} else {
					// 延长结束位置
					iEnd++;
				}

			} catch (Exception e) {
				// 异常说明不是数字
				// 如果是非数字
				if (iStart == -1) {
					// 说明前面没有遇到过，不用管，直接追加到最终结果上
					orderId += strCTemp;
				} else {
					// 开始截取这一段纯粹数字组成的字符串做替换
					strTemp = taskCode.substring(iStart, iEnd + 1);
					// 把这一段格式化成5位长度的字符串，不足位在前补零；
					// 如果这一段长度超过5位，则保留并追加
					orderId += nCharToString('0', 4 - iEnd + iStart) + strTemp
							+ taskCode.substring(i, i + 1);

					// 重新设置变量
					iStart = iEnd = -1;
				}
			} // catch
		}

		// 最后可能还有一段未处理，在此追加
		if (iStart >= 0) {
			strTemp = taskCode.substring(iStart, iEnd + 1);
			// 把这一段格式化成5位长度的字符串，不足位在前补零；
			// 如果这一段长度超过5位，则保留并追加
			orderId += nCharToString('0', 4 - iEnd + iStart) + strTemp;
		}

		return orderId;
	}

	/**
	 * 提供一个taskcode，仿照这个taskcode，得到新的taskcode
	 * 
	 * @param taskCode
	 *            String 输入taskcode
	 * @return String 新taskcode 例子：
	 *         org.util.Debug.prtOut(UTILString.getNewTaskCode("1"));
	 *         org.util.Debug.prtOut(UTILString.getNewTaskCode("01"));
	 *         org.util.Debug.prtOut(UTILString.getNewTaskCode("啊啊啊－01")); 结果： 2
	 *         02 啊啊啊－02
	 * 
	 */
	public static String getNewTaskCode(String taskCode) {
		if ("".equals(taskCode) || taskCode == null)
			return "";
		String strTemp = "", orderid = "";
		int intTemp = 0;
		int intEnd = 0;
		intEnd = getNumericIndex(taskCode, 0);
		if (intEnd >= 0) {
			strTemp = taskCode.substring(intEnd);
			intTemp = Integer.parseInt(strTemp);
			intTemp++;
			strTemp = String.valueOf(intTemp);
			// 生成，补零
			orderid = taskCode.substring(0, intEnd)
					+ nCharToString('0', taskCode.length() - intEnd
							- strTemp.length()) + strTemp;
		} else {
			orderid = taskCode + "1";
		}
		return orderid;
	}

	private static int getNumericIndex(String srch, int flag) {
		if ("".equals(srch) || srch == null) {
			return -1;
		}
		int idx = -1;
		char temp = ' ';
		if (flag == 0) {
			for (int i = srch.length() - 1; i >= 0; i--) {
				temp = srch.charAt(i);
				if (Character.isDigit(temp)) {
					idx = i;
				} else {
					break;
				}
			}
		} else {
			for (int i = 0; i < srch.length(); i++) {
				temp = srch.charAt(i);
				if (Character.isDigit(temp)) {
					idx = i;
				} else {
					break;
				}
			}
		}
		return idx;
	}

	/**
	 * 判断一个字符串是否数字字符串的函数 support Numeric format:<br>
	 * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		int begin = 0;
		boolean once = true;
		if (str == null || str.trim().equals("")) {
			return false;
		}
		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				// "+" "-"
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				if (str.charAt(i) == '.' && once) {
					// '.' can only once
					once = false;
				} else {
					return false;
				}
			}
		}
		if (str.length() == (begin + 1) && !once) {
			// "." "+." "-."
			return false;
		}
		return true;
	}

	/**
	 * 判断是不是整数字符串的函数 support Integer format:<br>
	 * "33" "003300" "+33" " -0000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		int begin = 0;
		if (str == null || str.trim().equals("")) {
			return false;
		}
		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				// "+" "-"
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否数字字符串的函数，使用异常来完成 use Exception support Numeric format:<br>
	 * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumericEx(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * 判断是否整数的字符串，使用异常完成 use Exception support less than 11 digits(<11)<br>
	 * support Integer format:<br>
	 * "33" "003300" "+33" " -0000 " "+ 000"
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isIntegerEx(String str) {
		str = str.trim();
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			if (str.startsWith("+")) {
				return isIntegerEx(str.substring(1));
			}
			return false;
		}
	}

	public static String getStr(String Str) {
		int iS = Str.indexOf(">");
		int iE = Str.indexOf(";");
		String str = "";
		if (iS >= 0 && iE >= 0 && iS < 6 && iE < 6) {
			if (iS < iE) {
				str = Str.substring(iS + 1);
			} else {
				str = Str.substring(iE + 1);
			}
		} else if (iS >= 0 && iS < 6) {
			str = Str.substring(iS + 1);
		} else if (iE >= 0 && iE < 6) {
			str = Str.substring(iE + 1);
		} else {
			str = Str;
		}
		iS = str.lastIndexOf("<");
		iE = str.lastIndexOf("&");
		if (iS > str.length() - 6 && iE > str.length() - 6) {
			if (iS > iE) {
				str = str.substring(0, iS);
			} else {
				str = str.substring(0, iE);
			}
		} else if (iS > str.length() - 6) {
			str = str.substring(0, iS);
		} else if (iE > str.length() - 6) {
			str = str.substring(0, iE);
		} 
		return str;
	}

	public static String getStr(String Str, String swhere) {
		int sS = Str.indexOf(swhere);
		int sE = sS + swhere.length();

		int iS = Str.indexOf(">");
		int iE = Str.indexOf(";");
		String str = "";
		if (iS >= 0 && iE >= 0 && iS < sS && iE < sS) {
			if (iS > iE) {
				str = Str.substring(iS + 1);
			} else {
				str = Str.substring(iE + 1);
			}
		} else if (iS >= 0 && iS < sS) {
			str = Str.substring(iS + 1);
		} else if (iE >= 0 && iE < sS) {
			str = Str.substring(iE + 1);
		} else {
			str = Str;
		}
		iS = str.lastIndexOf("<");
		iE = str.lastIndexOf("&");
		if (iS > sE && iE > sE) {
			if (iS > iE) {
				str = str.substring(0, iS);
			} else {
				str = str.substring(0, iE);
			}
		} else if (iS > sE) {
			str = str.substring(0, iS);
		} else if (iE > sE) {
			str = str.substring(0, iE);
		}

		return str;
	}

	/**
	 * 判断字符串是否包含中文
	 * 
	 * @param strIn
	 * @return
	 */
	public static boolean isStringContainChinese(String strIn) {
		if (strIn == null || "".equals(strIn)) {
			return false;
		}

		try {
			if (strIn.length() == (new String(strIn.getBytes(), "8859_1"))
					.length()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得token在str出现的字数
	 * 
	 * @return
	 */
	public static int getStrDisplayTime(String str, String token) {
		int result = 0;
		int i = -1;
		while ((i = str.indexOf(token, i + 1)) != -1) {
			result++;
		}
		return result;
	}

	/**
	 * 格式化日期为yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date2 = simpleDateFormat.parse(date);
			date = simpleDateFormat.format(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 根据一个String得到另一个String：select * from k_user where name =
	 * 'aaa'->select,*,from,k_user,where,name,=,aaa
	 * 
	 * @param date
	 * @return
	 */
	public static String getStringByString(String str) {
		String strs = "";
		try {

			if (str != null) {

				str = str.replaceAll("'", "").replaceAll("\"", "");

				for (int i = 0; i < str.split(" ").length; i++) {

					if (!"".equals(str.split(" ")[i].trim())) {

						strs += str.split(" ")[i] + ",";

					}

				}

				if (strs.endsWith(",")) {

					strs = strs.substring(0, strs.length() - 1);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return strs;

	}

	/**
	 * 根据一个String得到另一个String：select * from k_user where name =
	 * 'aaa'->select,*,from,k_user,where,name,=,aaa
	 * 
	 * @param date
	 * @return
	 */
	public static String addBlank(String str) {

		try {

			str = str.replaceAll("<=", " #1# ").replaceAll(">=", " #2# ")
					.replaceAll("!=", " #3# ");

			str = str.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ")
					.replaceAll("=", " = ").replaceAll("<>", " <> ")
					.replaceAll("#1#", "<=").replaceAll("#2#", ">=")
					.replaceAll("#3#", "!=");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;

	}
	

	public static String setXMLData(String XML, String name, String data) {
		// XML = "<"+name+">"+data+"</"+name+">";
		try {
			if (XML == null || name == null) {
				XML = "";
			}
			String XML2 = XML;

			int len1 = name.length();
			int i = XML.indexOf("<" + name + ">");
			if (i >= 0) {
				int j = XML.indexOf("</" + name + ">");
				if (j >= 0) {
					// String temp=XML.substring(i+len1+2,j-1);
					// String temp =
					return (XML.substring(0, i + len1 + 2) + data + XML2
							.substring(j));
				}
				return XML;
			}
			return XML;
		} catch (Exception e) {
			return XML;
		}
	}

	public static String getXMLData(String XML, String name) {
		try {
			if (XML == null || name == null) {
				return "";
			}

			int len1 = name.length();
			int i = XML.indexOf("<" + name + ">");
			if (i >= 0) {
				int j = XML.indexOf("</" + name + ">");
				if (j >= 0) {
					return (XML.substring(i + len1 + 2, j).trim());
				}
				return "";
			}
			return "";
		} catch (Exception e) {
			return "";
		}
	}

	public static String getXMLData(String XML, String name, String defaultvalule) {
		try {
			if (XML == null || name == null) {
				return "";
			}

			int len1 = name.length();
			int i = XML.indexOf("<" + name + ">");
			if (i >= 0) {
				int j = XML.indexOf("</" + name + ">");
				if (j >= 0) {
					String tempStr = XML.substring(i + len1 + 2, j).trim();
					if (tempStr.equals(""))
						return defaultvalule;
					else
						return (tempStr);
					// return temp.trim();
				}
				return defaultvalule;
			}
			return defaultvalule;
		} catch (Exception e) {
			return defaultvalule;
		}
	}

}
