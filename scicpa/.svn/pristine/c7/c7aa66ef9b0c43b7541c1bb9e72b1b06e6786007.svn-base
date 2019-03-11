package cn.org.gdicpa.web.service.workerBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.workerBranch.model.WorkerBranchTable;

public class WorkerBranchService {
	private Connection conn = null;
	
	public WorkerBranchService() {
	}
	public WorkerBranchService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 得到团组织
	 */
	public Map getBranch(String officeCode) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Map map = new HashMap();
			String sql = "select a.OfficeCode,a.OfficeName,a.area," +
					"b.id,b.branchname,b.builddate,b.branchtype,b.chairman,b.mobile,b.membernum,b.iscreate,b.workernum,b.cpanum,b.linkman,b.phone " +
					"from k_company a left join k_workerBranch b on a.loginid=b.officecode where a.loginid=?";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, officeCode);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = null;
			RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
				}
			}
			System.out.println("===>>>:"+map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	public void saveOrUpdate(WorkerBranchTable workerBranch) throws Exception{
		if(workerBranch.getId()==null || "".equals(workerBranch.getId())){
			// 生成 id 主键
			String guid = UUID.randomUUID().toString();
			String sql = "insert into K_WorkerBranch (id,workernum,branchtype,officecode,iscreate,membernum,builddate,branchname,chairman,mobile,lastby,lastmodify,area,linkman,phone,cpanum,pid,pname) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				int i = 1;
				pstmt.setString(i++, guid);
				pstmt.setInt(i++, workerBranch.getWorkerNum());
				pstmt.setString(i++, workerBranch.getBranchtype());
				pstmt.setString(i++, workerBranch.getOfficecode());
				pstmt.setString(i++, workerBranch.getIsCreate());
				pstmt.setInt(i++, workerBranch.getMembernum());
				pstmt.setString(i++, workerBranch.getBuilddate());
				pstmt.setString(i++, workerBranch.getBranchname());
				pstmt.setString(i++, workerBranch.getChairMan());
				pstmt.setString(i++, workerBranch.getMobile());
				pstmt.setString(i++, workerBranch.getLastby());
				pstmt.setString(i++, workerBranch.getLastmodify());
				pstmt.setString(i++, workerBranch.getArea());
				pstmt.setString(i++, workerBranch.getLinkMan());
				pstmt.setString(i++, workerBranch.getPhone());
				pstmt.setInt(i++, workerBranch.getCpanum());
				pstmt.setString(i++, workerBranch.getPid());
				pstmt.setString(i++, workerBranch.getPname());
				int count = pstmt.executeUpdate();
				
				System.out.println("-------------------------------->:"+count);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally{
				DbUtil.close(pstmt);
			}
		}else{
			String sql = "update K_WorkerBranch set workernum=?,branchtype=?,officecode=?,iscreate=?,membernum=?," +
					"builddate=?,branchname=?,chairman=?,mobile=?,lastby=?,lastmodify=?,area=?,linkman=?,phone=?,cpanum=?,pid=?,pname=? where id=?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				int i = 1;
				pstmt.setInt(i++, workerBranch.getWorkerNum());
				pstmt.setString(i++, workerBranch.getBranchtype());
				pstmt.setString(i++, workerBranch.getOfficecode());
				pstmt.setString(i++, workerBranch.getIsCreate());
				pstmt.setInt(i++, workerBranch.getMembernum());
				pstmt.setString(i++, workerBranch.getBuilddate());
				pstmt.setString(i++, workerBranch.getBranchname());
				pstmt.setString(i++, workerBranch.getChairMan());
				pstmt.setString(i++, workerBranch.getMobile());
				pstmt.setString(i++, workerBranch.getLastby());
				pstmt.setString(i++, workerBranch.getLastmodify());
				pstmt.setString(i++, workerBranch.getArea());
				pstmt.setString(i++, workerBranch.getLinkMan());
				pstmt.setString(i++, workerBranch.getPhone());
				pstmt.setInt(i++, workerBranch.getCpanum());
				pstmt.setString(i++, workerBranch.getPid());
				pstmt.setString(i++, workerBranch.getPname());
				
				pstmt.setString(i++, workerBranch.getId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally{
				DbUtil.close(pstmt);
			}
		}		
	}
}
