package com.whfp.oa.manager.jd.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdKnxx;
import com.whfp.oa.manager.jd.service.IJdKnxxService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JdKnxxServiceImpl extends BaseServiceImpl implements IJdKnxxService {
	
	@Override
	public DataGrid select(PageParam param, JdKnxx fg) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdKnxx u where 1=1 ");
		List list = new ArrayList();
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		Member member = (Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		System.out.println("deptIds=" + deptIds);
		if ((!sa) && (!dev)) {
			sb.append(" and u.gxbmid in(" + deptIds + ")  ");
		}
		if ((fg.getUsername() != null) && (!"".equals(fg.getUsername()))) {
			sb.append(" and u.username =?");
			list.add(fg.getUsername());
		}
		sb.append(" order by u.kssj desc,u.ydzt desc ");
		param.appendOrderBy(sb);
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		data.setRows(this.dao.findPage(sb.toString(), param.getPage(),
				param.getRows(), list));
		return data;
	}

	@Override
	public String updateKnxx(JdKnxx fg) {
		if (this.dao.update(fg)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public List<JdKnxx> selectXx(String hql) {
		return this.dao.find(hql);
	}
}
