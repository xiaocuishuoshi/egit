package com.whfp.oa.manager.jd.service;
import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam; 
import com.whfp.oa.manager.jd.bean.JdYjsb;

public interface IYjsbService extends IBaseService {
	
	public String addYjsb(JdYjsb jd);
	public DataGrid selectYjsb(PageParam param,JdYjsb jd);
	public List<JdYjsb> selectAllYjsb();
	public JdYjsb selectYb(String id);
	public boolean deleteYjsb(String[] id);
	public String updateYjsb(JdYjsb jd);
	public List<JdYjsb> selectYjsbList(String hql);
}

