package com.whfp.oa.manager.app.action.model;

public class QingjiaOutputModel {

	private String id;
	
	private String beginDate;//开始时间
	
	private String endDate;//结束时间
	
	private String mType;  //请假类别
	
	private String uid;  //请假人员id

	private String content;   //请假内容

	private String createDate;//创建时间
	
	private String status; //审核状态,0：未审核,1：同意，2：不同意
	
	private String resp;  //审核回复
	
	private Integer isFinish; //请假是否结束
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public Integer getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	
}
