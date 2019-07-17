package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdPzxx;
import com.whfp.oa.manager.jd.service.IPzscService;

@Service
public class PzscServiceImpl extends BaseServiceImpl implements IPzscService {

	@Override
	public DataGrid selectPzsc(PageParam param, JdPzxx jd) {

		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdPzxx d where 1=1 ");
		List list = new ArrayList();
		boolean sa = (Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev = (Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member = (Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null)
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		if (!sa && !dev) {// &&jd.getFkDeptId()!=null&&jd.getFkDeptId().length()>1){
			sb.append(" and d.deptId in(" + deptIds + ")  ");
		}
		if (StringUtils.isNotBlank(jd.getPzry())) {
			sb.append(" and d.pzry  like ? ");
			list.add("%" + jd.getPzry() + "%");
		}
		if (StringUtils.isNotBlank(jd.getId())) {
			sb.append(" and d.id=? ");
			list.add("" + jd.getId() + "");
		}
		sb.append(" order by d.pzsj desc");

		data.setTotal((Long) dao.findUniqueOne("select count(*)" + sb, list));
		// param.setOrder("desc");
		// param.setSort("pzsj");
		// param.appendOrderBy(sb);//排序
		System.out.println("Hql:" + sb.toString());
		List<Map<String, Object>> rows = dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), list);

		data.setRows(rows);

		return data;
	}

	@Override
	public String deletePzxx(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
