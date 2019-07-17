package com.whfp.oa.manager.jd.service;
import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdXc;

public interface IJdxcService extends IBaseService {
	
	public DataGrid select(PageParam param,JdXc jc);
	public String updateJdxc(JdXc jc);
	public boolean deleteUser(String[] id);
	public String addJdxc(JdXc jc);
	public List<JdXc> selectJdxcList(String hql);
	
	public Object CountWdSl(String hql);
}
