package com.whfp.oa.manager.hlkj.system.action;

import java.util.List;

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
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.manager.files.bean.ImageSpaceImg;
import com.whfp.oa.manager.hlkj.dict.bean.HlkjDict;
import com.whfp.oa.manager.hlkj.dict.service.IHlkjDiceService;
import com.whfp.oa.manager.hlkj.system.bean.HlkjAddress;
import com.whfp.oa.manager.hlkj.system.bean.HlkjTpt;
import com.whfp.oa.manager.hlkj.system.service.IHlkjAddress;

@Controller
@RequestMapping("/hlkj/address")
public class HlkjAddressAction extends BaseAction {
	@Autowired
	private IHlkjAddress service;
	
	@Autowired
	private IHlkjDiceService serviceD;
	
	@RequiresPermissions("hlkj/address:load")
	@RequestMapping("load")
	public String load(){
		return "hlkj/address/list";
	}
	
	
	@RequiresPermissions("hlkj/address:findSb")
	@RequestMapping("findSb")
	public String findSb(String taskId,ModelMap map){
		map.addAttribute("sbid", taskId);
		return "hlkj/address/treeAddress/loadTosb";
	}
	
	
	@RequiresPermissions("hlkj/address:findTp")
	@RequestMapping("findTp")
	public String findTp(String taskId,ModelMap map){
		HlkjAddress addss = new HlkjAddress();
		if(taskId!=null && !"".equals(taskId)){
			 addss = service.selectById(taskId);
		}
		map.addAttribute("addss",addss);	//地址信息
		
		 List<ImageSpaceImg> listimg = service.selectImg();	//图片列表
		map.addAttribute("listimg",listimg);
		
		
		return "hlkj/address/addressTp/loadTp";	//到添加拓扑图页面
	}
	
	/**
	 * 保存拓扑图
	 * @param p
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("hlkj/address:saveTp")
	@RequestMapping("saveTp")
	public ModelAndView saveTp(@Valid HlkjTpt p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		String ss = p.getTpBack();
		int s = ss.indexOf("*");
		int se = ss.indexOf("-");
		String backname = ss.substring(s+1, se);
		String backId = ss.substring(0,s);
		p.setTpBack(backname);
		p.setTpBackId(backId);
		p.setTpCreatetime(DateUtil.currentTimestamp());
		return ajaxDone(service.addTpt(p));
	}
	
	
	/**
	 * 到拓扑图列表
	 * @return
	 */
	@RequiresPermissions("hlkj/address:tplist")
	@RequestMapping("tplist")
	public String tplist(){
		return "hlkj/address/addressTp/list";
	}
	
	
	/*
	 * 查询拓扑图信息
	 */
	@RequiresPermissions("hlkj/address:querytp")
	@RequestMapping("querytp")
	public ModelAndView querytp(PageParam param,HlkjTpt q){
		return ajaxJsonEscape(service.selectTpt(param, q));
	}
	
	/**
	 * 批量删除拓扑图
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("hlkj/address:deletetp")
	@RequestMapping("deletetp")
	public ModelAndView deletetp(String[] ids) {
		return ajaxDone(service.deleteTpt(ids));
	}
	
	@RequiresPermissions("hlkj/address:toupdatetp")
	@RequestMapping("toupdatetp")
	public String toupdatetp(String id, ModelMap map) {
		HlkjTpt qq = service.selectTptById(id);
		map.addAttribute("qq", qq);
		ImageSpaceImg imgspa = service.selectImgById(qq.getTpBackId());
		map.addAttribute("savepath", imgspa.getSavePath());
		if(map.get("qq")==null){
			return NODATA;
		}
		 List<ImageSpaceImg> listimg = service.selectImg();	//图片列表
			map.addAttribute("listimg",listimg);
		return "hlkj/address/addressTp/update";
	}
	
	
	
	/**
	 * 修改拓扑图
	 * @param p
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("hlkj/address:updatetp")
	@RequestMapping("updatetp")
	public ModelAndView updatetp(@Valid HlkjTpt p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		String ss = p.getTpBack();
		int s = ss.indexOf("*");
		int se = ss.indexOf("-");
		String backname = ss.substring(s+1, se);
		String backId = ss.substring(0,s);
		p.setTpBack(backname);
		p.setTpBackId(backId);
		p.setTpCreatetime(DateUtil.currentTimestamp());
		
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.updateTpt(p));

	}
	
	
	
	
	
	
	/**
	 * 绑定设备地址更新设备表
	 * @param sbid	设备序号
	 * @param id	地址ID
	 * @param addre 地址名称
	 * @return
	 */
	@RequiresPermissions("hlkj/address:toupdateSb")
	@RequestMapping("toupdateSb")
	public String toupdateSb(String sbid,String id,String addre){
		// 地址
		HlkjAddress addss = service.selectById(id);
		String adsb="";
			if(addss.getAddressSb().indexOf(sbid)>=0){
				adsb = addss.getAddressSb()+" "+sbid;
			}else{
				adsb=addss.getAddressSb();
			}
		service.updateAddress(adsb,id);
		
		service.updateSBgl(addre,id,sbid);
		// 地址  sb
		return "hlkj/address/closeWin/closeWin";
	}
	/**
	 * 到tree
	 * @return
	 */
	@RequiresPermissions("hlkj/address:loadtr")
	@RequestMapping("loadtr")
	public String loadtr(){
		return "hlkj/address/treeAddress/load";
	}
	
	/**
	 * 查询左边tree
	 */
	@RequiresPermissions("hlkj/address:queryTree")
	@RequestMapping("queryTree")
	public ModelAndView queryTree(PageParam param,HlkjAddress q){
		return ajaxJsonEscape(service.selectAdd());
	}
	
	
	
	/*
	 * 查询地址列表信息
	 */
	@RequiresPermissions("hlkj/address:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,HlkjAddress q,String superId){
		q.setFather(superId);
		return ajaxJsonEscape(service.selectAddress(param, q));
	}
	
	
	/*
	 * 到添加地址信息页面
	 */
	@RequiresPermissions("hlkj/address:toadd")
	@RequestMapping("toadd")
	public String toadd(ModelMap map) {
		List<HlkjDict> list  = serviceD.selectDictList("dzlb");
		map.addAttribute("qq", list);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "hlkj/address/add";
	}
	
	
	/**
	 * 新增地址简介
	 * @return
	 */
	@RequiresPermissions("hlkj/address:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid HlkjAddress p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if(p.getFather()==null||"".equals(p.getFather())){
				p.setAddressJb("跟地址");
			}else{
				p.setAddressJb("子地址");
			}
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.addAddress(p));
	}
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("hlkj/address:toupdate")
	@RequestMapping("toupdate")
	public String toupdate(String id, ModelMap map) {
		HlkjAddress qq = service.selectById(id);
		map.addAttribute("qq", qq);
		
		List<HlkjDict> list  = serviceD.selectDictList("dzlb");
		map.addAttribute("list", list);
		
		if(map.get("qq")==null){
			return NODATA;
		}
		return "hlkj/address/update";
	}
	
	
	/**
	 * 修改地址信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("hlkj/address:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid HlkjAddress m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.updateAddress(m));

	}
	
	@RequiresPermissions("hlkj/address:show")
	@RequestMapping("show")
	public String show(String id, ModelMap map) {
		HlkjAddress qq = service.selectById(id);
		map.addAttribute("qq", qq);
		return "hlkj/address/show";
	}
		
	
	/**
	 * 批量删除地址信息
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("hlkj/address:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(service.deleteAddress(ids));
	}
	
}
