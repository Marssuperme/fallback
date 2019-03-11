package cn.org.gdicpa.web.service.planManage.model;

public class PlanManage {
	private String id;
	private String supID;//检查方案ID
	private String beginDate;//开始日期
	private String endDate;//结束日期
	private String userID;//填报人
	private String companyID;//被检查事务所（下拉；根据检查方案）
	private String projectID;//被检查项目（下拉；根据被检查事务所）
	private String comEvaluation;//被检查事务所评价（下拉：好、中、差）
	private String proEvaluation;//被检查项目评价（下拉：好、中、差）
	private String progressCnt;//评价意见
	private String changeDate;//意见交换日期 
	private String initFlag; 
	private String timeFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSupID() {
		return supID;
	}
	public void setSupID(String supID) {
		this.supID = supID;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getComEvaluation() {
		return comEvaluation;
	}
	public void setComEvaluation(String comEvaluation) {
		this.comEvaluation = comEvaluation;
	}
	public String getProEvaluation() {
		return proEvaluation;
	}
	public void setProEvaluation(String proEvaluation) {
		this.proEvaluation = proEvaluation;
	}
	public String getProgressCnt() {
		return progressCnt;
	}
	public void setProgressCnt(String progressCnt) {
		this.progressCnt = progressCnt;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getInitFlag() {
		return initFlag;
	}
	public void setInitFlag(String initFlag) {
		this.initFlag = initFlag;
	}
	public String getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}
	
}
