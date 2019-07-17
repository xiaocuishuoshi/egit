package com.whfp.oa.manager.jd.service;
import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdRyb;

public interface IDwglService extends IBaseService {
	
	public DataGrid selectWzxx(PageParam param,JdRyb jd);

}
