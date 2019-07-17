package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JdSqzw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jd_sqzw")
public class JdSqzw implements java.io.Serializable {

	// Fields

	private String id;
	private String sqgb;
	private String sqmj;
	private String jdsg;
	private String wgy;
	private String x;
	private String addres;

	// Constructors

	/** default constructor */
	public JdSqzw() {
	}


	/** full constructor */
	public JdSqzw(String id, String sqgb, String sqmj,String jdsg, String wgy, String x, String addres) {
		this.id = id;
		this.sqgb = sqgb;
		this.sqmj = sqmj;
		this.sqgb = jdsg;
		this.sqmj = wgy;
		this.x=x;
		this.addres = addres;
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
	
	@Column(name = "x", length = 20)
	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}
	
	@Column(name = "addres", length = 10)
	public String getAddres() {
		return this.addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

}