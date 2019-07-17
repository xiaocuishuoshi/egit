package com.whfp.oa.manager.hlkj.nxfx.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.nxfx.bean.History;
import com.whfp.oa.manager.hlkj.nxfx.service.HistoryService;

/**
 * 历史记录接口的实现类
 * @author LCL
 *
 */
@Service("HistoryService")
public class HistoryServiceImpl  extends BaseServiceImpl implements HistoryService{

	/**
	 * 条件分页查询历史记录	
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataGrid findPageHistory(PageParam param, History h,
			Date startDate, Date endDate) {
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from History ht where 1=1 ");
		List list=new ArrayList();
		if (h.getLsDevicetype() != null && !"".equals(h.getLsDevicetype())) {
			sb.append(" and ht.lsDevicetype = ? ");
			list.add(h.getLsDevicetype());
		}
		if (h.getLsVirtual() != null && !"".equals(h.getLsVirtual())) {
			sb.append(" and ht.lsVirtual = ? ");
			list.add( h.getLsVirtual());
		}
		if (h.getLsAttributename()!= null && !"".equals(h.getLsAttributename())) {
			sb.append(" and ht.lsAttributename = ? ");
			list.add(h.getLsAttributename());
		}
		if(startDate!=null){
			sb.append(" and ht.lsDate >= ? ");
			list.add( startDate );	
		}
		if(endDate!=null){
			sb.append(" and ht.lsDate <= ? ");
			list.add( endDate );	
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)" + sb,list));
		
		sb.append(" order by ht.lsDate desc");//排序
		List<History> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		data.setRows(rows);
		return data;
	}
}
