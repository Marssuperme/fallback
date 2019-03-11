package cn.org.gdicpa.web.service.cases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.cases.model.Case;
import cn.org.gdicpa.web.service.cases.model.CaseCheck;
import cn.org.gdicpa.web.service.policy.model.PolicyTree;

public class CaseService {
	
	private Connection conn = null ;
	
	public CaseService(Connection conn) {
		this.conn = conn ;
	}
	
	public List getTypeTree(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List treeList = new ArrayList();
		try {
			String sql = "select id,typeName,parentId,isLeaf,fullPath from p_casesType where parentId=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			
			while(rs.next()) {
				PolicyTree pt = new PolicyTree() ;
				
				pt.setId(rs.getString(1)) ;
				pt.setText(rs.getString(2)) ;
				pt.setParentId(rs.getString(3)) ;
				pt.setShowcheck(false) ;
				String isLeaf = rs.getString(4).trim();
				pt.setFullPath(rs.getString(5)) ;
				if("0".equals(isLeaf)) {
					pt.setHasChildren(true) ;
				}else {
					pt.setHasChildren(false) ;
				}
				treeList.add(pt) ;
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return treeList ;
	}
	
	//获得所有子结点的id
	public String getCaseTypeIds(String fullPath) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select distinct a.id from p_casestype a where a.fullPath like '"+fullPath+"%'" ;
			ps = conn.prepareStatement(sql) ;
			rs = ps.executeQuery() ;
			String typeIds = "" ;
			while(rs.next()) {
				typeIds += rs.getString(1) +"," ;
			}
			if(typeIds.length() >1) {
				typeIds = typeIds.substring(0,typeIds.length()-1);
			}
			return typeIds ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return "" ;
	}
	
	public Case getCase(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,typeId,title,content,author,viewcount from p_cases where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			Case cases = new Case();
			if(rs.next()) {
				cases.setId(rs.getString(1)) ;
				cases.setTypeId(rs.getString(2)) ;
				cases.setTitle(rs.getString(3)) ;
				cases.setContent(rs.getString(4)) ;
				cases.setAuthor(rs.getString(5)) ;
				cases.setViewcount(rs.getString(6));
				return cases ;
			}
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	
	public void addCheck(CaseCheck cc) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into p_cases_check(id,caseId,content,title,typeId,author,createtime,updateDate,updateUserId,state) " 
					   +" values(?,?,?,?,?,?,?,?,?,?)" ;
			ps = conn.prepareStatement(sql) ;
			int i = 1;
			ps.setString(i++,UUID.randomUUID().toString()) ;
			ps.setString(i++,cc.getCaseId()) ;
			ps.setString(i++,cc.getContent()) ;
			ps.setString(i++,cc.getTitle()) ;
			ps.setString(i++,cc.getTypeId()) ;
			ps.setString(i++,cc.getAuthor()) ;
			ps.setString(i++,cc.getCreatetime()) ;
			ps.setString(i++,cc.getUpdateDate()) ;
			ps.setString(i++,cc.getUpdateUserId()) ;
			ps.setString(i++,cc.getState()) ;
			ps.execute() ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	
	public CaseCheck getCheck(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,caseId,content,title,typeId,author,createtime,updateDate,updateUserId,state from p_cases_check where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			CaseCheck cc = new CaseCheck();
			if(rs.next()) {
				cc.setId(rs.getString(1)) ;
				cc.setCaseId(rs.getString(2)) ;
				cc.setContent(rs.getString(3)) ;
				cc.setTitle(rs.getString(4)) ;
				cc.setTypeId(rs.getString(5)) ;
				cc.setAuthor(rs.getString(6)) ;
				cc.setCreatetime(rs.getString(7));
				cc.setUpdateDate(rs.getString(8));
				cc.setUpdateUserId(rs.getString(9)) ;
				cc.setState(rs.getString(10)) ;
				return cc ;
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	public void updateCheck(String id,String state,String checkUserId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "update p_cases_check set state=?,checkUserId=? where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,state) ;
			ps.setString(2,checkUserId) ;
			ps.setString(3,id) ;
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
		}
	}
	
	public void updateCase(String id,String content) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "update p_cases set content=? where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,content) ;
			ps.setString(2,id) ;
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
		}
	}
	
	
	public void updateCheckCaseId(String id,String caseId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "update p_cases_check set caseId=? where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,caseId) ;
			ps.setString(2,id) ;
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
		}
	}
	
	
	public String addOrUpdatePolicy(CaseCheck cc) {
			
			PreparedStatement ps = null ;
			ResultSet rs = null ;
			String pId = "";
			try {
				String caseId = StringUtil.showNull(cc.getCaseId());
				if(!"".equals(caseId)) {
					updateCase(caseId,cc.getContent()) ;
					pId = caseId ;
				}else {
					//新增
					String uuid = UUID.randomUUID().toString() ;
					String sql = "insert into p_cases(id,typeId,title,content,author,createtime)  "
							   + " select '"+uuid+"',typeId,title,content,author,createtime from p_cases_check where id=? " ;
					ps = conn.prepareStatement(sql) ;
					ps.setString(1,cc.getId()) ;
					ps.execute();
					
					pId = uuid ;
					updateCheckCaseId(cc.getId(),uuid) ;
				}
			
			}catch(Exception e) {
				e.printStackTrace() ;
			}finally{
				DbUtil.close(rs) ;
				DbUtil.close(ps) ;
			}
			return pId ;
		}

}
