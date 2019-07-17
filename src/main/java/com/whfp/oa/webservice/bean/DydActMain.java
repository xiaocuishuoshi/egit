package com.whfp.oa.webservice.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dyd_act_main")
public class DydActMain implements java.io.Serializable {

	// Fields

	private String id;
	// private String actId;
	private String actName;

	private String actMaxNum;
	private Date actBeginTime;
	private Date actEndTime;
	private Date actApplyEndTime;
	private int actDays;
	private String actFrom;
	private String actTo;
	private String actReqSex;
	private int actFee;
	private String actDetail;
	private String actLogo;
	private String actType;
	private Date actTime;
	private String createUser;
	private String actContractInfo;
	private int actPubStatus;

	public DydActMain() {
		super();
	}

	public DydActMain(String id, String actName, String actMaxNum,
			Date actBeginTime, Date actEndTime, Date actApplyEndTime,
			int actDays, String actFrom, String actTo, String actReqSex,
			int actFee, String actDetail, String actLogo, String actType,
			Date actTime, String createUser, String actContractInfo,
			int actPubStatus) {
		super();
		this.id = id;
		this.actName = actName;
		this.actMaxNum = actMaxNum;
		this.actBeginTime = actBeginTime;
		this.actEndTime = actEndTime;
		this.actApplyEndTime = actApplyEndTime;
		this.actDays = actDays;
		this.actFrom = actFrom;
		this.actTo = actTo;
		this.actReqSex = actReqSex;
		this.actFee = actFee;
		this.actDetail = actDetail;
		this.actLogo = actLogo;
		this.actType = actType;
		this.actTime = actTime;
		this.createUser = createUser;
		this.actContractInfo = actContractInfo;
		this.actPubStatus = actPubStatus;
	}
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "act_name", length = 100)
	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}
	@Column(name = "act_max_num", length = 10)
	public String getActMaxNum() {
		return actMaxNum;
	}

	public void setActMaxNum(String actMaxNum) {
		this.actMaxNum = actMaxNum;
	}
	@Column(name = "act_begin_time")
	public Date getActBeginTime() {
		return actBeginTime;
	}

	public void setActBeginTime(Date actBeginTime) {
		this.actBeginTime = actBeginTime;
	}
	@Column(name = "act_end_time")
	public Date getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}
	@Column(name = "act_apply_end_time")
	public Date getActApplyEndTime() {
		return actApplyEndTime;
	}

	public void setActApplyEndTime(Date actApplyEndTime) {
		this.actApplyEndTime = actApplyEndTime;
	}
	@Column(name = "act_days", length = 10 )
	public int getActDays() {
		return actDays;
	}

	public void setActDays(int actDays) {
		this.actDays = actDays;
	}
	@Column(name = "act_from", length = 100 )
	public String getActFrom() {
		return actFrom;
	}

	public void setActFrom(String actFrom) {
		this.actFrom = actFrom;
	}
	@Column(name = "act_to", length = 100 )
	public String getActTo() {
		return actTo;
	}

	public void setActTo(String actTo) {
		this.actTo = actTo;
	}
	@Column(name = "act_req_sex", length = 10 )
	public String getActReqSex() {
		return actReqSex;
	}

	public void setActReqSex(String actReqSex) {
		this.actReqSex = actReqSex;
	}
	@Column(name = "act_Fee", length = 100 )
	public int getActFee() {
		return actFee;
	}

	public void setActFee(int actFee) {
		this.actFee = actFee;
	}
	@Column(name = "act_detail", length = 200 )
	public String getActDetail() {
		return actDetail;
	}

	public void setActDetail(String actDetail) {
		this.actDetail = actDetail;
	}
	@Column(name = "act_logo", length = 100 )
	public String getActLogo() {
		return actLogo;
	}

	public void setActLogo(String actLogo) {
		this.actLogo = actLogo;
	}
	@Column(name = "act_type", length = 32 )
	public String getActType() {
		return actType;
	}
	
	public void setActType(String actType) {
		this.actType = actType;
	}
	@Column(name = "act_time" )
	public Date getActTime() {
		return actTime;
	}

	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	@Column(name = "create_user", length = 100 )
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@Column(name = "act_contract_info", length = 100 )
	public String getActContractInfo() {
		return actContractInfo;
	}

	public void setActContractInfo(String actContractInfo) {
		this.actContractInfo = actContractInfo;
	}
	@Column(name = "act_pub_status", length = 100 )
	public int getActPubStatus() {
		return actPubStatus;
	}

	public void setActPubStatus(int actPubStatus) {
		this.actPubStatus = actPubStatus;
	}

}
