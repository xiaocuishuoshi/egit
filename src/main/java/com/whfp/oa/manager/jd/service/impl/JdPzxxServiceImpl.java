package com.whfp.oa.manager.jd.service.impl;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.exception.MyRuntimeException;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdPzxx;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IJdPzxxService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JdPzxxServiceImpl extends BaseServiceImpl implements IJdPzxxService {

	@Override
	public String addPzxx(JdPzxx d) {
		return null;
	}

	@Override
	public String selectAllPzxxs(String deptId) {
		return "";
	}

	@Override
	public List<Map<String, Object>> selectAllPzxxsMap() {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectAllPzxxsMap(String pzry) {
		return null;
	}

	@Override
	public String updatePzxx(JdPzxx d) {
		return null;
	}

	@Override
	public DataGrid selectPzxxs(PageParam param, JdPzxx jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdPzxx d where 1=1 ");
		List list = new ArrayList();
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		Member member = (Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
	/*	if (!deptIds.equals("'0'")) {
			sb.append(" and d.deptId in(" + deptIds + ") ");
		}*/
		if(!ServletUtil.isDeveloper()&&!ServletUtil.isSuperAdmin())
		{
			sb.append(" and (d.deptId='"+ServletUtil.getMember().getDeptId()+"' or d.deptId='"+ServletUtil.getMember().getOrgId()+"' or d.deptId in("+deptIds+"))");
		}
			
		
		if (StringUtils.isNotBlank(jd.getPzryxm())) {
			sb.append(" and d.pzryxm=? ");
			list.add(jd.getPzryxm());
		}
		sb.append(" order by d.pzsj desc");
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));

		param.appendOrderBy(sb);

		List<Map<String, Object>> rows = this.dao.findPage(sb.toString(),
				param.getPage(), param.getRows(), list);

		data.setRows(rows);

		return data;
	}

	@Override
	public boolean addImg(JdPzxx jd, String savePath, MultipartFile file) {
		try {
			String uuid = FileUtils.getUUID();
			String ext = FileUtils.getFileExt(file.getOriginalFilename());
			System.out.println("DateUtil.getCurrentTimeStamp()="
					+ DateUtil.getCurrentTimeStamp().toString());
			jd.setPzsj(DateUtil.currentDateTimeToString());
			jd.setZpdz(savePath + "/" + uuid + "." + ext);

			File newFile = new File(BaseConfig.webPath + savePath + "/" + uuid
					+ "." + ext);
			file.transferTo(newFile);

			JdRyb up = (JdRyb) dao.findOne(" from JdRyb where jdRyid=?",
					jd.getPzry());
			if (up != null) {
				up.setJdRyxp(savePath + "/" + uuid + "." + ext);
				dao.update(up);
			}
			return this.dao.save(jd);
		} catch (IOException e) {
			e.printStackTrace();
			throw new MyRuntimeException("图片保存失败！");
		}
	}

	@Override
	public boolean deletePzxx(String[] ids) {
		List<JdPzxx> list = new ArrayList();
		String[] arrayOfString;
		int j = (arrayOfString = ids).length;
		for (int i = 0; i < j; i++) {
			String s = arrayOfString[i];
			JdPzxx jx = this.dao.get(JdPzxx.class, s);
			if (jx != null) {
				list.add(jx);
			}
		}
		return this.dao.deleteAll(list);
	}

	@Override
	public List<JdPzxx> selectXX(String hql) {
		return this.dao.find(hql);
	}
}
