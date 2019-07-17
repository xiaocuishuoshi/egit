<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<title>实时数据参照图</title>

 <%--
	模块：报能效分析
--%>
     <div id="container" style="height:100%;width:100%"></div>  
     <script type="text/javascript" src="../js/echarts-all.js"></script>
     
  	<script type="text/javascript">
	var objd = ${objd};
	var objs = ${objs};
	var objh = ${objh};
	
	 option = {
	    title : {
	        text: '温湿度传感器数据',
 			subtext: '实时数据'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['温度','湿度'],
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
	            name:'温度',
	            type:'line',
	            data:objh,
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
	        
	        {
	            name:'湿度',
	            type:'line',
	            data:objs,
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
	        },	   	                 	   
	        
	      ]
	   };
        
			echarts.init(document.getElementById("container")).setOption(option, true);
  </script>  

