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
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IDwglService;

@Service
public  class DwglServiceImpl extends BaseServiceImpl implements IDwglService {

	@Override
	public DataGrid selectWzxx(PageParam param, JdRyb jd) {
		
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from JdRyb d where 1=1 ");
		List list= new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo"); 
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		 
		if(!sa&&!dev){
			sb.append(" and d.fkDeptId in("+deptIds+")  ");  
		}
			if(StringUtils.isNotBlank(jd.getJdRyxm())){
				sb.append(" and d.jdRyxm like ? ");
				list.add("%"+jd.getJdRyxm()+"%");
			}if(StringUtils.isNotBlank(jd.getDqwz())){
				sb.append(" and d.dqwz like ? ");
				list.add("%"+jd.getDqwz()+"%");
			}
		if(StringUtils.isNotBlank(jd.getFkDeptId())){
			sb.append(" and d.fkDeptId=? ");
			list.add(""+jd.getFkDeptId()+"");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		 
		
		data.setRows(rows);
		
		return data;
	}

	


}



