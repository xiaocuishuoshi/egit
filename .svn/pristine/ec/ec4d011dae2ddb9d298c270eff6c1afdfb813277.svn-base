package com.whfp.oa.manager.hlkj.sbgl.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HlkjSbglModer {
	private String device_id;
	private Integer device_type;
	private String last_update_time;
	private Date date_last_update_time;
	private Integer data_type;
	private Map data;
	//private ModelStatus data;
	private String reverse;

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String deviceId) {
		device_id = deviceId;
	}

	public Integer getDevice_type() {
		return device_type;
	}

	public void setDevice_type(Integer deviceType) {
		device_type = deviceType;
	}

	public String getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(String lastUpdateTime) {
		last_update_time = lastUpdateTime;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date_last_update_time = fmt.parse(last_update_time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Date getDate_last_update_time() {
		return date_last_update_time;
	}

	public Integer getData_type() {
		return data_type;
	}

	public void setData_type(Integer dataType) {
		data_type = dataType;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

	public String getReverse() {
		return reverse;
	}

	public void setReverse(String reverse) {
		this.reverse = reverse;
	}

}
