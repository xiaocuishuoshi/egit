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
import com.whfp.oa.manager.jd.bean.JdFlfg;
import com.whfp.oa.manager.jd.service.IJdflfgService;
import com.whfp.oa.commons.model.DataGrid;

@Service
public class JdflfgServiceImpl extends BaseServiceImpl implements IJdflfgService {

	@Override
	public DataGrid select(PageParam param, JdFlfg fg) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdFlfg u where 1=1 ");
		List list = new ArrayList();
		if(fg.getTitle()!=null && !"".equals(fg.getTitle())){
			sb.append(" and u.title=? ");
			list.add("" +fg.getTitle()+ " ");
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
	public boolean deleteUser(String[] ids) {
		List<Object> c = new ArrayList<Object>();
		for (String id : ids) {
			JdFlfg user = dao.get(JdFlfg.class, id);
			if (user != null) {
					c.add(user);
				}
			}

		return dao.deleteAll(c);
	}

	@Override
	public String add(JdFlfg fg) {
		fg.setFbsj(DateUtil.getCurrentTimeStamp().toString());
		fg.setRyxm(ServletUtil.getSession().getAttribute("truename").toString());
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo"); 
		fg.setBmid(member.getDeptId());
		System.out.println("当前变量:"+member); 
		if(dao.save(fg)){
			System.out.println("添加成功:"+fg);
			return MsgConfig.MSG_KEY_SUCCESS;
		}
		return MsgConfig.MSG_KEY_FAIL;
	}

	@Override
	public List<JdFlfg> selectJdflfgList(String hql) {
		
		return dao.find(hql);
	}

	@Override
	public Object CountWdSl(String hql) {
		// TODO Auto-generated method stub
		 return this.dao.findOne(hql, new Object[0]);
	}

	

	
	
	

}
