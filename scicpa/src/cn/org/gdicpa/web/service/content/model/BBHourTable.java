package cn.org.gdicpa.web.service.content.model;

public class BBHourTable {
	private String guid;
	private String bbguid;
	private String duty;//职位  
	private String countPeople;//人数 
	private String countHour;//总工时
	private String countMoney;//总金额
	private String propertys;//备注
	private String irecno;//排序字段
	public String getGuid() {
		return guid; 
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getBbguid() {
		return bbguid;
	}
	public void setBbguid(String bbguid) {
		this.bbguid = bbguid;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getCountPeople() {
		return countPeople;
	}
	public void setCountPeople(String countPeople) {
		this.countPeople = countPeople;
	}
	public String getCountHour() {
		return countHour;
	}
	public void setCountHour(String countHour) {
		this.countHour = countHour;
	}
	public String getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(String countMoney) {
		this.countMoney = countMoney;
	}
	public String getPropertys() {
		return propertys;
	}
	public void setPropertys(String propertys) {
		this.propertys = propertys;
	}
	public String getIrecno() {
		return irecno;
	}
	public void setIrecno(String irecno) {
		this.irecno = irecno;
	}
	
}
