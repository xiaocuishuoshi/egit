<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
int width=1024;
int height=568;
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
* {
	margin: 0;
	padding: 0;
}
ul {
	list-style: none;
}
a {
	text-decoration: none;
}
img {
	border: none;
}

.aaa{width:100%; height:800px; text-align:center; background-color:#fff;}
</style>
</head>

<body>
<div class="aaa">
<img src="./images/bj.png" width="1280" height="750" border="0" usemap="#Map" />
<map name="Map" id="Map">
  <area shape="poly" coords="596,4" href="#" />
  <area shape="circle" coords="606,58,47" href="javascript:void(0);" title="1" onClick="MUI.openDialog('孝感市-汉川市-马口镇-金河村','wgh/load.do?rel=wgh1&xh=1','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="829,66,38" href="javascript:void(0);"  title="2"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-关圣村','wgh/load.do?rel=wgh2&xh=2','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="rect" coords="725,63,785,121" href="javascript:void(0);" title="3"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-周湖村','wgh/load.do?rel=wgh3&xh=3','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="circle" coords="920,118,25" href="javascript:void(0);"  title="4"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-土桥村','wgh/load.do?rel=wgh4&xh=4','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="rect" coords="928,146,994,195" href="javascript:void(0);"  title="5"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-范岭村','wgh/load.do?rel=wgh5&xh=5','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="poly" coords="842,154,881,166,868,191,861,219,856,246,838,259,829,253,814,233,808,208" href="javascript:void(0);"  title="6"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-新庄村','wgh/load.do?rel=wgh6&xh=5','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="circle" coords="792,176,22" href="javascript:void(0);" title="7"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-窑新村','wgh/load.do?rel=wgh7&xh=7','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="734,168,21" href="javascript:void(0);"  title="8"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-八屋村','wgh/load.do?rel=wgh8&xh=8','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="681,126,35" href="javascript:void(0);"  title="9"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-曾家湾','wgh/load.do?rel=wgh9&xh=9','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="rect" coords="586,103,630,147" href="javascript:void(0); "title="10" onClick="MUI.openDialog('孝感市-汉川市-马口镇-南港村','wgh/load.do?rel=wgh10&xh=10','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="rect" coords="438,108,564,140" href="javascript:void(0);"  title="11"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-邱子村','wgh/load.do?rel=wgh11&xh=11','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="454,204,39" href="javascript:void(0);"  title="12"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-英山村','wgh/load.do?rel=wgh12&xh=12','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="circle" coords="574,188,31" href="javascript:void(0);"  title="13"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-敖家村','wgh/load.do?rel=wgh13&xh=13','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="642,211,32" href="javascript:void(0);"  title="14"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-白虎岭村','wgh/load.do?rel=wgh14&xh=14','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="rect" coords="686,211,747,237" href="javascript:void(0);"  title="15"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-五福村','wgh/load.do?rel=wgh15&xh=15','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="732,274,22" href="javascript:void(0);" title="16"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-严家山村','wgh/load.do?rel=wgh16&xh=16','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="812,304,30" href="javascript:void(0);"title="17"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-官山村','wgh/load.do?rel=wgh17&xh=17','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="926,265,50" href="javascript:void(0);" title="18"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-高山村','wgh/load.do?rel=wgh18&xh=18','gs_home',{width:<%=width %>,height:<%=height%>})" />
  <area shape="poly" coords="531,213,522,236,538,257,553,280,558,311,564,340,593,330,587,289,613,287,640,293,659,303,694,321,732,333,766,336,772,319,632,264,531,213" href="javascript:void(0);" title="19" onClick="MUI.openDialog('孝感市-汉川市-马口镇-白石湖村','wgh/load.do?rel=wgh19&xh=19','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="rect" coords="456,271,540,294" href="javascript:void(0);" title="20"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-庙湾村','wgh/load.do?rel=wgh20&xh=20','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="384,305,48" href="javascript:void(0);" title="21"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-八大村','wgh/load.do?rel=wgh21&xh=21','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="502,334,28" href="javascript:void(0);" title="22"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-童岭村','wgh/load.do?rel=wgh22&xh=22','gs_home',{width:<%=width %>,height:<%=height%>})" target="_blank" />
  <area shape="circle" coords="654,362,43" href="javascript:void(0);" title="23"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-七吴村','wgh/load.do?rel=wgh23&xh=23','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="poly" coords="722,350,720,393,740,381,774,385,785,385,783,367,771,354,724,348,723,350" href="javascript:void(0);" title="24"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-枣树村','wgh/load.do?rel=wgh24&xh=24','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="897,401,49" href="javascript:void(0);" title="25"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-光明村','wgh/load.do?rel=wgh25&xh=25','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="633,469,25" href="javascript:void(0);" title="26"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-丁集村','wgh/load.do?rel=wgh26&xh=26','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="566,418,42" href="javascript:void(0);" title="27"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-回龙村','wgh/load.do?rel=wgh28&xh=27','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="poly" coords="457,359,444,375,463,383,481,385,498,389,499,421,504,426,511,417,514,399,512,380,515,371,489,371,463,365,460,360"title="28"  href="javascript:void(0);" onClick="MUI.openDialog('孝感市-汉川市-马口镇-旭高村','wgh/load.do?rel=wgh28&xh=28','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="444,439,29" href="javascript:void(0);" title="29"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-雄伟村','wgh/load.do?rel=wgh29&xh=29','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="387,396,28" href="javascript:void(0);" title="30"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-雄丰村','wgh/load.do?rel=wgh30&xh=30','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="302,401,34" href="javascript:void(0);" title="31"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-船厂村','wgh/load.do?rel=wgh31&xh=31','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="rect" coords="355,488,448,550" href="javascript:void(0);" title="32"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-白马村','wgh/load.do?rel=wgh32&xh=32','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="502,496,25" href="javascript:void(0);" title="33"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-柴林村','wgh/load.do?rel=wgh33&xh=33','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="poly" coords="522,535,541,528,575,526,587,536,592,559,598,588,591,608,567,615,555,586,540,578,524,538"title="34"  href="javascript:void(0);" onClick="MUI.openDialog('孝感市-汉川市-马口镇-大咀村','wgh/load.do?rel=wgh34&xh=34','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="rect" coords="441,563,524,591" href="javascript:void(0);" title="35"  target="_blank"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-大咀村','wgh/load.do?rel=wgh35&xh=35','gs_home',{width:<%=width %>,height:<%=height%>})"/>
  <area shape="poly" coords="369,588,392,579,416,589,438,602,458,613,480,622,487,632,470,633,436,629,405,615,367,591" title="36"  href="javascript:void(0);" onClick="MUI.openDialog('孝感市-汉川市-马口镇-中岭村','wgh/load.do?rel=wgh36&xh=36','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="circle" coords="360,661,38" title="37"  href="javascript:void(0);" onClick="MUI.openDialog('孝感市-汉川市-马口镇-旧港村','wgh/load.do?rel=wgh37&xh=37','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
  <area shape="poly" coords="385,705,396,725,407,726,423,712,438,691,447,681,466,675,498,668,499,650,476,647,453,638,454,655,455,671,442,673,426,676,383,705" href="javascript:void(0);" title="38"  onClick="MUI.openDialog('孝感市-汉川市-马口镇-横山村','wgh/load.do?rel=wgh38&xh=38','gs_home',{width:<%=width %>,height:<%=height%>})"  target="_blank" />
</map>
</div>
</body>
</html>
