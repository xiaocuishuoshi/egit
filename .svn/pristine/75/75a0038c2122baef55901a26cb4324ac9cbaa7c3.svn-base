package com.whfp.oa.manager.hlkj.sbgl.service.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSb;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbgl;
import com.whfp.oa.manager.hlkj.sbgl.service.ISbglService;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;

@Service("SbglService")
public class SbglServiceImpl extends BaseServiceImpl implements ISbglService {

	@Override
	public String addSbgl(HlkjSbgl s,String bel) {
//				Object obj =dao.findOne(" from HlkjSbgl q where q.desc=?", s.getDesc());
//				if(obj==null){
//			boolean fla =false;
//			if(s.getType()!=null && !"".equals(s.getType())){
//				//读取规则表判断是否报警。
//					// HlkjRule rule=dao.findOne(" from HlkjRule r where r.type=?", s.getType());//待修改
//				//判断数据是否和规则（插入当条数据）（判断针对新数据，不针对数据库已存在数据。）
//				if(s.getStatus()!=null && !"".equals(s.getStatus()));{
//					//	 fla = s.getStatus().contains(rule.);
//				}
//				if(fla){
//				//  dao.save(rule);
//				}
//			}
		Object obj =dao.findOne(" from HlkjSb q where q.sortNum=?", s.getDesc());
		if(obj==null){
			HlkjSb hlsb = new HlkjSb();
			hlsb.setSortNum(s.getDesc());
			hlsb.setType(s.getType());
			if(bel==null &&"".equals(bel)){
				hlsb.setBelon("0000");
			}else{
				hlsb.setBelon(bel);
			}
			
			dao.save(hlsb);
		}
		
					if (dao.save(s)) {
						return "操作成功!";
					} else {
						return "操作失败!";
					}
//				}else{
//					return "数据库已有值!";//数据库已有值
//				}
	}
	
	
		@Override
		public List getAddress(String lm) {
			String sql ="select distinct(addressid) from HlkjSbgl  where 1=1 and addressid is not null ";
			if(lm!=null && !"".equals(lm)){
				sql+=" and sblm='"+lm+"'"; 
			}
			List list = dao.find(sql);
			return list;
		}
		
