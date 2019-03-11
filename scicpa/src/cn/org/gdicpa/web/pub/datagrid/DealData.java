package cn.org.gdicpa.web.pub.datagrid;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;

public class DealData {

	private static NumberFormat CURFORMATTER = new DecimalFormat("#,###,##0.00");
	private static ASFuntion CHF=new ASFuntion();
	
	// n 是format 字符串 s是数据库查出来的值，和传出去的值。
	// value 是witchisValue
	public static String format(String n, String s, String value) {

		// 第一步，格式化内容。不带<td >
		if (n == null) {
			return null;
		}
		// 无条件把空值赋值""
		if (s == null) {
			s = "";
		}
		if (n.indexOf("showNull") != -1) {
			s = StringUtil.showNull(s);
		}

		// 第二步，第一次加TD,style，一般都加在这里
		if (n.indexOf("showMoney1") != -1) {
			s = showMoney1(s);
		} else if (n.indexOf("showMoney") != -1) {
			s = showMoney(s);
		} else if (n.indexOf("maxLen") != -1) {
			s = maxLen(s, n);
		} else if (n.indexOf("hiddenLen") != -1) {
			s = hiddenLen(s, n);
		} else if (n.indexOf("showDate") != -1) {
			s = showDate(s, n);
		} else if (n.indexOf("showProportion") != -1) {
			s = showProportion(s);
		} else if (n.indexOf("showHidden") != -1) {
			s = showHidden(s); // 隐藏一列
		} else {
			s = "<td style='' >" + s + "</td>";
		}

		/**
		 * add showing by left/right/center
		 */
		if (n.indexOf("showRight") != -1) {
			s = showRight(s);
		} else if (n.indexOf("showCenter") != -1) {
			s = showCenter(s);
		} else if (n.indexOf("showLeft") != -1) {
			s = showLeft(s);
		}

		// color of td
		if (n.indexOf("color") != -1) {
			s = color(s, n); 
		}

		return s;
	}

	public static String showHidden(String s) {
		return "<td  style=\"display:none\">" + s + "</td>";
	}

	public static String showWidth(String s, String v) {
		return "<td  id=\"widthTD" + v + "\" nowarp width=\"100\" >" + s
				+ "</td>";
	}

	public static String showHidden(String s, String v) {
		return "<td  id=\"hiddenTD" + v + "\" style=\"display:none\">" + s
				+ "</td>";
	}

	public static String showMoney2(String s) {
		// 123,456,789.13
		return s == null ? "" : s.replaceAll(",", "");
	}

	public static String showMoney3(String s) {
		s = StringUtil.showNull(s);
		if (!s.equals("")) {

			s = CURFORMATTER.format(Double.valueOf(s).doubleValue()); // -1,234,568
		}

		return s;
	}

	public static String showMoney(String s) {

		s = StringUtil.showNull(s);
		if (!s.equals("")) {

			double d = Double.valueOf(s).doubleValue();

			s = CURFORMATTER.format(d); // -1,234,568

			if (s.trim().indexOf("-") == 0) {
				return ("<td style=\"text-align:right;color:#FF0000\" nowrap>"
						+ s + "</td>");

			} else {
				return ("<td style=\"text-align:right;color:#0000FF\" nowrap>"
						+ s + "</td>");
			}
		} else {
			return ("<td style=\"text-align:right;color:#0000FF\" nowrap></td>");
		}
	}

	public static String showMoney1(String s) {

		s = StringUtil.showNull(s).trim();
		String s1 = "";
		if (!s.equals("")) {

			double d = Double.valueOf(s).doubleValue();
			if (d >= 0) {
				s1 = CURFORMATTER.format(d); // 1,234,568
			} else {
				s1 = "(" + CURFORMATTER.format(-d) + ")";
			}

			if (s.indexOf("-") == 0) {
				return ("<td style=\"text-align:right;color:#FF0000\" nowrap>"
						+ s1 + "</td>");

			} else {
				return ("<td style=\"text-align:right;color:#0000FF\" nowrap>"
						+ s1 + "</td>");
			}
		} else {
			return ("<td style=\"text-align:right;color:#0000FF\" nowrap></td>");
		}
	}

	public static String showMoney(String s, int x) {

		s = StringUtil.showNull(s);
		if (!s.equals("")) {
			String temp = "";
			for (int i = 0; i < x; i++) {
				temp += "0";
			}
			NumberFormat formatter = new DecimalFormat("#,###,##0." + temp);
			double d = Double.valueOf(s).doubleValue();

			s = formatter.format(d); // -1,234,568

			if (s.trim().indexOf("-") == 0) {
				return ("<font color=\"#FF0000\" >" + s + "</font>");

			} else {
				return ("<font color=\"#0000FF\" >" + s + "</font>");
			}
		} else {
			return ("");
		}
	}

