<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="textml; charset=utf-8" />

<title>实时数据参照图</title>
</head>

<body> 

     <div id="container" style="height:400px;width:100%"></div>    
     <script type="text/javascript" src="../js/echarts-all.js"></script>
  <script type="text/javascript">
  
	var objd = ${objd};

	var obje = ${obje};
	

	 option = {
	    title : {
	        text: '电流监控数据',
 			subtext: '实时数据'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['实时电量'],
	    },
	       toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data :objd
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            axisLabel : {
	                formatter: '{value}'
	            }
	        }
	    ],
	    series : [
	        {
	            name:'实时电量',
	            type:'line',
	            data:obje,
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        } , 
	        
	      ]
	   };
        
			echarts.init(document.getElementById("container")).setOption(option, true);


  </script>  
</div>
</body>
</html>
