package com.whfp.oa.manager.jd.action;

import java.io.IOException;

import java.io.File;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.FileUtils;

import com.whfp.oa.manager.jd.bean.JdBfqk;
import com.whfp.oa.manager.jd.bean.JdSqzw;
import com.whfp.oa.manager.jd.service.JdSqzwService;



@Controller
@RequestMapping("/sqzw")
public class JdSqzwAction extends BaseAction {
	
	@Autowired
	private JdSqzwService service;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	

	/**
	 * 跳转到社区职务列表
	 * @return
	 */
	@RequestMapping("load")
	public String load(ModelMap map) {
		return "jdpage/sqzw/load";
	}
	
	
	/**
	 * 查询
	 * @param param
	 * @param sqzw
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView query(PageParam param, JdSqzw sqzw) {
		return ajaxJsonEscape(service.selectSqzw(param, sqzw));
	}

	/**
	 * 跳转到 添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String add(ModelMap map) {
		return "jdpage/sqzw/add";
	}

	/**
	 * 添加
	 * 
	 * @return sqzw
	 */
	@RequestMapping("addSqzw")
	public ModelAndView addSqzw(@Valid JdSqzw sqzw, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		sqzw.setAddres(session.getAttribute("name").toString());
		return ajaxDone(service.addSqzw(sqzw));
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("del")
	public ModelAndView deleteSqzw(String[] ids) {
		return ajaxDone(service.deleteSqzw(ids));
	}

	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public String update(String id, ModelMap map) {
		JdSqzw sqzw = service.selectById(id);
		map.addAttribute("sqzw", sqzw);
		if (map.get("sqzw") == null) {
			return NODATA;
		}
		return "jdpage/sqzw/update";
	}

	/**
	 * 修改
	 * @param sqzw
	 * @param errors
	 * @return
	 */
	@RequestMapping("updateSqzw")
	public ModelAndView updateSqzw(@Valid JdSqzw sqzw, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		return ajaxDone(service.updateSqzw(sqzw));
	}
	
	
	/*--------------------帮扶情况代码开始--------------------------*/
	
	/**
	 * 跳转到帮扶列表
	 * @return
	 */
	@RequestMapping("loadBf")
	public String loadBf(ModelMap map,String sqzwid,String sqzwname,String sh) {
		map.addAttribute("id", sqzwid);
		map.addAttribute("sqzwname", sqzwname);
		map.addAttribute("sh",sh);
		return "jdpage/sqzw/loadbfqk";
	}
	
	
	/**
	 * 查询
	 * @param param
	 * @param sqzw
	 * @return
	 */
	@RequestMapping("queryBfqk")
	public ModelAndView queryBfqk(PageParam param, JdBfqk bfqk) {
		return ajaxJsonEscape(service.selectBfqk(param, bfqk));
	}

	
	
	
	/**
	 * 跳转到 添加页面
	 * @return
	 */
	@RequestMapping("addbf")
	public String addbf(ModelMap map) {
		Member me=(Member) session.getAttribute("minfo");
		List<JdSqzw> list=service.ListZwmc(session.getAttribute("name").toString());
		map.addAttribute("list",list);
		return "jdpage/sqzw/addbfqk";
	}

	/**
	 * 添加
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("addBfqk")
	public ModelAndView addBfqk(@Valid JdBfqk bfqk, Errors errors,
			@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		String savpath = "image_space";
		String path = "";
		if (file != null) {
			String name = FileUtils.getUUID();
			String ext = FileUtils.getFileExt(file.getOriginalFilename());
			File newFile = new File(BaseConfig.webPath + savpath + "/" + name
					+ "." + ext);
			path = savpath + "/" + name + "." + ext;

			if (ext == null || ext == "") {
				bfqk.setBfzp(null);
			} else {
				String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
				ModelAndView view = FileUtils.validateFile(file,
						1024L * 1024 * 10, IMGTYPE, null);
				if (view != null)
					return view;
				file.transferTo(newFile);
				bfqk.setBfzp(path);
			}
		}
		JdSqzw sqzw=service.get(JdSqzw.class,bfqk.getSqzwid());
		bfqk.setSqgb(sqzw.getSqgb());
		bfqk.setSqmj(sqzw.getSqmj());
		bfqk.setJdsg(sqzw.getJdsg());
		bfqk.setWgy(sqzw.getWgy());
		bfqk.setSqzwname(sqzw.getX());
		return ajaxDone(service.addBfqk(bfqk));
	}
	
	
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deleteBfqk")
	public ModelAndView deleteBfqk(String[] ids) {
		return ajaxDone(service.deleteBfqk(ids));
	}
	
	
	/**
	 * 跳转到人员列表查找带回
	 * @return
	 */
	@RequestMapping("lookUp")
	public String lookUp(ModelMap map) {
		return "jdpage/sqzw/lookUp";
	}
	
	/*--------------------帮扶情况代码结束--------------------------*/
}
