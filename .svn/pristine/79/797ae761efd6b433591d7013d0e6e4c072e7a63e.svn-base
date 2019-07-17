package com.whfp.oa.manager.jd.action;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdTzs;
import com.whfp.oa.manager.jd.bean.JdTzsmb;
import com.whfp.oa.manager.jd.service.ITzsglService;
import com.whfp.oa.manager.system.service.IDeptService;


@SuppressWarnings("unused")
@Controller
@RequestMapping("/tzsgl")
public class TzsglAction extends BaseAction{
	
	@Autowired
	private ITzsglService service;

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("tzsgl:read")
	@RequestMapping("load")
	public String load(){
		
		System.out.println("进入方法"+"##############");
		return "jdpage/tzsgl/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("tzsgl:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectTzsmb(PageParam param,JdTzsmb jd){ 
		
		return ajaxJsonEscape(service.selectTzsmb(param, jd));
		
	}
	
	
	
	
	/**
	 * 跳转到新增用户界面
	 * @return
	 */
	@RequiresPermissions("tzsgl:add")
	@RequestMapping("addPage")
	public String addUsersPage(){

		return "jdpage/tzsgl/add";
	}
	/**
	 * 添加用户
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequiresPermissions("tzsgl:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid JdTzsmb jd,Errors errors,ModelMap map){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		return ajaxDone(service.addTzsmb(jd));
	}
	
	

	/**
	 * 删除用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("tzsgl:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		
		return ajaxDone(service.deleteTzsmb(ids));
	}


	
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("tzsgl:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdTzsmb user=service.get(JdTzsmb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("tzsmb",user);
		
		return "jdpage/tzsgl/update";
	}
	/**
	 * 修改用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("tzsgl:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdTzsmb jd,Errors errors){
		System.out.println(jd.getId()+"@@");
		return ajaxDone(service.updateTzsmb(jd));
		
	}
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("tzsgl:read")
	@RequestMapping("show")
	public String showTzsmd(String id,ModelMap map){
		
		JdTzsmb tzsmb=service.get(JdTzsmb.class, id);
		if(tzsmb==null){
			return NODATA;
		}
		map.addAttribute("tzsmb",tzsmb);
		
		return "jdpage/tzsgl/show";
	}

}
