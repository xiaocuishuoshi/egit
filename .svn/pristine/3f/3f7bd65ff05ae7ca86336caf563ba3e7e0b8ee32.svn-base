package com.whfp.oa.manager.hlkj.zcgl.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hlkj_zcgl")
public class HlkjZcgl {

	private String id;
	private String zcmc;
	private String zcbh;
	private String ccbh;
	private String dept;
	private String gys;
	private String azdd;
	private Timestamp cgsj;
	private String sysm;
	private String cgjg;
	private String sbcs;
	private String zrr;
	private String sbzt;
	private String sblx;
	private String desc;
	private String zjnx;
	private String bypl;
	private String czl;
	private String gl;
	
	
public HlkjZcgl(){
		
	}

	public HlkjZcgl(String id, String zcmc, String zcbh, String ccbh, String dept,
		String gys, String azdd, Timestamp cgsj, String sysm, String cgjg,
		String sbcs, String zrr, String sbzt, String sblx, String desc,
		String zjnx, String bypl, String czl, String gl) {
	super();
	this.id = id;
	this.zcmc = zcmc;
	this.zcbh = zcbh;
	this.ccbh = ccbh;
	this.dept = dept;
	this.gys = gys;
	this.azdd = azdd;
	this.cgsj = cgsj;
	this.sysm = sysm;
	this.cgjg = cgjg;
	this.sbcs = sbcs;
	this.zrr = zrr;
	this.sbzt = sbzt;
	this.sblx = sblx;
	this.desc = desc;
	this.zjnx = zjnx;
	this.bypl = bypl;
	this.czl = czl;
	this.gl = gl;
}

	public HlkjZcgl(String id, String zcmc, String zcbh, String ccbh,
			String dept, String gys, String azdd, Timestamp cgsj, String sysm,
			String cgjg, String sbcs, String zrr, String sbzt, String sblx,
			String desc) {
		super();
		this.id = id;
		this.zcmc = zcmc;
		this.zcbh = zcbh;
		this.ccbh = ccbh;
		this.dept = dept;
		this.gys = gys;
		this.azdd = azdd;
		this.cgsj = cgsj;
		this.sysm = sysm;
		this.cgjg = cgjg;
		this.sbcs = sbcs;
		this.zrr = zrr;
		this.sbzt = sbzt;
		this.sblx = sblx;
		this.desc = desc;
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
	
	@Column(name = "zcmc", nullable = false)
	public String getZcmc() {
		return zcmc;
	}
	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}
	
	@Column(name = "zcbh", nullable = true)
	public String getZcbh() {
		return zcbh;
	}
	public void setZcbh(String zcbh) {
		this.zcbh = zcbh;
	}
	
	@Column(name = "ccbh", nullable = true)
	public String getCcbh() {
		return ccbh;
	}
	public void setCcbh(String ccbh) {
		this.ccbh = ccbh;
	}
	
	@Column(name = "dept", nullable = true)
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name = "gys", nullable = true)
	public String getGys() {
		return gys;
	}
	public void setGys(String gys) {
		this.gys = gys;
	}
	
	@Column(name = "azdd", nullable = true)
	public String getAzdd() {
		return azdd;
	}
	public void setAzdd(String azdd) {
		this.azdd = azdd;
	}
	
	@Column(name = "cgsj", nullable = true)
	public Timestamp getCgsj() {
		return cgsj;
	}
	public void setCgsj(Timestamp cgsj) {
		this.cgsj = cgsj;
	}
	
	@Column(name = "sysm", nullable = true)
	public String getSysm() {
		return sysm;
	}
	public void setSysm(String sysm) {
		this.sysm = sysm;
	}
	
	@Column(name = "cgjg", nullable = true)
	public String getCgjg() {
		return cgjg;
	}
	public void setCgjg(String cgjg) {
		this.cgjg = cgjg;
	}
	
	@Column(name = "sbcs", nullable = true)
	public String getSbcs() {
		return sbcs;
	}
	public void setSbcs(String sbcs) {
		this.sbcs = sbcs;
	}
	
	@Column(name = "zrr", nullable = true)
	public String getZrr() {
		return zrr;
	}
	public void setZrr(String zrr) {
		this.zrr = zrr;
	}
	
	@Column(name = "sbzt", nullable = true)
	public String getSbzt() {
		return sbzt;
	}
	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}
	
	@Column(name = "sblx", nullable = true)
	public String getSblx() {
		return sblx;
	}
	public void setSblx(String sblx) {
		this.sblx = sblx;
	}
	
	@Column(name = "desc", nullable = true)
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "zjnx", nullable = true)
	public String getZjnx() {
		return zjnx;
	}

	public void setZjnx(String zjnx) {
		this.zjnx = zjnx;
	}
	
	@Column(name = "bypl", nullable = true)
	public String getBypl() {
		return bypl;
	}

	public void setBypl(String bypl) {
		this.bypl = bypl;
	}
	
	@Column(name = "czl", nullable = true)
	public String getCzl() {
		return czl;
	}

	public void setCzl(String czl) {
		this.czl = czl;
	}
	
	@Column(name = "gl", nullable = true)
	public String getGl() {
		return gl;
	}

	public void setGl(String gl) {
		this.gl = gl;
	}
	
	
	
}
