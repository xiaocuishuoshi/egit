package com.whfp.oa.manager.hlkj.bjgl.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "siren_rule")
public class SirenRule implements java.io.Serializable {

	// Fields

	private String gzId;
	private String gzGzname;
	private String gzSbtype;
	private String gzSbjb;
	private String gzBjtype;
	private Integer gzTime;
	private String gzGz;
	private Timestamp gzKdate;
	private Timestamp gzJdate;
	private Integer gzCount;
	private String gzKg;
	private String gzFacility;
	private String gzDescribe;
	private String gzPhone;
	private String gzEmail;

	// Constructors

	public SirenRule() {
	}


	/** full constructor */
	public SirenRule(String gzId, String gzGzname, String gzSbtype,
			String gzSbjb, String gzBjtype, Integer gzTime, String gzGz,
			Timestamp gzKdate, Timestamp gzJdate, Integer gzCount, String gzKg,
			String gzFacility, String gzDescribe, String gzPhone, String gzEmail) {
		this.gzId = gzId;
		this.gzGzname = gzGzname;
		this.gzSbtype = gzSbtype;
		this.gzSbjb = gzSbjb;
		this.gzBjtype = gzBjtype;
		this.gzTime = gzTime;
		this.gzGz = gzGz;
		this.gzKdate = gzKdate;
		this.gzJdate = gzJdate;
		this.gzCount = gzCount;
		this.gzKg = gzKg;
		this.gzFacility = gzFacility;
		this.gzDescribe = gzDescribe;
		this.gzPhone = gzPhone;
		this.gzEmail = gzEmail;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "gz_id", unique = true, nullable = false, length = 32)
	public String getGzId() {
		return this.gzId;
	}

	public void setGzId(String gzId) {
		this.gzId = gzId;
	}

	@Column(name = "gz_gzname", length = 64)
	public String getGzGzname() {
		return this.gzGzname;
	}

	public void setGzGzname(String gzGzname) {
		this.gzGzname = gzGzname;
	}

	@Column(name = "gz_sbtype", length = 64)
	public String getGzSbtype() {
		return this.gzSbtype;
	}

	public void setGzSbtype(String gzSbtype) {
		this.gzSbtype = gzSbtype;
	}

	@Column(name = "gz_sbjb", length = 64)
	public String getGzSbjb() {
		return this.gzSbjb;
	}

	public void setGzSbjb(String gzSbjb) {
		this.gzSbjb = gzSbjb;
	}

	@Column(name = "gz_bjtype", length = 64)
	public String getGzBjtype() {
		return this.gzBjtype;
	}

	public void setGzBjtype(String gzBjtype) {
		this.gzBjtype = gzBjtype;
	}

	@Column(name = "gz_time")
	public Integer getGzTime() {
		return this.gzTime;
	}

	public void setGzTime(Integer gzTime) {
		this.gzTime = gzTime;
	}

	@Column(name = "gz_gz", length = 64)
	public String getGzGz() {
		return this.gzGz;
	}

	public void setGzGz(String gzGz) {
		this.gzGz = gzGz;
	}

	@Column(name = "gz_kdate", length = 19)
	public Timestamp getGzKdate() {
		return this.gzKdate;
	}

	public void setGzKdate(Timestamp gzKdate) {
		this.gzKdate = gzKdate;
	}

	@Column(name = "gz_jdate", length = 19)
	public Timestamp getGzJdate() {
		return this.gzJdate;
	}

	public void setGzJdate(Timestamp gzJdate) {
		this.gzJdate = gzJdate;
	}

	@Column(name = "gz_count")
	public Integer getGzCount() {
		return this.gzCount;
	}

	public void setGzCount(Integer gzCount) {
		this.gzCount = gzCount;
	}

	@Column(name = "gz_kg", length = 64)
	public String getGzKg() {
		return this.gzKg;
	}

	public void setGzKg(String gzKg) {
		this.gzKg = gzKg;
	}

	@Column(name = "gz_facility", length = 64)
	public String getGzFacility() {
		return this.gzFacility;
	}

	public void setGzFacility(String gzFacility) {
		this.gzFacility = gzFacility;
	}

	@Column(name = "gz_describe", length = 500)
	public String getGzDescribe() {
		return this.gzDescribe;
	}

	public void setGzDescribe(String gzDescribe) {
		this.gzDescribe = gzDescribe;
	}

	@Column(name = "gz_phone", length = 64)
	public String getGzPhone() {
		return this.gzPhone;
	}

	public void setGzPhone(String gzPhone) {
		this.gzPhone = gzPhone;
	}

	@Column(name = "gz_email", length = 64)
	public String getGzEmail() {
		return this.gzEmail;
	}

	public void setGzEmail(String gzEmail) {
		this.gzEmail = gzEmail;
	}

}