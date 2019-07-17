package com.whfp.oa.manager.jiedu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.manager.jiedu.bean.JdActTalk;
import com.whfp.oa.manager.jiedu.bean.JdActVisit;
import com.whfp.oa.manager.jiedu.bean.JdManContact;
import com.whfp.oa.manager.jiedu.bean.JdManRelationShip;
import com.whfp.oa.manager.jiedu.service.JdActService;

@Service
public class JdActServiceImpl extends BaseServiceImpl implements  JdActService {

	@Override
	public DataGrid selectTalkList(PageParam param, JdActTalk m) {
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdActTalk s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getToUid() != null && !"".equals(m.getToUid())) {
			sb.append(" and s.toUid = '" + m.getToUid() + "'");
		}
		if (m.getCreateUid() != null && !"".equals(m.getCreateUid())) {
			sb.append(" and s.createUid = '" + m.getCreateUid() + "'");
		}
		if (m.getTalkUid() != null && !"".equals(m.getTalkUid())) {
			sb.append(" and s.talkUid like '%" + m.getTalkUid() + "%'");
		}
		
		SearchFilterUtil.appendRules(sb, map, param, null);
		
		data.setTotal((Long) dao.findUniqueOne(
				"select count(*)" + sb.toString(), map));
		
		List<Map<String, Object>> rows = dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), map);
		data.setRows(rows);
		return data;
	}

	@Override
	public boolean saveTalk(JdActTalk m) {
		
		return dao.saveOrUpdate(m);
	}

	@Override
	public JdActTalk findTalkById(Long id) {
		
		return dao.get(JdActTalk.class, id);
	}

	@Override
	public boolean deleteTalk(Long[] ids) {
		
		List<Object> c=new ArrayList<Object>();

		for (Long id : ids) { 
			JdActTalk one = dao.get(JdActTalk.class, id); 
	
			c.add(one);
		}
		dao.deleteAll(c);
		return true;
	}

	@Override
	public DataGrid selectVisitList(PageParam param, JdActVisit m) {
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdActVisit s,JdRyb j   where s.toUid=j.id ");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getToUid() != null && !"".equals(m.getToUid())) {
			sb.append(" and s.toUid = '" + m.getToUid() + "'");
		}
		if (m.getCreateUid() != null && !"".equals(m.getCreateUid())) {
			sb.append(" and s.createUid = '" + m.getCreateUid() + "'");
		}
		if (m.getVisitorUid() != null && !"".equals(m.getVisitorUid())) {
			sb.append(" and s.visitorUid like '%" + m.getVisitorUid() + "%'");
		}
		
		SearchFilterUtil.appendRules(sb, map, param, null);
		
		data.setTotal((Long) dao.findUniqueOne(
				"select count(*)" + sb.toString(), map));
		
		List<Map<String, Object>> rows = dao.findPage("select new Map( s.id as id,s.toUid as toUid,s.toUser as toUser,s.toVisitor as toVisitor,s.toVisitorRelationship as toVisitorRelationship,s.toVisitorPhone as toVisitorPhone,s.reasonType as reasonType,s.address as address,s.visitorUid as visitorUid,s.visitorName as visitorName,s.visitorDate as visitorDate,s.content as content,s.key1 as key1,s.key2 as key2,s.key3 as key3,s.key4 as key4,s.key5 as key5,s.createUid as createUid,s.createDate as createDate"
				+ ",j.id as manId, j.jdRyxm as jdRyxm) "+sb.toString(),
				param.getPage(), param.getRows(), map);
		
		data.setRows(rows);
		return data;
	}

	@Override
	public boolean saveVisit(JdActVisit m) {
		
		return dao.saveOrUpdate(m);
	}

	@Override
	public JdActVisit findVisitById(Long id) {
		
		return dao.get(JdActVisit.class, id);
	}

	@Override
	public boolean deleteVisit(Long[] ids) {
		
		List<Object> c=new ArrayList<Object>();

		for (Long id : ids) { 
			JdActVisit one = dao.get(JdActVisit.class, id); 
	
			c.add(one);
		}
		dao.deleteAll(c);
		return true;
	}
	
}
