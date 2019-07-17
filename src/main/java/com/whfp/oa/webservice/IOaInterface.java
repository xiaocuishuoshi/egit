package com.whfp.oa.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
/*@SOAPBinding(style=Style.RPC)
 * style:定义发送到WebService的消息和从WebService发送的消息的编码样式。Document和RPC两种形式，默认document。*/
public interface IOaInterface {
	@WebResult(name="addResult")
	public int add(@WebParam(name="a")int a, @WebParam(name="b")int b);
	
	@WebResult(name="minusResult")
	public int minus(@WebParam(name="a")int a, @WebParam(name="b")int b);
	
	@WebResult(name="loginUser")
	public User login(@WebParam(name="username")String username, @WebParam(name="password")String password);
}
