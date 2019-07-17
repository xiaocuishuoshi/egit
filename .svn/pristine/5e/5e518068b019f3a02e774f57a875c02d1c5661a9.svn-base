package com.whfp.oa.manager.qyxc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.qyxc.bean.QyxcNews;
import com.whfp.oa.manager.qyxc.service.IQyxwService;

@Service("QyxwService")
public class QyxwServiceImpl extends BaseServiceImpl implements IQyxwService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public QyxcNews selectById(String id) {
		if(id==null || "".equals(id)){
			List<QyxcNews> list = dao.find(" from QyxcNews  where 1=1  ");
			return list.get(0);
		}
		return dao.get(QyxcNews.class, id);
	}
	

	@Override
	public String addQyxw(QyxcNews s) {
		Object obj =dao.findOne(" from QyxcNews q where q.title=?", s.getTitle());
		if(obj==null){
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
		}else{
			return "msg.Public.unique";//数据库已有值
		}
	}

	@Override
	public boolean deleteQyxw(String[] ids) {
		for (String id : ids) {
			QyxcNews p = dao.get(QyxcNews.class, id);
			dao.delete(p);
		}
		return true;
	}

	@Override
	public DataGrid selectQyxw(PageParam param, QyxcNews s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from QyxcNews  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getTitle() != null && !"".equals(s.getTitle())) {
			sb.append(" and title like ? ");
			list.add("%" + s.getTitle() + "%");
		}
		if(s.getZy()!=null && !"".equals(s.getZy())){
			sb.append(" and zy like ? ");
			list.add("%"+s.getZy()+"%");
		}
		if(s.getZz()!=null && !"".equals(s.getZz())){
			sb.append(" and zz like ? ");
			list.add("%"+s.getZz()+"%");
		}
		if(s.getContent()!=null && !"".equals(s.getContent())){
			sb.append(" and content like ? ");
			list.add("%"+s.getContent()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	@Override
	public String updateQyxw(QyxcNews s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
