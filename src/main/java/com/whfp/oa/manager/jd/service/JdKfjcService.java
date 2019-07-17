package com.whfp.oa.manager.jd.service;

import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jiedu.bean.ViewManKfjc;

public interface JdKfjcService extends IBaseService {
	
	public DataGrid selectKfjc(PageParam param,JdKfjc kfjc);
	public String addKfjc(JdKfjc kfjc);
	public boolean deleteKfjc(String[] ids);
	
	//加统计  sam@20190514
	public DataGrid selectKfjcSum(PageParam param,ViewManKfjc man);
	
	public List<JdKfjc> selectList(String hql);
}
