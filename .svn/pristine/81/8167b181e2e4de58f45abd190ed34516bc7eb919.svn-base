package com.whfp.oa.manager.hlkj.bjgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.bjgl.bean.SirenRecord;
import com.whfp.oa.manager.hlkj.bjgl.service.SirenRecordService;

/**
 * 报警记录接口的实现类
 * @author LCL
 *
 */
@Service("SirenRecordService")
public class SirenRecordServiceImpl extends BaseServiceImpl implements SirenRecordService {

	/**
	 * 按条件分页查询报警记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unqualified-field-access" })
	@Override
	public DataGrid findPageSirenRecord(PageParam param, SirenRecord sr) {
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SirenRecord where 1=1 ");
		List list=new ArrayList();
		if (sr.getJlSbid() != null && !"".equals(sr.getJlSbid())) {
			sb.append(" and jl_sbid like ? ");
			list.add("%"+sr.getJlSbid()+"%");
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)" + sb,list));
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	/**
	 * 添加报警记录
	 */
	@Override
	public String addSirenRecord(SirenRecord sr) {
		if (dao.save(sr)) {
			return MsgConfig.MSG_KEY_SUCCESS;//操作成功
		} else {
			return MsgConfig.MSG_KEY_FAIL;//操作失败
		}
	}

	/**
	 * 修改反馈结果
	 */
	@Override
	public String updateSirenRecord(SirenRecord sr) {
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
	public SirenRecord selectById(String jlid) {
		if(jlid==null || "".equals(jlid)){
			List<SirenRecord> list = dao.find(" from SirenRecord  where 1=1  ");
			return list.get(0);
		}
		return dao.get(SirenRecord.class, jlid);
	}

}
