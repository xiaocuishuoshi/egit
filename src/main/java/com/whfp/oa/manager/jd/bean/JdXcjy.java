package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JdXcjy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jd_xcjy")
public class JdXcjy implements java.io.Serializable {

	// Fields

	private String id;
	private String jdXcbt;
	private String jdXcnr;
	private String jdTp;
	private Timestamp jdSj;

	// Constructors

	/** default constructor */
	public JdXcjy() {
	}


	/** full constructor */
	public JdXcjy(String id, String jdXcbt, String jdXcnr, String jdTp) {
		this.id = id;
		this.jdXcbt = jdXcbt;
		this.jdXcnr = jdXcnr;
		this.jdTp = jdTp;
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

	@Column(name = "jd_xcbt", length = 20)
	public String getJdXcbt() {
		return this.jdXcbt;
	}

	public void setJdXcbt(String jdXcbt) {
		this.jdXcbt = jdXcbt;
	}

	@Column(name = "jd_xcnr", length = 65535)
	public String getJdXcnr() {
		return this.jdXcnr;
	}

	public void setJdXcnr(String jdXcnr) {
		this.jdXcnr = jdXcnr;
	}

	@Column(name = "jd_tp", length = 50)
	public String getJdTp() {
		return this.jdTp;
	}

	public void setJdTp(String jdTp) {
		this.jdTp = jdTp;
	}

	@Column(name = "jd_sj")
	public Timestamp getJdSj() {
		return jdSj;
	}
	public void setJdSj(Timestamp jdSj) {
		this.jdSj = jdSj;
	}
}