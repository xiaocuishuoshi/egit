package com.whfp.oa.manager.jiedu.action;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jiedu.bean.JdActTalk;
import com.whfp.oa.manager.jiedu.bean.JdActVisit;
import com.whfp.oa.manager.jiedu.service.JdActService;

@Controller
@RequestMapping("/jiedu/act/visit")
public class ActVisitAction   extends BaseAction{

	private static Logger logger = LoggerFactory.getLogger(ActVisitAction.class);
	
	@Autowired
	private JdActService jdActService;
	
	@RequestMapping("list")
	public String list(String uid){
		return "jiedu/act/visit-list";
	}
	
	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@GetMapping("edit")
	public  String  edit(Model model,Long id,String userId){
		
		JdActVisit one=new JdActVisit();
		if(id==null||id>0) {
			
			one = jdActService.get(JdActVisit.class,id);
		}
		
		model.addAttribute("one", one);
		model.addAttribute("userId", userId);
		
		return "jiedu/act/visit-edit";
	}
	
	@RequestMapping("query")
	public ModelAndView query(PageParam param, JdActVisit one) {
	
		return ajaxJsonEscape(jdActService.selectVisitList(param, one));
	}
	
	/***
	 * 添加、修改
	 * @return
	 */
	@PostMapping("submit")
	public  ModelAndView  submit(@Valid JdActVisit m, Errors errors){
		
		boolean isOk=false;
		try {
			
			if (errors.hasErrors()) {
				ModelAndView mav = getValidationMessage(errors);
				if (mav != null) {
					return mav;
				}
			}
			Member member=ServletUtil.getMember();
			
			if(m.getId()==null||m.getId()==0){
				//add 
				m.setCreateDate(new Date());
				m.setCreateUid(member.getId());

				isOk=jdActService.saveVisit(m);
				
			}else {
				//upate
				JdActVisit one= jdActService.findVisitById(m.getId());
				
				if(one!=null) {
					
					BeanUtils.copyProperties(m,one, "createUid", "createDate");
					
					isOk=jdActService.saveVisit(one);
				}else {
					isOk=false;
				}
			}
			
		}catch(Exception ex) {
		
			logger.error("操作出错", ex);
			return ajaxDone(MsgConfig.MSG_KEY_FAIL);
		}

		return ajaxDone(isOk?MsgConfig.MSG_KEY_SUCCESS:MsgConfig.MSG_KEY_FAIL);
	}
	
	@RequestMapping("delete")
	public  ModelAndView  delete(Long[] ids){
		
		return ajaxDone(jdActService.deleteVisit(ids));
	}
	
	
}
