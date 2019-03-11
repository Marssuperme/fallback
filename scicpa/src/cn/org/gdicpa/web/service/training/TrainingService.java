package cn.org.gdicpa.web.service.training;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.service.pay.Order;
import cn.org.gdicpa.web.service.pay.OrderService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sun.org.apache.regexp.internal.recompile;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.pay.Order;
import cn.org.gdicpa.web.service.pay.OrderService;

public class TrainingService {
	private Connection conn = null;
	private static List<Integer> seatnums = null;

	public TrainingService(Connection conn) {
		this.conn = conn;
	}

	public Map get(String table, String nid, String loginid, String ctypetabname) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";

		HashMap arg15;
		try {
			HashMap arg18 = new HashMap();
			ASFuntion CHF = new ASFuntion();
			sql = "select * from " + table + " where id = ? ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, nid);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if (rs.next()) {
				for (int arg20 = 1; arg20 <= RSMD.getColumnCount(); ++arg20) {
					arg18.put(RSMD.getColumnName(arg20).toLowerCase(), rs.getString(RSMD.getColumnName(arg20)));
				}
			}

			DbUtil.close(rs);
			DbUtil.close(ps);
			sql = "select trainingID,count(trainingID) as tcount from b_enroll where trainingID = ? and source = ? group by trainingID ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, table);
			rs = ps.executeQuery();
			if (rs.next()) {
				arg18.put("tcount", rs.getString("tcount"));
			} else {
				arg18.put("tcount", "0");
			}

			DbUtil.close(rs);
			DbUtil.close(ps);
			sql = "select a.*,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid where a.trainingID = ? and a.source = ? and a.tid = ?  ";
			if ("k_company".equalsIgnoreCase(ctypetabname)) {
				sql = "select a.*,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid where a.trainingID = ? and a.source = ? and  a.loginid = ?  ";
			}