		@Override
		public List<Map<String,Object>> selectAddressByLmMap(String lm){
			boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
			boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev"); 
			if(sa||dev) 
				return dao.find("select new Map(id as id,addressName as addressName)from HlkjAddress t where t.id  in (select addressid from HlkjSbgl s where s.sblm='"+lm+"' )");
			//return dao.find("select new Map(id as id,addressName as addressName)from HlkjAddress t where t.id  in (select addressid from HlkjSbgl)");
			else{
				Member member= (Member) ServletUtil.getSession().getAttribute("minfo");
				String orgId=member.getOrgId();
				return dao.find("select new Map(id as id,addressName as addressName)from HlkjAddress t where t.id  in (select addressid from HlkjSbgl s where s.sblm='"+lm+"' )");
			}
		}
		
		
		 @Override
		public DataGrid selectSbgl(PageParam param,HlkjSbgl  s){
				DataGrid data = new DataGrid();
				StringBuffer sb = new StringBuffer("from HlkjSbgl t  where 1=1 ");
				List list = new ArrayList();
				// 查询条件
				if (s.getAddressid() != null && !"".equals(s.getAddressid())) {
					sb.append(" and addressid = ?");
					list.add( s.getAddressid());
				}
				
				if (s.getSblm() != null && !"".equals(s.getSblm())) {
					sb.append(" and sblm = ? ");
					list.add(s.getSblm());
				}else{
					
					return data;
				}
				
				if(list.size()<1){
					data.setTotal(0l);
				}else{
				data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
				}
				sb.append(" GROUP BY t.desc ORDER BY t.updatetime desc ");
			//	sb.append(" order by fbsj desc");
				
				
				List<HlkjSbgl> sbgl = dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
				if(sbgl.size()>0){
					for(int k =0;k<sbgl.size();k++){
						
						JSONObject  jasonObject = JSONObject.fromObject(sbgl.get(k).getStatus());
						Map map = (Map)(JSONObject.toBean(jasonObject, Map.class));
						if(map!=null){
							Iterator<String> it = map.keySet().iterator();
							String res="";
							while(it.hasNext()){
									String key = it.next();
									Object val = map.get(key);
									System.out.println("key="+key+",value="+val);
									
									
									if(sbgl.get(k).getType().equals("门磁3长闭门")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("关");
										}else{
											sbgl.get(k).setStatus("开");	
										}
									}else if(sbgl.get(k).getType().equals("电灯")){
										if(val.equals(10)){
											sbgl.get(k).setStatus("开");
										}else{
											sbgl.get(k).setStatus("关");	
										}
										
									}
									else if(sbgl.get(k).getType().equals("空调")){
										
										if(val.equals(10)){
											sbgl.get(k).setStatus("开");
										}else{
											sbgl.get(k).setStatus("关");	
										}
									}
									
									
									else if(sbgl.get(k).getType().equals("门磁1单元门")){
											sbgl.get(k).setStatus(val.toString());
									}else if(sbgl.get(k).getType().equals("门磁2常开门")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("关");
										}else{
											sbgl.get(k).setStatus("开");	
										}
									}else if(sbgl.get(k).getType().equals("智能垃圾箱")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("正");
										}else{
											sbgl.get(k).setStatus("倒");	
										}
									}else if(sbgl.get(k).getType().equals("弱电检测")){
										if(key.equals("elecValue")){
											res+=val.toString()+"(A)";
										} if(key.equals("voltage")){
											res+="/"+val.toString()+"(V)";
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("路灯检测")){
										if(key.equals("elecInt")){
											res+=val.toString();
										} if(key.equals("elecFloat")){
											res+="."+val.toString();
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("温湿度")){
										if(key.equals("temperatureValue")){
											res+=val.toString()+"(℃)";
										}
										if(key.equals("humidity")){
											res+="/"+val.toString()+"(%RH)";
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("水压力传感")){
										if(key.equals("pressureValue")){
											res+=val.toString()+"(Pa)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("液位传感")){
										if(key.equals("waterLevel")){
											if(val.equals(0))
											sbgl.get(k).setStatus("液位未达标");
											else
											sbgl.get(k).setStatus("液位达标");
										}
									}
									else if(sbgl.get(k).getType().equals("水表")){
										if(key.equals("waterFlow")){
											res+=val.toString()+"(%RH)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("电流监控")){
										if(key.equals("elecValue")){
											res+=val.toString()+"(A)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("地锁设备")){
										if(val.equals("00")){
											sbgl.get(k).setStatus("降锁");
										}else if(val.equals("01")){
											sbgl.get(k).setStatus("升锁");	
										}else if(val.equals("99")){
											sbgl.get(k).setStatus("故障");	
										}
									}
									else if(sbgl.get(k).getType().equals("地磁设备")){
										if(val.equals("EXISTS")){
											sbgl.get(k).setStatus("有车");
										}else if(val.equals("UNEXIST")){
											sbgl.get(k).setStatus("无车");	
										}
										else if(val.equals("FAULT")){
											sbgl.get(k).setStatus("故障");	
										}
									}
									else if(sbgl.get(k).getType().equals("电参数综合测量")){
										if(key.equals("UA")){
											res+=val.toString()+"(V)";
										}
										if(key.equals("UB")){
											res+="/"+val.toString()+"(V)";
										}if(key.equals("UC")){
											res+="/"+val.toString()+"(V)";
										}
										if(key.equals("IA")){
											res+=val.toString()+"(A)";
										}
										if(key.equals("IB")){
											res+="/"+val.toString()+"(A)";
										}if(key.equals("IC")){
											res+="/"+val.toString()+"(A)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("电梯设备")){
										if(key.equals("floor")){
											res+=val.toString()+"(F)";
										}
										if(key.equals("direction")){
											if(val.equals("00")){
												res+="/"+"等客";
											}
											if(val.equals("01")){
												res+="/"+"上行";
											}
											if(val.equals("02")){
												res+="/"+"下行";
											}
											sbgl.get(k).setStatus(res);
										}if(key.equals("model")){
											if(val.equals("0000")){
												res+="/"+"正常运行";
											}
											if(val.equals("0001")){
												res+="/"+"锁梯";
											}
											if(val.equals("0002")){
												res+="/"+"消防";
											}
											if(val.equals("0003")){
												res+="/"+"检修";
											}
											if(val.equals("004")){
												res+="/"+"司机";
											}
											if(val.equals("0005")){
												res+="/"+"超载";
											}
											if(val.equals("0006")){
												res+="/"+"VIP";
											}
											if(val.equals("0007")){
												res+="/"+"故障1";
											}
											if(val.equals("0008")){
												res+="/"+"故障2";
											}
										}
										if(key.equals("reverse")){
											if(val.equals("0000")){
												res+="/"+"正常";
											}
											if(val.equals("4003")){
												res+="/"+"冲顶";
											}
											if(val.equals("4004")){
												res+="/"+"蹲底";
											}
											if(val.equals("4005")){
												res+="/"+"开门走梯";
											}
											if(val.equals("4009")){
												res+="/"+"非平层区域停梯";
											}
										}
										
										sbgl.get(k).setStatus(res);
									}
									
						}
							
						}
						
						
							System.out.println("*********"+sbgl.get(k).getType());
							System.out.println("*********"+sbgl.get(k).getStatus());
					}
				}
				
				if(list.size()<1){
					data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),0));
				}else{
				data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
				}
				return data;
		 }
		 
		 
		 
		 
		 
		 
		 
		 @Override
		public DataGrid selectAllSb(PageParam param,HlkjSbgl  s){
				DataGrid data = new DataGrid();
				StringBuffer sb = new StringBuffer("from HlkjSbgl t  where 1=1 ");
				List list = new ArrayList();
				// 查询条件
				if (s.getAddressid() != null && !"".equals(s.getAddressid())) {
					sb.append(" and addressid = ?");
					list.add( s.getAddressid());
				}
				
				if (s.getSblm() != null && !"".equals(s.getSblm())) {
					sb.append(" and sblm = ? ");
					list.add(s.getSblm());
				}else{
					
					return data;
				}
				
				if(list.size()<1){
					data.setTotal(0l);
				}else{
				data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
				}
				sb.append("  ORDER BY t.updatetime desc ");
			//	sb.append(" order by fbsj desc");
				
				
				List<HlkjSbgl> sbgl = dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
				if(sbgl.size()>0){
					for(int k =0;k<sbgl.size();k++){
						
						JSONObject  jasonObject = JSONObject.fromObject(sbgl.get(k).getStatus());
						Map map = (Map)(JSONObject.toBean(jasonObject, Map.class));
						if(map!=null){
							Iterator<String> it = map.keySet().iterator();
							String res="";
							while(it.hasNext()){
									String key = it.next();
									Object val = map.get(key);
									System.out.println("key="+key+",value="+val);
									
									
									if(sbgl.get(k).getType().equals("门磁3长闭门")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("关");
										}else{
											sbgl.get(k).setStatus("开");	
										}
									}else if(sbgl.get(k).getType().equals("门磁1单元门")){
											sbgl.get(k).setStatus(val.toString());
									}else if(sbgl.get(k).getType().equals("门磁2常开门")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("关");
										}else{
											sbgl.get(k).setStatus("开");	
										}
									}else if(sbgl.get(k).getType().equals("智能垃圾箱")){
										if(val.equals(0)){
											sbgl.get(k).setStatus("正");
										}else{
											sbgl.get(k).setStatus("倒");	
										}
									}else if(sbgl.get(k).getType().equals("弱电检测")){
										if(key.equals("elecValue")){
											res+=val.toString()+"(A)";
										} if(key.equals("voltage")){
											res+="/"+val.toString()+"(V)";
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("路灯检测")){
										if(key.equals("elecInt")){
											res+=val.toString();
										} if(key.equals("elecFloat")){
											res+="."+val.toString();
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("温湿度")){
										if(key.equals("temperatureValue")){
											res+=val.toString()+"(℃)";
										}
										if(key.equals("humidity")){
											res+="/"+val.toString()+"(%RH)";
										}
										sbgl.get(k).setStatus(res);
									}else if(sbgl.get(k).getType().equals("水压力传感")){
										if(key.equals("pressureValue")){
											res+=val.toString()+"(Pa)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("液位传感")){
										if(key.equals("waterLevel")){
											if(val.equals(0))
											sbgl.get(k).setStatus("液位未达标");
											else
											sbgl.get(k).setStatus("液位达标");
										}
									}
									else if(sbgl.get(k).getType().equals("水表")){
										if(key.equals("waterFlow")){
											res+=val.toString()+"(%RH)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("电流监控")){
										if(key.equals("elecValue")){
											res+=val.toString()+"(A)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("地锁设备")){
										if(val.equals("00")){
											sbgl.get(k).setStatus("降锁");
										}else if(val.equals("01")){
											sbgl.get(k).setStatus("升锁");	
										}else if(val.equals("99")){
											sbgl.get(k).setStatus("故障");	
										}
									}
									else if(sbgl.get(k).getType().equals("地磁设备")){
										if(val.equals("EXISTS")){
											sbgl.get(k).setStatus("有车");
										}else if(val.equals("UNEXIST")){
											sbgl.get(k).setStatus("无车");	
										}
										else if(val.equals("FAULT")){
											sbgl.get(k).setStatus("故障");	
										}
									}
									else if(sbgl.get(k).getType().equals("电参数综合测量")){
										if(key.equals("UA")){
											res+=val.toString()+"(V)";
										}
										if(key.equals("UB")){
											res+="/"+val.toString()+"(V)";
										}if(key.equals("UC")){
											res+="/"+val.toString()+"(V)";
										}
										if(key.equals("IA")){
											res+=val.toString()+"(A)";
										}
										if(key.equals("IB")){
											res+="/"+val.toString()+"(A)";
										}if(key.equals("IC")){
											res+="/"+val.toString()+"(A)";
										}
										sbgl.get(k).setStatus(res);
									}
									else if(sbgl.get(k).getType().equals("电梯设备")){
										if(key.equals("floor")){
											res+=val.toString()+"(F)";
										}
										if(key.equals("direction")){
											if(val.equals("00")){
												res+="/"+"等客";
											}
											if(val.equals("01")){
												res+="/"+"上行";
											}
											if(val.equals("02")){
												res+="/"+"下行";
											}
											sbgl.get(k).setStatus(res);
										}if(key.equals("model")){
											if(val.equals("0000")){
												res+="/"+"正常运行";
											}
											if(val.equals("0001")){
												res+="/"+"锁梯";
											}
											if(val.equals("0002")){
												res+="/"+"消防";
											}
											if(val.equals("0003")){
												res+="/"+"检修";
											}
											if(val.equals("004")){
												res+="/"+"司机";
											}
											if(val.equals("0005")){
												res+="/"+"超载";
											}
											if(val.equals("0006")){
												res+="/"+"VIP";
											}
											if(val.equals("0007")){
												res+="/"+"故障1";
											}
											if(val.equals("0008")){
												res+="/"+"故障2";
											}
										}
										if(key.equals("reverse")){
											if(val.equals("0000")){
												res+="/"+"正常";
											}
											if(val.equals("4003")){
												res+="/"+"冲顶";
											}
											if(val.equals("4004")){
												res+="/"+"蹲底";
											}
											if(val.equals("4005")){
												res+="/"+"开门走梯";
											}
											if(val.equals("4009")){
												res+="/"+"非平层区域停梯";
											}
										}
										
										sbgl.get(k).setStatus(res);
									}
									
						}
							
						}
						
						
							System.out.println("*********"+sbgl.get(k).getType());
							System.out.println("*********"+sbgl.get(k).getStatus());
					}
				}
				
				if(list.size()<1){
					data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),0));
				}else{
				data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
				}
				return data;
		 }
		 
		 
		 
		 
		 @Override
		public DataGrid selectSbglSin(PageParam param, HlkjSbgl s) {
				DataGrid data = new DataGrid();
				StringBuffer sb = new StringBuffer("select distinct new Map(t.desc as desc,t.address as addressName,t.type as type) from HlkjSbgl t  where 1=1 ");
				List list = new ArrayList();
				// 查询条件
				if (s.getAddressid() != null && !"".equals(s.getAddressid())) {
					sb.append(" and addressid = ?");
					list.add( s.getAddressid());
				}if (s.getDesc() != null && !"".equals(s.getDesc())) {
					sb.append(" and desc = ?");
					list.add( s.getDesc());
				}if (s.getAddress() != null && !"".equals(s.getAddress())) {
					sb.append(" and address = ?");
					list.add( s.getAddress());
				}
				List sblist = dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
				
				System.out.println("***********="+sblist.size());
				//data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
				
				data.setTotal((long)sblist.size());
				
				data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
				return data;
		}


		@Override
		public SyUsers findUser(String username) {
			SyUsers uu = new SyUsers();
			if(username==null&&!"".equals(username)){
				uu=(SyUsers)dao.find(" from SyUsers ").get(0);
			}else{
				uu = (SyUsers)dao.findOne("from SyUsers where userName = ?",username);
			}
			// TODO Auto-generated method stub
			return uu;
		}


		@Override
		public boolean saveLoginLog(SyLoginLog sl) {
			// TODO Auto-generated method stub
			return dao.save(sl);
		}


		@Override
		public boolean updateUser(SyUsers us) {
			// TODO Auto-generated method stub
			return dao.update(us);
		}
		 

}
