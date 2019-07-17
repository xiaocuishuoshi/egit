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
import com.whfp.oa.manager.rssq.bean.QxjDetile;

public interface IQxjDetileService extends  IBaseService{
	
	
	/**
	 * 保存请休假信息
	 * @param s
	 * @return
	 */
	public String addQxjDetile(QxjDetile s);
	/**
	 * 查询请休假信息
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectQxjDetile(PageParam param,QxjDetile s);

	/**
	 * 修改请休假信息
	 * @param s
	 * @return
	 */
	public String updateQxjDetile(QxjDetile s);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	public boolean deleteQxjDetile(String[] ids);
	
	
	
	public QxjDetile selectById(String id);
	
	
	
	
	
	
}
