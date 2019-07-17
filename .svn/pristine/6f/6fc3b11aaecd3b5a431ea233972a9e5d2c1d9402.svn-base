package com.whfp.oa.manager.qyxc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.qyxc.bean.QyxcProduct;
import com.whfp.oa.manager.qyxc.service.IQycpService;

@Service("QycpService")
public class QycpServiceImpl extends BaseServiceImpl implements IQycpService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public QyxcProduct selectById(String id) {
		if(id==null || "".equals(id)){
			List<QyxcProduct> list = dao.find(" from QyxcProduct  where 1=1  ");
			return list.get(0);
		}
		return dao.get(QyxcProduct.class, id);
	}
	

	@Override
	public String addQycp(QyxcProduct s) {
		Object obj =dao.findOne(" from QyxcProduct q where q.proName=?", s.getProName());
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
	public boolean deleteQycp(String[] ids) {
		for (String id : ids) {
			QyxcProduct p = dao.get(QyxcProduct.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectQycp(PageParam param, QyxcProduct s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from QyxcProduct  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getProName() != null && !"".equals(s.getProName())) {
			sb.append(" and pro_name like ? ");
			list.add("%" + s.getProName() + "%");
		}
		if(s.getProMs()!=null && !"".equals(s.getProMs())){
			sb.append(" and pro_ms like ? ");
			list.add("%"+s.getProMs()+"%");
		}
		if(s.getProCharge()!=null && !"".equals(s.getProCharge())){
			sb.append(" and pro_charge like ? ");
			list.add("%"+s.getProCharge()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
	//	sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateQycp(QyxcProduct s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
