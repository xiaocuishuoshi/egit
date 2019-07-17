package com.whfp.oa.manager.app.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.app.action.model.QingjiaInputModel;
import com.whfp.oa.manager.app.action.model.QingjiaOutputModel;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.app.bean.PageBody;
import com.whfp.oa.manager.jd.bean.JdQj;
import com.whfp.oa.manager.jd.service.IQjglService;
import com.whfp.oa.manager.system.bean.SyUsers;


/***
 * 请假
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app/qingjia")
public class QingjiaApiController {

	@Autowired
	private IQjglService qjglService;
	
	@PostMapping("/create")
	public  @ResponseBody  JsonBody<String> create(QingjiaInputModel model){
		
		if(StringUtils.isEmpty(model.getBeginDate())) {
			
			return new JsonBody<>(-1,"开始时间不能为空");
		}
		if(StringUtils.isEmpty(model.getEndDate())) {
			
			return new JsonBody<>(-1,"结束时间不能为空");
		}
		if(StringUtils.isEmpty(model.getContent())) {
			
			return new JsonBody<>(-1,"请假内容不能为空");
		}

		if(StringUtils.isEmpty(model.getUid())) {
			
			return new JsonBody<>(-1,"请假人不能为空");
		}
		if(StringUtils.isEmpty(model.getmType())) {
			
			return new JsonBody<>(-1,"请假类别不能为空");
		}

		SyUsers u = qjglService.get(SyUsers.class,model.getUid());
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}
		
		JdQj one= new JdQj();
		
		one.setCgbz("0");//草稿标志
		one.setGxbmid(u.getDeptId());//管辖部门
		one.setQjjssj(model.getEndDate());
		one.setQjkssj(model.getBeginDate());
		one.setQjlb(model.getmType());
		one.setQjnr(model.getContent());
		one.setQjryid(model.getUid());
		one.setQjryxm(u.getTrueName());//请假人员姓名
		one.setQjsj(new Date());
		one.setSpzt("0");
		one.setXjsj("");//销假时间
		
		qjglService.saveOrUpdate(one);
		
		return new JsonBody<>(1,"操作成功");
	}
	
	/**
	 * 取消
	 * @param id
	 * @return
	 */
	@PostMapping("/cancel")
	public  @ResponseBody  JsonBody<String> cancel(String uid,String id){
		
		if(StringUtils.isEmpty(uid)) {
			
			return new JsonBody<>(-1,"参数错误,uid不能为空");
		}
		if(StringUtils.isEmpty(id)) {
			
			return new JsonBody<>(-1,"参数错误,id不能为空");
		}

		JdQj u = qjglService.get(JdQj.class,id);
		if (u == null) {
			
			return new JsonBody<>(-1,"记录不存在");
		}
		if(!u.getQjryid().equals(uid)) {
			
			return new JsonBody<>(-1,"只有本人才能取消");
		}
		//不改标记
		u.setCgbz("-1");
		
		//直接删除
		qjglService.delete(u);
		
		return new JsonBody<>(1,"操作成功");
	}
	
	@GetMapping("/my")
	public @ResponseBody PageBody<QingjiaOutputModel> my(
			@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid,Integer status){
	
		List<QingjiaOutputModel> list=new ArrayList<>();
		
		//
		DataGrid dg= qjglService.selectQj(pageIndex,pageSize, new String[] { });
		
		List rows=dg.getRows();
		
		if(rows.size()>0) {
			
			
			for(int i=0;i<rows.size();i++) {
			
				JdQj cols=(JdQj)rows.get(i);
						
				QingjiaOutputModel one=new QingjiaOutputModel();
				
				one.setId(cols.getId());
				one.setBeginDate(cols.getQjkssj());
				one.setEndDate(cols.getQjjssj());
				
				one.setContent(cols.getQjnr());
				one.setCreateDate("");//
				
				one.setIsFinish(0);
				one.setmType(cols.getQjlb());
				one.setResp("");
				one.setStatus(cols.getSpzt());//
				one.setUid(cols.getQjryid());
				
				list.add(one);
			}
		}
		
		return new PageBody<>(1,"查询成功",list);
	}
	
	/**
	 * 审批
	 * @param id
	 * @param uid
	 * @return
	 */
	@PostMapping("/audit")
	public  @ResponseBody  JsonBody<String> audit(String id,String uid,String flag,String content){
		
		if(StringUtils.isEmpty(uid)) {
			
			return new JsonBody<>(-1,"参数错误,uid不能为空");
		}
		if(StringUtils.isEmpty(id)) {
			
			return new JsonBody<>(-1,"参数错误,id不能为空");
		}
		
		if(flag.equals("2")&&StringUtils.isEmpty(content)) {
			
			return new JsonBody<>(-1,"请假不通过要填写原因");
		}

		JdQj u = qjglService.get(JdQj.class,id);
		if (u == null) {
			
			return new JsonBody<>(-1,"记录不存在");
		}

		//todo 检查是否有审批权限
		
		//不改标记
		u.setSpzt(flag);
		if(!StringUtils.isEmpty(content)) {
			
			u.setQjnr(u.getQjnr()==null?"":u.getQjnr()+" 审批回复:"+content);			
		}
		qjglService.update(u);
		
		return new JsonBody<>(1,"操作成功");
	}
}
