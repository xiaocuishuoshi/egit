package com.whfp.oa.manager.jiedu.action;

import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManRelationShip;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Controller
@RequestMapping("/jiedu/man/relationship")
public class ManRelationshipAction  extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ManRelationshipAction.class);
	
	@Autowired
	private JdManService jdManService;
	
	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@GetMapping("edit")
	public  String  edit(Model model,Long id,String userId){
		
		JdManRelationShip one=new JdManRelationShip();
		if(id==null||id>0) {
			
			one = jdManService.get(JdManRelationShip.class,id);
		}
		
		model.addAttribute("one", one);
		model.addAttribute("userId", userId);
		
		return "jiedu/man/relationship-edit";
	}
	
	@RequestMapping("query")
	public ModelAndView query(PageParam param, JdManRelationShip one) {
	
		return ajaxJsonEscape(jdManService.selectRelationshipList(param, one));
	}
	
	/***
	 * 添加、修改
	 * @return
	 */
	@PostMapping("submit")
	public  ModelAndView  submit(@Valid JdManRelationShip m, Errors errors){
		
		boolean isOk=false;
		try {
			
			JdRyb man=jdManService.get(JdRyb.class, m.getUserId());
			
			if(man==null) {
				
				return ajaxDoneTextError("参数错误，戒毒人员不存在");
			}
			
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

				isOk=jdManService.saveRelationship(m);
				
				man.setRelationshipNum(man.getRelationshipNum()==null?1:man.getRelationshipNum()+1);
				jdManService.update(man);
			}else {
				//upate
				JdManRelationShip one= jdManService.findRelationshipById(m.getId());
				
				if(one!=null) {
					
					BeanUtils.copyProperties(m,one, "createUid", "createDate");
					
					isOk=jdManService.saveRelationship(one);
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
		
		return ajaxDone(jdManService.deleteRelationship(ids));
	}
	
}
