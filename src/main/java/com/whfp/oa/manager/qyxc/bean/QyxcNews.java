package com.whfp.oa.manager.qyxc.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "qyxc_news")
public class QyxcNews {
	private String id;
	/**
	 * 所属用户id
	 */
	@NotBlank(message="新闻标题不能为空")
	private String title;
	/**
	 * 日程主题
	 */
	
	private String zy;
	
	private String zz;
	
	private String content;
	
	private String sfgq;
	
	private Timestamp fbsj;
	
	public QyxcNews(){
		
	}

	public QyxcNews( String title, String zy, String zz,
			String content, String sfgq, Timestamp fbsj) {
		super();
		this.id = id;
		this.title = title;
		this.zy = zy;
		this.zz = zz;
		this.content = content;
		this.sfgq = sfgq;
		this.fbsj = fbsj;
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
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "zy", nullable = true)
	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	@Column(name = "zz", nullable = false)
	public String getZz() {
		return zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	@Column(name = "content", nullable = true)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "sfgq", nullable = false)
	public String getSfgq() {
		return sfgq;
	}

	public void setSfgq(String sfgq) {
		this.sfgq = sfgq;
	}

	@Column(name = "fbsj", nullable = true)
	public Timestamp getFbsj() {
		return fbsj;
	}

	public void setFbsj(Timestamp fbsj) {
		this.fbsj = fbsj;
	}

	
}
