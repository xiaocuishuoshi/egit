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
@Table(name="jd_knxx")
public class JdKnxx
  implements Serializable
{
  private String id;
  private String lat;
  private String lng;
  private String userid;
  private String username;
  private Timestamp kssj;
  private Timestamp jssj;
  private String bj;
  private String ydzt;
  private String address;
  private String gxbmid;
  
  public JdKnxx() {}
  
  public JdKnxx(String id, String lat, String lng, String userid, String username, Timestamp kssj, Timestamp jssj, String bj)
  {
    this.id = id;
    this.lat = lat;
    this.lng = lng;
    this.userid = userid;
    this.username = username;
    this.kssj = kssj;
    this.jssj = jssj;
    this.bj = bj;
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
  
  @Column(name="lat")
  public String getLat()
  {
    return this.lat;
  }
  
  public void setLat(String lat)
  {
    this.lat = lat;
  }
  
  @Column(name="lng")
  public String getLng()
  {
    return this.lng;
  }
  
  public void setLng(String lng)
  {
    this.lng = lng;
  }
  
  @Column(name="userid")
  public String getUserid()
  {
    return this.userid;
  }
  
  public void setUserid(String userid)
  {
    this.userid = userid;
  }
  
  @Column(name="username")
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  @Column(name="kssj")
  public Timestamp getKssj()
  {
    return this.kssj;
  }
  
  public void setKssj(Timestamp kssj)
  {
    this.kssj = kssj;
  }
  
  @Column(name="jssj")
  public Timestamp getJssj()
  {
    return this.jssj;
  }
  
  public void setJssj(Timestamp jssj)
  {
    this.jssj = jssj;
  }
  
  @Column(name="bj")
  public String getBj()
  {
    return this.bj;
  }
  
  public void setBj(String bj)
  {
    this.bj = bj;
  }
  
  @Column(name="ydzt")
  public String getYdzt()
  {
    return this.ydzt;
  }
  
  public void setYdzt(String ydzt)
  {
    this.ydzt = ydzt;
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
  
  @Column(name="gxbmid")
  public String getGxbmid()
  {
    return this.gxbmid;
  }
  
  public void setGxbmid(String gxbmid)
  {
    this.gxbmid = gxbmid;
  }
  
  @Override
public String toString()
  {
    return 
    
      "JdKnxx [id=" + this.id + ", lat=" + this.lat + ", lng=" + this.lng + ", userid=" + this.userid + ", username=" + this.username + ", kssj=" + this.kssj + ", jssj=" + this.jssj + ", bj=" + this.bj + "]";
  }
}
