package com.whfp.oa.manager.qyxc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "qyxc_zpxx")
public class QyxcZpxx {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="公司名称不能为空")
	private String gsmc;
	
	@NotBlank(message="所属行业不能为空")
	private String hy;
	
	@NotBlank(message="公司所属性质不能为空")
	private String xz;
	
	@NotBlank(message="公司规模不能为空")
	private String gm;
	
	@NotBlank(message="薪资待遇不能为空")
	private String xzdy;
	
	@NotBlank(message="学历要求不能为空")
	private String xl;
	
	@NotBlank(message="招聘职位不能为空")
	private String zpzw;
	
	@NotBlank(message="工作年限不能为空")
	private String gznx;
	
	@NotBlank(message="工作地址不能为空")
	private String gzdz;
	
	@NotBlank(message="福利待遇不能为空")
	private String fldy;
	
	@NotBlank(message="联系电话不能为空")
	private String lxdh;
	
	public QyxcZpxx(){
		
	}
	
	

	public QyxcZpxx(String gsmc, String hy, String xz, String gm, String xzdy,
			String xl, String zpzw, String gznx, String gzdz, String fldy,
			String lxdh) {
		super();
		this.gsmc = gsmc;
		this.hy = hy;
		this.xz = xz;
		this.gm = gm;
		this.xzdy = xzdy;
		this.xl = xl;
		this.zpzw = zpzw;
		this.gznx = gznx;
		this.gzdz = gzdz;
		this.fldy = fldy;
		this.lxdh = lxdh;
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

	
	@Column(name = "gsmc", nullable = false,length =250)
	public String getGsmc() {
		return gsmc;
	}



	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}


	@Column(name = "hy", nullable = false)
	public String getHy() {
		return hy;
	}



	public void setHy(String hy) {
		this.hy = hy;
	}


	@Column(name = "xz", nullable = false)
	public String getXz() {
		return xz;
	}



	public void setXz(String xz) {
		this.xz = xz;
	}


	@Column(name = "gm", nullable = false)
	public String getGm() {
		return gm;
	}



	public void setGm(String gm) {
		this.gm = gm;
	}


	@Column(name = "xzdy", nullable = false)
	public String getXzdy() {
		return xzdy;
	}



	public void setXzdy(String xzdy) {
		this.xzdy = xzdy;
	}


	@Column(name = "xl", nullable = false)
	public String getXl() {
		return xl;
	}



	public void setXl(String xl) {
		this.xl = xl;
	}


	@Column(name = "zpzw", nullable = false)
	public String getZpzw() {
		return zpzw;
	}



	public void setZpzw(String zpzw) {
		this.zpzw = zpzw;
	}


	@Column(name = "gznx", nullable = false)
	public String getGznx() {
		return gznx;
	}



	public void setGznx(String gznx) {
		this.gznx = gznx;
	}


	@Column(name = "gzdz", nullable = false)
	public String getGzdz() {
		return gzdz;
	}



	public void setGzdz(String gzdz) {
		this.gzdz = gzdz;
	}


	@Column(name = "fldy", nullable = false)
	public String getFldy() {
		return fldy;
	}



	public void setFldy(String fldy) {
		this.fldy = fldy;
	}


	@Column(name = "lxdh", nullable = false)
	public String getLxdh() {
		return lxdh;
	}



	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	
}
