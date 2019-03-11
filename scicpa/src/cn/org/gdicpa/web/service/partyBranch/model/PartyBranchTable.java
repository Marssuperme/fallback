package cn.org.gdicpa.web.service.partyBranch.model;

/**
 * 党组织
 * @author yuanbo
 *
 */
public class PartyBranchTable {
	//id,branchname,builddate,branchtype,branchtype2,affiliation,pid,pname,email,mobile,phone
	//address,fax,web,area,lastby,lastmodify,officecode,state,ctype,fzqk,mzsh,dnbz
	private String id;
	private String branchname;// 党组织名称
	private String builddate;//  党建立日期
	private String branchtype; // 机构类型
	private String branchtype2;// 党组织类型
	private String affiliation;// 隶属关系
	private String pid;	// 父id
	private String pname; // 父name
	private String email;
	private String mobile;
	private String phone;
	private String address;
	private String fax;
	private String web;// 网址
	private String area;// 地址
	private String lastby; // 最后修改人
	private String lastmodify;// 最后修改日期
	private String officecode; // 事务所编号
	private String state;// 状态 [待定值]
	private String ctype;// 类型
	private String fzqk;// 党员发展情况
	private String mzsh;// 民主生活
	private String dnbz;// 党类表彰
	private String partyNum;//成员数
	private String cpaNum;//CPA数
	private String aPartyName;//书记姓名
	private String aPhone;//书记电话
	
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
	public String getFzqk() {
		return fzqk;
	}
	public void setFzqk(String fzqk) {
		this.fzqk = fzqk;
	}
	public String getMzsh() {
		return mzsh;
	}
	public void setMzsh(String mzsh) {
		this.mzsh = mzsh;
	}
	public String getDnbz() {
		return dnbz;
	}
	public void setDnbz(String dnbz) {
		this.dnbz = dnbz;
	}
	public String getPartyNum() {
		return partyNum;
	}
	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}
	public String getCpaNum() {
		return cpaNum;
	}
	public void setCpaNum(String cpaNum) {
		this.cpaNum = cpaNum;
	}
	public String getaPartyName() {
		return aPartyName;
	}
	public void setaPartyName(String aPartyName) {
		this.aPartyName = aPartyName;
	}
	public String getaPhone() {
		return aPhone;
	}
	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}
	
}
