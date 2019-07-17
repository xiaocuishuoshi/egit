package com.whfp.oa.manager.jd.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JdRyb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jd_ryb")
public class JdRyb implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 853428595012847524L;
	private String id;
	private String jdRyid;
	private String jdRybh;
	private String jdRyxm;
	private String fkDeptId;
	private String jdRysg;
	private String jdRyxb;
	private String jdJgry;
	private String jdDwdh;
	private String jdRyjg;
	private String jdHjd;
	private String jdHjxxdz;
	private String jdHjdpcs;
	private String jdHklx;
	private String jdHyzk;
	private String jdWhcd;
	private String jdLxfs;
	private String jdJzd;
	private String jdJzdz;
	private String jdJzdpcs;
	private String jdMz;
	private String jdZjxy;
	private String jdZjzl;
	private String jdSfzh;
	private String jdCsrq;
	private String jdCym;
	private String jdZzmm;
	public String jdZy;
	private String jdTscs;
	private String jdLydpzl;
	private String jdChdw;
	private String jdChrq;
	private String jdDqgkxz;
	private String jdDqgkdq;
	private String jdRyxp;
	private Date jdCjsj;
	private String jdXxly;
	private String dqwz;
	private String dqwzsj;
	private String jdHdqy; 
	private String jdScbz;
	private String jdSfyj; 
	private String jdSjid;
	private Integer jdRylb;
	private Integer jdJb;
	private Integer jdWghxh;
	private String jdWgy;
	private String jdWgsssq;
 
	//加统计
	//亲属关系
	private Integer relationshipNum;
	
	//工作经历
	@Column(name="work_num")
	private Integer workNum;
	
	//相关附件
	@Column(name="file_num")
	private Integer fileNum;
	
	//戒毒工作小组成员
	@Column(name="concact_num")
	private Integer concactNum;
	
	/** default constructor */
	public JdRyb() {
	}

	public JdRyb(String jdRyid,String jdRybh, String jdRyxm, String fkDeptId, String jdRysg,
			String jdRyxb, String jdJgry, String jdDwdh, String jdRyjg,
			String jdHjd, String jdHjxxdz, String jdHjdpcs, String jdHklx,
			String jdHyzk, String jdWhcd, String jdLxfs, String jdJzd,
			String jdJzdz, String jdJzdpcs, String jdMz, String jdZjxy,
			String jdZjzl, String jdSfzh, String jdCsrq, String jdCym,
			String jdZzmm, String jdZy, String jdTscs, String jdLydpzl,
			String jdChdw, String jdChrq, String jdDqgkxz, String jdDqgkdq,
			String jdRyxp, Date jdCjsj, String jdXxly,String dqwz,String dqwzsj,
			String jdHdqy,String jdScbz,String jdSfyj,String jdSjid,Integer jdRylb,Integer jdJb
			,Integer jdWghxh,String jdWgy,String jdWgsssq) { 
		super();
		this.jdRyid=jdRyid;
		this.jdRybh = jdRybh;
		this.jdRyxm = jdRyxm; 
		this.fkDeptId = fkDeptId;
		this.jdRysg = jdRysg;
		this.jdRyxb = jdRyxb;
		this.jdJgry = jdJgry;
		this.jdDwdh = jdDwdh;
		this.jdRyjg = jdRyjg;
		this.jdHjd = jdHjd;
		this.jdHjxxdz = jdHjxxdz;
		this.jdHjdpcs = jdHjdpcs;
		this.jdHklx = jdHklx;
		this.jdHyzk = jdHyzk;
		this.jdWhcd = jdWhcd;
		this.jdLxfs = jdLxfs;
		this.jdJzd = jdJzd;
		this.jdJzdz = jdJzdz;
		this.jdJzdpcs = jdJzdpcs;
		this.jdMz = jdMz;
		this.jdZjxy = jdZjxy;
		this.jdZjzl = jdZjzl;
		this.jdSfzh = jdSfzh;
		this.jdCsrq = jdCsrq;
		this.jdCym = jdCym;
		this.jdZzmm = jdZzmm;
		this.jdZy = jdZy;
		this.jdTscs = jdTscs;
		this.jdLydpzl = jdLydpzl;
		this.jdChdw = jdChdw;
		this.jdChrq = jdChrq;
		this.jdDqgkxz = jdDqgkxz;
		this.jdDqgkdq = jdDqgkdq;
		this.jdRyxp = jdRyxp;
		this.jdCjsj = jdCjsj;
		this.jdXxly = jdXxly;
		this.dqwz=dqwz;
		this.dqwzsj=dqwzsj;
		this.jdHdqy=jdHdqy;
		this.jdScbz=jdScbz;
		this.jdSfyj=jdSfyj;
		this.jdSjid=jdSjid;
		this.jdRylb=jdRylb;
		this.jdJb=jdJb;
		this.jdWghxh=jdWghxh;
		this.jdWgsssq=jdWgsssq;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "jd_rybh", length = 100)
	public String getJdRybh() {
		return this.jdRybh;
	}

	public void setJdRybh(String jdRybh) {
		this.jdRybh = jdRybh;
	}

	@Column(name = "jd_ryxm", length = 100)
	public String getJdRyxm() {
		return this.jdRyxm;
	}

	public void setJdRyxm(String jdRyxm) {
		this.jdRyxm = jdRyxm;
	}

	@Column(name = "fk_dept_id", length = 100)
	public String getFkDeptId() {
		return this.fkDeptId;
	}

	public void setFkDeptId(String fkDeptId) {
		this.fkDeptId = fkDeptId;
	}

	@Column(name = "jd_rysg", length = 50)
	public String getJdRysg() {
		return this.jdRysg;
	}

	public void setJdRysg(String jdRysg) {
		this.jdRysg = jdRysg;
	}

	@Column(name = "jd_ryxb", length = 50)
	public String getJdRyxb() {
		return this.jdRyxb;
	}

	public void setJdRyxb(String jdRyxb) {
		this.jdRyxb = jdRyxb;
	}

	@Column(name = "jd_jgry", length = 50)
	public String getJdJgry() {
		return this.jdJgry;
	}

	public void setJdJgry(String jdJgry) {
		this.jdJgry = jdJgry;
	}

	@Column(name = "jd_dwdh", length = 50)
	public String getJdDwdh() {
		return this.jdDwdh;
	}

	public void setJdDwdh(String jdDwdh) {
		this.jdDwdh = jdDwdh;
	}

	@Column(name = "jd_ryjg", length = 50)
	public String getJdRyjg() {
		return this.jdRyjg;
	}

	public void setJdRyjg(String jdRyjg) {
		this.jdRyjg = jdRyjg;
	}

	@Column(name = "jd_hjd", length = 100)
	public String getJdHjd() {
		return this.jdHjd;
	}

	public void setJdHjd(String jdHjd) {
		this.jdHjd = jdHjd;
	}

	@Column(name = "jd_hjxxdz", length = 100)
	public String getJdHjxxdz() {
		return this.jdHjxxdz;
	}

	public void setJdHjxxdz(String jdHjxxdz) {
		this.jdHjxxdz = jdHjxxdz;
	}

	@Column(name = "jd_hjdpcs", length = 100)
	public String getJdHjdpcs() {
		return this.jdHjdpcs;
	}

	public void setJdHjdpcs(String jdHjdpcs) {
		this.jdHjdpcs = jdHjdpcs;
	}

	@Column(name = "jd_hklx", length = 50)
	public String getJdHklx() {
		return this.jdHklx;
	}

	public void setJdHklx(String jdHklx) {
		this.jdHklx = jdHklx;
	}

	@Column(name = "jd_hyzk", length = 50)
	public String getJdHyzk() {
		return this.jdHyzk;
	}

	public void setJdHyzk(String jdHyzk) {
		this.jdHyzk = jdHyzk;
	}

	@Column(name = "jd_whcd", length = 50)
	public String getJdWhcd() {
		return this.jdWhcd;
	}

	public void setJdWhcd(String jdWhcd) {
		this.jdWhcd = jdWhcd;
	}

	@Column(name = "jd_lxfs", length = 50)
	public String getJdLxfs() {
		return this.jdLxfs;
	}

	public void setJdLxfs(String jdLxfs) {
		this.jdLxfs = jdLxfs;
	}

	@Column(name = "jd_jzd", length = 100)
	public String getJdJzd() {
		return this.jdJzd;
	}

	public void setJdJzd(String jdJzd) {
		this.jdJzd = jdJzd;
	}

	@Column(name = "jd_jzdz", length = 100)
	public String getJdJzdz() {
		return this.jdJzdz;
	}

	public void setJdJzdz(String jdJzdz) {
		this.jdJzdz = jdJzdz;
	}

	@Column(name = "jd_jzdpcs", length = 100)
	public String getJdJzdpcs() {
		return this.jdJzdpcs;
	}

	public void setJdJzdpcs(String jdJzdpcs) {
		this.jdJzdpcs = jdJzdpcs;
	}

	@Column(name = "jd_mz", length = 50)
	public String getJdMz() {
		return this.jdMz;
	}

	public void setJdMz(String jdMz) {
		this.jdMz = jdMz;
	}

	@Column(name = "jd_zjxy", length = 50)
	public String getJdZjxy() {
		return this.jdZjxy;
	}

	public void setJdZjxy(String jdZjxy) {
		this.jdZjxy = jdZjxy;
	}

	@Column(name = "jd_zjzl", length = 50)
	public String getJdZjzl() {
		return this.jdZjzl;
	}

	public void setJdZjzl(String jdZjzl) {
		this.jdZjzl = jdZjzl;
	}

	@Column(name = "jd_sfzh", length = 50)
	public String getJdSfzh() {
		return this.jdSfzh;
	}

	public void setJdSfzh(String jdSfzh) {
		this.jdSfzh = jdSfzh;
	}

	@Column(name = "jd_csrq", length = 50)
	public String getJdCsrq() {
		return this.jdCsrq;
	}

	public void setJdCsrq(String jdCsrq) {
		this.jdCsrq = jdCsrq;
	}

	@Column(name = "jd_cym", length = 50)
	public String getJdCym() {
		return this.jdCym;
	}

	public void setJdCym(String jdCym) {
		this.jdCym = jdCym;
	}


	@Column(name = "jd_zzmm", length = 100)
	public String getJdZzmm() {
		return this.jdZzmm;
	}

	public void setJdZzmm(String jdZzmm) {
		this.jdZzmm = jdZzmm;
	}

	@Column(name = "jd_zy", length = 50)
	public String getJdZy() {
		return this.jdZy;
	}

	public void setJdZy(String jdZy) {
		this.jdZy = jdZy;
	}

	@Column(name = "jd_tscs", length = 10)
	public String getJdTscs() {
		return this.jdTscs;
	}

	public void setJdTscs(String jdTscs) {
		this.jdTscs = jdTscs;
	}

	@Column(name = "jd_lydpzl", length = 200)
	public String getJdLydpzl() {
		return this.jdLydpzl;
	}

	public void setJdLydpzl(String jdLydpzl) {
		this.jdLydpzl = jdLydpzl;
	}

	@Column(name = "jd_chdw", length = 100)
	public String getJdChdw() {
		return this.jdChdw;
	}

	public void setJdChdw(String jdChdw) {
		this.jdChdw = jdChdw;
	}

	@Column(name = "jd_chrq", length = 50)
	public String getJdChrq() {
		return this.jdChrq;
	}

	public void setJdChrq(String jdChrq) {
		this.jdChrq = jdChrq;
	}

	@Column(name = "jd_dqgkxz", length = 100)
	public String getJdDqgkxz() {
		return this.jdDqgkxz;
	}

	public void setJdDqgkxz(String jdDqgkxz) {
		this.jdDqgkxz = jdDqgkxz;
	}

	@Column(name = "jd_dqgkdq", length = 100)
	public String getJdDqgkdq() {
		return this.jdDqgkdq;
	}

	public void setJdDqgkdq(String jdDqgkdq) {
		this.jdDqgkdq = jdDqgkdq;
	}

	@Column(name = "jd_ryxp", length = 200)
	public String getJdRyxp() {
		return this.jdRyxp;
	}

	public void setJdRyxp(String jdRyxp) {
		this.jdRyxp = jdRyxp;
	}
 
	@Column(name = "jd_cjsj", length = 10)
	public Date getJdCjsj() {
		return this.jdCjsj;
	}

	public void setJdCjsj(Date jdCjsj) {
		this.jdCjsj = jdCjsj;
	}

	@Column(name = "jd_xxly", length = 20)
	public String getJdXxly() {
		return this.jdXxly;
	}

	public void setJdXxly(String jdXxly) {
		this.jdXxly = jdXxly;
	}
	@Column(name = "jd_dqwz", length =100) 
	public String getDqwz() {
		return dqwz;
	}

	public void setDqwz(String dqwz) {
		this.dqwz = dqwz;
	}
	@Column(name = "jd_dqwzsj") 
	public String getDqwzsj() {
		return dqwzsj;
	}

	public void setDqwzsj(String dqwzsj) {
		this.dqwzsj = dqwzsj;
	}
	@Column(name = "jd_hdqy") 
	public String getJdHdqy() {
		return jdHdqy;
	}

	public void setJdHdqy(String jdHdqy) {
		this.jdHdqy = jdHdqy;
	}

	@Column(name = "jd_ryid") 
	public String getJdRyid() {
		return jdRyid;
	}

	public void setJdRyid(String jdRyid) {
		this.jdRyid = jdRyid;
	}

	@Column(name = "jd_scbz") 
	public String getJdScbz() {
		return jdScbz;
	}

	public void setJdScbz(String jdScbz) {
		this.jdScbz = jdScbz;
	}
	@Column(name = "jd_sfyj")
	public String getJdSfyj() {
		return jdSfyj;
	}

	public void setJdSfyj(String jdSfyj) {
		this.jdSfyj = jdSfyj;
	}
	@Column(name = "jd_sjid")
	public String getJdSjid() {
		return jdSjid;
	}

	public void setJdSjid(String jdSjid) {
		this.jdSjid = jdSjid;
	}
	
	
	@Column(name = "jd_rylb")
	public Integer getJdRylb() {
		return jdRylb;
	}

	public void setJdRylb(Integer jdRylb) {
		this.jdRylb = jdRylb;
	}
	  
	
	@Column(name = "jd_jb")
	public Integer getJdJb() {
		return jdJb;
	}

	public void setJdJb(Integer jdJb) {
		this.jdJb = jdJb;
	}
	
	
	@Column(name = "jd_wghxh")
	public Integer getJdWghxh() {
		return jdWghxh;
	}

	public void setJdWghxh(Integer jdWghxh) {
		this.jdWghxh = jdWghxh;
	}
	
	@Column(name = "jd_wgy")
	public String getJdWgy() {
		return jdWgy;
	}

	public void setJdWgy(String jdWgy) {
		this.jdWgy = jdWgy;
	}
	

	@Column(name = "jd_wgsssq")
	public String getJdWgsssq() {
		return jdWgsssq;
	}

	public void setJdWgsssq(String jdWgsssq) {
		this.jdWgsssq = jdWgsssq;
	}
	
	@Column(name="relationship_num")
	public Integer getRelationshipNum() {
		return relationshipNum;
	}

	public void setRelationshipNum(Integer relationshipNum) {
		this.relationshipNum = relationshipNum;
	}

	@Column(name="work_num")
	public Integer getWorkNum() {
		return workNum;
	}

	public void setWorkNum(Integer workNum) {
		this.workNum = workNum;
	}
	
	@Column(name="file_num")
	public Integer getFileNum() {
		return fileNum;
	}

	public void setFileNum(Integer fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name="concact_num")
	public Integer getConcactNum() {
		return concactNum;
	}

	public void setConcactNum(Integer concactNum) {
		this.concactNum = concactNum;
	}

	@Override
	public String toString() {
		return "JdRyb [fkDeptId=" + fkDeptId + ", id=" + id + ", jdChdw="
				+ jdChdw + ", jdChrq=" + jdChrq + ", jdCjsj=" + jdCjsj
				+ ", jdCsrq=" + jdCsrq + ", jdCym=" + jdCym + ", jdDqgkdq="
				+ jdDqgkdq + ", jdDqgkxz=" + jdDqgkxz + ", jdDwdh=" + jdDwdh
				+ ", jdHjd=" + jdHjd + ", jdHjdpcs=" + jdHjdpcs + ", jdHjdz="
				  + ", jdHjxxdz=" + jdHjxxdz + ", jdHklx=" + jdHklx
				+ ", jdHyzk=" + jdHyzk + ", jdJgry=" + jdJgry + ", jdJzd="
				+ jdJzd + ", jdJzdpcs=" + jdJzdpcs + ", jdJzdz=" + jdJzdz
				+ ", jdLxfs=" + jdLxfs + ", jdLydpzl=" + jdLydpzl + ", jdMz="
				+ jdMz + ", jdRybh=" + jdRybh + ", jdRyjg=" + jdRyjg
				+ ", jdRysg=" + jdRysg + ", jdRyxb=" + jdRyxb + ", jdRyxm="
				+ jdRyxm + ", jdRyxp=" + jdRyxp + ", jdSfzh=" + jdSfzh
				+ ", jdTscs=" + jdTscs + ", jdWhcd=" + jdWhcd + ", jdXxly="
				+ jdXxly + ", jdZjxy=" + jdZjxy + ", jdZjzl=" + jdZjzl
				+ ", jdZy=" + jdZy + ",  jdSfyj="+ jdSfyj + ", jdScbz=" + jdScbz + ", jdRyid="
				+ jdRyid + ", jdHdqy=" + jdHdqy + ", dqwzsj=" + dqwzsj + ", dqwz=" + dqwz + "]";
	}

}