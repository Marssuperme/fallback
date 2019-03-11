package cn.org.gdicpa.web.service.education;

//import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getCurrentDate(String rule) {
		SimpleDateFormat dateformat = new SimpleDateFormat(rule);
		Date currentdate = new Date();
		return dateformat.format(currentdate);
	}
	
	public static String getBeforeDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date d = cal.getTime();
		return sdf.format(d);
	}
	
	public static void main(String[] args) {
	}
}
