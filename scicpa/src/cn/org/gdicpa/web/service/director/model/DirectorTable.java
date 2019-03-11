package cn.org.gdicpa.web.service.director.model;

public class DirectorTable {
	private String loginid; // 编号
	private String loginName; // 名称
	private String pwd; // 密码
	private String state; // 状态
	private String ctype; // 会员类型
	private String ctypetabName; // 会员类型对应的表名

	private String email; // E-Mail、
	private String mobile; // 手机、
	private String phone; // 电话、
	private String workunits; // 所属单位、

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getCtypetabName() {
		return ctypetabName;
	}

	public void setCtypetabName(String ctypetabName) {
		this.ctypetabName = ctypetabName;
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

	public String getWorkunits() {
		return workunits;
	}

	public void setWorkunits(String workunits) {
		this.workunits = workunits;
	}

}
