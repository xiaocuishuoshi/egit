package com.whfp.oa.manager.jd.action;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdPzxx;
import com.whfp.oa.manager.jd.service.IJdPzxxService;
import com.whfp.oa.manager.system.bean.SyDept;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pzsc")
public class PzscAction extends BaseAction {
	
	@Autowired
	private IJdPzxxService service;
	@Autowired
	private HttpSession session;

	@RequiresPermissions("pzsc:read")
	@RequestMapping("load")
	public String load() {
		System.out.println("进入方法##############");
		return "jdpage/pzsc/load";
	}

	@RequiresPermissions("pzsc:read")
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param, JdPzxx jd) {
		return ajaxJsonEscape(this.service.selectPzxxs(param, jd));
	}

	@RequestMapping("del")
	public ModelAndView deletePzsc(String[] ids) {
		return ajaxDone(this.service.deletePzxx(ids));
	}

	@RequiresPermissions("pzsc:read")
	@RequestMapping("show")
	public String show(String id, ModelMap map) {
		JdPzxx pz = this.service.get(JdPzxx.class, id);
		if (pz == null) {
			return "nodata";
		}
		String deptid = pz.getDeptId();
		SyDept dept = this.service.get(SyDept.class, deptid);
		if (dept == null) {
			return "nodata";
		}
		String deptName = dept.getDeptName();
		map.addAttribute("deptName", deptName);
		map.addAttribute("pz", pz);
		return "jdpage/pzsc/show";
	}

	@RequestMapping("CkWz")
	public String CkWz(String id, ModelMap map, String lat, String lng) {
		JdPzxx pz = this.service.get(JdPzxx.class, id);
		if (pz == null) {
			return "nodata";
		}
		this.session.setAttribute("list", pz);
		this.session.setAttribute("lat", pz.getLan());
		this.session.setAttribute("lng", pz.getLng());

		return "jdpage/pzsc/wz";
	}
}
