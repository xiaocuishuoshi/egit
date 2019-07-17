package com.whfp.oa.manager.jd.action;

import java.io.UnsupportedEncodingException;

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
import com.whfp.oa.manager.jd.bean.JdYjsb;
import com.whfp.oa.manager.jd.service.IYjsbService;



@Controller

@RequestMapping("/yjsb")

public class YjsbAction extends BaseAction{
	@Autowired
	private IYjsbService service;

	/**
	 * 跳转到越级上报管理页面
	 * @return
	 */
	@RequiresPermissions("yjsb:read")
	@RequestMapping("load")
	public String load(){
		return "jdpage/yjsb/load";
	}
	
	
	/**
	 * 查询越级上报用户
	 * @return
	 */
	@RequiresPermissions("yjsb:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdYjsb jd){ 
		
		//jd.setFkDeptId(deptId);
		return ajaxJsonEscape(service.selectYjsb(param, jd));
		
	}
	/**
	 * 跳转到新的越级上报页面
	 * @return
	 */
	@RequiresPermissions("yjsb:add")
	@RequestMapping("addPage")
	public String addYjsbPage(){

		return "jdpage/yjsb/add";
	}
	/**
	 * 添加越级上报信息
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequiresPermissions("yjsb:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid JdYjsb jd,Errors errors,ModelMap map){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		
		System.out.println("进入添加方法");
		return ajaxDone(service.addYjsb(jd));
	}
	
	

	/**
	 * 删除越级上报信息
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("yjsb:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		
		return ajaxDone(service.deleteYjsb(ids));
	}
	
	/**
	 * 跳转到越级上报编辑页面
	 * @return
	 */
	@RequiresPermissions("yjsb:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdYjsb user=service.get(JdYjsb.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("yjsb",user);
		return "jdpage/yjsb/update";
	}
	/**
	 * 修改越级上报
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("yjsb:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdYjsb jd,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors,"userPassword");
			if(mav!=null)return mav;
        } 
		return ajaxDone(service.updateYjsb(jd));
		
	}
	
	
	/**
	 * 查看越级上报详情
	 * @return
	 */
	@RequiresPermissions("yjsb:read")
	@RequestMapping("show")
	public String showYjsb(String id,ModelMap map){
		
		JdYjsb yb=service.selectYb(id);
		if(yb==null){
			return NODATA;
		}
		
		map.addAttribute("yb",yb);
		
		return "jdpage/yjsb/show";
	}
	public static void main(String[] args) {
		System.out.println("12345");
	}
	

}
