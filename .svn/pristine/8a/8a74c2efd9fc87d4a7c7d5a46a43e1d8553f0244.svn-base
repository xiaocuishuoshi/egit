package com.whfp.oa.manager.jd.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whfp.oa.commons.base.BaseAction;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdBfqk;
import com.whfp.oa.manager.jd.bean.JdKfjc;
import com.whfp.oa.manager.jd.bean.JdRyb;
import com.whfp.oa.manager.jd.bean.JdXdrypg;
import com.whfp.oa.manager.jd.service.WghService;

@Controller
@RequestMapping("wgh")
public class WghAction extends BaseAction {

	@Autowired
	private WghService wghService;
	
	/**
	 * 查看网格化人员详情
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("show")
	public String show(String id,ModelMap map) {
		JdRyb ryb = wghService.get(JdRyb.class, id);
		
		try {
			JdKfjc kfjc=wghService.get(JdKfjc.class, wghService.selectKfjc(id).get(0));
			 map.addAttribute("kfjc",kfjc);
		} catch (Exception e) {
		}
		
		try {
			JdBfqk bfqk=wghService.get(JdBfqk.class, wghService.selectBfqk(id).get(0));
			map.addAttribute("bfqk",bfqk);
		} catch (Exception e) {}
		
		 try {
			 JdXdrypg pg=wghService.get(JdXdrypg.class, wghService.selectXdpg(id).get(0));
			 map.addAttribute("xdpg",pg);
		} catch (Exception e) {}
		 
		map.addAttribute("jd",ryb);
		return "jdpage/wghgl/show";
	}
	
	
	@RequestMapping("load")
	public String load(String xh,String sssq,ModelMap map) {
		map.addAttribute("xh", xh);
		map.addAttribute("sssq", sssq);
		return "jdpage/wghgl/load";
	}

	/**
	 * 条件分页查询用户
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView selectUsers(PageParam param, JdRyb jd) {
		return ajaxJsonEscape(wghService.selectRyb(param, jd));
	}
	
	
	
	/*------------------龙池办事处------------------------*/
	//园林社区
	@RequestMapping("load2")
	public String load2(){
		return "jdpage/wghgl/pic-2";
	}
	
	//城西社区
	@RequestMapping("load3")
	public String load3(){
		return "jdpage/wghgl/pic-3";
	}
	
	//西畈社区
	@RequestMapping("load4")
	public String load4(){
		return "jdpage/wghgl/pic-20";
	}
	
	//龙池桥社区
	@RequestMapping("load5")
	public String load5(){
		return "jdpage/wghgl/pic-5";
	}
	//松鹤社区
	@RequestMapping("load1")
	public String load1(){
		return "jdpage/wghgl/pic-19";
	}
	//宋家河社区
	@RequestMapping("load6")
	public String load6(){
		return "jdpage/wghgl/pic-18";
	}
	//黄狮岗社区
	@RequestMapping("load7")
	public String load7(){
		return "jdpage/wghgl/pic-17";
	}
	//七里桥村
	@RequestMapping("load8")
	public String load8(){
		return "jdpage/wghgl/pic-16";
	}
	//红石堰村
	@RequestMapping("load9")
	public String load9(){
		return "jdpage/wghgl/pic-6";
	}
	//白塔河社区
	@RequestMapping("load10")
	public String load10(){
		return "jdpage/wghgl/pic-15";
	}
	
	
	
	/*------------------鼓楼办事处------------------------*/
	
	//京广社区
	@RequestMapping("load11")
	public String load11(){
		return "jdpage/wghgl/pic-1";
	}
	//凉亭社区
	@RequestMapping("load12")
	public String load12(){
		return "jdpage/wghgl/pic-11";
	}
	//孝感乡社区
	@RequestMapping("load13")
	public String load13(){
		return "jdpage/wghgl/pic-12";
	}
	//小河头社区
	@RequestMapping("load14")
	public String load14(){
		return "jdpage/wghgl/pic-13";
	}
	//朝圣门社区
	@RequestMapping("load15")
	public String load15(){
		return "jdpage/wghgl/pic-7";
	}
	//杜鹃社区
	@RequestMapping("load16")
	public String load16(){
		return "jdpage/wghgl/pic-4";
	}
	//杨基塘社区
	@RequestMapping("load17")
	public String load17(){
		return "jdpage/wghgl/pic-10";
	}
	//枫树村
	@RequestMapping("load18")
	public String load18(){
		return "jdpage/wghgl/pic-14";
	}
	//桃园社区
	@RequestMapping("load19")
	public String load19(){
		return "jdpage/wghgl/pic-9";
	}
	//鼓楼社区
	@RequestMapping("load20")
	public String load20(){
		return "jdpage/wghgl/pic-8";
	}
	
	
	
	
	/*------------------开发区------------------------*/
	
	//兴发村
	@RequestMapping("load21")
	public String load21(){
		return "jdpage/wghgl/pic-21";
	}
	
	//鼎长岗
	@RequestMapping("load22")
	public String load22(){
		return "jdpage/wghgl/pic-22";
	}
	
	//陡坡山
	@RequestMapping("load23")
	public String load23(){
		return "jdpage/wghgl/pic-23";
	}
	
	//谌家园村
	@RequestMapping("load24")
	public String load24(){
		return "jdpage/wghgl/pic-24";
	}
	
	//红叶村
	@RequestMapping("load25")
	public String load25() {
		return "jdpage/wghgl/pic-25";
	}

	//黄金桥
	@RequestMapping("load26")
	public String load26() {
		return "jdpage/wghgl/pic-26";
	}
}
