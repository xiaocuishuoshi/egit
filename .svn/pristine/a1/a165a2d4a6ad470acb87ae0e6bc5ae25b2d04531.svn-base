package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "jd_yjsb")
public class JdYjsb implements java.io.Serializable {
	
	private String id;
	private String jbnr;
	private String jbryid;
	private String jbryxm;
	private String jbsj;
	private String gxbmid;
	private String jsryid;
	private String jsryxm;
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "jbnr",nullable = false)
	public String getJbnr() {
		return jbnr;
	}
	public void setJbnr(String jbnr) {
		this.jbnr = jbnr;
	}
	@Column(name = "jbryid",nullable = false, length = 32)
	public String getJbryid() {
		return jbryid;
	}
	public void setJbryid(String jbryid) {
		this.jbryid = jbryid;
	}
	@Column(name = "jbryxm",nullable = false, length = 100)
	public String getJbryxm() {
		return jbryxm;
	}
	public void setJbryxm(String jbryxm) {
		this.jbryxm = jbryxm;
	}
	@Column(name = "jbsj",nullable = false)
	public String getJbsj() {
		return jbsj;
	}
	public void setJbsj(String jbsj) {
		this.jbsj = jbsj;
	}
	@Column(name = "gxbmid",nullable = false, length = 32)
	public String getGxbmid() {
		return gxbmid;
	}
	public void setGxbmid(String gxbmid) {
		this.gxbmid = gxbmid;
	}
	@Column(name = "jsryid",nullable = false, length = 32)
	public String getJsryid() {
		return jsryid;
	}
	public void setJsryid(String jsryid) {
		this.jsryid = jsryid;
	}
	@Column(name = "jsryxm",nullable = true, length = 100)
	public String getJsryxm() {
		return jsryxm;
	}
	public void setJsryxm(String jsryxm) {
		this.jsryxm = jsryxm;
	}
	public JdYjsb(String jbnr, String jbryid, String jbryxm, String jbsj,
			String gxbmid, String jsryid, String jsryxm) {
		super();
		this.jbnr = jbnr;
		this.jbryid = jbryid;
		this.jbryxm = jbryxm;
		this.jbsj = jbsj;
		this.gxbmid = gxbmid;
		this.jsryid = jsryid;
		this.jsryxm = jsryxm;
	}
	
	public JdYjsb() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JdYjsb [id=" + id + ", jbnr=" + jbnr + ", jbryid=" + jbryid
				+ ", jbryxm=" + jbryxm + ", jbsj=" + jbsj + ", gxbmid="
				+ gxbmid + ", jsryid=" + jsryid + ", jsryxm=" + jsryxm + "]";
	}
	
	
	

}
