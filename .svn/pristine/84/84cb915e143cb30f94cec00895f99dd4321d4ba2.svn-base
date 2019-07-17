package com.whfp.oa.manager.hlkj.dict.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.dict.bean.HlkjDict;
import com.whfp.oa.manager.hlkj.dict.service.IHlkjDiceService;

@Service("HlkjDiceService")
public class HlkjDiceServiceImpl extends BaseServiceImpl implements IHlkjDiceService {

	@Override
	public String addDict(HlkjDict s) {
		Object obj =dao.findOne(" from HlkjDict q where q.flmc=?", s.getFlmc());
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
	public boolean deleteDict(String[] ids) {
		for (String id : ids) {
			HlkjDict p = dao.get(HlkjDict.class, id);
			dao.delete(p);
		}
		return true;
	}

	@Override
	public DataGrid selectDict(PageParam param, HlkjDict s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from HlkjDict  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getFlmc() != null && !"".equals(s.getFlmc())) {
			sb.append(" and flmc like ? ");
			list.add("%" + s.getFlmc() + "%");
		}
		if (s.getFllbmc() != null && !"".equals(s.getFllbmc())) {
			sb.append(" and fllbmc like ? ");
			list.add("%" + s.getFllbmc() + "%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
	//	sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	@Override
	public HlkjDict selectById(String id) {
		if(id==null || "".equals(id)){
			List<HlkjDict> list = dao.find(" from HlkjDict  where 1=1  ");
			return list.get(0);
		}
		return dao.get(HlkjDict.class, id);
	}

	@Override
	public String updateDict(HlkjDict s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}
	
	@Override
	public List<HlkjDict> selectDictList(String fllb){
		String sql =" from HlkjDict  where 1=1 ";
		if (fllb != null && !"".equals(fllb)) {
			sql += " and  fllb = '"+fllb+"'";
		}
		List<HlkjDict> listdict = dao.find(sql);
		return listdict;
	}

}
