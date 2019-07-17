package com.whfp.oa.manager.app.action.model;

public class MessageOutputModel {

	private Long id;
	
	//消息类型
	private String msgType;
	
	//消息类型名称
	private String msgTypeName;
	
	//内容
	private String content;
	
	//创建时间
	private String createDate;
	
	//消息状态0:未读，1:已读，
	private Integer status;
	
	//关联记录id
	private String refId;
	
	//关联业务类型
	private String refType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgTypeName() {
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	
}
