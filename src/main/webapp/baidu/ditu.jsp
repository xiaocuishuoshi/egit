<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="ECharts">
<meta name="author" content="kener.linfeng@gmail.com">
<title>ECharts · Example</title>

<link rel="shortcut icon" href="http://echarts.baidu.com/echarts2/doc/asset/ico/favicon.png">

<link href="http://echarts.baidu.com/echarts2/doc/asset/css/font-awesome.min.css" rel="stylesheet">
<link href="http://echarts.baidu.com/echarts2/doc/asset/css/bootstrap.css" rel="stylesheet">
<link href="http://echarts.baidu.com/echarts2/doc/asset/css/carousel.css" rel="stylesheet">
<link href="http://echarts.baidu.com/echarts2/doc/asset/css/echartsHome.css" rel="stylesheet">
 

<script src="./www/js/echarts.js"></script>
<script src="http://echarts.baidu.com/echarts2/doc/asset/js/codemirror.js"></script>
<script src="http://echarts.baidu.com/echarts2/doc/asset/js/javascript.js"></script>

<link href="http://echarts.baidu.com/echarts2/doc/asset/css/codemirror.css" rel="stylesheet">
<link href="http://echarts.baidu.com/echarts2/doc/asset/css/monokai.css" rel="stylesheet">

<style type="text/css">
.CodeMirror {
height: 550px;
}
</style>
</head>

<body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation" id="head"></div>


<div class="container-fluid">
<div class="row-fluid example">
<div id="sidebar-code" class="col-md-4">
<div class="well sidebar-nav">
<div class="nav-header"><a href="#" onclick="autoResize()" class="glyphicon glyphicon-resize-full" id ="icon-resize" ></a>option</div>
<textarea id="code" name="code">
// 自定义扩展图表类型：mapType = HK
require('echarts/util/mapData/params').params.HK = {
getGeoJson: function (callback) {
$.getJSON('geoJson/HK_geo.json',callback);
}
}
option = {
title : {
text : '香港18区人口密度 （2011）',
subtext: '人口密度数据来自Wikipedia',
sublink: 'http://zh.wikipedia.org/wiki/%E9%A6%99%E6%B8%AF%E8%A1%8C%E6%94%BF%E5%8D%80%E5%8A%83#cite_note-12'
},
tooltip : {
trigger: 'item',
formatter: '{b}<br/>{c} (p / km2)'
},
toolbox: {
show : true,
orient : 'vertical',
x: 'right',
y: 'center',
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
restore : {show: true},
saveAsImage : {show: true}
}
},
dataRange: {
min: 800,
max: 50000,
text:['High','Low'],
realtime: false,
calculable : true,
color: ['orangered','yellow','lightskyblue']
},
series : [
{
name: '香港18区人口密度',
type: 'map',
mapType: 'HK', // 自定义扩展图表类型
itemStyle:{
normal:{label:{show:true}},
emphasis:{label:{show:true}}
},
data:[
{name: '中西区', value: 20057.34},
{name: '湾仔', value: 15477.48},
{name: '东区', value: 31686.1},
{name: '南区', value: 6992.6},
{name: '油尖旺', value: 44045.49},
{name: '深水埗', value: 40689.64},
{name: '九龙城', value: 37659.78},
{name: '黄大仙', value: 45180.97},
{name: '观塘', value: 55204.26},
{name: '葵青', value: 21900.9},
{name: '荃湾', value: 4918.26},
{name: '屯门', value: 5881.84},
{name: '元朗', value: 4178.01},
{name: '北区', value: 2227.92},
{name: '大埔', value: 2180.98},
{name: '沙田', value: 9172.94},
{name: '西贡', value: 3368},
{name: '离岛', value: 806.98}
],
// 自定义名称映射
nameMap: {
'Central and Western':'中西区',
'Eastern':'东区',
'Islands':'离岛',
'Kowloon City':'九龙城',
'Kwai Tsing':'葵青',
'Kwun Tong':'观塘',
'North':'北区',
'Sai Kung':'西贡',
'Sha Tin':'沙田',
'Sham Shui Po':'深水埗',
'Southern':'南区',
'Tai Po':'大埔',
'Tsuen Wan':'荃湾',
'Tuen Mun':'屯门',
'Wan Chai':'湾仔',
'Wong Tai Sin':'黄大仙',
'Yau Tsim Mong':'油尖旺',
'Yuen Long':'元朗'
},
// 文本位置修正
textFixed : {
'Yau Tsim Mong' : [-10, 0]
},
// 文本直接经纬度定位
geoCoord : {
'Islands' : [113.95, 22.26]
}
}
]
};
</textarea>
</div><!--/.well -->
</div><!--/span-->
<div id="graphic" class="col-md-8">
<div id="main" class="main" style="height: 530px;"></div>
<div>
<button type="button" class="btn btn-sm btn-success" onclick="refresh(true)">刷 新</button>
<span class="text-primary">切换主题</span>
<select id="theme-select"></select>

<span id='wrong-message' style="color:red"></span>
</div>
</div><!--/span-->
</div><!--/row-->
</div><!--/.fluid-container-->

<footer id="footer"></footer> 
<script src="http://echarts.baidu.com/echarts2/doc/asset/js/jquery.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/echarts2/doc/asset/js/echartsHome.js"></script>
<script src="http://echarts.baidu.com/echarts2/doc/asset/js/bootstrap.min.js"></script>
<script src="http://echarts.baidu.com/echarts2/doc/asset/js/echartsExample.js"></script>
</body>
</html>
