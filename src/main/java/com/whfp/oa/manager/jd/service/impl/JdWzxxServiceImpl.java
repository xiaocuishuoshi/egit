package com.whfp.oa.manager.jd.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.manager.jd.bean.JdWzxx;
import com.whfp.oa.manager.jd.service.IJdWzxxService;

@Service
public class JdWzxxServiceImpl extends BaseServiceImpl implements IJdWzxxService{

	/*@Override
	public boolean save(Object obj) {
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
		return false;
	}

	@Override
	public boolean saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomExport(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomPrint(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SyTableCustom> findTableCustomShow(short type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addWzxx(JdWzxx jw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGrid selectWzxx(PageParam param, JdWzxx jw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteWzxx(String[] id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateWzxx(JdWzxx jw) { 
		return null;
	}

	@Override
	public List<JdWzxx> selectAllWzxx() {
		// TODO Auto-generated method stub
		return null;
	}
*/
 

	@Override
	public List<JdWzxx> selectWzxxByRyid(String ryid) { 
		// TODO Auto-generated method stub 
		return dao.findPage("from JdWzxx where userid=? order by createtime desc ",0,100,ryid);
		
	}

	@Override
	public List<JdWzxx> selectWzxxByRysj(String ryid,String cond) { 
		// TODO Auto-generated method stub
		String time="";
		Timestamp stamp=null;
		List wzxxList=new ArrayList();
		if(cond.equals("")){
			/*List<Timestamp> timeList=dao.findsql("select max(createTime) from Jd_Wzxx where userid='"+ryid+"'");
			if(timeList!=null&&timeList.size()>0&&timeList.get(0)!=null){
				stamp=timeList.get(0);
			   time=DateUtil.timestamp2String(stamp);
			}*/
			cond=" and createTime<='"+DateUtil.currentDateTimeToString()+"'  ";
		}
		cond+=" group by city,area,longitude,latitude,userid,username,fk_dept_id,out_Flag ,LEFT(CREATETIME,10) order by createtime";
		List<Object[]> list=dao.findsql("select max(id) as id ,city,area,longitude,latitude,max(createtime) as createtime,userid,username,fk_dept_id,out_Flag from Jd_Wzxx  where userid='"+ryid+"' "+cond+"  ");
		for(int i=0;list!=null&&i<list.size();i++){
			 Object obj[]=list.get(i);
			JdWzxx wzxx=new JdWzxx();
			wzxx.setId(obj[0].toString());
			if(obj[1]!=null)
				wzxx.setCity(obj[1].toString());
			if(obj[2]!=null)
				wzxx.setArea(obj[2].toString());
			if(obj[3]!=null)
				wzxx.setLongitude(obj[3].toString());
			if(obj[4]!=null)
				wzxx.setLatitude(obj[4].toString());
			if(obj[5]!=null)
				wzxx.setCreatetime((Timestamp)obj[5]);
			if(obj[6]!=null)
				wzxx.setUserid(obj[6].toString());
			if(obj[7]!=null)
				wzxx.setFkDeptId(obj[7].toString());
			if(obj[8]!=null)
				wzxx.setOutFlag(obj[8].toString());
			wzxxList.add(wzxx);
		}
		return wzxxList;
	}
}
