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
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManWork;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Controller
@RequestMapping("/jiedu/man/work")
public class ManWorkAction  extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ManWorkAction.class);
	
	@Autowired
	private JdManService jdManService;
	
	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@GetMapping("edit")
	public  String  edit(Model model,Long id,String userId){
		
		JdManWork one=new JdManWork();
		if(id==null||id>0) {
			
			one = jdManService.get(JdManWork.class,id);
		}
		
		model.addAttribute("one", one);
		model.addAttribute("userId", userId);
		
		return "jiedu/man/work-edit";
	}
	
	@RequestMapping("query")
	public ModelAndView query(PageParam param, JdManWork one) {
	
		return ajaxJsonEscape(jdManService.selectWorkList(param, one));
	}
	
	/***
	 * 添加、修改
	 * @return
	 */
	@PostMapping("submit")
	public  ModelAndView  submit(@Valid JdManWork m, Errors errors){
		
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

				isOk=jdManService.saveWork(m);
				
				man.setWorkNum(man.getWorkNum()==null?1:man.getWorkNum()+1);
				jdManService.update(man);
				
			}else {
				//upate
				JdManWork one= jdManService.findWorkById(m.getId());
				
				if(one!=null) {
					
					BeanUtils.copyProperties(m,one, "createUid", "createDate");
					
					isOk=jdManService.saveWork(one);
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
		
		return ajaxDone(jdManService.deleteWork(ids));
	}
	
}
