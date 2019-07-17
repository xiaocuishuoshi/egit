package com.whfp.oa.manager.jd.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ExcelUtils;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.system.service.IDeptService;
import com.whfp.oa.manager.system.service.ISystemLogService;

/**
 * 
 * 类名JbxxAction 功能：系统管理--人员管理--基本信息管理 详细：用户的增删改查 作者：zjh 版本：1.0
 * 
 * 
 */
@Controller
@RequestMapping("/jbxx")
public class JbxxAction extends BaseAction {

	@Autowired
	private IJdService service;

	@Autowired
	private IDeptService deptService; // 部门

	
	@Autowired
	private ISystemLogService logService; 
	/**
	 * 跳转到级别分类设置
	 * @return
	 */
	//@RequiresPermissions("jbxx:sz")
	@RequestMapping("sz")
	public String loadsz(String id,ModelMap map) {
		map.addAttribute("id",id);
		JdRyb user = service.get(JdRyb.class,id);
		map.addAttribute("user",user);
		return "jdpage/jbxx/sz";
	}
	  
	@RequestMapping("jbsz")
	public ModelAndView update(@Valid JdRyb jd, ModelMap map, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors, "设置失败！");
			if (mav != null)
				return mav;
			}
		JdRyb user = service.get(JdRyb.class, jd.getId());
		user.setJdRylb(jd.getJdRylb());
		user.setJdJb(jd.getJdJb());
		return ajaxDone(service.updateUser(user));

	}
	
	
	/**
	 * 跳转到用户管理页面
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:read")
	@RequestMapping("load")
	public String load(String lb,ModelMap map) {
		map.addAttribute("lb",lb);
		return "jdpage/jbxx/load";
	}

	/**
	 * 条件分页查询用户
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:read")
	@RequestMapping("queryUsers")
	public ModelAndView selectUsers(PageParam param, JdRyb jd, String deptId) {
		jd.setFkDeptId(deptId);
		return ajaxJsonEscape(service.selectUsers(param, jd));

	}

	/**
	 * 跳转到新增用户界面
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:add")
	@RequestMapping("addPage")
	public ModelAndView addUsersPage() {

		
		ModelAndView mv= new ModelAndView("jdpage/jbxx/add");
		mv.addObject("filePath","/image_space/default.jpg");
		return mv;
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	// @RequiresPermissions("jbxx:add")
	@RequestMapping("addUser")
	public ModelAndView add(@Valid JdRyb jd, ModelMap map, Errors errors,
			@RequestParam("jdRyxpFile") MultipartFile jdRyxpFile) {
		if (errors.hasErrors()) {
			return ajaxDoneError();
		}
		if (jdRyxpFile == null) {
			return ajaxDoneError();
		}
		System.out.println("进入添加方法");
		String savePath = "image_space";
		String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
		if (!jdRyxpFile.isEmpty()) {
			ModelAndView view = FileUtils.validateFile(jdRyxpFile,
					1024L * 1024 * 10, IMGTYPE, null);
			if (view != null)
				return ajaxDoneError();
			String uuid = FileUtils.getUUID();// uuid作为保存时的文件名
			String ext = FileUtils.getFileExt(jdRyxpFile.getOriginalFilename());// 获取文件后缀
			System.out.println("time:" + DateUtil.currentTimestamp().toString());
			jd.setJdRyxp(savePath + "/" + uuid + "." + ext);
			
			 File newFile = new File(BaseConfig.webPath+savePath+"/"+uuid+"."+ext);
			
			try {
				jdRyxpFile.transferTo(newFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		jd.setJdRylb(1); 
		jd.setJdJb(3);
		ModelAndView mv =  ajaxDone(service.addUser(jd));
		mv.addObject("filePath",jd.getJdRyxp());
		return mv;
	}

	/**
	 * 删除用户
	 * 
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("jbxx:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids) {

		return ajaxDone(service.deleteUser(ids));
	}

	/**
	 * 跳转到用户编辑页面
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:update")
	@RequestMapping("updatePage")
	public String updatePage(String id, ModelMap map) {
		System.out.println("ifd==" + id);
		JdRyb user = service.get(JdRyb.class, id);
		if (user == null) {
			return NODATA;
		}
		map.addAttribute("jd", user);
		return "jdpage/jbxx/update";
	}

	/**
	 * 修改用户
	 * 
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("jbxx:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid JdRyb jd, ModelMap map, Errors errors,
			@RequestParam("jdRyxpFile") MultipartFile jdRyxpFile) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors, "userPassword");
			if (mav != null)
				return mav;
		}
		
		
		if (errors.hasErrors()) {
			return ajaxDoneError();
		}
		if (jdRyxpFile == null) {
			return ajaxDoneError();
		}
		String savePath = "image_space";
		String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
		if (!jdRyxpFile.isEmpty()) {
			ModelAndView view = FileUtils.validateFile(jdRyxpFile,
					1024L * 1024 * 10, IMGTYPE, null);
			if (view != null)
				return ajaxDoneError();
			String uuid = FileUtils.getUUID();// uuid作为保存时的文件名
			String ext = FileUtils.getFileExt(jdRyxpFile.getOriginalFilename());// 获取文件后缀
			System.out.println("time:" + DateUtil.currentTimestamp().toString());
			jd.setJdRyxp(savePath + "/" + uuid + "." + ext);
			
		
			 File newFile = new File(BaseConfig.webPath+savePath+"/"+uuid+"."+ext);
			
			try {
				jdRyxpFile.transferTo(newFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			 
		}
		return ajaxDone(service.updateUser(jd));

	}

	/**
	 * 查看用户详情
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:read")
	@RequestMapping("show")
	public String showUser(String id, ModelMap map) {

		JdRyb user = service.get(JdRyb.class, id);
		if (user == null) {
			return NODATA;
		}
		map.addAttribute("jd", user);

		return "jdpage/jbxx/show";
	}

	/**
	 * 查询全部人员，和部门 全部人员数量 用于树结构显示
	 * 
	 * @return
	 */
	@RequestMapping("allUsers")
	public ModelAndView alllUsers() {

		List<JdRyb> list = service.selectAllUsers();
		List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
		for (JdRyb u : list) {
			Map<String, Object> user = new HashMap<String, Object>();
			user.put("id", u.getId());
			user.put("name", u.getJdRyxm());
			user.put("deptId", u.getFkDeptId());
			user.put("sex", u.getJdRyxb());
			users.add(user);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MsgConfig.STATUSCODE, MsgConfig.CODE_SUCCESS);
		map.put("users", users);
		map.put("depts", deptService.selectAllDeptsMap());

		return ajaxJsonEscape(map);
	}

	/**
	 * 跳转到用户管理页面
	 * 
	 * @return
	 */
	@RequiresPermissions("jbxx:read")
	@RequestMapping("wgh")
	public String wgh(String lb,ModelMap map) {
		map.addAttribute("lb",lb);
		return "jdpage/jbxx/wgh";
	}
	
	/**
	 * 导出吸毒人员信息
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("jbxx:export")
	@RequestMapping("export")
	public String export(String[] ids,HttpServletRequest request,HttpServletResponse response){
	
		
		return ExcelUtils.export(service.selectJdry(ids), logService.findTableCustomExport((short)2), "档案.xls", request, response);

	}

}
