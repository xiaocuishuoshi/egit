package com.whfp.oa.manager.jd.action;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jd.service.IShqzService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shqz")
public class ShqzAction extends BaseAction {
	@Autowired
	private HttpSession session;
	@Autowired
	private IShqzService service;

	@RequiresPermissions("shqz:read")
	@RequestMapping("load")
	public String load(ModelMap map) {
		return "jdpage/shqz/load";
	}

	@RequiresPermissions("shqz:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param, JdShqz jd) {
		return ajaxJsonEscape(service.select(param, jd));
	}

	@RequiresPermissions("shqz:update")
	@RequestMapping("updatePage")
	public String updatePage(String id, ModelMap map) {
		JdShqz user = service.get(JdShqz.class, id);
		if (user == null) {
			return "nodata";
		}
		map.addAttribute("shqz", user);
		return "jdpage/shqz/update";
	}

	@RequiresPermissions("shqz:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdShqz jd, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors,new String[] { "userPassword" });
			if (mav != null) {
				return mav;
			}
		}
		jd.setHfrxm(session.getAttribute("name").toString());
		return ajaxDone(service.update(jd));
	}

	@RequestMapping("del")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.delete(ids));
	}

	@RequiresPermissions("shqz:read")
	@RequestMapping("show")
	public String showTzs(String id, ModelMap map) {
		JdShqz user = service.get(JdShqz.class, id);
		if (user == null) {
			return "nodata";
		}
		map.addAttribute("shqz", user);

		service.update(user);

		return "jdpage/shqz/show";
	}
}
