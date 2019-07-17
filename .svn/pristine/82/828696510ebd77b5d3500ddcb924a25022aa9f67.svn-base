package com.whfp.oa.manager.jd.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdPzxx;


public interface IJdPzxxService extends IBaseService{
	/**
	 * 添加拍照信息
	 * @param d
	 * @return  添加结果对应的国际资源的key
	 */
	public String addPzxx(JdPzxx d);
	
	/**
	 * 查询出所有拍照信息
	 */
	public String selectAllPzxxs(String deptId);
	/**
	 * 查询出所有拍照信息，id PzxxName superId
	 * @return
	 */
	public List<Map<String,Object>> selectAllPzxxsMap();
	/**
	 * 查询出所有拍照信息
	 */
	/**
	 * 查询出所有拍照信息id zpdz pzry
	 * @return
	 */
	public List<Map<String,Object>> selectAllPzxxsMap(String pzry);
	/**
	 * 修改拍照信息
	 * @param d
	 * @return
	 */
	public String updatePzxx(JdPzxx d);
	

	/**
	 * 条件分页查询
	 * @param param
	 * @param Pzxx
	 * @return
	 */
	public DataGrid selectPzxxs(PageParam param,JdPzxx jd);

	public boolean addImg(JdPzxx jd, String savePath, MultipartFile file);

	public boolean deletePzxx(String[] ids);
	
	  
	public List<JdPzxx> selectXX(String hql);
	 
}
