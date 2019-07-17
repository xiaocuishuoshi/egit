package com.whfp.oa.manager.hlkj.sbgl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "hlkj_sb")
public class HlkjSb {
	
	@NotBlank(message="序号不能为空")
	private String sortNum;
	
	private String type;
	
	private String address;
	
	private String addressid;
	
	private String belon;
	
	public HlkjSb(){
		
	}


	public HlkjSb(String sortNum,  String type,
			String address,String addressid,String belon) {
		super();
		this.sortNum =sortNum;
		this.address = address;
		this.type = type;
		this.addressid = addressid;
		this.belon = belon;
	}



	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "sortNum", unique = true, nullable = false, length = 32)
	public String getSortNum() {
		return sortNum;
	}


	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "addressId", nullable = true)
	public String getAddressid() {
		return addressid;
	}


	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	@Column(name = "belon", nullable = true)
	public String getBelon() {
		return belon;
	}


	public void setBelon(String belon) {
		this.belon = belon;
	}

	
	
	
}
