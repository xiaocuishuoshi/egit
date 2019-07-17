package com.whfp.oa.manager.jd.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="jd_tzs")
public class JdTzs
  implements Serializable
{
  private String id;
  private String tzsmc;
  private String tzsxfsj;
  private Timestamp tzsjssj;
  private String tzsnr;
  private String tzsjsrid;
  private String tzsjsrxm;
  private String tzsydzt;
  private String tzshfbz;
  private String tzshfnr;
  private String tzshfsj;
  private String tzszt;
  private String gxbmid;
  private String fsrxm;
  private Timestamp qrsj;
  private String flag;
  private String bz;
  private String zpdz;
  
  public JdTzs() {}
  
  public JdTzs(String tzsmc, String tzsxfsj, Timestamp tzsjssj, String tzsnr, String tzsjsrid, String tzsjsrxm, String tzsydzt, String tzshfbz, String tzshfnr, String tzshfsj, String tzszt, String gxbmid)
  {
    this.tzsmc = tzsmc;
    this.tzsxfsj = tzsxfsj;
    this.tzsjssj = tzsjssj;
    this.tzsnr = tzsnr;
    this.tzsjsrid = tzsjsrid;
    this.tzsjsrxm = tzsjsrxm;
    this.tzsydzt = tzsydzt;
    this.tzshfbz = tzshfbz;
    this.tzshfnr = tzshfnr;
    this.tzshfsj = tzshfsj;
    this.tzszt = tzszt;
    this.gxbmid = gxbmid;
  }
  
  @GenericGenerator(name="generator", strategy="uuid.hex")
  @Id
  @GeneratedValue(generator="generator")
  @Column(name="id", unique=true, nullable=false, length=32)
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  @Column(name="tzsmc", length=100)
  public String getTzsmc()
  {
    return this.tzsmc;
  }
  
  public void setTzsmc(String tzsmc)
  {
    this.tzsmc = tzsmc;
  }
  
  @Column(name="tzsxfsj", length=19)
  public String getTzsxfsj()
  {
    return this.tzsxfsj;
  }
  
  public void setTzsxfsj(String tzsxfsj)
  {
    this.tzsxfsj = tzsxfsj;
  }
  
  @Column(name="tzsjssj", length=19)
  public Timestamp getTzsjssj()
  {
    return this.tzsjssj;
  }
  
  public void setTzsjssj(Timestamp tzsjssj)
  {
    this.tzsjssj = tzsjssj;
  }
  
  @Column(name="tzsnr", length=65535)
  public String getTzsnr()
  {
    return this.tzsnr;
  }
  
  public void setTzsnr(String tzsnr)
  {
    this.tzsnr = tzsnr;
  }
  
  @Column(name="tzsjsrid", length=32)
  public String getTzsjsrid()
  {
    return this.tzsjsrid;
  }
  
  public void setTzsjsrid(String tzsjsrid)
  {
    this.tzsjsrid = tzsjsrid;
  }
  
  @Column(name="tzsjsrxm", length=100)
  public String getTzsjsrxm()
  {
    return this.tzsjsrxm;
  }
  
  public void setTzsjsrxm(String tzsjsrxm)
  {
    this.tzsjsrxm = tzsjsrxm;
  }
  
  @Column(name="tzsydzt", length=4)
  public String getTzsydzt()
  {
    return this.tzsydzt;
  }
  
  public void setTzsydzt(String tzsydzt)
  {
    this.tzsydzt = tzsydzt;
  }
  
  @Column(name="tzshfbz", length=4)
  public String getTzshfbz()
  {
    return this.tzshfbz;
  }
  
  public void setTzshfbz(String tzshfbz)
  {
    this.tzshfbz = tzshfbz;
  }
  
  @Column(name="tzshfnr", length=65535)
  public String getTzshfnr()
  {
    return this.tzshfnr;
  }
  
  public void setTzshfnr(String tzshfnr)
  {
    this.tzshfnr = tzshfnr;
  }
  
  @Column(name="tzshfsj", length=19)
  public String getTzshfsj()
  {
    return this.tzshfsj;
  }
  
  public void setTzshfsj(String tzshfsj)
  {
    this.tzshfsj = tzshfsj;
  }
  
  @Column(name="tzszt", length=4)
  public String getTzszt()
  {
    return this.tzszt;
  }
  
  public void setTzszt(String tzszt)
  {
    this.tzszt = tzszt;
  }
  
  @Column(name="gxbmid", length=32)
  public String getGxbmid()
  {
    return this.gxbmid;
  }
  
  public void setGxbmid(String gxbmid)
  {
    this.gxbmid = gxbmid;
  }
  
  @Column(name="fsrxm")
  public String getFsrxm()
  {
    return this.fsrxm;
  }
  
  public void setFsrxm(String fsrxm)
  {
    this.fsrxm = fsrxm;
  }
  
  @Column(name="qrsj")
  public Timestamp getQrsj()
  {
    return this.qrsj;
  }
  
  public void setQrsj(Timestamp qrsj)
  {
    this.qrsj = qrsj;
  }
  
  @Column(name="flag")
  public String getFlag()
  {
    return this.flag;
  }
  
  public void setFlag(String flag)
  {
    this.flag = flag;
  }
  
  @Column(name="bz")
  public String getBz()
  {
    return this.bz;
  }
  
  public void setBz(String bz)
  {
    this.bz = bz;
  }
  
  @Column(name="zpdz")
  public String getZpdz()
  {
    return this.zpdz;
  }
  
  public void setZpdz(String zpdz)
  {
    this.zpdz = zpdz;
  }
  
  @Override
public String toString()
  {
    return 
    



      "JdTzs [gxbmid=" + this.gxbmid + ", id=" + this.id + ", tzshfbz=" + this.tzshfbz + ", tzshfnr=" + this.tzshfnr + ", tzshfsj=" + this.tzshfsj + ", tzsjsrid=" + this.tzsjsrid + ", tzsjsrxm=" + this.tzsjsrxm + ", tzsjssj=" + this.tzsjssj + ", tzsmc=" + this.tzsmc + ", tzsnr=" + this.tzsnr + ", tzsxfsj=" + this.tzsxfsj + ", tzsydzt=" + this.tzsydzt + ", tzszt=" + this.tzszt + "]";
  }
}
