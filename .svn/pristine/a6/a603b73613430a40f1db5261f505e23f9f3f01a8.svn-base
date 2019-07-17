package com.whfp.oa.manager.jd.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
 
import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdTzsmb;
import com.whfp.oa.manager.jd.service.ITzsglService;

@Service
public class TzsglServiceImpl extends BaseServiceImpl implements ITzsglService {

	

	@Override
	public String addTzsmb(JdTzsmb jd) {
		
		Timestamp loginTime=DateUtil.getCurrentTimeStamp();
		jd.setCjsj(loginTime);
		String name=jd.getCjry();
		String hql="select j.deptId from SyUsers j where j.trueName=?";
		List list = new ArrayList();
		 list=dao.find(hql, name);
		 String deptId=(String) list.get(0);
		jd.setGsdw(deptId);
		System.out.println("隶属单位:"+jd.getGsdw()+jd.getCjsj());
		if (dao.save(jd)) {
			System.out.println(jd);
			return MsgConfig.MSG_KEY_SUCCESS;
		} else {
			return MsgConfig.MSG_KEY_FAIL;
		}
	}

	@Override
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public DataGrid selectTzsmb(PageParam param, JdTzsmb jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdTzsmb u where 1=1 ");
		List list = new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		System.out.println("deptIds="+deptIds);
		if(!sa&&!dev){//&&jd.getFkDeptId()!=null&&jd.getFkDeptId().length()>1){
			sb.append(" and u.gsdw in("+deptIds+")  ");  
		}
		if (StringUtils.isNotBlank(jd.getTzsmc())
				&& !"0".equals(jd.getTzsmc())) {
			sb.append(" and u.tzsmc like ? ");
			list.add("%"+jd.getTzsmc()+"%");
		}
		if (StringUtils.isNotBlank(jd.getCjry())) {
			sb.append(" and u.cjry = ? ");
			list.add(jd.getCjry());
		}

		param.appendOrderBy(sb);// 排序
		data.setTotal((Long) dao.findUniqueOne("select count(*)" + sb, list));

		data.setRows(dao.findPage(sb.toString(), param.getPage(), param
				.getRows(), list));
		return data;
	}

	@Override
	public String updateTzsmb(JdTzsmb jd) {

		JdTzsmb old = dao.get(JdTzsmb.class,jd.getId());
		if (old == null) {
			return MsgConfig.MSG_KEY_NODATA;
		}
		old.setTzsmc(jd.getTzsmc());
		old.setCjry(jd.getCjry());
		old.setTzsnr(jd.getTzsnr());	
	
		saveLog("修改用户", "账号:" + old.getCjry());
		// 删除缓存
		MyCache.getInstance().removeCache(MyCache.USERID2INFO, old.getId());

		return MsgConfig.MSG_KEY_SUCCESS;
	}
	@Override
	public boolean deleteTzsmb(String[] ids) {
		for (String id : ids) {
			JdTzsmb user = dao.get(JdTzsmb.class, id);
			dao.delete(user);
		}
		return true;
	}

	@Override
	public List<JdTzsmb> selectAllTzsmb() {
		// TODO Auto-generated method stub
		return null;
	}



}
