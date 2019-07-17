package com.whfp.oa.manager.hlkj.system.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hlkj_address")
public class HlkjAddress {
	private String id;
	/**
	 * 所属用户id
	 */
	private String addressName;
	
	private String father;
	
	private String addressJb;
	
	private String addressFlmc;
	
	private String addressSb;
	
	private String addressDesc;
	
	
	
	public HlkjAddress(){
		
	}
	
	public HlkjAddress(String id, String addressName, String father,
			String addressJb, String addressFlmc, String addressSb,
			String addressDesc) {
		super();
		this.id = id;
		this.addressName = addressName;
		this.father = father;
		this.addressJb = addressJb;
		this.addressFlmc = addressFlmc;
		this.addressSb = addressSb;
		this.addressDesc = addressDesc;
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
	
	@Column(name = "address_name", nullable = false)
	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
	@Column(name = "father", nullable = true)
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	@Column(name = "address_jb", nullable = true)
	public String getAddressJb() {
		return addressJb;
	}

	public void setAddressJb(String addressJb) {
		this.addressJb = addressJb;
	}
	
	@Column(name = "address_flmc", nullable = true)
	public String getAddressFlmc() {
		return addressFlmc;
	}

	public void setAddressFlmc(String addressFlmc) {
		this.addressFlmc = addressFlmc;
	}

	@Column(name = "address_sb", nullable = true)
	public String getAddressSb() {
		return addressSb;
	}

	public void setAddressSb(String addressSb) {
		this.addressSb = addressSb;
	}

	@Column(name = "address_desc", nullable = true)
	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	
	
}
