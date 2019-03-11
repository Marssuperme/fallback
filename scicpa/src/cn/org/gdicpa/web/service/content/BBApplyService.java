package cn.org.gdicpa.web.service.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.content.model.BBApplyTable;

public class BBApplyService {
	private Connection conn = null ;
	
	public BBApplyService(Connection conn){
		this.conn = conn;
	}
	
	
	public BBApplyTable getApply(String guid) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		BBApplyTable at = new BBApplyTable();
		try {
			String sql = " select guid,applyDate,isAuditPropery,standard,auditPropery, " 
					   + " checkAdvice,standerPrice,auditBy,auditTime,cityAdvice," 
					   + " autoAudit,isnext,discountBySeven,iszxw,isyqyyw," 
					   + " property " 
					   + " from bb_apply where guid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, guid) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				
				at.setGuid(rs.getString("guid"));
				at.setApplyDate(rs.getString("applyDate"));
				at.setIsauditPropery(rs.getString("isAuditPropery"));
				at.setStandard(rs.getString("standard")) ;
				at.setAuditPropery(rs.getString("auditPropery"));
				
				at.setCheckAdvice(rs.getString("checkAdvice"));
				at.setStanderPrice(rs.getString("standerPrice"));
				at.setAuditBy(rs.getString("auditBy"));
				at.setAuditTime(rs.getString("auditTime"));
				at.setCityAdvice(rs.getString("cityAdvice"));
				
				at.setAutoAudit(rs.getString("autoAudit"));
				at.setIsnext(rs.getString("isnext"));
				at.setDiscountBySeven(rs.getString("discountBySeven"));
				at.setIszxw(rs.getString("iszxw"));
				at.setIsyqyyw(rs.getString("isyqyyw"));
				
				at.setPropertys(rs.getString("property"));
			}
			return at ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return at;
	}
	
	public synchronized void addApply(BBApplyTable at) {
		
		System.out.println("追加申请审核：addApply()方法被调用...");
		
		PreparedStatement ps = null ;
		try {
			String sql = " insert into bb_apply(guid,applyDate,isAuditPropery,standard,auditPropery," 
					   + " standerPrice,autoAudit,isnext,discountBySeven,iszxw, " 
					   + " property) " 
					   + " values(?,?,?,?,?, ?,?,?,?,?, ?)";
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			ps.setString(i++,at.getGuid());
			ps.setString(i++,at.getApplyDate());
			ps.setString(i++,at.getIsauditPropery());
			ps.setString(i++,at.getStandard());
			ps.setString(i++,at.getAuditPropery());
			
			ps.setString(i++,at.getStanderPrice());
			ps.setString(i++,at.getAutoAudit());
			ps.setString(i++,at.getIsnext());
			ps.setString(i++,at.getDiscountBySeven());
			ps.setString(i++,at.getIszxw());
			
			ps.setString(i++,at.getPropertys());
			
			ps.execute();
			
		}catch(Exception e) {
			String sql = " insert into l_log (logindate,logintime,operation,memo,ctype,initFlag) values(?,?,?,?,?,?) ";
			ASFuntion af = new ASFuntion();
			try {
				new DbUtil(conn).executeUpdate(sql, new Object[]{af.getCurrentDate(),af.getCurrentTime(),"报备申请","情况说明主键："+at.getGuid()+"||情况说明："+at.getStandard()+"||e.getMessage："+e.getMessage(),"K_Company","3"});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally{
				DbUtil.close(ps) ;
			}
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	
	
	public void updateApply(BBApplyTable at) {
		PreparedStatement ps = null ;
		try {
			String sql = " update bb_apply set isAuditPropery=?,applydate=?,standard=?,auditPropery=?,property=?,standerPrice=?," 
					   + " autoAudit=?,isnext=?,discountBySeven=?,iszxw=? " 
					   + " where guid = ? ";
			
			if("审核通过".equals(at.getAuditPropery()) || "报备完成".equals(at.getAuditPropery())){
				sql = " update bb_apply set standard=?,auditPropery=?,property=?,standerPrice=?," 
				    + " autoAudit=?,isnext=?,discountBySeven=?,iszxw=? " 
				    + " where guid = ? ";
			}
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			if(!"审核通过".equals(at.getAuditPropery()) && !"报备完成".equals(at.getAuditPropery())){
				ps.setString(i++,at.getIsauditPropery());
				ps.setString(i++,at.getApplyDate());
			}
			ps.setString(i++,at.getStandard());
			ps.setString(i++,at.getAuditPropery());
			ps.setString(i++,at.getPropertys());
			ps.setString(i++,at.getStanderPrice());
			
			ps.setString(i++,at.getAutoAudit());
			ps.setString(i++,at.getIsnext());
			ps.setString(i++,at.getDiscountBySeven());
			ps.setString(i++,at.getIszxw());
			
			ps.setString(i++,at.getGuid());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public void delApply(String guid) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from bb_apply where guid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,guid) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public void updateAuditProperty(String guid,String auditProperty) {
		PreparedStatement ps = null ;
		try {
			String sql = " update bb_apply set auditPropery=? where guid=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,auditProperty);
			ps.setString(2,guid);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}

}
