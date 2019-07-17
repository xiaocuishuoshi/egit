package com.whfp.oa.manager.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whfp.oa.commons.base.BaseAction;

/**
 * app 接口
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app")
public class IndexAction extends BaseAction{
	
	/**
	 * 接口中心
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "app/index";
	}
	
	
}
