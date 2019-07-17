package com.whfp.oa.manager.qyxc.action;

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
import com.whfp.oa.manager.qyxc.bean.QyxcQyjj;
import com.whfp.oa.manager.qyxc.service.IQyxcService;

@Controller
@RequestMapping("/qyxc")
public class QyxcAction extends BaseAction{
	
	@Autowired
	private IQyxcService service;
	
	/**
	 * 新增企业简介跳转
	 * @return
	 */
	@RequiresPermissions("qyxc:load")
	@RequestMapping("load")
	public String load(){
		return "qyxc/qyjj/add";
	}
	
	/**
	 * 企业简介查询跳转
	 * @return
	 */
	@RequiresPermissions("qyxc:queryload")
	@RequestMapping("queryload")
	public String queryload(){
		return "qyxc/qyjj/query";
	}
	
	/**
	 * 企业简介列表逻辑
	 */
	@RequiresPermissions("qyxc:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,QyxcQyjj q){
		return ajaxJsonEscape(service.selectQyjj(param, q));
	}
	
	/**
	 * 新增企业简介
	 * @return
	 */
	@RequiresPermissions("qyxc:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid QyxcQyjj p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addQyjj(p));
	}
	
	
	/**
	 * 查看企业简介信息
	 * 
	 * @return
	 */
	@RequiresPermissions("qyxc:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		QyxcQyjj qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyjj/show";
	}
	
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("qyxc:updateQQ")
	@RequestMapping("updateQQ")
	public String updateQQ(String id, ModelMap map) {
		QyxcQyjj qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyjj/showupdate";
	}
	
	
	
	
	/**
	 * 修改企业简介信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("qyxc:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid QyxcQyjj m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.updateQyjj(m));

	}
}
