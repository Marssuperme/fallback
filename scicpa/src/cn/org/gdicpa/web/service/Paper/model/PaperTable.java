package cn.org.gdicpa.web.service.Paper.model;

import cn.org.gdicpa.web.service.attachFileUploadService.model.AttachFile;

/**
 * 投告实体类
 * @author kq
 *
 */
public class PaperTable {
	private String id;
	private String officeCode;
	private String officeName;
	private String attachID;
	private String remark;
	private String isUse;
	private String useRemark;
	private String initFlag;
	private String timeFlag;
	private String sDate;
	private String title;
	private String workUnit;
	private AttachFile attachFile;
	
	//上传附件的表名
	private String papers = "b_Paper";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getAttachID() {
		return attachID;
	}
	public void setAttachID(String attachID) {
		this.attachID = attachID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getUseRemark() {
		return useRemark;
	}
	public void setUseRemark(String useRemark) {
		this.useRemark = useRemark;
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
	public String getPapers() {
		return papers;
	}
	public void setPapers(String papers) {
		this.papers = papers;
	}
	public String getSDate() {
		return sDate;
	}
	public void setSDate(String date) {
		sDate = date;
	}
	public AttachFile getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(AttachFile attachFile) {
		this.attachFile = attachFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	
}
