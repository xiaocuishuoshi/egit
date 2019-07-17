package com.whfp.oa.manager.hlkj.dict.service;

import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.dict.bean.HlkjDict;

public interface IHlkjDiceService extends  IBaseService{
	
	public String addDict(HlkjDict s);
	public DataGrid selectDict(PageParam param,HlkjDict s);
	public String updateDict(HlkjDict s);
	public boolean deleteDict(String[] ids);
	public HlkjDict selectById(String id);
	public List<HlkjDict> selectDictList(String fllb);

}
