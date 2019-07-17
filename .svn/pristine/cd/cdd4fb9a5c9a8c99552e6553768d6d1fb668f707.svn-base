package com.whfp.oa.manager.app.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.manager.app.action.model.NiaojianCheckInputModel;
import com.whfp.oa.manager.app.action.model.NiaojianInputModel;
import com.whfp.oa.manager.app.action.model.NiaojianOutputModel;
import com.whfp.oa.manager.app.action.model.QiuzhuOutputModel;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.app.bean.PageBody;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jd.service.JdKfjcService;
import com.whfp.oa.manager.system.bean.SyUsers;

/**
 * 尿检
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app/niaojian")
public class NiaojianApiController {

	static DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JdKfjcService service;
	
	
	@PostMapping("/create")
	public  @ResponseBody  JsonBody<String> create(NiaojianInputModel model){
		
		if(StringUtils.isEmpty(model.getUid())) {
			
			return new JsonBody<>(-1,"参数错误,uid不能为空");
		}

		SyUsers u = service.get(SyUsers.class,model.getUid());
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}
		
		JdKfjc one =new JdKfjc();
		
		one.setBmid(u.getDeptId());//部门ID
		one.setDh(u.getMobilePhoneNumber());
		one.setFzr("");//负责人
		one.setJcsj(format1.format(new Date()));//检查时间
		one.setJcsm(model.getRemarks());//检查谈话说明
		one.setName(u.getTrueName());
		one.setSfzc(model.getResult());//是否正常,阴性，阳性
		one.setRyid(model.getUid());
		
		service.saveOrUpdate(one);
		return new JsonBody<>(1,"操作成功");
	}
	
	@GetMapping("/my")
	public  @ResponseBody  PageBody<NiaojianOutputModel> my(
			@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid){
		
		List<NiaojianOutputModel> data=new ArrayList<>();
		
		if(StringUtils.isEmpty(uid)) {
			
			return new PageBody<>(-1,"uid不能为空",null);
		}

		List<JdKfjc> list= service.selectList("from JdKfjc u where 1=1");
		for(JdKfjc m:list) {
		
			NiaojianOutputModel one=new NiaojianOutputModel();
			
			one.setAddress("");
			
			one.setCreateDate(m.getJcsj());
			one.setFileIds("");
			
			one.setId(m.getId());
			
			one.setIsLocal(1);
			one.setName(m.getName());
			one.setRemarks(m.getJcsm());
			one.setResult(m.getSfzc());
			
			one.setAvatar("");
			one.setUid(m.getRyid());
			one.setSex("");
			
			data.add(one);
		}
		
		return new PageBody<>(1,"操作成功",data);
		
	}
	
	@PostMapping("/check")
	public  @ResponseBody  JsonBody<String> check(NiaojianCheckInputModel model){
		
		if(StringUtils.isEmpty(model.getUid())) {
			
			return new JsonBody<>(-1,"参数错误,uid不能为空");
		}
		if(model.getFlag()==null) {
			
			return new JsonBody<>(-1,"参数错误,检查结果不能为空");
		}

		SyUsers u = service.get(SyUsers.class,model.getUid());
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}
		
		return new JsonBody<>(1,"操作成功");
	}
}
