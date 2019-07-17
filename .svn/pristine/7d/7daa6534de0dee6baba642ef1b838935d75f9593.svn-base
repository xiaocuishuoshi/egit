package com.whfp.oa.manager.app.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.jiedu.service.JieduCommService;
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IRoleService;

@Controller
@RequestMapping("/app/account")
public class AccountController  extends JsonBaseController{

	@Autowired
	private JieduCommService jieduCommService;
	
	@Autowired
	private IRoleService roleService;
	
	@PostMapping("/login")
	public @ResponseBody JsonBody<Map<String,Object>> login(String mobile,String passwd){
		
		Map<String,Object> result=new HashMap<>();
		
		if(StringUtils.isEmpty(mobile)) {
			
			return new JsonBody<>(-1,"手机号不能为空");
		}
		if(StringUtils.isEmpty(passwd)) {
			
			return new JsonBody<>(-1,"密码不能为空");
		}
		
		SyUsers u = (SyUsers) jieduCommService.findAccountByMobile(mobile);
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}
		
		if (!MD5Util.MD5Validate(passwd, u.getUserPassword())) {
			
			return new JsonBody<>(-1,"用户名密码不正确");
		}
		
		//查找角色
		List<String> roles= roleService.selectRolesByUserId(u.getId());
		
		if(roles.size()==0) {
			return new JsonBody<>(-1,"抱歉，没有权限，禁止登录");
		}
		
		//查找绑定戒毒人员
		
		SyDept dept= jieduCommService.get(SyDept.class, u.getDeptId());
		
		result.put("uid", u.getId());
		
		//0:戒毒人员,1:社区人员,2:社区警察,3:社区医生
		//result.put("utype", u.getUserName().length()==18?0:1);
		//result.put("uRole", u.getUserName().length()==18?"戒毒人员":"社区人员");
		
		if(roles.get(0).equals("戒毒人员")) {
		
			result.put("utype", 0);
			result.put("uRole", "戒毒人员");
			
		}else if(roles.get(0).equals("社区人员")) {
			
			result.put("utype", 1);
			result.put("uRole", "社区人员");
			
			//社区人员
			Map<String,Object> extra=new HashMap<>();
			extra.put("ingNum", 2);//进行中的戒毒人员
			extra.put("finishNum", 0);//已经完成的戒毒人员
			extra.put("visitorNum", "12");//走访次数
			extra.put("helpManNum", "0");//帮扶人数
			
			result.put("extra", extra);
			
		}else if(roles.get(0).equals("社区警察")) {
			
			result.put("utype", 2);
			result.put("uRole", "社区警察");
			
			Map<String,Object> extra=new HashMap<>();
			extra.put("ingNum", 2);
			extra.put("finishNum", 0);
			extra.put("visitorNum", "12");
			extra.put("helpManNum", "0");
			
			result.put("extra", extra);
			
		}else if(roles.get(0).equals("社区医生")) {
			
			result.put("utype", 3);
			result.put("uRole", "社区医生");
			
		}else {
			return new JsonBody<>(-1,"抱歉，限定外的角色，禁止登录");
		}
		
		result.put("trueName", u.getTrueName());
		result.put("sex", u.getUserSex());
		//result.put("", "中山社区");
		result.put("avatar", "");
		result.put("finishManNum", 0);//成功戒毒人员
		
		result.put("deptId", u.getDeptId());
		result.put("deptName", dept==null?"":dept.getDeptName());
		//result.put("orgId", u.getOrgId());
		//result.put("orgName", org==null?"":org.getOrgName());
		
		return new JsonBody<>(1,"登录成功",result);
	}
}
