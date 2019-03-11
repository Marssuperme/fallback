package cn.org.gdicpa.web.service.bbbbqtb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbbbqtb.model.BbPrint;
import cn.org.gdicpa.web.service.bbbbqtb.model.BbqtbTable;

public class BbqtbService {
	private Connection conn;
	public BbqtbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public BbqtbTable getBbqtbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		BbqtbTable bt = new BbqtbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,qtcbdxm,bustype,zcze,xssr "
				+ " from bb_bbqtb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				bt.setGuid(rs.getString(i++));
				bt.setQtcbdxm(rs.getString(i++));
				bt.setBustype(rs.getString(i++));
				bt.setZcze(rs.getString(i++));
				bt.setXssr(rs.getString(i++));
			}
			return bt;
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
	public boolean addBbqtbTable(BbqtbTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_bbqtb (guid,qtcbdxm,bustype,zcze,xssr) "
				+ " values(?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, bt.getGuid());
			ps.setString(i++, bt.getQtcbdxm());
			ps.setString(i++, bt.getBustype());
			ps.setString(i++, bt.getZcze());
			ps.setString(i++, bt.getXssr());
			
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
	public boolean updateBbqtbTable(BbqtbTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_bbqtb set qtcbdxm=?,bustype=?,zcze=?,xssr=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, bt.getQtcbdxm());
			ps.setString(i++, bt.getBustype());
			ps.setString(i++, bt.getZcze());
			ps.setString(i++, bt.getXssr());
			
			ps.setString(i++, bt.getGuid());
			
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
	public boolean deleteBbqtbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_bbqtb where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	public BbPrint getPrintInfo(String guid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select bbbh,bgwh,wtdwmc,a.companyName,bgrq,bbtime,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,bgnd,bgnd2,"
				+ " b.phone,b.faxes,b.address,b.email,b.url,a.typeid,bsdwmc,bbperson,wtxmlx,ywyds,bbstate,ywarea from bb_view a left join "
				+ " BB_CompanyList b on a.companyid = b.guid where replace(REPLACE(a.guid,'{',''),'}','')=?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			BbPrint bbPrint = new BbPrint();
			bbPrint.setGuid(guid);
			int i = 1;
			if(rs.next()){
				bbPrint.setBbbh(rs.getString(i++));
				bbPrint.setBgwh(rs.getString(i++));
				bbPrint.setWtdwmc(rs.getString(i++)) ;
				bbPrint.setCompanyName(rs.getString(i++)) ;
				bbPrint.setBgrq(rs.getString(i++)) ;
				bbPrint.setBbtime(rs.getString(i++)) ;
				bbPrint.setCpa1(rs.getString(i++)) ;
				bbPrint.setCpa2(rs.getString(i++)) ;
				bbPrint.setCpa3(rs.getString(i++)) ;
				bbPrint.setCpa4(rs.getString(i++)) ;
				bbPrint.setCpa5(rs.getString(i++)) ;
				bbPrint.setCpa6(rs.getString(i++)) ;
				bbPrint.setQmzs1(rs.getString(i++)) ;
				bbPrint.setQmzs2(rs.getString(i++)) ;
				bbPrint.setQmzs3(rs.getString(i++)) ;
				bbPrint.setQmzs4(rs.getString(i++)) ;
				bbPrint.setQmzs5(rs.getString(i++)) ;
				bbPrint.setQmzs6(rs.getString(i++)) ;
				bbPrint.setBgnd(rs.getString(i++)) ;
				bbPrint.setBgnd2(rs.getString(i++)) ;
				bbPrint.setPhone(rs.getString(i++)) ;
				bbPrint.setFaxes(rs.getString(i++)) ;
				bbPrint.setAddress(rs.getString(i++)) ;
				bbPrint.setEmail(rs.getString(i++)) ;
				bbPrint.setUrl(rs.getString(i++)) ;
				bbPrint.setTypeid(rs.getString(i++)) ;
				bbPrint.setBsdwmc(rs.getString(i++)) ;
				bbPrint.setBbperson(rs.getString(i++)) ;
				bbPrint.setWtxmlx(rs.getString(i++)) ;
				bbPrint.setYwyds(rs.getString(i++)) ;
				bbPrint.setBbstate(rs.getString(i++)) ;
				bbPrint.setYwarea(rs.getString(i++)) ;
			}
			return bbPrint;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	
	
}
