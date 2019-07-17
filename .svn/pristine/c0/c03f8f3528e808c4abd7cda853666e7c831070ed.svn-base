package com.whfp.oa.manager.jd.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.gt.Notification;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jd.service.IShqzService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ShqzServiceImpl extends BaseServiceImpl implements IShqzService {
	
	@Override
	public DataGrid select(PageParam param, JdShqz jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdShqz u where 1=1 ");
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
			deptIds=member.getDeptId();
			sb.append(" and u.gxbmid in('" + deptIds + "')  ");
		}
		if ((StringUtils.isNotBlank(jd.getQzryxm()))
				&& (!"0".equals(jd.getQzryxm()))) {
			sb.append(" and u.qzryxm like ? ");
			list.add("%" + jd.getQzryxm() + "%");
		}
		if (StringUtils.isNotBlank(jd.getQzbt())) {
			sb.append(" and u.qzbt = ? ");
			list.add(jd.getQzbt());
		}
		sb.append(" order by u.ydzt asc,u.qzsj desc ");
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		data.setRows(this.dao.findPage(sb.toString(), param.getPage(),
				param.getRows(), list));
		System.out.println("进入查询");
		return data;
	}

	@Override
	public String update(JdShqz jd) {
		try {
			JdShqz old = this.dao.get(JdShqz.class, jd.getId());
			if (old == null) {
				return "msg.data.hasdelete";
			}
			Timestamp loginTime = DateUtil.getCurrentTimeStamp();
			old.setHfsj(loginTime.toString());
			old.setHfbz("1");
			old.setHfrxm(jd.getHfrxm());
			old.setHfnr(jd.getHfnr());
			old.setYdzt("1");

			String jz = jd.getId();
			JdShqz js = this.dao.get(JdShqz.class, jz);
			String id = js.getQzryid();

			List<JdRyb> list = this.dao.find(" from JdRyb where jdRyid =?",
					new Object[] { id });
			JdRyb jb = list.get(0);
			System.out.println("手机id:" + jb.getJdSjid());
			if (!new Notification().pushMsg(jb.getJdSjid(), "生活求助回复通知!",
					old.getHfnr())) {
				System.out.println("推送消息:" + old.getHfnr());
				return "msg.operation.failure";
			}
			if (this.dao.update(old)) {
				return "msg.operation.success";
			}
			return "msg.operation.failure";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "msg.operation.failure";
	}

	@Override
	public List<JdShqz> selectAll() {
		return null;
	}

	@Override
	public List<JdShqz> selectList(String hql) {
		return dao.find(hql);
	}

	@Override
	public boolean delete(String[] ids) {
		List<JdShqz> list = new ArrayList();
		for (String s : ids) {
			JdShqz jz = this.dao.get(JdShqz.class, s);
			if (jz != null) {
				list.add(jz);
			}
		}
		return this.dao.deleteAll(list);
	}

	@Override
	public List SelectweiDu() {
		String ids = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			ids = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		return this.dao
				.find("select count(*) from JdShqz s where s.ydzt='0' and s.gxbmid in("
						+ ids + ")");
	}

	@Override
	public List<JdShqz> selectShqzList(String hql) {
		return this.dao.find(hql);
	}

	@Override
	public Object CountWdSl(String hql) {
		return this.dao.findOne(hql, new Object[0]);
	}
}
