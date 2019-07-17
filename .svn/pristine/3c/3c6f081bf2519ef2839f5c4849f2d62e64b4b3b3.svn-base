/**
 * 
 */
package com.whfp.oa.manager.personnel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.FileList;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.personnel.bean.Deal;

/**
 * 
 * 类名：IJobService
 * 功能：
 * 详细：
 * 作者：曹中德(caozhongde)
 * 版本：1.0
 * 日期：2013年10月9日 13:58:44
 *
 */
public interface IDealService  extends IBaseService{

	/**
	 * 加载简历信息
	 * @return
	 */
	public DataGrid select(PageParam param, Deal d );
	
	public Map selectID(String id);
	/**
	 * 添加简历信息
	 * @param s
	 * @return
	 */
	public  String add(Deal j,String savePath,HttpServletRequest request,FileList files);

	/**
	 *  修改简历信息
	 * @param s
	 * @return
	 */
	public String update(Deal j,String savePath,HttpServletRequest request,FileList files);
	/**
	 * 删除简历信息
	 * @param ids
	 * @return
	 */
	public boolean delete(String[] ids);
	/**
	 * 删除附件
	 * @param id
	 * @param savepath
	 * @return
	 */
	public boolean deleteFile(String id, String savepath);
	
}
