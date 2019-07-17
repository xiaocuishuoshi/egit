/**  
 * @Project: jxoa
 * @Title: DeptServiceImpl.java
 * @Package com.whfp.oa.manager.system.service.impl
 * @date 2013-4-3 下午5:11:01
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SysOrg;
import com.whfp.oa.manager.system.service.IDeptService;

/**
 * 
 * 类名：DeptServiceImpl
 * 功能：部门管理 业务操作
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-4-3 下午5:11:01
 *
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl implements IDeptService{
	
	@Override
	public String addDept(SyDept d){ 
		Object obj=dao.findOne("from SyDept where deptName=? and superId=?",d.getDeptName(),d.getSuperId());
		if(obj==null){
			boolean isTop=false;
			int t=0;
			String topDeptId="0";
			String deptId="0";
			deptId=d.getSuperId();
			while(isTop==false&&d.getSuperId()!=null){
				if(t>6)break;//如果摸查６次数都不能找到则 
				SyDept dept=(SyDept) dao.findOne("from SyDept where id=?",deptId);
				if(dept!=null){
					if(dept.getSuperId().equals("0")){//找到顶级部门
						topDeptId=dept.getId();
						isTop=true;
					}
					else
						deptId=dept.getSuperId();
				}
				t++;
			}
			if(topDeptId.equals("0"))
				topDeptId=d.getId();
			d.setOrgId(topDeptId);
			dao.save(d);
			if(StringUtils.isNotBlank(d.getId())){
				
				saveLog("添加部门", "部门名称:"+d.getDeptName());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.deptname.unique";//部门名称已被占用
		}
		
	}
	
	/**
	 * 查询出所有部门
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SyDept> selectAllDepts(){

		
		return dao.find("from SyDept  order by deptSort asc");
	}
	/**
	 * 查询出所有部门
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectAllDeptsMap(){  
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev"); 
		if(sa||dev) 
		return dao.find("select new Map(id as id,deptName as deptName,superId as superId)from SyDept   order by deptSort asc");
		else{
			Member member= (Member) ServletUtil.getSession().getAttribute("minfo");
			String orgId=member.getOrgId();
			String deptId=member.getDeptId();
			String secDeptIds="";
			List<SyDept> listDept=dao.find("from  SyDept where id='"+deptId+"' or superId='"+deptId+"'");
			for(int i=0;i<listDept.size();i++){
				SyDept dept=listDept.get(i);
				secDeptIds+=",'"+dept.getId()+"'";
			}
			secDeptIds=secDeptIds.replaceFirst(",", "");
			return dao.find("select new Map(id as id,deptName as deptName,superId as superId)from SyDept where  (id='"+deptId+"' or superId='"+deptId+"' or superId in("+secDeptIds+"))  order by deptSort asc");
		}
	}
	/**
	 * 查询出所有部门
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SyDept> selectAllDepts(String orgId){
		
		return dao.find("from SyDept where orgId='"+orgId+"' order by deptSort asc");
	}
	/**
	 * 查询出所有部门
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectAllDeptsMap(String orgId){
		
		return dao.find("select new Map(id as id,deptName as deptName,superId as superId)from SyDept  where orgId='"+orgId+"'  order by deptSort asc");
	}
	/**
	 * 递归查询子节点 
	 * @param superMap
	 * @param depts
	 */
	/*@SuppressWarnings("unchecked")
	private void queryChildDepts(List<SyDept> depts){
		
		for(SyDept d:depts){
			List<SyDept> zdepts=(List<SyDept>)dao.find("from SyDept where superId=? order by deptSort asc",d.getId());
			if(!zdepts.isEmpty()){
				d.setDepts(zdepts);
				queryChildDepts(zdepts);	
			}
		}
	}*/
	
	@Override
	public String updateDept(SyDept d){
		System.out.println("super===="+d.getSuperId());
		Object obj=dao.findOne("from SyDept where deptName=? and superId=? and id!=?",d.getDeptName(),d.getSuperId(),d.getId());
		if(obj==null){
			boolean isTop=false;
			int t=0;
			String topDeptId="0";
			String deptId="0";
			deptId=d.getSuperId();
			while(isTop==false&&d.getSuperId()!=null){
				if(t>6)break;//如果摸查６次数都不能找到则 
				SyDept dept=(SyDept) dao.findOne("from SyDept where id=?",deptId);
				if(dept!=null){
					if(dept.getSuperId().equals("0")){//找到顶级部门
						topDeptId=dept.getId();
						isTop=true;
					}
					else
						deptId=dept.getSuperId();
				}
				t++;
			}
			if(topDeptId.equals("0"))
				topDeptId=d.getId();
			d.setOrgId(topDeptId);
			if(dao.update(d)){
				saveLog("修改部门", "部门名称："+d.getDeptName());
				//删除缓存
				MyCache.getInstance().removeCache(MyCache.DEPTID2NAME,d.getId());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.deptname.unique";//菜单名已被占用
		}
	}
	
	@Override
	public String deleteDept(String id){
		
		Object o=dao.findOne("from SyDept where superId=? ",id);
		if(o!=null){
			return "msg.dept.haschild";//部门下属还有子部门，无法删除
		}else{
			Object userObj=dao.findOne("from SyUsers where deptId=?",id);
			if(userObj!=null){
				return "msg.dept.hasuser";//有用户属于此部门，无法删除
			}
			SyDept dept=dao.get(SyDept.class, id);
			if(dept!=null){
				if(dao.delete(dept)){
					saveLog("删除部门", "部门名称："+dept.getDeptName());
					//删除缓存
					MyCache.getInstance().removeCache(MyCache.DEPTID2NAME,id);
					
					return MsgConfig.MSG_KEY_SUCCESS;
				}else{
					return MsgConfig.MSG_KEY_FAIL;
				}
			}else{
				return MsgConfig.MSG_KEY_NODATA;
			}
		}
		
	}
	

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectDepts(PageParam param,SyDept dept){
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SyDept d where 1=1 ");
		List list=new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		if(!sa&&!dev){
			sb.append(" and d.orgId=? ");
			list.add(""+member.getOrgId()+"");
		}
		if(StringUtils.isNotBlank(dept.getDeptName())){
			sb.append(" and d.deptName like ? ");
			list.add("%"+dept.getDeptName()+"%");
		}
		
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		 
		
		data.setRows(rows);
		
		return data;
	
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectDepts(PageParam param,SysOrg org){
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SyDept d where 1=1 ");
		List list=new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		if(!sa&&!dev){
			sb.append(" and d.orgId=? ");
			list.add(""+member.getOrgId()+"");
		}
		
		
		if(StringUtils.isNotBlank(org.getOrgName())){
			sb.append(" and d.deptName like ? ");
			list.add("%"+org.getOrgName()+"%");
		}
		
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		 
		
		data.setRows(rows);
		
		return data;
	
	}
	@Override 
	public String  getAreaPos(String area){
		String pos="";
		String sql=" select  pos from jd_city where   city='"+area+"'";
		List<String> list=dao.findsql(sql);
		if(list!=null&&list.size()>0)
			return list.get(0);
		else
			return "";
	} 
}
