package com.whfp.oa.manager.cj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.cj.bean.CjDetile;
import com.whfp.oa.manager.cj.service.ICjDetileService;

@Service("CjDetileService")
public class CjDetileServiceImpl extends BaseServiceImpl implements ICjDetileService {
	

	/**
	 * 通过ID查询
	 */
	@Override
	public CjDetile selectById(String id) {
		if(id==null || "".equals(id)){
			List<CjDetile> list = dao.find(" from CjDetile  where 1=1  ");
			return list.get(0);
		}
		return dao.get(CjDetile.class, id);
	}
	

	@Override
	public String addCjDetile(CjDetile s) {
		Object obj =dao.findOne(" from CjDetile q where q.cjtitle=?", s.getCjtitle());
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
	public boolean deleteCjDetile(String[] ids) {
		for (String id : ids) {
			CjDetile p = dao.get(CjDetile.class, id);
			dao.delete(p);
		}
		return true;
	}


	@Override
	public DataGrid selectCjDetile(PageParam param, CjDetile s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from CjDetile  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getCjtitle() != null && !"".equals(s.getCjtitle())) {
			sb.append(" and cjtitle like ? ");
			list.add("%" + s.getCjtitle() + "%");
		}
		if (s.getCjry() != null && !"".equals(s.getCjry())) {
			sb.append(" and cjry like ? ");
			list.add("%" + s.getCjry() + "%");
		}if(s.getSfsx()!=null && !"".equals(s.getSfsx())){
			sb.append(" and sfsx like ? ");
			list.add("%" + s.getSfsx() + "%");
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
		sb.append(" order by rbrq desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}


	@Override
	public String updateCjDetile(CjDetile s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}


}
