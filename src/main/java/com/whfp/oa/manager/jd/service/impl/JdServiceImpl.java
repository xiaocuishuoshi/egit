package com.whfp.oa.manager.jd.service.impl;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.exception.MyRuntimeException;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IDeptService;
import com.whfp.oa.manager.system.service.ILoginService;

@Service("JdService")
public class JdServiceImpl extends BaseServiceImpl implements IJdService {
	@Autowired
	private IDeptService deptService;
	@Autowired
	private ILoginService loginService;

	@Override
	public String addUser(JdRyb jd) {
		jd.setJdCjsj(DateUtil.getCurrentTimeStamp());
		if (this.dao.save(jd)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public DataGrid selectUsers(PageParam param, JdRyb jd) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from JdRyb u where 1=1 ");
		List list = new ArrayList();
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa"))
				.booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev"))
				.booleanValue();
		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		System.out.println("deptIds=" + deptIds);
		if ((!sa) && (!dev)) {
			sb.append(" and u.fkDeptId in(" + deptIds + ")  ");
		}
		if (StringUtils.isNotBlank(jd.getJdRyxm())) {
			sb.append(" and u.jdRyxm like ? ");
			list.add("%" + jd.getJdRyxm() + "%");
		}
		if ((StringUtils.isNotBlank(jd.getJdSfzh()))
				&& (!"0".equals(jd.getJdSfzh()))) {
			sb.append(" and u.jdSfzh = ? ");
			list.add(jd.getJdSfzh());
		}
		if ((StringUtils.isNotBlank(jd.getJdDwdh()))
				&& (!"0".equals(jd.getJdDwdh()))) {
			sb.append(" and u.jdDwdh = ? ");
			list.add(jd.getJdDwdh());
		}
		if ((StringUtils.isNotBlank(jd.getJdZy()))
				&& (!"0".equals(jd.getJdZy()))) {
			sb.append(" and u.jdZy = ? ");
			list.add(jd.getJdZy());
		}
		if ((jd.getJdRyxb() != null) && (!"".equals(jd.getJdRyxb()))) {
			sb.append(" and u.jdRyxb = ? ");
			list.add(jd.getJdRyxb());
		}
		if ((jd.getFkDeptId() != null) && (!"".equals(jd.getFkDeptId()))) {
			sb.append(" and u.fkDeptId = ? ");
			list.add(jd.getFkDeptId());
		}
		if (jd.getJdRylb() != null && !"".equals(jd.getJdRylb())) {
			sb.append(" and u.jdRylb = ? ");
			list.add(jd.getJdRylb());
		}
		param.appendOrderBy(sb);
		data.setTotal((Long) this.dao.findUniqueOne("select count(*)" + sb,
				list));
		List<JdRyb> rows=this.dao.findPage(sb.toString(), param.getPage(),
				param.getRows(), list);
		List<JdRyb> rows2=new ArrayList();
		for(JdRyb jdry:rows){
			 JdRyb ry=new JdRyb();
			 ry.setId(jdry.getId());
			 ry.setJdRyxm(jdry.getJdRyxm());
			 ry.setJdZy(jdry.getJdZy());
			 ry.setJdMz(jdry.getJdMz());
			 ry.setJdSfzh(jdry.getJdSfzh());
			 ry.setJdRyxb(jdry.getJdRyxb());
			 ry.setJdLxfs(jdry.getJdLxfs());
			 ry.setJdDwdh(jdry.getJdDwdh());
			 ry.setJdRyjg(jdry.getJdRyjg());
			 ry.setJdRylb(jdry.getJdRylb());
			 ry.setJdJb(jdry.getJdJb());
			 
			 //关联数据
			 ry.setRelationshipNum(jdry.getRelationshipNum()==null?0:jdry.getRelationshipNum());
			 ry.setConcactNum(jdry.getConcactNum()==null?0:jdry.getConcactNum());
			 ry.setFileNum(jdry.getFileNum()==null?0:jdry.getFileNum());
			 ry.setWorkNum(jdry.getWorkNum()==null?0:jdry.getWorkNum());
			 
			 rows2.add(ry);
			 
		}
		 
		data.setRows(rows2);
		return data;
	}

	@Override
	public boolean deleteUser(String[] ids) {
		List<Object> c = new ArrayList();
		for (String id : ids) {
			JdRyb user = this.dao.get(JdRyb.class, id);
			if (user != null) {
				if (!user.getJdRyxm().equals(
						BaseConfig.getInstance().getDevName())) {
					if (!user.getJdRyxm().equals(
							BaseConfig.getInstance().getSaName())) {
						saveLog("删除基本档案信息", " 姓名：" + user.getJdRyxm());
						c.add(user);
						SyUsers obj=dao.get(SyUsers.class, user.getJdRyid());
						if(obj!=null);
						dao.delete(obj);
						
						//删除关联数据
						
						//contact
						dao.delete("delete from JdManContact where userId=?", id);
						
						//files
						dao.delete("delete from JdManFiles where userId=?", id);
						
						//relationship
						dao.delete("delete from JdManRelationShip where userId=?", id);
						
						//work
						dao.delete("delete from JdManWork where userId=?", id);
					}
				}
			}
		}
		return this.dao.deleteAll(c);
	}

	@Override
	public String updateUser(JdRyb jd) {
		System.out.println("修改信息:" + jd);
		if (this.dao.update(jd)) {
			return "msg.operation.success";
		}
		return "msg.operation.failure";
	}

	@Override
	public List<JdRyb> selectAllUsers() {
		boolean sa = ((Boolean) ServletUtil.getSession().getAttribute("sa")).booleanValue();
		boolean dev = ((Boolean) ServletUtil.getSession().getAttribute("dev")).booleanValue();
		Member member = (Member) ServletUtil.getSession().getAttribute("minfo");

		String deptIds = "'0'";
		if (ServletUtil.getSession().getAttribute("deptIds") != null) {
			deptIds = ServletUtil.getSession().getAttribute("deptIds")
					.toString();
		}
		if ((!sa) && (!dev)) {
			return this.dao.find("from JdRyb where fkDeptId in(" + deptIds+ ") ");
		}
		return this.dao.find("from JdRyb");
	}
	@Override
	public List<JdRyb> selectJdry(String[] ids){
		List<JdRyb> list=new ArrayList<JdRyb>();
		for(String id : ids){
			list.add(dao.get(JdRyb.class, id));
		}
		return list;
	}
	@Override
	public JdRyb selectUser(String id) {
		JdRyb jdryb = (JdRyb) this.dao.findOne("from JdRyb where id=?",
				new Object[] { id });
		return jdryb;
	}

	@Override
	public JdRyb selectUserByUserid(String userid) {
		JdRyb jdryb = (JdRyb) this.dao.findOne("from JdRyb where jdRyid=?",
				new Object[] { userid });
		return jdryb;
	}

	@Override
	public List getAreaCount() {
		String sql = "select t.*, t2.pos from(select dept_desc,c.num as total,c.towns,c.countrys,count(*) as num, count(*)/num as bl  from jd_ryb a,sy_dept b,jd_area_pp c where a.fk_dept_id=b.id and b.dept_desc=c.area_name and ifnull(jd_ryid,'0') not in(select user_id from sy_user_role) group by b.dept_desc)t, jd_city  t2 where  left(dept_desc,2)=city order by t2.id ";
		List list = this.dao.findsql(sql);
		return list;
	}

	@Override
	public List<JdRyb> selectUsers(String hql) {
		return this.dao.find(hql);
	}

	@Override
	public boolean addImg(JdRyb jd, String savePath, MultipartFile file) {
		try {
			String uuid = FileUtils.getUUID();
			String ext = FileUtils.getFileExt(file.getOriginalFilename());
			jd.setJdRyxp(savePath + "/" + uuid + "." + ext);

			File newFile = new File(BaseConfig.webPath + savePath + "/" + uuid
					+ "." + ext);
			file.transferTo(newFile);

			return this.dao.saveOrUpdate(jd);
		} catch (IOException e) {
			e.printStackTrace();
			throw new MyRuntimeException("图片保存失败！");
		}
	}
}
