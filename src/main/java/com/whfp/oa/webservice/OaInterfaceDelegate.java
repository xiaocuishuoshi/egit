package com.whfp.oa.webservice;

@javax.jws.WebService(targetNamespace = "http://webservice.oa.whfp.com/", serviceName = "OaInterfaceService", portName = "OaInterfacePort")
public class OaInterfaceDelegate {

	 
	OaInterfaceImpl myServiceImpl = new OaInterfaceImpl();

	public int add(int a, int b) {
		return myServiceImpl.add(a, b);
	}

	public int minus(int a, int b) {
		return myServiceImpl.minus(a, b);
	}

	public User login(String username, String password) {
		return myServiceImpl.login(username, password);
	}
}