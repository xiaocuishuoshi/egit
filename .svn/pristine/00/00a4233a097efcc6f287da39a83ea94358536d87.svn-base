package com.whfp.oa.manager.jd.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.manager.jd.bean.JdXcjy;
import com.whfp.oa.manager.jd.service.JdXcjyService;

@Controller
@RequestMapping("xcjy")
public class JdXcjyAction extends BaseAction {

	@Autowired
	private JdXcjyService xcjyService;
	
	
	/**
	 * 跳转到宣传教育页面
	 * @return
	 */
	@RequestMapping("load")
	public String load(ModelMap map) {
		return "jdpage/xcjy/load";
	}

	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param, JdXcjy xcjy) {
		return ajaxJsonEscape(xcjyService.selectXcjy(param, xcjy));

	}

	/**
	 * 跳转到新增用户界面
	 * 
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "jdpage/xcjy/add";
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("addXcjy")
	public ModelAndView addXcjy(@Valid JdXcjy xcjy, ModelMap map, Errors errors,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
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
				xcjy.setJdTp(null);
			} else {
				String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
				ModelAndView view = FileUtils.validateFile(file,
						1024L * 1024 * 10, IMGTYPE, null);
				if (view != null)
					return view;
				file.transferTo(newFile);
				xcjy.setJdTp(path);
			}
		}
		return ajaxDone(xcjyService.addXcjy(xcjy));
	}

	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("del")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(xcjyService.deleteXcjy(ids));
	}

}
