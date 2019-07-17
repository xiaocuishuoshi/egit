/**  
 * @Project: jxoa
 * @Title: IDeptService.java
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
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SysOrg;

/**
 * 
 * 类名：IDeptService
 * 功能：部门管理 业务操作
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-4-3 下午5:11:18
 *
 */
public interface IDeptService extends IBaseService{
	/**
	 * 添加部门
	 * @param d
	 * @return  添加结果对应的国际资源的key
	 */
	public String addDept(SyDept d);
	
	/**
	 * 查询出所有部门
	 */
	public List<SyDept> selectAllDepts();
	/**
	 * 查询出所有部门，id deptName superId
	 * @return
	 */
	public List<Map<String,Object>> selectAllDeptsMap();
	/**
	 * 查询出所有部门
	 */
	public List<SyDept> selectAllDepts(String orgId);
	/**
	 * 查询出所有部门，id deptName superId
	 * @return
	 */
	public List<Map<String,Object>> selectAllDeptsMap(String orgId);
	/**
	 * 修改部门
	 * @param d
	 * @return
	 */
	public String updateDept(SyDept d);
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	public String deleteDept(String id);

	/**
	 * 部门条件分页查询
	 * @param param
	 * @param dept
	 * @return
	 */
	public DataGrid selectDepts(PageParam param,SyDept dept);
	
	/**
	 * 部门条件分页查询
	 * @param param
	 * @param dept
	 * @return
	 */
	public DataGrid selectDepts(PageParam param,SysOrg org);

	public String getAreaPos(String area);
	
}
