package com.whfp.oa.manager.cj.action;

import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.Member;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.commons.util.DateUtil;
import com.whfp.oa.commons.util.ServletUtil;
import com.whfp.oa.manager.cj.bean.CjDetile;
import com.whfp.oa.manager.cj.bean.CjResult;
import com.whfp.oa.manager.cj.service.ICjDetileService;
import com.whfp.oa.manager.cj.service.ICjResultService;
import com.whfp.oa.manager.system.bean.SyUsers;

@Controller
@RequestMapping("/tpcj")
public class CjAction extends BaseAction{
	
	@Autowired
	private ICjDetileService serviceD;
	
	@Autowired
	private ICjResultService serviceR;
	
	/**
	 * 抽奖
	 * @return
	 */
	@RequiresPermissions("tpcj:load")
	@RequestMapping("load")
	public String load(){
		return "tpcj/cj/query";
	}
	
	
	
	
	/**
	 * 用户抽奖列表
	 * @return
	 */
	@RequiresPermissions("tpcj:loadCj")
	@RequestMapping("loadCj")
	public String loadCj(){
		return "tpcj/cj/myCj";
	}
	
	
	/**
	 * 去保存抽奖信息
	 * @return
	 */
	@RequiresPermissions("tpcj:saveTo")
	@RequestMapping("saveTo")
	public String saveTo(){
		return "tpcj/cj/add";
	}
	
	
	@RequiresPermissions("tpcj:querytojl")
	@RequestMapping("querytojl")
	public String querytojl(){
		return "tpcj/cj/queryMyCj";
	}
	
	/**
	 * 抽奖列表逻辑
	 */
	@RequiresPermissions("tpcj:queryJl")
	@RequestMapping("queryJl")
	public ModelAndView queryJl(PageParam param,CjResult q){
		return ajaxJsonEscape(serviceR.selectCjResult(param, q));
	}
	
	
	
	/**
	 * 抽奖列表逻辑
	 */
	@RequiresPermissions("tpcj:query")
	@RequestMapping("query")
	public ModelAndView query(PageParam param,CjDetile q){
		return ajaxJsonEscape(serviceD.selectCjDetile(param, q));
	}
	
	
	
	/**
	 * 抽奖列表逻辑
	 */
	@RequiresPermissions("tpcj:queryCj")
	@RequestMapping("queryCj")
	public ModelAndView queryCj(PageParam param,CjDetile q){
		Member me = ServletUtil.getMember();//获取当前登陆用户id
		q.setCjry(me.getId());
		q.setSfsx("是");
		return ajaxJsonEscape(serviceD.selectCjDetile(param, q));
	}
	
	/**
	 * 新增抽奖
	 * @return
	 */
	@RequiresPermissions("tpcj:save")
	@RequestMapping("save")
	public ModelAndView save(@Valid CjDetile p, Errors errors){
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		p.setCjry(p.getFbry());
		p.setRbrq(DateUtil.currentTimestamp());
		
		
		if(p.getSfsx()==null||"".equals(p.getSfsx())){
			p.setSfsx("否");
		}
		
		System.out.println("==============="+p.getFbry());
		
		String s =p.getFbry();
		int res = 0;
		for(int z=0;z<s.length();z++){
			char c =s.charAt(z);
			if(c==','){
				res+=1;
			}
		}
		p.setYdjsy(p.getYdjrs());
		p.setEdjsy(p.getEdjrs());
		p.setSdjsy(p.getSdjrs());
		p.setQtjsy(p.getQtjrs());
		
		p.setFbrs(res+1);
		return ajaxDone(serviceD.addCjDetile(p));
	}
	
	
	
	
	
