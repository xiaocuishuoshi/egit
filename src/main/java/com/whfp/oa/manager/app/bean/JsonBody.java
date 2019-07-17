package com.whfp.oa.manager.app.bean;

public class JsonBody<T> {
	
	private int result;
	private String msg;
	
	private T data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public JsonBody(int b,String m){
		
		this.result=b;
		this.msg=m;
	}
	
	public JsonBody(int b,String m,T data){
		
		this.result=b;
		this.msg=m;
		this.data=data;
	}
	
	public JsonBody(){
		
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}
