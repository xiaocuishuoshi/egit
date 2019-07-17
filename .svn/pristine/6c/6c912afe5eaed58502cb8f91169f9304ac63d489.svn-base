/**  
 * @Project: jxoa
 * @Title: IScheduleService.java
 * @Package com.whfp.oa.manager.personalOffice.service
 * @date 2013-5-29 上午9:11:59
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.cj.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.cj.bean.CjResult;

public interface ICjResultService extends  IBaseService{
	
	
	/**
	 * 抽奖信息
	 * @param s
	 * @return
	 */
	public String addCjResult(CjResult s);
	/**
	 * 条件分页查询抽奖列表
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectCjResult(PageParam param,CjResult s);

	/**
	 * 修改抽奖信息
	 * @param s
	 * @return
	 */
	public String updateCjResult(CjResult s);
	
	/**
	 * 删除抽奖
	 * @param ids
	 * @return
	 */
	public boolean deleteCjResult(String[] ids);
	
	
	
	public CjResult selectById(String id);
	
	
	
	
	
	
}
