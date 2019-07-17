package com.whfp.oa.manager.app.action.model;

public class NiaojianCheckInputModel {

	private String id;
	
	//检查标记，0：未检查，1：正常，-1：不正常
	private Integer flag;
	
	private String remarks;

	private String uid;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
