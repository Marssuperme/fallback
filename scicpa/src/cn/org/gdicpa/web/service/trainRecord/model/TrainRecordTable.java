package cn.org.gdicpa.web.service.trainRecord.model;

public class TrainRecordTable {
	private String id; // 编号
	private String loginid; // loginid
	private String startTime; // 培训开始时间
	private String endTime; // 结束时间
	private String trainPlace; // 培训地点
	private String trainContent; // 培训内容
	private String trainTeacher; // 培训师
	private String remark; // 备注
	private String classHour; // 学时
	private String trainWay; // 培训方式

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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTrainPlace() {
		return trainPlace;
	}

	public void setTrainPlace(String trainPlace) {
		this.trainPlace = trainPlace;
	}

	public String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public String getTrainTeacher() {
		return trainTeacher;
	}

	public void setTrainTeacher(String trainTeacher) {
		this.trainTeacher = trainTeacher;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClassHour() {
		return classHour;
	}

	public void setClassHour(String classHour) {
		this.classHour = classHour;
	}

	public String getTrainWay() {
		return trainWay;
	}

	public void setTrainWay(String trainWay) {
		this.trainWay = trainWay;
	}
}
