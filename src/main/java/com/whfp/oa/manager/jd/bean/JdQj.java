package com.whfp.oa.manager.jd.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "jd_qj")
public class JdQj implements java.io.Serializable {
	private String id;
	private String qjryid;  //请假人员id
	private String qjryxm; //请假人员姓名
	private Date qjsj; //请假时间
	private String qjkssj; //请假开始时间
	private String qjjssj;  //请假结束时间
	private String qjnr;   //请假内容
	private String cgbz;  //草稿标志
	private String spzt;  //审批状态
	private String gxbmid;  //管辖部门
	private String xjsj;  //销假时间
	private String xjbz;	//销假标志
	private String qjlb;  //请假类别
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
	@Column(name = "qjryid", nullable = true,length = 32)
	public String getQjryid() {
		return qjryid;
	}
	public void setQjryid(String qjryid) {
		this.qjryid = qjryid;
	}
	@Column(name = "qjryxm", nullable = true,length = 100)
	public String getQjryxm() {
		return qjryxm;
	}
	public void setQjryxm(String qjryxm) {
		this.qjryxm = qjryxm;
	}
	@Column(name = "qjkssj", nullable = true,length = 30)
	public String getQjkssj() {
		return qjkssj;
	}
	public void setQjkssj(String qjkssj) {
		this.qjkssj = qjkssj;
	}
	@Column(name = "qjjssj", nullable = true,length = 30)
	public String getQjjssj() {
		return qjjssj;
	}
	public void setQjjssj(String qjjssj) {
		this.qjjssj = qjjssj;
	}
	@Column(name = "qjnr")

	public String getQjnr() {
		return qjnr;
	}
	public void setQjnr(String qjnr) {
	this.qjnr = qjnr;
}
	@Column(name = "cgbz", nullable = true,length = 4)
	public String getCgbz() {
		return cgbz;
	}
	public void setCgbz(String cgbz) {
		this.cgbz = cgbz;
	}
	@Column(name = "spzt", nullable = true,length = 4)
	public String getSpzt() {
		return spzt;
	}
	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	@Column(name = "gxbmid", nullable = true,length = 32)
	public String getGxbmid() {
		return gxbmid;
	}
	public void setGxbmid(String gxbmid) {
		this.gxbmid = gxbmid;
	}
	@Column(name = "xjsj")
	public void setXjsj(String xjsj) {
		this.xjsj = xjsj;
	}
	public String getXjsj() {
		return xjsj;
	}

	@Column(name = "xjbz", nullable = true,length = 4)
	public String getXjbz() {
		return xjbz;
	}
	public void setXjbz(String xjbz) {
		this.xjbz = xjbz;
	}


	public Date getQjsj() {
		return qjsj;
	}
	public void setQjsj(Date qjsj) {
		this.qjsj = qjsj;
	}
	public String getQjlb() {
		return qjlb;
	}
	public void setQjlb(String qjlb) {
		this.qjlb = qjlb;
	}
	public JdQj(String qjryid, String qjryxm, String qjkssj, String qjjssj,
			String qjnr, String cgbz, String spzt, String gxbmid, String xjsj,
			String xjbz,String qjlb) { 
		super();
		this.qjryid = qjryid;
		this.qjryxm = qjryxm;
		this.qjkssj = qjkssj;
		this.qjjssj = qjjssj;
		this.qjnr = qjnr;
		this.cgbz = cgbz;
		this.spzt = spzt;
		this.gxbmid = gxbmid;
		this.xjsj = xjsj;
		this.xjbz = xjbz;
		this.qjlb=qjlb;
	}
	public JdQj() {
	}
	@Override
	public String toString() {
		return "JdQj [id=" + id + ", qjryid=" + qjryid + ", qjryxm=" + qjryxm
				+ ", qjkssj=" + qjkssj + ", qjjssj=" + qjjssj + ", qjnr="
				+ qjnr + ", cgbz=" + cgbz + ", spzt=" + spzt + ", gxbmid="
				+ gxbmid + ", xjsj=" + xjsj + ", xjbz=" + xjbz + ",qjlb="+qjlb+"]";
	}
	


}
