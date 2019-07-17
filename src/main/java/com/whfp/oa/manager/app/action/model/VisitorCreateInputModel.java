package com.whfp.oa.manager.app.action.model;

public class VisitorCreateInputModel {

	/**
	 * 戒毒人员uid
	 */
	private String toUid;
	
	//戒毒人员名字
	private String toUserName;
	
	//走访原因
	private String reasonType;
	
	//走访对象姓名
	private String toVisitor;
	
	//走访对象于戒毒人员关系
	private String toVisitorRelationship;
	
	//走访对象联系方式
	private String toVisitorPhone;
	
	/**
	 * 问题一答案
	 */
	private String key1;
	
	private String key2;
	
	private String key3;
	
	private String key4;
	
	private String key5;
	
	private String remarks;

	/**
	 * 上传的附件（多张，逗号分隔）
	 */
	private String fileIds;
	
	public String getToUid() {
		return toUid;
	}

	public void setToUid(String toUid) {
		this.toUid = toUid;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getToVisitor() {
		return toVisitor;
	}

	public void setToVisitor(String toVisitor) {
		this.toVisitor = toVisitor;
	}

	public String getToVisitorRelationship() {
		return toVisitorRelationship;
	}

	public void setToVisitorRelationship(String toVisitorRelationship) {
		this.toVisitorRelationship = toVisitorRelationship;
	}

	public String getToVisitorPhone() {
		return toVisitorPhone;
	}

	public void setToVisitorPhone(String toVisitorPhone) {
		this.toVisitorPhone = toVisitorPhone;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getKey4() {
		return key4;
	}

	public void setKey4(String key4) {
		this.key4 = key4;
	}

	public String getKey5() {
		return key5;
	}

	public void setKey5(String key5) {
		this.key5 = key5;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}
	
	
}
