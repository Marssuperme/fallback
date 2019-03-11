package cn.org.gdicpa.web.service.officeRecord.model;

public class OfficeRecordTable {
	private String id;// 编号
	private String loginid;// loginid
	private String outTime;// 之前所的离所时间
	private String beforeName;// 之前所名称
	private String beforeChair;// 之前所职位
	private String inTime;// 当前所的进所时间
	private String nowName;// 现在所名称
	private String nowChair;// 在所职位
	private String reason;// 原因
	private String register;// 登记人
	private String registDate;// 登记日期

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBeforeChair() {
		return beforeChair;
	}

	public void setBeforeChair(String beforeChair) {
		this.beforeChair = beforeChair;
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

	public String getNowChair() {
		return nowChair;
	}

	public void setNowChair(String nowChair) {
		this.nowChair = nowChair;
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

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}
