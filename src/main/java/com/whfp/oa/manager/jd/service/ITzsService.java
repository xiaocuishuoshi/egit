package com.whfp.oa.manager.jd.service;
import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdTzs;
		
public interface ITzsService extends IBaseService {
	
	public String addTzs(JdTzs jd);
	public String addTzss(JdTzs js);//添加多条通知书
	public DataGrid selectTzs(PageParam param,JdTzs jd);
	public List<JdTzs> selectAllTzs();
	public Object countTzs(String hql);
	public boolean deleteTzs(String[] id);
	public String updateTzs(JdTzs jd);
	public List<JdTzs> selectTzsList(String hql);
	public List SelectweiDu();//查询未读信息

	

}
