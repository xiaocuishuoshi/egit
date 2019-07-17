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
import com.whfp.oa.manager.qyxc.bean.QyxcProduct;
import com.whfp.oa.manager.qyxc.service.IQycpService;

@Controller
@RequestMapping("/qycp")
public class QycpAction extends BaseAction{
	
	@Autowired
	private IQycpService service;
	
	/**
	 * 新增企业简介跳转
	 * @return
	 */
	@RequiresPermissions("qycp:load")
	@RequestMapping("load")
	public String load(){
		return "qyxc/qycp/add";
	}
	
	/**
	 * 企业简介查询跳转
	 * @return
	 */
	@RequiresPermissions("qycp:queryload")
	@RequestMapping("queryload")
	public String queryload(){
		return "qyxc/qycp/query";
	}
	
	/**
	 * 企业简介列表逻辑
	 */
	@RequiresPermissions("qycp:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,QyxcProduct q){
		return ajaxJsonEscape(service.selectQycp(param, q));
	}
	
	/**
	 * 新增企业简介
	 * @return
	 */
	@RequiresPermissions("qycp:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid QyxcProduct p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		
		//p.setFbsj(DateUtil.currentTimestamp());
		return ajaxDone(service.addQycp(p));
	}
	
	
	/**
	 * 查看企业简介信息
	 * 
	 * @return
	 */
	@RequiresPermissions("qycp:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		QyxcProduct qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qycp/show";
	}
	
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("qycp:updateQQ")
	@RequestMapping("updateQQ")
	public String updateQQ(String id, ModelMap map) {
		QyxcProduct qq = service.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "qyxc/qycp/showupdate";
	}
	
	
	
	
	/**
	 * 修改企业新闻信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("qycp:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid QyxcProduct m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		//m.setFbsj(DateUtil.string2Timestamp(m.getFbsj().toString()));
		return ajaxDone(service.updateQycp(m));

	}
	
	
	
	/**
	 * 删除企业新闻
	 * @param m
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("qycp:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteQycp(ids));
	}
}
