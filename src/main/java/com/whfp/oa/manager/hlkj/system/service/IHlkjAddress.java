package com.whfp.oa.manager.hlkj.system.service;

import java.util.List;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.files.bean.ImageSpaceImg;
import com.whfp.oa.manager.hlkj.system.bean.HlkjAddress;
import com.whfp.oa.manager.hlkj.system.bean.HlkjTpt;

public interface IHlkjAddress extends  IBaseService{
	
	public String addAddress(HlkjAddress s);
	public DataGrid selectAddress(PageParam param,HlkjAddress s);
	public List selectAdd();
	public String updateAddress(HlkjAddress s);
	public boolean deleteAddress(String[] ids);
	public HlkjAddress selectById(String id);
	
	
	public String updateSBgl(String address,String addressid,String desc);
	public String updateAddress(String addressSb,String addressid);
	
	public List<ImageSpaceImg> selectImg();
	
	public ImageSpaceImg selectImgById(String id);
	
	
	/**
	 * 新增拓扑图
	 * @param s
	 * @return
	 */
	public String addTpt(HlkjTpt s);
	/**
	 * 查询拓扑图列表
	 * @param param
	 * @param s
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public DataGrid selectTpt(PageParam param,HlkjTpt s);

	/**
	 * 修改拓扑图
	 * @param s
	 * @return
	 */
	public String updateTpt(HlkjTpt s);
	
	/**
	 * 删除拓扑图
	 * @param ids
	 * @return
	 */
	public boolean deleteTpt(String[] ids);
	
	
	
	public HlkjTpt selectTptById(String id);
	public HlkjTpt selectTptByAdd(String addressid);
	

}
