package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JdWzxx entity. 
 */
@Entity
@Table(name = "jd_wzxx")
public class JdWzxx implements java.io.Serializable {

	// Fields

	private String id;
	private String city;
	private String area; //地区
	private String longitude; //经度
	private String latitude;  //纬度
	private Timestamp createtime;
	private String userid;
	private String username;
	private String fkDeptId;
	private String outFlag;

	// Constructors

	/** default constructor */
	public JdWzxx() {
	} 

	/** minimal constructor */
	public JdWzxx(String longitude, String latitude, Timestamp createtime,
			String userid, String username, String fkDeptId,String outFlag) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.createtime = createtime;
		this.userid = userid;
		this.username = username;
		this.fkDeptId = fkDeptId;
		this.outFlag=outFlag;
	}

	/** full constructor */
	public JdWzxx(String city, String area, String longitude, String latitude,
			Timestamp createtime, String userid, String username, String fkDeptId,String outFlag) {
		this.city = city;
		this.area = area;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createtime = createtime;
		this.userid = userid;
		this.username = username;
		this.fkDeptId = fkDeptId;
		this.outFlag=outFlag;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 300)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "longitude", nullable = false, length = 20)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", nullable = false, length = 20)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "createtime", nullable = false, length = 30)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "userid", nullable = false, length = 32)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "fk_dept_id", nullable = false, length = 32)
	public String getFkDeptId() {
		return this.fkDeptId;
	}

	public void setFkDeptId(String fkDeptId) {
		this.fkDeptId = fkDeptId;
	}
	@Column(name = "out_flag", nullable = false, length =10)
	public String getOutFlag() {
		return this.outFlag;
	}

	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}

}