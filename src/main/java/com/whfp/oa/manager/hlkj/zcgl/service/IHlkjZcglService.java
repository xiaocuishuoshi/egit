package com.whfp.oa.manager.hlkj.zcgl.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.zcgl.bean.HlkjZcgl;

public interface IHlkjZcglService extends  IBaseService{
	public String addZcgl(HlkjZcgl s);
	public DataGrid selectZcgl(PageParam param,HlkjZcgl s);
	public String updateZcgl(HlkjZcgl s);
	public boolean deleteZcgl(String[] ids);
	public HlkjZcgl selectById(String id);
}
