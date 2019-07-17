<%@page import="com.whfp.oa.manager.jd.bean.JdRyb"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

List<JdRyb> list=null;
String pos="";

if(session.getAttribute("fb")!=null)
	list=(List)session.getAttribute("fb");

if(session.getAttribute("pos")!=null){
	pos=(String)session.getAttribute("pos");
    pos=pos.replace("[", "").replace("]",""); 
 }else
 	pos="115.55,29.85";
 %> 
 
<iframe width="100%" frameborder="0" height="100%" src="./echarts-m-1.0.0/fb.jsp"></iframe>

 
