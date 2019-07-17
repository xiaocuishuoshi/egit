package com.whfp.oa.webservice;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.config.BaseConfig;
import com.whfp.oa.commons.gt.Notification;
import com.whfp.oa.commons.model.IpInfo;
import com.whfp.oa.commons.model.LoginInfo;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.OnLineUser;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.FileUtils;
import com.whfp.oa.commons.util.IpUtil;
import com.whfp.oa.commons.util.MD5Util;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.commons.util.StringUtil;
import com.whfp.oa.manager.jd.bean.JdFlfg;
import com.whfp.oa.manager.jd.bean.JdPzxx;
import com.whfp.oa.manager.jd.bean.JdQj;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdShqz;
import com.whfp.oa.manager.jd.bean.JdSxhb;
import com.whfp.oa.manager.jd.bean.JdTzs;
import com.whfp.oa.manager.jd.bean.JdWzxx;
import com.whfp.oa.manager.jd.bean.JdXc;
import com.whfp.oa.manager.jd.bean.JdYjsb;
import com.whfp.oa.manager.jd.service.IJdPzxxService;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.jd.service.IJdflfgService;
import com.whfp.oa.manager.jd.service.IJdxcService;
import com.whfp.oa.manager.jd.service.IQjglService;
import com.whfp.oa.manager.jd.service.IShqzService;
import com.whfp.oa.manager.jd.service.ISxhbService;
import com.whfp.oa.manager.jd.service.ITzsService;
import com.whfp.oa.manager.jd.service.IYjsbService;
import com.whfp.oa.manager.system.bean.SyDept;
import com.whfp.oa.manager.system.bean.SyLog;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;
import com.whfp.oa.manager.system.service.IDeptService;
import com.whfp.oa.manager.system.service.ILoginService;
import com.whfp.oa.manager.system.service.ISystemLogService;
import com.whfp.oa.manager.system.service.IUserService;
import com.whfp.oa.webservice.bean.Enclosure;
import com.whfp.oa.webservice.bean.MobilelocationEntity;

@Controller
@RequestMapping("/jdInterface")
@Transactional
public class JdInterfaceImpl extends BaseAction {  
	public static Map tradCode = new HashMap();
	@Autowired
	private IUserService service;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ISystemLogService logService;
	
	@Autowired
	private IShqzService service1;
	@Autowired
	private IJdPzxxService jdPzxxService;

	@Autowired
	private ITzsService tzsService;
	@Autowired
	private IQjglService qjService;
	@Autowired
	private IJdService  jdService;
	
	@Autowired
	private IShqzService  shqzService;
	
