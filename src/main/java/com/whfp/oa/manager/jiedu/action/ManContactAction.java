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
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.MsgConfig;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManContact;
import com.whfp.oa.manager.jiedu.bean.JdManWork;
import com.whfp.oa.manager.jiedu.service.JdManService;

@Controller
@RequestMapping("/jiedu/man/contact")
public class ManContactAction  extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ManContactAction.class);
	
	@Autowired
	private JdManService jdManService;
	
	/***
	 * 添加、修改
	 * @return
	 */
	@PostMapping("submit")
	public  ModelAndView  submit(String userId,Long[] id, String[] postion, String[] name,String[] company,String[] phone,String[] duty ){
		
		try {
			
			JdManContact m=new JdManContact();
			
			Member member=ServletUtil.getMember();
			
			JdRyb man=jdManService.get(JdRyb.class, userId);
			
			if(man==null) {
				
				return ajaxDoneTextError("参数错误，戒毒人员不存在");
			}
			
			for(int i=0;i < postion.length;i++) {
				
				if(StringUtils.isEmpty(postion[i])) continue;
				
				if(id[i]==null) {
					//add
					m=new JdManContact();
					m.setCompany(company[i]);
					m.setCreateDate(new Date());
					m.setCreateUid(member.getId());
					m.setDuty(duty[i]);
					m.setName(name[i]);
					m.setPhone(phone[i]);
					m.setPostion(postion[i]);
					m.setUserId(userId);
					
					jdManService.saveContact(m);
					
				}else {
					//update
					JdManContact one=jdManService.findContactById(id[i]);
					if(one!=null) {
						
						one.setCompany(company[i]);
						one.setDuty(duty[i]);
						one.setName(name[i]);
						one.setPhone(phone[i]);
						one.setPostion(postion[i]);
						
						jdManService.saveContact(one);
					}
					
				}
			}
			
			man.setConcactNum(postion.length);
			jdManService.update(man);
		}catch(Exception ex) {
		
			logger.error("操作出错", ex);
			return ajaxDone(MsgConfig.MSG_KEY_FAIL);
		}

		return ajaxDone(MsgConfig.MSG_KEY_SUCCESS);
	}
	
	
	@RequestMapping("delete")
	public  ModelAndView  delete(Long[] ids){
		
		return ajaxDone(jdManService.deleteWork(ids));
	}
	
}
