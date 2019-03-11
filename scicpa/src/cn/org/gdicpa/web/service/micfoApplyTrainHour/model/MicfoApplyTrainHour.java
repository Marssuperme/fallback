package cn.org.gdicpa.web.service.micfoApplyTrainHour.model;
/**
 *MicfoApplyTrainHour 职业会员的 其它学时申报 实体类
 * @author YDZ
 */
public class MicfoApplyTrainHour {
	private String id;              // 内部编码GUID
	private String loginid;         // 申报人登录号
	private String loginName;       // 申报人姓名
	private String applyHours;      // 申请确认的学时数
	private String educationType;   // 参加继续教育的形式
	private String educationNote;   // 参加继续教育情况说明
	private String applyDate;        // 申请日期
	private String companyOpinion;   // 事务所意见
	private String societyOpinion;   // 省注协意见
	private String attachmentid;     // 附件索引号
	private String companyChecked;   // 事务所审核
	private String provinceChecked;  // 省注协审核
	private String Ctype;            // 职业会员还是非职业会员
	private String property1;            // 备用1
	private String property2;            // 备用2
	
	
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getApplyHours() {
		return applyHours;
	}
	public void setApplyHours(String applyHours) {
		this.applyHours = applyHours;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public String getEducationNote() {
		return educationNote;
	}
	public void setEducationNote(String educationNote) {
		this.educationNote = educationNote;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getCompanyOpinion() {
		return companyOpinion;
	}
	public void setCompanyOpinion(String companyOpinion) {
		this.companyOpinion = companyOpinion;
	}
	public String getSocietyOpinion() {
		return societyOpinion;
	}
	public void setSocietyOpinion(String societyOpinion) {
		this.societyOpinion = societyOpinion;
	}
	public String getAttachmentid() {
		return attachmentid;
	}
	public void setAttachmentid(String attachmentid) {
		this.attachmentid = attachmentid;
	}
	public String getCompanyChecked() {
		return companyChecked;
	}
	public void setCompanyChecked(String companyChecked) {
		this.companyChecked = companyChecked;
	}
	public String getProvinceChecked() {
		return provinceChecked;
	}
	public void setProvinceChecked(String provinceChecked) {
		this.provinceChecked = provinceChecked;
	}
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public String getProperty1() {
		return property1;
	}
	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	public String getProperty2() {
		return property2;
	}
	public void setProperty2(String property2) {
		this.property2 = property2;
	}
}
