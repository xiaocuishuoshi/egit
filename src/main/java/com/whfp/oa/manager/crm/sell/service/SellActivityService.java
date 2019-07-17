package com.whfp.oa.manager.crm.sell.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.crm.sell.bean.CrmSellActivity;

public interface SellActivityService extends IBaseService{
		/**
		 * 查询客户活动信息
		 * @param param
		 * @param activity
		 * @return
		 */
		public DataGrid selectActivity(PageParam param,CrmSellActivity activity);
		/**
		 * 增加客户活动
		 * @param ac
		 * @return
		 */
		public String addActivity(CrmSellActivity ac);
	
}
