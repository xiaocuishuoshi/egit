/**  
 * @Project: jxoa
 * @Title: IRulesService.java
 * @Package com.whfp.oa.manager.common_platform.service
 * @date 2013-6-3 上午10:18:45
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.common_platform.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.common_platform.bean.RmRulesmanager;

/**
 * 
 * 类名：IRulesService
 * 功能：
 * 详细：
 * 作者：QinXiaohua
 * 版本：1.0
 * 日期：2013-6-3 上午10:18:45
 *
 */
public interface IRulesService extends IBaseService {
	/**
	 * 查看法规
	 * @return
	 */
public DataGrid load(RmRulesmanager rm,PageParam param );

/**
 * 批量删除
 * @param ids
 * @return
 */
public boolean deletes(String[] ids);
/**
 * 修改法规
 * @param rm
 * @return
 */
public String updaterule(RmRulesmanager rm);
}
