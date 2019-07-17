package com.whfp.oa.manager.jiedu.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManContact;
import com.whfp.oa.manager.jiedu.bean.JdManFiles;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Controller
@RequestMapping("/jiedu/man")
public class ManAction extends BaseAction{
	
	@Autowired
	private JdManService jdManService;
	
	@RequestMapping("list")
	public String list(){
		return "jiedu/man/list";
	}
	
	@RequiresPermissions("jbxx:read")
	@RequestMapping("view")
	public String view(String id, ModelMap map){
		

		JdRyb user = jdManService.get(JdRyb.class, id);
		if (user == null) {
			return NODATA;
		}
		
		map.addAttribute("jd", user);
		return "jiedu/man/view-all";
	}
	
	/**
	 * 戒毒人员的亲属关系（列表、iud）
	 * @param uid
	 * @return
	 */
	@RequestMapping("relationship")
	public String relationship(Model model,String uid){
		
		JdRyb user = jdManService.get(JdRyb.class,uid);
		
		model.addAttribute("man", user);
		return "jiedu/man/relationship-list";
	}
	
	@RequestMapping("contact")
	public String contact(Model model,String uid){
		JdRyb user = jdManService.get(JdRyb.class,uid);
		
		List<JdManContact> list= jdManService.findContactListBy(uid);
		
		model.addAttribute("man", user);
		model.addAttribute("list", list);
		return "jiedu/man/contact-list";
	}
	
	@RequestMapping("work")
	public String work(Model model,String uid){
		JdRyb user = jdManService.get(JdRyb.class,uid);
		
		model.addAttribute("man", user);
		return "jiedu/man/work-list";
	}
	
	@RequestMapping("files")
	public String files(Model model,String uid){
		JdRyb user = jdManService.get(JdRyb.class,uid);
		
		List<JdManFiles> files0= jdManService.findFilesListBy(uid, 0);
		List<JdManFiles> files1= jdManService.findFilesListBy(uid, 1);
		
		model.addAttribute("man", user);
		model.addAttribute("files0", files0);
		model.addAttribute("files1", files1);
		return "jiedu/man/files-list";
	}
}
