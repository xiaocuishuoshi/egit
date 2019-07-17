package com.whfp.oa.manager.hlkj.bjgl.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SirenRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "siren_record")
public class SirenRecord implements java.io.Serializable {

	// Fields

	private String jlId;
	private String jlSbid;
	private String jlSbtype;
	private String jlBjjb;
	private String jlBjtype;
	private String jlBjgz;
	private String jlBjdz;
	private Timestamp jlStime;
	private String jlMs;
	private String jlPhone;
	private String jlReslet;
	private String jlZt;

	// Constructors

	/** default constructor */
	public SirenRecord() {
	}

	/** full constructor */
	public SirenRecord(String jlId, String jlSbid, String jlSbtype,
			String jlBjjb, String jlBjtype, String jlBjgz, String jlBjdz,
			Timestamp jlStime, String jlMs, String jlPhone, String jlReslet,
			String jlZt) {
		this.jlId = jlId;
		this.jlSbid = jlSbid;
		this.jlSbtype = jlSbtype;
		this.jlBjjb = jlBjjb;
		this.jlBjtype = jlBjtype;
		this.jlBjgz = jlBjgz;
		this.jlBjdz = jlBjdz;
		this.jlStime = jlStime;
		this.jlMs = jlMs;
		this.jlPhone = jlPhone;
		this.jlReslet = jlReslet;
		this.jlZt = jlZt;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "jl_id", unique = true, nullable = false, length = 64)
	public String getJlId() {
		return this.jlId;
	}

	public void setJlId(String jlId) {
		this.jlId = jlId;
	}

	@Column(name = "jl_sbid", length = 64)
	public String getJlSbid() {
		return this.jlSbid;
	}

	public void setJlSbid(String jlSbid) {
		this.jlSbid = jlSbid;
	}

	@Column(name = "jl_sbtype", length = 64)
	public String getJlSbtype() {
		return this.jlSbtype;
	}

	public void setJlSbtype(String jlSbtype) {
		this.jlSbtype = jlSbtype;
	}

	@Column(name = "jl_bjjb", length = 64)
	public String getJlBjjb() {
		return this.jlBjjb;
	}

	public void setJlBjjb(String jlBjjb) {
		this.jlBjjb = jlBjjb;
	}

	@Column(name = "jl_bjtype", length = 64)
	public String getJlBjtype() {
		return this.jlBjtype;
	}

	public void setJlBjtype(String jlBjtype) {
		this.jlBjtype = jlBjtype;
	}

	@Column(name = "jl_bjgz", length = 64)
	public String getJlBjgz() {
		return this.jlBjgz;
	}

	public void setJlBjgz(String jlBjgz) {
		this.jlBjgz = jlBjgz;
	}

	@Column(name = "jl_bjdz", length = 64)
	public String getJlBjdz() {
		return this.jlBjdz;
	}

	public void setJlBjdz(String jlBjdz) {
		this.jlBjdz = jlBjdz;
	}

	@Column(name = "jl_stime", length = 19)
	public Timestamp getJlStime() {
		return this.jlStime;
	}

	public void setJlStime(Timestamp jlStime) {
		this.jlStime = jlStime;
	}

	@Column(name = "jl_ms", length = 64)
	public String getJlMs() {
		return this.jlMs;
	}

	public void setJlMs(String jlMs) {
		this.jlMs = jlMs;
	}

	@Column(name = "jl_phone", length = 64)
	public String getJlPhone() {
		return this.jlPhone;
	}

	public void setJlPhone(String jlPhone) {
		this.jlPhone = jlPhone;
	}

	@Column(name = "jl_reslet", length = 64)
	public String getJlReslet() {
		return this.jlReslet;
	}

	public void setJlReslet(String jlReslet) {
		this.jlReslet = jlReslet;
	}

	@Column(name = "jl_zt", length = 64)
	public String getJlZt() {
		return this.jlZt;
	}

	public void setJlZt(String jlZt) {
		this.jlZt = jlZt;
	}

}