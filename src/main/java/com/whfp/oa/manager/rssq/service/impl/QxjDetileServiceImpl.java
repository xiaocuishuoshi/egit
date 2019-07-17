package com.whfp.oa.manager.rssq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.rssq.bean.QxjDetile;
import com.whfp.oa.manager.rssq.service.IQxjDetileService;

@Service("QxjDetileService")
public class QxjDetileServiceImpl extends BaseServiceImpl implements IQxjDetileService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public QxjDetile selectById(String id) {
		if(id==null || "".equals(id)){
			List<QxjDetile> list = dao.find(" from QxjDetile  where 1=1  ");
			return list.get(0);
		}
		return dao.get(QxjDetile.class, id);
	}
	

	@Override
	public String addQxjDetile(QxjDetile s) {
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
	}


	@Override
	public boolean deleteQxjDetile(String[] ids) {
		for (String id : ids) {
			QxjDetile p = dao.get(QxjDetile.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectQxjDetile(PageParam param, QxjDetile s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from QxjDetile  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getSqr() != null && !"".equals(s.getSqr())) {
			sb.append(" and sqr like ? ");
			list.add("%" + s.getSqr() + "%");
		}if(s.getDept()!=null && !"".equals(s.getDept())){
			sb.append( " and dept = ?");
			list.add(s.getDept());
		}if(s.getQjsj()!=0 && !"".equals(s.getQjsj())){
			sb.append(" and qjsj = ? ");
			list.add(s.getQjsj());
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		sb.append(" order by sqsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateQxjDetile(QxjDetile s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
