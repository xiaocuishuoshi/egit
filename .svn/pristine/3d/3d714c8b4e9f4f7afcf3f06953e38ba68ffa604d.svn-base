package com.whfp.oa.manager.hlkj.bjgl.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRecord;

/**
 * 报警记录接口
 * @author LCL
 *
 */
public interface SirenRecordService extends IBaseService {

	/**
	 * 按条件分页查询报警记录
	 * @param param
	 * @param sr
	 * @return
	 */
	public DataGrid findPageSirenRecord(PageParam param,SirenRecord sr);
	
	/**
	 * 添加报警记录
	 * @param sr
	 * @return
	 */
	public String addSirenRecord(SirenRecord sr);
	
	
	/**
	 * 修改反馈结果	
	 * @param sr
	 * @return
	 */
	public String updateSirenRecord(SirenRecord sr);
	
	/**
	 * 根据id查询
	 * @param jlid
	 * @return
	 */
	public SirenRecord selectById(String jlid);
}
