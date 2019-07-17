package com.whfp.oa.manager.jd.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdYjsb;
import com.whfp.oa.manager.jd.service.IYjsbService;
import com.whfp.oa.manager.system.bean.SyTableCustom;
@Service
public class YjsbServiceImpl extends BaseServiceImpl implements IYjsbService{

	@Override
	public boolean save(Object obj) {
		return dao.save(obj);
	}
	
	
	
	
	
	@Override
	public JdYjsb selectYb(String id) {
		
		JdYjsb jb= dao.get(JdYjsb.class, id);
		
		return jb;
	}
	
	
	@Override
	public boolean saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object o) {
		return false;
	
	}

	@Override
	public boolean deleteAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomExport(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomPrint(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomShow(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addYjsb(JdYjsb jd) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataGrid selectYjsb(PageParam param, JdYjsb jd) {
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from JdYjsb d where 1=1 ");
		List list= new ArrayList();
		
		if(StringUtils.isNotBlank(jd.getJbryxm())){
			sb.append(" and d.jbryxm=? ");
			list.add(""+jd.getJbryxm()+"");
		}
		
		if(StringUtils.isNotBlank(jd.getJsryxm())){
			sb.append(" and d.jsryxm=? ");
			list.add(""+jd.getJsryxm()+"");
		}
		sb.append(" order by d.jbsj desc");
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		 
		
		data.setRows(rows);
		
		return data;
	}

	@Override
	public List<JdYjsb> selectAllYjsb() {

		
		return null;
	}

	@Override
	public boolean deleteYjsb(String[] ids) {

		List<Object> c = new ArrayList<Object>();
		for (String id : ids) {
			JdYjsb user=dao.get(JdYjsb.class, id);
			if (user != null) {
					c.add(user);
				}
			}

		return dao.deleteAll(c);
	}
	@Override
	public String updateYjsb(JdYjsb jd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JdYjsb> selectYjsbList(String hql) {
		// TODO Auto-generated method stub
		return dao.find(hql);
	}


	

}
