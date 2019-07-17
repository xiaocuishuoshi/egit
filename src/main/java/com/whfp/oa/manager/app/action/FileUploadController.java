package com.whfp.oa.manager.app.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jiedu.bean.SysUploadFile;
import com.whfp.oa.manager.jiedu.service.JieduCommService;

@Controller
@RequestMapping("/app/file")
public class FileUploadController  extends JsonBaseController{

	public static SimpleDateFormat yyyymmdd_sd = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private JieduCommService jieduCommService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public  @ResponseBody  Map<String,Object> upload(MultipartFile file) {

		Member member = ServletUtil.getMember();

		Map<String,Object> result=new HashMap<>();
		
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
				
				SysUploadFile oneFile = new SysUploadFile();
				
				oneFile.setCreateDate(new Date());
				oneFile.setCreateUser(member!=null?member.getId():"");
				oneFile.setFileExt(ext);
				oneFile.setFileName(fileName);
				oneFile.setSecName(secName);
				oneFile.setFilePath(path);
				oneFile.setFileSize(file.getSize());
				oneFile.setFileUrl(path2);
				
				oneFile.setStatus(0);
				
				if(jieduCommService.save(oneFile)) {
					
					File newFile = new File(path);	
					
					file.transferTo(newFile);
				}
				
				result.put("success", true);
				result.put("msg", "上传文件成功");
				result.put("fileId", oneFile.getId());
				result.put("fileName", oneFile.getFileName());
				result.put("fileUrl", oneFile.getFileUrl());
			}else {
				
				result.put("success", false);
				result.put("msg", "上传文件为空");
			}
			
		}catch(Exception ex) {
		
			result.put("success", false);
			result.put("msg", "上传文件失败,"+ex.getMessage());
		}
		return result;
	}
}
