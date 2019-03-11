package cn.org.gdicpa.web.service.testerNotice.model;

public class TesterNoticeTable {
	private String id;
	private String testyear;
	private String customerID;
	private String userId;
	private String atime;
	private String title;
	private String acontent;
	private String testerlimit;
	private String timelimit;
	private String attachment;

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestyear() {
		return testyear;
	}

	public void setTestyear(String testyear) {
		this.testyear = testyear;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public String getTesterlimit() {
		return testerlimit;
	}

	public void setTesterlimit(String testerlimit) {
		this.testerlimit = testerlimit;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

}
