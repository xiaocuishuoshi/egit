package com.whfp.oa.manager.app.action.model;

public class ManInfoOutputModel {

	//戒毒人员id
	private String manId;
	
	private String avatar;
	
	//姓名
	private String name;
	
	//性别
	private String sex;
	
	//等级
	private String level;
	
	//状态，0：正常,-1：异常
	private Integer status;
	
	//接收时间
	private String joinDate;
	
	//剩余天数
	private Integer leftDay;
	
	//请假次数
	private Integer qingjiaTimes;
	
	//上报次数
	private Integer updateTimes;
	
	//尿检次数(阴性)
	private Integer niaojianOkTimes;
	
	//尿检次数(阳性)
	private Integer niaojianFailTimes;
	
	//失联次数
	private Integer lostConnectTimes;
	
	//最后一次上报位置
	private String lastGpsAddress;
	
	//最后一次上报时间
	private String lastUpdateDate;

	//是否已经完成戒毒
	private Integer isFinish=0;
	
	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getLeftDay() {
		return leftDay;
	}

	public void setLeftDay(Integer leftDay) {
		this.leftDay = leftDay;
	}

	public Integer getQingjiaTimes() {
		return qingjiaTimes;
	}

	public void setQingjiaTimes(Integer qingjiaTimes) {
		this.qingjiaTimes = qingjiaTimes;
	}

	public Integer getUpdateTimes() {
		return updateTimes;
	}

	public void setUpdateTimes(Integer updateTimes) {
		this.updateTimes = updateTimes;
	}

	
	public String getLastGpsAddress() {
		return lastGpsAddress;
	}

	public void setLastGpsAddress(String lastGpsAddress) {
		this.lastGpsAddress = lastGpsAddress;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getLostConnectTimes() {
		return lostConnectTimes;
	}

	public void setLostConnectTimes(Integer lostConnectTimes) {
		this.lostConnectTimes = lostConnectTimes;
	}

	public Integer getNiaojianFailTimes() {
		return niaojianFailTimes;
	}

	public void setNiaojianFailTimes(Integer niaojianFailTimes) {
		this.niaojianFailTimes = niaojianFailTimes;
	}

	public Integer getNiaojianOkTimes() {
		return niaojianOkTimes;
	}

	public void setNiaojianOkTimes(Integer niaojianOkTimes) {
		this.niaojianOkTimes = niaojianOkTimes;
	}

	public Integer getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	
	
}
