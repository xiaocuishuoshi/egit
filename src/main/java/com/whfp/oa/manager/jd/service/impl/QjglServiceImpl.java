package com.whfp.oa.manager.jd.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.gt.Notification;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdQj;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IQjglService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class QjglServiceImpl extends BaseServiceImpl implements IQjglService {

	@Override
	public DataGrid selectQj(PageParam param, JdQj jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdQj d where 1=1 ");
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
			//sb.append(" and d.gxbmid in(" + deptIds + ")  ");
			sb.append(" and d.gxbmid in('" + deptIds + "')  ");
		}
		if (StringUtils.isNotBlank(jd.getQjryxm())) {
			sb.append(" and d.qjryxm like ? ");
			list.add("%" + jd.getQjryxm() + "%");
		}
		if (StringUtils.isNotBlank(jd.getSpzt())) {
			sb.append(" and d.spzt=? ");
			list.add(jd.getSpzt());
		}
		sb.append(" order by d.spzt asc,d.qjkssj desc ");
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		List<Map<String, Object>> rows = this.dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), list);

		data.setRows(rows);

		return data;
	}
	
	@Override
	public DataGrid selectQj(int pageIndex,int pageSize, String[]  uid){
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdQj d where 1=1 ");
		List list = new ArrayList();
		
		if (uid!=null&&uid.length>0) {

			sb.append(" and d.qjryid in('" + uid + "')  ");
		}
		
		sb.append(" order by d.spzt asc,d.qjkssj desc ");
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		List<Map<String, Object>> rows = this.dao.findPage(sb.toString(),
				pageIndex, pageSize, list);

		data.setRows(rows);

		return data;
	}

	@Override
	public String updateSp(JdQj jd) {
		try {
			String qjid = jd.getId();
			if ((qjid == null) || (qjid.length() == 0)) {
				return "msg.data.hasdelete";
			}
			JdQj gj = this.dao.load(JdQj.class, qjid);
			if (gj == null) {
				return "msg.data.hasdelete";
			}
			String id = gj.getQjryid();
			System.out.println("请假id=" + id);
			if (id != null) {
				List<JdRyb> list = this.dao.find(" from JdRyb where jdRyid =?",
						new Object[] { id });
				if(list!=null&&list.size()>0){
					JdRyb jb = list.get(0);
					if (!new Notification().pushMsg(jb.getJdSjid(), "请假通知!",
							"您的请假已通过！")) {
						//return "msg.nonound.user";
					}else{
						//return "nodata";
					}
				}
			} else {
				return "msg.data.hasdelete";
			}
			gj.setSpzt("1");
			if (this.dao.update(gj)) {
				return "msg.operation.success";
			}
			return "msg.operation.success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "msg.operation.success";
	}

	@Override
	public String updateXj(JdQj jd) {
		JdQj old = this.dao.get(JdQj.class, jd.getId());
		if (old == null) {
			return "msg.data.hasdelete";
		}
		try {
			String qjid = jd.getId();
			if ((qjid == null) || (qjid.length() == 0)) {
				return "msg.data.hasdelete";
			}
			JdQj gj = this.dao.load(JdQj.class, qjid);
			if (gj == null) {
				return "msg.data.hasdelete";
			}
			String id = gj.getQjryid();
			System.out.println("请假id=" + id);
			if (id != null) {
				List<JdRyb> list = this.dao.find(" from JdRyb where jdRyid =?",
						new Object[] { id });
				if(list!=null&&list.size()>0){
					JdRyb jb = list.get(0);
					if (!new Notification().pushMsg(jb.getJdSjid(), "销假通知!",
							"您的请假已销！")) {
						//return "msg.nonound.user";
					}else{
					//	return "msg.operation.failure";
					}
				}
			} else {
				return "msg.data.hasdelete";
			}
			gj.setXjbz("1");
			gj.setXjsj(DateUtil.currentDateToString());
			if (this.dao.update(gj)) {
				return "msg.operation.success";
			}
			return "msg.operation.success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "msg.operation.success";
	}

	@Override
	public List<JdQj> selectWdQjLb(String ryid) {
		return this.dao.find("from JdQj where qjryid='" + ryid + "' order by qjsj desc");
	}

	@Override
	public List SelectweiDu() {
		String id = "0";
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			id=ServletUtil.getSession().getAttribute("deptIds").toString();
		return this.dao
				.find("select count(*) from JdQj s where s.spzt='0' and s.gxbmid in("
						+ id + ")");
	}

	@Override
	public List<JdQj> selectQjLb(String hql) {
		return this.dao.find(hql);
	}

	@Override
	public Object selectXX(String hql) {
		return this.dao.findOne(hql, new Object[0]);
	}
}
