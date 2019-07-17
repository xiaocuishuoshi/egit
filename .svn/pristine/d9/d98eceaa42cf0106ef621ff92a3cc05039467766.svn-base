package com.whfp.oa.manager.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "area_info")
public class Area_info implements java.io.Serializable {
	private String id;
	private String type;
	private String area;
	private String cell;
	private String sector;
	private String cellname;
	private String longitude;
	private String latitude;
	private String createtime;
	private String num;

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 20)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "type", length = 100)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "area", length = 300)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "cell", length = 100)
	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	@Column(name = "sector", length = 10)
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Column(name = "cellname", length = 200)
	public String getCellname() {
		return cellname;
	}

	public void setCellname(String cellname) {
		this.cellname = cellname;
	}

	@Column(name = "longitude", length = 20)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", length = 20)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "createtime", length = 30)
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Column(name = "num", length = 10)
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Area_info(String id, String type, String area, String cell,
			String sector, String cellname, String longitude, String latitude,
			String createtime, String num) {
		super();
		this.id = id;
		this.type = type;
		this.area = area;
		this.cell = cell;
		this.sector = sector;
		this.cellname = cellname;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createtime = createtime;
		this.num = num;
	}
	

	public Area_info(String type, String area, String cell, String sector,
			String cellname, String longitude, String latitude,
			String createtime, String num) {
		super();
		this.type = type;
		this.area = area;
		this.cell = cell;
		this.sector = sector;
		this.cellname = cellname;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createtime = createtime;
		this.num = num;
	}

	public Area_info() {
	}

	@Override
	public String toString() {
		return "Area_info [id=" + id + ", type=" + type + ", area=" + area
				+ ", cell=" + cell + ", sector=" + sector + ", cellname="
				+ cellname + ", longitude=" + longitude + ", latitude="
				+ latitude + ", createtime=" + createtime + ", num=" + num
				+ "]";
	}
	
	

}
