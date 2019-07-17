package com.whfp.oa.manager.jd.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.system.service.IDeptService;

/**
 * 
 *  类名RydaAction
 * 功能：系统管理--人员管理--人员档案管理
 * 详细：戒毒人员的增删改查
 * 作者：zjh
 * 版本：1.0
 *
 */ 
 
@Controller
@RequestMapping("/ryda")
public class RydaAction extends BaseAction{
	
	@Autowired
	private IJdService service;

	@Autowired
	private IDeptService deptService; //部门
	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("ryda:read")
	@RequestMapping("load")
	public String load(){ 
		return "jdpage/ryda/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("ryda:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdRyb jd,String deptId){ 
		
		jd.setFkDeptId(deptId);
		return ajaxJsonEscape(service.selectUsers(param, jd));
		
	}
	
	
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("ryda:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdRyb user=service.get(JdRyb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jd",user);
		return "jdpage/ryda/update";
	}
	/**
	 * 修改用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("ryda:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdRyb jd,Errors errors){
		/*if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors,"userPassword");
			if(mav!=null)return mav;
        } */
		return ajaxDone(service.updateUser(jd));
		
	}
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("ryda:read")
	@RequestMapping("show")
	public String showUser(String id,ModelMap map){
		
		JdRyb user=service.get(JdRyb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jd",user);
		
		return "jdpage/ryda/show";
	}
	/**
	 * 查询全部人员，和部门 全部人员数量  用于树结构显示
	 * @return
	 */
	@RequestMapping("allUsers")
	public ModelAndView alllUsers(){
		
		List<JdRyb> list=service.selectAllUsers();
		List<Map<String,Object>> users=new ArrayList<Map<String,Object>>();
		for(JdRyb u:list){
			Map<String,Object> user=new HashMap<String,Object>();
			user.put("id", u.getId());
			user.put("name", u.getJdRyxm());
			user.put("deptId", u.getFkDeptId());
			user.put("sex", u.getJdRyxb());
			users.add(user);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put(MsgConfig.STATUSCODE, MsgConfig.CODE_SUCCESS);
		map.put("users", users);
		map.put("depts", deptService.selectAllDeptsMap());
		
		return ajaxJsonEscape(map);
	}
}
