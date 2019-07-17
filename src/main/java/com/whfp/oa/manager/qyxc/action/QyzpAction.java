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
import com.whfp.oa.manager.qyxc.bean.QyxcZpxx;
import com.whfp.oa.manager.qyxc.service.IZpxxService;

@Controller
@RequestMapping("/qyzp")
public class QyzpAction extends BaseAction{
	
	@Autowired
	private IZpxxService service;
	
	/**
	 * 新增企业简介跳转
	 * @return
	 */
	@RequiresPermissions("qyzp:load")
	@RequestMapping("load")
	public String load(){
		return "qyxc/qyzp/add";
	}
	
	/**
	 * 企业简介查询跳转
	 * @return
	 */
	@RequiresPermissions("qyzp:queryload")
	@RequestMapping("queryload")
	public String queryload(){
		return "qyxc/qyzp/query";
	}
	
	/**
	 * 企业简介列表逻辑
	 */
	@RequiresPermissions("qyzp:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,QyxcZpxx q){
		return ajaxJsonEscape(service.selectQyzp(param, q));
	}
	
	/**
	 * 新增企业简介
	 * @return
	 */
	@RequiresPermissions("qyzp:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid QyxcZpxx p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		
		//p.setFbsj(DateUtil.currentTimestamp());
		return ajaxDone(service.addQyzp(p));
	}
	
	
	/**
	 * 查看企业简介信息
	 * 
	 * @return
	 */
	@RequiresPermissions("qyzp:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		QyxcZpxx qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyzp/show";
	}
	
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("qyzp:updateQQ")
	@RequestMapping("updateQQ")
	public String updateQQ(String id, ModelMap map) {
		QyxcZpxx qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qyzp/showupdate";
	}
	
	
	
	
	/**
	 * 修改企业新闻信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("qyzp:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid QyxcZpxx m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		//m.setFbsj(DateUtil.string2Timestamp(m.getFbsj().toString()));
		return ajaxDone(service.updateQyzp(m));

	}
	
	
	
	/**
	 * 删除企业新闻
	 * @param m
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("qyzp:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteQyzp(ids));
	}
}
