package com.whfp.oa.manager.jd.action;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.gt.Notification;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.manager.jd.bean.JdDhyj;
import com.whfp.oa.manager.jd.service.IJdXXjgService;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IUserService;



@Controller
@RequestMapping("/xxjg")
public class XXjgAction extends BaseAction{
	
	@Autowired
	private IJdXXjgService service;

	@Autowired
	private HttpSession session; 
	
	@RequiresPermissions("xxjg:read")
	@RequestMapping("load")
	public String load(){
		return "jdpage/xxjg/load";
	}
	
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("xxjg:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param,JdDhyj fg){ 
		return ajaxJsonEscape(service.select(param, fg));
	}
	@RequiresPermissions("xxjg:add")
	@RequestMapping("addPage")
	public String addPage(){
		
		return "jdpage/xxjg/add";
	}
	
	@RequestMapping("lookUpPage")
	public String lookUpPage(Integer type){
		
		return "jdpage/xxjg/lookup";
		
	}
	
	@RequiresPermissions("xxjg:add")
	@RequestMapping("add")
	public ModelAndView addUser(@Valid JdDhyj fg,String cid) {
		
		fg.setFssj(DateUtil.currentDateTimeToString());
		String name=session.getAttribute("name").toString();	
		String uname=session.getAttribute("uname").toString(); //登陆账号
		fg.setFsrxm(name);
		//String id=service.selectId(uname);
		List<Object[]> list=service.findsj(" select cid,id from Sy_Users where user_Name='"+uname+"' ");	
		if(list.size()>0&&list.get(0)[0]!=null)  
			cid=list.get(0)[0].toString();
		System.out.println("登录账号:"+uname+"手机Id："+cid);
//		if(id == null){
//			return ajaxDoneError();
//		}
		fg.setJsrid(cid);
		try {
			if(! new Notification().pushMsg(cid, "信息警告!", fg.getFsnr())){
				System.out.println("送失败"+cid);
				return ajaxDoneError();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError();
		}
		
		return ajaxDone(service.add(fg));
		
	}
	/**
	 * 跳转到用户编辑页面
	 * @return
	 */
	@RequiresPermissions("xxjg:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		JdDhyj  user=service.get(JdDhyj.class, id);
		if(user==null){
			return NODATA;
		}
		map.addAttribute("jc",user);
		return "jdpage/xxjg/update";
	}
	
	
	
	/**
	 * 查看用户详情
	 * @return
	 */
	@RequiresPermissions("xxjg:read")
	@RequestMapping("show")
	public String showTzs(String id,ModelMap map){
		
		JdDhyj user=service.get(JdDhyj.class, id);
		if(user==null){
			return NODATA;
		}
//		String deptid=pz.getDeptId();
//		SyDept dept=service.get(SyDept.class, deptid);
		
		map.addAttribute("jc",user);
		
		return "jdpage/xxjg/show";
	}
	@RequiresPermissions("xxjg:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		System.out.println("删除数据");
		return ajaxDone(service.deleteUser(ids));
	}
}
