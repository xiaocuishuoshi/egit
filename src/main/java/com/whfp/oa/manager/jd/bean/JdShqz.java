package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "jd_shqz")
public class JdShqz implements java.io.Serializable {
	
	private String id;
	private String qzbt;	//求助标题
	private String qznr;	//求助内容
	private String qzryid;	//求助人id
	private String qzryxm;	//求助人姓名
	private Date qzsj;	//求助时间
	private String gxbmid;	//接收人id
	private String jssj;	//接受时间
	private String jsryxm;	//接收人姓名
	private String hfnr;	//回复内容
	private String hfsj;	//回复时间
	private String hfbz;	//回复标志
	private String hfrxm; //回复人姓名
    private String ydzt;//阅读状态

	
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
	@Column(name = "qzbt", nullable = false,length = 100)
	public String getQzbt() {
		return qzbt;
	}
	public void setQzbt(String qzbt) {
		this.qzbt = qzbt;
	}
	@Column(name = "qznr",nullable = false)
	public String getQznr() {
		return qznr;
	}
	public void setQznr(String qznr) {
		this.qznr = qznr;
	}
	@Column(name = "qzryid",nullable = false, length = 32)
	public String getQzryid() {
		return qzryid;
	}
	public void setQzryid(String qzryid) {
		this.qzryid = qzryid;
	}
	@Column(name = "qzryxm",nullable = false, length = 100)
	public String getQzryxm() {
		return qzryxm;
	}
	public void setQzryxm(String qzryxm) {
		this.qzryxm = qzryxm;
	}
	@Column(name = "qzsj",nullable = false)
	public Date getQzsj() {
		return qzsj;
	}
	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}
	@Column(name = "gxbmid",nullable = false, length = 32)
	public String getGxbmid() {
		return gxbmid;
	}
	public void setGxbmid(String gxbmid) {
		this.gxbmid = gxbmid;
	}
	@Column(name = "jssj",nullable = true)
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	@Column(name = "jsryxm",nullable = true, length = 100)
	public String getJsryxm() {
		return jsryxm;
	}
	public void setJsryxm(String jsryxm) {
		this.jsryxm = jsryxm;
	}
	@Column(name = "hfnr")
	public String getHfnr() {
		return hfnr;
	}
	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}
	@Column(name = "hfsj",nullable = true)
	public String getHfsj() {
		return hfsj;
	}
	public void setHfsj(String hfsj) {
		this.hfsj = hfsj;
	}
	@Column(name = "hfbz",nullable = true, length = 4)
	public String getHfbz() {
		return hfbz;
	}
	public void setHfbz(String hfbz) {
		this.hfbz = hfbz;
	}
	@Column(name = "hfrxm",nullable = true, length = 100)
	public String getHfrxm() {
		return hfrxm;
	}
	public void setHfrxm(String hfrxm) {
		this.hfrxm = hfrxm;
	}
	
	@Column(name="ydzt")
    public String getYdzt(){
    	return this.ydzt;
    }
    public void setYdzt(String ydzt){
    	this.ydzt=ydzt;
    }
	public JdShqz(String qzbt, String qznr, String qzryid, String qzryxm,
			Timestamp qzsj, String gxbmid, String jssj, String jsryxm,
			String hfnr, String hfsj, String hfbz, String hfrxm) {
		super();
		this.qzbt = qzbt;
		this.qznr = qznr;
		this.qzryid = qzryid;
		this.qzryxm = qzryxm;
		this.qzsj = qzsj;
		this.gxbmid = gxbmid;
		this.jssj = jssj;
		this.jsryxm = jsryxm;
		this.hfnr = hfnr;
		this.hfsj = hfsj;
		this.hfbz = hfbz;
		this.hfrxm = hfrxm;
	}
	
	public JdShqz() {
	}
	@Override
	public String toString() {
		return "JdShqz [id=" + id + ", qzbt=" + qzbt + ", qznr=" + qznr
				+ ", qzryid=" + qzryid + ", qzryxm=" + qzryxm + ", qzsj="
				+ qzsj + ", gxbmid=" + gxbmid + ", jssj=" + jssj + ", jsryxm="
				+ jsryxm + ", hfnr=" + hfnr + ", hfsj=" + hfsj + ", hfbz="
				+ hfbz + ", hfrxm=" + hfrxm + "]";
	}
	
}