	@Autowired
	private IJdxcService jdxcService;
	@Autowired
	private IYjsbService yjsbService;
	@Autowired
	private IJdflfgService JdflfgService;
	@Autowired
	private ISxhbService sxhbService;
	@RequestMapping("userLogin")
	public String userLogin(ModelMap map, HttpServletResponse response,HttpServletRequest request) {
    	response.setCharacterEncoding("utf-8");
		try {
			String msg = "";
			String json = "";
			String code = "0";
			Timestamp loginTime =DateUtil.string2Timestamp(DateUtil.currentDateTimeToString());// DateUtil.currentTimestamp();
			String loginIp = IpUtil.getIpAddr(ServletUtil.getRequest());
			String tradeCode = "";// 返回给用户用于接口访问的验证编码

			String username = ServletUtil.getRequest().getParameter("username");

			String password = ServletUtil.getRequest().getParameter("password");
			String cid=ServletUtil.getRequest().getParameter("cid");
			SyUsers u = service.findUserByLoginName(username);
			// SyUsers
			// u=(SyUsers)dao.findOne("from SyUsers where userName = ?",username);
			if (u == null) {
				System.out.println("不存在此用户");
				msg = "用户名错误， 请重新登录";
				json = "{\"success\":false,\"msg\":\"" + msg + "\"}";
				try {
					response.getWriter().println(json);
					return null;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			// 3. 验证用户是否被限制登陆
			if (u.getUserStatus() == (short) 0) {
				msg = "用户被限制登陆，请联系管理员";
				response.setCharacterEncoding("UTF-8");
				json = "{\"success\":false,\"msg\":\"" + msg + "\"}";
				try {
					response.getWriter().println(json);
					return null;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			IpInfo ipInfo = IpUtil.getIpInfo(loginIp);

			// 5. 登录认证 验证密码
			if (MD5Util.MD5Validate(password, u.getUserPassword())) {
				Subject currentUser = SecurityUtils.getSubject();

				UsernamePasswordToken token = new UsernamePasswordToken(
						u.getId(), password);
				currentUser.login(token);// 登录认证 记录登陆信息
				System.out.println("****登陆成功*****");
				// 6.1 登录成功 保持一些用户信息到session中
				Member me = new Member();// 需要放入当前session 的用户信息
				me.setId(u.getId());
				me.setIpInfo(ipInfo);
				me.setLoginTime(loginTime);
				me.setDeptId(u.getDeptId());
				me.setOrgId(u.getOrgId());
				HttpSession session = ServletUtil.getRequest().getSession();
				if (username.equals(BaseConfig.getInstance().getDevName())) {
					session.setAttribute("dev", true);// 当前登陆用户是开发者，拥有所有权限
				} else {
					session.setAttribute("dev", false);
				}
				if (username.equals(BaseConfig.getInstance().getSaName())) {
					session.setAttribute("sa", true);// 当前登陆用户是系统超级管理员
				} else {
					session.setAttribute("sa", false);
				}
				// 6.2 保持一些用户登陆信息 到全局在线用户列表
				// 获取全局 用户列表 将此次登录用户添加到用户在线列表中
				Map<String, OnLineUser> usersMap = ServletUtil.getOnLineUsers();

				OnLineUser onmy = usersMap.get(u.getId());
				if (onmy == null) {
					onmy = new OnLineUser();
				}
				onmy.setId(u.getId());
				onmy.setTrueName(u.getTrueName());
				onmy.setDeptId(u.getDeptId());
				onmy.setSex(u.getUserSex());

				Map<String, LoginInfo> loginInfos = onmy.getLoginInfos();
				if (loginInfos == null) {
					loginInfos = new HashMap<String, LoginInfo>();
				}
				LoginInfo loginInfo = new LoginInfo();
				loginInfo.setId(FileUtils.getUUID());
				loginInfo.setLoginType(1);
				loginInfo.setIpInfo(ipInfo);
				loginInfo.setLoginTime(loginTime);
				loginInfos.put(session.getId(), loginInfo);
				onmy.setLoginInfos(loginInfos);
				usersMap.put(u.getId(), onmy);// 将当前用户信息放入在线用户列表
				session.setAttribute("loginType", 1);// 标记此session登陆方式 用于退出时使用
				// 6.3 记录登录日志
				SyLoginLog log = new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short) 1);
				log.setLoginDesc("登录成功");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);


				logService.save(log);// 保存登录日志
				// 6.4 保持用户本此登录时间 ip 等信息保持到数据库
				u.setLastLoginIp(loginIp);// 登录ip
				u.setLastLoginTime(loginTime);// 登录时间
				u.setErrorCount((short) 0);// 将密码错误次数重置为0
				u.setCid(cid);
				service.update(u);// 更新用户
				msg = "登录成功";
				code = "1";
				session.removeAttribute("jmpw");// 清除加密密码
				session.setAttribute("fromLogin", true);// 标记刚执行登陆操作
				String ryid=u.getId();//StringUtil.trim(request.getParameter("ryid"));  
				JdRyb ryb=jdService.selectUserByUserid(ryid);  
				String jdzy="";
				if(ryb!=null)jdzy=ryb.getJdZy();
				String jdryxb="";
				if(ryb!=null) jdryxb=ryb.getJdRyxb();
                                json = "{\"success\":true,\"msg\":\""+msg+"\",\"userId\":\""+u.getId()+"\",\"userName\":\""+u.getUserName()+"\",\"password\":\""+u.getUserPassword()+"\",\"trueName\":\""+u.getTrueName()+"\",\"fkDeptId\":\""+u.getDeptId()+"\",\"jdzy\":\""+jdzy+"\",\"jdryxb\":\""+jdryxb+"\",\"cid\":\""+cid+"\",\"mobile\":\""+u.getMobilePhoneNumber()+"\"}";
				/*
				 * tradeCode=MD5Util.MD5(username+new Date().getTime()); String
				 * userinfo[]={u.getId(),tradeCode,DateUtil.date2String(new
				 * Date()),"1"}; if(tradCode.get(u.getId())!=null){
				 * tradCode.remove(u.getId()); } tradCode.put(u.getId(),
				 * userinfo);
				 * System.out.println("在线用户："+tradCode.size()+"  tradeCode="
				 * +tradeCode);
				 */
				// return mav;
			} else {
				// 认证失败 
				System.out.println("密码错误");
				// 登录日志
				SyLoginLog log = new SyLoginLog();
				log.setUserId(u.getId());
				log.setLoginType((short) 1);
				log.setLoginDesc("密码错误");
				log.setIpInfoCountry(ipInfo.getCountry());
				log.setIpInfoCity(ipInfo.getCity());
				log.setIpInfoIsp(ipInfo.getIsp());
				log.setIpInfoRegion(ipInfo.getRegion());
				log.setLoginIp(loginIp);
				log.setLoginTime(loginTime);

				logService.save(log);// 保存登录日志

				u.setErrorTime(loginTime);
				u.setErrorCount((short) (u.getErrorCount() + 1));

				service.update(u);// 更新用户
				msg = "用户名或密码错误， 请重新登录";
				json = "{\"success\":false,\"msg\":\"" + msg + "\"}";

			}
			/*
			 * StringBuffer sb=new StringBuffer();
			 * sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			 * sb.append("<MSGBODY>");
			 * sb.append("<TRANSACTION_ID>"+tradeCode+"</TRANSACTION_ID><USERID>"
			 * +
			 * u.getId()+"</USERID><FkDeptId>"+u.getOrgId()+"</FkDeptId><CODE>"+
			 * code
			 * +"</CODE><PASSWORD>"+u.getUserPassword()+"</PASSWORD><MSG>"+msg
			 * +"</MSG>"); sb.append("</MSGBODY>");
			 */
			System.out.println(json);
			response.getWriter().println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block　
			e.printStackTrace();

			/*
			 * StringBuffer sb=new StringBuffer();
			 * sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			 * sb.append("<MSGBODY>");
			 * sb.append("<CODE>0</CODE><MSG>未知错误</MSG>");
			 * sb.append("</MSGBODY>");
			 */
			String json = "{\"success\":false,\"msg\":\"未知错误\"}";
			try {
				response.getWriter().println(json);
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
	 * @param userId
	 *            ,
	 * @param 新密码newpwd
	 *            ,
	 * @param startIndex
	 *            ,
	 * @return xml
	 */
	@RequestMapping("updatePwd")
	public String updatePwd(ModelMap map, HttpServletResponse response) {
		response.setCharacterEncoding("gbk");
		HttpServletRequest request = ServletUtil.getRequest();
		String userId = StringUtil.trim(request.getParameter("userId"));
		String oldPwd = StringUtil.trim(request.getParameter("oldPwd"));
		String newPwd = StringUtil.trim(request.getParameter("newPwd"));
		String json = "";

		try {
			SyUsers u = service.findUserByLoginId(userId);
			String decodePass = MD5Util.MD5(oldPwd);
			System.out.println(u.getUserPassword() + "＝＝  decodePass=="
					+ decodePass);
			if (!u.getUserPassword().equals(decodePass)) {
				json = "{\"success\":false,\"msg\":\"原密码输入错误，请重新输入！\"}";
				response.getWriter().println(json);
				return null;
			}
			u.setUserPassword(MD5Util.MD5(newPwd));

			boolean fla = service.update(u);

			if (fla) {
				json = "{\"success\":true,\"msg\":\"密码修改成功！\"}";
			} else {
				json = "{\"success\":true,\"msg\":\"修改失败!\"}";

			}
			System.out.println(json);
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 添加戒毒人员信息
	 * 
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(ModelMap map, HttpServletResponse response) {//,@RequestParam MultipartFile file
		HttpServletRequest request = ServletUtil.getRequest();
		response.setCharacterEncoding("utf-8");
		String jdRybh = StringUtil.trim(request.getParameter("jd_rybh"));
		String jdRyid = StringUtil.trim(request.getParameter("jd_ryid"));
		String jdRyxm = (String) map.get("jd_ryxm");//StringUtil.trim(request.getParameter("jd_ryxm"));
		String fkDeptId =StringUtil.trim(request.getParameter("fk_dept_id"));
		String jdRysg = StringUtil.trim(request.getParameter("jd_rysg"));
		String jdRyxb =StringUtil.trim(request.getParameter("jd_ryxb"));
		String jdJgry = StringUtil.trim(request.getParameter("jd_jgry"));
		String jdDwdh =StringUtil.trim(request.getParameter("jd_dwdh"));
		String jdRyjg = StringUtil.trim(request.getParameter("jd_ryjg"));
		String jdHjd = StringUtil.trim(request.getParameter("jd_hjd"));
		String jdHjxxdz = StringUtil.trim(request.getParameter("jd_hjxxdz"));
		String jdHjdpcs =StringUtil.trim(request.getParameter("jd_hjdpcs"));
		String jdHklx = StringUtil.trim(request.getParameter("jd_hklx"));
		String jdHyzk = StringUtil.trim(request.getParameter("jd_hyzk"));
		String jdWhcd = StringUtil.trim(request.getParameter("jd_whcd"));
		String jdLxfs = StringUtil.trim(request.getParameter("jd_lxfs"));
		String jdJzd = StringUtil.trim(request.getParameter("jd_jzd"));
		String jdJzdz = StringUtil.trim(request.getParameter("jd_jzdz"));
		String jdJzdpcs = StringUtil.trim(request.getParameter("jd_jzdpcs"));
		String jdMz = StringUtil.trim(request.getParameter("jd_mz"));
		String jdZjxy = StringUtil.trim(request.getParameter("jd_zjxy"));
		String jdZjzl = StringUtil.trim(request.getParameter("jd_zjzl"));
		String jdSfzh = StringUtil.trim(request.getParameter("jd_sfzh"));
		String jdCsrq = StringUtil.trim(request.getParameter("jd_csrq"));
		String jdCym = StringUtil.trim(request.getParameter("jd_cym"));
		String jdZzmm = StringUtil.trim(request.getParameter("jd_zzmm"));
		String jdZy = StringUtil.trim(request.getParameter("zd_zy"));
		String jdTscs = StringUtil.trim(request.getParameter("jd_tscs"));
		String jdLydpzl = StringUtil.trim(request.getParameter("jd_lydpzl"));
		String jdChdw = StringUtil.trim(request.getParameter("jd_chdw"));
		String jdChrq = StringUtil.trim(request.getParameter("jd_chrq"));
		String jdDqgkxz = StringUtil.trim(request.getParameter("jd_dqgkxz"));
		String jdDqgkdq = StringUtil.trim(request.getParameter("jd_dqgkdq"));
		String jdRyxp ="";// StringUtil.trim(request.getParameter("jd_ryxp"));
		String SAVEPATH = "image_space";
		String json = "";
		try {
		// 定义图片类型后缀,只允许上传此类型的图片
		/*String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
		
			if (file.isEmpty()) {
				json = ajaxDoneError().toString();
			}
			ModelAndView view = FileUtils.validateFile(file, 1024L * 1024 * 10,
					IMGTYPE, null);
			if (view != null)
				json = view.toString();  
			String uuid=FileUtils.getUUID();//uuid作为保存时的文件名
			String ext=FileUtils.getFileExt(file.getOriginalFilename());//获取文件后缀  
			//保存文件
			File newFile = new File(BaseConfig.webPath+SAVEPATH+"/"+uuid+"."+ext); 
			file.transferTo(newFile); 
			jdRyxp=SAVEPATH+"/"+uuid+"."+ext;
	*/
				
			/*jdCjsj = formatter.parse(StringUtil.trim(request
					.getParameter("jd_cjsj")));*/ 
		Timestamp jdCjsj =DateUtil.currentTimestamp();
			JdRyb  jd = new JdRyb(jdRyid,jdRybh, jdRyxm, fkDeptId, jdRysg, jdRyxb, jdJgry,
					jdDwdh, jdRyjg, jdHjd, jdHjxxdz, jdHjdpcs, jdHklx, jdHyzk,
					jdWhcd, jdLxfs, jdJzd, jdJzdz, jdJzdpcs, jdMz, jdZjxy, jdZjzl,
					jdSfzh, jdCsrq, jdCym, jdZzmm, jdZy, jdTscs, jdLydpzl, jdChdw,
					jdChrq, jdDqgkxz, jdDqgkdq, jdRyxp, jdCjsj, "1",null,null,null,"0","0","",0,0,0,"","");
			
			boolean fla = service.save(jd);
 
			if (fla) {
				json = "{\"success\":true,\"msg\":\"提交个人信息成功!\"}";

			} else {
				json = "{\"success\":false,\"msg\":\"提交个人信息失败!\"}";
			}

			response.getWriter().println(json);
		} catch (Exception e1) {
			e1.printStackTrace();
			json = "{\"success\":false,\"msg\":\"提交个人信息失败!\"}";
		}
	
	
		return null;
	}
	
	
	/**
	 * 添加位置
	 * 
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping("UpLoadLocation")
	public String UpLoadLocation(HttpServletRequest request, HttpServletResponse response) { 
		String city = StringUtil.trim(request.getParameter("city"));
		String area = StringUtil.trim(request.getParameter("area")); 
		String longitude = StringUtil.trim(request.getParameter("longitude"));
		String latitude = StringUtil.trim(request.getParameter("latitude"));
		Timestamp createtime =DateUtil.string2Timestamp(DateUtil.currentDateTimeToString());
		String userid = StringUtil.trim(request.getParameter("userid"));
		String username = StringUtil.trim(request.getParameter("username"));
		String fk_dept_id = StringUtil.trim(request.getParameter("fk_dept_id"));
		String cid=StringUtil.trim(request.getParameter("cid"));
		String json = "";
		boolean isout=false;
		try {
		/*	if(city==null||city.equals("")||city.equals("null")||area==null||area.equals("")||area.equals("null")){

				json = "{\"success\":false,\"msg\":\"提交个人信息失败,未获取到定位信息！\"}";
				return json;
			}*/
			
			if(longitude!=null&&longitude.length()>10)
				longitude=longitude.substring(0,10);

			if(latitude!=null&&latitude.length()>10)
				latitude=latitude.substring(0,10);
			
			
			JdWzxx ai = new JdWzxx(city, area, longitude, latitude, createtime,
					userid, username, fk_dept_id,""); 
			JdRyb jdRyb=jdService.selectUserByUserid(userid);
			if(jdRyb!=null){
			jdRyb.setDqwz(city+area+","+longitude+","+latitude+"");
			jdRyb.setDqwzsj(DateUtil.currentTimestamp().toString()); 
			jdRyb.setJdSjid(cid); 
			System.out.println("jdRyb.getJdHdqy()=="+jdRyb.getJdHdqy());
			if(jdRyb.getJdHdqy()!=null&&!jdRyb.getJdHdqy().equals("")&&jdRyb.getJdHdqy().length()>4){
				System.out.println(11111);
				String array[]=jdRyb.getJdHdqy().split(";"); 
				System.out.println("length====="+array.length);
				List<Enclosure> enclosureList=new ArrayList(); 
				for(int i=0;i<array.length;i++)
				{
					String jwd[]=array[i].split(",");
					if(jwd==null||jwd.length<2)
						continue;
					Enclosure clo=new Enclosure(jwd[0], jwd[1]); 
					enclosureList.add(clo);
				}
				System.out.println("enclosureList="+enclosureList.size());
				MobilelocationEntity mobilelocationEntity=new MobilelocationEntity(longitude,latitude);
				boolean flag=MapTools.isInPolygon(mobilelocationEntity, enclosureList);
				 
				if(flag==false){ 
						jdRyb.setJdSfyj("1");
					 
						isout=true;
							// 6.3 记录登录日志
						SyLog log = new SyLog();
						log.setUserId(jdRyb.getJdRyid());
						log.setActionContent("越界告警");
						log.setActionDesc(jdRyb.getJdRyxm()+"位置："+longitude+","+latitude);
						 
						log.setActionIp(request.getLocalAddr());
						log.setActionIpInfo(request.getLocalAddr());
						log.setActionTime(createtime); 
						logService.save(log);// 保存登录日志
					 
				}else
					jdRyb.setJdSfyj("0");
			} 
			boolean ufla=jdService.saveOrUpdate(jdRyb); 
			boolean fla = service.save(ai);
			
			if (fla) {
				if(isout){
					System.out.println("爱心之路越界面提醒:你已经越过可活动边界，请速回!");
				//	new Notification().pushMsg(jdRyb.getJdSjid(), "爱心之路越界面提醒","payload:{content:\"你已经越过可活动边界，请速回！\"}");
					new Notification().pushMsg(jdRyb.getJdSjid(), "爱心之路越界面提醒","你已经越过可活动边界，请速回！");
					System.out.println("爱心之路越界面提醒:你已经越过可活动边界，请速回!");
					
				}
				json = "{\"success\":true,\"msg\":\"提交个人信息成功!\"}";
			} else {
				json = "{\"success\":false,\"msg\":\"提交个人信息失败!\"}";
			}
		}else{
			json = "{\"success\":false,\"msg\":\"提交个人信息失败!该人员非吸毒人员\"}";
		}
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
			json = "{\"success\":false,\"msg\":\"提交个人信息失败!\"}";
		}
		return null;
	}

	/**
	 *  添加戒毒人員拍照信息
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("uploadImage")
	public String uploadImage(HttpServletRequest request,HttpServletResponse response,
			@RequestParam MultipartFile file) {
		response.setCharacterEncoding("utf-8");
		String SAVEPATH = "image_space";
		String json = "";
		// 定义图片类型后缀,只允许上传此类型的图片
		String[] IMGTYPE = new String[] { "png", "jpg", "jpeg", "gif" };
		try {
			if (file.isEmpty()) {
				json = ajaxDoneError().toString();
			}
			ModelAndView view = FileUtils.validateFile(file, 1024L * 1024 * 10,
					IMGTYPE, null);
			if (view != null)
				json = view.toString(); 
			String userId = request.getParameter("userId");
			String trueName = request.getParameter("trueName"); 

			String longitude = StringUtil.trim(request.getParameter("longitude"));
			String latitude = StringUtil.trim(request.getParameter("latitude"));
			SyUsers user=service.get(SyUsers.class, userId);
			JdPzxx jd = new JdPzxx();
			jd.setPzryxm(trueName);
			jd.setPzry(userId);
			jd.setLan(latitude);
			jd.setLng(longitude);
			if(user!=null)
				jd.setDeptId(user.getDeptId());
			jdPzxxService.addImg(jd, SAVEPATH, file);
			
			json = "{\"success\":true,\"msg\":\"上传拍照图片成功!\"}";
			response.getWriter().println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json = "{\"success\":false,\"msg\":\"上传拍照图片失败!\"}";
			try {
				response.getWriter().println(json);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
 
	/**
	 * 添加戒毒人員请假信息
	 * 
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("qjsq")
	public String qjsq(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String qjryid= StringUtil.trim(request.getParameter("qjryid"));
		String qjryxm=StringUtil.trim(request.getParameter("qjryxm"));
		String  qjkssj=StringUtil.trim(request.getParameter("qjkssj"));
		String qjjssj=StringUtil.trim(request.getParameter("qjjssj"));
		String qjnr=StringUtil.trim(request.getParameter("qjnr"));
		String cgbz=StringUtil.trim(request.getParameter("cgbz"));
		String spzt=StringUtil.trim(request.getParameter("spzt"));
		String gxbmid=StringUtil.trim(request.getParameter("gxbmid"));
		String xjsj=StringUtil.trim(request.getParameter("xjsj"));
		String xjbz=StringUtil.trim(request.getParameter("xjbz")); 
		String qjlb=StringUtil.trim(request.getParameter("qjlb"));
		String json=""; 
		JdQj jq=new JdQj(qjryid, qjryxm, qjkssj, qjjssj, qjnr, cgbz, spzt, gxbmid, xjsj, xjbz,qjlb);
		try {
			boolean fla = service.save(jq);

			if (fla) {
				json = "{\"success\":true,\"msg\":\"提交人员请假信息成功!\"}";
			} else {
				json = "{\"success\":false,\"msg\":\"提交人员请假信息失败!\"}";
			}
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 我的请假列表
	 * @param response
	 * @param file
	 * @return
	 */ 
	@RequestMapping("qjlb")
	public String lb(HttpServletRequest request ,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String qjryid=StringUtil.trim(request.getParameter("qjryid"));  
		List<JdQj> tzsList=qjService.selectWdQjLb(qjryid); 
		String json=ajaxJson(tzsList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 我的请假信息查看
	 * @param response
	 * @param file
	 * @return
	 */ 
	@RequestMapping("qjck")
	public String qjck(HttpServletRequest request ,HttpServletResponse response) {
	 
		String qjid=StringUtil.trim(request.getParameter("qjid"));  
		JdQj jdqj =qjService.get(JdQj.class, qjid); 
		String json=ajaxJson(jdqj).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 生活求助
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("UpLoadjqshqz")
	public String uploadjdshqz(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String qzbt= StringUtil.trim(request.getParameter("qzbt"));
		String qznr=StringUtil.trim(request.getParameter("qznr"));
		String  qzryid=StringUtil.trim(request.getParameter("qzryid"));
		String qzryxm=StringUtil.trim(request.getParameter("qzryxm"));/*
		String qzsj=StringUtil.trim(request.getParameter("qjsj"));*/
		Timestamp  qzsj=DateUtil.getCurrentTimeStamp();
		String gxbmid=StringUtil.trim(request.getParameter("gxbmid"));
		String jssj=null;
		String jsryxm=StringUtil.trim(request.getParameter("jsryxm"));
		String hfnr=StringUtil.trim(request.getParameter("hfnr"));
		String hfsj=null;//StringUtil.trim(request.getParameter("hfsj"));
		String hfbz=StringUtil.trim(request.getParameter("hfbz")); 
		String hfrxm=StringUtil.trim(request.getParameter("hfrxm"));
		String json="";
		JdShqz js=new JdShqz(qzbt, qznr, qzryid, qzryxm, qzsj, gxbmid, jssj, jsryxm, hfnr, hfsj, hfbz, hfrxm);
		js.setYdzt("0");
		try {
			boolean fla = service.save(js);

			if (fla) {
				json = "{\"success\":true,\"msg\":\"提交生活求助信息成功!\"}";
			} else {
				json = "{\"success\":false,\"msg\":\"提交生活求助信息失败!\"}";
			}
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 思想汇报
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("UpLoadsxhb")
	public String uploadjdsxhb(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String hbbt= StringUtil.trim(request.getParameter("hbbt"));
		String hbnr=StringUtil.trim(request.getParameter("hbnr"));
		Timestamp  hbsj=DateUtil.getCurrentTimeStamp();
		String hbryid=StringUtil.trim(request.getParameter("hbryid"));
		String hbryxm=StringUtil.trim(request.getParameter("hbryxm"));
		String hbbz=StringUtil.trim(request.getParameter("hbbz"));
		String gxbmid=StringUtil.trim(request.getParameter("gxbmid"));
		String json="";
		JdSxhb js=new JdSxhb(hbbt, hbnr, hbsj, hbryid, hbryxm, hbbz, gxbmid);
		js.setYdzt("0");
		try {
			boolean fla = service1.save(js);

			if (fla) {
				json = "{\"success\":true,\"msg\":\"提交思想汇报信息成功!\"}";
			} else {
				json = "{\"success\":false,\"msg\":\"提交思想汇报信息失败!\"}";
			}
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * 通知书阅读
	 * @param response
	 * @param file
	 * @return
	 */
	 @RequestMapping("tzsck")
	public String tzsck(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String tzsid=StringUtil.trim(request.getParameter("tzsid"));  
		JdTzs tzs=tzsService.get(JdTzs.class, tzsid); 
		tzs.setTzsydzt("1");
		tzs.setTzsjssj(DateUtil.getCurrentTimeStamp()); 
		tzsService.updateTzs(tzs); 
		String json=ajaxJson(tzs).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 通知书回复
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("tzshf")
	public String tzshf(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String tzsid=StringUtil.trim(request.getParameter("tzsid")); 
		String tzshfnr=StringUtil.trim(request.getParameter("tzshfnr")); 
		JdTzs tzs=tzsService.get(JdTzs.class, tzsid);
			tzs.setTzsydzt("1");
			tzs.setTzsjssj(DateUtil.getCurrentTimeStamp());
		tzs.setTzshfnr(tzshfnr);
		tzs.setTzshfbz("1");
		tzs.setTzshfsj(DateUtil.currentTimestamp().toString());  
		tzsService.updateTzs(tzs);
		String json = "{\"success\":true,\"msg\":\"提交通知书回复信息成功!\"}";
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 我的通知书列表
	 * @param response
	 * @param file
	 * @return
	 */ 
	@RequestMapping("tzslb")
	public String tzslb(HttpServletRequest request ,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String userid=StringUtil.trim(request.getParameter("userid")); 
		String tzsstr="";
		String hql="  from JdTzs where tzsjsrid='"+userid+"'";
		List<JdTzs> tzsList=tzsService.selectTzsList(hql); 
		
		String hql1=" select count(*) from JdTzs where tzsjsrid='"+userid+"' and tzsydzt='0'";
		String count=tzsService.countTzs(hql1).toString(); 

		for(int i=0;i<tzsList.size();i++){
			JdTzs tzs=tzsList.get(i);  
		       String tzsydzt=tzs.getTzsydzt();//阅读状态
		       if(tzsydzt==null)tzsydzt="0";
		       String tzshfbz=tzs.getTzshfbz();//回复标志
		       if(tzshfbz==null)tzshfbz="0";
		       String tzsnr=tzs.getTzsnr();//通知书内容  
		       if(tzsnr==null)tzsnr="0";
		       String tzshfnr=tzs.getTzshfnr();//通知书回复内容 
		       if(tzshfnr==null)tzshfnr="0";
		       String tzszt=tzs.getTzszt();//回复状态
		       if(tzszt==null)tzszt="0";
		       String gxbmid=tzs.getGxbmid();//管辖部门
		       if(gxbmid==null)gxbmid="0"; 
		       String tzshfsj="";
		      // Timestamp tszhfsj1=tzs.getTzshfsj();,,
		       String tzsxfsj = tzs.getTzsxfsj();
		       
			tzsstr+="{\"id\":\""+tzs.getId()+"\",\"tzsmc\":\""+tzs.getTzsmc()+"\",\"tzsxfsj\":\""+tzs.getTzsxfsj()+"\",\"tzsnr\":\""+tzs.getTzsnr()+"\",\"tzsjsrxm\":\""+tzs.getTzsjsrxm()+"\",\"tzsydzt\":\""+tzsydzt+"\",\"tzshfsj\":\""+tzshfsj+"\",\"tzshfbz\":\""+tzshfbz+"\",\"tzszt\":\""+count+"\",\"gxbmid\":\""+gxbmid+"\"}";
			if(i>=0&&i<tzsList.size()-1)
				tzsstr=tzsstr+",";
		}
		tzsstr="["+tzsstr+"]";
		String json=tzsstr;//ajaxJson(tzsList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	*越级上报信息
	*@param response
	*@param file
	*@return
	*/
	@RequestMapping("Yjsb")
	public String Yjsb(HttpServletRequest request ,HttpServletResponse response) {
	 
		String userid=StringUtil.trim(request.getParameter("userid")); 
		String jbryxm=StringUtil.trim(request.getParameter("jbryxm"));
		String gxbmid=StringUtil.trim(request.getParameter("gxbmid")); 
		String jbnr=StringUtil.trim(request.getParameter("jbnr")); 
		 
		try { 
			JdYjsb obj=new JdYjsb();
			obj.setGxbmid(gxbmid);
			obj.setJbryid(userid); 
			obj.setJbryxm(jbryxm);
			obj.setJbsj(DateUtil.currentDateTimeToString());
			obj.setJbnr(jbnr);
			boolean flag=yjsbService.save(obj); 
		    String msg="上报成功！";
			String json="{\"success\":"+flag+",\"msg\":\""+msg+"\"}"; 
			response.getWriter().println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String json="{\"success\":false,\"msg\":\"上传失败\"}"; 
			try {
				response.getWriter().println(json);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 
	 * 个人信息
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("grxx") 
	public String grxx(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String ryid=StringUtil.trim(request.getParameter("ryid"));  
		try { 
			JdRyb ryb=jdService.selectUserByUserid(ryid);  
			System.out.println("ryb="+ryb); 
			String json="{\"id\":\""+ryb.getId()+"\",\"jdRyid\":\""+ryb.getJdRyid()+"\",\"jdRyxm\":\""+ryb.getJdRyxm()+"\",\"fkDeptId\":\""+ryb.getFkDeptId()+"\",\"jdrybh\":\""+ryb.getJdRybh()
					+"\",\"jdRysg\":\""+ryb.getJdRysg()+"\",\"jdRyxb\":\""+ryb.getJdRyxb()+"\",\"jdJgry\":\""+ryb.getJdJgry()+"\",\"jdDwdh\":\""+ryb.getJdDwdh()+"\",\"jdRyjg\":\""+ryb.getJdRyjg()+"\",\"jdHjd\":\""+ryb.getJdHjd()+"\",\"jdHjxxdz\":\""+ryb.getJdHjxxdz()+"\",\"jdHjdpcs\":\""+ryb.getJdHjdpcs()+"\",\"jdHklx\":\""+ryb.getJdHklx()+"\",\"jdHyzk\":\""+ryb.getJdHyzk()+"\",\"jdWhcd\":\""+ryb.getJdWhcd()+"\",\"jdJzd\":\""+ryb.getJdJzd()+"\",\"jdJzdpcs\":\""+ryb.getJdJzdpcs()+"\",\"jdMz\":\""+ryb.getJdMz()+"\",\"jdZjxy\":\""+ryb.getJdZjxy()+"\",jdZjzl:\""+ryb.getJdZjzl()+"\",\"jdSfzh\":\""+ryb.getJdSfzh()+"\",\"jdCsrq\":\""+ryb.getJdCsrq()+"\",\"jdCym\":\""+ryb.getJdCym()+"\",\"jdHjdz\":\""+ryb.getJdHjd()+"\",\"jdZzmm\":\""+ryb.getJdZzmm()+"\",\"jdZy\":\""+ryb.getJdZy()+"\",\"jdTscs\":\""+ryb.getJdTscs()+"\",\"jdLydpzl\":\""+ryb.getJdLydpzl()+"\"}";
			response.getWriter().println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.getWriter().println("{}");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	} 

	/**
	*越级上报列表接口
	*@param response
	*@param file
	*@return
	*/
	@RequestMapping("Yjsblb")
	public String Yjsblb(HttpServletRequest request ,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String userid=StringUtil.trim(request.getParameter("userid")); 
		String hql="from JdYjsb where jbryid='"+userid+"'";
		List<JdYjsb> yjsbList=yjsbService.selectYjsbList(hql);
		String json=ajaxJson(yjsbList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	*生活求助列表接口
	*@param response
	*@param file
	*@return
	*/
	@RequestMapping("Shqzlb")
	public String Shqzlb(HttpServletRequest request ,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String userid=StringUtil.trim(request.getParameter("userid")); 
		String hql="from JdShqz where qzryid='"+userid+"'";
		List<JdShqz> yjsbList=shqzService.selectShqzList(hql);
		String json=ajaxJson(yjsbList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	*思想汇报列表接口
	*@param response
	*@param file
	*@return
	*/
	@RequestMapping("Sxhblb")
	public String Sxhblb(HttpServletRequest request ,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String userid=StringUtil.trim(request.getParameter("userid")); 
		String hql="from JdSxhb where hbryid='"+userid+"'";
		List<JdSxhb> yjsbList=sxhbService.selectSxhbList(hql);
		String json=ajaxJson(yjsbList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 戒毒宣传接口
	 *@param response
	 *@param file
	 *@return
	 * */
	@RequestMapping("Jdxc")
	public String Jdxc(HttpServletRequest request ,HttpServletResponse response) {
	 	response.setCharacterEncoding("utf-8");  
		String bmid=StringUtil.trim(request.getParameter("bmid"));  
		String deptIds="'0'";
		String orgId=""; 
		SyDept dept=deptService.get(SyDept.class, bmid); 
		if(dept!=null){
			orgId=dept.getOrgId();   
			deptIds="'"+orgId+"',"+loginService.getDeptIds(bmid, orgId);
		}
		String hql="from JdXc order by fbsj desc";//where bmid in("+deptIds+")
		List<JdXc> JdxcList=jdxcService.selectJdxcList(hql);
		String json=ajaxJson(JdxcList).getModelMap().get("msginfo").toString();
		try { 
			json=json.replace("'", "'");
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 法律法规接口
	 *@param response
	 *@param file
	 *@return
	 * */
	@RequestMapping("Jdflfg")
	public String Jdflfg(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8"); 
		String bmid=StringUtil.trim(request.getParameter("bmid"));  
		String deptIds="'0'";
		String orgId=""; 
		SyDept dept=deptService.get(SyDept.class, bmid); 
		if(dept!=null){
			orgId=dept.getOrgId();   
			deptIds="'"+orgId+"',"+loginService.getDeptIds(bmid, orgId);
		}
		String hql="from JdFlfg order by fbsj desc "; //where bmid in("+deptIds+")
		List<JdFlfg> JdFlfgList=JdflfgService.selectJdflfgList(hql);
		String json=ajaxJson(JdFlfgList).getModelMap().get("msginfo").toString();
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 

/**
 * 
 * 法律法规查看接口
 * @param response
 * @param file
 * @return
 */
@RequestMapping("flfgck")
public String flfgck(HttpServletRequest request,HttpServletResponse response) {
	response.setCharacterEncoding("utf-8"); 
	String id=StringUtil.trim(request.getParameter("id"));  
	JdFlfg flfg=JdflfgService.get(JdFlfg.class, id); 
	String json=ajaxJson(flfg).getModelMap().get("msginfo").toString();
	json=json.replace("'", "'");
	try { 
		response.getWriter().println(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 
 * 戒毒宣传查看接口
 * @param response
 * @param file
 * @return
 */
@RequestMapping("jdxcck")
public String jdxcck(HttpServletRequest request,HttpServletResponse response) {
	response.setCharacterEncoding("utf-8"); 
	String id=StringUtil.trim(request.getParameter("id"));  
	JdXc xc=jdxcService.get(JdXc.class, id); 
	String json=ajaxJson(xc).getModelMap().get("msginfo").toString();
	try { 
		response.getWriter().println(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 请假审批接口
 * @param response
 * @param file
 * @return
 * 
 * */
@RequestMapping("qjsp")
public String qjsp(HttpServletRequest request,HttpServletResponse response) {
	response.setCharacterEncoding("utf-8"); 
	String id=StringUtil.trim(request.getParameter("id"));  
	JdQj jdqj=qjService.get(JdQj.class, id); 
	jdqj.setSpzt("1");
	qjService.updateSp(jdqj);
	String json = "{\"success\":true,\"msg\":\"请假申请审批成功!\"}";
	try { 
		response.getWriter().println(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 请假销假接口
 *  @param response
 * @param file
 * @return
 * 
 * */
@RequestMapping("qjxj")
public String qjxj(HttpServletRequest request,HttpServletResponse response) {
	response.setCharacterEncoding("utf-8"); 
	String id=StringUtil.trim(request.getParameter("id"));  
	JdQj jdqj=qjService.get(JdQj.class, id); 
	Timestamp time=DateUtil.currentTimestamp();
	jdqj.setXjsj(DateUtil.currentDateToString());
	jdqj.setXjbz("1");
	qjService.updateXj(jdqj);
	String json = "{\"success\":true,\"msg\":\"已销假!\"}";
	try { 
		response.getWriter().println(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 生活求助回复接口
 *  @param response
 * @param file
 * @return
 * 
 * */
@RequestMapping("shqzhf")
public String shqzhf(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8"); 
		String id=StringUtil.trim(request.getParameter("id")); 
		String hfnr=StringUtil.trim(request.getParameter("hfnr")); 
		JdShqz shqz=shqzService.get(JdShqz.class, id);
		if(shqz.getYdzt()==null||shqz.getYdzt().equals("0")){
			shqz.setYdzt("1");
			shqz.setHfsj(DateUtil.currentTimestamp().toString());
		}
		shqz.setHfnr(hfnr);
		shqz.setHfbz("1");
		shqz.setHfsj(DateUtil.currentTimestamp().toString());  
		shqzService.update(shqz);
		String json = "{\"success\":true,\"msg\":\"生活求助回复信息成功!\"}";
		try { 
			response.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	


}