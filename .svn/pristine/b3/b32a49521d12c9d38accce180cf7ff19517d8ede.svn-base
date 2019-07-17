package com.whfp.oa.manager.rssq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.rssq.bean.RssqCcsq;
import com.whfp.oa.manager.rssq.service.IRssqCcService;

@Service("RssqCcService")
public class RssqCcServiceImpl extends BaseServiceImpl implements IRssqCcService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public RssqCcsq selectById(String id) {
		if(id==null || "".equals(id)){
			List<RssqCcsq> list = dao.find(" from RssqCcsq  where 1=1  ");
			return list.get(0);
		}
		return dao.get(RssqCcsq.class, id);
	}
	

	@Override
	public String addRssqCc(RssqCcsq s) {
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
	}


	@Override
	public boolean deleteRssqCc(String[] ids) {
		for (String id : ids) {
			RssqCcsq p = dao.get(RssqCcsq.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectRssqCc(PageParam param, RssqCcsq s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from RssqCcsq  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getSqr() != null && !"".equals(s.getSqr())) {
			sb.append(" and sqr like ? ");
			list.add("%" + s.getSqr() + "%");
		}if(s.getDept()!=null && !"".equals(s.getDept())){
			sb.append( " and dept = ?");
			list.add(s.getDept());
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		sb.append(" order by sqrq desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateRssqCc(RssqCcsq s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
