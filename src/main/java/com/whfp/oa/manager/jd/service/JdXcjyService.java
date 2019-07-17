package com.whfp.oa.manager.jd.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdXcjy;

public interface JdXcjyService extends IBaseService {
	
	public DataGrid selectXcjy(PageParam param,JdXcjy xcjy);
	public String addXcjy(JdXcjy xcjy);
	public boolean deleteXcjy(String[] ids);

}
