package com.whfp.oa.manager.qyxc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "qyxc_product")
public class QyxcProduct {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="产品名称不能为空")
	private String proName;
	/**
	 * 日程主题
	 */
	
	private String proMs;
	
	private String proCharge;
	
	private String proEx;
	
	private String proPho;
	
	public QyxcProduct(){
		
	}

	public QyxcProduct(String proName, String proMs, String proCharge,
			String proEx, String proPho) {
		super();
		this.proName = proName;
		this.proMs = proMs;
		this.proCharge = proCharge;
		this.proEx = proEx;
		this.proPho = proPho;
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
	
	@Column(name = "pro_name", nullable = false)
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Column(name = "pro_ms", nullable = true)
	public String getProMs() {
		return proMs;
	}

	public void setProMs(String proMs) {
		this.proMs = proMs;
	}

	@Column(name = "pro_charge", nullable = true)
	public String getProCharge() {
		return proCharge;
	}

	public void setProCharge(String proCharge) {
		this.proCharge = proCharge;
	}

	@Column(name = "pro_ex", nullable = true)
	public String getProEx() {
		return proEx;
	}

	public void setProEx(String proEx) {
		this.proEx = proEx;
	}

	@Column(name = "pro_pho", nullable = true)
	public String getProPho() {
		return proPho;
	}

	public void setProPho(String proPho) {
		this.proPho = proPho;
	}


	
}
