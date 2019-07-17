package com.whfp.oa.manager.hlkj.sbgl.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "hlkj_sbgl")
public class HlkjSbgl {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="序号不能为空")
	private String desc;
	/**
	 * 日程主题
	 */
	private String address;
	
	private String type;
	
	private String status;
	
	private Timestamp updatetime;
	
	private String sblm;
	
	private String addressid;
	
	public HlkjSbgl(){
		
	}


	public HlkjSbgl(String id, String desc, String address, String type,
			String status, Timestamp updatetime, String sblm,String addressid) {
		super();
		this.id = id;
		this.desc = desc;
		this.address = address;
		this.type = type;
		this.status = status;
		this.updatetime = updatetime;
		this.sblm = sblm;
		this.addressid = addressid;
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

	@Column(name = "sortNum", nullable = false)
	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "updatetime", nullable = false)
	public Timestamp getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	@Column(name = "sblm", nullable = true)
	public String getSblm() {
		return sblm;
	}

	public void setSblm(String sblm) {
		this.sblm = sblm;
	}


	@Column(name = "addressid", nullable = true)
	public String getAddressid() {
		return addressid;
	}


	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	
	
	
	
}
