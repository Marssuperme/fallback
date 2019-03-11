package cn.org.gdicpa.web.service.ticket.model;

public class TicketTable {
	private String id;
	private String tctitle;			// 标题
	private String tccontent;		// 内容
	private String tcchooseone;		// 选项一
	private String tcchoosetwo;		// 选项二
	private String tcchoosethree;	// 选项三
	private String tcchoosefour;	// 选项四
	private String tcenddate;		// 结束日期
	
	private String tctruename;		// 实名
	private String tcfalsename;		// 虚名
	private String tcproperty;		// 备注
	
	private String anonymous;
	private String reduplicate;
	private String fillarea;
	private String iuser;
	private String idate;
	private String fillearaName;
	private String property;

	public String getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}

	public String getReduplicate() {
		return reduplicate;
	}

	public void setReduplicate(String reduplicate) {
		this.reduplicate = reduplicate;
	}

	public String getFillarea() {
		return fillarea;
	}

	public void setFillarea(String fillarea) {
		this.fillarea = fillarea;
	}

	public String getIuser() {
		return iuser;
	}

	public void setIuser(String iuser) {
		this.iuser = iuser;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getFillearaName() {
		return fillearaName;
	}

	public void setFillearaName(String fillearaName) {
		this.fillearaName = fillearaName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTctitle() {
		return tctitle;
	}

	public void setTctitle(String tctitle) {
		this.tctitle = tctitle;
	}

	public String getTccontent() {
		return tccontent;
	}

	public void setTccontent(String tccontent) {
		this.tccontent = tccontent;
	}

	public String getTcchooseone() {
		return tcchooseone;
	}

	public void setTcchooseone(String tcchooseone) {
		this.tcchooseone = tcchooseone;
	}

	public String getTcchoosetwo() {
		return tcchoosetwo;
	}

	public void setTcchoosetwo(String tcchoosetwo) {
		this.tcchoosetwo = tcchoosetwo;
	}

	public String getTcchoosethree() {
		return tcchoosethree;
	}

	public void setTcchoosethree(String tcchoosethree) {
		this.tcchoosethree = tcchoosethree;
	}

	public String getTcchoosefour() {
		return tcchoosefour;
	}

	public void setTcchoosefour(String tcchoosefour) {
		this.tcchoosefour = tcchoosefour;
	}

	public String getTcenddate() {
		return tcenddate;
	}

	public void setTcenddate(String tcenddate) {
		this.tcenddate = tcenddate;
	}

	public String getTctruename() {
		return tctruename;
	}

	public void setTctruename(String tctruename) {
		this.tctruename = tctruename;
	}

	public String getTcfalsename() {
		return tcfalsename;
	}

	public void setTcfalsename(String tcfalsename) {
		this.tcfalsename = tcfalsename;
	}

	public String getTcproperty() {
		return tcproperty;
	}

	public void setTcproperty(String tcproperty) {
		this.tcproperty = tcproperty;
	}

}
