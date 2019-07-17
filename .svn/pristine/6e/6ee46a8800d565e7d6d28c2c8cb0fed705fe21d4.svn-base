<%@page import="com.whfp.oa.commons.model.Member"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap {height:500px; width: 100%;}
		#control{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Y9Yo0UsPgY38Ncy26Qmbz1B7"></script>
	<title>设置线、面可编辑</title>
</head>
<body>
	<div id="allmap"></div>
	<div id="control">
		<button onclick = "polyline.enableEditing();polygon.enableEditing();">开启线、面编辑功能</button>
		<button onclick = "polyline.disableEditing();polygon.disableEditing();">关闭线、面编辑功能</button>
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(114.906618,30.446109), 15);
	map.enableScrollWheelZoom();
	
	var point1=new BMap.Point(114.901618, 30.440);
	var point2=new BMap.Point(114.902618, 30.450);
	var point3=new BMap.Point(114.903618, 30.460);
	var point4=new BMap.Point(114.904618, 30.470);
	var marker1 = new BMap.Marker(point1);  // 创建标注
	map.addOverlay(marker1);              // 将标注添加到地图中
	var label1 = new BMap.Label("我是文字标注1",{offset:new BMap.Size(20,-10)});
	marker1.setLabel(label1);
	var marker2 = new BMap.Marker(point2);  // 创建标注 
	map.addOverlay(marker2);   
	var label2 = new BMap.Label("我是文字标注2",{offset:new BMap.Size(20,-10)}); 
	marker2.setLabel(label2);
	
	var marker3 = new BMap.Marker(point3);  // 创建标注 
	map.addOverlay(marker3);   
	var label3 = new BMap.Label("我是文字标注3",{offset:new BMap.Size(20,-10)}); 
	marker3.setLabel(label3);
	
	var marker4 = new BMap.Marker(point4);  // 创建标注 
	map.addOverlay(marker4);   
	var label4 = new BMap.Label("我是文字标注4",{offset:new BMap.Size(20,-10)}); 
	marker4.setLabel(label4);
	
	var polyline = new BMap.Polyline([
	    point1,point2,point3,point4
	], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.8});   //创建折线
	map.addOverlay(polyline);   //增加折线1
	
	
	
    
</script>

 