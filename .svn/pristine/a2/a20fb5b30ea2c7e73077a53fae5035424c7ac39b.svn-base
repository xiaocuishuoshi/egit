package com.whfp.oa.manager.rssq.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "rssq_ccsq")
public class RssqCcsq {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="申请人不能为空")
	private String sqr;
	/**
	 * 日程主题
	 */
	
	private Timestamp sqrq;
	
	private String ccdd;
	
	private String ccsy;
	
	private Timestamp ccsjjs;
	
	private Timestamp ccsjks;
	
	private String shr;
	
	private Timestamp shrq;
	
	private String spr;
	
	private Timestamp sprq;
	
	private String dept;
	
	private String sqhf;
	
	
	public RssqCcsq(){
		
	}
	

	public RssqCcsq(String id, String sqr, Timestamp sqrq, String ccdd,
			String ccsy, Timestamp ccsjjs, Timestamp ccsjks, String shr, Timestamp shrq,
			String spr, Timestamp sprq, String dept, String sqhf) {
		super();
		this.id = id;
		this.sqr = sqr;
		this.sqrq = sqrq;
		this.ccdd = ccdd;
		this.ccsy = ccsy;
		this.ccsjjs = ccsjjs;
		this.ccsjks = ccsjks;
		this.shr = shr;
		this.shrq = shrq;
		this.spr = spr;
		this.sprq = sprq;
		this.dept = dept;
		this.sqhf = sqhf;
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
	
	@Column(name = "sqr", nullable = false)
	public String getSqr() {
		return sqr;
	}


	public void setSqr(String sqr) {
		this.sqr = sqr;
	}


	@Column(name = "sqrq", nullable = true)
	public Timestamp getSqrq() {
		return sqrq;
	}


	public void setSqrq(Timestamp sqrq) {
		this.sqrq = sqrq;
	}

	@Column(name = "ccdd", nullable = true)
	public String getCcdd() {
		return ccdd;
	}


	public void setCcdd(String ccdd) {
		this.ccdd = ccdd;
	}

	@Column(name = "ccsy", nullable = true)
	public String getCcsy() {
		return ccsy;
	}


	public void setCcsy(String ccsy) {
		this.ccsy = ccsy;
	}

	@Column(name = "ccsjjs", nullable = true)
	public Timestamp getCcsjjs() {
		return ccsjjs;
	}


	public void setCcsjjs(Timestamp ccsjjs) {
		this.ccsjjs = ccsjjs;
	}
	
	@Column(name = "ccsjks", nullable = true)
	public Timestamp getCcsjks() {
		return ccsjks;
	}


	public void setCcsjks(Timestamp ccsjks) {
		this.ccsjjs = ccsjjs;
	}

	@Column(name = "shr", nullable = true)
	public String getShr() {
		return shr;
	}


	public void setShr(String shr) {
		this.shr = shr;
	}

	@Column(name = "shrq", nullable = true)
	public Timestamp getShrq() {
		return shrq;
	}


	public void setShrq(Timestamp shrq) {
		this.shrq = shrq;
	}
	
	@Column(name = "spr", nullable = true)
	public String getSpr() {
		return spr;
	}


	public void setSpr(String spr) {
		this.spr = spr;
	}

	@Column(name = "sprq", nullable = true)
	public Timestamp getSprq() {
		return sprq;
	}


	public void setSprq(Timestamp sprq) {
		this.sprq = sprq;
	}

	@Column(name = "dept", nullable = true)
	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "sqhf", nullable = true)
	public String getSqhf() {
		return sqhf;
	}


	public void setSqhf(String sqhf) {
		this.sqhf = sqhf;
	}




}
