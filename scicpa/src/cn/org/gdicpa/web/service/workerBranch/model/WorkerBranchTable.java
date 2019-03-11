package cn.org.gdicpa.web.service.workerBranch.model;

public class WorkerBranchTable {
	private String id;
	private String branchname;// 团组织名称-------------------
	private String builddate;//  团建立日期----------------------
	private String branchtype; // 机构类型----------------------事务所团组织
	private String branchtype2;// 团组织类型
	private String affiliation;// 隶属关系
	private String pid;	// 父id
	private String pname; // 父name
	private String email;
	private String chairMan;//主席--------------
	private String mobile;//团书记手机-------------------------
	private String phone;//联系人电话--------------------------
	private String address;
	private String fax;
	private String web;// 网址
	private String area;// 地址
	private String lastby; // 最后修改人--------------------------
	private String lastmodify;// 最后修改日期----------------------
	private String officecode; // 事务所编号----------------------
	private String state;// 状态 [待定值]
	private String ctype;// 类型
	private String isCreate;//-------------------------是否成立团组织	
	private String linkMan;//联系人--------------
	private String actRoom;
	private String partyBranchID;
	private String partyBranchName;//
	private String costOrigin;
	private int workerNum;
	private String regeditValue;
	private String flowValue;
	private String hasWomen;
	private int membernum;
	private int cpanum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getBuilddate() {
		return builddate;
	}
	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}
	public String getBranchtype() {
		return branchtype;
	}
	public void setBranchtype(String branchtype) {
		this.branchtype = branchtype;
	}
	public String getBranchtype2() {
		return branchtype2;
	}
	public void setBranchtype2(String branchtype2) {
		this.branchtype2 = branchtype2;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChairMan() {
		return chairMan;
	}
	public void setChairMan(String chairMan) {
		this.chairMan = chairMan;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLastby() {
		return lastby;
	}
	public void setLastby(String lastby) {
		this.lastby = lastby;
	}
	public String getLastmodify() {
		return lastmodify;
	}
	public void setLastmodify(String lastmodify) {
		this.lastmodify = lastmodify;
	}
	public String getOfficecode() {
		return officecode;
	}
	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getIsCreate() {
		return isCreate;
	}
	public void setIsCreate(String isCreate) {
		this.isCreate = isCreate;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getActRoom() {
		return actRoom;
	}
	public void setActRoom(String actRoom) {
		this.actRoom = actRoom;
	}
	public String getPartyBranchID() {
		return partyBranchID;
	}
	public void setPartyBranchID(String partyBranchID) {
		this.partyBranchID = partyBranchID;
	}
	public String getPartyBranchName() {
		return partyBranchName;
	}
	public void setPartyBranchName(String partyBranchName) {
		this.partyBranchName = partyBranchName;
	}
	public String getCostOrigin() {
		return costOrigin;
	}
	public void setCostOrigin(String costOrigin) {
		this.costOrigin = costOrigin;
	}
	public int getWorkerNum() {
		return workerNum;
	}
	public void setWorkerNum(int workerNum) {
		this.workerNum = workerNum;
	}
	public String getRegeditValue() {
		return regeditValue;
	}
	public void setRegeditValue(String regeditValue) {
		this.regeditValue = regeditValue;
	}
	public String getFlowValue() {
		return flowValue;
	}
	public void setFlowValue(String flowValue) {
		this.flowValue = flowValue;
	}
	public String getHasWomen() {
		return hasWomen;
	}
	public void setHasWomen(String hasWomen) {
		this.hasWomen = hasWomen;
	}
	public int getMembernum() {
		return membernum;
	}
	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}
	public int getCpanum() {
		return cpanum;
	}
	public void setCpanum(int cpanum) {
		this.cpanum = cpanum;
	}
}
