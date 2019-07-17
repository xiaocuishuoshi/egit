package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "jd_sxhb")
public class JdSxhb implements java.io.Serializable {
	private String id;
	private String hbbt; //标题
	private String hbnr;	//内容
	private Timestamp hbsj;	//汇报时间
	private String hbryid;	//汇报人id
	private String hbryxm;	//汇报人姓名
	private String hbbz;	//汇报标志
	private String gxbmid;	//管辖部门
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
	@Column(name = "hbbt",nullable = true, length = 200)
	public String getHbbt() {
		return hbbt;
	}
	public void setHbbt(String hbbt) {
		this.hbbt = hbbt;
	}
	@Column(name = "hbnr",nullable = true)
	public String getHbnr() {
		return hbnr;
	}
	public void setHbnr(String hbnr) {
		this.hbnr = hbnr;
	}
	@Column(name = "hbsj",nullable = true)
	public Timestamp getHbsj() {
		return hbsj;
	}
	public void setHbsj(Timestamp hbsj) {
		this.hbsj = hbsj;
	}
	@Column(name = "hbryid",nullable = true, length = 32)
	public String getHbryid() {
		return hbryid;
	}
	public void setHbryid(String hbryid) {
		this.hbryid = hbryid;
	}
	@Column(name = "hbryxm",nullable = true, length = 100)
	public String getHbryxm() {
		return hbryxm;
	}
	public void setHbryxm(String hbryxm) {
		this.hbryxm = hbryxm;
	}
	@Column(name = "hbbz",nullable = true, length = 4)
	public String getHbbz() {
		return hbbz;
	}
	public void setHbbz(String hbbz) {
		this.hbbz = hbbz;
	}
	@Column(name = "gxbmid",nullable = true, length = 4)
	public String getGxbmid() {
		return gxbmid;
	}
	public void setGxbmid(String gxbmid) {
		this.gxbmid = gxbmid;
	}
	
	@Column(name="ydzt")
    public String getYdzt(){
    	return this.ydzt;
    }
    public void setYdzt(String ydzt){
    	this.ydzt=ydzt;
    }
	public JdSxhb(String hbbt, String hbnr, Timestamp hbsj, String hbryid,
			String hbryxm, String hbbz, String gxbmid) {
		super();
		this.hbbt = hbbt;
		this.hbnr = hbnr;
		this.hbsj = hbsj;
		this.hbryid = hbryid;
		this.hbryxm = hbryxm;
		this.hbbz = hbbz;
		this.gxbmid = gxbmid;
	}
	public JdSxhb() {
	}
	@Override
	public String toString() {
		return "JdSxhb [id=" + id + ", hbbt=" + hbbt + ", hbnr=" + hbnr
				+ ", hbsj=" + hbsj + ", hbryid=" + hbryid + ", hbryxm="
				+ hbryxm + ", hbbz=" + hbbz + ", gxbmid=" + gxbmid + "]";
	}
	
}