			ps = this.conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, table);
			ps.setString(3, loginid);
			rs = ps.executeQuery();
			RSMD = rs.getMetaData();
			String arg201 = "1";

			while (rs.next()) {
				for (int i = 1; i <= RSMD.getColumnCount(); ++i) {
					if (!"id".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())) {
						if (!"tid".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())
								&& !"tname".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())) {
							arg18.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
						} else {
							String string1 = CHF.showNull((String) arg18.get(RSMD.getColumnName(i).toLowerCase()));
							String string = ("".equals(string1) ? "" : string1 + ",")
									+ rs.getString(RSMD.getColumnName(i));
							arg18.put(RSMD.getColumnName(i).toLowerCase(), string);
						}
					} else {
						arg18.put("eid", rs.getString("id"));
					}

					if (!"orderState".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())
							&& ("0".equals(rs.getString("orderstate")) || "".equals(rs.getString("orderstate"))
									|| rs.getString("orderstate") == null)) {
						arg201 = "0";
					}
				}
			}

			if ("k_company".equalsIgnoreCase(ctypetabname)) {
				arg18.put("orderstate", arg201);
			}

			System.out.println("map=|" + arg18 + "     /n  sql=" + sql);
			arg15 = arg18;
		} catch (Exception arg181) {
			System.out.println("saveInfo ERROR :" + sql);
			arg181.printStackTrace();
			throw arg181;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return arg15;
	}

	public String save(String table, Map parameters) throws Exception {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";

		try {
			String arg36 = (String) parameters.get("lessonname");
			String trainingname = (String) parameters.get("trainingname");
			String expense = (String) parameters.get("expense");
			String orderId = (String) parameters.get("orderid");
			String loginid = (String) parameters.get("loginid");
			String loginuser = (String) parameters.get("loginuser");
			String ctypetabname = (String) parameters.get("ctypetabname");
			double expense1 = 0.0D;
			String tnames = (String) parameters.get("tname");
			String tid = (String) parameters.get("tid");
			String companyToMicfoNo = (String) parameters.get("companyToMicfoNo");
			String[] syzss = new String[0];
			String[] syzzs = new String[0];
			String[] syzzs2 = new String[0];
			String[] phones = new String[0];
			String leval = (String) parameters.get("leval2");
			String[] companyToMicfoNos = companyToMicfoNo.split(",");
			String[] levals = leval.split(",");
			String[] ts = tnames.split(",");
			String loginid22 = (String) parameters.get("loginid22");
			String[] loginid22s = new String[0];
			if (loginid22 != null && !"".equals(loginid22)) {
				loginid22s = loginid22.split(",");
			}

			String phone = (String) parameters.get("phones");
			if (phone != null && !"".equals(phone)) {
				phones = phone.split(",");
			}

			int orderService;
			String order;
			String j;
			String arg38;
			for (orderService = 0; orderService < loginid22s.length; ++orderService) {
				sql = "select ctypetabname from k_user where loginid = \'" + loginid22s[orderService] + "\'";
				order = (new DbUtil(this.conn)).queryForString(sql);
				if (!"".equals(order) && order != null) {
					sql = "select mobile from " + order + " where loginid = \'" + loginid22s[orderService] + "\'";
					j = (new DbUtil(this.conn)).queryForString(sql);
					if (j == null || "".equals(j)) {
						sql = "update " + order + " set mobile = \'" + phones[orderService] + "\' where loginid = \'"
								+ loginid22s[orderService] + "\'";
						(new DbUtil(this.conn)).executeUpdate(sql);
					}

					sql = "select post from " + order + " where loginid = \'" + loginid22s[orderService] + "\'";
					arg38 = (new DbUtil(this.conn)).queryForString(sql);
					if (arg38 == null || "".equals(arg38)) {
						sql = "update " + order + " set post = \'" + levals[orderService] + "\' where loginid = \'"
								+ loginid22s[orderService] + "\'";
						(new DbUtil(this.conn)).executeUpdate(sql);
					}

					System.out.println("tabname=" + order + "    loginid22s[j]=" + loginid22s[orderService]
							+ "      mobile=" + j + "   post=" + arg38);
				}
			}

			if ("k_company".equalsIgnoreCase(ctypetabname)) {
				arg38 = (String) parameters.get("syzs");
				order = (String) parameters.get("syzz");
				j = (String) parameters.get("syzz2");
				if (arg38 != null && !"".equals(arg38)) {
					syzss = arg38.split(",");
				}

				if (order != null && !"".equals(order)) {
					syzzs = order.split(",");
				}

				if (j != null && !"".equals(j)) {
					syzzs2 = j.split(",");
				}
			}

			sql = "insert into  b_enroll (id,trainingID,source,loginid,edate,tid,tname,memo,orderId,lessonid,isdormitory,istransit,phone,usertype,leval,enrolltype,seatno,istransit1) values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?) ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(2, (String) parameters.get("trainingid"));
			ps.setString(3, table);
			if ("k_micfo".equalsIgnoreCase(ctypetabname)) {
				sql = "select officecode from k_micfo where loginid = \'" + loginuser + "\'";
				arg38 = (new DbUtil(this.conn)).queryForString(sql);
				ps.setString(4, arg38);
			} else {
				ps.setString(4, loginid);
			}

			ps.setString(5, (String) parameters.get("edate"));
			ps.setString(8, (String) parameters.get("memo"));
			ps.setString(9, orderId);
			ps.setString(10, (String) parameters.get("lessonid"));

			for (orderService = 0; orderService < ts.length; ++orderService) {
				if ("k_company".equalsIgnoreCase(ctypetabname)) {
					if (ts[orderService] == null || "".equals(ts[orderService].trim())) {
						continue;
					}

					sql = "select * from b_enroll where trainingID = \'" + (String) parameters.get("trainingid")
							+ "\' and source = ? and loginid = ? and tname = ? ";
					ps1 = this.conn.prepareStatement(sql);
					ps1.setString(1, table);
					ps1.setString(2, loginid);
					ps1.setString(3, ts[orderService]);
					rs = ps1.executeQuery();
					if (rs.next()) {
						continue;
					}

					DbUtil.close(rs);
					DbUtil.close(ps1);
					if (orderService + 1 <= loginid22s.length) {
						ps.setString(6, loginid22s[orderService]);
					} else {
						order = (new DbUtil(this.conn)).queryForString(
								"select top 1 loginid from k_user where loginname = ?", new Object[]{ts[orderService]});
						if (order == null || "".equals(order)) {
							order = "sd001";
						}

						ps.setString(6, order);
					}

					if ("".equals(expense) || expense == null) {
						expense = "0.00";
					}

					expense1 += Double.parseDouble(expense);
					ps.setString(11, syzss[orderService]);
					ps.setString(12, syzzs[orderService]);
					ps.setString(13, phones[orderService]);
				} else {
					if ("".equals(expense) || expense == null) {
						expense = "0.00";
					}

					expense1 += Double.parseDouble(expense);
					ps.setString(6, loginuser);
					ps.setString(11, (String) parameters.get("isdormitory"));
					ps.setString(12, (String) parameters.get("istransit"));
					ps.setString(13, (String) parameters.get("phone"));
				}

				ps.setString(1, UUID.randomUUID().toString());
				ps.setString(7, ts[orderService]);
				System.out.println("ctypetabname=" + ctypetabname);
				if (!"k_company".equalsIgnoreCase(ctypetabname)) {
					ps.setString(14, "micfo");
					ps.setString(15, (String) parameters.get("leval"));
				} else {
					boolean arg39 = false;

					for (int arg42 = 0; arg42 < companyToMicfoNos.length; ++arg42) {
						if (ts[orderService].equals(companyToMicfoNos[arg42])) {
							arg39 = true;
							break;
						}
					}

					System.out.println("bl=" + arg39);
					if (arg39) {
						ps.setString(14, "companyToMicfoNo");
					} else {
						ps.setString(14, "companyToMicfo");
					}

					ps.setString(15, levals[orderService]);
				}

				if ("k_company".equalsIgnoreCase((String) parameters.get("ctypetabname"))) {
					ps.setString(16, "团体代报名");
				} else {
					ps.setString(16, "个人已报名");
				}

				ps.setInt(17, this.getSeatNoTo(parameters));
				ps.setString(18, syzzs2[orderService]);
				ps.addBatch();
			}

			ps.executeBatch();
			OrderService arg40 = new OrderService(this.conn);
			Order arg41 = new Order();
			arg41.setOrderAmount(expense1);
			arg41.setOrderContent(trainingname + "-报名费");
			arg41.setOrderId(orderId);
			arg41.setUserId(loginid);
			arg40.save(arg41);
			return "";
		} catch (Exception arg381) {
			System.out.println("saveInfo ERROR :" + sql);
			arg381.printStackTrace();
			throw arg381;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(ps1);
			seatnums = null;
		}
	}

	public String del(String loginid, String trainingid, String table) throws Exception {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";

		try {
			byte arg11 = 1;
			sql = "delete from b_enroll where id = ? ";
			ps1 = this.conn.prepareStatement(sql);
			sql = "select a.* from b_enroll a inner join k_order b on a.orderid = b.orderid and orderState = 0 where loginid = ? and trainingid = ? and source = ? ";
			ps = this.conn.prepareStatement(sql);
			int arg14 = arg11 + 1;
			ps.setString(arg11, loginid);
			ps.setString(arg14++, trainingid);
			ps.setString(arg14++, table);
			rs = ps.executeQuery();
			System.err.println(
					"select a.* from b_enroll a inner join k_order b on a.orderid = b.orderid and orderState = 0 where loginid = "
							+ loginid + " and trainingid = " + trainingid + " and source = " + table);

			while (rs.next()) {
				ps1.setString(1, rs.getString("id"));
				ps1.addBatch();
			}

			ps1.executeBatch();
			return "";
		} catch (Exception arg12) {
			System.out.println("saveInfo ERROR :" + sql);
			arg12.printStackTrace();
			throw arg12;
		} finally {
			DbUtil.close(ps);
		}
	}

	public String delByName(String loginid, String trainingid, String table, String tname) throws Exception {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";

		try {
			byte arg12 = 1;
			sql = "delete from b_enroll where id = ? and tname = ? ";
			ps1 = this.conn.prepareStatement(sql);
			sql = "select a.* from b_enroll a inner join k_order b on a.orderid = b.orderid and orderState = 0 where loginid = ? and trainingid = ? and source = ? ";
			ps = this.conn.prepareStatement(sql);
			int arg15 = arg12 + 1;
			ps.setString(arg12, loginid);
			ps.setString(arg15++, trainingid);
			ps.setString(arg15++, table);
			System.err.println(
					"select a.* from b_enroll a inner join k_order b on a.orderid = b.orderid and orderState = 0 where loginid = "
							+ loginid + " and trainingid = " + trainingid + " and source = " + table);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.err
						.println(rs.getString("id") + " --------------- tname=" + tname + "  --------------this is p");
				ps1.setString(1, rs.getString("id"));
				ps1.setString(2, tname);
				ps1.addBatch();
			}

			ps1.executeBatch();
			return "";
		} catch (Exception arg13) {
			System.out.println("saveInfo ERROR :" + sql);
			arg13.printStackTrace();
			throw arg13;
		} finally {
			DbUtil.close(ps);
			DbUtil.close(ps1);
		}
	}

	public void upByid(String trainingId, String tname, String[] str) {
		String sql = "update b_enroll set isdormitory=?,istransit=?,phone=?,istransit1=?,leval=? where tname=? and trainingid=? ";
		PreparedStatement ps = null;

		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, str[0]);
			ps.setString(2, str[1]);
			ps.setString(3, str[2]);
			ps.setString(4, str[3]);
			ps.setString(5, str[4]);
			ps.setString(6, tname);
			ps.setString(7, trainingId);
			ps.execute();
		} catch (SQLException arg9) {
			arg9.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}

	}

	public void expense(String eid, String loginid, String memo) throws Exception {
		PreparedStatement ps = null;
		String sql = "";

		try {
			sql = "update b_enroll  set isexpense = 1 ,memo = ? \twhere trainingid = ? \tand ( loginid = ? or tid = ? ) ";
			ps = this.conn.prepareStatement(sql);
			byte arg9 = 1;
			int arg11 = arg9 + 1;
			ps.setString(arg9, memo);
			ps.setString(arg11++, eid);
			ps.setString(arg11++, loginid);
			ps.setString(arg11++, loginid);
			ps.execute();
		} catch (Exception arg10) {
			System.out.println(" ERROR :" + sql);
			arg10.printStackTrace();
			throw arg10;
		} finally {
			DbUtil.close(ps);
		}

	}

	public String del(String eid, String loginid, String ctypetabname, String p) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		boolean flag = false;
		String tname = "";
		String enrollId = "";
		String[] enrollIds = new String[0];

		String arg17;
		try {
			OrderService arg19 = new OrderService(this.conn);
			if ("k_company".equalsIgnoreCase(ctypetabname)) {
				sql = " select a.* ,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid  where trainingID = ? and loginid = ?  ";
			} else {
				sql = " select a.* ,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid  where trainingID = ? and tid = ?  ";
			}

			ps = this.conn.prepareStatement(sql);
			byte ii = 1;
			int arg21 = ii + 1;
			ps.setString(ii, eid);
			ps.setString(arg21++, loginid);
			rs = ps.executeQuery();

			String arg16;
			while (rs.next()) {
				arg16 = rs.getString("orderState");
				String orderid = rs.getString("orderid");
				if ("1".equals(arg16)) {
					flag = true;
					tname = tname + rs.getString("tname") + ",";
				} else {
					enrollId = enrollId + rs.getString("id") + ",";
					arg19.remove(orderid);
				}
			}

			enrollId = enrollId.substring(0, enrollId.length() - 1);
			sql = "delete from b_enroll where id = ? ";
			if (enrollId.indexOf(",") > -1) {
				enrollIds = enrollId.split(",");

				for (int arg22 = 0; arg22 < enrollIds.length; ++arg22) {
					ps = this.conn.prepareStatement(sql);
					ps.setString(1, enrollIds[arg22]);
					ps.execute();
				}
			} else {
				ps = this.conn.prepareStatement(sql);
				ps.setString(1, enrollId);
				ps.execute();
			}

			if (!flag) {
				return "取消报名成功！";
			}

			arg16 = "参与人" + tname.substring(0, tname.length() - 1) + "已经缴费，不能取消,其他参与人已取消报名成功！";
			arg17 = arg16;
		} catch (Exception arg20) {
			System.out.println(" ERROR :" + sql);
			arg20.printStackTrace();
			throw arg20;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return arg17;
	}

	public Map get(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		HashMap arg5;
		try {
			HashMap arg8 = new HashMap();
			sql = "select count(*) as countall,sum(convert(decimal(18,2), expense)) as expenseall from ( " + sql
					+ ") a";
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				arg8.put("countall", rs.getString("countall"));
				arg8.put("expenseall", rs.getString("expenseall"));
			} else {
				arg8.put("countall", "0");
				arg8.put("expenseall", "0.00");
			}

			arg5 = arg8;
		} catch (Exception arg81) {
			System.out.println(" ERROR :" + sql);
			arg81.printStackTrace();
			throw arg81;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return arg5;
	}

	public List getList(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ArrayList arg11 = new ArrayList();
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();

			while (rs.next()) {
				HashMap arg8 = new HashMap();

				for (int i = 1; i <= RSMD.getColumnCount(); ++i) {
					arg8.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
				}

				arg11.add(arg8);
			}

			ArrayList arg81 = arg11;
			return arg81;
		} catch (Exception arg111) {
			System.out.println(" ERROR :" + sql);
			arg111.printStackTrace();
			throw arg111;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}

	public String isLesson(String lessonid, String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";

		String arg10;
		try {
			ASFuntion arg13 = new ASFuntion();
			String result = "";
			String ispass = "";
			int opt = 0;
			sql = "select a.lessonid,a.lessonname,b.* \tfrom b_training a,dbo.b_enroll b \twhere 1=1 \tand a.lessonid = ? \tand (b.loginid = ? or b.tid = ?) \tand a.id = b.trainingid ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, lessonid);
			ps.setString(2, loginid);
			ps.setString(3, loginid);
			rs = ps.executeQuery();

			while (rs.next()) {
				++opt;
				ispass = arg13.showNull(rs.getString("ispass"));
				if ("1".equals(ispass)) {
					break;
				}
			}

			DbUtil.close(rs);
			DbUtil.close(ps);
			if ("1".equals(ispass)) {
				result = "1";
			} else if (opt != 0 && ("".equals(ispass) || "0".equals(ispass))) {
				result = "2";
			}

			arg10 = result;
		} catch (Exception arg131) {
			arg131.printStackTrace();
			throw arg131;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return arg10;
	}

	public Map getIsTransit(String id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from b_training where id = ?";
		HashMap map = new HashMap();

		HashMap arg8;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResultSetMetaData arg11 = rs.getMetaData();
			if (rs.next()) {
				for (int i = 1; i <= arg11.getColumnCount(); ++i) {
					System.out
							.println(arg11.getColumnName(i).toLowerCase() + "=" + rs.getString(arg11.getColumnName(i)));
					map.put(arg11.getColumnName(i).toLowerCase(), rs.getString(arg11.getColumnName(i)));
				}
			}

			arg8 = map;
		} catch (Exception arg111) {
			System.out.println(" ERROR :" + sql);
			arg111.printStackTrace();
			throw arg111;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}

		return arg8;
	}

	public List getLists(String sql, String loginid) throws Exception {
		System.out.println("报备SQL ： " + sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ArrayList arg13 = new ArrayList();
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();

			while (rs.next()) {
				HashMap arg10 = new HashMap();

				for (int i = 1; i <= RSMD.getColumnCount(); ++i) {
					String leval;
					if (!"phone".equals(RSMD.getColumnName(i).toLowerCase())
							|| rs.getString("phone") != null && !"".equals(rs.getString("phone"))) {
						if (!"leval".equals(RSMD.getColumnName(i).toLowerCase())
								|| rs.getString("leval") != null && !"".equals(rs.getString("leval"))) {
							arg10.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
						} else {
							leval = (new DbUtil(this.conn)).queryForString(
									"select top 1 leval from b_enroll where loginid = ? and tid = ? order by edate desc",
									new Object[]{loginid, rs.getString("loginid")});
							System.out.println(this.getClass() + "      leval=" + leval + "     loginid=" + loginid
									+ "     tid=" + rs.getString("loginid"));
							if (!"".equals(leval) && leval != null) {
								arg10.put(RSMD.getColumnName(i).toLowerCase(), leval);
							} else {
								arg10.put(RSMD.getColumnName(i).toLowerCase(), rs.getString("post"));
							}
						}
					} else {
						leval = (new DbUtil(this.conn)).queryForString(
								"select top 1 phone from b_enroll where loginid = ? and tid = ? order by edate desc",
								new Object[]{loginid, rs.getString("loginid")});
						System.out.println(this.getClass() + "      phone=" + leval + "     loginid=" + loginid
								+ "     tid=" + rs.getString("loginid"));
						if (!"".equals(leval) && leval != null) {
							arg10.put(RSMD.getColumnName(i).toLowerCase(), leval);
						} else {
							arg10.put(RSMD.getColumnName(i).toLowerCase(), rs.getString("mobile"));
						}
					}
				}

				arg13.add(arg10);
			}

			ArrayList arg101 = arg13;
			return arg101;
		} catch (Exception arg131) {
			System.out.println(" ERROR :" + sql);
			arg131.printStackTrace();
			throw arg131;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}

	public synchronized String savePerson(String table, Map parameters) throws Exception {
		PreparedStatement ps = null;
		Object ps1 = null;
		Object rs = null;
		String sql = "";

		try {
			String arg32 = UUID.randomUUID().toString();
			String trainingId = (String) parameters.get("trainingid");
			String source = "b_training";
			String loginid = (String) parameters.get("officecode");
			String edate = (String) parameters.get("edate");
			String tid = (String) parameters.get("loginuser");
			String tname = (String) parameters.get("loginname");
			String memo = (String) parameters.get("memo");
			String orderid = (String) parameters.get("orderid");
			String lessonid = (String) parameters.get("lessonid");
			String isdormitory = (String) parameters.get("isdormitory");
			String istransit = (String) parameters.get("istransit");
			String phone = (String) parameters.get("phone");
			String usertype = (String) parameters.get("usertype");
			String leval = (String) parameters.get("leval");
			String enrolltype = (String) parameters.get("enrolltype");
			String ctypetabname = (String) parameters.get("ctypetabname");
			String trainingname = (String) parameters.get("trainingname");
			String expense = (String) parameters.get("expense");
			double expense1 = 0.0D;
			if (!"".equals(ctypetabname) && ctypetabname != null) {
				sql = "select mobile from " + ctypetabname + " where loginid = \'" + tid + "\'";
				String orderService1 = (new DbUtil(this.conn)).queryForString(sql);
				if (orderService1 == null || "".equals(orderService1)) {
					sql = "update " + ctypetabname + " set mobile = \'" + phone + "\' where loginid = \'" + tid + "\'";
					(new DbUtil(this.conn)).executeUpdate(sql);
				}

				sql = "select post from " + ctypetabname + " where loginid = \'" + tid + "\'";
				String order1 = (new DbUtil(this.conn)).queryForString(sql);
				if (order1 == null || "".equals(order1)) {
					sql = "update " + ctypetabname + " set post = \'" + leval + "\' where loginid = \'" + tid + "\'";
					(new DbUtil(this.conn)).executeUpdate(sql);
				}
			}

			sql = "insert into  b_enroll (id,trainingID,source,loginid,edate,tid,tname,memo,orderId,lessonid,isdormitory,istransit,phone,usertype,leval,enrolltype,seatno) values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?) ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, arg32);
			ps.setString(2, trainingId);
			ps.setString(3, table);
			if ("k_micfo".equalsIgnoreCase(ctypetabname)) {
				ps.setString(4, loginid);
				ps.setString(14, "micfo");
				ps.setString(16, "个人已报名");
			} else {
				ps.setString(4, tid);
				ps.setString(14, "micfono");
				ps.setString(16, "非执业个人已报名");
			}

			ps.setString(5, edate);
			ps.setString(6, tid);
			ps.setString(7, tname);
			ps.setString(8, memo);
			ps.setString(9, orderid);
			ps.setString(10, lessonid);
			ps.setString(11, isdormitory);
			ps.setString(12, istransit);
			ps.setString(13, phone);
			ps.setString(15, leval);
			if (expense != null && !"".equals(expense)) {
				expense1 = Double.parseDouble(expense);
			}

			ps.setInt(17, this.getSeatNoTo(parameters));
			ps.executeUpdate();
			OrderService orderService11 = new OrderService(this.conn);
			Order order11 = new Order();
			order11.setOrderAmount(expense1);
			order11.setOrderContent(trainingname + "-报名费");
			order11.setOrderId(orderid);
			order11.setUserId(loginid);
			orderService11.save(order11);
		} catch (Exception arg321) {
			System.out.println("saveInfo ERROR :" + sql);
			arg321.printStackTrace();
			throw arg321;
		} finally {
			DbUtil.close((ResultSet) rs);
			DbUtil.close(ps);
			DbUtil.close((Statement) ps1);
			seatnums = null;
		}

		return "";
	}

	public List<Integer> getSeatNo(String trainingId) {
		ArrayList seatNos = new ArrayList();
		String sql = "select seatNo from b_enroll where trainingID = \'" + trainingId + "\'";
		PreparedStatement psmt = null;
		ResultSet rst = null;

		try {
			psmt = this.conn.prepareStatement(sql);
			rst = psmt.executeQuery();

			while (rst.next()) {
				seatNos.add(Integer.valueOf(rst.getInt("seatNo")));
			}
		} catch (SQLException arg14) {
			arg14.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}

				if (rst != null) {
					rst.close();
				}
			} catch (SQLException arg13) {
				arg13.printStackTrace();
			}

		}

		return seatNos;
	}

	public int getSeatNoTo(Map parameters) throws Exception {
		if (seatnums == null) {
			seatnums = this.getSeatNo("" + parameters.get("trainingid"));
		}

		String seatMaxNoSql = " select quote as seatno from b_training where id = ? ";
		int seatMaxNo = (new DbUtil(this.conn)).queryForInt(seatMaxNoSql, new Object[]{parameters.get("trainingid")})
				+ 1;
		int seatNo = 0;

		for (int i = 1; i <= seatMaxNo; ++i) {
			if (!seatnums.contains(Integer.valueOf(i))) {
				seatNo = i;
				seatnums.add(Integer.valueOf(i));
				break;
			}
		}

		return seatNo;
	}
	
