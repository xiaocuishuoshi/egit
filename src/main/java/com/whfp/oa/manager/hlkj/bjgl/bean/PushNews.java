package com.whfp.oa.manager.hlkj.bjgl.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * PushNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "push_news")
public class PushNews implements java.io.Serializable {

	// Fields

	private String xxId;
	private String xxType;
	private String xxTypename;
	private String xxNr;
	private String xxZname;
	private String xxFname;
	private String xxReslet;
	private Timestamp xxTdate;

	// Constructors

	/** default constructor */
	public PushNews() {
	}

	/** full constructor */
	public PushNews(String xxId, String xxType, String xxTypename, String xxNr,
			String xxZname, String xxFname, String xxReslet, Timestamp xxTdate) {
		this.xxId = xxId;
		this.xxType = xxType;
		this.xxTypename = xxTypename;
		this.xxNr = xxNr;
		this.xxZname = xxZname;
		this.xxFname = xxFname;
		this.xxReslet = xxReslet;
		this.xxTdate = xxTdate;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "xx_id", unique = true, nullable = false, length = 64)
	public String getXxId() {
		return this.xxId;
	}

	public void setXxId(String xxId) {
		this.xxId = xxId;
	}

	@Column(name = "xx_type", length = 64)
	public String getXxType() {
		return this.xxType;
	}

	public void setXxType(String xxType) {
		this.xxType = xxType;
	}

	@Column(name = "xx_typename", length = 64)
	public String getXxTypename() {
		return this.xxTypename;
	}

	public void setXxTypename(String xxTypename) {
		this.xxTypename = xxTypename;
	}

	@Column(name = "xx_nr", length = 64)
	public String getXxNr() {
		return this.xxNr;
	}

	public void setXxNr(String xxNr) {
		this.xxNr = xxNr;
	}

	@Column(name = "xx_zname", length = 64)
	public String getXxZname() {
		return this.xxZname;
	}

	public void setXxZname(String xxZname) {
		this.xxZname = xxZname;
	}

	@Column(name = "xx_fname", length = 64)
	public String getXxFname() {
		return this.xxFname;
	}

	public void setXxFname(String xxFname) {
		this.xxFname = xxFname;
	}

	@Column(name = "xx_reslet", length = 64)
	public String getXxReslet() {
		return this.xxReslet;
	}

	public void setXxReslet(String xxReslet) {
		this.xxReslet = xxReslet;
	}

	@Column(name = "xx_tdate", length = 19)
	public Timestamp getXxTdate() {
		return this.xxTdate;
	}

	public void setXxTdate(Timestamp xxTdate) {
		this.xxTdate = xxTdate;
	}

}