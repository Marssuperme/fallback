package cn.org.gdicpa.web.service.conferenceRecord.model;

public class ConferenceRecordTable {
	private String id; // 编号
	private String loginid; // loginid;
	private String outTime; // 之前会的离会时间
	private String beforeName; // 之前会名称
	private String beforeType; // 之前会会员类型
	private String inTime;// 当前会的加入时间
	private String nowName; // 现在会名称
	private String nowType; // 会员类型
	private String reason; // 原因
	private String register; // 登记人
	private String registDate; // 登记日期

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getBeforeName() {
		return beforeName;
	}

	public void setBeforeName(String beforeName) {
		this.beforeName = beforeName;
	}

	public String getBeforeType() {
		return beforeType;
	}

	public void setBeforeType(String beforeType) {
		this.beforeType = beforeType;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getNowName() {
		return nowName;
	}

	public void setNowName(String nowName) {
		this.nowName = nowName;
	}

	public String getNowType() {
		return nowType;
	}

	public void setNowType(String nowType) {
		this.nowType = nowType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
