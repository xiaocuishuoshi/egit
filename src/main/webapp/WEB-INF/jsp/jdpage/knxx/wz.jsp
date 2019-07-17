<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.manager.jd.bean.JdKnxx"%>
 
		<%
			String lng=session.getAttribute("lng").toString();
			String lat=session.getAttribute("lat").toString();
			JdKnxx jx=(JdKnxx)session.getAttribute("list");
		String content="<br/>姓名:"+jx.getUsername()+"<br/>开始时间:"+jx.getKssj()+"<br/>结束时间:"+jx.getJssj()+"<br/>地址:"+jx.getAddress()+"<br/>备注:"+jx.getBj()+"";
			
		%>
	<style type="text/css">
		#allmap{width:100%;height:500px;overflow: hidden;}
	</style>
	<div id="allmap"></div>
<script type="text/javascript">
		var map = new BMap.Map("allmap");
	var point = new BMap.Point(<%=lng%>,<%=lat%>);
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
	map.enableScrollWheelZoom(true);  //开启鼠标滚轮缩放
	map.centerAndZoom(point, 15);
	 marker.setAnimation(BMAP_ANIMATION_BOUNCE);
	var infoWindow = new BMap.InfoWindow("<%=content%>");  // 创建信息窗口对象 
	marker.addEventListener("mouseover", function(){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
	
</script>
