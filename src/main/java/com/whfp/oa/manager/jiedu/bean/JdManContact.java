package com.whfp.oa.manager.jiedu.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 戒毒人员的联系人
 * @author wenhu
 *
 */
@Entity
@Table(name = "jd_man_contact")
public class JdManContact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_id")
	private String userId;
	
	private String postion;
	
	private String name;
	
	private String company;
	
	private String phone;
	
	//职责
	private String duty;
	
	@Column(name="create_uid")
	private String createUid;
	
	@Column(name="create_date")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateUid() {
		return createUid;
	}

	public void setCreateUid(String createUid) {
		this.createUid = createUid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	
}
