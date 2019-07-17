package com.whfp.oa.manager.hlkj.bjgl.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRule;

/**
 * 报警规则接口
 * @author LCL
 *
 */
public interface SirenRuleService extends IBaseService {

	/**
	 * 按条件分页查询报警规则
	 * @param param
	 * @param sr
	 * @return
	 */
	public DataGrid findPageSirenResle(PageParam param,SirenRule sr);
	
	/**
	 * 添加报警规则
	 * @param sr
	 * @return
	 */
	public String addSirenRule(SirenRule sr);
	
	
	/**
	 * 修改报警规则信息
	 * @param sr
	 * @return
	 */
	public String updateSirenRule(SirenRule sr);
	
	/**
	 * 根据id查询
	 * @param gzid
	 * @return
	 */
	public SirenRule selectById(String gzid);
	
	
	/**
	 * 删除报警规则信息
	 * @param gzids
	 * @return
	 */
	public boolean deleteSirenRule(String[] ids);
}
