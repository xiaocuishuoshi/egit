/**  
 * @Project: jxoa
 * @Title: IScheduleService.java
 * @Package com.whfp.oa.manager.personalOffice.service
 * @date 2013-5-29 上午9:11:59
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.qyxc.service;

import java.util.Date;
import java.util.List;
import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.qyxc.bean.QyxcQyjj;

public interface IQyxcService extends  IBaseService{
	
	
	/**
	 * 添加企业宣传
	 * @param s
	 * @return
	 */
	public String addQyjj(QyxcQyjj s);
	/**
	 * 条件分页查询企业宣传列表
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectQyjj(PageParam param,QyxcQyjj s);
	/**
	 * 查询我的日程  用于视图模式
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectMyQyjj(Date startDate,Date endDate);

	/**
	 * 修改企业简介
	 * @param s
	 * @return
	 */
	public String updateQyjj(QyxcQyjj s);
	
	/**
	 * 删除企业简介
	 * @param ids
	 * @return
	 */
	public boolean deleteQyjj(String[] ids);
	
	
	
	public QyxcQyjj selectById(String id);
	
	
	
	
	
	
}
