package com.whfp.oa.manager.gwsp.action;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.manager.gwsp.bean.OaFwb;
import com.whfp.oa.manager.personalOffice.service.IScheduleService;


@Controller
@RequestMapping("/gwsp")
public class gwspAction  extends BaseAction{

	@Autowired
	private IScheduleService service;
	
	
	/**
	 *公文发送
	 */
	@RequiresPermissions("gwsp:add")
	@RequestMapping("add")
	public String add(){
		return "gwsp/gwsp/add";
	}
//	public ModelAndView add(@Valid OaFwb s,Errors errors){
//		if(errors.hasErrors()) {  
//			ModelAndView mav=getValidationMessage(errors);
//			if(mav!=null)return mav;
//        }
//		//s.setNgr(ServletUtil.getMember().getId());
//		return ajaxDone(service.save(s));
//	}
	/**
	 *待办公文查询
	 */
	@RequiresPermissions("gwsp:load")
	@RequestMapping("load")
	public String load(){
		return "gwsp/gwsp/load";
	}
	
	
	
	@RequiresPermissions("gwsp:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid OaFwb s,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
			return ajaxDone(service.save(s));
	}
	/**
	 *已办公文查询
	 */
	@RequiresPermissions("gwsp:search")
	@RequestMapping("search")
	public String search(){
		return "gwsp/gwsp/search";
	}
	
	
	
	
	
//	/**
//	 * 日程安排管理页面
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("manage/load")
//	public String manageLoad(){
//		
//		return "personalOffice/schedule/query";
//	}
//	/**
//	 * 日程安排管理
//	 * @param param
//	 * @param s
//	 * @param startDate
//	 * @param endDate
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("manage/query")
//	public ModelAndView query(PageParam param,PerSchedule s,Date startDate,Date endDate){
//		s.setUserId(ServletUtil.getMember().getId());
//		
//		return ajaxJsonEscape(service.selectSchedule(param, s, startDate, endDate));
//	}
//	/**
//	 * 跳转到添加页面
//	 * @return
//	 */
//	@RequestMapping("addPage")
//	public String addPage(){
//		
//		return "personalOffice/schedule/add";
//	}
//	/**
//	 * 添加日程
//	 * @param s
//	 * @param errors
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("add")
//	public ModelAndView add(@Valid PerSchedule s,Errors errors){
//		if(errors.hasErrors()) {  
//			ModelAndView mav=getValidationMessage(errors);
//			if(mav!=null)return mav;
//        }
//		s.setUserId(ServletUtil.getMember().getId());
//		return ajaxDone(service.save(s));
//		
//	}
//	/**
//	 * 跳转到日程安排编辑页面
//	 * @param id
//	 * @param map
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("updatePage")
//	public String updatePage(String id,ModelMap map){
//		PerSchedule s=service.get(PerSchedule.class, id);
//		if(s==null){
//			return NODATA;
//		}
//		if(!ServletUtil.getMember().getId().equals(s.getUserId())){
//			return NOPOWER;
//		}
//		map.addAttribute("s",s);
//		return "personalOffice/schedule/update";
//	}
//	/**
//	 * 修改日程安排
//	 * @param s
//	 * @param errors
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("update")
//	public ModelAndView update(@Valid PerSchedule s,Errors errors){
//		if(errors.hasErrors()) {  
//			ModelAndView mav=getValidationMessage(errors);
//			if(mav!=null)return mav;
//        }
//		s.setUserId(ServletUtil.getMember().getId());
//		return ajaxDone(service.updateSchedule(s));
//		
//	}
//	/**
//	 * 查看日程安排详情
//	 * @param id
//	 * @param map
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("show")
//	public String show(String id,ModelMap map){
//		PerSchedule s=service.get(PerSchedule.class, id);
//		if(s==null){
//			return NODATA;
//		}
//		if(!ServletUtil.getMember().getId().equals(s.getUserId())){
//			return NOPOWER;
//		}
//		map.addAttribute("s",s);
//		return "personalOffice/schedule/show";
//	}
//	
//	/**
//	 * 删除日程安排
//	 * @param ids
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("del")
//	public ModelAndView delete(String[] ids){
//		
//		return ajaxDone(service.deleteSchedule(ids));
//	
//	}
//	
//	/**
//	 * 查询出今日日程安排，用于js提醒
//	 * @return
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping("queryWarn")
//	public ModelAndView queryWarn(){
//		
//		Map map=new HashMap();
//
//		map.put(MsgConfig.STATUSCODE, MsgConfig.CODE_SUCCESS);
//		
//		map.put("sch",service.selectAfterNowTodaySchedule());
//		
//		map.put("now",new Date().getTime());
//		
//		return ajaxJsonEscape(map);
//		
//	}
//	/**
//	 * 日程安排 查询 视图模式
//	 * @param start
//	 * @param end
//	 * @return
//	 */
//	@RequiresPermissions("schedule:read")
//	@RequestMapping("view/query")
//	public ModelAndView query(Date start,Date end){
//		
//		return ajaxJsonEscape(service.selectMySchedule(start, end));
//	}
	
}
