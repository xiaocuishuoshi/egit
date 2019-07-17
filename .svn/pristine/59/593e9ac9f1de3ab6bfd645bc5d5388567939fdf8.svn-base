package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
 
import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdXc;
import com.whfp.oa.manager.jd.service.IJdxcService;
import com.whfp.oa.commons.model.DataGrid;

@Service
public class JdxcServiceImpl extends BaseServiceImpl implements IJdxcService {

	@Override
	public DataGrid select(PageParam param, JdXc jc) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdXc u where 1=1 ");
		List list = new ArrayList();
		 
		if(!ServletUtil.isDeveloper()&&!ServletUtil.isSuperAdmin())
		{
			sb.append(" and (bmid='"+ServletUtil.getMember().getDeptId()+"')");// or bmid='"+ServletUtil.getMember().getOrgId()+"'
		}
		if(jc.getTitle()!=null && !"".equals(jc.getTitle())){
			sb.append(" and u.title=? ");
			list.add("" +jc.getTitle()+ " ");
		}		
			
		sb.append(" order by u.fbsj desc ");
		param.appendOrderBy(sb);// 排序
		data.setTotal((Long) dao.findUniqueOne("select count(*)" + sb, list));

		data.setRows(dao.findPage(sb.toString(), param.getPage(), param
				.getRows(), list));
		System.out.println("进入查询");
		return data;
	}

	@Override
	public String updateJdxc(JdXc jc) {
		jc.setFbsj(DateUtil.currentDateTimeToString());
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		jc.setBmid(member.getDeptId());
		jc.setRyid(member.getId());
		jc.setRyxm(ServletUtil.getSession().getAttribute("truename").toString());
		if(dao.update(jc)){
			return MsgConfig.MSG_KEY_SUCCESS;
		}
		return MsgConfig.MSG_KEY_FAIL;
	}

	@Override
	public boolean deleteUser(String[] ids) {
		List<Object> c = new ArrayList<Object>();
		for (String id : ids) {
			JdXc user = dao.get(JdXc.class, id);
			if (user != null) {
					c.add(user);
				}
			}

		return dao.deleteAll(c);
	}

	@Override
	public String addJdxc(JdXc jc) {
		jc.setFbsj(DateUtil.currentDateTimeToString());
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		jc.setBmid(member.getDeptId());
		jc.setRyid(member.getId());
		jc.setRyxm(ServletUtil.getSession().getAttribute("truename").toString());
		if(dao.save(jc)){
			System.out.println("添加成功:"+jc);
			return MsgConfig.MSG_KEY_SUCCESS;
		}
		return MsgConfig.MSG_KEY_FAIL;
	}
		@Override
	public List<JdXc> selectJdxcList(String hql) {
		// TODO Auto-generated method stub
		return dao.find(hql);
	}

		@Override
		public Object CountWdSl(String hql) {
			// TODO Auto-generated method stub
			return this.dao.findOne(hql, new Object[0]);
		} 
}
