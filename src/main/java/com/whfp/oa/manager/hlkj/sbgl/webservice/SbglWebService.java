package com.whfp.oa.manager.hlkj.sbgl.webservice;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbgl;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbglModer;
import com.whfp.oa.manager.hlkj.sbgl.bean.JsonResult;
import com.whfp.oa.manager.hlkj.sbgl.service.ISbglService;


@Controller
@RequestMapping("/HlkjSbgl")
public class SbglWebService {

	@Autowired
	private ISbglService service;

	/**
	 * 设备管理
	 * 
	 * @param dataModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public JsonResult<String> upload(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult<String> jsonResult = new JsonResult<String>();
		try {

			String data = StringTools.convertStream(request.getInputStream(),
					Charset.forName("UTF-8"));
			System.out.println("**********************data=" + data);
			JSONObject jsonObject = JSONObject.fromObject(data);
			System.out.println("**********************jsonObject=" + jsonObject);
			System.out.println("**********************data=" + data);
			HlkjSbglModer dataModel = (HlkjSbglModer) JSONObject.toBean(jsonObject, HlkjSbglModer.class);
			// Map dd = (JSONObject) jsonObject.get("data");
			//			
			// for(int s = 0 ;s<dd.size();s++){
			// System.out.println("map键值对：="+dd.get(s));
			// }
			//			

			// if (StringUtils.isEmpty(data)) {
			// jsonResult.setMessage("数据不能为空");
			// jsonResult.setSuccess(false);
			// return jsonResult;
			// }

			HlkjSbgl hlsb = new HlkjSbgl(); // 设备信息表
			int s = dataModel.getDevice_type();
			hlsb.setDesc(dataModel.getDevice_id());// 设备序号
			switch (s) {
			case 1:
				hlsb.setType("门磁1单元门"); // 设备类型ID
				hlsb.setSblm("mjgl");
				break;
			case 2:
				hlsb.setType("门磁2常开门");
				hlsb.setSblm("mjgl");
				break;
			case 3:
				hlsb.setType("门磁3长闭门");
				hlsb.setSblm("mjgl");
				break;
			case 4:
				hlsb.setType("智能垃圾箱");
				hlsb.setSblm("lhgl");
				break;
			case 5:
				hlsb.setType("弱电检测");
				hlsb.setSblm("bpdgl");
				break;
			case 6:
				hlsb.setType("路灯检测");
				hlsb.setSblm("zmgl");
				break;
			case 7:
				hlsb.setType("温湿度");
				hlsb.setSblm("gpsgl");
				break;
			case 8:
				hlsb.setType("水压力传感");
				hlsb.setSblm("gpsgl");
				break;
			case 9:
				hlsb.setType("液位传感");
				hlsb.setSblm("gpsgl");
				break;
			case 10:
				hlsb.setType("电梯");
				hlsb.setSblm("dtgl");
				break;
			case 11:
				hlsb.setType("水表");
				hlsb.setSblm("gpsgl");
				break;
			case 12:
				hlsb.setType("电流监控");
				hlsb.setSblm("bpdgl");
				break;
			case 13:
				hlsb.setType("消防设施");
				hlsb.setSblm("xfgl");
				break;
			case 14:
				hlsb.setType("烟感");
				hlsb.setSblm("xfgl");
				break;
			case 15:
				hlsb.setType("火焰探测");
				hlsb.setSblm("xfgl");
				break;
			case 16:
				hlsb.setType("危险气体");
				hlsb.setSblm("xfgl");
				break;
			case 17:
				hlsb.setType("大气压强");
				hlsb.setSblm("xfgl");
				break;
			case 18:
				hlsb.setType("空气质量");
				hlsb.setSblm("lhgl");
				break;
			case 19:
				hlsb.setType("人数统计");
				hlsb.setSblm("mjgl");
				break;
			case 20:
				hlsb.setType("电参数综合测量");
				hlsb.setSblm("bpdgl");
				break;
			case 21:
				hlsb.setType("地锁设备");
				hlsb.setSblm("tcgl");
				break;
			case 22:
				hlsb.setType("地磁设备");
				hlsb.setSblm("tcgl");
				break;
			case 23:
				hlsb.setType("流量设备");
				hlsb.setSblm("gpsgl");
				break;
			case 24:
				hlsb.setType("电梯设备");
				hlsb.setSblm("dtgl");
				break;
			case 35:
				hlsb.setType("电灯");
				hlsb.setSblm("dd");
				break;
			case 36:
				hlsb.setType("空调");
				hlsb.setSblm("kt");
				break;
			default:
				hlsb.setType("无法获取设备类型");
				hlsb.setSblm("wfl");
				break;
			}
			hlsb.setStatus(dataModel.getData().toString());
			hlsb.setUpdatetime(new Timestamp((new SimpleDateFormat(
					"yyyyMMddHHmmss").parse(dataModel.getLast_update_time()))
					.getTime()));
			// hlsb.setAddressid(dataModel.getDevice_id());
			service.addSbgl(hlsb,"jtyh");
			jsonResult.setCode(0);
			jsonResult.setMsg("设备上传数据成功");
			jsonResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setCode(1);
			jsonResult.setMsg("设备上传数据失败");
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
}
