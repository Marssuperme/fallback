package cn.org.gdicpa.web.service.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.content.model.BBHourTable;

public class BBHourService {
	private Connection conn = null ;
	
	public BBHourService(Connection conn){
		this.conn = conn;
	}
	
	
	public BBHourTable getHour(String guid) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		BBHourTable bt = new BBHourTable();
		try {
			String sql = " select guid,bbguid,duty,countPeople,countHour, " 
					   + " countMoney,property,irecno " 
					   + " from bb_hour where guid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, guid) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				bt.setGuid(rs.getString(1));
				bt.setBbguid(rs.getString(2));
				bt.setDuty(rs.getString(3));
				bt.setCountPeople(rs.getString(4)) ;
				bt.setCountHour(rs.getString(5));
				
				bt.setCountMoney(rs.getString(6));
				bt.setPropertys(rs.getString(7));
				bt.setIrecno(rs.getString(8));
			}
			return bt ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return bt;
	}
	
	public List<BBHourTable> getHourList(String bbguid) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<BBHourTable> list = new ArrayList<BBHourTable>();
		try {
			String sql = " select guid,bbguid,duty,countPeople,countHour, " 
					   + " countMoney,property,irecno " 
					   + " from bb_hour where bbguid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, bbguid) ;
			rs = ps.executeQuery() ;
			while(rs.next()) {
				
				BBHourTable bt = new BBHourTable();
				
				bt.setGuid(rs.getString(1));
				bt.setBbguid(rs.getString(2));
				bt.setDuty(rs.getString(3));
				bt.setCountPeople(rs.getString(4)) ;
				bt.setCountHour(rs.getString(5));
				
				bt.setCountMoney(rs.getString(6));
				bt.setPropertys(rs.getString(7));
				bt.setIrecno(rs.getString(8));
				
				list.add(bt);
			}
			return list ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return list;
	}
	
	
	public synchronized void addBBHour(BBHourTable bt) {
		PreparedStatement ps = null ;
		try {
			String sql = " insert into bb_hour(guid,bbguid,duty,countPeople,countHour, " 
					   + " countMoney,property,irecno) " 
					   + " values(?,?,?,?,?, ?,?,?)";
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			 
			ps.setString(i++,bt.getGuid());
			ps.setString(i++,bt.getBbguid());
			ps.setString(i++,bt.getDuty());
			ps.setString(i++,bt.getCountPeople());
			ps.setString(i++,bt.getCountHour());
			
			ps.setString(i++,bt.getCountMoney());
			ps.setString(i++,bt.getPropertys());
			ps.setString(i++,bt.getIrecno());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}
	
	
	
	public void updateBBHour(BBHourTable bt) {
		PreparedStatement ps = null ;
		try {
			String sql = " update bb_hour set bbguid=?,duty=?,countPeople=?,countHour=?,countMoney=?, " 
					   + " property=?,irecno=? " 
					   + " where guid = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++,bt.getBbguid());
			ps.setString(i++,bt.getDuty());
			ps.setString(i++,bt.getCountPeople());
			ps.setString(i++,bt.getCountHour());
			ps.setString(i++,bt.getCountMoney());
			
			ps.setString(i++,bt.getPropertys());
			ps.setString(i++,bt.getIrecno());
			
			ps.setString(i++,bt.getGuid());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	
	public void delBBHour(String guid) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from bb_hour where guid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,guid) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	


}
