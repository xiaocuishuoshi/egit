/**  
 * @Project: jxoa
 * @Title: IOrgService.java
 * @Package com.whfp.oa.manager.system.service
 * @date 2013-4-3 下午5:11:18
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.system.service;

import java.util.List;
import java.util.Map;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.system.bean.SysOrg;

/**
 * 
 * 类名：IOrgService
 * 功能：单位管理 业务操作
 * 详细：
 * 作者：shadow
 * 版本：1.0
 * 日期：2015-5-3 下午5:11:18
 *
 */
public interface IOrgService extends IBaseService{
	/**
	 * 添加单位
	 * @param d
	 * @return  添加结果对应的国际资源的key
	 */
	public String addOrg(SysOrg d);
	
	/**
	 * 查询出所有单位
	 */
	public List<SysOrg> selectAllOrgs();
	/**
	 * 查询出所有单位，id orgName superId
	 * @return
	 */
	public List<Map<String,Object>> selectAllOrgsMap();
	
	/**
	 * 修改单位
	 * @param d
	 * @return
	 */
	public String updateOrg(SysOrg d);
	
	/**
	 * 删除单位
	 * @param id
	 * @return
	 */
	public String deleteOrg(String id);

	/**
	 * 单位条件分页查询
	 * @param param
	 * @param org
	 * @return
	 */
	public DataGrid selectOrgs(PageParam param,SysOrg org);
	
}
