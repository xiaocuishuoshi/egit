package com.whfp.oa.manager.system.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.config.WebConfig;
import com.whfp.oa.commons.model.IpInfo;
import com.whfp.oa.commons.model.LoginInfo;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.OnLineUser;
import com.whfp.oa.commons.util.AppUtil;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.IpUtil;
import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.commons.util.SerialNumberUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.ILoginService;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginServiceImpl extends BaseServiceImpl implements ILoginService {
	@Override
	public ModelAndView updateLogin(String vercode, String name,
			String password, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("ajaxMessage");
		HttpSession session = request.getSession();

		String loginIp = IpUtil.getIpAddr(request);

		boolean iskey = SerialNumberUtil.verificationkey(
				BaseConfig.serialconfig.getClientname(),
				BaseConfig.serialconfig.getClientcode(),
				BaseConfig.serialconfig.getValidstart(),
				BaseConfig.serialconfig.getValidend(),
				BaseConfig.serialconfig.getValidday(),
				BaseConfig.serialconfig.getKey()); 
	/*	if(!iskey){
			//系统不可用,已过期
			mav.setViewName("ajaxDone");
			mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
			mav.addObject(MsgConfig.MESSAGE,"抱歉，您的系统已过期，无法进行操作！请联系管理员！");
			return mav;
		}*/
		if ((!name.equals(BaseConfig.getInstance().getDevName()))
				|| (!name.equals(BaseConfig.getInstance().getSaName()))) {
			WebConfig wc = BaseConfig.webconfig;
			if ((wc.getAppStart() != null)
					&& (wc.getAppStart().intValue() != 1)) {
				mav.setViewName("ajaxDone");
				mav.addObject("statusCode", MsgConfig.CODE_FAIL);
				mav.addObject("message", "系统已设置禁止访问！请联系管理员！");
				return mav;
			}
			if (!AppUtil.checkLoginTime(new Date(), wc.getLoginStartTime(),
					wc.getLoginEndTime())) {
				mav.setViewName("ajaxDone");
				mav.addObject("statusCode", MsgConfig.CODE_FAIL);
				mav.addObject("message", "系统只能在" + wc.getLoginStartTime()
						+ " 至 " + wc.getLoginEndTime() + "之间才能访问！");
				return mav;
			}
			if ((StringUtils.isNotBlank(wc.getAllowIps()))
					&& (!AppUtil.checkIp(wc.getAllowIps(), loginIp))) {
				mav.setViewName("ajaxDone");
				mav.addObject("statusCode", MsgConfig.CODE_FAIL);
				mav.addObject("message", "系统已设置ip限制！");
				return mav;
			}
			if ((StringUtils.isNotBlank(wc.getLimitIps()))
					&& (AppUtil.checkIp(wc.getLimitIps(), loginIp))) {
				mav.setViewName("ajaxDone");
				mav.addObject("statusCode", MsgConfig.CODE_FAIL);
				mav.addObject("message", "系统已设置ip限制！");
				return mav;
			}
		}
		SyUsers u = (SyUsers) this.dao.findOne(
				"from SyUsers where userName = ?", new Object[] { name });
		if (u == null) {
			System.out.println("不存在此用户");
			mav.addObject("statusCode", MsgConfig.CODE_FAIL);
			mav.addObject("message", "msg.login.failure");

			return mav;
		}
		if (u.getUserStatus().shortValue() == 0) {
			mav.addObject("statusCode", MsgConfig.CODE_FAIL);
			mav.addObject("message", "msg.login.restrict");
			return mav;
		}
		IpInfo ipInfo =new IpInfo(); //IpUtil.getIpInfo(loginIp);

		Timestamp loginTime = DateUtil.getCurrentTimeStamp();
		int num = BaseConfig.webconfig.getPwdErrorNum().intValue();
		int time = BaseConfig.webconfig.getPwdErrorTime().intValue();
		if (u.getErrorCount().shortValue() >= num) {
			long gotime = loginTime.getTime() - (u.getErrorTime()==null?loginTime:u.getErrorTime()).getTime();
			if (gotime < time * 60000) {
				mav.addObject("statusCode", MsgConfig.CODE_FAIL);
				mav.addObject("message", "msg.login.restricttime");
				mav.addObject("messageValues", num + "," + time + "分钟");
				return mav;
			}
			u.setErrorCount(Short.valueOf((short) 0));
		}
		if (MD5Util.MD5Validate(password, u.getUserPassword())) {
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(u.getId(),
					password);
			currentUser.login(token);
			System.out.println("****登陆成功*****");

			Member me = new Member();
			me.setId(u.getId());
			me.setIpInfo(ipInfo);
			me.setLoginTime(loginTime);
			me.setDeptId(u.getDeptId());
			me.setOrgId(u.getOrgId());
			session.setAttribute("minfo", me);
			session.setAttribute("truename", u.getTrueName());
			session.setAttribute("name", u.getTrueName());
			session.setAttribute("uname", u.getUserName());
			boolean isDev = true;
			boolean isSa = true;
			if (name.equals(BaseConfig.getInstance().getDevName())) {
				session.setAttribute("dev", Boolean.valueOf(true));
			} else {
				session.setAttribute("dev", Boolean.valueOf(false));
				isDev = false;
			}
			if (name.equals(BaseConfig.getInstance().getSaName())) {
				session.setAttribute("sa", Boolean.valueOf(true));
			} else {
				session.setAttribute("sa", Boolean.valueOf(false));
				isSa = false;
			}
			if ((!isDev) && (!isSa)) {
				String deptId = me.getDeptId();
				String orgId = me.getOrgId();
				String deptIds = "'0'";
				deptIds = getDeptIds(deptId, orgId);
				session.setAttribute("deptIds", deptIds);
			}
			Map<String, OnLineUser> usersMap = ServletUtil.getOnLineUsers();

			OnLineUser onmy = usersMap.get(u.getId());
			if (onmy == null) {
				onmy = new OnLineUser();
			}
			onmy.setId(u.getId());
			onmy.setTrueName(u.getTrueName());
			onmy.setDeptId(u.getDeptId());
			onmy.setSex(u.getUserSex());

			Map<String, LoginInfo> loginInfos = onmy.getLoginInfos();
			if (loginInfos == null) {
				loginInfos = new HashMap();
			}
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setId(FileUtils.getUUID());
			loginInfo.setLoginType(1);
			loginInfo.setIpInfo(ipInfo);
			loginInfo.setLoginTime(loginTime);
			loginInfos.put(session.getId(), loginInfo);
			onmy.setLoginInfos(loginInfos);
			usersMap.put(u.getId(), onmy);
			session.setAttribute("loginType", Integer.valueOf(1));

			SyLoginLog log = new SyLoginLog();
			log.setUserId(u.getId());
			log.setLoginType(Short.valueOf((short) 1));
			log.setLoginDesc("登录成功");
			log.setIpInfoCountry(ipInfo.getCountry());
			log.setIpInfoRegion(ipInfo.getRegion());
			log.setIpInfoCity(ipInfo.getCity());
			log.setIpInfoIsp(ipInfo.getIsp());
			log.setLoginIp(loginIp);
			log.setLoginTime(loginTime);

			this.dao.save(log);

			u.setLastLoginIp(loginIp);
			u.setLastLoginTime(loginTime);
			u.setErrorCount(Short.valueOf((short) 0));
			this.dao.update(u);

			mav.addObject("statusCode", MsgConfig.CODE_SUCCESS);
			mav.addObject("message", "msg.login.success");

			session.removeAttribute("jmpw");
			session.setAttribute("fromLogin", Boolean.valueOf(true));
			return mav;
		}
		System.out.println("密码错误");

		SyLoginLog log = new SyLoginLog();
		log.setUserId(u.getId());
		log.setLoginType(Short.valueOf((short) 1));
		log.setLoginDesc("密码错误");
		log.setIpInfoCountry(ipInfo.getCountry());
		log.setIpInfoCity(ipInfo.getCity());
		log.setIpInfoIsp(ipInfo.getIsp());
		log.setIpInfoRegion(ipInfo.getRegion());
		log.setLoginIp(loginIp);
		log.setLoginTime(loginTime);
		this.dao.save(log);

		u.setErrorTime(loginTime);
		u.setErrorCount(Short
				.valueOf((short) (u.getErrorCount().shortValue() + 1)));

		this.dao.update(u);
		mav.addObject("statusCode", MsgConfig.CODE_FAIL);
		mav.addObject("message", "msg.login.failure");
		return mav;
	}

	@Override
	public Map updateLoginAndroid(String vercode, String name, String password,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(name);
		System.out.println(password);
		Map<String, Object> map = new HashMap();
		HttpSession session = request.getSession();
		 
		String loginIp = IpUtil.getIpAddr(request);

		boolean iskey = SerialNumberUtil.verificationkey(
				BaseConfig.serialconfig.getClientname(),
				BaseConfig.serialconfig.getClientcode(),
				BaseConfig.serialconfig.getValidstart(),
				BaseConfig.serialconfig.getValidend(),
				BaseConfig.serialconfig.getValidday(),
				BaseConfig.serialconfig.getKey());
		
		
		if ((!name.equals(BaseConfig.getInstance().getDevName()))
				|| (!name.equals(BaseConfig.getInstance().getSaName()))) {
			WebConfig wc = BaseConfig.webconfig;
			if (wc.getAppStart().intValue() != 1) {
				map.put("statusCode", MsgConfig.CODE_FAIL);
				map.put("message", "系统已设置禁止访问！请联系管理员！");
				return map;
			}
			if (!AppUtil.checkLoginTime(new Date(), wc.getLoginStartTime(),
					wc.getLoginEndTime())) {
				map.put("statusCode", MsgConfig.CODE_FAIL);
				map.put("message", "系统只能在" + wc.getLoginStartTime() + " 至 "
						+ wc.getLoginEndTime() + "之间才能访问！");
				return map;
			}
			if ((StringUtils.isNotBlank(wc.getAllowIps()))
					&& (!AppUtil.checkIp(wc.getAllowIps(), loginIp))) {
				map.put("statusCode", MsgConfig.CODE_FAIL);
				map.put("message", "系统已设置ip限制！");
				return map;
			}
			if ((StringUtils.isNotBlank(wc.getLimitIps()))
					&& (AppUtil.checkIp(wc.getLimitIps(), loginIp))) {
				map.put("statusCode", MsgConfig.CODE_FAIL);
				map.put("message", "系统已设置ip限制！");
				return map;
			}
		}
		SyUsers u = (SyUsers) this.dao.findOne(
				"from SyUsers where userName = ?", new Object[] { name });
		System.out.println("user" + u);
		if (u == null) {
			System.out.println("不存在此用户");
			map.put("statusCode", MsgConfig.CODE_FAIL);
			map.put("message", "用户名或密码错误！");

			return map;
		}
		if (u.getUserStatus().shortValue() == 0) {
			map.put("statusCode", MsgConfig.CODE_FAIL);
			map.put("message", "您已被限制登录！");
			return map;
		}
		IpInfo ipInfo = new IpInfo();
		ipInfo.setIp(loginIp);
		ipInfo.setCountry("中国");
		ipInfo.setRegion("山东省");
		ipInfo.setCity("济南市");
		ipInfo.setIsp("联通");

		Timestamp loginTime = DateUtil.getCurrentTimeStamp();
		int num = BaseConfig.webconfig.getPwdErrorNum().intValue();
		int time = BaseConfig.webconfig.getPwdErrorTime().intValue();
		if (u.getErrorCount().shortValue() >= num) {
			long gotime = loginTime.getTime() - u.getErrorTime().getTime();
			if (gotime < time * 60000) {
				map.put("statusCode", MsgConfig.CODE_FAIL);
				map.put("message", "您已" + num + "次密码输入错误，请" + time + "分钟之后再试!");
				return map;
			}
			u.setErrorCount(Short.valueOf((short) 0));
		}
		if (MD5Util.MD5Validate(password, u.getUserPassword())) {
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(u.getId(),
					password);
			currentUser.login(token);
			System.out.println("****登陆成功*****");

			Member me = new Member();
			me.setId(u.getId());
			me.setIpInfo(ipInfo);
			me.setLoginTime(loginTime);
			me.setDeptId(u.getDeptId());
			session.setAttribute("minfo", me);
			if (name.equals(BaseConfig.getInstance().getDevName())) {
				session.setAttribute("dev", Boolean.valueOf(true));
			} else {
				session.setAttribute("dev", Boolean.valueOf(false));
			}
			if (name.equals(BaseConfig.getInstance().getSaName())) {
				session.setAttribute("sa", Boolean.valueOf(true));
			} else {
				session.setAttribute("sa", Boolean.valueOf(false));
			}
			Map<String, OnLineUser> usersMap = ServletUtil.getOnLineUsers();

			OnLineUser onmy = usersMap.get(u.getId());
			if (onmy == null) {
				onmy = new OnLineUser();
			}
			onmy.setId(u.getId());
			onmy.setTrueName(u.getTrueName());
			onmy.setDeptId(u.getDeptId());
			onmy.setSex(u.getUserSex());
			session.setAttribute("name", u.getTrueName());
			Map<String, LoginInfo> loginInfos = onmy.getLoginInfos();
			if (loginInfos == null) {
				loginInfos = new HashMap();
			}
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setId(FileUtils.getUUID());
			loginInfo.setLoginType(2);
			loginInfo.setIpInfo(ipInfo);
			loginInfo.setLoginTime(loginTime);
			loginInfos.put(session.getId(), loginInfo);
			onmy.setLoginInfos(loginInfos);
			usersMap.put(u.getId(), onmy);
			session.setAttribute("loginType", Integer.valueOf(2));

			SyLoginLog log = new SyLoginLog();
			log.setUserId(u.getId());
			log.setLoginType(Short.valueOf((short) 2));
			log.setLoginDesc("登录成功");
			log.setIpInfoCountry(ipInfo.getCountry());
			log.setIpInfoRegion(ipInfo.getRegion());
			log.setIpInfoCity(ipInfo.getCity());
			log.setIpInfoIsp(ipInfo.getIsp());
			log.setLoginIp(loginIp);
			log.setLoginTime(loginTime);

			this.dao.save(log);

			u.setLastLoginIp(loginIp);
			u.setLastLoginTime(loginTime);
			u.setErrorCount(Short.valueOf((short) 0));
			this.dao.update(u);

			map.put("statusCode", MsgConfig.CODE_SUCCESS);
			map.put("message", "登录成功");

			session.removeAttribute("jmpw");
			session.setAttribute("fromLogin", Boolean.valueOf(true));

			return map;
		}
		System.out.println("密码错误");

		SyLoginLog log = new SyLoginLog();
		log.setUserId(u.getId());
		log.setLoginType(Short.valueOf((short) 2));
		log.setLoginDesc("密码错误");
		log.setIpInfoCountry(ipInfo.getCountry());
		log.setIpInfoCity(ipInfo.getCity());
		log.setIpInfoIsp(ipInfo.getIsp());
		log.setIpInfoRegion(ipInfo.getRegion());
		log.setLoginIp(loginIp);
		log.setLoginTime(loginTime);

		this.dao.save(log);

		u.setErrorTime(loginTime);
		u.setErrorCount(Short
				.valueOf((short) (u.getErrorCount().shortValue() + 1)));

		this.dao.update(u);

		map.put("statusCode", MsgConfig.CODE_FAIL);
		map.put("message", "用户名或密码错误！");
		return map;
	}
	@Override
	public ModelAndView updateLogin(String name,
			String password, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("ajaxMessage");
		HttpSession session = request.getSession();
		// 获取登录ip
		String loginIp = IpUtil.getIpAddr(request); 
		// 1.验证系统防火墙，例：ip,时间 等访问限制，先排除开发人员，超级管理员
		if (!name.equals(BaseConfig.getInstance().getDevName())
				|| !name.equals(BaseConfig.getInstance().getSaName())) {
			WebConfig wc = BaseConfig.webconfig;
			// 先判断系统是否禁止登陆
			if (wc.getAppStart() != 1) {
				// 禁止登陆系统
				mav.setViewName("ajaxDone");
				mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
				mav.addObject(MsgConfig.MESSAGE, "系统已设置禁止访问！请联系管理员！");
				return mav;

			}
			// 判断是否在可以登录的时间范围内
			if (!AppUtil.checkLoginTime(new Date(), wc.getLoginStartTime(),
					wc.getLoginEndTime())) {
				// 不符合使用范围
				mav.setViewName("ajaxDone");
				mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
				mav.addObject(
						MsgConfig.MESSAGE,
						"系统只能在" + wc.getLoginStartTime() + " 至 "
								+ wc.getLoginEndTime() + "之间才能访问！");
				return mav;
			}
			// 进行ip验证
			if (StringUtils.isNotBlank(wc.getAllowIps())
					&& !AppUtil.checkIp(wc.getAllowIps(), loginIp)) {

				mav.setViewName("ajaxDone");
				mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
				mav.addObject(MsgConfig.MESSAGE, "系统已设置ip限制！");
				return mav;
			} else {
				if (StringUtils.isNotBlank(wc.getLimitIps())
						&& AppUtil.checkIp(wc.getLimitIps(), loginIp)) {
					mav.setViewName("ajaxDone");
					mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
					mav.addObject(MsgConfig.MESSAGE, "系统已设置ip限制！");
					return mav;
				}
			}
		}
		/*
		 * //2.验证验证码是否正确
		 * if(!((String)session.getAttribute("imgCode")).equalsIgnoreCase
		 * (vercode)){ mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_FAIL);
		 * mav.addObject(MsgConfig.MESSAGE,"msg.validation.code.match");//验证码错误
		 * return mav; }
		 */

		SyUsers u = (SyUsers) dao.findOne("from SyUsers where userName = ?",
				name);
		Timestamp loginTime = DateUtil.string2Timestamp(DateUtil.currentDateTimeToString());
		IpInfo ipInfo = IpUtil.getIpInfo(loginIp);
		Member me = new Member();// 需要放入当前session 的用户信息
		me.setId(u.getId());
		me.setIpInfo(ipInfo);
		me.setLoginTime(loginTime);
		me.setDeptId(u.getDeptId());
		session.setAttribute("minfo", me); // 将当前用户信息存入session中

		if (name.equals(BaseConfig.getInstance().getDevName())) {
			session.setAttribute("dev", true);// 当前登陆用户是开发者，拥有所有权限
		} else {
			session.setAttribute("dev", false);
		}
		if (name.equals(BaseConfig.getInstance().getSaName())) {
			session.setAttribute("sa", true);// 当前登陆用户是系统超级管理员
		} else {
			session.setAttribute("sa", false);
		}
		// 6.2 保持一些用户登陆信息 到全局在线用户列表
		// 获取全局 用户列表 将此次登录用户添加到用户在线列表中
		Map<String, OnLineUser> usersMap = ServletUtil.getOnLineUsers();

		OnLineUser onmy = usersMap.get(u.getId());
		if (onmy == null) {
			onmy = new OnLineUser();
		}
		onmy.setId(u.getId());
		onmy.setTrueName(u.getTrueName());
		onmy.setDeptId(u.getDeptId());
		onmy.setSex(u.getUserSex());

		Map<String, LoginInfo> loginInfos = onmy.getLoginInfos();
		if (loginInfos == null) {
			loginInfos = new HashMap<String, LoginInfo>();
		}	
		 
		// 5. 登录认证 验证密码 
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(u.getId(),
					password);
			currentUser.login(token);// 登录认证 记录登陆信息 
			// 6.1 登录成功 保持一些用户信息到session中 
			mav.addObject(MsgConfig.STATUSCODE, MsgConfig.CODE_SUCCESS);
			mav.addObject(MsgConfig.MESSAGE, "msg.login.success");// 登录成功

			session.removeAttribute("jmpw");// 清除加密密码
			session.setAttribute("fromLogin", true);// 标记刚执行登陆操作
			return mav;
		 
	}
	@Override
	public boolean unlock(HttpSession session, String password) {
		SyUsers user = this.dao.get(SyUsers.class, ServletUtil
				.getMember().getId());
		if (MD5Util.MD5Validate(password, user.getUserPassword())) {
			session.removeAttribute("unlockPwd");
			session.removeAttribute("lock");
			return true;
		}
		return false;
	}

	@Override
	public String getDeptIds(String deptId, String orgId) {
		String deptIds = "'0'";

		boolean isFirst = false;
		boolean isSecond = false;
		SyDept dept = (SyDept) this.dao.findOne("from SyDept where id=?",
				new Object[] { deptId });
		if ((dept != null) && (dept.getSuperId().equals("0"))) {
			isFirst = true;
		}
		if (isFirst) {
			List<String> listId = this.dao
					.findsql("select id from Sy_Dept where org_Id='" + orgId
							+ "' and (id='" + deptId + "' or super_Id='"
							+ deptId + "') ");
			for (int i = 0; i < listId.size(); i++) {
				deptIds = deptIds + ",'" + listId.get(i) + "'";
				List<String> listId2 = this.dao
						.findsql("select id from Sy_Dept where org_Id='"
								+ orgId + "' and (id='"
								+ listId.get(i) + "' or super_Id='"
								+ listId.get(i) + "') ");
				for (int j = 0; j < listId2.size(); j++) {
					deptIds = deptIds + ",'" + listId2.get(j) + "'";
				}
			}
		} else {
			List<String> listId = this.dao
					.findsql("select id from Sy_Dept where   id='" + deptId
							+ "'");
			for (int i = 0; i < listId.size(); i++) {
				deptIds = deptIds + ",'" + listId.get(i) + "'";
				List<String> listId2 = this.dao
						.findsql("select id from Sy_Dept where org_Id='"
								+ orgId + "' and (id='"
								+ listId.get(i) + "' or super_Id='"
								+ listId.get(i) + "') ");
				for (int j = 0; j < listId2.size(); j++) {
					deptIds = deptIds + ",'" + listId2.get(j) + "'";
				}
			}
		}
		return deptIds;
	}
}
