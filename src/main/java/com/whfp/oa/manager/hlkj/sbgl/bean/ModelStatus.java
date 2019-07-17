package com.whfp.oa.manager.hlkj.sbgl.bean;

public class ModelStatus {
	private String openTimes;
	private String status; 
	private String state;
	private String elecValue;
	private String voltage;
	private String temperatureValue; 
	private String humidity;
	private String pressureValue;
	private String waterFlow;
	private String waterLevel;
	private String UA;
	private String UB;
	private String UC;
	private String IA;
	private String IB;
	private String IC;
	private String energy;
	private String floor;
	private String direction;
	private String model;
	
	
	
	
	
	
	
	public ModelStatus(){
		
	}
	
	
	public ModelStatus(String status) {
		super();
		this.status = status;
	}
	public ModelStatus(String status, String state) {
		super();
		this.status = status;
		this.state = state;
	}
	
	
	
	public ModelStatus(String uA, String uB, String uC) {
		super();
		UA = uA;
		UB = uB;
		UC = uC;
	}


	public ModelStatus(String status, String uA, String uB, String uC) {
		super();
		this.status = status;
		UA = uA;
		UB = uB;
		UC = uC;
	}


	public ModelStatus(String openTimes, String status, String state,
			String elecValue, String voltage, String temperatureValue,
			String humidity, String pressureValue, String waterFlow,
			String waterLevel, String uA, String uB, String uC, String iA,
			String iB, String iC, String energy, String floor,
			String direction, String model) {
		super();
		this.openTimes = openTimes;
		this.status = status;
		this.state = state;
		this.elecValue = elecValue;
		this.voltage = voltage;
		this.temperatureValue = temperatureValue;
		this.humidity = humidity;
		this.pressureValue = pressureValue;
		this.waterFlow = waterFlow;
		this.waterLevel = waterLevel;
		UA = uA;
		UB = uB;
		UC = uC;
		IA = iA;
		IB = iB;
		IC = iC;
		this.energy = energy;
		this.floor = floor;
		this.direction = direction;
		this.model = model;
	}
	public String getOpenTimes() {
		return openTimes;
	}
	public void setOpenTimes(String openTimes) {
		this.openTimes = openTimes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getElecValue() {
		return elecValue;
	}
	public void setElecValue(String elecValue) {
		this.elecValue = elecValue;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getTemperatureValue() {
		return temperatureValue;
	}
	public void setTemperatureValue(String temperatureValue) {
		this.temperatureValue = temperatureValue;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressureValue() {
		return pressureValue;
	}
	public void setPressureValue(String pressureValue) {
		this.pressureValue = pressureValue;
	}
	public String getWaterFlow() {
		return waterFlow;
	}
	public void setWaterFlow(String waterFlow) {
		this.waterFlow = waterFlow;
	}
	public String getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}
	public String getUA() {
		return UA;
	}
	public void setUA(String uA) {
		UA = uA;
	}
	public String getUB() {
		return UB;
	}
	public void setUB(String uB) {
		UB = uB;
	}
	public String getUC() {
		return UC;
	}
	public void setUC(String uC) {
		UC = uC;
	}
	public String getIA() {
		return IA;
	}
	public void setIA(String iA) {
		IA = iA;
	}
	public String getIB() {
		return IB;
	}
	public void setIB(String iB) {
		IB = iB;
	}
	public String getIC() {
		return IC;
	}
	public void setIC(String iC) {
		IC = iC;
	}
	public String getEnergy() {
		return energy;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
