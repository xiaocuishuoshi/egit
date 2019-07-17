package com.whfp.oa.manager.hlkj.bjgl.service;

import java.util.Date;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.PushNews;

/**
 * 推送消息接口
 * @author LCL
 *
 */
public interface PushNewsService extends IBaseService {
	/**
	 * 按条件分页查询推送消息
	 * @param param
	 * @param pns
	 * @return
	 */
	public DataGrid findPagePushNews(PageParam param,PushNews pn,Date startDate,Date endDate);
}
