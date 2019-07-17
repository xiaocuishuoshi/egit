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
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.manager.qyxc.bean.QyxcNews;
import com.whfp.oa.manager.qyxc.service.IQyxwService;

@Controller
@RequestMapping("/qyxw")
public class QyxwAction extends BaseAction{
	
	@Autowired
	private IQyxwService service;
	
	/**
	 * 新增企业简介跳转
	 * @return
	 */
	@RequiresPermissions("qyxw:load")
	@RequestMapping("load")
	public String load(){
		return "qyxc/qyxw/add";
	}
	
	/**
	 * 企业简介查询跳转
	 * @return
	 */
	@RequiresPermissions("qyxw:queryload")
	@RequestMapping("queryload")
	public String queryload(){
		return "qyxc/qyxw/query";
	}
	
	/**
	 * 企业简介列表逻辑
	 */
	@RequiresPermissions("qyxw:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,QyxcNews q){
		return ajaxJsonEscape(service.selectQyxw(param, q));
	}
	
	/**
	 * 新增企业简介
	 * @return
	 */
	@RequiresPermissions("qyxw:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid QyxcNews p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		
		p.setFbsj(DateUtil.currentTimestamp());
		return ajaxDone(service.addQyxw(p));
	}
	
	
	/**
	 * 查看企业简介信息
	 * 
	 * @return
	 */
	@RequiresPermissions("qyxw:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		QyxcNews qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyxw/show";
	}
	
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("qyxw:updateQQ")
	@RequestMapping("updateQQ")
	public String updateQQ(String id, ModelMap map) {
		QyxcNews qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyxw/showupdate";
	}
	
	
	
	
	/**
	 * 修改企业新闻信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("qyxw:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid QyxcNews m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		QyxcNews qq = service.selectById(m.getId());
		m.setFbsj(qq.getFbsj());
		return ajaxDone(service.updateQyxw(m));

	}
	
	
	
	/**
	 * 删除企业新闻
	 * @param m
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("qyxw:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteQyxw(ids));
	}
}
