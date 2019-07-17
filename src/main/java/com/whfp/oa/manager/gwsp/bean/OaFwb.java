package com.whfp.oa.manager.gwsp.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 日程安排表对应实体
 */

public class OaFwb implements java.io.Serializable {

	// Fields

	/**
	 * @Fields serialVersionUID : 
	 */
	
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 日程主题
	 */
	@NotBlank(message="公文标题不能为空")
	@Length(min=1, max=500, message="公文标题长度限制在1-50")
	private String gwbt;
	private String swzh;
	private String fwzh;
	@NotBlank(message="主题词不能为空")
	private String ztc;
	private String zsjg;
	private String csjg;
	@NotBlank(message="起草单位不能为空")
	private String qcdw;
	@NotBlank(message="拟稿人不能为空")
	private String ngr;
	private String sgr;
	private String hgr;
	private String fyfs;
	private String jdr;
	public OaFwb( String gwbt, String swzh, String fwzh, String ztc,
			String zsjg, String csjg, String qcdw, String sgr, String hgr,
			String fyfs, String jdr,String ngr) {
		super();
		this.gwbt = gwbt;
		this.swzh = swzh;
		this.fwzh = fwzh;
		this.ztc = ztc;
		this.zsjg = zsjg;
		this.csjg = csjg;
		this.qcdw = qcdw;
		this.sgr = sgr;
		this.hgr = hgr;
		this.fyfs = fyfs;
		this.jdr = jdr;
		this.ngr = ngr;
	}
	
	public String getNgr() {
		return ngr;
	}

	public void setNgr(String ngr) {
		this.ngr = ngr;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGwbt() {
		return gwbt;
	}
	public void setGwbt(String gwbt) {
		this.gwbt = gwbt;
	}
	public String getSwzh() {
		return swzh;
	}
	public void setSwzh(String swzh) {
		this.swzh = swzh;
	}
	public String getFwzh() {
		return fwzh;
	}
	public void setFwzh(String fwzh) {
		this.fwzh = fwzh;
	}
	public String getZtc() {
		return ztc;
	}
	public void setZtc(String ztc) {
		this.ztc = ztc;
	}
	public String getZsjg() {
		return zsjg;
	}
	public void setZsjg(String zsjg) {
		this.zsjg = zsjg;
	}
	public String getCsjg() {
		return csjg;
	}
	public void setCsjg(String csjg) {
		this.csjg = csjg;
	}
	public String getQcdw() {
		return qcdw;
	}
	public void setQcdw(String qcdw) {
		this.qcdw = qcdw;
	}
	public String getSgr() {
		return sgr;
	}
	public void setSgr(String sgr) {
		this.sgr = sgr;
	}
	public String getHgr() {
		return hgr;
	}
	public void setHgr(String hgr) {
		this.hgr = hgr;
	}
	public String getFyfs() {
		return fyfs;
	}
	public void setFyfs(String fyfs) {
		this.fyfs = fyfs;
	}
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
	}
	
	
	
}