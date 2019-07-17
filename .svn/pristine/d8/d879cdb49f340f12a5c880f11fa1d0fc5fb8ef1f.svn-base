package com.whfp.oa.manager.qyxc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "qyxc_qyjj")
public class QyxcQyjj {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="企业名称不能为空")
	private String name;
	/**
	 * 日程主题
	 */
	
	private String qyjj;
	
	private String addres;
	
	private String telphone;
	
	private String cz;
	
	private String qyfr;
	
	private String zczj;

	private String qyGrouping;
	
	public QyxcQyjj(){
		
	}
	
	public QyxcQyjj(String name, String qyjj, String addres, String telphone,
			String cz, String qyfr, String zczj) {
		super();
		this.name = name;
		this.qyjj = qyjj;
		this.addres = addres;
		this.telphone = telphone;
		this.cz = cz;
		this.qyfr = qyfr;
		this.zczj = zczj;
	}

	public QyxcQyjj(String name, String qyjj, String addres, String telphone) {
		super();
		this.name = name;
		this.qyjj = qyjj;
		this.addres = addres;
		this.telphone = telphone;
	}

	
	public QyxcQyjj(String name, String qyjj, String addres, String telphone,
			String cz, String qyfr, String zczj, String qyGrouping) {
		super();
		this.name = name;
		this.qyjj = qyjj;
		this.addres = addres;
		this.telphone = telphone;
		this.cz = cz;
		this.qyfr = qyfr;
		this.zczj = zczj;
		this.qyGrouping = qyGrouping;
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

	@Column(name = "name", nullable = false,length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "qyjj", nullable = true)
	public String getQyjj() {
		return this.qyjj;
	}

	public void setQyjj(String qyjj) {
		this.qyjj = qyjj;
	}

	@Column(name = "addres", nullable = true)
	public String getAddres() {
		return this.addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Column(name = "telphone", nullable = true)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "cz", nullable = true)
	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	@Column(name = "qyfr", nullable = true)
	public String getQyfr() {
		return this.qyfr;
	}

	public void setQyfr(String qyfr) {
		this.qyfr = qyfr;
	}

	@Column(name = "zczj", nullable = true)
	public String getZczj() {
		return this.zczj;
	}

	public void setZczj(String zczj) {
		this.zczj = zczj;
	}

	public String getQyGrouping() {
		return this.qyGrouping;
	}

	public void setQyGrouping(String qyGrouping) {
		this.qyGrouping = qyGrouping;
	}
	
	
}