	public static String showMoney(String s, String style) {

		s = StringUtil.showNull(s);
		if (!s.equals("")) {

			s = CURFORMATTER.format(Double.valueOf(s).doubleValue()); // -1,234,568

			// org.util.Debug.prtOut(s);

			if (s.trim().indexOf("-") == 0) {
				return ("<td style=\"text-align:right;color:#FF0000\" " + style
						+ " nowrap>" + s + "</td>");

			} else {
				return ("<td style=\"text-align:right;color:#0000FF\" " + style
						+ " nowrap>" + s + "</td>");
			}
		} else {
			return ("<td style=\"text-align:right;color:#0000FF\" " + style + " nowrap></td>");
		}
	}

	public static String showPercent(double number) {
		NumberFormat formatter = new DecimalFormat("0.00");

		if (number < 0) {
			return ("<td style=\"text-align:right;color:#FF0000\" nowrap>"
					+ formatter.format(number) + "%</td>");

		} else {
			return ("<td style=\"text-align:right;color:#0000FF\" nowrap>"
					+ formatter.format(number) + "%</td>");
		}

	}

	public static String showProportion(String number) {
		NumberFormat formatter = new DecimalFormat("0.00");

		double value = Double.parseDouble(number);
		if (value < 0) {
			return ("<td style=\"text-align:right;color:#FF0000\" nowrap >"
					+ formatter.format(value) + "%</td>");

		} else {
			return ("<td style=\"text-align:right;color:#0000FF\" nowrap >"
					+ formatter.format(value) + "%</td>");
		}
	}

	public static String showRight(String s) {
		return CHF.replaceStr(s, "style=''", "style=\"text-align:right;\"");
//		return s.replaceFirst("style=''", "style=\"text-align:right;\"");
		

	}

	public static String showLeft(String s) {
		return CHF.replaceStr(s, "style=''", "style=\"text-align:left;\"");
//		return s.replaceFirst("style=''", "style=\"text-align:left;\"");
	}

	public static String showCenter(String s) {
		return CHF.replaceStr(s, "style=''", "style=\"text-align:center;\"");
//		return s.replaceFirst("style=''", "style=\"text-align:center;\"");
	}

	public static String maxLen(String s, String format) {

		int i = format.indexOf("maxLen:") + 7;
		int j = format.indexOf(" ", i);
		int len = 0;
		try {
			if (j == -1) {
				j = format.length();
			}
			len = Integer.parseInt(format.substring(i, j));
		} catch (Exception e) {
		}

		return "<td style=\"width:"
				+ len
				+ "\" > "
				+ s + "</td>";
	}

	public static String showDate(String s, String format) {
		if (s == null || "".equals(s)) {
			return "<td style=\"\" nowarp >"
					+ s + "</td>";
		}

		int i = format.indexOf("showDate:") + 9;
		int j = format.length();
		String formatString = "";

		formatString = format.substring(i, j);

		try {
			java.util.Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(s);
			return "<td style=\"\" nowarp >"
					+ new SimpleDateFormat(formatString).format(d) + "</td>";
		} catch (Exception e) {
			e.printStackTrace();
			return "<td style=\"\" nowarp >"
					+ s + "</td>";
		}

	}

	public static String hiddenLen(String s, String format) {

		int i = format.indexOf("hiddenLen:") + 10;
		int j = format.indexOf(" ", i);
		int len = 0;
		try {
			if (j == -1) {
				j = format.length();
			}
			len = Integer.parseInt(format.substring(i, j));
		} catch (Exception e) {
		}

		if (s.length() > len) {
			s = "<td style=\"\" title=\"" + s + "\">" + s.substring(0, len)
					+ "..." + "</td>";
		} else {
			s = "<td style=\"\" >" + s + "</td>";
		}

		return s;
	}

	public static String color(String s, String format) {
		int i = format.indexOf("color:") + 6;
		int j = format.indexOf(" ", i);
		if (j == -1) {
			j = format.length();
		}
		String color = format.substring(i, j);

		return s.replaceFirst("style=\\\"", "style=\"color:" + color + ";");
	}
	
	public static void main(String[] args) {
		String s= "<td style='' >11111</td>";
		System.out.println(CHF.replaceStr(s, "style=''", "style=\"text-align:center;\""));
	}
}
