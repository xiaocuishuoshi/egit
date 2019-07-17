package com.whfp.oa.manager.jd.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="jd_Jdktv")
public class JdJdKtv
  implements Serializable
{
  private String id;
  private String name;
  private String lat;
  private String lng;
  private String address;
  private String telephone;
  private String uid;
  
  public JdJdKtv() {}
  
  public JdJdKtv(String id, String name, String lat, String lng, String address, String telephone, String uid)
  {
    this.id = id;
    this.name = name;
    this.lat = lat;
    this.lng = lng;
    this.address = address;
    this.telephone = telephone;
    this.uid = uid;
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
  
  @Column(name="name")
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
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
  
  @Column(name="address")
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  @Column(name="telephone")
  public String getTelephone()
  {
    return this.telephone;
  }
  
  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }
  
  @Column(name="uid")
  public String getUid()
  {
    return this.uid;
  }
  
  public void setUid(String uid)
  {
    this.uid = uid;
  }
  
  @Override
public String toString()
  {
    return 
    
      "JdJdKtv [id=" + this.id + ", name=" + this.name + ", lat=" + this.lat + ", lng=" + this.lng + ", address=" + this.address + ", telephone=" + this.telephone + ", uid=" + this.uid + "]";
  }
}
