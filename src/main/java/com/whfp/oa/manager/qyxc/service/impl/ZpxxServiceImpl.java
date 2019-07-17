package com.whfp.oa.manager.qyxc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.qyxc.bean.QyxcZpxx;
import com.whfp.oa.manager.qyxc.service.IZpxxService;

@Service("ZpxxService")
public class ZpxxServiceImpl extends BaseServiceImpl implements IZpxxService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public QyxcZpxx selectById(String id) {
		if(id==null || "".equals(id)){
			List<QyxcZpxx> list = dao.find(" from QyxcZpxx  where 1=1  ");
			return list.get(0);
		}
		return dao.get(QyxcZpxx.class, id);
	}
	

	@Override
	public String addQyzp(QyxcZpxx s) {
//		Object obj =dao.findOne(" from QyxcZpxx q where q.proName=?", s.getProName());
//		if(obj==null){
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
//		}else{
//			return "msg.Public.unique";//数据库已有值
//		}
	}


	@Override
	public boolean deleteQyzp(String[] ids) {
		for (String id : ids) {
			QyxcZpxx p = dao.get(QyxcZpxx.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectQyzp(PageParam param, QyxcZpxx s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from QyxcZpxx  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getZpzw() != null && !"".equals(s.getZpzw())) {
			sb.append(" and zpzw like ? ");
			list.add("%" + s.getZpzw() + "%");
		}
		if(s.getXl()!=null && !"".equals(s.getXl())){
			sb.append(" and xl like ? ");
			list.add("%"+s.getXl()+"%");
		}
		if(s.getGznx()!=null && !"".equals(s.getGznx())){
			sb.append(" and gznx like ? ");
			list.add("%"+s.getGznx()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
	//	sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateQyzp(QyxcZpxx s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
