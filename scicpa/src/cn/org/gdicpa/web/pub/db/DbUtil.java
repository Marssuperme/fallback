package cn.org.gdicpa.web.pub.db;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;

/**
 *
 * <p>
 * Title: 数据库专用操作类
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2006, 2008 MaTech Corporation. All rights reserved.
 * </p>
 * <p>
 * Company: Matech 广州铭太信息科技有限公司
 * </p>
 * 本程序及其相关的所有资源均为铭太科技公司研发中心审计开发组所有， 版本发行及解释权归研发中心，公司网站为：http://www.matech.cn
 *
 * 贡献者团队: 铭太科技 - 研发中心，审计开发组
 *
 * @author winnerQ
 * @version 3.0
 */

public class DbUtil {
	private Connection conn;

	// 基于common-log和log4j实现的记录日志，但是比较麻烦，不推荐其它类使用
	private static Log log = LogFactory.getLog(DbUtil.class);

	private QueryRunner queryRunner = new QueryRunner(true);

	/**
	 * 初始化对象，需要传入CONN对象
	 * 
	 * @param conn
	 *            DBConnect
	 */
	public DbUtil(Connection conn) throws Exception {
		this.conn = conn;
	}

	/**
	 * 执行SQL得到记录集,请记住,这个记录集并没有关闭, 请在调用本方法之后,显式的执行关闭记录rs.close()
	 * 
	 * @param strSql
	 *            String
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet getResultSet(String strSql) throws Exception {
		ResultSet rs = null;

		try {
			rs = conn.createStatement().executeQuery(strSql);
		} catch (Exception e) {
			log.error("getResultSet函数执行sql出错=:" + strSql);
			throw new Exception("执行sql出错", e);
		} finally {
		}

		return rs;
	}

	/**
	 * 如果连接对象为空，则抛出异常
	 * 
	 * @param con
	 *            Connection
	 * @throws Exception
	 */
	public static void checkConn(Connection con) throws Exception {
		if (con == null) {
			throw new Exception("连接对象不能为空");
		}
	}

