package com.whfp.oa.manager.hlkj.sbgl.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbgl;
import com.whfp.oa.manager.hlkj.sbgl.service.ISbglService;
import com.whfp.oa.manager.hlkj.system.bean.HlkjTpt;
import com.whfp.oa.manager.hlkj.system.service.IHlkjAddress;

@Controller
@RequestMapping("/hlkj/sbgl")
public class SbglAction extends BaseAction {
	@Autowired
	private ISbglService service;
	
	@Autowired
	private IHlkjAddress serviceA;
	
	@RequiresPermissions("hlkj/sbgl:load")
	@RequestMapping("load")
	public String load(ModelMap map,String lm){
		List list = service.getAddress(lm);
		map.addAttribute("lm", lm);
		map.addAttribute("qq", list);
		if(lm.equals("ddgl")){
			
			
			return "hlkj/sbgl/ddgl";
		}
		if(lm.equals("ktgl")){
			
			return "hlkj/sbgl/ktgl";
		}
		
		return "hlkj/sbgl/load";
	}
	
	
	
	
	
	@RequiresPermissions("hlkj/sbgl:loaddd")
	@RequestMapping(value = "loaddd")
	public String loaddd(ModelMap map,String op) {
		String urls = "";
		System.out.println("op*************="+op);
		if(op.equals("on")){
			urls="http://ibmsdhs.net4iot.com/api/v1/552358/0A/00";
		}else if(op.equals("off")){
			urls="http://ibmsdhs.net4iot.com/api/v1/552358/05/00";
		}else{
			urls="http://ibmsdhs.net4iot.com/api/v1/552358/0A/00";
		}
		 StringBuilder json = new StringBuilder();
	        try {
	            URL oracle = new URL(urls);
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(
	                                        yc.getInputStream()));
	            String inputLine = null;
	            while ( (inputLine = in.readLine()) != null) {
	                json.append(inputLine);
	            }
	            in.close();
	        } catch (MalformedURLException e) {
	        } catch (IOException e) {
	        }
	        try {
				URLDecoder.decode(json.toString(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        JSON.parse(json.toString());
	        Map m =  (Map)JSON.parse(json.toString());
	     
	        
	        System.out.println("***********="+json.toString()+"*************code="+m.get("code")+"**************message="+m.get("message"));
	        String code =  m.get("code").toString();
	        String msg = m.get("message").toString();
	        msg = msg.substring(0,msg.indexOf(":"));
	        System.out.println("*****msg="+msg);
	       
	        map.addAttribute("code", code);
	        map.addAttribute("msg", msg);
	        
		return "hlkj/sbgl/ddgl";
	}
	
	
	
	/**
	 * 去设备绑定地址列表
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:toquerySin")
	@RequestMapping("toquerySin")
	public String toquerySin(){
		return "hlkj/address/tosb/list";
	}
	
	/**
	 * 设备绑定列表
	 * @param param
	 * @param q
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:toquerySbin")
	@RequestMapping("toquerySbin")
	public ModelAndView toquerySbin(PageParam param,HlkjSbgl q){
		return ajaxJsonEscape(service.selectSbglSin(param, q));
	}
	
	
	@RequiresPermissions("hlkj/sbgl:query")
	@RequestMapping("query")
	public ModelAndView querySbDz(ModelMap map,String lm){
		return ajaxJsonEscape(service.selectAddressByLmMap(lm));
	}
	
	
	/**
	 * 按照地址查询每个设备当前状态
	 * @param param
	 * @param q
	 * @param pathimg
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:querylist")
	@RequestMapping("querylist")
	public ModelAndView query(PageParam param,HlkjSbgl q,String pathimg){
		if(q.getAddressid()!=null &&!"".equals(q.getAddressid())){
			HlkjTpt tpt = serviceA.selectTptByAdd(q.getAddressid());
			String savep = serviceA.selectImgById(tpt.getTpBackId()).getSavePath();
			pathimg = savep;
			System.out.println("***************"+savep);
		}
		
		return ajaxJsonEscape(service.selectSbgl(param, q));
	}
	
	
	/**
	 * 跳转到视图列表
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:queryDetile")
	@RequestMapping("queryDetile")
	public String queryDetile(){
		return "hlkj/sbgl/SbTpt";
	}
	
	
	/**
	 * 跳转到查询流水
	 * @param param
	 * @param q
	 * @param pathimg
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:querySbList")
	@RequestMapping("querySbList")
	public String querySbList(PageParam param,ModelMap map,HlkjSbgl q,String lm,String addressid){
		map.addAttribute("lm", lm);
		map.addAttribute("addrssid", addressid);
		return "hlkj/sbgl/query_allSb";
	}
	
	/**
	 * 查询设备所有流水状态列表
	 * @param param
	 * @param q
	 * @param pathimg
	 * @return
	 */
	@RequiresPermissions("hlkj/sbgl:queryAlllist")
	@RequestMapping("queryAlllist")
	public ModelAndView queryAlllist(PageParam param,HlkjSbgl q,String lm,String addressid){
		if(lm!=null&&!"".equals(lm)){
			q.setSblm(lm);
		}
		if(addressid!=null&&!"".equals(addressid)){
			q.setAddressid(addressid);
		}
		
		return ajaxJsonEscape(service.selectAllSb(param, q));
	}
	
	
	
//	@RequiresPermissions("hlkj/sbgl:querylist")
//	@RequestMapping("querylist")
//	public String query(ModelMap map,HlkjSbgl q,String pathimg){
//		if(q.getAddressid()!=null &&!"".equals(q.getAddressid())){
//			HlkjTpt tpt = serviceA.selectTptByAdd(q.getAddressid());
//			String savep = serviceA.selectImgById(tpt.getTpBackId()).getSavePath();
//			map.put("tpt", tpt);
//			map.put("savep", savep);
//			map.put("pathimg", pathimg);
//			pathimg = savep;
//			System.out.println("***************"+savep);
//		}
//		List<HlkjSbgl> list = service.selectSbgl(q);
//		map.put("list", list);
//		return "hlkj/sbgl/query_sb";
//	}
	
	
}
