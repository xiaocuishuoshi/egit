package com.whfp.oa.manager.qyxc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.qyxc.bean.QyxcQyjj;
import com.whfp.oa.manager.qyxc.service.IQyxcService;

@Service("QyxcService")
public class QyxcServiceImpl extends BaseServiceImpl implements IQyxcService {
	
	
	@Override
	public String addQyjj(QyxcQyjj s) {
		Object obj =dao.findOne(" from QyxcQyjj q where q.name=?", s.getName());
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
	public boolean deleteQyjj(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List selectMyQyjj(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGrid selectQyjj(PageParam param, QyxcQyjj s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from QyxcQyjj  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getName() != null && !"".equals(s.getName())) {
			sb.append(" and name like ? ");
			list.add("%" + s.getName() + "%");
		}
		if(s.getTelphone()!=null && !"".equals(s.getTelphone())){
			sb.append(" and name like ? ");
			list.add("%"+s.getTelphone()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	/**
	 * 通过ID查询
	 */
	@Override
	public QyxcQyjj selectById(String id) {
		if(id==null || "".equals(id)){
			List<QyxcQyjj> list = dao.find(" from QyxcQyjj  where 1=1  ");
			return list.get(0);
		}
		return dao.get(QyxcQyjj.class, id);
	}
	
	@Override
	public String updateQyjj(QyxcQyjj s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
