package com.whfp.oa.manager.system.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


/**
 * 单位表对应实体
 */
@Entity
@Table(name = "sys_org")
public class SysOrg implements java.io.Serializable {

	// Fields

	/**
	 * @Fields serialVersionUID : 
	 */
	
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 单位序号
	 */
	@NotNull(message="单位序号不能为空")
	@Range(min=1,max=999,message="单位序号必须为1-999的整数")
	private Short orgSort;
	/**
	 * 单位名称
	 */
	@NotBlank(message="单位名称不能为空")
	@Length(min=1,max=50,message="单位名称长度必须在1-50之间")
	private String orgName;
	/**
	 * 单位电话
	 */
	@Length(min=0,max=255,message="电话长度必须在1-255之间")
	private String orgPhone;
	/**
	 * 单位传真
	 */
	@Length(min=0,max=255,message="传真长度必须在1-255之间")
	private String orgFax;
	/**
	 * 单位地址
	 */
	@Length(min=0,max=100,message="地址长度不能超过100。")
	private String orgAddress;
	/**
	 * 上级单位
	 */
	@NotBlank(message="上级单位不能为空")
	private String superId;
	/**
	 * 单位主管
	 */
	private String leadUid;
	/**
	 * 单位描述
	 */
	@Length(min=0,max=200,message="备注长度不能超过200。")
	private String orgDesc;
	

	// Constructors

	/** default constructor */
	public SysOrg() {
	}

	/** minimal constructor */
	public SysOrg(Short orgSort, String orgName, String superId) {
		this.orgSort = orgSort;
		this.orgName = orgName;
		this.superId = superId;
	}

	/** full constructor */
	public SysOrg(Short orgSort, String orgName, String orgPhone,
			String orgFax, String orgAddress, String superId, String leadUid,
			String orgDesc) {
		this.orgSort = orgSort;
		this.orgName = orgName;
		this.orgPhone = orgPhone;
		this.orgFax = orgFax;
		this.orgAddress = orgAddress;
		this.superId = superId;
		this.leadUid = leadUid;
		this.orgDesc = orgDesc;
		
	}

	// Property accessors
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
	@Column(name = "org_sort", nullable = false)
	public Short getOrgSort() {
		return this.orgSort;
	}

	public void setOrgSort(Short orgSort) {
		this.orgSort = orgSort;
	}
	@Column(name = "org_name", nullable = false,length = 50)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Column(name = "org_phone", length = 20)
	public String getOrgPhone() {
		return this.orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}
	@Column(name = "org_fax", length = 20)
	public String getOrgFax() {
		return this.orgFax;
	}

	public void setOrgFax(String orgFax) {
		this.orgFax = orgFax;
	}
	@Column(name = "org_address", length = 100)
	public String getOrgAddress() {
		return this.orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	@Column(name = "super_id", nullable = false, length = 32)
	public String getSuperId() {
		return this.superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}
	@Column(name = "lead_uid", length = 32)
	public String getLeadUid() {
		return this.leadUid;
	}

	public void setLeadUid(String leadUid) {
		this.leadUid = leadUid;
	}
	@Column(name = "org_desc", length = 200)
	public String getOrgDesc() {
		return this.orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}



}