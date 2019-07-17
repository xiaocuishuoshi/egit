package com.whfp.oa.manager.hlkj.bjgl.action;

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
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRecord;
import com.whfp.oa.manager.hlkj.bjgl.service.SirenRecordService;

@Controller
@RequestMapping("/reco")
public class SirenRecordAction extends BaseAction {

	@Autowired
	private SirenRecordService sirenRecordService;
	
	/**
	 * 跳转到报警记录页面
	 * @return
	 */
	@RequiresPermissions("reco:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/bjgl/show";
	}
	/**
	 * 按条件查询
	 * @param param
	 * @param sr
	 * @return
	 */
	@RequiresPermissions("reco:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,SirenRecord sr){
		return ajaxJsonEscape(sirenRecordService.findPageSirenRecord(param, sr));
	}
	
	/**
	 * 跳转到报警规则添加页面
	 * @return
	 */
	@RequiresPermissions("reco:add")
	@RequestMapping("add")
	public String add(){
		return "hlkj/bjgl/jiluadd";
	}
	
	/**
	 * 新增报警规则
	 * @param p
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("reco:addSirenRecord")
	@RequestMapping("addSirenRecord")
	public ModelAndView addSirenRecord(@Valid SirenRecord sr, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(sirenRecordService.addSirenRecord(sr));
	}
	
	
	/**
	 * 跳转到反馈结果页面
	 * 
	 * @return
	 */
	@RequiresPermissions("reco:update")
	@RequestMapping("update")
	public String update(String id, ModelMap map) {
		SirenRecord sr = sirenRecordService.selectById(id);
		map.addAttribute("sr", sr);
		if(map.get("sr")==null){
			return NODATA;
		}
		return "hlkj/bjgl/fkjgupdate";
	}
	/**
	 * 修改反馈结果
	 * @param sr
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("reco:updateSirenRecord")
	@RequestMapping("updateSirenRecord")
	public ModelAndView updateSirenRule(@Valid SirenRecord sr, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(sirenRecordService.updateSirenRecord(sr));

	}
}
