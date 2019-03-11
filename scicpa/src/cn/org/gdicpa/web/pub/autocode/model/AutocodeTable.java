package cn.org.gdicpa.web.pub.autocode.model;

public class AutocodeTable {
	public AutocodeTable() {
	}

	private int id;
	private String atype;
	private String aowner;
	private int curnum1;
	private int curnum2;
	private int curnum3;
	private int showlen1;
	private int showlen2;
	private int showlen3;
	private String format;
	private String businesssum;
	private String isonly;
	private String atime;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setAtype(String Atype) {
		this.atype = Atype;
	}

	public String getAtype() {
		return atype;
	}

	public void setAowner(String aowner) {
		this.aowner = aowner;
	}

	public String getAowner() {
		return aowner;
	}

	public void setCurnum1(int curnum1) {
		this.curnum1 = curnum1;
	}

	public int getCurnum1() {
		return curnum1;
	}

	public void setCurnum2(int curnum2) {
		this.curnum2 = curnum2;
	}

	public int getCurnum2() {
		return curnum2;
	}

	public void setCurnum3(int curnum3) {
		this.curnum3 = curnum3;
	}

	public int getCurnum3() {
		return curnum3;
	}

	public void setShowlen1(int showlen1) {
		this.showlen1 = showlen1;
	}

	public int getShowlen1() {
		return showlen1;
	}

	public void setShowlen2(int showlen2) {
		this.showlen2 = showlen2;
	}

	public int getShowlen2() {
		return showlen2;
	}

	public void setShowlen3(int showlen3) {
		this.showlen3 = showlen3;
	}

	public int getShowlen3() {
		return showlen3;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public String getBusinesssum() {
		return businesssum;
	}

	public void setBusinesssum(String businesssum) {
		this.businesssum = businesssum;
	}

	public String getIsonly() {
		return isonly;
	}

	public void setIsonly(String isonly) {
		this.isonly = isonly;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

}
