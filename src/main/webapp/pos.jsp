 
<%@page import="java.sql.*"%> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 String id=request.getParameter("id"); 
 
try{

Connection  conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/whcx?characterEncoding=UTF-8","root","djdqltj");
 
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select area,longitude,latitude from area_info  where id="+id);
 

rs.close(); 
stmt.close();
conn.close();
}catch(Exception e){
e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{width:100%;height:500px;}
		p{margin-left:5px; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Y9Yo0UsPgY38Ncy26Qmbz1B7"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/AreaRestriction/1.2/src/AreaRestriction_min.js"></script>
	<title>设置地图显示范围</title>
</head>
<body>
	<div id="allmap"></div> 
</body>
</html>

<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(114.906618,30.446109);
	map.centerAndZoom(point, 13);
	// 编写自定义函数,创建标注
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	}
	// 随机向地图添加25个标注
	var bounds = map.getBounds();
	var sw = bounds.getSouthWest();
	var ne = bounds.getNorthEast();
	var lngSpan = Math.abs(sw.lng - ne.lng);
	var latSpan = Math.abs(ne.lat - sw.lat);
	for (var i = 0; i < 25; i ++) {
		var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
		addMarker(point);
	}
</script>
