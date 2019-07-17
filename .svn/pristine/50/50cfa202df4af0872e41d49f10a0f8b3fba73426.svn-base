package com.whfp.oa.manager.hlkj.system.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hlkj_tpt")
public class HlkjTpt {
	private String id;
	/**
	 * 所属用户id
	 */
	
	private String tpName;
	
	private Timestamp tpCreatetime;
	
	private String tpSfzd;
	
	private String tpBack;
	
	private String tpBackId;
	
	private String tpAddress;
	
	private String tpAddressId;
	
	private String tpXnh;
	
	
	public HlkjTpt(){
		
	}
	

	public HlkjTpt(String id,  String tpName,
			Timestamp tpCreatetime, String tpSfzd, String tpBack, String tpBackId,
			String tpAddress, String tpAddressId,String tpXnh) {
		super();
		this.id = id;
		this.tpName = tpName;
		this.tpCreatetime = tpCreatetime;
		this.tpSfzd = tpSfzd;
		this.tpBack = tpBack;
		this.tpBackId = tpBackId;
		this.tpAddress = tpAddress;
		this.tpAddressId = tpAddressId;
		this.tpXnh = tpXnh;
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

	@Column(name = "tp_name", nullable = false)
	public String getTpName() {
		return tpName;
	}


	public void setTpName(String tpName) {
		this.tpName = tpName;
	}

	@Column(name = "tp_createtime", nullable = false)
	public Timestamp getTpCreatetime() {
		return tpCreatetime;
	}


	public void setTpCreatetime(Timestamp tpCreatetime) {
		this.tpCreatetime = tpCreatetime;
	}

	@Column(name = "tp_sfzd", nullable = false)
	public String getTpSfzd() {
		return tpSfzd;
	}


	public void setTpSfzd(String tpSfzd) {
		this.tpSfzd = tpSfzd;
	}

	@Column(name = "tp_back", nullable =true)
	public String getTpBack() {
		return tpBack;
	}


	public void setTpBack(String tpBack) {
		this.tpBack = tpBack;
	}

	@Column(name = "tp_backId", nullable =true)
	public String getTpBackId() {
		return tpBackId;
	}


	public void setTpBackId(String tpBackId) {
		this.tpBackId = tpBackId;
	}

	@Column(name = "tp_address", nullable =true)
	public String getTpAddress() {
		return tpAddress;
	}


	public void setTpAddress(String tpAddress) {
		this.tpAddress = tpAddress;
	}

	@Column(name = "tp_addressId", nullable =true)
	public String getTpAddressId() {
		return tpAddressId;
	}


	public void setTpAddressId(String tpAddressId) {
		this.tpAddressId = tpAddressId;
	}

	@Column(name = "tp_xnh", nullable =true)
	public String getTpXnh() {
		return tpXnh;
	}


	public void setTpXnh(String tpXnh) {
		this.tpXnh = tpXnh;
	}
	
	
	
	
}
