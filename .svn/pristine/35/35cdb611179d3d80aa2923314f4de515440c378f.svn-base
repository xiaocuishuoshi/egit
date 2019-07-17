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
import com.whfp.oa.manager.rssq.bean.RssqJzsq;
import com.whfp.oa.manager.rssq.service.IRssqJzService;

@Controller
@RequestMapping("/sqjz")
public class JzAction extends BaseAction{
	
	@Autowired
	private IRssqJzService service;
	
	/**
	 * 添加借支申请详细
	 * @return
	 */
	@RequiresPermissions("sqjz:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid RssqJzsq p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addRssqJz(p));
	}
	
	
	
	
	/**
	 * 借支申请列表
	 * @return
	 */
	@RequiresPermissions("sqjz:loadList")
	@RequestMapping("loadList")
	public String loadList(){
		return "rssq/jzsq/list";
	}
	
	
	/**
	 * 借支申请列表逻辑
	 * @return
	 */
	@RequiresPermissions("sqjz:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,RssqJzsq q){
		return ajaxJsonEscape(service.selectRssqJz(param, q));
	}
	
	/**
	 * 批量删除借支申请信息
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("sqjz:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteRssqJz(ids));
	}
	
	
}
