package cn.org.gdicpa.web.service.education;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static Properties ps = new Properties();
	static{
		try {
			ps.load(ConfigUtil.class.getClassLoader().getResourceAsStream("yj_config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getString(String key){
		return ps.getProperty(key);
	}
	public static Integer getInt(String key){
		return Integer.parseInt(ps.getProperty(key));
	}
	public static Double getDouble(String key){
		return Double.parseDouble(ps.getProperty(key));
	}
	public static void main(String[] args) {
		System.out.println(getString("ZIP_TO_DIR"));
	}
}
