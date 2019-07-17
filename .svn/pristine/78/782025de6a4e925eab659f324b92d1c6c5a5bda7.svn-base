package com.whfp.oa.manager.hlkj.nxfx.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * History entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "history")
public class History implements java.io.Serializable {

	// Fields

	private Integer lsId;
	private String lsVirtual;
	private String lsAttributename;
	private String lsDatatype;
	private Integer lsAbility;
	private Timestamp lsDate;
	private String lsDevicetype;

	// Constructors

	/** default constructor */
	public History() {
	}


	/** full constructor */
	public History(Integer lsId, String lsVirtual, String lsAttributename,
			String lsDatatype, Integer lsAbility, Timestamp lsDate,
			String lsDevicetype) {
		this.lsId = lsId;
		this.lsVirtual = lsVirtual;
		this.lsAttributename = lsAttributename;
		this.lsDatatype = lsDatatype;
		this.lsAbility = lsAbility;
		this.lsDate = lsDate;
		this.lsDevicetype = lsDevicetype;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ls_id", unique = true, nullable = false, length = 32)
	public Integer getLsId() {
		return this.lsId;
	}

	public void setLsId(Integer lsId) {
		this.lsId = lsId;
	}

	@Column(name = "ls_virtual", length = 64)
	public String getLsVirtual() {
		return this.lsVirtual;
	}

	public void setLsVirtual(String lsVirtual) {
		this.lsVirtual = lsVirtual;
	}

	@Column(name = "ls_attributename", length = 200)
	public String getLsAttributename() {
		return this.lsAttributename;
	}

	public void setLsAttributename(String lsAttributename) {
		this.lsAttributename = lsAttributename;
	}

	@Column(name = "ls_datatype", length = 64)
	public String getLsDatatype() {
		return this.lsDatatype;
	}

	public void setLsDatatype(String lsDatatype) {
		this.lsDatatype = lsDatatype;
	}

	@Column(name = "ls_ability")
	public Integer getLsAbility() {
		return this.lsAbility;
	}

	public void setLsAbility(Integer lsAbility) {
		this.lsAbility = lsAbility;
	}

	@Column(name = "ls_date", length = 19)
	public Timestamp getLsDate() {
		return this.lsDate;
	}

	public void setLsDate(Timestamp lsDate) {
		this.lsDate = lsDate;
	}

	@Column(name = "ls_devicetype", length = 64)
	public String getLsDevicetype() {
		return this.lsDevicetype;
	}

	public void setLsDevicetype(String lsDevicetype) {
		this.lsDevicetype = lsDevicetype;
	}

}