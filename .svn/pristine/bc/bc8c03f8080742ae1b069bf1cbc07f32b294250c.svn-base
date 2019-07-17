package com.whfp.oa.manager.hlkj.nxfx.action;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.nxfx.bean.History;
import com.whfp.oa.manager.hlkj.nxfx.service.HistoryService;

@Controller
@RequestMapping("/ht")
public class HistoryAction extends BaseAction {

	@Autowired
	private HistoryService his;
	
	/**
	 * 跳转到历史记录页面
	 * @return
	 */
	@RequiresPermissions("ht:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/xnfx/load";
	}
	
	/**
	 * 按条件查询
	 * @param param
	 * @param sr
	 * @return
	 */
	@RequiresPermissions("ht:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,History h,Date startDate,Date endDate){
		return ajaxJsonEscape(his.findPageHistory(param, h, startDate, endDate));
	}
}
