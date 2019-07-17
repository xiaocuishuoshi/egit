<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

List<Object[]> list=null;
if(session.getAttribute("map")!=null)
	list=(List)session.getAttribute("map");

 %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>

	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Y9Yo0UsPgY38Ncy26Qmbz1B7"></script> 
	<title>添加行政区划</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
   map.setMapStyle({
		    	   styleJson:[
		    	         {
		                    "featureType": "poi",
		                    "elementType": "all",
		                    "stylers": {
		                              "color": "#ffffff",
		                              "visibility": "off"
		                    }
				          },
				          {
				                    "featureType": "road",
				                    "elementType": "all",
				                    "stylers": {
				                              "color": "#ffffff",
				                               "visibility": "off"
				                    }
				          },
				          {
				                    "featureType": "background",
				                    "elementType": "all",
				                    "stylers": {
				                              "color": "#ffffff"
				                    }
				          }
					]
				});
			   
	map.centerAndZoom(new BMap.Point(115.55,30),11);
	map.enableScrollWheelZoom();

	function getBoundary(){       
		var bdary = new BMap.Boundary();
		bdary.get("武穴市", function(rs){       //获取行政区域
		//map.clearOverlays();        //清除地图覆盖物       
			var count = rs.boundaries.length; //行政区域的点有多少个
			for(var i = 0; i < count; i++){
				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000",strokeOpacity:0.0, fillOpacity: 0.0, fillColor: 

"none"}); //建立多边形覆盖物
				map.addOverlay(ply);  //添加覆盖物
				//map.setViewport(ply.getPath());    //调整视野     
			}                
		});   
		  
	}
	

	  function ComplexCustomOverlay(point, text, mouseoverText){
      this._point = point;
      this._text = text;
      this._overText = mouseoverText;
    }
    ComplexCustomOverlay.prototype = new BMap.Overlay();
    ComplexCustomOverlay.prototype.initialize = function(map1){
      this._map = map1;
      var div = this._div = document.createElement("div");
      div.style.position = "absolute";
      div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
      div.style.backgroundColor = "#EE5D5B";
      div.style.border = "1px solid #BC3B3A";
      div.style.color = "white";
      div.style.height = "18px";
      div.style.padding = "2px";
      div.style.lineHeight = "18px";
      div.style.whiteSpace = "nowrap";
      div.style.MozUserSelect = "none";
      div.style.fontSize = "22px"
      var span = this._span = document.createElement("span");
      div.appendChild(span);
      span.appendChild(document.createTextNode(this._text));      
      var that = this;

      var arrow = this._arrow = document.createElement("div");
      arrow.style.background = "url(http://map.baidu.com/fwmap/upload/r/map/fwmap/static/house/images/label.png) no-repeat";
      arrow.style.position = "absolute";
      arrow.style.width = "11px";
      arrow.style.height = "10px";
      arrow.style.top = "22px";
      arrow.style.left = "10px";
      arrow.style.overflow = "hidden";
      div.appendChild(arrow);
     
      div.onmouseover = function(){
        this.style.backgroundColor = "#6BADCA";
        this.style.borderColor = "#0000ff";
        this.getElementsByTagName("span")[0].innerHTML = that._overText;
        arrow.style.backgroundPosition = "0px -20px";
      }

      div.onmouseout = function(){
        this.style.backgroundColor = "#EE5D5B";
        this.style.borderColor = "#BC3B3A";
        this.getElementsByTagName("span")[0].innerHTML = that._text;
        arrow.style.backgroundPosition = "0px 0px";
      }
	  div.onclick = function(){  
        var address=that._text;
         
	 		
      }
      map.getPanes().labelPane.appendChild(div);
      
      return div;
    }
    ComplexCustomOverlay.prototype.draw = function(){
      var map = this._map;
      var pixel = map.pointToOverlayPixel(this._point);
      this._div.style.left = pixel.x - parseInt(this._arrow.style.left) + "px";
      this._div.style.top  = pixel.y - 30 + "px";
    }
    <%
    out.println("size="+list.size());
    for(int i=0;list!=null&&i<list.size();i++){
    Object[] obj=list.get(i);
    
    out.println("var txt"+i+"='"+obj[0]+"', mouseoverTxt"+i+"=(txt"+i +")+"+"'人口" +obj[1] + "，吸毒比例"+(Double.parseDouble(obj[5].toString())*100)+"%';") ;
    String pos=obj[6].toString();
    if(pos!=null)
    pos=pos.replace("[", "").replace("]", "");
    out.println("var myCompOverlay"+i+"= new ComplexCustomOverlay(new BMap.Point("+pos+"), '"+obj[0]+""+obj[4]+"人',mouseoverTxt"+i+");");
 	out.println("map.addOverlay(myCompOverlay"+i+");"); 
 }%>
setTimeout(function(){
		getBoundary();
	}, 0);
</script>