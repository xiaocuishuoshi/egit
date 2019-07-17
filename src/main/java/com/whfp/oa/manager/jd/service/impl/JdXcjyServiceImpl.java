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
import com.whfp.oa.manager.jd.bean.JdXcjy;
import com.whfp.oa.manager.jd.service.JdXcjyService;

@Service
public class JdXcjyServiceImpl extends BaseServiceImpl implements JdXcjyService {

	@Override
	public DataGrid selectXcjy(PageParam param, JdXcjy xcjy) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdXcjy s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (xcjy.getJdXcbt() != null && !"".equals(xcjy.getJdXcbt())) {
			sb.append(" and s.jdXcbt = '" + xcjy.getJdXcbt() + "'");
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
	public String addXcjy(JdXcjy xcjy) {
		if (dao.save(xcjy)) {
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public boolean deleteXcjy(String[] ids) {
		for (String id : ids) { 
			JdXcjy xcjy = dao.get(JdXcjy.class, id);
			dao.delete(xcjy);
		}
		return true;
	}

}
