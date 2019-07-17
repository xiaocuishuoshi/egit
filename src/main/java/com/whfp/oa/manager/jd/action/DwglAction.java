package com.whfp.oa.manager.jd.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdWzxx;
import com.whfp.oa.manager.jd.service.IDwglService;
import com.whfp.oa.manager.jd.service.IJdService;
import com.whfp.oa.manager.jd.service.IJdWzxxService;
import com.whfp.oa.manager.system.bean.SyDept;

@Controller
@RequestMapping("/dwgl")
public class DwglAction extends BaseAction{
	   
	@Autowired
	private IDwglService service;
	
	@Autowired
	private IJdService jdservice;
	@Autowired
	private IJdWzxxService jdWzservice;
	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequiresPermissions("dwgl:read")
	@RequestMapping("load")
	public String load(){
		return "jdpage/dwgl/load";
	}
	
	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequiresPermissions("dwgl:read")
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param,JdRyb jd){ 
		
		return ajaxJsonEscape(service.selectWzxx(param, jd));
		
	}
	/**
	 * 电子围栏设置页面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequiresPermissions("dwgl:fence")
	@RequestMapping("fencePage")
	public String fencePage(HttpServletRequest request,String id,ModelMap map){ 
		JdRyb user=service.get(JdRyb.class, id);  
		if(user==null){
			return NODATA;
		} 
		SyDept dept=service.get(SyDept.class, user.getFkDeptId());
		map.addAttribute("jd",user);
		 String deptName=""; 
		if(dept!=null&&user.getJdDqgkdq()==null)
			deptName=dept.getDeptDesc();
		else
			deptName=user.getJdDqgkdq();
		 request.getSession().setAttribute("deptName", deptName);
		return "jdpage/dwgl/fence";
	}
	/**
	 * 保存电子围栏
	 * @param dept
	 * @return
	 */
	@RequiresPermissions("dwgl:updateFence")
	@RequestMapping("updateFence")
	public ModelAndView updateFence(String id,String jdHdqy,String jdDqgkdq){ 
		System.out.println(id+"jdhdqy="+jdHdqy);
		if(jdHdqy==null||jdHdqy.equals(""))
			jdHdqy="{}";
		JdRyb user=service.get(JdRyb.class, id);
		
		user.setJdHdqy(jdHdqy);
		user.setJdDqgkdq(jdDqgkdq);
		return ajaxDone(jdservice.updateUser(user)); 
	}
 
	/**
	 * 运行轨迹查看
	 * @return
	 */
	@RequiresPermissions("dwgl:running")
	@RequestMapping("running")
	public String running(HttpServletRequest request,String[] ids,ModelMap map){
		Map  listAll=new HashMap();
		Map posMap=new HashMap();
		Map deptMap=new HashMap();
		String cond="";
		String kssj=request.getParameter("kssj"); 
		String jssj=request.getParameter("jssj");
		String a=request.getParameter("a");
		if(kssj==null&&jssj==null)
			cond="";// and createTime>='"+DateUtil.currentDateToString()+"'
		else{
			if(!kssj.equals(""))
				cond+=" and createTime>='"+kssj+" 00:00:00'   ";
			if(!jssj.equals(""))
				cond+=" and createTime<='"+jssj+" 23:59:59'  ";
		 
		}
		String deptid="";
		String area[]={};
		String areas="0,";
		List<Object> c = new ArrayList<Object>();
		int r=0;
		int cnt=0;
		String dqgkdq="";
		for (String id : ids) { 
			JdRyb user=jdservice.selectUser(id); 
		    List<JdWzxx> list=	jdWzservice.selectWzxxByRysj(user.getJdRyid(),cond);   
		    listAll.put(r,list);
		    deptid=user.getFkDeptId();
		    posMap.put("user_pos"+r, user); 
			SyDept dept=service.get(SyDept.class, deptid); 
			if(areas.indexOf(","+deptid+",")<0){
			   deptMap.put(cnt, user.getJdDqgkdq());
			   cnt++;
			}
			areas=areas+deptid+",";
			dqgkdq=user.getJdDqgkdq();
			System.out.println("deptname="+dept.getDeptName());
		    r++;
		}  
	    request.getSession().setAttribute("area", deptMap);
		request.getSession().setAttribute("user_pos", posMap); 
		request.getSession().setAttribute("wzxx", listAll);
		request.getSession().setAttribute("dqgkdq", dqgkdq);
		request.setAttribute("a", a);
		request.setAttribute("ids", ids);
		map.addAttribute("wzxx",listAll); 
		return "jdpage/dwgl/running";
	} 
	
}
