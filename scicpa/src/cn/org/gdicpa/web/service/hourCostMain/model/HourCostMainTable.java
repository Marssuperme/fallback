package cn.org.gdicpa.web.service.hourCostMain.model;

public class HourCostMainTable {
	private String id;
	private String fillMan;// 填报人
	private String checkProjet; // 填报项目
	private String checkoffice; // 被检查事务所
	private String fillTime;// 填报时间
	private String totalDays; // 总天数
	private String totalCheckPay; // 检查津贴总额
	private String totalfoodPay; // 食宿费总额
	private String totalbusinessTrips; // 差旅费总额
	private String totalCountMoney; // 小计总额
	private String propertys; // 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFillMan() {
		return fillMan;
	}

	public void setFillMan(String fillMan) {
		this.fillMan = fillMan;
	}

	public String getCheckProject() {
		return checkProjet;
	}

	public void setCheckProject(String checkProjet) {
		this.checkProjet = checkProjet;
	}

	public String getCheckoffice() {
		return checkoffice;
	}

	public void setCheckoffice(String checkoffice) {
		this.checkoffice = checkoffice;
	}

	public String getFillTime() {
		return fillTime;
	}

	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public String getTotalCheckPay() {
		return totalCheckPay;
	}

	public void setTotalCheckPay(String totalCheckPay) {
		this.totalCheckPay = totalCheckPay;
	}

	public String getTotalfoodPay() {
		return totalfoodPay;
	}

	public void setTotalfoodPay(String totalfoodPay) {
		this.totalfoodPay = totalfoodPay;
	}

	public String getTotalbusinessTrips() {
		return totalbusinessTrips;
	}

	public void setTotalbusinessTrips(String totalbusinessTrips) {
		this.totalbusinessTrips = totalbusinessTrips;
	}

	public String getTotalCountMoney() {
		return totalCountMoney;
	}

	public void setTotalCountMoney(String totalCountMoney) {
		this.totalCountMoney = totalCountMoney;
	}

	public String getPropertys() {
		return propertys;
	}

	public void setPropertys(String propertys) {
		this.propertys = propertys;
	}
}
