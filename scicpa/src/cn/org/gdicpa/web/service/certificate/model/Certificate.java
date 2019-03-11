package cn.org.gdicpa.web.service.certificate.model;

public class Certificate {
	private String id;
	private String loginName;//姓名
    private String idnumber;//身份证号
	private String suear;//年份
    private String account;//会计
	private String audit;//审计
	private String financial;//财务管理
	private String economyLow;//经济法
	private String taxLow;//税法
	private String csrm;//公司战略与风险管理
	private String professional;//专业阶段合格证号
	private String general;//全科合格证号
    private String integratedTest;//综合测试
    private String state;
	private String initFlag; 
   	private String timeFlag;
   	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getSuear() {
		return suear;
	}
	public void setSuear(String suear) {
		this.suear = suear;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getFinancial() {
		return financial;
	}
	public void setFinancial(String financial) {
		this.financial = financial;
	}
	public String getEconomyLow() {
		return economyLow;
	}
	public void setEconomyLow(String economyLow) {
		this.economyLow = economyLow;
	}
	public String getTaxLow() {
		return taxLow;
	}
	public void setTaxLow(String taxLow) {
		this.taxLow = taxLow;
	}
	public String getCsrm() {
		return csrm;
	}
	public void setCsrm(String csrm) {
		this.csrm = csrm;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public String getIntegratedTest() {
		return integratedTest;
	}
	public void setIntegratedTest(String integratedTest) {
		this.integratedTest = integratedTest;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
