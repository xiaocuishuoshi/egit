package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * JdTzs entity. @author MyEclipse Persistence Tools
 * 法律法规实体类
 * 
 */
@Entity
@Table(name="jd_flfg")

public class JdFlfg  implements java.io.Serializable {


    // Fields    

     private String id;
     private String title;
     private String nr;
     private String fbsj;
     private String ryxm;
     private String bmid;
     private String ydzt;
     
    // Constructors

    /** default constructor */
    public JdFlfg() {
    }
	public JdFlfg(String id, String title, String nr, String fbsj,
			String ryxm) {
		super();
		this.id = id;
		this.title = title;
		this.nr = nr;
		this.fbsj = fbsj;
		this.ryxm = ryxm;
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
	
	  @Column(name="ryxm")
	public String getRyxm() {
		return ryxm;
	}
	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}
	
	  @Column(name="bmid")
		public String getBmid() {
			return bmid;
		}
		public void setBmid(String bmid) {
			this.bmid = bmid;
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
		return "JdFlfg [id=" + id + ", title=" + title + ", nr=" + nr
				+ ", fbsj=" + fbsj + ", ryxm=" + ryxm + "]";
	}
	
}