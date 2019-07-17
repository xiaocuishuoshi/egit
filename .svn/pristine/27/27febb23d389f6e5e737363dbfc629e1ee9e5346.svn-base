/**  
 * @Project: jxoa
 * @Title: RoleServiceImpl.java
 * @Package com.whfp.oa.manager.system.service.impl
 * @date 2013-4-28 下午2:57:53
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.whfp.oa.manager.system.bean.SyRole;
import com.whfp.oa.manager.system.bean.SyRoleAction;
import com.whfp.oa.manager.system.bean.SyRoleMenu;
import com.whfp.oa.manager.system.bean.SyUserRole;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IRoleService;

/**
 * 
 * 类名：RoleServiceImpl
 * 功能：角色管理 业务层实现
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-4-28 下午2:57:53
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService{
	
	@Override
	public List selectAllRoles(){
		
		return dao.find("from SyRole ");
		
	}
	
	@Override
	public DataGrid selectRoles(PageParam param,SyRole role){
		
		DataGrid data=new DataGrid();
		
		StringBuffer hql=new StringBuffer("from SyRole r where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		//查询条件
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo"); 
//		if(!sa&&!dev){ 
//			hql.append(" and   r.orgId=? ");
//			list.add(""+member.getOrgId()+"");
//		}
		if(StringUtils.isNotBlank(role.getRoleName())){
			hql.append(" and r.roleName like ? ");
			list.add("%"+role.getRoleName()+"%");
		}
		if(StringUtils.isNotBlank(role.getRoleDesc())){
			hql.append(" and r.roleDesc like ? ");
			list.add("%"+role.getRoleDesc()+"%");
		}
		
		
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+hql,list));
		
		param.appendOrderBy(hql);//排序
		
		data.setRows(dao.findPage(hql.toString(),param.getPage(),param.getRows(),list));
		
		
		return data;
		
	
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Long selectRolesCount(SyRole role){
		
		StringBuffer sb=new StringBuffer("select count(*)from SyRole r where 1=1 ");
		List list=new ArrayList();
		//查询条件
		if(StringUtils.isNotBlank(role.getRoleName())){
			sb.append(" and r.roleName like ? ");
			list.add("%"+role.getRoleName()+"%");
		}
				
		
		return (Long)dao.findUniqueOne(sb.toString(),list);
		
	}
	@Override
	public String addRole(SyRole role){
		
		Object obj=dao.findOne("from SyRole where roleName=? ",role.getRoleName());
		if(obj==null){
			dao.save(role);
			if(StringUtils.isNotBlank(role.getId())){
				saveLog("添加角色", "角色名称:"+role.getRoleName());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.role.unique";//此角色名称已存在
		}
	}

	@Override
	public String updateRole(SyRole role){
		Object obj=dao.findOne("from SyRole where id!=? and roleName=? ",role.getId(),role.getRoleName());
		if(obj==null){
			if(dao.update(role)){
				saveLog("修改角色", "角色名称:"+role.getRoleName());
				
				//删除缓存
				MyCache.getInstance().removeCache(MyCache.ROLE2NAME,role.getId());
				
				return MsgConfig.MSG_KEY_SUCCESS;
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.role.unique";//此角色名称已存在
		}
	}
	@Override
	public boolean deleteRoles(String[] ids){
		//等待删除的对象集合
		List<Object> c=new ArrayList<Object>();
		for(String id:ids){
			SyRole r=dao.get(SyRole.class, id);
			if(r!=null){
				saveLog("删除角色", "删除名称:"+r.getRoleName());
				c.add(r);
				//删除缓存
				MyCache.getInstance().removeCache(MyCache.ROLE2NAME,id);
			}
		}
		return dao.deleteAll(c);
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectPowers(String id){
		
		List allMenus=dao.find("from SyMenu order by menuSort asc");
		List allActions=dao.find("from SyAction  order by actionSort asc");
		List<String> oldMenus=dao.find("select menuId from SyRoleMenu where roleId=?",id);
		List<String> oldActions=dao.find("select actionId from SyRoleAction  where roleId=? ",id);
		Map map=new HashMap();
		map.put("menus", allMenus);
		map.put("actions", allActions);
		map.put("hasMenus", oldMenus);
		map.put("hasActions", oldActions);
		
		return map;
	
	}
	
	@Override
	public boolean updatePowers(String roleId,String addMenuIds,String delMenuIds,String addActionIds,String delActionIds){
		//等待添加更新的对象集合
		List<Object> c=new ArrayList<Object>();
		//添加菜单关联
		if(StringUtils.isNotBlank(addMenuIds)){
			String[] list_addMenuIds=addMenuIds.split(",");
			for(String id:list_addMenuIds){
			
				SyRoleMenu rm=new SyRoleMenu();
				rm.setRoleId(roleId);
				rm.setMenuId(id);
		
				c.add(rm);
			}
		}
		//删除菜单关联
		if(StringUtils.isNotBlank(delMenuIds)){
			String[] list_delMenuIds=delMenuIds.split(",");
			for(String id:list_delMenuIds){
				dao.delete(" delete SyRoleMenu where roleId=? and menuId=? ", roleId,id);
			}
		}
		//添加操作关联
		if(StringUtils.isNotBlank(addActionIds)){
			String[] list_addActionIds=addActionIds.split(",");
			for(String id:list_addActionIds){
				SyRoleAction ra=new SyRoleAction();
				ra.setRoleId(roleId);
				ra.setActionId(id);
	
				c.add(ra);
			}
		}
		//删除操作关联
		if(StringUtils.isNotBlank(delActionIds)){
			String[] list_delActionIds=delActionIds.split(",");
			for(String id:list_delActionIds){
				dao.delete(" delete SyRoleAction where roleId=? and actionId=? ", roleId,id);
			}
		}
		return dao.saveOrUpdateAll(c);
	}
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public DataGrid selectUsers(PageParam param,String roleId,SyUsers user){
		DataGrid data=new DataGrid();
		//先查询出已具有此角色的用户id
		List<String> ids=dao.find("select ur.userId from SyUserRole ur where  ur.roleId=?",roleId);
		Map<String,Object> map=new HashMap<String,Object>();
		StringBuffer sb=new StringBuffer("from SyUsers u where ");
		if(ids.isEmpty()){
			sb.append(" 1=1 ");
		}else{
			sb.append(" u.id not in(:ids) ");
			map.put("ids",ids);
		}
		//查询条件
		if(StringUtils.isNotBlank(user.getUserName())){
			sb.append(" and u.userName like :userName ");
			map.put("userName", "%"+user.getUserName()+"%");
		}
		if(StringUtils.isNotBlank(user.getTrueName())){
			sb.append(" and u.trueName like :trueName ");
			map.put("trueName", "%"+user.getTrueName()+"%");
		}
		if(StringUtils.isNotBlank(user.getDeptId())&&!"0".equals(user.getDeptId())){
			sb.append(" and u.deptId = :deptId ");
			map.put("deptId",user.getDeptId());
		}
		if(user.getUserSex()!=null){
			sb.append(" and u.userSex = :userSex ");
			map.put("userSex", user.getUserSex());
		}
		if(user.getUserStatus()!=null){
			sb.append(" and u.userStatus = :userStatus ");
			map.put("userStatus", user.getUserStatus());
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,map));
		param.appendOrderBy(sb);//排序
		List<Map<String,Object>> rows=dao.findPage("select new Map(u.id as id,u.userName as userName, " +
				"u.userStatus as userStatus,u.trueName as trueName,u.userSex as userSex,u.deptId as deptId)"
				+sb.toString(),param.getPage(),param.getRows(),map);
		 
		for(Map<String,Object> m:rows){
			m.put("deptName",MyCache.getInstance().getDeptName((String)m.get("deptId")));
		 
		}		
		data.setRows(rows);
		return data;
		
	}
	@Override
	public boolean addUserRole(String roleId,String[] ids){
		//等待添加的对象集合
		List<Object> c=new ArrayList<Object>();
		for(String id:ids){
			if(StringUtils.isNotBlank(id)){
				
				SyUserRole ur=new SyUserRole();
				ur.setRoleId(roleId);
				ur.setUserId(id);
				c.add(ur);
			}
		}
		return dao.saveOrUpdateAll(c);
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectRoleUsers(PageParam param,String roleId,SyUsers user){
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SyUsers u ,SyUserRole ur where u.id=ur.userId  and ur.roleId=? ");
		List list=new ArrayList();
		list.add(roleId);
		//查询条件
		if(StringUtils.isNotBlank(user.getUserName())){
			sb.append(" and u.userName like ? ");
			list.add("%"+user.getUserName()+"%");
		}
		if(StringUtils.isNotBlank(user.getTrueName())){
			sb.append(" and u.trueName like ? ");
			list.add("%"+user.getTrueName()+"%");
		}
		if(StringUtils.isNotBlank(user.getDeptId())&&!"0".equals(user.getDeptId())){
			sb.append(" and u.deptId = ? ");
			list.add(user.getDeptId());	
		}
		if(user.getUserSex()!=null){
			sb.append(" and u.userSex = ? ");
			list.add(user.getUserSex());	
		}
		if(user.getUserStatus()!=null){
			sb.append(" and u.userStatus = ? ");
			list.add(user.getUserStatus());	
		}
		
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
		
		param.appendOrderBy(sb);//排序
		
		List<Map<String,Object>> rows=dao.findPage("select new Map(ur.id as id," +
				"u.userName as userName,u.userStatus as userStatus,u.trueName as trueName,u.userSex as userSex,u.deptId as deptId)"
				+sb.toString(),param.getPage(),param.getRows(),list);
		 
		for(Map<String,Object> map:rows){
			map.put("deptName",MyCache.getInstance().getDeptName((String)map.get("deptId")));
		 
		}		
		
		data.setRows(rows);
		
		return data;
		
	}
	@Override
	public boolean delUserRole(String[] ids){
		for(String id:ids){
			dao.delete(" delete SyUserRole where id=? ", id);
		}
		return true;
	}
	@Override
	public List<String> selectRolesByUserId(String userId){ 
		return dao.find("select roleId from SyUserRole where userId=? ",userId);
	}
	
	
}
