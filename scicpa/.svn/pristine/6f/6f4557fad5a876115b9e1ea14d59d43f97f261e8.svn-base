package cn.org.gdicpa.web.service.hourCostMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.hourCostMain.model.HourCostMainTable;

public class HourCostMainService {
	private Connection conn = null;
	public HourCostMainService (Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public HourCostMainTable getHourHourCostMainTable(String id){
		HourCostMainTable hcmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,fillMan,checkProject,checkoffice,fillTime,totalDays,totalCheckPay,"  
				+ " totalfoodPay,totalbusinessTrips,totalCountMoney,propertys "
				+ " from k_hourcostmain where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				hcmt = new HourCostMainTable();
				hcmt.setId(rs.getString(i++));
				hcmt.setFillMan(rs.getString(i++));
				hcmt.setCheckProject(rs.getString(i++));
				hcmt.setCheckoffice(rs.getString(i++));
				hcmt.setFillTime(rs.getString(i++));
				hcmt.setTotalDays(rs.getString(i++));
				hcmt.setTotalCheckPay(rs.getString(i++));
				hcmt.setTotalfoodPay(rs.getString(i++));
				hcmt.setTotalbusinessTrips(rs.getString(i++));
				hcmt.setTotalCountMoney(rs.getString(i++));
				hcmt.setPropertys(rs.getString(i++));
			}
			return hcmt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	
	/**
	 * 添加对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean addHourCostMainTable(HourCostMainTable hcmt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_hourcostmain (id,fillMan,checkProject,checkoffice,fillTime,totalDays,"  
				+ " totalCheckPay,totalfoodPay,totalbusinessTrips,totalCountMoney,propertys) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, hcmt.getId());
			ps.setString(i++, hcmt.getFillMan());
			ps.setString(i++, hcmt.getCheckProject());
			ps.setString(i++, hcmt.getCheckoffice());
			ps.setString(i++, hcmt.getFillTime());
			ps.setString(i++, hcmt.getTotalDays());
			ps.setString(i++, hcmt.getTotalCheckPay());
			ps.setString(i++, hcmt.getTotalfoodPay());
			ps.setString(i++, hcmt.getTotalbusinessTrips());
			ps.setString(i++, hcmt.getTotalCountMoney());
			ps.setString(i++, hcmt.getPropertys());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 修改对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean updateHourCostManageTable(HourCostMainTable hcmt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_hourcostmain set fillMan=?,checkProject=?,checkoffice=?,fillTime=?,totalDays=?,"  
				+ " totalCheckPay=?,totalfoodPay=?,totalbusinessTrips=?,totalCountMoney=?,propertys=?"  
				+ " where id = ?";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, hcmt.getFillMan());
			ps.setString(i++, hcmt.getCheckProject());
			ps.setString(i++, hcmt.getCheckoffice());
			ps.setString(i++, hcmt.getFillTime());
			ps.setString(i++, hcmt.getTotalDays());
			ps.setString(i++, hcmt.getTotalCheckPay());
			ps.setString(i++, hcmt.getTotalfoodPay());
			ps.setString(i++, hcmt.getTotalbusinessTrips());
			ps.setString(i++, hcmt.getTotalCountMoney());
			ps.setString(i++, hcmt.getPropertys());
			ps.setString(i++, hcmt.getId());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 删除
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean deleteHourCostMainTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_hourcostmain where id = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
}
