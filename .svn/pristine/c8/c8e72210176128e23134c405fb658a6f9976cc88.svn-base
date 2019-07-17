package com.whfp.oa.manager.jd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.manager.jd.bean.JdXdrypg;
import com.whfp.oa.manager.jd.service.JdXdrypgService;

@Service
public class JdXdrypgServiceImpl extends BaseServiceImpl implements JdXdrypgService {

	@Override
	public DataGrid selectXdpg(PageParam param, JdXdrypg xdpg) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdXdrypg s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (xdpg.getName() != null && !"".equals(xdpg.getName())) {
			sb.append(" and s.name like '%" + xdpg.getName() + "%'");
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
	public String addXdpg(JdXdrypg xdpg) {
		if (dao.save(xdpg)) {
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public boolean deleteXdpg(String[] ids) {
		for (String id : ids) { 
			JdXdrypg xdpg = dao.get(JdXdrypg.class, id);
			dao.delete(xdpg);
		}
		return true;
	}

}
