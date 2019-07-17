package com.whfp.oa.manager.jd.action;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.service.JdKfjcService;
import com.whfp.oa.manager.jiedu.bean.ViewManKfjc;

@Controller
@RequestMapping("kfjc")
public class JdKfjcAction extends BaseAction {

	@Autowired
	private JdKfjcService service;
	
	
	/**
	 * 跳转到检查分析列表
	 * @return
	 */
	@RequestMapping("fxload")
	public String fxload(ModelMap map,String ryid) {
		map.addAttribute("ryid", ryid);
		return "jdpage/kfjc/syload";
	}
	
	
	
	/**
	 * 跳转到检查详情列表
	 * @return
	 */
	@RequestMapping("xqload")
	public String xqload(ModelMap map,String dh) {
		map.addAttribute("dh", dh);
		return "jdpage/kfjc/xqload";
	}
	
	
	
	
	/**
	 * 跳转到检查列表
	 * @return
	 */
	@RequestMapping("load")
	public String load(ModelMap map) {
		return "jdpage/kfjc/load";
	}
	
	
	/**
	 * 查询
	 * @param param
	 * @param sqzw
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView query(PageParam param, JdKfjc kfjc) {
	
		return ajaxJsonEscape(service.selectKfjc(param, kfjc));
	}
	
	@RequestMapping("querySum")
	public ModelAndView querySum(PageParam param, ViewManKfjc kfjc) {
		
		return ajaxJsonEscape(service.selectKfjcSum(param, kfjc));
	}

	/**
	 * 跳转到 添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String add(ModelMap map) {
		return "jdpage/kfjc/add";
	}

	/**
	 * 添加
	 * 
	 * @return sqzw
	 */
	@RequestMapping("addKfjc")
	public ModelAndView addKfjc(@Valid JdKfjc kfjc, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addKfjc(kfjc));
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("del")
	public ModelAndView deleteKfjc(String[] ids) {
		return ajaxDone(service.deleteKfjc(ids));
	}

}
