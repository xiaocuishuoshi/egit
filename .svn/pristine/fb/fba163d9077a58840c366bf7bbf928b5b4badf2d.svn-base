package com.whfp.oa.manager.jd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.manager.jd.service.CountService;
import com.whfp.oa.manager.system.bean.SyDept;

/**
 * 报表统计分析
 * @author LCL
 *
 */
@Controller
@RequestMapping("tjfx")
public class CountAction extends BaseAction {

	@Autowired
	private CountService service;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	
	/**
	 * 毒品种类数据分析
	 * @param time
	 * @param map
	 * @return
	 */
	@RequestMapping("zltj")
	public String loadsz(String time,ModelMap map) {
		/*try {
			if (time == null) {
				Date date = new Date();// 获得系统当前年份
				DateFormat format = new SimpleDateFormat("yyyy");
				String ti = format.format(date);
				time = ti;
			}
		} catch (Exception e) {
		}*/
		
		Member me=(Member) session.getAttribute("minfo");
		map.addAttribute("desc",service.get(SyDept.class,me.getDeptId()).getDeptDesc());//当前账号地区信息
		
		List<Object[]> list=service.LoadBar(time);
		List<String> sj=service.LoadTime();
		Object[] zs=new Object[list.size()];
		Object[] mc=new Object[list.size()];	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[1]==null) {
				mc[i]="其他";
				zs[i]= list.get(i)[0];
			}else {
				zs[i]= list.get(i)[0];
				mc[i]= list.get(i)[1];
			}
			
		}
		request.setAttribute("sj",time);
		request.setAttribute("date",sj);
		request.setAttribute("list",list);
		request.setAttribute("zs",JSON.toJSONString(zs));
		request.setAttribute("mc",JSON.toJSONString(mc));
		
		
		List<Object[]> line=service.LoadLine();
		Object[] nf=new Object[line.size()];
		Object[] sl=new Object[line.size()];
		for (int j = 0; j < line.size(); j++) {
			if (line.get(j)[0]==null || line.get(j)[0].equals("")) {
				nf[j]="其他";
				sl[j]=line.get(j)[1];
			}else {
				nf[j]=line.get(j)[0];
				sl[j]=line.get(j)[1];
			}
			
		}
		request.setAttribute("nf",JSON.toJSONString(nf));
		request.setAttribute("sl",JSON.toJSONString(sl));
		return "jdpage/tjfx/zltj";
	}
	
	
	
	
	
	/**
	 * 吸毒人员类型数据分析
	 * @param time
	 * @param map
	 * @return
	 */
	@RequestMapping("ryzl")
	public String loadryzl(String time,ModelMap map) {

		Member me=(Member) session.getAttribute("minfo");
		map.addAttribute("desc",service.get(SyDept.class,me.getDeptId()).getDeptDesc());//当前账号地区信息
		
		List<Object[]> list=service.LoadLineLx(time);
		List<String> sj=service.LoadTime();

		Object[] sl=new Object[list.size()];
		Object[] lx=new Object[list.size()];	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0]==null) {
				lx[i]="未设置";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(1)) {
				lx[i]="药物替代治疗人员";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(2)) {
				lx[i]="社区戒毒人员";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(3)) {
				lx[i]="社区康复人员";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(4)) {
				lx[i]="戒断三年未复吸人员";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(5)) {
				lx[i]="其他";
				sl[i]= list.get(i)[1];
			}else if (list.get(i)[0].equals(6)) {
				lx[i]="戒毒期满出所人员";
				sl[i]= list.get(i)[1];
			}
			
		}
		request.setAttribute("sj",time);
		request.setAttribute("date",sj);
		request.setAttribute("sl",JSON.toJSONString(sl));
		request.setAttribute("lx",JSON.toJSONString(lx));
		
		return "jdpage/tjfx/ryzl";
	}
}
