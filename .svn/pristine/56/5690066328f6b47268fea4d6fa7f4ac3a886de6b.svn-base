package com.whfp.oa.manager.hlkj.bjgl.action;

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
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRule;
import com.whfp.oa.manager.hlkj.bjgl.service.SirenRuleService;

@Controller
@RequestMapping("/sr")
public class SirenRuleAction extends BaseAction {

	@Autowired
	private SirenRuleService sirenRuleService;
	
	/**
	 * 跳转到报警规则页面
	 * @return
	 */
	@RequiresPermissions("sr:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/bjgl/load";
	}
	/**
	 * 按条件查询
	 * @param param
	 * @param sr
	 * @return
	 */
	@RequiresPermissions("sr:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,SirenRule sr){
		return ajaxJsonEscape(sirenRuleService.findPageSirenResle(param, sr));
	}
	
	/**
	 * 跳转到报警规则添加页面
	 * @return
	 */
	@RequiresPermissions("sr:add")
	@RequestMapping("add")
	public String add(){
		return "hlkj/bjgl/add";
	}
	
	/**
	 * 新增报警规则
	 * @param p
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("sr:addSirenRecord")
	@RequestMapping("addSirenRecord")
	public ModelAndView addSirenRule(@Valid SirenRule sr, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(sirenRuleService.addSirenRule(sr));
	}
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sr:update")
	@RequestMapping("update")
	public String update(String id, ModelMap map) {
		SirenRule sr = sirenRuleService.selectById(id);
		map.addAttribute("sr", sr);
		if(map.get("sr")==null){
			return NODATA;
		}
		return "hlkj/bjgl/update";
	}
	
	
	
	
	/**
	 * 修改报警规则信息
	 * @param sr
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("sr:updateSirenRule")
	@RequestMapping("updateSirenRule")
	public ModelAndView updateSirenRule(@Valid SirenRule sr, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(sirenRuleService.updateSirenRule(sr));

	}
	/**
	 * 删除报警规则
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unqualified-field-access")
	@RequiresPermissions("sr:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(sirenRuleService.deleteSirenRule(ids));
	}
}
