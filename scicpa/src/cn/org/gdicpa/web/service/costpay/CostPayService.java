package cn.org.gdicpa.web.service.costpay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.costpay.model.Pay;
import cn.org.gdicpa.web.service.costpay.model.PayDetail;

public class CostPayService {
	private Connection conn = null ;
	
	public CostPayService(Connection conn){
		this.conn = conn;
	}
	
	public void addPay(Pay pay) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into k_costpay(UUID,iuser,idate,iyear,departname,totalIncome,groupCost,memberCost,cpaCount,total,memo,property) " 
					   + "values(?,?,?,? ,?,?,?,? ,?,?,?,?)" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,pay.getUUID()) ;
			ps.setString(2,pay.getIuser()) ;
			ps.setString(3,pay.getIdate()) ;
			ps.setString(4,pay.getIyear()) ;
			ps.setString(5,pay.getDepartname()) ;
			ps.setString(6,pay.getTotalIncome()) ;
			ps.setString(7,pay.getGroupCost()) ;
			ps.setString(8,pay.getMemberCost()) ;
			ps.setString(9,pay.getCpaCount()) ;
			ps.setString(10,pay.getTotal()) ;
			ps.setString(11,pay.getMemo()) ;
			ps.setString(12,pay.getProperty()) ;
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}
	
	public void delPay(String id) {
		PreparedStatement ps = null ;
		try {
			String sql = "delete from k_costpay where UUID=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}
	
	public void addPayDetail(PayDetail paydetail) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into k_costpay_detail(id,UID,cpaid,username,sex,dutylevel,memo,property) " 
					   + "values(?,?,?,?, ?,?,?,?)" ;
			ps = conn.prepareStatement(sql) ;
			int i = 1;
			ps.setString(i++,UUID.randomUUID().toString()) ;
			ps.setString(i++,paydetail.getUID()) ;
			ps.setString(i++,paydetail.getCpaid()) ;
			ps.setString(i++,paydetail.getUsername()) ;
			ps.setString(i++,paydetail.getSex()) ;
			ps.setString(i++,paydetail.getDutylevel()) ;
			ps.setString(i++,paydetail.getMemo()) ;
			ps.setString(i++,paydetail.getProperty()) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}
	
	public void delPayDetail(String uid) {
		PreparedStatement ps = null ;
		try {
			String sql = "delete from k_costpay_detail where uid=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,uid) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public void delPay(String iyear,String departname) {
		PreparedStatement ps = null ;
		try {
			String sql = "delete from k_costpay where iyear=? and departname=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,iyear) ;
			ps.setString(2,departname) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}
	
	public void delPayDetail(String iyear,String departname) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select UUID from k_costpay where iyear=? and departname=?";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, iyear) ;
			ps.setString(2, departname) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				String uuid = rs.getString(1) ;
				sql = "delete from k_costpay_detail where uid=?" ;
				ps = conn.prepareStatement(sql) ;
				ps.setString(1,uuid) ;
				ps.execute();
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public String isPayExist(String iyear,String departname) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select property from k_costpay where iyear=? and departname=?";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, iyear) ;
			ps.setString(2, departname) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return "";
	}
	
	public Pay getPay(String UUID) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select UUID,iuser,idate,iyear,departname,totalIncome,groupCost,memberCost,cpaCount,total,memo,property " 
					   + "from k_costpay where UUID=?";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, UUID) ;
			rs = ps.executeQuery() ;
			Pay pay = new Pay();
			if(rs.next()) {
				pay.setUUID(rs.getString(1));
				pay.setIuser(rs.getString(2));
				pay.setIdate(rs.getString(3));
				pay.setIyear(rs.getString(4)) ;
				pay.setDepartname(rs.getString(5));
				pay.setTotalIncome(rs.getString(6));
				pay.setGroupCost(rs.getString(7));
				pay.setMemberCost(rs.getString(8)) ;
				pay.setCpaCount(rs.getString(9));
				pay.setTotal(rs.getString(10));
				pay.setMemo(rs.getString(11));
				pay.setProperty(rs.getString(12)) ;
			}
			return pay ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return null;
	}
	
	public List<PayDetail> getUserBydepartCode(String departCode) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<PayDetail> payDetailList = new ArrayList<PayDetail>();
		try {
			String sql = "select cpano,loginname,sex,professional from k_micfo where officecode=? and state='0' and association='广东省注册会计师协会' order by cpano desc " ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,departCode) ;
			rs = ps.executeQuery();
			while(rs.next()) {
				PayDetail payDetail = new PayDetail();
				payDetail.setCpaid(rs.getString(1)) ;
				payDetail.setUsername(rs.getString(2)) ;
				payDetail.setSex(rs.getString(3));
				payDetail.setDutylevel(rs.getString(4));
				payDetailList.add(payDetail);
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
		return payDetailList ;
	}
	
	public List<PayDetail> getPayDetailByUid(String UID) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<PayDetail> payDetailList = new ArrayList<PayDetail>();
		try {
			String sql = "select cpaid,username,sex,dutylevel,memo from k_costpay_detail where UID=? order by cpaid desc" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,UID) ;
			rs = ps.executeQuery();
			while(rs.next()) {
				PayDetail payDetail = new PayDetail();
				payDetail.setCpaid(rs.getString(1)) ;
				payDetail.setUsername(rs.getString(2)) ;
				payDetail.setSex(rs.getString(3));
				payDetail.setDutylevel(rs.getString(4));
				payDetail.setMemo(rs.getString(5));
				payDetailList.add(payDetail);
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
		return payDetailList ;
	}

}
