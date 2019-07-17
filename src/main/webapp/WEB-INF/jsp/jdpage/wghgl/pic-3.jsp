<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>城西社区网格划分图</title>
        <!-- <link href="css/index.css" rel="stylesheet" type="text/css" /> -->
	</head>
	<body>
		<!-- <div  id="header">
			<div class="header-inner"><h2>城西社区网格划分图</h2></div>
		</div> -->
		<div id="main" style="width:1280px;height:960px;"><img src="<%=request.getContextPath()%>/img/img3.png" border="0" usemap="#Map3" class="pic">
          <map name="Map3">
            <a href="wgh/load.do?xh=7&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="poly" coords="797,289,794,306,856,314,839,327,834,330,826,403,849,430,825,434,822,477,755,457,716,429,698,285,711,280,796,289">
            </a>
            <a href="wgh/load.do?xh=6&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="868,318,1006,482" >
            </a>
            <a href="wgh/load.do?xh=5&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="1082,142,1258,325">
			</a>
			<a href="wgh/load.do?xh=2&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
				<area shape="rect" coords="330,132,666,194">
          	</a>
          	<a href="wgh/load.do?xh=3&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="poly" coords="626,365,625,379,634,380,634,392,619,389,619,410,585,412,561,417,565,447,692,454,684,365,625,363">
           	</a>
           	<a href="wgh/load.do?xh=1&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="poly" coords="3,229,-8,310,281,363,256,402,322,229,6,229">
           	</a>
           	<a href="wgh/load.do?xh=4&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="poly" coords="731,141,705,208,1033,274,1052,229,1069,93,1019,94,972,146,887,133,730,141">
            </a>
            <a href="wgh/load.do?xh=5&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="poly" coords="1391,107,1369,209,1397,243,1642,279,1645,163,1543,149,1545,123,1391,108">
            </a>
            <a href="wgh/load.do?xh=3&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="414,392,499,446">
            </a>
            <a href="wgh/load.do?xh=8&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="367,272,591,391">
            </a>
             <a href="wgh/load.do?xh=10&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
           	 	<area shape="poly" coords="756,567,721,580,687,688,793,694,793,677,745,672,748,631,787,629,786,614,734,612,739,598,776,592,758,567">
            </a>
             <a href="wgh/load.do?xh=10&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="759,528,1018,550">
             </a>
            <a href="wgh/load.do?xh=13&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="884,671,962,747">
             </a>
            <a href="wgh/load.do?xh=11&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="806,555,996,637" >
            </a>
            <a href="wgh/load.do?xh=12&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="800,673,878,749" >
            </a>
            <a href="wgh/load.do?xh=14&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="966,647,1036,779" >
            </a>
             <a href="wgh/load.do?xh=14&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">	
            	<area shape="poly" coords="694,722,790,727,801,790,861,795,829,767,887,747,899,832,843,833,878,808,732,810,731,797,782,792,785,784,732,779,696,721" >
            </a>
             <a href="wgh/load.do?xh=8&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">		
            	<area shape="rect" coords="498,512,567,758">
            </a>
            <a href="wgh/load.do?xh=9&sssq=城西社区&rel=${param.rel}_wgh" rel="${param.rel}_wg" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="980" height="500" title="网格人员">
            	<area shape="rect" coords="590,520,665,795">
         	</a>
          </map>
		</div>
	</body>
</html>
