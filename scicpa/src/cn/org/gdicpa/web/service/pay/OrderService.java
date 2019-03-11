package cn.org.gdicpa.web.service.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import cn.org.gdicpa.web.pub.db.DbUtil;

public class OrderService {
	private Connection conn = null;
	
	/**
	 * 已支付状态
	 */
	public static final String ORDER_STATE_PAID = "1";
	
	
	/**
	 * 初始化状态
	 */
	public static final String ORDER_STATE_INIT = "0";
	
	/**
	 * 已取消
	 */
	public static final String ORDER_STATE_CANCEL = "-1";
	
	public OrderService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 获取唯一的订单编号,格式为 当前年月日时分秒 + 随机生成6位数
	 * @return
	 */
	public synchronized String getOrderId() {
		//当前年月日时分秒
		String dateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		//随机生成6位数
		String rand = new DecimalFormat("000000").format(new Random().nextInt(999999));

		return String.valueOf(dateTime + rand);
	}
	
	/**
	 * 生成订单
	 * @param order
	 * @return
	 */
	public int save(Order order) throws Exception {

		String sql = " INSERT INTO k_order( "
					+ " orderId,orderDate,orderContent, orderAmount,userId,orderstate) "
					+ " VALUES(?,?,?, ?,?,?)  ";
		Object[] args = new Object[] {
			order.getOrderId(),
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
			order.getOrderContent(),
			order.getOrderAmount(),
			order.getUserId(),
			ORDER_STATE_INIT
		};
			
		return new DbUtil(conn).executeUpdate(sql, args);	
	}
	
	/**
	 * 更新订单
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int update(Order order) throws Exception {
		String sql = " update k_order set "
				+ " orderDate=?,orderContent=?,orderAmount=?,orderState=?, "
				+ " payDate=?,payType=?,payTarget=?,userId=?,serialNumber=? "
				+ " where orderId=? ";

		Object[] args = new Object[] {

			order.getOrderDate(),
			order.getOrderContent(),
			order.getOrderAmount(),
			order.getOrderState(),
			order.getPayDate(),
			order.getPayType(),
			order.getPayTarget(),
			order.getUserId(),
			order.getSerialNumber(),

			order.getOrderId(),
		};
	
		return new DbUtil(conn).executeUpdate(sql, args);	
	}
	
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public int remove(String orderId) throws Exception {
		String sql = " delete from k_order "
					+ " where orderId=? ";

		Object[] args = new Object[] {
			orderId
		};
	
		return new DbUtil(conn).executeUpdate(sql, args);	
	}
	
	/**
	 * 获取订单
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public Order getOrder(String orderId) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Order order = null;
		
		try {
			String sql = " select * from k_order "
						+ " where orderId=? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				order = new Order();
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderContent(rs.getString("orderContent"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setOrderId(rs.getString("orderId"));
				order.setOrderState(rs.getString("orderState"));
				order.setPayDate(rs.getString("payDate"));
				order.setPayType(rs.getString("payType"));
				order.setPayTarget(rs.getString("payTarget"));
				order.setSerialNumber(rs.getString("serialNumber"));
				order.setUserId(rs.getString("userId"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	
		return order;
	}
	
	public static void main(String[] args) {
		
		OrderService orderService = new OrderService(null);
		for (int i = 0; i < 1000; i++) {
			System.out.println(orderService.getOrderId());
		}
	}
}
