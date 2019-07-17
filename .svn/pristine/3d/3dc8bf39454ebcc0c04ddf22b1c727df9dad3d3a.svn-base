package com.whfp.oa.manager.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.manager.app.action.model.ManInfoOutputModel;
import com.whfp.oa.manager.app.action.model.MessageOutputModel;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.app.bean.PageBody;

/**
 * 消息
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app/message")
public class MessageApiController   extends JsonBaseController{

	/**
	 * 我的消息（列ge）
	 * @param pageIndex
	 * @param pageSize
	 * @param uid:用户id
	 * @param status:状态,0:未读,1:已读，为空表示全部
	 * @return
	 */
	@GetMapping("/my")
	public @ResponseBody PageBody<MessageOutputModel> my(
			@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid,Integer status){
		
		
		return null;
	}
	
	/**
	 * 已读操作（可多条）
	 * @param uid
	 * @param ids
	 * @return
	 */
	@GetMapping("/read")
	public @ResponseBody JsonBody<String> read(String uid,String ids){
		
		
		return new JsonBody<>(1,"操作成功");
	}
}
