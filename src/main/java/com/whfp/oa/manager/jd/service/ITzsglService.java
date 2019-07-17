package com.whfp.oa.manager.jd.service;
import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdTzsmb;

public interface ITzsglService extends IBaseService {
	
	public String addTzsmb(JdTzsmb jd);
	public DataGrid selectTzsmb(PageParam param,JdTzsmb jd);
	public boolean deleteTzsmb(String[] id);
	public String updateTzsmb(JdTzsmb jd);
	public List<JdTzsmb> selectAllTzsmb();
	
	
}
