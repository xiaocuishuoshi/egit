package com.whfp.oa.manager.app.action.model;

import java.util.List;

import com.whfp.oa.manager.jiedu.bean.JdManActLog;

public class ManLogOutputModel {

	private String manId;
	
	private String groupDate;
	
	public  List<JdManActLog> list;
	
	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public String getGroupDate() {
		return groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public List<JdManActLog> getList() {
		return list;
	}



	public void setList(List<JdManActLog> list) {
		this.list = list;
	}
}
