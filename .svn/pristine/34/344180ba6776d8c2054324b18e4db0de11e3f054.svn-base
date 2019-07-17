package com.whfp.oa.manager.jd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.manager.jd.bean.JdBfqk;
import com.whfp.oa.manager.jd.bean.JdSqzw;
import com.whfp.oa.manager.jd.service.JdSqzwService;

@Service
public class JdSqzwServiceImpl extends BaseServiceImpl implements JdSqzwService {
	
	@Autowired
	private HttpSession session;
	
	@Override
	public DataGrid selectSqzw(PageParam param, JdSqzw sqzw) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdSqzw s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		if (sqzw.getX() != null && !"".equals(sqzw.getX())) {
			sb.append(" and s.x like '%" + sqzw.getX() + "%'");
		}
		if (!session.getAttribute("name").toString().equals("麻城管理员")) {
			sb.append(" and s.addres = '" + session.getAttribute("name").toString() + "'");
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
	public String addSqzw(JdSqzw sqzw) {
		if (dao.save(sqzw)) {
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public boolean deleteSqzw(String[] ids) {
		for (String id : ids) { 
			JdSqzw sqzw = dao.get(JdSqzw.class, id);
			dao.delete(sqzw);
		}
		return true;
	}

	@Override
	public JdSqzw selectById(String id) {
		if (id == "" || "".equals(id)) {
			List<JdSqzw> list = dao.find(" from JdSqzw  where 1=1 ");
			return list.get(0);
		}
		return dao.get(JdSqzw.class, id);
	}

	@Override
	public String updateSqzw(JdSqzw sqzw) {
		if (dao.update(sqzw)) {
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	
	
	/*-----------------帮扶情况代码------------------------*/
	@Override
	public String addBfqk(JdBfqk bfqk) {
		if (dao.save(bfqk)) {
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public DataGrid selectBfqk(PageParam param, JdBfqk bfqk) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdBfqk s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		if (bfqk.getBfrname() != null && !"".equals(bfqk.getBfrname())) {
			sb.append(" and s.bfrname like '%" + bfqk.getBfrname() + "%'");
		}
		if (bfqk.getSqzwid() != null && !"".equals(bfqk.getSqzwid())) {
			sb.append(" and s.sqzwid = '" + bfqk.getSqzwid() + "'");
		}
		if (bfqk.getSqzwname() != null && !"".equals(bfqk.getSqzwname())) {
			sb.append(" and s.sqzwname like '%" + bfqk.getSqzwname() + "%'");
		}
		
		if (bfqk.getId().equals("1") ) {
			sb.append(" and s.sqzwname not in ('司法所','人社中心')");
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
	public boolean deleteBfqk(String[] ids) {
		for (String id : ids) { 
			JdBfqk bfqk = dao.get(JdBfqk.class, id);
			dao.delete(bfqk);
		}
		return true;
	}

	@Override
	public List<JdSqzw> ListZwmc(String addred) {
		StringBuffer sb = new StringBuffer(" from JdSqzw s  where 1=1");
		if (!session.getAttribute("name").toString().equals("麻城管理员")) {
			sb.append(" and s.addres = '" + session.getAttribute("name").toString() + "'");
		}
		return dao.find(sb.toString());
	}

	@Override
	public List<JdBfqk> SelectById(String id) {
		return dao.find(" from JdBfqk where bfrid='"+id+"' ORDER BY bfsj desc");
	}

}
