package cn.org.gdicpa.web.service.checkGroupResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.checkGroupResult.model.CheckGroupResultTable;
import cn.org.gdicpa.web.service.hourCostManage.model.HourCostManageTable;

public class CheckGroupResultService {
	private Connection conn = null;
	public CheckGroupResultService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象
	 * @param id
	 * @return
	 */
	public CheckGroupResultTable getCheckGroupResultTable(String checkid){
		CheckGroupResultTable cgrt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select checkid,checkofficeid,checkoffice,years,evaluation,prize,punish,result from" 
				+ " b_checkGroupResult where checkid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, checkid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				cgrt = new CheckGroupResultTable();
				cgrt.setCheckid(rs.getString(i++));
				cgrt.setCheckofficeid(rs.getString(i++));
				cgrt.setCheckoffice(rs.getString(i++));
				cgrt.setYears(rs.getString(i++));
				cgrt.setEvaluation(rs.getString(i++));
				cgrt.setPrize(rs.getString(i++));
				cgrt.setPunish(rs.getString(i++));
				cgrt.setResult(rs.getString(i++));
			}
			return cgrt;
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
	public boolean addCheckGroupResultTable(CheckGroupResultTable cgrt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into b_checkGroupResult (checkofficeid,checkoffice,years,evaluation,prize,punish,result,checkid) "
				+ " values(?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++,cgrt.getCheckofficeid());
			ps.setString(i++,cgrt.getCheckoffice());
			ps.setString(i++,cgrt.getYears());
			ps.setString(i++,cgrt.getEvaluation());
			ps.setString(i++,cgrt.getPrize());
			ps.setString(i++,cgrt.getPunish());
			ps.setString(i++,cgrt.getResult()); 
			ps.setString(i++,UUID.randomUUID().toString()); 
			
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
	public boolean updateCheckGroupResultTable(CheckGroupResultTable cgrt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update b_checkGroupResult set checkofficeid=?,checkoffice=?,years=?,evaluation=?,prize=?,punish=?,result=?"  
				+ " where checkid = ?";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++,cgrt.getCheckofficeid());
			ps.setString(i++,cgrt.getCheckoffice() );
			ps.setString(i++,cgrt.getYears());
			ps.setString(i++,cgrt.getEvaluation());
			ps.setString(i++,cgrt.getPrize());
			ps.setString(i++,cgrt.getPunish());
			ps.setString(i++,cgrt.getResult()); 
			ps.setString(i++,cgrt.getCheckid()); 
			
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
	public boolean deleteCheckGroupResultTable(String checkid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from b_checkGroupResult where checkid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,checkid);
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
