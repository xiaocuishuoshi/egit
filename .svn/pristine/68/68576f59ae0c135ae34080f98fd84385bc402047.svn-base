package com.whfp.oa.manager.jd.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.whfp.oa.commons.util.EncodeUtils;

@Entity
@Table(name="jd_pzxx")
public class JdPzxx
  implements Serializable
{
  private String id;
  private String zpdz;
  private String pzsj;
  private String pzry;
  private String pzryxm;
  private String deptId;
  private String address;
  private String lng;
  private String lan;
  
  public JdPzxx() {}
  
  public JdPzxx(String pzry, String zpdz, String pzsj, String pzryxm, String deptId)
  {
    this.pzry = pzry;
    this.zpdz = zpdz;
    this.pzsj = pzsj;
    this.pzryxm = pzryxm;
    this.deptId = deptId;
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
  
  @Column(name="zpdz", nullable=true, length=100)
  public String getZpdz()
  {
    return this.zpdz;
  }
  
  public void setZpdz(String zpdz)
  {
    this.zpdz = zpdz;
  }
  
  @Column(name="pzsj", nullable=true, length=30)
  public String getPzsj()
  {
    return this.pzsj;
  }
  
  public void setPzsj(String pzsj)
  {
    this.pzsj = pzsj;
  }
  
  @Column(name="pzry", nullable=true, length=50)
  public String getPzry()
  {
    return this.pzry;
  }
  
  public void setPzry(String pzry)
  {
    this.pzry = pzry;
  }
  
  @Column(name="pzryxm", nullable=true, length=50)
  public String getPzryxm()
  {
    return this.pzryxm;
  }
  
  public void setPzryxm(String pzryxm)
  {
    this.pzryxm = pzryxm;
  }
  
  @Column(name="deptId", nullable=true, length=50)
  public String getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(String deptId)
  {
    this.deptId = deptId;
  }
  
  @Column(name="address")
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  @Column(name="lng")
  public String getLng()
  {
	  if(this.lng==null)
		  this.lng="0";
    return EncodeUtils.formatDouble(Double.parseDouble(this.lng));
  }
  
  public void setLng(String lng)
  {
    this.lng = lng;
  }
  
  @Column(name="lan")
  public String getLan()
  {
	  if(this.lan==null)
		  this.lan="0";
    return EncodeUtils.formatDouble(Double.parseDouble(this.lan));
  }
  
  public void setLan(String lan)
  {
    this.lan = lan;
  }
}
