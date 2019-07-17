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
@Table(name = "qxj_detile")
public class QxjDetile {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="申请人不能为空")
	private String sqr;
	/**
	 * 日程主题
	 */
	
	private Timestamp sqsj;
	
	private String dept;
	
	private String jqlx;
	
	private Timestamp qjsjks;
	
	private Timestamp qjsjjs;
	
	private String qjly;
	
	private String bmzgyj;
	
	private Timestamp zgsj;
	
	private String gsldpf;
	
	private Timestamp pfsj;
	
	private String spjg;
	
	private int qjsj;
	
	public QxjDetile(){
		
	}
	

	public QxjDetile(String id, String sqr, Timestamp sqsj, String dept,
			String jqlx, Timestamp qjsjks, Timestamp qjsjjs, String qjly,
			String bmzgyj, Timestamp zgsj, String gsldpf, Timestamp pfsj,
			String spjg, int qjsj) {
		super();
		this.id = id;
		this.sqr = sqr;
		this.sqsj = sqsj;
		this.dept = dept;
		this.jqlx = jqlx;
		this.qjsjks = qjsjks;
		this.qjsjjs = qjsjjs;
		this.qjly = qjly;
		this.bmzgyj = bmzgyj;
		this.zgsj = zgsj;
		this.gsldpf = gsldpf;
		this.pfsj = pfsj;
		this.spjg = spjg;
		this.qjsj = qjsj;
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

	@Column(name = "sqsj", nullable = true)
	public Timestamp getSqsj() {
		return sqsj;
	}


	public void setSqsj(Timestamp sqsj) {
		this.sqsj = sqsj;
	}

	@Column(name = "dept", nullable = true)
	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "jqlx", nullable = true)
	public String getJqlx() {
		return jqlx;
	}


	public void setJqlx(String jqlx) {
		this.jqlx = jqlx;
	}

	@Column(name = "qjsjks", nullable = false)
	public Timestamp getQjsjks() {
		return qjsjks;
	}


	public void setQjsjks(Timestamp qjsjks) {
		this.qjsjks = qjsjks;
	}

	@Column(name = "qjsjjs", nullable = false)
	public Timestamp getQjsjjs() {
		return qjsjjs;
	}


	public void setQjsjjs(Timestamp qjsjjs) {
		this.qjsjjs = qjsjjs;
	}

	@Column(name = "qjly", nullable = false)
	public String getQjly() {
		return qjly;
	}


	public void setQjly(String qjly) {
		this.qjly = qjly;
	}

	@Column(name = "bmzgyj", nullable = true)
	public String getBmzgyj() {
		return bmzgyj;
	}


	public void setBmzgyj(String bmzgyj) {
		this.bmzgyj = bmzgyj;
	}

	@Column(name = "zgsj", nullable = true)
	public Timestamp getZgsj() {
		return zgsj;
	}


	public void setZgsj(Timestamp zgsj) {
		this.zgsj = zgsj;
	}

	@Column(name = "gsldpf", nullable = true)
	public String getGsldpf() {
		return gsldpf;
	}


	public void setGsldpf(String gsldpf) {
		this.gsldpf = gsldpf;
	}

	@Column(name = "pfsj", nullable = true)
	public Timestamp getPfsj() {
		return pfsj;
	}


	public void setPfsj(Timestamp pfsj) {
		this.pfsj = pfsj;
	}

	@Column(name = "spjg", nullable = true)
	public String getSpjg() {
		return spjg;
	}


	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}

	@Column(name = "qjsj", nullable = true)
	public int getQjsj() {
		return qjsj;
	}


	public void setQjsj(int qjsj) {
		this.qjsj = qjsj;
	}
	
}
