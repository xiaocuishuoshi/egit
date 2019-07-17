package com.whfp.oa.manager.gwsp.service;

import java.util.Date;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.personalOffice.bean.PerSchedule;

public interface IGwglService  extends  IBaseService{
	
	/**
	 * 分页查询公文
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectGwgl(PageParam param,PerSchedule s,Date startDate,Date endDate);

}
