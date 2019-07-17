package com.whfp.oa.manager.rssq.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "rssq_jzsq")
public class RssqJzsq {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="申请人不能为空")
	private String sqr;
	/**
	 * 日程主题
	 */
	
	private Timestamp sqrq;	
	
	private String sqje;
	
	private String sqsy;
	
	private String ssbm;
	
	private String rshcyj;
	
	private String rszgfh;
	
	private String gsldpf;
	
	private String sqhf;
	public RssqJzsq(){
		
	}

	public RssqJzsq(String id, String sqr, Timestamp sqrq, String sqje,
			String sqsy, String ssbm, String rshcyj, String rszgfh,
			String gsldpf, String sqhf) {
		super();
		this.id = id;
		this.sqr = sqr;
		this.sqrq = sqrq;
		this.sqje = sqje;
		this.sqsy = sqsy;
		this.ssbm = ssbm;
		this.rshcyj = rshcyj;
		this.rszgfh = rszgfh;
		this.gsldpf = gsldpf;
		this.sqhf = sqhf;
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
	
	@Column(name = "sqr", nullable = false)
	public String getSqr() {
		return sqr;
	}


	public void setSqr(String sqr) {
		this.sqr = sqr;
	}


	@Column(name = "sqrq", nullable = true)
	public Timestamp getSqrq() {
		return sqrq;
	}


	public void setSqrq(Timestamp sqrq) {
		this.sqrq = sqrq;
	}

	@Column(name = "sqje", nullable = true)
	public String getSqje() {
		return sqje;
	}

	public void setSqje(String sqje) {
		this.sqje = sqje;
	}

	@Column(name = "sqsy", nullable = true)
	public String getSqsy() {
		return sqsy;
	}
	
	public void setSqsy(String sqsy) {
		this.sqsy = sqsy;
	}
	
	@Column(name = "ssbm", nullable = true)
	public String getSsbm() {
		return ssbm;
	}

	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}

	@Column(name = "rshcyj", nullable = true)
	public String getRshcyj() {
		return rshcyj;
	}

	public void setRshcyj(String rshcyj) {
		this.rshcyj = rshcyj;
	}

	@Column(name = "rszgfh", nullable = true)
	public String getRszgfh() {
		return rszgfh;
	}

	public void setRszgfh(String rszgfh) {
		this.rszgfh = rszgfh;
	}

	@Column(name = "gsldpf", nullable = true)
	public String getGsldpf() {
		return gsldpf;
	}

	public void setGsldpf(String gsldpf) {
		this.gsldpf = gsldpf;
	}

	@Column(name = "sqhf", nullable = true)
	public String getSqhf() {
		return sqhf;
	}


	public void setSqhf(String sqhf) {
		this.sqhf = sqhf;
	}



}
