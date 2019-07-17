package com.whfp.oa.manager.jd.action;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdXc;
import com.whfp.oa.manager.jd.service.IJdxcService;

/*
 * 戒毒宣传action
 */
@Controller
@RequestMapping("/jdxc")
public class JdxcAction extends BaseAction{
	
	@Autowired
	private IJdxcService service;

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("jdxc:read")
	@RequestMapping("load")
	public String load(){
		return "jdpage/jdxc/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("jdxc:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdXc jc){ 
		
		return ajaxJsonEscape(service.select(param, jc));
		
	}
	@RequiresPermissions("jdxc:add")
	@RequestMapping("addPage")
	public String addPage(){
		
		return "jdpage/jdxc/add";
	}
	
	
	@RequiresPermissions("jdxc:add")
	@RequestMapping("add")
	public ModelAndView addUser(@Valid JdXc jc){
		return ajaxDone(service.addJdxc(jc));
		
	}
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("jdxc:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdXc user=service.get(JdXc.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jc",user);
		return "jdpage/jdxc/update";
	}
	/**
	 * 修改用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("jdxc:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdXc jc){
		
		return ajaxDone(service.updateJdxc(jc));
		
	}
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("jdxc:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		
		JdXc user=service.get(JdXc.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jc",user);
		
		return "jdpage/jdxc/show";
	}
	@RequiresPermissions("jdxc:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		System.out.println("进入删除fangdfa");
		return ajaxDone(service.deleteUser(ids));
	}
}
