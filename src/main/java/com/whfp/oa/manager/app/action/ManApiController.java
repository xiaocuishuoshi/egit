package com.whfp.oa.manager.app.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.framework.core.dao.base.INormalBaseDao;
import com.whfp.framework.core.event.EventBusAdapter;
import com.whfp.framework.core.event.entity.NotifyEventEntity;
import com.whfp.oa.manager.app.action.model.ManInfoOutputModel;
import com.whfp.oa.manager.app.bean.JsonBody;
import com.whfp.oa.manager.app.bean.PageBody;
import com.whfp.oa.manager.app.service.AppUnifiedService;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jiedu.bean.JdManActLog;
import com.whfp.oa.manager.system.bean.SyUsers;

/**
 * 戒毒人员信息
 * @author wenhu
 *
 */
@Controller
@RequestMapping("/app/man")
public class ManApiController  extends JsonBaseController{

    @Resource(name = "normalBaseDaoImpl")
    private INormalBaseDao baseDao;

    @Autowired
    private AppUnifiedService appUnifiedService;
    
    @Autowired
    private EventBusAdapter eventBusAdapter;
	/**
	 * 我的戒毒人员信息（列表）（社区人员，民警）
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/my")
	public @ResponseBody PageBody<ManInfoOutputModel> my(
			@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid){
		
		List<ManInfoOutputModel> list=new ArrayList<>();
		
		ManInfoOutputModel one=new ManInfoOutputModel();
		one.setAvatar("");
		one.setJoinDate("2019-05-14");
		one.setLastGpsAddress("武汉市xxxx区");
		one.setLastUpdateDate("2019-05-14 12:12");
		one.setLeftDay(200);
		one.setLevel("三级");
		one.setLostConnectTimes(2);
		one.setManId("402881946a9bd395016a9bd88f1d0001");
		one.setName("张三");
		one.setNiaojianOkTimes(20);
		one.setNiaojianFailTimes(0);
		one.setQingjiaTimes(2);
		one.setSex("男");
		one.setStatus(0);
		one.setIsFinish(0);
		one.setUpdateTimes(200);
		
		list.add(one);
		return new PageBody<ManInfoOutputModel>(1,"查询成功",list);
	}
	
	/**
	 * 获取单个戒毒人员信息（全部）
	 * @param uid
	 * @return
	 */
	@GetMapping("/get")
	public @ResponseBody JsonBody<ManInfoOutputModel> get(String uid){
		
		ManInfoOutputModel one=new ManInfoOutputModel();
		
		return new JsonBody<>(1,"查询成功",one);
	}
	
	/**
	 * 获取单个戒毒人员信息（时间轴）
	 * @param uid
	 * @return
	 */
	@GetMapping("/getlog")
	public @ResponseBody PageBody<JdManActLog> getlog(@RequestParam(value="pageIndex",required=false,defaultValue="0")  int pageIndex
			,@RequestParam(value="pageSize",required=false,defaultValue="20")  int pageSize
			,String uid){
		
		//List<ManLogOutputModel> data=new ArrayList<ManLogOutputModel>();
		
		//ManLogOutputModel one=new ManLogOutputModel();
		//one.setManId("402881946a9bd395016a9bd88f1d0001");
		//one.setGroupDate("2019-05-15");
		
		List<JdManActLog> list=new ArrayList<>();
		
		JdManActLog oneLog=new JdManActLog();
		oneLog.setId(1L);
		oneLog.setContent("上传尿检报告，结果正常");
		oneLog.setLogType("尿检");
		oneLog.setRefId("11");
		oneLog.setCreateDate("2019-05-15 12:23:30");
		
		JdManActLog oneLog2=new JdManActLog();
		oneLog2.setId(2L);
		oneLog2.setContent("汇报内容内容内容内容内容内容内容内容内容内容内容内容");
		oneLog2.setLogType("思想汇报");
		oneLog2.setCreateDate("2019-05-15 15:23:30");
		oneLog2.setRefId("12");
		
		list.add(oneLog);
		list.add(oneLog2);
		//one.setList(list);
		//data.add(one);
		return new PageBody<JdManActLog>(1,"查询成功",list);
	}
	
	@GetMapping("/test")
	public  @ResponseBody List test() {
		
		List list= baseDao.queryByHQL(" from SyUsers");
		
		JdRyb mm= appUnifiedService.findById("4028810869902033016995c626e0025d");
		
		eventBusAdapter.post(new NotifyEventEntity());
		return list;
		
	}
}
