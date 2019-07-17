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
import com.whfp.oa.manager.rssq.bean.RssqCcsq;
import com.whfp.oa.manager.rssq.service.IRssqCcService;

@Controller
@RequestMapping("/cc")
public class CcAction extends BaseAction{
	
	@Autowired
	private IRssqCcService service;
	
	/**
	 * 添加出差申请信息
	 * @return
	 */
	@RequiresPermissions("cc:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid RssqCcsq p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addRssqCc(p));
	}
		

	
	/**
	 * 出差申请列表
	 * @return
	 */
	@RequiresPermissions("cc:loadList")
	@RequestMapping("loadList")
	public String loadList(){
		return "rssq/ccsq/list";
	}
	
	
	/**
	 * 出差申请列表逻辑
	 * @return
	 */
	@RequiresPermissions("cc:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,RssqCcsq q){
		return ajaxJsonEscape(service.selectRssqCc(param, q));
	}
	
	/**
	 * 批量删除出差申请信息
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("cc:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteRssqCc(ids));
	}
	
	
}
