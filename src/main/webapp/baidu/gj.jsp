﻿<%@page import="com.whfp.oa.commons.util.DateUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.whfp.oa.manager.jd.bean.*"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String area=request.getParameter("area");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GBK">
		<title></title>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=aGf0sLjv7DOonc61fINdATGez2d3O8xB"></script>
		<style type="text/css">
			body,html {
				width: 100%;
				height: 100%;
				margin: 0;
				font-family: "微软雅黑";
			}
			#map_canvas {
				width: 100%;
				height: 600px;
			}
		</style>
	</head>
	<body>
		
		<div id="map_canvas"></div>
		
		<script> 
			var map = new BMap.Map('map_canvas');
			map.enableScrollWheelZoom();
				<%
	JdRyb ryb=null;
	String  dqwz="",dqwzfksj="";
	String pos[]=new String[3];
	Map arrayList=new HashMap();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//System.out.println(session.getAttribute("user_pos"));
String pso="";
	 
	String color[]={"red","blue","green","black","yellow","orange","Purple"};
	if(pos.length>=2){
	%>
	
	
		var xx='<%=pos[1]%>';
		var yy='<%=pos[2]%>'; 
		if(xx==null||xx.length<1||yy==null||yy.length<1){
			xx="114.87";
			yy="30.44";
		}
		map.centerAndZoom(new BMap.Point(xx,yy), 25); 
	<%}else{
	%>
		map.centerAndZoom(new BMap.Point(113.59,30.63), 25); 
	<%}%>
	function getBoundary(){
	
	<%
	
	if(session.getAttribute("area")!=null){
		Map area_map=(HashMap)session.getAttribute("area");
		
	  for(int m=0;m<area_map.size();m++){
	   if(area_map.get(m)!=null){
	%>
	       
	    var bdary<%=m%> = new BMap.Boundary(); 
	    bdary<%=m%>.get('<%=area_map.get(m).toString()%>', function(rs){       //获取行政区域
	      //  map.clearOverlays();        //清除地图覆盖物
	        var count = rs.boundaries.length; //行政区域的点有多少个 
	        for(var i = 0; i < count; i++){   
	            var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "<%=color[m]%>"}); //建立多边形覆盖物
	            map.addOverlay(ply);  //添加覆盖物
	            map.setViewport(ply.getPath());    //调整视野         
	        }                
	    });   
    <%  }
      }
    }else{
    	String  dqgkdq ="";
    	if(session.getAttribute("dqgkdq")!=null)
    	dqgkdq=session.getAttribute("dqgkdq").toString();
    %>
      　　　var bdary = new BMap.Boundary(); 
	    bdary.get('<%=dqgkdq%>', function(rs){       //获取行政区域
	      //  map.clearOverlays();        //清除地图覆盖物
	        var count = rs.boundaries.length; //行政区域的点有多少个 
	        for(var i = 0; i < count; i++){   
	            var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000",fillColor:"none",fillOpacity:"0.9"}); //建立多边形覆盖物
	            map.addOverlay(ply);  //添加覆盖物
	           
	            map.setViewport(ply.getPath());    //调整视野         
	        }                
	    });	
    <%}%> 
}

getBoundary();
	<%
	  
	String strout="";
	
	if(session.getAttribute("wzxx")!=null){
	arrayList=(HashMap)session.getAttribute("wzxx"); 
	} 
	for(int j=0;j<arrayList.size();j++){ 
	    List arrayList1=(List)arrayList.get(j);
	    %>
	     var PointArr<%=j%>= new Array();
	    <%
	    
	System.out.println("size===11="+arrayList1.size());
		for(int i=0;i<arrayList1.size();i++){
			JdWzxx wzxx=(JdWzxx)arrayList1.get(i);
			if(i<arrayList1.size())
			 strout+="point"+i+",";
			 else
			  strout+="point"+i;
		  String isout="";
		  if(wzxx.getOutFlag().equals("1"))isout="【越界】";
	%>		
			/**采集到的GPS点**/
		
			PointArr<%=j%>.push({"x":<%=wzxx.getLongitude()%>,"y":<%=wzxx.getLatitude()%>,"z":'<%=df.format(wzxx.getCreatetime())+wzxx.getArea()+isout%>'});	
	<%}%>	 
			var p = Math.ceil(PointArr<%=j%>.length / 2);
			map.centerAndZoom(new BMap.Point(PointArr<%=j%>[p].x, PointArr<%=j%>[p].y), 25);	
			var driving;
			for(var i in PointArr<%=j%>){
				if(i == 0 ){
					addMarker(new BMap.Point(PointArr<%=j%>[i].x, PointArr<%=j%>[i].y),"起点:"+PointArr<%=j%>[i].z);
					continue;
				}
				driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: false}, 
		        onMarkersSet:function(routes) {
		          map.removeOverlay(routes[0].marker); //删除API自带起点
		             map.removeOverlay(routes[1].marker); //删除API自带终点
		        }});
				
		        driving.search(new BMap.Point(PointArr<%=j%>[i-1].x, PointArr<%=j%>[i-1].y), 
						new BMap.Point(PointArr<%=j%>[i].x, PointArr<%=j%>[i].y));
		        if(i == PointArr<%=j%>.length -1){
					addMarker(new BMap.Point(PointArr<%=j%>[i].x, PointArr<%=j%>[i].y),"终点:"+PointArr<%=j%>[i].z);
		        }else{
				    if(i>0)
					addMarker(new BMap.Point(PointArr<%=j%>[i].x, PointArr<%=j%>[i].y),PointArr<%=j%>[i].z);
				}
			}
			<%}%>	
			/**
			 * 标记
			 * @param {Object} point
			 */
			function addMarker(point,name){
				var marker = new BMap.Marker(point);
				var label = new BMap.Label(name, {
					offset : new BMap.Size(20, -10)
				});
				marker.setLabel(label);
				map.addOverlay(marker);
			}
		</script>
	</body>
</html>