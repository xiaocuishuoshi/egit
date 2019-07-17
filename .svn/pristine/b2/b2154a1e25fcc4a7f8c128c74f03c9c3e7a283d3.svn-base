package com.whfp.oa.manager.gwsp.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.gwsp.service.IGwglService;
import com.whfp.oa.manager.personalOffice.bean.PerSchedule;

public class GwglService extends BaseServiceImpl implements IGwglService {

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectGwgl(PageParam param, PerSchedule s, Date startDate,Date endDate) {
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from PerSchedule s where 1=1 ");
		List list=new ArrayList();
		//查询条件
		if(StringUtils.isNotBlank(s.getUserId())){
			sb.append(" and s.userId = ? ");
			list.add(s.getUserId());	
		}
		if(StringUtils.isNotBlank(s.getSchType())){
			sb.append(" and s.schType = ? ");
			list.add(s.getSchType());	
		}
		if(StringUtils.isNotBlank(s.getSchTitle())){
			sb.append(" and s.schTitle like ? ");
			list.add("%"+s.getSchTitle()+"%");
		}
		if(startDate!=null){
			sb.append(" and s.startTime >=? ");
			list.add(startDate);	
		}
		if(endDate!=null){
			sb.append(" and s.startTime <=? ");
			list.add(endDate);	
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		if(StringUtils.isNotBlank(param.getSort())){
			param.appendOrderBy(sb);//排序
		}else{
			sb.append(" order by s.startTime ");
		}
		
		
		List<PerSchedule> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		for(PerSchedule r:rows){
			r.setSchType(MyCache.getInstance().getSelectValue(r.getSchType()));
			r.setSchContent("");
		}
		data.setRows(rows);
	
		return data;
	}

}
