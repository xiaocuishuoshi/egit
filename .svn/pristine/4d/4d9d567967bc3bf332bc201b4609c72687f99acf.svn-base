/**  
 * @Project: jxoa
 * @Title: RulesregulationsService.java
 * @Package com.whfp.oa.manager.common_platform.service.impl
 * @date 2013-5-31 上午11:36:05
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.common_platform.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.common_platform.bean.RgRulesregulations;
import com.whfp.oa.manager.common_platform.service.IRulesregulationsService;

/**
 * 
 * 类名：RulesregulationsService
 * 功能：
 * 详细：
 * 作者：QinXiaohua
 * 版本：1.0
 * 日期：2013-5-31 上午11:36:05
 *
 */
@Service
public class RulesregulationsServiceImpl extends BaseServiceImpl implements IRulesregulationsService {
	/**
	 * 查询规章总数
	 */
@Override
@SuppressWarnings({ "rawtypes", "unchecked" })
public DataGrid selectrules(RgRulesregulations rg,PageParam param){
	DataGrid data=new DataGrid();
	StringBuffer sb=new StringBuffer("from RgRulesregulations where 1=1");
	List list=new ArrayList();
	boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
	boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
	Member member=(Member) ServletUtil.getSession().getAttribute("minfo"); 
	if(!sa&&!dev){ 
		sb.append(" and   orgid=? ");
		list.add(""+member.getOrgId()+"");
	}
	if(StringUtils.isNotBlank(rg.getRulestitle())){
		sb.append(" and rulestitle like ?");
		list.add("%"+rg.getRulestitle()+"%");
	}
	if(StringUtils.isNotBlank(rg.getTypeid())){
		sb.append(" and typeid=?");
		list.add(rg.getTypeid());
	}
	data.setTotal((Long)dao.findOne("select count(*)"+sb,list));
	
	if(StringUtils.isNotBlank(param.getSort())){
		param.appendOrderBy(sb);//排序
	}else{
		sb.append(" order by createdate desc ");
	}
	List<RgRulesregulations> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
	for(RgRulesregulations m:rows){//发布人
		
		m.setPromulgator(MyCache.getInstance().getTrueName(m.getPromulgator()));//发布人
		
		m.setTypeid(MyCache.getInstance().getSelectValue(m.getTypeid()));//规章类型
	}	
	data.setRows(rows);
	return data;
}

/**
 * 批量删除
 */
@Override
public boolean delete(String[] ids){
	List<Object> list=new ArrayList<Object>();
	for(String id:ids){
		RgRulesregulations rg=dao.get(RgRulesregulations.class, id);
		list.add(rg);
	}
	return dao.deleteAll(list);
}
/**
 * 修改规章
 */
@Override
public String updaterg(RgRulesregulations rg){
	RgRulesregulations rl=dao.get(RgRulesregulations.class, rg.getId());
	if(rl!=null){
		try {
			BeanUtils.copyProperties(rl, rg);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MsgConfig.MSG_KEY_SUCCESS;
	}
		
		else{
			return "msg.data.hasdelete";
		}
	}
}

