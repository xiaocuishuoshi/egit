package com.whfp.oa.manager.jd.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdQj;
import com.whfp.oa.manager.jd.service.IQjglService;
import com.whfp.oa.manager.jd.service.IShqzService;
import com.whfp.oa.manager.jd.service.ISxhbService;

@Controller
@RequestMapping("/qjgl")
public class QjglAction extends BaseAction{
	@Autowired
	private IQjglService service;
	@Autowired
	private ISxhbService service1;
	
	@Autowired
	private IShqzService service2;
	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("qjgl:read")
	@RequestMapping("load")
	public String load(ModelMap map){
		
		
		return "jdpage/qjgl/load";
	}
	@RequestMapping("countQj")
	public String countQj(ModelMap map,HttpServletResponse response){
		
		List list=service.SelectweiDu();
		List list2=service1.SelectweiDu();
		List list3=service2.SelectweiDu();
		 map.put("qj",list);
		 map.put("hb",list2);
		 map.put("qz",list3);
		try {
			response.getWriter().println(ajaxJson(map).getModelMap().get("msginfo").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 	null;
	}
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("qjgl:read")
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param,JdQj jd){ 
		
		return ajaxJsonEscape(service.selectQj(param, jd));
		
	}

	
	@RequiresPermissions("qjgl:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdQj user=service.get(JdQj.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("qj",user);
		return "jdpage/qjgl/updateSp";
	}
	
	@RequiresPermissions("qjgl:update")
	@RequestMapping("updatePageXj")
	public String updatePageXj(String id,ModelMap map){
		JdQj user=service.get(JdQj.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("qj",user);
		return "jdpage/qjgl/updateXj";
	}
	
	
	@RequiresPermissions("qjgl:update")
	@RequestMapping("updateSp")
	public ModelAndView update(@Valid JdQj jd,Errors errors){
		return ajaxDone(service.updateSp(jd));
		
	}
	

	@RequiresPermissions("qjgl:update")
	@RequestMapping("updateXj")
	public ModelAndView update1(@Valid JdQj jd,Errors errors){
		return ajaxDone(service.updateXj(jd));
		
	}
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("qjgl:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		System.out.println("id:"+id);
		JdQj user=service.get(JdQj.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("qj",user);
		
		
		service.update(user);
		return "jdpage/qjgl/show";
	}
	
}
