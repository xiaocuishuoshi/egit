package com.whfp.oa.manager.jd.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdDhyj;
import com.whfp.oa.manager.jd.bean.JdJdKtv;
import com.whfp.oa.manager.jd.bean.JdKnxx;
import com.whfp.oa.manager.jd.service.IJdXXjgService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JdXXjgServiceImpl extends BaseServiceImpl implements IJdXXjgService {

	@Override
	public DataGrid select(PageParam param, JdDhyj fg) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdDhyj u where 1=1 ");
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
			sb.append(" and u.bz in(" + deptIds + ")  ");
		}
		if ((fg.getJsrxm() != null) && (!"".equals(fg.getJsrxm()))) {
			sb.append(" and u.jsrxm =?");
			list.add(fg.getJsrxm());
		}
		sb.append(" order by u.fssj desc ");
		param.appendOrderBy(sb);
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		data.setRows(this.dao.findPage(sb.toString(), param.getPage(),
				param.getRows(), list));
		return data;
	}

	@Override
	public boolean deleteUser(String[] ids) {
		List<Object> c = new ArrayList();
		for (String id : ids) {
			JdDhyj user = this.dao.get(JdDhyj.class, id);
			if (user != null) {
				c.add(user);
			}
		}
		return this.dao.deleteAll(c);
	}

	@Override
	public String add(JdDhyj fg) {
		Member member = (Member) ServletUtil.getSession().getAttribute("minfo");
		String deptId = member.getDeptId();
		fg.setBz(deptId);
		if (this.dao.save(fg)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public String selectId(String name) {
		return this.dao.findOne(
				" select cid from SyUsers where trueName='" + name + "' ",
				new Object[0]).toString();
	}

	@Override
	public JdJdKtv findBegxx(String sql) {
		return (JdJdKtv) this.dao.findOne(sql, new Object[0]);
	}

	@Override
	public String add(JdKnxx jx) {
		if (this.dao.save(jx)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public JdKnxx findEndxx(String sql) {
		return (JdKnxx) this.dao.findOne(sql, new Object[0]);
	}

	@Override
	public String updateJdKnxx(JdKnxx jx) {
		if (this.dao.update(jx)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public List<Object[]> findsj(String sql) {
		return this.dao.findsql(sql);
	}

	@Override
	public List<JdDhyj> selectXx(String hql) {
		return this.dao.find(hql);
	}


}
