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
import com.whfp.oa.manager.jd.bean.JdFlfg;
import com.whfp.oa.manager.jd.service.IJdflfgService;

/*
 * 法律法规action
 */
@Controller
@RequestMapping("/flfg")
public class JdflfgAction extends BaseAction{
	
	@Autowired
	private IJdflfgService service;

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("flfg:read")
	@RequestMapping("load")
	public String load(){
		return "jdpage/flfg/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("flfg:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdFlfg fg){ 
		
		return ajaxJsonEscape(service.select(param, fg));
		
	}
	@RequiresPermissions("flfg:add")
	@RequestMapping("addPage")
	public String addPage(){
		
		return "jdpage/flfg/add";
	}
	
	
	@RequiresPermissions("flfg:add")
	@RequestMapping("add")
	public ModelAndView addUser(@Valid JdFlfg fg){
		return ajaxDone(service.add(fg));
		
	}
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("flfg:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdFlfg  user=service.get(JdFlfg.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jc",user);
		return "jdpage/flfg/update";
	}
	
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("flfg:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		
		JdFlfg user=service.get(JdFlfg.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jc",user);
		
		return "jdpage/flfg/show";
	}
	@RequiresPermissions("flfg:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		System.out.println("删除数据");
		return ajaxDone(service.deleteUser(ids));
	}
}
