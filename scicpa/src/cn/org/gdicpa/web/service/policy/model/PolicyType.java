package cn.org.gdicpa.web.service.policy.model;

public class PolicyType {
	//id,typeName,parentId,isLeaf,fullPath
	private String id = "" ;
	private String typeName = "" ;
	private String parentId = "" ;
	private String isLeaf = "" ;
	private String fullPath = "" ;
	public String getId() {
		return id;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getParentId() {
		return parentId;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}


}
