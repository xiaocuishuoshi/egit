package com.whfp.oa.manager.hskm.webService;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.model.IpInfo;
import com.whfp.oa.commons.model.LoginInfo;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.OnLineUser;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.IpUtil;
import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbglModer;
import com.whfp.oa.manager.hlkj.sbgl.service.ISbglService;
import com.whfp.oa.manager.hskm.bean.JsonResult;
import com.whfp.oa.manager.hskm.tools.StringTools;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;


@Controller
@RequestMapping("/HsService")
public class HsWebService extends BaseAction {
	public static Map tradCode=new HashMap();
	@Autowired
	private ISbglService service;

	
	
	/**
	 * 设备管理
	 * 
	 * @param dataModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public JsonResult<String> upload(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult<String> jsonResult = new JsonResult<String>();
		
		
		try {
			
			
			String data = StringTools.convertStream(request.getInputStream(),Charset.forName("UTF-8"));
			JSONObject jsonObject = JSONObject.fromObject(data);
			System.out.println("**********************jsonObject=" + jsonObject);
			System.out.println("**********************data=" + data);
			HlkjSbglModer dataModel = (HlkjSbglModer) JSONObject.toBean(jsonObject, HlkjSbglModer.class);
			JSONObject ons = new JSONObject();
			//ons.accumulate(key, value)
		
			jsonResult.setMsg("设备上传数据成功");
			jsonResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMsg("设备上传数据失败");
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * json格式用户登录接口
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "userLogin", method = { RequestMethod.POST,
			RequestMethod.GET })
	public JsonResult<String> userLogin(HttpServletRequest request,HttpServletResponse response){ 
		JsonResult<String> jsonResult = new JsonResult<String>();
		try {
			jsonResult.setMsg("");
			jsonResult.setSuccess(false);
			Timestamp loginTime=DateUtil.currentTimestamp();
			String loginIp=IpUtil.getIpAddr(ServletUtil.getRequest());
			String tradeCode="";//返回给用户用于接口访问的验证编码
    		
			String username=request.getParameter("username"); 
		 
			String password=request.getParameter("password"); 
			
			//SyUsers u=(SyUsers)dao.findOne("from SyUsers where userName = ?",username);
			SyUsers u = service.findUser(username);
			if(u==null){
				System.out.println("不存在此用户"); 
				jsonResult.setMsg("用户名错误， 请重新登录");
			}
			
			//3. 验证用户是否被限制登陆
			if(u.getUserStatus()==(short)0){	
				jsonResult.setMsg("用户被限制登陆，请联系管理员");
			}
			 IpInfo ipInfo=IpUtil.getIpInfo(loginIp); 
			//5. 登录认证  验证密码
			if(MD5Util.MD5Validate(password, u.getUserPassword())){
				Subject currentUser =SecurityUtils.getSubject();
				UsernamePasswordToken token =new UsernamePasswordToken(u.getId(), password);
				currentUser.login(token);//登录认证 记录登陆信息 
				System.out.println("****登陆成功*****");
				//6.1 登录成功 保持一些用户信息到session中
				Member me=new Member();//需要放入当前session 的用户信息
				me.setId(u.getId());
				me.setIpInfo(ipInfo);
				me.setLoginTime(loginTime);
				me.setDeptId(u.getDeptId());
				me.setOrgId(u.getOrgId()); 
				HttpSession session=ServletUtil.getRequest().getSession();
				if(username.equals(BaseConfig.getInstance().getDevName())){
					session.setAttribute("dev", true);//当前登陆用户是开发者，拥有所有权限
				}else{
					session.setAttribute("dev", false);
				}
				if(username.equals(BaseConfig.getInstance().getSaName())){
					session.setAttribute("sa", true);//当前登陆用户是系统超级管理员
				}else{
					session.setAttribute("sa", false);
				}
				//6.2 保持一些用户登陆信息 到全局在线用户列表
				//获取全局 用户列表 将此次登录用户添加到用户在线列表中
				Map<String,OnLineUser> usersMap=ServletUtil.getOnLineUsers();
				
				OnLineUser onmy=usersMap.get(u.getId());
				if(onmy==null){
					onmy=new OnLineUser();
				}
				onmy.setId(u.getId());
				onmy.setTrueName(u.getTrueName());
				onmy.setDeptId(u.getDeptId());
				onmy.setSex(u.getUserSex());
				
				Map<String,LoginInfo> loginInfos=onmy.getLoginInfos();
				if(loginInfos==null){
					loginInfos=new HashMap<String,LoginInfo>();
				}
				LoginInfo loginInfo=new LoginInfo();
				loginInfo.setId(FileUtils.getUUID());
				loginInfo.setLoginType(1);
				loginInfo.setIpInfo(ipInfo);
				loginInfo.setLoginTime(loginTime);
				loginInfos.put(session.getId(),loginInfo );
				onmy.setLoginInfos(loginInfos);
				usersMap.put(u.getId(), onmy);//将当前用户信息放入在线用户列表
				session.setAttribute("loginType", 1);//标记此session登陆方式 用于退出时使用
				//6.3 记录登录日志
				SyLoginLog log=new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short)1);
				log.setLoginDesc("登录成功");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);
				
				// dao.save(log);//保存登录日志
				service.saveLoginLog(log);
				//6.4 保持用户本此登录时间 ip 等信息保持到数据库
				u.setLastLoginIp(loginIp);//登录ip
				u.setLastLoginTime(loginTime);//登录时间
				u.setErrorCount((short)0);//将密码错误次数重置为0
				
				// dao.update(u);//更新用户 
				service.updateUser(u);
				
				jsonResult.setMsg("登录成功");
				jsonResult.setSuccess(true);
				
				session.removeAttribute("jmpw");//清除加密密码
				session.setAttribute("fromLogin",true);//标记刚执行登陆操作
				tradeCode=MD5Util.MD5(username+new Date().getTime());
				String userinfo[]={u.getId(),tradeCode,DateUtil.date2String(new Date()),"1"};
				if(tradCode.get(u.getId())!=null){
					tradCode.remove(u.getId()); 
				}  
				tradCode.put(u.getId(), userinfo);
				System.out.println("在线用户："+tradCode.size()+"  tradeCode="+tradeCode);
			}else{
				//认证失败
				System.out.println("密码错误");
				//登录日志
				SyLoginLog log=new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short)1);
				log.setLoginDesc("密码错误");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);
				
				// dao.save(log);//保存登录日志
				service.saveLoginLog(log);
				
				u.setErrorTime(loginTime);
				u.setErrorCount((short)(u.getErrorCount()+1));
				
				// dao.update(u);//更新用户
				service.updateUser(u);
				jsonResult.setMsg("用户名或密码错误， 请重新登录");
				jsonResult.setSuccess(false);
			} 
			
			jsonResult.setTransaction(tradeCode);
			jsonResult.setUserid(u.getId());
			jsonResult.setFkdeptid(u.getOrgId());
			jsonResult.setPasswor(u.getUserPassword());
			
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();

			response.setCharacterEncoding("UTF-8");
			jsonResult.setMsg("未知错误");
		}
		return jsonResult;
	
	}
	
	
	/**
	 * json格式用户登录接口xi
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getDeptTree", method = { RequestMethod.POST,
			RequestMethod.GET })
	public JsonResult<String> getDeptTree(HttpServletRequest request,HttpServletResponse response){ 
		JsonResult<String> jsonResult = new JsonResult<String>();
		
		
	return jsonResult;	
	}
	
	
	
	
}
