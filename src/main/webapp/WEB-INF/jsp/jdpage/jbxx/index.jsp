<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 90%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
		<script type="text/javascript"
			src="http://api.map.baidu.com/api?v=2.0&ak=BydHZOdwnMhgKCnkXXrq4Eef6bs5V9Yn">
</script>
		<script type="text/javascript"
			src="http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js">
</script>
		<script type="text/javascript" src="jquery-1.11.js">
</script>
		<script type="text/javascript" src="jquery.json-2.2.js">
</script>
		<script type="text/javascript"
			src="baiduArea.js?r=<%=System.currentTimeMillis()%>">
			
</script>
		<title>百度地图电子围栏及点是否出圈计算</title>
	</head>
	<body>
		<div id="allmap"></div>
		
<input type="button" onClick="getData();">
	</body>
	<script type="text/javascript">
//坐标一在范围内
var nodes = [ {
 "lng" : 116.314313,
 "lat" : 40.040618
 }, {
 "lng" : 116.278668,
 "lat" : 39.901717
 }, {
 "lng" : 116.455742,
 "lat" : 39.860966
 }, {
 "lng" : 116.535081,
 "lat" : 39.930936
 } ];
//坐标二在范围内
/*var nodes = [ {
	"lng" : 116.973166,
	"lat" : 40.023823
}, {
	"lng" : 116.558077,
	"lat" : 40.044153
}, {
	"lng" : 116.630517,
	"lat" : 39.88666
}, {
	"lng" : 116.817939,
	"lat" : 39.977838
} ];*/
//两个坐标都在范围内
/*var nodes = [ {
 "lng" : 116.973166,
 "lat" : 40.023823
 }, {
 "lng" : 116.558077,
 "lat" : 40.044153
 }, {
 "lng" : 116.170584,
 "lat" : 40.015867
 }, {
 "lng" : 116.651214,
 "lat" : 39.744781
 } ];*/
// 百度地图API功能

var map = new BMap.Map("allmap"); // 创建Map实例
var pt = new BMap.Point(116.404, 39.915);
var pt2 = new BMap.Point(116.67766, 39.958373);
map.centerAndZoom(pt, 11); // 初始化地图,设置中心点坐标和地图级别
//map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
map.setCurrentCity("北京市"); // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
var markerBegin = new BMap.Marker(pt);// 创建标注
map.addOverlay(markerBegin); // 将标注添加到地图中
markerBegin.disableDragging(); // 不可拖拽
var marker2 = new BMap.Marker(pt2);// 创建标注
map.addOverlay(marker2); // 将标注添加到地图中
marker2.disableDragging(); // 不可拖拽
var baiduArea = new BaiduArea(map, nodes, true);
console.log("===>地理围栏标注节点信息:" + $.toJSON(baiduArea.getConfigInfo()));
alert(baiduArea.isPointInArea(pt) ? "坐标点1在范围内" : "坐标点1在范围外");
alert(baiduArea.isPointInArea(pt2) ? "坐标点2在范围内" : "坐标点2在范围外");
 
function getData(){
  var m=$.toJSON(baiduArea.getConfigInfo());
	alert(m);
} 
//ptInPolygon();
//点在多边形内
/*function ptInPolygon() {
 var pts = [];
 for ( var index = 0; index < nodes.length; index++) {
 var pt = nodes[index];
 pts.push(new BMap.Point(pt.lng, pt.lat));
 }
 var ply = new BMap.Polygon(pts);

 var pt = new BMap.Point(116.404, 39.915);

 var result = BMapLib.GeoUtils.isPointInPolygon(pt, ply);
 if (result == true) {
 alert("点在多边形内");
 } else {
 alert("点在多边形外")
 }

 //演示：将面添加到地图上    
 map.clearOverlays();
 var mkr = new BMap.Marker(pt);
 map.addOverlay(mkr);
 map.addOverlay(ply);
 }*/
</script>
</html>
