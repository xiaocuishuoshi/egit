/**  
 * @Project: fpoa
 * @Title: OrgAction.java
 * @Package com.whfp.oa.manager.system.action
 * @date 2015-3-4 下午4:11:32
 * @Copyright: 2015 
 */
package com.whfp.oa.manager.system.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.system.bean.SysOrg;
import com.whfp.oa.manager.system.service.IOrgService;

/**
 * 
 * 类名：OrgAction
 * 功能：系统管理--组织机构--单位管理
 * 详细：单位的增删改查     
 * 作者：shadow
 * 版本：1.0
 * 日期：2015-3-4 下午4:11:32
 *
 */
@Controller
@RequestMapping("/org")
public class OrgAction extends BaseAction{
	
	@Autowired
	private IOrgService service; 
	
	/**
	 * 跳转到单位加载页面,查询出所有单位
	 * @return
	 */
	@RequiresPermissions("org:read")
	@RequestMapping("load")
	public String load(ModelMap map,HttpServletResponse response){ 
	 
		try {
		 
			response.getWriter().println("11111111111111");
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/organize/org/load";
	
	}
	
	  
	/**
	 * 查询所有单位，返回json格式数据
	 * @return
	 */
	@RequestMapping("load/all")
	public ModelAndView allorg(){
		
		
		return ajaxJsonEscape(service.selectAllOrgsMap());
		
	}
	
	/**
	 * 跳转到单位添加页面
	 * @return
	 */
	@RequestMapping("addPage")
	public String addPage(){
		System.out.println("dsfasssssssssssss");
		return "system/organize/org/add";
	
	}
	/**
	 * 单位查询，查找带回
	 * @param param
	 * @param org
	 * @param type 1:单选，2：多选，3：上级单位查询
	 * @param map
	 * @return
	 */
	@RequestMapping("lookUpPage")
	public String lookUpPage(Integer type){
	
		if(type!=null){
			if(type==2){
				return "system/organize/org/lookup_more";
			}else{
				return "system/organize/org/lookup";
			}
		}else{
			
			return "system/organize/org/lookup";
		}
	}
	/**
	 * 单位查询，查找带回
	 * @param param
	 * @param org
	 * @param type 1:单选，2：多选，3：上级单位查询
	 * @param map
	 * @return
	 */
	@RequestMapping("lookUp")
	public ModelAndView lookUp(PageParam param,SysOrg org){
		
		return ajaxJsonEscape(service.selectOrgs(param, org));
	}
	/**
	 * 添加单位
	 * @param org
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("org:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid SysOrg org,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		
		return ajaxDone(service.addOrg(org));
		
	}
	/**
	 * 单位修改页面 
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		SysOrg org=service.get(SysOrg.class,id);
		if(org==null){
			return NODATA;
		}
		map.addAttribute("org",org);
		
		return "system/organize/org/update";
	}
	
	/**
	 * 修改单位
	 * @param org
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("org:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid SysOrg org,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		return ajaxDone(service.updateOrg(org));
	}
	/**
	 * 删除单位
	 * @param id
	 * @return
	 */
	@RequiresPermissions("org:delete")
	@RequestMapping("del")
	public ModelAndView delete(String id){
		
		return ajaxDone(service.deleteOrg(id));
	
	}
	/**
	 * 查询单位名称	
	 * @param ids 单位id，多个用，隔开
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("getOrgNamesById")
	public ModelAndView getOrgNamesByIds(String ids){
		
		Map map=new HashMap();
	
		map.put("names",MyCache.getInstance().getOrgName(ids));
		
		return ajaxJsonEscape(map);
	
	}
	
}
