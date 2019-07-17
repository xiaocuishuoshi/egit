package com.whfp.oa.manager.jd.service;
import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdFlfg;

public interface IJdflfgService extends IBaseService {
	
	public DataGrid select(PageParam param,JdFlfg fg);
	public boolean deleteUser(String[] ids);
	public String add(JdFlfg fg);
	public List<JdFlfg> selectJdflfgList(String hql);
	
	
	  
	  public  Object CountWdSl(String hql);
}
