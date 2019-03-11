package cn.org.gdicpa.web.service.member.model;

public class MemberTable {
	private String id; 
	private String memberName;//姓名-------------------
	private String sex;//性别------------------
	private String post;//行政职务-------------团内职务;
	private String department;//作单位
	private String idnumber;//身份证号
	private String general;//证书编号
	private String partystate;//党籍状态
	private String joindate;//入党时间
	private String relationparty;//正式组织关系所在党组织
	private String borndate;//出生日期------------------------------
	private String marital;//婚姻状态
	private String rank;//职位--------------------------------------
	private String relationdepart;//人事关系所在单位名称
	private String email;
	private String mobile;//-------------------------------------------
	private String phone;
	private String address;
	private String fax;
	private String partytype;//类型 0: 注协党员  1: 事务所党员
	private String lastby;
	private String lastmodify;
	private String state;
	private String ctype;
	private String nation;//民族----------------------------------
	private String isCicpa;//是否注师-----------------------------
	private String isMemberCadre;//是否团干部--------------------------
	private String officeCode;//事务所编号
	
	private String partyNameEx;
	private String birthPlace;
	private String nonLand;
	private String graduateSchool;
	private String specialty;
	private String goodAt;
	private String education;//学历--------------------------------
	private String degree;
	private String workDate;
	private String title;
	private String titleName;
	private int industry1;
	private int industry2;
	private int industry3;
	private int industry4;
	private int politics1;
	private int politics2;
	private int politics3;
	private int politics4;
	private int politics5;
	private int politics6;
	private int politics7;
	private int politics8;
	private String introduce1;
	private String introduce2;
	private String base;
	private String amount;
	private String returnDate;
	private String delayReurn;
	private String inParty;
	private String isWorker;
	private String postContent;
	private String postTime;
	private String lastPost;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public String getPartystate() {
		return partystate;
	}
	public void setPartystate(String partystate) {
		this.partystate = partystate;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getRelationparty() {
		return relationparty;
	}
	public void setRelationparty(String relationparty) {
		this.relationparty = relationparty;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getRelationdepart() {
		return relationdepart;
	}
	public void setRelationdepart(String relationdepart) {
		this.relationdepart = relationdepart;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPartytype() {
		return partytype;
	}
	public void setPartytype(String partytype) {
		this.partytype = partytype;
	}
	public String getLastby() {
		return lastby;
	}
	public void setLastby(String lastby) {
		this.lastby = lastby;
	}
	public String getLastmodify() {
		return lastmodify;
	}
	public void setLastmodify(String lastmodify) {
		this.lastmodify = lastmodify;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPartyNameEx() {
		return partyNameEx;
	}
	public void setPartyNameEx(String partyNameEx) {
		this.partyNameEx = partyNameEx;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getNonLand() {
		return nonLand;
	}
	public void setNonLand(String nonLand) {
		this.nonLand = nonLand;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getGoodAt() {
		return goodAt;
	}
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public int getIndustry1() {
		return industry1;
	}
	public void setIndustry1(int industry1) {
		this.industry1 = industry1;
	}
	public int getIndustry2() {
		return industry2;
	}
	public void setIndustry2(int industry2) {
		this.industry2 = industry2;
	}
	public int getIndustry3() {
		return industry3;
	}
	public void setIndustry3(int industry3) {
		this.industry3 = industry3;
	}
	public int getIndustry4() {
		return industry4;
	}
	public void setIndustry4(int industry4) {
		this.industry4 = industry4;
	}
	public int getPolitics1() {
		return politics1;
	}
	public void setPolitics1(int politics1) {
		this.politics1 = politics1;
	}
	public int getPolitics2() {
		return politics2;
	}
	public void setPolitics2(int politics2) {
		this.politics2 = politics2;
	}
	public int getPolitics3() {
		return politics3;
	}
	public void setPolitics3(int politics3) {
		this.politics3 = politics3;
	}
	public int getPolitics4() {
		return politics4;
	}
	public void setPolitics4(int politics4) {
		this.politics4 = politics4;
	}
	public int getPolitics5() {
		return politics5;
	}
	public void setPolitics5(int politics5) {
		this.politics5 = politics5;
	}
	public int getPolitics6() {
		return politics6;
	}
	public void setPolitics6(int politics6) {
		this.politics6 = politics6;
	}
	public int getPolitics7() {
		return politics7;
	}
	public void setPolitics7(int politics7) {
		this.politics7 = politics7;
	}
	public int getPolitics8() {
		return politics8;
	}
	public void setPolitics8(int politics8) {
		this.politics8 = politics8;
	}
	public String getIntroduce1() {
		return introduce1;
	}
	public void setIntroduce1(String introduce1) {
		this.introduce1 = introduce1;
	}
	public String getIntroduce2() {
		return introduce2;
	}
	public void setIntroduce2(String introduce2) {
		this.introduce2 = introduce2;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getDelayReurn() {
		return delayReurn;
	}
	public void setDelayReurn(String delayReurn) {
		this.delayReurn = delayReurn;
	}
	public String getInParty() {
		return inParty;
	}
	public void setInParty(String inParty) {
		this.inParty = inParty;
	}
	public String getIsWorker() {
		return isWorker;
	}
	public void setIsWorker(String isWorker) {
		this.isWorker = isWorker;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getLastPost() {
		return lastPost;
	}
	public void setLastPost(String lastPost) {
		this.lastPost = lastPost;
	}
	public String getIsCicpa() {
		return isCicpa;
	}
	public void setIsCicpa(String isCicpa) {
		this.isCicpa = isCicpa;
	}
	public String getIsMemberCadre() {
		return isMemberCadre;
	}
	public void setIsMemberCadre(String isMemberCadre) {
		this.isMemberCadre = isMemberCadre;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
