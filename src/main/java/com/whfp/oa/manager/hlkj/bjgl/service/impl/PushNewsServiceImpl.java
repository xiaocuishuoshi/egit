package com.whfp.oa.manager.hlkj.bjgl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.PushNews;
import com.whfp.oa.manager.hlkj.bjgl.service.PushNewsService;

/**
 * 推送消息接口的实现类
 * @author LCL
 *
 */
@Service("PushNewsService")
public class PushNewsServiceImpl extends BaseServiceImpl implements PushNewsService {

	/**
	 * 条件分页查询送消息接
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unqualified-field-access" })
	@Override
	public DataGrid findPagePushNews(PageParam param, PushNews pn,Date startDate,Date endDate) {
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer(" from PushNews where 1=1 ");
		List list=new ArrayList();
		if (pn.getXxType() != null && !"".equals(pn.getXxType())) {
			sb.append(" and xx_type = ? ");
			list.add(pn.getXxType());
		}
		if(startDate!=null){
			sb.append(" and xx_tdate >=? ");
			list.add(startDate);	
		}
		if(endDate!=null){
			sb.append(" and xx_tdate <=? ");
			list.add(endDate);	
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)" + sb,list));
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

}
