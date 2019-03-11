package cn.org.gdicpa.web.service.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.policy.model.Policy;
import cn.org.gdicpa.web.service.policy.model.PolicyCheck;
import cn.org.gdicpa.web.service.policy.model.PolicyTree;
import cn.org.gdicpa.web.service.policy.model.PolicyType;

public class PolicyService {
	
	private Connection conn = null ;
	
	public PolicyService(Connection conn) {
		this.conn = conn ;
	}
	
	public List getTypeTree(String id) {
		  
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List treeList = new ArrayList();
		String sql="";
		try {
			//String sql = "select id,typeName,parentId,isLeaf,fullPath from p_policyType where parentId=?" ;
			if ("00".equals(id)||"0".equals(id)){
				id="0";
				sql="select t1.id,t1.typeName,parentId,isLeaf,fullPath ,t2.mycount \n"
					+" from p_policyType t1 , \n"
					+" ( \n"
					+" 	select a.id ,count(distinct c.policyid) as mycount \n"
					+" 	from p_policyType a ,p_policyType b,p_policyandtype c \n"
					+" 	where a.parentid=? \n"
					+" 	and b.fullpath like a.fullpath +'%' \n"
					+" 	and b.id=c.typeid \n"
					+" 	group by a.id \n"
					+" )t2 \n"
					+" where t1.parentid=? \n"
					+" and t1.id=t2.id";
				
			}else{
				sql="select t1.id,t1.typeName,parentId,isLeaf,fullPath ,t2.mycount \n"
					+" from p_policyType t1 , \n"
					+" ( \n"
					+" 	select a.id ,count(distinct c.policyid) as mycount \n"
					+" 	from p_policyType a ,p_policyType b,p_policyandtype c \n"
					+" 	where a.parentid=? \n"
					+" 	and b.fullpath like a.fullpath +'%' \n"
					+" 	and b.id=c.typeid \n"
					+" 	group by a.id \n"
					+" )t2 \n"
					+" where t1.parentid=? \n"
					+" and t1.id=t2.id";
			}
			
			ps = conn.prepareStatement(sql) ;
			
			ps.setString(1,id) ;
			ps.setString(2,id) ;
			
			System.out.println("qwh:sql="+sql);
			System.out.println("qwh:id="+id);
			
			rs = ps.executeQuery() ;
			
			while(rs.next()) {
				PolicyTree pt = new PolicyTree() ;
				
				pt.setId(rs.getString(1)) ;
				pt.setText(rs.getString(2)+"("+rs.getInt("mycount")+")") ;
				pt.setParentId(rs.getString(3)) ;
				pt.setShowcheck(false) ;
				String isLeaf = rs.getString(4) ;
				pt.setFullPath(rs.getString(5)) ;
				if("0".equals(isLeaf)) {
					pt.setHasChildren(true) ;
				//	pt.setChildNodes(getTypeTree(rs.getString(1))) ;
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
	
	public Policy getPolicy(String id) {		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,wordNum,sendDate,sendDepartment,title,content,viewCount,fileName,fullPath,validityStatus,area from p_policy where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			Policy policy = new Policy() ;
			if(rs.next()) {				
				policy.setId(rs.getString(1)) ;
				policy.setWordNum(rs.getString(2)) ;
				policy.setSendDate(rs.getString(3)) ;
				policy.setSendDepartment(rs.getString(4)) ;
				policy.setTitle(rs.getString(5)) ;
				policy.setContent(rs.getString(6)) ;
				policy.setViewCount(rs.getString(7)) ;
				policy.setFileName(rs.getString(8)) ;
				policy.setFullPath(rs.getString(9)) ;
			}
			return policy ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	
	public void addCheck(PolicyCheck pc) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into p_policy_check(id,policyId,updateContent,updateUserId,state,checkUserId,updateDate,wordNum,sendDate,sendDepartment,title,typeId) values(?,?,?,?,?, ?,?,?,?, ?,?,?)" ;
			ps = conn.prepareStatement(sql) ;
			int i = 1;
			ps.setString(i++,UUID.randomUUID().toString()) ;
			ps.setString(i++,pc.getPolicyId()) ;
			ps.setString(i++,pc.getUpdateConent()) ;
			ps.setString(i++,pc.getUpdateUserId()) ;
			ps.setString(i++,pc.getState()) ;
			ps.setString(i++,pc.getCheckUserId()) ;
			ps.setString(i++, pc.getUpdateDate()) ;
			ps.setString(i++,pc.getWordNum()) ;
			ps.setString(i++,pc.getSendDate()) ;
			ps.setString(i++,pc.getSendDepartment()) ;
			ps.setString(i++,pc.getTitle()) ;
			ps.setString(i++,pc.getTypeId()) ;
			ps.execute() ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	//获得所有子结点的id
	public String getPolicyTypeIds(String fullPath) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select distinct a.id from p_policyType a where a.fullPath like '"+fullPath+"%'" ;
			// 88888 按照地域性分类
			if(fullPath.indexOf("88888|")>=0){
				sql = "select distinct a.id from p_policyType a where a.fullPath = '"+fullPath+"'" ;	
			}
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
	
	public void addPolicy(Policy policy) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into p_policy(id,typeId,wordNum,sendDate,sendDepartment,title,content,fullPath) values(?,?,?,?, ?,?,?,?)" ;
			ps = conn.prepareStatement(sql) ;
			int i = 1;
			ps.setString(i++,UUID.randomUUID().toString()) ;
			ps.setString(i++,policy.getTypeId()) ;
			ps.setString(i++,policy.getWordNum()) ;
			ps.setString(i++,policy.getSendDate()) ;
			ps.setString(i++,policy.getSendDepartment()) ;
			ps.setString(i++,policy.getTitle()) ;
			ps.setString(i++,policy.getContent()) ;
			ps.setString(i++,policy.getFullPath()) ;
			ps.execute() ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	
	public PolicyCheck getCheck(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,policyId,updateContent,updateUserId,state,checkUserId,updateDate,wordNum,sendDate,sendDepartment,title,typeId from p_policy_check where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			PolicyCheck pc = new PolicyCheck() ;
			if(rs.next()) {
				pc.setId(rs.getString(1)) ;
				pc.setPolicyId(rs.getString(2)) ;
				pc.setUpdateConent(rs.getString(3)) ;
				pc.setUpdateUserId(rs.getString(4)) ;
				pc.setState(rs.getString(5)) ;
				pc.setCheckUserId(rs.getString(6)) ;
				pc.setUpdateDate(rs.getString(7)) ;
				pc.setWordNum(rs.getString(8)) ;
				pc.setSendDate(rs.getString(9)) ;
				pc.setSendDepartment(rs.getString(10)) ;
				pc.setTitle(rs.getString(11)) ;
				pc.setTypeId(rs.getString(12)) ;
			}
			return pc ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
		
	public PolicyType getPolicyType(String id) {
			
			PreparedStatement ps = null ;
			ResultSet rs = null ;
			try {
				String sql = "select id,typeName,parentId,isLeaf,fullPath from p_policyType where id=?" ;
				ps = conn.prepareStatement(sql) ;
				ps.setString(1,id) ;
				rs = ps.executeQuery() ;
				PolicyType pt = new PolicyType() ;
				if(rs.next()) {
					pt.setId(rs.getString(1)) ;
					pt.setTypeName(rs.getString(2)) ;
					pt.setParentId(rs.getString(3)) ;
					pt.setIsLeaf(rs.getString(4)) ;
					pt.setFullPath(rs.getString(5));
				}
				return pt ;
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
			String sql = "update p_policy_check set state=?,checkUserId=? where id=?" ;
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
	
	public void updatePolicy(String id,String content) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "update p_policy set content=? where id=?" ;
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
	
	public void updatePolicyFullPath(String id,String fullpath) {
			
			PreparedStatement ps = null ;
			ResultSet rs = null ;
			try {
				String sql = "update p_policy set fullpath=? where id=?" ;
				ps = conn.prepareStatement(sql) ;
				ps.setString(1,fullpath) ;
				ps.setString(2,id) ;
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace() ;
			}finally{
				DbUtil.close(rs) ;
				DbUtil.close(ps) ;
			}
		}
	
	public void updatePolicyCheckId(String id,String policyId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "update p_policy_check set policyId=? where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,policyId) ;
			ps.setString(2,id) ;
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
		}
	}
		
	public String addOrUpdatePolicy(PolicyCheck pc) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		String pId = "";
		try {
			String policyId = StringUtil.showNull(pc.getPolicyId());
			if(!"".equals(policyId)) {
				updatePolicy(policyId,pc.getUpdateConent()) ;
				pId = policyId ;
			}else {
				//新增
				String uuid = UUID.randomUUID().toString() ;
				String sql = "insert into p_policy(id,typeId,wordNum,sendDate,sendDepartment,title,content)  "
						   + " select '"+uuid+"',typeId,wordNum,sendDate,sendDepartment,title,updateContent from p_policy_check where id=? " ;
				ps = conn.prepareStatement(sql) ;
				ps.setString(1,pc.getId()) ;
				ps.execute();
				
				pId = uuid ;
				updatePolicyCheckId(pc.getId(),uuid);
			}
		
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
		}
		return pId ;
	}
	
	/**
	 * 得到法律法规的附件
	 * @param policyId
	 * @return
	 */
	public List getPolicyAttachFileList(String policyId){
		PreparedStatement ps = null;
		ResultSet rs = null;		
		List list = new ArrayList();
		try {
			String sql = " select * from p_policyAttachmentTable where legislationid = ? order by cast(attachmentId as int)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, policyId);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();	
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if("filename".equalsIgnoreCase(RSMD.getColumnLabel(i))){
						map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getString(RSMD.getColumnLabel(i)).replace("Download_File", ""));
					}else{
						map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getString(RSMD.getColumnLabel(i)));
					}
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return list;
	}
	
	/**
	 * 得到法律法规的附件
	 * @param policyId
	 * @return
	 */
	public Map getPolicyAttachFile(String attachmentId){
		PreparedStatement ps = null;
		ResultSet rs = null;		
		Map map = new HashMap();
		try {
			String sql = " select * from p_policyAttachmentTable where attachmentId = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, attachmentId);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if("filename".equalsIgnoreCase(RSMD.getColumnLabel(i))){
						map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getString(RSMD.getColumnLabel(i)).replace("Download_File", ""));
					}else{
						map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getString(RSMD.getColumnLabel(i)));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return map;
	}
}
