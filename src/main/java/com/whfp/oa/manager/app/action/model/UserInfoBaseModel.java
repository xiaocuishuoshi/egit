package com.whfp.oa.manager.app.action.model;

/**
 * 用户信息基类
 * @author wenhu
 *
 */
public class UserInfoBaseModel {

	//用户id
	private String uid;
	
	//用户真实姓名
	private String realname;
	
	//用户性别
	private String sex;
	
	//用户头像
	private String avatar;
	
	//角色类型
	private Integer roleType;
	
	//角色名称
	private String roleName;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
