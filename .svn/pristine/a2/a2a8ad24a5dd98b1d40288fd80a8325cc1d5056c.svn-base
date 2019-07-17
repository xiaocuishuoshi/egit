package com.whfp.oa.manager.cj.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "cj_detile")
public class CjDetile {
	private String id;
	/**
	 * 可抽奖人员
	 */
	
	private String cjtitle;
	
	private String cjry;
	/**
	 * 发布人员
	 */
	private String fbry;
	
	/**
	 * 发布人数
	 */
	private int fbrs;
	
	/**
	 * 描述
	 */
	private String ms;
	
	/**
	 * 发布日期
	 */
	private Timestamp rbrq;
	
	/**
	 * 是否生效
	 */
	private String sfsx;
	
	
	/**
	 * 一等奖人数
	 */
	private int ydjrs;
	private int edjrs;
	private int sdjrs;
	private int qtjrs;
	
	
	/**
	 * 一等奖奖品
	 */
	private String ydjjp;
	private String edjjp;
	private String sdjjp;
	private String qtjjp;
	
	private int ydjsy;
	private int edjsy;
	private int sdjsy;
	private int qtjsy;
	
	
	public CjDetile(){
		
	}


	public CjDetile(String cjtitle,String cjry, String fbry, int fbrs, String ms,
			Timestamp rbrq, String sfsx, int ydjrs, int edjrs, int sdjrs,
			int qtjrs, String ydjjp, String edjjp, String sdjjp, String qtjjp,int ydjsy,int edjsy,int sdjsy,int qtjsy) {
		super();
		this.cjtitle = cjtitle;
		this.cjry = cjry;
		this.fbry = fbry;
		this.fbrs = fbrs;
		this.ms = ms;
		this.rbrq = rbrq;
		this.sfsx = sfsx;
		this.ydjrs = ydjrs;
		this.edjrs = edjrs;
		this.sdjrs = sdjrs;
		this.qtjrs = qtjrs;
		this.ydjjp = ydjjp;
		this.edjjp = edjjp;
		this.sdjjp = sdjjp;
		this.qtjjp = qtjjp;
		this.ydjsy = ydjsy;
		this.edjsy = edjsy;
		this.sdjsy=sdjsy;
		this.qtjsy = qtjsy;
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
	
	@Column(name = "cjtitle", nullable = true)
	public String getCjtitle() {
		return cjtitle;
	}


	public void setCjtitle(String cjtitle) {
		this.cjtitle = cjtitle;
	}


	@Column(name = "cjry", nullable = true)
	public String getCjry() {
		return cjry;
	}


	public void setCjry(String cjry) {
		this.cjry = cjry;
	}


	@Column(name = "fbry", nullable = false)
	public String getFbry() {
		return fbry;
	}


	public void setFbry(String fbry) {
		this.fbry = fbry;
	}

	@Column(name = "fbrs", nullable = false)
	public int getFbrs() {
		return fbrs;
	}


	public void setFbrs(int fbrs) {
		this.fbrs = fbrs;
	}

	@Column(name = "ms", nullable = true)
	public String getMs() {
		return ms;
	}


	public void setMs(String ms) {
		this.ms = ms;
	}

	@Column(name = "rbrq", nullable = false)
	public Timestamp getRbrq() {
		return rbrq;
	}


	public void setRbrq(Timestamp rbrq) {
		this.rbrq = rbrq;
	}

	@Column(name = "sfsx", nullable = true)
	public String getSfsx() {
		return sfsx;
	}


	public void setSfsx(String sfsx) {
		this.sfsx = sfsx;
	}

	@Column(name = "ydjrs", nullable = true)
	public int getYdjrs() {
		return ydjrs;
	}


	public void setYdjrs(int ydjrs) {
		this.ydjrs = ydjrs;
	}

	@Column(name = "edjrs", nullable = true)
	public int getEdjrs() {
		return edjrs;
	}


	public void setEdjrs(int edjrs) {
		this.edjrs = edjrs;
	}

	@Column(name = "sdjrs", nullable = true)
	public int getSdjrs() {
		return sdjrs;
	}


	public void setSdjrs(int sdjrs) {
		this.sdjrs = sdjrs;
	}
	
	@Column(name = "qtjrs", nullable = true)
	public int getQtjrs() {
		return qtjrs;
	}


	public void setQtjrs(int qtjrs) {
		this.qtjrs = qtjrs;
	}

	@Column(name = "ydjjp", nullable = true)
	public String getYdjjp() {
		return ydjjp;
	}


	public void setYdjjp(String ydjjp) {
		this.ydjjp = ydjjp;
	}

	@Column(name = "edjjp", nullable = true)
	public String getEdjjp() {
		return edjjp;
	}


	public void setEdjjp(String edjjp) {
		this.edjjp = edjjp;
	}

	@Column(name = "sdjjp", nullable = true)
	public String getSdjjp() {
		return sdjjp;
	}


	public void setSdjjp(String sdjjp) {
		this.sdjjp = sdjjp;
	}

	@Column(name = "qtjjp", nullable = true)
	public String getQtjjp() {
		return qtjjp;
	}


	public void setQtjjp(String qtjjp) {
		this.qtjjp = qtjjp;
	}

	@Column(name = "ydjsy", nullable = true)
	public int getYdjsy() {
		return ydjsy;
	}


	public void setYdjsy(int ydjsy) {
		this.ydjsy = ydjsy;
	}

	@Column(name = "edjsy", nullable = true)
	public int getEdjsy() {
		return edjsy;
	}


	public void setEdjsy(int edjsy) {
		this.edjsy = edjsy;
	}

	@Column(name = "sdjsy", nullable = true)
	public int getSdjsy() {
		return sdjsy;
	}


	public void setSdjsy(int sdjsy) {
		this.sdjsy = sdjsy;
	}

	@Column(name = "qtjsy", nullable = true)
	public int getQtjsy() {
		return qtjsy;
	}


	public void setQtjsy(int qtjsy) {
		this.qtjsy = qtjsy;
	}


}
