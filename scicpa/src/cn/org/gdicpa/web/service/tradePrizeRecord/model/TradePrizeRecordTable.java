package cn.org.gdicpa.web.service.tradePrizeRecord.model;

public class TradePrizeRecordTable {
	private String id;// id
	private String loginid;// loginid
	private String person;// 奖罚人
	private String officeName;// 事务所名称
	private String noteMasterName;// 注师名称
	private String department;// 处理部门
	private String fieldNumber;// 文号
	private String recordDate;// 日期
	private String reason;// 事由
	private String prizeContent;// 奖励内容
	private String punishContent;// 惩罚内容
	private String publishZone;// 发布范围

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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getNoteMasterName() {
		return noteMasterName;
	}

	public void setNoteMasterName(String noteMasterName) {
		this.noteMasterName = noteMasterName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(String fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPrizeContent() {
		return prizeContent;
	}

	public void setPrizeContent(String prizeContent) {
		this.prizeContent = prizeContent;
	}

	public String getPunishContent() {
		return punishContent;
	}

	public void setPunishContent(String punishContent) {
		this.punishContent = punishContent;
	}

	public String getPublishZone() {
		return publishZone;
	}

	public void setPublishZone(String publishZone) {
		this.publishZone = publishZone;
	}
}
