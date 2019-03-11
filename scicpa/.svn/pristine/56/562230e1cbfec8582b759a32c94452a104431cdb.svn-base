package cn.org.gdicpa.web.service.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.content.model.SJMoneyTable;

public class SJMoneyService {
	private Connection conn = null ;
	
	public SJMoneyService(Connection conn){
		this.conn = conn;
	}
	
	
	public SJMoneyTable getSJMoney(String guid) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		SJMoneyTable st = new SJMoneyTable();
		try {
			String sql = " select guid,bbguid,typeid,years,zcze, " 
					   + " xssr,yysr,zxsjje,cyry,propertys " 
					   + " from bb_sjmoney where guid=? ";
			
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, guid) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				st.setGuid(rs.getString("guid"));
				st.setBbguid(rs.getString("bbguid"));
				st.setTypeid(rs.getString("typeid"));
				st.setYears(rs.getString("years"));
				st.setZcze(rs.getString("zcze")) ;
				
				st.setXssr(rs.getString("xssr"));
				st.setYysr(rs.getString("yysr"));
				st.setZxsjje(rs.getString("zxsjje"));
				st.setCyry(rs.getString("cyry"));
				st.setPropertys(rs.getString("propertys"));
			}
			return st ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return st;
	}
	
	public List<SJMoneyTable> getSJMoneyList(String bbguid) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<SJMoneyTable> list = new ArrayList<SJMoneyTable>();
		try {
			String sql = " select guid,bbguid,typeid,years,zcze,xssr, " 
				   + " yysr,zxsjje,cyry,propertys " 
				   + " from bb_sjmoney where bbguid=? ";
			
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, bbguid) ;
			rs = ps.executeQuery() ;
			while(rs.next()) {
				
				SJMoneyTable st = new SJMoneyTable();
				
				st.setGuid(rs.getString("guid"));
				st.setBbguid(rs.getString("bbguid"));
				st.setTypeid(rs.getString("typeid"));
				st.setYears(rs.getString("years"));
				st.setZcze(rs.getString("zcze")) ;
				
				st.setXssr(rs.getString("xssr"));
				st.setYysr(rs.getString("yysr"));
				st.setZxsjje(rs.getString("zxsjje"));
				st.setCyry(rs.getString("cyry"));
				st.setPropertys(rs.getString("propertys"));
				
				list.add(st);
			}
			return list ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return list;
	}
	
	
	public synchronized void addSJMoney(SJMoneyTable st) {
		PreparedStatement ps = null ;
		try {
			String sql = " insert into bb_sjmoney(guid,bbguid,typeid,years,zcze, " 
				  	   + " xssr,yysr,zxsjje,cyry,propertys) " 
					   + " values(?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			 
			ps.setString(i++,st.getGuid());
			ps.setString(i++,st.getBbguid());
			ps.setString(i++,st.getTypeid());
			ps.setString(i++,st.getYears());
			ps.setString(i++,st.getZcze());
			
			ps.setString(i++,st.getXssr());
			ps.setString(i++,st.getYysr());
			ps.setString(i++,st.getZxsjje());
			ps.setString(i++,st.getCyry());
			ps.setString(i++,st.getPropertys());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
			
		}
	}	
	
	public void updateSJMoney(SJMoneyTable st) {
		PreparedStatement ps = null ;
		try {
			String sql = " update bb_sjmoney set bbguid=?,typeid=?,years=?,zcze=?,xssr=?, " 
				  	   + " yysr=?,zxsjje=?,cyry=?,propertys=? " 
					   + " where guid=? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++,st.getBbguid());
			ps.setString(i++,st.getTypeid());
			ps.setString(i++,st.getYears());
			ps.setString(i++,st.getZcze());
			ps.setString(i++,st.getXssr());
			ps.setString(i++,st.getYysr());
			
			ps.setString(i++,st.getZxsjje());
			ps.setString(i++,st.getCyry());
			ps.setString(i++,st.getPropertys());
			
			ps.setString(i++,st.getGuid());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	
	public void delSJMoney(String guid) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from bb_sjmoney where guid=? ";
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
