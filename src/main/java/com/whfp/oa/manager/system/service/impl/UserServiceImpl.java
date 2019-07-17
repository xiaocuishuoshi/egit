/**  
 * @Project: jxoa
 * @Title: UserServiceImpl.java
 * @Package com.whfp.oa.manager.system.service.impl
 * @date 2013-3-29 下午2:20:27
 * @Copyright: 2013 
 */
package com.whfp.oa.manager.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
 
import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SyUserRole;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IUserService;

/**
 * 
 * 类名：UserServiceImpl
 * 功能：用户管理 业务层实现
 * 详细：
 * 作者：LiuJincheng
 * 版本：1.0
 * 日期：2013-3-29 下午2:20:27
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService{
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectUsers(PageParam param,SyUsers user){
		DataGrid data=new DataGrid();
		StringBuffer sb=new StringBuffer("from SyUsers u where 1=1 ");
		
		List list=new ArrayList(); 
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		System.out.println("deptIds="+deptIds);
		
		
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
		}else{
			if(!sa&&!dev){
				sb.append(" and u.deptId in("+deptIds+")  "); 
				 
			}
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
		
		List<Map<String,Object>> rows=dao.findPage("select new Map(u.id as id,u.userName as userName,u.registerTime as registerTime,u.userStatus as userStatus," +
				"u.deptId as deptId,u.trueName as trueName,u.userSex as userSex) "
				+sb.toString(),param.getPage(),param.getRows(),list);
		 
		for(Map<String,Object> map:rows){
			map.put("deptName",MyCache.getInstance().getDeptName((String)map.get("deptId")));
		 
		}		
		
		data.setRows(rows);
		
		return data;
		
	}
	
	
	@Override
	public String addUser(SyUsers user){
		Object obj=dao.findOne("from SyUsers where userName=?",user.getUserName());
		if(obj==null){
			boolean isTop=false;
			int t=0;
			String topDeptId="0";
			String deptId="0";
			deptId=user.getDeptId();
			while(isTop==false){
				if(t>6)break;//如果摸查６次数都不能找到则
				System.out.println("deptId="+deptId);
					SyDept dept=(SyDept) dao.findOne("from SyDept where id=?",deptId);
				if(dept.getSuperId().equals("0")){//找到顶级部门
					topDeptId=dept.getId();
					isTop=true;
				}
				else
					deptId=dept.getSuperId();
				t++;
			}
			if(topDeptId.equals("0"))
				topDeptId=user.getDeptId();
			user.setOrgId(topDeptId);
			Member me=ServletUtil.getMember();
			user.setRegisterUid(me.getId());
			
			user.setUserPassword(MD5Util.MD5(user.getUserPassword()));
			user.setErrorCount((short)0);
			user.setLastLoginIp("x.x.x.x");//设置用户最后登录ip，可以根据此ip判断用户是否为第一次登录系统
			user.setRegisterTime(DateUtil.getCurrentTimeStamp());
			boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
			boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
			if(!sa&&!dev)
				user.setUserStatus((short)1);
			dao.save(user);
			
			if(StringUtils.isNotBlank(user.getId())){
				try{
				JdRyb ryb=new JdRyb();
				ryb.setJdRyid(user.getId());
				ryb.setJdRyxm(user.getTrueName());
				ryb.setFkDeptId(user.getDeptId());
				String jd_dqgkdq="湖北省武穴市";
				String jd_hdqy="115.933256, 30.307241;115.938827, 30.307218;115.945403, 30.316165;115.948881, 30.312347;115.958854, 30.312169;115.965677, 30.30641;115.979242, 30.304494;115.994949, 30.292735;115.990897, 30.283856;115.997086, 30.277172;115.992685, 30.27178;115.994357, 30.267901;116.00258, 30.261562;116.016766, 30.259885;116.021479, 30.251972;116.019792, 30.24688;116.0345, 30.24611;116.035058, 30.239861;116.049434, 30.232436;116.054099, 30.225438;116.063322, 30.225327;116.071754, 30.211239;116.067526, 30.207052;116.072542, 30.200057;116.062027, 30.192428;116.061776, 30.188938;116.067774, 30.159359;116.076815, 30.138369;116.094534, 30.131912;116.090472, 30.120182;116.095002, 30.110338;116.087375, 30.096647;116.09333, 30.083696;116.08326, 30.071534;116.085095, 30.061653;116.098449, 30.037232;116.08855, 30.031404;116.090631, 30.024616;116.084122, 30.000224;116.086296, 29.986582;116.07991, 29.971681;116.133358, 29.906049;116.133564, 29.890932;116.140501, 29.883643;116.133319, 29.863216;116.140065, 29.853345;116.136074, 29.841912;116.142104, 29.829065;116.093617, 29.804557;116.053736, 29.765578;115.959152, 29.727326;115.928106, 29.726652;115.848032, 29.75113;115.768573, 29.800214;115.712613, 29.84302;115.689115, 29.857244;115.673455, 29.857101;115.613694, 29.842301;115.561316, 29.841284;115.5252, 29.843555;115.491676, 29.851511;115.46426, 29.864604;115.436349, 29.905496;115.41745, 29.917337;115.41487, 29.950444;115.389097, 29.972167;115.368123, 30.006744;115.333188, 30.04023;115.32898, 30.053334;115.327335, 30.082338;115.30526, 30.122989;115.23118, 30.208822;115.214144, 30.218919;115.195419, 30.222019;115.173966, 30.221622;115.148019, 30.211853;115.12642, 30.215717;115.103114, 30.227566;115.086667, 30.242818;115.085262, 30.267359;115.096426, 30.298311;115.09247, 30.330363;115.104584, 30.354133;115.094606, 30.369622;115.085576, 30.362024;115.074439, 30.382023;115.055222, 30.399363;115.018059, 30.411633;114.957343, 30.410559;114.895936, 30.417372;114.866537, 30.436246;114.853994, 30.448418;114.842412, 30.468337;114.838537, 30.494727;114.845446, 30.546981;114.844419, 30.566417;114.815363, 30.595449;114.811554, 30.606528;114.794198, 30.619363;114.802522, 30.625508;114.846285, 30.630204;114.858127, 30.637346;114.85142, 30.643258;114.861183, 30.639989;114.864171, 30.64195;114.860203, 30.649033;114.852272, 30.647867;114.852101, 30.653853;114.835283, 30.675505;114.830507, 30.676892;114.825561, 30.669529;114.819804, 30.666575;114.816514, 30.668242;114.811099, 30.680345;114.817529, 30.692339;114.802808, 30.705428;114.790826, 30.727486;114.810885, 30.729886;114.822966, 30.736901;114.847936, 30.744705;114.877126, 30.76586;114.8828, 30.776263;114.882513, 30.798587;114.88531, 30.802074;114.894284, 30.802577;114.921991, 30.790449;114.939121, 30.802092;114.957986, 30.781562;114.963342, 30.786666;114.963964, 30.792865;114.960114, 30.799798;114.951639, 30.802635;114.950814, 30.808121;114.969669, 30.813316;114.97633, 30.818195;114.979415, 30.813385;114.987561, 30.821945;114.989159, 30.814371;114.994905, 30.815386;114.998204, 30.830591;115.007347, 30.836425;114.998341, 30.851483;115.0057, 30.864559;115.025286, 30.869018;115.028789, 30.862642;115.036511, 30.862914;115.035839, 30.854631;115.043406, 30.851153;115.05348, 30.862421;115.056052, 30.858734;115.060972, 30.861246;115.059112, 30.869897;115.085775, 30.888963;115.082644, 30.897855;115.066106, 30.900638;115.064105, 30.90925;115.042152, 30.915286;115.027965, 30.931268;115.018792, 30.92898;114.999273, 30.946402;114.992939, 30.961009;114.998714, 30.973105;114.992991, 30.974555;114.988736, 30.980992;114.995281, 30.990673;114.99451, 31.003842;114.989741, 31.003911;114.990181, 30.998608;114.986967, 30.998621;114.991013, 31.020611;114.986243, 31.03184;114.982844, 31.033432;114.977519, 31.029339;114.983139, 31.012355;114.967394, 30.992596;114.961789, 30.993082;114.955782, 31.00162;114.945048, 31.003443;114.942708, 31.008364;114.934727, 31.001685;114.926412, 31.020488;114.911053, 31.011414;114.888873, 31.012258;114.875398, 31.003719;114.862745, 30.991306;114";
				ryb.setJdDqgkdq(jd_dqgkdq);
				ryb.setJdHdqy(jd_hdqy);
				dao.save(ryb); 
		 
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					saveLog("添加用户", "账号:"+user.getUserName()); 
					ServletUtil.getSession().removeAttribute("jmpw");//清除加密密码
					return MsgConfig.MSG_KEY_SUCCESS;
				}
				
				
			}else{
				return MsgConfig.MSG_KEY_FAIL;
			}
		}else{
			return "msg.username.unique";//用户名已被占用
		}
	}
	
	@Override
	public String addUsers(List<Map> excel){
		List<SyUsers> lu  = new ArrayList<SyUsers>();
		try {
			for (Map<Integer ,String> map : excel) {
				SyUsers user = new SyUsers();
				user.setUserName(map.get(0));
				user.setTrueName(map.get(1));
				System.out.println("map.get(2).toString()="+map.get(2).toString());
				String did = (String)dao.findOne("select id from SyDept where deptName=?  ", map.get(2).toString());
				
				if(did!=null && !"".equals(did)){
					user.setDeptId(did);
				}else{
					continue;
				}
				if("女".equals(map.get(3))){
					user.setUserSex((short)0);
				}else{
					user.setUserSex((short)1);
				}
				user.setMobilePhoneNumber(map.get(4));
				if("是".equals(map.get(5))){
					user.setUserStatus((short)1);
				}else{
					//禁止登陆
					user.setUserStatus((short)0);
				}
				
				
				user.setUserPassword("H1AF2G39C90F59F00H5DHA574BA4EE3H");//默认密码123456
				Member me=ServletUtil.getMember();
				user.setRegisterUid(me.getId());
				user.setErrorCount((short)0);
				user.setLastLoginIp("x.x.x.x");//设置用户最后登录ip，可以根据此ip判断用户是否为第一次登录系统
				user.setRegisterTime(DateUtil.getCurrentTimeStamp());
				//lu.add(user); 
				dao.save(user);
				JdRyb ryb=new JdRyb();
				ryb.setJdRyid(user.getId());
				ryb.setJdRyxm(user.getTrueName());
				ryb.setFkDeptId(user.getDeptId());
				ryb.setJdHjd(map.get(6));
				ryb.setJdHjxxdz(map.get(7));
				ryb.setJdLxfs(user.getMobilePhoneNumber()); 
				if(user.getUserSex()==1)
					ryb.setJdRyxb("男");
				else
					ryb.setJdRyxb("女");
				SyDept dept=(SyDept)dao.findOne("from SyDept where id=?",user.getDeptId());
				if(dept!=null)
					ryb.setJdDqgkdq(dept.getDeptDesc());
				dao.save(ryb);
				 
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgConfig.MSG_KEY_FAIL;
		}
		return MsgConfig.MSG_KEY_SUCCESS;
	/*	if(dao.saveOrUpdateAll(lu)){
			return MsgConfig.MSG_KEY_SUCCESS;
		}else{
			return MsgConfig.MSG_KEY_FAIL;
					
		}*/
		
		
			
	}
	@Override
	public String addUsersAndJdryxx(List<Map> excel){
		List<SyUsers> lu  = new ArrayList<SyUsers>();
		try {
			int p=0;
			for (Map<Integer ,String> map : excel) {
				System.out.println(map.toString());
				SyUsers user = new SyUsers(); 
				String username=map.get(4);
				if(username!=null)
					username=username.replace("、", "");
				if(username==null||username.equals(""))continue;
				username=username.replace("'", "");
				username=username.replace("’", "").trim();
				List list=dao.findsql("select 1 from Sy_Users where user_Name='"+username+"'");
				if(list.size()>0)
					continue;
				user.setUserName(username);
				user.setTrueName(map.get(0)); 
				String did = (String)dao.findOne("select id from SyDept where deptName=?  ", map.get(6));
				
				if(did!=null && !"".equals(did)){ 
					user.setDeptId(did);
				}else{
				   user.setDeptId(ServletUtil.getMember().getDeptId());
				}
				if("女".equals(map.get(15))){
					user.setUserSex((short)0);
				}else{
					user.setUserSex((short)1);
				} 
				
				//user.setMobilePhoneNumber(map.get(20));
				user.setUserStatus((short)1);
				
				user.setUserPassword("H1AF2G39C90F59F00H5DHA574BA4EE3H");//默认密码123456
				Member me=ServletUtil.getMember();
				user.setRegisterUid(me.getId());
				user.setErrorCount((short)0);
				user.setLastLoginIp("x.x.x.x");//设置用户最后登录ip，可以根据此ip判断用户是否为第一次登录系统
				user.setRegisterTime(DateUtil.getCurrentTimeStamp());
				//lu.add(user); 
				dao.save(user);
				String jdlb=map.get(18);
				JdRyb ryb=new JdRyb();
				//ryb.setJdRybh("ch"+p+map.get(0));
				ryb.setJdCym(map.get(1)); 
				ryb.setJdCsrq(map.get(2));
				ryb.setJdMz(map.get(9));
				ryb.setJdRysg(map.get(10)); 
				ryb.setJdZjzl(map.get(3));
				ryb.setJdSfzh(map.get(4));
				ryb.setJdHyzk(map.get(8));
				ryb.setJdWhcd(map.get(16));
				//ryb.setJdZy(map.get(12));
				ryb.setJdHjd(map.get(7));
				ryb.setJdHjxxdz(map.get(5));
				//
				ryb.setJdHjdpcs(map.get(6));
				ryb.setJdJzd(map.get(11));
				ryb.setJdJzdz(map.get(12));
				ryb.setJdJzdpcs(map.get(13));
				/*
				ryb.setJdJgry(map.get(19));
				ryb.setJdDwdh(map.get(20));
				ryb.setJdRyjg(map.get(21));
				ryb.setJdLxfs(map.get(22));
				ryb.setJdZzmm(map.get(23));
				ryb.setJdZjxy(map.get(24));
				ryb.setJdTscs(map.get(25));
				ryb.setJdLydpzl(map.get(26));
				ryb.setJdChdw(map.get(27));
				ryb.setJdChrq(map.get(28));
				ryb.setJdDqgkxz(map.get(29));
				ryb.setJdDqgkdq(map.get(30));
				//ryb.setJdWghxh(Integer.valueOf(StringUtil.toNumber(map.get(32))));
				ryb.setJdWgy(map.get(32)); */
				ryb.setJdRyid(user.getId());
				ryb.setJdRyxm(user.getTrueName());
				ryb.setFkDeptId(user.getDeptId()); 
				if(jdlb==null)
					jdlb="";
				if(jdlb.contains("药物"))
					ryb.setJdRylb(1);
				else if(jdlb.equals("社区康复"))
					ryb.setJdRylb(3);
				else if(jdlb.equals("社区戒毒"))
					ryb.setJdRylb(2);
				else if(jdlb.contains("强制隔离戒毒"))
					ryb.setJdRylb(4);
				else
					ryb.setJdRylb(5);
				
				ryb.setJdLxfs(user.getMobilePhoneNumber()); 
				if(user.getUserSex()==1)
					ryb.setJdRyxb("男");
				else
					ryb.setJdRyxb("女");
				SyDept dept=(SyDept)dao.findOne("from SyDept where id=?",user.getDeptId());
				if(dept!=null)
					ryb.setJdDqgkdq(dept.getDeptDesc());
				
				String jd_dqgkdq="湖北省武穴市";
				String jd_hdqy="115.933256, 30.307241;115.938827, 30.307218;115.945403, 30.316165;115.948881, 30.312347;115.958854, 30.312169;115.965677, 30.30641;115.979242, 30.304494;115.994949, 30.292735;115.990897, 30.283856;115.997086, 30.277172;115.992685, 30.27178;115.994357, 30.267901;116.00258, 30.261562;116.016766, 30.259885;116.021479, 30.251972;116.019792, 30.24688;116.0345, 30.24611;116.035058, 30.239861;116.049434, 30.232436;116.054099, 30.225438;116.063322, 30.225327;116.071754, 30.211239;116.067526, 30.207052;116.072542, 30.200057;116.062027, 30.192428;116.061776, 30.188938;116.067774, 30.159359;116.076815, 30.138369;116.094534, 30.131912;116.090472, 30.120182;116.095002, 30.110338;116.087375, 30.096647;116.09333, 30.083696;116.08326, 30.071534;116.085095, 30.061653;116.098449, 30.037232;116.08855, 30.031404;116.090631, 30.024616;116.084122, 30.000224;116.086296, 29.986582;116.07991, 29.971681;116.133358, 29.906049;116.133564, 29.890932;116.140501, 29.883643;116.133319, 29.863216;116.140065, 29.853345;116.136074, 29.841912;116.142104, 29.829065;116.093617, 29.804557;116.053736, 29.765578;115.959152, 29.727326;115.928106, 29.726652;115.848032, 29.75113;115.768573, 29.800214;115.712613, 29.84302;115.689115, 29.857244;115.673455, 29.857101;115.613694, 29.842301;115.561316, 29.841284;115.5252, 29.843555;115.491676, 29.851511;115.46426, 29.864604;115.436349, 29.905496;115.41745, 29.917337;115.41487, 29.950444;115.389097, 29.972167;115.368123, 30.006744;115.333188, 30.04023;115.32898, 30.053334;115.327335, 30.082338;115.30526, 30.122989;115.23118, 30.208822;115.214144, 30.218919;115.195419, 30.222019;115.173966, 30.221622;115.148019, 30.211853;115.12642, 30.215717;115.103114, 30.227566;115.086667, 30.242818;115.085262, 30.267359;115.096426, 30.298311;115.09247, 30.330363;115.104584, 30.354133;115.094606, 30.369622;115.085576, 30.362024;115.074439, 30.382023;115.055222, 30.399363;115.018059, 30.411633;114.957343, 30.410559;114.895936, 30.417372;114.866537, 30.436246;114.853994, 30.448418;114.842412, 30.468337;114.838537, 30.494727;114.845446, 30.546981;114.844419, 30.566417;114.815363, 30.595449;114.811554, 30.606528;114.794198, 30.619363;114.802522, 30.625508;114.846285, 30.630204;114.858127, 30.637346;114.85142, 30.643258;114.861183, 30.639989;114.864171, 30.64195;114.860203, 30.649033;114.852272, 30.647867;114.852101, 30.653853;114.835283, 30.675505;114.830507, 30.676892;114.825561, 30.669529;114.819804, 30.666575;114.816514, 30.668242;114.811099, 30.680345;114.817529, 30.692339;114.802808, 30.705428;114.790826, 30.727486;114.810885, 30.729886;114.822966, 30.736901;114.847936, 30.744705;114.877126, 30.76586;114.8828, 30.776263;114.882513, 30.798587;114.88531, 30.802074;114.894284, 30.802577;114.921991, 30.790449;114.939121, 30.802092;114.957986, 30.781562;114.963342, 30.786666;114.963964, 30.792865;114.960114, 30.799798;114.951639, 30.802635;114.950814, 30.808121;114.969669, 30.813316;114.97633, 30.818195;114.979415, 30.813385;114.987561, 30.821945;114.989159, 30.814371;114.994905, 30.815386;114.998204, 30.830591;115.007347, 30.836425;114.998341, 30.851483;115.0057, 30.864559;115.025286, 30.869018;115.028789, 30.862642;115.036511, 30.862914;115.035839, 30.854631;115.043406, 30.851153;115.05348, 30.862421;115.056052, 30.858734;115.060972, 30.861246;115.059112, 30.869897;115.085775, 30.888963;115.082644, 30.897855;115.066106, 30.900638;115.064105, 30.90925;115.042152, 30.915286;115.027965, 30.931268;115.018792, 30.92898;114.999273, 30.946402;114.992939, 30.961009;114.998714, 30.973105;114.992991, 30.974555;114.988736, 30.980992;114.995281, 30.990673;114.99451, 31.003842;114.989741, 31.003911;114.990181, 30.998608;114.986967, 30.998621;114.991013, 31.020611;114.986243, 31.03184;114.982844, 31.033432;114.977519, 31.029339;114.983139, 31.012355;114.967394, 30.992596;114.961789, 30.993082;114.955782, 31.00162;114.945048, 31.003443;114.942708, 31.008364;114.934727, 31.001685;114.926412, 31.020488;114.911053, 31.011414;114.888873, 31.012258;114.875398, 31.003719;114.862745, 30.991306;114";
				ryb.setJdDqgkdq(jd_dqgkdq);
				ryb.setJdHdqy(jd_hdqy);
				dao.save(ryb); 
				p++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgConfig.MSG_KEY_FAIL;
		}
		return MsgConfig.MSG_KEY_SUCCESS;
	/*	if(dao.saveOrUpdateAll(lu)){
			return MsgConfig.MSG_KEY_SUCCESS;
		}else{
			return MsgConfig.MSG_KEY_FAIL;
					
		}*/
		
		
			
	}
	
	
	@Override
	public String updateUser(SyUsers u){
		SyUsers old=dao.get(SyUsers.class, u.getId());
		if(old==null){
			return MsgConfig.MSG_KEY_NODATA;
		}
		Object obj=dao.findOne("from SyUsers where userName=? and id!=?",u.getUserName(),u.getId());
		if(obj!=null){
			return "msg.username.unique";//用户名已被占用
		}
		
		if(StringUtils.isNotBlank(u.getUserPassword())){
			old.setUserPassword(MD5Util.MD5(u.getUserPassword()));
		}
		old.setUserName(u.getUserName());
		old.setTrueName(u.getTrueName());
		old.setUserSex(u.getUserSex());
		old.setDeptId(u.getDeptId());
		old.setUserDesc(u.getUserDesc());
		
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		if(sa||dev)
		old.setUserStatus(u.getUserStatus());
		old.setMobilePhoneNumber(u.getMobilePhoneNumber());
		
		saveLog("修改用户", "账号:"+old.getUserName()); 
		Object object=dao.findOne("from JdRyb where jdRyid=?", u.getId()); 
		if(object==null){
			JdRyb ryb=new JdRyb(); 
			ryb.setJdRyid(u.getId());
			ryb.setJdRyxm(u.getTrueName());
			ryb.setFkDeptId(u.getDeptId());
			ryb.setJdLxfs(u.getMobilePhoneNumber());
			if(u.getUserSex()==1)
				ryb.setJdRyxb("男");
			else
				ryb.setJdRyxb("女");
			SyDept dept=(SyDept)dao.findOne("from SyDept where id=?",u.getDeptId());
			if(dept!=null)
				ryb.setJdDqgkdq(dept.getDeptDesc());
			dao.save(ryb);
		}else{
			JdRyb ryb=(JdRyb)object;
			ryb.setJdRyxm(u.getTrueName());
			ryb.setJdLxfs(u.getMobilePhoneNumber());
			if(u.getUserSex()==1)
				ryb.setJdRyxb("男");
			else
				ryb.setJdRyxb("女");
			SyDept dept=(SyDept)dao.findOne("from SyDept where id=?",u.getDeptId());
			if(dept!=null)
				ryb.setJdDqgkdq(dept.getDeptDesc());
			dao.update(ryb);
		}
		//删除缓存
		MyCache.getInstance().removeCache(MyCache.USERID2INFO,old.getId());
		
		
		
		return MsgConfig.MSG_KEY_SUCCESS;
		
	}
	
	
	@Override
	public boolean deleteUser(String[] ids){
		//等待删除的对象集合
		List<Object> c=new ArrayList<Object>();
		for(String id:ids){
			SyUsers user=dao.get(SyUsers.class, id);
			if(user!=null){
				if(user.getId().equals(ServletUtil.getMember().getId()))//不能删除自己的账号信息
					continue;
				//开发人员账号，超级管理员账号不可删除
				if(!user.getUserName().equals(BaseConfig.getInstance().getDevName())&&!user.getUserName().equals(BaseConfig.getInstance().getSaName())){
					
					saveLog("删除用户", "账号："+user.getUserName()+" 姓名："+user.getTrueName());
					c.add(user);
					
					//删除缓存
					MyCache.getInstance().removeCache(MyCache.USERID2INFO,id);
					/**
			         * 删除IM用户[单个]
			         */
					/*EasemobIMUsers users = new EasemobIMUsers();
			        ObjectNode deleteIMUserByuserNameNode = EasemobIMUsers.deleteIMUserByuserName(user.getUserName());
			        if (null != deleteIMUserByuserNameNode) {
			            System.out.println("删除IM用户[单个]: " + deleteIMUserByuserNameNode.toString());
			        }  */
					dao.update("update JdRyb set jdScbz=1 where jdRyid=?", id);
				}
				
			}
		}
		

		return dao.deleteAll(c);
	}
	

	@Override
	@SuppressWarnings("rawtypes")
	public List selectUserRoles(String userId){
		
		return dao.find("select r from SyRole r,SyUserRole ur where ur.userId=? and r.id=ur.roleId ",userId);
		
		
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectUserRolesAndIds(String userId){
		String cond="";
		if(!ServletUtil.isDeveloper()&&!ServletUtil.isSuperAdmin())
			cond=" where r.id<>'402881f73e4f9ae9013e4fa2cb080003' ";
		List<Map> allRoles=dao.find("select new Map(r.id as id,r.roleName as roleName)from SyRole r "+cond);
		List<String> oldRoles=dao.find("select roleId from SyUserRole where userId=? ",userId);
		Map map=new HashMap();
		map.put("roles", allRoles);
		map.put("hasRoles", oldRoles);
		
		return map;
		
	}
	@Override
	public boolean updateUserRoles(String userId,String[] addRoleIds,String[] delRoleIds){
		//等待修改的对象集合
		List<Object> c=new ArrayList<Object>();
		//添加用户角色关联
		
		for(String id:addRoleIds){
			SyUserRole ur=new SyUserRole();
			ur.setRoleId(id);
			ur.setUserId(userId);
			c.add(ur);
		}
		//删除用户角色关联
		for(String id:delRoleIds){
			dao.delete(" delete SyUserRole where roleId=? and userId=? ",id,userId);
		}
		
		return dao.saveOrUpdateAll(c);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String,Object> selectUserPowers(String userId){
		List<String> ids=dao.find("select r.id from SyRole r, SyUserRole ur where ur.roleId=r.id and ur.userId=? ",userId);
		Map<String,Object> map=new HashMap<String,Object>();
		if(!ids.isEmpty()){
			Map<String,Object> queryValues=new HashMap<String,Object>();
			queryValues.put("roleIds", ids);
			List menus=dao.find("select distinct new Map(m.id as id,m.menuName as menuName,m.menuSuperId as menuSuperId,m.menuIcon as menuIcon) from SyRoleMenu rm,SyMenu m where rm.menuId=m.id and rm.roleId in(:roleIds) order by m.menuSort asc",queryValues);
			List actions=dao.find("select distinct new Map(a.id as id,a.menuId as menuId, a.actionName as actionName) from SyRoleAction ra,SyAction a where ra.actionId=a.id and ra.roleId in(:roleIds) order by a.actionSort asc",queryValues);
			
			map.put("menus", menus);
			map.put("actions", actions);
			
		}else{
			map.put("noRole", true);
		}
		return map;
	}
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SyUsers> selectAllUsers(){
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		if(!sa&&!dev){
			return  dao.find("from SyUsers where orgId='"+member.getOrgId()+"'");
		}
		return  dao.find("from SyUsers");
		
	}
	
	@Override
	public boolean updatePassword(String id,String userPassword){
		
	
		boolean flag= dao.update("update SyUsers set userPassword=? where id=?",MD5Util.MD5(userPassword),id);
		 
		return flag;
			
	}
	
	@Override
	public boolean updateMyPassword(String oldPassword,String userPassword){ 
		SyUsers user=dao.get(SyUsers.class, ServletUtil.getMember().getId());
		if(MD5Util.MD5Validate(oldPassword, user.getUserPassword())){
			user.setUserPassword(MD5Util.MD5(userPassword));
			saveLog("修改密码", "");
			/*重置IM密码*/
			System.out.println("username="+user.getUserName()+" user.getUserPassword()="+user.getUserPassword());
			 
			return true;
		}else{
			return false;
		}
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectUsersLookUp(PageParam param,SyUsers user){
		DataGrid data=new DataGrid();
		
		StringBuffer sb=new StringBuffer("from SyUsers u where 1=1 ");
		List list=new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		if(!sa&&!dev){
			sb.append(" and  (u.deptId='"+ServletUtil.getMember().getDeptId()+"' or u.deptId='"+ServletUtil.getMember().getOrgId()+"')  ");  
		/*	sb.append(" and u.orgId=? ");
			list.add(""+member.getOrgId()+"");*/
		}
		if(StringUtils.isNotBlank(user.getTrueName())){
			sb.append(" and u.trueName like ? ");
			list.add("%"+user.getTrueName()+"%");
		}
		if(StringUtils.isNotBlank(user.getDeptId())){
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
		
		List<Map<String,Object>> rows=dao.findPage("select new Map(u.id as id," +
				"u.deptId as deptId,u.trueName as trueName,u.userSex as userSex) "
				+sb.toString(),param.getPage(),param.getRows(),list);
		 
		for(Map<String,Object> map:rows){
			map.put("deptName",MyCache.getInstance().getDeptName((String)map.get("deptId")));
		 
		}		
		
		data.setRows(rows);
		
		return data;
		
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid selectUsersLookUpNumber(PageParam param,SyUsers user){
		DataGrid data=new DataGrid();
		
		StringBuffer sb=new StringBuffer(" from SyUsers u where 1=1 ");
		List list=new ArrayList();
		boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
		boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
		Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
		String deptIds="'0'"; 
		if(ServletUtil.getSession().getAttribute("deptIds")!=null)
			deptIds=ServletUtil.getSession().getAttribute("deptIds").toString();
		if(!sa&&!dev){
		//	sb.append(" and u.deptId in("+deptIds+")  ");  
			sb.append(" and  (u.deptId='"+ServletUtil.getMember().getDeptId()+"' or u.deptId='"+ServletUtil.getMember().getOrgId()+"')  ");  
			
		/*	sb.append(" and u.orgId=? ");
			list.add(""+member.getOrgId()+"");*/
		}
		if(StringUtils.isNotBlank(user.getTrueName())){
			sb.append(" and u.trueName like ? ");
			list.add("%"+user.getTrueName()+"%");
		}
		if(StringUtils.isNotBlank(user.getDeptId())){
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
		
		List<Map<String,Object>> rows=dao.findPage("select new Map(u.id as id,u.mobilePhoneNumber as mobilePhoneNumber, " +
				"u.deptId as deptId,u.trueName as trueName,u.userSex as userSex) "
				+sb.toString(),param.getPage(),param.getRows(),list);
		 
		for(Map<String,Object> map:rows){
			map.put("deptName",MyCache.getInstance().getDeptName((String)map.get("deptId")));
		 
		}		
		
		data.setRows(rows);
		
		return data;
		
	}
	@Override
	public SyUsers findUserByLoginName(String name){ 
		
		return (SyUsers)dao.findOne("from SyUsers where userName = ?",name);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String,Collection<String>> selectRolesPowers(String userId){
		Map<String,Collection<String>> map=new HashMap<String,Collection<String>>();
		List<String> roleIds=dao.find("select roleId from SyUserRole where userId=? ",userId);
		//用户可以访问的url集合
		Set<String> urls=new HashSet<String>();
		for(String id:roleIds){
			List<String> menuUrls=dao.find("select distinct m.menuUrl from SyRoleMenu rm,SyMenu m where rm.menuId=m.id and rm.roleId=? ",id);
			for(String url:menuUrls){
			
				if(StringUtils.isNotBlank(url)){
					urls.add(url.split("\\?")[0]);
				}
			}
		}
		//获取操作url
		for(String id:roleIds){
			List<String> actUrl=dao.find("select distinct a.actionUrl from SyAction a,SyRoleAction ra where a.id=ra.actionId and ra.roleId=? ",id);
			for(String url:actUrl){
				if(StringUtils.isNotBlank(url)){
					urls.addAll(Arrays.asList(url.split(",")));
				}
			}
		}
		map.put("roleIds", roleIds);
		map.put("powers", urls);
		return map;
	}
//********************************安卓********************************************************
	/**
	 * id 用户id
	 * trueName  用户姓名
	 * sex 用户性别  1 男 0 女
	 * deptName部门名称
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryAllUsers(PageParam param) {
		
		return dao.findPage(" select new Map(u.id as id,u.trueName as trueName,u.userSex as sex,d.deptName as deptName) from SyUsers u,SyDept d where u.userStatus='1' and u.deptId=d.id  ", param.getPage(),param.getRows());
	}
	@Override
	public Long totleUsers() {
		
		return (Long) dao.findUniqueOne("select count(*) from SyUsers u where u.userStatus='1' " );
	}
	/**
	 * id 用户id
	 * trueName  用户姓名
	 * sex 用户性别  1 男 0 女
	 * deptName部门名称
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryUserConditions(String deptId,String name,PageParam param) {
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(" from SyUsers u,SyDept d where u.userStatus='1' and u.deptId=d.id  ");
		if(StringUtils.isNotBlank(deptId)){
			sb.append(" and u.deptId=? ");
			list.add(deptId);
		}
		if(StringUtils.isNotBlank(name)){
			sb.append(" and u.trueName like ? ");
			list.add("%"+name+"%");
		}
		return dao.findPage("select new Map(u.id as id,u.trueName as trueName,u.userSex as sex,d.deptName as deptName)"+sb.toString(),param.getPage(), param.getRows(),list); 
	}
	@Override
	public Long totleUserConditions(String deptId,String name) {
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(" from SyUsers u,SyDept d where u.userStatus='1' and u.deptId=d.id  ");
		if(StringUtils.isNotBlank(deptId)){
			sb.append(" and u.deptId=? ");
			list.add(deptId);
		}
		if(StringUtils.isNotBlank(name)){
			sb.append(" and u.trueName like ? ");
			list.add("%"+name+"%");
		}
		return (Long) dao.findUniqueOne("select count(*)"+sb.toString(),list);
	}
	
 
	@Override
	public SyUsers findUserByLoginId(String id) { 
		// TODO Auto-generated method stub
		return (SyUsers)dao.findOne("from SyUsers where id = ?",id); 

	}
}
