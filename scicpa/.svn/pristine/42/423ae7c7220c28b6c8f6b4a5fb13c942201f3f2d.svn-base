package cn.org.gdicpa.web.pub.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static int equalDate(String sdStr, String edStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date sd = formatter.parse(sdStr, new ParsePosition(0));
		Date ed = formatter.parse(edStr, new ParsePosition(0));
		return (int) ((ed.getTime() - sd.getTime()) / (3600 * 24 * 1000));
	}
	
	public static String getDate(String rule){
		SimpleDateFormat formatter = new SimpleDateFormat(rule);
		return formatter.format(new Date());
	}
	
	public static void main(String[] args) {
		String sdStr = "2010-01-01";
		String edStr = "2013-12-31";
		System.out.println(equalDate(sdStr, edStr));
	}
	public static int equalDateIn(String start,String thedate, String end) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date sd = formatter.parse(start, new ParsePosition(0));
		Date td = formatter.parse(thedate, new ParsePosition(0));
		Date ed = formatter.parse(end, new ParsePosition(0));
		long tdt=td.getTime();
		long sdt=sd.getTime();
		long edt=ed.getTime();
		if(tdt<sdt){
			return 0;
		}else if(tdt>edt){
			return 2;
		}else if(tdt>=sdt&&tdt<=edt){
			return 1;
		}else {
			return 2;
		}
	}
}
