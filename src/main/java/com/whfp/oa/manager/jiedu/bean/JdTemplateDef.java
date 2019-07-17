package com.whfp.oa.manager.jiedu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jd_template_def")
public class JdTemplateDef {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="template_name")
	private String templateName;
	
	@Column(name="def_key")
	private String defKey;
	
	@Column(name="key_type")
	private String keyType;
	
	@Column(name="default_value")
	private String defaultValue;
	
	private String desc;
	
	@Column(name="is_required")
	private Integer isRequired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getDefKey() {
		return defKey;
	}

	public void setDefKey(String defKey) {
		this.defKey = defKey;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Integer isRequired) {
		this.isRequired = isRequired;
	}
	
	
}
