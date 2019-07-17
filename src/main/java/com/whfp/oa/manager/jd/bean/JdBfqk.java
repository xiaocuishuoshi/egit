package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JdBfqk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jd_bfqk")
public class JdBfqk implements java.io.Serializable {

	// Fields

	private String id;
	private String bfnr;
	private String bfzp;
	private Timestamp bfsj;
	private String bfrid;
	private String sqgb;
	private String sqmj;
	private String jdsg;
	private String wgy;
	private String bfrname;
	private String sqzwid;
	private String sqzwname;

	// Constructors

	/** default constructor */
	public JdBfqk() {
	}


	/** full constructor */
	public JdBfqk(String id, String bfnr, String bfzp, Timestamp bfsj,
			String bfrid,String sqgb, String sqmj,String jdsg, String wgy, String bfrname, String sqzwid, String sqzwname) {
		this.id = id;
		this.bfnr = bfnr;
		this.bfzp = bfzp;
		this.bfsj = bfsj;
		this.bfrid = bfrid;
		this.sqgb = sqgb;
		this.sqmj = sqmj;
		this.sqgb = jdsg;
		this.sqmj = wgy;
		this.bfrname = bfrname;
		this.sqzwid = sqzwid;
		this.sqzwname = sqzwname;
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

	@Column(name = "bfnr", length = 65535)
	public String getBfnr() {
		return this.bfnr;
	}

	public void setBfnr(String bfnr) {
		this.bfnr = bfnr;
	}

	@Column(name = "bfzp", length = 50)
	public String getBfzp() {
		return this.bfzp;
	}

	public void setBfzp(String bfzp) {
		this.bfzp = bfzp;
	}

	@Column(name = "bfsj", length = 19)
	public Timestamp getBfsj() {
		return this.bfsj;
	}

	public void setBfsj(Timestamp bfsj) {
		this.bfsj = bfsj;
	}

	@Column(name = "bfrid", length = 32)
	public String getBfrid() {
		return this.bfrid;
	}

	public void setBfrid(String bfrid) {
		this.bfrid = bfrid;
	}
	@Column(name = "sqgb", length = 20)
	public String getSqgb() {
		return this.sqgb;
	}

	public void setSqgb(String sqgb) {
		this.sqgb = sqgb;
	}

	
	@Column(name = "sqmj", length = 20)
	public String getSqmj() {
		return this.sqmj;
	}

	public void setSqmj(String sqmj) {
		this.sqmj = sqmj;
	}

	
	@Column(name = "jdsg", length = 20)
	public String getJdsg() {
		return this.jdsg;
	}

	public void setJdsg(String jdsg) {
		this.jdsg = jdsg;
	}

	
	@Column(name = "wgy", length = 20)
	public String getWgy() {
		return this.wgy;
	}

	public void setWgy(String wgy) {
		this.wgy = wgy;
	}
	
	@Column(name = "bfrname", length = 10)
	public String getBfrname() {
		return this.bfrname;
	}

	public void setBfrname(String bfrname) {
		this.bfrname = bfrname;
	}

	@Column(name = "sqzwid", length = 32)
	public String getSqzwid() {
		return this.sqzwid;
	}

	public void setSqzwid(String sqzwid) {
		this.sqzwid = sqzwid;
	}

	@Column(name = "sqzwname", length = 30)
	public String getSqzwname() {
		return this.sqzwname;
	}

	public void setSqzwname(String sqzwname) {
		this.sqzwname = sqzwname;
	}

}