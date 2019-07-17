package com.whfp.oa.manager.jd.service;
import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdPzxx;

public interface IPzscService extends IBaseService {
	
	public DataGrid selectPzsc(PageParam param,JdPzxx jd);
	
	public String deletePzxx(String ids);

}
