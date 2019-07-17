package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdSxhb;
import com.whfp.oa.manager.jd.service.ISxhbService;

@Service
public class SxhbServiceImpl extends BaseServiceImpl implements ISxhbService {

	@Override
	public DataGrid select(PageParam param, JdSxhb jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdSxhb u where 1=1 ");
		List list = new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		System.out.println("deptIds="+deptIds);
		if(!sa&&!dev){//&&jd.getFkDeptId()!=null&&jd.getFkDeptId().length()>1){
			sb.append(" and u.gxbmid in("+deptIds+")  ");  
		}
		if (StringUtils.isNotBlank(jd.getHbryxm())
				&& !"0".equals(jd.getHbryxm())) {
			sb.append(" and u.hbryxm like ? ");
			list.add("%"+jd.getHbryxm()+"%");
		}
		if (StringUtils.isNotBlank(jd.getHbbt())) {
			sb.append(" and u.hbbt = ? ");
			list.add(""+jd.getHbbt()+"");
		}

		sb.append(" order by u.ydzt asc,u.hbsj desc ");
		data.setTotal((Long) dao.findUniqueOne("select count(*)" + sb, list));

		data.setRows(dao.findPage(sb.toString(), param.getPage(), param
				.getRows(), list));
		System.out.println("进入查询");
		return data;
	}
	
	
	@Override
	public String update(JdSxhb jd) {

		jd.setYdzt("1");
		
		if(dao.update(jd)){
			return MsgConfig.MSG_KEY_SUCCESS;
		}else{
		
		return MsgConfig.MSG_KEY_FAIL;
				} 
	}


	@Override
	public List<JdSxhb> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JdSxhb> selectList(String hql) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(String[] ids) {
		List<JdSxhb> list = new ArrayList<JdSxhb>();
		
		for (String s : ids) {
			JdSxhb jb=dao.get(JdSxhb.class, s);
			if(jb!=null)
			list.add(jb);
		}
		return dao.deleteAll(list);
	}


	@Override
	public List SelectweiDu() {
		String id = "0";
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			id=ServletUtil.getSession().getAttribute("deptIds").toString();
		return dao.find("select count(*) from JdSxhb s where s.ydzt='0' and s.gxbmid in("+id+")");
	}


	@Override
	public List<JdSxhb> selectSxhbList(String hql) {
		return dao.find(hql);
	}

	
	
	
	

}
