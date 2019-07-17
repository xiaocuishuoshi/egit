package com.whfp.oa.manager.cj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.cj.bean.CjResult;
import com.whfp.oa.manager.cj.service.ICjResultService;

@Service("CjResultService")
public class CjResultServiceImpl extends BaseServiceImpl implements ICjResultService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public CjResult selectById(String id) {
		if(id==null || "".equals(id)){
			List<CjResult> list = dao.find(" from CjResult  where 1=1  ");
			return list.get(0);
		}
		return dao.get(CjResult.class, id);
	}
	

	@Override
	public String addCjResult(CjResult s) {
		Object obj =dao.findOne(" from CjResult ");
		
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
		
	}


	@Override
	public boolean deleteCjResult(String[] ids) {
		for (String id : ids) {
			CjResult p = dao.get(CjResult.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectCjResult(PageParam param, CjResult s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from CjResult  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getCjJx() != null && !"".equals(s.getCjJx())) {
			sb.append(" and cjjx like ? ");
			list.add("%" + s.getCjJx() + "%");
		}
		if(s.getUserid()!=null && !"".equals(s.getUserid())){
			sb.append(" and userid = ?");
			list.add(s.getUserid());
		}
//		if(s.getProMs()!=null && !"".equals(s.getProMs())){
//			sb.append(" and pro_ms like ? ");
//			list.add("%"+s.getProMs()+"%");
//		}
//		if(s.getProCharge()!=null && !"".equals(s.getProCharge())){
//			sb.append(" and pro_charge like ? ");
//			list.add("%"+s.getProCharge()+"%");
//		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		sb.append(" order by cjrq desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateCjResult(CjResult s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
