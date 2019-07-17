package com.whfp.oa.webservice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.whfp.oa.commons.util.HttpPostUtil;
import com.whfp.oa.commons.util.MD5Util;

public class SendMsg {
    private static String HTTPURL = "http://120.55.82.118:8091";
	private static String userid= "1001103";//用户编号，接入方信息唯一标识
	private static String password="fp9988";//用户在平台上分配的密码
	public  String msgSend(String phones,String content){
		StringBuffer posturl = new StringBuffer(HTTPURL+"/sismsapi.go?method=smssend");
//		String sendtermid="";//扩展号
		String sendtime = "1";//发送时间 1为立即发送,定时发送 格式为: yyyyMMddHHmmss
		String md5 = MD5Util.MD5(userid+"||"+phones+"||"+password);
		try {
			content = URLEncoder.encode(content,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Map<String, String> params = new  HashMap<String, String>();
		params.put("userid", userid);
		params.put("phones", phones);//多个号码以英文逗号 “,”分隔
		params.put("content", content);
//		params.put("sendtermid", sendtermid);
		params.put("sendtime", sendtime); 
		params.put("md5", md5.toLowerCase()); 
		String reStr = HttpPostUtil.postXml(posturl.toString(), params);
		System.out.println(reStr);
		return reStr;
	}
public static void main(String[] args) {
	new SendMsg().msgSend("18086337555", "您的登陆验证码为123456[动益动]");
}
}
