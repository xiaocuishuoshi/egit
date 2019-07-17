<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.manager.jd.bean.JdPzxx"%>
 
	 <%
			JdPzxx jx=(JdPzxx)session.getAttribute("list");
		String content="<br/>姓名:"+jx.getPzryxm()+"<br/>拍照时间:"+jx.getPzsj()+"<br/>经度:"+jx.getLng()+"<br/>纬度:"+jx.getLan()+"";
		%>  
	<style type="text/css">  
		#allmap{width:100%;height:500px;overflow: hidden;}
	</style>
	<div id="allmap"></div>
<script type="text/javascript">
		var map = new BMap.Map("allmap");
	  
	var point = new BMap.Point(<%=jx.getLng()%>,<%=jx.getLan()%>);
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
	map.enableScrollWheelZoom(true);  //开启鼠标滚轮缩放
	map.centerAndZoom(point, 15);
	 marker.setAnimation(BMAP_ANIMATION_BOUNCE);
	var infoWindow = new BMap.InfoWindow("<%=content%> ");  // 创建信息窗口对象 
	marker.addEventListener("mouseover", function(){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
	
</script>
