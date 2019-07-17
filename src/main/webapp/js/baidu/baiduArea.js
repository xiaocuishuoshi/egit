/***
 * 需要引入以下两个js文件
 * 1、百度地图接口地址
 * http://api.map.baidu.com/api?v=2.0&ak=百度AK
 * 2、百度地图几何运算工具
 * http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js
 */
var BaiduArea_nodeMap = {};

var area = null;
function BaiduArea(map, nodes, devMode) {
	this.nodes = nodes || [];
	this.map = map;
	this.devMode = devMode || false;

	init();
	function init() {

		if (!map) {
			alert("找不到地图对象!");
			return;
		}
		if (devMode) {
			map.addEventListener("click", function(e) {
				var mark = new BMap.Marker(e.point);
				mark.enableDragging();
				mark.addEventListener("mousedown", function(e) {
					//					console.log("鼠标放下去了" + $.toJSON(this.getPosition()));
						var pt = this.getPosition();
						var ckey = pt.lng + "-" + pt.lat;
						var tmp = {};
						for ( var key in BaiduArea_nodeMap) {
							if (key == ckey) {
								//							console.log("find key");
						continue;
					}
					tmp[key] = BaiduArea_nodeMap[key];
				}
				BaiduArea_nodeMap = tmp;
			}	);
				mark.addEventListener("dragend", function(e) {
					console.log("移动结束" + $.toJSON(this.getPosition()));
					var pt = this.getPosition();
					var key = pt.lng + "-" + pt.lat;
					BaiduArea_nodeMap[key] = pt;
					redraw();
				});
				map.addOverlay(mark);
				var key = e.point.lng + "-" + e.point.lat;
				BaiduArea_nodeMap[key] = e.point;
				redraw();
			});
		}
		try {
			if (nodes) {
				var len = nodes.length;
				for ( var index = 0; index < len; index++) {
					var pt = nodes[index];
					var point = new BMap.Point(pt.lng, pt.lat);
					addMarker(point);
				}
				if (len > 2) {
					var pts = [];
					for ( var index = 0; index < nodes.length; index++) {
						var pt = nodes[index];
						pts.push(new BMap.Point(pt.lng, pt.lat));
					}
					area = new BMap.Polygon(pts, {
						strokeColor : "#0000ff",
						strokeWeight : 2,
						strokeOpacity : 0.5
					}); //创建多边形
					this.map.addOverlay(area);
					//					alert("地理信息初始化成功");
				} else {
					area = null;
				}
			}
		} catch (e) {
			alert("初始化失败");
		}
		//		console.log($.toJSON(BaiduArea_nodeMap));
	}
	/***
	 * 清楚编辑的布局，重新开始布局
	 * @memberOf {TypeName} 
	 */
	this.clearOverLay = function() {
		this.map.clearOverlay();
	};
	function redraw() {
		var nodes = [];
		for ( var key in BaiduArea_nodeMap) {
			nodes.push(BaiduArea_nodeMap[key]);
		}
		if (area) {
			this.map.removeOverlay(area);
			area = null;
		}
		this.nodes = nodes;
		var pts = [];
		for ( var index = 0; index < nodes.length; index++) {
			var pt = nodes[index];
			pts.push(new BMap.Point(pt.lng, pt.lat));
		}
		area = new BMap.Polygon(pts, {
			strokeColor : "blue",
			strokeWeight : 2,
			strokeOpacity : 0.5
		}); //创建多边形
		this.map.addOverlay(area);
		console.log($.toJSON(this.nodes));
	}
	/***
	 * 计算一个点是否在区域范围内
	 * @param {Object} point 当前所在点
	 * @return true/false在范围内，则返回true,否则返回false
	 */
	this.isPointInArea = function(point) {
		if (area) {
			try {
				return BMapLib.GeoUtils.isPointInPolygon(point, area);
			} catch (e) {
				alert("缺少必要参数，资源加载失败!")
				return false;
			}
		} else {
			return false;
		}
	}
	this.getAreaInfo = function() {
		return area;
	}
	this.getConfigInfo = function() {
		var info = [];
		for(var key in BaiduArea_nodeMap){
			var o = BaiduArea_nodeMap[key];
			if(o){
				info.push(o);
			}
		}
		return info;
	}
	function addMarker(point) {
		var mark = new BMap.Marker(point);
		var pos = mark.getPosition();
		var key = pos.lng + "-" + pos.lat;
		BaiduArea_nodeMap[key] = pos;
		//		console.log($.toJSON(mark.getPosition()));
		if (devMode) {
			mark.enableDragging();
			mark.addEventListener("mousedown", function(e) {
				//				console.log("鼠标放下去了" + $.toJSON(this.getPosition()));
					var pt = this.getPosition();
					var ckey = pt.lng + "-" + pt.lat;
					var tmp = {};
					for ( var key in BaiduArea_nodeMap) {
						if (key == ckey) {
							continue;
						}
						tmp[key] = BaiduArea_nodeMap[key];
					}
					BaiduArea_nodeMap = tmp;
				});
			mark.addEventListener("dragend", function(e) {
				//				console.log("移动结束" + $.toJSON(this.getPosition()));
					var pt = this.getPosition();
					var key = pt.lng + "-" + pt.lat;
					BaiduArea_nodeMap[key] = pt;
					redraw();
				});
		} else {
			mark.disableDragging();
		}
		map.addOverlay(mark);
	}
} 