/**  
 * @Project: jxoa
 * @Title: IScheduleService.java
 * @Package com.whfp.oa.manager.personalOffice.service
 * @date 2013-5-29 上午9:11:59
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.rssq.service;


import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.rssq.bean.RssqCcsq;

public interface IRssqCcService extends  IBaseService{
	
	
	/**
	 * 保存出差申请信息
	 * @param s
	 * @return
	 */
	public String addRssqCc(RssqCcsq s);
	/**
	 * 查询出差申请信息
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectRssqCc(PageParam param,RssqCcsq s);

	/**
	 * 修改出差申请信息
	 * @param s
	 * @return
	 */
	public String updateRssqCc(RssqCcsq s);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	public boolean deleteRssqCc(String[] ids);
	
	
	
	public RssqCcsq selectById(String id);
	
	
	
	
	
	
}
