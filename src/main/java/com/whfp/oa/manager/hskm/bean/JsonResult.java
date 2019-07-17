package com.whfp.oa.manager.hskm.bean;

public class JsonResult<String> {

	private String msg;		//返回信息
	
	private String userid;	//当前用户ID
	
	private Boolean success;	//是否成功
	
	private String  transaction;		//登录认证ID
	
	private String fkdeptid;	//部门主键ID
	
	private  String passwor;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getFkdeptid() {
		return fkdeptid;
	}

	public void setFkdeptid(String fkdeptid) {
		this.fkdeptid = fkdeptid;
	}

	public String getPasswor() {
		return passwor;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}


	
}
