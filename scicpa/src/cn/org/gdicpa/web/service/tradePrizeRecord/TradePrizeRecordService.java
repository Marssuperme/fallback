package cn.org.gdicpa.web.service.tradePrizeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.tradePrizeRecord.model.TradePrizeRecordTable;

public class TradePrizeRecordService {
	private Connection conn = null;
	public TradePrizeRecordService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TradePrizeRecordTable getTradePrizeRecordTableById(String id) throws Exception{
		TradePrizeRecordTable tprt = new TradePrizeRecordTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,person,officeName,noteMasterName,department,fieldNumber,recordDate,"
				+ " reason,prizeContent,punishContent,publishZone from k_tradePrizeRecord where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				tprt.setId((rs.getString(i++)));
				tprt.setLoginid(rs.getString(i++));
				tprt.setPerson(rs.getString(i++));
				tprt.setOfficeName(rs.getString(i++));
				tprt.setNoteMasterName(rs.getString(i++));
				tprt.setDepartment(rs.getString(i++));
				tprt.setFieldNumber(rs.getString(i++));
				tprt.setRecordDate(rs.getString(i++));
				tprt.setReason(rs.getString(i++));
				tprt.setPrizeContent(rs.getString(i++));
				tprt.setPunishContent(rs.getString(i++));
				tprt.setPublishZone(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return tprt;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addTradePrizeRecordTable(TradePrizeRecordTable tprt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into k_tradePrizeRecord "
				+ "(id,loginid,person,officeName,noteMasterName,department,fieldNumber,"
				+ " recordDate,reason,prizeContent,punishContent,publishZone) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, tprt.getLoginid());
			ps.setString(i++, tprt.getPerson());
			ps.setString(i++, tprt.getOfficeName());
			ps.setString(i++, tprt.getNoteMasterName());
			ps.setString(i++, tprt.getDepartment());
			ps.setString(i++, tprt.getFieldNumber());
			ps.setString(i++, tprt.getRecordDate());
			ps.setString(i++, tprt.getReason());
			ps.setString(i++, tprt.getPrizeContent());
			ps.setString(i++, tprt.getPunishContent());
			ps.setString(i++, tprt.getPublishZone());
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
	 * 修改
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean updateTradePrizeRecordTable(TradePrizeRecordTable tprt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_tradePrizeRecord set person=?,officeName=?,noteMasterName=?,"
				+ " department=?,fieldNumber=?,recordDate=?,reason=?,prizeContent=?,"
				+ " punishContent=?,publishZone=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, tprt.getPerson());
			ps.setString(i++, tprt.getOfficeName());
			ps.setString(i++, tprt.getNoteMasterName());
			ps.setString(i++, tprt.getDepartment());
			ps.setString(i++, tprt.getFieldNumber());
			ps.setString(i++, tprt.getRecordDate());
			ps.setString(i++, tprt.getReason());
			ps.setString(i++, tprt.getPrizeContent());
			ps.setString(i++, tprt.getPunishContent());
			ps.setString(i++, tprt.getPublishZone());
			ps.setString(i++, tprt.getId());
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
	public boolean deleteTradePrizeRecordTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_tradePrizeRecord where id = ?" ;
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
