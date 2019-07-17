package com.whfp.oa.manager.app.action;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jiedu.bean.JdActTalk;
import com.whfp.oa.manager.jiedu.service.JdActService;

@Controller
@RequestMapping("/app/talk")
public class TalkApiController  extends BaseAction{
	@Autowired
	private JdActService jdActService;
	/*@PostMapping("/create")
	public  @ResponseBody  JsonBody<String> create(TalkCreateInputModel model){
		
		return new JsonBody<>(1,"操作成功");
	}
	
	@GetMapping("/my")
	public @ResponseBody JsonBody<List<JdActTalk>> my(@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize){
	
		List<JdActTalk> list=new ArrayList<>();
		
		return new JsonBody<>(1,"查询成功",list);
	}*/
	
	@GetMapping("/my")
	public @ResponseBody ModelAndView my(@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize,PageParam param,@RequestParam(value="talkUid",required=true,defaultValue="")String talkUid ){		
		JdActTalk jdActTalk=new JdActTalk();
		jdActTalk.setTalkUid("4028810869902033016995c626f00260");
		//jdActTalk.setTalkUid(talkUid);
		
		//jdActVisit.setVisitorUid(member.getId());
		//jdActVisit.setVisitorUid(member.getId());
		
		
		
		//PageParam param=new PageParam();
		/*param.setPage(pageIndex);
		param.setRows(pageSize);*/
		
		
		return ajaxJsonEscape(jdActService.selectTalkList(param, jdActTalk));
		//return new JsonBody<>(1,"查询成功",list);
	}
	
	
	/***
	 * 添加、修改
	 * @return
	 */
	@GetMapping("/create")
	public  @ResponseBody ModelAndView  submit(@Valid JdActTalk m, Errors errors,@RequestParam(value="createUid",required=true,defaultValue="")String createUid){			
			Member member=ServletUtil.getMember();
			
			if(m.getId()==null||m.getId()==0){
				//add 
				m.setCreateDate(new Date());
				m.setCreateUid(createUid);
				//m.setCreateUid(member.getId());

				jdActService.saveTalk(m);
				
			}else {
				//upate
				JdActTalk one= jdActService.findTalkById(m.getId());
				
				if(one!=null) {
					
					BeanUtils.copyProperties(m,one, "createUid", "createDate");
					
					jdActService.saveTalk(one);
				}
			}
			
			
			return ajaxDone(true?MsgConfig.MSG_KEY_SUCCESS:MsgConfig.MSG_KEY_FAIL);
	
	}
}
