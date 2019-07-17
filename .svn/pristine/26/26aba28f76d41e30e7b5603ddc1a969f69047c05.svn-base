package com.whfp.oa.manager.rssq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.rssq.bean.RssqJzsq;
import com.whfp.oa.manager.rssq.service.IRssqJzService;

@Service("RssqJzService")
public class RssqJzServiceImpl extends BaseServiceImpl implements IRssqJzService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public RssqJzsq selectById(String id) {
		if(id==null || "".equals(id)){
			List<RssqJzsq> list = dao.find(" from RssqJzsq  where 1=1  ");
			return list.get(0);
		}
		return dao.get(RssqJzsq.class, id);
	}
	

	@Override
	public String addRssqJz(RssqJzsq s) {
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
	}


	@Override
	public boolean deleteRssqJz(String[] ids) {
		for (String id : ids) {
			RssqJzsq p = dao.get(RssqJzsq.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectRssqJz(PageParam param, RssqJzsq s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from RssqJzsq  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getSqr() != null && !"".equals(s.getSqr())) {
			sb.append(" and sqr like ? ");
			list.add("%" + s.getSqr() + "%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		sb.append(" order by sqrq desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateRssqJz(RssqJzsq s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
