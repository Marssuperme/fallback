package cn.org.gdicpa.web.pub.db;

import java.net.ProxySelector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;


public class DBConnect {
	private static ProxoolDataSource proxooldataSource=null;
	public DBConnect() {
		
	};
	public DBConnect(ProxoolDataSource dataSource){
		DBConnect.proxooldataSource=dataSource;
	}
	private final static Log log = LogFactory.getLog(DBConnect.class);
	private static final String key = "0002000200020002"; 
	/**
	 * 向连接池获取连接
	 * 
	 * @return
	 */
	public  Connection getConnect() {
		Connection conn = null;
		try {
			/*conn = DriverManager.getConnection("proxool.proxoolPool");
			 * */
			conn=proxooldataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("初始化proxool失败，将从本地获取连接");
			conn = getLocalConnection();
		}

//		System.out.println("连接对象 ： " + conn);
		return conn;
	}
	/**
	 * 供本地测试使用
	 * @return
	 * @throws Exception
	 */
	private  Connection getLocalConnection() {
		Connection conn = null;
		try {

			String webInfoPath = DBConnect.class.getClassLoader()
					.getResource("").getPath();

			webInfoPath = webInfoPath.substring(1,
					webInfoPath.indexOf("classes"));

			if (webInfoPath.lastIndexOf("/") != webInfoPath.length()) {
				webInfoPath += "/";
			}

			log.info("本地数据库连接池配置路径：" + webInfoPath);

			JAXPConfigurator.configure(webInfoPath + "proxool.xml", false);

			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");

			ProxySelector proxySelector = ProxySelector.getDefault();
			ProxySelector.setDefault(null);
			conn = DriverManager.getConnection("proxool.proxoolPool");
			ProxySelector.setDefault(proxySelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放Statement对象
	 * 
	 * @param conn
	 */
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放ResultSet对象
	 * 
	 * @param conn
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 供本地测试使用
	 * @return
	 * @throws Exception
	 */
//	public Connection getLocalConnection1() throws Exception {
//
//		try {
//			
//			String webInfoPath = DBConnect.class.getClassLoader().getResource("").getPath();
//	
//			webInfoPath = webInfoPath.substring(1, webInfoPath.indexOf("classes"));
//			
//			System.out.println("本地数据库连接池配置路径：" + webInfoPath);
//
//			JAXPConfigurator.configure(webInfoPath + "proxool.xml", false);
//
//			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
//
//			return (Connection) DriverManager.getConnection("proxool.gdicpa");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}
}
