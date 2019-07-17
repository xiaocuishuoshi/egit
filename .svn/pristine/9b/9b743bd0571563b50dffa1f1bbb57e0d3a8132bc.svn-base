package com.whfp.oa.manager.app.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.manager.app.bean.JsonBody;

public abstract class JsonBaseController {

	protected static final Logger logger = LoggerFactory.getLogger(JsonBaseController.class);
	
	@ExceptionHandler
	public @ResponseBody  JsonBody<String> handleException(HttpServletRequest request, Exception ex){
	   
		logger.error("handleException", ex);
		
		if(ex instanceof ConstraintViolationException){
			
			Set<ConstraintViolation<?>> violations= ((ConstraintViolationException) ex).getConstraintViolations();
			
			String err="";
			for(ConstraintViolation<?> violation:violations){
				
				String message = violation.getMessage();
				
				err=err+violation.getPropertyPath()+message+",\n";
			}
			
			return new JsonBody<String>(-1,"操作失败，参数输入验证失败",err); 
			
		}else if(ex instanceof UnauthorizedException){
			
			return new JsonBody<String>(-401,"权限拒绝，操作失败",""); 
		}

		String url=request.getRequestURI();
		
		if(url.length()>256){
			url=url.substring(url.length()-260);
		}
		
		return new JsonBody<String>(-1,"操作失败，系统出现异常",ex.getMessage()); 
	 }

	
}
