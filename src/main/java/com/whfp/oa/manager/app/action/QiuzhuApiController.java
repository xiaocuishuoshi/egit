package com.whfp.oa.manager.app.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.manager.app.action.model.QiuzhuInputModel;
import com.whfp.oa.manager.app.action.model.QiuzhuOutputModel;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.app.bean.PageBody;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jd.service.IShqzService;
import com.whfp.oa.manager.system.bean.SyUsers;

/**
 * 生活求助
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app/qiuzhu")
public class QiuzhuApiController {

	static DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Autowired
	private IShqzService shqzService;
	
	@PostMapping("/create")
	public  @ResponseBody  JsonBody<String> create(QiuzhuInputModel model){

		if(StringUtils.isEmpty(model.getUid())) {
			
			return new JsonBody<>(-1,"uid不能为空");
		}
		if(StringUtils.isEmpty(model.getContent())) {
			
			return new JsonBody<>(-1,"求助内容不能为空");
		}
		
		SyUsers u = shqzService.get(SyUsers.class,model.getUid());
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}
		
		JdShqz one=new JdShqz();
		
		one.setHfbz("");//标题
		one.setQznr(model.getContent());
		one.setQzryid(model.getUid());//求助人id
		one.setQzryxm(u.getTrueName());
		one.setQzsj(new Date());
		one.setYdzt("0");
		shqzService.save(one);
		
		return new JsonBody<>(1,"操作成功");
	}
	
	@GetMapping("/my")
	public  @ResponseBody  PageBody<QiuzhuOutputModel> my(
			@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid){
		
		List<QiuzhuOutputModel> data=new ArrayList<>();
		
		if(StringUtils.isEmpty(uid)) {
			
			return new PageBody<>(-1,"uid不能为空",null);
		}

		List<JdShqz> list= shqzService.selectList("from JdShqz u where 1=1");
		for(JdShqz m:list) {
		
			QiuzhuOutputModel one=new QiuzhuOutputModel();
			
			one.setId(m.getId());
			one.setCategory(m.getQzbt());
			one.setContent(m.getQznr());
			one.setResp(m.getHfnr());
			one.setRespDate(m.getHfsj());
			one.setRespUid("");
			one.setRespUserName(m.getHfrxm());
			one.setUid(uid);
		
			data.add(one);
		}
		
		return new PageBody<>(1,"操作成功",data);
	}
	
	@PostMapping("/resp")
	public  @ResponseBody  JsonBody<String> resp(String uid,String id,String content){
		
		if(StringUtils.isEmpty(id)) {
			
			return new JsonBody<>(-1,"id不能为空");
		}

		if(StringUtils.isEmpty(uid)) {
			
			return new JsonBody<>(-1,"uid不能为空");
		}
		if(StringUtils.isEmpty(content)) {
			
			return new JsonBody<>(-1,"求助内容不能为空");
		}
		
		JdShqz one=shqzService.get(JdShqz.class, id);
		if (one == null) {
			
			return new JsonBody<>(-1,"记录不存在");
		}

		SyUsers u = shqzService.get(SyUsers.class,uid);
		if (u == null) {
			
			return new JsonBody<>(-1,"用户名不存在");
		}

		one.setHfbz(content);
		one.setHfsj(format1.format(new Date()));
		one.setHfbz("1");
		one.setHfrxm(u.getTrueName());
		
		shqzService.update(one);
		
		return new JsonBody<>(1,"操作成功");
	}
}
