package cn.org.gdicpa.web.service.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.Staff.model.StaffTable;
import cn.org.gdicpa.web.service.department.model.departmentTable;
import cn.org.gdicpa.web.service.position.model.positionTable;
/**
 * 数据处理类
 * @author kq
 *
 */
public class StaffService {
	private Connection conn = null ;
	private final static int PAGE_SIZE = 5;
	public StaffService(Connection conn){
		this.conn = conn;
	}
	/**
	 * 查询某个部门下的所有员工的详细信息
	 * @param pageNumber
	 * @param departmentId
	 * @return
	 */
	public List<StaffTable> getAll(int pageNumber,String departmentId){
		List<StaffTable> list = new ArrayList<StaffTable>();
		StaffTable staff = null;
		positionTable position = null;
		ResultSet rs = null;
		PreparedStatement pt = null;
		try {
			String sql = " select top " + PAGE_SIZE + " s.id,max(pt.departmentId) as departmentId,max(s.loginName) as loginName,max(photoPath)as photoPath,max(s.orderNo)as orderNo from K_Staff s "
				+ " left join k_StaffPosition sp on sp.staffid = s.id " 
				+ " left join k_position pt on pt.id = sp.positionid "
				+ " where pt.departmentid = ? " 
				+ " and s.id not in(select top  " + PAGE_SIZE*(pageNumber-1) + " s.id from K_Staff s  left join k_StaffPosition sp on sp.staffid = s.id  left join " 
				+ " k_position pt on pt.id = sp.positionid  where pt.departmentid = ? group by s.id  order by s.id) "
				+ " group by s.id order by orderNo ";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, departmentId);
			pt.setString(2, departmentId);
			rs = pt.executeQuery();
			while (rs.next()) {
				staff = new StaffTable();
				position = new positionTable();
				staff.setId(rs.getString("id"));
				position.setDepartmentId(departmentId);
				staff.setLoginName(rs.getString("loginName"));
				staff.setPhotoPath(rs.getString("photoPath"));
				staff.setNation(rs.getString("orderNo"));
				staff.setPosition(position);
				staff.setPositionNames(getPositionNameAll(departmentId,rs.getString("id")));
				staff.setPositionRemarks(getRemarksAll(departmentId,rs.getString("id")));
				list.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pt);
		}
		return list;
	}
	/**
	 * 显示个人的详细资料
	 * @param departmentId
	 * @param staffId
	 * @return
	 */
	public StaffTable getStaffTableOdd(String departmentId,String staffId){
		StaffTable staff = new StaffTable();
		ResultSet rs = null;
		PreparedStatement pt = null;
		try {
			String sql = "select sf.id,max(pt.departmentId) as departmentId,max(sf.loginName) as loginName,max(sf.Sex)as Sex, " 
						+ "	max(sf.Nation)as Nation,max(sf.BornDate)as BornDate,max(sf.Origin)as Origin,max(sf.Politics)as Politics," 
						+ " max(sf.Education)as Education,max(sf.Resume)as Resume,max(photoPath)as photoPath " 
						+ " from K_Staff sf  left join k_StaffPosition sp on sp.staffid = sf.id  left join" 
						+ " k_position pt on pt.id = sp.positionid  where pt.departmentid = ?" 
						+ " and sf.id = ?" 
						+ " group by sf.id  order by id";
			pt = conn.prepareStatement(sql);
			pt.setString(1, departmentId);
			pt.setString(2, staffId);
			rs = pt.executeQuery();
			if(rs.next()) {
				staff.setId(rs.getString("id"));
				staff.setLoginName(rs.getString("loginName"));
				staff.setSex(rs.getString("Sex"));
				staff.setNation(rs.getString("Nation"));
				staff.setBornDate(rs.getString("BornDate"));
				staff.setOrigin(rs.getString("Origin"));
				staff.setPolitics(rs.getString("Politics"));
				staff.setEducation(rs.getString("Education"));
				staff.setResume(rs.getString("Resume"));
				staff.setPhotoPath(rs.getString("photoPath"));
				staff.setPositionNames(getPositionNameAll(departmentId,rs.getString("id")));
				staff.setPositionRemarks(getRemarksAll(departmentId,rs.getString("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pt);
		}
		return staff;
	}
	/**
	 * 根据岗位去找人
	 * @param departmentId
	 * @return
	 */
	public String getPositionNameAll(String departmentId,String staffid){
		String positionName = "";
		ResultSet rs = null;
		PreparedStatement pt = null;
		try {
			String sql = "select ps.id,ps.departmentId,sf.LoginName,ps.positionName,ps.Remarks" 
					+ " from k_department dt,k_position ps,k_StaffPosition sp,K_Staff sf" 
					+ " where dt.id = ps.departmentId and ps.id = sp.positionId and sp.staffid = sf.id" 
					+ " and ps.departmentId=? and sf.id = ?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, departmentId);
			pt.setString(2, staffid);
			rs = pt.executeQuery();
			while (rs.next()) {
				positionName = positionName + rs.getString("positionName") + "、";
			}
			positionName = positionName.substring(0,positionName.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pt);
		}
		return positionName;
	}
	/**
	 * 岗位描述
	 * @param departmentId
	 * @param staffid
	 * @return
	 */
	public String getRemarksAll(String departmentId,String staffid){
		String positionName = "";
		ResultSet rs = null;
		PreparedStatement pt = null;
		try {
			String sql = "select ps.id,ps.departmentId,sf.LoginName,ps.positionName,ps.Remarks" 
					+ " from k_department dt,k_position ps,k_StaffPosition sp,K_Staff sf" 
					+ " where dt.id = ps.departmentId and ps.id = sp.positionId and sp.staffid = sf.id" 
					+ " and ps.departmentId=? and sf.id = ?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, departmentId);
			pt.setString(2, staffid);
			rs = pt.executeQuery();
			while (rs.next()) {
				positionName = positionName + rs.getString("Remarks") + "、";
			}
			positionName = positionName.substring(0,positionName.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pt);
		}
		return positionName;
	}
	/**
	 * 计算当前员工表有多少员工
	 * @return
	 */
	public int getCount(String departmentId){
		int result = 0;
		ResultSet rs = null;
		PreparedStatement pt = null;
		try {
			String sql = "select count(*)from k_department dt,k_position ps,k_StaffPosition sp,K_Staff sf " 
					+ " where dt.id = ps.departmentId and ps.id = sp.positionId and sp.staffid = sf.id " 
					+ " and ps.departmentId= ? ";
			pt = conn.prepareStatement(sql);
			pt.setString(1, departmentId);
			rs = pt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			result = (result+PAGE_SIZE-1)/PAGE_SIZE;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pt);
		}
		return result;
	}
	/**
	 * 找出部门的ID
	 * @param departmentId
	 * @return
	 */
	public departmentTable getdepartmentNo(String departmentId){
		departmentTable depa = new departmentTable();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql ="select * from dbo.k_department where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, departmentId);
			rs = ps.executeQuery();
			if (rs.next()) {
				depa.setId(rs.getString("id"));
				depa.setName(rs.getString("name"));
				depa.setPid(rs.getString("pid"));
				depa.setSort(rs.getString("sort"));
				depa.setInitFlag(rs.getString("initFlag"));
				depa.setTimeFlag(rs.getString("timeFlag"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return depa;
	}
}
