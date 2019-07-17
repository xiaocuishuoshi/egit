package com.whfp.oa.manager.jiedu.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManFiles;
import com.whfp.oa.manager.jiedu.bean.SysUploadFile;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Controller
@RequestMapping("/jiedu/man/files")
public class ManFilesAction  extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ManFilesAction.class);
	
	public static SimpleDateFormat yyyymmdd_sd = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JdManService jdManService;
	
	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@PostMapping("upload")
	public  ModelAndView  upload(Model model,MultipartFile file,String manId,Integer actType){
		
		Member member = ServletUtil.getMember();
		
		if(file.isEmpty()) {
			
			return ajaxDoneTextError("上传文件不能为空");
		}
		
		if(StringUtils.isEmpty(manId)) {
			
			return ajaxDoneTextError("参数错误，戒毒人员不能为空");
		}
		if(actType==null) {
			
			return ajaxDoneTextError("参数错误，附件类别不能为空");
		}
		
		JdRyb man=jdManService.get(JdRyb.class, manId);
		
		if(man==null) {
			
			return ajaxDoneTextError("参数错误，戒毒人员不存在");
		}
		SysUploadFile oneFile= saveFile(file,member.getId());
		JdManFiles m=new JdManFiles();
		
		if(oneFile!=null) {
			
			m.setAct_type(actType);
			m.setCheck_token("");
			m.setCreateDate(new Date());
			m.setCreateUid(member.getId());
			m.setFile_ext(oneFile.getFileExt());
			m.setFile_name(oneFile.getFileName());
			m.setFile_path(oneFile.getFilePath());
			m.setFile_sec(oneFile.getSecName());
			m.setFile_url(oneFile.getFileUrl());
			m.setIs_private(0);
			m.setUserId(manId);
			
			jdManService.saveFile(m);
			
			man.setFileNum(man.getFileNum()==null?1:man.getFileNum()+1);
			jdManService.update(man);
			
		}else {
			
			return ajaxDoneTextError("附件保存失败了");
		}
		return ajaxJsonEscape(m);
	}
	

	private SysUploadFile saveFile(MultipartFile file,String uid) {
		

		SysUploadFile oneFile = new SysUploadFile();
		
		try {
			
			if (StringUtils.isNotBlank(file.getOriginalFilename())) {
				
				String yyyymmdd= yyyymmdd_sd.format(new Date());
				
				// 附件保存根路径
				final String SAVEPATH = BaseConfig.uploadPath;
				File uploadFolder = new File(SAVEPATH+File.separator+yyyymmdd);
				if (!uploadFolder.exists() && !uploadFolder.isDirectory()) {
					uploadFolder.mkdirs();
				}
				
				// uuid作为保存时的文件名
				String uuid = FileUtils.getUUID();
				
				String fileName=file.getOriginalFilename();
				
				// 获取文件后缀
				String ext = FileUtils.getFileExt(file.getOriginalFilename());
				
				String secName=uuid + "." + ext;
				
				String path=SAVEPATH+File.separator+yyyymmdd+File.separator+secName;
				
				String path2="/"+yyyymmdd+"/"+secName;
				
				oneFile.setCreateDate(new Date());
				oneFile.setCreateUser(uid);
				oneFile.setFileExt(ext);
				oneFile.setFileName(fileName);
				oneFile.setSecName(secName);
				oneFile.setFilePath(path);
				oneFile.setFileSize(file.getSize());
				oneFile.setFileUrl(path2);
				
				oneFile.setStatus(0);
				
				if(jdManService.save(oneFile)) {
					
					File newFile = new File(path);	
					
					file.transferTo(newFile);
				}
				
			}
			
		}catch(Exception ex) {
		
			logger.debug("保存文件失败 "+ex.getMessage());
			oneFile=null;
		}
		
		return oneFile;
	}
	
	@RequestMapping("delete")
	public  ModelAndView  delete(Long[] ids){
		
		return ajaxDone(jdManService.deleteFile(ids));
	}
	
}
