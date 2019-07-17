package com.whfp.oa.manager.hlkj.system.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.files.bean.ImageSpaceImg;
import com.whfp.oa.manager.hlkj.system.bean.HlkjAddress;
import com.whfp.oa.manager.hlkj.system.bean.HlkjTpt;
import com.whfp.oa.manager.hlkj.system.service.IHlkjAddress;

@Service("HlkjAddress")
public class HlkjAddressImpl extends BaseServiceImpl implements IHlkjAddress {

	@Override
	public String addAddress(HlkjAddress s) {
//		Object obj =dao.findOne(" from HlkjAddress q where q.id=?", s.getId());
//		if(obj==null){
			if (dao.save(s)) {
				return "msg.save.success";
			} else {
				return "msg.operation.failure";
			}
//		}else{
//			return "msg.Public.unique";//数据库已有值
//		}
	}

	@Override
	public boolean deleteAddress(String[] ids) {
		for (String id : ids) {
			HlkjAddress p = dao.get(HlkjAddress.class, id);
			dao.delete(p);
		}
		return true;
	}

	@Override
	public DataGrid selectAddress(PageParam param, HlkjAddress s) {
		DataGrid data = new DataGrid();
		StringBuffer sb = new StringBuffer("from HlkjAddress  where 1=1 ");
		List list = new ArrayList();
		// 查询条件
		if (s.getAddressName() != null && !"".equals(s.getAddressName())) {
			sb.append(" and address_name like ? ");
			list.add("%" + s.getAddressName() + "%");
		}if(s.getFather()!=null && !"".equals(s.getFather())){
			sb.append(" and father = ?");
			list.add(s.getFather());
		}
		data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
	//	sb.append(" order by fbsj desc");
		data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
		return data;
	}

	@Override
	public HlkjAddress selectById(String id) {
		if(id==null || "".equals(id)){
			List<HlkjAddress> list = dao.find(" from HlkjAddress  where 1=1  ");
			return list.get(0);
		}
		return dao.get(HlkjAddress.class, id);
	}

	@Override
	public String updateAddress(HlkjAddress s) {
		if (dao.update(s)) {
			return "msg.update.success";
		} else {
			return "msg.operation.failure";
		}
	}
		@Override
		public List selectAdd() {
			return dao.find("select  distinct new Map(t.id as id,t.addressName as name,t.father as superId)from HlkjAddress t");
		}
		
		
		@Override
		public String updateAddress(String addressSb,String addressid) {
			String hql = "update HlkjAddress t set t.addressSb=? where t.id=?";
			if(dao.update(hql,addressSb,addressid)){
				return "msg.update.success";
			}else {
				return "msg.operation.failure";
			}
			
		}
		
		
		@Override
		public String updateSBgl(String address,String addressid,String desc) {
			String hql = " update HlkjSbgl h set h.address=?,h.addressid=? where h.desc=?";
			if(dao.update(hql,address,addressid,desc)){
				return "msg.update.success";
			}else {
				return "msg.operation.failure";
			}
		}
		
		
		/**
		 * 读取出图片
		 */
		@Override
		public List<ImageSpaceImg> selectImg(){
			StringBuffer hql=new StringBuffer("from ImageSpaceImg m where 1=1 ");
			List<Object> list=new ArrayList<Object>();
			hql.append(" order by createTime desc ");
			return dao.find(hql.toString());
		}

		@Override
		public String addTpt(HlkjTpt s) {
			Object obj =dao.findOne(" from HlkjTpt q where q.tpXnh=?", s.getTpXnh());
			if(obj==null){
				Object objq =dao.findOne(" from HlkjTpt q where  q.tpAddressId=?", s.getTpAddressId());
				if(objq==null){
					if (dao.save(s)) {
						return "msg.save.success";
					} else {
						return "msg.operation.failure";
					}	
				}else{
					return "msg.tpt.address";//改地址已绑定拓扑图
				}
				
			}else{
				return "msg.tpt.xnh";//虚拟号已存在
			}
		}

		@Override
		public boolean deleteTpt(String[] ids) {
			for (String id : ids) {
				HlkjTpt p = dao.get(HlkjTpt.class, id);
				dao.delete(p);
			}
			return true;
		}

		@Override
		public DataGrid selectTpt(PageParam param, HlkjTpt s) {
			DataGrid data = new DataGrid();
			StringBuffer sb = new StringBuffer("from HlkjTpt  where 1=1 ");
			List list = new ArrayList();
			// 查询条件
			if (s.getTpName() != null && !"".equals(s.getTpName())) {
				sb.append(" and tp_name like ? ");
				list.add("%" + s.getTpName() + "%");
			}
			if(s.getTpXnh()!=null && !"".equals(s.getTpXnh())){
				sb.append(" and tp_xnh like ? ");
				list.add("%"+s.getTpXnh()+"%");
			}
			data.setTotal((Long)dao.findUniqueOne("select count(*)"+sb,list));
			data.setRows(dao.findPage(sb.toString(),param.getPage(),param.getRows(),list));
			return data;
		}

		@Override
		public HlkjTpt selectTptById(String id) {
			if(id==null || "".equals(id)){
				List<HlkjTpt> list = dao.find(" from HlkjTpt  where 1=1  ");
				return list.get(0);
			}
			return dao.get(HlkjTpt.class, id);
		}
		
		@Override
		public HlkjTpt selectTptByAdd(String addressid) {
			if(addressid==null || "".equals(addressid)){
				List<HlkjTpt> list = dao.find(" from HlkjTpt  where 1=1  ");
				if(list.size()<1){
					return new HlkjTpt();
				}else{
					return list.get(0);
				}
			}
			List<HlkjTpt> list = dao.find("from HlkjTpt t where t.tpAddressId=?",addressid);
			if(list.size()<1){
				return new HlkjTpt();
			}else{
			return (HlkjTpt)dao.find("from HlkjTpt t where t.tpAddressId=?",addressid).get(0);
			}
		}
		

		@Override
		public String updateTpt(HlkjTpt s) {
			if (dao.update(s)) {
				return "msg.update.success";
			} else {
				return "msg.operation.failure";
			}
		}
	
		
		@Override
		public ImageSpaceImg selectImgById(String id) {
			if(id==null || "".equals(id)){
				List<ImageSpaceImg> list = dao.find(" from ImageSpaceImg  where 1=1  ");
				return list.get(0);
			}
			return dao.get(ImageSpaceImg.class, id);
		}
}
