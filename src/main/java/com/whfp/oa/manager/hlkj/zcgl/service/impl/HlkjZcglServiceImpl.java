package com.whfp.oa.manager.hlkj.zcgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.zcgl.bean.HlkjZcgl;
import com.whfp.oa.manager.hlkj.zcgl.service.IHlkjZcglService;

@Service("HlkjZcglService")
public class HlkjZcglServiceImpl extends BaseServiceImpl implements
		IHlkjZcglService {

	@Override
	public String addZcgl(HlkjZcgl s) {
		if (dao.save(s)) {
			return "msg.save.success";
		} else {
			return "msg.operation.failure";
		}
	}

	@Override
	public boolean deleteZcgl(String[] ids) {
		for (String id : ids) {
			HlkjZcgl p = dao.get(HlkjZcgl.class, id);
			dao.delete(p);
		}
		return true;
	}

	@Override
	public DataGrid selectZcgl(PageParam param, HlkjZcgl s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from HlkjZcgl  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getZcmc() != null && !"".equals(s.getZcmc())) {
			sb.append(" and zcmc like ? ");
			list.add("%" + s.getZcmc() + "%");
		}
		if (s.getZcbh() != null && !"".equals(s.getZcbh())) {
			sb.append(" and zcbh like ? ");
			list.add("%" + s.getZcbh() + "%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
	//	sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	@Override
	public HlkjZcgl selectById(String id) {
		if(id==null || "".equals(id)){
			List<HlkjZcgl> list = dao.find(" from HlkjZcgl  where 1=1  ");
			return list.get(0);
		}
		return dao.get(HlkjZcgl.class, id);
	}

	@Override
	public String updateZcgl(HlkjZcgl s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}

}
