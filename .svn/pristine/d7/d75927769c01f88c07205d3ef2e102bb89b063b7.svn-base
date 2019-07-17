package com.whfp.oa.manager.hlkj.nxfx.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.whfp.oa.manager.hlkj.nxfx.service.HlkjSbglService;


@Controller
@RequestMapping("/echarts")
public class echartsAction {
	
	@Autowired
	private HlkjSbglService ech;
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 折线图
	 * @param response
	 * @param type
	 * @param t
	 * @param h
	 * @param w
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("echarts:ech")
	@RequestMapping("ech")
	public String ech(HttpServletResponse response,String type,String t,String h,String w,String e) throws Exception{
	
			List<Object[]> list=ech.showHlkjSbgl(type,null);
			
			Object[] objw = new Object[list.size()];//液位传感
			Object[] obje = new Object[list.size()];//电流监控
		
			Object[] objs = new Object[list.size()];//摄氏度
			Object[] objh = new Object[list.size()];//湿度
			Object[] objd = new Object[list.size()];//时间
			

			for (int i = 0; i < list.size(); i++) {
				
				Object[] objectd=list.get(i);
				Object[] objects=list.get(i);
				
				objd[i]= objectd[5].toString().substring(10, 13);//时间
				
				JSONObject jasonObject = JSONObject.fromObject(objects[4]);
				Map map = (Map)(JSONObject.toBean(jasonObject, Map.class));
				if(map!=null){
					Iterator<String> it = map.keySet().iterator();
					String res="";
					while(it.hasNext()){
							String key = it.next();
						
							objs[i]=map.get(h);
							objh[i]=map.get(t);
							
							objw[i]=map.get(w);
							obje[i]=map.get(e);
				}
			}  
		}
			request.setAttribute("objw", JSON.toJSONString(objw));
			request.setAttribute("obje", JSON.toJSONString(obje));
			request.setAttribute("objs", JSON.toJSONString(objs));	
			request.setAttribute("objh", JSON.toJSONString(objh));
			request.setAttribute("objd", JSON.toJSONString(objd));
		
			
			if (type.equals("温湿度")) {
				return "hlkj/xnfx/ec";
			}else if (type.equals("电流监控")) {
				return "hlkj/xnfx/dec";
			}else {
				return "hlkj/xnfx/yec";
			}		
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	*//**
	 * @param res
	 * @return
	 *//*
	@RequiresPermissions("echarts:line")
	@RequestMapping("line")
	public String  line(HttpServletRequest res)
	{
	//	Option option =ech.simpleChart();
		//String opt = JSON.toJSONString(option);
		//res.setAttribute("option", opt);
		return "hlkj/xnfx/ec";
	}
	
	*//**
	 * @param res
	 * @return
	 * ����
	 *//*
	@RequiresPermissions("echarts:pie")
	@RequestMapping("pie")
	public String pie(HttpServletRequest res)
	{
		Option option = ech.pieTest();
		String opt =JSON.toJSONString(option);
		
		System.out.println(opt);
		
		res.setAttribute("option", opt);
		return "ec";
	}
	
	 *//**
	 * @return
	 * ���ͼ���
	 *//*
	@RequiresPermissions("echarts:pieTest")
	@RequestMapping("pieTest")
	public String pieTest(HttpServletRequest res)
	 {
		 Option option = ech.pieTest();
		 String opt =JSON.toJSONString(option);
		 
		 res.setAttribute("option", opt);
		 System.out.println(opt);
		 return "ec";
	 }
	 
	
	*//**
	 * @param res
	 * @return
	 * ��ͼ����
	 *//*
	@RequiresPermissions("echarts:mapTest")
	@RequestMapping("mapTest")
	public String mapTest(HttpServletRequest res)
	{
		Option option = ech.mapTest();
		String opt = JSON.toJSONString(option);
		res.setAttribute("option", opt);	
		System.out.println(opt);
		return "ec";
	}
	
	
	*//**
	 * @param res
	 * @return
	 * ��۵�ͼ
	 *//*
	@RequiresPermissions("echarts:HKMap")
	@RequestMapping("HKMap")
	public String HKMap(HttpServletRequest res)
	{
		Option option = ech.mapTest2();
		String opt = JSON.toJSONString(option);
		res.setAttribute("option", opt);
		System.out.println(opt);
		return "ec";
	}
	
	
	*//**
	 * @param res
	 * @return
	 * 堆积图
	 *//*
	@RequiresPermissions("echarts:stackChart")
	@RequestMapping("stackChart")
	public String stackChart(HttpServletRequest res)
	{
		Option option = ech.stackChart();
		
		String opt = JSON.toJSONString(option);
		
		res.setAttribute("option", opt);
		
		return "ec";
	}*/

