package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * JdKfjc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jd_kfjc")
public class JdKfjc implements java.io.Serializable {

	// Fields

	private String id;
	private String fzr;
	private String jcsm;
	private String sfzc;
	private String jcsj;
	private String ryid;
	private String name;
	private String dh;
	private String bmid;

	// Constructors

	/** default constructor */
	public JdKfjc() {
	}


	/** full constructor */
	public JdKfjc(String id, String fzr, String jcsm, String sfzc, String jcsj,
			String ryid, String name, String dh,String bmid) {
		this.id = id;
		this.fzr = fzr;
		this.jcsm = jcsm;
		this.sfzc = sfzc;
		this.jcsj = jcsj;
		this.ryid = ryid;
		this.name = name;
		this.dh = dh;
		this.bmid=bmid;
	}

	@GenericGenerator(name="generator", strategy="uuid.hex")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "fzr", length = 20)
	public String getFzr() {
		return this.fzr;
	}

	public void setFzr(String fzr) {
		this.fzr = fzr;
	}

	@Column(name = "jcsm", length = 500)
	public String getJcsm() {
		return this.jcsm;
	}

	public void setJcsm(String jcsm) {
		this.jcsm = jcsm;
	}

	@Column(name = "sfzc", length = 4)
	public String getSfzc() {
		return this.sfzc;
	}

	public void setSfzc(String sfzc) {
		this.sfzc = sfzc;
	}

	@Column(name = "jcsj", length = 10)
	public String getJcsj() {
		return this.jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	@Column(name = "ryid", length = 32)
	public String getRyid() {
		return this.ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	@Column(name = "name", length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dh", length = 20)
	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "bmid", length = 32)
	public String getBmid() {
		return bmid;
	}


	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

}