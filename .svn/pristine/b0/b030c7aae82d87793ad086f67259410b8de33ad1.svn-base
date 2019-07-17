package com.whfp.oa.manager.cj.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "cj_result")
public class CjResult {
	private String id;
	/**
	 * 抽奖ID
	 */
	@NotBlank(message="抽奖ID不能为空")
	private String cjId;
	/**
	 * 发布人员
	 */
	@NotBlank(message="用户ID不能为空")
	private String userid;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 抽奖奖项
	 */
	private String cjJx;
	
	/**
	 * 抽奖奖品
	 */
	private String cjJp;
	
	
	private Timestamp cjrq;
	
	
	
	public CjResult(){
		
	}
	

	public CjResult(String cjId, String userid, String username, String cjJx,
			String cjJp,Timestamp cjrq) {
		super();
		this.cjId = cjId;
		this.userid = userid;
		this.username = username;
		this.cjJx = cjJx;
		this.cjJp = cjJp;
		this.cjrq = cjrq;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "cj_id", nullable = false)
	public String getCjId() {
		return cjId;
	}

	public void setCjId(String cjId) {
		this.cjId = cjId;
	}
	
	@Column(name = "userid", nullable = false)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "username", nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "cj_jx", nullable = false)
	public String getCjJx() {
		return cjJx;
	}

	public void setCjJx(String cjJx) {
		this.cjJx = cjJx;
	}

	@Column(name = "cj_jp", nullable = false)
	public String getCjJp() {
		return cjJp;
	}

	public void setCjJp(String cjJp) {
		this.cjJp = cjJp;
	}

	@Column(name = "cjrq", nullable = false)
	public Timestamp getCjrq() {
		return cjrq;
	}


	public void setCjrq(Timestamp cjrq) {
		this.cjrq = cjrq;
	}
	

}
