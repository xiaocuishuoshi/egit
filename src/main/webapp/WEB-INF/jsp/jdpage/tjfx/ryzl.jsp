<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <script type="text/javascript" src="<%=path%>/js/echarts-all.js"></script>
<title>吸毒人员统计分析</title>

     <div id="container" style="height:100%;width:100%;float: left;"> </div>
    
    <div style="position:absolute;margin-top: 0.5%;margin-left: 33%;"> 
        <select id="sj" name="sj" style="width: 70px;"  onchange="window.location.href='<%=path%>/tjfx/ryzl.do?time='+this.value">
				<option value="">全部</option>
			<c:forEach items="${requestScope.date}" var="d">
					<option value="${pageScope.d}">${pageScope.d}年</option>
			</c:forEach>
		</select>
		 <script type="text/javascript">
			document.getElementById("sj").value="${sj}";
		</script>
   </div>
   
   <script type="text/javascript">
	var lx=${lx};
	var sl=${sl};
	
 option = {

    title : {
        text: ' ${desc}吸毒人员统计分析',
         x:'center'
       // subtext: '实时数据'
    },
    tooltip : {
        trigger: 'axis'
    },

    toolbox: {
        show : true,
        feature : {
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
            data : lx
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'吸毒人数',
            type:'bar',
            data:sl,
            stack: 'sum',
            barCategoryGap: '50%',
  		
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            },
            itemStyle: {
                normal: {
                   color: function(params) {
                   var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                      },
                      label: {
                        show: true,
                        position: 'top',
                    }
              }
               }
           }
         
    ]
};
          echarts.init(document.getElementById("container")).setOption(option);
    </script>

