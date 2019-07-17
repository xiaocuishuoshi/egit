package com.whfp.oa.manager.jd.service;

import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdBfqk;
import com.whfp.oa.manager.jd.bean.JdSqzw;

public interface JdSqzwService extends IBaseService {

	public DataGrid selectSqzw(PageParam param,JdSqzw sqzw);
	public String addSqzw(JdSqzw sqzw);
	public boolean deleteSqzw(String[] ids);
	public JdSqzw selectById(String id);
	public String updateSqzw(JdSqzw sqzw);
	
	
	
	/*-----------------帮扶情况代码------------------------*/
	public DataGrid selectBfqk(PageParam param,JdBfqk bfqk);
	public boolean deleteBfqk(String[] ids);
	public String addBfqk(JdBfqk bfqk);
	public List<JdSqzw> ListZwmc(String addred);
	public List<JdBfqk> SelectById(String id);
}
