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
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManContact;
import com.whfp.oa.manager.jiedu.bean.JdManFiles;
import com.whfp.oa.manager.jiedu.bean.JdManRelationShip;
import com.whfp.oa.manager.jiedu.bean.JdManWork;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Service
public class JdManServiceImpl extends BaseServiceImpl implements JdManService {
	
	@Override
	public DataGrid selectJdManContactList(PageParam param, JdManContact m) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdManContact s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getUserId() != null && !"".equals(m.getUserId())) {
			sb.append(" and s.userId = '" + m.getUserId() + "'");
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
	public JdManContact findContactById(Long id) {
	
		return dao.get(JdManContact.class, id);
	}
	
	
	
	@Override
	public List<JdManContact> findContactListBy(String uid) {
		
		return dao.find(" from JdManContact s  where s.userId = ? ", uid);
	}

	@Override
	public boolean saveContact(JdManContact m) {
		
		return dao.saveOrUpdate(m);
	}

	@Override
	public boolean deleteContact(Long[] ids) {
		List<Object> c=new ArrayList<Object>();

		for (Long id : ids) { 
			JdManRelationShip one = dao.get(JdManRelationShip.class, id); 
	
			c.add(one);
		}
		 dao.deleteAll(c);
		return true;
	}

	@Override
	public DataGrid selectFilesList(PageParam param, JdManFiles m) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdManFiles s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getUserId() != null && !"".equals(m.getUserId())) {
			sb.append(" and s.userId = '" + m.getUserId() + "'");
		}
		if (m.getAct_type() != null ) {
			sb.append(" and s.act_type = " + m.getAct_type() + "");
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
	public List<JdManRelationShip> findRelationShipListBy(String uid) {
		
		return dao.find(" from JdManRelationShip s  where s.userId = ? ", uid);
	}
	
	@Override
	public List<JdManFiles> findFilesListBy(String uid, Integer actType) {
		
		return dao.find(" from JdManFiles s  where s.userId = ?  and s.act_type =?   ", uid,actType);
	}

	@Override
	public boolean saveFile(JdManFiles m) {
		
		return dao.saveOrUpdate(m);
	}

	@Override
	public boolean deleteFile(Long[] ids) {
		List<JdManFiles> c=new ArrayList<JdManFiles>();

		for (Long id : ids) { 
			JdManFiles one = dao.get(JdManFiles.class, id); 
	
			c.add(one);
		}
		 dao.deleteAll(c);
		 
		if(c.size()>0) {
			JdRyb man=dao.get(JdRyb.class, c.get(0).getUserId());
					
			if(man!=null) {
				man.setFileNum(man.getFileNum()-c.size());	
				dao.update(man);
			}	 
		}
		return true;
	}

	@Override
	public DataGrid selectWorkList(PageParam param, JdManWork m) {
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdManWork s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getUserId() != null && !"".equals(m.getUserId())) {
			sb.append(" and s.userId = '" + m.getUserId() + "'");
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
	public JdManWork findWorkById(Long id) {
		
		return dao.get(JdManWork.class, id);
	}
	
	@Override
	public List<JdManWork> findWorkListBy(String uid) {
		
		return dao.find(" from JdManWork s  where s.userId = ? ", uid);
	}
	
	@Override
	public boolean saveWork(JdManWork m) {
	
		return dao.saveOrUpdate(m);
	}

	@Override
	public boolean deleteWork(Long[] ids) {
		List<JdManWork> c=new ArrayList<JdManWork>();

		for (Long id : ids) { 
			JdManWork one = dao.get(JdManWork.class, id); 
	
			c.add(one);
		}
		dao.deleteAll(c);
		if(c.size()>0) {
			JdRyb man=dao.get(JdRyb.class, c.get(0).getUserId());
			
			if(man!=null) {
				man.setWorkNum(man.getWorkNum()-c.size());	
				dao.update(man);
			}
		}	
		return true;
	}

	@Override
	public DataGrid selectRelationshipList(PageParam param, JdManRelationShip m) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdManRelationShip s  where 1=1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (m.getUserId() != null && !"".equals(m.getUserId())) {
			sb.append(" and s.userId = '" + m.getUserId() + "'");
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
	public boolean saveRelationship(JdManRelationShip m) {

		return dao.saveOrUpdate(m);
	}
	
	@Override
	public JdManRelationShip findRelationshipById(Long id) {
		
		return dao.get(JdManRelationShip.class, id);
	}

	@Override
	public boolean deleteRelationship(Long[] ids) {
		
		List<JdManRelationShip> c=new ArrayList<JdManRelationShip>();

		for (Long id : ids) {
			
			if(id==null) continue;
			
			JdManRelationShip one = dao.get(JdManRelationShip.class, id); 
	
			c.add(one);
		}
		
		dao.deleteAll(c);
		if(c.size()>0) {
			JdRyb man=dao.get(JdRyb.class, c.get(0).getUserId());
				
			if(man!=null) {
				man.setRelationshipNum(man.getRelationshipNum()-c.size());	
				dao.update(man);
			}	 
		} 
		return true;
	}
	
}
