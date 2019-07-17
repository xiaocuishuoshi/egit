package com.whfp.oa.manager.jd.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * JdTzsmb entity. @author MyEclipse Persistence Tools
 * 通知书
 */
@Entity
@Table(name="jd_tzsmb")

public class JdTzsmb  implements java.io.Serializable {


    // Fields    

     private String id;
     private String tzsmc;//通知书标题
     private String tzsnr;//通知书内容
     private Timestamp cjsj;//创建时间
     private String cjry;//接收人
     private String gsdw;//隶属单位


    // Constructors

    /** default constructor */
    public JdTzsmb() {
    }

    
    /** full constructor */
    public JdTzsmb(String tzsmc, String tzsnr, Timestamp cjsj, String cjry, String gsdw) {
        this.tzsmc = tzsmc;
        this.tzsnr = tzsnr;
        this.cjsj = cjsj;
        this.cjry = cjry;
        this.gsdw = gsdw;
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
    
    @Column(name="tzsmc", length=100)

    public String getTzsmc() {
        return this.tzsmc;
    }
    
    public void setTzsmc(String tzsmc) {
        this.tzsmc = tzsmc;
    }
    
    @Column(name="tzsnr", length=65535)

    public String getTzsnr() {
        return this.tzsnr;
    }
    
    public void setTzsnr(String tzsnr) {
        this.tzsnr = tzsnr;
    }
    
    @Column(name="cjsj", length=19)

    public Timestamp getCjsj() {
        return this.cjsj;
    }
    
    public void setCjsj(Timestamp cjsj) {
        this.cjsj = cjsj;
    }
    
    @Column(name="cjry", length=100)

    public String getCjry() {
        return this.cjry;
    }
    
    public void setCjry(String cjry) {
        this.cjry = cjry;
    }
    
    @Column(name="gsdw", length=32)

    public String getGsdw() {
        return this.gsdw;
    }
    
    public void setGsdw(String gsdw) {
        this.gsdw = gsdw;
    }
   








}