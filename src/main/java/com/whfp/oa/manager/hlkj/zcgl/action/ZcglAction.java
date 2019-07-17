package com.whfp.oa.manager.hlkj.zcgl.action;

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
import com.whfp.oa.manager.hlkj.zcgl.bean.HlkjZcgl;
import com.whfp.oa.manager.hlkj.zcgl.service.IHlkjZcglService;

@Controller
@RequestMapping("/hlkj/zcgl")
public class ZcglAction extends BaseAction {
	@Autowired
	private IHlkjZcglService service;
	
	
	@RequiresPermissions("hlkj/zcgl:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/zcgl/list";
	}
	
	/*
	 * 查询资产列表信息
	 */
	@RequiresPermissions("hlkj/zcgl:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,HlkjZcgl q){
		return ajaxJsonEscape(service.selectZcgl(param, q));
	}
	
	/*
	 * 到添加地址信息页面
	 */
	@RequiresPermissions("hlkj/zcgl:toadd")
	@RequestMapping("toadd")
	public String toadd() {
		return "hlkj/zcgl/add";
	}
	
	/*
	 * 添加资产信息
	 */
	@RequiresPermissions("hlkj/zcgl:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid HlkjZcgl p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addZcgl(p));
	}
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("hlkj/zcgl:toupdate")
	@RequestMapping("toupdate")
	public String toupdate(String id, ModelMap map) {
		HlkjZcgl qq = service.selectById(id);
		map.addAttribute("list", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "hlkj/zcgl/update";
	}
	
	
	/**
	 * 修改资产信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("hlkj/zcgl:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid HlkjZcgl m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.updateZcgl(m));

	}
	
	
	/**
	 * 批量删除地址信息
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("hlkj/zcgl:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteZcgl(ids));
	}
	
	
	
	/**
	 * 查看资产信息
	 * 
	 * @return
	 */
	@RequiresPermissions("hlkj/zcgl:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		HlkjZcgl qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "hlkj/zcgl/show";
	}
}
