package com.whfp.oa.manager.rssq.action;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.rssq.bean.QxjDetile;
import com.whfp.oa.manager.rssq.service.IQxjDetileService;

@Controller
@RequestMapping("/qxj")
public class QxjAction extends BaseAction{
	
	@Autowired
	private IQxjDetileService service;
	
	/**
	 * 
	 * @return
	 */
	@RequiresPermissions("qxj:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid QxjDetile p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addQxjDetile(p));
	}
	
	
	
	
	/**
	 * 请休假列表
	 * @return
	 */
	@RequiresPermissions("qxj:loadList")
	@RequestMapping("loadList")
	public String loadList(){
		return "rssq/qxj/list";
	}
	
	
	/**
	 * 请休假列表逻辑
	 * @return
	 */
	@RequiresPermissions("qxj:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,QxjDetile q){
		return ajaxJsonEscape(service.selectQxjDetile(param, q));
	}
	
	/**
	 * 批量删除请休假信息
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("qxj:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteQxjDetile(ids));
	}
	
	
}
