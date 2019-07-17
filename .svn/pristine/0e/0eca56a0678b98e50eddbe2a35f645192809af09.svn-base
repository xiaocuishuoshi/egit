package com.whfp.oa.manager.jd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.SearchFilterUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.WghService;

@Service
public class WghServiceImpl extends BaseServiceImpl implements WghService {

	@Override
	public DataGrid selectRyb(PageParam param, JdRyb jd) {
		String area="";
	 
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer(" from JdRyb s  where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (jd.getJdWghxh() != null && !"".equals(jd.getJdWghxh())) {
			String cond=""; 
			if(jd.getJdWghxh()==1)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-金河村'";
			else if(jd.getJdWghxh()==4)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-土桥村'";
			else if(jd.getJdWghxh()==2)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-关圣村'";
			else if(jd.getJdWghxh()==3)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-周湖村'";
			else if(jd.getJdWghxh()==5)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-范岭村'";
			else if(jd.getJdWghxh()==7)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-窑新村'";
			else if(jd.getJdWghxh()==6) 
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-新庄村'";
			else if(jd.getJdWghxh()==8)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-八屋村'";
			else if(jd.getJdWghxh()==9)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-曾家湾'";
			else if(jd.getJdWghxh()==10)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-南港村'";
			else if(jd.getJdWghxh()==11)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-邱子村'";
			else if(jd.getJdWghxh()==12)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-英山村'";
			else if(jd.getJdWghxh()==13)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-敖家村'";
			else if(jd.getJdWghxh()==14)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-白虎岭村'";
			else if(jd.getJdWghxh()==15)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-五福村'";
			else if(jd.getJdWghxh()==16)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-严家山村'";
			else if(jd.getJdWghxh()==17)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-官山村'";
			else if(jd.getJdWghxh()==18)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-高山村'";
			else if(jd.getJdWghxh()==19)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-白石湖村'";
			else if(jd.getJdWghxh()==20)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-庙湾村'";
			else if(jd.getJdWghxh()==21)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-八大村'";
			else if(jd.getJdWghxh()==22)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-童岭村'";
			else if(jd.getJdWghxh()==23)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-七吴村'";
			else if(jd.getJdWghxh()==24)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-枣树村'";
			else if(jd.getJdWghxh()==25)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-光明村'";
			else if(jd.getJdWghxh()==26)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-丁集村'";
			else if(jd.getJdWghxh()==27)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-回龙村'";
			else if(jd.getJdWghxh()==28)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-旭高村'";
			else if(jd.getJdWghxh()==29)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-雄伟村'";
			else if(jd.getJdWghxh()==30)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-雄丰村'";
			else if(jd.getJdWghxh()==31)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-船厂村'";
			else if(jd.getJdWghxh()==32)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-白马村'";
			else if(jd.getJdWghxh()==33)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-柴林村'";
			else if(jd.getJdWghxh()==34)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-大咀村'";
			else if(jd.getJdWghxh()==35)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-中岭村'";
			else if(jd.getJdWghxh()==36)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-旧港村'";
			else if(jd.getJdWghxh()==37)
				 cond=" and s.jdWgsssq='孝感市-汉川市-马口镇-横山村'";
			
			sb.append(cond);
			//sb.append(" and s.jdWghxh = '" + jd.getJdWghxh() + "'");
		}
		if (jd.getJdWgsssq() != null && !"".equals(jd.getJdWgsssq())) {
			sb.append(" and s.jdWgsssq = '" + jd.getJdWgsssq() + "'");
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
	public List<String> selectKfjc(String id) {
		return dao.findsql("select id from jd_kfjc where ryid='"+id+"' GROUP BY jcsj desc LIMIT 1");
	}

	@Override
	public List<String> selectBfqk(String id) {
		return dao.findsql("select id from Jd_bfqk where bfrid='"+id+"' GROUP BY bfsj desc LIMIT 1");
	}

	@Override
	public List<String> selectXdpg(String id) {
		return dao.findsql("select id from Jd_xdrypg where xdrid='"+id+"' GROUP BY  date desc LIMIT 1");
	}

}
