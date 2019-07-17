/**  
 * @Title UserAuthenticationFilter.java
 * @date 2013-12-4 上午10:46:12
 * @Copyright: 2013 
 */
package com.whfp.oa.commons.security;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.whfp.oa.commons.model.LoginInfo;
import com.whfp.oa.commons.model.OnLineUser;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.system.service.ILoginService;

/**
 * 验证用户是否在线
 * 用户已验证通过，并且在全局在线用户列表,否定登陆超时
 * @author LiuJincheng
 * @version 1.0
 */
public class UserAuthenticationFilter extends org.apache.shiro.web.filter.authc.UserFilter{
	@Autowired
	private ILoginService service; 
	@Override
	protected boolean isAccessAllowed(ServletRequest request,ServletResponse response, Object mappedValue) {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		System.out.println("验证登陆信息=="+req.getRequestURI());
		System.out.println("sessionId=="+req.getSession().getId());
		String loginUser=req.getParameter("loginUser");
		/*if(loginUser!=null){
			service.updateLogin(loginUser, null, req, res);
		}*/
		if (isLoginRequest(request, response)) {
            return true;
        } else {
        /*	try {
				res.sendRedirect("http://219.138.150.221:8081/sso/checkLoadSso.do?sysFlag=A");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}*/
            Subject subject = getSubject(request, response);
            System.out.println("subject url=="+req.getRequestURI()+"  flag="+req.getRequestURI().indexOf("interface/"));
            // 验证是否有登陆用户 
            //过滤掉不需要登录的请求
        	if(req.getRequestURI().toLowerCase().indexOf("interface/")>0||
        			req.getRequestURI().toLowerCase().indexOf("/app/")>0||
        			req.getRequestURI().indexOf("HlkjSbgl/upload")>0||
        			req.getRequestURI().indexOf("HsService/userLogin")>0){ 
       		res.setHeader("Access-Control-Allow-Origin", "*");
        	//	tradCode.put(tradeCode, value)
        		//if(tradCode.get(tradeCode)) 
        		return true;
        	}
            if(subject.getPrincipal() != null&&subject.isAuthenticated()){
            	//判断用户是否在全局在线列表
        		String userId=(String)subject.getPrincipal();//获取用户id 
            	Map<String,OnLineUser> usersMap =ServletUtil.getOnLineUsers();
    			OnLineUser om=usersMap.get(userId);//获取在线人员列表
    			//判断当前用户是否在在线人员列表里面，如果不在，不能继续访问
            	if(om==null){
            		return false;
            	}else{
            		Map<String,LoginInfo> loginInfos=om.getLoginInfos();
            		if(loginInfos.containsKey(((HttpServletRequest)request).getSession().getId())){
            			return true;
            		}else{
            			return false;
            		}
            	}
            }else{
            	
            	return false;
            }
        }
	}

}