	/**
	 * 实现抽奖逻辑并插入数据库
	 * @return
	 */
	@RequiresPermissions("tpcj:tocj")
	@RequestMapping("tocj")
	public ModelAndView tocj(@Valid CjDetile p, Errors errors){
		Member me = ServletUtil.getMember();//获取当前登陆用户id
		SyUsers us = serviceD.get(SyUsers.class, me.getId());
		
		CjDetile qq = serviceD.selectById(p.getId());
		String cjr = "";
		String js= qq.getCjry();
		js = js.replace(us.getId(),"");
		String[] rrr =js.split(",");
		cjr= StringUtils.join(rrr,",");
		System.out.println("!!!!!!!!!!!==="+cjr);
		
		qq.setCjry(cjr);
		
		CjResult res =new CjResult();  //保存抽奖结果表
		res.setCjId(qq.getId()); //获取当前登录用户信息
		res.setUserid(us.getId());
		res.setUsername(us.getTrueName());
		
		
		int totoJ = 0;
		int resul=0;
		int zrs = qq.getFbrs(); //发布总人数
		int ydj = qq.getYdjsy();  //一等奖人数
		int edj = qq.getEdjsy();	//二等奖人数
		int sdj = qq.getSdjsy();	//三等奖人数
		int qtj = qq.getQtjsy();	//其他奖人数
		 totoJ = ydj+edj+sdj+qtj;
		 int [] arr ={};
		 Random ra = new Random();
		if(zrs>totoJ){
			arr =new int[zrs];	//奖池
			int i=0;
			for(;i<ydj;i++){
				arr[i]=1;
			}
			int a=i;
			for(;a<edj+i;a++){
				arr[a]=2;
			}
			int w=a;
			for(;w<sdj+a;w++){
				arr[w]=3;
			}
			int t=w;
			for(;t<qtj+w;t++){
				arr[t]=5;
			}//其他奖项
			int l=t;
			for(;l<zrs-totoJ+l;l++){
				arr[l]=0;
			}
			 int ad = ra.nextInt(arr.length);
			 resul =arr[ad];	 //抽奖结果
		}
		 
		if(zrs<=totoJ){
			arr= new int[totoJ];
			int i=0;
			for(;i<ydj;i++){
				arr[i]=1;
			}
			int a=i;
			for(;a<edj+i;a++){
				arr[a]=2;
			}
			int w=a;
			for(;w<sdj+a;w++){
				arr[w]=3;
			}
			int t=w;
			for(;t<qtj+w;t++){
				arr[t]=5;
			}//其他奖项
			 int ad = ra.nextInt(arr.length);
			 resul =arr[ad];	 //抽奖结果
		}
		for(int xx=0;xx<arr.length;xx++){
				System.out.println("数组为arr="+arr[xx]);
		}
		
		
		
		System.out.println("抽奖值为："+resul);
		
		qq.setFbrs(qq.getFbrs()-1);
		switch (resul) {
		case 1:
			res.setCjJx("一等奖");
			res.setCjJp(qq.getYdjjp());
			qq.setYdjsy(qq.getYdjsy()-1);
			break;
		case 2:
			res.setCjJx("二等奖");
			res.setCjJp(qq.getEdjjp());
			qq.setEdjsy(qq.getEdjsy()-1);
			break;
		case 3:
			res.setCjJx("三等奖");
			res.setCjJp(qq.getSdjjp());
			qq.setSdjsy(qq.getSdjsy()-1);
			break;
		case 5:
			res.setCjJx("其他奖");
			res.setCjJp(qq.getQtjjp());
			qq.setQtjsy(qq.getQtjsy()-1);
			break;
		default:
			res.setCjJx("谢谢参与");
			res.setCjJp("谢谢参与");
			break;
		}
		
		
		
		
		serviceD.updateCjDetile(qq);	//修改基础表
		
		
		return ajaxDone(serviceR.addCjResult(res));	//添加结果表
	}
	
	
	
	
	/**
	 * 抽奖信息
	 * 
	 * @return
	 */
	@RequiresPermissions("tpcj:show")
	@RequestMapping("show")
	public String findshow(String id, ModelMap map) {
		CjDetile qq = serviceD.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "tpcj/cj/show";
	}
	
	
	
	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@RequiresPermissions("tpcj:updateQQ")
	@RequestMapping("updateQQ")
	public String updateQQ(String id, ModelMap map) {
		CjDetile qq = serviceD.selectById(id);
		map.addAttribute("qq", qq);
		if(map.get("qq")==null){
			return NODATA;
		}
		return "tpcj/cj/showupdate";
	}
	
	
	
	
	/**
	 * 修改抽奖信息
	 * 
	 * @param lv
	 * @return
	 */
	@RequiresPermissions("tpcj:update")
	@RequestMapping("update")
	public ModelAndView update(@Valid CjDetile m, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = getValidationMessage(errors);
			if (mav != null)
				return mav;
		}
		//m.setFbsj(DateUtil.string2Timestamp(m.getFbsj().toString()));
		m.setCjry(m.getFbry());
		m.setRbrq(serviceD.selectById(m.getId()).getRbrq());
		m.setYdjsy(serviceD.selectById(m.getId()).getYdjsy());
		m.setEdjsy(serviceD.selectById(m.getId()).getEdjsy());
		m.setSdjsy(serviceD.selectById(m.getId()).getSdjsy());
		m.setQtjsy(serviceD.selectById(m.getId()).getQtjsy());
		return ajaxDone(serviceD.updateCjDetile(m));

	}
	
	//Member me = ServletUtil.getMember();//获取当前登陆用户id
	
	/**
	 * 删除抽奖
	 * @param m
	 * @param errors
	 * @return
	 */
	@RequiresPermissions("tpcj:delete")
	@RequestMapping("delete")
	public ModelAndView delete(String[] ids) {
		return ajaxDone(serviceD.deleteCjDetile(ids));
	}
}
