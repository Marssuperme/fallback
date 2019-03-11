package cn.org.gdicpa.web.service.hourCostManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.hourCostManage.model.CityTransportTable;
import cn.org.gdicpa.web.service.hourCostManage.model.HourCostManageTable;


public class HourCostManageService {
	private Connection conn = null;
	public HourCostManageService (Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public HourCostManageTable getHourCostManageTable(String id){
		HourCostManageTable hcmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,mid,checkManID,startTime,endTime,countDays,checkPay,foodPay,"
				+ " businessTrips,countMoney,checkOffice,checkProject,fillMan,fillTime,propertys"
				+ " from k_hourCostManage where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				hcmt = new HourCostManageTable();
				hcmt.setId(rs.getString(i++));
				hcmt.setMid(rs.getString(i++));
				hcmt.setCheckManID(rs.getString(i++));
				hcmt.setStartTime(rs.getString(i++));
				hcmt.setEndTime(rs.getString(i++));
				hcmt.setCountDays(rs.getString(i++));
				hcmt.setCheckPay(rs.getString(i++));
				hcmt.setFoodPay(rs.getString(i++));
				hcmt.setBusinessTrips(rs.getString(i++));
				hcmt.setCountMoney(rs.getString(i++));
				hcmt.setCheckOffice(rs.getString(i++));
				hcmt.setCheckProject(rs.getString(i++));
				hcmt.setFillMan(rs.getString(i++));
				hcmt.setFillTime(rs.getString(i++));
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
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public List getManyHourCostManageTable(String mid){
		HourCostManageTable hcmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,mid,checkManID,startTime,endTime,countDays,checkPay,foodPay,"
				+ " businessTrips,countMoney,checkOffice,checkProject,fillMan,fillTime,propertys"
				+ " from k_hourCostManage where mid = ?";
			System.out.println(this.getClass()+"    mid="+mid);
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			List<HourCostManageTable> list = new ArrayList<HourCostManageTable>();
			while(rs.next()){
				int i = 1;
				hcmt = new HourCostManageTable();
				hcmt.setId(rs.getString(i++));
				hcmt.setMid(rs.getString(i++));
				hcmt.setCheckManID(rs.getString(i++));
				hcmt.setStartTime(rs.getString(i++));
				hcmt.setEndTime(rs.getString(i++));
				hcmt.setCountDays(rs.getString(i++));
				hcmt.setCheckPay(rs.getString(i++));
				hcmt.setFoodPay(rs.getString(i++));
				hcmt.setBusinessTrips(rs.getString(i++));
				hcmt.setCountMoney(rs.getString(i++));
				hcmt.setCheckOffice(rs.getString(i++));
				hcmt.setCheckProject(rs.getString(i++));
				hcmt.setFillMan(rs.getString(i++));
				hcmt.setFillTime(rs.getString(i++));
				hcmt.setPropertys(rs.getString(i++));
				list.add(hcmt);
			}
			System.out.println(this.getClass()+ "   list.size() = "+list.size());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	

	/**
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public List getCityTransportTable(String pid){
		CityTransportTable ctt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,pid,loginId,loginName,sdate, startPlace,endPlace,moneys,reason,remark "
				+ " from K_cityTransport where pid = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			List<CityTransportTable> list = new ArrayList<CityTransportTable>();
			
			while(rs.next()){
				ctt = new CityTransportTable();
				
				ctt.setId(rs.getString("id"));
				ctt.setPid(rs.getString("pid"));
				ctt.setLoginId(rs.getString("loginId"));
				ctt.setLoginName(rs.getString("loginName"));
				ctt.setSdate(rs.getString("sdate"));
				ctt.setStartPlace(rs.getString("startPlace"));
				ctt.setEndPlace(rs.getString("endPlace"));
				ctt.setMoneys(rs.getString("moneys"));
				ctt.setReason(rs.getString("reason"));
				ctt.setRemark(rs.getString("remark"));
				
				list.add(ctt);
			}
			
			return list;
			
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
	public boolean addHourCostManageTable(HourCostManageTable hcmt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_hourCostManage (id,mid,checkManID,startTime,endTime,countDays,foodPay,checkPay,"
				+ " businessTrips,countMoney,checkOffice,checkProject,fillMan,fillTime,propertys) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, hcmt.getMid());
			ps.setString(i++, hcmt.getCheckManID());
			ps.setString(i++, hcmt.getStartTime());
			ps.setString(i++, hcmt.getEndTime());
			ps.setString(i++, hcmt.getCountDays());
			ps.setString(i++, hcmt.getFoodPay());
			ps.setString(i++, hcmt.getCheckPay());
			ps.setString(i++, hcmt.getBusinessTrips());
			ps.setString(i++, hcmt.getCountMoney());
			ps.setString(i++, hcmt.getCheckOffice());
			ps.setString(i++, hcmt.getCheckProject());
			ps.setString(i++, hcmt.getFillMan());
			ps.setString(i++, hcmt.getFillTime());
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
	public boolean updateHourCostManageTable(HourCostManageTable hcmt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_hourCostManage set mid=?,checkManID=?,startTime=?,endTime=?,countDays=?,foodPay=?,checkPay=?,"
				+ " businessTrips=?,countMoney=?,checkOffice=?,checkProject=?,fillMan=?,fillTime=?,propertys=?"  
				+ " where id = ?";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, hcmt.getMid());
			ps.setString(i++, hcmt.getCheckManID());
			ps.setString(i++, hcmt.getStartTime());
			ps.setString(i++, hcmt.getEndTime());
			ps.setString(i++, hcmt.getCountDays());
			ps.setString(i++, hcmt.getFoodPay());
			ps.setString(i++, hcmt.getCheckPay());
			ps.setString(i++, hcmt.getBusinessTrips());
			ps.setString(i++, hcmt.getCountMoney());
			ps.setString(i++, hcmt.getCheckOffice());
			ps.setString(i++, hcmt.getCheckProject());
			ps.setString(i++, hcmt.getFillMan());
			ps.setString(i++, hcmt.getFillTime());
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
	public boolean deleteHourCostManageTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_hourCostManage where id = ?" ;
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
	
	/**
	 * 删除
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean delHourCostManageTable(String mid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_hourCostManage where mid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,mid);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	
	/**
	 * 添加对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean addCityTransportTable(CityTransportTable ctt){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into K_cityTransport (id,pid,loginId,loginName,sdate, startPlace,endPlace,moneys,reason,remark) "
				+ " values(?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, ctt.getPid());
			ps.setString(i++, ctt.getLoginId());
			ps.setString(i++, ctt.getLoginName());
			ps.setString(i++, ctt.getSdate());
			
			ps.setString(i++, ctt.getStartPlace());
			ps.setString(i++, ctt.getEndPlace());
			ps.setString(i++, ctt.getMoneys());
			ps.setString(i++, ctt.getReason());
			ps.setString(i++, ctt.getRemark());
			
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
	public boolean delCityTransportTable(String pid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from K_cityTransport where pid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,pid);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	

	/**
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public Map getPayParametterTable(){
		Map map = new HashMap();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,pid,checkpay,mealmoneypay,transportpay," 
				+ " other,checkpayex,mealmoneypayex,transportpayex,otherex,"
				+ " companypay,companypayex "
			    + " from k_payParametter ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				map.put("id", rs.getString("id"));
				map.put("pid", rs.getString("pid"));
				map.put("checkpay", rs.getString("checkpay"));
				map.put("mealmoneypay", rs.getString("mealmoneypay"));
				map.put("transportpay", rs.getString("transportpay"));
				
				map.put("other", rs.getString("other"));
				map.put("checkpayex", rs.getString("checkpayex"));
				map.put("mealmoneypayex", rs.getString("mealmoneypayex"));
				map.put("transportpayex", rs.getString("transportpayex"));
				map.put("otherex", rs.getString("otherex"));
				
				map.put("companypay", rs.getString("companypay"));
				map.put("companypayex", rs.getString("companypayex"));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
}
