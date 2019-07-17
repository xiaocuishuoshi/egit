package com.whfp.oa.manager.jd.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.system.bean.SyLoginLog;

public interface IJdService extends IBaseService {
	
	public String addUser(JdRyb jd);
	public DataGrid selectUsers(PageParam param,JdRyb jd);
	public boolean deleteUser(String[] id);
	public String updateUser(JdRyb jd);
	public List<JdRyb> selectAllUsers();
	public  JdRyb selectUser(String ryid); 
	public JdRyb selectUserByUserid(String userid); 
	public List getAreaCount();
	public List<JdRyb> selectUsers(String hql);
	public boolean addImg(JdRyb jd, String savePath, MultipartFile file); 
	public List<JdRyb> selectJdry(String[] ids); 
	 
}
