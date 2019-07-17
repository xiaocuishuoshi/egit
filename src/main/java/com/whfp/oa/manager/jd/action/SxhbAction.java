package com.whfp.oa.manager.jd.action;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdSxhb;
import com.whfp.oa.manager.jd.service.ISxhbService;


@Controller
@RequestMapping("/sxhb")
public class SxhbAction extends BaseAction{
	
	@Autowired
	private ISxhbService service;

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("sxhb:read")
	@RequestMapping("load")
	public String load(ModelMap map){
		
		return "jdpage/sxhb/load";
	}
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("sxhb:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdSxhb jd){ 
		
		return ajaxJsonEscape(service.select(param, jd));
		
	}
	
	
	
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("sxhb:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdSxhb user=service.get(JdSxhb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("sxhb",user);
		return "jdpage/sxhb/update";
	}
	/**
	 * 修改用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("sxhb:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdSxhb jd,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors,"userPassword");
			if(mav!=null)return mav;
        } 
		return ajaxDone(service.update(jd));
		
	}
	
	@RequestMapping("del")
	public ModelAndView delete(String [] ids){
		
		
		return ajaxDone(service.delete(ids));
		
	}
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("sxhb:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		
		JdSxhb user=service.get(JdSxhb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("sxhb",user);
		
		service.update(user);
		return "jdpage/sxhb/show";
	}
	
}
