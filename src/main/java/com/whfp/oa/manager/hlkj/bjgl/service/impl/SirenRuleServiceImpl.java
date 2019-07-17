package com.whfp.oa.manager.hlkj.bjgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRule;
import com.whfp.oa.manager.hlkj.bjgl.service.SirenRuleService;

/**
 * 报警规则接口的实现类
 * @author LCL
 *
 */
@Service("SirenRuleService")
public class SirenRuleServiceImpl extends BaseServiceImpl implements SirenRuleService{

	/**
	 * 按条件分页查询报警规则
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unqualified-field-access" })
	@Override
	public DataGrid findPageSirenResle(PageParam param, SirenRule sr) {
		
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SirenRule where 1=1 ");
		List list=new ArrayList();
		if (sr.getGzGzname() != null && !"".equals(sr.getGzGzname())) {
			sb.append(" and gz_gzname like ? ");
			list.add("%"+sr.getGzGzname()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)" + sb,list));
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	/**
	 * 添加报警规则
	 */
	@Override
	public String addSirenRule(SirenRule sr) {
			if (dao.save(sr)) {
				return MsgConfig.MSG_KEY_SUCCESS;//操作成功
			} else {
				return MsgConfig.MSG_KEY_FAIL;//操作失败
			}
	}

	/**
	 * 修改报警规则信息
	 */
	@Override
	public String updateSirenRule(SirenRule sr) {
		if (dao.update(sr)) {
			return MsgConfig.MSG_KEY_SUCCESS;//操作成功
		} else {
			return MsgConfig.MSG_KEY_FAIL;//操作失败
		}
	}

	/**
	 * 根据id查询
	 */
	@Override
	public SirenRule selectById(String gzid) {
		if(gzid==null || "".equals(gzid)){
			List<SirenRule> list = dao.find(" from SirenRule  where 1=1  ");
			return list.get(0);
		}
		return dao.get(SirenRule.class, gzid);
	}

	/**
	 *  删除报警规则信息
	 */
	@Override
	public boolean deleteSirenRule(String[] ids) {
		for (String id : ids) {
			SirenRule s = dao.get(SirenRule.class, id);
			dao.delete(s);
		}
		return true;
	}
}
