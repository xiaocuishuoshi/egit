package com.whfp.oa.manager.jd.action;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.manager.jd.bean.JdXdrypg;
import com.whfp.oa.manager.jd.service.JdXdrypgService;

@Controller
@RequestMapping("xdpg")
public class JdXdyrpgAction extends BaseAction {

	@Autowired
	private JdXdrypgService xdpgService;
	
	
	/**
	 * 跳转到吸毒人员评估页面
	 * @return
	 */
	@RequestMapping("load")
	public String load(ModelMap map) {
		return "jdpage/xdpg/load";
	}

	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param, JdXdrypg xdpg) {
		return ajaxJsonEscape(xdpgService.selectXdpg(param, xdpg));

	}

	/**
	 * 跳转到新增用户界面
	 * 
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "jdpage/xdpg/add";
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping("addXdpg")
	public ModelAndView addXdpg(@Valid JdXdrypg xdpg, ModelMap map, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		xdpg.setDate(DateUtil.currentTimestamp());
		return ajaxDone(xdpgService.addXdpg(xdpg));
	}

	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("del")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(xdpgService.deleteXdpg(ids));
	}

	
	/**
	 * 查看评估详情
	 * @return
	 */
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		JdXdrypg xdpg=xdpgService.get(JdXdrypg.class, id);
		if(xdpg==null){
			return NODATA;
		}
		map.addAttribute("xdpg",xdpg);
		return "jdpage/xdpg/show";
	}
}
