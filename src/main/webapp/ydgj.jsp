<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	 
	map.centerAndZoom(new BMap.Point(114.906618,30.446109), 13);
	map.enableScrollWheelZoom();
	var point1=new BMap.Point(114.901618, 30.440);
	var point2=new BMap.Point(114.922618, 30.453);
	var point3=new BMap.Point(114.923618, 30.466);
	var point4=new BMap.Point(114.934618, 30.479);
	var marker1 = new BMap.Marker(point1);  // 创建标注
	map.addOverlay(marker1);              // 将标注添加到地图中
	var label1 = new BMap.Label("我是李四1点在地点1",{offset:new BMap.Size(20,-10)});
	marker1.setLabel(label1);
	var marker2 = new BMap.Marker(point2);  // 创建标注 
	map.addOverlay(marker2);   
	var label2 = new BMap.Label("我是李四2点在地点2",{offset:new BMap.Size(20,-10)}); 
	marker2.setLabel(label2);
	
	var marker3 = new BMap.Marker(point3);  // 创建标注 
	map.addOverlay(marker3);   
	var label3 = new BMap.Label("我是李四3点在地点3",{offset:new BMap.Size(20,-10)}); 
	marker3.setLabel(label3);
	
	var marker4 = new BMap.Marker(point4);  // 创建标注 
	map.addOverlay(marker4);   
	var label4 = new BMap.Label("李四现在所在位置",{offset:new BMap.Size(20,-10)}); 
	marker4.setLabel(label4);
	marker4.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	var polyline = new BMap.Polyline([
	    point1,point2,point3,point4
	], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.8});   //创建折线
	map.addOverlay(polyline);   //增加折线1
	
	
	var point11=new BMap.Point(114.931618, 30.410);
	var point22=new BMap.Point(114.942618, 30.433);
	var point33=new BMap.Point(114.953618, 30.466);
	var point44=new BMap.Point(114.964618, 30.499);
	var marker11 = new BMap.Marker(point11);  // 创建标注
	map.addOverlay(marker11);              // 将标注添加到地图中
	var label11 = new BMap.Label("张三8点在地点11",{offset:new BMap.Size(20,-10)});
	marker1.setLabel(label11);
	var marker22 = new BMap.Marker(point22);  // 创建标注 
	map.addOverlay(marker22);   
	var label22 = new BMap.Label("张三9点在地点22",{offset:new BMap.Size(20,-10)}); 
	marker22.setLabel(label22);
	
	var marker33 = new BMap.Marker(point33);  // 创建标注 
	map.addOverlay(marker33);   
	var label33 = new BMap.Label("张三10点在地点33",{offset:new BMap.Size(20,-10)}); 
	marker33.setLabel(label33);
	
	
 
	 var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {  
                        offset: new BMap.Size(10, 25), // 指定定位位置  
                         fillColor: "yellow",//填充颜色
                        imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移  
                    });  
                    
	//var marker44 = new BMap.Marker(point44,{icon:myIcon});  // 创建标注 
	
	
	//设置marker图标为水滴
var marker44 = new BMap.Marker(point44, {
  // 指定Marker的icon属性为Symbol
  icon: new BMap.Symbol(BMap_Symbol_SHAPE_POINT, {
    scale: 2,//图标缩放大小
    fillColor: "green",//填充颜色
    fillOpacity: 0.8//填充透明度
  })
});
	
	
	map.addOverlay(marker44);   
	var label44 = new BMap.Label("张三现在所在位置",{offset:new BMap.Size(20,-10)}); 
	marker44.setLabel(label44);
	marker44.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画 
	  polyline = new BMap.Polyline([
	    point11,point22,point33,point44
	], {strokeColor:"green", strokeWeight:2, strokeOpacity:0.8});   //创建折线
	map.addOverlay(polyline);   //增加折线1
	
</script>

 