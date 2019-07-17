package com.whfp.oa.manager.hlkj.nxfx.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.manager.hlkj.nxfx.service.HlkjSbglService;




@Service("EchartsTService")
public class HlkjSbglTServiceImpl extends BaseServiceImpl implements HlkjSbglService {

	//��ȡ���
	@Override
	public List showHlkjSbgl(String type,String time) {
		String sql = "select * from hlkj_sbgl where 1=1 ";
		if(type!=null && !"".equals(type)){
			sql+=" and type='"+type+"'"; 
		} 
		if(time!=null && !"".equals(time)){
			sql+=" and updatetime like '"+time+"%'"; 
		}
		sql+=" limit 80";
		
		List list = dao.findsql(sql);
		return list;
	}	
}
