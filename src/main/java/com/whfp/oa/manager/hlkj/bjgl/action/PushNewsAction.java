package com.whfp.oa.manager.hlkj.bjgl.action;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.PushNews;
import com.whfp.oa.manager.hlkj.bjgl.service.PushNewsService;

@Controller
@RequestMapping("/push")
public class PushNewsAction extends BaseAction {

	@Autowired
	private PushNewsService pushNewsService;
	
	/**
	 * 跳转到推送消息页面
	 * @return
	 */
	@RequiresPermissions("push:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/bjgl/tsxxload";
	}
	
	/**
	 * 按条件查询
	 * @param param
	 * @param pn
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("push:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,PushNews pn,Date startDate,Date endDate){	
		System.out.println("111111111111111111111111"+pn);
		System.out.println("22222222222222222222222222"+startDate);
		System.out.println("333333333333333333333333"+endDate);
		return ajaxJsonEscape(pushNewsService.findPagePushNews(param, pn, startDate, endDate));
		}
}
