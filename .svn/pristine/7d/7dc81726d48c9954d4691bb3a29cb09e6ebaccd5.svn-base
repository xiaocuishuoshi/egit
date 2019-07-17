package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.SQLQueryMapping;
import com.whfp.oa.manager.jd.service.CountService;

@Service
public class CountServiceImpl extends BaseServiceImpl implements CountService {

	@Override
	public List LoadBar(String time) {
		
		StringBuffer sb = new StringBuffer("select COUNT(*) as zs,u.jd_lydpzl as mc from jd_ryb u where 1=1 ");
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		System.out.println("deptIds=" + deptIds);
		if ((!sa) && (!dev)) {
			sb.append(" and u.fk_dept_id in(" + deptIds + ")  ");
		}
		if (time != null && !"".equals(time)) {
			sb.append(" and DATE_FORMAT(u.jd_chrq,'%Y')='"+time+"'");
		}
		sb.append("  GROUP BY u.jd_lydpzl");
		return dao.findsql(sb.toString());
	}

	@Override
	public List<String> LoadTime() {
		List<SQLQueryMapping> typeList = new ArrayList<SQLQueryMapping>();
		typeList.add(new SQLQueryMapping("nf",
				new org.hibernate.type.IntegerType()));
		
		StringBuffer sb = new StringBuffer("select DATE_FORMAT(jd_chrq,'%Y') as nf from jd_ryb u where 1=1 ");
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		System.out.println("deptIds=" + deptIds);
		if ((!sa) && (!dev)) {
			sb.append(" and u.fk_dept_id in(" + deptIds + ")  ");
		}
			sb.append(" and (DATE_FORMAT(u.jd_chrq,'%Y') is not null or DATE_FORMAT(u.jd_chrq,'%Y')<>'') ");
			sb.append("  GROUP BY DATE_FORMAT(u.jd_chrq,'%Y') ORDER BY DATE_FORMAT(jd_chrq,'%Y') desc");
		return dao.findsql(sb.toString(),typeList);
	}

	@Override
	public List LoadLine() {
		List<SQLQueryMapping> typeList = new ArrayList<SQLQueryMapping>();
		typeList.add(new SQLQueryMapping("nf",
				new org.hibernate.type.IntegerType()));
		typeList.add(new SQLQueryMapping("sl",
				new org.hibernate.type.IntegerType()));
		StringBuffer sb = new StringBuffer("select DATE_FORMAT(u.jd_chrq,'%Y') as nf,COUNT(*) as sl from jd_ryb u where 1=1 ");
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		if ((!sa) && (!dev)) {
			sb.append(" and u.fk_dept_id in(" + deptIds + ")  ");
		}
		sb.append("   GROUP BY DATE_FORMAT(u.jd_chrq,'%Y')");
		return dao.findsql(sb.toString(),typeList);
	}

	@Override
	public List LoadLineLx(String time) {
		StringBuffer sb = new StringBuffer("select jd_rylb ,COUNT(*)  from jd_ryb u where 1=1 ");
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		if ((!sa) && (!dev)) {
			sb.append(" and u.fk_dept_id in(" + deptIds + ")  ");
		}
		if (time != null && !"".equals(time)) {
			sb.append(" and DATE_FORMAT(u.jd_chrq,'%Y')='"+time+"'");
		}
		sb.append("  GROUP BY jd_rylb");
		return dao.findsql(sb.toString());
	}

}
