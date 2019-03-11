package cn.org.gdicpa.web.service.pay;

public class Pay {
	private String order;
	private double amount;
	private String productName;
	private String productType;
	private String productDesc;
	private String productReMark;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductReMark() {
		return productReMark;
	}

	public void setProductReMark(String productReMark) {
		this.productReMark = productReMark;
	}
}
