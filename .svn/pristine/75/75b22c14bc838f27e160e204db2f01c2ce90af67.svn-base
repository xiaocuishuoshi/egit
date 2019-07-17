package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * JdTzs entity. @author MyEclipse Persistence Tools
 * 戒毒宣传实体类
 * 
 */
@Entity
@Table(name="jd_jdxc")

public class JdXc  implements java.io.Serializable {


    // Fields    

     private String id;
     private String title;
     private String nr;
     private String fbsj;
     private String bmid;
     private String ryid;
     private String ryxm;
     private String ydzt;

    // Constructors

    /** default constructor */
    public JdXc() {
    }
    public JdXc(String id, String title, String nr, String fbsj,
			String bmid, String ryid) {
		super();
		this.id = id;
		this.title = title;
		this.nr = nr;
		this.fbsj = fbsj;
		this.bmid = bmid;
		this.ryid = ryid;
	}




	// Property accessors
    @GenericGenerator(name="generator", strategy="uuid.hex")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    @Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    @Column(name="nr")
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	 @Column(name="fbsj")
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	  @Column(name="bmid")
	  public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	  @Column(name="ryid")
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	
	  @Column(name="ryxm")
	public String getRyxm() {
		return ryxm;
	}
	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}
	
	  @Column(name="ydzt")
	public String getYdzt() {
		return ydzt;
	}
	public void setYdzt(String ydzt) {
		this.ydzt = ydzt;
	}
	@Override
	public String toString() {
		return "JdXc [id=" + id + ", title=" + title + ", nr=" + nr + ", fbsj="
				+ fbsj + ", bmid=" + bmid + ", ryid=" + ryid + "]";
	}
    
    
}