package com.whfp.oa.manager.app.action.model;

public class QiuzhuOutputModel {

	private String id;
	
	//求助人id
	private String uid;
	
	//分类
	private String category;
	
	//内容
	private String content;

	//创建时间
	private String createDate;
	
	//回复内容
	private String resp;
	
	//回复用户id
	private String respUid;
	
	//回复用户姓名
	private String respUserName;

	//回复时间
	private String respDate;
	
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public String getRespUid() {
		return respUid;
	}

	public void setRespUid(String respUid) {
		this.respUid = respUid;
	}

	public String getRespUserName() {
		return respUserName;
	}

	public void setRespUserName(String respUserName) {
		this.respUserName = respUserName;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
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
	
	
}
