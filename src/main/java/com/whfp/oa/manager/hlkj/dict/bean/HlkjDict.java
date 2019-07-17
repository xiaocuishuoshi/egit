package com.whfp.oa.manager.hlkj.dict.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hlkj_dict")
public class HlkjDict {
	private String id;
	/**
	 * 所属用户id
	 */
	private String flmc;
	
	private String flpx;
	
	private String fllb;
	
	private String fllbmc;
	
	
	
	
	
	public HlkjDict(){
		
	}
	

	public HlkjDict(String id, String flmc, String flpx, String fllb,
			String fllbmc) {
		super();
		this.id = id;
		this.flmc = flmc;
		this.flpx = flpx;
		this.fllb = fllb;
		this.fllbmc = fllbmc;
	}


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

	@Column(name = "flmc", nullable = false)
	public String getFlmc() {
		return flmc;
	}


	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}

	@Column(name = "flpx", nullable = true)
	public String getFlpx() {
		return flpx;
	}


	public void setFlpx(String flpx) {
		this.flpx = flpx;
	}
	
	@Column(name = "fllb", nullable = true)
	public String getFllb() {
		return fllb;
	}


	public void setFllb(String fllb) {
		this.fllb = fllb;
	}

	@Column(name = "fllbmc", nullable = true)
	public String getFllbmc() {
		return fllbmc;
	}


	public void setFllbmc(String fllbmc) {
		this.fllbmc = fllbmc;
	}
	
	

	
	
}
