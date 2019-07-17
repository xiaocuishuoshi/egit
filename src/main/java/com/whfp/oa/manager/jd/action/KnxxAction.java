package com.whfp.oa.manager.jd.action;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdKnxx;
import com.whfp.oa.manager.jd.service.IJdKnxxService;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/knxx")
public class KnxxAction extends BaseAction {
	@Autowired
	private IJdKnxxService service;
	@Autowired
	private HttpSession session;

	@RequiresPermissions("knxx:read")
	@RequestMapping("load")
	public String load() {
		return "jdpage/knxx/load";
	}

	@RequiresPermissions("knxx:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param, JdKnxx fg) {
		return ajaxJsonEscape(this.service.select(param, fg));
	}

	@RequiresPermissions("knxx:read")
	@RequestMapping("show")
	public String showTzs(String id, ModelMap map) {
		JdKnxx user = this.service.get(JdKnxx.class, id);
		if (user == null) {
			return "nodata";
		}
		user.setYdzt("1");
		this.service.updateKnxx(user);
		map.addAttribute("jc", user);

		return "jdpage/knxx/show";
	}

	@RequiresPermissions("knxx:read")
	@RequestMapping("CkWz")
	public String CkWz(String id, ModelMap map, String lat, String lng) {
		JdKnxx user = this.service.get(JdKnxx.class, id);
		if (user == null) {
			return "nodata";
		}
		user.setYdzt("1");
		this.service.updateKnxx(user);

		this.session.setAttribute("list", user);
		this.session.setAttribute("lng", lng);
		this.session.setAttribute("lat", lat);

		return "jdpage/knxx/wz";
	}
}