public String netSchList(String loginid){
		
		StringBuffer sb=new StringBuffer();
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		ResultSet rs=null;

		ResultSet rs2=null;
		try {
			ASFuntion arg14 = new ASFuntion();
			String nowDate = arg14.getCurrentDate();
			String sql = "select * from k_netSchool a left join  (select * from k_netSchoolrecord where loginid=? and SUBSTRING(applytime,1,4)=\'"
					+ DateUtil.getDate("yyyy") + "\') b on a.uuid=b.netSchoolid";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs=ps.executeQuery();
			String  reparestartdate="";
			String repareenddate="";
			
			while(rs.next()){
				 reparestartdate=rs.getString("reparestartdate");
				 repareenddate=rs.getString("repareenddate");
				sb.append("<tr><td style='width: 300px; ' align='center' >")
				.append("<div><a  >")
				.append("<img alt='' src='"+rs.getString("logurl")+"' border='0'></a></div><br/>")
				.append("<a href=\"javascript:netSchInfo('"+rs.getString("uuid")+"');\" style='padding-left: 50px;'>课程介绍</a>")
				.append("</td><td   >");
			/*	//学时补充sql
				String sql2="select * from k_netSchoolrecord where loginid=? and SUBSTRING(applytime,1,4)='"+(Integer.parseInt( DateUtil.getDate("yyyy"))-1)+"' and isrepare='是' and netSchoolid='"+rs.getString("uuid")+"'";
				ps2=conn.prepareStatement(sql2);
				ps2.setString(1, loginid);
				rs2=ps2.executeQuery();*/
				
				if(loginid.equals(rs.getString("loginid"))){
					
					/*String loginname=rs.getString("loginname");
					String certno=rs.getString("certificateno");
					String now=af.getDateAndTime1();
					
					String sign=MD5.getMD5String(loginname+loginid+certno+now);
					
					sb.append("<input name='"+loginname+"'/>");
					sb.append("<input certno='"+certno+"'/>");
					sb.append("<input certno='"+certno+"'/>");*/
					sb.append("<a href=\"javascript:golearn('"+rs.getString("uuid")+"');\" style='font-size: 20px;'>>>"+rs.getString("year")+"年度非执业会员继续教育进入学习</a>");

					//sb.append("<a href=\"http://study.dongao.com/study/login/loginByScHx?name=Mrliu1&certno=1111111113&signtime=2016-08-11&sign=b176b872eb7b140102f3eb814903d4b5;\" style='font-size: ;'>>>进入学习</a>");
				}else {
					String startdate=rs.getString("startdate");
					String enddate=rs.getString("enddate");
					if(startdate!=null&&enddate!=null){
						int isok=DateUtil.equalDateIn(startdate,nowDate, enddate);
						if(isok==0){
							//sb.append("<a href=\"javascript:;\" style='font-size: ;'>报名未开始</a>");
							sb.append("<a href=\"javascript:;\" style=\'font-size:20px ;\'>"+rs.getString("year")
									+ "年非执业会员继续教育培训未开通</a>");//原为报名未开始，应要求改动
						}else if(isok==1){
							sb.append("<a href=\"javascript:apply('"+rs.getString("uuid")+"');\" style='font-size: 20px;'>"+rs.getString("year")+"年度非执业会员继续教育报名</a>");
						}else if(isok==2){
							//sb.append("<a href=\"javascript:;\" style='font-size: ;'>报名已经结束</a>");
							sb.append("<a href=\"javascript:;\" style=\'font-size:20px ;\'>" +rs.getString("year")//原为报名已结束
									+ "年非执业会员继续教育培训未开通</a>");
						}
					}
				}
				int isok2=DateUtil.equalDateIn(reparestartdate,nowDate, repareenddate);
				if(isok2==0){
					sb.append("<br/><a href=\"javascript:;\" style='font-size: ;'>补考未开始</a>");
				}else if(isok2==1){
					if(checkexist(rs.getString("uuid"), Integer.valueOf(rs.getString("year"))-1+"",loginid))
						sb.append("<br/><br/><a href=\"javascript:golearn('"+rs.getString("uuid")+"');\">>>"+( Integer.valueOf(rs.getString("year"))-1)+"年度非执业会员继续教育进入学习</a>");
					else
						sb.append("<br/><br/><a href=\"javascript:repairXS('"+( Integer.valueOf(rs.getString("year"))-1)+"','"+rs.getString("uuid")+"');\" style='font-size: ;'>"+( Integer.valueOf(rs.getString("year"))-1)+"年度非执业会员继续教育补培训</a>");
				}else if(isok2==2){
					sb.append("<br/><a href=\"javascript:;\" style='font-size: ;'>补考已经结束</a>");
				}
				
				sb.append("</td></tr><tr><td colspan='2' style='padding-bottom:30px;'><hr></td></tr>	");
			}
		} catch (Exception arg15) {
			arg15.printStackTrace();
		}
		
		return sb.toString(); 
	}
	
	
	
	private boolean checkexist(String uuid, String year,String loginid) throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql = "select b.netSchoolname,a.isrepare,b.uuid from  k_netSchoolrecord a,k_netSchool b where a.netSchoolid=b.uuid and a.loginid =? and SUBSTRING(a.applytime,1,4)=?  and b.uuid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, loginid);
		ps.setString(2, year);
		ps.setString(3, uuid);
		rs=ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}

	public String netSchInfo(String sid){
		StringBuffer sb=new StringBuffer(); 
		String sql=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ResultSet rs2=null;

		try {
			boolean arg9 = true;
			sql = "select distinct type,sum(convert(numeric(12,2) ,classhour)) as score from k_netSchoolCourseIntro where netSchoolid=? group by type";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, sid);
			rs = ps.executeQuery();
			sql = "select courseName,classhour,teacher,teacherIntro ,courseIntro from k_netSchoolCourseIntro where netSchoolid=? and type=? ";
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, sid);

			while (rs.next()) {
				arg9 = false;
				sb.append("<tr class=\'classtype\'>").append("<td nowrap=\'nowrap\'>序号</td><td nowrap=\'nowrap\'>")
						.append(rs.getString(1)).append("</td>").append("<td  nowrap=\'nowrap\'>课时（" + rs.getString(2)
								+ "）</td><td  nowrap=\'nowrap\'>主讲老师</td><td  nowrap=\'nowrap\'>名师简介</td><td  nowrap=\'nowrap\'>课程介绍</td></tr>");
				ps.setString(2, rs.getString(1));
				rs2 = ps.executeQuery();
				int c = 1;

				while (rs2.next()) {
					sb.append("<tr class=\'classinfo\'><td>").append(c++).append("</td>");

					for (int i = 1; i <= 5; ++i) {
						sb.append("<td>").append(rs2.getString(i)).append("</td>");
					}

					sb.append("</tr>");
				}
			}

			ps.close();
			rs.close();
			if (arg9) {
				sb.append("<tr><td colspan=\'5\'>没有找到相关的课程介绍!</td></tr>");
			}
		} catch (Exception arg91) {
			arg91.printStackTrace();
		}

		return sb.toString();
	}
}