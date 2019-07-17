package com.whfp.oa.manager.jd.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdXdrypg;

public interface JdXdrypgService extends IBaseService {
	
	public DataGrid selectXdpg(PageParam param,JdXdrypg xdpg);
	public String addXdpg(JdXdrypg xdpg);
	public boolean deleteXdpg(String[] ids);
}
