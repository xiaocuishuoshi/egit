/**  
 * @Project: 
 * @Title: JournalAction.java
 * @Package com.whfp.oa.manager.coordination.action
 * @date 2013-5-23 上午10:13:13
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.coordination.action;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.exception.MyRuntimeException;
import com.whfp.oa.commons.model.FileList;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.coordination.bean.XtJournal;
import com.whfp.oa.manager.coordination.service.IJournalService;

/**
 * 
 * 类名：JournalAction
 * 功能：协同办公--日志管理
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-5-23 上午10:13:13
 *
 */
@Controller
@RequestMapping("/journal")
public class JournalAction extends BaseAction{
	@Autowired
	private IJournalService service;
	
	
	/**
	 * 工作计划上传的保存路径
	 */
	private static final String SAVEPATH=BaseConfig.uploadPath+"journal";
	
	/**
	 * 查询出我的日志
	 */
	@RequiresPermissions("journal:read")
	@RequestMapping("my/load")
	public String load(){
		
		return "coordination/journal/load";
	}
	/**
	 * 查询出我的日志
	 * @param param
	 * @param xj
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("journal:read")
	@RequestMapping("my/query")
	public ModelAndView query(PageParam param,XtJournal xj,Date startDate,Date endDate){
		xj.setUserId(ServletUtil.getMember().getId());
		return ajaxJsonEscape(service.selectJournal(param, xj, startDate, endDate));
	}
	/**
	 * 查询出我能查看的共享日志 页面
	 * @param param
	 * @param xj
	 * @param startDate
	 * @param endDate
	 * @param map
	 * @return
	 */
	@RequiresPermissions("journal:read")
	@RequestMapping("share/load")
	public String shareLoad(){
		
		return "coordination/journal/share";
	}
	/**
	 * 查询出我能查看的共享日志
	 * @param param
	 * @param xj
	 * @param startDate
	 * @param endDate
	 * @param map
	 * @return
	 */
	@RequiresPermissions("journal:read")
	@RequestMapping("share/query")
	public ModelAndView shareQuery(PageParam param,XtJournal xj,Date startDate,Date endDate,ModelMap map){
		
		return ajaxJsonEscape(service.selectJournalShare(param, xj, startDate, endDate));
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequiresPermissions("journal:add")
	@RequestMapping("addPage")
	public String addPage(){
		
		return "coordination/journal/add";
	}
	
	/**
	 * 添加日志
	 * @param xj
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("journal:add")
	@RequestMapping("add")
	public ModelAndView add(@Valid XtJournal xj,Errors errors,String[] userIds,Integer isSendMsg,FileList files){
		
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		
		//验证上传文件大小，格式
		List<MultipartFile> fs=files.getFile();
		if(fs!=null){
			for(MultipartFile file:fs){
				if(file!=null&&!file.isEmpty()){
					ModelAndView view=FileUtils.validateFile(file, 1024L*1024*500, null, new String[]{"exe"});
					if(view!=null)return view;
				}
			}
		}
		
		String fileJson=FileUtils.uploadFilesToJson(SAVEPATH, files);
		if(fileJson==null){
			throw new MyRuntimeException("文件上传失败");
		}
		xj.setFiles(fileJson);
		
		xj.setUserId(ServletUtil.getMember().getId());
		
		return ajaxDone(service.saveJournal(xj, userIds, isSendMsg));
		
	}
	/**
	 * 查看单个日志
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions("journal:read")
	@RequestMapping("show")
	public String show(String id,ModelMap map){
		XtJournal xj=service.get(XtJournal.class, id);
		if(xj==null){
			return NODATA;
		}
		map.addAttribute("j",xj);
		
		map.addAttribute("userIds",service.selectJournalUserIds(id));
		map.put("files", JSON.parseArray(xj.getFiles()));
		return "coordination/journal/show";
		
		
	}
	/**
	 * 跳转到日志更新页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions("journal:update")
	@RequestMapping("updatePage")
	public String updatePage(String id,ModelMap map){
		XtJournal xj=service.get(XtJournal.class, id);
		if(xj==null){
			return NODATA;
		}
		map.addAttribute("j",xj);
		map.put("files", JSON.parseArray(xj.getFiles()));
		map.addAttribute("userIds", service.selectJournalUserIds(id));
		return "coordination/journal/update";
	}
	/**
	 * 更新日志
	 * @param xj
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("journal:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid XtJournal xj,Errors errors,String[] userIds,Integer isSendMsg,FileList files){
		if(errors.hasErrors()) {  
			ModelAndView mav=getValidationMessage(errors);
			if(mav!=null)return mav;
        }
		
		
		//验证上传文件大小，格式
		List<MultipartFile> fs=files.getFile();
		if(fs!=null){
			for(MultipartFile file:fs){
				if(file!=null&&!file.isEmpty()){
					ModelAndView view=FileUtils.validateFile(file, 1024L*1024*500, null, new String[]{"exe"});
					if(view!=null)return view;
				}
			}
		}
		String fileJson=FileUtils.uploadFilesToJson(SAVEPATH, files);
		xj.setFiles(fileJson);
		
		return ajaxDone(service.updateJournal(xj, userIds, isSendMsg));
		
	}
	/**
	 * 删除日志
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("journal:delete")
	@RequestMapping("del")
	public ModelAndView delete(String[] ids){
		
		return ajaxDone(service.deleteJournal(ids));
		
	}
	
}