	/**
	 * 执行SQL语句,执行成功返回true,否则记录日志,抛出异常,返回false
	 * 
	 * @param strSql
	 *            String 要执行的SQL语句
	 * @return boolean
	 * @throws Exception
	 */
	public boolean execute(String strSql) throws Exception {
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			return stmt.execute(strSql);
		} catch (Exception e) {
			log.error("execute函数执行sql出错=:" + strSql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC Statement", ex);
				}
			}
		}
	}

	/**
	 * 执行带参数的SQL语句,执行成功返回true,否则记录日志,抛出异常,返回false
	 * 
	 * @param strSql
	 *            String 要执行的SQL语句
	 * @return boolean
	 * @throws Exception
	 */
	public boolean execute(String strSql, Object[] args) throws Exception {
		PreparedStatement ps = null;

		try {
			if (args == null) {
				throw new Exception("参数不能为空!!");
			}

			ps = conn.prepareStatement(strSql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			return ps.execute();

		} catch (Exception e) {
			log.error("execute函数执行sql出错=:" + strSql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC PreparedStatement", ex);
				}
			}
		}
	}

	/**
	 * 执行SQL语句,执行成功返回实际影响行数,否则抛出异常
	 * 
	 * @param sql
	 *            String 要执行的SQL语句
	 * @return boolean
	 * @throws Exception
	 */
	public int executeUpdate(String sql) throws Exception {
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			log.error("execute函数执行sql出错=:" + sql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC Statement", ex);
				}
			}
		}
	}

	/**
	 * 执行带参数的SQL语句,执行成功返回实际影响行数,否则抛出异常
	 * 
	 * @param strSql
	 *            String 要执行的SQL语句
	 * @return boolean
	 * @throws Exception
	 */
	public int executeUpdate(String strSql, Object[] args) throws Exception {
		PreparedStatement ps = null;

		try {
			if (args == null) {
				throw new Exception("参数不能为空!!");
			}

			ps = conn.prepareStatement(strSql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			return ps.executeUpdate();

		} catch (Exception e) {
			log.error("execute函数执行sql出错=:" + strSql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC PreparedStatement", ex);
				}
			}
		}
	}

	/**
	 * 执行带参数的SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回null
	 * 
	 * @param strSql
	 *            String 要执行的SQL语句
	 * @return Object类型,需要自己强制转换
	 * @throws Exception
	 */
	public Object queryForObject(String sql, Object[] args) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object result = null;
		try {
			ps = conn.prepareStatement(sql);

			if (args == null) {
				throw new Exception("参数不能为空!!");
			}

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getObject(1);
			}
		} catch (Exception e) {
			log.error("executeQuery函数执行sql出错=:" + sql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC ResulSet", ex);
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					log.warn("Exception in closing JDBC ps", ex);
				}
			}
		}
		return result;
	}

	/**
	 * 执行带参数的SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回null;
	 * 
	 * @param strSql
	 * @return String类型
	 * @throws Exception
	 */
	public String queryForString(String strSql, Object[] object) throws Exception {
		String result = String.valueOf(queryForObject(strSql, object));
		if (!"null".equals(result)) {
			return result;
		}
		return null;
	}

	/**
	 * 执行带参数的SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回-1;
	 * 
	 * @param strSql
	 * @return int类型
	 * @throws Exception
	 */
	public int queryForInt(String strSql, Object[] object) throws Exception {
		String result = String.valueOf(queryForObject(strSql, object));

		if (!"null".equals(result)) {
			return Integer.parseInt(result);
		}
		return -1;
	}

	/**
	 * 执行SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回null
	 * 
	 * @param strSql
	 *            String 要执行的SQL语句
	 * @return Object类型,需要自己强制转换
	 * @throws Exception
	 */
	public Object queryForObject(final String strSql) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		Object result = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strSql);

			if (rs.next()) {
				result = rs.getObject(1);
			}
		} catch (final Exception e) {
			log.error("executeQuery函数执行sql出错=:" + strSql);
			throw new Exception("执行sql出错", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final SQLException ex) {
					log.warn("Exception in closing JDBC ResulSet", ex);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (final SQLException ex) {
					log.warn("Exception in closing JDBC Statement", ex);
				}
			}
		}
		return result;
	}

	/**
	 * 执行SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回null;
	 * 
	 * @param strSql
	 * @return String类型
	 * @throws Exception
	 */
	public String queryForString(String strSql) throws Exception {
		String result = String.valueOf(queryForObject(strSql));
		if (!"null".equals(result)) {
			return result;
		}
		return null;
	}

	/**
	 * 执行SQL语句,执行成功返回执行结果的第一行第一列的记录,否则记录日志,抛出异常,返回-1;
	 * 
	 * @param strSql
	 * @return int类型
	 * @throws Exception
	 */
	public int queryForInt(String strSql) throws Exception {
		String result = String.valueOf(queryForObject(strSql));

		if (!"null".equals(result)) {
			return Integer.parseInt(result);
		}
		return -1;
	}

	/**
	 * 得到ResultSet记录集的行数。 其实不推荐使用本方法来获取行数,对效率的影响程度需要小郭测试
	 * 
	 * @param RS
	 *            ResultSet
	 * @return int 返回记录集的行数
	 */
	public int getRowCount(ResultSet RS) {
		int rowCount = 0;

		try {
			String rowStatus = "";
			int preRow = 0;

			if (RS.isBeforeFirst()) {
				rowStatus = "isBeforeFirst";
			} else {

				if (RS.isAfterLast()) {
					rowStatus = "isAfterLast";
				} else {
					rowStatus = "normal";
					preRow = RS.getRow();
				}
			}

			RS.last();
			rowCount = RS.getRow();

			if (rowStatus.equals("isBeforeFirst")) {
				RS.beforeFirst();
			} else {

				if (rowStatus.equals("isAfterLast")) {
					RS.afterLast();
				} else {
					RS.absolute(preRow);
				}
			}

		} catch (Exception e) {
			log.error("getRowCount函数执行出错=:" + e.getMessage());
			rowCount = -1;
		}
		return rowCount;
	}

	/**
	 * 得到记录集的列数。
	 * 
	 * @param RS
	 *            ResultSet
	 * @return int 返回记录集的列数
	 */
	public int getColCount(ResultSet RS) {
		int colCount = 0;

		try {
			ResultSetMetaData RSMD = RS.getMetaData();
			colCount = RSMD.getColumnCount();
		} catch (Exception e) {
			log.error("getColCount函数执行出错=:" + e.getMessage());
			colCount = -1;
		}

		return colCount;
	}

	// 分页
	public void absolutePage(ResultSet RS, int pageSize, int page) {

		try {
			RS.absolute(pageSize * (page - 1) + 1);
		} catch (Exception e) {
			log.error("absolutePage函数执行出错=:" + e.getMessage());
		}
	}

	// 从存储过程中得到返回值。
	public int getReturnCode(CallableStatement callablestatement, boolean flag) {
		int i = -1;
		ResultSet resultset = null;
		if (flag) {
			try {
				resultset = callablestatement.getResultSet();
				resultset.next();
				i = resultset.getInt(1);
			} catch (Exception e) {
				log.error("getReturnCode函数执行出错=:" + e.getMessage());
				i = -1;
			} finally {
				try {
					resultset.close();
				} catch (SQLException e) {
					log.warn("getReturnCode函数执行出错=:" + e.getMessage());
				}
			}
		}
		return i;
	}

	/**
	 * 安全关闭RS的代码
	 * 
	 * @param rs
	 *            ResultSet
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			log.warn("安全关闭RS执行出错=:" + e.getMessage());
		}
	}

	/**
	 * 安全关闭Statement
	 * 
	 * @param st
	 *            Statement
	 */
	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			log.warn("安全关闭St执行出错=:" + e.getMessage());
		}
	}

	/**
	 * 安全关闭数据库连接
	 * 
	 * @param conn1
	 *            Connection
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			log.warn("安全关闭conn执行出错=:" + e.getMessage());
		}
	}

	public int insertInfo(String table, String fields, Map<?, ?> map) throws Exception {
		int result = 0;
		PreparedStatement ps = null;
		try {
			String sql = "", sql2 = "?";

			String[] fieldsArray = fields.split(",");
			for (int i = 1; i < fieldsArray.length; i++) {
				sql2 += ",?";
			}
			sql = "insert into " + table + " (" + fields + ") values (" + sql2 + ") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 0; i < fieldsArray.length; i++) {
				String string = (String) map.get(fieldsArray[i]);
				ps.setString(ii, (string == null) ? "" : string);
				ii++;
			}

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public Map getMap(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ASFuntion CHF = new ASFuntion();
			Map map = null;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if (rs.next()) {
				map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i), CHF.showNull(rs.getObject(RSMD.getColumnLabel(i)) + ""));
				}
			}

			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

	}

	/**
	 * 返回Sql语句查询结果集的第一行数据
	 * @param sql  查询Sql语句
	 * @param objs 查询参数，没有参数用null表示
	 * @throws Exception
	 */
	public Map<String, Object> getOneObject2Map(String sql, Object[] objs) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		try {
			MapHandler a = new MapHandler();
			if (objs == null || objs.length == 0) {
				map = queryRunner.query(conn, sql, a);
			} else {
				map = queryRunner.query(conn, sql, a, objs);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 返回Sql语句查询结果集所有记录
	 * @param sql 查询Sql语句
	 * @param objs  查询参数，没有参数用null表示
	 * @return List集合 List集合中存放的是Map Map中 key存放列名 value存放列数据
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllObject2ListMap(String sql, Object[] objs) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			MapListHandler a = new MapListHandler();
			if (objs == null || objs.length == 0) {
				list = (ArrayList<Map<String, Object>>) queryRunner.query(conn, sql, a);
			} else {
				list = (ArrayList<Map<String, Object>>) queryRunner.query(conn, sql, a, objs);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;

	}

	/**
	 * 返回Sql语句查询结果集的第一行数据
	 * @param sql 查询Sql语句
	 * @param objs 查询参数，没有参数用null表示
	 * @throws Exception
	 */
	public Map<String, Object> getOneObject2MapUpper(String sql, Object[] objs) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rms = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}

			rs = ps.executeQuery();
			rms = rs.getMetaData();

			if (rs.next()) {
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					map.put(rms.getColumnLabel(i).toUpperCase(),
							getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
		}
		return map;
	}

	/**
	 * 返回Sql语句查询结果集所有记录
	 * @param sql 查询Sql语句
	 * @param objs 查询参数，没有参数用null表示
	 * @return List集合 List集合中存放的是Map Map中 key存放列名 value存放列数据
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllObject2ListMapUpper(String sql, Object[] objs) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rms = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}

			rs = ps.executeQuery();
			rms = rs.getMetaData();

			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					if (rms.getColumnLabel(i).equals("_id") || rms.getColumnLabel(i).equals("_parent")
							|| rms.getColumnLabel(i).equals("_is_leaf")) {
						map.put(rms.getColumnLabel(i),
								getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
					} else {
						map.put(rms.getColumnLabel(i).toUpperCase(),
								getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
					}
				}
				list.add(map);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return list;

	}

	/**
	 * 返回Sql语句查询结果集所有记录
	 * @param ResultSet 数据库记录集
	 * @return List集合 List集合中存放的是Map Map中 key存放列名 value存放列数据
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllObject2ListMapUpper(ResultSet rs) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		ResultSetMetaData rms = null;
		try {
			rms = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					if (rms.getColumnLabel(i).equals("_id") || rms.getColumnLabel(i).equals("_parent")
							|| rms.getColumnLabel(i).equals("_is_leaf")) {
						map.put(rms.getColumnLabel(i),
								getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
					} else {
						map.put(rms.getColumnLabel(i).toUpperCase(),
								getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
					}
				}
				list.add(map);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return list;

	}

	/**
	 * 返回Sql语句查询结果集所有记录
	 * @param ResultSet  数据库记录集
	 * @return List集合 List集合中存放的是Map Map中 key存放列名 value存放列数据
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllObject2ListMapFromRS(ResultSet rs) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSetMetaData rms = null;
		try {
			rms = rs.getMetaData();

			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					map.put(rms.getColumnLabel(i).toUpperCase(),
							getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i)));
				}
				list.add(map);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * 返回Sql语句查询结果集的第一行数据
	 * @param sql 查询Sql语句
	 * @param objs 查询参数，没有参数用null表示
	 * @throws Exception
	 */
	public Object[] getOneObject2Array(String sql, Object[] objs) {
		Object[] objects = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rms = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}

			rs = ps.executeQuery();
			rms = rs.getMetaData();
			if (rs.next()) {
				objects = new Object[rms.getColumnCount()];
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					objects[i - 1] = getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i));
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return objects;
	}

	/**
	 * 返回Sql语句查询结果集
	 * @param sql  查询Sql语句
	 * @param objs 查询参数，没有参数用null表示
	 * @return List List集合中存放的是Object[]数组，Object数组 将结果集每一条数据以数组方式存放
	 * @throws Exception
	 */
	public List<Object[]> getAllObject2ListArray(String sql, Object[] objs) {
		List<Object[]> list = new ArrayList<Object[]>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rms = null;

		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}

			rs = ps.executeQuery();
			rms = rs.getMetaData();

			while (rs.next()) {
				Object[] objects = new Object[rms.getColumnCount()];
				for (int i = 1; i <= rms.getColumnCount(); i++) {
					objects[i - 1] = this.getStringValue(rs.getObject(rms.getColumnLabel(i)), rms.getColumnType(i));
				}
				list.add(objects);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * 返回Sql语句查询结果集的第一行数据
	 * @param sql 查询Sql
	 * @param cls 查询Bean的Class
	 * @param objs 查询参数，没有参数用null表示
	 * @return Object 返回查询结果对象 （类的属性名务必与数据库表列名一一对应）
	 * @throws Exception
	 */
	public Object getOneObject2Bean(String sql, Class cls, Object[] objs) {
		Object obj = null;
		try {
			BeanHandler a = new BeanHandler(cls);
			if (objs == null || objs.length == 0) {
				obj = queryRunner.query(conn, sql, a);
			} else {
				obj = queryRunner.query(conn, sql, a, objs);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return obj;
	}

	/**
	 * 返回Sql语句查询结果集
	 * @param sql  查询Sql
	 * @param cls  查询Bean的Class
	 * @param objs 查询参数，没有参数用null表示
	 * @return List List集合中存放查询结果Bean
	 * @throws Exception
	 */
	public List<Object> getAllObject2ListBean(String sql, Class cls, Object[] objs) {
		ArrayList<Object> list = null;
		try {
			BeanListHandler<Object> a = new BeanListHandler(cls);
			if (objs == null || objs.length == 0) {
				list = (ArrayList<Object>) queryRunner.query(conn, sql, a);
			} else {
				list = (ArrayList<Object>) queryRunner.query(conn, sql, a, objs);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * 更新数据库
	 * @param table
	 * @param field
	 * @param map
	 * @throws Exception
	 */
	public void update(String table, String keyName, String keyValue, String field, String value) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "update " + table + " set " + field + "=?  where " + keyName + "=? ";

			ps = this.conn.prepareStatement(sql);
			int ii = 1;
			ps.setString(ii++, value);
			ps.setString(ii++, keyValue);
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	/**
	 * 更新数据库
	 * @param table
	 * @param field
	 * @param map
	 * @throws Exception
	 */
	public void update(String table, String field, Map map) throws Exception {

		if (StringUtil.showNull(table).equalsIgnoreCase("")) {
			throw new RuntimeException("表名为空");
		}

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "";
			String sql1 = "";

			sql = "select * from " + table + " where 1=2 ";

			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();

			Iterator it = map.keySet().iterator();
			List valueList = new ArrayList();
			while (it.hasNext()) {
				String key = String.valueOf(it.next());
				String value = String.valueOf(map.get(key));
				key = key.toLowerCase();
				for (int i = 1; i <= RSMD.getColumnCount(); ++i) {
					String columnName = RSMD.getColumnLabel(i).toLowerCase();
					if ((!(StringUtil.showNull(field).toLowerCase().equals(columnName))) && (key.equals(columnName))) {
						sql1 = sql1 + "," + key + "=? ";
						value = StringUtil.showNull(value);
						int fieldType = RSMD.getColumnType(i);
						if (fieldType == 2) {
							value = value.replaceAll(",", "");
						}
						valueList.add(value);
					}
				}
			}

			String fieldValue = StringUtil.showNull(map.get(StringUtil.showNull(field)));

			sql = "update " + table + " set " + sql1.substring(1) + " where " + field + "='" + fieldValue + "'";

			ps = this.conn.prepareStatement(sql);
			for (int i = 0; i < valueList.size(); ++i) {
				ps.setString(i + 1, (String) valueList.get(i));
			}
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	/**
     * 通用增加，修改，删除方法
     * @param sql  增加，修改，删除 
     * @param obj数组 没有参数传递null
     * @return 受影响的行数
     * @throws Exception
     */
    public int update(String sql,Object[] obj) throws Exception{
    	int n=-1;
    	try{
	    	if(obj==null){
	    		n=queryRunner.update(conn,sql);
	    	}else{
	    		n=queryRunner.update(conn, sql, obj);
	    	}	    		
    	}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			throw e;
    	}
    	return n;
    }
	
	/**
	 * 更新
	 * @param table
	 * @param field
	 * @param obj
	 * @throws Exception
	 */
	public void update(String table, String field, Object obj) throws Exception {
		this.update(table, field, this.convertBean(obj));
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * @param type 要转化的类型
	 * @param map 包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException 如果分析类属性失败
	 * @throws IllegalAccessException  如果实例化 JavaBean 失败
	 * @throws InstantiationException  如果实例化 JavaBean 失败
	 * @throws InvocationTargetException  如果调用属性的 setter 方法失败
	 */
	public Object convertMap(Class type, Map map)
			throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);

				Object[] args = new Object[1];
				args[0] = value;

				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean  要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException  如果分析类属性失败
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败
	 * @throws InvocationTargetException  如果调用属性的 setter 方法失败
	 */
	public Map convertBean(Object bean)throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}
	
	/**
	 * 新增一条记录到表里
	 * @param table 表名
	 * @param field  不包括的变量
	 * @param map  待保存值
	 */
	public void add(String table, String field, Map map) throws Exception {

		if (StringUtil.showNull(table).equals("")) {
			throw new RuntimeException("表名为空");
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";

		try {
			String sql1 = "";
			String sql2 = "";

			sql = "SELECT * FROM " + table + " WHERE 1=2 ";
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();

			Iterator it = map.keySet().iterator();

			List valueList = new ArrayList();

			while (it.hasNext()) {
				String key = String.valueOf(it.next());
				String value = String.valueOf(map.get(key));
				key = key.toLowerCase();
				for (int i = 1; i <= RSMD.getColumnCount(); ++i) {
					String columnName = RSMD.getColumnLabel(i).toLowerCase();

					if ((!(StringUtil.showNull(field).toLowerCase().equals(columnName))) && (key.equals(columnName))) {
						sql1 = sql1 + "," + key;
						sql2 = sql2 + ",? ";

						value = StringUtil.showNull(value);
						int fieldType = RSMD.getColumnType(i);
						if (fieldType == 2) {
							value = value.replaceAll(",", "");
						}
						value = value.replaceAll("\"", "&quot;");
						valueList.add(value);
					}
				}

			}

			sql = "INSERT INTO " + table + " (" + sql1.substring(1) + ") VALUES (" + sql2.substring(1) + ") ";

			ps = this.conn.prepareStatement(sql);
			for (int i = 0; i < valueList.size(); ++i) {
				ps.setString(i + 1, (String) valueList.get(i));
			}

			ps.execute();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	/**
	 * 新增一条记录到表里
	 * @param table 表名
	 * @param field  不包括的变量
	 * @param obj  待保存对象
	 */
	public void add(String table, String field, Object obj) throws Exception {
		if (table == null || "".equals(table)) {
			throw new RuntimeException("表名为空");
		}
		this.add(table, field, this.convertBean(obj));
	}
	
	/**
	 * 获取字段字符值
	 * @param value
	 * @param type
	 * @return
	 */
	private String getStringValue(Object value, int type) {
		String result = null;

		switch (type) {
		/*case 2005:
			Clob clob = (Clob) value;
			result = getClobToString(clob);
			break;*/
		/**
		 * case 2: BigDecimal v = (BigDecimal)value; if (v != null) { result =
		 * new DecimalFormat("##0.00").format(v.doubleValue()); break; } result
		 * = "0.00";
		 * 
		 * break;
		 */
		default:
			result = String.valueOf(value);
		}

		return StringUtil.showNull(result);
	}
	
	
}
