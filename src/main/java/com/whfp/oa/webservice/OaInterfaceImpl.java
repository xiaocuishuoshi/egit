package com.whfp.oa.webservice;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.base.IBaseDao;
import com.whfp.oa.commons.cache.MyCache;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.model.IpInfo;
import com.whfp.oa.commons.model.LoginInfo;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.OnLineUser;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.IpUtil;
import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.commons.util.StringUtil;
import com.whfp.oa.manager.common_platform.bean.Meeting;
import com.whfp.oa.manager.common_platform.bean.Newsmanagement;
import com.whfp.oa.manager.common_platform.bean.RgRulesregulations;
import com.whfp.oa.manager.common_platform.bean.RmRulesmanager;
import com.whfp.oa.manager.common_platform.bean.XtAffiche;
import com.whfp.oa.manager.personalOffice.bean.PerSchedule;
import com.whfp.oa.manager.system.bean.ListValues;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;

@Controller
@RequestMapping("/interface")
@WebService(endpointInterface="com.whfp.oa.webservice.IOaInterface")
public class OaInterfaceImpl extends BaseAction implements IOaInterface {
    public static Map tradCode=new HashMap();
 
    
	@Autowired
	protected IBaseDao dao;
	 
	@Override
	public User login(String username, String password) {
		System.out.println(username + "is logining");
		User user = new User();
		user.setId("1");
		user.setUsername(username);
		user.setPassword(password); 
		return user;
	}
	@RequestMapping("userLogin")
	public String userLogin(ModelMap map,HttpServletResponse response){ 
		 
		try {
			String msg="";
			String code="0";
			Timestamp loginTime=DateUtil.currentTimestamp();
			String loginIp=IpUtil.getIpAddr(ServletUtil.getRequest());
			String tradeCode="";//返回给用户用于接口访问的验证编码
    		
			String username=ServletUtil.getRequest().getParameter("username"); 
		 
			String password=ServletUtil.getRequest().getParameter("password"); 
			
			SyUsers u=(SyUsers)dao.findOne("from SyUsers where userName = ?",username);
			if(u==null){
				System.out.println("不存在此用户"); 
				msg="用户名错误， 请重新登录";  
				response.setCharacterEncoding("UTF-8");
				StringBuffer sb=new StringBuffer();
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<CODE>0</CODE><MSG>"+msg+"</MSG>");
				sb.append("</MSGBODY>"); 
				try {
					response.getWriter().println(sb.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//3. 验证用户是否被限制登陆
			if(u.getUserStatus()==(short)0){	 
				msg="用户被限制登陆，请联系管理员"; 
				response.setCharacterEncoding("UTF-8");
				StringBuffer sb=new StringBuffer();
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<CODE>0</CODE><MSG>"+msg+"</MSG>");
				sb.append("</MSGBODY>"); 
				try {
					response.getWriter().println(sb.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			 IpInfo ipInfo=IpUtil.getIpInfo(loginIp); 
		 
			//5. 登录认证  验证密码
			if(MD5Util.MD5Validate(password, u.getUserPassword())){
				Subject currentUser =SecurityUtils.getSubject();
				
				UsernamePasswordToken token =new UsernamePasswordToken(u.getId(), password);
				currentUser.login(token);//登录认证 记录登陆信息 
				System.out.println("****登陆成功*****");
				//6.1 登录成功 保持一些用户信息到session中
				Member me=new Member();//需要放入当前session 的用户信息
				me.setId(u.getId());
				me.setIpInfo(ipInfo);
				me.setLoginTime(loginTime);
				me.setDeptId(u.getDeptId());
				me.setOrgId(u.getOrgId()); 
				HttpSession session=ServletUtil.getRequest().getSession();
				if(username.equals(BaseConfig.getInstance().getDevName())){
					session.setAttribute("dev", true);//当前登陆用户是开发者，拥有所有权限
				}else{
					session.setAttribute("dev", false);
				}
				if(username.equals(BaseConfig.getInstance().getSaName())){
					session.setAttribute("sa", true);//当前登陆用户是系统超级管理员
				}else{
					session.setAttribute("sa", false);
				}
				//6.2 保持一些用户登陆信息 到全局在线用户列表
				//获取全局 用户列表 将此次登录用户添加到用户在线列表中
				Map<String,OnLineUser> usersMap=ServletUtil.getOnLineUsers();
				
				OnLineUser onmy=usersMap.get(u.getId());
				if(onmy==null){
					onmy=new OnLineUser();
				}
				onmy.setId(u.getId());
				onmy.setTrueName(u.getTrueName());
				onmy.setDeptId(u.getDeptId());
				onmy.setSex(u.getUserSex());
				
				Map<String,LoginInfo> loginInfos=onmy.getLoginInfos();
				if(loginInfos==null){
					loginInfos=new HashMap<String,LoginInfo>();
				}
				LoginInfo loginInfo=new LoginInfo();
				loginInfo.setId(FileUtils.getUUID());
				loginInfo.setLoginType(1);
				loginInfo.setIpInfo(ipInfo);
				loginInfo.setLoginTime(loginTime);
				loginInfos.put(session.getId(),loginInfo );
				onmy.setLoginInfos(loginInfos);
				usersMap.put(u.getId(), onmy);//将当前用户信息放入在线用户列表
				session.setAttribute("loginType", 1);//标记此session登陆方式 用于退出时使用
				//6.3 记录登录日志
				SyLoginLog log=new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short)1);
				log.setLoginDesc("登录成功");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);
				
				dao.save(log);//保存登录日志
				//6.4 保持用户本此登录时间 ip 等信息保持到数据库
				u.setLastLoginIp(loginIp);//登录ip
				u.setLastLoginTime(loginTime);//登录时间
				u.setErrorCount((short)0);//将密码错误次数重置为0
				dao.update(u);//更新用户 
				msg="登录成功";
				code="1";
				session.removeAttribute("jmpw");//清除加密密码
				session.setAttribute("fromLogin",true);//标记刚执行登陆操作
				tradeCode=MD5Util.MD5(username+new Date().getTime());
				String userinfo[]={u.getId(),tradeCode,DateUtil.date2String(new Date()),"1"};
				if(tradCode.get(u.getId())!=null){
					tradCode.remove(u.getId()); 
				}  
				tradCode.put(u.getId(), userinfo);
				System.out.println("在线用户："+tradCode.size()+"  tradeCode="+tradeCode);
			//	return mav;
			}else{
				//认证失败
				System.out.println("密码错误");
				//登录日志
				SyLoginLog log=new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short)1);
				log.setLoginDesc("密码错误");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);
				
				dao.save(log);//保存登录日志
				
				u.setErrorTime(loginTime);
				u.setErrorCount((short)(u.getErrorCount()+1));
				
				dao.update(u);//更新用户
				msg="用户名或密码错误， 请重新登录";
			} 
			StringBuffer sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			sb.append("<TRANSACTION_ID>"+tradeCode+"</TRANSACTION_ID><USERID>"+u.getId()+"</USERID><FkDeptId>"+u.getOrgId()+"</FkDeptId><CODE>"+code+"</CODE><PASSWORD>"+u.getUserPassword()+"</PASSWORD><MSG>"+msg+"</MSG>");
			sb.append("</MSGBODY>"); 
			System.out.println(sb.toString());
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block　
			e.printStackTrace();

			response.setCharacterEncoding("UTF-8");
			StringBuffer sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			sb.append("<CODE>0</CODE><MSG>未知错误</MSG>");
			sb.append("</MSGBODY>"); 
			try {
				response.getWriter().println(sb.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	
	}
	
	
	/**
	 * 用户修改密码
	 * 
	 * @param userId,
	 *@param  新密码newpwd,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("updatePwd")
	public String updatePwd(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String newpwd = StringUtil.trim(request.getParameter("newpwd"));
		
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			System.out.println("userinfo:="+userinfo[1]+" ");
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
		/*  	SyUsers user=(SyUsers) dao.findOne("from SysDept where id=?", userId);
		  	if(user!=null)
		  		deptId=user.getDeptId();*/
			SyUsers u=(SyUsers)dao.findOne("from SyUsers where id = ?",userId);
			u.setUserPassword(MD5Util.MD5(newpwd));
			boolean fla = dao.update(u);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(fla){
						sb.append("<RESULT_CODE>1</RESULT_CODE>");
						sb.append("<MSG>修改成功!</MSG>");
				}	
			else{
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>修改失败!</MSG>");
			}
			sb.append("</MSGBODY>"); 
			response.setCharacterEncoding("utf-8");
			 
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	
	
	
	/**
	 * 获取会议通知
	 * 
	 * @param userId,
	 *@param  deptId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("conferenceList")
	public String conferenceList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		System.out.println("userId:"+userId+" deptId="+deptId+" ");
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			System.out.println("userinfo:="+userinfo[1]+" ");
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PageParam param=new PageParam();
			param.setPage(page);
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId); 
		/*  	SyUsers user=(SyUsers) dao.findOne("from SysDept where id=?", userId);
		  	if(user!=null)
		  		deptId=user.getDeptId();*/
		  	List list=new ArrayList();
		  	sb.append("from Meeting a where a.id in(select mpMtid from Mapping where  ((mpType=1 and mpFkid in(select deptId from SyUsers where id=?)) or (mpType=2 and mpFkid=?))) ");
			list.add(""+deptId+"");
			list.add(""+userId+"");
			int row=0;
			List<Meeting> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
				for(Meeting r:rows){
					if(row==0)
						sb.append("<RESULT_CODE>1</RESULT_CODE>");
					
					String status="0";
					/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
					if(conList!=null&&conList.size()>0)
						status=conList.get(0).toString();
					else
						status="1";*/
					sb.append("<LIST>");
					sb.append("<ID>");
					sb.append(r.getId());
					sb.append("</ID>");
					sb.append("<TITLE>");
					sb.append("<![CDATA["+r.getMName()+"]]>");
					sb.append("</TITLE>");
					sb.append("<CONTENT>");
					//sb.append("<![CDATA["+r.getMSummary()+"]]>");
					sb.append("</CONTENT>");
					sb.append("<DATE>");
					sb.append(r.getMPublished());
					sb.append("</DATE>");
					sb.append("<STATUS>"+status); 
					sb.append("</STATUS>");
					sb.append("</LIST>");
					row++;
				}	
			}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>"); 
			response.setCharacterEncoding("utf-8");
			 
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	/**
	 * 获取会议通知内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("conferenceContent")
	public String conferenceContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId")); 
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId);  
		  	List list=new ArrayList();
		  	sb.append("from Meeting a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			Meeting  meeting=(Meeting) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+meeting.getMSummary()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
/**
 * 获取新闻
 * @param map
 * @param response
 * 	 * @param userId,
	 *@param  deptId,
	 *@param startIndex, 
	 * @return xml
 * @return
 */
	@RequestMapping("newsList")
	public String newsList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		System.out.println("userId:"+userId+" deptId="+deptId+" ");
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PageParam param=new PageParam();
			param.setPage(page);
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId); 
		   
		  	List list=new ArrayList();
		  	sb.append("from Newsmanagement a where    a.orgid=? ");
			list.add(""+deptId+""); 
			int row=0;
			List<Newsmanagement> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(Newsmanagement r:rows){
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				
				String status="0";
				/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
				if(conList!=null&&conList.size()>0)
					status=conList.get(0).toString();
				else
					status="1";*/
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
				sb.append("<TITLE>");
				sb.append("<![CDATA["+r.getNewstitle()+"]]>");
				sb.append("</TITLE>");
				sb.append("<CONTENT>");
			 //	sb.append("<![CDATA["+r.getNewsplot()+"]]>");
				sb.append("</CONTENT>");
				sb.append("<DATE>");
				sb.append(r.getCreatedtime());
				sb.append("</DATE>");
				sb.append("<IMG>");
				 
				sb.append("</IMG>"); 
				sb.append("<STATUS>"+status); 
				sb.append("</STATUS>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	/**
	 * 获取新闻内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("newsContent")
	public String newsContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId")); 
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId);  
		  	List list=new ArrayList();
		  	sb.append("from Newsmanagement a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			Newsmanagement  affiche=(Newsmanagement) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+affiche.getNewsplot()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取通知公告
	 * 
	 * @param userId,
	 *@param  deptId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("noticeList")
	public String noticeList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PageParam param=new PageParam();
			param.setPage(page);
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId); 
		   
		  	List list=new ArrayList();
		  	sb.append("from XtAffiche a where    a.orgid=? ");
			list.add(""+deptId+"");
		  /*	if(StringUtils.isNotBlank(a.getUserId())){
				sb.append(" and a.userId =? ");
				list.add(a.getUserId());
			} */
			int row=0;
			List<XtAffiche> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(XtAffiche r:rows){
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				
				String status="0";
				/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
				if(conList!=null&&conList.size()>0)
					status=conList.get(0).toString();
				else
					status="1";*/
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
				sb.append("<TITLE>");
				sb.append("<![CDATA["+r.getAfficheTitle()+"]]>");
				sb.append("</TITLE>");
				sb.append("<CONTENT>");
				//sb.append("<![CDATA["+r.getAfficheContent()+"]]>");
				sb.append("</CONTENT>");
				sb.append("<DATE>");
				sb.append(r.getCreateTime());
				sb.append("</DATE>");
				sb.append("<STATUS>"+status); 
				sb.append("</STATUS>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	/**
	 * 获取通知公告内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("noticeContent")
	public String noticeContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId= StringUtil.trim(request.getParameter("deptId")); 
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
		  	XtAffiche a=new XtAffiche();
		  	a.setUserId(userId);
		  	a.setOrgid(deptId);  
		  	List list=new ArrayList();
		  	sb.append("from XtAffiche a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			XtAffiche  affiche=(XtAffiche) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+affiche.getAfficheContent()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取日程安排
	 * 
	 * @param userId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("scheduleList")
	public String scheduleList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PageParam param=new PageParam();
			param.setPage(page);
			PerSchedule ps = new PerSchedule();
			ps.setUserId(userId);
		   
		  	List list=new ArrayList();
		  	sb.append("from PerSchedule a where    a.userId=? ");
			list.add(""+userId+"");
		  /*	if(StringUtils.isNotBlank(a.getUserId())){
				sb.append(" and a.userId =? ");
				list.add(a.getUserId());
			} */
			int row=0;
			List<PerSchedule> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(PerSchedule r:rows){
				r.setSchType(MyCache.getInstance().getSelectValue(r.getSchType()));
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
				if(conList!=null&&conList.size()>0)
					status=conList.get(0).toString();
				else
					status="1";*/
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
				sb.append("<SCHTITLE>");
				sb.append("<![CDATA["+r.getSchTitle()+"]]>");
				sb.append("</SCHTITLE>");
				sb.append("<SCHTYPE>");
				sb.append(r.getSchType());
				sb.append("</SCHTYPE>");
				sb.append("<STARTTIME>");
				sb.append(r.getStartTime());
				sb.append("</STARTTIME>");
				sb.append("<ENDTIME>");
				sb.append(r.getEndTime());
				sb.append("</ENDTIME>");
				sb.append("<WARNTIME>");
				sb.append(r.getWarnTime());
				sb.append("</WARNTIME>");
				sb.append("<SCHCONTENT>");
				sb.append("<![CDATA["+r.getSchContent()+"]]>");
				sb.append("</SCHCONTENT>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	
	
	
	
	
	
	/**
	 * 获取日程安排内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("scheduleContent")
	public String scheduleContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
			PerSchedule ps=new PerSchedule();
		  	ps.setUserId(userId);
		  	List list=new ArrayList();
		  	sb.append("from PerSchedule a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			PerSchedule  affiche=(PerSchedule) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+affiche.getSchContent()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 获取ListValue
	 * 
	 * @param userId,
	 *@param startIndex,
	 *@param listtype
	 * @return xml
	 */
	@RequestMapping("TypeList")
	public String TypeList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		 int listType= Integer.parseInt(StringUtil.toNumber(request.getParameter("listtype")));
		//String listType= StringUtil.trim(request.getParameter("listType"));
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PageParam param=new PageParam();
			param.setPage(page);
			ListValues lv = new ListValues();
			lv.setListType(listType);
		   
		  	List list=new ArrayList();
		  	sb.append("from ListValues a where    a.listType=? ");
			list.add(listType);
			int row=0;
			List<ListValues> rows=dao.find(sb.toString(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(ListValues r:rows){
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
//				sb.append("<LISTTYPE>");
//				sb.append(r.getListType());
//				sb.append("</LISTTYPE>");
				sb.append("<LISTVALUE>");
				sb.append(r.getListValue());
				sb.append("</LISTVALUE>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	
	
	/**
	 * 添加日程安排
	 * 
	 * @param userId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("addSchedule")
	public String addSchedule(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		
		String schTitle =StringUtil.trim(request.getParameter("schTitle")); //日程主题
		String schType=StringUtil.trim(request.getParameter("schType"));	//日程类型
		String schContent =StringUtil.trim(request.getParameter("schContent"));	//日程类型
		Timestamp startTime =DateUtil.string2Timestamp(request.getParameter("startTime"));//开始时间
		Timestamp endTime =DateUtil.string2Timestamp(request.getParameter("endTime"));		//结束时间
		Timestamp warnTime = DateUtil.string2Timestamp(request.getParameter("warnTime"));	//提醒时间
		
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			PerSchedule ps = new PerSchedule();
			ps.setUserId(userId);
			ps.setSchTitle(schTitle);
			ps.setSchType(schType);
			ps.setStartTime(startTime);
			ps.setEndTime(endTime);
			ps.setWarnTime(warnTime);
			ps.setSchContent(schContent);
			boolean flak = dao.save(ps);
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(flak){
				sb.append("<RESULT_CODE>"+"1"+"</RESULT_CODE>");
				sb.append("<MSG>"+"操作成功！"+"</MSG>");
				}else{
					sb.append("<MSG>"+"内部错误,请联系管理员"+"</MSG>");
				}
			sb.append("</MSGBODY>"); 
			System.out.println(sb.toString());
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	


	
	/**
	 * 获取法规
	 * 
	 * @param userId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("rulesList")
	public String rulesList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId=StringUtil.trim(request.getParameter("deptId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			
			PageParam param=new PageParam();
			param.setPage(page);
			RmRulesmanager rmg = new RmRulesmanager();
			rmg.setAuthor(userId);
			rmg.setOrgid(deptId);
		   
		  	List list=new ArrayList();
		  	sb.append("from RmRulesmanager a where  a.author=? ");
			list.add(""+userId+"");
		  /*	if(StringUtils.isNotBlank(a.getUserId())){
				sb.append(" and a.userId =? ");
				list.add(a.getUserId());
			} */
			int row=0;
			List<RmRulesmanager> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(RmRulesmanager r:rows){
				r.setAuthor(MyCache.getInstance().getTrueName(r.getAuthor()));//发布人
				r.setRulesTypeid(MyCache.getInstance().getSelectValue(r.getRulesTypeid()));//法规类型
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
				if(conList!=null&&conList.size()>0)
					status=conList.get(0).toString();
				else
					status="1";*/
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
				sb.append("<RULESTITLE>");
				sb.append("<![CDATA["+r.getRulesTitle()+"]]>");
				sb.append("</RULESTITLE>");
				sb.append("<RULESTYPE>");
				sb.append(r.getRulesTypeid());
				sb.append("</RULESTYPE>");
				sb.append("<AUTHOR>");
				sb.append(r.getAuthor());
				sb.append("</AUTHOR>");
				sb.append("<MODYAUTHOR>");
				sb.append(r.getModyauthor());
				sb.append("</MODYAUTHOR>");
				sb.append("<CREATEDATE>");
				sb.append(r.getCreatedate());
				sb.append("</CREATEDATE>");
				sb.append("<MODYDATE>");
				sb.append(r.getModydate());
				sb.append("</MODYDATE>");
				sb.append("<CONTENTS>");
				sb.append("<![CDATA["+r.getContents()+"]]>");
				sb.append("</CONTENTS>");
				sb.append("<ORGID>");
				sb.append(r.getOrgid());
				sb.append("</ORGID>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	
	
	
	
	
	
	/**
	 * 获取法规内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("rulesContent")
	public String rulesContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId=StringUtil.trim(request.getParameter("deptId"));
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
			RmRulesmanager ps=new RmRulesmanager();
		  	ps.setAuthor(userId);
		  	ps.setOrgid(deptId);
		  	List list=new ArrayList();
		  	sb.append("from RmRulesmanager a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			RmRulesmanager  affiche=(RmRulesmanager) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+affiche.getContents()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * 获取规章
	 * 
	 * @param userId,
	 *@param startIndex,
	 * @return xml
	 */
	@RequestMapping("regulaList")
	public String regulaList(ModelMap map,HttpServletResponse response){ 
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID");
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId=StringUtil.trim(request.getParameter("deptId"));
		int page= Integer.parseInt(StringUtil.toNumber(request.getParameter("page")));
		String startIndex= StringUtil.trim(request.getParameter("startIndex"));
		String flag= StringUtil.trim(request.getParameter("flag"));
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>");
				System.out.println("sb.toString()=="+sb.toString());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			}
			
			PageParam param=new PageParam();
			param.setPage(page);
			RgRulesregulations rmg = new RgRulesregulations();
			rmg.setPromulgator(userId);
			rmg.setOrgid(deptId);
		   
		  	List list=new ArrayList();
		  	sb.append("from RgRulesregulations a where  a.promulgator=? ");
			list.add(""+userId+"");
		  /*	if(StringUtils.isNotBlank(a.getUserId())){
				sb.append(" and a.userId =? ");
				list.add(a.getUserId());
			} */
			int row=0;
			List<RgRulesregulations> rows=dao.findPage(sb.toString(),param.getPage(),param.getRows(),list);
			 sb=new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<MSGBODY>");
			if(rows.size()>0){
			for(RgRulesregulations r:rows){
				r.setPromulgator(MyCache.getInstance().getTrueName(r.getPromulgator()));//发布人
				r.setTypeid(MyCache.getInstance().getSelectValue(r.getTypeid()));//规章类型
				if(row==0)
					sb.append("<RESULT_CODE>1</RESULT_CODE>");
				/*List conList=this.getGeneralService().getBySQL("select nvl(ISRECEIVERCLEARFLAG,0) from sys_pub_msg where msg_id='"+no.getId()+"' and sender_id='CONF' and RECEIVER_ID='"+userId+"' ");
				if(conList!=null&&conList.size()>0)
					status=conList.get(0).toString();
				else
					status="1";*/
				sb.append("<LIST>");
				sb.append("<ID>");
				sb.append(r.getId());
				sb.append("</ID>");
				sb.append("<TYPEID>");
				sb.append(r.getTypeid());
				sb.append("</TYPEID>");
				sb.append("<CONTENTS>");
				sb.append("<![CDATA["+r.getContents()+"]]>");
				sb.append("</CONTENTS>");
				sb.append("<PROMULGATOR>");
				sb.append(r.getPromulgator());
				sb.append("</PROMULGATOR>");
				sb.append("<CREATEDATE>");
				sb.append(r.getCreatedate());
				sb.append("</CREATEDATE>");
				sb.append("<MODIFIEDATE>");
				sb.append(r.getModifiedate());
				sb.append("</MODIFIEDATE>");
				sb.append("<RULESTITLE>");
				sb.append(r.getRulestitle());
				sb.append("</RULESTITLE>");
				sb.append("<MODIFYBYNAME>");
				sb.append(r.getModifyByname());
				sb.append("</MODIFYBYNAME>");
				sb.append("<ORGID>");
				sb.append(r.getOrgid());
				sb.append("</ORGID>");
				sb.append("</LIST>");
				row++;
			}	}else{
			
				sb.append("<RESULT_CODE>0</RESULT_CODE>");
				sb.append("<MSG>暂无数据</MSG>");
			}
			sb.append("</MSGBODY>");
			 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(sb.toString());
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}
 
	
	
	
	
	
	
	/**
	 * 获取法规内容
	 * 
	 * @param id, 
	 * @return html
	 */
	@RequestMapping("regulaContent")
	public String regulaContent(ModelMap map,HttpServletResponse response){
		HttpServletRequest request=ServletUtil.getRequest();
		String tradeCode=request.getParameter("TRANSACTION_ID"); 
		String id=StringUtil.trim(request.getParameter("id"));
		String userId=StringUtil.trim(request.getParameter("userId"));
		String deptId=StringUtil.trim(request.getParameter("deptId"));
		String flag= StringUtil.trim(request.getParameter("flag")); 
		StringBuffer sb=new StringBuffer();
		try{
			String userinfo[]=(String[])tradCode.get(userId);
			if(userinfo==null||!userinfo[1].equals(tradeCode)){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<MSGBODY>");
				sb.append("<RESULT_CODE>0</RESULT_CODE><MSG>非法访问</MSG>");
				sb.append("</MSGBODY>"); 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(sb.toString());
				return null;
			} 
			RgRulesregulations ps=new RgRulesregulations();
		  	ps.setPromulgator(userId);
		  	List list=new ArrayList();
		  	sb.append("from RgRulesregulations a where    a.id=? ");
			list.add(""+id+""); 
			int row=0;
			RgRulesregulations  affiche=(RgRulesregulations) dao.findOne(sb.toString(),list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>"+affiche.getContents()+"</body></html>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int minus(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}