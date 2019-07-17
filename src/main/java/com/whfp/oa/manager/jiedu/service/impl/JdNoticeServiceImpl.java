package com.whfp.oa.manager.jiedu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.manager.jiedu.bean.JdNoticeWarn;
import com.whfp.oa.manager.jiedu.service.JdNoticeService;

@Service
public class JdNoticeServiceImpl extends BaseServiceImpl implements JdNoticeService {

	@Override
	public DataGrid selectJdNoticeList(PageParam param, JdNoticeWarn m) {
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdNoticeWarn s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getUserId() != null && !"".equals(m.getUserId())) {
			sb.append(" and s.userId = '" + m.getUserId() + "'");
		}
		
		SearchFilterUtil.appendRules(sb, map, param, null);
		
		data.setTotal((Long) dao.findUniqueOne(
				"select count(*)" + sb.toString(), map));
		
		List<Map<String, Object>> rows = dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), map);
		data.setRows(rows);
		return data;
	}

	@Override
	public boolean saveNotice(JdNoticeWarn m) {
		
		return dao.saveOrUpdate(m);
	}

	@Override
	public JdNoticeWarn findNoticeById(Long id) {
		
		return dao.get(JdNoticeWarn.class, id);
	}

	@Override
	public boolean deleteNotice(Long[] ids) {
		
		List<Object> c=new ArrayList<Object>();

		for (Long id : ids) { 
			JdNoticeWarn one = dao.get(JdNoticeWarn.class, id); 
	
			c.add(one);
		}
		 dao.deleteAll(c);
		return true;
	}

	
}
