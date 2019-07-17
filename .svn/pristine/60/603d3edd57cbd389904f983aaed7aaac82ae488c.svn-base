package com.whfp.oa.commons.util;

import java.net.*;
import java.util.*;
import java.io.*;


public class HttpPostUtil {
	public static String postXml(String url, Map<String, String> params) {
		URL u = null;
		HttpURLConnection con = null;
		//构建请求参数
		StringBuffer sb = new StringBuffer();
		if(params!=null){
		for (String key : params.keySet()) {
    		sb.append(key);
    		sb.append("=");
    		sb.append(params.get(key));
    		sb.append("&");
		}
		sb.substring(0, sb.length() - 1);
		}
		System.out.println("send_url:"+url);
		System.out.println("send_data:"+sb.toString());
		//尝试发送请求
		try {
    		u = new URL(url);
    		con = (HttpURLConnection) u.openConnection();
    		con.setRequestMethod("POST");
    		con.setDoOutput(true);
    		con.setDoInput(true);
    		con.setUseCaches(false);
    		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
    		osw.write(sb.toString());
    		osw.flush();
    		osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
    		if (con != null) {
    			con.disconnect();
    		}
		}
		//读取返回内容
		StringBuffer buffer = new StringBuffer();
		try {
    		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
    		String temp;
    		while ((temp = br.readLine()) != null) {
	    		buffer.append(temp);
	    		buffer.append("\n");
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
   }
}
