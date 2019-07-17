package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 部门表对应实体
 */
@Entity
@Table(name = "jd_dhyj")
public class JdDhyj implements java.io.Serializable {

	// Fields
	private String id;
	private String fsrxm; //发送人姓名
	private String jsrxm;	//接受人姓名
	private String fssj;	//发送时间
	private String fsnr;	//发送内容
	private String bz;		//备注
	private String jsrid;
	
	
	public JdDhyj() {
	}

	public JdDhyj(String id, String fsrxm, String jsrxm, String fssj,
			String fsnr, String bz) {
		super();
		this.id = id;
		this.fsrxm = fsrxm;
		this.jsrxm = jsrxm;
		this.fssj = fssj;
		this.fsnr = fsnr;
		this.bz = bz;
	}




	// Property accessors
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

	@Column(name = "fsrxm")
	public String getFsrxm() {
		return fsrxm;
	}

	public void setFsrxm(String fsrxm) {
		this.fsrxm = fsrxm;
	}
	@Column(name = "jsrxm")
	public String getJsrxm() {
		return jsrxm;
	}

	public void setJsrxm(String jsrxm) {
		this.jsrxm = jsrxm;
	}
	@Column(name = "fssj")
	public String getFssj() {
		return fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}
	@Column(name = "fsnr")
	public String getFsnr() {
		return fsnr;
	}

	public void setFsnr(String fsnr) {
		this.fsnr = fsnr;
	}
	@Column(name = "bz")
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "jsrid")
	public String getJsrid() {
		return jsrid;
	}

	public void setJsrid(String jsrid) {
		this.jsrid = jsrid;
	}

	@Override
	public String toString() {
		return "JdDhyj [id=" + id + ", fsrxm=" + fsrxm + ", jsrxm=" + jsrxm
				+ ", fssj=" + fssj + ", fsnr=" + fsnr + ", bz=" + bz + "]";
	}
}