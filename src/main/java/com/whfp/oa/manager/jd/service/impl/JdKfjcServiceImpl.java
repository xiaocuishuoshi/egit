package com.whfp.oa.manager.jd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.service.JdKfjcService;
import com.whfp.oa.manager.jiedu.bean.ViewManKfjc;
import com.whfp.oa.manager.system.bean.SyUsers;

@Service
public class JdKfjcServiceImpl extends BaseServiceImpl implements JdKfjcService {

	@Override
	public DataGrid selectKfjc(PageParam param, JdKfjc Kfjc) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdKfjc s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		if (Kfjc.getName() != null && !"".equals(Kfjc.getName())) {
			sb.append(" and s.name like '%" + Kfjc.getName() + "%'");
		}
		if (Kfjc.getRyid() != null && !"".equals(Kfjc.getRyid())) {
			sb.append(" and s.ryid='" + Kfjc.getRyid() + "'");
		}
		if(!ServletUtil.isDeveloper()&&!ServletUtil.isSuperAdmin())
		{
			sb.append(" and (s.bmid='"+ServletUtil.getMember().getDeptId()+"' or s.bmid='"+ServletUtil.getMember().getOrgId()+"')");
		}
		if (Kfjc.getSfzc().equals("1")) {
			sb.append(" and s.sfzc not in ('未检查')");
		}
		
		SearchFilterUtil.appendRules(sb, map, param, null);
		data.setTotal((Long) dao.findUniqueOne(
				"select count(*)" + sb.toString(), map));
		if (Kfjc.getDh().equals("1")) {
			sb.append("  group by s.name ");
		}
		List<Map<String, Object>> rows = dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), map);
		data.setRows(rows);
		return data;
	}

	
	
	@Override
	public List<JdKfjc> selectList(String hql) {
		
		return dao.find(hql);
	}



	@Override
	public DataGrid selectKfjcSum(PageParam param, ViewManKfjc man) {
		
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from ViewManKfjc s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		if (man.getJdRyxm() != null && !"".equals(man.getJdRyxm())) {
			sb.append(" and s.jdRyxm like '%" + man.getJdRyxm() + "%'");
		}
		if (man.getId() != null && !"".equals(man.getId())) {
			sb.append(" and s.id='" + man.getId() + "'");
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
	public String addKfjc(JdKfjc Kfjc) {
		Member member=ServletUtil.getMember();
		Kfjc.setBmid(member.getDeptId());
		if (dao.save(Kfjc)) {
			SyUsers user=dao.get(SyUsers.class, member.getId());
			saveLog("添加定期检查数据", "账号："+user.getUserName()+" 姓名："+user.getTrueName());
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	public boolean deleteKfjc(String[] ids) {
		List<Object> c=new ArrayList<Object>();
		Member member=ServletUtil.getMember();
		SyUsers user=dao.get(SyUsers.class, member.getId());
		for (String id : ids) { 
			JdKfjc Kfjc = dao.get(JdKfjc.class, id); 
			saveLog("删除定期检查数据", "账号："+user.getUserName()+" 姓名："+user.getTrueName());
			c.add(Kfjc);
		}
		 dao.deleteAll(c);
		return true;
	}

}
