package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdTzs;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.jd.service.ITzsService;

/**
 * 类名：TzsServiceImpl
 * 功能：用户管理 业务层实现
 * 详细：
 * 作者：zjh
 * 版本：1.0
 */
@Service
public class TzsServiceImpl extends BaseServiceImpl implements ITzsService {
	@Autowired
	private IJdService  jdService;
	@Override
	public String addTzs(JdTzs jd) {
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");  
		String deptId=member.getDeptId();
		jd.setGxbmid(deptId);
		
		jd.setTzsydzt("0");
		
		JdRyb ryb=jdService.selectUserByUserid(jd.getTzsjsrid());
		if(ryb!=null)
			jd.setTzsjsrxm(ryb.getJdRyxm());
		jd.setTzsxfsj(DateUtil.getCurrentTimeStamp().toString());
		if (dao.save(jd)) {
			System.out.println(jd+"!!!");
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}


	@Override
	public String addTzss(JdTzs js) {
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");  
		String deptId=member.getDeptId();
		js.setGxbmid(deptId);
		js.setTzsydzt("0");
		js.setTzsxfsj(DateUtil.getCurrentTimeStamp().toString());
		  
		if (dao.save(js)) {
			System.out.println(js+"!!!");
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public boolean deleteTzs(String[] ids) {
		// 等待删除的对象集合
		List<Object> c = new ArrayList<Object>();
		for (String id : ids) {
			JdTzs user = dao.get(JdTzs.class, id);
			if (user != null) {
				// 开发人员账号，超级管理员账号不可删除
//				if (!user.getTzsjsrxm().equals(
//						BaseConfig.getInstance().getDevName())
//						&& !user.getTzsjsrxm().equals(
//								BaseConfig.getInstance().getSaName())) {

					saveLog("删除用户", " 姓名：" + user.getTzsjsrxm());
					c.add(user);

					// 删除缓存
					MyCache.getInstance().removeCache(MyCache.USERID2INFO, id);
					 
			//	}

			}
		}

		return dao.deleteAll(c);
	}

	
	@Override
	public DataGrid selectTzs(PageParam param, JdTzs jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdTzs u where 1=1 ");
		List list = new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		System.out.println("deptIds="+deptIds);
		if(!sa&&!dev){//&&jd.getFkDeptId()!=null&&jd.getFkDeptId().length()>1){
			deptIds=member.getDeptId();
			sb.append(" and u.gxbmid in('"+deptIds+"')  ");  
		}
		if (StringUtils.isNotBlank(jd.getId())&&!jd.getId().equals("0")) {
			sb.append(" and u.id = ? ");
			list.add(jd.getId());
		}
		if (StringUtils.isNotBlank(jd.getTzsmc())
				&& !"0".equals(jd.getTzsmc())) {
			sb.append(" and u.tzsmc like ? ");
			list.add("%"+jd.getTzsmc()+"%");
		}
		if (StringUtils.isNotBlank(jd.getTzsjsrxm())) {
			sb.append(" and u.tzsjsrxm = ? ");
			list.add(""+jd.getTzsjsrxm()+"");
		}
		param.appendOrderBy(sb);// 排序
		data.setTotal((Long) dao.findUniqueOne("select count(*)" + sb, list));
		
		data.setRows(dao.findPage(sb.toString()+" order by tzsxfsj desc ", param.getPage(), param
				.getRows(), list));
		return data;
	
	}

	@Override
	public String updateTzs(JdTzs jd) { 
		
		if(dao.update(jd)){
		return MsgConfig.MSG_KEY_SUCCESS;
		}else{
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public List<JdTzs> selectAllTzs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JdTzs> selectTzsList(String hql) {
		// TODO Auto-generated method stub
		return dao.find(hql);
	}


	@Override
	public List SelectweiDu() {
		

		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		
		return dao.find("select count(*) from JdTzs s where s.tzshfbz='0' and s.gxbmid in("+deptIds+")");
	}


	@Override
	public Object countTzs(String hql) {
		return dao.findOne(hql).toString();
	}

	

}
