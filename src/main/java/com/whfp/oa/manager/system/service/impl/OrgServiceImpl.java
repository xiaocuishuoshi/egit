/**  
 * @Project: jxoa
 * @Title: OrgServiceImpl.java
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
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.system.bean.SysOrg;
import com.whfp.oa.manager.system.service.IOrgService;

/**
 * 
 * 类名：OrgServiceImpl
 * 功能：单位管理 业务操作
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-4-3 下午5:11:01
 *
 */
@Service
public class OrgServiceImpl extends BaseServiceImpl implements IOrgService{
	
	@Override
	public String addOrg(SysOrg d){
		Object obj=dao.findOne("from SysOrg where orgName=? and superId=?",d.getOrgName(),d.getSuperId());
		if(obj==null){
			dao.save(d);
			if(StringUtils.isNotBlank(d.getId())){
				
				saveLog("添加单位", "单位名称:"+d.getOrgName());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.orgname.unique";//单位名称已被占用
		}
		
	}
	
	/**
	 * 查询出所有单位
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SysOrg> selectAllOrgs(){
		
		return dao.find("from SysOrg  order by orgSort asc");
	}
	/**
	 * 查询出所有单位
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectAllOrgsMap(){
		
		return dao.find("select new Map(id as id,orgName as orgName,superId as superId)from SysOrg  order by orgSort asc");
	}
	
	/**
	 * 递归查询子节点 
	 * @param superMap
	 * @param orgs
	 */
	/*@SuppressWarnings("unchecked")
	private void queryChildOrgs(List<SysOrg> orgs){
		
		for(SysOrg d:orgs){
			List<SysOrg> zorgs=(List<SysOrg>)dao.find("from SysOrg where superId=? order by orgSort asc",d.getId());
			if(!zorgs.isEmpty()){
				d.setOrgs(zorgs);
				queryChildOrgs(zorgs);	
			}
		}
	}*/
	
	@Override
	public String updateOrg(SysOrg d){
		
		Object obj=dao.findOne("from SysOrg where orgName=? and superId=? and id!=?",d.getOrgName(),d.getSuperId(),d.getId());
		if(obj==null){
			
			if(dao.update(d)){
				saveLog("修改单位", "单位名称："+d.getOrgName());
				//删除缓存
				MyCache.getInstance().removeCache(MyCache.DEPTID2NAME,d.getId());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.orgname.unique";//菜单名已被占用
		}
	}
	
	@Override
	public String deleteOrg(String id){
		
		Object o=dao.findOne("from SysOrg where superId=? ",id);
		if(o!=null){
			return "msg.org.haschild";//单位下属还有子单位，无法删除
		}else{
			Object userObj=dao.findOne("from SyUsers where orgId=?",id);
			if(userObj!=null){
				return "msg.org.hasuser";//有用户属于此单位，无法删除
			}
			SysOrg org=dao.get(SysOrg.class, id);
			if(org!=null){
				if(dao.delete(org)){
					saveLog("删除单位", "单位名称："+org.getOrgName());
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
	public DataGrid selectOrgs(PageParam param,SysOrg org){
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SysOrg d where 1=1 ");
		List list=new ArrayList();
		if(StringUtils.isNotBlank(org.getOrgName())){
			sb.append(" and d.orgName like ? ");
			list.add("%"+org.getOrgName()+"%");
		}
		
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
		 
		
		data.setRows(rows);
		
		return data;
	
	}
	
	
}
