package cn.org.gdicpa.web.service.position.model;
import cn.org.gdicpa.web.service.Staff.model.StaffTable;
import cn.org.gdicpa.web.service.department.model.departmentTable;
/**
 * 岗位实体类
 * @author kq
 *
 */
public class positionTable {
	private String id;
	private String departmentId;
	private String positionName;
	private String remarks;
	private departmentTable department;
	private StaffTable staff;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public departmentTable getDepartment() {
		return department;
	}
	public void setDepartment(departmentTable department) {
		this.department = department;
	}
	public StaffTable getStaff() {
		return staff;
	}
	public void setStaff(StaffTable staff) {
		this.staff = staff;
	}
	
}
