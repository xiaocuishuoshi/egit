package com.whfp.oa.manager.jd.action;

import java.io.UnsupportedEncodingException;
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
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdTzs;
import com.whfp.oa.manager.jd.service.ITzsService;


@Controller
@RequestMapping("/tzs")
public class TzsAction extends BaseAction{
	
	@Autowired
	private ITzsService service;

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("tzs:read")
	@RequestMapping("load")
	public String load(ModelMap map){
		
		List list=service.SelectweiDu();
		Object msg=list.get(0);
		System.out.println("接受信息:"+msg);
		map.addAttribute("msg",msg.toString());
		return "jdpage/tzs/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("tzs:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdTzs jd){ 
		
		//jd.setFkDeptId(deptId);
		return ajaxJsonEscape(service.selectTzs(param, jd));
		
	}
	/**
	 * 跳转到新增用户界面
	 * @return
	 */
	@RequiresPermissions("tzs:add")
	@RequestMapping("addPage")
	public String addTzsPage(){

		return "jdpage/tzs/add";
	}
	/**
	 * 添加用户
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequiresPermissions("tzs:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid JdTzs jd,String cjry,String tzsjsrid,ModelMap map){
		
		
		String [] ryxm=cjry.split(",");
		String [] id=tzsjsrid.split(",");
		//通知书群发
		if(ryxm!=null && id!=null && (id.length==ryxm.length)){
			final int len = ryxm.length;
			for (int index=0;index<len;index++) {
					String name=ryxm[index];
					String i=id[index];
					JdTzs js= new JdTzs();
					js.setTzsmc(jd.getTzsmc());
					js.setTzsnr(jd.getTzsnr());
					js.setTzsjsrid(i);
					js.setTzsjsrxm(name);
					String p=service.addTzs(js);
					
					if(p.equals(MsgConfig.MSG_KEY_SUCCESS)){
						continue;
					}
					
					return ajaxDone(MsgConfig.MSG_KEY_FAIL);
			}
			return ajaxDone(MsgConfig.MSG_KEY_SUCCESS);
				
		}
		return ajaxDone(MsgConfig.MSG_KEY_FAIL);
		
	}
	
	

	/**
	 * 删除用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("tzs:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		
		return ajaxDone(service.deleteTzs(ids));
	}
	
	//结果处理
	@RequestMapping("qrtz")
	public String updateqrtz(String id,ModelMap map){
		JdTzs user=service.get(JdTzs.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("tzs",user);
		return "jdpage/tzs/qrtz";
	}
	
	//结果处理
	@RequestMapping("updateQrtzDo")
	public ModelAndView updateQrtzDo(@Valid JdTzs jd,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors,"userPassword");
			if(mav!=null)return mav;
        } 
		JdTzs js=service.get(JdTzs.class, jd.getId());
		
		js.setBz(jd.getBz());
		return ajaxDone(service.updateTzs(js));
		
	}
	
	
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("tzs:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdTzs user=service.get(JdTzs.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("tzs",user);
		return "jdpage/tzs/update";
	}
	/**
	 * 修改用户
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("tzs:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdTzs jd,Errors errors){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors,"userPassword");
			if(mav!=null)return mav;
        } 
		JdTzs js=service.get(JdTzs.class, jd.getId());
		
		js.setTzsmc(jd.getTzsmc());
		js.setTzsjsrxm(jd.getTzsjsrxm());
		js.setTzsnr(jd.getTzsnr());
		
		return ajaxDone(service.updateTzs(js));
		
	}
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("tzs:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		
		JdTzs user=service.get(JdTzs.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("tzs",user);
		
		
		service.updateTzs(user);
		return "jdpage/tzs/show";
	}
	
}
